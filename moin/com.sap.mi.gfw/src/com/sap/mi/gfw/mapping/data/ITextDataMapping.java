package com.sap.mi.gfw.mapping.data;

import com.sap.mi.gfw.mm.links.PictogramLink;

/**
 * The Interface ITextDataMapping.
 */
public interface ITextDataMapping extends IDataMapping {

	/**
	 * Gets the text.
	 * 
	 * @param link
	 *            the link
	 * 
	 * @return the text
	 */
	public String getText(PictogramLink link);
}
