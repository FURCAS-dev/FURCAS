package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.IAddConnectionContext;
import com.sap.mi.gfw.mm.pictograms.Anchor;

/**
 * The Class AddConnectionContext.
 */
public class AddConnectionContext extends AddContext implements IAddConnectionContext {

	/**
	 * The target anchor.
	 */
	Anchor sourceAnchor, targetAnchor;

	/**
	 * Instantiates a new adds the connection context.
	 * 
	 * @param sourceAnchor
	 *            the source anchor
	 * @param targetAnchor
	 *            the target anchor
	 */
	public AddConnectionContext(Anchor sourceAnchor, Anchor targetAnchor) {
		super();
		this.sourceAnchor = sourceAnchor;
		this.targetAnchor = targetAnchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IConnectionContext#getSourceAnchor()
	 */
	public Anchor getSourceAnchor() {
		return sourceAnchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.IConnectionContext#getTargetAnchor()
	 */
	public Anchor getTargetAnchor() {
		return targetAnchor;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " sourceAnchore: " + getSourceAnchor() + " targetAnchor: " + getTargetAnchor(); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
