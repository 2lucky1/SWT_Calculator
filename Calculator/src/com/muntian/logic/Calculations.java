package com.muntian.logic;

import java.util.Map;

import org.eclipse.swt.widgets.Text;

import com.muntian.ui.MainPanel;

public class Calculations implements Observer {

	private double firstNumber;
	private String sign;
	private double secondNumber;
	private boolean isflyModeOn;

	private MathData mathData;
	private SimpleCalculatorImpl calculator = new SimpleCalculatorImpl();

	public Calculations(MathData mathData) {

		this.mathData = mathData;
		mathData.registerObserver(this);

		this.calculator = new SimpleCalculatorImpl();
	}

	@Override
	public void update(Map params) {
		this.firstNumber = (double) params.get("firstOperand");
		this.sign = (String) params.get("sign");
		this.secondNumber = (double) params.get("secondOperand");
		
		calculate();
	}

	private void calculate() {
		
		double result = calculator.makeCalculation(firstNumber, secondNumber, sign);

		MainPanel.getInstance().getMathOperationPanel().updateResultField(String.valueOf(result));

		MainPanel.getInstance().getHistoryPanel()
				.addStatementToHistory(firstNumber + sign + secondNumber + " = " + result);

	}

}
