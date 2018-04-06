package com.muntian.logic;

public class MathOperationAdd implements MathOperation {

	@Override
	public double getResult(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

}
