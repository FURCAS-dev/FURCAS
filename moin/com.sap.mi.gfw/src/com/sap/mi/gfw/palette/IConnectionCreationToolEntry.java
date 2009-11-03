package com.sap.mi.gfw.palette;

import java.util.List;

import com.sap.mi.gfw.features.IFeature;

/**
 * The Interface IConnectionCreationToolEntry.
 */
public interface IConnectionCreationToolEntry extends ICreationToolEntry {

	/**
	 * Gets the creates the connection features.
	 * 
	 * @return the creates the connection features
	 */
	public List<IFeature> getCreateConnectionFeatures();
}
