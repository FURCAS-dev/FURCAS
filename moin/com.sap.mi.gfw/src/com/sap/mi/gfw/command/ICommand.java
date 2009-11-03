package com.sap.mi.gfw.command;

import com.sap.mi.gfw.IDescription;
import com.sap.mi.gfw.features.IFeatureProviderHolder;

/**
 * The Interface ICommand. Defines the general GFW Command
 */
public interface ICommand extends IDescription, IFeatureProviderHolder {

	/**
	 * Can execute.
	 * 
	 * @return true, if successful
	 */
	boolean canExecute();

	/**
	 * Execute.
	 * 
	 * @return true, if successful
	 */
	boolean execute();

	/**
	 * Can undo.
	 * 
	 * @return true, if successful
	 */
	boolean canUndo();

	/**
	 * Undo.
	 * 
	 * @return true, if successful
	 */
	boolean undo();
}
