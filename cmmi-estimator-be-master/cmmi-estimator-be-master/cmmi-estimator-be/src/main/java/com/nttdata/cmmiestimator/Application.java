package com.nttdata.cmmiestimator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = { "com.nttdata" })
public class Application {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(Application.class);

	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);

	}

}
