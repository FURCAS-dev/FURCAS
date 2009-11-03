package com.sap.mi.tools.diagnostics.internal.actions;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

/**
 * Base class for viewer actions
 * 
 * @author d031150
 */
public abstract class DiagnosticsViewerAction extends BaseSelectionListenerAction {
    
    protected final StructuredViewer mViewer;

    /**
     * Creates an action based on the given viewer's selection
     */
    DiagnosticsViewerAction(String text, StructuredViewer viewer) {
        super(text);
        mViewer = viewer;
        // set initial selection and enablement state
        selectionChanged((IStructuredSelection) viewer.getSelection());
    }
    
    /**
     * @return whether the action is to be shown
     */
    public abstract boolean isAvailable();

}
