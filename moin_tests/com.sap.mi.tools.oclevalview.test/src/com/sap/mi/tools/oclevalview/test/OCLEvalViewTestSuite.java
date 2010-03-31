package com.sap.mi.tools.oclevalview.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.test.service.DisposingTestSuite;
import com.sap.mi.tools.oclevalview.internal.OCLEvalViewTest;

public class OCLEvalViewTestSuite {

    public static Test suite() {
        TestSuite suite = new DisposingTestSuite(OCLEvalViewTestSuite.class.getName());

        suite.addTestSuite(OCLEvalViewTest.class);
        return suite;
    }

}
