package com.sap.mi.gfw.mapping.data;

import com.sap.mi.gfw.mm.links.PictogramLink;

/**
 * The Interface IImageDataMapping.
 */
public interface IImageDataMapping extends IDataMapping {

	/**
	 * Gets the image id.
	 * 
	 * @param link
	 *            the link
	 * 
	 * @return the image id
	 */
	String getImageId(PictogramLink link);
}
