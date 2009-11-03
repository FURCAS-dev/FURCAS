package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.draw2d.Graphics;

import com.sap.mi.gfw.internal.GaUtilInternal;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;

public class GfwImageFigure extends ImageFigureAntialias {
	private GraphicsAlgorithm graphicsAlgorithm;

	public GfwImageFigure(GraphicsAlgorithm graphicsAlgorithm) {
		this.graphicsAlgorithm = graphicsAlgorithm;
	}

	@Override
	public void paintFigure(Graphics graphics) {
		if (graphicsAlgorithm != null && MoinHelper.isObjectAlive(graphicsAlgorithm)) {
			double transparency = GaUtilInternal.getTransparency(graphicsAlgorithm, true);
			int alpha = (int) ((1.0 - transparency) * 255.0);
			graphics.setAlpha(alpha);
		}
		super.paintFigure(graphics);
	}
}
