package com.sap.mi.gfw.tb;

import com.sap.mi.gfw.mm.pictograms.LineStyleEnum;
import com.sap.mi.gfw.util.IColorConstant;

/**
 * The Interface ISelectionInfo.
 */
public interface ISelectionInfo {

	/**
	 * Gets the color.
	 * 
	 * @return the color of the selection border
	 */
	IColorConstant getColor();

	/**
	 * Gets the handle foreground color.
	 * 
	 * @return the foreground color of the selection handle
	 */
	IColorConstant getHandleForegroundColor();

	/**
	 * Gets the handle background color.
	 * 
	 * @return the background color of the selection handle
	 */
	IColorConstant getHandleBackgroundColor();

	/**
	 * Gets the line style.
	 * 
	 * @return the line style of the selection
	 */
	LineStyleEnum getLineStyle();

	/**
	 * set the color of the selection.
	 * 
	 * @param color
	 *            the color
	 */
	void setColor(IColorConstant color);

	/**
	 * set the foreground color of the selection handle.
	 * 
	 * @param color
	 *            the color
	 */
	void setHandleForegroundColor(IColorConstant color);

	/**
	 * set the background color of the selection handle.
	 * 
	 * @param color
	 *            the color
	 */
	void setHandleBackgroundColor(IColorConstant color);

	/**
	 * set the line style of the selection.
	 * 
	 * @param lineStyle
	 *            the line style
	 */
	void setLineStyle(LineStyleEnum lineStyle);

}
