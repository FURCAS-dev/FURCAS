package com.sap.mi.gfw.tb;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;

public class ToolbarEntry extends AbstractContextEntry implements IToolbarEntry {

	public ToolbarEntry(IFeature feature, IContext context) {
		super(feature, context);
	}

}
