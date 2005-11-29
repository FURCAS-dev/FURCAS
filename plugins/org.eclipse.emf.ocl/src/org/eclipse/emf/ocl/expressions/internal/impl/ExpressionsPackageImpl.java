/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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

package org.eclipse.emf.ocl.expressions.internal.impl;

import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;

import org.eclipse.emf.ocl.expressions.AssociationEndCallExp;
import org.eclipse.emf.ocl.expressions.AttributeCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.LiteralExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.ModelPropertyCallExp;
import org.eclipse.emf.ocl.expressions.NavigationCallExp;
import org.eclipse.emf.ocl.expressions.NumericLiteralExp;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OclMessageArg;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PrimitiveLiteralExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.internal.utilities.UtilitiesPackage;
import org.eclipse.emf.ocl.internal.utilities.impl.UtilitiesPackageImpl;
import org.eclipse.emf.ocl.query.QueryPackage;
import org.eclipse.emf.ocl.query.internal.impl.QueryPackageImpl;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl;
import org.eclipse.emf.ocl.uml.UmlPackage;
import org.eclipse.emf.ocl.uml.internal.impl.UmlPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package </b>. <!--
 * end-user-doc -->
 * @generated
 */
public class ExpressionsPackageImpl extends EPackageImpl implements
        ExpressionsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass associationEndCallExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass attributeCallExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass booleanLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass collectionItemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass collectionLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass collectionLiteralPartEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass collectionRangeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass enumLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass ifExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass integerLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass iterateExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass iteratorExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass letExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass literalExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass loopExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass modelPropertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass navigationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass numericLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass oclExpressionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass oclMessageArgEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass operationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass primitiveLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass propertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass realLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass stringLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass tupleLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass unspecifiedValueExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass variableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass variableExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationClassCallExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum collectionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType visitorEDataType = null;

    /**
     * Creates an instance of the model <b>Package </b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry}by the
     * package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ExpressionsPackageImpl() {
		super(eNS_URI, ExpressionsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
    public static ExpressionsPackage init() {
		if (isInited) return (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Obtain or create and register package
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExpressionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackageImpl.init();

		// Obtain or create and register interdependencies
		QueryPackageImpl theQueryPackage = (QueryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) instanceof QueryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) : QueryPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		UtilitiesPackageImpl theUtilitiesPackage = (UtilitiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI) instanceof UtilitiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI) : UtilitiesPackage.eINSTANCE);
		UmlPackageImpl theUmlPackage = (UmlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UmlPackage.eNS_URI) instanceof UmlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UmlPackage.eNS_URI) : UmlPackage.eINSTANCE);

		// Create package meta-data objects
		theExpressionsPackage.createPackageContents();
		theQueryPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theUtilitiesPackage.createPackageContents();
		theUmlPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionsPackage.initializePackageContents();
		theQueryPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theUtilitiesPackage.initializePackageContents();
		theUmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExpressionsPackage.freeze();

		return theExpressionsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getAssociationEndCallExp() {
		return associationEndCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getAssociationEndCallExp_ReferredAssociationEnd() {
		return (EReference)associationEndCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getAttributeCallExp() {
		return attributeCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getAttributeCallExp_ReferredAttribute() {
		return (EReference)attributeCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getBooleanLiteralExp() {
		return booleanLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getBooleanLiteralExp_BooleanSymbol() {
		return (EAttribute)booleanLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getCollectionItem() {
		return collectionItemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getCollectionItem_Item() {
		return (EReference)collectionItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getCollectionLiteralExp() {
		return collectionLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getCollectionLiteralExp_Kind() {
		return (EAttribute)collectionLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getCollectionLiteralExp_Parts() {
		return (EReference)collectionLiteralExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getCollectionLiteralPart() {
		return collectionLiteralPartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getCollectionLiteralPart_Type() {
		return (EReference)collectionLiteralPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getCollectionRange() {
		return collectionRangeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getCollectionRange_First() {
		return (EReference)collectionRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getCollectionRange_Last() {
		return (EReference)collectionRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getEnumLiteralExp() {
		return enumLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getEnumLiteralExp_ReferredEnumLiteral() {
		return (EReference)enumLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getIfExp() {
		return ifExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getIfExp_Condition() {
		return (EReference)ifExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getIfExp_ThenExpression() {
		return (EReference)ifExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getIfExp_ElseExpression() {
		return (EReference)ifExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getIntegerLiteralExp() {
		return integerLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getIntegerLiteralExp_IntegerSymbol() {
		return (EAttribute)integerLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getIterateExp() {
		return iterateExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getIterateExp_Result() {
		return (EReference)iterateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getIteratorExp() {
		return iteratorExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getLetExp() {
		return letExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getLetExp_In() {
		return (EReference)letExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getLetExp_Variable() {
		return (EReference)letExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getLiteralExp() {
		return literalExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getLoopExp() {
		return loopExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getLoopExp_Body() {
		return (EReference)loopExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getLoopExp_Iterators() {
		return (EReference)loopExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getModelPropertyCallExp() {
		return modelPropertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelPropertyCallExp_MarkedPre() {
		return (EAttribute)modelPropertyCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getNavigationCallExp() {
		return navigationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getNavigationCallExp_Qualifiers() {
		return (EReference)navigationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getNavigationCallExp_NavigationSource() {
		return (EReference)navigationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getNumericLiteralExp() {
		return numericLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getOclExpression() {
		return oclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getOclExpression_AppliedProperty() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpression_InitializedVariable() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getOclExpression_ParentOperation() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getOclExpression_Type() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getOclMessageArg() {
		return oclMessageArgEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getOclMessageArg_Expression() {
		return (EReference)oclMessageArgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getOclMessageArg_Unspecified() {
		return (EReference)oclMessageArgEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getOperationCallExp() {
		return operationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getOperationCallExp_Arguments() {
		return (EReference)operationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getOperationCallExp_ReferredOperation() {
		return (EReference)operationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getPrimitiveLiteralExp() {
		return primitiveLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getPropertyCallExp() {
		return propertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getPropertyCallExp_Source() {
		return (EReference)propertyCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getRealLiteralExp() {
		return realLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getRealLiteralExp_RealSymbol() {
		return (EAttribute)realLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getStringLiteralExp() {
		return stringLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getStringLiteralExp_StringSymbol() {
		return (EAttribute)stringLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getTupleLiteralExp() {
		return tupleLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getTupleLiteralExp_TuplePart() {
		return (EReference)tupleLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getUnspecifiedValueExp() {
		return unspecifiedValueExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getVariableDeclaration_VarName() {
		return (EAttribute)variableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getVariableDeclaration_LoopExpr() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getVariableDeclaration_InitExpression() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getVariableDeclaration_BaseExp() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getVariableDeclaration_Type() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getVariableExp() {
		return variableExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getVariableExp_ReferredVariable() {
		return (EReference)variableExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationClassCallExp() {
		return associationClassCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationClassCallExp_ReferredAssociationClass() {
		return (EReference)associationClassCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getCollectionKind() {
		return collectionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVisitor() {
		return visitorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ExpressionsFactory getExpressionsFactory() {
		return (ExpressionsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		associationEndCallExpEClass = createEClass(ASSOCIATION_END_CALL_EXP);
		createEReference(associationEndCallExpEClass, ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END);

		attributeCallExpEClass = createEClass(ATTRIBUTE_CALL_EXP);
		createEReference(attributeCallExpEClass, ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE);

		booleanLiteralExpEClass = createEClass(BOOLEAN_LITERAL_EXP);
		createEAttribute(booleanLiteralExpEClass, BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL);

		collectionItemEClass = createEClass(COLLECTION_ITEM);
		createEReference(collectionItemEClass, COLLECTION_ITEM__ITEM);

		collectionLiteralExpEClass = createEClass(COLLECTION_LITERAL_EXP);
		createEAttribute(collectionLiteralExpEClass, COLLECTION_LITERAL_EXP__KIND);
		createEReference(collectionLiteralExpEClass, COLLECTION_LITERAL_EXP__PARTS);

		collectionLiteralPartEClass = createEClass(COLLECTION_LITERAL_PART);
		createEReference(collectionLiteralPartEClass, COLLECTION_LITERAL_PART__TYPE);

		collectionRangeEClass = createEClass(COLLECTION_RANGE);
		createEReference(collectionRangeEClass, COLLECTION_RANGE__FIRST);
		createEReference(collectionRangeEClass, COLLECTION_RANGE__LAST);

		enumLiteralExpEClass = createEClass(ENUM_LITERAL_EXP);
		createEReference(enumLiteralExpEClass, ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL);

		ifExpEClass = createEClass(IF_EXP);
		createEReference(ifExpEClass, IF_EXP__CONDITION);
		createEReference(ifExpEClass, IF_EXP__THEN_EXPRESSION);
		createEReference(ifExpEClass, IF_EXP__ELSE_EXPRESSION);

		integerLiteralExpEClass = createEClass(INTEGER_LITERAL_EXP);
		createEAttribute(integerLiteralExpEClass, INTEGER_LITERAL_EXP__INTEGER_SYMBOL);

		iterateExpEClass = createEClass(ITERATE_EXP);
		createEReference(iterateExpEClass, ITERATE_EXP__RESULT);

		iteratorExpEClass = createEClass(ITERATOR_EXP);

		letExpEClass = createEClass(LET_EXP);
		createEReference(letExpEClass, LET_EXP__IN);
		createEReference(letExpEClass, LET_EXP__VARIABLE);

		literalExpEClass = createEClass(LITERAL_EXP);

		loopExpEClass = createEClass(LOOP_EXP);
		createEReference(loopExpEClass, LOOP_EXP__BODY);
		createEReference(loopExpEClass, LOOP_EXP__ITERATORS);

		modelPropertyCallExpEClass = createEClass(MODEL_PROPERTY_CALL_EXP);
		createEAttribute(modelPropertyCallExpEClass, MODEL_PROPERTY_CALL_EXP__MARKED_PRE);

		navigationCallExpEClass = createEClass(NAVIGATION_CALL_EXP);
		createEReference(navigationCallExpEClass, NAVIGATION_CALL_EXP__QUALIFIERS);
		createEReference(navigationCallExpEClass, NAVIGATION_CALL_EXP__NAVIGATION_SOURCE);

		numericLiteralExpEClass = createEClass(NUMERIC_LITERAL_EXP);

		oclExpressionEClass = createEClass(OCL_EXPRESSION);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__APPLIED_PROPERTY);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__INITIALIZED_VARIABLE);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__PARENT_OPERATION);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__TYPE);

		oclMessageArgEClass = createEClass(OCL_MESSAGE_ARG);
		createEReference(oclMessageArgEClass, OCL_MESSAGE_ARG__EXPRESSION);
		createEReference(oclMessageArgEClass, OCL_MESSAGE_ARG__UNSPECIFIED);

		operationCallExpEClass = createEClass(OPERATION_CALL_EXP);
		createEReference(operationCallExpEClass, OPERATION_CALL_EXP__ARGUMENTS);
		createEReference(operationCallExpEClass, OPERATION_CALL_EXP__REFERRED_OPERATION);

		primitiveLiteralExpEClass = createEClass(PRIMITIVE_LITERAL_EXP);

		propertyCallExpEClass = createEClass(PROPERTY_CALL_EXP);
		createEReference(propertyCallExpEClass, PROPERTY_CALL_EXP__SOURCE);

		realLiteralExpEClass = createEClass(REAL_LITERAL_EXP);
		createEAttribute(realLiteralExpEClass, REAL_LITERAL_EXP__REAL_SYMBOL);

		stringLiteralExpEClass = createEClass(STRING_LITERAL_EXP);
		createEAttribute(stringLiteralExpEClass, STRING_LITERAL_EXP__STRING_SYMBOL);

		tupleLiteralExpEClass = createEClass(TUPLE_LITERAL_EXP);
		createEReference(tupleLiteralExpEClass, TUPLE_LITERAL_EXP__TUPLE_PART);

		unspecifiedValueExpEClass = createEClass(UNSPECIFIED_VALUE_EXP);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
		createEAttribute(variableDeclarationEClass, VARIABLE_DECLARATION__VAR_NAME);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__LOOP_EXPR);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__INIT_EXPRESSION);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__BASE_EXP);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__TYPE);

		variableExpEClass = createEClass(VARIABLE_EXP);
		createEReference(variableExpEClass, VARIABLE_EXP__REFERRED_VARIABLE);

		associationClassCallExpEClass = createEClass(ASSOCIATION_CLASS_CALL_EXP);
		createEReference(associationClassCallExpEClass, ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS);

		// Create enums
		collectionKindEEnum = createEEnum(COLLECTION_KIND);

		// Create data types
		visitorEDataType = createEDataType(VISITOR);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackageImpl theEcorePackage = (EcorePackageImpl)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		UtilitiesPackageImpl theUtilitiesPackage = (UtilitiesPackageImpl)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);

		// Add supertypes to classes
		associationEndCallExpEClass.getESuperTypes().add(this.getNavigationCallExp());
		attributeCallExpEClass.getESuperTypes().add(this.getModelPropertyCallExp());
		booleanLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
		collectionItemEClass.getESuperTypes().add(this.getCollectionLiteralPart());
		collectionLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		collectionLiteralPartEClass.getESuperTypes().add(theEcorePackage.getENamedElement());
		collectionRangeEClass.getESuperTypes().add(this.getCollectionLiteralPart());
		enumLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		ifExpEClass.getESuperTypes().add(this.getOclExpression());
		integerLiteralExpEClass.getESuperTypes().add(this.getNumericLiteralExp());
		iterateExpEClass.getESuperTypes().add(this.getLoopExp());
		iteratorExpEClass.getESuperTypes().add(this.getLoopExp());
		letExpEClass.getESuperTypes().add(this.getOclExpression());
		literalExpEClass.getESuperTypes().add(this.getOclExpression());
		loopExpEClass.getESuperTypes().add(this.getPropertyCallExp());
		modelPropertyCallExpEClass.getESuperTypes().add(this.getPropertyCallExp());
		navigationCallExpEClass.getESuperTypes().add(this.getModelPropertyCallExp());
		numericLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
		oclExpressionEClass.getESuperTypes().add(theEcorePackage.getENamedElement());
		oclExpressionEClass.getESuperTypes().add(theUtilitiesPackage.getVisitable());
		oclExpressionEClass.getESuperTypes().add(theUtilitiesPackage.getAstNode());
		oclMessageArgEClass.getESuperTypes().add(theEcorePackage.getENamedElement());
		operationCallExpEClass.getESuperTypes().add(this.getModelPropertyCallExp());
		primitiveLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		propertyCallExpEClass.getESuperTypes().add(this.getOclExpression());
		propertyCallExpEClass.getESuperTypes().add(theUtilitiesPackage.getCallingAstNode());
		realLiteralExpEClass.getESuperTypes().add(this.getNumericLiteralExp());
		stringLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
		tupleLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		unspecifiedValueExpEClass.getESuperTypes().add(this.getOclExpression());
		variableDeclarationEClass.getESuperTypes().add(theEcorePackage.getENamedElement());
		variableDeclarationEClass.getESuperTypes().add(theUtilitiesPackage.getVisitable());
		variableDeclarationEClass.getESuperTypes().add(theUtilitiesPackage.getTypedAstNode());
		variableExpEClass.getESuperTypes().add(this.getOclExpression());
		associationClassCallExpEClass.getESuperTypes().add(this.getNavigationCallExp());

		// Initialize classes and features; add operations and parameters
		initEClass(associationEndCallExpEClass, AssociationEndCallExp.class, "AssociationEndCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAssociationEndCallExp_ReferredAssociationEnd(), theEcorePackage.getEReference(), null, "referredAssociationEnd", null, 0, 1, AssociationEndCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(attributeCallExpEClass, AttributeCallExp.class, "AttributeCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAttributeCallExp_ReferredAttribute(), theEcorePackage.getEAttribute(), null, "referredAttribute", null, 0, 1, AttributeCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(booleanLiteralExpEClass, BooleanLiteralExp.class, "BooleanLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getBooleanLiteralExp_BooleanSymbol(), ecorePackage.getEBooleanObject(), "booleanSymbol", null, 0, 1, BooleanLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionItemEClass, CollectionItem.class, "CollectionItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionItem_Item(), this.getOclExpression(), null, "item", null, 0, 1, CollectionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionLiteralExpEClass, CollectionLiteralExp.class, "CollectionLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getCollectionLiteralExp_Kind(), this.getCollectionKind(), "kind", null, 0, 1, CollectionLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionLiteralExp_Parts(), this.getCollectionLiteralPart(), null, "parts", null, 0, -1, CollectionLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionLiteralPartEClass, CollectionLiteralPart.class, "CollectionLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionLiteralPart_Type(), theEcorePackage.getEClassifier(), null, "type", null, 0, 1, CollectionLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionRangeEClass, CollectionRange.class, "CollectionRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionRange_First(), this.getOclExpression(), null, "first", null, 0, 1, CollectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCollectionRange_Last(), this.getOclExpression(), null, "last", null, 0, 1, CollectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(enumLiteralExpEClass, EnumLiteralExp.class, "EnumLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEnumLiteralExp_ReferredEnumLiteral(), theEcorePackage.getEEnumLiteral(), null, "referredEnumLiteral", null, 0, 1, EnumLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ifExpEClass, IfExp.class, "IfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIfExp_Condition(), this.getOclExpression(), null, "condition", null, 0, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfExp_ThenExpression(), this.getOclExpression(), null, "thenExpression", null, 0, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getIfExp_ElseExpression(), this.getOclExpression(), null, "elseExpression", null, 0, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(integerLiteralExpEClass, IntegerLiteralExp.class, "IntegerLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIntegerLiteralExp_IntegerSymbol(), ecorePackage.getEIntegerObject(), "integerSymbol", null, 0, 1, IntegerLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iterateExpEClass, IterateExp.class, "IterateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIterateExp_Result(), this.getVariableDeclaration(), this.getVariableDeclaration_BaseExp(), "result", null, 0, 1, IterateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iteratorExpEClass, IteratorExp.class, "IteratorExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(letExpEClass, LetExp.class, "LetExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLetExp_In(), this.getOclExpression(), null, "in", null, 0, 1, LetExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLetExp_Variable(), this.getVariableDeclaration(), null, "variable", null, 0, 1, LetExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(literalExpEClass, LiteralExp.class, "LiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(loopExpEClass, LoopExp.class, "LoopExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLoopExp_Body(), this.getOclExpression(), null, "body", null, 0, 1, LoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLoopExp_Iterators(), this.getVariableDeclaration(), this.getVariableDeclaration_LoopExpr(), "iterators", null, 0, -1, LoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelPropertyCallExpEClass, ModelPropertyCallExp.class, "ModelPropertyCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getModelPropertyCallExp_MarkedPre(), theEcorePackage.getEBoolean(), "markedPre", null, 0, 1, ModelPropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(navigationCallExpEClass, NavigationCallExp.class, "NavigationCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNavigationCallExp_Qualifiers(), this.getOclExpression(), null, "qualifiers", null, 0, -1, NavigationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getNavigationCallExp_NavigationSource(), theEcorePackage.getEReference(), null, "navigationSource", null, 0, 1, NavigationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(numericLiteralExpEClass, NumericLiteralExp.class, "NumericLiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(oclExpressionEClass, OclExpression.class, "OclExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOclExpression_AppliedProperty(), this.getPropertyCallExp(), this.getPropertyCallExp_Source(), "appliedProperty", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOclExpression_InitializedVariable(), this.getVariableDeclaration(), this.getVariableDeclaration_InitExpression(), "initializedVariable", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOclExpression_ParentOperation(), this.getOperationCallExp(), this.getOperationCallExp_Arguments(), "parentOperation", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOclExpression_Type(), theEcorePackage.getEClassifier(), null, "type", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(oclMessageArgEClass, OclMessageArg.class, "OclMessageArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOclMessageArg_Expression(), this.getOclExpression(), null, "expression", null, 0, 1, OclMessageArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOclMessageArg_Unspecified(), this.getUnspecifiedValueExp(), null, "unspecified", null, 0, 1, OclMessageArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operationCallExpEClass, OperationCallExp.class, "OperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperationCallExp_Arguments(), this.getOclExpression(), this.getOclExpression_ParentOperation(), "arguments", null, 0, -1, OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCallExp_ReferredOperation(), theEcorePackage.getEOperation(), null, "referredOperation", null, 0, 1, OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(primitiveLiteralExpEClass, PrimitiveLiteralExp.class, "PrimitiveLiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(propertyCallExpEClass, PropertyCallExp.class, "PropertyCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPropertyCallExp_Source(), this.getOclExpression(), this.getOclExpression_AppliedProperty(), "source", null, 0, 1, PropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(realLiteralExpEClass, RealLiteralExp.class, "RealLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getRealLiteralExp_RealSymbol(), ecorePackage.getEDoubleObject(), "realSymbol", null, 0, 1, RealLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringLiteralExpEClass, StringLiteralExp.class, "StringLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStringLiteralExp_StringSymbol(), ecorePackage.getEString(), "stringSymbol", null, 0, 1, StringLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tupleLiteralExpEClass, TupleLiteralExp.class, "TupleLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTupleLiteralExp_TuplePart(), this.getVariableDeclaration(), null, "tuplePart", null, 0, -1, TupleLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(unspecifiedValueExpEClass, UnspecifiedValueExp.class, "UnspecifiedValueExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getVariableDeclaration_VarName(), ecorePackage.getEString(), "varName", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVariableDeclaration_LoopExpr(), this.getLoopExp(), this.getLoopExp_Iterators(), "loopExpr", null, 0, 1, VariableDeclaration.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVariableDeclaration_InitExpression(), this.getOclExpression(), this.getOclExpression_InitializedVariable(), "initExpression", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVariableDeclaration_BaseExp(), this.getIterateExp(), this.getIterateExp_Result(), "baseExp", null, 0, 1, VariableDeclaration.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVariableDeclaration_Type(), theEcorePackage.getEClassifier(), null, "type", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(variableExpEClass, VariableExp.class, "VariableExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getVariableExp_ReferredVariable(), this.getVariableDeclaration(), null, "referredVariable", null, 0, 1, VariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(associationClassCallExpEClass, AssociationClassCallExp.class, "AssociationClassCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAssociationClassCallExp_ReferredAssociationClass(), ecorePackage.getEClass(), null, "referredAssociationClass", null, 0, 1, AssociationClassCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(collectionKindEEnum, CollectionKind.class, "CollectionKind"); //$NON-NLS-1$
		addEEnumLiteral(collectionKindEEnum, CollectionKind.COLLECTION_LITERAL);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.SET_LITERAL);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.BAG_LITERAL);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.SEQUENCE_LITERAL);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.ORDERED_SET_LITERAL);

		// Initialize data types
		initEDataType(visitorEDataType, Visitor.class, "Visitor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //ExpressionsPackageImpl
