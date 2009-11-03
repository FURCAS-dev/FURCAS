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

public interface IFeatureChecker {

	boolean allow(IFeature feature, IContext context);

	boolean allowAdd(IContext context);

	boolean allowConnectionSplit(ISplitConnectionContext context);

	boolean allowCreate();

	boolean allowCustomFeatures(ICustomContext context);

	boolean allowDelete(IDeleteContext context);

	boolean allowDragAndDrop(IPictogramElementContext context);

	boolean allowLayout(ILayoutContext context);

	boolean allowMove(IContext context);

	boolean allowPaste(IPasteContext context);

	boolean allowReconnect(IReconnectionContext context);

	boolean allowRemove(IContext context);

	boolean allowResize(IResizeShapeContext context);

	boolean allowUpdate(IUpdateContext context);
}
