package com.lynx.form;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoleForm extends LynxBaseForm {

	private static final long serialVersionUID = -6976954415307999547L;

	private String id;

	private String name;

	private Set<PrivilegeForm> privileges;

}
