package com.sap.mi.gfw.palette.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.palette.ICreationToolEntry;

/**
 * The Class AbstractPaletteToolEntry.
 */
public abstract class AbstractPaletteToolEntry extends AbstractPaletteEntry implements ICreationToolEntry {

	/**
	 * The features.
	 */
	protected List<IFeature> features = new ArrayList<IFeature>();

	private String description;

	private String largeIconId = null;

	/**
	 * Instantiates a new abstract palette tool entry.
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
	public AbstractPaletteToolEntry(String label, String description, String iconId, String largeIconId) {
		super(label, iconId);
		this.description = description;
		setLargeIconId(largeIconId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.palette.ICreationToolEntry#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the features.
	 * 
	 * @return the features
	 */
	public List<IFeature> getFeatures() {
		return features;
	}

	public String getLargeIconId() {
		return largeIconId;
	}

	private void setLargeIconId(String largeIconId) {
		this.largeIconId = largeIconId;
	}

}
