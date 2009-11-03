package com.sap.mi.gfw.eclipse.internal.fixed;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ScalableFreeformLayeredPane;

/**
 * The Class FixedScalableFreeformLayeredPane.
 */
public class FixedScalableFreeformLayeredPane extends ScalableFreeformLayeredPane {
	/**
	 * Paint client area.
	 * 
	 * @param graphics
	 *            the graphics
	 * 
	 * @see org.eclipse.draw2d.Figure#paintClientArea(Graphics)
	 */
	@Override
	protected void paintClientArea(Graphics graphics) {
		if (getChildren().isEmpty())
			return;
		if (false && getScale() == 1.0) { // deactivated; always use
			// FixedScaledGraphics for
			// consistency
			super.paintClientArea(graphics);
		} else {
			Graphics g = new FixedScaledGraphics(graphics);
			boolean optimizeClip = getBorder() == null || getBorder().isOpaque();
			if (!optimizeClip)
				g.clipRect(getBounds().getCropped(getInsets()));
			g.scale(getScale());
			g.pushState();
			paintChildren(g);
			g.dispose();
			graphics.restoreState();
		}
	}
}
