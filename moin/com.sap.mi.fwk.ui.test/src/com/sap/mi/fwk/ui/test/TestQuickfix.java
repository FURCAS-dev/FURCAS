package com.sap.mi.fwk.ui.test;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;

import com.sap.mi.fwk.ModelManager;

public class TestQuickfix implements IMarkerResolution {

    private static boolean flag;
    private boolean myFlag;

    /*
     * Quickfixes are instatiated using default constructor. The corresponding test case uses two instances
     * of this quickfix which are displayed in a selection dialog. In order to distinguish the the bool flag
     * is used 
     */
    public TestQuickfix() {
        myFlag = flag;
        flag = !flag;
    }

    public String getLabel() {
        return "testquickfix " + myFlag;
    }

    public void run(IMarker marker) {
        ModelManager.getMarkerManager().deleteMarker(marker);
    }
}
