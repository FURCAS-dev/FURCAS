package com.sap.mi.tools.diagnostics.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.test.service.DisposingTestSuite;
import com.sap.mi.tools.diagnostics.internal.DiagnosticsViewTest;
import com.sap.mi.tools.diagnostics.internal.properties.DiagnosticsViewPropertiesTest;

public class DiagnosticsTestSuite {

    public static Test suite() {
        TestSuite suite = new DisposingTestSuite(DiagnosticsTestSuite.class.getName());

        suite.addTestSuite(DiagnosticsViewTest.class);
        suite.addTestSuite(DiagnosticsViewPropertiesTest.class);
        return suite;
    }

}
