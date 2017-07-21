package com.lynx.repository;

import java.util.Optional;

import com.lynx.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	
	 Optional<User> findOneByEmail(String email);

}
