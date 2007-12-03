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
 * $Id: CSTPackageImpl.java,v 1.2 2007/12/03 18:44:41 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTFactory;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionRangeCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.ContextDeclCS;
import org.eclipse.ocl.cst.DefCS;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.DerValueCS;
import org.eclipse.ocl.cst.DotOrArrowEnum;
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
import org.eclipse.ocl.cst.MessageExpKind;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.OperationContextDeclCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.cst.PrimitiveLiteralExpCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.PropertyContextCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CSTPackageImpl extends EPackageImpl implements CSTPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass cstNodeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass packageDeclarationCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass contextDeclCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass classifierContextDeclCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass operationContextDeclCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass prePostOrBodyDeclCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass operationCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass initOrDerValueCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass derValueCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass initValueCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass invOrDefCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass invCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass defCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass defExpressionCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass pathNameCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass variableExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass simpleNameCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typeCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass primitiveTypeCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass tupleTypeCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass collectionTypeCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass oclExpressionCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass letExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass ifExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass oclMessageArgCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass literalExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass enumLiteralExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass collectionLiteralExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass tupleLiteralExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass primitiveLiteralExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass integerLiteralExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass unlimitedNaturalLiteralExpCSEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass realLiteralExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass stringLiteralExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass booleanLiteralExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass collectionLiteralPartCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass collectionRangeCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass loopExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass iteratorExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass iterateExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass operationCallExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass isMarkedPreCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass propertyContextCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass stateExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass messageExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass variableCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass nullLiteralExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass invalidLiteralExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass callExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass featureCallExpCSEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum prePostOrBodyEnumEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum simpleTypeEnumEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum collectionTypeIdentifierEnumEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum dotOrArrowEnumEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum messageExpKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.internal.cst.CSTPackage#eNS_URI
	 * @see #init()
	 */
	private CSTPackageImpl() {
		super(eNS_URI, CSTFactory.eINSTANCE);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static CSTPackage init() {
        if (isInited) return (CSTPackage)EPackage.Registry.INSTANCE.getEPackage(CSTPackage.eNS_URI);

        // Obtain or create and register package
        CSTPackageImpl theCSTPackage = (CSTPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof CSTPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new CSTPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theCSTPackage.createPackageContents();

        // Initialize created meta-data
        theCSTPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theCSTPackage.freeze();

        return theCSTPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCSTNode() {
        return cstNodeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCSTNode_StartOffset() {
        return (EAttribute)cstNodeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCSTNode_EndOffset() {
        return (EAttribute)cstNodeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPackageDeclarationCS() {
        return packageDeclarationCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPackageDeclarationCS_PathNameCS() {
        return (EReference)packageDeclarationCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPackageDeclarationCS_ContextDecls() {
        return (EReference)packageDeclarationCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPackageDeclarationCS_PackageDeclarationCS() {
        return (EReference)packageDeclarationCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getContextDeclCS() {
        return contextDeclCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getClassifierContextDeclCS() {
        return classifierContextDeclCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getClassifierContextDeclCS_PathNameCS() {
        return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getClassifierContextDeclCS_InvOrDefCS() {
        return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOperationContextDeclCS() {
        return operationContextDeclCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperationContextDeclCS_OperationCS() {
        return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperationContextDeclCS_PrePostOrBodyDecls() {
        return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPrePostOrBodyDeclCS() {
        return prePostOrBodyDeclCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPrePostOrBodyDeclCS_Kind() {
        return (EAttribute)prePostOrBodyDeclCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPrePostOrBodyDeclCS_SimpleNameCS() {
        return (EReference)prePostOrBodyDeclCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPrePostOrBodyDeclCS_ExpressionCS() {
        return (EReference)prePostOrBodyDeclCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOperationCS() {
        return operationCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperationCS_PathNameCS() {
        return (EReference)operationCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperationCS_SimpleNameCS() {
        return (EReference)operationCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperationCS_Parameters() {
        return (EReference)operationCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperationCS_TypeCS() {
        return (EReference)operationCSEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getInitOrDerValueCS() {
        return initOrDerValueCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getInitOrDerValueCS_InitOrDerValueCS() {
        return (EReference)initOrDerValueCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getInitOrDerValueCS_ExpressionCS() {
        return (EReference)initOrDerValueCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDerValueCS() {
        return derValueCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getInitValueCS() {
        return initValueCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getInvOrDefCS() {
        return invOrDefCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getInvOrDefCS_SimpleNameCS() {
        return (EReference)invOrDefCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getInvOrDefCS_InvOrDefCS() {
        return (EReference)invOrDefCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getInvCS() {
        return invCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getInvCS_ExpressionCS() {
        return (EReference)invCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDefCS() {
        return defCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDefCS_DefExpressionCS() {
        return (EReference)defCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDefExpressionCS() {
        return defExpressionCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDefExpressionCS_OperationCS() {
        return (EReference)defExpressionCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDefExpressionCS_VariableCS() {
        return (EReference)defExpressionCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDefExpressionCS_ExpressionCS() {
        return (EReference)defExpressionCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPathNameCS() {
        return pathNameCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPathNameCS_SequenceOfNames() {
        return (EAttribute)pathNameCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getVariableExpCS() {
        return variableExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getVariableExpCS_Arguments() {
        return (EReference)variableExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getVariableExpCS_SimpleNameCS() {
        return (EReference)variableExpCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getVariableExpCS_IsMarkedPreCS() {
        return (EReference)variableExpCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSimpleNameCS() {
        return simpleNameCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSimpleNameCS_Value() {
        return (EAttribute)simpleNameCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSimpleNameCS_Type() {
        return (EAttribute)simpleNameCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTypeCS() {
        return typeCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPrimitiveTypeCS() {
        return primitiveTypeCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTupleTypeCS() {
        return tupleTypeCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTupleTypeCS_Variables() {
        return (EReference)tupleTypeCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCollectionTypeCS() {
        return collectionTypeCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCollectionTypeCS_CollectionTypeIdentifier() {
        return (EAttribute)collectionTypeCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCollectionTypeCS_TypeCS() {
        return (EReference)collectionTypeCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOCLExpressionCS() {
        return oclExpressionCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLetExpCS() {
        return letExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLetExpCS_Variables() {
        return (EReference)letExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLetExpCS_InExpression() {
        return (EReference)letExpCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIfExpCS() {
        return ifExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getIfExpCS_ThenExpression() {
        return (EReference)ifExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getIfExpCS_ElseExpression() {
        return (EReference)ifExpCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getIfExpCS_Condition() {
        return (EReference)ifExpCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOCLMessageArgCS() {
        return oclMessageArgCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOCLMessageArgCS_TypeCS() {
        return (EReference)oclMessageArgCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOCLMessageArgCS_Expression() {
        return (EReference)oclMessageArgCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLiteralExpCS() {
        return literalExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEnumLiteralExpCS() {
        return enumLiteralExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEnumLiteralExpCS_PathNameCS() {
        return (EReference)enumLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEnumLiteralExpCS_SimpleNameCS() {
        return (EReference)enumLiteralExpCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCollectionLiteralExpCS() {
        return collectionLiteralExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCollectionLiteralExpCS_CollectionType() {
        return (EAttribute)collectionLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCollectionLiteralExpCS_CollectionLiteralParts() {
        return (EReference)collectionLiteralExpCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTupleLiteralExpCS() {
        return tupleLiteralExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTupleLiteralExpCS_Variables() {
        return (EReference)tupleLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPrimitiveLiteralExpCS() {
        return primitiveLiteralExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPrimitiveLiteralExpCS_Symbol() {
        return (EAttribute)primitiveLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIntegerLiteralExpCS() {
        return integerLiteralExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getIntegerLiteralExpCS_IntegerSymbol() {
        return (EAttribute)integerLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUnlimitedNaturalLiteralExpCS() {
        return unlimitedNaturalLiteralExpCSEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUnlimitedNaturalLiteralExpCS_IntegerSymbol() {
        return (EAttribute)unlimitedNaturalLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRealLiteralExpCS() {
        return realLiteralExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRealLiteralExpCS_RealSymbol() {
        return (EAttribute)realLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getStringLiteralExpCS() {
        return stringLiteralExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getStringLiteralExpCS_StringSymbol() {
        return (EAttribute)stringLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getBooleanLiteralExpCS() {
        return booleanLiteralExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getBooleanLiteralExpCS_BooleanSymbol() {
        return (EAttribute)booleanLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCollectionLiteralPartCS() {
        return collectionLiteralPartCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCollectionLiteralPartCS_ExpressionCS() {
        return (EReference)collectionLiteralPartCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCollectionRangeCS() {
        return collectionRangeCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCollectionRangeCS_LastExpressionCS() {
        return (EReference)collectionRangeCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLoopExpCS() {
        return loopExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLoopExpCS_Variable1() {
        return (EReference)loopExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLoopExpCS_Variable2() {
        return (EReference)loopExpCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLoopExpCS_Body() {
        return (EReference)loopExpCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIteratorExpCS() {
        return iteratorExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIterateExpCS() {
        return iterateExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOperationCallExpCS() {
        return operationCallExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIsMarkedPreCS() {
        return isMarkedPreCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getIsMarkedPreCS_Pre() {
        return (EAttribute)isMarkedPreCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPropertyContextCS() {
        return propertyContextCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyContextCS_PathNameCS() {
        return (EReference)propertyContextCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyContextCS_SimpleNameCS() {
        return (EReference)propertyContextCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyContextCS_TypeCS() {
        return (EReference)propertyContextCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyContextCS_InitOrDerValueCS() {
        return (EReference)propertyContextCSEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getStateExpCS() {
        return stateExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getStateExpCS_SequenceOfNames() {
        return (EAttribute)stateExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMessageExpCS() {
        return messageExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMessageExpCS_Target() {
        return (EReference)messageExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMessageExpCS_Kind() {
        return (EAttribute)messageExpCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMessageExpCS_SimpleNameCS() {
        return (EReference)messageExpCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMessageExpCS_Arguments() {
        return (EReference)messageExpCSEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getVariableCS() {
        return variableCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getVariableCS_Name() {
        return (EAttribute)variableCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getVariableCS_TypeCS() {
        return (EReference)variableCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getVariableCS_InitExpression() {
        return (EReference)variableCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNullLiteralExpCS() {
        return nullLiteralExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNullLiteralExpCS_Symbol() {
        return (EAttribute)nullLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getInvalidLiteralExpCS() {
        return invalidLiteralExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getInvalidLiteralExpCS_Symbol() {
        return (EAttribute)invalidLiteralExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCallExpCS() {
        return callExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCallExpCS_Source() {
        return (EReference)callExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCallExpCS_Accessor() {
        return (EAttribute)callExpCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCallExpCS_SimpleNameCS() {
        return (EReference)callExpCSEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFeatureCallExpCS() {
        return featureCallExpCSEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFeatureCallExpCS_Arguments() {
        return (EReference)featureCallExpCSEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFeatureCallExpCS_IsMarkedPreCS() {
        return (EReference)featureCallExpCSEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getPrePostOrBodyEnum() {
        return prePostOrBodyEnumEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getSimpleTypeEnum() {
        return simpleTypeEnumEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getCollectionTypeIdentifierEnum() {
        return collectionTypeIdentifierEnumEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getDotOrArrowEnum() {
        return dotOrArrowEnumEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getMessageExpKind() {
        return messageExpKindEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CSTFactory getCSTFactory() {
        return (CSTFactory)getEFactoryInstance();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

	/**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        cstNodeEClass = createEClass(CST_NODE);
        createEAttribute(cstNodeEClass, CST_NODE__START_OFFSET);
        createEAttribute(cstNodeEClass, CST_NODE__END_OFFSET);

        packageDeclarationCSEClass = createEClass(PACKAGE_DECLARATION_CS);
        createEReference(packageDeclarationCSEClass, PACKAGE_DECLARATION_CS__PATH_NAME_CS);
        createEReference(packageDeclarationCSEClass, PACKAGE_DECLARATION_CS__CONTEXT_DECLS);
        createEReference(packageDeclarationCSEClass, PACKAGE_DECLARATION_CS__PACKAGE_DECLARATION_CS);

        pathNameCSEClass = createEClass(PATH_NAME_CS);
        createEAttribute(pathNameCSEClass, PATH_NAME_CS__SEQUENCE_OF_NAMES);

        typeCSEClass = createEClass(TYPE_CS);

        oclExpressionCSEClass = createEClass(OCL_EXPRESSION_CS);

        contextDeclCSEClass = createEClass(CONTEXT_DECL_CS);

        propertyContextCSEClass = createEClass(PROPERTY_CONTEXT_CS);
        createEReference(propertyContextCSEClass, PROPERTY_CONTEXT_CS__PATH_NAME_CS);
        createEReference(propertyContextCSEClass, PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS);
        createEReference(propertyContextCSEClass, PROPERTY_CONTEXT_CS__TYPE_CS);
        createEReference(propertyContextCSEClass, PROPERTY_CONTEXT_CS__INIT_OR_DER_VALUE_CS);

        simpleNameCSEClass = createEClass(SIMPLE_NAME_CS);
        createEAttribute(simpleNameCSEClass, SIMPLE_NAME_CS__VALUE);
        createEAttribute(simpleNameCSEClass, SIMPLE_NAME_CS__TYPE);

        initOrDerValueCSEClass = createEClass(INIT_OR_DER_VALUE_CS);
        createEReference(initOrDerValueCSEClass, INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS);
        createEReference(initOrDerValueCSEClass, INIT_OR_DER_VALUE_CS__EXPRESSION_CS);

        classifierContextDeclCSEClass = createEClass(CLASSIFIER_CONTEXT_DECL_CS);
        createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS);
        createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS);

        invOrDefCSEClass = createEClass(INV_OR_DEF_CS);
        createEReference(invOrDefCSEClass, INV_OR_DEF_CS__SIMPLE_NAME_CS);
        createEReference(invOrDefCSEClass, INV_OR_DEF_CS__INV_OR_DEF_CS);

        operationContextDeclCSEClass = createEClass(OPERATION_CONTEXT_DECL_CS);
        createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__OPERATION_CS);
        createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS);

        operationCSEClass = createEClass(OPERATION_CS);
        createEReference(operationCSEClass, OPERATION_CS__PATH_NAME_CS);
        createEReference(operationCSEClass, OPERATION_CS__SIMPLE_NAME_CS);
        createEReference(operationCSEClass, OPERATION_CS__PARAMETERS);
        createEReference(operationCSEClass, OPERATION_CS__TYPE_CS);

        variableCSEClass = createEClass(VARIABLE_CS);
        createEAttribute(variableCSEClass, VARIABLE_CS__NAME);
        createEReference(variableCSEClass, VARIABLE_CS__TYPE_CS);
        createEReference(variableCSEClass, VARIABLE_CS__INIT_EXPRESSION);

        prePostOrBodyDeclCSEClass = createEClass(PRE_POST_OR_BODY_DECL_CS);
        createEAttribute(prePostOrBodyDeclCSEClass, PRE_POST_OR_BODY_DECL_CS__KIND);
        createEReference(prePostOrBodyDeclCSEClass, PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS);
        createEReference(prePostOrBodyDeclCSEClass, PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS);

        derValueCSEClass = createEClass(DER_VALUE_CS);

        initValueCSEClass = createEClass(INIT_VALUE_CS);

        invCSEClass = createEClass(INV_CS);
        createEReference(invCSEClass, INV_CS__EXPRESSION_CS);

        defCSEClass = createEClass(DEF_CS);
        createEReference(defCSEClass, DEF_CS__DEF_EXPRESSION_CS);

        defExpressionCSEClass = createEClass(DEF_EXPRESSION_CS);
        createEReference(defExpressionCSEClass, DEF_EXPRESSION_CS__OPERATION_CS);
        createEReference(defExpressionCSEClass, DEF_EXPRESSION_CS__VARIABLE_CS);
        createEReference(defExpressionCSEClass, DEF_EXPRESSION_CS__EXPRESSION_CS);

        variableExpCSEClass = createEClass(VARIABLE_EXP_CS);
        createEReference(variableExpCSEClass, VARIABLE_EXP_CS__ARGUMENTS);
        createEReference(variableExpCSEClass, VARIABLE_EXP_CS__SIMPLE_NAME_CS);
        createEReference(variableExpCSEClass, VARIABLE_EXP_CS__IS_MARKED_PRE_CS);

        isMarkedPreCSEClass = createEClass(IS_MARKED_PRE_CS);
        createEAttribute(isMarkedPreCSEClass, IS_MARKED_PRE_CS__PRE);

        primitiveTypeCSEClass = createEClass(PRIMITIVE_TYPE_CS);

        tupleTypeCSEClass = createEClass(TUPLE_TYPE_CS);
        createEReference(tupleTypeCSEClass, TUPLE_TYPE_CS__VARIABLES);

        collectionTypeCSEClass = createEClass(COLLECTION_TYPE_CS);
        createEAttribute(collectionTypeCSEClass, COLLECTION_TYPE_CS__COLLECTION_TYPE_IDENTIFIER);
        createEReference(collectionTypeCSEClass, COLLECTION_TYPE_CS__TYPE_CS);

        letExpCSEClass = createEClass(LET_EXP_CS);
        createEReference(letExpCSEClass, LET_EXP_CS__VARIABLES);
        createEReference(letExpCSEClass, LET_EXP_CS__IN_EXPRESSION);

        ifExpCSEClass = createEClass(IF_EXP_CS);
        createEReference(ifExpCSEClass, IF_EXP_CS__THEN_EXPRESSION);
        createEReference(ifExpCSEClass, IF_EXP_CS__ELSE_EXPRESSION);
        createEReference(ifExpCSEClass, IF_EXP_CS__CONDITION);

        messageExpCSEClass = createEClass(MESSAGE_EXP_CS);
        createEReference(messageExpCSEClass, MESSAGE_EXP_CS__TARGET);
        createEAttribute(messageExpCSEClass, MESSAGE_EXP_CS__KIND);
        createEReference(messageExpCSEClass, MESSAGE_EXP_CS__SIMPLE_NAME_CS);
        createEReference(messageExpCSEClass, MESSAGE_EXP_CS__ARGUMENTS);

        oclMessageArgCSEClass = createEClass(OCL_MESSAGE_ARG_CS);
        createEReference(oclMessageArgCSEClass, OCL_MESSAGE_ARG_CS__TYPE_CS);
        createEReference(oclMessageArgCSEClass, OCL_MESSAGE_ARG_CS__EXPRESSION);

        literalExpCSEClass = createEClass(LITERAL_EXP_CS);

        enumLiteralExpCSEClass = createEClass(ENUM_LITERAL_EXP_CS);
        createEReference(enumLiteralExpCSEClass, ENUM_LITERAL_EXP_CS__PATH_NAME_CS);
        createEReference(enumLiteralExpCSEClass, ENUM_LITERAL_EXP_CS__SIMPLE_NAME_CS);

        collectionLiteralExpCSEClass = createEClass(COLLECTION_LITERAL_EXP_CS);
        createEAttribute(collectionLiteralExpCSEClass, COLLECTION_LITERAL_EXP_CS__COLLECTION_TYPE);
        createEReference(collectionLiteralExpCSEClass, COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS);

        collectionLiteralPartCSEClass = createEClass(COLLECTION_LITERAL_PART_CS);
        createEReference(collectionLiteralPartCSEClass, COLLECTION_LITERAL_PART_CS__EXPRESSION_CS);

        tupleLiteralExpCSEClass = createEClass(TUPLE_LITERAL_EXP_CS);
        createEReference(tupleLiteralExpCSEClass, TUPLE_LITERAL_EXP_CS__VARIABLES);

        primitiveLiteralExpCSEClass = createEClass(PRIMITIVE_LITERAL_EXP_CS);
        createEAttribute(primitiveLiteralExpCSEClass, PRIMITIVE_LITERAL_EXP_CS__SYMBOL);

        integerLiteralExpCSEClass = createEClass(INTEGER_LITERAL_EXP_CS);
        createEAttribute(integerLiteralExpCSEClass, INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL);

        unlimitedNaturalLiteralExpCSEClass = createEClass(UNLIMITED_NATURAL_LITERAL_EXP_CS);
        createEAttribute(unlimitedNaturalLiteralExpCSEClass, UNLIMITED_NATURAL_LITERAL_EXP_CS__INTEGER_SYMBOL);

        realLiteralExpCSEClass = createEClass(REAL_LITERAL_EXP_CS);
        createEAttribute(realLiteralExpCSEClass, REAL_LITERAL_EXP_CS__REAL_SYMBOL);

        stringLiteralExpCSEClass = createEClass(STRING_LITERAL_EXP_CS);
        createEAttribute(stringLiteralExpCSEClass, STRING_LITERAL_EXP_CS__STRING_SYMBOL);

        booleanLiteralExpCSEClass = createEClass(BOOLEAN_LITERAL_EXP_CS);
        createEAttribute(booleanLiteralExpCSEClass, BOOLEAN_LITERAL_EXP_CS__BOOLEAN_SYMBOL);

        nullLiteralExpCSEClass = createEClass(NULL_LITERAL_EXP_CS);
        createEAttribute(nullLiteralExpCSEClass, NULL_LITERAL_EXP_CS__SYMBOL);

        invalidLiteralExpCSEClass = createEClass(INVALID_LITERAL_EXP_CS);
        createEAttribute(invalidLiteralExpCSEClass, INVALID_LITERAL_EXP_CS__SYMBOL);

        collectionRangeCSEClass = createEClass(COLLECTION_RANGE_CS);
        createEReference(collectionRangeCSEClass, COLLECTION_RANGE_CS__LAST_EXPRESSION_CS);

        callExpCSEClass = createEClass(CALL_EXP_CS);
        createEReference(callExpCSEClass, CALL_EXP_CS__SOURCE);
        createEAttribute(callExpCSEClass, CALL_EXP_CS__ACCESSOR);
        createEReference(callExpCSEClass, CALL_EXP_CS__SIMPLE_NAME_CS);

        loopExpCSEClass = createEClass(LOOP_EXP_CS);
        createEReference(loopExpCSEClass, LOOP_EXP_CS__VARIABLE1);
        createEReference(loopExpCSEClass, LOOP_EXP_CS__VARIABLE2);
        createEReference(loopExpCSEClass, LOOP_EXP_CS__BODY);

        iteratorExpCSEClass = createEClass(ITERATOR_EXP_CS);

        iterateExpCSEClass = createEClass(ITERATE_EXP_CS);

        featureCallExpCSEClass = createEClass(FEATURE_CALL_EXP_CS);
        createEReference(featureCallExpCSEClass, FEATURE_CALL_EXP_CS__ARGUMENTS);
        createEReference(featureCallExpCSEClass, FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS);

        operationCallExpCSEClass = createEClass(OPERATION_CALL_EXP_CS);

        stateExpCSEClass = createEClass(STATE_EXP_CS);
        createEAttribute(stateExpCSEClass, STATE_EXP_CS__SEQUENCE_OF_NAMES);

        // Create enums
        simpleTypeEnumEEnum = createEEnum(SIMPLE_TYPE_ENUM);
        prePostOrBodyEnumEEnum = createEEnum(PRE_POST_OR_BODY_ENUM);
        collectionTypeIdentifierEnumEEnum = createEEnum(COLLECTION_TYPE_IDENTIFIER_ENUM);
        messageExpKindEEnum = createEEnum(MESSAGE_EXP_KIND);
        dotOrArrowEnumEEnum = createEEnum(DOT_OR_ARROW_ENUM);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

	/**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        packageDeclarationCSEClass.getESuperTypes().add(this.getCSTNode());
        pathNameCSEClass.getESuperTypes().add(this.getTypeCS());
        typeCSEClass.getESuperTypes().add(this.getOCLExpressionCS());
        oclExpressionCSEClass.getESuperTypes().add(this.getCSTNode());
        contextDeclCSEClass.getESuperTypes().add(this.getCSTNode());
        propertyContextCSEClass.getESuperTypes().add(this.getContextDeclCS());
        simpleNameCSEClass.getESuperTypes().add(this.getOCLExpressionCS());
        initOrDerValueCSEClass.getESuperTypes().add(this.getCSTNode());
        classifierContextDeclCSEClass.getESuperTypes().add(this.getContextDeclCS());
        invOrDefCSEClass.getESuperTypes().add(this.getCSTNode());
        operationContextDeclCSEClass.getESuperTypes().add(this.getContextDeclCS());
        operationCSEClass.getESuperTypes().add(this.getCSTNode());
        variableCSEClass.getESuperTypes().add(this.getCSTNode());
        prePostOrBodyDeclCSEClass.getESuperTypes().add(this.getCSTNode());
        derValueCSEClass.getESuperTypes().add(this.getInitOrDerValueCS());
        initValueCSEClass.getESuperTypes().add(this.getInitOrDerValueCS());
        invCSEClass.getESuperTypes().add(this.getInvOrDefCS());
        defCSEClass.getESuperTypes().add(this.getInvOrDefCS());
        defExpressionCSEClass.getESuperTypes().add(this.getCSTNode());
        variableExpCSEClass.getESuperTypes().add(this.getOCLExpressionCS());
        isMarkedPreCSEClass.getESuperTypes().add(this.getCSTNode());
        primitiveTypeCSEClass.getESuperTypes().add(this.getSimpleNameCS());
        primitiveTypeCSEClass.getESuperTypes().add(this.getTypeCS());
        tupleTypeCSEClass.getESuperTypes().add(this.getTypeCS());
        collectionTypeCSEClass.getESuperTypes().add(this.getTypeCS());
        letExpCSEClass.getESuperTypes().add(this.getOCLExpressionCS());
        ifExpCSEClass.getESuperTypes().add(this.getOCLExpressionCS());
        messageExpCSEClass.getESuperTypes().add(this.getOCLExpressionCS());
        oclMessageArgCSEClass.getESuperTypes().add(this.getCSTNode());
        literalExpCSEClass.getESuperTypes().add(this.getOCLExpressionCS());
        enumLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
        collectionLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
        collectionLiteralPartCSEClass.getESuperTypes().add(this.getCSTNode());
        tupleLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
        primitiveLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
        integerLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
        unlimitedNaturalLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
        realLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
        stringLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
        booleanLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
        nullLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
        invalidLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
        collectionRangeCSEClass.getESuperTypes().add(this.getCollectionLiteralPartCS());
        callExpCSEClass.getESuperTypes().add(this.getOCLExpressionCS());
        loopExpCSEClass.getESuperTypes().add(this.getCallExpCS());
        iteratorExpCSEClass.getESuperTypes().add(this.getLoopExpCS());
        iterateExpCSEClass.getESuperTypes().add(this.getLoopExpCS());
        featureCallExpCSEClass.getESuperTypes().add(this.getCallExpCS());
        operationCallExpCSEClass.getESuperTypes().add(this.getFeatureCallExpCS());
        stateExpCSEClass.getESuperTypes().add(this.getTypeCS());

        // Initialize classes and features; add operations and parameters
        initEClass(cstNodeEClass, CSTNode.class, "CSTNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getCSTNode_StartOffset(), ecorePackage.getEInt(), "startOffset", null, 0, 1, CSTNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getCSTNode_EndOffset(), ecorePackage.getEInt(), "endOffset", null, 0, 1, CSTNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(packageDeclarationCSEClass, PackageDeclarationCS.class, "PackageDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPackageDeclarationCS_PathNameCS(), this.getPathNameCS(), null, "pathNameCS", null, 0, 1, PackageDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPackageDeclarationCS_ContextDecls(), this.getContextDeclCS(), null, "contextDecls", null, 0, -1, PackageDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPackageDeclarationCS_PackageDeclarationCS(), this.getPackageDeclarationCS(), null, "packageDeclarationCS", null, 0, 1, PackageDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(pathNameCSEClass, PathNameCS.class, "PathNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPathNameCS_SequenceOfNames(), ecorePackage.getEString(), "sequenceOfNames", null, 0, -1, PathNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeCSEClass, TypeCS.class, "TypeCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(oclExpressionCSEClass, OCLExpressionCS.class, "OCLExpressionCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(contextDeclCSEClass, ContextDeclCS.class, "ContextDeclCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(propertyContextCSEClass, PropertyContextCS.class, "PropertyContextCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getPropertyContextCS_PathNameCS(), this.getPathNameCS(), null, "pathNameCS", null, 0, 1, PropertyContextCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPropertyContextCS_SimpleNameCS(), this.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, PropertyContextCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPropertyContextCS_TypeCS(), this.getTypeCS(), null, "typeCS", null, 0, 1, PropertyContextCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPropertyContextCS_InitOrDerValueCS(), this.getInitOrDerValueCS(), null, "initOrDerValueCS", null, 0, 1, PropertyContextCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(simpleNameCSEClass, SimpleNameCS.class, "SimpleNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getSimpleNameCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, SimpleNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getSimpleNameCS_Type(), this.getSimpleTypeEnum(), "type", null, 0, 1, SimpleNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(initOrDerValueCSEClass, InitOrDerValueCS.class, "InitOrDerValueCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getInitOrDerValueCS_InitOrDerValueCS(), this.getInitOrDerValueCS(), null, "initOrDerValueCS", null, 0, 1, InitOrDerValueCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getInitOrDerValueCS_ExpressionCS(), this.getOCLExpressionCS(), null, "expressionCS", null, 0, 1, InitOrDerValueCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(classifierContextDeclCSEClass, ClassifierContextDeclCS.class, "ClassifierContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getClassifierContextDeclCS_PathNameCS(), this.getPathNameCS(), null, "pathNameCS", null, 0, 1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getClassifierContextDeclCS_InvOrDefCS(), this.getInvOrDefCS(), null, "invOrDefCS", null, 0, 1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(invOrDefCSEClass, InvOrDefCS.class, "InvOrDefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getInvOrDefCS_SimpleNameCS(), this.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, InvOrDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getInvOrDefCS_InvOrDefCS(), this.getInvOrDefCS(), null, "invOrDefCS", null, 0, 1, InvOrDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(operationContextDeclCSEClass, OperationContextDeclCS.class, "OperationContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getOperationContextDeclCS_OperationCS(), this.getOperationCS(), null, "operationCS", null, 0, 1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOperationContextDeclCS_PrePostOrBodyDecls(), this.getPrePostOrBodyDeclCS(), null, "prePostOrBodyDecls", null, 1, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(operationCSEClass, OperationCS.class, "OperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getOperationCS_PathNameCS(), this.getPathNameCS(), null, "pathNameCS", null, 0, 1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOperationCS_SimpleNameCS(), this.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOperationCS_Parameters(), this.getVariableCS(), null, "parameters", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOperationCS_TypeCS(), this.getTypeCS(), null, "typeCS", null, 0, 1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(variableCSEClass, VariableCS.class, "VariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getVariableCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getVariableCS_TypeCS(), this.getTypeCS(), null, "typeCS", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getVariableCS_InitExpression(), this.getOCLExpressionCS(), null, "initExpression", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(prePostOrBodyDeclCSEClass, PrePostOrBodyDeclCS.class, "PrePostOrBodyDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPrePostOrBodyDeclCS_Kind(), this.getPrePostOrBodyEnum(), "kind", null, 0, 1, PrePostOrBodyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPrePostOrBodyDeclCS_SimpleNameCS(), this.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, PrePostOrBodyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getPrePostOrBodyDeclCS_ExpressionCS(), this.getOCLExpressionCS(), null, "expressionCS", null, 0, 1, PrePostOrBodyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(derValueCSEClass, DerValueCS.class, "DerValueCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(initValueCSEClass, InitValueCS.class, "InitValueCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(invCSEClass, InvCS.class, "InvCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getInvCS_ExpressionCS(), this.getOCLExpressionCS(), null, "expressionCS", null, 0, 1, InvCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(defCSEClass, DefCS.class, "DefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getDefCS_DefExpressionCS(), this.getDefExpressionCS(), null, "defExpressionCS", null, 0, 1, DefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(defExpressionCSEClass, DefExpressionCS.class, "DefExpressionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getDefExpressionCS_OperationCS(), this.getOperationCS(), null, "operationCS", null, 0, 1, DefExpressionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getDefExpressionCS_VariableCS(), this.getVariableCS(), null, "variableCS", null, 0, 1, DefExpressionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getDefExpressionCS_ExpressionCS(), this.getOCLExpressionCS(), null, "expressionCS", null, 0, 1, DefExpressionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(variableExpCSEClass, VariableExpCS.class, "VariableExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getVariableExpCS_Arguments(), this.getOCLExpressionCS(), null, "arguments", null, 0, -1, VariableExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getVariableExpCS_SimpleNameCS(), this.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, VariableExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getVariableExpCS_IsMarkedPreCS(), this.getIsMarkedPreCS(), null, "isMarkedPreCS", null, 0, 1, VariableExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(isMarkedPreCSEClass, IsMarkedPreCS.class, "IsMarkedPreCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getIsMarkedPreCS_Pre(), ecorePackage.getEBoolean(), "pre", null, 0, 1, IsMarkedPreCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(primitiveTypeCSEClass, PrimitiveTypeCS.class, "PrimitiveTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(tupleTypeCSEClass, TupleTypeCS.class, "TupleTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTupleTypeCS_Variables(), this.getVariableCS(), null, "variables", null, 1, -1, TupleTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(collectionTypeCSEClass, CollectionTypeCS.class, "CollectionTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getCollectionTypeCS_CollectionTypeIdentifier(), this.getCollectionTypeIdentifierEnum(), "collectionTypeIdentifier", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getCollectionTypeCS_TypeCS(), this.getTypeCS(), null, "typeCS", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(letExpCSEClass, LetExpCS.class, "LetExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getLetExpCS_Variables(), this.getVariableCS(), null, "variables", null, 1, -1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getLetExpCS_InExpression(), this.getOCLExpressionCS(), null, "inExpression", null, 0, 1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(ifExpCSEClass, IfExpCS.class, "IfExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getIfExpCS_ThenExpression(), this.getOCLExpressionCS(), null, "thenExpression", null, 1, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getIfExpCS_ElseExpression(), this.getOCLExpressionCS(), null, "elseExpression", null, 1, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getIfExpCS_Condition(), this.getOCLExpressionCS(), null, "condition", null, 1, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(messageExpCSEClass, MessageExpCS.class, "MessageExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMessageExpCS_Target(), this.getOCLExpressionCS(), null, "target", null, 0, 1, MessageExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getMessageExpCS_Kind(), this.getMessageExpKind(), "kind", null, 0, 1, MessageExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMessageExpCS_SimpleNameCS(), this.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, MessageExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMessageExpCS_Arguments(), this.getOCLMessageArgCS(), null, "arguments", null, 0, -1, MessageExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(oclMessageArgCSEClass, OCLMessageArgCS.class, "OCLMessageArgCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getOCLMessageArgCS_TypeCS(), this.getTypeCS(), null, "typeCS", null, 0, 1, OCLMessageArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getOCLMessageArgCS_Expression(), this.getOCLExpressionCS(), null, "expression", null, 0, 1, OCLMessageArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(literalExpCSEClass, LiteralExpCS.class, "LiteralExpCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(enumLiteralExpCSEClass, EnumLiteralExpCS.class, "EnumLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getEnumLiteralExpCS_PathNameCS(), this.getPathNameCS(), null, "pathNameCS", null, 0, 1, EnumLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getEnumLiteralExpCS_SimpleNameCS(), this.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, EnumLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(collectionLiteralExpCSEClass, CollectionLiteralExpCS.class, "CollectionLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getCollectionLiteralExpCS_CollectionType(), this.getCollectionTypeIdentifierEnum(), "collectionType", null, 0, 1, CollectionLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getCollectionLiteralExpCS_CollectionLiteralParts(), this.getCollectionLiteralPartCS(), null, "collectionLiteralParts", null, 0, -1, CollectionLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(collectionLiteralPartCSEClass, CollectionLiteralPartCS.class, "CollectionLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getCollectionLiteralPartCS_ExpressionCS(), this.getOCLExpressionCS(), null, "expressionCS", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(tupleLiteralExpCSEClass, TupleLiteralExpCS.class, "TupleLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTupleLiteralExpCS_Variables(), this.getVariableCS(), null, "variables", null, 0, -1, TupleLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(primitiveLiteralExpCSEClass, PrimitiveLiteralExpCS.class, "PrimitiveLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getPrimitiveLiteralExpCS_Symbol(), ecorePackage.getEString(), "symbol", null, 0, 1, PrimitiveLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(integerLiteralExpCSEClass, IntegerLiteralExpCS.class, "IntegerLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getIntegerLiteralExpCS_IntegerSymbol(), ecorePackage.getEIntegerObject(), "integerSymbol", null, 0, 1, IntegerLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(unlimitedNaturalLiteralExpCSEClass, UnlimitedNaturalLiteralExpCS.class, "UnlimitedNaturalLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getUnlimitedNaturalLiteralExpCS_IntegerSymbol(), ecorePackage.getEIntegerObject(), "integerSymbol", null, 0, 1, UnlimitedNaturalLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(realLiteralExpCSEClass, RealLiteralExpCS.class, "RealLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getRealLiteralExpCS_RealSymbol(), ecorePackage.getEDoubleObject(), "realSymbol", null, 0, 1, RealLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(stringLiteralExpCSEClass, StringLiteralExpCS.class, "StringLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getStringLiteralExpCS_StringSymbol(), ecorePackage.getEString(), "stringSymbol", null, 0, 1, StringLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(booleanLiteralExpCSEClass, BooleanLiteralExpCS.class, "BooleanLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getBooleanLiteralExpCS_BooleanSymbol(), ecorePackage.getEBooleanObject(), "booleanSymbol", null, 0, 1, BooleanLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(nullLiteralExpCSEClass, NullLiteralExpCS.class, "NullLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getNullLiteralExpCS_Symbol(), ecorePackage.getEString(), "symbol", null, 0, 1, NullLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(invalidLiteralExpCSEClass, InvalidLiteralExpCS.class, "InvalidLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getInvalidLiteralExpCS_Symbol(), ecorePackage.getEString(), "symbol", null, 0, 1, InvalidLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(collectionRangeCSEClass, CollectionRangeCS.class, "CollectionRangeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getCollectionRangeCS_LastExpressionCS(), this.getOCLExpressionCS(), null, "lastExpressionCS", null, 0, 1, CollectionRangeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(callExpCSEClass, CallExpCS.class, "CallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getCallExpCS_Source(), this.getOCLExpressionCS(), null, "source", null, 0, 1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getCallExpCS_Accessor(), this.getDotOrArrowEnum(), "accessor", null, 0, 1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getCallExpCS_SimpleNameCS(), this.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(loopExpCSEClass, LoopExpCS.class, "LoopExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getLoopExpCS_Variable1(), this.getVariableCS(), null, "variable1", null, 0, 1, LoopExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getLoopExpCS_Variable2(), this.getVariableCS(), null, "variable2", null, 0, 1, LoopExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getLoopExpCS_Body(), this.getOCLExpressionCS(), null, "body", null, 0, 1, LoopExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(iteratorExpCSEClass, IteratorExpCS.class, "IteratorExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(iterateExpCSEClass, IterateExpCS.class, "IterateExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(featureCallExpCSEClass, FeatureCallExpCS.class, "FeatureCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getFeatureCallExpCS_Arguments(), this.getOCLExpressionCS(), null, "arguments", null, 0, -1, FeatureCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getFeatureCallExpCS_IsMarkedPreCS(), this.getIsMarkedPreCS(), null, "isMarkedPreCS", null, 0, 1, FeatureCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(operationCallExpCSEClass, OperationCallExpCS.class, "OperationCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(stateExpCSEClass, StateExpCS.class, "StateExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getStateExpCS_SequenceOfNames(), ecorePackage.getEString(), "sequenceOfNames", null, 0, -1, StateExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum(simpleTypeEnumEEnum, SimpleTypeEnum.class, "SimpleTypeEnum"); //$NON-NLS-1$
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.IDENTIFIER_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.SELF_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.INTEGER_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.STRING_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.REAL_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.BOOLEAN_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.OCL_ANY_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.OCL_VOID_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.INVALID_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.OCL_MESSAGE_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.KEYWORD_LITERAL);
        addEEnumLiteral(simpleTypeEnumEEnum, SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL);

        initEEnum(prePostOrBodyEnumEEnum, PrePostOrBodyEnum.class, "PrePostOrBodyEnum"); //$NON-NLS-1$
        addEEnumLiteral(prePostOrBodyEnumEEnum, PrePostOrBodyEnum.PRE_LITERAL);
        addEEnumLiteral(prePostOrBodyEnumEEnum, PrePostOrBodyEnum.POST_LITERAL);
        addEEnumLiteral(prePostOrBodyEnumEEnum, PrePostOrBodyEnum.BODY_LITERAL);

        initEEnum(collectionTypeIdentifierEnumEEnum, CollectionTypeIdentifierEnum.class, "CollectionTypeIdentifierEnum"); //$NON-NLS-1$
        addEEnumLiteral(collectionTypeIdentifierEnumEEnum, CollectionTypeIdentifierEnum.SET_LITERAL);
        addEEnumLiteral(collectionTypeIdentifierEnumEEnum, CollectionTypeIdentifierEnum.BAG_LITERAL);
        addEEnumLiteral(collectionTypeIdentifierEnumEEnum, CollectionTypeIdentifierEnum.SEQUENCE_LITERAL);
        addEEnumLiteral(collectionTypeIdentifierEnumEEnum, CollectionTypeIdentifierEnum.COLLECTION_LITERAL);
        addEEnumLiteral(collectionTypeIdentifierEnumEEnum, CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL);

        initEEnum(messageExpKindEEnum, MessageExpKind.class, "MessageExpKind"); //$NON-NLS-1$
        addEEnumLiteral(messageExpKindEEnum, MessageExpKind.HAS_SENT_LITERAL);
        addEEnumLiteral(messageExpKindEEnum, MessageExpKind.SENT_LITERAL);

        initEEnum(dotOrArrowEnumEEnum, DotOrArrowEnum.class, "DotOrArrowEnum"); //$NON-NLS-1$
        addEEnumLiteral(dotOrArrowEnumEEnum, DotOrArrowEnum.NONE_LITERAL);
        addEEnumLiteral(dotOrArrowEnumEEnum, DotOrArrowEnum.DOT_LITERAL);
        addEEnumLiteral(dotOrArrowEnumEEnum, DotOrArrowEnum.ARROW_LITERAL);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

	/**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createExtendedMetaDataAnnotations() {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$		
        addAnnotation
          (oclExpressionCSEClass, 
           source, 
           new String[] {
             "name", "OclExpressionCS" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getInitOrDerValueCS_ExpressionCS(), 
           source, 
           new String[] {
             "name", "oclExpressionCS" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getPrePostOrBodyDeclCS_ExpressionCS(), 
           source, 
           new String[] {
             "name", "oclExpressionCS" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getInvCS_ExpressionCS(), 
           source, 
           new String[] {
             "name", "oclExpressionCS" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getDefExpressionCS_ExpressionCS(), 
           source, 
           new String[] {
             "name", "oclExpressionCS" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (oclMessageArgCSEClass, 
           source, 
           new String[] {
             "name", "OclMessageArgCS" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getOCLMessageArgCS_Expression(), 
           source, 
           new String[] {
             "name", "oclExpression" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getCollectionLiteralPartCS_ExpressionCS(), 
           source, 
           new String[] {
             "name", "oclExpressionCS" //$NON-NLS-1$ //$NON-NLS-2$
           });		
        addAnnotation
          (getCollectionRangeCS_LastExpressionCS(), 
           source, 
           new String[] {
             "name", "lastOclExpressionCS" //$NON-NLS-1$ //$NON-NLS-2$
           });
    }

} //CSTPackageImpl
