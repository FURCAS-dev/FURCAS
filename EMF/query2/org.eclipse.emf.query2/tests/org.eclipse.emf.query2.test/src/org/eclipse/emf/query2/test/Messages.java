package org.eclipse.emf.query2.test;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.emf.query2.test.messages"; //$NON-NLS-1$
	public static String Query2CoreTest_SuiteSmokeQueryTest_IncorrectResultSet;
	public static String Query2CoreTest_SuiteSmokeQueryTest_WrongResultSetSize;
	public static String Query2CoreTest_SuiteSyntheticInMemoryForCstTest_4;
	public static String Query2CoreTest_SuiteSyntheticInMemoryForCstTest_IncorrectResultSet;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
