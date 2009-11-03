package com.sap.mi.gfw.eclipse.internal.util.draw2d;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

public class TransparentGhostFigure extends ImageFigure {
	private IFigure figure = null;

	private int alpha;

	private double zoomLevel = 1;

	public TransparentGhostFigure(IFigure figure, int alpha, double zoomLevel) {
		this.figure = figure;
		this.alpha = alpha;
		this.zoomLevel = zoomLevel;

		setOpaque(false);

		// do not set the image any more (see CSN 0120061532 0000510151 2009)
		// setImage(generateImage());
	}

	/**
	 * creates a ghost image - don�t forget to dispose!
	 * 
	 * @return the ghost image.
	 */
	private Image generateImage() {
		if (figure == null)
			return null;

		Rectangle bounds;
		if (figure instanceof HandleBounds) {
			bounds = ((HandleBounds) figure).getHandleBounds().getCopy();
		} else {
			bounds = figure.getBounds().getCopy();
		}

		bounds.scale(zoomLevel);

		Image image = new Image(Display.getCurrent(), bounds.width, bounds.height);

		GC gc = new GC(image);
		SWTGraphics swtGraphics = new SWTGraphics(gc);
		swtGraphics.translate(-bounds.x, -bounds.y);

		swtGraphics.scale(zoomLevel);

		figure.paint(swtGraphics);

		ImageData data = image.getImageData();
		data.alpha = alpha;

		image.dispose();
		swtGraphics.dispose();
		gc.dispose();
		return new Image(Display.getCurrent(), data);

	}

	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		graphics.setAlpha(alpha); // fill transparent gray rectangle
		graphics.setBackgroundColor(ColorConstants.lightGray);
		graphics.fillRectangle(getClientArea().getCropped(new Insets(0, 0, 1, 1)));
		graphics.setAlpha(255); // draw non-transparent dotted rectangle border
		graphics.setLineStyle(Graphics.LINE_DOT);
		graphics.drawRectangle(getClientArea().getCropped(new Insets(0, 0, 1, 1)));
	}

	public void dispose() {
		if (getImage() != null) {
			getImage().dispose();
		}
	}
}
