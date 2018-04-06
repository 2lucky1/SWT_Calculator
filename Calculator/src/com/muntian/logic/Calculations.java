package com.muntian.logic;

import java.util.Map;

import org.eclipse.swt.widgets.Text;

import com.muntian.ui.MainPanel;

public class Calculations implements Observer {

	private double firstNumber;
	private String sign;
	private double secondNumber;
	private boolean isflyModeOn;
	private Text fieldForDisplayResult;
	
	private MathData mathData;

	public Calculations(MathData mathData) {
		this.fieldForDisplayResult = fieldForDisplayResult;
		
		this.mathData = mathData;
		mathData.registerObserver(this);
	}
	
	@Override
	public void update(Map params) {
		this.firstNumber = (double) params.get("firstOperand");
		this.sign = (String) params.get("sign");
		this.secondNumber = (double) params.get("secondOperand");
		calculate();
	}

	public void calculate() {
			double result = -1;
			switch (sign) {
			case "+":
				result = firstNumber + secondNumber;
				break;
			case "-":
				result = firstNumber - secondNumber;
				break;
			case "/":
				result = firstNumber / secondNumber;
				break;
			case "*":
				result = firstNumber*secondNumber;
				break;
			}
			MainPanel.getInstance().getMathOperationPanel().updateResultField(String.valueOf(result));
	}

}
