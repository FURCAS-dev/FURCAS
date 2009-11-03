package com.sap.mi.gfw.eclipse.internal.fixed;

import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;

/**
 * The Class FixedScrollingGraphicalViewer.
 */
public class FixedScrollingGraphicalViewer extends ScrollingGraphicalViewer {

	/**
	 * Creates the default root editpart. Called during construction.
	 */
	@Override
	protected void createDefaultRoot() {
		setRootEditPart(new FixedScalableRootEditPart());
	}

}
