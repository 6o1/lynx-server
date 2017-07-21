package com.lynx.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserCreateForm {

	@NotEmpty
	private String email = "";

	@NotEmpty
	private String password = "";

	@NotEmpty
	private String passwordRepeated = "";

	@NotNull
	private Role role = Role.USER;

	@Override
	public String toString() {
		return "UserCreateForm{" + "email='" + email.replaceFirst("@.+", "@***") + '\'' + ", password=***" + '\''
				+ ", passwordRepeated=***" + '\'' + ", role=" + role + '}';
	}

}
