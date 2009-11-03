package org.oslo.ocl20.standard.types;

import java.util.List;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.factories.BridgeFactory;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.impl.ClassifierImpl;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.semantics.model.types.VoidType;
import org.oslo.ocl20.standard.lib.OclUndefined;


/**
 * @author dha
 *
 */
public class VoidTypeImpl extends ClassifierImpl implements VoidType {
	/** Construct a VoidType */
	public VoidTypeImpl(OclProcessor proc) {
		super();
		setProcessor(proc);
		setName("VoidType");
	}

	public void createOperations(TypeFactory tf) {
		BridgeFactory bf = processor.getBridgeFactory();
		//--- Add operations for OCLVOID_TYPE ---
		getOperations().addAll( tf.buildBooleanType().getOperations() );
		// add others ???
	}

	/** Check if this (a TypeVoid) conforms to t2 */
	public Boolean conformsTo(Classifier t2) {
		return Boolean.TRUE;
	}

	/** Serach for an operation with a given name and signature */
	public Operation lookupOperation(String name, List types) {
		Operation op = super.lookupOperation(name, types);
		if (op==null) {
			//no operation found with this name
			// so return default operation that returns Unfefined.
			op = super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildVoidType(), "_default", (Classifier[])types.toArray(new Classifier[]{}) );
		}
		return op;
	}
	
	/** Set element type */
	public void setElementType(Classifier elementType) {
	}
	/** Get element type */
	public Classifier getElementType() {
		return this;
	}

	public Classifier getBaseElementType() {
		return this;
	}

	/** Accept a Semantic Visitor */ 
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this,obj);
	}
	
	/** ToString */
	public String toString(){
		return "VoidType";
	}

	public Object getDelegate() {
		return java.lang.Boolean.class;
	}

	public Class getImplClass() {
		return OclUndefined.class;
	}
}
