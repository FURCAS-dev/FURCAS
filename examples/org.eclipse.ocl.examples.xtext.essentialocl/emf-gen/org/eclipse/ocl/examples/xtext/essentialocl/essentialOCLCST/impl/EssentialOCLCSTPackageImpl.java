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
 * $Id: EssentialOCLCSTPackageImpl.java,v 1.1 2010/04/13 06:32:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallArgumentsCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotIndexArgumentsCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IntegerLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RealLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryExpressionCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EssentialOCLCSTPackageImpl extends EPackageImpl implements EssentialOCLCSTPackage {
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
	private EClass simpleNameCSEClass = null;

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
	private EClass typeCSEClass = null;

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
	private EClass tupleTypeCSEClass = null;

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
	private EClass literalExpCSEClass = null;

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
	private EClass collectionLiteralPartCSEClass = null;

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
	private EClass tupleLiteralExpCSEClass = null;

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
	private EClass unlimitedNaturalLiteralExpCSEClass = null;

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
	private EClass nullLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callArgumentsCSEClass = null;

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
	private EClass ifExpCSEClass = null;

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
	private EClass binaryExpressionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExpressionCSEClass = null;

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
	private EClass arrowCallArgumentsCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dotIndexArgumentsCSEClass = null;

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
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EssentialOCLCSTPackageImpl() {
		super(eNS_URI, EssentialOCLCSTFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EssentialOCLCSTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EssentialOCLCSTPackage init() {
		if (isInited) return (EssentialOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSTPackage.eNS_URI);

		// Obtain or create and register package
		EssentialOCLCSTPackageImpl theEssentialOCLCSTPackage = (EssentialOCLCSTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EssentialOCLCSTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EssentialOCLCSTPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEssentialOCLCSTPackage.createPackageContents();

		// Initialize created meta-data
		theEssentialOCLCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEssentialOCLCSTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EssentialOCLCSTPackage.eNS_URI, theEssentialOCLCSTPackage);
		return theEssentialOCLCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclExpressionCS() {
		return oclExpressionCSEClass;
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
	public EReference getSimpleNameCS_CollectionLiteralParts() {
		return (EReference)simpleNameCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getPathNameCS_SimpleNames() {
		return (EReference)pathNameCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getCollectionTypeCS() {
		return collectionTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTypeCS_Value() {
		return (EReference)collectionTypeCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getCollectionTypeCS_CollectionLiteralParts() {
		return (EReference)collectionTypeCSEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getTupleTypeCS_Value() {
		return (EAttribute)tupleTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTupleTypeCS_Part() {
		return (EReference)tupleTypeCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getVariableCS_Name() {
		return (EReference)variableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableCS_Type() {
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
	public EClass getLiteralExpCS() {
		return literalExpCSEClass;
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
	public EReference getCollectionLiteralPartCS_LastExpressionCS() {
		return (EReference)collectionLiteralPartCSEClass.getEStructuralFeatures().get(1);
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
	public EClass getTupleLiteralExpCS() {
		return tupleLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTupleLiteralExpCS_Part() {
		return (EReference)tupleLiteralExpCSEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getBooleanLiteralExpCS_Value() {
		return (EAttribute)booleanLiteralExpCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getInvalidLiteralExpCS() {
		return invalidLiteralExpCSEClass;
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
	public EClass getTypeLiteralExpCS() {
		return typeLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallArgumentsCS() {
		return callArgumentsCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallArgumentsCS_PathName() {
		return (EReference)callArgumentsCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallArgumentsCS_Arguments() {
		return (EReference)callArgumentsCSEClass.getEStructuralFeatures().get(1);
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
	public EClass getIfExpCS() {
		return ifExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpCS_Condition() {
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpCS_ThenExpression() {
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpCS_ElseExpression() {
		return (EReference)ifExpCSEClass.getEStructuralFeatures().get(2);
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
	public EReference getLetExpCS_Variable() {
		return (EReference)letExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExpCS_In() {
		return (EReference)letExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryExpressionCS() {
		return binaryExpressionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryExpressionCS_Left() {
		return (EReference)binaryExpressionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryExpressionCS_Op() {
		return (EAttribute)binaryExpressionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryExpressionCS_Right() {
		return (EReference)binaryExpressionCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryExpressionCS() {
		return unaryExpressionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnaryExpressionCS_Op() {
		return (EAttribute)unaryExpressionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryExpressionCS_Source() {
		return (EReference)unaryExpressionCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getCallExpCS_CallArguments() {
		return (EReference)callExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrowCallArgumentsCS() {
		return arrowCallArgumentsCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrowCallArgumentsCS_Variable1() {
		return (EReference)arrowCallArgumentsCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrowCallArgumentsCS_Variable2() {
		return (EReference)arrowCallArgumentsCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrowCallArgumentsCS_Body() {
		return (EReference)arrowCallArgumentsCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDotIndexArgumentsCS() {
		return dotIndexArgumentsCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDotIndexArgumentsCS_Indexes() {
		return (EReference)dotIndexArgumentsCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDotIndexArgumentsCS_IsPre() {
		return (EAttribute)dotIndexArgumentsCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSTFactory getEssentialOCLCSTFactory() {
		return (EssentialOCLCSTFactory)getEFactoryInstance();
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
		arrowCallArgumentsCSEClass = createEClass(ARROW_CALL_ARGUMENTS_CS);
		createEReference(arrowCallArgumentsCSEClass, ARROW_CALL_ARGUMENTS_CS__VARIABLE1);
		createEReference(arrowCallArgumentsCSEClass, ARROW_CALL_ARGUMENTS_CS__VARIABLE2);
		createEReference(arrowCallArgumentsCSEClass, ARROW_CALL_ARGUMENTS_CS__BODY);

		binaryExpressionCSEClass = createEClass(BINARY_EXPRESSION_CS);
		createEReference(binaryExpressionCSEClass, BINARY_EXPRESSION_CS__LEFT);
		createEAttribute(binaryExpressionCSEClass, BINARY_EXPRESSION_CS__OP);
		createEReference(binaryExpressionCSEClass, BINARY_EXPRESSION_CS__RIGHT);

		booleanLiteralExpCSEClass = createEClass(BOOLEAN_LITERAL_EXP_CS);
		createEAttribute(booleanLiteralExpCSEClass, BOOLEAN_LITERAL_EXP_CS__VALUE);

		callArgumentsCSEClass = createEClass(CALL_ARGUMENTS_CS);
		createEReference(callArgumentsCSEClass, CALL_ARGUMENTS_CS__PATH_NAME);
		createEReference(callArgumentsCSEClass, CALL_ARGUMENTS_CS__ARGUMENTS);

		callExpCSEClass = createEClass(CALL_EXP_CS);
		createEReference(callExpCSEClass, CALL_EXP_CS__SOURCE);
		createEReference(callExpCSEClass, CALL_EXP_CS__CALL_ARGUMENTS);

		collectionLiteralExpCSEClass = createEClass(COLLECTION_LITERAL_EXP_CS);

		collectionLiteralPartCSEClass = createEClass(COLLECTION_LITERAL_PART_CS);
		createEReference(collectionLiteralPartCSEClass, COLLECTION_LITERAL_PART_CS__EXPRESSION_CS);
		createEReference(collectionLiteralPartCSEClass, COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS);

		collectionTypeCSEClass = createEClass(COLLECTION_TYPE_CS);
		createEReference(collectionTypeCSEClass, COLLECTION_TYPE_CS__VALUE);
		createEReference(collectionTypeCSEClass, COLLECTION_TYPE_CS__TYPE_CS);
		createEReference(collectionTypeCSEClass, COLLECTION_TYPE_CS__COLLECTION_LITERAL_PARTS);

		dotIndexArgumentsCSEClass = createEClass(DOT_INDEX_ARGUMENTS_CS);
		createEReference(dotIndexArgumentsCSEClass, DOT_INDEX_ARGUMENTS_CS__INDEXES);
		createEAttribute(dotIndexArgumentsCSEClass, DOT_INDEX_ARGUMENTS_CS__IS_PRE);

		ifExpCSEClass = createEClass(IF_EXP_CS);
		createEReference(ifExpCSEClass, IF_EXP_CS__CONDITION);
		createEReference(ifExpCSEClass, IF_EXP_CS__THEN_EXPRESSION);
		createEReference(ifExpCSEClass, IF_EXP_CS__ELSE_EXPRESSION);

		integerLiteralExpCSEClass = createEClass(INTEGER_LITERAL_EXP_CS);
		createEAttribute(integerLiteralExpCSEClass, INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL);

		invalidLiteralExpCSEClass = createEClass(INVALID_LITERAL_EXP_CS);

		letExpCSEClass = createEClass(LET_EXP_CS);
		createEReference(letExpCSEClass, LET_EXP_CS__VARIABLE);
		createEReference(letExpCSEClass, LET_EXP_CS__IN);

		literalExpCSEClass = createEClass(LITERAL_EXP_CS);

		nullLiteralExpCSEClass = createEClass(NULL_LITERAL_EXP_CS);

		oclExpressionCSEClass = createEClass(OCL_EXPRESSION_CS);

		pathNameCSEClass = createEClass(PATH_NAME_CS);
		createEReference(pathNameCSEClass, PATH_NAME_CS__SIMPLE_NAMES);

		primitiveLiteralExpCSEClass = createEClass(PRIMITIVE_LITERAL_EXP_CS);

		realLiteralExpCSEClass = createEClass(REAL_LITERAL_EXP_CS);
		createEAttribute(realLiteralExpCSEClass, REAL_LITERAL_EXP_CS__REAL_SYMBOL);

		simpleNameCSEClass = createEClass(SIMPLE_NAME_CS);
		createEAttribute(simpleNameCSEClass, SIMPLE_NAME_CS__VALUE);
		createEReference(simpleNameCSEClass, SIMPLE_NAME_CS__COLLECTION_LITERAL_PARTS);

		stringLiteralExpCSEClass = createEClass(STRING_LITERAL_EXP_CS);
		createEAttribute(stringLiteralExpCSEClass, STRING_LITERAL_EXP_CS__STRING_SYMBOL);

		tupleLiteralExpCSEClass = createEClass(TUPLE_LITERAL_EXP_CS);
		createEReference(tupleLiteralExpCSEClass, TUPLE_LITERAL_EXP_CS__PART);

		tupleTypeCSEClass = createEClass(TUPLE_TYPE_CS);
		createEAttribute(tupleTypeCSEClass, TUPLE_TYPE_CS__VALUE);
		createEReference(tupleTypeCSEClass, TUPLE_TYPE_CS__PART);

		typeCSEClass = createEClass(TYPE_CS);

		typeLiteralExpCSEClass = createEClass(TYPE_LITERAL_EXP_CS);

		unaryExpressionCSEClass = createEClass(UNARY_EXPRESSION_CS);
		createEAttribute(unaryExpressionCSEClass, UNARY_EXPRESSION_CS__OP);
		createEReference(unaryExpressionCSEClass, UNARY_EXPRESSION_CS__SOURCE);

		unlimitedNaturalLiteralExpCSEClass = createEClass(UNLIMITED_NATURAL_LITERAL_EXP_CS);

		variableCSEClass = createEClass(VARIABLE_CS);
		createEReference(variableCSEClass, VARIABLE_CS__NAME);
		createEReference(variableCSEClass, VARIABLE_CS__TYPE);
		createEReference(variableCSEClass, VARIABLE_CS__INIT_EXPRESSION);

		variableExpCSEClass = createEClass(VARIABLE_EXP_CS);
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
		arrowCallArgumentsCSEClass.getESuperTypes().add(this.getCallArgumentsCS());
		binaryExpressionCSEClass.getESuperTypes().add(this.getOclExpressionCS());
		booleanLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		callExpCSEClass.getESuperTypes().add(this.getOclExpressionCS());
		collectionLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		collectionTypeCSEClass.getESuperTypes().add(this.getTypeCS());
		collectionTypeCSEClass.getESuperTypes().add(this.getCollectionLiteralExpCS());
		collectionTypeCSEClass.getESuperTypes().add(this.getTypeLiteralExpCS());
		dotIndexArgumentsCSEClass.getESuperTypes().add(this.getCallArgumentsCS());
		ifExpCSEClass.getESuperTypes().add(this.getOclExpressionCS());
		integerLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		invalidLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		letExpCSEClass.getESuperTypes().add(this.getOclExpressionCS());
		literalExpCSEClass.getESuperTypes().add(this.getOclExpressionCS());
		nullLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		pathNameCSEClass.getESuperTypes().add(this.getTypeCS());
		pathNameCSEClass.getESuperTypes().add(this.getTypeLiteralExpCS());
		primitiveLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		realLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		simpleNameCSEClass.getESuperTypes().add(this.getTypeCS());
		simpleNameCSEClass.getESuperTypes().add(this.getCollectionLiteralExpCS());
		simpleNameCSEClass.getESuperTypes().add(this.getTypeLiteralExpCS());
		simpleNameCSEClass.getESuperTypes().add(this.getVariableExpCS());
		stringLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		tupleLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		tupleTypeCSEClass.getESuperTypes().add(this.getTypeCS());
		tupleTypeCSEClass.getESuperTypes().add(this.getTypeLiteralExpCS());
		typeLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		unaryExpressionCSEClass.getESuperTypes().add(this.getOclExpressionCS());
		unlimitedNaturalLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
		variableExpCSEClass.getESuperTypes().add(this.getOclExpressionCS());

		// Initialize classes and features; add operations and parameters
		initEClass(arrowCallArgumentsCSEClass, ArrowCallArgumentsCS.class, "ArrowCallArgumentsCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrowCallArgumentsCS_Variable1(), this.getVariableCS(), null, "variable1", null, 0, 1, ArrowCallArgumentsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrowCallArgumentsCS_Variable2(), this.getVariableCS(), null, "variable2", null, 0, 1, ArrowCallArgumentsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrowCallArgumentsCS_Body(), this.getOclExpressionCS(), null, "body", null, 0, 1, ArrowCallArgumentsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryExpressionCSEClass, BinaryExpressionCS.class, "BinaryExpressionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryExpressionCS_Left(), this.getOclExpressionCS(), null, "left", null, 0, 1, BinaryExpressionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryExpressionCS_Op(), ecorePackage.getEString(), "op", null, 0, 1, BinaryExpressionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryExpressionCS_Right(), this.getOclExpressionCS(), null, "right", null, 0, 1, BinaryExpressionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanLiteralExpCSEClass, BooleanLiteralExpCS.class, "BooleanLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteralExpCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, BooleanLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callArgumentsCSEClass, CallArgumentsCS.class, "CallArgumentsCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallArgumentsCS_PathName(), this.getPathNameCS(), null, "pathName", null, 0, 1, CallArgumentsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallArgumentsCS_Arguments(), this.getOclExpressionCS(), null, "arguments", null, 0, -1, CallArgumentsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callExpCSEClass, CallExpCS.class, "CallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallExpCS_Source(), this.getOclExpressionCS(), null, "source", null, 0, 1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallExpCS_CallArguments(), this.getCallArgumentsCS(), null, "callArguments", null, 0, -1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionLiteralExpCSEClass, CollectionLiteralExpCS.class, "CollectionLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionLiteralPartCSEClass, CollectionLiteralPartCS.class, "CollectionLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionLiteralPartCS_ExpressionCS(), this.getOclExpressionCS(), null, "expressionCS", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionLiteralPartCS_LastExpressionCS(), this.getOclExpressionCS(), null, "lastExpressionCS", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionTypeCSEClass, CollectionTypeCS.class, "CollectionTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionTypeCS_Value(), this.getSimpleNameCS(), null, "value", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTypeCS_TypeCS(), this.getTypeCS(), null, "typeCS", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTypeCS_CollectionLiteralParts(), this.getCollectionLiteralPartCS(), null, "collectionLiteralParts", null, 0, -1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dotIndexArgumentsCSEClass, DotIndexArgumentsCS.class, "DotIndexArgumentsCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDotIndexArgumentsCS_Indexes(), this.getOclExpressionCS(), null, "indexes", null, 0, -1, DotIndexArgumentsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDotIndexArgumentsCS_IsPre(), ecorePackage.getEBoolean(), "isPre", null, 0, 1, DotIndexArgumentsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifExpCSEClass, IfExpCS.class, "IfExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfExpCS_Condition(), this.getOclExpressionCS(), null, "condition", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfExpCS_ThenExpression(), this.getOclExpressionCS(), null, "thenExpression", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfExpCS_ElseExpression(), this.getOclExpressionCS(), null, "elseExpression", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerLiteralExpCSEClass, IntegerLiteralExpCS.class, "IntegerLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteralExpCS_IntegerSymbol(), ecorePackage.getEBigInteger(), "integerSymbol", null, 0, 1, IntegerLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invalidLiteralExpCSEClass, InvalidLiteralExpCS.class, "InvalidLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(letExpCSEClass, LetExpCS.class, "LetExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLetExpCS_Variable(), this.getVariableCS(), null, "variable", null, 0, -1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLetExpCS_In(), this.getOclExpressionCS(), null, "in", null, 0, 1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalExpCSEClass, LiteralExpCS.class, "LiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nullLiteralExpCSEClass, NullLiteralExpCS.class, "NullLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oclExpressionCSEClass, OclExpressionCS.class, "OclExpressionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pathNameCSEClass, PathNameCS.class, "PathNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathNameCS_SimpleNames(), this.getSimpleNameCS(), null, "simpleNames", null, 0, -1, PathNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveLiteralExpCSEClass, PrimitiveLiteralExpCS.class, "PrimitiveLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(realLiteralExpCSEClass, RealLiteralExpCS.class, "RealLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealLiteralExpCS_RealSymbol(), ecorePackage.getEBigDecimal(), "realSymbol", null, 0, 1, RealLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleNameCSEClass, SimpleNameCS.class, "SimpleNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleNameCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, SimpleNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleNameCS_CollectionLiteralParts(), this.getCollectionLiteralPartCS(), null, "collectionLiteralParts", null, 0, -1, SimpleNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralExpCSEClass, StringLiteralExpCS.class, "StringLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteralExpCS_StringSymbol(), ecorePackage.getEString(), "stringSymbol", null, 0, -1, StringLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tupleLiteralExpCSEClass, TupleLiteralExpCS.class, "TupleLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTupleLiteralExpCS_Part(), this.getVariableCS(), null, "part", null, 0, -1, TupleLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tupleTypeCSEClass, TupleTypeCS.class, "TupleTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTupleTypeCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, TupleTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTupleTypeCS_Part(), this.getVariableCS(), null, "part", null, 0, -1, TupleTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeCSEClass, TypeCS.class, "TypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeLiteralExpCSEClass, TypeLiteralExpCS.class, "TypeLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryExpressionCSEClass, UnaryExpressionCS.class, "UnaryExpressionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryExpressionCS_Op(), ecorePackage.getEString(), "op", null, 0, 1, UnaryExpressionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryExpressionCS_Source(), this.getOclExpressionCS(), null, "source", null, 0, 1, UnaryExpressionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unlimitedNaturalLiteralExpCSEClass, UnlimitedNaturalLiteralExpCS.class, "UnlimitedNaturalLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableCSEClass, VariableCS.class, "VariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableCS_Name(), this.getSimpleNameCS(), null, "name", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableCS_Type(), this.getTypeCS(), null, "type", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableCS_InitExpression(), this.getOclExpressionCS(), null, "initExpression", null, 0, 1, VariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableExpCSEClass, VariableExpCS.class, "VariableExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EssentialOCLCSTPackageImpl
