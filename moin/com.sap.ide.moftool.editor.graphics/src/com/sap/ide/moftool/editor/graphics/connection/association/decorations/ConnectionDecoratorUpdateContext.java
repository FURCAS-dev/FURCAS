package com.sap.ide.moftool.editor.graphics.connection.association.decorations;

import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class ConnectionDecoratorUpdateContext extends UpdateContext {

	private boolean mNoLocationUpdate = false;
	
	public ConnectionDecoratorUpdateContext(PictogramElement pictogramElement) {
		this(pictogramElement, false);
	}

	public ConnectionDecoratorUpdateContext(PictogramElement pictogramElement,
			boolean noLocationUpdate) {
		super(pictogramElement);
		mNoLocationUpdate = noLocationUpdate;
	}

	/**
	 * @return the mNoLocationUpdate
	 */
	public boolean isNoLocationUpdate() {
		return mNoLocationUpdate;
	}
}
