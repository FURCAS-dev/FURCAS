package com.sap.mi.gfw.features.impl;

import com.sap.mi.gfw.features.IDirectEditingInfo;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class DefaultDirectEditingInfo.
 */
public class DefaultDirectEditingInfo implements IDirectEditingInfo {

	private PictogramElement mainPictogramElement;

	private PictogramElement pictogramElement;

	private GraphicsAlgorithm graphicsAlgorithm;

	private boolean isActive = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingInfo#getGraphicsAlgorithm()
	 */
	public GraphicsAlgorithm getGraphicsAlgorithm() {
		return graphicsAlgorithm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingInfo#getMainPictogramElement()
	 */
	public PictogramElement getMainPictogramElement() {
		return mainPictogramElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingInfo#getPictogramElement()
	 */
	public PictogramElement getPictogramElement() {
		return pictogramElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingInfo#isActive()
	 */
	public boolean isActive() {
		return isActive;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingInfo#reset()
	 */
	public void reset() {
		setMainPictogramElement(null);
		setPictogramElement(null);
		setGraphicsAlgorithm(null);
		setActive(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingInfo#setActive(boolean)
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingInfo#setGraphicsAlgorithm(com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm)
	 */
	public void setGraphicsAlgorithm(GraphicsAlgorithm graphicsAlgorithm) {
		this.graphicsAlgorithm = graphicsAlgorithm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingInfo#setMainPictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public void setMainPictogramElement(PictogramElement pictogramElement) {
		this.mainPictogramElement = pictogramElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IDirectEditingInfo#setPictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public void setPictogramElement(PictogramElement pictogramElement) {
		this.pictogramElement = pictogramElement;
	}
}
