package com.killerwilmer.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.killerwilmer.data.api.TodoService;
import com.killerwilmer.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub() {
		
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		
		
	}

}
