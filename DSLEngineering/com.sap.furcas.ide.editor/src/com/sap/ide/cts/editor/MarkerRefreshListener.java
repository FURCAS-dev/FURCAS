package com.sap.ide.cts.editor;

import org.eclipse.core.resources.IProject;

public interface MarkerRefreshListener {

    void onMarkerChange(IProject affectedProject);

}
