package com.sap.mi.gfw.tb;

import com.sap.mi.gfw.datatypes.ILocation;

/**
 * The Class ImageRenderingDecorator.
 */
public class ImageRenderingDecorator extends AbstractRenderingDecorator implements ILocation {
	private static final int DEFAULT_LOCATION = 4;

	private String imageId;

	private int y = DEFAULT_LOCATION;

	private int x = DEFAULT_LOCATION;

	/**
	 * The Constructor.
	 * 
	 * @param imageId
	 *            the image id
	 */
	public ImageRenderingDecorator(String imageId) {
		super();
		setImageId(imageId);
	}

	/**
	 * Gets the image id.
	 * 
	 * @return the image id
	 */
	public String getImageId() {
		return imageId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.datatypes.ILocation#getX()
	 */
	public int getX() {
		return x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.datatypes.ILocation#getY()
	 */
	public int getY() {
		return y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.datatypes.ILocation#setX(int)
	 */
	public void setX(int x) {
		this.x = x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.datatypes.ILocation#setY(int)
	 */
	public void setY(int y) {
		this.y = y;
	}

	private void setImageId(String imageId) {
		this.imageId = imageId;
	}
}
