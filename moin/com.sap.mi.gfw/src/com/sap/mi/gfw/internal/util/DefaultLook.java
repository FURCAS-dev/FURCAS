package com.sap.mi.gfw.internal.util;

import java.awt.Color;

import com.sap.mi.gfw.util.ColorConstant;
import com.sap.mi.gfw.util.IColorConstant;
import com.sap.mi.gfw.util.ILook;

/**
 * The Class DefaultLook.
 */
public class DefaultLook implements ILook {

	private IColorConstant fieldErrorBackgroundColor;

	private IColorConstant gridBackgroundColor;

	private IColorConstant majorGridLineColor;

	private IColorConstant minorGridLineColor;

	public IColorConstant getFieldErrorBackgroundColor() {
		if (fieldErrorBackgroundColor == null) {
			// final Color decode = Color.decode("#FFFFFF");
			// fieldErrorBackgroundColor = new ColorConstant(decode.getRed(),
			// decode.getGreen(), decode.getBlue());
			fieldErrorBackgroundColor = IColorConstant.YELLOW;
		}
		return fieldErrorBackgroundColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.ILook#getGridBackgroundColor()
	 */
	public IColorConstant getGridBackgroundColor() {
		if (gridBackgroundColor == null) {
			final Color decode = Color.decode("#FFFFFF"); //$NON-NLS-1$
			gridBackgroundColor = new ColorConstant(decode.getRed(), decode.getGreen(), decode.getBlue());
		}
		return gridBackgroundColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.ILook#getGridLineThickness()
	 */
	public int getGridLineThickness() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.ILook#getMajorGridLineColor()
	 */
	public IColorConstant getMajorGridLineColor() {
		if (majorGridLineColor == null) {
			final Color decode = Color.decode("#CEE0F2"); //$NON-NLS-1$
			majorGridLineColor = new ColorConstant(decode.getRed(), decode.getGreen(), decode.getBlue());
		}
		return majorGridLineColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.ILook#getMajorGridLineDistance()
	 */
	public int getMajorGridLineDistance() {
		return 50;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.ILook#getMinorGridLineColor()
	 */
	public IColorConstant getMinorGridLineColor() {
		if (minorGridLineColor == null) {
			final Color decode = Color.decode("#E3EEF9"); //$NON-NLS-1$
			minorGridLineColor = new ColorConstant(decode.getRed(), decode.getGreen(), decode.getBlue());
		}
		return minorGridLineColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.util.ILook#getMinorGridLineDistance()
	 */
	public int getMinorGridLineDistance() {
		return 10;
	}
}
