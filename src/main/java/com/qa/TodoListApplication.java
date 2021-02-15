package com.qa;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		ApplicationContext beanBag = SpringApplication.run(TodoListApplication.class, args);
	}

}
 