package com.lynx.domain;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lynx.domain.enums.TaskResultCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "task")
@Data
@EqualsAndHashCode(callSuper = false)
public class Task extends LynxBaseCollection {

	@Id
	private String id;

	private String pluginId;

	private String label;

	private String code;

	private String cronExpression;

	private Date activationDate;

	private Date expirationDate;

	private Long timeToLive;

	private TaskResultCode status;

	private Map<String, Object> parameters;

}
