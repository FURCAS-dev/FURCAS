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
 * $Id: OCLinEcoreCSTAdapterFactory.java,v 1.5 2011/01/24 21:43:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.util;

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
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage
 * @generated
 */
public class OCLinEcoreCSTAdapterFactory extends AdapterFactoryImpl
{
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static OCLinEcoreCSTPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public OCLinEcoreCSTAdapterFactory()
  {
		if (modelPackage == null)
		{
			modelPackage = OCLinEcoreCSTPackage.eINSTANCE;
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
  protected OCLinEcoreCSTSwitch<Adapter> modelSwitch =
    new OCLinEcoreCSTSwitch<Adapter>()
		{
			@Override
			public Adapter caseOCLinEcoreConstraintCS(OCLinEcoreConstraintCS object)
			{
				return createOCLinEcoreConstraintCSAdapter();
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
			public Adapter caseConstraintCS(ConstraintCS object)
			{
				return createConstraintCSAdapter();
			}
			@Override
			public Adapter caseExpConstraintCS(ExpConstraintCS object)
			{
				return createExpConstraintCSAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS <em>OC Lin Ecore Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS
	 * @generated
	 */
	public Adapter createOCLinEcoreConstraintCSAdapter()
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

} //OCLinEcoreCSTAdapterFactory
