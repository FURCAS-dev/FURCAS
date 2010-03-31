package com.sap.mi.fwk.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.ModelManagerTest;
import com.sap.mi.fwk.commands.CreatePartitionCommandTest;
import com.sap.mi.fwk.test.CommandManagerCoreTest;
import com.sap.mi.fwk.test.ConnectionManagerTest;
import com.sap.mi.fwk.test.ConsistencyListenerTest;
import com.sap.mi.fwk.test.DCHelperTest;
import com.sap.mi.fwk.test.MIEAdapterTest;
import com.sap.mi.fwk.test.MetamodelManagerTest;
import com.sap.mi.fwk.test.ModelAdapterTest;
import com.sap.mi.fwk.test.MoinConstraintCheckerTest;
import com.sap.mi.fwk.test.MoinOperationTest;
import com.sap.mi.fwk.test.PartitionServiceTest;
import com.sap.mi.fwk.test.PropertyTesterTest;
import com.sap.mi.fwk.test.QueryServiceTest;
import com.sap.mi.fwk.test.service.DisposingTestSuite;
import com.sap.mi.fwk.util.test.FileBasedBuilderTest;
import com.sap.mi.fwk.util.test.StringUtilTest;

/**
 * Test suite for MOIN in Eclipse fwk. Includes the smoke tests.
 * 
 * @author d031150
 */
public class MiFwkTests {

	public static Test suite() {
		TestSuite suite = new DisposingTestSuite(MiFwkTests.class.getName());

		return addToSuite(suite);
	}

	/**
	 * Adds all tests to the given suite
	 * 
	 * @return the given suite for convenience
	 */
	static TestSuite addToSuite(TestSuite suite) {
		// add smoke tests
		MiFwkSmokeTests.addToSuite(suite);

		suite.addTest(MiFwkMoinTests.suite());
		suite.addTestSuite(ConnectionManagerTest.class);
		suite.addTestSuite(CommandManagerCoreTest.class);
		suite.addTestSuite(ConsistencyListenerTest.class);
		suite.addTestSuite(CreatePartitionCommandTest.class);
		suite.addTestSuite(FileBasedBuilderTest.class);
		suite.addTestSuite(MetamodelManagerTest.class);
		suite.addTestSuite(MIEAdapterTest.class);
		suite.addTestSuite(ModelAdapterTest.class);
		suite.addTestSuite(ModelManagerTest.class);
		suite.addTestSuite(MoinConstraintCheckerTest.class);
		suite.addTestSuite(MoinOperationTest.class);
		suite.addTestSuite(PartitionServiceTest.class);
		suite.addTestSuite(QueryServiceTest.class);
		suite.addTestSuite(PropertyTesterTest.class);
		suite.addTestSuite(StringUtilTest.class);
		suite.addTestSuite(DCHelperTest.class);

		return suite;
	}

}
