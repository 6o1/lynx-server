package com.lynx.form;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PrivilegeForm extends LynxBaseForm {

	private static final long serialVersionUID = -7997895361654416551L;

	private String id;

	private String name;
	
	private PluginForm provider;

}
