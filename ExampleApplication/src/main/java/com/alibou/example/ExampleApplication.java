package com.alibou.example;

import com.alibou.example.service.MyFirstService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(ExampleApplication.class, args);

		MyFirstService service = context.getBean(MyFirstService.class);
		System.out.println(service.tellAStory());
	}
}
