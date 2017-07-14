package com.lynx.db.agent;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgentRepository extends MongoRepository<Agent, Long>, AgentRepositoryCustom {

	Agent findFirstByClientId(String clientId);

}
