/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation and others.
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
 * $Id: UtilitiesPackageImpl.java,v 1.8 2008/02/29 17:47:13 cdamus Exp $
 */
package org.eclipse.ocl.utilities.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.impl.TypesPackageImpl;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UtilitiesFactory;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UtilitiesPackageImpl extends EPackageImpl implements UtilitiesPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass astNodeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass callingASTNodeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass predefinedTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typedASTNodeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass visitableEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typedElementEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass visitorEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass expressionInOCLEClass = null;

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
     * @see org.eclipse.ocl.utilities.UtilitiesPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private UtilitiesPackageImpl() {
        super(eNS_URI, UtilitiesFactory.eINSTANCE);
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
	public static UtilitiesPackage init() {
        if (isInited) return (UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);

        // Obtain or create and register package
        UtilitiesPackageImpl theUtilitiesPackage = (UtilitiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof UtilitiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new UtilitiesPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
        ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);

        // Create package meta-data objects
        theUtilitiesPackage.createPackageContents();
        theTypesPackage.createPackageContents();
        theExpressionsPackage.createPackageContents();

        // Initialize created meta-data
        theUtilitiesPackage.initializePackageContents();
        theTypesPackage.initializePackageContents();
        theExpressionsPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theUtilitiesPackage.freeze();

        return theUtilitiesPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getASTNode() {
        return astNodeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getASTNode_StartPosition() {
        return (EAttribute)astNodeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getASTNode_EndPosition() {
        return (EAttribute)astNodeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCallingASTNode() {
        return callingASTNodeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCallingASTNode_PropertyStartPosition() {
        return (EAttribute)callingASTNodeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCallingASTNode_PropertyEndPosition() {
        return (EAttribute)callingASTNodeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPredefinedType() {
        return predefinedTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTypedASTNode() {
        return typedASTNodeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTypedASTNode_TypeStartPosition() {
        return (EAttribute)typedASTNodeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTypedASTNode_TypeEndPosition() {
        return (EAttribute)typedASTNodeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getVisitable() {
        return visitableEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTypedElement() {
        return typedElementEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getVisitor() {
        return visitorEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getExpressionInOCL() {
        return expressionInOCLEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getExpressionInOCL_BodyExpression() {
        return (EReference)expressionInOCLEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getExpressionInOCL_ContextVariable() {
        return (EReference)expressionInOCLEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getExpressionInOCL_ResultVariable() {
        return (EReference)expressionInOCLEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getExpressionInOCL_ParameterVariable() {
        return (EReference)expressionInOCLEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UtilitiesFactory getUtilitiesFactory() {
        return (UtilitiesFactory)getEFactoryInstance();
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
        astNodeEClass = createEClass(AST_NODE);
        createEAttribute(astNodeEClass, AST_NODE__START_POSITION);
        createEAttribute(astNodeEClass, AST_NODE__END_POSITION);

        callingASTNodeEClass = createEClass(CALLING_AST_NODE);
        createEAttribute(callingASTNodeEClass, CALLING_AST_NODE__PROPERTY_START_POSITION);
        createEAttribute(callingASTNodeEClass, CALLING_AST_NODE__PROPERTY_END_POSITION);

        typedASTNodeEClass = createEClass(TYPED_AST_NODE);
        createEAttribute(typedASTNodeEClass, TYPED_AST_NODE__TYPE_START_POSITION);
        createEAttribute(typedASTNodeEClass, TYPED_AST_NODE__TYPE_END_POSITION);

        visitableEClass = createEClass(VISITABLE);

        visitorEClass = createEClass(VISITOR);

        typedElementEClass = createEClass(TYPED_ELEMENT);

        expressionInOCLEClass = createEClass(EXPRESSION_IN_OCL);
        createEReference(expressionInOCLEClass, EXPRESSION_IN_OCL__BODY_EXPRESSION);
        createEReference(expressionInOCLEClass, EXPRESSION_IN_OCL__CONTEXT_VARIABLE);
        createEReference(expressionInOCLEClass, EXPRESSION_IN_OCL__RESULT_VARIABLE);
        createEReference(expressionInOCLEClass, EXPRESSION_IN_OCL__PARAMETER_VARIABLE);

        predefinedTypeEClass = createEClass(PREDEFINED_TYPE);
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
     * <p>
     * The generated implementation is extended by adding me as a child of
     * the empty root <tt>OCL</tt> package.
     * </p>
     */
    public void initializePackageContents() {
        if (!isInitialized) {
            // create my own resource first, before adding me to my parent
            // package.  Otherwise, I will already be in a resource when
            // createResource() is called, and it will not create a new one
            initializePackageContentsGen();
            
            ExpressionsPackageImpl.OCL_ROOT_PACKAGE.getESubpackages().add(this);
        }
    }
    
    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContentsGen() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

        // Create type parameters
        ETypeParameter visitorEClass_T = addETypeParameter(visitorEClass, "T"); //$NON-NLS-1$
        ETypeParameter visitorEClass_C = addETypeParameter(visitorEClass, "C"); //$NON-NLS-1$
        ETypeParameter visitorEClass_O = addETypeParameter(visitorEClass, "O"); //$NON-NLS-1$
        ETypeParameter visitorEClass_P = addETypeParameter(visitorEClass, "P"); //$NON-NLS-1$
        ETypeParameter visitorEClass_EL = addETypeParameter(visitorEClass, "EL"); //$NON-NLS-1$
        ETypeParameter visitorEClass_PM = addETypeParameter(visitorEClass, "PM"); //$NON-NLS-1$
        ETypeParameter visitorEClass_S = addETypeParameter(visitorEClass, "S"); //$NON-NLS-1$
        ETypeParameter visitorEClass_COA = addETypeParameter(visitorEClass, "COA"); //$NON-NLS-1$
        ETypeParameter visitorEClass_SSA = addETypeParameter(visitorEClass, "SSA"); //$NON-NLS-1$
        ETypeParameter visitorEClass_CT = addETypeParameter(visitorEClass, "CT"); //$NON-NLS-1$
        ETypeParameter typedElementEClass_C = addETypeParameter(typedElementEClass, "C"); //$NON-NLS-1$
        ETypeParameter expressionInOCLEClass_C = addETypeParameter(expressionInOCLEClass, "C"); //$NON-NLS-1$
        ETypeParameter expressionInOCLEClass_PM = addETypeParameter(expressionInOCLEClass, "PM"); //$NON-NLS-1$
        ETypeParameter predefinedTypeEClass_O = addETypeParameter(predefinedTypeEClass, "O"); //$NON-NLS-1$

        // Set bounds for type parameters

        // Add supertypes to classes
        callingASTNodeEClass.getESuperTypes().add(this.getASTNode());
        typedASTNodeEClass.getESuperTypes().add(this.getASTNode());
        expressionInOCLEClass.getESuperTypes().add(this.getVisitable());

        // Initialize classes and features; add operations and parameters
        initEClass(astNodeEClass, ASTNode.class, "ASTNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getASTNode_StartPosition(), ecorePackage.getEInt(), "startPosition", "-1", 0, 1, ASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getASTNode_EndPosition(), ecorePackage.getEInt(), "endPosition", "-1", 0, 1, ASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(callingASTNodeEClass, CallingASTNode.class, "CallingASTNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getCallingASTNode_PropertyStartPosition(), ecorePackage.getEInt(), "propertyStartPosition", "-1", 0, 1, CallingASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getCallingASTNode_PropertyEndPosition(), ecorePackage.getEInt(), "propertyEndPosition", "-1", 0, 1, CallingASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(typedASTNodeEClass, TypedASTNode.class, "TypedASTNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getTypedASTNode_TypeStartPosition(), ecorePackage.getEInt(), "typeStartPosition", "-1", 0, 1, TypedASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute(getTypedASTNode_TypeEndPosition(), ecorePackage.getEInt(), "typeEndPosition", "-1", 0, 1, TypedASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass(visitableEClass, Visitable.class, "Visitable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        EOperation op = addEOperation(visitableEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        ETypeParameter t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
        ETypeParameter t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
        EGenericType g1 = createEGenericType(this.getVisitor());
        EGenericType g2 = createEGenericType(t1);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        t2.getEBounds().add(g1);
        g1 = createEGenericType(t2);
        addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(t1);
        initEOperation(op, g1);

        initEClass(visitorEClass, Visitor.class, "Visitor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(visitorEClass, null, "visitVariableExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getVariableExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_PM);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "variableExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitLetExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getLetExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_PM);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "letExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitIfExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getIfExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "ifExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitTypeExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getTypeExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "typeExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitPropertyCallExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getPropertyCallExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_P);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "callExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitOperationCallExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getOperationCallExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_O);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "callExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitAssociationClassCallExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getAssociationClassCallExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_P);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "callExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitIteratorExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getIteratorExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_PM);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "callExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitIterateExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getIterateExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_PM);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "callExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitUnspecifiedValueExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getUnspecifiedValueExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "unspecExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitIntegerLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getIntegerLiteralExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "literalExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitUnlimitedNaturalLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getUnlimitedNaturalLiteralExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "literalExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitRealLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getRealLiteralExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "literalExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitStringLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getStringLiteralExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "literalExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitBooleanLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getBooleanLiteralExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "literalExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitEnumLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getEnumLiteralExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_EL);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "literalExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitCollectionLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getCollectionLiteralExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "literalExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitCollectionItem", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getCollectionItem());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "item", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitCollectionRange", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getCollectionRange());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "range", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitTupleLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getTupleLiteralExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_P);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "literalExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitTupleLiteralPart", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getTupleLiteralPart());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_P);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "part", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitInvalidLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getInvalidLiteralExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "literalExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitNullLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getNullLiteralExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "literalExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitStateExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getStateExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_S);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "stateExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitMessageExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getMessageExp());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_COA);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_SSA);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "messageExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitVariable", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getVariable());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_PM);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "variable", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitExpressionInOCL", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(this.getExpressionInOCL());
        g2 = createEGenericType(visitorEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(visitorEClass_PM);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "expression", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        op = addEOperation(visitorEClass, null, "visitConstraint", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_CT);
        addEParameter(op, g1, "constraint", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(visitorEClass_T);
        initEOperation(op, g1);

        initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        addEOperation(typedElementEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(typedElementEClass, null, "getType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(typedElementEClass_C);
        initEOperation(op, g1);

        op = addEOperation(typedElementEClass, null, "setName", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(typedElementEClass, null, "setType", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(typedElementEClass_C);
        addEParameter(op, g1, "type", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

        initEClass(expressionInOCLEClass, ExpressionInOCL.class, "ExpressionInOCL", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getOCLExpression());
        g2 = createEGenericType(expressionInOCLEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getExpressionInOCL_BodyExpression(), g1, null, "bodyExpression", null, 1, 1, ExpressionInOCL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getVariable());
        g2 = createEGenericType(expressionInOCLEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(expressionInOCLEClass_PM);
        g1.getETypeArguments().add(g2);
        initEReference(getExpressionInOCL_ContextVariable(), g1, null, "contextVariable", null, 1, 1, ExpressionInOCL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getVariable());
        g2 = createEGenericType(expressionInOCLEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(expressionInOCLEClass_PM);
        g1.getETypeArguments().add(g2);
        initEReference(getExpressionInOCL_ResultVariable(), g1, null, "resultVariable", null, 0, 1, ExpressionInOCL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(theExpressionsPackage.getVariable());
        g2 = createEGenericType(expressionInOCLEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(expressionInOCLEClass_PM);
        g1.getETypeArguments().add(g2);
        initEReference(getExpressionInOCL_ParameterVariable(), g1, null, "parameterVariable", null, 0, -1, ExpressionInOCL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(predefinedTypeEClass, PredefinedType.class, "PredefinedType", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        addEOperation(predefinedTypeEClass, ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(predefinedTypeEClass, null, "oclOperations", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(predefinedTypeEClass_O);
        initEOperation(op, g1);

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
          (expressionInOCLEClass, 
           source, 
           new String[] {
             "name", "ExpressionInOcl" //$NON-NLS-1$ //$NON-NLS-2$
           });
    }

} //UtilitiesPackageImpl
