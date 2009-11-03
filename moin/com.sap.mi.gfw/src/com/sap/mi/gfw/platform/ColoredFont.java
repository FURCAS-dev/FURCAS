package com.sap.mi.gfw.platform;

import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.pictograms.Font;

/**
 * The Class ColoredFont.
 */
public class ColoredFont {

	private Font font;
	private Color color;

	/**
	 * Instantiates a new colored font.
	 * 
	 * @param font
	 *            the font
	 * @param color
	 *            the color
	 */
	public ColoredFont(Font font, Color color) {
		super();
		setFont(font);
		setColor(color);
	}

	/**
	 * Gets the color.
	 * 
	 * @return Returns the color.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Gets the font.
	 * 
	 * @return Returns the font.
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * Sets the color.
	 * 
	 * @param color
	 *            The color to set.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Sets the font.
	 * 
	 * @param font
	 *            The font to set.
	 */
	public void setFont(Font font) {
		this.font = font;
	}

}
