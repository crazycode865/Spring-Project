package com.testcases.studentapp.trial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.studentapp.user.User;

 public class UserTest {
	User user  = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		user = new User();
	}

	@AfterEach
	void tearDown() throws Exception {
		user = null;
	}

	@Test
	void testGreet() {
		assertEquals("Have a great Day",user.greet());
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(strings={"Great Day","Have a great Day","Good day"})
	void testGreet(String message) {
		assertEquals(message,user.greet());
	}
	
	@ParameterizedTest
	@ValueSource(ints={2,100,-900,373,100})
	void testGreet(int num) {
	//	assertTrue(num<=user.check());
		assertEquals(num,user.check());
	}

}
