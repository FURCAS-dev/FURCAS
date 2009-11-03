package com.sap.mi.gfw.palette.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.palette.IPaletteCompartmentEntry;
import com.sap.mi.gfw.palette.IToolEntry;

/**
 * creates a compartment entry which visualises as a drawer in the palette containing multiple tools.
 */
public class PaletteCompartmentEntry extends AbstractPaletteEntry implements IPaletteCompartmentEntry {

	private List<IToolEntry> toolEntries = new ArrayList<IToolEntry>();

	private boolean initiallyOpen = true;

	/**
	 * The Constructor.
	 * 
	 * @param label
	 *            the text label
	 * @param iconId
	 *            the icon which is displayed
	 */
	public PaletteCompartmentEntry(String label, String iconId) {
		super(label, iconId);
	}

	/**
	 * Gets the tool entries.
	 * 
	 * @return the tools contained in the compartment
	 */
	public List<IToolEntry> getToolEntries() {
		return toolEntries;
	}

	/**
	 * adds a tool entry to the compartment.
	 * 
	 * @param toolEntry
	 *            the tool entry
	 */
	public void addToolEntry(IToolEntry toolEntry) {
		toolEntries.add(toolEntry);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.palette.IPaletteCompartmentEntry#setInitiallyOpen(boolean)
	 */
	public void setInitiallyOpen(boolean initiallyOpen) {
		this.initiallyOpen = initiallyOpen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.palette.IPaletteCompartmentEntry#isInitiallyOpen()
	 */
	public boolean isInitiallyOpen() {
		return initiallyOpen;
	}

}
