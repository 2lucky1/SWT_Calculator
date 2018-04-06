package com.muntian;

//import org.eclipse.swt.layout.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.muntian.ui.MainPanel;

public class Main {
	
	private static final String TITLE_OF_APP = "SWT Calculator";
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText(TITLE_OF_APP);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		gridLayout.marginLeft = 5;
		gridLayout.marginRight = 3;
		
		shell.setLayout(gridLayout);
		
		MainPanel mainPanel = new MainPanel(shell);

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
