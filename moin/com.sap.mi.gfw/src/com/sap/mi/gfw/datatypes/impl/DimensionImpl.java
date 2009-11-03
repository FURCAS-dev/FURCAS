package com.sap.mi.gfw.datatypes.impl;

import com.sap.mi.gfw.datatypes.IAdvancedDimension;
import com.sap.mi.gfw.datatypes.IDimension;

/**
 * The Class DimensionImpl.
 */
public class DimensionImpl implements IAdvancedDimension {

	private int width;

	private int height;

	public DimensionImpl(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	public DimensionImpl(IDimension dimension) {
		this(dimension.getWidth(), dimension.getHeight());
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o instanceof DimensionImpl) {
			DimensionImpl d = (DimensionImpl) o;
			return d.width == width && d.height == height;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (width * height) ^ (width + height);
	}

	@Override
	public String toString() {
		return "Dimension(" + width + ", " + height + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public IDimension getDimensionCopy() {
		return new DimensionImpl(this);
	}

	public IDimension setDimension(int width, int height) {
		this.width = width;
		this.height = height;
		return this;
	}

	public IDimension setDimension(IDimension dimension) {
		return setDimension(dimension.getWidth(), dimension.getHeight());
	}

	public void scale(double amount) {
		width = (int) Math.floor(width * amount);
		height = (int) Math.floor(height * amount);
	}

	public IDimension expand(int dw, int dh) {
		width += dw;
		height += dh;
		return this;
	}
}
