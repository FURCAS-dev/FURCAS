package com.sap.mi.gfw.eclipse.internal.parts;

import java.util.List;

import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface IAnchorContainerDelegate.
 */
public interface IAnchorContainerDelegate extends IPictogramElementDelegate {

	/**
	 * Gets the model children.
	 * 
	 * @return the model children
	 */
	List<PictogramElement> getModelChildren();

	void refreshRenderingDecorators();
}
