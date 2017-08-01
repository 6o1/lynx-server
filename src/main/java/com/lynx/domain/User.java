package com.lynx.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lynx.domain.enums.Role;

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

	private Role role;

	private Set<Privilege> privileges;

	public static User build(String email, String firstName, String lastName, String phone, String title,
			String plainPassword, Role role, Set<Privilege> privileges) {
		return builder().email(email).firstName(firstName).lastName(lastName).phone(phone).title(title)
				.passwordHash(new BCryptPasswordEncoder().encode(plainPassword)).role(role).privileges(privileges)
				.build();
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", email='" + email.replaceFirst("@.*", "@***") + ", passwordHash='"
				+ passwordHash.substring(0, 10) + ", role=" + role + '}';
	}

}
