package com.lynx.form;

import com.lynx.domain.enums.PluginType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PluginForm extends LynxBaseForm {

	private static final long serialVersionUID = 8809390614600106209L;

	private String id;

	private String code;

	private String version;

	private PluginType type;

	private Boolean active;

	private Boolean deleted;

}
