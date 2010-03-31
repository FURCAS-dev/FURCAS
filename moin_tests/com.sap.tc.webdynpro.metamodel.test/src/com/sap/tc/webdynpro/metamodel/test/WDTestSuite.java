package com.sap.tc.webdynpro.metamodel.test;

import junit.framework.TestSuite;

import com.sap.mi.fwk.test.service.DisposingTestSuite;

public class WDTestSuite {
    
    public static TestSuite suite() {
        TestSuite suite = new DisposingTestSuite(WDTestSuite.class.getName());
        
        suite.addTest(new CreateComponentTest());
        suite.addTest(new ModifyComponentTest());
        
        return suite;
    }

}
