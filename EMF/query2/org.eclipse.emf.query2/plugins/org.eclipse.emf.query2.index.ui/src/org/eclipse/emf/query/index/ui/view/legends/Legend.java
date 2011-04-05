package org.eclipse.emf.query.index.ui.view.legends;

import org.eclipse.swt.graphics.Image;

public class Legend implements ILegend {

	private Image mImage;
	private String mDescription;
	
	public Legend(Image image, String description) {
		super();
		mImage = image;
		mDescription = description;
	}

	public String getDescription() {
		return mDescription;
	}

	public Image getImage() {
		return mImage;
	}
	
}


