package com.sap.mi.gfw.eclipse.internal.util.gef;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayeredPane;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.ScalableFreeformLayeredPane;
import org.eclipse.draw2d.Viewport;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;

import com.sap.mi.gfw.eclipse.internal.fixed.FixedScalableFreeformRootEditPart;

/**
 * A subclass of the ScalableRootEditPart, which just replaces the default ZoomManager with a ZoomManagerWithAnimation (unfortunately there
 * is no method setZoomManager() on the ScalableRootEditPart)
 */
public class ScalableRootEditPartAnimated extends FixedScalableFreeformRootEditPart {

	private ZoomManagerWithAnimation zoomManagerWithAnimation;

	private static boolean connectionLayerOnTop = true; // true means default

	// behavior

	/**
	 * Creates a new ScalableRootEditPartAnimated.
	 */
	public ScalableRootEditPartAnimated(ScrollingGraphicalViewer viewer) {
		zoomManagerWithAnimation = new ZoomManagerWithAnimation((ScalableFreeformLayeredPane) getScaledLayers(), ((Viewport) getFigure()),
				viewer);
	}

	@Override
	protected void createLayers(LayeredPane layeredPane) {
		super.createLayers(layeredPane);

		// THIS IS A WORKAROUND: PROBLEM WITH HANDLES MOVING POLYGONS WITH LINE
		// WIDTH = 1
		layeredPane.remove(getLayer(HANDLE_LAYER));
		layeredPane.add(new FreeformLayer() {
			@Override
			public void validate() {

				setValid(false);
				super.validate();
			}
		}, HANDLE_LAYER);
		// END WORKAROUND
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.ScalableRootEditPart#getZoomManager()
	 */
	@Override
	public ZoomManager getZoomManager() {
		return zoomManagerWithAnimation;
	}

	@Override
	protected LayeredPane createPrintableLayers() {
		if (connectionLayerOnTop) {
			return super.createPrintableLayers();
		} else {
			FreeformLayeredPane layeredPane = new FreeformLayeredPane();
			layeredPane.add(new ConnectionLayer(), CONNECTION_LAYER);
			layeredPane.add(new FreeformLayer(), PRIMARY_LAYER);
			return layeredPane;
		}
	}
}
