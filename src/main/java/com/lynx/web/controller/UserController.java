package com.lynx.web.controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lynx.domain.User;
import com.lynx.domain.enums.Role;
import com.lynx.domain.validator.UserFormValidator;
import com.lynx.form.UserForm;
import com.lynx.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	private final UserService userService;
	private final UserFormValidator formValidator;
	private final BCryptPasswordEncoder encoder;

	@Autowired
	public UserController(UserService userService, UserFormValidator formValidator, BCryptPasswordEncoder encoder) {
		this.userService = userService;
		this.formValidator = formValidator;
		this.encoder = encoder;
	}

	@InitBinder("form")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(formValidator);
	}

	// @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
	@RequestMapping("/user/{id}")
	public ModelAndView getUserPage(@PathVariable String id) {
		// TODO get privileges
		log.debug("Getting user page for user={}", id);
		return new ModelAndView("user/edit", "user", userService.getUserById(id)
				.orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
	}

	// @PreAuthorize("hasPrivilege('READ_asdas')")
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage() {
		// TODO get privileges
		log.debug("Getting user create form");
		return new ModelAndView("user/create", "form", new UserForm());
	}

	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String handleUserCreateForm(@Valid @ModelAttribute("form") UserForm form, BindingResult bindingResult) {
		log.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
		if (bindingResult.hasErrors()) {
			// failed validation
			return "user/create";
		}
		try {
			userService.create(convertToEntity(form));
		} catch (DataIntegrityViolationException e) {
			log.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
			bindingResult.reject("email.exists", "Email already exists");
			return "user/create";
		}
		// everything fine redirect to list
		return "redirect:/user/list";
	}

	@RequestMapping("/user/list")
	public ModelAndView getUsersPage() {
		log.debug("Getting users page");
		return new ModelAndView("user/list", "users", userService.getAllUsers());
	}

	private User convertToEntity(UserForm form) {
		return User.builder().email(form.getEmail()).firstName(form.getFirstName()).lastName(form.getLastName())
				.phone(form.getPhone()).title(form.getTitle()).passwordHash(encoder.encode(form.getPassword()))
				.deleted(false).role(Role.USER).privileges(form.getPrivileges()).build();
	}

}
