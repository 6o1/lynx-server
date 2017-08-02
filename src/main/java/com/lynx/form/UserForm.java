package com.lynx.form;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.lynx.domain.enums.Role;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserForm extends LynxBaseForm {

	private static final long serialVersionUID = 1396523794468203640L;

	private String id;

	@NotEmpty
	private String email = "";

	@NotEmpty
	private String password = "";

	@NotEmpty
	private String passwordRepeated = "";

	@NotEmpty
	private String firstName = "";

	@NotEmpty
	private String lastName = "";

	private String phone;

	private String title;

	@NotNull
	private Boolean enabled;

	@NotNull
	private Role role = Role.USER;

	@NotNull
	private Set<String> privileges;

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", email=" + email.replaceFirst("@.*", "@***") + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", title=" + title + ", role=" + role
				+ ", privileges=" + privileges + "]";
	}

}
