package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

public class HistoryPanel extends Composite {

	private static final String CLEAR = "Clear";
	private List listResults;
	private Button btnClear;
	
	public HistoryPanel(Composite parent) {
		super(parent, SWT.NONE);
		createContent(parent);
	}

	private void createContent(Composite parent) {
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setLayout(new GridLayout(1, false));
		setBackground(parent.getShell().getBackground());
		
		listResults = new List(this, SWT.V_SCROLL | SWT.BORDER);
		listResults.setLayoutData(new GridData(240, 210));
		
		btnClear = new Button(this, SWT.PUSH);
		btnClear.setText(CLEAR);
		GridData gridData = new GridData(GridData.END, GridData.CENTER,false,false);
		btnClear.setLayoutData(gridData);
		
		btnClear.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				switch(event.type) {
				case SWT.Selection:
					listResults.removeAll();
				}
			}
		});
		
	}
	
	public void addStatementToHistory(String statement) {
		listResults.add(statement);
	}

}
