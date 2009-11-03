package com.sap.mi.tools.cockpit.editor.ui.dialog.legend;

import org.eclipse.swt.graphics.Image;

public interface ILegendElement {
	/**
	 *  @return the image representing the figure of this legend
	 */
	Image getFigureImage();
	

	/**
	 * 
	 * @return the description of this legend
	 */
	String getDescription();	
	
}