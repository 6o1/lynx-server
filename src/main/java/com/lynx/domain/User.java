package com.lynx.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lynx.domain.enums.Role;

import lombok.Builder;
import lombok.Data;

@Document(collection = "user")
@Data
@Builder
public class User {

	@Id
	private String id;

	private String email;

	private String passwordHash;

	private Role role;

	public static User build(String email, String plainPassword, Role role) {
		return builder().email(email).passwordHash(new BCryptPasswordEncoder().encode(plainPassword)).role(role)
				.build();
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", email='" + email.replaceFirst("@.*", "@***") + ", passwordHash='"
				+ passwordHash.substring(0, 10) + ", role=" + role + '}';
	}
}
