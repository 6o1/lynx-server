package com.lynx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lynx.domain.AgentUserSession;

public interface AgentUserSessionRepository extends MongoRepository<AgentUserSession, String> {

}
