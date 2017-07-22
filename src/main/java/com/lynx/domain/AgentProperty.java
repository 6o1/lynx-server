package com.lynx.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AgentProperty extends LynxBaseCollection {
	
	@Id
	private String id;
	
	private String agentId;
	
	private String propertyName;
	
	private String propertyValue;

}
