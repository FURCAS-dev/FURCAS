package com.sap.mi.gfw.palette;

import java.util.List;

/**
 * The Interface IPaletteCompartmentEntry.
 */
public interface IPaletteCompartmentEntry extends IPaletteEntry {

	/**
	 * Gets the tool entries.
	 * 
	 * @return the tool entries inside this compartment
	 */
	List<IToolEntry> getToolEntries();

	/**
	 * set the initial open state of the compartment.
	 * 
	 * @param initiallyOpen
	 *            the initially open
	 */
	void setInitiallyOpen(boolean initiallyOpen);

	/**
	 * provide the initial open state of the compartment.
	 * 
	 * @return the open state
	 */
	boolean isInitiallyOpen();
}
