package com.lynx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lynx.domain.AgentProperty;

public interface AgentPropertyRepository extends MongoRepository<AgentProperty, String> {

}
