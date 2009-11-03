package com.sap.mi.gfw.tb;

import java.util.ArrayList;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;

/**
 * The Class ContextMenuEntry.
 */
public class ContextMenuEntry extends AbstractContextEntry implements IContextMenuEntry {
	private static final IContextMenuEntry[] NO_CONTEXT_MENU_ENTRIES = new IContextMenuEntry[0];

	private ArrayList<IContextMenuEntry> children = new ArrayList<IContextMenuEntry>();

	private boolean submenu = true;

	/**
	 * Instantiates a new context menu entry.
	 * 
	 * @param feature
	 *            the feature
	 * @param context
	 *            the context
	 */
	public ContextMenuEntry(IFeature feature, IContext context) {
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
		return submenu;
	}

	/**
	 * Sets the submenu.
	 * 
	 * @param submenu
	 *            the new submenu
	 */
	public void setSubmenu(boolean submenu) {
		this.submenu = submenu;
	}
}
