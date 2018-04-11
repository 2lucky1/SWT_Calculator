package com.muntian.logic;

public class MathOperationMultiplication implements MathOperation {

	@Override
	public double calculateResult(double firstNumber, double secondNumber) {
		return firstNumber*secondNumber;
	}

}
