package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Path;

import com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;

/**
 * A GFW Rectangle Figure. Most functionality is handled in the super-class. This class only has to define the outline-path and fill-path
 * for the figure-specific painting.
 */
public class GfwRectangleFigure extends GfwAbstractShape {

	/**
	 * Creates a new GfwRectangleFigure.
	 * 
	 * @param pictogramElementDelegate
	 *            The PictogramElementDelegate which provides the GraphicsAlgorithm.
	 * @param graphicsAlgorithm
	 *            The GraphicsAlgorithm which provides the values to paint this Shape.
	 */
	public GfwRectangleFigure(IPictogramElementDelegate pictogramElementDelegate, GraphicsAlgorithm graphicsAlgorithm) {
		super(pictogramElementDelegate, graphicsAlgorithm);
	}

	/**
	 * Returns the Path specifying a rectangle for the given outer bounds. It does not differenciate between a fill Path and an outline
	 * Path.
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
	 * @return The Path specifying a rectangle for the given outer bounds.
	 */
	@Override
	protected Path createPath(Rectangle outerBounds, Graphics graphics, boolean isFill) {
		Path path = new Path(null);
		float x = outerBounds.x;
		float y = outerBounds.y;
		float height = outerBounds.height;
		float width = outerBounds.width;
		path.moveTo(x, y);
		path.addRectangle(x, y, width, height);
		return path;
	}
}
