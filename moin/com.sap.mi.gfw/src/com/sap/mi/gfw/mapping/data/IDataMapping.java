package com.sap.mi.gfw.mapping.data;

import com.sap.mi.gfw.mm.links.PictogramLink;

/**
 * The Interface IDataMapping.
 */
public interface IDataMapping {

	/**
	 * Gets the update warning.
	 * 
	 * @param pictogramLink
	 *            the pictogram link
	 * 
	 * @return the update warning
	 */
	String getUpdateWarning(PictogramLink pictogramLink);
}
