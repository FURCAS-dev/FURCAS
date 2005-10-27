/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.types.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ocl.internal.utilities.AstNode;
import org.eclipse.emf.ocl.internal.utilities.TypedAstNode;
import org.eclipse.emf.ocl.types.*;

import org.eclipse.emf.ocl.types.AnyType;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.ModelElementType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.PrimitiveInteger;
import org.eclipse.emf.ocl.types.PrimitiveReal;
import org.eclipse.emf.ocl.types.PrimitiveString;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.VoidType;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ocl.types.TypesPackage
 * @generated
 */
public class TypesSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesSwitch() {
		if (modelPackage == null) {
			modelPackage = TypesPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TypesPackage.ANY_TYPE: {
				AnyType anyType = (AnyType)theEObject;
				Object result = caseAnyType(anyType);
				if (result == null) result = caseEDataType(anyType);
				if (result == null) result = caseEClassifier(anyType);
				if (result == null) result = caseENamedElement(anyType);
				if (result == null) result = caseEModelElement(anyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.BAG_TYPE: {
				BagType bagType = (BagType)theEObject;
				Object result = caseBagType(bagType);
				if (result == null) result = caseCollectionType(bagType);
				if (result == null) result = caseEDataType(bagType);
				if (result == null) result = caseTypedAstNode(bagType);
				if (result == null) result = caseEClassifier(bagType);
				if (result == null) result = caseAstNode(bagType);
				if (result == null) result = caseENamedElement(bagType);
				if (result == null) result = caseEModelElement(bagType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.COLLECTION_TYPE: {
				CollectionType collectionType = (CollectionType)theEObject;
				Object result = caseCollectionType(collectionType);
				if (result == null) result = caseEDataType(collectionType);
				if (result == null) result = caseTypedAstNode(collectionType);
				if (result == null) result = caseEClassifier(collectionType);
				if (result == null) result = caseAstNode(collectionType);
				if (result == null) result = caseENamedElement(collectionType);
				if (result == null) result = caseEModelElement(collectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.ORDERED_SET_TYPE: {
				OrderedSetType orderedSetType = (OrderedSetType)theEObject;
				Object result = caseOrderedSetType(orderedSetType);
				if (result == null) result = caseCollectionType(orderedSetType);
				if (result == null) result = caseEDataType(orderedSetType);
				if (result == null) result = caseTypedAstNode(orderedSetType);
				if (result == null) result = caseEClassifier(orderedSetType);
				if (result == null) result = caseAstNode(orderedSetType);
				if (result == null) result = caseENamedElement(orderedSetType);
				if (result == null) result = caseEModelElement(orderedSetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.PRIMITIVE_BOOLEAN: {
				PrimitiveBoolean primitiveBoolean = (PrimitiveBoolean)theEObject;
				Object result = casePrimitiveBoolean(primitiveBoolean);
				if (result == null) result = casePrimitiveType(primitiveBoolean);
				if (result == null) result = caseAnyType(primitiveBoolean);
				if (result == null) result = caseEDataType(primitiveBoolean);
				if (result == null) result = caseEClassifier(primitiveBoolean);
				if (result == null) result = caseENamedElement(primitiveBoolean);
				if (result == null) result = caseEModelElement(primitiveBoolean);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.PRIMITIVE_INTEGER: {
				PrimitiveInteger primitiveInteger = (PrimitiveInteger)theEObject;
				Object result = casePrimitiveInteger(primitiveInteger);
				if (result == null) result = casePrimitiveReal(primitiveInteger);
				if (result == null) result = casePrimitiveType(primitiveInteger);
				if (result == null) result = caseAnyType(primitiveInteger);
				if (result == null) result = caseEDataType(primitiveInteger);
				if (result == null) result = caseEClassifier(primitiveInteger);
				if (result == null) result = caseENamedElement(primitiveInteger);
				if (result == null) result = caseEModelElement(primitiveInteger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.PRIMITIVE_REAL: {
				PrimitiveReal primitiveReal = (PrimitiveReal)theEObject;
				Object result = casePrimitiveReal(primitiveReal);
				if (result == null) result = casePrimitiveType(primitiveReal);
				if (result == null) result = caseAnyType(primitiveReal);
				if (result == null) result = caseEDataType(primitiveReal);
				if (result == null) result = caseEClassifier(primitiveReal);
				if (result == null) result = caseENamedElement(primitiveReal);
				if (result == null) result = caseEModelElement(primitiveReal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.PRIMITIVE_STRING: {
				PrimitiveString primitiveString = (PrimitiveString)theEObject;
				Object result = casePrimitiveString(primitiveString);
				if (result == null) result = casePrimitiveType(primitiveString);
				if (result == null) result = caseAnyType(primitiveString);
				if (result == null) result = caseEDataType(primitiveString);
				if (result == null) result = caseEClassifier(primitiveString);
				if (result == null) result = caseENamedElement(primitiveString);
				if (result == null) result = caseEModelElement(primitiveString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				Object result = casePrimitiveType(primitiveType);
				if (result == null) result = caseAnyType(primitiveType);
				if (result == null) result = caseEDataType(primitiveType);
				if (result == null) result = caseEClassifier(primitiveType);
				if (result == null) result = caseENamedElement(primitiveType);
				if (result == null) result = caseEModelElement(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.SEQUENCE_TYPE: {
				SequenceType sequenceType = (SequenceType)theEObject;
				Object result = caseSequenceType(sequenceType);
				if (result == null) result = caseCollectionType(sequenceType);
				if (result == null) result = caseEDataType(sequenceType);
				if (result == null) result = caseTypedAstNode(sequenceType);
				if (result == null) result = caseEClassifier(sequenceType);
				if (result == null) result = caseAstNode(sequenceType);
				if (result == null) result = caseENamedElement(sequenceType);
				if (result == null) result = caseEModelElement(sequenceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.SET_TYPE: {
				SetType setType = (SetType)theEObject;
				Object result = caseSetType(setType);
				if (result == null) result = caseCollectionType(setType);
				if (result == null) result = caseEDataType(setType);
				if (result == null) result = caseTypedAstNode(setType);
				if (result == null) result = caseEClassifier(setType);
				if (result == null) result = caseAstNode(setType);
				if (result == null) result = caseENamedElement(setType);
				if (result == null) result = caseEModelElement(setType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TUPLE_TYPE: {
				TupleType tupleType = (TupleType)theEObject;
				Object result = caseTupleType(tupleType);
				if (result == null) result = caseEClass(tupleType);
				if (result == null) result = caseEClassifier(tupleType);
				if (result == null) result = caseENamedElement(tupleType);
				if (result == null) result = caseEModelElement(tupleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.VOID_TYPE: {
				VoidType voidType = (VoidType)theEObject;
				Object result = caseVoidType(voidType);
				if (result == null) result = caseEClassifier(voidType);
				if (result == null) result = caseENamedElement(voidType);
				if (result == null) result = caseEModelElement(voidType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.MESSAGE_TYPE: {
				MessageType messageType = (MessageType)theEObject;
				Object result = caseMessageType(messageType);
				if (result == null) result = caseEClassifier(messageType);
				if (result == null) result = caseENamedElement(messageType);
				if (result == null) result = caseEModelElement(messageType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.MODEL_ELEMENT_TYPE: {
				ModelElementType modelElementType = (ModelElementType)theEObject;
				Object result = caseModelElementType(modelElementType);
				if (result == null) result = caseEClassifier(modelElementType);
				if (result == null) result = caseENamedElement(modelElementType);
				if (result == null) result = caseEModelElement(modelElementType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.OCL_STATE: {
				OclState oclState = (OclState)theEObject;
				Object result = caseOclState(oclState);
				if (result == null) result = caseEcore_ENamedElement(oclState);
				if (result == null) result = caseEcore_EModelElement(oclState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Bag Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBagType(BagType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Ordered Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrderedSetType(OrderedSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Sequence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSequenceType(SequenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSetType(SetType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Tuple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTupleType(TupleType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Void Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVoidType(VoidType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Message Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMessageType(MessageType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Model Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Model Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseModelElementType(ModelElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Ocl State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Ocl State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclState(OclState object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primitive Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primitive Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveBoolean(PrimitiveBoolean object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primitive Integer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primitive Integer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveInteger(PrimitiveInteger object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primitive Real</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primitive Real</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveReal(PrimitiveReal object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Primitive String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Primitive String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveString(PrimitiveString object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnyType(AnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>ENamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>ENamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseENamedElement(ENamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EClassifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEClassifier(EClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EData Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EData Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEDataType(EDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Ast Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Ast Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAstNode(AstNode object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Typed Ast Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Typed Ast Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTypedAstNode(TypedAstNode object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEClass(EClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEcore_EModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>ENamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>ENamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEcore_ENamedElement(ENamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //TypesSwitch
