package com.sap.tc.moin.ocl.ia.instancescope.debug;

import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.ocl.ia.instancescope.debug.NavigationStepDebugHelperExtension;
import com.sap.tc.moin.repository.core.CoreConnection;

public class NavigationStepDebugHelperExtensionImpl implements NavigationStepDebugHelperExtension {

    public NavigationStepDebugHelperExtensionImpl() {

    }

    @Override
    public void printGraph(NavigationStep step, CoreConnection conn, String path) {
	NavigationStepDebugHelperImpl.printGraphFile(step, conn, path);

    }

}
