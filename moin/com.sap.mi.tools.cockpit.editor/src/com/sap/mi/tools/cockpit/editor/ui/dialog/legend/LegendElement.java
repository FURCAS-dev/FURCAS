package com.sap.mi.tools.cockpit.editor.ui.dialog.legend;

import org.eclipse.swt.graphics.Image;

public class LegendElement implements ILegendElement{
	Image image;
	String description;
	
	/**
	 * Constructs legend element.
	 * 
	 * @param image the specified image 
	 * @param description the description of the image
	 */
	public LegendElement(Image image, String description) {
		this.image = image;
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see com.tssap.util.ui.dialog.legend.ILegendElement#getFigureImage()
	 */
	public Image getFigureImage() {
		return this.image;
	}

	/* (non-Javadoc)
	 * @see com.tssap.util.ui.dialog.legend.ILegendElement#getDescription()
	 */
	public String getDescription() {
		return this.description;
	}

}
