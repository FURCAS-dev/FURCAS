package com.sap.mi.gfw.pattern.config;

import com.sap.mi.gfw.util.IColorConstant;

/**
 * The Interface IColorConfiguration.
 */
public interface IColorConfiguration extends IPatternConfiguration {

	/**
	 * Gets the background color.
	 * 
	 * @return the background color
	 */
	IColorConstant getBackgroundColor();

	/**
	 * Gets the foreground color.
	 * 
	 * @return the foreground color
	 */
	IColorConstant getForegroundColor();

	/**
	 * Gets the text color.
	 * 
	 * @return the text color
	 */
	IColorConstant getTextColor();

	/**
	 * Sets the background color.
	 * 
	 * @param color
	 *            the new background color
	 */
	void setBackgroundColor(IColorConstant color);

	/**
	 * Sets the foreground color.
	 * 
	 * @param color
	 *            the new foreground color
	 */
	void setForegroundColor(IColorConstant color);

	/**
	 * Sets the text color.
	 * 
	 * @param color
	 *            the new text color
	 */
	void setTextColor(IColorConstant color);

	/**
	 * Gets the transparency.
	 * 
	 * @return the transparency
	 */
	double getTransparency();

	/**
	 * Sets the transparency.
	 * 
	 * @param i
	 *            the new transparency
	 */
	void setTransparency(int i);

}
