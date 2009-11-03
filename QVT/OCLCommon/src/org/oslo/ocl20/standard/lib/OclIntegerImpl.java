package org.oslo.ocl20.standard.lib;

import org.oslo.ocl20.semantics.bridge.Classifier;

public class OclIntegerImpl extends OclRealImpl implements OclInteger {
    int _int_impl;

    public OclIntegerImpl(int i, StdLibAdapter adapter) {
		super(i,adapter);
		_int_impl = i;
	}

	public int int_impl() {
		return _int_impl;
	}
    
    public OclType oclType() {
        Classifier type = adapter.getProcessor().getTypeFactory().buildIntegerType();
        return adapter.Type(type);
    }

	public OclBoolean equalTo(OclInteger i2) {
		return super.equalTo(i2);
	}

	//--- IOclInteger ---
	public OclInteger inegate() {
		return adapter.Integer(this.int_impl() * -1);
	}

	public OclInteger add(OclInteger i2) {
		return adapter.Integer(this.int_impl() + ((OclIntegerImpl) i2).int_impl());
	}

	public OclInteger subtract(OclInteger i2) {
		return adapter.Integer(this.int_impl() - ((OclIntegerImpl) i2).int_impl());
	}

	public OclInteger multiply(OclInteger i2) {
		return adapter.Integer(this.int_impl() * ((OclIntegerImpl) i2).int_impl());
	}

	public OclReal divide(OclInteger i2) {
		if (((OclIntegerImpl)i2).int_impl() == 0) return adapter.Undefined();
		return adapter.Real(this.implementation() / ((OclIntegerImpl) i2).implementation());
	}

	public OclInteger iabs() {
		return adapter.Integer(Math.abs(this.int_impl()));
	}

	public OclInteger div(OclInteger i2) {
		if (((OclIntegerImpl)i2).int_impl() == 0) return adapter.Undefined();
		return adapter.Integer(this.int_impl() / ((OclIntegerImpl) i2).int_impl());
	}

	public OclInteger mod(OclInteger i2) {
		if (((OclIntegerImpl)i2).int_impl() == 0) return adapter.Undefined();
		return adapter.Integer(this.int_impl() % ((OclIntegerImpl) i2).int_impl());
	}

	public OclInteger max(OclInteger i2) {
		return adapter.Integer(Math.max(this.int_impl(), ((OclIntegerImpl) i2).int_impl()));
	}

	public OclInteger min(OclInteger i2) {
		return adapter.Integer(Math.min(this.int_impl(), ((OclIntegerImpl) i2).int_impl()));
	}

	//--- OclAny ---
	public OclBoolean equalTo(OclAny i2) {
		if ( ! (i2 instanceof OclReal) )
			return this.adapter.Boolean(false);
		return super.equalTo( (OclReal)i2);
	}
	public Object asJavaObject() {
		return new Integer(int_impl());
	}

	//--- IOclVisitable ---
	public Object accept(OclVisitor v, Object obj) {
		return v.visit(this, obj);
	}

	//---Object---
	public String toString() {
		return String.valueOf(int_impl());
	}
	/*
	public boolean equals(Object i) {
	if ( ! (i instanceof OclInteger)) return false;
	return (implementation() == ((OclInteger)i).implementation());
	}
	*/
	public int hashCode() {
		return int_impl();
	}

	public Object clone() {
		return adapter.Integer(int_impl());
	}
}
