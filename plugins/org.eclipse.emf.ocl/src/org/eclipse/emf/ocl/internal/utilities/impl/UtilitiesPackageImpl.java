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

package org.eclipse.emf.ocl.internal.utilities.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;

import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.internal.impl.ExpressionsPackageImpl;
import org.eclipse.emf.ocl.internal.utilities.AstNode;
import org.eclipse.emf.ocl.internal.utilities.CallingAstNode;
import org.eclipse.emf.ocl.internal.utilities.TypedAstNode;
import org.eclipse.emf.ocl.internal.utilities.UtilitiesFactory;
import org.eclipse.emf.ocl.internal.utilities.UtilitiesPackage;
import org.eclipse.emf.ocl.internal.utilities.Visitable;
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
public class UtilitiesPackageImpl extends EPackageImpl implements
        UtilitiesPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass visitableEClass = null;

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
	private EClass typedAstNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callingAstNodeEClass = null;

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
     * @see org.eclipse.emf.ocl.internal.utilities.UtilitiesPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private UtilitiesPackageImpl() {
		super(eNS_URI, UtilitiesFactory.eINSTANCE);
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
    public static UtilitiesPackage init() {
		if (isInited) return (UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);

		// Obtain or create and register package
		UtilitiesPackageImpl theUtilitiesPackage = (UtilitiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof UtilitiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new UtilitiesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackageImpl.init();

		// Obtain or create and register interdependencies
		QueryPackageImpl theQueryPackage = (QueryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) instanceof QueryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) : QueryPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		UmlPackageImpl theUmlPackage = (UmlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UmlPackage.eNS_URI) instanceof UmlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UmlPackage.eNS_URI) : UmlPackage.eINSTANCE);

		// Create package meta-data objects
		theUtilitiesPackage.createPackageContents();
		theQueryPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theUmlPackage.createPackageContents();

		// Initialize created meta-data
		theUtilitiesPackage.initializePackageContents();
		theQueryPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theUmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUtilitiesPackage.freeze();

		return theUtilitiesPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	public EClass getAstNode() {
		return astNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAstNode_StartPosition() {
		return (EAttribute)astNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAstNode_EndPosition() {
		return (EAttribute)astNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedAstNode() {
		return typedAstNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedAstNode_TypeStartPosition() {
		return (EAttribute)typedAstNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedAstNode_TypeEndPosition() {
		return (EAttribute)typedAstNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallingAstNode() {
		return callingAstNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallingAstNode_PropertyStartPosition() {
		return (EAttribute)callingAstNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallingAstNode_PropertyEndPosition() {
		return (EAttribute)callingAstNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public UtilitiesFactory getUtilitiesFactory() {
		return (UtilitiesFactory)getEFactoryInstance();
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
		visitableEClass = createEClass(VISITABLE);

		astNodeEClass = createEClass(AST_NODE);
		createEAttribute(astNodeEClass, AST_NODE__START_POSITION);
		createEAttribute(astNodeEClass, AST_NODE__END_POSITION);

		typedAstNodeEClass = createEClass(TYPED_AST_NODE);
		createEAttribute(typedAstNodeEClass, TYPED_AST_NODE__TYPE_START_POSITION);
		createEAttribute(typedAstNodeEClass, TYPED_AST_NODE__TYPE_END_POSITION);

		callingAstNodeEClass = createEClass(CALLING_AST_NODE);
		createEAttribute(callingAstNodeEClass, CALLING_AST_NODE__PROPERTY_START_POSITION);
		createEAttribute(callingAstNodeEClass, CALLING_AST_NODE__PROPERTY_END_POSITION);
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
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		EcorePackageImpl theEcorePackage = (EcorePackageImpl)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Add supertypes to classes
		typedAstNodeEClass.getESuperTypes().add(this.getAstNode());
		callingAstNodeEClass.getESuperTypes().add(this.getAstNode());

		// Initialize classes and features; add operations and parameters
		initEClass(visitableEClass, Visitable.class, "Visitable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		EOperation op = addEOperation(visitableEClass, ecorePackage.getEJavaObject(), "accept"); //$NON-NLS-1$
		addEParameter(op, theExpressionsPackage.getVisitor(), "v"); //$NON-NLS-1$

		initEClass(astNodeEClass, AstNode.class, "AstNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAstNode_StartPosition(), theEcorePackage.getEInt(), "startPosition", "-1", 0, 1, AstNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getAstNode_EndPosition(), theEcorePackage.getEInt(), "endPosition", "-1", 0, 1, AstNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(typedAstNodeEClass, TypedAstNode.class, "TypedAstNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTypedAstNode_TypeStartPosition(), theEcorePackage.getEInt(), "typeStartPosition", "-1", 0, 1, TypedAstNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getTypedAstNode_TypeEndPosition(), theEcorePackage.getEInt(), "typeEndPosition", "-1", 0, 1, TypedAstNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(callingAstNodeEClass, CallingAstNode.class, "CallingAstNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getCallingAstNode_PropertyStartPosition(), theEcorePackage.getEInt(), "propertyStartPosition", "-1", 0, 1, CallingAstNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getCallingAstNode_PropertyEndPosition(), theEcorePackage.getEInt(), "propertyEndPosition", "-1", 0, 1, CallingAstNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		// Create resource
		createResource(eNS_URI);
	}

} //UtilitiesPackageImpl
