package com.lynx.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lynx.domain.enums.SessionEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "usersession")
@Data
@EqualsAndHashCode(callSuper = false)
public class AgentUserSession extends LynxBaseCollection {

	@Id
	private String id;

	private String agentId;

	private String username;

	private SessionEvent event;

}
