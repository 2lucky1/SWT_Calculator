package com.muntian.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.muntian.exceptions.IncorrectInputOfNumberException;
import com.muntian.logic.Calculations;
import com.muntian.logic.MathData;
import com.muntian.logic.SimpleCalculatorImpl;

public class MathOperationPanel extends Composite {

	private static final String RESULT = "Result:";
	private static final String CALCULATE = "Calculate";
	private static final String CALCULATE_ON_THE_FLY = "Calculate on the fly";

	private static final String[] items = new String[] { "+", "-", "/", "*", " " };

	private MathData mathData;

	private Text firstNumber;
	private Combo mathOperator;
	private Text secondNumber;
	private Button checkBoxOnFlyMode;
	private Label labelCalcOnTheFly;
	private Button btnCalculate;
	private Label labelResult;
	private Text textResult;
	
	private boolean firstNumberIsCorrect = false;
	
	private Calculations calculation;

	public MathOperationPanel(Composite parent) {
		super(parent, SWT.NONE);

		createContent(parent);
		initActions();
		
		mathData = new MathData();
		calculation = new Calculations(new SimpleCalculatorImpl());
		mathData.registerObserver(calculation);
	}

	private void createContent(Composite parent) {

		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(3, false);
		gridLayout.verticalSpacing = 80;
		gridLayout.horizontalSpacing = 15;
		setLayout(gridLayout);
		setBackground(parent.getShell().getBackground());

		firstNumber = new Text(this, SWT.BORDER);

		mathOperator = new Combo(this, SWT.DROP_DOWN);
		mathOperator.setItems(items);
		GridData gridData = new GridData(GridData.CENTER, GridData.FILL, false, false);
		gridData.widthHint = 50;
		gridData.heightHint = 5;
		mathOperator.setLayoutData(gridData);

		secondNumber = new Text(this, SWT.BORDER);

		checkBoxOnFlyMode = new Button(this, SWT.CHECK);

		labelCalcOnTheFly = new Label(this, SWT.NONE);
		labelCalcOnTheFly.setText(CALCULATE_ON_THE_FLY);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalIndent = -70;
		gridData.verticalIndent = 4;
		labelCalcOnTheFly.setLayoutData(gridData);

		btnCalculate = new Button(this, SWT.PUSH);
		btnCalculate.setText(CALCULATE);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalIndent = 15;
		btnCalculate.setLayoutData(gridData);

		labelResult = new Label(this, SWT.NONE);
		labelResult.setText(RESULT);

		textResult = new Text(this, SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalSpan = 2;
		textResult.setLayoutData(gridData);
	}

	private void initActions() {

		
		
		
		firstNumber.addModifyListener(new FirstOperandModifyListener());

		firstNumber.addListener(SWT.Verify, new Listener() {
			
			@Override
			public void handleEvent(Event e) {
				try {
					verifyInput(e.text);
				} catch (IncorrectInputOfNumberException ex) {
					System.out.println("verify listener has done");
					
				}
			}
		});

		secondNumber.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (checkBoxOnFlyMode.getSelection()) {
					mathData.setSecondOperand(Double.parseDouble(secondNumber.getText()));
				}
			}
		});

		mathOperator.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (checkBoxOnFlyMode.getSelection()) {
					mathData.setSign(mathOperator.getText());
				}
			}
		});

		checkBoxOnFlyMode.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				mathData.setOnFlyMode(checkBoxOnFlyMode.getSelection());
				if (checkBoxOnFlyMode.getSelection()) {
					btnCalculate.setEnabled(false);
				} else {
					btnCalculate.setEnabled(true);
				}
			}
		});
		
		btnCalculate.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				switch(event.type) {
				case SWT.Selection:
					
					mathData.setFirstOperand(Double.parseDouble(firstNumber.getText()));
					mathData.setSecondOperand(Double.parseDouble(secondNumber.getText()));
					mathData.setSign(mathOperator.getText());
					
					break;
				}
			}
		});

	}
	
	/**
	 * This method update result field in calculator.
	 * 
	 * @param text
	 */
	public void updateResultField(String text) {
		textResult.setText(text);
	}

	
	static void verifyInput(String input) {
		String regExp = "^(0|[1-9]\\d*)?(\\.\\d+)?(?<=\\d)$";
		if(!input.matches(regExp)) {
			throw new IncorrectInputOfNumberException("Incorrect input of number: " + input + ". Input decimal number");
		}
	}
	
	/**
	 * 
	 * @author MMuntian
	 *
	 */
	private class FirstOperandModifyListener implements ModifyListener {

		@Override
		public void modifyText(ModifyEvent e) {
			if (checkBoxOnFlyMode.getSelection()) {
				System.out.println("Modify listener!!");
				mathData.setFirstOperand(Double.parseDouble(firstNumber.getText()));
			}
		}
	}
}
