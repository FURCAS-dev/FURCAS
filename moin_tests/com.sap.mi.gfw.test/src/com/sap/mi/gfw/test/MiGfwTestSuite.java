package com.sap.mi.gfw.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.test.service.DisposingTestSuite;

public class MiGfwTestSuite {

	public static Test suite() {
		TestSuite suite = new DisposingTestSuite(MiGfwTestSuite.class.getName());

		suite.addTestSuite(GfwOtherTests.class);
		suite.addTestSuite(GfwPackageTests.class);
		suite.addTestSuite(GfwDialogTests.class);
		suite.addTestSuite(GfwIacTests.class);
		// suite.addTestSuite(GfwStandardUxContextButtonPadDeclarationTests.class);

		return suite;
	}

}
