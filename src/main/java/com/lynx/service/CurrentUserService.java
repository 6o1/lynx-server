package com.lynx.service;

import org.springframework.stereotype.Service;

import com.lynx.domain.CurrentUser;
import com.lynx.domain.Role;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CurrentUserService {
	
	public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        log.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}
