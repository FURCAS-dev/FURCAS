/*
 * Created on 08-Aug-2003
 *
 */
package org.oslo.ocl20.standard.types;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.factories.BridgeFactory;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.semantics.model.types.TypeType;
import org.oslo.ocl20.standard.lib.OclType;


/**
 * @author dha
 *
 */
public class TypeTypeImpl extends PrimitiveImpl implements TypeType {

	Classifier cls;
	public Classifier getClassifier() {
		return cls;
	}
	public TypeTypeImpl(OclProcessor proc, Classifier cls) {
		super(proc);
		this.cls = cls;
		setName("OclType");
	}

	public void createOperations(TypeFactory tf) {
		BridgeFactory bf = processor.getBridgeFactory();
		//--- Add operations ---
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "=", new Classifier[] { this }));
		getOperations().add(bf.buildOperation(tf.buildBooleanType(), "<>", new Classifier[] { this }));
		getOperations().add(bf.buildOperation(tf.buildSetType(this.cls), "allInstances", new Classifier[] { }));
		
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
		return "TypeType("+cls+")";
	}

	public Object getDelegate() {
		return java.lang.Class.class;
	}

	public Class getImplClass() {
		return OclType.class;
	}


}
