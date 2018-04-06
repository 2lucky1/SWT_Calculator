package com.muntian.logic;

import java.util.HashMap;
import java.util.Map;

public class SimpleCalculatorImpl implements Calculator {

	private Map<String, MathOperation> mathOperationsMap;

	public SimpleCalculatorImpl() {
		creatsOperationsMap();
	}

	public double makeCalculation(double firstNumber, double secondNumber, String sign) {

		MathOperation mathOperation = null;

		if (mathOperationsMap.containsKey(sign)) {
			mathOperation = mathOperationsMap.get(sign);
		} else {
			System.out.println("Invalid sign");
		}
	
		return mathOperation.getResult(firstNumber, secondNumber);
	}

	@Override
	public double add(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

	@Override
	public double sub(double firstNumber, double secondNumber) {
		return firstNumber - secondNumber;
	}

	@Override
	public double dev(double firstNumber, double secondNumber) {
		return firstNumber / secondNumber;
	}

	@Override
	public double mult(double firstNumber, double secondNumber) {
		return firstNumber * secondNumber;
	}

	private void creatsOperationsMap() {
		mathOperationsMap = new HashMap<>();
		mathOperationsMap.put("+", new MathOperationAdd());
		mathOperationsMap.put("-", new MathOperationSubtraction());
		mathOperationsMap.put("/", new MathOperationDevision());
		mathOperationsMap.put("*", new MathOperationMultiplication());
	}
}
