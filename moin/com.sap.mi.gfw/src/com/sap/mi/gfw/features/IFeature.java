/*
 * Created on 06.07.2005
 */
package com.sap.mi.gfw.features;

import com.sap.mi.gfw.IDescription;
import com.sap.mi.gfw.IName;
import com.sap.mi.gfw.features.context.IContext;

/**
 * Similar to actions and commands. Contains check/can methods and (in the future) methods for undo and redo functionality.
 * 
 * @see com.sap.mi.gfw.features.context.IContext
 */
public interface IFeature extends IName, IDescription, IFeatureProviderHolder {

	/**
	 * Decides if the current feature is available with the given context.
	 * 
	 * @param context
	 *            this is the general input for this method
	 * 
	 * @return true if it is available, false if not
	 * 
	 * @see IContext
	 */
	boolean isAvailable(IContext context);

	/**
	 * Decides if the current feature can execute with the given context.
	 * 
	 * @param context
	 *            this is the general input for this method
	 * 
	 * @return true if the feature can be executed, false if not
	 * 
	 * @see IContext
	 */
	boolean canExecute(IContext context);

	/**
	 * Executes the current feature with the given context.
	 * 
	 * @param context
	 *            this is the general input for this method
	 * 
	 * @see IContext
	 */
	void execute(IContext context);

	/**
	 * Decides if the current feature can be undone - this is the undo of the execute operation.
	 * 
	 * @param context
	 *            this is the general input for this method
	 * 
	 * @return true if the feature can be undone, false if not
	 * 
	 * @see IContext
	 */
	boolean canUndo(IContext context);
}