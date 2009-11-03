package com.sap.mi.gfw.datatypes;

/**
 * The Interface IDimension.
 */
public interface IAdvancedDimension extends IDimension {
	IDimension getDimensionCopy();

	IDimension setDimension(int width, int height);

	IDimension setDimension(IDimension dimension);

	void scale(double amount);

	IDimension expand(int dw, int dh);
}
