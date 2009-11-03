/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IPasteContext;

/**
 * The Interface IPasteFeature.
 */
public interface IPasteFeature extends IFeature {

	/**
	 * Paste.
	 * 
	 * @param context
	 *            the context
	 */
	void paste(IPasteContext context);

	/**
	 * Can paste.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canPaste(IPasteContext context);
}