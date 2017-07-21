package com.lynx.domain;

import org.springframework.security.core.authority.AuthorityUtils;

import lombok.Getter;

@Getter
public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 4424162102326567450L;

	private User user;

	public CurrentUser(User user) {
		super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}

	public String getId() {
		return user.getId();
	}

	public Role getRole() {
		return user.getRole();
	}

	@Override
	public String toString() {
		return "CurrentUser{" + "user=" + user + "} " + super.toString();
	}

}
