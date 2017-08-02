package com.lynx.domain;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lynx.domain.enums.Role;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "user")
@Getter
public class User extends LynxBaseCollection {

	@Id
	private String id;

	@NotNull
	@Indexed(unique = true)
	private String email;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	private String phone;

	private String title;

	@NotNull
	private String passwordHash;

	private Boolean deleted;

	@NotNull
	private Role role;

	private Set<String> privileges;

	@Builder
	public User(String id, String email, String firstName, String lastName, String phone, String title,
			String passwordHash, Boolean deleted, Role role, Set<String> privileges, Date dateCreated, String createdBy,
			Date dateUpdated, String updatedBy) {
		super(dateCreated, createdBy, dateUpdated, updatedBy);
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.title = title;
		this.passwordHash = passwordHash;
		this.deleted = deleted;
		this.role = role;
		this.privileges = privileges;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email.replaceFirst("@.*", "@***") + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", title=" + title + ", passwordHash="
				+ passwordHash.substring(0, 10) + ", deleted=" + deleted + ", role=" + role + ", privileges="
				+ privileges + "]";
	}

}
