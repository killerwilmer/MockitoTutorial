package com.killerwilmer.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyInt;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.killerwilmer.data.api.TodoService;
import com.killerwilmer.data.api.TodoServiceStub;

public class TodoBusinessImplMockBDDTest {

	// Given
	// When
	// Then
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		
		// Given
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		// Then
		assertThat(filteredTodos.size(), is(2));

	}
	
	@Test
	public void letsMockListGet_usingBDD() {
		// Given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("Hello");
		
		// When
		String firstElement = listMock.get(0);
		
		// Then
		assertThat(firstElement, is("Hello"));
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {
		
		// Given
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		// Then
		verify(todoServiceMock).deleteTodo("Learn to Dance");
		
		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
		
		verify(todoServiceMock, never()).deleteTodo("Learn Spring Boot");
		
		verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
		
		verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Dance");

	}

}
