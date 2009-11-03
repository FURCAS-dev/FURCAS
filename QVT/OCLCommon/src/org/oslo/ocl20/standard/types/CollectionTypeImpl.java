package org.oslo.ocl20.standard.types;

import java.util.List;
import java.util.Vector;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.semantics.model.types.BagType;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.semantics.model.types.OrderedSetType;
import org.oslo.ocl20.semantics.model.types.SequenceType;
import org.oslo.ocl20.semantics.model.types.SetType;
import org.oslo.ocl20.semantics.model.types.TupleType;
import org.oslo.ocl20.semantics.model.types.VoidType;
import org.oslo.ocl20.standard.lib.OclCollection;


/**
 * @author dha
 *
 */
public class CollectionTypeImpl extends OclAnyTypeImpl implements CollectionType {
	/** Construct a CollectionType */
	public CollectionTypeImpl(Classifier elementType, OclProcessor proc) {
		super(proc);
		setElementType(elementType);
		setName("Collection");
	}
	
	/** Set the operations */
	public void createOperations(TypeFactory tf) {
		CollectionType colT;
		if (this.getClass() == CollectionTypeImpl.class)
			colT = this;
		else
			colT = tf.buildCollectionType(getElementType());
			
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildIntegerType(), "size", new Classifier[]{}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "includes", new Classifier[]{getElementType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "excludes", new Classifier[]{getElementType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildIntegerType(), "count", new Classifier[]{getElementType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "includesAll", new Classifier[]{colT}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "excludesAll", new Classifier[]{colT}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "isEmpty", new Classifier[]{}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "notEmpty", new Classifier[]{}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(getElementType(), "sum", new Classifier[]{}) );
		// product's signature will be computed latter
		//getOperations().add("product", buildOperation(?TupleType?, "product", null) );

		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "exists", new Classifier[]{tf.buildBooleanType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "exists", new Classifier[]{getElementType(), tf.buildBooleanType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "exists", new Classifier[]{getElementType(), getElementType(), tf.buildBooleanType()}) );
		
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "forAll", new Classifier[]{tf.buildBooleanType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "forAll", new Classifier[]{getElementType(), tf.buildBooleanType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "forAll", new Classifier[]{getElementType(), getElementType(), tf.buildBooleanType()}) );
		
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "isUnique", new Classifier[]{tf.buildClassifier()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "isUnique", new Classifier[]{getElementType(), tf.buildClassifier()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "isUnique", new Classifier[]{getElementType(), getElementType(), tf.buildClassifier()}) );

		getOperations().add( super.processor.getBridgeFactory().buildOperation(getElementType(), "any", new Classifier[]{tf.buildBooleanType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(getElementType(), "any", new Classifier[]{getElementType(), tf.buildBooleanType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(getElementType(), "any", new Classifier[]{getElementType(), getElementType(), tf.buildBooleanType()}) );

		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "one", new Classifier[]{tf.buildBooleanType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "one", new Classifier[]{getElementType(), tf.buildBooleanType()}) );
		getOperations().add( super.processor.getBridgeFactory().buildOperation(tf.buildBooleanType(), "one", new Classifier[]{getElementType(), getElementType(), tf.buildBooleanType()}) );
		// collect's signature will be computed latter
		//_operations.put("collect", buildOperation(buildCollectionType(?bodyType?), "collect", null) );
		
		super.createOperations(tf);
	}

	/** Get only operations from CollectionType */ 
	public List getCollectionTypeOperations() {
		CollectionType colT;
		if (this.getClass() == CollectionTypeImpl.class)
			colT = this;
		else
			colT = super.processor.getTypeFactory().buildCollectionType(getElementType());
		List oper = new Vector();
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildIntegerType(), "size", new Classifier[]{}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "includes", new Classifier[]{getElementType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "excludes", new Classifier[]{getElementType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildIntegerType(), "count", new Classifier[]{getElementType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "includesAll", new Classifier[]{colT}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "excludesAll", new Classifier[]{colT}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "isEmpty", new Classifier[]{}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "notEmpty", new Classifier[]{}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(getElementType(), "sum", new Classifier[]{}) );
		// product's signature will be computed latter
		//getOperations().add("product", buildOperation(?TupleType?, "product", null) );

		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "exists", new Classifier[]{super.processor.getTypeFactory().buildBooleanType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "exists", new Classifier[]{getElementType(), super.processor.getTypeFactory().buildBooleanType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "exists", new Classifier[]{getElementType(), getElementType(), super.processor.getTypeFactory().buildBooleanType()}) );
		
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "forAll", new Classifier[]{super.processor.getTypeFactory().buildBooleanType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "forAll", new Classifier[]{getElementType(), super.processor.getTypeFactory().buildBooleanType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "forAll", new Classifier[]{getElementType(), getElementType(), super.processor.getTypeFactory().buildBooleanType()}) );
		
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "isUnique", new Classifier[]{super.processor.getTypeFactory().buildClassifier()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "isUnique", new Classifier[]{getElementType(), super.processor.getTypeFactory().buildClassifier()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "isUnique", new Classifier[]{getElementType(), getElementType(), super.processor.getTypeFactory().buildClassifier()}) );

		oper.add( super.processor.getBridgeFactory().buildOperation(getElementType(), "any", new Classifier[]{super.processor.getTypeFactory().buildBooleanType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(getElementType(), "any", new Classifier[]{getElementType(), super.processor.getTypeFactory().buildBooleanType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(getElementType(), "any", new Classifier[]{getElementType(), getElementType(), super.processor.getTypeFactory().buildBooleanType()}) );

		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "one", new Classifier[]{super.processor.getTypeFactory().buildBooleanType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "one", new Classifier[]{getElementType(), super.processor.getTypeFactory().buildBooleanType()}) );
		oper.add( super.processor.getBridgeFactory().buildOperation(super.processor.getTypeFactory().buildBooleanType(), "one", new Classifier[]{getElementType(), getElementType(), super.processor.getTypeFactory().buildBooleanType()}) );
		// collect's signature will be computed latter
		//_operations.put("collect", buildOperation(buildCollectionType(?bodyType?), "collect", null) );
		return oper;
	}

	Classifier _elementType=null;
	public Classifier getElementType() {
		return _elementType;
	}

	public void setElementType(Classifier elementType) {
		_elementType = elementType;
	}

	public Classifier getBaseElementType() {
		Classifier x = getElementType();
		if (x instanceof CollectionType)
			return ((CollectionType)x).getBaseElementType();
		return x;
	}
	/** Check if this (a Collection) conforms with t2 */
	public Boolean conformsTo(Classifier t2) {
		//--- T2 is undefined ---
		if (t2 instanceof VoidType)
			return Boolean.TRUE;
		//--- T2 is CollectionType ---
		if (t2 instanceof CollectionType && 
			!(t2 instanceof SetType) && !(t2 instanceof OrderedSetType) && !(t2 instanceof SequenceType) && !(t2 instanceof BagType)) 
			return getElementType().conformsTo(((CollectionType)t2).getElementType());
		//--- Check for parents ---
		else
			return TypeConformance.isAssignableTo(this, t2) ? Boolean.TRUE : Boolean.FALSE;
	}

	/** Search for an operation with agiven name and signature */
	public Operation lookupOperation(String name, List types) {
		Operation op = super.lookupOperation(name, types);
		if (op == null) {
			if (name.equals("product")) {
				Classifier t = getElementType();
				Classifier t2 = (Classifier)types.get(types.size()-1);
				TupleType tt = super.processor.getTypeFactory().buildTupleType( new String[]{"first", "second"}, new Classifier[]{t,t2} );
				return super.processor.getBridgeFactory().buildOperation(tt, "product", null);
			}
		}
		return op;
	}
	
	/** Accept a Semantic Visitor */ 
	public Object accept(SemanticsVisitor v, Object obj) {
		return v.visit(this,obj);
	}

	/** ToString */
	public String toString(){
		return "Collection("+this.getElementType()+")";
	}

	public Object getDelegate() {
		return java.util.Collection.class;
	}

	public Class getImplClass() {
		return OclCollection.class;
	}
	
	Classifier baseElementType(Classifier t) {		
	  if (t instanceof CollectionType && ! (t instanceof VoidType))
		  return baseElementType(((CollectionType)t).getElementType());
	  else
		  return t;
	}
}
