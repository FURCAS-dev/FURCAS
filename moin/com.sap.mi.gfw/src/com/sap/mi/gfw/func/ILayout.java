package com.sap.mi.gfw.func;

import com.sap.mi.gfw.features.context.ILayoutContext;

/**
 * The Interface ILayout.
 */
public interface ILayout {

	/**
	 * Checks whether the current pictogram element of the given context can be layouted.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true if update is possible
	 */
	boolean canLayout(ILayoutContext context);

	/**
	 * Layoutes the pictogram element.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if update process was successfull
	 */
	boolean layout(ILayoutContext context);
}
