/*
 * Created on 17.11.2005
 */
package com.sap.mi.gfw.features.context.impl;

import com.sap.mi.gfw.features.context.ICreateConnectionContext;
import com.sap.mi.gfw.features.context.impl.base.DefaultContext;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

/**
 * The Class CreateConnectionContext.
 */
public class CreateConnectionContext extends DefaultContext implements ICreateConnectionContext {

	private Anchor sourceAnchor;

	private Anchor targetAnchor;

	private PictogramElement sourcePictogramElement;

	private PictogramElement targetPictogramElement;

	/**
	 * Instantiates a new creates the connection context.
	 */
	public CreateConnectionContext() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ICreateConnectionContext#getSourceAnchor()
	 */
	public Anchor getSourceAnchor() {
		return sourceAnchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ICreateConnectionContext#getTargetAnchor()
	 */
	public Anchor getTargetAnchor() {
		return targetAnchor;
	}

	/**
	 * Sets the source anchor.
	 * 
	 * @param sourceAnchor
	 *            The sourceAnchor to set.
	 */
	public void setSourceAnchor(Anchor sourceAnchor) {
		this.sourceAnchor = sourceAnchor;
	}

	/**
	 * Sets the target anchor.
	 * 
	 * @param targetAnchor
	 *            The targetAnchor to set.
	 */
	public void setTargetAnchor(Anchor targetAnchor) {
		this.targetAnchor = targetAnchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ICreateConnectionContext#getSourcePictogramElement()
	 */
	public PictogramElement getSourcePictogramElement() {
		return sourcePictogramElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.context.ICreateConnectionContext#getTargetPictogramElement()
	 */
	public PictogramElement getTargetPictogramElement() {
		return targetPictogramElement;
	}

	/**
	 * Sets the source pictogram element.
	 * 
	 * @param sourcePictogramElement
	 *            the new source pictogram element
	 */
	public void setSourcePictogramElement(PictogramElement sourcePictogramElement) {
		this.sourcePictogramElement = sourcePictogramElement;
	}

	/**
	 * Sets the target pictogram element.
	 * 
	 * @param targetPictogramElement
	 *            the new target pictogram element
	 */
	public void setTargetPictogramElement(PictogramElement targetPictogramElement) {
		this.targetPictogramElement = targetPictogramElement;
	}

	@Override
	public String toString() {
		String ret = super.toString();
		return ret + " sourceAnchor: " + getSourceAnchor() + " targetAnchor: " + getTargetAnchor() + " sourcePictogramElement: " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ getSourcePictogramElement();
	}

}
