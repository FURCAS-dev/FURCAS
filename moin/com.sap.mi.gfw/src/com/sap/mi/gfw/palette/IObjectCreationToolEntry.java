package com.sap.mi.gfw.palette;

import com.sap.mi.gfw.features.ICreateFeature;

/**
 * The Interface IObjectCreationToolEntry.
 */
public interface IObjectCreationToolEntry extends ICreationToolEntry {

	/**
	 * Gets the creates the feature.
	 * 
	 * @return the creates the feature
	 */
	public ICreateFeature getCreateFeature();
}
