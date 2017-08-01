package com.lynx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lynx.domain.TaskResult;

public interface TaskResultRepository extends MongoRepository<TaskResult, String> {

}
