package org.oslo.ocl20.standard.lib;

import org.oslo.ocl20.semantics.bridge.Classifier;

public class OclBooleanImpl extends OclAnyImpl implements OclBoolean {
	public OclBooleanImpl(StdLibAdapter adapter) {
		super(adapter);
	}

	public OclType oclType() {
		Classifier type = adapter.getProcessor().getTypeFactory().buildBooleanType();
		return adapter.Type(type);
	}


	public static OclBoolean TRUE ;
    public static OclBoolean FALSE ;

	public Object asJavaObject() {
		if (this == TRUE)
			return java.lang.Boolean.TRUE ;
		else if (this == FALSE)
			return java.lang.Boolean.FALSE;
		else
			return null;
	}
	//--- IOclBoolean ---
	public OclBoolean equalTo(OclBoolean b2) {
		//if ( this == UNDEFINED ) return UNDEIFNED;
		if (b2 instanceof OclUndefined) return b2;
		return adapter.Boolean(this.equals(b2));
	}

	public OclBoolean or(OclBoolean b2) {
		if (this == TRUE) return TRUE;
		if (b2 == TRUE) return TRUE;
		if (this == FALSE && b2 == FALSE) return FALSE;
		if (b2 instanceof OclUndefined) return b2;
		return adapter.Undefined();
	}

	public OclBoolean xor(OclBoolean b2) {
		//if ( this == UNDEFINED ) return UNDEFINED;
		if (b2 instanceof OclUndefined) return b2;
		if (this == b2) return FALSE;
		return TRUE;
	}

	public OclBoolean and(OclBoolean b2) {
		if (this == FALSE)	return FALSE;
		if (b2 == FALSE) return FALSE;
		if (this == TRUE && b2 == TRUE) return TRUE;
		if (b2 instanceof OclUndefined) return b2;
		return adapter.Undefined();
	}

	public OclBoolean not() {
		if (this == TRUE)
			return FALSE;
		if (this == FALSE)
			return TRUE;
		return adapter.Undefined();
	}

	public OclBoolean implies(OclBoolean b2) {
		if (this == FALSE)
			return TRUE;
		if (b2 == TRUE)
			return TRUE;
		if (this == TRUE)
			return b2;
		//if (this==UNDEFINED) return UNDEFINED; unless b2 ==TRUE
		return adapter.Undefined();
	}
/*
	//expr1.evaluationType ifThenElse(IOclExpression expr1, IOclExpression expr2);
	public IOclAny ifThenElse(IOclExpression expr1, IOclExpression expr2) {
		if (this == TRUE) {
			return expr1.evaluate();
		}
		if (this == FALSE) {
			return expr2.evaluate();
		}
		return UNDEFINED;
	}

	public IOclAny ifThenElse(IOclAny val1, IOclAny val2) {
		if (this == TRUE) {
			return val1;
		}
		if (this == FALSE) {
			return val2;
		}
		return UNDEFINED;
	}
*/
	//--- IOclVisitable ---
	public Object accept(OclVisitor v, Object obj) {
		return v.visit(this, obj);
	}

	//--- Object ---
	public String toString() {
		if (this == TRUE)
			return "true";
		if (this == FALSE)
			return "false";
		return adapter.Undefined().toString();
	}

	public boolean equals(Object b) {
		// if this is undef..this equalTo in undef is called
		if (! (b instanceof OclBoolean) ) return false;
// TODO TODOMWA remove old implementation -- not ocl conform		if (b instanceof OclUndefined) return ((Boolean)((OclBoolean)b).asJavaObject()).booleanValue();
        if (b instanceof OclUndefined) return false;
// TODO dirty !!! use values
		return this == b;
	}
	public int hashCode() {
		return this == FALSE ? 0 : 1;
	}
	public Object clone() {
		return this;
	}
}
