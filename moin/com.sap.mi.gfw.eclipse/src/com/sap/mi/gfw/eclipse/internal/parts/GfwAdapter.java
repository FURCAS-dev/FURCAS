package com.sap.mi.gfw.eclipse.internal.parts;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.ui.model.WorkbenchAdapter;

import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.LinkUtil;

/**
 * The Class GfwAdapter.
 */
public class GfwAdapter extends WorkbenchAdapter implements IGfwAdapter {

	private static final RefObject[] NO_REF_OBJECTS = new RefObject[0];

	/**
	 * Instantiates a new gfw adapter.
	 */
	public GfwAdapter() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.model.WorkbenchAdapter#getLabel(java.lang.Object)
	 */
	@Override
	public String getLabel(Object object) {
		String addition = null;
		PictogramElement pe = getPictogramElement(object);
		if (pe != null) {
			addition = pe.toString();
		}
		return "PE: " + addition + ""; //$NON-NLS-1$//$NON-NLS-2$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.IGfwAdapter#getPictogramElement(java.lang.Object)
	 */
	public PictogramElement getPictogramElement(Object object) {
		if (object instanceof IPictogramElementEditPart) {
			IPictogramElementEditPart peEditPart = (IPictogramElementEditPart) object;
			return peEditPart.getPictogramElement();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.eclipse.internal.parts.IGfwAdapter#getBusinessObjects(java.lang.Object)
	 */
	public RefObject[] getBusinessObjects(Object object) {
		RefObject[] ret = NO_REF_OBJECTS;
		PictogramElement pe = getPictogramElement(object);
		if (pe != null) {
			ret = LinkUtil.getAllBusinessObjectsForLinkedPictogramElement(pe);
		}
		return ret;
	}

}
