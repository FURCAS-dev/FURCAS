/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.expressions.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ocl.expressions.*;

import org.eclipse.emf.ocl.uml.TypedElement;

import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CallExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.FeatureCallExp;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.InvalidLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.LiteralExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.MessageExp;
import org.eclipse.emf.ocl.expressions.NavigationCallExp;
import org.eclipse.emf.ocl.expressions.NullLiteralExp;
import org.eclipse.emf.ocl.expressions.NumericLiteralExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PrimitiveLiteralExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StateExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.TypeExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.CallingASTNode;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.emf.ocl.utilities.Visitable;
/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @deprecated Use the {@link org.eclipse.ocl.expressions.util.ExpressionsAdapterFactory} class,
 * instead.
 * 
 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage
 * @generated
 */
@Deprecated
public class ExpressionsAdapterFactory extends AdapterFactoryImpl
{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

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
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionsSwitch modelSwitch=
		new ExpressionsSwitch() {
			@Override
            public Object caseAssociationClassCallExp(AssociationClassCallExp object) {
				return createAssociationClassCallExpAdapter();
			}
			@Override
            public Object caseBooleanLiteralExp(BooleanLiteralExp object) {
				return createBooleanLiteralExpAdapter();
			}
			@Override
            public Object caseCallExp(CallExp object) {
				return createCallExpAdapter();
			}
			@Override
            public Object caseCollectionItem(CollectionItem object) {
				return createCollectionItemAdapter();
			}
			@Override
            public Object caseCollectionLiteralExp(CollectionLiteralExp object) {
				return createCollectionLiteralExpAdapter();
			}
			@Override
            public Object caseCollectionLiteralPart(CollectionLiteralPart object) {
				return createCollectionLiteralPartAdapter();
			}
			@Override
            public Object caseCollectionRange(CollectionRange object) {
				return createCollectionRangeAdapter();
			}
			@Override
            public Object caseEnumLiteralExp(EnumLiteralExp object) {
				return createEnumLiteralExpAdapter();
			}
			@Override
            public Object caseFeatureCallExp(FeatureCallExp object) {
				return createFeatureCallExpAdapter();
			}
			@Override
            public Object caseIfExp(IfExp object) {
				return createIfExpAdapter();
			}
			@Override
            public Object caseIntegerLiteralExp(IntegerLiteralExp object) {
				return createIntegerLiteralExpAdapter();
			}
			@Override
            public Object caseInvalidLiteralExp(InvalidLiteralExp object) {
				return createInvalidLiteralExpAdapter();
			}
			@Override
            public Object caseIterateExp(IterateExp object) {
				return createIterateExpAdapter();
			}
			@Override
            public Object caseIteratorExp(IteratorExp object) {
				return createIteratorExpAdapter();
			}
			@Override
            public Object caseLetExp(LetExp object) {
				return createLetExpAdapter();
			}
			@Override
            public Object caseLiteralExp(LiteralExp object) {
				return createLiteralExpAdapter();
			}
			@Override
            public Object caseLoopExp(LoopExp object) {
				return createLoopExpAdapter();
			}
			@Override
            public Object caseMessageExp(MessageExp object) {
				return createMessageExpAdapter();
			}
			@Override
            public Object caseNavigationCallExp(NavigationCallExp object) {
				return createNavigationCallExpAdapter();
			}
			@Override
            public Object caseNullLiteralExp(NullLiteralExp object) {
				return createNullLiteralExpAdapter();
			}
			@Override
            public Object caseNumericLiteralExp(NumericLiteralExp object) {
				return createNumericLiteralExpAdapter();
			}
			@Override
            public Object caseOCLExpression(OCLExpression object) {
				return createOCLExpressionAdapter();
			}
			@Override
            public Object caseOperationCallExp(OperationCallExp object) {
				return createOperationCallExpAdapter();
			}
			@Override
            public Object casePrimitiveLiteralExp(PrimitiveLiteralExp object) {
				return createPrimitiveLiteralExpAdapter();
			}
			@Override
            public Object casePropertyCallExp(PropertyCallExp object) {
				return createPropertyCallExpAdapter();
			}
			@Override
            public Object caseRealLiteralExp(RealLiteralExp object) {
				return createRealLiteralExpAdapter();
			}
			@Override
            public Object caseStateExp(StateExp object) {
				return createStateExpAdapter();
			}
			@Override
            public Object caseStringLiteralExp(StringLiteralExp object) {
				return createStringLiteralExpAdapter();
			}
			@Override
            public Object caseTupleLiteralExp(TupleLiteralExp object) {
				return createTupleLiteralExpAdapter();
			}
			@Override
            public Object caseTupleLiteralPart(TupleLiteralPart object) {
				return createTupleLiteralPartAdapter();
			}
			@Override
            public Object caseTypeExp(TypeExp object) {
				return createTypeExpAdapter();
			}
			@Override
            public Object caseUnspecifiedValueExp(UnspecifiedValueExp object) {
				return createUnspecifiedValueExpAdapter();
			}
			@Override
            public Object caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
            public Object caseVariableExp(VariableExp object) {
				return createVariableExpAdapter();
			}
			@Override
            public Object caseEModelElement(EModelElement object) {
				return createEModelElementAdapter();
			}
			@Override
            public Object caseENamedElement(ENamedElement object) {
				return createENamedElementAdapter();
			}
			@Override
            public Object caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
            public Object caseVisitable(Visitable object) {
				return createVisitableAdapter();
			}
			@Override
            public Object caseASTNode(ASTNode object) {
				return createASTNodeAdapter();
			}
			@Override
            public Object caseCallingASTNode(CallingASTNode object) {
				return createCallingASTNodeAdapter();
			}
			@Override
            public Object caseTypedASTNode(TypedASTNode object) {
				return createTypedASTNodeAdapter();
			}
			@Override
            public Object defaultCase(EObject object) {
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
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.BooleanLiteralExp
	 * @generated
	 */
	public Adapter createBooleanLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.CollectionItem
	 * @generated
	 */
	public Adapter createCollectionItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.CollectionLiteralExp
	 * @generated
	 */
	public Adapter createCollectionLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.CollectionLiteralPart <em>Collection Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.CollectionLiteralPart
	 * @generated
	 */
	public Adapter createCollectionLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.CollectionRange <em>Collection Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.CollectionRange
	 * @generated
	 */
	public Adapter createCollectionRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.IfExp <em>If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.IfExp
	 * @generated
	 */
	public Adapter createIfExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.IntegerLiteralExp
	 * @generated
	 */
	public Adapter createIntegerLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.IterateExp <em>Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.IterateExp
	 * @generated
	 */
	public Adapter createIterateExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.IteratorExp <em>Iterator Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.IteratorExp
	 * @generated
	 */
	public Adapter createIteratorExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.LetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.LetExp
	 * @generated
	 */
	public Adapter createLetExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.LiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.LiteralExp
	 * @generated
	 */
	public Adapter createLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.LoopExp <em>Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.LoopExp
	 * @generated
	 */
	public Adapter createLoopExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.NavigationCallExp <em>Navigation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.NavigationCallExp
	 * @generated
	 */
	public Adapter createNavigationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.NumericLiteralExp
	 * @generated
	 */
	public Adapter createNumericLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.OperationCallExp
	 * @generated
	 */
	public Adapter createOperationCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.PrimitiveLiteralExp
	 * @generated
	 */
	public Adapter createPrimitiveLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.RealLiteralExp
	 * @generated
	 */
	public Adapter createRealLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.StringLiteralExp <em>String Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.StringLiteralExp
	 * @generated
	 */
	public Adapter createStringLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.TupleLiteralExp
	 * @generated
	 */
	public Adapter createTupleLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.UnspecifiedValueExp <em>Unspecified Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.UnspecifiedValueExp
	 * @generated
	 */
	public Adapter createUnspecifiedValueExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.VariableExp
	 * @generated
	 */
	public Adapter createVariableExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.AssociationClassCallExp <em>Association Class Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.AssociationClassCallExp
	 * @generated
	 */
	public Adapter createAssociationClassCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.FeatureCallExp <em>Feature Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.FeatureCallExp
	 * @generated
	 */
	public Adapter createFeatureCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.MessageExp <em>Message Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.MessageExp
	 * @generated
	 */
	public Adapter createMessageExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.CallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.CallExp
	 * @generated
	 */
	public Adapter createCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.NullLiteralExp <em>Null Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.NullLiteralExp
	 * @generated
	 */
	public Adapter createNullLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.InvalidLiteralExp
	 * @generated
	 */
	public Adapter createInvalidLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.TypeExp <em>Type Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.TypeExp
	 * @generated
	 */
	public Adapter createTypeExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.StateExp <em>State Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.StateExp
	 * @generated
	 */
	public Adapter createStateExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.PropertyCallExp <em>Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.PropertyCallExp
	 * @generated
	 */
	public Adapter createPropertyCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.TupleLiteralPart <em>Tuple Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.TupleLiteralPart
	 * @generated
	 */
	public Adapter createTupleLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.OCLExpression <em>OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.OCLExpression
	 * @generated
	 */
	public Adapter createOCLExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.expressions.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.expressions.EnumLiteralExp
	 * @generated
	 */
	public Adapter createEnumLiteralExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EModelElement <em>EModel Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.EModelElement
	 * @generated
	 */
	public Adapter createEModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.ENamedElement <em>ENamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecore.ENamedElement
	 * @generated
	 */
	public Adapter createENamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.utilities.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.utilities.Visitable
	 * @generated
	 */
	public Adapter createVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.utilities.ASTNode <em>AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.utilities.ASTNode
	 * @generated
	 */
	public Adapter createASTNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.uml.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.uml.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.utilities.CallingASTNode <em>Calling AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.utilities.CallingASTNode
	 * @generated
	 */
	public Adapter createCallingASTNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ocl.utilities.TypedASTNode <em>Typed AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ocl.utilities.TypedASTNode
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
