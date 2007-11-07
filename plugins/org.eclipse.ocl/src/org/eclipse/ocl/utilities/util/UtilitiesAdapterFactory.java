/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UtilitiesAdapterFactory.java,v 1.6 2007/11/07 18:08:22 cdamus Exp $
 */
package org.eclipse.ocl.utilities.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

//import org.eclipse.ocl.utilities.*;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.utilities.UtilitiesPackage
 * @generated
 */
public class UtilitiesAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static UtilitiesPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UtilitiesAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = UtilitiesPackage.eINSTANCE;
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
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
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
	protected UtilitiesSwitch<Adapter> modelSwitch =
		new UtilitiesSwitch<Adapter>() {
            @Override
            public Adapter caseASTNode(ASTNode object) {
                return createASTNodeAdapter();
            }
            @Override
            public Adapter caseCallingASTNode(CallingASTNode object) {
                return createCallingASTNodeAdapter();
            }
            @Override
            public Adapter caseTypedASTNode(TypedASTNode object) {
                return createTypedASTNodeAdapter();
            }
            @Override
            public Adapter caseVisitable(Visitable object) {
                return createVisitableAdapter();
            }
            @Override
            public <T, C, O, P, EL, PM, S, COA, SSA, CT> Adapter caseVisitor(Visitor<T, C, O, P, EL, PM, S, COA, SSA, CT> object) {
                return createVisitorAdapter();
            }
            @Override
            public <C> Adapter caseTypedElement(TypedElement<C> object) {
                return createTypedElementAdapter();
            }
            @Override
            public <C, PM> Adapter caseExpressionInOCL(ExpressionInOCL<C, PM> object) {
                return createExpressionInOCLAdapter();
            }
            @Override
            public <O> Adapter casePredefinedType(PredefinedType<O> object) {
                return createPredefinedTypeAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
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
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.ASTNode <em>AST Node</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.ASTNode
     * @generated
     */
	public Adapter createASTNodeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.CallingASTNode <em>Calling AST Node</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.CallingASTNode
     * @generated
     */
	public Adapter createCallingASTNodeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.PredefinedType <em>Predefined Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.PredefinedType
     * @generated
     */
	public Adapter createPredefinedTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.TypedASTNode <em>Typed AST Node</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.TypedASTNode
     * @generated
     */
	public Adapter createTypedASTNodeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.Visitable <em>Visitable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.Visitable
     * @generated
     */
	public Adapter createVisitableAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.TypedElement <em>Typed Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.TypedElement
     * @generated
     */
	public Adapter createTypedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.Visitor <em>Visitor</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.Visitor
     * @generated
     */
	public Adapter createVisitorAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.ExpressionInOCL <em>Expression In OCL</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.ExpressionInOCL
     * @generated
     */
	public Adapter createExpressionInOCLAdapter() {
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
	public Adapter createEObjectAdapter() {
        return null;
    }

} //UtilitiesAdapterFactory
