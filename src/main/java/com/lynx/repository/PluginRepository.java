package com.lynx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lynx.domain.Plugin;

public interface PluginRepository extends MongoRepository<Plugin, String> {

}
