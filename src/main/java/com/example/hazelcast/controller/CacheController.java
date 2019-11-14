package com.example.hazelcast.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hazelcast.config.ModelMap;
import com.example.hazelcast.service.CacheService;

@RestController
@RequestMapping("/")
public class CacheController {

	@Autowired
	private CacheService cacheService;

	@PutMapping(value = "/write-data")
	public String writeData(@RequestBody ModelMap modelMap) {
		cacheService.put(modelMap.getKey(), modelMap.getValue());
		return "Data stored";
	}

	@GetMapping(value = "/read-data")
	public String readData(@RequestParam String key) {
		return cacheService.get(key);
	}

	@GetMapping(value = "/read-all-data")
	public Map<String, String> readAllData() {
		return cacheService.readAll();
	}

}
