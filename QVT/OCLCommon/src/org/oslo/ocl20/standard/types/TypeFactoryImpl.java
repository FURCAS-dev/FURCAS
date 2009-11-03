/**
 * Kent Modelling Framework - KMFStudio
 * Copyright (C) 2002 University of Kent at Canterbury, UK 
 * Visit www.cs.ukc.ac.uk/kmf
 *
 */

package org.oslo.ocl20.standard.types;

import java.util.HashMap;
import java.util.Map;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.types.BagType;
import org.oslo.ocl20.semantics.model.types.BooleanType;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.semantics.model.types.IntegerType;
import org.oslo.ocl20.semantics.model.types.OclAnyType;
import org.oslo.ocl20.semantics.model.types.OclMessageType;
import org.oslo.ocl20.semantics.model.types.OrderedSetType;
import org.oslo.ocl20.semantics.model.types.RealType;
import org.oslo.ocl20.semantics.model.types.SequenceType;
import org.oslo.ocl20.semantics.model.types.SetType;
import org.oslo.ocl20.semantics.model.types.StringType;
import org.oslo.ocl20.semantics.model.types.TupleType;
import org.oslo.ocl20.semantics.model.types.TypeType;
import org.oslo.ocl20.semantics.model.types.VoidType;
import org.oslo.ocl20.synthesis.CreationHelper;

public class TypeFactoryImpl implements TypeFactory {
	/** Construct a TypeFactory */
	public TypeFactoryImpl(OclProcessor proc) {
		this.processor = proc;
		this.init();
	}

	/** A OclProcessor */
	protected OclProcessor processor;

	public Classifier buildClassifier() {
		return this.CLASSIFIER_TYPE;
	}

	public BooleanType buildBooleanType() {
		return this.BOOLEAN_TYPE;
	}

	public RealType buildRealType() {
		return this.REAL_TYPE;
	}

	public IntegerType buildIntegerType() {
		return this.INTEGER_TYPE;
	}

	public StringType buildStringType() {
		return this.STRING_TYPE;
	}

	public VoidType buildVoidType() {
		return this.VOID_TYPE;
	}

	public OclAnyType buildOclAnyType() {
		return this.OCLANY_TYPE;
	}

	public TypeType buildTypeType(Classifier type) {
		return new TypeTypeImpl(this.processor, type);
	}

	public OclMessageType buildOclMessageType() {
		return null;
	}

	public TupleType buildTupleType(String[] names, Classifier[] types) {
		TupleType tt = new TupleTypeImpl(this.processor);
		((TupleTypeImpl) tt).createOperations(this);
		for (int i = 0; i < names.length; i++) {
			VariableDeclaration vd = CreationHelper.createVariableDeclaration();
			vd.setName(names[i]);
			vd.setType(types[i]);
			tt.getPartType().add(vd);
		}
		return tt;
	}

	Map _collectionTypes = new HashMap();

	public CollectionType buildCollectionType(Classifier elementType) {
		// --- Search it ---
		CollectionType collectionType = (CollectionType) this._collectionTypes.get(elementType);
		if (collectionType == null) {
			// --- Create it ---
			collectionType = new CollectionTypeImpl(elementType, this.processor);
			// --- Cache it to avoid cycles in operations ---
			this._collectionTypes.put(elementType, collectionType);
			// --- Set operations ---
			((CollectionTypeImpl) collectionType).createOperations(this);
		}
		return collectionType;
	}

	Map _bagTypes = new HashMap();

	public BagType buildBagType(Classifier elementType) {
		// --- Search it ---
		BagType bagType = (BagType) this._bagTypes.get(elementType);
		if (bagType == null) {
			// --- Create it ---
			bagType = new BagTypeImpl(elementType, this.processor);
			// --- Cache it to avoid cycles in operations ---
			this._bagTypes.put(elementType, bagType);
			// --- Set operations ---
			((BagTypeImpl) bagType).createOperations(this);
			// ((BagTypeImpl)bagType).getOperations().addAll(((CollectionTypeImpl)bagType).getCollectionTypeOperations());
		}
		return bagType;
	}

	Map _orderedSetTypes = new HashMap();

	public OrderedSetType buildOrderedSetType(Classifier elementType) {
		// --- Search it ---
		OrderedSetType orderedSetType = (OrderedSetType) this._orderedSetTypes.get(elementType);
		if (orderedSetType == null) {
			// --- Create it ---
			orderedSetType = new OrderedSetTypeImpl(elementType, this.processor);
			// --- Cache it to avoid cycles in operations ---
			this._orderedSetTypes.put(elementType, orderedSetType);
			// --- Set operations ---
			((OrderedSetTypeImpl) orderedSetType).createOperations(this);
			// ((OrderedSetTypeImpl)orderedSetType).getOperations().addAll(((CollectionTypeImpl)orderedSetType).getCollectionTypeOperations());
		}
		return orderedSetType;
	}

	Map _sequenceTypes = new HashMap();

	public SequenceType buildSequenceType(Classifier elementType) {
		// --- Search it ---
		SequenceType sequenceType = (SequenceType) this._sequenceTypes.get(elementType);
		if (sequenceType == null) {
			// --- Create it ---
			sequenceType = new SequenceTypeImpl(elementType, this.processor);
			// --- Cache it to avoid cycles in operations ---
			this._sequenceTypes.put(elementType, sequenceType);
			// --- Set operations ---
			((SequenceTypeImpl) sequenceType).createOperations(this);
			// ((SequenceTypeImpl)sequenceType).getOperations().addAll(((CollectionTypeImpl)sequenceType).getCollectionTypeOperations());
		}
		return sequenceType;
	}

	Map _setTypes = new HashMap();

	public SetType buildSetType(Classifier elementType) {
		// --- Search it ---
		SetType setType = (SetType) this._setTypes.get(elementType);
		if (setType == null) {
			// --- Create it ---
			setType = new SetTypeImpl(elementType, this.processor);
			// --- Cache it to avoid cycles in operations ---
			this._setTypes.put(elementType, setType);
			// --- Set operations ---
			((SetTypeImpl) setType).createOperations(this);
			// ((SetTypeImpl)setType).getOperations().addAll(((CollectionTypeImpl)setType).getCollectionTypeOperations());
		}
		return setType;
	}

	//
	// Unique references to types
	//
	public OclAnyType OCLANY_TYPE = null;

	public TypeType TYPE_TYPE = null;

	public OclMessageType OCLMESSAGE_TYPE = null;

	public VoidType VOID_TYPE = null;

	public BooleanType BOOLEAN_TYPE = null;

	public IntegerType INTEGER_TYPE = null;

	public RealType REAL_TYPE = null;

	public StringType STRING_TYPE = null;

	public Classifier[] NONE = null;

	public Classifier CLASSIFIER_TYPE = null;

	// Have to add operations like this, because they use each other
	// creating the operations within the constructors causes circular
	// references, or means that types are created witout operations.
	protected void init() {
		this.OCLANY_TYPE = new OclAnyTypeImpl(this.processor);
		// oclMessageType = new OclMessageType$Class();
		this.VOID_TYPE = new VoidTypeImpl(this.processor);
		this.BOOLEAN_TYPE = new BooleanTypeImpl(this.processor);
		this.INTEGER_TYPE = new IntegerTypeImpl(this.processor);
		this.REAL_TYPE = new RealTypeImpl(this.processor);
		this.STRING_TYPE = new StringTypeImpl(this.processor);
		this.CLASSIFIER_TYPE = CreationHelper.createClassifier(this.processor);

		// --- Create operations ---
		this.CLASSIFIER_TYPE.createOperations(this);
		this.OCLANY_TYPE.createOperations(this);
		this.REAL_TYPE.createOperations(this);
		this.INTEGER_TYPE.createOperations(this);
		this.STRING_TYPE.createOperations(this);
		this.BOOLEAN_TYPE.createOperations(this);
		this.VOID_TYPE.createOperations(this);
	}

	protected Operation buildOperation(Classifier ret, String op_name, Classifier params[]) {
		return this.processor.getBridgeFactory().buildOperation(ret, op_name, params);
	}

	public Classifier getFlatType(Classifier type) {
		while (type instanceof CollectionType && !(type instanceof VoidType)) {
			type = ((CollectionType) type).getElementType();
		}
		return type;
	}
}
