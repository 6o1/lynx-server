package com.lynx.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "agent")
@Data
@EqualsAndHashCode(callSuper = false)
public class Client extends LynxBaseCollection {
	
	@Id
	private String id;
	
	private Boolean up;

}
