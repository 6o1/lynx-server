package com.lynx.form;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

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
	
	private Boolean enabled;

	@NotNull
	private Set<RoleForm> roles;

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", email=" + email.replaceFirst("@.*", "@***") + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", title=" + title + ", roles=" + roles + "]";
	}

}
