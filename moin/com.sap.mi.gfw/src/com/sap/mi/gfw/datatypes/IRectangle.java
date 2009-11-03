package com.sap.mi.gfw.datatypes;

public interface IRectangle extends IDimension, ILocation {

	public IRectangle getRectangleCopy();

	public void setRectangle(int x, int y, int width, int height);

	public void setRectangle(IRectangle rectangle);

	public boolean contains(int x, int y);

	public boolean contains(ILocation location);
}
