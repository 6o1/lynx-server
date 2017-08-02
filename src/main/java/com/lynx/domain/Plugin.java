package com.lynx.domain;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lynx.domain.enums.PluginType;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "plugin")
@Getter
public class Plugin extends LynxBaseCollection {

	@Id
	private String id;

	@NotNull
	@Indexed(unique = true)
	private String code;

	private String version;

	@NotNull
	private PluginType type;

	private Boolean deleted;

	private Set<String> privileges;

	@Builder
	public Plugin(String id, String code, String version, PluginType type, Boolean deleted, Set<String> privileges,
			Date dateCreated, String createdBy, Date dateUpdated, String updatedBy) {
		super(dateCreated, createdBy, dateUpdated, updatedBy);
		this.id = id;
		this.code = code;
		this.version = version;
		this.type = type;
		this.deleted = deleted;
		this.privileges = privileges;
	}
	
}
