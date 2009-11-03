package org.oslo.ocl20.standard.types;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.factories.BridgeFactory;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.semantics.model.types.BooleanType;
import org.oslo.ocl20.standard.lib.OclBoolean;


/**
 * @author dha
 *
 */
public class BooleanTypeImpl extends PrimitiveImpl implements BooleanType {
	/** Construct a BooleanType */
	public BooleanTypeImpl(OclProcessor proc) {
		super(proc);
		setName("Boolean");	}

	public void createOperations(TypeFactory tf) {
		BridgeFactory bf = processor.getBridgeFactory();
		//--- Add operations for BOOLEAN_TYPE ---
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "or", new Classifier[] { tf.buildBooleanType(), }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "xor", new Classifier[] { tf.buildBooleanType(), }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "and", new Classifier[] { tf.buildBooleanType(), }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "not", new Classifier[] {}));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "implies", new Classifier[] { tf.buildBooleanType(), }));
		
		super.createOperations(tf);
	}
	/** Check if this (a Boolean) conforms with t2 */
	public Boolean conformsTo(Classifier t2) {
		return TypeConformance.isAssignableTo(this, t2) ? Boolean.TRUE : Boolean.FALSE;
	}

	/** Accept a semantic vistor */	
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this,obj);
	}
	
	/** ToString */
	public String toString(){
		return "Boolean";
	}
	public Object getDelegate() {
		return java.lang.Boolean.class;
	}

	public Class getImplClass() {
		return OclBoolean.class;
	}
}
