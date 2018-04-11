package com.muntian.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

//import static org.junit.Assert.*;

import org.junit.Test;

public class MathOperationAddTest {

	@Test
	public void testCalculateResult() {
		double firstNumber = 2;
		double secondNumber = 1;
 		double expResult = 3;
		MathOperationAdd instance = new MathOperationAdd();
		double result = instance.calculateResult(firstNumber, secondNumber);
		assertEquals(expResult, result, 0.0001);
	}

}
