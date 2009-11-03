package com.sap.mi.gfw.func;

import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Interface IAdd.
 */
public interface IAdd {

	/**
	 * Checks, if the add can be executed.
	 * 
	 * @param context
	 *            context the context needed to execute the add
	 * 
	 * @return true, if the add can be executed
	 */
	boolean canAdd(IAddContext context);

	/**
	 * Executes the add.
	 * 
	 * @param context
	 *            the context needed to execute the add
	 * 
	 * @return the added pictogram element
	 */
	PictogramElement add(IAddContext context);

}
