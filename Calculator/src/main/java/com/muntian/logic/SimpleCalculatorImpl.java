package com.muntian.logic;

import java.util.HashMap;
import java.util.Map;

public class SimpleCalculatorImpl implements Calculator {

	private Map<String, MathOperation> mathOperationsMap;

	public SimpleCalculatorImpl() {
		creatsOperationsMap();
	}

	/**
	 * 
	 * @param firstNumber - first number which takes part in operation
	 * @param secondNumber - second number which takes part in operation
	 * @param mathOperator - a sign that denotes a mathematical action with numbers 
	 * @return result of operation
	 */
	public double makeCalculation(double firstNumber, double secondNumber, String mathOperator ) {

		MathOperation mathOperation = null;

		if (mathOperationsMap.containsKey(mathOperator)) {
			mathOperation = mathOperationsMap.get(mathOperator);
		} else {
			System.out.println("Invalid sign");
		}
	
		return mathOperation.calculateResult(firstNumber, secondNumber);
	}

	/**
	 * 
	 */
	private void creatsOperationsMap() {
		mathOperationsMap = new HashMap<>();
		mathOperationsMap.put("+", new MathOperationAdd());
		mathOperationsMap.put("-", new MathOperationSubtraction());
		mathOperationsMap.put("/", new MathOperationDevision());
		mathOperationsMap.put("*", new MathOperationMultiplication());
	}
}
