package com.muntian;

import static org.junit.Assert.*;

import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

	private Shell shell;
	
	@Before
	public void init() {
		shell = new Shell();
	}
	
	@After
	public void tearDown() {
		shell = null;
	}
	
	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShell() {
		fail("Not yet implemented");
	}

}
