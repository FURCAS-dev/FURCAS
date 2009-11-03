package com.sap.mi.gfw.eclipse.internal.util.ui;

/**
 * A generic interface for preference containers (e.g. print, saveas, ...), which serves as abstraction for generic edit fields which store
 * their values in a preference object
 */
public interface DefaultPreferences {

	public void setDefaults();

	public void setIntPreference(int atIndex, int value);

	public void setDoublePreference(int atIndex, double value);

	public int getIntPreference(int atIndex);

	public double getDoublePreference(int atIndex);
}