package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

public class HistoryPanel extends Composite {

	private static final String TEST_ITEM = "TestItem";
	private List listResults;
	private Button btnClear;
//	private RowLayout rowLayout;
	
	public HistoryPanel(Composite parent) {
		super(parent, SWT.NONE);
		createContent(parent);
	}

	private void createContent(Composite parent) {
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setLayout(new GridLayout(1, false));
		setBackground(parent.getShell().getBackground());
		
		listResults = new List(this, SWT.V_SCROLL);
		listResults.setLayoutData(new GridData(100, 100));
		listResults.add(TEST_ITEM);
		
		btnClear = new Button(this, SWT.PUSH);
		btnClear.setText("Clear");
		GridData gridData = new GridData(GridData.END, GridData.CENTER,false,false);
		btnClear.setLayoutData(gridData);
		
	}

}
