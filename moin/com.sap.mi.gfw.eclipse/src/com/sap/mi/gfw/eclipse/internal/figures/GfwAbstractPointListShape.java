package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

import com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;

/**
 * An abstract class for those GFW Shapes, which are based on a list of points, e.g. polyline and polygon.
 * <p>
 * This abstract class only adds the point-list and the setter/getter methods for it. It also takes care to reset the bounds and repaint the
 * figure when the point-list changes. But it does not add any details how the Shape is outlined.
 */
public abstract class GfwAbstractPointListShape extends GfwAbstractShape {

	/**
	 * The point-list maintained in this Shape.
	 */
	private PointList points = new PointList();

	/**
	 * Creates a new GfwAbstractPointListShape.
	 * 
	 * @param pictogramElementDelegate
	 *            The PictogramElementDelegate which provides the GraphicsAlgorithm.
	 * @param graphicsAlgorithm
	 *            The GraphicsAlgorithm which provides the values to paint this Shape.
	 */
	public GfwAbstractPointListShape(IPictogramElementDelegate pictogramElementDelegate, GraphicsAlgorithm graphicsAlgorithm) {
		super(pictogramElementDelegate, graphicsAlgorithm);

		// initialize further values
		bounds = null;
	}

	// ================== methods to retrieve the point-list ==================

	/**
	 * Returns the points in this Shape <B>by reference</B>. If the returned list is modified, this Shape must be informed by calling
	 * {@link #setPoints(PointList)}. Failure to do so will result in layout and paint problems.
	 * 
	 * @return The points in this Shape <B>by reference</B>.
	 */
	public final PointList getPoints() {
		return points;
	}

	/**
	 * Returns the first point in the point-list.
	 * 
	 * @return the first point in the point-list.
	 */
	public Point getStart() {
		return points.getFirstPoint();
	}

	/**
	 * Returns the last point in the point-list.
	 * 
	 * @return the last point in the point-list.
	 */
	public Point getEnd() {
		return points.getLastPoint();
	}

	// =================== methods to change the point-list ===================

	/**
	 * Adds the passed point to the point-list. This method results in a recalculation of the Shapes bounding box.
	 * 
	 * @param pt
	 *            The Point to be added to the point-list.
	 */
	public void addPoint(Point pt) {
		points.addPoint(pt);
		bounds = null;
		repaint();
	}

	/**
	 * Inserts a given point at a specified index in the point-list. This method results in a recalculation of the Shapes bounding box.
	 * 
	 * @param pt
	 *            The point to be added.
	 * @param index
	 *            the position in the point-list where the point is to be added.
	 */
	public void insertPoint(Point pt, int index) {
		points.insertPoint(pt, index);
		bounds = null;
		repaint();
	}

	/**
	 * Overwrites the point at <code>index</code> with the Point <code>pt</code>. If you're going to set multiple Points, use
	 * {@link #setPoints(PointList)}. This method results in a recalculation of the Shapes bounding box.
	 * 
	 * @param pt
	 *            The point to set.
	 * @param index
	 *            The index, at which to set the point.
	 */
	public void setPoint(Point pt, int index) {
		erase();
		points.setPoint(pt, index);
		bounds = null;
		repaint();
	}

	/**
	 * Sets the list of points to be used by this Shape <b>by reference</b>. The previous PointList used by this Shape is not used anymore.
	 * This method results in a recalculation of the Shapes bounding box.
	 * 
	 * @param points
	 *            The new PointList used by this Shape.
	 */
	public void setPoints(PointList points) {
		erase();
		this.points = points;
		bounds = null;
		firePropertyChange(Connection.PROPERTY_POINTS, null, points);
		repaint();
	}

	/**
	 * Sets the start point of the point-list. This method results in a recalculation of the Shapes bounding box.
	 * 
	 * @param start
	 *            The point that will become the first point in the point-list.
	 */
	public void setStart(Point start) {
		if (points.size() == 0)
			addPoint(start);
		else
			setPoint(start, 0);
	}

	/**
	 * Sets the end point of the point-list. This method results in a recalculation of the Shapes bounding box.
	 * 
	 * @param end
	 *            The point that will become the last point in the point-list.
	 */
	public void setEnd(Point end) {
		if (points.size() < 2)
			addPoint(end);
		else
			setPoint(end, points.size() - 1);
	}

	/**
	 * Removes a point at a given index from the point-list. This method results in a recalculation of the Shapes bounding box.
	 * 
	 * @param index
	 *            The position of the point to be removed.
	 */
	public void removePoint(int index) {
		erase();
		bounds = null;
		points.removePoint(index);
	}

	/**
	 * This method results in a recalculation of the Shapes bounding box. Removes all points from the point-list.
	 */
	public void removeAllPoints() {
		erase();
		bounds = null;
		points.removeAllPoints();
	}
}
