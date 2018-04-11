package com.muntian.logic;

public class MathOperationAdd implements MathOperation {

	@Override
	public double calculateResult(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

}
