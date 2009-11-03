package com.sap.mi.gfw.eclipse.internal.parts;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.model.IWorkbenchAdapter2;

import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface IGfwAdapter.
 */
public interface IGfwAdapter extends IWorkbenchAdapter, IWorkbenchAdapter2 {

	/**
	 * Gets the pictogram element.
	 * 
	 * @param object
	 *            the object
	 * 
	 * @return the pictogram element
	 */
	PictogramElement getPictogramElement(Object object);

	/**
	 * Gets the business objects.
	 * 
	 * @param object
	 *            the object
	 * 
	 * @return the business objects
	 */
	RefObject[] getBusinessObjects(Object object);
}
