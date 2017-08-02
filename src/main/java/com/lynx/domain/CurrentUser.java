package com.lynx.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.lynx.domain.enums.Role;

import lombok.Getter;

@Getter
public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 2677248428935965584L;

	private User user;

	public CurrentUser(User user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getEmail(), user.getPasswordHash(), true, true, true, true, authorities);
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
		return "CurrentUser [user=" + user + "] " + super.toString();
	}

}
