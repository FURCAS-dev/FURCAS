package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import com.sap.mi.gfw.eclipse.internal.parts.IPictogramElementDelegate;
import com.sap.mi.gfw.internal.GaUtilInternal;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Text;

public class GfwText extends Label {
	private GraphicsAlgorithm graphicsAlgorithm;

	private int labelAlignment = CENTER;

	public GfwText(IPictogramElementDelegate pictogramElementDelegate, GraphicsAlgorithm graphicsAlgorithm) {
		this.graphicsAlgorithm = graphicsAlgorithm;
	}

	public int getLabelAlignment() {
		return labelAlignment;
	}

	@Override
	public void paintFigure(Graphics graphics) {
		if (graphicsAlgorithm != null && MoinHelper.isObjectAlive(graphicsAlgorithm)) {
			double transparency = GaUtilInternal.getTransparency(graphicsAlgorithm, true);
			int alpha = (int) ((1.0 - transparency) * 255.0);
			graphics.setAlpha(alpha);

			graphics.setTextAntialias(SWT.ON);

			int angle = 0;
			if (graphicsAlgorithm instanceof Text) {
				Text textGa = (Text) graphicsAlgorithm;
				angle = GaUtilInternal.getAngle(textGa, true);
			}

			if (angle != 0) {
				Rectangle rect = new Rectangle();
				graphics.getClip(rect);
				graphics.pushState();
				Rectangle bounds = getBounds();
				int w = bounds.width;
				int h = bounds.height;
				bounds.height = w;
				bounds.width = h;
				graphics.translate(bounds.x, bounds.y + h); // TODO caluclate
				// the offset to x
				// and y based on
				// angle
				graphics.rotate(angle);
				rect = new Rectangle(0, 0, 1000, 1000); // TODO calculate the
				// real clip rectangle
				// from the angle
				graphics.setClip(rect);
				graphics.drawText(getSubStringText(), getTextLocation());

				bounds.height = h;
				bounds.width = w;

				graphics.popState();
				return;

			}
		}

		super.paintFigure(graphics);

	}

	@Override
	public void setLabelAlignment(int align) {
		super.setLabelAlignment(align);
		labelAlignment = align;
	}
}
