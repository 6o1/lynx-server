package com.lynx.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lynx.domain.User;
import com.lynx.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Optional<User> getUserById(String id) {
		log.debug("Getting user={}", id);
		return Optional.ofNullable(userRepository.findOne(id));
	}

	public Optional<User> getUserByEmail(String email) {
		log.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
		return userRepository.findOneByEmail(email);
	}

	public Collection<User> getAllUsers() {
		log.debug("Getting all users");
		return userRepository.findAll(new Sort("email"));
	}

	public User create(User user) {
		return userRepository.save(user);
	}

}
