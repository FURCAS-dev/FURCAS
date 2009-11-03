package com.sap.mi.gfw.palette.impl;

import com.sap.mi.gfw.palette.IPaletteEntry;

/**
 * The Class AbstractPaletteEntry.
 */
public abstract class AbstractPaletteEntry implements IPaletteEntry {

	private String label, iconId;

	/**
	 * Instantiates a new abstract palette entry.
	 * 
	 * @param label
	 *            the label
	 * @param iconId
	 *            the icon id
	 */
	public AbstractPaletteEntry(String label, String iconId) {
		this.label = label;
		this.iconId = iconId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.palette.IPaletteEntry#getLabel()
	 */
	public String getLabel() {
		return label;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.palette.IPaletteEntry#getIconId()
	 */
	public String getIconId() {
		return iconId;
	}

}
