package com.sap.mi.gfw.eclipse.internal.requests;

import com.sap.mi.gfw.eclipse.internal.parts.directedit.IDirectEditHolder;

/**
 * This direct edit request extends the existing one with a direct edit holder
 */

public class GfwDirectEditRequest extends org.eclipse.gef.requests.DirectEditRequest {

	private IDirectEditHolder directEditHolder;

	/**
	 * returns the IDirectEditHolder
	 * 
	 * @return IDirectEditHolder
	 */
	public IDirectEditHolder getDirectEditHolder() {
		return directEditHolder;
	}

	/**
	 * sets the IDirectEditHolder
	 * 
	 * @param directEditHolder
	 */
	public void setDirectEditingContext(IDirectEditHolder directEditHolder) {
		this.directEditHolder = directEditHolder;
	}
}
