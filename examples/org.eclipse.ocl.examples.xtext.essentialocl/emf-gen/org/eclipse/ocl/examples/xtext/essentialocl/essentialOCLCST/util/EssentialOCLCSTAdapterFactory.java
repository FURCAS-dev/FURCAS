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
 * $Id: EssentialOCLCSTAdapterFactory.java,v 1.2 2010/04/13 20:35:16 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage
 * @generated
 */
public class EssentialOCLCSTAdapterFactory extends AdapterFactoryImpl {
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
	public EssentialOCLCSTAdapterFactory() {
		if (modelPackage == null) {
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
	protected EssentialOCLCSTSwitch<Adapter> modelSwitch =
		new EssentialOCLCSTSwitch<Adapter>() {
			@Override
			public Adapter caseBinaryExpressionCS(BinaryExpressionCS object) {
				return createBinaryExpressionCSAdapter();
			}
			@Override
			public Adapter caseBooleanLiteralExpCS(BooleanLiteralExpCS object) {
				return createBooleanLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseCallExpCS(CallExpCS object) {
				return createCallExpCSAdapter();
			}
			@Override
			public Adapter caseCollectionLiteralExpCS(CollectionLiteralExpCS object) {
				return createCollectionLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseCollectionLiteralPartCS(CollectionLiteralPartCS object) {
				return createCollectionLiteralPartCSAdapter();
			}
			@Override
			public Adapter caseCollectionTypeCS(CollectionTypeCS object) {
				return createCollectionTypeCSAdapter();
			}
			@Override
			public Adapter caseIfExpCS(IfExpCS object) {
				return createIfExpCSAdapter();
			}
			@Override
			public Adapter caseIndexExpCS(IndexExpCS object) {
				return createIndexExpCSAdapter();
			}
			@Override
			public Adapter caseIntegerLiteralExpCS(IntegerLiteralExpCS object) {
				return createIntegerLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseInvalidLiteralExpCS(InvalidLiteralExpCS object) {
				return createInvalidLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseLetExpCS(LetExpCS object) {
				return createLetExpCSAdapter();
			}
			@Override
			public Adapter caseLiteralExpCS(LiteralExpCS object) {
				return createLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseNullLiteralExpCS(NullLiteralExpCS object) {
				return createNullLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseOclExpressionCS(OclExpressionCS object) {
				return createOclExpressionCSAdapter();
			}
			@Override
			public Adapter caseOperationExpressionCS(OperationExpressionCS object) {
				return createOperationExpressionCSAdapter();
			}
			@Override
			public Adapter casePathNameCS(PathNameCS object) {
				return createPathNameCSAdapter();
			}
			@Override
			public Adapter casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object) {
				return createPrimitiveLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseRealLiteralExpCS(RealLiteralExpCS object) {
				return createRealLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseSimpleNameCS(SimpleNameCS object) {
				return createSimpleNameCSAdapter();
			}
			@Override
			public Adapter caseStringLiteralExpCS(StringLiteralExpCS object) {
				return createStringLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTupleLiteralExpCS(TupleLiteralExpCS object) {
				return createTupleLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseTupleTypeCS(TupleTypeCS object) {
				return createTupleTypeCSAdapter();
			}
			@Override
			public Adapter caseTypeCS(TypeCS object) {
				return createTypeCSAdapter();
			}
			@Override
			public Adapter caseTypeLiteralExpCS(TypeLiteralExpCS object) {
				return createTypeLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseUnaryExpressionCS(UnaryExpressionCS object) {
				return createUnaryExpressionCSAdapter();
			}
			@Override
			public Adapter caseUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS object) {
				return createUnlimitedNaturalLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseVariableCS(VariableCS object) {
				return createVariableCSAdapter();
			}
			@Override
			public Adapter caseVariableExpCS(VariableExpCS object) {
				return createVariableExpCSAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS
	 * @generated
	 */
	public Adapter createOclExpressionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperationExpressionCS <em>Operation Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperationExpressionCS
	 * @generated
	 */
	public Adapter createOperationExpressionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS
	 * @generated
	 */
	public Adapter createSimpleNameCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameCS
	 * @generated
	 */
	public Adapter createPathNameCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeCS
	 * @generated
	 */
	public Adapter createTypeCSAdapter() {
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
	public Adapter createCollectionTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS <em>Tuple Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS
	 * @generated
	 */
	public Adapter createTupleTypeCSAdapter() {
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
	public Adapter createVariableCSAdapter() {
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
	public Adapter createLiteralExpCSAdapter() {
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
	public Adapter createCollectionLiteralExpCSAdapter() {
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
	public Adapter createCollectionLiteralPartCSAdapter() {
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
	public Adapter createPrimitiveLiteralExpCSAdapter() {
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
	public Adapter createTupleLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IntegerLiteralExpCS <em>Integer Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IntegerLiteralExpCS
	 * @generated
	 */
	public Adapter createIntegerLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RealLiteralExpCS <em>Real Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RealLiteralExpCS
	 * @generated
	 */
	public Adapter createRealLiteralExpCSAdapter() {
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
	public Adapter createStringLiteralExpCSAdapter() {
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
	public Adapter createBooleanLiteralExpCSAdapter() {
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
	public Adapter createUnlimitedNaturalLiteralExpCSAdapter() {
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
	public Adapter createInvalidLiteralExpCSAdapter() {
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
	public Adapter createNullLiteralExpCSAdapter() {
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
	public Adapter createTypeLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableExpCS <em>Variable Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableExpCS
	 * @generated
	 */
	public Adapter createVariableExpCSAdapter() {
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
	public Adapter createIfExpCSAdapter() {
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
	public Adapter createIndexExpCSAdapter() {
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
	public Adapter createLetExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS <em>Binary Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS
	 * @generated
	 */
	public Adapter createBinaryExpressionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryExpressionCS <em>Unary Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryExpressionCS
	 * @generated
	 */
	public Adapter createUnaryExpressionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallExpCS <em>Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallExpCS
	 * @generated
	 */
	public Adapter createCallExpCSAdapter() {
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

} //EssentialOCLCSTAdapterFactory
