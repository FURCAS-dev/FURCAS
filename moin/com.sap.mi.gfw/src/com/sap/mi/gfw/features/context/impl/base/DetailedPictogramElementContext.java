package com.sap.mi.gfw.features.context.impl.base;

import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class DetailedPictogramElementContext.
 */
public abstract class DetailedPictogramElementContext extends PictogramElementContext {
	private GraphicsAlgorithm graphicsAlgorithm;

	/**
	 * The Constructor.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @param graphicsAlgorithm
	 *            the graphics algorithm
	 */
	public DetailedPictogramElementContext(PictogramElement pictogramElement, GraphicsAlgorithm graphicsAlgorithm) {
		super(pictogramElement);
		this.graphicsAlgorithm = graphicsAlgorithm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IDirectEditingContext#getGraphicsAlgorithm()
	 */
	/**
	 * Gets the graphics algorithm.
	 * 
	 * @return the graphics algorithm
	 */
	public GraphicsAlgorithm getGraphicsAlgorithm() {
		return graphicsAlgorithm;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " graphicsAlgorithm: " + getGraphicsAlgorithm(); //$NON-NLS-1$
	}

}
