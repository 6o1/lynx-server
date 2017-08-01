package com.lynx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lynx.domain.Agent;

public interface AgentRepository extends MongoRepository<Agent, String> {

}
