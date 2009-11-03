package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.swt.graphics.Color;

/**
 * This class is used to assign a color to a location. See {@link #getLocation(int, double)} for a detailed explanation of the location.
 */
public class ColoredLocation {

	/**
	 * This location-type defines that the location-value is a relative percentage value in the range [0, 100]. Concretely the location is
	 * calculated by "length * (location-value / 100)".
	 */
	public static final int LOCATION_TYPE_RELATIVE = 1;

	/**
	 * This location-type defines that the location-value is an absolute value starting at the beginning of length. Concretely the location
	 * is calculated by "location-value".
	 */
	public static final int LOCATION_TYPE_ABSOLUTE_START = 2;

	/**
	 * This location-type defines that the location-value is an absolute value starting at the end of length. Concretely the location is
	 * calculated by "end - location-value".
	 */
	public static final int LOCATION_TYPE_ABSOLUTE_END = 3;

	/**
	 * The color set in the constructor.
	 */
	private Color color;

	/**
	 * The location-value set in the constructor.
	 */
	private int locationValue;

	/**
	 * The location-type set in the constructor.
	 */
	private int locationType;

	/**
	 * Creates a new ColoredLocation for the given values. Have a look at {@link #getLocation(int, double)} for an explanation of the
	 * location-type and location-value.
	 * 
	 * @param color
	 *            The color.
	 * @param locationValue
	 *            The location-value.
	 * @param locationType
	 *            The location-type.
	 */
	public ColoredLocation(Color color, int locationValue, int locationType) {
		this.color = color;
		this.locationValue = locationValue;
		this.locationType = locationType;
	}

	/**
	 * Creates a new ColoredLocation for the given values. Have a look at {@link #getLocation(int, double)} for an explanation of the
	 * location-type and location-value.
	 * 
	 * @param colorHexRGBString
	 *            The color as hexadecimal RGB string, e.g. "FF00FF".
	 * @param locationValue
	 *            The location-value.
	 * @param locationType
	 *            The location-type.
	 */
	public ColoredLocation(String colorHexRGBString, int locationValue, int locationType) {
		this(getColor(colorHexRGBString), locationValue, locationType);
	}

	/**
	 * Returns the color.
	 * 
	 * @return The color.
	 */
	public final Color getColor() {
		return color;
	}

	/**
	 * Returns the location-value. From the location-value and the location-type the real location can be calculated.
	 * 
	 * @return The location-value.
	 * @see #getLocation(int, double)
	 */
	protected final int getLocationValue() {
		return locationValue;
	}

	/**
	 * Returns the location-type. From the location-value and the location-type the real location can be calculated.
	 * 
	 * @return The location-type.
	 * @see #getLocation(int, double)
	 */
	public final int getLocationType() {
		return locationType;
	}

	/**
	 * Returns the location for the given length and zoom-factor. The location is calculated from the location-value and location-type in
	 * relation to the given length and zoom-factor.
	 * <p>
	 * The idea is, that the location-type specifies how to interpret the location-value in relation to the length. For example if the
	 * location-type is "relative" and the location-value is "40", then this means, that the location is at 40% of the length. So for a
	 * length of 200 the location would be 80.
	 * 
	 * @param length
	 *            The length, for which to calculate the location.
	 * @param zoom
	 *            The zoom-factor, which to use on the location-value.
	 * @return The location for the given length and zoom-factor.
	 */
	public int getLocation(int length, double zoom) {
		if (locationType == LOCATION_TYPE_ABSOLUTE_START) {
			return (int) Math.round(locationValue * zoom);
		}
		if (locationType == LOCATION_TYPE_ABSOLUTE_END) {
			return length - (int) Math.round(locationValue * zoom);
		}
		if (locationType == LOCATION_TYPE_RELATIVE) {
			double ret = ((double) locationValue) / 100 * length;
			return (int) Math.round(ret);
		}
		throw new IllegalStateException("Unknown location type '" + locationType + "'"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Returns a new Color object for a given String, which defines the RGB values in hexadecimal format. This means, that the String must
	 * have a length of 6 characters. Example: <code>getColor("FF0000")</code> returns a red color.
	 * 
	 * @param hexRGBString
	 *            The RGB values in hexadecimal format.
	 * @return A new Color object for a given String, which defines the RGB values in hexadecimal format.
	 */
	public static Color getColor(final String hexRGBString) {
		assert (hexRGBString != null && hexRGBString.length() == 6);
		int red = 16 * hexToInt(hexRGBString.charAt(0)) + hexToInt(hexRGBString.charAt(1));
		int green = 16 * hexToInt(hexRGBString.charAt(2)) + hexToInt(hexRGBString.charAt(3));
		int blue = 16 * hexToInt(hexRGBString.charAt(4)) + hexToInt(hexRGBString.charAt(5));
		return new Color(null, red, green, blue);
	}

	/**
	 * Returns the integer-value for the given hexadecimal character [0-9, A-F, a-f].
	 * 
	 * @param hexChar
	 *            The hexadecimal character, for which to return the integer-value.
	 * @return The integer-value for the given hexadecimal character.
	 * @throws NumberFormatException
	 *             , if given character is not hexadecimal [0-9, A-F, a-f]
	 */
	private static int hexToInt(char hexChar) throws NumberFormatException {
		switch (hexChar) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case 'A':
			return 10;
		case 'B':
			return 11;
		case 'C':
			return 12;
		case 'D':
			return 13;
		case 'E':
			return 14;
		case 'F':
			return 15;
		case 'a':
			return 10;
		case 'b':
			return 11;
		case 'c':
			return 12;
		case 'd':
			return 13;
		case 'e':
			return 14;
		case 'f':
			return 15;
		}
		throw new NumberFormatException("Not a hexadecimal char: ascii-code=" + ((int) hexChar)); //$NON-NLS-1$
	}
}
