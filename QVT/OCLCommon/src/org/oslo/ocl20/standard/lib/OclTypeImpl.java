/*
 * Created on 08-Aug-2003
 *
 */
package org.oslo.ocl20.standard.lib;

import org.oslo.ocl20.semantics.bridge.Classifier;

/**
 * @author dha
 *
 */
public class OclTypeImpl extends OclAnyImpl implements OclType {

	Classifier cls;

	public OclTypeImpl(Classifier cls, StdLibAdapter adapter) {
		super(adapter);
		this.cls = cls;
	}

	public OclType oclType() {
		Classifier type = adapter.getProcessor().getTypeFactory().buildTypeType(cls);
		return adapter.Type(type);
	}

	public OclSet allInstances() {
		return adapter.getProcessor().getModelEvaluationAdapter().OclType_allInstances(this);
	}
	
	public Object clone() {
		return new OclTypeImpl(this.cls, super.adapter);
	}

	public boolean equals(Object o) {
		if (o instanceof OclTypeImpl)
			return this.cls.equals(  ((OclTypeImpl)o).cls );
		return false;
	}

	public Object asJavaObject() {
		return cls;
	}

	public String toString() {
		return "OclType("+cls+")";
	}

}
