package com.sap.ide.cts.editor.test.util;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.After;
import org.junit.BeforeClass;

import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;

public class StandaloneConnectionBasedTest {

	static {
		MoinContext.setMoin(MOINTCSMetaConnectionProvider.getBuildMoin());
	}

	protected static ResourceSet connection = null;

	@BeforeClass
	public static void setUp() {
		if (connection == null) {
			connection = MOINTCSMetaConnectionProvider.getTestConnection();
		}
	}

	@After
	public void tearDown() {

		// should be @After and execute after every test
		if (connection != null && connection.isAlive()) {
		    while (connection.getCommandStack( ).isCommandRunning()) {
			try {
			    Thread.sleep(100 /*ms*/);
			} catch (InterruptedException e) {
			    throw new RuntimeException(e);
			}
		    }
		    connection.revert();
		}

	}

}
