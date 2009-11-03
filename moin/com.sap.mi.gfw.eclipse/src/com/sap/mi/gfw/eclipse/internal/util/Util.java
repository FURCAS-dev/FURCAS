package com.sap.mi.gfw.eclipse.internal.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import com.sap.mi.gfw.datatypes.ILocation;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.ChopboxAnchorFixed;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.ChopboxAnchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.PeUtil;

/**
 * Collection of general static helper methods.
 */
public class Util {

	/**
	 * Returns the stacktrace of the given Throwable.
	 * 
	 * @param The
	 *            Throwable, for which to get the stacktrace.
	 * @return The stacktrace of the given Throwable.
	 */
	public static String getStacktrace(Throwable t) {
		if (t == null)
			return null;
		StringWriter writer = new StringWriter();
		t.printStackTrace(new PrintWriter(writer));
		return writer.toString();
	}

	/**
	 * @param c
	 * @param d
	 * @return
	 */
	public static Point getConnectionPointAt(Connection c, double d) {
		Point ret = null;

		Anchor startAnchor = c.getStart();
		ILocation startLocation = PeUtil.getLocationRelativeToDiagram(startAnchor);
		Point startPoint = new Point(startLocation.getX(), startLocation.getY());

		Anchor endAnchor = c.getEnd();
		ILocation endLocation = PeUtil.getLocationRelativeToDiagram(endAnchor);
		Point endPoint = new Point(endLocation.getX(), endLocation.getY());

		// special solutions for chopbox anchors
		if (startAnchor instanceof ChopboxAnchor || endAnchor instanceof ChopboxAnchor) {
			if (startAnchor instanceof ChopboxAnchor) {
				ChopboxAnchor cbStartAnchor = (ChopboxAnchor) startAnchor;
				GraphicsAlgorithm parentGa = cbStartAnchor.getParent().getGraphicsAlgorithm();
				Shape shape = (Shape) cbStartAnchor.getParent();
				ILocation location = PeUtil.getLocationRelativeToDiagram(shape);
				Rectangle parentRect = new Rectangle(location.getX(), location.getY(), parentGa.getWidth(), parentGa.getHeight());

				Point pointNextToStartAnchor = endPoint.getCopy();

				if (c instanceof FreeFormConnection) {
					FreeFormConnection ffc = (FreeFormConnection) c;
					List bendpoints = ffc.getBendpoints();
					if (!bendpoints.isEmpty()) {
						com.sap.mi.gfw.mm.datatypes.Point firstBendpoint = (com.sap.mi.gfw.mm.datatypes.Point) bendpoints.get(0);
						pointNextToStartAnchor.setLocation(firstBendpoint.getX(), firstBendpoint.getY());
					}
				}

				Point chopboxLocationOnBox = getChopboxLocationOnBox(pointNextToStartAnchor, parentRect);
				startPoint.setLocation(chopboxLocationOnBox);
			}

			if (endAnchor instanceof ChopboxAnchor) {
				ChopboxAnchor cbEndAnchor = (ChopboxAnchor) endAnchor;
				GraphicsAlgorithm parentGa = cbEndAnchor.getParent().getGraphicsAlgorithm();
				Shape shape = (Shape) cbEndAnchor.getParent();
				ILocation location = PeUtil.getLocationRelativeToDiagram(shape);
				Rectangle parentRect = new Rectangle(location.getX(), location.getY(), parentGa.getWidth(), parentGa.getHeight());

				Point pointNextToEndAnchor = startPoint.getCopy();

				if (c instanceof FreeFormConnection) {
					FreeFormConnection ffc = (FreeFormConnection) c;
					List bendpoints = ffc.getBendpoints();
					if (!bendpoints.isEmpty()) {
						com.sap.mi.gfw.mm.datatypes.Point lastBendpoint = (com.sap.mi.gfw.mm.datatypes.Point) bendpoints.get(bendpoints
								.size() - 1);
						pointNextToEndAnchor.setLocation(lastBendpoint.getX(), lastBendpoint.getY());
					}
				}

				Point chopboxLocationOnBox = getChopboxLocationOnBox(pointNextToEndAnchor, parentRect);
				endPoint.setLocation(chopboxLocationOnBox);
			}

		}

		if (c instanceof FreeFormConnection) {
			FreeFormConnection ffc = (FreeFormConnection) c;
			List bendpoints = ffc.getBendpoints();
			Point[] draw2dPoints = new Point[bendpoints.size() + 2];
			{
				draw2dPoints[0] = startPoint;
				int i = 1;
				for (Iterator iter = bendpoints.iterator(); iter.hasNext();) {
					com.sap.mi.gfw.mm.datatypes.Point pictogramsPoint = (com.sap.mi.gfw.mm.datatypes.Point) iter.next();
					draw2dPoints[i] = new Point(pictogramsPoint.getX(), pictogramsPoint.getY());
					i++;
				}
				draw2dPoints[i] = endPoint;
			}

			double completeDistance = getDistance(draw2dPoints);
			double absDistanceToRelPoint = completeDistance * d;

			double distanceSum = 0;
			for (int i = 0; i < draw2dPoints.length - 1; i++) {
				double oldDistanceSum = distanceSum;
				Point currentPoint = draw2dPoints[i];
				Point nextPoint = draw2dPoints[i + 1];
				// no need to check both points
				// actually this would lead to division-by-zero in the following calculation
				if (currentPoint.equals(nextPoint))
					continue;

				double additionalDistanceToNext = getDistance(currentPoint, nextPoint);
				distanceSum += additionalDistanceToNext;
				if (distanceSum >= absDistanceToRelPoint) {
					double thisRelative = ((completeDistance * d) - oldDistanceSum) / additionalDistanceToNext;
					ret = getPointAt(currentPoint, nextPoint, thisRelative);
					break; // or return ret;
				}
			}

		} else {
			ret = getPointAt(startPoint.x, startPoint.y, endPoint.x, endPoint.y, d);
		}
		return ret;
	}

	private static Point getDistantPoint(Point start, Point end, double distance) {
		Point ret = getDistantPoint(start.x, start.y, end.x, end.y, distance);
		return ret;
	}

	private static Point getDistantPoint(int startX, int startY, int endX, int endY, double distance) {
		Point ret;
		double completeDistance = Math.sqrt(((endX - startX) * (endX - startX)) + ((endY - startY) * (endY - startY)));
		double relative;
		if (distance >= 0) {
			relative = (distance > completeDistance) ? 1 : distance / completeDistance;
			ret = getPointAt(startX, startY, endX, endY, relative);
		} else {
			relative = (-distance > completeDistance) ? 0 : 1 - (distance / completeDistance);
			ret = getPointAt(startX, startY, endX, endY, relative);
		}

		return ret;
	}

	/**
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 * @param d
	 * @return
	 */
	private static Point getPointAt(int startX, int startY, int endX, int endY, double d) {
		Point ret;
		int midX = (int) Math.round((startX + d * (endX - startX)));
		int midY = (int) Math.round((startY + d * (endY - startY)));
		ret = new Point(midX, midY);
		return ret;
	}

	private static Point getPointAt(Point start, Point end, double d) {
		Point ret = getPointAt(start.x, start.y, end.x, end.y, d);
		return ret;
	}

	private static double getDistance(Point[] points) {
		double ret = 0;
		for (int i = 0; i < points.length - 1; i++) {
			Point currentPoint = points[i];
			Point nextPoint = points[i + 1];
			ret += getDistance(currentPoint, nextPoint);
		}
		return ret;
	}

	private static double getDistance(Point start, Point end) {
		int xDist = end.x - start.x;
		int yDist = end.y - start.y;
		double ret = Math.sqrt((xDist * xDist) + (yDist * yDist));
		return ret;
	}

	/**
	 * This method has to be kept in sync with {@link ChopboxAnchorFixed#getLocation(Point)}.
	 */
	public static Point getChopboxLocationOnBox(Point reference, Rectangle box) {
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(box);
		r.translate(-1, -1);
		r.resize(1, 1);

		// getOwner().translateToAbsolute(r);
		float centerX = r.x + 0.5f * r.width;
		float centerY = r.y + 0.5f * r.height;

		// CHANGED: returning the center in case of a divide-by-zero is not a
		// good result
		// if (r.isEmpty() || (reference.x == (int)centerX && reference.y ==
		// (int)centerY))
		// return new Point((int)centerX, (int)centerY); //This avoids
		// divide-by-zero

		float dx = reference.x - centerX;
		float dy = reference.y - centerY;

		// r.width, r.height, dx, and dy are guaranteed to be non-zero.

		// CHANGED: in case of "nearly zero" (divide-by-zero or
		// rounding-problems) would happen.
		// Instead return a point on the border of the figure.
		// Doesn't matter which one, because it is directly in the center, so
		// take top-middle.
		float max = Math.max(Math.abs(dx) / r.width, Math.abs(dy) / r.height);
		if (max <= 0.001f) {
			return new Point((int) centerX, r.y);
		}

		float scale = 0.5f / max;

		dx *= scale;
		dy *= scale;
		centerX += dx;
		centerY += dy;

		return new Point(Math.round(centerX), Math.round(centerY));
	}

	/**
	 * @param c
	 * @param absDistance
	 *            absDistance > 0 means distance from beginning. absDistance < 0 means distance from connection end.
	 * @return
	 */
	public static Point getAbsolutePointOnConnection(Connection c, double distance) {
		Point ret = null;

		Anchor startAnchor = c.getStart();
		ILocation startLocation = PeUtil.getLocationRelativeToDiagram(startAnchor);
		Point startPoint = new Point(startLocation.getX(), startLocation.getY());

		Anchor endAnchor = c.getEnd();
		ILocation endLocation = PeUtil.getLocationRelativeToDiagram(endAnchor);
		Point endPoint = new Point(endLocation.getX(), endLocation.getY());

		// special solutions for chopbox anchors
		if (startAnchor instanceof ChopboxAnchor || endAnchor instanceof ChopboxAnchor) {
			if (startAnchor instanceof ChopboxAnchor) {
				ChopboxAnchor cbStartAnchor = (ChopboxAnchor) startAnchor;
				GraphicsAlgorithm parentGa = cbStartAnchor.getParent().getGraphicsAlgorithm();
				Rectangle parentRect = new Rectangle(parentGa.getX(), parentGa.getY(), parentGa.getWidth(), parentGa.getHeight());

				Point pointNextToStartAnchor = endPoint.getCopy();

				if (c instanceof FreeFormConnection) {
					FreeFormConnection ffc = (FreeFormConnection) c;
					List bendpoints = ffc.getBendpoints();
					if (!bendpoints.isEmpty()) {
						com.sap.mi.gfw.mm.datatypes.Point firstBendpoint = (com.sap.mi.gfw.mm.datatypes.Point) bendpoints.get(0);
						pointNextToStartAnchor.setLocation(firstBendpoint.getX(), firstBendpoint.getY());
					}
				}

				Point chopboxLocationOnBox = getChopboxLocationOnBox(pointNextToStartAnchor, parentRect);
				startPoint.setLocation(chopboxLocationOnBox);
			}

			if (endAnchor instanceof ChopboxAnchor) {
				ChopboxAnchor cbEndAnchor = (ChopboxAnchor) endAnchor;
				GraphicsAlgorithm parentGa = cbEndAnchor.getParent().getGraphicsAlgorithm();
				Rectangle parentRect = new Rectangle(parentGa.getX(), parentGa.getY(), parentGa.getWidth(), parentGa.getHeight());

				Point pointNextToEndAnchor = startPoint.getCopy();

				if (c instanceof FreeFormConnection) {
					FreeFormConnection ffc = (FreeFormConnection) c;
					List bendpoints = ffc.getBendpoints();
					if (!bendpoints.isEmpty()) {
						com.sap.mi.gfw.mm.datatypes.Point lastBendpoint = (com.sap.mi.gfw.mm.datatypes.Point) bendpoints.get(bendpoints
								.size() - 1);
						pointNextToEndAnchor.setLocation(lastBendpoint.getX(), lastBendpoint.getY());
					}
				}

				Point chopboxLocationOnBox = getChopboxLocationOnBox(pointNextToEndAnchor, parentRect);
				endPoint.setLocation(chopboxLocationOnBox);
			}

		}

		if (c instanceof FreeFormConnection) {
			FreeFormConnection ffc = (FreeFormConnection) c;
			List bendpoints = ffc.getBendpoints();
			Point[] draw2dPoints = new Point[bendpoints.size() + 2];
			{
				draw2dPoints[0] = startPoint;
				int i = 1;
				for (Iterator iter = bendpoints.iterator(); iter.hasNext();) {
					com.sap.mi.gfw.mm.datatypes.Point pictogramsPoint = (com.sap.mi.gfw.mm.datatypes.Point) iter.next();
					draw2dPoints[i] = new Point(pictogramsPoint.getX(), pictogramsPoint.getY());
					i++;
				}
				draw2dPoints[i] = endPoint;
			}

			if (distance < 0) {
				// mirror the array
				mirrorArray(draw2dPoints);
			}

			double absDistance = Math.abs(distance);

			double distanceSum = 0;
			for (int i = 0; i < draw2dPoints.length - 1; i++) {
				Point currentPoint = draw2dPoints[i];
				Point nextPoint = draw2dPoints[i + 1];
				double additionalDistanceToNext = getDistance(currentPoint, nextPoint);
				distanceSum += additionalDistanceToNext;
				if (distanceSum >= absDistance) {
					// double thisDistance = (distance - oldDistanceSum) /
					// additionalDistanceToNext;
					// ret = getMidpoint(currentPoint, nextPoint, thisDistance);
					ret = getDistantPoint(currentPoint, nextPoint, absDistance);
					break; // or return ret;
				}
			}

		} else {
			ret = getDistantPoint(startLocation.getX(), startLocation.getY(), endLocation.getX(), endLocation.getY(), distance);
		}

		if (ret == null) {
			ret = startPoint;
		}

		return ret;
	}

	/**
	 * @param draw2dPoints
	 */
	public static void mirrorArray(Point[] draw2dPoints) {
		int length = draw2dPoints.length;
		for (int i = 0; i < length / 2; i++) {
			Point pTemp = draw2dPoints[length - 1 - i];
			draw2dPoints[length - 1 - i] = draw2dPoints[i];
			draw2dPoints[i] = pTemp;
		}
	}
}
