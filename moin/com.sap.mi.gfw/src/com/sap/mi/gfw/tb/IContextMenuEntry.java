package com.sap.mi.gfw.tb;

/**
 * The Interface IContextMenuEntry.
 */
public interface IContextMenuEntry extends IContextEntry {

	/**
	 * Gets the children.
	 * 
	 * @return the children
	 */
	IContextMenuEntry[] getChildren();

	/**
	 * Adds the.
	 * 
	 * @param entry
	 *            the entry
	 */
	void add(IContextMenuEntry entry);

	/**
	 * Checks if is submenu.
	 * 
	 * @return true, if is submenu
	 */
	boolean isSubmenu();
}
