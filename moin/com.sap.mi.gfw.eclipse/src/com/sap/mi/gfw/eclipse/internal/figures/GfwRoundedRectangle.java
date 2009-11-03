package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Path;

import com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;

/**
 * A GFW Rounded Rectangle Figure. Most functionality is handled in the super-class. This class only has to define the outline-path and
 * fill-path for the figure-specific painting.
 */
public class GfwRoundedRectangle extends GfwAbstractShape {

	/**
	 * The corner-dimensions of this rounded rectangle.
	 */
	protected Dimension corner = new Dimension(8, 8);

	/**
	 * Creates a new GfwRoundedRectangle.
	 * 
	 * @param pictogramElementDelegate
	 *            The PictogramElementDelegate which provides the GraphicsAlgorithm.
	 * @param graphicsAlgorithm
	 *            The GraphicsAlgorithm which provides the values to paint this Shape.
	 */
	public GfwRoundedRectangle(IPictogramElementDelegate pictogramElementDelegate, GraphicsAlgorithm graphicsAlgorithm) {
		super(pictogramElementDelegate, graphicsAlgorithm);
	}

	/**
	 * Sets the corner-dimensions of this rounded rectangle.
	 * 
	 * @param cornerDimensions
	 *            The corner-dimensions to set.
	 */
	public void setCornerDimensions(Dimension cornerDimensions) {
		corner.width = cornerDimensions.width;
		corner.height = cornerDimensions.height;
	}

	/**
	 * Returns the Path specifying a rounded rectangle for the given outer bounds. The fill Path is slightly different from the outline
	 * Path, because the corner-dimensions have to be adjusted a bit.
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
	 * @return The Path specifying a rounded rectangle for the given outer bounds.
	 */
	@Override
	protected Path createPath(Rectangle outerBounds, Graphics graphics, boolean isFill) {
		Path path = new Path(null);
		float x = outerBounds.x;
		float y = outerBounds.y;
		float height = outerBounds.height;
		float width = outerBounds.width;
		float bottom = y + height;
		float right = x + width;

		double zoom = getZoomLevel(graphics);
		int lineWidth = getLineWidth(graphics);

		// the half cornersize is the length of the arc,
		// so two time the half cornersize must not be longer than the side
		// itself
		float cornerWidth = (float) (corner.width * zoom);
		float cornerHeight = (float) (corner.height * zoom);
		cornerWidth = (cornerWidth > width) ? width : cornerWidth;
		cornerHeight = (cornerHeight > height) ? height : cornerHeight;

		if (isFill) {
			// adjust corner for the inner path (formula found by experimenting)
			cornerHeight = Math.max(1, cornerHeight - (lineWidth + cornerHeight / 64));
			cornerWidth = Math.max(1, cornerWidth - (lineWidth + cornerWidth / 64));
		}

		// workaround: path must be usual rectangle, if corner=0
		// otherwise the path is not drawn at all (same happens
		// RoundedRectangles)
		if (cornerHeight <= 0 || cornerWidth <= 0) {
			path.addRectangle(x, y, width, height);
		} else {
			path.moveTo(x, y);
			path.addArc(x, y, cornerWidth, cornerHeight, 90, 90);
			path.addArc(x, bottom - cornerHeight, cornerWidth, cornerHeight, 180, 90);
			path.addArc(right - cornerWidth, bottom - cornerHeight, cornerWidth, cornerHeight, 270, 90);
			path.addArc(right - cornerWidth, y, cornerWidth, cornerHeight, 0, 90);
			path.close();
		}

		return path;
	}
}
