package com.sap.mi.tools.mmdeploy.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.test.service.DisposingTestSuite;
import com.sap.mi.tools.mmdeploy.internal.MmDeploymentViewTest;

public class MmDeploymentTestSuite {

    public static Test suite() {
        TestSuite suite = new DisposingTestSuite(MmDeploymentTestSuite.class.getName());

        suite.addTestSuite(MmDeploymentViewTest.class);
        return suite;
    }

}
