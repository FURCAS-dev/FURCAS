/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EssentialOCLCSTSwitch.java,v 1.6 2011/01/24 21:31:48 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.util.Nameable;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.*;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

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
public class EssentialOCLCSTSwitch<T>
{
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
  public EssentialOCLCSTSwitch()
  {
		if (modelPackage == null)
		{
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
  public T doSwitch(EObject theEObject)
  {
		return doSwitch(theEObject.eClass(), theEObject);
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
		if (theEClass.eContainer() == modelPackage)
		{
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else
		{
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
  protected T doSwitch(int classifierID, EObject theEObject)
  {
		switch (classifierID)
		{
			case EssentialOCLCSTPackage.BINARY_OPERATOR_CS:
			{
				BinaryOperatorCS binaryOperatorCS = (BinaryOperatorCS)theEObject;
				T result = caseBinaryOperatorCS(binaryOperatorCS);
				if (result == null) result = caseOperatorCS(binaryOperatorCS);
				if (result == null) result = caseNamedElementCS(binaryOperatorCS);
				if (result == null) result = caseExpCS(binaryOperatorCS);
				if (result == null) result = caseMonikeredElementCS(binaryOperatorCS);
				if (result == null) result = caseNameable(binaryOperatorCS);
				if (result == null) result = caseModelElementCS(binaryOperatorCS);
				if (result == null) result = caseElementCS(binaryOperatorCS);
				if (result == null) result = casePivotable(binaryOperatorCS);
				if (result == null) result = caseVisitableCS(binaryOperatorCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.BOOLEAN_LITERAL_EXP_CS:
			{
				BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS)theEObject;
				T result = caseBooleanLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseExpCS(booleanLiteralExpCS);
				if (result == null) result = caseMonikeredElementCS(booleanLiteralExpCS);
				if (result == null) result = caseModelElementCS(booleanLiteralExpCS);
				if (result == null) result = caseElementCS(booleanLiteralExpCS);
				if (result == null) result = casePivotable(booleanLiteralExpCS);
				if (result == null) result = caseVisitableCS(booleanLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS:
			{
				CollectionLiteralExpCS collectionLiteralExpCS = (CollectionLiteralExpCS)theEObject;
				T result = caseCollectionLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseExpCS(collectionLiteralExpCS);
				if (result == null) result = caseMonikeredElementCS(collectionLiteralExpCS);
				if (result == null) result = caseModelElementCS(collectionLiteralExpCS);
				if (result == null) result = caseElementCS(collectionLiteralExpCS);
				if (result == null) result = casePivotable(collectionLiteralExpCS);
				if (result == null) result = caseVisitableCS(collectionLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS:
			{
				CollectionLiteralPartCS collectionLiteralPartCS = (CollectionLiteralPartCS)theEObject;
				T result = caseCollectionLiteralPartCS(collectionLiteralPartCS);
				if (result == null) result = caseMonikeredElementCS(collectionLiteralPartCS);
				if (result == null) result = caseModelElementCS(collectionLiteralPartCS);
				if (result == null) result = caseElementCS(collectionLiteralPartCS);
				if (result == null) result = casePivotable(collectionLiteralPartCS);
				if (result == null) result = caseVisitableCS(collectionLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.COLLECTION_TYPE_CS:
			{
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)theEObject;
				T result = caseCollectionTypeCS(collectionTypeCS);
				if (result == null) result = caseNamedElementCS(collectionTypeCS);
				if (result == null) result = caseTypedRefCS(collectionTypeCS);
				if (result == null) result = caseNameable(collectionTypeCS);
				if (result == null) result = caseTypeRefCS(collectionTypeCS);
				if (result == null) result = caseModelElementCS(collectionTypeCS);
				if (result == null) result = caseParameterableElementCS(collectionTypeCS);
				if (result == null) result = caseMonikeredElementCS(collectionTypeCS);
				if (result == null) result = caseElementCS(collectionTypeCS);
				if (result == null) result = casePivotable(collectionTypeCS);
				if (result == null) result = caseVisitableCS(collectionTypeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.CONTEXT_CS:
			{
				ContextCS contextCS = (ContextCS)theEObject;
				T result = caseContextCS(contextCS);
				if (result == null) result = caseNamedElementCS(contextCS);
				if (result == null) result = caseRootCS(contextCS);
				if (result == null) result = caseMonikeredElementCS(contextCS);
				if (result == null) result = caseNameable(contextCS);
				if (result == null) result = caseModelElementCS(contextCS);
				if (result == null) result = caseElementCS(contextCS);
				if (result == null) result = casePivotable(contextCS);
				if (result == null) result = caseVisitableCS(contextCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.DECORATED_NAMED_EXP_CS:
			{
				DecoratedNamedExpCS decoratedNamedExpCS = (DecoratedNamedExpCS)theEObject;
				T result = caseDecoratedNamedExpCS(decoratedNamedExpCS);
				if (result == null) result = caseNamedExpCS(decoratedNamedExpCS);
				if (result == null) result = caseExpCS(decoratedNamedExpCS);
				if (result == null) result = caseMonikeredElementCS(decoratedNamedExpCS);
				if (result == null) result = caseModelElementCS(decoratedNamedExpCS);
				if (result == null) result = caseElementCS(decoratedNamedExpCS);
				if (result == null) result = casePivotable(decoratedNamedExpCS);
				if (result == null) result = caseVisitableCS(decoratedNamedExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.EXP_CS:
			{
				ExpCS expCS = (ExpCS)theEObject;
				T result = caseExpCS(expCS);
				if (result == null) result = caseMonikeredElementCS(expCS);
				if (result == null) result = caseModelElementCS(expCS);
				if (result == null) result = caseElementCS(expCS);
				if (result == null) result = casePivotable(expCS);
				if (result == null) result = caseVisitableCS(expCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.EXP_CONSTRAINT_CS:
			{
				ExpConstraintCS expConstraintCS = (ExpConstraintCS)theEObject;
				T result = caseExpConstraintCS(expConstraintCS);
				if (result == null) result = caseConstraintCS(expConstraintCS);
				if (result == null) result = caseNamedElementCS(expConstraintCS);
				if (result == null) result = caseMonikeredElementCS(expConstraintCS);
				if (result == null) result = caseNameable(expConstraintCS);
				if (result == null) result = caseModelElementCS(expConstraintCS);
				if (result == null) result = caseElementCS(expConstraintCS);
				if (result == null) result = casePivotable(expConstraintCS);
				if (result == null) result = caseVisitableCS(expConstraintCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.IF_EXP_CS:
			{
				IfExpCS ifExpCS = (IfExpCS)theEObject;
				T result = caseIfExpCS(ifExpCS);
				if (result == null) result = caseExpCS(ifExpCS);
				if (result == null) result = caseMonikeredElementCS(ifExpCS);
				if (result == null) result = caseModelElementCS(ifExpCS);
				if (result == null) result = caseElementCS(ifExpCS);
				if (result == null) result = casePivotable(ifExpCS);
				if (result == null) result = caseVisitableCS(ifExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.INDEX_EXP_CS:
			{
				IndexExpCS indexExpCS = (IndexExpCS)theEObject;
				T result = caseIndexExpCS(indexExpCS);
				if (result == null) result = caseDecoratedNamedExpCS(indexExpCS);
				if (result == null) result = caseNamedExpCS(indexExpCS);
				if (result == null) result = caseExpCS(indexExpCS);
				if (result == null) result = caseMonikeredElementCS(indexExpCS);
				if (result == null) result = caseModelElementCS(indexExpCS);
				if (result == null) result = caseElementCS(indexExpCS);
				if (result == null) result = casePivotable(indexExpCS);
				if (result == null) result = caseVisitableCS(indexExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.INFIX_EXP_CS:
			{
				InfixExpCS infixExpCS = (InfixExpCS)theEObject;
				T result = caseInfixExpCS(infixExpCS);
				if (result == null) result = caseExpCS(infixExpCS);
				if (result == null) result = caseMonikeredElementCS(infixExpCS);
				if (result == null) result = caseModelElementCS(infixExpCS);
				if (result == null) result = caseElementCS(infixExpCS);
				if (result == null) result = casePivotable(infixExpCS);
				if (result == null) result = caseVisitableCS(infixExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.INVALID_LITERAL_EXP_CS:
			{
				InvalidLiteralExpCS invalidLiteralExpCS = (InvalidLiteralExpCS)theEObject;
				T result = caseInvalidLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(invalidLiteralExpCS);
				if (result == null) result = caseExpCS(invalidLiteralExpCS);
				if (result == null) result = caseMonikeredElementCS(invalidLiteralExpCS);
				if (result == null) result = caseModelElementCS(invalidLiteralExpCS);
				if (result == null) result = caseElementCS(invalidLiteralExpCS);
				if (result == null) result = casePivotable(invalidLiteralExpCS);
				if (result == null) result = caseVisitableCS(invalidLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.LET_EXP_CS:
			{
				LetExpCS letExpCS = (LetExpCS)theEObject;
				T result = caseLetExpCS(letExpCS);
				if (result == null) result = caseExpCS(letExpCS);
				if (result == null) result = caseMonikeredElementCS(letExpCS);
				if (result == null) result = caseModelElementCS(letExpCS);
				if (result == null) result = caseElementCS(letExpCS);
				if (result == null) result = casePivotable(letExpCS);
				if (result == null) result = caseVisitableCS(letExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.LET_VARIABLE_CS:
			{
				LetVariableCS letVariableCS = (LetVariableCS)theEObject;
				T result = caseLetVariableCS(letVariableCS);
				if (result == null) result = caseVariableCS(letVariableCS);
				if (result == null) result = caseExpCS(letVariableCS);
				if (result == null) result = caseNamedElementCS(letVariableCS);
				if (result == null) result = caseMonikeredElementCS(letVariableCS);
				if (result == null) result = caseNameable(letVariableCS);
				if (result == null) result = caseModelElementCS(letVariableCS);
				if (result == null) result = caseElementCS(letVariableCS);
				if (result == null) result = casePivotable(letVariableCS);
				if (result == null) result = caseVisitableCS(letVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.LITERAL_EXP_CS:
			{
				LiteralExpCS literalExpCS = (LiteralExpCS)theEObject;
				T result = caseLiteralExpCS(literalExpCS);
				if (result == null) result = caseExpCS(literalExpCS);
				if (result == null) result = caseMonikeredElementCS(literalExpCS);
				if (result == null) result = caseModelElementCS(literalExpCS);
				if (result == null) result = caseElementCS(literalExpCS);
				if (result == null) result = casePivotable(literalExpCS);
				if (result == null) result = caseVisitableCS(literalExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NAME_EXP_CS:
			{
				NameExpCS nameExpCS = (NameExpCS)theEObject;
				T result = caseNameExpCS(nameExpCS);
				if (result == null) result = caseSimpleNamedExpCS(nameExpCS);
				if (result == null) result = caseNamedExpCS(nameExpCS);
				if (result == null) result = caseExpCS(nameExpCS);
				if (result == null) result = caseMonikeredElementCS(nameExpCS);
				if (result == null) result = caseModelElementCS(nameExpCS);
				if (result == null) result = caseElementCS(nameExpCS);
				if (result == null) result = casePivotable(nameExpCS);
				if (result == null) result = caseVisitableCS(nameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NAMED_EXP_CS:
			{
				NamedExpCS namedExpCS = (NamedExpCS)theEObject;
				T result = caseNamedExpCS(namedExpCS);
				if (result == null) result = caseExpCS(namedExpCS);
				if (result == null) result = caseMonikeredElementCS(namedExpCS);
				if (result == null) result = caseModelElementCS(namedExpCS);
				if (result == null) result = caseElementCS(namedExpCS);
				if (result == null) result = casePivotable(namedExpCS);
				if (result == null) result = caseVisitableCS(namedExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NAVIGATING_ARG_CS:
			{
				NavigatingArgCS navigatingArgCS = (NavigatingArgCS)theEObject;
				T result = caseNavigatingArgCS(navigatingArgCS);
				if (result == null) result = caseModelElementCS(navigatingArgCS);
				if (result == null) result = caseElementCS(navigatingArgCS);
				if (result == null) result = casePivotable(navigatingArgCS);
				if (result == null) result = caseVisitableCS(navigatingArgCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NAVIGATING_EXP_CS:
			{
				NavigatingExpCS navigatingExpCS = (NavigatingExpCS)theEObject;
				T result = caseNavigatingExpCS(navigatingExpCS);
				if (result == null) result = caseDecoratedNamedExpCS(navigatingExpCS);
				if (result == null) result = caseNamedExpCS(navigatingExpCS);
				if (result == null) result = caseExpCS(navigatingExpCS);
				if (result == null) result = caseMonikeredElementCS(navigatingExpCS);
				if (result == null) result = caseModelElementCS(navigatingExpCS);
				if (result == null) result = caseElementCS(navigatingExpCS);
				if (result == null) result = casePivotable(navigatingExpCS);
				if (result == null) result = caseVisitableCS(navigatingExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NAVIGATION_OPERATOR_CS:
			{
				NavigationOperatorCS navigationOperatorCS = (NavigationOperatorCS)theEObject;
				T result = caseNavigationOperatorCS(navigationOperatorCS);
				if (result == null) result = caseBinaryOperatorCS(navigationOperatorCS);
				if (result == null) result = caseOperatorCS(navigationOperatorCS);
				if (result == null) result = caseNamedElementCS(navigationOperatorCS);
				if (result == null) result = caseExpCS(navigationOperatorCS);
				if (result == null) result = caseMonikeredElementCS(navigationOperatorCS);
				if (result == null) result = caseNameable(navigationOperatorCS);
				if (result == null) result = caseModelElementCS(navigationOperatorCS);
				if (result == null) result = caseElementCS(navigationOperatorCS);
				if (result == null) result = casePivotable(navigationOperatorCS);
				if (result == null) result = caseVisitableCS(navigationOperatorCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NESTED_EXP_CS:
			{
				NestedExpCS nestedExpCS = (NestedExpCS)theEObject;
				T result = caseNestedExpCS(nestedExpCS);
				if (result == null) result = caseExpCS(nestedExpCS);
				if (result == null) result = caseMonikeredElementCS(nestedExpCS);
				if (result == null) result = caseModelElementCS(nestedExpCS);
				if (result == null) result = caseElementCS(nestedExpCS);
				if (result == null) result = casePivotable(nestedExpCS);
				if (result == null) result = caseVisitableCS(nestedExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NULL_LITERAL_EXP_CS:
			{
				NullLiteralExpCS nullLiteralExpCS = (NullLiteralExpCS)theEObject;
				T result = caseNullLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseExpCS(nullLiteralExpCS);
				if (result == null) result = caseMonikeredElementCS(nullLiteralExpCS);
				if (result == null) result = caseModelElementCS(nullLiteralExpCS);
				if (result == null) result = caseElementCS(nullLiteralExpCS);
				if (result == null) result = casePivotable(nullLiteralExpCS);
				if (result == null) result = caseVisitableCS(nullLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.NUMBER_LITERAL_EXP_CS:
			{
				NumberLiteralExpCS numberLiteralExpCS = (NumberLiteralExpCS)theEObject;
				T result = caseNumberLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(numberLiteralExpCS);
				if (result == null) result = caseExpCS(numberLiteralExpCS);
				if (result == null) result = caseMonikeredElementCS(numberLiteralExpCS);
				if (result == null) result = caseModelElementCS(numberLiteralExpCS);
				if (result == null) result = caseElementCS(numberLiteralExpCS);
				if (result == null) result = casePivotable(numberLiteralExpCS);
				if (result == null) result = caseVisitableCS(numberLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.OPERATOR_CS:
			{
				OperatorCS operatorCS = (OperatorCS)theEObject;
				T result = caseOperatorCS(operatorCS);
				if (result == null) result = caseNamedElementCS(operatorCS);
				if (result == null) result = caseExpCS(operatorCS);
				if (result == null) result = caseMonikeredElementCS(operatorCS);
				if (result == null) result = caseNameable(operatorCS);
				if (result == null) result = caseModelElementCS(operatorCS);
				if (result == null) result = caseElementCS(operatorCS);
				if (result == null) result = casePivotable(operatorCS);
				if (result == null) result = caseVisitableCS(operatorCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.PREFIX_EXP_CS:
			{
				PrefixExpCS prefixExpCS = (PrefixExpCS)theEObject;
				T result = casePrefixExpCS(prefixExpCS);
				if (result == null) result = caseExpCS(prefixExpCS);
				if (result == null) result = caseMonikeredElementCS(prefixExpCS);
				if (result == null) result = caseModelElementCS(prefixExpCS);
				if (result == null) result = caseElementCS(prefixExpCS);
				if (result == null) result = casePivotable(prefixExpCS);
				if (result == null) result = caseVisitableCS(prefixExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.PRIMITIVE_LITERAL_EXP_CS:
			{
				PrimitiveLiteralExpCS primitiveLiteralExpCS = (PrimitiveLiteralExpCS)theEObject;
				T result = casePrimitiveLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseExpCS(primitiveLiteralExpCS);
				if (result == null) result = caseMonikeredElementCS(primitiveLiteralExpCS);
				if (result == null) result = caseModelElementCS(primitiveLiteralExpCS);
				if (result == null) result = caseElementCS(primitiveLiteralExpCS);
				if (result == null) result = casePivotable(primitiveLiteralExpCS);
				if (result == null) result = caseVisitableCS(primitiveLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.SELF_EXP_CS:
			{
				SelfExpCS selfExpCS = (SelfExpCS)theEObject;
				T result = caseSelfExpCS(selfExpCS);
				if (result == null) result = caseExpCS(selfExpCS);
				if (result == null) result = caseMonikeredElementCS(selfExpCS);
				if (result == null) result = caseModelElementCS(selfExpCS);
				if (result == null) result = caseElementCS(selfExpCS);
				if (result == null) result = casePivotable(selfExpCS);
				if (result == null) result = caseVisitableCS(selfExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.SIMPLE_NAMED_EXP_CS:
			{
				SimpleNamedExpCS simpleNamedExpCS = (SimpleNamedExpCS)theEObject;
				T result = caseSimpleNamedExpCS(simpleNamedExpCS);
				if (result == null) result = caseNamedExpCS(simpleNamedExpCS);
				if (result == null) result = caseExpCS(simpleNamedExpCS);
				if (result == null) result = caseMonikeredElementCS(simpleNamedExpCS);
				if (result == null) result = caseModelElementCS(simpleNamedExpCS);
				if (result == null) result = caseElementCS(simpleNamedExpCS);
				if (result == null) result = casePivotable(simpleNamedExpCS);
				if (result == null) result = caseVisitableCS(simpleNamedExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.STRING_LITERAL_EXP_CS:
			{
				StringLiteralExpCS stringLiteralExpCS = (StringLiteralExpCS)theEObject;
				T result = caseStringLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(stringLiteralExpCS);
				if (result == null) result = caseExpCS(stringLiteralExpCS);
				if (result == null) result = caseMonikeredElementCS(stringLiteralExpCS);
				if (result == null) result = caseModelElementCS(stringLiteralExpCS);
				if (result == null) result = caseElementCS(stringLiteralExpCS);
				if (result == null) result = casePivotable(stringLiteralExpCS);
				if (result == null) result = caseVisitableCS(stringLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TUPLE_LITERAL_EXP_CS:
			{
				TupleLiteralExpCS tupleLiteralExpCS = (TupleLiteralExpCS)theEObject;
				T result = caseTupleLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(tupleLiteralExpCS);
				if (result == null) result = caseExpCS(tupleLiteralExpCS);
				if (result == null) result = caseMonikeredElementCS(tupleLiteralExpCS);
				if (result == null) result = caseModelElementCS(tupleLiteralExpCS);
				if (result == null) result = caseElementCS(tupleLiteralExpCS);
				if (result == null) result = casePivotable(tupleLiteralExpCS);
				if (result == null) result = caseVisitableCS(tupleLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TUPLE_LITERAL_PART_CS:
			{
				TupleLiteralPartCS tupleLiteralPartCS = (TupleLiteralPartCS)theEObject;
				T result = caseTupleLiteralPartCS(tupleLiteralPartCS);
				if (result == null) result = caseVariableCS(tupleLiteralPartCS);
				if (result == null) result = caseNamedElementCS(tupleLiteralPartCS);
				if (result == null) result = caseMonikeredElementCS(tupleLiteralPartCS);
				if (result == null) result = caseNameable(tupleLiteralPartCS);
				if (result == null) result = caseModelElementCS(tupleLiteralPartCS);
				if (result == null) result = caseElementCS(tupleLiteralPartCS);
				if (result == null) result = casePivotable(tupleLiteralPartCS);
				if (result == null) result = caseVisitableCS(tupleLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TYPE_LITERAL_EXP_CS:
			{
				TypeLiteralExpCS typeLiteralExpCS = (TypeLiteralExpCS)theEObject;
				T result = caseTypeLiteralExpCS(typeLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(typeLiteralExpCS);
				if (result == null) result = caseExpCS(typeLiteralExpCS);
				if (result == null) result = caseMonikeredElementCS(typeLiteralExpCS);
				if (result == null) result = caseModelElementCS(typeLiteralExpCS);
				if (result == null) result = caseElementCS(typeLiteralExpCS);
				if (result == null) result = casePivotable(typeLiteralExpCS);
				if (result == null) result = caseVisitableCS(typeLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.TYPE_NAME_EXP_CS:
			{
				TypeNameExpCS typeNameExpCS = (TypeNameExpCS)theEObject;
				T result = caseTypeNameExpCS(typeNameExpCS);
				if (result == null) result = caseTypedRefCS(typeNameExpCS);
				if (result == null) result = caseSimpleNamedExpCS(typeNameExpCS);
				if (result == null) result = caseTypeRefCS(typeNameExpCS);
				if (result == null) result = caseNamedExpCS(typeNameExpCS);
				if (result == null) result = caseParameterableElementCS(typeNameExpCS);
				if (result == null) result = caseExpCS(typeNameExpCS);
				if (result == null) result = caseMonikeredElementCS(typeNameExpCS);
				if (result == null) result = caseModelElementCS(typeNameExpCS);
				if (result == null) result = caseElementCS(typeNameExpCS);
				if (result == null) result = casePivotable(typeNameExpCS);
				if (result == null) result = caseVisitableCS(typeNameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.UNARY_OPERATOR_CS:
			{
				UnaryOperatorCS unaryOperatorCS = (UnaryOperatorCS)theEObject;
				T result = caseUnaryOperatorCS(unaryOperatorCS);
				if (result == null) result = caseOperatorCS(unaryOperatorCS);
				if (result == null) result = caseNamedElementCS(unaryOperatorCS);
				if (result == null) result = caseExpCS(unaryOperatorCS);
				if (result == null) result = caseMonikeredElementCS(unaryOperatorCS);
				if (result == null) result = caseNameable(unaryOperatorCS);
				if (result == null) result = caseModelElementCS(unaryOperatorCS);
				if (result == null) result = caseElementCS(unaryOperatorCS);
				if (result == null) result = casePivotable(unaryOperatorCS);
				if (result == null) result = caseVisitableCS(unaryOperatorCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
			{
				UnlimitedNaturalLiteralExpCS unlimitedNaturalLiteralExpCS = (UnlimitedNaturalLiteralExpCS)theEObject;
				T result = caseUnlimitedNaturalLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = casePrimitiveLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseExpCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseMonikeredElementCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseModelElementCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseElementCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = casePivotable(unlimitedNaturalLiteralExpCS);
				if (result == null) result = caseVisitableCS(unlimitedNaturalLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EssentialOCLCSTPackage.VARIABLE_CS:
			{
				VariableCS variableCS = (VariableCS)theEObject;
				T result = caseVariableCS(variableCS);
				if (result == null) result = caseNamedElementCS(variableCS);
				if (result == null) result = caseMonikeredElementCS(variableCS);
				if (result == null) result = caseNameable(variableCS);
				if (result == null) result = caseModelElementCS(variableCS);
				if (result == null) result = caseElementCS(variableCS);
				if (result == null) result = casePivotable(variableCS);
				if (result == null) result = caseVisitableCS(variableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Operator CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Operator CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryOperatorCS(BinaryOperatorCS object)
	{
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
  public T caseBooleanLiteralExpCS(BooleanLiteralExpCS object)
  {
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
  public T caseCollectionLiteralExpCS(CollectionLiteralExpCS object)
  {
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
  public T caseCollectionLiteralPartCS(CollectionLiteralPartCS object)
  {
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
  public T caseCollectionTypeCS(CollectionTypeCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Context CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextCS(ContextCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Decorated Named Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decorated Named Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecoratedNamedExpCS(DecoratedNamedExpCS object)
	{
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
  public T caseExpCS(ExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Exp Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp Constraint CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpConstraintCS(ExpConstraintCS object)
	{
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
  public T caseIfExpCS(IfExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Index Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexExpCS(IndexExpCS object)
	{
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
  public T caseInfixExpCS(InfixExpCS object)
  {
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
  public T caseInvalidLiteralExpCS(InvalidLiteralExpCS object)
  {
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
  public T caseLetExpCS(LetExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Let Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetVariableCS(LetVariableCS object)
	{
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
  public T caseLiteralExpCS(LiteralExpCS object)
  {
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
  public T caseNameExpCS(NameExpCS object)
  {
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
  public T caseNamedExpCS(NamedExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Navigating Arg CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigating Arg CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigatingArgCS(NavigatingArgCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigating Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigating Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigatingExpCS(NavigatingExpCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Operator CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Operator CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationOperatorCS(NavigationOperatorCS object)
	{
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
  public T caseNestedExpCS(NestedExpCS object)
  {
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
  public T caseNullLiteralExpCS(NullLiteralExpCS object)
  {
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
  public T caseNumberLiteralExpCS(NumberLiteralExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Operator CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorCS(OperatorCS object)
	{
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
  public T casePrefixExpCS(PrefixExpCS object)
  {
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
  public T casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object)
  {
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
  public T caseSelfExpCS(SelfExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Named Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Named Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleNamedExpCS(SimpleNamedExpCS object)
	{
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
  public T caseStringLiteralExpCS(StringLiteralExpCS object)
  {
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
  public T caseTupleLiteralExpCS(TupleLiteralExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleLiteralPartCS(TupleLiteralPartCS object)
	{
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
	public T caseTypeLiteralExpCS(TypeLiteralExpCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeNameExpCS(TypeNameExpCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Operator CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Operator CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryOperatorCS(UnaryOperatorCS object)
	{
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
	public T caseUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS object)
	{
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
	public T caseVariableCS(VariableCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitableCS(VisitableCS object)
	{
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
  public T caseElementCS(ElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotable(Pivotable object)
	{
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
  public T caseModelElementCS(ModelElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Monikered Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monikered Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMonikeredElementCS(MonikeredElementCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object)
	{
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
  public T caseNamedElementCS(NamedElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterable Element CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseParameterableElementCS(ParameterableElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Type Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeRefCS(TypeRefCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedRefCS(TypedRefCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootCS(RootCS object)
	{
		return null;
	}

/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintCS(ConstraintCS object)
	{
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
  public T defaultCase(EObject object)
  {
		return null;
	}

} //EssentialOCLCSTSwitch
