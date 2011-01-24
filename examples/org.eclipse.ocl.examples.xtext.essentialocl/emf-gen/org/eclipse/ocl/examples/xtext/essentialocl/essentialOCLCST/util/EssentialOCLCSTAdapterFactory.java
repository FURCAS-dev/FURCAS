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
 * $Id: EssentialOCLCSTAdapterFactory.java,v 1.6 2011/01/24 21:31:48 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage
 * @generated
 */
public class EssentialOCLCSTAdapterFactory extends AdapterFactoryImpl
{
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static EssentialOCLCSTPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EssentialOCLCSTAdapterFactory()
  {
		if (modelPackage == null)
		{
			modelPackage = EssentialOCLCSTPackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object)
  {
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EssentialOCLCSTSwitch<Adapter> modelSwitch =
    new EssentialOCLCSTSwitch<Adapter>()
		{
			@Override
			public Adapter caseBinaryOperatorCS(BinaryOperatorCS object)
			{
				return createBinaryOperatorCSAdapter();
			}
			@Override
			public Adapter caseBooleanLiteralExpCS(BooleanLiteralExpCS object)
			{
				return createBooleanLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseCollectionLiteralExpCS(CollectionLiteralExpCS object)
			{
				return createCollectionLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseCollectionLiteralPartCS(CollectionLiteralPartCS object)
			{
				return createCollectionLiteralPartCSAdapter();
			}
			@Override
			public Adapter caseCollectionTypeCS(CollectionTypeCS object)
			{
				return createCollectionTypeCSAdapter();
			}
			@Override
			public Adapter caseContextCS(ContextCS object)
			{
				return createContextCSAdapter();
			}
			@Override
			public Adapter caseDecoratedNamedExpCS(DecoratedNamedExpCS object)
			{
				return createDecoratedNamedExpCSAdapter();
			}
			@Override
			public Adapter caseExpCS(ExpCS object)
			{
				return createExpCSAdapter();
			}
			@Override
			public Adapter caseExpConstraintCS(ExpConstraintCS object)
			{
				return createExpConstraintCSAdapter();
			}
			@Override
			public Adapter caseIfExpCS(IfExpCS object)
			{
				return createIfExpCSAdapter();
			}
			@Override
			public Adapter caseIndexExpCS(IndexExpCS object)
			{
				return createIndexExpCSAdapter();
			}
			@Override
			public Adapter caseInfixExpCS(InfixExpCS object)
			{
				return createInfixExpCSAdapter();
			}
			@Override
			public Adapter caseInvalidLiteralExpCS(InvalidLiteralExpCS object)
			{
				return createInvalidLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseLetExpCS(LetExpCS object)
			{
				return createLetExpCSAdapter();
			}
			@Override
			public Adapter caseLetVariableCS(LetVariableCS object)
			{
				return createLetVariableCSAdapter();
			}
			@Override
			public Adapter caseLiteralExpCS(LiteralExpCS object)
			{
				return createLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseNameExpCS(NameExpCS object)
			{
				return createNameExpCSAdapter();
			}
			@Override
			public Adapter caseNamedExpCS(NamedExpCS object)
			{
				return createNamedExpCSAdapter();
			}
			@Override
			public Adapter caseNavigatingArgCS(NavigatingArgCS object)
			{
				return createNavigatingArgCSAdapter();
			}
			@Override
			public Adapter caseNavigatingExpCS(NavigatingExpCS object)
			{
				return createNavigatingExpCSAdapter();
			}
			@Override
			public Adapter caseNavigationOperatorCS(NavigationOperatorCS object)
			{
				return createNavigationOperatorCSAdapter();
			}
			@Override
			public Adapter caseNestedExpCS(NestedExpCS object)
			{
				return createNestedExpCSAdapter();
			}
			@Override
			public Adapter caseNullLiteralExpCS(NullLiteralExpCS object)
			{
				return createNullLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseNumberLiteralExpCS(NumberLiteralExpCS object)
			{
				return createNumberLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseOperatorCS(OperatorCS object)
			{
				return createOperatorCSAdapter();
			}
			@Override
			public Adapter casePrefixExpCS(PrefixExpCS object)
			{
				return createPrefixExpCSAdapter();
			}
			@Override
			public Adapter casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object)
			{
				return createPrimitiveLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseSelfExpCS(SelfExpCS object)
			{
				return createSelfExpCSAdapter();
			}
			@Override
			public Adapter caseSimpleNamedExpCS(SimpleNamedExpCS object)
			{
				return createSimpleNamedExpCSAdapter();
			}
			@Override
			public Adapter caseStringLiteralExpCS(StringLiteralExpCS object)
			{
				return createStringLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTupleLiteralExpCS(TupleLiteralExpCS object)
			{
				return createTupleLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTupleLiteralPartCS(TupleLiteralPartCS object)
			{
				return createTupleLiteralPartCSAdapter();
			}
			@Override
			public Adapter caseTypeLiteralExpCS(TypeLiteralExpCS object)
			{
				return createTypeLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTypeNameExpCS(TypeNameExpCS object)
			{
				return createTypeNameExpCSAdapter();
			}
			@Override
			public Adapter caseUnaryOperatorCS(UnaryOperatorCS object)
			{
				return createUnaryOperatorCSAdapter();
			}
			@Override
			public Adapter caseUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS object)
			{
				return createUnlimitedNaturalLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseVariableCS(VariableCS object)
			{
				return createVariableCSAdapter();
			}
			@Override
			public Adapter caseVisitableCS(VisitableCS object)
			{
				return createVisitableCSAdapter();
			}
			@Override
			public Adapter caseElementCS(ElementCS object)
			{
				return createElementCSAdapter();
			}
			@Override
			public Adapter casePivotable(Pivotable object)
			{
				return createPivotableAdapter();
			}
			@Override
			public Adapter caseModelElementCS(ModelElementCS object)
			{
				return createModelElementCSAdapter();
			}
			@Override
			public Adapter caseMonikeredElementCS(MonikeredElementCS object)
			{
				return createMonikeredElementCSAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object)
			{
				return createNameableAdapter();
			}
			@Override
			public Adapter caseNamedElementCS(NamedElementCS object)
			{
				return createNamedElementCSAdapter();
			}
			@Override
			public Adapter caseParameterableElementCS(ParameterableElementCS object)
			{
				return createParameterableElementCSAdapter();
			}
			@Override
			public Adapter caseTypeRefCS(TypeRefCS object)
			{
				return createTypeRefCSAdapter();
			}
			@Override
			public Adapter caseTypedRefCS(TypedRefCS object)
			{
				return createTypedRefCSAdapter();
			}
			@Override
			public Adapter caseRootCS(RootCS object)
			{
				return createRootCSAdapter();
			}
			@Override
			public Adapter caseConstraintCS(ConstraintCS object)
			{
				return createConstraintCSAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target)
  {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS <em>Binary Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS
	 * @generated
	 */
	public Adapter createBinaryOperatorCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS
	 * @generated
	 */
  public Adapter createBooleanLiteralExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS
	 * @generated
	 */
  public Adapter createCollectionLiteralExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS <em>Collection Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS
	 * @generated
	 */
  public Adapter createCollectionLiteralPartCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS <em>Collection Type CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS
	 * @generated
	 */
  public Adapter createCollectionTypeCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS <em>Context CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS
	 * @generated
	 */
	public Adapter createContextCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS <em>Decorated Named Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS
	 * @generated
	 */
	public Adapter createDecoratedNamedExpCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS <em>Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS
	 * @generated
	 */
  public Adapter createExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS <em>Exp Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS
	 * @generated
	 */
	public Adapter createExpConstraintCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS <em>If Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS
	 * @generated
	 */
  public Adapter createIfExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS <em>Index Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS
	 * @generated
	 */
	public Adapter createIndexExpCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS <em>Infix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS
	 * @generated
	 */
  public Adapter createInfixExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS <em>Invalid Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS
	 * @generated
	 */
  public Adapter createInvalidLiteralExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS <em>Let Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS
	 * @generated
	 */
  public Adapter createLetExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS <em>Let Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS
	 * @generated
	 */
	public Adapter createLetVariableCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS <em>Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS
	 * @generated
	 */
  public Adapter createLiteralExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS <em>Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS
	 * @generated
	 */
  public Adapter createNameExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS <em>Named Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS
	 * @generated
	 */
  public Adapter createNamedExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS <em>Navigating Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS
	 * @generated
	 */
	public Adapter createNavigatingArgCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS <em>Navigating Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS
	 * @generated
	 */
	public Adapter createNavigatingExpCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS <em>Navigation Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS
	 * @generated
	 */
	public Adapter createNavigationOperatorCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS <em>Nested Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS
	 * @generated
	 */
  public Adapter createNestedExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS <em>Null Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS
	 * @generated
	 */
  public Adapter createNullLiteralExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS <em>Number Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS
	 * @generated
	 */
  public Adapter createNumberLiteralExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS <em>Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS
	 * @generated
	 */
	public Adapter createOperatorCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS <em>Prefix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS
	 * @generated
	 */
  public Adapter createPrefixExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS <em>Primitive Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS
	 * @generated
	 */
  public Adapter createPrimitiveLiteralExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS <em>Self Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS
	 * @generated
	 */
  public Adapter createSelfExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNamedExpCS <em>Simple Named Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNamedExpCS
	 * @generated
	 */
	public Adapter createSimpleNamedExpCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS
	 * @generated
	 */
  public Adapter createStringLiteralExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS <em>Tuple Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS
	 * @generated
	 */
  public Adapter createTupleLiteralExpCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS <em>Tuple Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS
	 * @generated
	 */
	public Adapter createTupleLiteralPartCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS <em>Type Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS
	 * @generated
	 */
	public Adapter createTypeLiteralExpCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS <em>Type Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS
	 * @generated
	 */
	public Adapter createTypeNameExpCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS <em>Unary Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS
	 * @generated
	 */
	public Adapter createUnaryOperatorCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS <em>Unlimited Natural Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS
	 * @generated
	 */
	public Adapter createUnlimitedNaturalLiteralExpCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS <em>Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS
	 * @generated
	 */
	public Adapter createVariableCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.util.VisitableCS <em>Visitable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.util.VisitableCS
	 * @generated
	 */
	public Adapter createVisitableCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS <em>Element CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS
	 * @generated
	 */
  public Adapter createElementCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.pivot.util.Pivotable <em>Pivotable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.pivot.util.Pivotable
	 * @generated
	 */
	public Adapter createPivotableAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS <em>Model Element CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS
	 * @generated
	 */
  public Adapter createModelElementCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS <em>Monikered Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS
	 * @generated
	 */
	public Adapter createMonikeredElementCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.pivot.util.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.pivot.util.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS
	 * @generated
	 */
  public Adapter createNamedElementCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS <em>Parameterable Element CS</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS
	 * @generated
	 */
  public Adapter createParameterableElementCSAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS <em>Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS
	 * @generated
	 */
	public Adapter createTypeRefCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS <em>Typed Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS
	 * @generated
	 */
	public Adapter createTypedRefCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.RootCS
	 * @generated
	 */
	public Adapter createRootCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS
	 * @generated
	 */
	public Adapter createConstraintCSAdapter()
	{
		return null;
	}

/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter()
  {
		return null;
	}

} //EssentialOCLCSTAdapterFactory
