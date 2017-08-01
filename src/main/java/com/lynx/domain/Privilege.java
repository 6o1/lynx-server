package com.lynx.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "userprivilege")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Privilege extends LynxBaseCollection {

	@Id
	private String id;

	@Indexed(unique = true)
	private String name;

	private Plugin provider;

	public static Privilege build(String name, Plugin provider) {
		return builder().name(name).provider(provider).build();
	}

}
