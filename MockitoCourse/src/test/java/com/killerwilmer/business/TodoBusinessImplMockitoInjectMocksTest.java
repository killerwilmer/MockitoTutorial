package com.killerwilmer.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.killerwilmer.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn to Dance");

		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());

	}

	@Test
	public void testRetrieveTodosRelatedToSpring_withEmptyList() {

		List<String> todos = Arrays.asList();

		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(0, filteredTodos.size());

	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {
		
		// Given
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		// Then
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));

	}

}
