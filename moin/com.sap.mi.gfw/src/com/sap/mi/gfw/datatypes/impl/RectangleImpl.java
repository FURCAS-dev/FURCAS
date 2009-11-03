package com.sap.mi.gfw.datatypes.impl;

import com.sap.mi.gfw.datatypes.IAdvancedDimension;
import com.sap.mi.gfw.datatypes.IAdvancedLocation;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.datatypes.ILocation;
import com.sap.mi.gfw.datatypes.IRectangle;

public class RectangleImpl implements IRectangle {

	private IAdvancedDimension dimension = new DimensionImpl(0, 0);
	private IAdvancedLocation location = new LocationImpl(0, 0);

	public RectangleImpl(int width, int height) {
		this(0, 0, width, height);
	}

	public RectangleImpl(int x, int y, int width, int height) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

	public RectangleImpl(IRectangle other) {
		this(other.getX(), other.getY(), other.getWidth(), other.getHeight());
	}

	public int getHeight() {
		return getDimension().getHeight();
	}

	public int getWidth() {
		return getDimension().getWidth();
	}

	public void setHeight(int height) {
		getDimension().setHeight(height);
	}

	public void setWidth(int width) {
		getDimension().setWidth(width);
	}

	public int getX() {
		return getLocation().getX();
	}

	public int getY() {
		return getLocation().getY();
	}

	public void setX(int x) {
		getLocation().setX(x);
	}

	public void setY(int y) {
		getLocation().setY(y);
	}

	private IAdvancedDimension getDimension() {
		return dimension;
	}

	private IAdvancedLocation getLocation() {
		return location;
	}

	@Override
	public int hashCode() {
		return (getX() + getHeight() + 1) * (getY() + getWidth() + 1) ^ getX() ^ getY();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o instanceof RectangleImpl) {
			RectangleImpl r = (RectangleImpl) o;
			return (getX() == r.getX()) && (getY() == r.getY()) && (getWidth() == r.getWidth()) && (getHeight() == r.getHeight());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Rectangle(" + getX() + ", " + getY() + ", " + getWidth() + ", " + getHeight() + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}

	public IDimension expand(int dw, int dh) {
		return getDimension().expand(dw, dh);
	}

	public IDimension getDimensionCopy() {
		return getDimension().getDimensionCopy();
	}

	public void scale(double amount) {
		getDimension().scale(amount);
		getLocation().scale(amount);
	}

	public IDimension setDimension(int width, int height) {
		return getDimension().setDimension(width, height);
	}

	public IDimension setDimension(IDimension dimension) {
		return getDimension().setDimension(dimension);
	}

	public ILocation getLocationCopy() {
		return getLocation().getLocationCopy();
	}

	public ILocation setLocation(int x, int y) {
		return getLocation().setLocation(x, y);
	}

	public ILocation setLocation(ILocation location) {
		return getLocation().setLocation(location);
	}

	public ILocation translate(int dx, int dy) {
		return getLocation().translate(dx, dy);
	}

	public IRectangle getRectangleCopy() {
		return new RectangleImpl(this);
	}

	public void setRectangle(int x, int y, int width, int height) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

	public void setRectangle(IRectangle rectangle) {
		setRectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
	}

	public boolean contains(int x, int y) {
		return y >= getY() && y < getY() + getHeight() && x >= getX() && x < getX() + getWidth();
	}

	public boolean contains(ILocation location) {
		return contains(location.getX(), location.getY());
	}
}
