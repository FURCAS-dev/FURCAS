package com.sap.mi.gfw.util;

/**
 * The Interface IColorConstant.
 */
public interface IColorConstant {

	/**
	 * some pre-defined colors.
	 */
	IColorConstant WHITE = new ColorConstant(255, 255, 255);

	/**
	 * The LIGH t_ ligh t_ gray.
	 */
	IColorConstant LIGHT_LIGHT_GRAY = new ColorConstant(250, 250, 250);

	/**
	 * The LIGH t_ gray.
	 */
	IColorConstant LIGHT_GRAY = new ColorConstant(192, 192, 192);

	/**
	 * The GRAY.
	 */
	IColorConstant GRAY = new ColorConstant(128, 128, 128);

	/**
	 * The DAR k_ gray.
	 */
	IColorConstant DARK_GRAY = new ColorConstant(64, 64, 64);

	/**
	 * The BLACK.
	 */
	IColorConstant BLACK = new ColorConstant(0, 0, 0);

	/**
	 * The RED.
	 */
	IColorConstant RED = new ColorConstant(255, 0, 0);

	/**
	 * The ORANGE.
	 */
	IColorConstant ORANGE = new ColorConstant(255, 196, 0);

	/**
	 * The YELLOW.
	 */
	IColorConstant YELLOW = new ColorConstant(255, 255, 0);

	/**
	 * The GREEN.
	 */
	IColorConstant GREEN = new ColorConstant(0, 255, 0);

	/**
	 * The LIGH t_ green.
	 */
	IColorConstant LIGHT_GREEN = new ColorConstant(96, 255, 96);

	/**
	 * The DAR k_ green.
	 */
	IColorConstant DARK_GREEN = new ColorConstant(0, 127, 0);

	/**
	 * The CYAN.
	 */
	IColorConstant CYAN = new ColorConstant(0, 255, 255);

	/**
	 * The LIGH t_ blue.
	 */
	IColorConstant LIGHT_BLUE = new ColorConstant(127, 127, 255);

	/**
	 * The BLUE.
	 */
	IColorConstant BLUE = new ColorConstant(0, 0, 255);

	/**
	 * The DAR k_ blue.
	 */
	IColorConstant DARK_BLUE = new ColorConstant(0, 0, 127);

	// === Colors aligned with Visual Composer ===

	// Color Style: BLUE
	/**
	 * The V c_ ver y_ ligh t_ blue.
	 */
	IColorConstant VC_VERY_LIGHT_BLUE = new ColorConstant(245, 247, 250);

	/**
	 * The V c_ ligh t_ blue.
	 */
	IColorConstant VC_LIGHT_BLUE = new ColorConstant(224, 231, 247);

	/**
	 * The V c_ mediu m_ blue.
	 */
	IColorConstant VC_MEDIUM_BLUE = new ColorConstant(176, 192, 216);

	/**
	 * The V c_ dar k_ blue.
	 */
	IColorConstant VC_DARK_BLUE = new ColorConstant(51, 102, 153);

	// Color Style: GREY
	/**
	 * The V c_ ligh t_ grey.
	 */
	IColorConstant VC_LIGHT_GREY = new ColorConstant(221, 221, 221);

	/**
	 * The V c_ mediu m_ grey.
	 */
	IColorConstant VC_MEDIUM_GREY = new ColorConstant(178, 178, 178);

	/**
	 * The V c_ dar k_ grey.
	 */
	IColorConstant VC_DARK_GREY = new ColorConstant(77, 77, 77);

	// Color Style: PURPLE
	/**
	 * The V c_ ligh t_ purple.
	 */
	IColorConstant VC_LIGHT_PURPLE = new ColorConstant(242, 242, 255);

	/**
	 * The V c_ mediu m_ purple.
	 */
	IColorConstant VC_MEDIUM_PURPLE = new ColorConstant(223, 223, 255);

	/**
	 * The V c_ dar k_ purple.
	 */
	IColorConstant VC_DARK_PURPLE = new ColorConstant(139, 157, 213);

	// Color Style: GREEN
	/**
	 * The V c_ ver y_ ligh t_ green.
	 */
	IColorConstant VC_VERY_LIGHT_GREEN = new ColorConstant(242, 247, 242);

	/**
	 * The V c_ ligh t_ green.
	 */
	IColorConstant VC_LIGHT_GREEN = new ColorConstant(179, 217, 179);

	/**
	 * The V c_ mediu m_ green.
	 */
	IColorConstant VC_MEDIUM_GREEN = new ColorConstant(111, 149, 111);

	/**
	 * The V c_ dar k_ green.
	 */
	IColorConstant VC_DARK_GREEN = new ColorConstant(0, 102, 0);

	// Color Style: BROWN
	/**
	 * The V c_ ligh t_ brown.
	 */
	IColorConstant VC_LIGHT_BROWN = new ColorConstant(213, 214, 189);

	/**
	 * The V c_ mediu m_ brown.
	 */
	IColorConstant VC_MEDIUM_BROWN = new ColorConstant(162, 149, 126);

	/**
	 * The V c_ dar k_ brown.
	 */
	IColorConstant VC_DARK_BROWN = new ColorConstant(147, 128, 88);

	// Color Style: ORANGE
	/**
	 * The V c_ ligh t_ orange.
	 */
	IColorConstant VC_LIGHT_ORANGE = new ColorConstant(252, 207, 153);

	/**
	 * The V c_ mediu m_ orange.
	 */
	IColorConstant VC_MEDIUM_ORANGE = new ColorConstant(255, 153, 51);

	/**
	 * The V c_ dar k_ orange.
	 */
	IColorConstant VC_DARK_ORANGE = new ColorConstant(187, 102, 0);

	// Color Style: BEIGE
	/**
	 * The V c_ ligh t_ beige.
	 */
	IColorConstant VC_LIGHT_BEIGE = new ColorConstant(255, 238, 221);

	/**
	 * The V c_ mediu m_ beige.
	 */
	IColorConstant VC_MEDIUM_BEIGE = new ColorConstant(255, 219, 181);

	/**
	 * The V c_ dar k_ beige.
	 */
	IColorConstant VC_DARK_BEIGE = new ColorConstant(254, 192, 164);

	// Color Style: GREYISH-BLUE
	/**
	 * The V c_ ligh t_ greyis h_ blue.
	 */
	IColorConstant VC_LIGHT_GREYISH_BLUE = new ColorConstant(222, 231, 239);

	/**
	 * The V c_ mediu m_ greyis h_ blue.
	 */
	IColorConstant VC_MEDIUM_GREYISH_BLUE = new ColorConstant(199, 208, 217);

	/**
	 * The V c_ dar k_ greyis h_ blue.
	 */
	IColorConstant VC_DARK_GREYISH_BLUE = new ColorConstant(113, 131, 152);

	// selection and selection handles
	/**
	 * The HANDL e_ fg.
	 */
	IColorConstant HANDLE_FG = VC_DARK_ORANGE;

	/**
	 * The HANDL e_ bg.
	 */
	IColorConstant HANDLE_BG = VC_MEDIUM_ORANGE;

	/**
	 * The SHAP e_ selectio n_ fg.
	 */
	IColorConstant SHAPE_SELECTION_FG = VC_LIGHT_ORANGE;

	/**
	 * The CONNECTIO n_ selectio n_ fg.
	 */
	IColorConstant CONNECTION_SELECTION_FG = VC_MEDIUM_ORANGE;

	/**
	 * Returns the amount of red in the color, from 0 to 255.
	 * 
	 * @return the red component of the color
	 */
	int getRed();

	/**
	 * Returns the amount of green in the color, from 0 to 255.
	 * 
	 * @return the green component of the color
	 */
	int getGreen();

	/**
	 * Returns the amount of blue in the color, from 0 to 255.
	 * 
	 * @return the blue component of the color
	 */
	int getBlue();
}
