/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary.util;

import com.sap.tc.moin.repository.mmi.Model.Classifier;
import com.sap.tc.moin.repository.mmi.Model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.Model.ModelElement;
import com.sap.tc.moin.repository.mmi.Model.Namespace;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.omg.OCL.StdLibrary.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage
 * @generated
 */
public class StdLibrarySwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StdLibraryPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StdLibrarySwitch() {
		if (modelPackage == null) {
			modelPackage = StdLibraryPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StdLibraryPackage.OCL_ANY_STD_LIB: {
				OclAnyStdLib oclAnyStdLib = (OclAnyStdLib)theEObject;
				T result = caseOclAnyStdLib(oclAnyStdLib);
				if (result == null) result = caseClassifier(oclAnyStdLib);
				if (result == null) result = caseGeneralizableElement(oclAnyStdLib);
				if (result == null) result = caseNamespace(oclAnyStdLib);
				if (result == null) result = caseModelElement(oclAnyStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.STRING_STD_LIB: {
				StringStdLib stringStdLib = (StringStdLib)theEObject;
				T result = caseStringStdLib(stringStdLib);
				if (result == null) result = caseOclAnyStdLib(stringStdLib);
				if (result == null) result = caseClassifier(stringStdLib);
				if (result == null) result = caseGeneralizableElement(stringStdLib);
				if (result == null) result = caseNamespace(stringStdLib);
				if (result == null) result = caseModelElement(stringStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.BOOLEAN_STD_LIB: {
				BooleanStdLib booleanStdLib = (BooleanStdLib)theEObject;
				T result = caseBooleanStdLib(booleanStdLib);
				if (result == null) result = caseOclAnyStdLib(booleanStdLib);
				if (result == null) result = caseClassifier(booleanStdLib);
				if (result == null) result = caseGeneralizableElement(booleanStdLib);
				if (result == null) result = caseNamespace(booleanStdLib);
				if (result == null) result = caseModelElement(booleanStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.FLOAT_STD_LIB: {
				FloatStdLib floatStdLib = (FloatStdLib)theEObject;
				T result = caseFloatStdLib(floatStdLib);
				if (result == null) result = caseOclAnyStdLib(floatStdLib);
				if (result == null) result = caseClassifier(floatStdLib);
				if (result == null) result = caseGeneralizableElement(floatStdLib);
				if (result == null) result = caseNamespace(floatStdLib);
				if (result == null) result = caseModelElement(floatStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.COLLECTION_TYPE_STD_LIB: {
				CollectionTypeStdLib collectionTypeStdLib = (CollectionTypeStdLib)theEObject;
				T result = caseCollectionTypeStdLib(collectionTypeStdLib);
				if (result == null) result = caseClassifier(collectionTypeStdLib);
				if (result == null) result = caseGeneralizableElement(collectionTypeStdLib);
				if (result == null) result = caseNamespace(collectionTypeStdLib);
				if (result == null) result = caseModelElement(collectionTypeStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.SET_TYPE_STD_LIB: {
				SetTypeStdLib setTypeStdLib = (SetTypeStdLib)theEObject;
				T result = caseSetTypeStdLib(setTypeStdLib);
				if (result == null) result = caseCollectionTypeStdLib(setTypeStdLib);
				if (result == null) result = caseClassifier(setTypeStdLib);
				if (result == null) result = caseGeneralizableElement(setTypeStdLib);
				if (result == null) result = caseNamespace(setTypeStdLib);
				if (result == null) result = caseModelElement(setTypeStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.SEQUENCE_TYPE_STD_LIB: {
				SequenceTypeStdLib sequenceTypeStdLib = (SequenceTypeStdLib)theEObject;
				T result = caseSequenceTypeStdLib(sequenceTypeStdLib);
				if (result == null) result = caseCollectionTypeStdLib(sequenceTypeStdLib);
				if (result == null) result = caseClassifier(sequenceTypeStdLib);
				if (result == null) result = caseGeneralizableElement(sequenceTypeStdLib);
				if (result == null) result = caseNamespace(sequenceTypeStdLib);
				if (result == null) result = caseModelElement(sequenceTypeStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.BAG_TYPE_STD_LIB: {
				BagTypeStdLib bagTypeStdLib = (BagTypeStdLib)theEObject;
				T result = caseBagTypeStdLib(bagTypeStdLib);
				if (result == null) result = caseCollectionTypeStdLib(bagTypeStdLib);
				if (result == null) result = caseClassifier(bagTypeStdLib);
				if (result == null) result = caseGeneralizableElement(bagTypeStdLib);
				if (result == null) result = caseNamespace(bagTypeStdLib);
				if (result == null) result = caseModelElement(bagTypeStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.ORDERED_SET_TYPE_STD_LIB: {
				OrderedSetTypeStdLib orderedSetTypeStdLib = (OrderedSetTypeStdLib)theEObject;
				T result = caseOrderedSetTypeStdLib(orderedSetTypeStdLib);
				if (result == null) result = caseCollectionTypeStdLib(orderedSetTypeStdLib);
				if (result == null) result = caseClassifier(orderedSetTypeStdLib);
				if (result == null) result = caseGeneralizableElement(orderedSetTypeStdLib);
				if (result == null) result = caseNamespace(orderedSetTypeStdLib);
				if (result == null) result = caseModelElement(orderedSetTypeStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.OCL_VOID_STD_LIB: {
				OclVoidStdLib oclVoidStdLib = (OclVoidStdLib)theEObject;
				T result = caseOclVoidStdLib(oclVoidStdLib);
				if (result == null) result = caseOclAnyStdLib(oclVoidStdLib);
				if (result == null) result = caseClassifier(oclVoidStdLib);
				if (result == null) result = caseGeneralizableElement(oclVoidStdLib);
				if (result == null) result = caseNamespace(oclVoidStdLib);
				if (result == null) result = caseModelElement(oclVoidStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.INTEGER_STD_LIB: {
				IntegerStdLib integerStdLib = (IntegerStdLib)theEObject;
				T result = caseIntegerStdLib(integerStdLib);
				if (result == null) result = caseOclAnyStdLib(integerStdLib);
				if (result == null) result = caseClassifier(integerStdLib);
				if (result == null) result = caseGeneralizableElement(integerStdLib);
				if (result == null) result = caseNamespace(integerStdLib);
				if (result == null) result = caseModelElement(integerStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.OCL_TYPE_STD_LIB: {
				OclTypeStdLib oclTypeStdLib = (OclTypeStdLib)theEObject;
				T result = caseOclTypeStdLib(oclTypeStdLib);
				if (result == null) result = caseOclAnyStdLib(oclTypeStdLib);
				if (result == null) result = caseClassifier(oclTypeStdLib);
				if (result == null) result = caseGeneralizableElement(oclTypeStdLib);
				if (result == null) result = caseNamespace(oclTypeStdLib);
				if (result == null) result = caseModelElement(oclTypeStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.TUPLE_TYPE_STD_LIB: {
				TupleTypeStdLib tupleTypeStdLib = (TupleTypeStdLib)theEObject;
				T result = caseTupleTypeStdLib(tupleTypeStdLib);
				if (result == null) result = caseClassifier(tupleTypeStdLib);
				if (result == null) result = caseGeneralizableElement(tupleTypeStdLib);
				if (result == null) result = caseNamespace(tupleTypeStdLib);
				if (result == null) result = caseModelElement(tupleTypeStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.DOUBLE_STD_LIB: {
				DoubleStdLib doubleStdLib = (DoubleStdLib)theEObject;
				T result = caseDoubleStdLib(doubleStdLib);
				if (result == null) result = caseOclAnyStdLib(doubleStdLib);
				if (result == null) result = caseClassifier(doubleStdLib);
				if (result == null) result = caseGeneralizableElement(doubleStdLib);
				if (result == null) result = caseNamespace(doubleStdLib);
				if (result == null) result = caseModelElement(doubleStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.LONG_STD_LIB: {
				LongStdLib longStdLib = (LongStdLib)theEObject;
				T result = caseLongStdLib(longStdLib);
				if (result == null) result = caseOclAnyStdLib(longStdLib);
				if (result == null) result = caseClassifier(longStdLib);
				if (result == null) result = caseGeneralizableElement(longStdLib);
				if (result == null) result = caseNamespace(longStdLib);
				if (result == null) result = caseModelElement(longStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StdLibraryPackage.OCL_INVALID_STD_LIB: {
				OclInvalidStdLib oclInvalidStdLib = (OclInvalidStdLib)theEObject;
				T result = caseOclInvalidStdLib(oclInvalidStdLib);
				if (result == null) result = caseOclAnyStdLib(oclInvalidStdLib);
				if (result == null) result = caseClassifier(oclInvalidStdLib);
				if (result == null) result = caseGeneralizableElement(oclInvalidStdLib);
				if (result == null) result = caseNamespace(oclInvalidStdLib);
				if (result == null) result = caseModelElement(oclInvalidStdLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Any Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Any Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclAnyStdLib(OclAnyStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringStdLib(StringStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanStdLib(BooleanStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatStdLib(FloatStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionTypeStdLib(CollectionTypeStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetTypeStdLib(SetTypeStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceTypeStdLib(SequenceTypeStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBagTypeStdLib(BagTypeStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedSetTypeStdLib(OrderedSetTypeStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Void Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Void Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclVoidStdLib(OclVoidStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerStdLib(IntegerStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Type Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclTypeStdLib(OclTypeStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleTypeStdLib(TupleTypeStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleStdLib(DoubleStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongStdLib(LongStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Invalid Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Invalid Std Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclInvalidStdLib(OclInvalidStdLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElement(ModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generalizable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generalizable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralizableElement(GeneralizableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifier(Classifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //StdLibrarySwitch
