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
 * $Id: ExpressionsAdapterFactory.java,v 1.6 2007/11/07 18:08:22 cdamus Exp $
 */
package org.eclipse.ocl.expressions.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

//import org.eclipse.ocl.expressions.*;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NavigationCallExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.NumericLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PrimitiveLiteralExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;


/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static ExpressionsPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExpressionsAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ExpressionsPackage.eINSTANCE;
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
	protected ExpressionsSwitch<Adapter> modelSwitch =
		new ExpressionsSwitch<Adapter>() {
            @Override
            public <C, P> Adapter caseAssociationClassCallExp(AssociationClassCallExp<C, P> object) {
                return createAssociationClassCallExpAdapter();
            }
            @Override
            public <C, P> Adapter caseNavigationCallExp(NavigationCallExp<C, P> object) {
                return createNavigationCallExpAdapter();
            }
            @Override
            public <C> Adapter caseFeatureCallExp(FeatureCallExp<C> object) {
                return createFeatureCallExpAdapter();
            }
            @Override
            public <C> Adapter caseCallExp(CallExp<C> object) {
                return createCallExpAdapter();
            }
            @Override
            public <C> Adapter caseOCLExpression(OCLExpression<C> object) {
                return createOCLExpressionAdapter();
            }
            @Override
            public <C> Adapter caseBooleanLiteralExp(BooleanLiteralExp<C> object) {
                return createBooleanLiteralExpAdapter();
            }
            @Override
            public <C> Adapter casePrimitiveLiteralExp(PrimitiveLiteralExp<C> object) {
                return createPrimitiveLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseLiteralExp(LiteralExp<C> object) {
                return createLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseCollectionItem(CollectionItem<C> object) {
                return createCollectionItemAdapter();
            }
            @Override
            public <C> Adapter caseCollectionLiteralPart(CollectionLiteralPart<C> object) {
                return createCollectionLiteralPartAdapter();
            }
            @Override
            public <C> Adapter caseCollectionLiteralExp(CollectionLiteralExp<C> object) {
                return createCollectionLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseCollectionRange(CollectionRange<C> object) {
                return createCollectionRangeAdapter();
            }
            @Override
            public <C, EL> Adapter caseEnumLiteralExp(EnumLiteralExp<C, EL> object) {
                return createEnumLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseIfExp(IfExp<C> object) {
                return createIfExpAdapter();
            }
            @Override
            public <C> Adapter caseIntegerLiteralExp(IntegerLiteralExp<C> object) {
                return createIntegerLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseNumericLiteralExp(NumericLiteralExp<C> object) {
                return createNumericLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<C> object) {
                return createUnlimitedNaturalLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseInvalidLiteralExp(InvalidLiteralExp<C> object) {
                return createInvalidLiteralExpAdapter();
            }
            @Override
            public <C, PM> Adapter caseIterateExp(IterateExp<C, PM> object) {
                return createIterateExpAdapter();
            }
            @Override
            public <C, PM> Adapter caseLoopExp(LoopExp<C, PM> object) {
                return createLoopExpAdapter();
            }
            @Override
            public <C, PM> Adapter caseVariable(Variable<C, PM> object) {
                return createVariableAdapter();
            }
            @Override
            public <C, PM> Adapter caseIteratorExp(IteratorExp<C, PM> object) {
                return createIteratorExpAdapter();
            }
            @Override
            public <C, PM> Adapter caseLetExp(LetExp<C, PM> object) {
                return createLetExpAdapter();
            }
            @Override
            public <C, COA, SSA> Adapter caseMessageExp(MessageExp<C, COA, SSA> object) {
                return createMessageExpAdapter();
            }
            @Override
            public <C> Adapter caseNullLiteralExp(NullLiteralExp<C> object) {
                return createNullLiteralExpAdapter();
            }
            @Override
            public <C, O> Adapter caseOperationCallExp(OperationCallExp<C, O> object) {
                return createOperationCallExpAdapter();
            }
            @Override
            public <C, P> Adapter casePropertyCallExp(PropertyCallExp<C, P> object) {
                return createPropertyCallExpAdapter();
            }
            @Override
            public <C> Adapter caseRealLiteralExp(RealLiteralExp<C> object) {
                return createRealLiteralExpAdapter();
            }
            @Override
            public <C, S> Adapter caseStateExp(StateExp<C, S> object) {
                return createStateExpAdapter();
            }
            @Override
            public <C> Adapter caseStringLiteralExp(StringLiteralExp<C> object) {
                return createStringLiteralExpAdapter();
            }
            @Override
            public <C, P> Adapter caseTupleLiteralExp(TupleLiteralExp<C, P> object) {
                return createTupleLiteralExpAdapter();
            }
            @Override
            public <C, P> Adapter caseTupleLiteralPart(TupleLiteralPart<C, P> object) {
                return createTupleLiteralPartAdapter();
            }
            @Override
            public <C> Adapter caseTypeExp(TypeExp<C> object) {
                return createTypeExpAdapter();
            }
            @Override
            public <C> Adapter caseUnspecifiedValueExp(UnspecifiedValueExp<C> object) {
                return createUnspecifiedValueExpAdapter();
            }
            @Override
            public <C, PM> Adapter caseVariableExp(VariableExp<C, PM> object) {
                return createVariableExpAdapter();
            }
            @Override
            public <C> Adapter caseTypedElement(TypedElement<C> object) {
                return createTypedElementAdapter();
            }
            @Override
            public Adapter caseVisitable(Visitable object) {
                return createVisitableAdapter();
            }
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
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.AssociationClassCallExp
     * @generated
     */
	public Adapter createAssociationClassCallExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.BooleanLiteralExp
     * @generated
     */
	public Adapter createBooleanLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CallExp <em>Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.CallExp
     * @generated
     */
	public Adapter createCallExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CollectionItem <em>Collection Item</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.CollectionItem
     * @generated
     */
	public Adapter createCollectionItemAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.CollectionLiteralExp
     * @generated
     */
	public Adapter createCollectionLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CollectionLiteralPart <em>Collection Literal Part</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.CollectionLiteralPart
     * @generated
     */
	public Adapter createCollectionLiteralPartAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CollectionRange <em>Collection Range</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.CollectionRange
     * @generated
     */
	public Adapter createCollectionRangeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.EnumLiteralExp <em>Enum Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.EnumLiteralExp
     * @generated
     */
	public Adapter createEnumLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.FeatureCallExp <em>Feature Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.FeatureCallExp
     * @generated
     */
	public Adapter createFeatureCallExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.IfExp <em>If Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.IfExp
     * @generated
     */
	public Adapter createIfExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.IntegerLiteralExp
     * @generated
     */
	public Adapter createIntegerLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp <em>Unlimited Natural Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp
     * @generated
     */
    public Adapter createUnlimitedNaturalLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.InvalidLiteralExp
     * @generated
     */
	public Adapter createInvalidLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.IterateExp <em>Iterate Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.IterateExp
     * @generated
     */
	public Adapter createIterateExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.IteratorExp <em>Iterator Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.IteratorExp
     * @generated
     */
	public Adapter createIteratorExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.LetExp <em>Let Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.LetExp
     * @generated
     */
	public Adapter createLetExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.LiteralExp <em>Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.LiteralExp
     * @generated
     */
	public Adapter createLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.LoopExp <em>Loop Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.LoopExp
     * @generated
     */
	public Adapter createLoopExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.MessageExp <em>Message Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.MessageExp
     * @generated
     */
	public Adapter createMessageExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.NavigationCallExp <em>Navigation Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.NavigationCallExp
     * @generated
     */
	public Adapter createNavigationCallExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.NullLiteralExp <em>Null Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.NullLiteralExp
     * @generated
     */
	public Adapter createNullLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.NumericLiteralExp
     * @generated
     */
	public Adapter createNumericLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.OCLExpression <em>OCL Expression</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.OCLExpression
     * @generated
     */
	public Adapter createOCLExpressionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.OperationCallExp <em>Operation Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.OperationCallExp
     * @generated
     */
	public Adapter createOperationCallExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.PrimitiveLiteralExp
     * @generated
     */
	public Adapter createPrimitiveLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.PropertyCallExp <em>Property Call Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.PropertyCallExp
     * @generated
     */
	public Adapter createPropertyCallExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.RealLiteralExp <em>Real Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.RealLiteralExp
     * @generated
     */
	public Adapter createRealLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.StateExp <em>State Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.StateExp
     * @generated
     */
	public Adapter createStateExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.StringLiteralExp <em>String Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.StringLiteralExp
     * @generated
     */
	public Adapter createStringLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.TupleLiteralExp
     * @generated
     */
	public Adapter createTupleLiteralExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.TupleLiteralPart <em>Tuple Literal Part</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.TupleLiteralPart
     * @generated
     */
	public Adapter createTupleLiteralPartAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.TypeExp <em>Type Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.TypeExp
     * @generated
     */
	public Adapter createTypeExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.UnspecifiedValueExp
     * @generated
     */
	public Adapter createUnspecifiedValueExpAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.Variable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.Variable
     * @generated
     */
	public Adapter createVariableAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.VariableExp <em>Variable Exp</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.VariableExp
     * @generated
     */
	public Adapter createVariableExpAdapter() {
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

} //ExpressionsAdapterFactory
