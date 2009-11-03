package org.oslo.ocl20.standard.types;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.factories.BridgeFactory;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.semantics.model.types.IntegerType;
import org.oslo.ocl20.standard.lib.OclInteger;


/**
 * @author dha
 *
 */
public class IntegerTypeImpl extends RealTypeImpl implements IntegerType {
	/** Construct a IntegerType */	
	public IntegerTypeImpl(OclProcessor proc) {
		super(proc);
		setName("Integer");
	}

	public void createOperations(TypeFactory tf) {
		BridgeFactory bf = processor.getBridgeFactory();
		//--- Add operations for INTEGER_TYPE ---
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "-", new Classifier[] {}));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "+", new Classifier[] { tf.buildIntegerType() }));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "-", new Classifier[] { tf.buildIntegerType() }));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "*", new Classifier[] { tf.buildIntegerType() }));
		getOperations().add(bf.buildOperation(tf.buildRealType(), "/", new Classifier[] { tf.buildIntegerType() }));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "abs", new Classifier[] {}));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "div", new Classifier[] { tf.buildIntegerType() }));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "mod", new Classifier[] { tf.buildIntegerType() }));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "max", new Classifier[] { tf.buildIntegerType() }));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "min", new Classifier[] { tf.buildIntegerType() }));

		super.createOperations(tf);	
	}

	/** Check if this (an IntegerType) conforms to t2 */
	public Boolean conformsTo(Classifier t2) {
		return TypeConformance.isAssignableTo(this, t2) ? Boolean.TRUE : Boolean.FALSE;
	}

	/** Accept a Semantic Visitor */	
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this,obj);
	}
	
	/** ToString */
	public String toString(){
		return "Integer";
	}
	
	public Object getDelegate() {
		return java.lang.Integer.class;
	}
	public Class getImplClass() {
		return OclInteger.class;
	}
}
