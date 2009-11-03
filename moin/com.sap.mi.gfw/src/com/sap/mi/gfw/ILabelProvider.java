package com.sap.mi.gfw;

/**
 * The Interface ILabelProvider. Allows to provide an explanatory text and image id for a given object.
 */
public interface ILabelProvider {

	/**
	 * Gets the text.
	 * 
	 * @param o
	 *            the o
	 * 
	 * @return the text
	 */
	String getText(Object o);

	/**
	 * Gets the image id.
	 * 
	 * @param o
	 *            the o
	 * 
	 * @return image id
	 */
	String getImageId(Object o);
}
