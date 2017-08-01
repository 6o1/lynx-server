package com.lynx.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "userrole")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Role extends LynxBaseCollection {

	@Id
	private String id;

	@Indexed(unique = true)
	private String name;

	private Set<Privilege> privileges;

}
