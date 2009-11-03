/*
 * Created on 17.11.2005
 */
package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface ICreateConnectionContext.
 */
public interface ICreateConnectionContext extends IContext, IConnectionContext {

	/**
	 * Gets the source pictogram element.
	 * 
	 * @return the source pictogram element
	 */
	PictogramElement getSourcePictogramElement();

	/**
	 * Gets the target pictogram element.
	 * 
	 * @return the target pictogram element
	 */
	PictogramElement getTargetPictogramElement();

}