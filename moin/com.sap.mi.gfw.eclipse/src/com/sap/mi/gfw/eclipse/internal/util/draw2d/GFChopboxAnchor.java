package com.sap.mi.gfw.eclipse.internal.util.draw2d;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polygon;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;

import com.sap.mi.gfw.eclipse.internal.figures.GfwEllipse;
import com.sap.mi.gfw.eclipse.internal.figures.GfwEllipseDecoration;
import com.sap.mi.gfw.eclipse.internal.figures.GfwPolygon;
import com.sap.mi.gfw.eclipse.internal.figures.GfwPolyline;

/**
 * A chopbox anchor supporting insets
 */
public class GFChopboxAnchor extends ChopboxAnchorFixed {

	public GFChopboxAnchor(IFigure figure) {
		super(figure);
	}

	/**
	 * Gets the anchors associated figure's bounding box in absolute coordinates.
	 * 
	 * @return a <code>Rectangle</code> that is the bounding box of the owner figure in absolute coordinates. also regards the indents
	 */
	@Override
	protected Rectangle getBox() {
		if (getOwner() instanceof HandleBounds) {
			return ((HandleBounds) getOwner()).getHandleBounds().getCopy();
		}

		return getOwner().getBounds().getCopy();
	}

	@Override
	public Point getLocation(Point reference) {

		if (getOwner() instanceof GfwEllipse || getOwner() instanceof GfwEllipseDecoration || getOwner() instanceof Ellipse) {
			Rectangle r = Rectangle.SINGLETON;
			r.setBounds(getBox()); // r.setBounds(getOwner().getBounds().getCropped(getOwner().getInsets()));
			r.translate(-1, -1);
			r.resize(1, 1);
			getOwner().translateToAbsolute(r);

			Point ref = r.getCenter().negate().translate(reference);

			if (ref.x == 0)
				return new Point(reference.x, (ref.y > 0) ? r.bottom() : r.y);
			if (ref.y == 0)
				return new Point((ref.x > 0) ? r.right() : r.x, reference.y);

			float dx = (ref.x > 0) ? 0.5f : -0.5f;
			float dy = (ref.y > 0) ? 0.5f : -0.5f;

			// ref.x, ref.y, r.width, r.height != 0 => safe to proceed

			float k = (float) (ref.y * r.width) / (ref.x * r.height);
			k = k * k;

			return r.getCenter().translate((int) (r.width * dx / Math.sqrt(1 + k)), (int) (r.height * dy / Math.sqrt(1 + 1 / k)));
		}
		if (getOwner() instanceof GfwPolygon || getOwner() instanceof Polygon || getOwner() instanceof GfwPolyline
				|| getOwner() instanceof Polyline) {

			Point foreignReference = reference.getCopy();

			// the midpoint
			Point ownReference = getReferencePoint().getCopy();

			// nice feature!
			// ownReference = normalizeToStraightlineTolerance(foreignReference,
			// ownReference, STRAIGHT_LINE_TOLERANCE);

			Point location = getLocation(ownReference, foreignReference);
			if (location == null || getBox().expand(1, 1).contains(foreignReference) && !getBox().shrink(1, 1).contains(foreignReference))
				location = getLocation(getBox().getCenter(), foreignReference);

			if (location == null) {
				location = getBox().getCenter();
			}

			return location;
		}

		return super.getLocation(reference);

	}

	/**
	 * Calculates the location of the anchor depending on the anchors own reference and foreign reference points
	 * 
	 * @param ownReference
	 *            - the own reference of the anchor
	 * @param foreignReference
	 *            - foreign reference that comes in
	 * @return the location of the anchor depending on the anchors own reference and foreign reference points
	 */
	protected Point getLocation(Point ownReference, Point foreignReference) {
		PointList intersections = getIntersectionPoints(ownReference, foreignReference);

		if (intersections != null && intersections.size() != 0) {
			Point location = pickClosestPoint(intersections, foreignReference);
			return location;
		}
		return null;
	}

	/**
	 * Assumption: Points in the <Code>PointList</Code> and <Code>Point</Code> p lie on the same line. Returns the <Code>Point</Code> from
	 * the <Code>PointList</Code> closest to
	 * 
	 * @param p
	 * @param points
	 *            - the list of points to select the result from
	 * @param p
	 *            - the point to which the closest point must be found
	 * @return the <Code>Point</Code> from the <Code>PointList</Code> closest to
	 * @param p
	 */
	public static Point pickClosestPoint(PointList points, Point p) {
		Point result = points.getFirstPoint();
		for (int i = 1; i < points.size(); i++) {
			Point temp = points.getPoint(i);
			if (Math.abs(temp.x - p.x) < Math.abs(result.x - p.x))
				result = temp;
			else if (Math.abs(temp.y - p.y) < Math.abs(result.y - p.y))
				result = temp;
		}
		return result;
	}

	/**
	 * Calculates intersection points of the figure and the line that passes through ownReference and foreignReference points
	 * 
	 * @param ownReference
	 *            the reference <code>Point</code> on or inside the shape that is being anchored to.
	 * @param foreignReference
	 *            the outside reference <code>Point</code> point that is the terminal end of the line formed by the two parameters.
	 * @return intersection points of the figure and the line that passes through ownReference and foreignReference points
	 */
	protected PointList getIntersectionPoints(Point ownReference, Point foreignReference) {
		final PointList polygon = getPolygonPoints();
		return (new LineSeg(ownReference, foreignReference)).getLineIntersectionsWithLineSegs(polygon);
	}

	/**
	 * Returns the list of all the vertices of the figure. The created list must form a polygon, i.e. closed polyline, for figures hence the
	 * starting and ending points must be the same
	 * 
	 * @return the <code>PointList</code> list of all the vertices of the figure.
	 */
	protected PointList getPolygonPoints() {
		if (getOwner() instanceof GfwPolygon) {
			PointList polyList = ((GfwPolygon) getOwner()).getPoints().getCopy();
			polyList.addPoint(polyList.getFirstPoint());
			getOwner().translateToAbsolute(polyList);
			return polyList;
		}
		return null;
	}

	/**
	 * Calculates the relative location of the reference point with respect to the bounds of the figure. If point p is not inside of the
	 * figure's bounds then the point is mapped on the bounds and the point relative location is calculated
	 * 
	 * @param p
	 *            the <code>Point</code> that is relative coordinates of the point
	 * @return <Code>PrecisionPoint</Code>, i.e. the relative reference for <Code>SlidableAnchor</Code>
	 */
	static public PrecisionPoint getAnchorRelativeLocation(Point p, Rectangle bounds) {
		PrecisionPoint relLocation;
		Point temp = new Point(p);
		if (p.x < bounds.x || p.x > bounds.x + bounds.width || p.y < bounds.y || p.y > bounds.y + bounds.height) {
			if (p.x < bounds.x || p.x > bounds.x + bounds.width) {
				temp.x = p.x < bounds.x ? bounds.x : bounds.x + bounds.width;
			}
			if (p.y < bounds.y || p.y > bounds.y + bounds.height) {
				temp.y = p.y < bounds.y ? bounds.y : bounds.y + bounds.height;
			}
			relLocation = new PrecisionPoint((double) (temp.x - bounds.x) / bounds.width, (double) (temp.y - bounds.y) / bounds.height);
		} else {

			relLocation = new PrecisionPoint((double) (temp.x - bounds.x) / bounds.width, (double) (temp.y - bounds.y) / bounds.height);
		}
		return relLocation;
	}
}
