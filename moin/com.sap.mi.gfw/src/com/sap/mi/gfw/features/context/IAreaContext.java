package com.sap.mi.gfw.features.context;

/**
 * Types of this context describe an area, where features have to work in.
 */
public interface IAreaContext extends ILocationContext {

	/**
	 * Gets the width.
	 * 
	 * @return the area's width
	 */
	int getWidth();

	/**
	 * Gets the height.
	 * 
	 * @return the area's height
	 */
	int getHeight();
}