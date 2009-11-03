package com.sap.mi.gfw.palette.impl;

import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.palette.IObjectCreationToolEntry;

/**
 * creates an palette tool which creates an object.
 */
public class ObjectCreationToolEntry extends AbstractPaletteToolEntry implements IObjectCreationToolEntry {

	private ICreateFeature createFeature;

	/**
	 * The Constructor.
	 * 
	 * @param label
	 *            the label
	 * @param description
	 *            the description
	 * @param iconId
	 *            the icon id
	 * @param createFeature
	 *            the feature which should be called on creation
	 * @deprecated use ObjectCreationToolEntry(String label, String description, String iconId, String largeIconId, ICreateFeature
	 *             createFeature) instead
	 */
	@Deprecated
	public ObjectCreationToolEntry(String label, String description, String iconId, ICreateFeature createFeature) {
		this(label, description, iconId, iconId, createFeature);
	}

	/**
	 * The Constructor.
	 * 
	 * @param label
	 *            the label
	 * @param description
	 *            the description
	 * @param iconId
	 *            the icon id
	 * @param largeIconId
	 *            the large icon id
	 * @param createFeature
	 *            the feature which should be called on creation
	 */
	public ObjectCreationToolEntry(String label, String description, String iconId, String largeIconId, ICreateFeature createFeature) {
		super(label, description, iconId, largeIconId);
		this.createFeature = createFeature;
	}

	/**
	 * Gets the create feature.
	 * 
	 * @return the associated creation tool
	 */
	public ICreateFeature getCreateFeature() {
		return createFeature;
	}

}
