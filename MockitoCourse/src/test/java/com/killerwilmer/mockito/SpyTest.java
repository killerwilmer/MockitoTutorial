package com.killerwilmer.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void testMockArrayList() {
		
		List arrayListMock = mock(ArrayList.class);
		assertEquals(0, arrayListMock.size());
		
		stub(arrayListMock.size()).toReturn(5);
		arrayListMock.add("New"); // this add does change the arrayListMock
		assertEquals(5, arrayListMock.size());
		
	}
	
	@Test
	public void testSpyArrayList() {
		
		List arrayListSpy = spy(ArrayList.class);
		assertEquals(0, arrayListSpy.size());
		
		arrayListSpy.add("new");// in Spy the change is real (add)
		assertEquals(1, arrayListSpy.size());
		
		arrayListSpy.remove("new");// in Spy the change is real (remove)
		assertEquals(0, arrayListSpy.size());
		
	}
	
	@Test
	public void testSpyArrayListReturn() {
		
		List arrayListSpy = spy(ArrayList.class);
		stub(arrayListSpy.size()).toReturn(5);
		assertEquals(5, arrayListSpy.size());
		
	}
	
	@Test
	public void testSpyArrayListVerify() {
		
		List arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Dummy");
		verify(arrayListSpy).add("Dummy");
		verify(arrayListSpy, never()).clear();
		
	}

}
