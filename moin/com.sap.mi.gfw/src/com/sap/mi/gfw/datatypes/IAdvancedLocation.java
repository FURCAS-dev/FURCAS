package com.sap.mi.gfw.datatypes;

/**
 * The Interface ILocation.
 */
public interface IAdvancedLocation extends ILocation {
	ILocation getLocationCopy();

	ILocation setLocation(int x, int y);

	ILocation setLocation(ILocation location);

	void scale(double amount);

	ILocation translate(int dx, int dy);
}
