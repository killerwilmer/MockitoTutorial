package com.killerwilmer.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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

// 1.
@RunWith(PowerMockRunner.class)
// 2. 
@PrepareForTest(UtilityClass.class)
public class mockingStaticMethodTest {
	
	// 1. Specific Runner
	// 2. Initialize UtilityClass.class
	// 3. Mock
	
	@Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {

		List<Integer> stats = Arrays.asList(1, 2, 3);

		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		// 3.
		PowerMockito.mockStatic(UtilityClass.class);
		
		when(UtilityClass.staticMethod(6)).thenReturn(150);

		int result = systemUnderTest.methodCallingAStaticMethod();
		
		assertEquals(150, result);
		
		// Verify if static method is called
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(6);

	}

}
