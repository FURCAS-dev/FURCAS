package com.sap.mi.gfw.eclipse.internal.fixed;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.ScalableLayeredPane;
import org.eclipse.gef.editparts.ScalableRootEditPart;

/**
 * The Class FixedScalableRootEditPart.
 */
public class FixedScalableRootEditPart extends ScalableRootEditPart {

	/**
	 * Creates a scalable layered pane and the layers that should be scaled.
	 * 
	 * @return a new <code>ScalableLayeredPane</code> containing the scalable layers
	 */
	@Override
	protected ScalableLayeredPane createScaledLayers() {
		ScalableLayeredPane layers = new ScalableLayeredPane();
		layers.add(createGridLayer(), GRID_LAYER);
		layers.add(getPrintableLayers(), PRINTABLE_LAYERS);
		layers.add(new FeedbackLayer(), SCALED_FEEDBACK_LAYER);
		return layers;
	}

	/**
	 * The Class FeedbackLayer.
	 */
	class FeedbackLayer extends FreeformLayer {

		/**
		 * Instantiates a new feedback layer.
		 */
		FeedbackLayer() {
			setEnabled(false);
		}
	}
}
