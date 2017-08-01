package com.lynx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lynx.domain.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

}
