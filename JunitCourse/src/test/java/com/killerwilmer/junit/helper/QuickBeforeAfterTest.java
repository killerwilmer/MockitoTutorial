package com.killerwilmer.junit.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}

	@Before
	public void setup() {
		System.out.println("Before test");
	}
	
	@After
	public void teardown() {
		System.out.println("After test");
	}

	@Test
	public void test1() {
		System.out.println("Test1 executed");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2 executed");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}

}
