package com.sap.mi.gfw.eclipse.internal.action;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public interface IContextAndFeatureProvider {

	IFeature provideFeatureForContext(IContext context);

	IContext createContext(PictogramElement pe);
}
