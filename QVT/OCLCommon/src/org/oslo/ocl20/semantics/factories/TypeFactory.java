package org.oslo.ocl20.semantics.factories;

import org.oslo.ocl20.semantics.bridge.Classifier;
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
/**
 * @author dha
 *
 */
public interface TypeFactory {
	Classifier buildClassifier();
	BagType buildBagType(Classifier elementType);
	BooleanType buildBooleanType();
	CollectionType buildCollectionType(Classifier elementType);
	IntegerType buildIntegerType();
	OclAnyType buildOclAnyType();
	TypeType buildTypeType(Classifier type);
	OclMessageType buildOclMessageType();
	OrderedSetType buildOrderedSetType(Classifier elementType);
	RealType buildRealType();
	SequenceType buildSequenceType(Classifier elementType);
	SetType buildSetType(Classifier elementType);
	StringType buildStringType();
	TupleType buildTupleType(String[] names, Classifier[] types);
	VoidType buildVoidType();
	Classifier getFlatType(Classifier type);
}
