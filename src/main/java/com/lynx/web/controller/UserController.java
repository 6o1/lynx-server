package com.lynx.web.controller;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lynx.domain.Plugin;
import com.lynx.domain.Privilege;
import com.lynx.domain.Role;
import com.lynx.domain.User;
import com.lynx.domain.validator.UserFormValidator;
import com.lynx.form.PluginForm;
import com.lynx.form.PrivilegeForm;
import com.lynx.form.RoleForm;
import com.lynx.form.UserForm;
import com.lynx.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	private final UserService userService;
	private final UserFormValidator formValidator;

	@Autowired
	public UserController(UserService userService, UserFormValidator formValidator) {
		this.userService = userService;
		this.formValidator = formValidator;
	}

	@InitBinder("form")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(formValidator);
	}

	@PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
	@RequestMapping("/user/{id}")
	public ModelAndView getUserPage(@PathVariable String id) {
		log.debug("Getting user page for user={}", id);
		return new ModelAndView("user", "user", userService.getUserById(id)
				.orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
	}

	@PreAuthorize("hasPrivilege('READ_asdas')")
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage() {
		log.debug("Getting user create form");
		return new ModelAndView("user_create", "form", new UserForm());
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String handleUserCreateForm(@Valid @ModelAttribute("form") UserForm form, BindingResult bindingResult) {
		log.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
		if (bindingResult.hasErrors()) {
			// failed validation
			return "user_create";
		}
		try {
			userService.create(convertToEntity(form));
		} catch (DataIntegrityViolationException e) {
			// probably email already exists - very rare case when multiple
			// admins are adding same user
			// at the same time and form validation has passed for more than one
			// of them.
			log.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
			bindingResult.reject("email.exists", "Email already exists");
			return "user_create";
		}
		// everything fine redirect to list
		return "redirect:/users";
	}
	
    @RequestMapping("/users")
    public ModelAndView getUsersPage() {
        log.debug("Getting users page");
        return new ModelAndView("users", "users", userService.getAllUsers());
    }

	private User convertToEntity(UserForm userForm) {
		Set<Role> roles = new HashSet<Role>();
		for (RoleForm role : userForm.getRoles()) {
			Set<Privilege> privileges = new HashSet<Privilege>();
			for (PrivilegeForm privilege : role.getPrivileges()) {
				PluginForm plugin = privilege.getProvider();
				privileges.add(Privilege.builder().id(privilege.getId()).name(privilege.getName())
						.provider(Plugin.builder().id(plugin.getId()).code(plugin.getCode())
								.version(plugin.getVersion()).type(plugin.getType()).active(plugin.getActive())
								.deleted(plugin.getDeleted()).build())
						.build());
			}
			roles.add(Role.builder().id(role.getId()).name(role.getName()).privileges(privileges).build());
		}
		return User.builder().id(userForm.getId()).email(userForm.getEmail()).firstName(userForm.getFirstName())
				.lastName(userForm.getLastName()).phone(userForm.getPhone()).title(userForm.getTitle())
				.passwordHash(userForm.getPassword()).enabled(userForm.getEnabled()).roles(roles).build();
	}

}
