package com.muntian.ui;

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

import com.muntian.logic.Calculations;
import com.muntian.logic.MathData;

public class MathOperationPanel extends Composite {

	private static final String RESULT = "Result:";
	private static final String CALCULATE = "Calculate";
	private static final String CALCULATE_ON_THE_FLY = "Calculate on the fly";

	private static final String[] items = new String[] { "+", "-", "/", "*", " " };

	private MathData mathData;

	private Text firstNumber;
	private Combo sign;
	private Text secondNumber;
	private Button checkBoxOnFlyMode;
	private Label labelCalcOnTheFly;
	private Button btnCalculate;
	private Label labelResult;
	private Text textResult;
	
	private Calculations calculation;

	public MathOperationPanel(Composite parent) {
		super(parent, SWT.NONE);

		createContent(parent);
		initActions();
		
		mathData = new MathData();
		calculation = new Calculations(textResult, mathData);
	}

	private void createContent(Composite parent) {

		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(3, false);
		gridLayout.verticalSpacing = 80;
		gridLayout.horizontalSpacing = 15;
		setLayout(gridLayout);
		setBackground(parent.getShell().getBackground());

		firstNumber = new Text(this, SWT.BORDER);

		sign = new Combo(this, SWT.DROP_DOWN);
		sign.setItems(items);
		GridData gridData = new GridData(GridData.CENTER, GridData.FILL, false, false);
		gridData.widthHint = 50;
		gridData.heightHint = 5;
		sign.setLayoutData(gridData);

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

		firstNumber.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (checkBoxOnFlyMode.getSelection()) {
					mathData.setFirstOperand(Double.parseDouble(firstNumber.getText()));
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

		sign.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (checkBoxOnFlyMode.getSelection()) {
					mathData.setSign(sign.getText());
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
					mathData.setSign(sign.getText());
					break;
				}
			}
		});
		
		

		// sign.addSelectionListener( new SelectionListener() {
		//
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// mathData.setSign(sign);
		// }
		//
		// @Override
		// public void widgetDefaultSelected(SelectionEvent e) {
		// mathData.setSign(null);
		// }
		// });

		// public void widgetSelected(SelectionEvent e) {
		// double res;
		// switch (sign.getText()) {
		// case "+":
		// res = Double.parseDouble(firstNumber.getText()) +
		// Double.parseDouble(secondNumber.getText());
		//
		// break;
		// case "-":
		// res = Double.parseDouble(firstNumber.getText()) -
		// Double.parseDouble(secondNumber.getText());
		// textResult.setText("" + res);
		// break;
		// case "/":
		// res = Double.parseDouble(firstNumber.getText()) /
		// Double.parseDouble(secondNumber.getText());
		// textResult.setText("" + res);
		// break;
		// case "*":
		// res = Double.parseDouble(firstNumber.getText()) *
		// Double.parseDouble(secondNumber.getText());
		// textResult.setText("" + res);
		// break;
		// }
		//
		// if (checkBoxOnFlyMode.getSelection()) {
		// textResult.setText("" + res);
		// }
		//
		// }
		// });

	}

	public Text getTextResult() {
		return textResult;
	}
}
