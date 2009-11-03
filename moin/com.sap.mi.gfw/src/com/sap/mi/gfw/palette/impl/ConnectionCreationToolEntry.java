package com.sap.mi.gfw.palette.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.features.ICreateConnectionFeature;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.palette.IConnectionCreationToolEntry;

/**
 * creates a tool entry for the palette which can create connections.
 */
public class ConnectionCreationToolEntry extends AbstractPaletteToolEntry implements IConnectionCreationToolEntry {

	/**
	 * connection creation features are added seperately.
	 * 
	 * @param label
	 *            the label
	 * @param description
	 *            the description
	 * @param iconId
	 *            the icon id
	 * @deprecated use ConnectionCreationToolEntry(String label, String description, String iconId, String largeIconId) instead
	 */
	@Deprecated
	public ConnectionCreationToolEntry(String label, String description, String iconId) {
		this(label, description, iconId, iconId);
	}

	/**
	 * connection creation features are added seperately.
	 * 
	 * @param label
	 *            the label
	 * @param description
	 *            the description
	 * @param iconId
	 *            the icon id
	 * @param largeIconId
	 *            the large icon id
	 */
	public ConnectionCreationToolEntry(String label, String description, String iconId, String largeIconId) {
		super(label, description, iconId, largeIconId);
	}

	/**
	 * adds a create feature to the tool. you have to provide at least one. if several features are added the tool will display a popup menu
	 * after connection creation which lets the user choose between all features which canExecute.
	 * 
	 * @param createFeature
	 *            the create feature
	 */
	public void addCreateConnectionFeature(ICreateConnectionFeature createFeature) {
		features.add(createFeature);
	}

	/**
	 * Gets the create connection features.
	 * 
	 * @return the provided create connection features
	 */
	public List<IFeature> getCreateConnectionFeatures() {

		List<IFeature> createFeatures = new ArrayList<IFeature>();

		for (IFeature feature : features)
			createFeatures.add(feature);

		return createFeatures;
	}

}
