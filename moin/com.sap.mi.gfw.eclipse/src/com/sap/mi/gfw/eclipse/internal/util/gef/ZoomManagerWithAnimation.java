package com.sap.mi.gfw.eclipse.internal.util.gef;

import org.eclipse.draw2d.ScalableFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.gfw.GfwTestConfiguration;
import com.sap.mi.gfw.eclipse.internal.editor.GFWFigureCanvas;

/**
 * Enhances the default ZoomManager by animating the change of the zoom. This is done by implicitely replacing every change of the zoom by a
 * sequence of changes, which range from the old zoom to the new zoom.
 */
public class ZoomManagerWithAnimation extends ZoomManager {

	ScrollingGraphicalViewer viewer = null;
	private static int totalSteps = 5;

	/**
	 * Creates a new ZoomManagerWithAnimation.
	 */
	public ZoomManagerWithAnimation(ScalableFigure pane, Viewport viewport, ScrollingGraphicalViewer viewer) {
		super(pane, viewport);
		this.viewer = viewer;
	}

	/**
	 * Sets many zoom-levels to create the animation-effect.
	 * 
	 * @see org.eclipse.gef.editparts.ZoomManager#primSetZoom(double)
	 */
	@Override
	protected void primSetZoom(double zoom) {
		// int totalSteps = getTotalSteps();
		double currentZoom = getZoom();
		zoomSqrt(currentZoom, zoom, totalSteps);
		super.primSetZoom(zoom); // the last one is the original value, so rounding-errors are avoided
	}

	/**
	 * Returns the zoomLevel needed so that the diagram shapes fit on the screen. In order to calculate the correct size, the invisible
	 * corner pixels which we need to have the scroll bars always present, are removed and added later again. If this is not the
	 * GFWFigureCanvas, the corresponding super method is called.
	 * 
	 * @return zoom setting required to fit the entire scalable figure on the screen
	 */
	@Override
	protected double getFitPageZoomLevel() {
		double zoomLevel = 1D;
		if (viewer != null) {
			Control control = viewer.getControl();
			if (control instanceof GFWFigureCanvas) {
				GFWFigureCanvas gfwFigureCanvas = (GFWFigureCanvas) control;
				gfwFigureCanvas.removeCornerPixels();
				zoomLevel = getFitXZoomLevel(2, gfwFigureCanvas);
				gfwFigureCanvas.setCornerPixels();
				return zoomLevel;
			} else {
				return super.getFitPageZoomLevel();
			}
		}

		return super.getFitPageZoomLevel();
	}

	/**
	 * Calculates the zoom-steps using a square root algorithm.
	 */
	private void zoomSqrt(double currentZoom, double targetZoom, int totalSteps) {
		double currentZoom2 = Math.sqrt(currentZoom);
		double targetZoom2 = Math.sqrt(targetZoom);
		double delta = (targetZoom2 - currentZoom2) / totalSteps;
		for (int i = 0; i < totalSteps; i++) {
			currentZoom2 += delta;
			super.primSetZoom(currentZoom2 * currentZoom2);
			stepPerformed();
		}
	}

	/**
	 * Is called after each performed step.
	 * <p>
	 * By default it dispatches all pending events of the current Display. This is important, because typically the steps do something which
	 * shall be visible to the user. By dispatching the events all updates to the UI will be performed.
	 */
	public void stepPerformed() {
		while (true) {
			if (!Display.getCurrent().readAndDispatch())
				break;
		}
	}

	/**
	 * Returns the total number of steps. Should be called on every execute() and undo(), so that always the last preference-value is used.
	 * 
	 * @return The total number of steps.
	 */
	public int getTotalSteps() {
		// return '0' to solve problem described in CSN 0120061532 0006043421 2007
		int totalSteps = GfwTestConfiguration.getZoomAnimationSteps();
		return totalSteps;
	}

	/**
	 * Returns the zoomLevel needed so that the diagram shapes fit horizontally on the screen. In order to calculate the correct size, the
	 * invisible corner pixels which we need to have the scroll bars always present, are removed and added later again. If this is not the
	 * GFWFigureCanvas, the corresponding super method is called.
	 * 
	 * @return zoom setting required to fit the scalable figure horizontally on the screen
	 */
	@Override
	protected double getFitWidthZoomLevel() {
		double zoomLevel = 1D;
		if (viewer != null) {
			Control control = viewer.getControl();
			if (control instanceof GFWFigureCanvas) {
				GFWFigureCanvas gfwFigureCanvas = (GFWFigureCanvas) control;
				gfwFigureCanvas.removeCornerPixels();
				zoomLevel = getFitXZoomLevel(0, gfwFigureCanvas);
				gfwFigureCanvas.setCornerPixels();
				return zoomLevel;
			} else {
				return super.getFitWidthZoomLevel();
			}
		}
		return super.getFitWidthZoomLevel();
	}

	/**
	 * Returns the zoomLevel needed so that the diagram shapes fit vertically on the screen. In order to calculate the correct size, the
	 * invisible corner pixels which we need to have the scroll bars always present, are removed and added later again. If this is not the
	 * GFWFigureCanvas, the corresponding super method is called.
	 * 
	 * @return zoom setting required to fit the scalable figure vertically on the screen
	 */
	@Override
	protected double getFitHeightZoomLevel() {
		double zoomLevel = 1D;
		if (viewer != null) {
			Control control = viewer.getControl();
			if (control instanceof GFWFigureCanvas) {
				GFWFigureCanvas gfwFigureCanvas = (GFWFigureCanvas) control;
				gfwFigureCanvas.removeCornerPixels();
				zoomLevel = getFitXZoomLevel(1, gfwFigureCanvas);
				gfwFigureCanvas.setCornerPixels();
				return zoomLevel;
			} else {
				return super.getFitHeightZoomLevel();
			}
		}
		return super.getFitHeightZoomLevel();
	}

	private double getFitXZoomLevel(int which, GFWFigureCanvas gfwFigureCanvas) {
		Dimension available = getViewport().getClientArea().getSize();
		Dimension desired = gfwFigureCanvas.getDiagramBoundsFromEditPartChildren().getSize();

		double scaleX = Math.min((double) available.width / (double) desired.width, getMaxZoom());
		double scaleY = Math.min((double) available.height / (double) desired.height, getMaxZoom());
		if (which == 0)
			return scaleX;
		if (which == 1)
			return scaleY;
		return Math.min(scaleX, scaleY);
	}
}
