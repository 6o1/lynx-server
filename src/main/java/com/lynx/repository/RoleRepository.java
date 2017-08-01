package com.lynx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lynx.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

}
