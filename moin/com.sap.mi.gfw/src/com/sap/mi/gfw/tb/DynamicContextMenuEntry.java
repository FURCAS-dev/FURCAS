package com.sap.mi.gfw.tb;

import java.util.ArrayList;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;

/**
 * The Class DynamicContextMenuEntry.
 */
public class DynamicContextMenuEntry extends AbstractContextEntry implements IContextMenuEntry {
	private static final IContextMenuEntry[] NO_CONTEXT_MENU_ENTRIES = new IContextMenuEntry[0];

	private int minimumSubmenuEntries = 3;

	private ArrayList<IContextMenuEntry> children = new ArrayList<IContextMenuEntry>();

	/**
	 * Instantiates a new dynamic context menu entry.
	 * 
	 * @param feature
	 *            the feature
	 * @param context
	 *            the context
	 */
	public DynamicContextMenuEntry(IFeature feature, IContext context) {
		super(feature, context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextMenuEntry#getChildren()
	 */
	public IContextMenuEntry[] getChildren() {
		IContextMenuEntry[] ret = children.toArray(NO_CONTEXT_MENU_ENTRIES);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextMenuEntry#add(com.sap.mi.gfw.tb.IContextMenuEntry)
	 */
	public void add(IContextMenuEntry entry) {
		children.add(entry);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.IContextMenuEntry#isSubmenu()
	 */
	public boolean isSubmenu() {
		return (getText() != null || getFeature() != null) && getChildren().length >= getMinimumSubmenuEntries();
	}

	/**
	 * Sets the minimum submenu entries.
	 * 
	 * @param minimumSubmenuEntries
	 *            the new minimum submenu entries
	 */
	public void setMinimumSubmenuEntries(int minimumSubmenuEntries) {
		this.minimumSubmenuEntries = minimumSubmenuEntries;
	}

	/**
	 * Gets the minimum submenu entries.
	 * 
	 * @return the minimum submenu entries
	 */
	public int getMinimumSubmenuEntries() {
		return minimumSubmenuEntries;
	}
}
