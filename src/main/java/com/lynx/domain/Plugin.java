package com.lynx.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.lynx.domain.enums.PluginType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
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

}
