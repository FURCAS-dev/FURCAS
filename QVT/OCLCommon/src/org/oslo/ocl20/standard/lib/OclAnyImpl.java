package org.oslo.ocl20.standard.lib;

import java.util.Arrays;

import org.oslo.ocl20.semantics.bridge.Classifier;


abstract
public class OclAnyImpl implements OclAny {
    protected StdLibAdapter adapter;
	protected OclAnyImpl(StdLibAdapter adapter) {
		this.adapter = adapter;
	}

	//--- IOclAny ---
//	public OclBoolean equalTo(OclAny object2) {
//		return adapter.Boolean(this.equals(object2));
//	}

	public OclBoolean notEqualTo(OclAny object2) {
		return this.equalTo(object2).not();
	}
	
//	public OclBoolean oclIsNew() {
//		return this.adapter.Boolean(false);
//	}
//
//	public OclAny oclAsType(OclType type) {
//		return this;
//	}
//
//	public OclBoolean oclIsTypeOf(OclType type) {
//		Class c1 = (Class)((Classifier)type.asJavaObject()).getDelegate();
//		Class c2 = (Class)this.asJavaObject().getClass();
//		boolean b1 = false;
//		boolean b2 = false;
//		//c2 is the class of this, therefore must always be a class
//		if (c1.isInterface()) {
//			b1 = Arrays.asList(c2.getInterfaces()).contains(c1);
//			b2 = c1.isAssignableFrom(c2);
//		} else {
//			b1 = c1.isAssignableFrom(c2);
//			b2 = c2.isAssignableFrom( c1 );
//		}
//		return adapter.Boolean(b1 && b2);
//	}
//
//	public OclBoolean oclIsKindOf(OclType type) {
//		Classifier cls = (Classifier)type.asJavaObject();
//		boolean b = ((java.lang.Class)cls.getDelegate()).isAssignableFrom( this.asJavaObject().getClass() );
//		return adapter.Boolean(b);
//	}
//
//	public OclBoolean oclIsInState(Object state) {
//		return this.adapter.Boolean(false);
//	}
    
    public OclBoolean equalTo(OclAny o2){
        boolean b = adapter.getProcessor().getModelEvaluationAdapter().OclModelElement_equalTo(this,o2);
        return adapter.Boolean(b);
    }

    public OclAny oclAsType(OclType type){
        Object o = adapter.getProcessor().getModelEvaluationAdapter().OclModelElement_oclAsType(this, type);
        return adapter.OclAny( o);
    }
    
    public OclBoolean oclIsTypeOf(OclType type){
        boolean b = adapter.getProcessor().getModelEvaluationAdapter().OclModelElement_oclIsTypeOf(this,type);
        return adapter.Boolean(b);
    }
    
    public OclBoolean oclIsKindOf(OclType type){
        boolean b = adapter.getProcessor().getModelEvaluationAdapter().OclModelElement_oclIsKindOf(this,type);
        return adapter.Boolean(b);
    }
    
	public OclBoolean oclIsUndefined() {
		return this.adapter.Boolean(false);
	}

	//public OclSet allInstances() {
	//	return null;
	//}

	String toString(Class[] x) {
		String str = "(";
		for(int i=0; i<x.length; i++) {
			str+=x[i].getName();
			if (i+1<x.length) str+="' ";
		}
		str+=")";
		return str;
	}

	//--- Object ---
	public abstract Object clone();
	public abstract boolean equals(Object o);
	public int hashCode() {
		return 0;
	}
}
