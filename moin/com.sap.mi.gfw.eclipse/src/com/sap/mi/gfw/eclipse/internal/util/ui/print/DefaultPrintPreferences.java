package com.sap.mi.gfw.eclipse.internal.util.ui.print;

import com.sap.mi.gfw.eclipse.internal.util.ui.DefaultPreferences;

/**
 * This class is a simple container for the preferences for the print dialog.
 */
public class DefaultPrintPreferences implements DefaultPreferences {

	// double preferences
	public static final int SCALE_FACTOR_X = 0;
	public static final int SCALE_FACTOR_Y = 1;
	public static final int LEFT_MARGIN = 2;
	public static final int TOP_MARGIN = 3;
	public static final int SCALE_FACTOR = 4;
	public static final int CURRENT_SCALE = 5;
	public static final int PRINTER_IMAGE_WIDTH = 6;
	public static final int PRINTER_IMAGE_HEIGHT = 7;
	public static final int PRINTER_LEFT_MARGIN = 8;
	public static final int PRINTER_TOP_MARGIN = 9;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 11;

	// integer preferences
	public static final int CENTER = 0;

	// default values for preferences
	public static final double SCALE_FACTOR_DEFAULT = 1.0;
	public static final double LEFT_MARGIN_DEFAULT = 0.0;
	public static final double TOP_MARGIN_DEFAULT = 0.0;
	public static final double CURRENT_SCALE_DEFAULT = 1.0;
	public static final double PRINTER_IMAGE_WIDTH_DEFAULT = 500.0;
	public static final double PRINTER_IMAGE_HEIGHT_DEFAULT = 500.0;
	public static final double PRINTER_LEFT_MARGIN_DEFAULT = 0.0;
	public static final double PRINTER_TOP_MARGIN_DEFAULT = 0.0;
	public static final double WIDTH_DEFAULT = 10.0;
	public static final double HEIGHT_DEFAULT = 10.0;

	public static final double[] DEFAULT_DOUBLE_PREFERENCES = { SCALE_FACTOR_DEFAULT, SCALE_FACTOR_DEFAULT, LEFT_MARGIN_DEFAULT,
			TOP_MARGIN_DEFAULT, SCALE_FACTOR_DEFAULT, CURRENT_SCALE_DEFAULT, PRINTER_IMAGE_WIDTH_DEFAULT, PRINTER_IMAGE_HEIGHT_DEFAULT,
			PRINTER_LEFT_MARGIN_DEFAULT, PRINTER_TOP_MARGIN_DEFAULT, WIDTH_DEFAULT, HEIGHT_DEFAULT };

	public static final int[] DEFAULT_INT_PREFERENCES = { CENTER };

	// number of preferences
	public static final int NUM_OF_DOUBLE_PREFERENCES = DEFAULT_DOUBLE_PREFERENCES.length;
	public static final int NUM_OF_INT_PREFERENCES = DEFAULT_INT_PREFERENCES.length;

	// member variables
	private int[] prefs;
	private double[] prefsDouble;

	/**
	 * Creates a new instance of DefaultPrintPreferences, which is initialized with the default values.
	 */
	public DefaultPrintPreferences() {
		prefs = new int[NUM_OF_INT_PREFERENCES];
		prefsDouble = new double[NUM_OF_DOUBLE_PREFERENCES];
		setDefaults();
	}

	// =================== interface DefaultPreferences =======================

	public void setDefaults() {
		for (int i = 0; i < NUM_OF_INT_PREFERENCES; i++)
			prefs[i] = DEFAULT_INT_PREFERENCES[i];

		for (int i = 0; i < NUM_OF_DOUBLE_PREFERENCES; i++)
			prefsDouble[i] = DEFAULT_DOUBLE_PREFERENCES[i];

	}

	public void setIntPreference(int preference, int value) {
		prefs[preference] = value;

	}

	public int getIntPreference(int preference) {
		return prefs[preference];
	}

	public void setDoublePreference(int preference, double value) {
		prefsDouble[preference] = value;
	}

	public double getDoublePreference(int preference) {
		return prefsDouble[preference];
	}
}
