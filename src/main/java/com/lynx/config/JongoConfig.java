package com.lynx.config;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration Auto
 * configuration} for {@code Jongo} support.
 * 
 * @author Emre Kağan Akkaya
 *
 */
@Configuration
@ConditionalOnClass({ Jongo.class })
public class JongoConfig {

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

	/**
	 * Create a instance of the {@code Jongo} class.
	 *
	 * @return The instance of {@code Jongo} class.
	 */
	@Bean
	public Jongo jongo() {
		final DB database = mongo.getDB(properties.getDatabase());
		return new Jongo(database);
	}

}
