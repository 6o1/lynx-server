package com.lynx.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class LynxBaseCollection implements Serializable {

	private static final long serialVersionUID = -954311673920463254L;

	@NotNull
	private Date dateCreated;

	@NotNull
	private String createdBy;

	private Date dateUpdated;

	private String updatedBy;

}
