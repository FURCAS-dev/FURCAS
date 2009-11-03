package com.sap.mi.gfw.pattern.config;

/**
 * The Interface IMinimumSizeConfiguration.
 */
public interface IMinimumSizeConfiguration extends IPatternConfiguration {

	/**
	 * Gets the minimum height.
	 * 
	 * @return the minimum height
	 */
	int getMinimumHeight();

	/**
	 * Gets the minimum width.
	 * 
	 * @return the minimum width
	 */
	int getMinimumWidth();

	/**
	 * Sets the minimum height.
	 * 
	 * @param minimumHeight
	 *            the new minimum height
	 */
	void setMinimumHeight(int minimumHeight);

	/**
	 * Sets the minimum width.
	 * 
	 * @param minimumWidth
	 *            the new minimum width
	 */
	void setMinimumWidth(int minimumWidth);

}
