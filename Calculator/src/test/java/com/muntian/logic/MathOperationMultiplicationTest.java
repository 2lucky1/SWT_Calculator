package com.muntian.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathOperationMultiplicationTest {

	@Test
	public void testCalculateResult() {
		double firstNumber = 2;
		double secondNumber = 1;
		double expResult = 2;
		MathOperationMultiplication instance = new MathOperationMultiplication();
		double result = instance.calculateResult(firstNumber, secondNumber);
		assertEquals(expResult, result, 0.0001);
	}
}
