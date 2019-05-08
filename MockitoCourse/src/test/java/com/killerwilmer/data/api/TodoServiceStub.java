package com.killerwilmer.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
	
	// Disadvantages use Stub
	// Dynamic Condition
	// Service Definition

	public List<String> retrieveTodos(String user) {
		
		return Arrays.asList("Learn Spring MVC", "Learn Spring Boot", 
				"Learn to Dance");
		
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}
	
}
