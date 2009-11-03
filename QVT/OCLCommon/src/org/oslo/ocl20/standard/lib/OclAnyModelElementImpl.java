/*
 * Created on 07-Aug-2003
 *
 */
package org.oslo.ocl20.standard.lib;

import java.lang.reflect.Method;

/**
 * @author dha
 *
 */
public class OclAnyModelElementImpl extends OclAnyImpl implements OclAnyModelElement {

	public int hashCode() {
		if (modelElement!=null) {
			return modelElement.hashCode();
		}
		return super.hashCode();
	}

	java.lang.Object modelElement;
	public OclAnyModelElementImpl(java.lang.Object modelElem, StdLibAdapter adapter) {
		super(adapter);
		this.modelElement = modelElem;
	}

	private OclType oclType;
	public OclType oclType() {
		if (oclType == null) {
			oclType = adapter.getProcessor().getModelEvaluationAdapter().OclModelElement_oclType(this); 
		}
		return oclType;
	}

	public OclBoolean equalTo(OclAny o2){
		if (o2 instanceof OclUndefined) {
			return adapter.Undefined();
		}
		boolean b = adapter.getProcessor().getModelEvaluationAdapter().OclModelElement_equalTo(this,o2);
		return adapter.Boolean(b);
	}
	
	public OclBoolean oclIsNew(){
		boolean b = adapter.getProcessor().getModelEvaluationAdapter().OclModelElement_oclIsNew(this);
		return adapter.Boolean(b);
	}

	public OclBoolean oclIsUndefined(){
		boolean b = adapter.getProcessor().getModelEvaluationAdapter().OclModelElement_oclIsUndefined(this);
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
	
	//public OclSet allInstances(){
	//	Set s = adapter.getProcessor().getModelEvaluationAdapter().OclModelElement_allInstances(this);
	//	return null;//adapter.Set(this,s);
	//}


	public Object clone() {
		try {
			Method m = modelElement.getClass().getMethod("clone",new Class[]{});
			return m.invoke(modelElement, new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean equals(Object o) {
		if (o instanceof OclAnyModelElement)
			return adapter.getProcessor().getModelEvaluationAdapter().OclModelElement_equalTo(this,(OclAnyModelElement)o);
		return false;
	}

	public Object asJavaObject() {
		return modelElement;
	}

	public String toString() {
		return modelElement.toString();
	}

}
