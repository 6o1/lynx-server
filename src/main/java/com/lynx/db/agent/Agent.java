package com.lynx.db.agent;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lynx.db.LynxBaseDocument;

import lombok.Data;

@Data
@Document(collection = "l_agent")
public class Agent extends LynxBaseDocument {

	@Id
	private Long id;

	@Indexed(unique = true)
	private String clientId;

	private Boolean deleted;

	private String ldapUid;

	private String password;

	private String hostname;

}
