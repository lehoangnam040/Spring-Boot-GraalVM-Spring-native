package com.ceti.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@TypeHint(types = SQLServerResource.class, typeNames = "com.microsoft.sqlserver.jdbc.SQLServerResource")
@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
