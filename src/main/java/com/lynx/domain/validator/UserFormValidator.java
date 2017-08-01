package com.lynx.domain.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lynx.form.UserForm;
import com.lynx.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserFormValidator implements Validator {

	private final UserService userService;

	@Autowired
	public UserFormValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UserForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		log.debug("Validating {}", target);
		UserForm form = (UserForm) target;
		validatePasswords(errors, form);
		validateEmail(errors, form);
	}

	private void validatePasswords(Errors errors, UserForm form) {
		if (!form.getPassword().equals(form.getPasswordRepeated())) {
			errors.reject("password.no_match", "Passwords do not match");
		}
	}

	private void validateEmail(Errors errors, UserForm form) {
		if (userService.getUserByEmail(form.getEmail()).isPresent()) {
			errors.reject("email.exists", "User with this email already exists");
		}
	}

}
