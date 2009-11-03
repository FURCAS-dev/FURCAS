package com.sap.mi.tools.diagnostics.internal.properties;

import org.eclipse.ui.views.properties.PropertyDescriptor;

class MoinPropertyDescriptor extends PropertyDescriptor {
	public MoinPropertyDescriptor(Object id, String displayName) {
		super(id, displayName);
	}
	
	@Override
	protected boolean getAlwaysIncompatible() {
		return true;
	}
}