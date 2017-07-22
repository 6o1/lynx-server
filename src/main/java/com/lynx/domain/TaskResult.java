package com.lynx.domain;

import org.springframework.data.annotation.Id;

import com.lynx.domain.enums.ContentType;
import com.lynx.domain.enums.TaskResultCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TaskResult extends LynxBaseCollection {

	@Id
	private String id;

	private String agentId;

	private String taskId;

	private TaskResultCode code;

	private byte[] data;

	private ContentType contentType;

}
