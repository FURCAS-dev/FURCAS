package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Path;

import com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;

/**
 * This class is an abstract super-class for all RotatableDecorations in the GFW. The main idea is, that the outline and fill-area of a
 * RotatableDecoration is defined by a Path. Sub-classes usually only have to implement the abstract methods
 * {@link #createPath(Rectangle, Graphics, boolean)} and {@link #getInitialTouchPoint()}.
 */
public abstract class GfwAbstractRotatableDecoration extends GfwAbstractShape implements RotatableDecoration {

	/**
	 * The initial bounds as described in {@link #getInitialBounds()}.
	 */
	private Rectangle initialBounds = null;

	/**
	 * The bounds of this figure. They are calculated depending on the current decorator-location and decorator-reference-point.
	 */
	private Rectangle bounds = new Rectangle();

	/**
	 * The decorator-location as described in {@link #getDecoratorLocation()}.
	 */
	private Point decoratorLocation = new Point();

	/**
	 * The decorator-reference-point as described in {@link #getDecoratorReferencePoint()}.
	 */
	private Point decoratorReferencePoint = new Point();

	/**
	 * The angle "phi" in degrees as described in {@link #getPhiDegrees()}.
	 */
	private double phiDegrees = 0;

	/**
	 * The angle "phi" in radians as described in {@link #getPhiRadians()}.
	 */
	private double phiRadians = 0;

	/**
	 * The distance which the decorator will be moved, so that the initialTouchPoint touches the decorator-location after the rotation.
	 */
	private Point touchPointDelta = new Point();

	/**
	 * Creates a new GfwAbstractRotatableDecoration.
	 * 
	 * @param pictogramElementDelegate
	 *            The PictogramElementDelegate which provides the GraphicsAlgorithm.
	 * @param graphicsAlgorithm
	 *            The GraphicsAlgorithm which provides the values to paint this Shape.
	 */
	public GfwAbstractRotatableDecoration(IPictogramElementDelegate pictogramElementDelegate, GraphicsAlgorithm graphicsAlgorithm) {
		super(pictogramElementDelegate, graphicsAlgorithm);

		// initialize values
		initialBounds = new Rectangle(0, 0, graphicsAlgorithm.getWidth(), graphicsAlgorithm.getHeight());
	}

	// ============================= abstract methods =========================

	/**
	 * Returns the initial touch-point of the decorator-shape. This is the point of the decorator-shape inside the initial-bounds (see
	 * {@link #getInitialBounds()}), which shall touch the decorated figure at the decorator-location (see {@link #getDecoratorLocation()}.
	 * It is called "inital" because it is the point before translation/rotation.
	 * <p>
	 * Example: for an Ellipse the point <code>(0, getInitialBounds().height / 2)</code> is returned.
	 * 
	 * @return The initial touch-point of the decorator-shape.
	 */
	protected abstract Point getInitialTouchPoint();

	// ======================= interface RotatableDecoration ==================

	/**
	 * Sets the decorator-location.
	 * 
	 * @param p
	 *            The decorator-location to set.
	 * @see #getDecoratorLocation()
	 */
	@Override
	public void setLocation(Point p) {
		decoratorLocation.setLocation(p);

		// probably not necessary, because afterwards always(?)
		// setReferencePoint() is called.
		processRotatableDecorationValues();
	}

	/**
	 * Sets the decorator-reference-point. Calls {@link #processRotatableDecorationValues()} afterwards to initialize the rotated rectangle
	 * values.
	 * 
	 * @param ref
	 *            The decorator-reference-point to set.
	 * @see #getDecoratorReferencePoint()
	 */
	public void setReferencePoint(Point ref) {
		decoratorReferencePoint.setLocation(ref);
		processRotatableDecorationValues();
	}

	/**
	 * After the decorator-location or decorator-reference-point changed, the translated/rotated rectangle has to be re-calculated. This
	 * includes {@link #getPhiDegrees()}, {@link #getPhiRadians()}, {@link #getBounds()}, {@link #getTouchPointDelta()}.
	 */
	protected void processRotatableDecorationValues() {
		// Calculate the angle between the x-axis and the line through
		// [location, referencePoint].
		// Add 180 degrees so that 0 degree is at 3 o'clock, increasing
		// clockwise
		Point tempRect = Point.SINGLETON.setLocation(getDecoratorReferencePoint());
		tempRect.negate().translate(getDecoratorLocation());
		phiDegrees = Math.toDegrees((Math.atan2(tempRect.y, tempRect.x))) + 180d;
		phiRadians = Math.toRadians(phiDegrees);

		// Compute the delta between the rotated touch-point and the location.
		double sin = Math.sin(getPhiRadians());
		double cos = Math.cos(getPhiRadians());
		double rotatedX = getInitialTouchPoint().x * cos - getInitialTouchPoint().y * sin;
		double rotatedY = getInitialTouchPoint().x * sin + getInitialTouchPoint().y * cos;
		touchPointDelta = new PrecisionPoint(getDecoratorLocation().x - rotatedX, getDecoratorLocation().y - rotatedY);

		// Calculate the bounds.
		// This is a rough value, which is bigger than the smallest bounds would
		// be.
		int maxExtension = Math.max(getInitialBounds().width, getInitialBounds().height) + 10;
		bounds = new Rectangle(touchPointDelta.x - maxExtension, touchPointDelta.y - maxExtension, 2 * maxExtension, 2 * maxExtension);
	}

	// ============================ overwritten methods =======================

	/**
	 * Returns the bounds of this decorator shape. This implementation bases on a rough calculation, which returns a bigger rectangle than
	 * necessary.
	 * 
	 * @return The bounds of this decorator shape.
	 */
	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * Fills this Shape on the given Graphics. It enhances the implementation of the super-class by adding a rotation and translation
	 * according to the values set via {@link RotatableDecoration}.
	 * 
	 * @param graphics
	 *            The Graphics on which to outline this Shape.
	 */
	@Override
	protected void paintShape(Graphics graphics, boolean isFill) {
		// initialize Graphics
		int oldLineWidth = graphics.getLineWidth();
		graphics.setLineWidth(getLineWidth(graphics));

		// get Path
		double zoom = getZoomLevel(graphics);
		int lw = getLineWidth(graphics);
		Rectangle pathbounds = GfwFigureUtil.getAdjustedRectangle(getInitialBounds(), zoom, lw);
		// do not adjust the bounds for filling as is done in the super-class,
		// because the rotation creates too much rounding-differences to get
		// good results.
		Path path = createPath(pathbounds, graphics, isFill);

		// adjust Graphics
		graphics.pushState();
		// translation before rotation to avoid nullpointer
		graphics.translate(getTouchPointDelta().x, getTouchPointDelta().y);
		graphics.rotate((float) getPhiDegrees());

		// outline or fill Path
		if (isFill) {
			fillPath(graphics, path);
		} else {
			graphics.drawPath(path);
		}

		// reset Graphics
		path.dispose();
		graphics.popState();
		graphics.setLineWidth(oldLineWidth);
	}

	/**
	 * Returns true, if the point is inside the translated/rotated rectangle. Specifics of the decorator Shape are ignored, but can be added
	 * by overwriting {@link #containsPointInInitialFigure(int, int)}.
	 */
	@Override
	public boolean containsPointInFigure(int x, int y) {
		// Idea: translate and rotate the point (x, y) backwards into the intial
		// bounds.
		// There the real check is done.
		PrecisionPoint backwards = rotateTargetToInitial(x, y);

		// fast check
		if (!getInitialBounds().contains((int) Math.round(backwards.preciseX), (int) Math.round(backwards.preciseY))) {
			return false;
		}

		// forward to the shape-specific check
		return containsPointInInitialFigure(backwards.x, backwards.y);
	}

	// ============================== helper methods ==========================

	/**
	 * Returns true, if the point is inside the initial figure, meaning the figure in the {@link #getInitialBounds()} before
	 * translation/rotation.
	 * <p>
	 * This implementation just returns true, but sub-classes can overwrite it to make decorator-shape specific checks.
	 */
	public boolean containsPointInInitialFigure(int x, int y) {
		return true;
	}

	/**
	 * Returns the initial point for the given target point. This means, that it translates/rotates the given target point from the
	 * coordinates of the target-rectangle backwards to the coordinates of the initial bounds.
	 * 
	 * @param x
	 *            The x-coordinate of the target point to translate/rotate.
	 * @param y
	 *            The y-coordinate of the target point to translate/rotate.
	 * @return The initial point for the given target point.
	 */
	protected PrecisionPoint rotateTargetToInitial(double x, double y) {
		double sin = Math.sin(-getPhiRadians());
		double cos = Math.cos(-getPhiRadians());
		double translatedX = x - getDecoratorLocation().x;
		double translatedY = y - getDecoratorLocation().y;
		double rotatedX = translatedX * cos - translatedY * sin;
		double rotatedY = translatedX * sin + translatedY * cos;
		rotatedX += getInitialTouchPoint().x;
		rotatedY += getInitialTouchPoint().y;

		return new PrecisionPoint(rotatedX, rotatedY);
	}

	/**
	 * Sets the initial-bounds. The initial-bounds are a rectangle which starts at (0,0) and has the (width, height) of the figure before
	 * rotation. The initial-bounds are set in the constructor and not changed afterwards.
	 * 
	 * @param initialBounds
	 *            The initial-bounds to set.
	 */
	protected final void setInitialBounds(Rectangle initialBounds) {
		this.initialBounds = initialBounds;
	}

	/**
	 * Returns the initial-bounds. The initial-bounds are a rectangle which starts at (0,0) and has the (width, height) of the figure before
	 * rotation. The initial-bounds are set in the constructor and not changed afterwards.
	 * 
	 * @return The initial-bounds.
	 */
	protected final Rectangle getInitialBounds() {
		return initialBounds;
	}

	/**
	 * Returns the decorator-location. The decorator-location is the start-point of the connection. This means that at this point the
	 * decorator and the figure shall touch.
	 * 
	 * @return The decorator-location.
	 * @see #setLocation(Point)
	 */
	protected final Point getDecoratorLocation() {
		return decoratorLocation;
	}

	/**
	 * Returns the decorator-reference-point. The decorator-reference-point is the end-point of the connection. It is used to calculate the
	 * angle "phi".
	 * 
	 * @return The decorator-reference-point.
	 * @see #setReferencePoint(Point)
	 * @see #getPhiDegrees()
	 * @see #getPhiRadians()
	 */
	protected final Point getDecoratorReferencePoint() {
		return decoratorReferencePoint;
	}

	/**
	 * Returns the angle "phi" in degrees. This is the angle between the x-axis and the line through [decorator-location,
	 * decorator-reference-point].
	 * 
	 * @return The angle "phi" in degrees.
	 * @see #getPhiRadians()
	 */
	protected final double getPhiDegrees() {
		return phiDegrees;
	}

	/**
	 * Returns the angle "phi" in radians. This is the angle between the x-axis and the line through [decorator-location,
	 * decorator-reference-point].
	 * 
	 * @return The angle "phi" in radians.
	 * @see #getPhiDegrees()
	 */
	protected final double getPhiRadians() {
		return phiRadians;
	}

	/**
	 * Returns the touch-point delta. This is the distance which the decorator has to be moved, so that the initial touchpoint touches the
	 * decorator-location after the rotation.
	 * 
	 * @return The touch-point delta.
	 */
	protected final Point getTouchPointDelta() {
		return touchPointDelta;
	}
}
