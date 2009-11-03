package com.sap.mi.gfw.features.context;

import com.sap.mi.gfw.mm.pictograms.Anchor;

/**
 * The Interface IConnectionContext.
 */
public interface IConnectionContext extends IContext {

	/**
	 * Gets the source anchor.
	 * 
	 * @return the source anchor
	 */
	Anchor getSourceAnchor();

	/**
	 * Gets the target anchor.
	 * 
	 * @return the target anchor
	 */
	Anchor getTargetAnchor();

}
