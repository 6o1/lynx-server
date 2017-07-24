package com.lynx.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lynx.domain.enums.ContentType;
import com.lynx.domain.enums.TaskResultCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection = "taskresult")
@Data
@EqualsAndHashCode(callSuper = false)
public class TaskResult extends LynxBaseCollection {

	@Id
	private String id;

	private String agentId;

	private String taskId;

	private TaskResultCode code;

	private Map<String, Object> data;

	private ContentType contentType;

}
