package com.muntian.logic;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCalculator {

	protected Map<String, MathOperation> mathOperationsMap;

	/**
	 * 
	 * @param firstNumber
	 *            - first number which takes part in operation
	 * @param secondNumber
	 *            - second number which takes part in operation
	 * @param mathOperator
	 *            - a sign that denotes a mathematical action with numbers
	 * @return result of operation
	 */
	public abstract double makeCalculation(double firstNumber, double secondNumber, String sign);

	public abstract void creatOperationsMap();

	protected Map<String, MathOperation> creatMainOperationsMap() {
		mathOperationsMap = new HashMap<>();
		mathOperationsMap.put(MathOperation.PLUS, new MathOperationAdd());
		mathOperationsMap.put(MathOperation.MINUS, new MathOperationSubtraction());
		mathOperationsMap.put(MathOperation.DIVISION, new MathOperationDevision());
		mathOperationsMap.put(MathOperation.MULTIPLY, new MathOperationMultiplication());
		return mathOperationsMap;
	}

}