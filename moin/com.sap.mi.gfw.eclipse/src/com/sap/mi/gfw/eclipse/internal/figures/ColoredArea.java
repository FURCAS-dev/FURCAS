package com.sap.mi.gfw.eclipse.internal.figures;

/**
 * This class is used to combine a start colored-location and an end colored-location. It can be used to draw a color-gradient from the
 * start-location to the end-location (see
 * {@link GfwFigureUtil#paintColorFlow(org.eclipse.draw2d.geometry.Rectangle, org.eclipse.draw2d.Graphics, ColoredArea, double, boolean)}).
 */
public class ColoredArea {

	/**
	 * The start colored-location set in the constructor.
	 */
	private ColoredLocation start;

	/**
	 * The end colored-location set in the constructor.
	 */
	private ColoredLocation end;

	/**
	 * Creates a new ColoredArea.
	 * 
	 * @param start
	 *            The start colored-location.
	 * @param end
	 *            The end colored-location.
	 */
	public ColoredArea(ColoredLocation start, ColoredLocation end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * Returns the start colored-location.
	 * 
	 * @return The start colored-location.
	 */
	public ColoredLocation getStart() {
		return start;
	}

	/**
	 * Returns the end colored-location.
	 * 
	 * @return The end colored-location.
	 */
	public ColoredLocation getEnd() {
		return end;
	}

	/**
	 * Returns colored-areas, which are calculated from the given colored-locations. The idea is, that the end color-location and the
	 * following start color-location are identical, which gives the impression of a seemless color-gradient.
	 * 
	 * @param location
	 *            The colored-locations, from which to calculate the colored-areas.
	 * @return colored-areas, which are calculated from the given colored-locations.
	 */
	public static ColoredArea[] getSeemlessArea(ColoredLocation location[]) {
		if (location.length <= 1) {
			return new ColoredArea[0];
		}

		ColoredArea ret[] = new ColoredArea[location.length - 1];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = new ColoredArea(location[i], location[i + 1]);
		}
		return ret;
	}
}
