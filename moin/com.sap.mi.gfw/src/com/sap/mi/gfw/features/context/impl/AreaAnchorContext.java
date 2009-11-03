/*
 * Created on 16.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IMoveAnchorContext;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;

/**
 * The Class AreaAnchorContext.
 */
public class AreaAnchorContext extends AreaContext implements IMoveAnchorContext {

	private Anchor anchor;

	private AnchorContainer sourceContainer;

	private AnchorContainer targetContainer;

	/**
	 * The Constructor.
	 * 
	 * @param anchor
	 *            the anchor
	 */
	public AreaAnchorContext(Anchor anchor) {
		super();
		setAnchor(anchor);
	}

	/**
	 * Gets the anchor.
	 * 
	 * @return Returns the anchor.
	 */
	public Anchor getAnchor() {
		return anchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IMoveAnchorContext#getSourceContainer()
	 */
	public AnchorContainer getSourceContainer() {
		return sourceContainer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IMoveAnchorContext#getTargetContainer()
	 */
	public AnchorContainer getTargetContainer() {
		return targetContainer;
	}

	/**
	 * Sets the source container.
	 * 
	 * @param sourceContainer
	 *            The sourceContainer to set.
	 */
	public void setSourceContainer(AnchorContainer sourceContainer) {
		this.sourceContainer = sourceContainer;
	}

	/**
	 * Sets the target container.
	 * 
	 * @param targetContainer
	 *            The targetContainer to set.
	 */
	public void setTargetContainer(AnchorContainer targetContainer) {
		this.targetContainer = targetContainer;
	}

	/**
	 * @param anchor
	 *            The anchor to set.
	 */
	private void setAnchor(Anchor anchor) {
		this.anchor = anchor;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " anchor: " + getAnchor() + " sourceContainer: " + getSourceContainer() + " targetContainer: " + getTargetContainer(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

}
