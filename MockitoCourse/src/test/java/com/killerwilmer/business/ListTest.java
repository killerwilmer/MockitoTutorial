package com.killerwilmer.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyInt;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void testLetsMockListSizeMethod() {
		List listMock = mock(List.class);
		
		when(listMock.size()).thenReturn(2);
		
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void testLetsMockListSize_ReturnMultipleValues() {
		List listMock = mock(List.class);
		
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void testLetsMockListGet() {
		List listMock = mock(List.class);
		
		when(listMock.get(0)).thenReturn("Hello");
		
		assertEquals("Hello", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}
	
	@Test
	public void testLetsMockListGetAnyIntMatcher() {
		List listMock = mock(List.class);
		
		// Argument Matcher
		when(listMock.get(anyInt())).thenReturn("Hello");
		
		assertEquals("Hello", listMock.get(100));
		assertEquals("Hello", listMock.get(777));
	}
	
	@Test(expected = RuntimeException.class)
	public void testLetsMockList_throwAnException() {
		List listMock = mock(List.class);
		
		// Argument Matcher
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
		
		listMock.get(0);
	}

}
