package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.draw2d.AbstractLocator;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

/**
 * This is a very flexible Locator, which places a {@link RotatableDecoration} or a non-rotatable IFigure on a {@link Connection}. The
 * location is determined using a relative distance on the connection (e.g. "0.5" is the middle of the connection) and/or using an absolute
 * distance on the connection (e.g. "100" is 100 pixel from the anchor).
 */
public class FlexibleRotatableLocator extends AbstractLocator {

	/**
	 * A small data-structure, which contains the important results of the calculated location.
	 */
	private class CalculationResult {
		/**
		 * The calculated location on the connection.
		 */
		private Point location;

		/**
		 * The start-point of the line-segment of the connection, in which the location is placed. It is needed to calculate the angle of
		 * the line through the location.
		 */
		private Point segmentStart;

		/**
		 * The end-point of the line-segment of the connection, in which the location is placed. It is needed to calculate the angle of the
		 * line through the location.
		 */
		private Point segmentEnd;
	}

	/**
	 * The connection, as described in {@link #getConnection()}.
	 */
	private Connection connection;

	/**
	 * If the distance values refer to the start-point or the end-point. See {@link #getDistanceToStart()}.
	 */
	private boolean distanceToStart;

	/**
	 * The relative distance, as described in {@link #getRelativeDistance()}.
	 */
	private double relativeDistance;

	/**
	 * The absolute distance, as described in {@link #getAbsoluteDistance()}.
	 */
	private int absoluteDistance;

	/**
	 * The degrees to rotate, as described in {@link #getRotateDegrees()}.
	 */
	private double rotateDegrees;

	/**
	 * Creates a new FlexibleRotabableLocator.
	 * 
	 * @param connection
	 *            The connection, as described in {@link #getConnection()}.
	 * @param distanceToStart
	 *            If the distance values refer to the start-point or the end-point. See {@link #getDistanceToStart()}.
	 * @param relativeDistance
	 *            The relative distance, as described in {@link #getRelativeDistance()}.
	 * @param absoluteDistance
	 *            The absolute distance, as described in {@link #getAbsoluteDistance()}.
	 * @param rotateDegrees
	 *            The degrees to rotate, as described in {@link #getRotateDegrees()}.
	 */
	public FlexibleRotatableLocator(Connection connection, boolean distanceToStart, double relativeDistance, int absoluteDistance,
			double rotateDegrees) {
		assert (connection != null);
		this.connection = connection;
		setDistanceToStart(distanceToStart);
		setRelativeDistance(relativeDistance);
		setAbsoluteDistance(absoluteDistance);
		setRotateDegrees(rotateDegrees);
	}

	/**
	 * Returns the connection, on which this Locator places the location.
	 * 
	 * @return The connection, on which this Locator places the location.
	 */
	protected final Connection getConnection() {
		return connection;
	}

	/**
	 * Returns true, if the distance values (see {@link #getRelativeDistance()} and {@link #getAbsoluteDistance()}) refer to the start
	 * point of the connection. Returns false, if the distance values refer to the end point of the connection. For example if a relative
	 * and absolute distance are "0", then returning true will place the location on the start point and returning false on the end point.
	 * 
	 * @return If the distance values refer to the start-point or the end-point.
	 */
	public final boolean getDistanceToStart() {
		return distanceToStart;
	}

	/**
	 * Sets, If the distance values refer to the start-point or the end-point. For details see {@link #getDistanceToStart()}.
	 * 
	 * @param distanceToStart
	 *            If true, the distance values refer to the start-point.
	 */
	public final void setDistanceToStart(boolean distanceToStart) {
		this.distanceToStart = distanceToStart;
	}

	/**
	 * Returns the relative distance of the location to the start/end-point. The total distance is calculated by ([relative distance] *
	 * [length of connection] + [absolute distance]).
	 * 
	 * @return The relative distance of the location to the start/end-point.
	 * @see #getAbsoluteDistance()
	 * @see #getDistanceToStart()
	 */
	public final double getRelativeDistance() {
		return relativeDistance;
	}

	/**
	 * Sets the relative distance of the location to the start/end-point. For details see {@link #getRelativeDistance()}.
	 * 
	 * @param relativeDistance
	 *            The relative distance of the location to the start/end-point.
	 */
	public final void setRelativeDistance(double relativeDistance) {
		this.relativeDistance = relativeDistance;
	}

	/**
	 * Returns the absolute distance of the location to the start/end-point. The total distance is calculated by ([relative distance] *
	 * [length of connection] + [absolute distance]).
	 * 
	 * @return The absolute distance of the location to the start/end-point.
	 * @see #getRelativeDistance()
	 * @see #getDistanceToStart()
	 */
	public final int getAbsoluteDistance() {
		return absoluteDistance;
	}

	/**
	 * Sets the absolute distance of the location to the start/end-point. For details see {@link #getAbsoluteDistance()}.
	 * 
	 * @param absoluteDistance
	 *            The absolute distance of the location to the start/end-point.
	 */
	public final void setAbsoluteDistance(int absoluteDistance) {
		this.absoluteDistance = absoluteDistance;
	}

	/**
	 * Returns the degrees, around which the figure shall be rotated, if it is a RotatableDecoration. This rotation around a fixed value is
	 * done additionally to the dynamic rotation depending on the connection.
	 * 
	 * @return The degrees, around which the figure shall be rotated, if it is a RotatableDecoration.
	 */
	public final double getRotateDegrees() {
		return rotateDegrees;
	}

	/**
	 * Sets the degrees, around which the figure shall be rotated, if it is a RotatableDecoration. For details see
	 * {@link #getRotateDegrees()}.
	 * 
	 * @param rotateDegrees
	 *            The degrees, around which the figure shall be rotated, if it is a RotatableDecoration.
	 */
	public final void setRotateDegrees(double rotateDegrees) {
		this.rotateDegrees = rotateDegrees;
	}

	/**
	 * Calculates the location based on the current distance values and the connection.
	 * 
	 * @return The location based on the current distance values and the connection.
	 */
	protected CalculationResult calculateLocation() {
		PointList pointList = getConnection().getPoints();
		assert (pointList.size() >= 2); // all connections must have start point
		// and end point

		CalculationResult result = new CalculationResult();

		// sort the points of the connection (start to end / end to start)
		Point allPoints[] = new Point[pointList.size()];
		for (int i = 0; i < allPoints.length; i++) {
			if (getDistanceToStart()) {
				allPoints[i] = pointList.getPoint(i);
			} else {
				allPoints[(allPoints.length - 1) - i] = pointList.getPoint(i);
			}
		}

		// quick check for improved performance
		if (getAbsoluteDistance() == 0 && getRelativeDistance() == 0) {
			result.segmentStart = allPoints[0];
			result.segmentEnd = allPoints[1];
			result.location = result.segmentStart;
			return result;
		}
		if (getAbsoluteDistance() == 0 && getRelativeDistance() == 1) {
			result.segmentStart = allPoints[allPoints.length - 2];
			result.segmentEnd = allPoints[allPoints.length - 1];
			result.location = result.segmentEnd;
			return result;
		}

		// calculate the total length of the connection and of each connection
		// segment
		double totalLength = 0;
		double segmentLength[] = new double[allPoints.length - 1];
		for (int i = 0; i < segmentLength.length; i++) {
			segmentLength[i] = allPoints[i].getDistance(allPoints[i + 1]);
			totalLength += segmentLength[i];
		}

		// determine total distance
		double totalDistance = totalLength * getRelativeDistance() + getAbsoluteDistance();

		// determine the target segment
		int targetIndex = 0;
		double lengthBeforeTargetSegment = 0;
		for (targetIndex = 0; targetIndex < segmentLength.length - 1; targetIndex++) {
			if (lengthBeforeTargetSegment + segmentLength[targetIndex] < totalDistance) {
				lengthBeforeTargetSegment += segmentLength[targetIndex];
			} else {
				break;
			}
		}
		result.segmentStart = allPoints[targetIndex];
		result.segmentEnd = allPoints[targetIndex + 1];

		// determine location in target segment
		if (segmentLength[targetIndex] == 0) { // both points of segment are
			// identical (avoid division by
			// zero)
			result.location = result.segmentStart;
		} else {
			double absoluteDistanceInSegment = totalDistance - lengthBeforeTargetSegment;
			double relativeDistanceInSegment = absoluteDistanceInSegment / segmentLength[targetIndex];
			double locationX = result.segmentStart.x + ((result.segmentEnd.x - result.segmentStart.x) * relativeDistanceInSegment);
			double locationY = result.segmentStart.y + ((result.segmentEnd.y - result.segmentStart.y) * relativeDistanceInSegment);
			result.location = new Point(locationX, locationY);
		}

		return result;
	}

	/**
	 * Returns the location on the connection, which is calculated based on the current distance values and the connection.
	 * 
	 * @return The location on the connection.
	 */
	@Override
	protected Point getReferencePoint() {
		CalculationResult calculationResult = calculateLocation();
		getConnection().translateToAbsolute(calculationResult.location);
		return calculationResult.location;
	}

	/**
	 * Rotates the figure, if it is a RotatableDecoration.
	 * 
	 * @param target
	 *            The figure to rotate.
	 */
	@Override
	public void relocate(IFigure target) {
		if (target instanceof RotatableDecoration) {
			CalculationResult calculationResult = calculateLocation();
			RotatableDecoration rotatable = (RotatableDecoration) target;
			rotatable.setLocation(calculationResult.location);

			// determine reference point
			Point p1 = calculationResult.segmentStart;
			Point p2 = calculationResult.segmentEnd;
			Point reference;
			if (p1.equals(p2)) { // no clear direction -> choose "horizontal"
				reference = calculationResult.location.getCopy().translate(-10, 0);
			} else { // extend line through [p1, p2] to keep direction
				reference = new Point();
				reference.x = p2.x + (p2.x - p1.x);
				reference.y = p2.y + (p2.y - p1.y);

				rotatePoint(calculationResult.location, reference, getRotateDegrees());
			}
			rotatable.setReferencePoint(reference);
		} else {
			super.relocate(target);
		}
	}

	protected void rotatePoint(Point center, Point rotate, double degrees) {
		if (degrees != 0) {
			double radians = Math.toRadians(degrees);
			double sin = Math.sin(radians);
			double cos = Math.cos(radians);

			Point v = new Point(rotate.x - center.x, rotate.y - center.y);

			rotate.x = center.x + (int) (cos * v.x - sin * v.y);
			rotate.y = center.y + (int) (sin * v.x + cos * v.y);
		}
	}
}
