package com.sap.mi.gfw.eclipse.internal.fixed;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.ScalableFreeformLayeredPane;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;

/**
 * The Class FixedScalableFreeformRootEditPart.
 */
public class FixedScalableFreeformRootEditPart extends ScalableFreeformRootEditPart {

	/**
	 * Creates a layered pane and the layers that should be scaled.
	 * 
	 * @return a new freeform layered pane containing the scalable layers
	 */
	@Override
	protected ScalableFreeformLayeredPane createScaledLayers() {
		ScalableFreeformLayeredPane layers = new FixedScalableFreeformLayeredPane();
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
