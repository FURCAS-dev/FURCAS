package org.oslo.ocl20.standard.types;

import java.util.List;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.factories.BridgeFactory;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.impl.DataTypeImpl;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.semantics.model.types.OclAnyType;
import org.oslo.ocl20.semantics.model.types.SetType;
import org.oslo.ocl20.semantics.model.types.TypeType;
import org.oslo.ocl20.standard.lib.OclAny;


/**
 * @author dha
 *
 */

public class OclAnyTypeImpl 
       extends	DataTypeImpl 
       implements OclAnyType 
{
	/** Compute an OclAnyType */
	public OclAnyTypeImpl(OclProcessor proc) {
		super();
		setProcessor(proc);
		setName("OclAny");
	}

	public void createOperations(TypeFactory tf) {
		BridgeFactory bf = processor.getBridgeFactory();
		//--- Add operations for OCLANY_TYPE ---
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "=", new Classifier[] { tf.buildOclAnyType() }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "<>", new Classifier[] { tf.buildOclAnyType() }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "oclIsNew", new Classifier[] {}));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "oclIsUndefined", new Classifier[] {}));
		// Signature of oclAsType is computed later
		// OCLANY_TYPE.getOperations().add(buildOperation(CLASSIFIER_TYPE, "oclAsType", new Classifier[] { CLASSIFIER_TYPE }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "oclIsTypeOf", new Classifier[] { tf.buildClassifier() }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "oclIsKindOf", new Classifier[] { tf.buildClassifier() }));
		// Signature of allInstances is computed later
		// OCLANY_TYPE.getOperations().add(buildOperation(buildSetType(CLASSIFIER_TYPE), "allInstances", NONE));
	}
	
	/** Search for an operation */
	public Operation lookupOperation(String name, List types) {
		Operation op = super.lookupOperation(name, types);
		if (op == null) {
			if (name.equals("oclAsType")) {
				TypeType tt = (TypeType)types.get(0);
				return super.processor.getBridgeFactory().buildOperation(tt.getClassifier(), "oclAsType", new Classifier[] {tt.getClassifier()});
			} else if (name.equals("allInstances")) {
				SetType setT = null; // TODO TODOMWA make correct !!
				if (this instanceof TypeType) {
					setT = super.processor.getTypeFactory().buildSetType(((TypeType)this).getClassifier());					
				} else {
					setT = super.processor.getTypeFactory().buildSetType(this);					
				}
				return super.processor.getBridgeFactory().buildOperation(setT, "allInstances", null);
			}
		}
		return op;
	}

	/** Check if this (an OclAnyType) conforms to t2 */ 
	public Boolean conformsTo(Classifier t2) {
		return TypeConformance.isAssignableTo(this, t2) ? Boolean.TRUE : Boolean.FALSE;
	}

	/** Accept a Semantic Visitor */
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this,obj);
	}

	/** ToString */
	public String toString(){
		return "OclAny";
	}
	public Object getDelegate() {
		return java.lang.Object.class;
	}

	public Class getImplClass() {
		return OclAny.class;
	}
}
