package com.muntian.logic;

import java.util.Map;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

public interface Observer {
	void update (Map params);
}
