package com.sap.mi.gfw.eclipse.internal.parts.directedit;

import com.sap.mi.gfw.features.IDirectEditingFeature;
import com.sap.mi.gfw.features.context.IDirectEditingContext;

public interface IDirectEditHolder {
	IDirectEditingContext getDirectEditingContext();

	IDirectEditingFeature getDirectEditingFeature();
}
