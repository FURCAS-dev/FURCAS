package com.sap.mi.gfw.util;

/**
 * The Interface ILook.
 */
public interface ILook {

	/**
	 * Gets the grid background color.
	 * 
	 * @return the grid background color
	 */
	IColorConstant getGridBackgroundColor();

	/**
	 * Gets the major grid line color.
	 * 
	 * @return the major grid line color
	 */
	IColorConstant getMajorGridLineColor();

	/**
	 * Gets the minor grid line color.
	 * 
	 * @return the minor grid line color
	 */
	IColorConstant getMinorGridLineColor();

	/**
	 * Gets the major grid line distance.
	 * 
	 * @return the major grid line distance
	 */
	int getMajorGridLineDistance();

	/**
	 * Gets the minor grid line distance.
	 * 
	 * @return the minor grid line distance
	 */
	int getMinorGridLineDistance();

	/**
	 * Gets the grid line thickness.
	 * 
	 * @return the grid line thickness
	 */
	int getGridLineThickness();

	/**
	 * Gets the field error background color.
	 * 
	 * @return the field error background color
	 */
	IColorConstant getFieldErrorBackgroundColor();
}
