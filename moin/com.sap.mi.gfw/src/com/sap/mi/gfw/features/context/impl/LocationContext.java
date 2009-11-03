package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.ILocationContext;
import com.sap.mi.gfw.features.context.impl.base.DefaultContext;

/**
 * The Class LocationContext.
 */
public class LocationContext extends DefaultContext implements ILocationContext {

	private int x = -1;

	private int y = -1;

	/**
	 * The Constructor.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public LocationContext(int x, int y) {
		super();
		setLocation(x, y);
	}

	/**
	 * Instantiates a new location context.
	 */
	public LocationContext() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IContext#getX()
	 */
	public int getX() {
		return x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IContext#getY()
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the location.
	 * 
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Sets the x.
	 * 
	 * @param x
	 *            The x to set.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the y.
	 * 
	 * @param y
	 *            The y to set.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.impl.base.DefaultContext#toString()
	 */
	@Override
	public String toString() {
		String ret = super.toString();
		ret = ret + "(x=" + getX() + ", y=" + getY() + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return ret;
	}
}
