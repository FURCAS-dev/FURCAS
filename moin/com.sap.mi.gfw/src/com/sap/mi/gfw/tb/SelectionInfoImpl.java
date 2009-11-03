package com.sap.mi.gfw.tb;

import com.sap.mi.gfw.mm.pictograms.LineStyleEnum;
import com.sap.mi.gfw.util.IColorConstant;

/**
 * The Class SelectionInfoImpl.
 */
public class SelectionInfoImpl implements ISelectionInfo {

	private IColorConstant color;

	private IColorConstant handleForegroundColor;

	private IColorConstant handleBackgroundColor;

	private LineStyleEnum lineStyle;

	/**
	 * Instantiates a new selection info impl.
	 * 
	 * @param color
	 *            the color
	 * @param handleForegroundColor
	 *            the handle foreground color
	 * @param handleBackgroundColor
	 *            the handle background color
	 * @param lineStyle
	 *            the line style
	 */
	public SelectionInfoImpl(IColorConstant color, IColorConstant handleForegroundColor, IColorConstant handleBackgroundColor,
			LineStyleEnum lineStyle) {

		setColor(color);
		setHandleForegroundColor(handleForegroundColor);
		setHandleBackgroundColor(handleBackgroundColor);
		setLineStyle(lineStyle);
	}

	/**
	 * Instantiates a new selection info impl.
	 */
	public SelectionInfoImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.ISelectionInfo#getColor()
	 */
	public IColorConstant getColor() {
		return color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.ISelectionInfo#getHandleForegroundColor()
	 */
	public IColorConstant getHandleForegroundColor() {
		return handleForegroundColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.ISelectionInfo#setHandleForegroundColor(com.sap.mi.gfw.util.IColorConstant)
	 */
	public void setHandleForegroundColor(IColorConstant handleForegroundColor) {
		this.handleForegroundColor = handleForegroundColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.ISelectionInfo#getHandleBackgroundColor()
	 */
	public IColorConstant getHandleBackgroundColor() {
		return handleBackgroundColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.ISelectionInfo#setHandleBackgroundColor(com.sap.mi.gfw.util.IColorConstant)
	 */
	public void setHandleBackgroundColor(IColorConstant handleBackgroundColor) {
		this.handleBackgroundColor = handleBackgroundColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.ISelectionInfo#getLineStyle()
	 */
	public LineStyleEnum getLineStyle() {
		return lineStyle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.ISelectionInfo#setLineStyle(com.sap.mi.gfw.mm.pictograms.LineStyleEnum)
	 */
	public void setLineStyle(LineStyleEnum lineStyle) {
		this.lineStyle = lineStyle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.tb.ISelectionInfo#setColor(com.sap.mi.gfw.util.IColorConstant)
	 */
	public void setColor(IColorConstant color) {
		this.color = color;
	}
}
