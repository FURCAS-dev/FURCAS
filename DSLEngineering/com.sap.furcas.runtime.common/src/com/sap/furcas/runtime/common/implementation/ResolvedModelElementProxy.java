package com.sap.furcas.runtime.common.implementation;

import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;


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

	@Override
	public int hashCode() {
	    if(realObject != null) {
		return realObject.hashCode();
	    } else {
		return super.hashCode();
	    }
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (!(obj instanceof IModelElementProxy))
		return false;
	    IModelElementProxy other = (IModelElementProxy) obj;
	    if (realObject == null) {
		if (other.getRealObject() != null)
		    return false;
	    } else if (!realObject.equals(other.getRealObject()))
		return false;
	    return true;
	}

	@Override
	public Object getParent() {
		return realObject; //this is also the parent object
	}
	
	
}
