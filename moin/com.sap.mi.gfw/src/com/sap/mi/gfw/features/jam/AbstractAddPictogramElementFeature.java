package com.sap.mi.gfw.features.jam;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IAreaContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.impl.AbstractAddFeature;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.GaUtil;

/**
 * Add feature especially for pictogram elements.
 */
public abstract class AbstractAddPictogramElementFeature extends AbstractAddFeature {

	/**
	 * The Constructor.
	 * 
	 * @param fp
	 *            the fp
	 */
	public AbstractAddPictogramElementFeature(IFeatureProvider fp) {
		super(fp);
	}

	/**
	 * Checks if the pictogram element could be updated. This implementation asks the feature provider for available update features.
	 * 
	 * @param pe
	 *            the pictogram element
	 * 
	 * @return true, if the update could be processed
	 */
	protected boolean canUpdatePictogramElement(PictogramElement pe) {
		boolean ret = false;
		UpdateContext context = new UpdateContext(pe);
		ret = getFeatureProvider().canUpdate(context).toBoolean();
		return ret;
	}

	/**
	 * Checks if the pictogram element has to be updated. This implementation asks the feature provider for available update features.
	 * 
	 * @param pe
	 *            the pe
	 * 
	 * @return true, if update pictogram element needed
	 */
	protected boolean updatePictogramElementNeeded(PictogramElement pe) {
		boolean ret = false;
		UpdateContext updateSemanticsContext = new UpdateContext(pe);
		ret = getFeatureProvider().updateNeeded(updateSemanticsContext).toBoolean();
		return ret;
	}

	/**
	 * This is a convenience method for layouting a graphics algorithm.
	 * 
	 * @param ga
	 *            the ga
	 * @param minWidth
	 *            minimum width
	 * @param minHeight
	 *            minimum height
	 * @param context
	 *            the layout context
	 */
	protected void setSizeAndLocation(GraphicsAlgorithm ga, int minWidth, int minHeight, IAreaContext context) {
		int x = context.getX();
		int y = context.getY();
		int width = context.getWidth();
		int height = context.getHeight();

		// set min-size if user didn't draw a rectangle
		if (width < 0 && height < 0) {
			height = minHeight;
			width = minWidth;
		}

		GaUtil.setLocationAndSizeOfGraphicsAlgorithm(ga, x, y, width, height);
	}
}
