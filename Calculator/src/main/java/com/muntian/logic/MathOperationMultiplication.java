package com.muntian.logic;

public class MathOperationMultiplication implements MathOperation {

	@Override
	public double getResult(double firstNumber, double secondNumber) {
		return firstNumber*secondNumber;
	}

}
