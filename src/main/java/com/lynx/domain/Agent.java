package com.lynx.domain;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "agent")
@Getter
public class Agent extends LynxBaseCollection {

	@Id
	private String id;

	@NotNull
	@Indexed(unique = true)
	private String uid;

	@NotNull
	private Client client;

	@NotNull
	private String hostname;

	private String passwordHash;

	@NotNull
	private String[] ipAddresses;

	@NotNull
	private String[] macAddresses;
	
	private Map<String, Object> properties;

	private Boolean deleted;
	
	@Builder
	public Agent(String id, String uid, Client client, String hostname, String passwordHash, String[] ipAddresses,
			String[] macAddresses, Map<String, Object> properties, Boolean deleted, Date dateCreated, String createdBy, Date dateUpdated,
			String updatedBy) {
		super(dateCreated, createdBy, dateUpdated, updatedBy);
		this.id = id;
		this.uid = uid;
		this.client = client;
		this.hostname = hostname;
		this.passwordHash = passwordHash;
		this.ipAddresses = ipAddresses;
		this.macAddresses = macAddresses;
		this.properties = properties;
		this.deleted = deleted;
	}

}
