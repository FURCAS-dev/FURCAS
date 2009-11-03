package com.sap.mi.gfw.util;

/**
 * The IDs of the predefined rendering styles. See {@link GaUtil#setRenderingStyle(com.sap.mi.gfw.mm.pictograms.AbstractStyle, String)}.
 */
public interface IPredefinedRenderingStyle {

	/**
	 * The ID for a blue-to-white gradient with a gloss-effect.
	 */
	public static final String BLUE_WHITE_GLOSS_ID = "blue-white-gloss"; //$NON-NLS-1$

	/**
	 * The ID for a blue-to-white gradient.
	 */
	public static final String BLUE_WHITE_ID = "blue-white"; //$NON-NLS-1$

	/**
	 * The ID for a light yellow color.
	 */
	public static final String LIGHT_YELLOW_ID = "light-yellow"; //$NON-NLS-1$

	/**
	 * The ID for a light gray color.
	 */
	public static final String LIGHT_GRAY_ID = "light-gray"; //$NON-NLS-1$

	/**
	 * The ID for a copper-to-white gradient with a gloss-effect.
	 */
	public static final String COPPER_WHITE_GLOSS_ID = "copper-white-gloss"; //$NON-NLS-1$

	/**
	 * The ID for a silver-to-white gradient with a gloss-effect.
	 */
	public static final String SILVER_WHITE_GLOSS_ID = "silver-white-gloss"; //$NON-NLS-1$

	/**
	 * All IDs.
	 */
	public static final String[] ALL_IDS = new String[] { BLUE_WHITE_GLOSS_ID, BLUE_WHITE_ID, LIGHT_YELLOW_ID, LIGHT_GRAY_ID,
			COPPER_WHITE_GLOSS_ID, SILVER_WHITE_GLOSS_ID };

}
