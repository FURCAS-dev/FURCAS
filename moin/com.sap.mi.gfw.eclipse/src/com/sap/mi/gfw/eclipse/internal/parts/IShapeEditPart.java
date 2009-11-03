/*

 */
package com.sap.mi.gfw.eclipse.internal.parts;

import org.eclipse.gef.EditPart;

/**
 * Window - Preferences - Java - Code Style - Code Templates.
 */
public interface IShapeEditPart extends IAnchorContainerEditPart {

	/**
	 * Delete child and refresh.
	 * 
	 * @param childEditPart
	 *            the child edit part
	 */
	void deleteChildAndRefresh(EditPart childEditPart);

	/**
	 * 
	 */
	void refreshRenderingDecorators();
}