/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.types.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.syntax.ast.Visitable;

import org.oslo.ocl20.syntax.ast.expressions.LiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;
import org.oslo.ocl20.syntax.ast.expressions.PrimaryExpAS;

import org.oslo.ocl20.syntax.ast.types.*;

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
 * @see org.oslo.ocl20.syntax.ast.types.TypesPackage
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
			case TypesPackage.BAG_TYPE_AS: {
				BagTypeAS bagTypeAS = (BagTypeAS)theEObject;
				Object result = caseBagTypeAS(bagTypeAS);
				if (result == null) result = caseCollectionTypeAS(bagTypeAS);
				if (result == null) result = caseTypeAS(bagTypeAS);
				if (result == null) result = caseLiteralExpAS(bagTypeAS);
				if (result == null) result = casePrimaryExpAS(bagTypeAS);
				if (result == null) result = caseOclExpressionAS(bagTypeAS);
				if (result == null) result = caseVisitable(bagTypeAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.CLASSIFIER_AS: {
				ClassifierAS classifierAS = (ClassifierAS)theEObject;
				Object result = caseClassifierAS(classifierAS);
				if (result == null) result = caseTypeAS(classifierAS);
				if (result == null) result = caseLiteralExpAS(classifierAS);
				if (result == null) result = casePrimaryExpAS(classifierAS);
				if (result == null) result = caseOclExpressionAS(classifierAS);
				if (result == null) result = caseVisitable(classifierAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.COLLECTION_TYPE_AS: {
				CollectionTypeAS collectionTypeAS = (CollectionTypeAS)theEObject;
				Object result = caseCollectionTypeAS(collectionTypeAS);
				if (result == null) result = caseTypeAS(collectionTypeAS);
				if (result == null) result = caseLiteralExpAS(collectionTypeAS);
				if (result == null) result = casePrimaryExpAS(collectionTypeAS);
				if (result == null) result = caseOclExpressionAS(collectionTypeAS);
				if (result == null) result = caseVisitable(collectionTypeAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.ORDERED_SET_TYPE_AS: {
				OrderedSetTypeAS orderedSetTypeAS = (OrderedSetTypeAS)theEObject;
				Object result = caseOrderedSetTypeAS(orderedSetTypeAS);
				if (result == null) result = caseCollectionTypeAS(orderedSetTypeAS);
				if (result == null) result = caseTypeAS(orderedSetTypeAS);
				if (result == null) result = caseLiteralExpAS(orderedSetTypeAS);
				if (result == null) result = casePrimaryExpAS(orderedSetTypeAS);
				if (result == null) result = caseOclExpressionAS(orderedSetTypeAS);
				if (result == null) result = caseVisitable(orderedSetTypeAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.SEQUENCE_TYPE_AS: {
				SequenceTypeAS sequenceTypeAS = (SequenceTypeAS)theEObject;
				Object result = caseSequenceTypeAS(sequenceTypeAS);
				if (result == null) result = caseCollectionTypeAS(sequenceTypeAS);
				if (result == null) result = caseTypeAS(sequenceTypeAS);
				if (result == null) result = caseLiteralExpAS(sequenceTypeAS);
				if (result == null) result = casePrimaryExpAS(sequenceTypeAS);
				if (result == null) result = caseOclExpressionAS(sequenceTypeAS);
				if (result == null) result = caseVisitable(sequenceTypeAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.SET_TYPE_AS: {
				SetTypeAS setTypeAS = (SetTypeAS)theEObject;
				Object result = caseSetTypeAS(setTypeAS);
				if (result == null) result = caseCollectionTypeAS(setTypeAS);
				if (result == null) result = caseTypeAS(setTypeAS);
				if (result == null) result = caseLiteralExpAS(setTypeAS);
				if (result == null) result = casePrimaryExpAS(setTypeAS);
				if (result == null) result = caseOclExpressionAS(setTypeAS);
				if (result == null) result = caseVisitable(setTypeAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TUPLE_TYPE_AS: {
				TupleTypeAS tupleTypeAS = (TupleTypeAS)theEObject;
				Object result = caseTupleTypeAS(tupleTypeAS);
				if (result == null) result = caseTypeAS(tupleTypeAS);
				if (result == null) result = caseLiteralExpAS(tupleTypeAS);
				if (result == null) result = casePrimaryExpAS(tupleTypeAS);
				if (result == null) result = caseOclExpressionAS(tupleTypeAS);
				if (result == null) result = caseVisitable(tupleTypeAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TYPE_AS: {
				TypeAS typeAS = (TypeAS)theEObject;
				Object result = caseTypeAS(typeAS);
				if (result == null) result = caseLiteralExpAS(typeAS);
				if (result == null) result = casePrimaryExpAS(typeAS);
				if (result == null) result = caseOclExpressionAS(typeAS);
				if (result == null) result = caseVisitable(typeAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBagTypeAS(BagTypeAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClassifierAS(ClassifierAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionTypeAS(CollectionTypeAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrderedSetTypeAS(OrderedSetTypeAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSequenceTypeAS(SequenceTypeAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSetTypeAS(SetTypeAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTupleTypeAS(TupleTypeAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTypeAS(TypeAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Expression AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Expression AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclExpressionAS(OclExpressionAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primary Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primary Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimaryExpAS(PrimaryExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLiteralExpAS(LiteralExpAS object) {
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
	public Object defaultCase(EObject object) {
		return null;
	}

} //TypesSwitch
