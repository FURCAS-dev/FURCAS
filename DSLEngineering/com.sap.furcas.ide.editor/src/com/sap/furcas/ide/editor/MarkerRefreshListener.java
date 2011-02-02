package com.sap.furcas.ide.editor;

import org.eclipse.core.resources.IProject;

public interface MarkerRefreshListener {

    void onMarkerChange(IProject affectedProject);

}
