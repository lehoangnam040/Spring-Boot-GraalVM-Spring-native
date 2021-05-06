package com.ceti.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/")
	public String foo() {
		return "Hello from Spring MVC and Tomcat";
	}
}
