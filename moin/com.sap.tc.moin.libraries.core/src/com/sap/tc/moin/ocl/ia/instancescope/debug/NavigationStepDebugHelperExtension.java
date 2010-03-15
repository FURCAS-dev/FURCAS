package com.sap.tc.moin.ocl.ia.instancescope.debug;

import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.repository.core.CoreConnection;

public interface NavigationStepDebugHelperExtension {
    public void printGraph(NavigationStep step, CoreConnection conn, String path);
}
