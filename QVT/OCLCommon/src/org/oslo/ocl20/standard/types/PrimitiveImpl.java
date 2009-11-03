package org.oslo.ocl20.standard.types;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.model.types.OclAnyType;


/**
 * @author dha
 *
 */
abstract
public class PrimitiveImpl extends OclAnyTypeImpl implements OclAnyType {
	/** Construct a Primitive */
	public PrimitiveImpl(OclProcessor proc) {
		super(proc);
	}

	/** Check if this (a Primitive) conforms to t2 */
	public Boolean conformsTo(Classifier t2) {
		return TypeConformance.isAssignableTo(this, t2) ? Boolean.TRUE : Boolean.FALSE;
	}

	/** Accept a Semantic Visitor */ 
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this,obj);
	}
	
	/** ToString */
	public String toString(){
		return "Primitive";
	}
}
