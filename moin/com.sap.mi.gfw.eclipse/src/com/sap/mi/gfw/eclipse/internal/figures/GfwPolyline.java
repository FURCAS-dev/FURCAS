/*
 * Created on 14.10.2005
 */
package com.sap.mi.gfw.eclipse.internal.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Path;

import com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;

/**
 * A GFW Polyline Figure. Most functionality is handled in the super-class. This class only has to define the outline-path and fill-path for
 * the figure-specific painting.
 */
public class GfwPolyline extends GfwAbstractPointListShape {

	/**
	 * The minimum selection line-width which is set in {@link #setMinimumSelectionLineWidth(int)}.
	 */
	private int minimumSelectionLineWidth = 5;

	/**
	 * If filling is suppressed as described in {@link #setSuppressFilling(boolean)}.
	 */
	private boolean suppressFilling = false;

	/**
	 * The distance used to calculate the rounding of the bezier-curve as described in {@link #getGeneralBezierDistance()}.
	 */
	private int generalBezierDistance = 0; // no rounding by default

	/**
	 * The distances used to calculate the rounding of the bezier-curve as described in {@link #getSpecificBezierDistances()}.
	 */
	private int specificBezierDistances[] = null; // no rounding by default

	/**
	 * The adjusted point-list as described in {@link #getAdjustedPointListWithoutZoom()}.
	 */
	private PointList adjustedPointsWithoutZoom = new PointList();

	/**
	 * Creates a new GfwPolyline.
	 * 
	 * @param pictogramElementDelegate
	 *            The PictogramElementDelegate which provides the GraphicsAlgorithm.
	 * @param graphicsAlgorithm
	 *            The GraphicsAlgorithm which provides the values to paint this Shape.
	 */
	public GfwPolyline(IPictogramElementDelegate pictogramElementDelegate, GraphicsAlgorithm graphicsAlgorithm) {
		super(pictogramElementDelegate, graphicsAlgorithm);

		// A Polyline is NEVER filled
		setSuppressFilling(true);
	}

	/**
	 * Sets the selection tolerance. This is the minimum line-width, which is still considered to be a selection of the polyline,
	 * independent from the real line-width. For a small line-width this makes it easier to select the polyline.
	 * 
	 * @param minimumSelectionLineWidth
	 *            The new minimum selection line-width to set.
	 */
	public void setMinimumSelectionLineWidth(int minimumSelectionLineWidth) {
		this.minimumSelectionLineWidth = minimumSelectionLineWidth;
	}

	/**
	 * Set, if the filling should be suppressed under all circumstances (even if {@link #setFill(boolean)} was set to true).
	 * 
	 * @param suppressFilling
	 *            If true, then the filling is suppressed under all circumstances.
	 */
	public void setSuppressFilling(boolean suppressFilling) {
		this.suppressFilling = suppressFilling;
	}

	/**
	 * Sets the general distance used to calculate the rounding of the bezier-curve. This means, that all bezier-distances for this polyline
	 * are identical. This is different to {@link #setSpecificBezierDistances(int[])}. See
	 * {@link GfwFigureUtil#getBezierPath(List, boolean)} for a more details.
	 * 
	 * @param bezierDistance
	 *            The general distance used to calculate the rounding of the bezier-curve.
	 */
	public void setGeneralBezierDistance(int bezierDistance) {
		this.generalBezierDistance = bezierDistance;
	}

	/**
	 * Returns the general bezier distance used to calculate the rounding of the bezier-curve. See {@link #setGeneralBezierDistance(int)}
	 * for more details.
	 * 
	 * @return The general bezier distance used to calculate the rounding of the bezier-curve.
	 */
	protected int getGeneralBezierDistance() {
		return generalBezierDistance;
	}

	/**
	 * Sets the specific distances used to calculate the rounding of the bezier-curve. This means, that for each point of the polyline the
	 * before-distance and the after distance have to be specified. If this attribute is null, then the value of the attribute in
	 * {@link #setGeneralBezierDistance(int)} will be used. See {@link GfwFigureUtil#getBezierPath(List, boolean)} for a more details.
	 * 
	 * @param bezierDistances
	 *            The specific distance used to calculate the rounding of the bezier-curve.
	 */
	public void setSpecificBezierDistances(int[] bezierDistances) {
		// TODO This interface should be improved: bezierDistances.length == 2 * points.length is quite difficult to use.
		this.specificBezierDistances = bezierDistances;
	}

	/**
	 * Returns the specific bezier distance used to calculate the rounding of the bezier-curve. See
	 * {@link #setSpecificBezierDistances(int[])} for more details.
	 * 
	 * @return The specific bezier distance used to calculate the rounding of the bezier-curve.
	 */
	protected int[] getSpecificBezierDistances() {
		// TODO This interface should be improved: bezierDistances.length == 2 * points.length is quite difficult to use.
		return specificBezierDistances;
	}

	/**
	 * Returns the points of this polyline, which are adjusted regarding their line-width but which are not zoomed (see
	 * {@link #getAdjustedPointList(PointList, double, double)}). This is a buffered value, which is used to check, if a point is contained
	 * on this polyline. It is re-calculated whenever the "real" point-list of this polyline changes.
	 * 
	 * @return Returns the points of this polyline, which are translated regarding their line-width.
	 */
	protected PointList getAdjustedPointListWithoutZoom() {
		getBounds(); // this will initialize the tranlatedPoints
		return adjustedPointsWithoutZoom;
	}

	/**
	 * Returns a new instance of the input point-list, which is adjusted regarding the given zoom-factor and line-width. This is the
	 * point-list which will be outlined on the graphics. So this allows to draw along slightly different point-list than the original
	 * point-list.
	 * <p>
	 * The implementation of this method just forwards to {@link GfwFigureUtil#getAdjustedPointList(PointList, double, double)}.
	 * 
	 * @param points
	 *            The point-list which to adjust.
	 * @param zoom
	 *            The zoom-factor to regard.
	 * @param lw
	 *            The line-width to regard.
	 */
	protected PointList getAdjustedPointList(PointList points, double zoom, double lw) {
		return GfwFigureUtil.getAdjustedPointList(points, zoom, lw);
	}

	// =================== overwritten functional methods =====================

	/**
	 * Returns the bounding box of the Polyline. This is actually the bounding box of the point-list which defines the Polyline. That means,
	 * that the bounding box changes whenever the point-list changes. Also note, that calling {@link #setBounds(Rectangle)} does not change
	 * the dimension of the bounding box, but it may translate the bounding box (see {@link #primTranslate(int, int)}).
	 * 
	 * @return The bounding box of the Polyline.
	 */
	@Override
	public Rectangle getBounds() {
		boolean boundsChanged = false;
		if (bounds == null) {
			boundsChanged = true;
			bounds = getPoints().getBounds().getCopy();

			int lw = getLineWidth();
			adjustedPointsWithoutZoom = getAdjustedPointList(getPoints(), 1.0, lw);
		}

		// special handling, if bounds < linewidth (can easily happen for horizontal/vertical lines)
		int lw = getLineWidth();
		if (bounds.height < lw) {
			boundsChanged = true;
			bounds.y -= (lw - bounds.height + 1) / 2;
			bounds.height = lw + 1;
		}
		if (bounds.width < lw) {
			boundsChanged = true;
			bounds.x -= (lw - bounds.width + 1) / 2;
			bounds.width = lw + 1;
		}

		// Usually the following refresh is done in setBounds(), but in this class the bounds are changed in getBounds().
		// Mostly it works without this explicit refresh, except that the selection-handles were not moved.
		if (boundsChanged) {
			invalidate();
			fireFigureMoved();
			repaint();
		}

		return bounds;
	}

	/**
	 * Sets the line-width of the Polyline. Note that changing the line-width might change the bounds of the Polyline. This is the reason,
	 * why this method is overwritten for the Polyline.
	 * 
	 * @see #getBounds()
	 * 
	 * @param lw
	 *            The line-width to set.
	 */
	@Override
	public void setLineWidth(int lw) {
		if (lineWidth == lw)
			return;
		if (lw < lineWidth) // The bounds will become smaller, so erase must
			// occur first.
			erase();
		bounds = null;
		super.setLineWidth(lw);
	}

	/**
	 * Returns true, if the given point is contained in this Polyline. This is the case if
	 * <ul>
	 * <li>The point is located on the line, taking into account a certain tolerance (see {@link #setSelectionTolerance(int)})</li>
	 * <li>The point is contained in a child of this Shape</li>
	 * </ul>
	 * 
	 * @param x
	 *            The x-coordinate of the point to check.
	 * @param y
	 *            The y-coordinate of the point to check.
	 * 
	 * @return true, if the given point is contained in this Polyline.
	 */
	@Override
	public boolean containsPointInFigure(int x, int y) {
		int tolerance = Math.max(lineWidth, minimumSelectionLineWidth);

		// check the translated-points, because the drawing will happen along
		// those lines
		Boolean inFigure = GfwFigureUtil.containsPointInPolyline(getAdjustedPointListWithoutZoom(), x, y, tolerance);
		if (inFigure != null) // clear result, no need for further checking
			return inFigure.booleanValue();

		// check if point inside children (if existing)
		List children = getChildren();
		for (int i = 0; i < children.size(); i++) {
			if (((IFigure) children.get(i)).containsPoint(x, y)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Translates the shape by the given x/y dimensions. This will translate all points of the Polyline by the given values. Note, that it
	 * is necessary to overwrite this method, because the super-class implementation only changes the bounding box, which has no affect on
	 * the coordinates of the Polyline.
	 * 
	 * @param dx
	 *            The amount to translate horizontally
	 * @param dy
	 *            The amount to translate vertically
	 * 
	 * @see #getBounds()
	 */
	@Override
	public void primTranslate(int dx, int dy) {
		setPoints(GfwFigureUtil.getTranslatedPointList(getPoints(), dx, dy));

		// copied from the super-class
		if (useLocalCoordinates()) {
			fireCoordinateSystemChanged();
			return;
		}
		for (int i = 0; i < getChildren().size(); i++)
			((IFigure) getChildren().get(i)).translate(dx, dy);
	}

	// ==================== overwritten drawing methods =======================

	/**
	 * Suppresses the filling if specified in {@link #setSuppressFilling(boolean)}. Otherwise it just forwards to the super-class.
	 */
	@Override
	protected void fillShape(Graphics graphics) {
		if (!suppressFilling) {
			super.fillShape(graphics);
		}
	}

	/**
	 * Returns the Path specifying a polyline for the adjusted point-list (see {@link #getAdjustedPointList(PointList, double, double)}) of
	 * this Shape. Note, that the outer bounds are ignored to calculate the Path, in contrast to most other Shapes. It does not
	 * differenciate between a fill Path and an outline Path.
	 * 
	 * @param outerBounds
	 *            The outer bounds which shall contain the Path. They are calculated from the bounds of this figure by
	 *            {@link GfwFigureUtil#getAdjustedRectangle(Rectangle, double, int)}. Note, that those outline-bounds are just a suggestion
	 *            which works fine for many cases.
	 * @param graphics
	 *            The Graphics on which the outline Path shall be painted. It can be used to react on Graphics specific values, like the
	 *            zoom-level of the Graphics.
	 * @param isFill
	 *            if true, the Path is used for filling the Shape, otherwise for outlining the Shape.
	 * 
	 * @return The Path specifying a polyline for the point-list of this Shape.
	 */
	@Override
	protected Path createPath(Rectangle outerBoundss, Graphics graphics, boolean isFill) {
		// instead of just zooming the translated-points (see
		// getTranslatedPoints()),
		// better do the calculation again by first zooming and then translating
		// to avoid rounding errors.
		double zoom = getZoomLevel(graphics);
		double lw = getLineWidth(graphics);
		PointList points = getAdjustedPointList(getPoints(), zoom, lw);

		List<BezierPoint> bezierPoints = getBezierPoints(points, zoom);
		boolean isClosed = bezierPoints.get(0).equals(bezierPoints.get(bezierPoints.size() - 1));

		Path path = GfwFigureUtil.getBezierPath(bezierPoints, isClosed);
		return path;
	}

	/**
	 * Returns a new list of bezier-points, which is calculated from the given point list.
	 * 
	 * @param points
	 *            The point list, from which to calculate the bezier-points.
	 * @param zoom
	 *            The zoom-level used to adjust the bezier distances.
	 * 
	 * @return a new list of bezier-points, which is calculated from the given point list.
	 */
	protected List<BezierPoint> getBezierPoints(PointList points, double zoom) {
		List<BezierPoint> ret = new ArrayList<BezierPoint>(points.size());
		if (specificBezierDistances != null) {
			for (int i = 0; i < points.size(); i++) {
				int bezierDistanceBefore = (int) (getSpecificBezierDistances()[2 * i] * zoom);
				int bezierDistanceAfter = (int) (getSpecificBezierDistances()[2 * i + 1] * zoom);
				Point point = points.getPoint(i);
				ret.add(new BezierPoint(point.x, point.y, bezierDistanceBefore, bezierDistanceAfter));
			}
		} else {
			for (int i = 0; i < points.size(); i++) {
				int bezierDistance = (int) (getGeneralBezierDistance() * zoom);
				Point point = points.getPoint(i);
				ret.add(new BezierPoint(point.x, point.y, bezierDistance, bezierDistance));
			}
		}
		return ret;
	}
}