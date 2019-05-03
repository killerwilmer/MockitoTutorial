package com.killerwilmer.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	// Array.sort
	
	@Test
	public void testArraySort_RandomArray() {
		int[] actualNumbers = {12, 3, 4, 1};
		int[] expectedNumbers = {1, 3, 4, 12};
		
		Arrays.sort(actualNumbers);
		
		assertArrayEquals(expectedNumbers, actualNumbers);
	}
	
	@Test(expected = NullPointerException.class)
	public void testArraySort_NullArray() {
		int[] numbers = null;
		Arrays.sort(numbers);
	}

}
