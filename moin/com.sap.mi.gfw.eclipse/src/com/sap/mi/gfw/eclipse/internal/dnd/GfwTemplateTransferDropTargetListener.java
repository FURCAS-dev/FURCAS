package com.sap.mi.gfw.eclipse.internal.dnd;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;

/**
 * This subclass of TemplateTransferDropTargetListener {@link org.eclipse.gef.dnd.TemplateTransferDropTargetListener} was introduced to
 * change the default behavior. For details on this see csn-message 0120031469 0001576030 2008
 */
public class GfwTemplateTransferDropTargetListener extends TemplateTransferDropTargetListener {

	public GfwTemplateTransferDropTargetListener(EditPartViewer viewer) {
		super(viewer);
		// it is important to set this value to true
		setEnablementDeterminedByCommand(true);
	}

}
