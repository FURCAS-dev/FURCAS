package com.sap.mi.fwk.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.test.service.test.TestUtilTest;
import com.sap.mi.fwk.util.test.ZipServiceTest;

/**
 * Test suite containing unit tests for plugins com.sap.mi.fwk and com.sap.mi.fwk.test.service
 * @author d022960
 *
 */
public class MiFwkUnitTest extends TestSuite {
    public static Test suite() {
    	TestSuite suite = new MiFwkUnitTest();
    	
    	suite.addTestSuite(TestUtilTest.class);
		suite.addTestSuite(ZipServiceTest.class);
    	return suite;
    }
}
