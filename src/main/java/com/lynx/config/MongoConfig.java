package com.lynx.config;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * 
 * @author Emre Kağan Akkaya
 *
 */
@Configuration
public class MongoConfig {

	/**
	 * Mongo
	 */
	@Autowired
	protected Mongo mongo;

	/**
	 * Jongo properties.
	 */
	@Autowired
	protected MongoProperties properties;

	@Bean
	public ValidatingMongoEventListener validatingMongoEventListener() {
		return new ValidatingMongoEventListener(validator());
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

	/**
	 * Create a instance of the {@code Jongo} class.
	 *
	 * @return The instance of {@code Jongo} class.
	 */
	// @Bean
	// public Jongo jongo() {
	// final DB database = mongo.getDB(properties.getDatabase());
	// return new Jongo(database);
	// }

}
