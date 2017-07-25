package com.lynx.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@EnableHazelcastHttpSession
@ConditionalOnProperty(value = "spring.session.store-type", havingValue = "hazelcast", matchIfMissing = false)
public class HazelcastHttpSessionConfig {

	@Bean
	public HazelcastInstance embeddedHazelcast() {
		Config hazelcastConfig = new Config();
		return Hazelcast.newHazelcastInstance(hazelcastConfig);
	}

}
