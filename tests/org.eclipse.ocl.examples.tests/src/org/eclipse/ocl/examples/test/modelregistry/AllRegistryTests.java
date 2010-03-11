package org.eclipse.ocl.examples.test.modelregistry;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllRegistryTests
{
	public static void buildSuite(TestSuite suite) {
		suite.addTestSuite(TestContents.class);
		suite.addTestSuite(TestFileHandles.class);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All Registry Tests");
		buildSuite(suite);
		return suite;
	}
}
