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
 * $Id: EssentialOCLCSTSwitch.java,v 1.5 2010/05/21 20:12:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
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
			case EssentialOCLCSTPackage.BOOLEAN_LITERAL_EXP_CS: {
				BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS)theEObject;
				T result = caseBooleanLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseExpCS(booleanLiteralExpCS);
				if (result == null) result = caseElementCS(booleanLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS: {
				CollectionLiteralExpCS collectionLiteralExpCS = (CollectionLiteralExpCS)theEObject;
				T result = caseCollectionLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseExpCS(collectionLiteralExpCS);
				if (result == null) result = caseElementCS(collectionLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS: {
				CollectionLiteralPartCS collectionLiteralPartCS = (CollectionLiteralPartCS)theEObject;
				T result = caseCollectionLiteralPartCS(collectionLiteralPartCS);
				if (result == null) result = caseElementCS(collectionLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.COLLECTION_TYPE_CS: {
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)theEObject;
				T result = caseCollectionTypeCS(collectionTypeCS);
				if (result == null) result = caseNamedElementCS(collectionTypeCS);
				if (result == null) result = caseTypeExpCS(collectionTypeCS);
				if (result == null) result = caseModelElementCS(collectionTypeCS);
				if (result == null) result = caseLiteralExpCS(collectionTypeCS);
				if (result == null) result = caseTypeCS(collectionTypeCS);
				if (result == null) result = caseExpCS(collectionTypeCS);
				if (result == null) result = caseElementCS(collectionTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.EXP_CS: {
				ExpCS expCS = (ExpCS)theEObject;
				T result = caseExpCS(expCS);
				if (result == null) result = caseElementCS(expCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.IF_EXP_CS: {
				IfExpCS ifExpCS = (IfExpCS)theEObject;
				T result = caseIfExpCS(ifExpCS);
				if (result == null) result = caseExpCS(ifExpCS);
				if (result == null) result = caseElementCS(ifExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.INFIX_EXP_CS: {
				InfixExpCS infixExpCS = (InfixExpCS)theEObject;
				T result = caseInfixExpCS(infixExpCS);
				if (result == null) result = caseOperatorExpCS(infixExpCS);
				if (result == null) result = caseSubExpCS(infixExpCS);
				if (result == null) result = caseExpCS(infixExpCS);
				if (result == null) result = caseElementCS(infixExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.INVALID_LITERAL_EXP_CS: {
				InvalidLiteralExpCS invalidLiteralExpCS = (InvalidLiteralExpCS)theEObject;
				T result = caseInvalidLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseExpCS(invalidLiteralExpCS);
				if (result == null) result = caseElementCS(invalidLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.LET_EXP_CS: {
				LetExpCS letExpCS = (LetExpCS)theEObject;
				T result = caseLetExpCS(letExpCS);
				if (result == null) result = caseExpCS(letExpCS);
				if (result == null) result = caseElementCS(letExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.LITERAL_EXP_CS: {
				LiteralExpCS literalExpCS = (LiteralExpCS)theEObject;
				T result = caseLiteralExpCS(literalExpCS);
				if (result == null) result = caseExpCS(literalExpCS);
				if (result == null) result = caseElementCS(literalExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NAME_EXP_CS: {
				NameExpCS nameExpCS = (NameExpCS)theEObject;
				T result = caseNameExpCS(nameExpCS);
				if (result == null) result = caseTypeExpCS(nameExpCS);
				if (result == null) result = caseLiteralExpCS(nameExpCS);
				if (result == null) result = caseTypeCS(nameExpCS);
				if (result == null) result = caseExpCS(nameExpCS);
				if (result == null) result = caseElementCS(nameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NAMED_EXP_CS: {
				NamedExpCS namedExpCS = (NamedExpCS)theEObject;
				T result = caseNamedExpCS(namedExpCS);
				if (result == null) result = caseExpCS(namedExpCS);
				if (result == null) result = caseElementCS(namedExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NESTED_EXP_CS: {
				NestedExpCS nestedExpCS = (NestedExpCS)theEObject;
				T result = caseNestedExpCS(nestedExpCS);
				if (result == null) result = caseSubExpCS(nestedExpCS);
				if (result == null) result = caseExpCS(nestedExpCS);
				if (result == null) result = caseElementCS(nestedExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NULL_LITERAL_EXP_CS: {
				NullLiteralExpCS nullLiteralExpCS = (NullLiteralExpCS)theEObject;
				T result = caseNullLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseExpCS(nullLiteralExpCS);
				if (result == null) result = caseElementCS(nullLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NUMBER_LITERAL_EXP_CS: {
				NumberLiteralExpCS numberLiteralExpCS = (NumberLiteralExpCS)theEObject;
				T result = caseNumberLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = caseExpCS(numberLiteralExpCS);
				if (result == null) result = caseElementCS(numberLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.OPERATOR_EXP_CS: {
				OperatorExpCS operatorExpCS = (OperatorExpCS)theEObject;
				T result = caseOperatorExpCS(operatorExpCS);
				if (result == null) result = caseSubExpCS(operatorExpCS);
				if (result == null) result = caseExpCS(operatorExpCS);
				if (result == null) result = caseElementCS(operatorExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS: {
				PathNameExpCS pathNameExpCS = (PathNameExpCS)theEObject;
				T result = casePathNameExpCS(pathNameExpCS);
				if (result == null) result = caseNameExpCS(pathNameExpCS);
				if (result == null) result = caseQualifiedRefCS(pathNameExpCS);
				if (result == null) result = caseTypeExpCS(pathNameExpCS);
				if (result == null) result = caseModelElementCS(pathNameExpCS);
				if (result == null) result = caseLiteralExpCS(pathNameExpCS);
				if (result == null) result = caseTypeCS(pathNameExpCS);
				if (result == null) result = caseExpCS(pathNameExpCS);
				if (result == null) result = caseElementCS(pathNameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.PRE_EXP_CS: {
				PreExpCS preExpCS = (PreExpCS)theEObject;
				T result = casePreExpCS(preExpCS);
				if (result == null) result = caseNamedExpCS(preExpCS);
				if (result == null) result = caseExpCS(preExpCS);
				if (result == null) result = caseElementCS(preExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.PREFIX_EXP_CS: {
				PrefixExpCS prefixExpCS = (PrefixExpCS)theEObject;
				T result = casePrefixExpCS(prefixExpCS);
				if (result == null) result = caseSubExpCS(prefixExpCS);
				if (result == null) result = caseExpCS(prefixExpCS);
				if (result == null) result = caseElementCS(prefixExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.PRIMITIVE_LITERAL_EXP_CS: {
				PrimitiveLiteralExpCS primitiveLiteralExpCS = (PrimitiveLiteralExpCS)theEObject;
				T result = casePrimitiveLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseElementCS(primitiveLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.PRIMITIVE_TYPE_CS: {
				PrimitiveTypeCS primitiveTypeCS = (PrimitiveTypeCS)theEObject;
				T result = casePrimitiveTypeCS(primitiveTypeCS);
				if (result == null) result = caseNamedElementCS(primitiveTypeCS);
				if (result == null) result = caseTypeExpCS(primitiveTypeCS);
				if (result == null) result = caseModelElementCS(primitiveTypeCS);
				if (result == null) result = caseLiteralExpCS(primitiveTypeCS);
				if (result == null) result = caseTypeCS(primitiveTypeCS);
				if (result == null) result = caseExpCS(primitiveTypeCS);
				if (result == null) result = caseElementCS(primitiveTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS: {
				RoundBracketExpCS roundBracketExpCS = (RoundBracketExpCS)theEObject;
				T result = caseRoundBracketExpCS(roundBracketExpCS);
				if (result == null) result = caseNamedExpCS(roundBracketExpCS);
				if (result == null) result = caseExpCS(roundBracketExpCS);
				if (result == null) result = caseElementCS(roundBracketExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.SELF_EXP_CS: {
				SelfExpCS selfExpCS = (SelfExpCS)theEObject;
				T result = caseSelfExpCS(selfExpCS);
				if (result == null) result = caseExpCS(selfExpCS);
				if (result == null) result = caseElementCS(selfExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.SIMPLE_NAME_EXP_CS: {
				SimpleNameExpCS simpleNameExpCS = (SimpleNameExpCS)theEObject;
				T result = caseSimpleNameExpCS(simpleNameExpCS);
				if (result == null) result = caseNameExpCS(simpleNameExpCS);
				if (result == null) result = caseTypeExpCS(simpleNameExpCS);
				if (result == null) result = caseLiteralExpCS(simpleNameExpCS);
				if (result == null) result = caseTypeCS(simpleNameExpCS);
				if (result == null) result = caseExpCS(simpleNameExpCS);
				if (result == null) result = caseElementCS(simpleNameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS: {
				SquareBracketExpCS squareBracketExpCS = (SquareBracketExpCS)theEObject;
				T result = caseSquareBracketExpCS(squareBracketExpCS);
				if (result == null) result = caseNamedExpCS(squareBracketExpCS);
				if (result == null) result = caseExpCS(squareBracketExpCS);
				if (result == null) result = caseElementCS(squareBracketExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.SUB_EXP_CS: {
				SubExpCS subExpCS = (SubExpCS)theEObject;
				T result = caseSubExpCS(subExpCS);
				if (result == null) result = caseExpCS(subExpCS);
				if (result == null) result = caseElementCS(subExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.STRING_LITERAL_EXP_CS: {
				StringLiteralExpCS stringLiteralExpCS = (StringLiteralExpCS)theEObject;
				T result = caseStringLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseExpCS(stringLiteralExpCS);
				if (result == null) result = caseElementCS(stringLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TUPLE_LITERAL_EXP_CS: {
				TupleLiteralExpCS tupleLiteralExpCS = (TupleLiteralExpCS)theEObject;
				T result = caseTupleLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseClassifierCS(tupleLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseNamedElementCS(tupleLiteralExpCS);
				if (result == null) result = caseTypeCS(tupleLiteralExpCS);
				if (result == null) result = caseExpCS(tupleLiteralExpCS);
				if (result == null) result = caseModelElementCS(tupleLiteralExpCS);
				if (result == null) result = caseElementCS(tupleLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TUPLE_TYPE_CS: {
				TupleTypeCS tupleTypeCS = (TupleTypeCS)theEObject;
				T result = caseTupleTypeCS(tupleTypeCS);
				if (result == null) result = caseClassifierCS(tupleTypeCS);
				if (result == null) result = caseTypeExpCS(tupleTypeCS);
				if (result == null) result = caseNamedElementCS(tupleTypeCS);
				if (result == null) result = caseTypeCS(tupleTypeCS);
				if (result == null) result = caseLiteralExpCS(tupleTypeCS);
				if (result == null) result = caseModelElementCS(tupleTypeCS);
				if (result == null) result = caseExpCS(tupleTypeCS);
				if (result == null) result = caseElementCS(tupleTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TYPE_EXP_CS: {
				TypeExpCS typeExpCS = (TypeExpCS)theEObject;
				T result = caseTypeExpCS(typeExpCS);
				if (result == null) result = caseLiteralExpCS(typeExpCS);
				if (result == null) result = caseTypeCS(typeExpCS);
				if (result == null) result = caseExpCS(typeExpCS);
				if (result == null) result = caseElementCS(typeExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.VARIABLE_CS: {
				VariableCS variableCS = (VariableCS)theEObject;
				T result = caseVariableCS(variableCS);
				if (result == null) result = caseNamedElementCS(variableCS);
				if (result == null) result = caseModelElementCS(variableCS);
				if (result == null) result = caseElementCS(variableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathNameExpCS(PathNameExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pre Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pre Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreExpCS(PreExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prefix Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prefix Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrefixExpCS(PrefixExpCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <E extends ElementCS> T caseQualifiedRefCS(QualifiedRefCS<E> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierCS(ClassifierCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCS(ElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpCS(ExpCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Type Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeExpCS(TypeExpCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementCS(ModelElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameExpCS(NameExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedExpCS(NamedExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElementCS(NamedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedExpCS(NestedExpCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveTypeCS(PrimitiveTypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Round Bracket Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Round Bracket Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoundBracketExpCS(RoundBracketExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Self Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelfExpCS(SelfExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleNameExpCS(SimpleNameExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Square Bracket Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Square Bracket Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSquareBracketExpCS(SquareBracketExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubExpCS(SubExpCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Number Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberLiteralExpCS(NumberLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorExpCS(OperatorExpCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Infix Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infix Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfixExpCS(InfixExpCS object) {
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
