package com.sap.mi.gfw.pattern.template;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface IBinderTemplate.
 */
public interface IBinderTemplate {

	/**
	 * Builds the visual tree.
	 * 
	 * @return the pictogram element
	 */
	PictogramElement buildVisualTree();

	/**
	 * Builds the domain tree.
	 * 
	 * @return the ref object
	 */
	RefObject buildDomainTree();

}
