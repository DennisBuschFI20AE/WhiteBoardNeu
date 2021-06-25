package com.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidTest {

	
	@Test
	void isPasswordValid() {
		assertTrue( Valid.isPasswordValid("OnePiegfh12") );
	}
	

}
