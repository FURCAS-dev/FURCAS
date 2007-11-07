/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CSTAdapterFactory.java,v 1.3 2007/11/07 18:08:22 cdamus Exp $
 */
package org.eclipse.ocl.cst.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

//import org.eclipse.ocl.cst.*;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionRangeCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.ContextDeclCS;
import org.eclipse.ocl.cst.DefCS;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.DerValueCS;
import org.eclipse.ocl.cst.EnumLiteralExpCS;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.InitValueCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.InvCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;
import org.eclipse.ocl.cst.LoopExpCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.OperationContextDeclCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrimitiveLiteralExpCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.PropertyContextCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.StateExpCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.cst.CSTPackage
 * @generated
 */
public class CSTAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static CSTPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CSTAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = CSTPackage.eINSTANCE;
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
	protected CSTSwitch<Adapter> modelSwitch =
		new CSTSwitch<Adapter>() {
            @Override
            public Adapter caseCSTNode(CSTNode object) {
                return createCSTNodeAdapter();
            }
            @Override
            public Adapter casePackageDeclarationCS(PackageDeclarationCS object) {
                return createPackageDeclarationCSAdapter();
            }
            @Override
            public Adapter casePathNameCS(PathNameCS object) {
                return createPathNameCSAdapter();
            }
            @Override
            public Adapter caseTypeCS(TypeCS object) {
                return createTypeCSAdapter();
            }
            @Override
            public Adapter caseOCLExpressionCS(OCLExpressionCS object) {
                return createOCLExpressionCSAdapter();
            }
            @Override
            public Adapter caseContextDeclCS(ContextDeclCS object) {
                return createContextDeclCSAdapter();
            }
            @Override
            public Adapter casePropertyContextCS(PropertyContextCS object) {
                return createPropertyContextCSAdapter();
            }
            @Override
            public Adapter caseSimpleNameCS(SimpleNameCS object) {
                return createSimpleNameCSAdapter();
            }
            @Override
            public Adapter caseInitOrDerValueCS(InitOrDerValueCS object) {
                return createInitOrDerValueCSAdapter();
            }
            @Override
            public Adapter caseClassifierContextDeclCS(ClassifierContextDeclCS object) {
                return createClassifierContextDeclCSAdapter();
            }
            @Override
            public Adapter caseInvOrDefCS(InvOrDefCS object) {
                return createInvOrDefCSAdapter();
            }
            @Override
            public Adapter caseOperationContextDeclCS(OperationContextDeclCS object) {
                return createOperationContextDeclCSAdapter();
            }
            @Override
            public Adapter caseOperationCS(OperationCS object) {
                return createOperationCSAdapter();
            }
            @Override
            public Adapter caseVariableCS(VariableCS object) {
                return createVariableCSAdapter();
            }
            @Override
            public Adapter casePrePostOrBodyDeclCS(PrePostOrBodyDeclCS object) {
                return createPrePostOrBodyDeclCSAdapter();
            }
            @Override
            public Adapter caseDerValueCS(DerValueCS object) {
                return createDerValueCSAdapter();
            }
            @Override
            public Adapter caseInitValueCS(InitValueCS object) {
                return createInitValueCSAdapter();
            }
            @Override
            public Adapter caseInvCS(InvCS object) {
                return createInvCSAdapter();
            }
            @Override
            public Adapter caseDefCS(DefCS object) {
                return createDefCSAdapter();
            }
            @Override
            public Adapter caseDefExpressionCS(DefExpressionCS object) {
                return createDefExpressionCSAdapter();
            }
            @Override
            public Adapter caseVariableExpCS(VariableExpCS object) {
                return createVariableExpCSAdapter();
            }
            @Override
            public Adapter caseIsMarkedPreCS(IsMarkedPreCS object) {
                return createIsMarkedPreCSAdapter();
            }
            @Override
            public Adapter casePrimitiveTypeCS(PrimitiveTypeCS object) {
                return createPrimitiveTypeCSAdapter();
            }
            @Override
            public Adapter caseTupleTypeCS(TupleTypeCS object) {
                return createTupleTypeCSAdapter();
            }
            @Override
            public Adapter caseCollectionTypeCS(CollectionTypeCS object) {
                return createCollectionTypeCSAdapter();
            }
            @Override
            public Adapter caseLetExpCS(LetExpCS object) {
                return createLetExpCSAdapter();
            }
            @Override
            public Adapter caseIfExpCS(IfExpCS object) {
                return createIfExpCSAdapter();
            }
            @Override
            public Adapter caseMessageExpCS(MessageExpCS object) {
                return createMessageExpCSAdapter();
            }
            @Override
            public Adapter caseOCLMessageArgCS(OCLMessageArgCS object) {
                return createOCLMessageArgCSAdapter();
            }
            @Override
            public Adapter caseLiteralExpCS(LiteralExpCS object) {
                return createLiteralExpCSAdapter();
            }
            @Override
            public Adapter caseEnumLiteralExpCS(EnumLiteralExpCS object) {
                return createEnumLiteralExpCSAdapter();
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
            public Adapter caseTupleLiteralExpCS(TupleLiteralExpCS object) {
                return createTupleLiteralExpCSAdapter();
            }
            @Override
            public Adapter casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object) {
                return createPrimitiveLiteralExpCSAdapter();
            }
            @Override
            public Adapter caseIntegerLiteralExpCS(IntegerLiteralExpCS object) {
                return createIntegerLiteralExpCSAdapter();
            }
            @Override
            public Adapter caseUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS object) {
                return createUnlimitedNaturalLiteralExpCSAdapter();
            }
            @Override
            public Adapter caseRealLiteralExpCS(RealLiteralExpCS object) {
                return createRealLiteralExpCSAdapter();
            }
            @Override
            public Adapter caseStringLiteralExpCS(StringLiteralExpCS object) {
                return createStringLiteralExpCSAdapter();
            }
            @Override
            public Adapter caseBooleanLiteralExpCS(BooleanLiteralExpCS object) {
                return createBooleanLiteralExpCSAdapter();
            }
            @Override
            public Adapter caseNullLiteralExpCS(NullLiteralExpCS object) {
                return createNullLiteralExpCSAdapter();
            }
            @Override
            public Adapter caseInvalidLiteralExpCS(InvalidLiteralExpCS object) {
                return createInvalidLiteralExpCSAdapter();
            }
            @Override
            public Adapter caseCollectionRangeCS(CollectionRangeCS object) {
                return createCollectionRangeCSAdapter();
            }
            @Override
            public Adapter caseCallExpCS(CallExpCS object) {
                return createCallExpCSAdapter();
            }
            @Override
            public Adapter caseLoopExpCS(LoopExpCS object) {
                return createLoopExpCSAdapter();
            }
            @Override
            public Adapter caseIteratorExpCS(IteratorExpCS object) {
                return createIteratorExpCSAdapter();
            }
            @Override
            public Adapter caseIterateExpCS(IterateExpCS object) {
                return createIterateExpCSAdapter();
            }
            @Override
            public Adapter caseFeatureCallExpCS(FeatureCallExpCS object) {
                return createFeatureCallExpCSAdapter();
            }
            @Override
            public Adapter caseOperationCallExpCS(OperationCallExpCS object) {
                return createOperationCallExpCSAdapter();
            }
            @Override
            public Adapter caseStateExpCS(StateExpCS object) {
                return createStateExpCSAdapter();
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
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.CSTNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.CSTNode
     * @generated
     */
	public Adapter createCSTNodeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.PackageDeclarationCS <em>Package Declaration CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.PackageDeclarationCS
     * @generated
     */
	public Adapter createPackageDeclarationCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.ContextDeclCS <em>Context Decl CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.ContextDeclCS
     * @generated
     */
	public Adapter createContextDeclCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.ClassifierContextDeclCS <em>Classifier Context Decl CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.ClassifierContextDeclCS
     * @generated
     */
	public Adapter createClassifierContextDeclCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.OperationContextDeclCS <em>Operation Context Decl CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.OperationContextDeclCS
     * @generated
     */
	public Adapter createOperationContextDeclCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS <em>Pre Post Or Body Decl CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.PrePostOrBodyDeclCS
     * @generated
     */
	public Adapter createPrePostOrBodyDeclCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.OperationCS <em>Operation CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.OperationCS
     * @generated
     */
	public Adapter createOperationCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.InitOrDerValueCS <em>Init Or Der Value CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.InitOrDerValueCS
     * @generated
     */
	public Adapter createInitOrDerValueCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.DerValueCS <em>Der Value CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.DerValueCS
     * @generated
     */
	public Adapter createDerValueCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.InitValueCS <em>Init Value CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.InitValueCS
     * @generated
     */
	public Adapter createInitValueCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.InvOrDefCS <em>Inv Or Def CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.InvOrDefCS
     * @generated
     */
	public Adapter createInvOrDefCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.InvCS <em>Inv CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.InvCS
     * @generated
     */
	public Adapter createInvCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.DefCS <em>Def CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.DefCS
     * @generated
     */
	public Adapter createDefCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.DefExpressionCS <em>Def Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.DefExpressionCS
     * @generated
     */
	public Adapter createDefExpressionCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.PathNameCS <em>Path Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.PathNameCS
     * @generated
     */
	public Adapter createPathNameCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.VariableExpCS <em>Variable Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.VariableExpCS
     * @generated
     */
	public Adapter createVariableExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.SimpleNameCS <em>Simple Name CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.SimpleNameCS
     * @generated
     */
	public Adapter createSimpleNameCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.TypeCS <em>Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.TypeCS
     * @generated
     */
	public Adapter createTypeCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.PrimitiveTypeCS <em>Primitive Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.PrimitiveTypeCS
     * @generated
     */
	public Adapter createPrimitiveTypeCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.TupleTypeCS <em>Tuple Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.TupleTypeCS
     * @generated
     */
	public Adapter createTupleTypeCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.CollectionTypeCS <em>Collection Type CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.CollectionTypeCS
     * @generated
     */
	public Adapter createCollectionTypeCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.OCLExpressionCS <em>OCL Expression CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.OCLExpressionCS
     * @generated
     */
	public Adapter createOCLExpressionCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.LetExpCS <em>Let Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.LetExpCS
     * @generated
     */
	public Adapter createLetExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.IfExpCS <em>If Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.IfExpCS
     * @generated
     */
	public Adapter createIfExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.OCLMessageArgCS <em>OCL Message Arg CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.OCLMessageArgCS
     * @generated
     */
	public Adapter createOCLMessageArgCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.LiteralExpCS <em>Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.LiteralExpCS
     * @generated
     */
	public Adapter createLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.EnumLiteralExpCS <em>Enum Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.EnumLiteralExpCS
     * @generated
     */
	public Adapter createEnumLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.CollectionLiteralExpCS
     * @generated
     */
	public Adapter createCollectionLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.TupleLiteralExpCS <em>Tuple Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.TupleLiteralExpCS
     * @generated
     */
	public Adapter createTupleLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.PrimitiveLiteralExpCS <em>Primitive Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.PrimitiveLiteralExpCS
     * @generated
     */
	public Adapter createPrimitiveLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.IntegerLiteralExpCS <em>Integer Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.IntegerLiteralExpCS
     * @generated
     */
	public Adapter createIntegerLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS <em>Unlimited Natural Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS
     * @generated
     */
    public Adapter createUnlimitedNaturalLiteralExpCSAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.RealLiteralExpCS <em>Real Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.RealLiteralExpCS
     * @generated
     */
	public Adapter createRealLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.StringLiteralExpCS
     * @generated
     */
	public Adapter createStringLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.BooleanLiteralExpCS
     * @generated
     */
	public Adapter createBooleanLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.CollectionLiteralPartCS <em>Collection Literal Part CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.CollectionLiteralPartCS
     * @generated
     */
	public Adapter createCollectionLiteralPartCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.CollectionRangeCS <em>Collection Range CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.CollectionRangeCS
     * @generated
     */
	public Adapter createCollectionRangeCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.LoopExpCS <em>Loop Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.LoopExpCS
     * @generated
     */
	public Adapter createLoopExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.IteratorExpCS <em>Iterator Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.IteratorExpCS
     * @generated
     */
	public Adapter createIteratorExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.IterateExpCS <em>Iterate Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.IterateExpCS
     * @generated
     */
	public Adapter createIterateExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.OperationCallExpCS <em>Operation Call Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.OperationCallExpCS
     * @generated
     */
	public Adapter createOperationCallExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.IsMarkedPreCS <em>Is Marked Pre CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.IsMarkedPreCS
     * @generated
     */
	public Adapter createIsMarkedPreCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.PropertyContextCS <em>Property Context CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.PropertyContextCS
     * @generated
     */
	public Adapter createPropertyContextCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.StateExpCS <em>State Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.StateExpCS
     * @generated
     */
	public Adapter createStateExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.MessageExpCS <em>Message Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.MessageExpCS
     * @generated
     */
	public Adapter createMessageExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.VariableCS <em>Variable CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.VariableCS
     * @generated
     */
	public Adapter createVariableCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.NullLiteralExpCS <em>Null Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.NullLiteralExpCS
     * @generated
     */
	public Adapter createNullLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.InvalidLiteralExpCS <em>Invalid Literal Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.InvalidLiteralExpCS
     * @generated
     */
	public Adapter createInvalidLiteralExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.CallExpCS <em>Call Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.CallExpCS
     * @generated
     */
	public Adapter createCallExpCSAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.FeatureCallExpCS <em>Feature Call Exp CS</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.cst.FeatureCallExpCS
     * @generated
     */
	public Adapter createFeatureCallExpCSAdapter() {
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

} //CSTAdapterFactory
