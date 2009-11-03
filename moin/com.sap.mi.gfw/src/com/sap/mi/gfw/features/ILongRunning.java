package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IContext;

/**
 * The Interface ILongRunning.
 */
public interface ILongRunning extends IProgressProvider {

	/**
	 * Checks if is really long running.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return true, if is really long running
	 */
	boolean isReallyLongRunning(IContext context);

	/**
	 * Gets the running steps.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @return the running steps
	 */
	int getRunningSteps(IContext context);
}
