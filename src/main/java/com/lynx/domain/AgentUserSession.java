package com.lynx.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lynx.domain.enums.SessionEvent;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "usersession")
@Getter
public class AgentUserSession extends LynxBaseCollection {

	@Id
	private String id;

	@NotNull
	private String refAgentId;

	@NotNull
	@Indexed
	private String username;

	@NotNull
	private SessionEvent event;

	@Builder
	public AgentUserSession(String id, String refAgentId, String username, SessionEvent event, Date dateCreated,
			String createdBy, Date dateUpdated, String updatedBy) {
		super(dateCreated, createdBy, dateUpdated, updatedBy);
		this.id = id;
		this.refAgentId = refAgentId;
		this.username = username;
		this.event = event;
	}

}
