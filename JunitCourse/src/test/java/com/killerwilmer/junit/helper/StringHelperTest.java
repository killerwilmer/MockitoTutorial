package com.killerwilmer.junit.helper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {

	// AACD=>CD - ACD=>CD - CDEF=>CDEF - CDAA=>CDAA
	StringHelper stringHelper;

	@Before
	public void setup() {
		stringHelper = new StringHelper();
	}

	@Test
	public void testTruncateAInFirst2PositionsAinFirst2Positions() {
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));
		// expected, actual
	}

	@Test
	public void testTruncateAInFirst2PositionsAinFirstPosition() {
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));
	}

	@Test
	public void testTruncateAInFirst2PositionsAisNotPresent() {
		assertEquals("CDEF", stringHelper.truncateAInFirst2Positions("CDEF"));
	}

	@Test
	public void testTruncateAInFirst2PositionsAinEnd2Position() {
		assertEquals("CDAA", stringHelper.truncateAInFirst2Positions("CDAA"));
	}

	// ABCD => false, ABAB => true, AB => true, A => false
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_Positive2Characters() {
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AB"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_Negative1Character() {
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("A"));
	}

}
