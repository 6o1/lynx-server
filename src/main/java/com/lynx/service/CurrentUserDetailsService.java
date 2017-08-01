package com.lynx.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lynx.domain.CurrentUser;
import com.lynx.domain.Privilege;
import com.lynx.domain.Role;
import com.lynx.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CurrentUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserService userService;

	private static final String PRIVILEGE_PREFIX = "PRIV_";
	private static final String ROLE_PREFIX = "ROLE_";

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
		User user = userService.getUserByEmail(email).orElseThrow(
				() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
		return new CurrentUser(user, getAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<Privilege> privileges = new ArrayList<>();
		for (Role role : roles) {
			// Add role authority:
			authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getName()));
			privileges.addAll(role.getPrivileges());
		}
		for (Privilege privilege : privileges) {
			// Add privilege authority:
			authorities.add(new SimpleGrantedAuthority(PRIVILEGE_PREFIX + privilege.getName()));
		}
		return authorities;
	}

}
