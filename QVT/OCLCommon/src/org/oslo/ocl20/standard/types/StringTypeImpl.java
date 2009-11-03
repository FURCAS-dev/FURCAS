package org.oslo.ocl20.standard.types;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.factories.BridgeFactory;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.semantics.model.types.StringType;
import org.oslo.ocl20.standard.lib.OclBoolean;
import org.oslo.ocl20.standard.lib.OclInteger;
import org.oslo.ocl20.standard.lib.OclSequence;
import org.oslo.ocl20.standard.lib.OclString;


/**
 * @author dha
 *
 */
public class StringTypeImpl extends PrimitiveImpl implements StringType {
	/** Construct a StringType */
	public StringTypeImpl(OclProcessor proc) {
		super(proc);
		setName("String");
	}

	public void createOperations(TypeFactory tf) {
		BridgeFactory bf = processor.getBridgeFactory();
		//--- Add operations for STRING_TYPE ---
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "size", new Classifier[] {}));
		getOperations().add(bf.buildOperation(tf.buildStringType(), "concat", new Classifier[] { tf.buildStringType(), }));
		getOperations().add(bf.buildOperation(tf.buildStringType(), "substring", new Classifier[] { tf.buildIntegerType(), tf.buildIntegerType() }));
		getOperations().add(bf.buildOperation(tf.buildIntegerType(), "toInteger", new Classifier[] {}));
		getOperations().add(bf.buildOperation(tf.buildRealType(), "toReal", new Classifier[] {}));
		
		if (OclProcessor.supportStringExtension) {
			getOperations().add(bf.buildOperation(tf.buildStringType(), "+", new Classifier[] { tf.buildStringType() }));
			
			getOperations().add(bf.buildOperation(tf.buildBooleanType(), "toBoolean", new Classifier[] {}));
			getOperations().add(bf.buildOperation(tf.buildStringType(), "toLower", new Classifier[] {}));
			getOperations().add(bf.buildOperation(tf.buildStringType(), "toUpper", new Classifier[] {}));
			
			getOperations().add(bf.buildOperation(tf.buildStringType(), "firstToUpper", new Classifier[] {}));
			getOperations().add(bf.buildOperation(tf.buildStringType(), "firstToLower", new Classifier[] {}));
			
			getOperations().add(bf.buildOperation(tf.buildIntegerType(), "indexOf", new Classifier[] { tf.buildStringType() }));
			getOperations().add(bf.buildOperation(tf.buildIntegerType(), "indexOf", new Classifier[] { tf.buildStringType(), tf.buildIntegerType() }));
			getOperations().add(bf.buildOperation(tf.buildIntegerType(), "lastIndexOf", new Classifier[] { tf.buildStringType() }));
			getOperations().add(bf.buildOperation(tf.buildIntegerType(), "lastIndexOf", new Classifier[] { tf.buildStringType(), tf.buildIntegerType() }));

			getOperations().add(bf.buildOperation(tf.buildBooleanType(), "endsWith", new Classifier[] { tf.buildStringType() }));
			getOperations().add(bf.buildOperation(tf.buildBooleanType(), "startsWith", new Classifier[] { tf.buildStringType() }));

			getOperations().add(bf.buildOperation(tf.buildStringType(), "trim", new Classifier[] { }));
			getOperations().add(bf.buildOperation(tf.buildBooleanType(), "equalsIgnoreCase", new Classifier[] { tf.buildStringType() }));
			
			getOperations().add(bf.buildOperation(tf.buildStringType(), "substringBefore", new Classifier[] { tf.buildStringType() }));
			getOperations().add(bf.buildOperation(tf.buildStringType(), "substringAfter", new Classifier[] { tf.buildStringType() }));
		    
			getOperations().add(bf.buildOperation(tf.buildBooleanType(), "containsOnlyLetters", new Classifier[] { }));
			getOperations().add(bf.buildOperation(tf.buildBooleanType(), "containsOnlyDigits", new Classifier[] { }));
			getOperations().add(bf.buildOperation(tf.buildBooleanType(), "containsOnlyDigitsAndLetters", new Classifier[] { }));
			
			getOperations().add(bf.buildOperation(tf.buildStringType(), "replace", new Classifier[] { tf.buildStringType(), tf.buildStringType() }));
			getOperations().add(bf.buildOperation(tf.buildStringType(), "replaceFirst", new Classifier[] { tf.buildStringType(), tf.buildStringType() }));
		    
			getOperations().add(bf.buildOperation(tf.buildSequenceType(tf.buildStringType()), "split", new Classifier[] { tf.buildStringType() }));
			getOperations().add(bf.buildOperation(tf.buildSequenceType(tf.buildStringType()), "split", new Classifier[] { tf.buildStringType(), tf.buildIntegerType()}));
			getOperations().add(bf.buildOperation(tf.buildBooleanType(), "matches", new Classifier[] { tf.buildStringType() }));

		}
		
		
		super.createOperations(tf);
	}
	/** Check if this (a String) conforms with t2 */
	public Boolean conformsTo(Classifier t2) {
		return TypeConformance.isAssignableTo(this, t2) ? Boolean.TRUE : Boolean.FALSE;
	}

	/** Accept a Semantic Visitor */ 
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this,obj);
	}
	
	/** ToString */
	public String toString(){
		return "String";
	}

	public Object getDelegate() {
		return java.lang.String.class;
	}

	public Class getImplClass() {
		return OclString.class;
	}
}
