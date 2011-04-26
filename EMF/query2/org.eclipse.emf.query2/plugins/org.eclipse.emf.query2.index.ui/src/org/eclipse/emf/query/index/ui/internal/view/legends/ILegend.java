package org.eclipse.emf.query.index.ui.internal.view.legends;

import org.eclipse.swt.graphics.Image;

public interface ILegend {

	/**
	 *  @return the image representing the figure of this legend
	 */
	Image getImage();
	
	
	/**
	 * 
	 * @return the description of this legend
	 */
	String getDescription();
	
}
