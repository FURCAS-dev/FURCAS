package com.sap.mi.gfw.func;

import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.context.IUpdateContext;

/**
 * The Interface IUpdate.
 */
public interface IUpdate {

	/**
	 * Checks whether the values of the current pictogram element of the given context can be updated.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true if update is possible
	 */
	boolean canUpdate(IUpdateContext context);

	/**
	 * Check whether the values in the pictogram element are up to date, that means whether the graphics algorithm of this pictogram element
	 * contain the latest values from the business objects.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true if parts of the pictogram model needs to be updated with the latest values from the business model
	 */
	IReason updateNeeded(IUpdateContext context);

	/**
	 * Updates the pictogram element. It copies the latest values from the business model to the graphics algorithm of this pictogram
	 * elements.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if update process was successfull
	 */
	boolean update(IUpdateContext context);
}