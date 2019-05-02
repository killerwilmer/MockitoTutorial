package com.killerwilmer.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	// AACD=>CD - ACD=>CD - CDEF=>CDEF - CDAA=>CDAA
	StringHelper stringHelper = new StringHelper();

	@Test
	public void testTruncateAInFirst2PositionsAinFirst2Positions() {
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));
		// expected, actual
	}

	@Test
	public void testTruncateAInFirst2PositionsAinFirstPosition() {
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));
	}

}
