package com.lynx.db.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

public class AgentRepositoryImpl implements AgentRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public int updateAgent(String clientId, boolean deleted) {
		Query query = new Query(Criteria.where("clientId").is(clientId));
		Update update = new Update();
		update.set("deleted", deleted);

		WriteResult result = mongoTemplate.updateFirst(query, update, Agent.class);

		if (result != null)
			return result.getN();
		else
			return 0;

	}

}
