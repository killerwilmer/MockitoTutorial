package com.killerwilmer.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	@Test
	public void test() {
		// AACD=>CD - ACD=>CD - CDEF=>CDEF - CDAA=>CDAA
		StringHelper stringHelper = new StringHelper();
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));
		assertEquals("CD", stringHelper.truncateAInFirst2Positions("ACD"));
		// expected, actual
	}

}
