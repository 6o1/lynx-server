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
import com.lynx.domain.User;
import com.lynx.domain.enums.Role;

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
		return new CurrentUser(user, getAuthorities(user.getRole(), user.getPrivileges()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Role role, Set<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.toString()));
		for (String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(PRIVILEGE_PREFIX + privilege));
		}
		return authorities;
	}

}
