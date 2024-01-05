package com.todo.springboottodobackend;

import com.todo.springboottodobackend.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringBootTodoBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTodoBackendApplication.class, args);
	}

}
