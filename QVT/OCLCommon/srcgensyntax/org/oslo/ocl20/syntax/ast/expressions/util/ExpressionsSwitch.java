/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.syntax.ast.Visitable;

import org.oslo.ocl20.syntax.ast.expressions.*;

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
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpressionsPackage.eINSTANCE;
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
			case ExpressionsPackage.AND_EXP_AS: {
				AndExpAS andExpAS = (AndExpAS)theEObject;
				Object result = caseAndExpAS(andExpAS);
				if (result == null) result = caseLogicalExpAS(andExpAS);
				if (result == null) result = caseOclExpressionAS(andExpAS);
				if (result == null) result = caseVisitable(andExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ARROW_SELECTION_EXP_AS: {
				ArrowSelectionExpAS arrowSelectionExpAS = (ArrowSelectionExpAS)theEObject;
				Object result = caseArrowSelectionExpAS(arrowSelectionExpAS);
				if (result == null) result = caseSelectionExpAS(arrowSelectionExpAS);
				if (result == null) result = caseOclExpressionAS(arrowSelectionExpAS);
				if (result == null) result = caseVisitable(arrowSelectionExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ASSOCIATION_CALL_EXP_AS: {
				AssociationCallExpAS associationCallExpAS = (AssociationCallExpAS)theEObject;
				Object result = caseAssociationCallExpAS(associationCallExpAS);
				if (result == null) result = caseCallExpAS(associationCallExpAS);
				if (result == null) result = caseOclExpressionAS(associationCallExpAS);
				if (result == null) result = caseVisitable(associationCallExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.BOOLEAN_LITERAL_EXP_AS: {
				BooleanLiteralExpAS booleanLiteralExpAS = (BooleanLiteralExpAS)theEObject;
				Object result = caseBooleanLiteralExpAS(booleanLiteralExpAS);
				if (result == null) result = casePrimitiveLiteralExpAS(booleanLiteralExpAS);
				if (result == null) result = caseLiteralExpAS(booleanLiteralExpAS);
				if (result == null) result = casePrimaryExpAS(booleanLiteralExpAS);
				if (result == null) result = caseOclExpressionAS(booleanLiteralExpAS);
				if (result == null) result = caseVisitable(booleanLiteralExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CALL_EXP_AS: {
				CallExpAS callExpAS = (CallExpAS)theEObject;
				Object result = caseCallExpAS(callExpAS);
				if (result == null) result = caseOclExpressionAS(callExpAS);
				if (result == null) result = caseVisitable(callExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_ITEM_AS: {
				CollectionItemAS collectionItemAS = (CollectionItemAS)theEObject;
				Object result = caseCollectionItemAS(collectionItemAS);
				if (result == null) result = caseCollectionLiteralPartAS(collectionItemAS);
				if (result == null) result = caseVisitable(collectionItemAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_LITERAL_EXP_AS: {
				CollectionLiteralExpAS collectionLiteralExpAS = (CollectionLiteralExpAS)theEObject;
				Object result = caseCollectionLiteralExpAS(collectionLiteralExpAS);
				if (result == null) result = caseLiteralExpAS(collectionLiteralExpAS);
				if (result == null) result = casePrimaryExpAS(collectionLiteralExpAS);
				if (result == null) result = caseOclExpressionAS(collectionLiteralExpAS);
				if (result == null) result = caseVisitable(collectionLiteralExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_LITERAL_PART_AS: {
				CollectionLiteralPartAS collectionLiteralPartAS = (CollectionLiteralPartAS)theEObject;
				Object result = caseCollectionLiteralPartAS(collectionLiteralPartAS);
				if (result == null) result = caseVisitable(collectionLiteralPartAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_RANGE_AS: {
				CollectionRangeAS collectionRangeAS = (CollectionRangeAS)theEObject;
				Object result = caseCollectionRangeAS(collectionRangeAS);
				if (result == null) result = caseCollectionLiteralPartAS(collectionRangeAS);
				if (result == null) result = caseVisitable(collectionRangeAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.DOT_SELECTION_EXP_AS: {
				DotSelectionExpAS dotSelectionExpAS = (DotSelectionExpAS)theEObject;
				Object result = caseDotSelectionExpAS(dotSelectionExpAS);
				if (result == null) result = caseSelectionExpAS(dotSelectionExpAS);
				if (result == null) result = caseOclExpressionAS(dotSelectionExpAS);
				if (result == null) result = caseVisitable(dotSelectionExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ENUM_LITERAL_EXP_AS: {
				EnumLiteralExpAS enumLiteralExpAS = (EnumLiteralExpAS)theEObject;
				Object result = caseEnumLiteralExpAS(enumLiteralExpAS);
				if (result == null) result = caseLiteralExpAS(enumLiteralExpAS);
				if (result == null) result = casePrimaryExpAS(enumLiteralExpAS);
				if (result == null) result = caseOclExpressionAS(enumLiteralExpAS);
				if (result == null) result = caseVisitable(enumLiteralExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.IF_EXP_AS: {
				IfExpAS ifExpAS = (IfExpAS)theEObject;
				Object result = caseIfExpAS(ifExpAS);
				if (result == null) result = caseOclExpressionAS(ifExpAS);
				if (result == null) result = caseVisitable(ifExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.IMPLIES_EXP_AS: {
				ImpliesExpAS impliesExpAS = (ImpliesExpAS)theEObject;
				Object result = caseImpliesExpAS(impliesExpAS);
				if (result == null) result = caseLogicalExpAS(impliesExpAS);
				if (result == null) result = caseOclExpressionAS(impliesExpAS);
				if (result == null) result = caseVisitable(impliesExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.INTEGER_LITERAL_EXP_AS: {
				IntegerLiteralExpAS integerLiteralExpAS = (IntegerLiteralExpAS)theEObject;
				Object result = caseIntegerLiteralExpAS(integerLiteralExpAS);
				if (result == null) result = casePrimitiveLiteralExpAS(integerLiteralExpAS);
				if (result == null) result = caseLiteralExpAS(integerLiteralExpAS);
				if (result == null) result = casePrimaryExpAS(integerLiteralExpAS);
				if (result == null) result = caseOclExpressionAS(integerLiteralExpAS);
				if (result == null) result = caseVisitable(integerLiteralExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ITERATE_EXP_AS: {
				IterateExpAS iterateExpAS = (IterateExpAS)theEObject;
				Object result = caseIterateExpAS(iterateExpAS);
				if (result == null) result = caseLoopExpAS(iterateExpAS);
				if (result == null) result = caseOclExpressionAS(iterateExpAS);
				if (result == null) result = caseVisitable(iterateExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ITERATOR_EXP_AS: {
				IteratorExpAS iteratorExpAS = (IteratorExpAS)theEObject;
				Object result = caseIteratorExpAS(iteratorExpAS);
				if (result == null) result = caseLoopExpAS(iteratorExpAS);
				if (result == null) result = caseOclExpressionAS(iteratorExpAS);
				if (result == null) result = caseVisitable(iteratorExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LET_EXP_AS: {
				LetExpAS letExpAS = (LetExpAS)theEObject;
				Object result = caseLetExpAS(letExpAS);
				if (result == null) result = caseOclExpressionAS(letExpAS);
				if (result == null) result = caseVisitable(letExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LITERAL_EXP_AS: {
				LiteralExpAS literalExpAS = (LiteralExpAS)theEObject;
				Object result = caseLiteralExpAS(literalExpAS);
				if (result == null) result = casePrimaryExpAS(literalExpAS);
				if (result == null) result = caseOclExpressionAS(literalExpAS);
				if (result == null) result = caseVisitable(literalExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LOGICAL_EXP_AS: {
				LogicalExpAS logicalExpAS = (LogicalExpAS)theEObject;
				Object result = caseLogicalExpAS(logicalExpAS);
				if (result == null) result = caseOclExpressionAS(logicalExpAS);
				if (result == null) result = caseVisitable(logicalExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LOOP_EXP_AS: {
				LoopExpAS loopExpAS = (LoopExpAS)theEObject;
				Object result = caseLoopExpAS(loopExpAS);
				if (result == null) result = caseOclExpressionAS(loopExpAS);
				if (result == null) result = caseVisitable(loopExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NOT_EXP_AS: {
				NotExpAS notExpAS = (NotExpAS)theEObject;
				Object result = caseNotExpAS(notExpAS);
				if (result == null) result = caseLogicalExpAS(notExpAS);
				if (result == null) result = caseOclExpressionAS(notExpAS);
				if (result == null) result = caseVisitable(notExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OCL_EXPRESSION_AS: {
				OclExpressionAS oclExpressionAS = (OclExpressionAS)theEObject;
				Object result = caseOclExpressionAS(oclExpressionAS);
				if (result == null) result = caseVisitable(oclExpressionAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OCL_MESSAGE_ARG_AS: {
				OclMessageArgAS oclMessageArgAS = (OclMessageArgAS)theEObject;
				Object result = caseOclMessageArgAS(oclMessageArgAS);
				if (result == null) result = caseVisitable(oclMessageArgAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OCL_MESSAGE_EXP_AS: {
				OclMessageExpAS oclMessageExpAS = (OclMessageExpAS)theEObject;
				Object result = caseOclMessageExpAS(oclMessageExpAS);
				if (result == null) result = caseOclExpressionAS(oclMessageExpAS);
				if (result == null) result = caseVisitable(oclMessageExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OPERATION_CALL_EXP_AS: {
				OperationCallExpAS operationCallExpAS = (OperationCallExpAS)theEObject;
				Object result = caseOperationCallExpAS(operationCallExpAS);
				if (result == null) result = caseCallExpAS(operationCallExpAS);
				if (result == null) result = caseOclExpressionAS(operationCallExpAS);
				if (result == null) result = caseVisitable(operationCallExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OR_EXP_AS: {
				OrExpAS orExpAS = (OrExpAS)theEObject;
				Object result = caseOrExpAS(orExpAS);
				if (result == null) result = caseLogicalExpAS(orExpAS);
				if (result == null) result = caseOclExpressionAS(orExpAS);
				if (result == null) result = caseVisitable(orExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.PATH_NAME_EXP_AS: {
				PathNameExpAS pathNameExpAS = (PathNameExpAS)theEObject;
				Object result = casePathNameExpAS(pathNameExpAS);
				if (result == null) result = casePrimaryExpAS(pathNameExpAS);
				if (result == null) result = caseOclExpressionAS(pathNameExpAS);
				if (result == null) result = caseVisitable(pathNameExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.PRIMARY_EXP_AS: {
				PrimaryExpAS primaryExpAS = (PrimaryExpAS)theEObject;
				Object result = casePrimaryExpAS(primaryExpAS);
				if (result == null) result = caseOclExpressionAS(primaryExpAS);
				if (result == null) result = caseVisitable(primaryExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.PRIMITIVE_LITERAL_EXP_AS: {
				PrimitiveLiteralExpAS primitiveLiteralExpAS = (PrimitiveLiteralExpAS)theEObject;
				Object result = casePrimitiveLiteralExpAS(primitiveLiteralExpAS);
				if (result == null) result = caseLiteralExpAS(primitiveLiteralExpAS);
				if (result == null) result = casePrimaryExpAS(primitiveLiteralExpAS);
				if (result == null) result = caseOclExpressionAS(primitiveLiteralExpAS);
				if (result == null) result = caseVisitable(primitiveLiteralExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.REAL_LITERAL_EXP_AS: {
				RealLiteralExpAS realLiteralExpAS = (RealLiteralExpAS)theEObject;
				Object result = caseRealLiteralExpAS(realLiteralExpAS);
				if (result == null) result = casePrimitiveLiteralExpAS(realLiteralExpAS);
				if (result == null) result = caseLiteralExpAS(realLiteralExpAS);
				if (result == null) result = casePrimaryExpAS(realLiteralExpAS);
				if (result == null) result = caseOclExpressionAS(realLiteralExpAS);
				if (result == null) result = caseVisitable(realLiteralExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.SELECTION_EXP_AS: {
				SelectionExpAS selectionExpAS = (SelectionExpAS)theEObject;
				Object result = caseSelectionExpAS(selectionExpAS);
				if (result == null) result = caseOclExpressionAS(selectionExpAS);
				if (result == null) result = caseVisitable(selectionExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.STRING_LITERAL_EXP_AS: {
				StringLiteralExpAS stringLiteralExpAS = (StringLiteralExpAS)theEObject;
				Object result = caseStringLiteralExpAS(stringLiteralExpAS);
				if (result == null) result = casePrimitiveLiteralExpAS(stringLiteralExpAS);
				if (result == null) result = caseLiteralExpAS(stringLiteralExpAS);
				if (result == null) result = casePrimaryExpAS(stringLiteralExpAS);
				if (result == null) result = caseOclExpressionAS(stringLiteralExpAS);
				if (result == null) result = caseVisitable(stringLiteralExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.TUPLE_LITERAL_EXP_AS: {
				TupleLiteralExpAS tupleLiteralExpAS = (TupleLiteralExpAS)theEObject;
				Object result = caseTupleLiteralExpAS(tupleLiteralExpAS);
				if (result == null) result = caseLiteralExpAS(tupleLiteralExpAS);
				if (result == null) result = casePrimaryExpAS(tupleLiteralExpAS);
				if (result == null) result = caseOclExpressionAS(tupleLiteralExpAS);
				if (result == null) result = caseVisitable(tupleLiteralExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.XOR_EXP_AS: {
				XorExpAS xorExpAS = (XorExpAS)theEObject;
				Object result = caseXorExpAS(xorExpAS);
				if (result == null) result = caseLogicalExpAS(xorExpAS);
				if (result == null) result = caseOclExpressionAS(xorExpAS);
				if (result == null) result = caseVisitable(xorExpAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAndExpAS(AndExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arrow Selection Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arrow Selection Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArrowSelectionExpAS(ArrowSelectionExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Call Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Call Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAssociationCallExpAS(AssociationCallExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBooleanLiteralExpAS(BooleanLiteralExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCallExpAS(CallExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Item AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Item AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionItemAS(CollectionItemAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionLiteralExpAS(CollectionLiteralExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Part AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionLiteralPartAS(CollectionLiteralPartAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Range AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Range AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollectionRangeAS(CollectionRangeAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dot Selection Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dot Selection Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDotSelectionExpAS(DotSelectionExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnumLiteralExpAS(EnumLiteralExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIfExpAS(IfExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implies Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implies Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseImpliesExpAS(ImpliesExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIntegerLiteralExpAS(IntegerLiteralExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIterateExpAS(IterateExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIteratorExpAS(IteratorExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLetExpAS(LetExpAS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Logical Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLogicalExpAS(LogicalExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLoopExpAS(LoopExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNotExpAS(NotExpAS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Message Arg AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Message Arg AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclMessageArgAS(OclMessageArgAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Message Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Message Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOclMessageExpAS(OclMessageExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperationCallExpAS(OperationCallExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrExpAS(OrExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Name Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Name Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePathNameExpAS(PathNameExpAS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrimitiveLiteralExpAS(PrimitiveLiteralExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRealLiteralExpAS(RealLiteralExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSelectionExpAS(SelectionExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStringLiteralExpAS(StringLiteralExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTupleLiteralExpAS(TupleLiteralExpAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xor Exp AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xor Exp AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXorExpAS(XorExpAS object) {
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

} //ExpressionsSwitch
