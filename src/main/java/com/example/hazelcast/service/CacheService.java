package com.example.hazelcast.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hazelcast.constant.HazelCastConstant;
import com.hazelcast.core.HazelcastInstance;

@Service
public class CacheService {
	@Autowired
	private HazelcastInstance hazelcastInstance;

	public String put(String key, String value) {
		Map<String, String> hazelcastMap = hazelcastInstance.getMap(HazelCastConstant.MAP_NAME);
		return hazelcastMap.put(key, value);
	}

	public String get(String key) {
		Map<String, String> hazelcastMap = hazelcastInstance.getMap(HazelCastConstant.MAP_NAME);
		return hazelcastMap.get(key);
	}

	public Map<String, String> readAll() {
		return hazelcastInstance.getMap(HazelCastConstant.MAP_NAME);
	}
}
