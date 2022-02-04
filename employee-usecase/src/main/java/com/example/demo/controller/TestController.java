package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${test.name}")
	private String test;

	@GetMapping("/test/")
	public String getTestProperty() {
		return test;
	}
}
