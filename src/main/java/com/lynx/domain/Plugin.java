package com.lynx.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lynx.domain.enums.PluginType;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "plugin")
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Plugin extends LynxBaseCollection {

	@Id
	private String id;

	@Indexed(unique = true)
	private String code;

	private String version;

	private PluginType type;

	private Boolean active;

	private Boolean deleted;

	public static Plugin build(String code, String version, PluginType type) {
		return builder().code(code).version(version).type(type).active(true).deleted(false).build();
	}

}
