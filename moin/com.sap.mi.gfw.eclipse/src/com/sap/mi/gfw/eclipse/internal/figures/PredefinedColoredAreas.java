package com.sap.mi.gfw.eclipse.internal.figures;

import com.sap.mi.gfw.util.IPredefinedRenderingStyle;

/**
 * Predefined colored areas to be used in {@link GfwFigureUtil#paintColorFlow(Rectangle, Graphics, ColoredArea, boolean)}.
 */
public class PredefinedColoredAreas implements IPredefinedRenderingStyle {

	/**
	 * The style-adaptation to use for default elements.
	 */
	public static final int STYLE_ADAPTATION_DEFAULT = 0;

	/**
	 * The style-adaptation to use for primary selected elements.
	 */
	public static final int STYLE_ADAPTATION_PRIMARY_SELECTED = 1;

	/**
	 * The style-adaptation to use for secondary selected elements.
	 */
	public static final int STYLE_ADAPTATION_SECONDARY_SELECTED = 2;

	/**
	 * The style-adaptation to use to indicate that an action is allowed.
	 */
	public static final int STYLE_ADAPTATION_ACTION_ALLOWED = 3;

	/**
	 * The style-adaptation to use to indicate that an action is forbidden.
	 */
	public static final int STYLE_ADAPTATION_ACTION_FORBIDDEN = 4;

	// just added to this class for easier access
	private static final int LOCATION_TYPE_ABSOLUTE_START = ColoredLocation.LOCATION_TYPE_ABSOLUTE_START;

	// just added to this class for easier access
	private static final int LOCATION_TYPE_ABSOLUTE_END = ColoredLocation.LOCATION_TYPE_ABSOLUTE_END;

	/**
	 * The color-areas, which are used for default elements with the ID {@link #BLUE_WHITE_GLOSS_ID}.
	 */
	private static final ColoredArea[] BLUE_WHITE_GLOSS_DEFAULT_AREAS = new ColoredArea[] {
			getColoredArea("F8FBFE", 0, LOCATION_TYPE_ABSOLUTE_START, "F8FBFE", 1, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("EDF5FC", 1, LOCATION_TYPE_ABSOLUTE_START, "EDF5FC", 2, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("DEEDFA", 2, LOCATION_TYPE_ABSOLUTE_START, "DEEDFA", 3, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("D4E7F8", 3, LOCATION_TYPE_ABSOLUTE_START, "FAFBFC", 2, LOCATION_TYPE_ABSOLUTE_END), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("E2E5E9", 2, LOCATION_TYPE_ABSOLUTE_END, "E2E5E9", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for primary selected elements with the ID {@link #BLUE_WHITE_GLOSS_ID}.
	 */
	private static final ColoredArea[] BLUE_WHITE_GLOSS_PRIMARY_SELECTED_AREAS = new ColoredArea[] {
			getColoredArea("EEF6FD", 0, LOCATION_TYPE_ABSOLUTE_START, "EEF6FD", 1, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("D0E6F9", 1, LOCATION_TYPE_ABSOLUTE_START, "D0E6F9", 2, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("ACD2F4", 2, LOCATION_TYPE_ABSOLUTE_START, "ACD2F4", 3, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("81B9EA", 3, LOCATION_TYPE_ABSOLUTE_START, "AAD0F2", 2, LOCATION_TYPE_ABSOLUTE_END), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("9ABFE0", 2, LOCATION_TYPE_ABSOLUTE_END, "9ABFE0", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for secondary selected elements with the ID {@link #BLUE_WHITE_GLOSS_ID}.
	 */
	private static final ColoredArea[] BLUE_WHITE_GLOSS_SECONDARY_SELECTED_AREAS = new ColoredArea[] {
			getColoredArea("F5F9FE", 0, LOCATION_TYPE_ABSOLUTE_START, "F5F9FE", 1, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("E2EFFC", 1, LOCATION_TYPE_ABSOLUTE_START, "E2EFFC", 2, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("CBE3F9", 2, LOCATION_TYPE_ABSOLUTE_START, "CBE3F9", 3, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("BBDAF7", 3, LOCATION_TYPE_ABSOLUTE_START, "C5E0F7", 2, LOCATION_TYPE_ABSOLUTE_END), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("B2CDE5", 2, LOCATION_TYPE_ABSOLUTE_END, "B2CDE5", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for elements where an action is allowed with the ID {@link #BLUE_WHITE_GLOSS_ID}.
	 */
	private static final ColoredArea[] BLUE_WHITE_GLOSS_ACTION_ALLOWED_AREAS = new ColoredArea[] { //
	getColoredArea("99CC00", 0, LOCATION_TYPE_ABSOLUTE_START, "339966", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for elements where an action is forbidden with the ID {@link #BLUE_WHITE_GLOSS_ID}.
	 */
	private static final ColoredArea[] BLUE_WHITE_GLOSS_ACTION_FORBIDDEN_AREAS = new ColoredArea[] { //
	getColoredArea("FFCC00", 0, LOCATION_TYPE_ABSOLUTE_START, "FF6600", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for default elements with the ID {@link #BLUE_WHITE_ID}.
	 */
	private static final ColoredArea[] BLUE_WHITE_DEFAULT_AREAS = new ColoredArea[] { //
	getColoredArea("D4E7F8", 0, LOCATION_TYPE_ABSOLUTE_START, "FAFBFC", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for primary selected elements with the ID {@link #BLUE_WHITE_ID}.
	 */
	private static final ColoredArea[] BLUE_WHITE_PRIMARY_SELECTED_AREAS = new ColoredArea[] { //
	getColoredArea("81B9EA", 0, LOCATION_TYPE_ABSOLUTE_START, "AAD0F2", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for secondary selected elements with the ID {@link #BLUE_WHITE_ID}.
	 */
	private static final ColoredArea[] BLUE_WHITE_SECONDARY_SELECTED_AREAS = new ColoredArea[] { //
	getColoredArea("BBDAF7", 0, LOCATION_TYPE_ABSOLUTE_START, "C5E0F7", 0, LOCATION_TYPE_ABSOLUTE_END) }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for default elements with the ID {@link #LIGHT_YELLOW_ID}.
	 */
	private static final ColoredArea[] LIGHT_YELLOW_DEFAULT_AREAS = new ColoredArea[] { //
	getColoredArea("FEFEF4", 0, LOCATION_TYPE_ABSOLUTE_START, "FEFEF4", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for primary selected elements with the ID {@link #LIGHT_YELLOW_ID}.
	 */
	private static final ColoredArea[] LIGHT_YELLOW_PRIMARY_SELECTED_AREAS = new ColoredArea[] { //
	getColoredArea("E5E5C2", 0, LOCATION_TYPE_ABSOLUTE_START, "E5E5C2", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for secondary selected elements with the ID {@link #LIGHT_YELLOW_ID}.
	 */
	private static final ColoredArea[] LIGHT_YELLOW_SECONDARY_SELECTED_AREAS = new ColoredArea[] { //
	getColoredArea("FAFAD9", 0, LOCATION_TYPE_ABSOLUTE_START, "FAFAD9", 0, LOCATION_TYPE_ABSOLUTE_END) }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for default elements with the ID {@link #LIGHT_GRAY_ID}.
	 */
	private static final ColoredArea[] LIGHT_GRAY_DEFAULT_AREAS = new ColoredArea[] { //
	getColoredArea("F5F5ED", 0, LOCATION_TYPE_ABSOLUTE_START, "F5F5ED", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for primary selected elements with the ID {@link #LIGHT_GRAY_ID}.
	 */
	private static final ColoredArea[] LIGHT_GRAY_PRIMARY_SELECTED_AREAS = new ColoredArea[] { //
	getColoredArea("D6D6D0", 0, LOCATION_TYPE_ABSOLUTE_START, "D6D6D0", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for secondary selected elements with the ID {@link #LIGHT_GRAY_ID}.
	 */
	private static final ColoredArea[] LIGHT_GRAY_SECONDARY_SELECTED_AREAS = new ColoredArea[] { //
	getColoredArea("E5E5Df", 0, LOCATION_TYPE_ABSOLUTE_START, "E5E5Df", 0, LOCATION_TYPE_ABSOLUTE_END) }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for default elements with the ID {@link #COPPER_WHITE_GLOSS_ID}.
	 */
	private static final ColoredArea[] COPPER_WHITE_GLOSS_DEFAULT_AREAS = new ColoredArea[] {
			getColoredArea("F9F5F2", 0, LOCATION_TYPE_ABSOLUTE_START, "F9F5F2", 1, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("EDE0D8", 1, LOCATION_TYPE_ABSOLUTE_START, "EDE0D8", 2, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("E4D0C4", 2, LOCATION_TYPE_ABSOLUTE_START, "F5F0E8", 2, LOCATION_TYPE_ABSOLUTE_END), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("E6DDD0", 2, LOCATION_TYPE_ABSOLUTE_END, "E6DDD0", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The color-areas, which are used for default elements with the ID {@link #SILVER_WHITE_GLOSS_ID}.
	 */
	private static final ColoredArea[] SILVER_WHITE_GLOSS_DEFAULT_AREAS = new ColoredArea[] {
			getColoredArea("EEEEED", 0, LOCATION_TYPE_ABSOLUTE_START, "EEEEED", 1, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("E1E1E0", 1, LOCATION_TYPE_ABSOLUTE_START, "E1E1E0", 2, LOCATION_TYPE_ABSOLUTE_START), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("D2D1CF", 2, LOCATION_TYPE_ABSOLUTE_START, "F2F0EF", 2, LOCATION_TYPE_ABSOLUTE_END), //$NON-NLS-1$ //$NON-NLS-2$
			getColoredArea("DFDEDD", 2, LOCATION_TYPE_ABSOLUTE_END, "DFDEDD", 0, LOCATION_TYPE_ABSOLUTE_END), }; //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Returns the color-areas for the given ID. The ID must be one of those defined in this class.
	 * 
	 * @param id
	 *            The ID for which to return the color-areas.
	 * @return The color-areas for the given ID.
	 */
	public static ColoredArea[] getColoredAreas(String id, int styleAdaptation) {
		// default, needed for backward compatibility, because in old models the
		// id is null
		if (id == null) {
			id = BLUE_WHITE_GLOSS_ID;
		}

		if (BLUE_WHITE_GLOSS_ID.equals(id)) {
			if (styleAdaptation == STYLE_ADAPTATION_PRIMARY_SELECTED)
				return BLUE_WHITE_GLOSS_PRIMARY_SELECTED_AREAS;
			if (styleAdaptation == STYLE_ADAPTATION_SECONDARY_SELECTED)
				return BLUE_WHITE_GLOSS_SECONDARY_SELECTED_AREAS;
			if (styleAdaptation == STYLE_ADAPTATION_ACTION_ALLOWED)
				return BLUE_WHITE_GLOSS_ACTION_ALLOWED_AREAS;
			if (styleAdaptation == STYLE_ADAPTATION_ACTION_FORBIDDEN)
				return BLUE_WHITE_GLOSS_ACTION_FORBIDDEN_AREAS;
			return BLUE_WHITE_GLOSS_DEFAULT_AREAS;
		}
		if (BLUE_WHITE_ID.equals(id)) {
			if (styleAdaptation == STYLE_ADAPTATION_PRIMARY_SELECTED)
				return BLUE_WHITE_PRIMARY_SELECTED_AREAS;
			if (styleAdaptation == STYLE_ADAPTATION_SECONDARY_SELECTED)
				return BLUE_WHITE_SECONDARY_SELECTED_AREAS;
			return BLUE_WHITE_DEFAULT_AREAS;
		}
		if (LIGHT_YELLOW_ID.equals(id)) {
			if (styleAdaptation == STYLE_ADAPTATION_PRIMARY_SELECTED)
				return LIGHT_YELLOW_PRIMARY_SELECTED_AREAS;
			if (styleAdaptation == STYLE_ADAPTATION_SECONDARY_SELECTED)
				return LIGHT_YELLOW_SECONDARY_SELECTED_AREAS;
			return LIGHT_YELLOW_DEFAULT_AREAS;
		}
		if (LIGHT_GRAY_ID.equals(id)) {
			if (styleAdaptation == STYLE_ADAPTATION_PRIMARY_SELECTED)
				return LIGHT_GRAY_PRIMARY_SELECTED_AREAS;
			if (styleAdaptation == STYLE_ADAPTATION_SECONDARY_SELECTED)
				return LIGHT_GRAY_SECONDARY_SELECTED_AREAS;
			return LIGHT_GRAY_DEFAULT_AREAS;
		}
		if (COPPER_WHITE_GLOSS_ID.equals(id)) {
			return COPPER_WHITE_GLOSS_DEFAULT_AREAS;
		}
		if (SILVER_WHITE_GLOSS_ID.equals(id)) {
			return SILVER_WHITE_GLOSS_DEFAULT_AREAS;
		}
		throw new IllegalArgumentException("Unsupported ID '" + id + "'"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Returns a new colored-area for the given parameters. Have a look at {@link ColoredLocation} for a further explanation of the
	 * parameters.
	 * 
	 * @return A new colored-area for the given parameters.
	 */
	private static ColoredArea getColoredArea(String startColor, int startLocation, int startType, String endColor, int endLocation,
			int endType) {
		ColoredLocation startColoredLocation = new ColoredLocation(startColor, startLocation, startType);
		ColoredLocation endColoredLocation = new ColoredLocation(endColor, endLocation, endType);
		return new ColoredArea(startColoredLocation, endColoredLocation);
	}
}
