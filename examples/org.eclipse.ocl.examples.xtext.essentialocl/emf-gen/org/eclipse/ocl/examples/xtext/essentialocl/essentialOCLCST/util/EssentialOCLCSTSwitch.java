/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EssentialOCLCSTSwitch.java,v 1.1 2010/04/13 06:32:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.*;

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
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage
 * @generated
 */
public class EssentialOCLCSTSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EssentialOCLCSTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSTSwitch() {
		if (modelPackage == null) {
			modelPackage = EssentialOCLCSTPackage.eINSTANCE;
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
			case EssentialOCLCSTPackage.ARROW_CALL_ARGUMENTS_CS: {
				ArrowCallArgumentsCS arrowCallArgumentsCS = (ArrowCallArgumentsCS)theEObject;
				T result = caseArrowCallArgumentsCS(arrowCallArgumentsCS);
				if (result == null) result = caseCallArgumentsCS(arrowCallArgumentsCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.BINARY_EXPRESSION_CS: {
				BinaryExpressionCS binaryExpressionCS = (BinaryExpressionCS)theEObject;
				T result = caseBinaryExpressionCS(binaryExpressionCS);
				if (result == null) result = caseOclExpressionCS(binaryExpressionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.BOOLEAN_LITERAL_EXP_CS: {
				BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS)theEObject;
				T result = caseBooleanLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(booleanLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.CALL_ARGUMENTS_CS: {
				CallArgumentsCS callArgumentsCS = (CallArgumentsCS)theEObject;
				T result = caseCallArgumentsCS(callArgumentsCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.CALL_EXP_CS: {
				CallExpCS callExpCS = (CallExpCS)theEObject;
				T result = caseCallExpCS(callExpCS);
				if (result == null) result = caseOclExpressionCS(callExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS: {
				CollectionLiteralExpCS collectionLiteralExpCS = (CollectionLiteralExpCS)theEObject;
				T result = caseCollectionLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(collectionLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS: {
				CollectionLiteralPartCS collectionLiteralPartCS = (CollectionLiteralPartCS)theEObject;
				T result = caseCollectionLiteralPartCS(collectionLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.COLLECTION_TYPE_CS: {
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)theEObject;
				T result = caseCollectionTypeCS(collectionTypeCS);
				if (result == null) result = caseTypeCS(collectionTypeCS);
				if (result == null) result = caseCollectionLiteralExpCS(collectionTypeCS);
				if (result == null) result = caseTypeLiteralExpCS(collectionTypeCS);
				if (result == null) result = caseLiteralExpCS(collectionTypeCS);
				if (result == null) result = caseOclExpressionCS(collectionTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS: {
				DotIndexArgumentsCS dotIndexArgumentsCS = (DotIndexArgumentsCS)theEObject;
				T result = caseDotIndexArgumentsCS(dotIndexArgumentsCS);
				if (result == null) result = caseCallArgumentsCS(dotIndexArgumentsCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.IF_EXP_CS: {
				IfExpCS ifExpCS = (IfExpCS)theEObject;
				T result = caseIfExpCS(ifExpCS);
				if (result == null) result = caseOclExpressionCS(ifExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.INTEGER_LITERAL_EXP_CS: {
				IntegerLiteralExpCS integerLiteralExpCS = (IntegerLiteralExpCS)theEObject;
				T result = caseIntegerLiteralExpCS(integerLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(integerLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(integerLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(integerLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.INVALID_LITERAL_EXP_CS: {
				InvalidLiteralExpCS invalidLiteralExpCS = (InvalidLiteralExpCS)theEObject;
				T result = caseInvalidLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(invalidLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.LET_EXP_CS: {
				LetExpCS letExpCS = (LetExpCS)theEObject;
				T result = caseLetExpCS(letExpCS);
				if (result == null) result = caseOclExpressionCS(letExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.LITERAL_EXP_CS: {
				LiteralExpCS literalExpCS = (LiteralExpCS)theEObject;
				T result = caseLiteralExpCS(literalExpCS);
				if (result == null) result = caseOclExpressionCS(literalExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NULL_LITERAL_EXP_CS: {
				NullLiteralExpCS nullLiteralExpCS = (NullLiteralExpCS)theEObject;
				T result = caseNullLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(nullLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.OCL_EXPRESSION_CS: {
				OclExpressionCS oclExpressionCS = (OclExpressionCS)theEObject;
				T result = caseOclExpressionCS(oclExpressionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.PATH_NAME_CS: {
				PathNameCS pathNameCS = (PathNameCS)theEObject;
				T result = casePathNameCS(pathNameCS);
				if (result == null) result = caseTypeCS(pathNameCS);
				if (result == null) result = caseTypeLiteralExpCS(pathNameCS);
				if (result == null) result = caseLiteralExpCS(pathNameCS);
				if (result == null) result = caseOclExpressionCS(pathNameCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.PRIMITIVE_LITERAL_EXP_CS: {
				PrimitiveLiteralExpCS primitiveLiteralExpCS = (PrimitiveLiteralExpCS)theEObject;
				T result = casePrimitiveLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(primitiveLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.REAL_LITERAL_EXP_CS: {
				RealLiteralExpCS realLiteralExpCS = (RealLiteralExpCS)theEObject;
				T result = caseRealLiteralExpCS(realLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(realLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(realLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(realLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.SIMPLE_NAME_CS: {
				SimpleNameCS simpleNameCS = (SimpleNameCS)theEObject;
				T result = caseSimpleNameCS(simpleNameCS);
				if (result == null) result = caseTypeCS(simpleNameCS);
				if (result == null) result = caseCollectionLiteralExpCS(simpleNameCS);
				if (result == null) result = caseTypeLiteralExpCS(simpleNameCS);
				if (result == null) result = caseVariableExpCS(simpleNameCS);
				if (result == null) result = caseLiteralExpCS(simpleNameCS);
				if (result == null) result = caseOclExpressionCS(simpleNameCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.STRING_LITERAL_EXP_CS: {
				StringLiteralExpCS stringLiteralExpCS = (StringLiteralExpCS)theEObject;
				T result = caseStringLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(stringLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TUPLE_LITERAL_EXP_CS: {
				TupleLiteralExpCS tupleLiteralExpCS = (TupleLiteralExpCS)theEObject;
				T result = caseTupleLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(tupleLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TUPLE_TYPE_CS: {
				TupleTypeCS tupleTypeCS = (TupleTypeCS)theEObject;
				T result = caseTupleTypeCS(tupleTypeCS);
				if (result == null) result = caseTypeCS(tupleTypeCS);
				if (result == null) result = caseTypeLiteralExpCS(tupleTypeCS);
				if (result == null) result = caseLiteralExpCS(tupleTypeCS);
				if (result == null) result = caseOclExpressionCS(tupleTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TYPE_CS: {
				TypeCS typeCS = (TypeCS)theEObject;
				T result = caseTypeCS(typeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TYPE_LITERAL_EXP_CS: {
				TypeLiteralExpCS typeLiteralExpCS = (TypeLiteralExpCS)theEObject;
				T result = caseTypeLiteralExpCS(typeLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(typeLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(typeLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.UNARY_EXPRESSION_CS: {
				UnaryExpressionCS unaryExpressionCS = (UnaryExpressionCS)theEObject;
				T result = caseUnaryExpressionCS(unaryExpressionCS);
				if (result == null) result = caseOclExpressionCS(unaryExpressionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS: {
				UnlimitedNaturalLiteralExpCS unlimitedNaturalLiteralExpCS = (UnlimitedNaturalLiteralExpCS)theEObject;
				T result = caseUnlimitedNaturalLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseOclExpressionCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.VARIABLE_CS: {
				VariableCS variableCS = (VariableCS)theEObject;
				T result = caseVariableCS(variableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.VARIABLE_EXP_CS: {
				VariableExpCS variableExpCS = (VariableExpCS)theEObject;
				T result = caseVariableExpCS(variableExpCS);
				if (result == null) result = caseOclExpressionCS(variableExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Expression CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclExpressionCS(OclExpressionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Name CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleNameCS(SimpleNameCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathNameCS(PathNameCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeCS(TypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionTypeCS(CollectionTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleTypeCS(TupleTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableCS(VariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExpCS(LiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionLiteralExpCS(CollectionLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionLiteralPartCS(CollectionLiteralPartCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleLiteralExpCS(TupleLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteralExpCS(IntegerLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealLiteralExpCS(RealLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralExpCS(StringLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteralExpCS(BooleanLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvalidLiteralExpCS(InvalidLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullLiteralExpCS(NullLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeLiteralExpCS(TypeLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Arguments CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Arguments CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallArgumentsCS(CallArgumentsCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableExpCS(VariableExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfExpCS(IfExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetExpCS(LetExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Expression CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryExpressionCS(BinaryExpressionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpressionCS(UnaryExpressionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExpCS(CallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arrow Call Arguments CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arrow Call Arguments CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrowCallArgumentsCS(ArrowCallArgumentsCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dot Index Arguments CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dot Index Arguments CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDotIndexArgumentsCS(DotIndexArgumentsCS object) {
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

} //EssentialOCLCSTSwitch
