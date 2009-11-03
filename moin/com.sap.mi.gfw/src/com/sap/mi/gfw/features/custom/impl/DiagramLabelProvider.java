package com.sap.mi.gfw.features.custom.impl;

import com.sap.mi.gfw.ILabelProvider;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.platform.IPlatformImageConstants;

/**
 * The Class DiagramLabelProvider.
 */
class DiagramLabelProvider implements ILabelProvider {

	/**
	 * Instantiates a new diagram label provider.
	 */
	public DiagramLabelProvider() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object o) {
		String ret = null;
		if (o instanceof Diagram) {
			Diagram diagram = (Diagram) o;
			ret = diagram.getName() + " (" + diagram.getDiagramTypeId() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.ILabelProvider#getImageId(java.lang.Object)
	 */
	public String getImageId(Object o) {
		return IPlatformImageConstants.IMG_DIAGRAM;
	}

}
