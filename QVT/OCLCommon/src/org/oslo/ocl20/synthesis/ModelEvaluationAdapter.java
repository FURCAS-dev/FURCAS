package org.oslo.ocl20.synthesis;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.EnumLiteral;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;
import org.oslo.ocl20.standard.lib.OclEnumeration;
import org.oslo.ocl20.standard.lib.OclSet;
import org.oslo.ocl20.standard.lib.OclType;

import uk.ac.kent.cs.kmf.util.ILog;

/**
 * @author dha
 * 
 */
public interface ModelEvaluationAdapter {
	Object getImpl(ModelElement me);

	Class getImplClass(Classifier me);

	// Code Generation
	// String getModelPropertyName(String string);
	// String getEnumLiteralReference(EnumLiteral enumLit);
	// String getDefinedPropertyReference(OclAny source, DefinedProperty property);

	String getGetterName(Property property);

	String getSetterName(Property property);

	Object getEnumLiteralValue(EnumLiteral enumLit);

	boolean OclModelElement_equalTo(OclAny o1, OclAny o2);

	boolean OclModelElement_oclIsNew(OclAny o1);

	boolean OclModelElement_oclIsUndefined(OclAny o1);

	Object OclModelElement_oclAsType(OclAny o1, OclType o2);

	boolean OclModelElement_oclIsTypeOf(OclAny o1, OclType o2);

	boolean OclModelElement_oclIsKindOf(OclAny o1, OclType o2);

	/**
	 * Get all instances of type <code>type</code> for all registered models
	 * 
	 * @param type
	 * @param modelForDirection
	 * @return
	 */
	OclSet OclType_allInstances(OclType o1);

	/**
	 * Get all contained instances of type <code>type</code> for models <code>models</code>
	 * 
	 * @param type
	 * @param modelForDirection
	 * @return
	 */
	OclSet OclType_allInstances(OclType type, Collection models);

	OclType OclModelElement_oclType(OclAnyModelElement impl);

	boolean EnumLiteral_equalTo(OclEnumeration e1, OclAny e2);

	boolean EnumLiteral_oclIsNew(Object o1);

	boolean EnumLiteral_oclIsUndefined(Object o1);

	Object EnumLiteral_oclAsType(Object o1, Object o2);

	boolean EnumLiteral_oclIsTypeOf(Object o1, Object o2);

	boolean EnumLiteral_oclIsKindOf(Object o1, Object o2);

	Set EnumLiteral_allInstances(Object o1);

	Object getValueForFeauture(Object source, Property property); // TODO TODOMWA check parameters

	Object invokeModelOperation(Classifier sourceType, Classifier resultType, Object source, String operName, List javaTypes, List args, ILog log);

}
