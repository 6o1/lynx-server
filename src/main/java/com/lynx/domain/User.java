package com.lynx.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "user")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class User extends LynxBaseCollection {

	@Id
	private String id;

	@Indexed(unique = true)
	private String email;

	private String firstName;

	private String lastName;

	private String phone;

	private String title;

	private String passwordHash;

	private Boolean enabled;

	private Set<Role> roles;

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", email='" + email.replaceFirst("@.*", "@***") + ", passwordHash='"
				+ passwordHash.substring(0, 10) + ", role=" + roles.toString() + '}';
	}

}
