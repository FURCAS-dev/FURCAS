package com.sap.mi.gfw.eclipse.internal.util.ui.sfx;

/***********************************************************************************************************************
 * Copyright (c) 2003, 2005 IBM Corporation and others. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: IBM Corporation - initial API and implementation
 **********************************************************************************************************************/

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGuides;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.gfw.eclipse.internal.IDisposable;
import com.sap.mi.gfw.eclipse.internal.policy.ResourceManagingGraphicalEditPolicy;
import com.sap.mi.gfw.eclipse.internal.util.draw2d.GFColorConstants;

/**
 * An EditPolicy that is used to show snap feedback for guides (red lines) and geometry (blue lines). This policy is not required for Grids.
 * 
 * @author Randy Hudson
 * @author Pratik Shah
 * @since 3.0
 */
public class GFSnapFeedbackPolicy extends ResourceManagingGraphicalEditPolicy {
	IFigure guide[] = new IFigure[6];

	Integer location[] = new Integer[6];

	/**
	 * @see org.eclipse.gef.EditPolicy#eraseTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		for (int i = 0; i < guide.length; i++) {
			if (guide[i] != null)
				removeFeedback(guide[i]);
			guide[i] = null;
			location[i] = null;
		}
	}

	class FadeIn extends Figure implements IDisposable {
		int opacity = 0;

		static final int FRAMES = 6;

		Image image;

		int count;

		FadeIn(Color bg) {
			setBackgroundColor(bg);
			super.setOpaque(true);
		}

		/**
		 * @see org.eclipse.draw2d.IFigure#getLocalBackgroundColor()
		 */
		@Override
		public Color getLocalBackgroundColor() {
			Color localBackgroundColor = super.getLocalBackgroundColor();
			Color parentBackgroundColor = getParent().getBackgroundColor();
			Color temp = FigureUtilities.mixColors(localBackgroundColor, parentBackgroundColor, (double) opacity / FRAMES);
			Color mixColors = manageColor(temp);
			return mixColors;
		}

		/**
		 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
		 */
		@Override
		protected void paintFigure(Graphics graphics) {
			if (opacity != FRAMES) {
				if (image != null) {
					image.dispose();
					count--;
					image = null;
				}
				if (opacity != FRAMES - 1) {
					Display display = Display.getCurrent();
					PaletteData pData = new PaletteData(0xFF, 0xFF00, 0xFF0000);
					int fillColor = pData.getPixel(getLocalBackgroundColor().getRGB());
					ImageData iData = new ImageData(1, 1, 24, pData);
					iData.setPixel(0, 0, fillColor);
					iData.setAlpha(0, 0, 255 * opacity / FRAMES);
					image = new Image(display, iData);
					count++;
				}
				Display.getCurrent().timerExec(100, new Runnable() {
					public void run() {
						opacity = Math.min(FRAMES, opacity + 1);
						repaint();
					}
				});
			}
			Rectangle r = getBounds();
			if (image != null)
				graphics.drawImage(image, 0, 0, 1, 1, r.x, r.y, r.width, r.height);
			else
				super.paintFigure(graphics);
		}

		/**
		 * @see org.eclipse.draw2d.Figure#removeNotify()
		 */
		@Override
		public void removeNotify() {
			if (image != null) {
				image.dispose();
				count--;
				image = null;
			}
		}

		public void dispose() {
			getResourceRegistry().dispose();
		}
	}

	// Even offset indicates a vertical feedback line; odd, horizontal.
	void highlightGuide(Integer pos, Color color, int offset) {
		if (pos == null) {
			if (guide[offset] != null) {
				removeFeedback(guide[offset]);
				guide[offset] = null;
			}
			location[offset] = pos;
			return;
		}

		// pos is an integer relative to target's client area.
		// translate pos to absolute, and then make it relative to fig.
		int position = pos.intValue();
		PrecisionPoint loc = new PrecisionPoint(position, position);
		IFigure contentPane = ((GraphicalEditPart) getHost()).getContentPane();
		contentPane.translateToParent(loc);
		contentPane.translateToAbsolute(loc);

		if (location[offset] == null || !location[offset].equals(pos)) {
			location[offset] = pos;
			if (guide[offset] != null) {
				removeFeedback(guide[offset]);
				guide[offset] = null;
			}

			IFigure fig = new FadeIn(color);
			guide[offset] = fig;
			addFeedback(fig);
			fig.translateToRelative(loc);
			position = offset % 2 == 0 ? (int) Math.round(loc.preciseX) : (int) Math.round(loc.preciseY);
			Rectangle figBounds = getFeedbackLayer().getBounds().getCopy();
			if ((offset % 2) == 1) {
				figBounds.height = 2;
				figBounds.y = position;
			} else {
				figBounds.x = position;
				figBounds.width = 2;
			}
			fig.setBounds(figBounds);
		} else {
			// The feedback layer could have grown (if auto-scrolling), so
			// resize the fade-in
			// line.
			IFigure fig = guide[offset];
			Rectangle figBounds = fig.getBounds().getCopy();
			Rectangle feedbackBounds = getFeedbackLayer().getBounds();
			if ((offset % 2) == 1) {
				figBounds.x = feedbackBounds.x;
				figBounds.width = feedbackBounds.width;
			} else {
				figBounds.y = feedbackBounds.y;
				figBounds.height = feedbackBounds.height;
			}
			fig.setBounds(figBounds);
		}
	}

	/**
	 * @see org.eclipse.gef.EditPolicy#showTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void showTargetFeedback(Request req) {
		if (req.getType().equals(REQ_MOVE) || req.getType().equals(REQ_RESIZE) || req.getType().equals(REQ_CLONE)
				|| req.getType().equals(REQ_ADD) || req.getType().equals(REQ_CREATE)) {

			Integer value;
			value = (Integer) req.getExtendedData().get(SnapToGeometry.KEY_WEST_ANCHOR);
			highlightGuide(value, GFColorConstants.HANDLE_BG, 0);

			value = (Integer) req.getExtendedData().get(SnapToGeometry.KEY_NORTH_ANCHOR);
			highlightGuide(value, GFColorConstants.HANDLE_BG, 1);

			value = (Integer) req.getExtendedData().get(SnapToGeometry.KEY_EAST_ANCHOR);
			highlightGuide(value, GFColorConstants.HANDLE_BG, 2);

			value = (Integer) req.getExtendedData().get(SnapToGeometry.KEY_SOUTH_ANCHOR);
			highlightGuide(value, GFColorConstants.HANDLE_BG, 3);

			value = (Integer) req.getExtendedData().get(SnapToGuides.KEY_VERTICAL_GUIDE);
			highlightGuide(value, ColorConstants.red, 4);

			value = (Integer) req.getExtendedData().get(SnapToGuides.KEY_HORIZONTAL_GUIDE);
			highlightGuide(value, ColorConstants.red, 5);
		}
	}

	@Override
	protected void removeFeedback(IFigure figure) {
		super.removeFeedback(figure);
		disposeFigure(figure);
	}

}
