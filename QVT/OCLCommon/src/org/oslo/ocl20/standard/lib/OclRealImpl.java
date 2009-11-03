package org.oslo.ocl20.standard.lib;

import org.oslo.ocl20.semantics.bridge.Classifier;

public class OclRealImpl extends OclAnyImpl implements OclReal {
	public OclRealImpl(double r, StdLibAdapter adapter) {
		super(adapter);
		_implementation = r;
	}
	public OclType oclType() {
		Classifier type = adapter.getProcessor().getTypeFactory().buildRealType();
		return adapter.Type(type);
	}

	double _implementation;
	public double implementation() {
		return _implementation;
	}

	public strictfp OclBoolean equalTo(OclReal r2) {
		return adapter.Boolean(this.implementation() == ((OclRealImpl) r2).implementation());
	}

	public strictfp OclBoolean notEqualTo(OclReal r2) {
		return adapter.Boolean(this.implementation() != ((OclRealImpl) r2).implementation());
	}
	
	public Object asJavaObject() {
		return new Double(implementation());
	}

	//--- IOclReal ---
	public OclReal add(OclReal r2) {
		return adapter.Real(this.implementation() + ((OclRealImpl) r2).implementation());
	}

	public OclReal subtract(OclReal r2) {
		return adapter.Real(this.implementation() - ((OclRealImpl) r2).implementation());
	}

	public OclReal multiply(OclReal r2) {
		return adapter.Real(this.implementation() * ((OclRealImpl) r2).implementation());
	}

	public OclReal negate() {
		return adapter.Real(this.implementation() * -1);
	}

	public OclReal divide(OclReal r2) {
		if (((OclRealImpl)r2)._implementation == 0) return adapter.Undefined();
		return adapter.Real(this.implementation() / ((OclRealImpl) r2).implementation());
	}

	public OclReal abs() {
		return adapter.Real(Math.abs(this.implementation()));
	}

	public OclInteger floor() {
		return adapter.Integer((int) Math.floor(this.implementation()));
	}

	public OclInteger round() {
		return adapter.Integer((int) Math.round(this.implementation()));
	}

	public OclReal max(OclReal r2) {
		return adapter.Real(Math.max(this.implementation(), ((OclRealImpl) r2).implementation()));
	}

	public OclReal min(OclReal r2) {
		return adapter.Real(Math.min(this.implementation(), ((OclRealImpl) r2).implementation()));
	}

	public OclBoolean lessThan(OclReal r2) {
		return adapter.Boolean(this.implementation() < ((OclRealImpl) r2).implementation());
	}

	public OclBoolean greaterThan(OclReal r2) {
		return adapter.Boolean(this.implementation() > ((OclRealImpl) r2).implementation());
	}

	public OclBoolean lessThanOrEqualTo(OclReal r2) {
		return adapter.Boolean(this.implementation() <= ((OclRealImpl) r2).implementation());
	}

	public OclBoolean greaterThanOrEqualTo(OclReal r2) {
		return adapter.Boolean(this.implementation() >= ((OclRealImpl) r2).implementation());
	}

	//--- IOclVisitable ---
	public Object accept(OclVisitor v, Object obj) {
		return v.visit(this, obj);
	}

	//---Object---
	public String toString() {
		return String.valueOf(implementation());
	}
	public boolean equals(Object r) {
		if (r instanceof OclRealImpl)
			return ((OclBooleanImpl)this.equalTo((OclRealImpl) r)) == OclBooleanImpl.TRUE;
		return false;
	}

	public int hashCode() {
		return (int) implementation();
	}

	public Object clone() {
		return new OclRealImpl(implementation(), super.adapter);
	}
}
