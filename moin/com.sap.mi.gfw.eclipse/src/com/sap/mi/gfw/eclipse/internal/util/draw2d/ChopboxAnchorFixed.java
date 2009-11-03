package com.sap.mi.gfw.eclipse.internal.util.draw2d;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import com.sap.mi.gfw.eclipse.internal.util.Util;

/**
 * The purpose of this class is to fix bugs in the {@link ChopboxAnchor} by overwriting the erroneous methods.
 */
public class ChopboxAnchorFixed extends ChopboxAnchor {

	public ChopboxAnchorFixed(IFigure figure) {
		super(figure);
	}

	/**
	 * CHANGED: if the reference is in the center of the figure, the result was not correct. This method has to be kept in sync with
	 * {@link Util#getChopboxLocationOnBox(Point, Rectangle)}.
	 */
	@Override
	public Point getLocation(Point reference) {
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getBox());
		r.translate(-1, -1);
		r.resize(1, 1);

		getOwner().translateToAbsolute(r);
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
}
