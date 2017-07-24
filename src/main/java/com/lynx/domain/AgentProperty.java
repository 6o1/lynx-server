package com.lynx.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "agentproperty")
@Data
@EqualsAndHashCode(callSuper = false)
public class AgentProperty extends LynxBaseCollection {

	@Id
	private String id;

	private String agentId;

	private String propertyName;

	private String propertyValue;

}
