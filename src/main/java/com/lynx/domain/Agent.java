package com.lynx.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Agent extends LynxBaseCollection {

	@Id
	private String id;

	@Indexed(unique = true)
	private String uid;
	
	private String hostname;

	private String passwordHash;

	private String[] ipAddresses;

	private String[] macAddresses;
	
	private Boolean deleted;

}
