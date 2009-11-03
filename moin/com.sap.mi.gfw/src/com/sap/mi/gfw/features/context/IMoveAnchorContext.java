/*
 * Created on 16.11.2005
 *


 */
package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;

/**
 * The Interface IMoveAnchorContext.
 */
public interface IMoveAnchorContext extends IMoveContext {

	/**
	 * Gets the anchor.
	 * 
	 * @return the anchor
	 */
	Anchor getAnchor();

	/**
	 * Gets the target container.
	 * 
	 * @return the target container
	 */
	AnchorContainer getTargetContainer();

	/**
	 * Gets the source container.
	 * 
	 * @return the source container
	 */
	AnchorContainer getSourceContainer();
}