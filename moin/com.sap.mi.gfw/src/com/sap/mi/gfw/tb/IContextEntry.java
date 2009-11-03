package com.sap.mi.gfw.tb;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;

/**
 * The Interface IContextEntry.
 */
public interface IContextEntry {

	/**
	 * Can execute.
	 * 
	 * @return true, if successful
	 */
	boolean canExecute();

	/**
	 * Execute.
	 */
	void execute();

	/**
	 * Gets the context.
	 * 
	 * @return the context
	 */
	IContext getContext();

	/**
	 * Gets the feature.
	 * 
	 * @return the feature
	 */
	IFeature getFeature();

	/**
	 * Gets the icon id.
	 * 
	 * @return the icon id
	 */
	String getIconId();

	/**
	 * Sets the description.
	 * 
	 * @param text
	 *            the new description
	 */
	void setDescription(String text);

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	String getDescription();

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	void setText(String text);

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	String getText();

	/**
	 * Sets the icon id.
	 * 
	 * @param iconId
	 *            the new icon id
	 */
	void setIconId(String iconId);

}
