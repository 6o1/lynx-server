package com.lynx.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class LynxBaseCollection {

	@NotNull
	private Date dateCreated;

	@NotNull
	private String createdBy;

	private Date dateUpdated;

	private String updatedBy;

}
