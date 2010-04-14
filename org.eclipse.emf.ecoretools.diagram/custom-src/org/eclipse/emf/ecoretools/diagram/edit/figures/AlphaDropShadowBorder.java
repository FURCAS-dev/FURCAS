/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Simon Bernard (Anyware Technologies) - initial API and implementation
 *
 * $Id: AlphaDropShadowBorder.java,v 1.1 2008/08/12 13:24:50 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.edit.figures;

import org.eclipse.draw2d.AbstractBackground;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.DropShadowBorder;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IPolygonAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.graphics.Color;

/**
 * A border using a shadow<br>
 * creation : 17 mai. 08
 * 
 * @author <a href="mailto:simon.bernard@anyware-tech.com">Simon Bernard</a>
 */
public class AlphaDropShadowBorder extends AbstractBackground implements DropShadowBorder {

	private static final int DEFAULT_SHIFT_VALUE = 1;

	private static final Color SHADOW_COLOR = DiagramColorConstants.diagramDarkGray;

	private static final int DEFAULT_TRANSPARENCY = 65;

	private boolean shouldDrawShadow = true;

	private int shift = DEFAULT_SHIFT_VALUE;

	public void setShouldDrawDropShadow(boolean drawDropShadow) {
		shouldDrawShadow = drawDropShadow;
	}

	public boolean shouldDrawDropShadow() {
		return shouldDrawShadow;
	}

	/**
	 * Method for determining the inset the border will take up on the shape.
	 * 
	 * @param figure
	 *            Figure that will be inset from the border
	 * @return Insets the Insets for the border on the given figure.
	 */
	public Insets getInsets(IFigure figure) {
		Insets insetsNew = new Insets();
		insetsNew.top = 0;
		insetsNew.left = 0;
		insetsNew.bottom = MapModeUtil.getMapMode(figure).DPtoLP(shift * 2);
		insetsNew.right = MapModeUtil.getMapMode(figure).DPtoLP(shift * 2);
		return insetsNew;
	}

	public Insets getTransparentInsets(IFigure figure) {
		Insets insetsNew = new Insets();
		insetsNew.top = 0;
		insetsNew.left = 0;
		insetsNew.bottom = MapModeUtil.getMapMode(figure).DPtoLP(shift * 2);
		insetsNew.right = MapModeUtil.getMapMode(figure).DPtoLP(shift * 2);
		return insetsNew;
	}

	@Override
	public void paintBackground(IFigure figure, Graphics graphics, Insets insets) {
		if (shouldDrawDropShadow()) {
			graphics.pushState();
			graphics.setBackgroundColor(SHADOW_COLOR);
			graphics.setAlpha(DEFAULT_TRANSPARENCY);

			if (figure instanceof IPolygonAnchorableFigure) {
				PointList polygonPoints = ((IPolygonAnchorableFigure) figure).getPolygonPoints();
				polygonPoints.translate(shift, shift);
				graphics.fillPolygon(polygonPoints);
				polygonPoints.translate(shift, shift);
				graphics.fillPolygon(polygonPoints);
			} else {
				Rectangle bounds = figure.getBounds().getCopy();
				bounds.translate(shift, shift);
				graphics.fillRoundRectangle(bounds, 0, 0);
				bounds.translate(shift, shift);
				graphics.fillRoundRectangle(bounds, 0, 0);
			}

			graphics.popState();
		}
	}
}
