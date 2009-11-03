package com.sap.mi.gfw.features;

import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.IPasteContext;
import com.sap.mi.gfw.features.context.IPictogramElementContext;
import com.sap.mi.gfw.features.context.IReconnectionContext;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.context.ISplitConnectionContext;
import com.sap.mi.gfw.features.context.IUpdateContext;

/**
 * Convenience implementation of IFeatureChecker. All methods return either true or false.
 * 
 * This class is expected to be sub-classed.
 */
public class FeatureCheckerAdapter implements IFeatureChecker {

	private final boolean allow;

	public FeatureCheckerAdapter(boolean allow) {
		this.allow = allow;
	}

	public boolean allowAdd(IContext context) {
		return allow;
	}

	public boolean allowConnectionSplit(ISplitConnectionContext context) {
		return allow;
	}

	public boolean allowCreate() {
		return allow;
	}

	public boolean allowCustomFeatures(ICustomContext context) {
		return allow;
	}

	public boolean allowDelete(IDeleteContext context) {
		return allow;
	}

	public boolean allowDragAndDrop(IPictogramElementContext context) {
		return allow;
	}

	public boolean allowLayout(ILayoutContext context) {
		return allow;
	}

	public boolean allowMove(IContext context) {
		return allow;
	}

	public boolean allowPaste(IPasteContext context) {
		return allow;
	}

	public boolean allowReconnect(IReconnectionContext context) {
		return allow;
	}

	public boolean allowRemove(IContext context) {
		return allow;
	}

	public boolean allowResize(IResizeShapeContext context) {
		return allow;
	}

	public boolean allowUpdate(IUpdateContext context) {
		return allow;
	}

	public boolean allow(IFeature feature, IContext context) {
		return allow;
	}

}
