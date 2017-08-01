package com.lynx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lynx.domain.Privilege;

public interface PrivilegeRepository extends MongoRepository<Privilege, String> {

}
