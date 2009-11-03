package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IPrintContext;

/**
 * The Interface IPrintFeature.
 */
public interface IPrintFeature extends IFeature {

	/**
	 * Can print.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if successful
	 */
	boolean canPrint(IPrintContext context);

	/**
	 * Pre print.
	 * 
	 * @param context
	 *            the context
	 */
	void prePrint(IPrintContext context);

	/**
	 * Post print.
	 * 
	 * @param context
	 *            the context
	 */
	void postPrint(IPrintContext context);
}
