package com.sap.ide.cts.editor.test.util;

import org.junit.After;
import org.junit.BeforeClass;

import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.mi.textual.syntaxmodel.moinadapter.MoinContext;
import com.sap.tc.moin.repository.Connection;

public class StandaloneConnectionBasedTest {

	static {
		MoinContext.setMoin(MOINTCSMetaConnectionProvider.getBuildMoin());
	}

	protected static Connection connection = null;

	@BeforeClass
	public static void setUp() throws Exception {
		if (connection == null) {
			connection = MOINTCSMetaConnectionProvider.getTestConnection();
		}
	}

	@After
	public void tearDown() throws Exception {

		// should be @After and execute after every test
		if (connection != null) {
			connection.revert();
		}

	}

}
