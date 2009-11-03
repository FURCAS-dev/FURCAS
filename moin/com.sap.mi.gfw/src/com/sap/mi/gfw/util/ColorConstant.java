package com.sap.mi.gfw.util;

/**
 * The Class ColorConstant.
 */
public class ColorConstant implements IColorConstant {

	private int red;

	private int green;

	private int blue;

	/**
	 * Constructs a new instance of this class given the desired red, green and blue values expressed as ints in the range 0 to 255 (where 0
	 * is black and 255 is full brightness).
	 * 
	 * @param red
	 *            the amount of red in the color
	 * @param green
	 *            the amount of green in the color
	 * @param blue
	 *            the amount of blue in the color
	 */
	public ColorConstant(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.IColorConstant#getRed()
	 */
	public int getRed() {
		return red;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.IColorConstant#getGreen()
	 */
	public int getGreen() {
		return green;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.IColorConstant#getBlue()
	 */
	public int getBlue() {
		return blue;
	}

}
