package com.sap.mi.gfw.eclipse.internal.util.draw2d;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

public interface GFColorConstants extends ColorConstants {

	// === Colors aligned with Visual Composer ===

	// Color Style: BLUE
	public static final Color VERY_LIGHT_BLUE = new Color(null, 245, 247, 250);

	public static final Color LIGHT_BLUE = new Color(null, 224, 231, 247);

	public static final Color MEDIUM_BLUE = new Color(null, 176, 192, 216);

	public static final Color DARK_BLUE = new Color(null, 51, 102, 153);

	// Color Style: GREY
	public static final Color LIGHT_GREY = new Color(null, 221, 221, 221);

	public static final Color MEDIUM_GREY = new Color(null, 178, 178, 178);

	public static final Color DARK_GREY = new Color(null, 77, 77, 77);

	// Color Style: PURPLE
	public static final Color LIGHT_PURPLE = new Color(null, 242, 242, 255);

	public static final Color MEDIUM_PURPLE = new Color(null, 223, 223, 255);

	public static final Color DARK_PURPLE = new Color(null, 139, 157, 213);

	// Color Style: GREEN
	public static final Color VERY_LIGHT_GREEN = new Color(null, 242, 247, 242);

	public static final Color LIGHT_GREEN = new Color(null, 179, 217, 179);

	public static final Color MEDIUM_GREEN = new Color(null, 111, 149, 111);

	public static final Color DARK_GREEN = new Color(null, 0, 102, 0);

	// Color Style: BROWN
	public static final Color LIGHT_BROWN = new Color(null, 213, 214, 189);

	public static final Color MEDIUM_BROWN = new Color(null, 162, 149, 126);

	public static final Color DARK_BROWN = new Color(null, 147, 128, 88);

	// Color Style: ORANGE
	public static final Color LIGHT_ORANGE = new Color(null, 252, 207, 153);

	public static final Color MEDIUM_ORANGE = new Color(null, 255, 153, 51);

	public static final Color DARK_ORANGE = new Color(null, 187, 102, 0);

	// Color Style: BEIGE
	public static final Color LIGHT_BEIGE = new Color(null, 255, 238, 221);

	public static final Color MEDIUM_BEIGE = new Color(null, 255, 219, 181);

	public static final Color DARK_BEIGE = new Color(null, 254, 192, 164);

	// Color Style: GREYISH-BLUE
	public static final Color LIGHT_GREYISH_BLUE = new Color(null, 222, 231, 239);

	public static final Color MEDIUM_GREYISH_BLUE = new Color(null, 199, 208, 217);

	public static final Color DARK_GREYISH_BLUE = new Color(null, 113, 131, 152);

	// === GFW System Colors ===

	public static final Color TOOLTIP_FG = tooltipBackground; // LIGHT_BEIGE;

	public static final Color TOOLTIP_BG = tooltipBackground; // LIGHT_ORANGE;

	public static final Color HANDLE_FG_LIGHT = LIGHT_ORANGE;

	public static final Color HANDLE_FG = DARK_ORANGE;

	public static final Color HANDLE_BG = MEDIUM_ORANGE;

	public static final Color BUTTON_FG = MEDIUM_ORANGE;

	public static final Color BUTTON_BG = MEDIUM_BEIGE;
}
