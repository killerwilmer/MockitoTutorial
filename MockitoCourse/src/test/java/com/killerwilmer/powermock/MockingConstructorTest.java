package com.killerwilmer.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
// 1.
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructorTest {
	
	// 1. PrepareFortest => SystemUnderTest.class
	// 2. Override the constructor
	
	@Mock
	ArrayList mockList;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Test
	public void testBadNames() throws Exception {

		List<Integer> stats = Arrays.asList(1, 2, 3);
		
		when(mockList.size()).thenReturn(5);
		
		// 2.
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		
		int size = systemUnderTest.methodUsingAnArrayListConstructor();
		
		assertEquals(5, size);
		
	}

}
