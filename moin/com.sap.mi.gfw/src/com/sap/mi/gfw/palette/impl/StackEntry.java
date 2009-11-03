package com.sap.mi.gfw.palette.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.palette.ICreationToolEntry;
import com.sap.mi.gfw.palette.IStackToolEntry;

/**
 * creates a compartment entry which visualises as a drawer in the palette containing multiple tools.
 */
public class StackEntry extends AbstractPaletteEntry implements IStackToolEntry {

	private String description;

	private List<ICreationToolEntry> creationToolEntries = new ArrayList<ICreationToolEntry>();

	/**
	 * creates a new stack tool for the palette. A stack entry contains multiple tools in a drop down list of which one is active and
	 * visible
	 * 
	 * @param label
	 *            the text to display
	 * @param description
	 *            the tooltip text
	 * @param iconId
	 *            the id for the icon
	 */
	public StackEntry(String label, String description, String iconId) {
		super(label, iconId);
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * return the creation tools.
	 * 
	 * @return the creation tool entries
	 */
	public List<ICreationToolEntry> getCreationToolEntries() {
		return creationToolEntries;
	}

	/**
	 * adds a creation tool to the stack entry.
	 * 
	 * @param creationToolEntry
	 *            the creation tool entry
	 */
	public void addCreationToolEntry(ICreationToolEntry creationToolEntry) {
		creationToolEntries.add(creationToolEntry);
	}
}
