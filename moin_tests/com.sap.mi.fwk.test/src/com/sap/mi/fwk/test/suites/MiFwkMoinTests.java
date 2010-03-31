package com.sap.mi.fwk.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.test.ConnectionTest;
import com.sap.mi.fwk.test.PartitionTest;
import com.sap.mi.fwk.test.service.DisposingTestSuite;

/**
 * Contains test for expectations and bugs of the core Moin Api, but not for
 * MiE functionality.  The tests will fail whenever Moin Api changes its behavior
 * or bugs are fixed.
 * 
 * @author d031150
 */
public class MiFwkMoinTests {

    public static Test suite() {
        TestSuite suite = new DisposingTestSuite(MiFwkMoinTests.class.getName());
        
        suite.addTestSuite(PartitionTest.class);
        suite.addTestSuite(ConnectionTest.class);

        return suite;
    }

}
