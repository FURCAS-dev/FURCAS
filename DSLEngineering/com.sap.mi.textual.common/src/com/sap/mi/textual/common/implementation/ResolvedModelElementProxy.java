package com.sap.mi.textual.common.implementation;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;


public class ResolvedModelElementProxy implements IModelElementProxy {

	private final Object realObject;

	@Override
	public Object getRealObject() {
		return realObject;
	}

	@Override
	public boolean isReferenceOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	public ResolvedModelElementProxy(Object realObject) {
		super();
		this.realObject = realObject;
	}

}
