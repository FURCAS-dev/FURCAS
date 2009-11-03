package com.sap.mi.gfw.palette;

import java.util.List;

/**
 * The Interface IStackToolEntry.
 */
public interface IStackToolEntry extends IToolEntry {

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription();

	/**
	 * Gets the creation tool entries.
	 * 
	 * @return the creation tool entries
	 */
	public List<ICreationToolEntry> getCreationToolEntries();
}
