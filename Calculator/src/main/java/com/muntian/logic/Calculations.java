package com.muntian.logic;

import java.util.Map;

import org.eclipse.swt.widgets.Text;

import com.muntian.ui.MainPanel;

public class Calculations implements Observer {

	private double firstNumber;
	private String sign;
	private double secondNumber;
	private double result;
	private boolean isflyModeOn;
	
//	private MainPanel mainPanel = MainPanel.getInstance();

	private MathData mathData;
	private Calculator calculator;

	public Calculations(Calculator calculator) {
		this.calculator = calculator;
		

	}

	@Override
	public void update(Map params) {
//		if (params.containsKey(arg0)) {
//			throw new IllegalArgumentException("dhfklshfkljhs")
//		}
		
		this.firstNumber = (double) params.get("firstOperand");
		this.sign = (String) params.get("sign");
		this.secondNumber = (double) params.get("secondOperand");
		
		this.result = calculator.makeCalculation(firstNumber, secondNumber, sign);
		setResultIntoResultField(result);
		setResultIntoHistory(result);
	}
	
	private void setResultIntoResultField(double result) {
		MainPanel.getInstance().getMathOperationPanel().updateResultField(String.valueOf(result));
	}
	
	private void setResultIntoHistory(double result) {
		MainPanel.getInstance().getHistoryPanel()
		.addStatementToHistory(firstNumber + sign + secondNumber + " = " + result);
	}
	

}
