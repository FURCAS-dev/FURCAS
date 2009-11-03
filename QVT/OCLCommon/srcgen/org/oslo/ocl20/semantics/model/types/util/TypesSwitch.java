/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.types.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.semantics.SemanticsVisitable;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.DataType;
import org.oslo.ocl20.semantics.bridge.Element;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Primitive;

import org.oslo.ocl20.semantics.model.types.*;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.model.types.TypesPackage
 * @generated
 */
public class TypesSwitch {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static TypesPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypesSwitch() {
		if (modelPackage == null) {
			modelPackage = TypesPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch((EClass) eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TypesPackage.BAG_TYPE: {
				BagType bagType = (BagType) theEObject;
				Object result = caseBagType(bagType);
				if (result == null)
					result = caseCollectionType(bagType);
				if (result == null)
					result = caseDataType(bagType);
				if (result == null)
					result = caseClassifier(bagType);
				if (result == null)
					result = caseNamespace(bagType);
				if (result == null)
					result = caseModelElement(bagType);
				if (result == null)
					result = caseSemanticsVisitable(bagType);
				if (result == null)
					result = caseElement(bagType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.BOOLEAN_TYPE: {
				BooleanType booleanType = (BooleanType) theEObject;
				Object result = caseBooleanType(booleanType);
				if (result == null)
					result = casePrimitive(booleanType);
				if (result == null)
					result = caseOclAnyType(booleanType);
				if (result == null)
					result = caseDataType(booleanType);
				if (result == null)
					result = caseClassifier(booleanType);
				if (result == null)
					result = caseNamespace(booleanType);
				if (result == null)
					result = caseModelElement(booleanType);
				if (result == null)
					result = caseSemanticsVisitable(booleanType);
				if (result == null)
					result = caseElement(booleanType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.COLLECTION_TYPE: {
				CollectionType collectionType = (CollectionType) theEObject;
				Object result = caseCollectionType(collectionType);
				if (result == null)
					result = caseDataType(collectionType);
				if (result == null)
					result = caseClassifier(collectionType);
				if (result == null)
					result = caseNamespace(collectionType);
				if (result == null)
					result = caseModelElement(collectionType);
				if (result == null)
					result = caseSemanticsVisitable(collectionType);
				if (result == null)
					result = caseElement(collectionType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.INTEGER_TYPE: {
				IntegerType integerType = (IntegerType) theEObject;
				Object result = caseIntegerType(integerType);
				if (result == null)
					result = caseRealType(integerType);
				if (result == null)
					result = casePrimitive(integerType);
				if (result == null)
					result = caseOclAnyType(integerType);
				if (result == null)
					result = caseDataType(integerType);
				if (result == null)
					result = caseClassifier(integerType);
				if (result == null)
					result = caseNamespace(integerType);
				if (result == null)
					result = caseModelElement(integerType);
				if (result == null)
					result = caseSemanticsVisitable(integerType);
				if (result == null)
					result = caseElement(integerType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.OCL_ANY_TYPE: {
				OclAnyType oclAnyType = (OclAnyType) theEObject;
				Object result = caseOclAnyType(oclAnyType);
				if (result == null)
					result = caseDataType(oclAnyType);
				if (result == null)
					result = caseClassifier(oclAnyType);
				if (result == null)
					result = caseNamespace(oclAnyType);
				if (result == null)
					result = caseModelElement(oclAnyType);
				if (result == null)
					result = caseSemanticsVisitable(oclAnyType);
				if (result == null)
					result = caseElement(oclAnyType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.OCL_MESSAGE_TYPE: {
				OclMessageType oclMessageType = (OclMessageType) theEObject;
				Object result = caseOclMessageType(oclMessageType);
				if (result == null)
					result = caseClassifier(oclMessageType);
				if (result == null)
					result = caseNamespace(oclMessageType);
				if (result == null)
					result = caseModelElement(oclMessageType);
				if (result == null)
					result = caseSemanticsVisitable(oclMessageType);
				if (result == null)
					result = caseElement(oclMessageType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.ORDERED_SET_TYPE: {
				OrderedSetType orderedSetType = (OrderedSetType) theEObject;
				Object result = caseOrderedSetType(orderedSetType);
				if (result == null)
					result = caseCollectionType(orderedSetType);
				if (result == null)
					result = caseDataType(orderedSetType);
				if (result == null)
					result = caseClassifier(orderedSetType);
				if (result == null)
					result = caseNamespace(orderedSetType);
				if (result == null)
					result = caseModelElement(orderedSetType);
				if (result == null)
					result = caseSemanticsVisitable(orderedSetType);
				if (result == null)
					result = caseElement(orderedSetType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.REAL_TYPE: {
				RealType realType = (RealType) theEObject;
				Object result = caseRealType(realType);
				if (result == null)
					result = casePrimitive(realType);
				if (result == null)
					result = caseOclAnyType(realType);
				if (result == null)
					result = caseDataType(realType);
				if (result == null)
					result = caseClassifier(realType);
				if (result == null)
					result = caseNamespace(realType);
				if (result == null)
					result = caseModelElement(realType);
				if (result == null)
					result = caseSemanticsVisitable(realType);
				if (result == null)
					result = caseElement(realType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.SEQUENCE_TYPE: {
				SequenceType sequenceType = (SequenceType) theEObject;
				Object result = caseSequenceType(sequenceType);
				if (result == null)
					result = caseCollectionType(sequenceType);
				if (result == null)
					result = caseDataType(sequenceType);
				if (result == null)
					result = caseClassifier(sequenceType);
				if (result == null)
					result = caseNamespace(sequenceType);
				if (result == null)
					result = caseModelElement(sequenceType);
				if (result == null)
					result = caseSemanticsVisitable(sequenceType);
				if (result == null)
					result = caseElement(sequenceType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.SET_TYPE: {
				SetType setType = (SetType) theEObject;
				Object result = caseSetType(setType);
				if (result == null)
					result = caseCollectionType(setType);
				if (result == null)
					result = caseDataType(setType);
				if (result == null)
					result = caseClassifier(setType);
				if (result == null)
					result = caseNamespace(setType);
				if (result == null)
					result = caseModelElement(setType);
				if (result == null)
					result = caseSemanticsVisitable(setType);
				if (result == null)
					result = caseElement(setType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.STRING_TYPE: {
				StringType stringType = (StringType) theEObject;
				Object result = caseStringType(stringType);
				if (result == null)
					result = casePrimitive(stringType);
				if (result == null)
					result = caseOclAnyType(stringType);
				if (result == null)
					result = caseDataType(stringType);
				if (result == null)
					result = caseClassifier(stringType);
				if (result == null)
					result = caseNamespace(stringType);
				if (result == null)
					result = caseModelElement(stringType);
				if (result == null)
					result = caseSemanticsVisitable(stringType);
				if (result == null)
					result = caseElement(stringType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TUPLE_TYPE: {
				TupleType tupleType = (TupleType) theEObject;
				Object result = caseTupleType(tupleType);
				if (result == null)
					result = caseDataType(tupleType);
				if (result == null)
					result = caseClassifier(tupleType);
				if (result == null)
					result = caseNamespace(tupleType);
				if (result == null)
					result = caseModelElement(tupleType);
				if (result == null)
					result = caseSemanticsVisitable(tupleType);
				if (result == null)
					result = caseElement(tupleType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TYPE_TYPE: {
				TypeType typeType = (TypeType) theEObject;
				Object result = caseTypeType(typeType);
				if (result == null)
					result = casePrimitive(typeType);
				if (result == null)
					result = caseOclAnyType(typeType);
				if (result == null)
					result = caseDataType(typeType);
				if (result == null)
					result = caseClassifier(typeType);
				if (result == null)
					result = caseNamespace(typeType);
				if (result == null)
					result = caseModelElement(typeType);
				if (result == null)
					result = caseSemanticsVisitable(typeType);
				if (result == null)
					result = caseElement(typeType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.VOID_TYPE: {
				VoidType voidType = (VoidType) theEObject;
				Object result = caseVoidType(voidType);
				if (result == null)
					result = caseStringType(voidType);
				if (result == null)
					result = caseOrderedSetType(voidType);
				if (result == null)
					result = caseIntegerType(voidType);
				if (result == null)
					result = caseBooleanType(voidType);
				if (result == null)
					result = caseSetType(voidType);
				if (result == null)
					result = caseSequenceType(voidType);
				if (result == null)
					result = caseOclModelElementType(voidType);
				if (result == null)
					result = caseBagType(voidType);
				if (result == null)
					result = casePrimitive(voidType);
				if (result == null)
					result = caseCollectionType(voidType);
				if (result == null)
					result = caseRealType(voidType);
				if (result == null)
					result = caseOclAnyType(voidType);
				if (result == null)
					result = caseDataType(voidType);
				if (result == null)
					result = caseClassifier(voidType);
				if (result == null)
					result = caseNamespace(voidType);
				if (result == null)
					result = caseModelElement(voidType);
				if (result == null)
					result = caseSemanticsVisitable(voidType);
				if (result == null)
					result = caseElement(voidType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBagType(BagType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIntegerType(IntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Any Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclAnyType(OclAnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Message Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Message Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclMessageType(OclMessageType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrderedSetType(OrderedSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRealType(RealType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSequenceType(SequenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSetType(SetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTupleType(TupleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTypeType(TypeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVoidType(VoidType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSemanticsVisitable(SemanticsVisitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseModelElement(ModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClassifier(Classifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitive(Primitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Ocl Model Element Type</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Ocl Model Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclModelElementType(OclModelElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} // TypesSwitch
