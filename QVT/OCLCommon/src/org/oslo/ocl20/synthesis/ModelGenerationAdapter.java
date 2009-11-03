package org.oslo.ocl20.synthesis;

import java.util.List;
import java.util.Set;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.EnumLiteral;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.model.contexts.DefinedOperation;
import org.oslo.ocl20.semantics.model.contexts.DefinedProperty;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclBoolean;
import org.oslo.ocl20.standard.lib.OclType;


/**
 * @author dha
 *
 */
public interface ModelGenerationAdapter {
	Object getImpl(ModelElement me);
	Class getImplClass(Classifier me);
	
	String getGetterName(String property_name);
	String getSetterName(String property_name);
	String getModelPropertyName(String string);
	String getEnumLiteralReference(EnumLiteral enumLit);
	String getDefinedPropertyReference(OclAny source, DefinedProperty property);
	String getDefinedOperationReference(OclAny source, DefinedOperation property, List arguments);

	//Object getEnumLiteralValue(EnumLiteral enumLit);

	OclBoolean OclModelElement_equalTo(OclAny o1, OclAny o2);
	OclBoolean OclModelElement_oclIsNew(OclAny o1);
	OclBoolean OclModelElement_oclIsUndefined(OclAny o1);
	Object OclModelElement_oclAsType(OclAny o1, OclType o2);
	OclBoolean OclModelElement_oclIsTypeOf(OclAny o1, OclType o2);
	OclBoolean OclModelElement_oclIsKindOf(OclAny o1, OclType o2);
	Set OclModelElement_allInstances(OclAny o1);
		
	OclBoolean EnumLiteral_equalTo(Object e1, Object e2);
	OclBoolean EnumLiteral_oclIsNew(Object o1);
	OclBoolean EnumLiteral_oclIsUndefined(Object o1);
	Object EnumLiteral_oclAsType(Object o1, OclType type);
	OclBoolean EnumLiteral_oclIsTypeOf(Object o1, OclType o2);
	OclBoolean EnumLiteral_oclIsKindOf(Object o1, OclType o2);
	Set EnumLiteral_allInstances(Object o1);


}
