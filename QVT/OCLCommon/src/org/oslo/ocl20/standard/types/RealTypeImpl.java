package org.oslo.ocl20.standard.types;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.factories.BridgeFactory;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.semantics.model.types.RealType;
import org.oslo.ocl20.standard.lib.OclReal;


/**
 * @author dha
 *
 */
public class RealTypeImpl extends PrimitiveImpl implements RealType {
	/** Construct a RealType */
	public RealTypeImpl(OclProcessor proc) {
		super(proc);
		setName("Real");
	}

	public void createOperations(TypeFactory tf) {
		BridgeFactory bf = processor.getBridgeFactory();
		//--- Add operations for REAL_TYPE ---
		getOperations().add(bf.buildOperation(tf.buildRealType(), "+", new Classifier[] { tf.buildRealType() }));
		getOperations().add(bf.buildOperation(tf.buildRealType(), "-", new Classifier[] { tf.buildRealType() }));
		getOperations().add(bf.buildOperation(tf.buildRealType(), "*", new Classifier[] { tf.buildRealType() }));
		getOperations().add(bf.buildOperation(tf.buildRealType(), "-", new Classifier[] {}));
		getOperations().add(bf.buildOperation(tf.buildRealType(), "/", new Classifier[] { tf.buildRealType() }));
		getOperations().add(bf.buildOperation(tf.buildRealType(), "abs", new Classifier[] {}));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "floor", new Classifier[] {}));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "round", new Classifier[] {}));
		getOperations().add(bf.buildOperation(tf.buildRealType(), "max", new Classifier[] { tf.buildRealType() }));
		getOperations().add(bf.buildOperation(tf.buildRealType(), "min", new Classifier[] { tf.buildRealType() }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "<", new Classifier[] { tf.buildRealType() }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), ">", new Classifier[] { tf.buildRealType() }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "<=", new Classifier[] { tf.buildRealType() }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), ">=", new Classifier[] { tf.buildRealType() }));
		
		super.createOperations(tf);
	}

	/** Check if this (a Real) conforms with t2 */
	public Boolean conformsTo(Classifier t2) {
		return TypeConformance.isAssignableTo(this, t2) ? Boolean.TRUE : Boolean.FALSE;
	}
	
	/** Accept a Semantic Visitor */ 
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this,obj);
	}

	/** ToString */
	public String toString(){
		return "Real";
	}

	public Object getDelegate() {
		return java.lang.Double.class;
	}

	public Class getImplClass() {
		return OclReal.class;
	}
}
