package com.sap.mi.gfw.features;

public interface IResizeConfiguration {
	/**
	 * Defines resize behavior
	 * 
	 * @return true if element can be resized in vertical direction
	 */
	boolean isVerticalResizeAllowed();

	/**
	 * Defines resize behavior
	 * 
	 * @return true if element can be resized in horizontal direction
	 */
	boolean isHorizantalResizeAllowed();
}
