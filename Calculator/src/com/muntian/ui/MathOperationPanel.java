package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MathOperationPanel extends Composite {

	private static final String RESULT = "Result:";
	private static final String CALCULATE = "Calculate";
	private static final String CALCULATE_ON_THE_FLY = "Calculate on the fly";

	private static final String[] items = new String[] { "+", "-", "/", "*", " " };

	private Text firstNumber;
	private Combo sign;
	private Text secondNumber;
	private Button checkBoxOnFlyMode;
	private Label calcOnTheFly;
	private Button btnCalculate;
	private Label labelResult;
	private Text textResult;

	public MathOperationPanel(Composite parent) {
		super(parent, SWT.NONE);

		createContent(parent);

	}

	private void createContent(Composite parent) {
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(3, false);
		gridLayout.verticalSpacing = 80;
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

		calcOnTheFly = new Label(this, SWT.NONE);
		calcOnTheFly.setText(CALCULATE_ON_THE_FLY);

		btnCalculate = new Button(this, SWT.PUSH);
		btnCalculate.setText(CALCULATE);

		labelResult = new Label(this, SWT.NONE);
		labelResult.setText(RESULT);

		textResult = new Text(this, SWT.BORDER);

	}
}
