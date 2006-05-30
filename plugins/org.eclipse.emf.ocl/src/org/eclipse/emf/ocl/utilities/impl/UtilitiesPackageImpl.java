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
 * $Id: UtilitiesPackageImpl.java,v 1.2 2006/05/30 21:37:21 cdamus Exp $
 */

package org.eclipse.emf.ocl.utilities.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.impl.ExpressionsPackageImpl;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.query.QueryPackage;
import org.eclipse.emf.ocl.query.impl.QueryPackageImpl;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.impl.TypesPackageImpl;
import org.eclipse.emf.ocl.uml.UMLPackage;
import org.eclipse.emf.ocl.uml.impl.UMLPackageImpl;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.CallingASTNode;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.emf.ocl.utilities.UtilitiesFactory;
import org.eclipse.emf.ocl.utilities.UtilitiesPackage;
import org.eclipse.emf.ocl.utilities.Visitable;
/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package </b>. <!--
 * end-user-doc -->
 * @generated
 */
public class UtilitiesPackageImpl extends EPackageImpl implements
        UtilitiesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

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
	private EClass typedASTNodeEClass = null;

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
	private EDataType semanticExceptionEDataType = null;

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
     * @see org.eclipse.emf.ocl.utilities.UtilitiesPackage#eNS_URI
     * @see #init()
     * @generated NOT
     */
    private UtilitiesPackageImpl() {
		super(eNS_URI, UtilitiesFactory.eINSTANCE);
		
		ExpressionsPackageImpl.OCL_ROOT_PACKAGE.getESubpackages().add(this);
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
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		UMLPackageImpl theUMLPackage = (UMLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI) instanceof UMLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI) : UMLPackage.eINSTANCE);
		QueryPackageImpl theQueryPackage = (QueryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) instanceof QueryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) : QueryPackage.eINSTANCE);

		// Create package meta-data objects
		theUtilitiesPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theUMLPackage.createPackageContents();
		theQueryPackage.createPackageContents();

		// Initialize created meta-data
		theUtilitiesPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theUMLPackage.initializePackageContents();
		theQueryPackage.initializePackageContents();

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
	public EDataType getSemanticException() {
		return semanticExceptionEDataType;
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
		astNodeEClass = createEClass(AST_NODE);
		createEAttribute(astNodeEClass, AST_NODE__START_POSITION);
		createEAttribute(astNodeEClass, AST_NODE__END_POSITION);

		callingASTNodeEClass = createEClass(CALLING_AST_NODE);
		createEAttribute(callingASTNodeEClass, CALLING_AST_NODE__PROPERTY_START_POSITION);
		createEAttribute(callingASTNodeEClass, CALLING_AST_NODE__PROPERTY_END_POSITION);

		predefinedTypeEClass = createEClass(PREDEFINED_TYPE);

		typedASTNodeEClass = createEClass(TYPED_AST_NODE);
		createEAttribute(typedASTNodeEClass, TYPED_AST_NODE__TYPE_START_POSITION);
		createEAttribute(typedASTNodeEClass, TYPED_AST_NODE__TYPE_END_POSITION);

		visitableEClass = createEClass(VISITABLE);

		// Create data types
		semanticExceptionEDataType = createEDataType(SEMANTIC_EXCEPTION);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Add supertypes to classes
		callingASTNodeEClass.getESuperTypes().add(this.getASTNode());
		typedASTNodeEClass.getESuperTypes().add(this.getASTNode());

		// Initialize classes and features; add operations and parameters
		initEClass(astNodeEClass, ASTNode.class, "ASTNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getASTNode_StartPosition(), theEcorePackage.getEInt(), "startPosition", "-1", 0, 1, ASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getASTNode_EndPosition(), theEcorePackage.getEInt(), "endPosition", "-1", 0, 1, ASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(callingASTNodeEClass, CallingASTNode.class, "CallingASTNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getCallingASTNode_PropertyStartPosition(), theEcorePackage.getEInt(), "propertyStartPosition", "-1", 0, 1, CallingASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getCallingASTNode_PropertyEndPosition(), theEcorePackage.getEInt(), "propertyEndPosition", "-1", 0, 1, CallingASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(predefinedTypeEClass, PredefinedType.class, "PredefinedType", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(predefinedTypeEClass, theEcorePackage.getEOperation(), "getOperations", 0, -1); //$NON-NLS-1$

		EOperation op = addEOperation(predefinedTypeEClass, theEcorePackage.getEString(), "getOperationNameFor", 0, 1); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEInt(), "opcode", 0, 1); //$NON-NLS-1$

		op = addEOperation(predefinedTypeEClass, theEcorePackage.getEInt(), "getOperationCodeFor", 0, 1); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEString(), "operName", 0, 1); //$NON-NLS-1$

		op = addEOperation(predefinedTypeEClass, theEcorePackage.getEClassifier(), "getResultTypeFor", 0, 1); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEClassifier(), "ownerType", 1, 1); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEInt(), "opcode", 0, 1); //$NON-NLS-1$
		addEParameter(op, theExpressionsPackage.getOCLExpression(), "args", 0, -1); //$NON-NLS-1$
		addEException(op, this.getSemanticException());

		op = addEOperation(predefinedTypeEClass, theEcorePackage.getEInt(), "getRelationshipTo", 0, 1); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEClassifier(), "type", 1, 1); //$NON-NLS-1$

		op = addEOperation(predefinedTypeEClass, theEcorePackage.getEClassifier(), "getCommonSupertype", 0, 1); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEClassifier(), "type", 1, 1); //$NON-NLS-1$
		addEException(op, this.getSemanticException());

		initEClass(typedASTNodeEClass, TypedASTNode.class, "TypedASTNode", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTypedASTNode_TypeStartPosition(), theEcorePackage.getEInt(), "typeStartPosition", "-1", 0, 1, TypedASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getTypedASTNode_TypeEndPosition(), theEcorePackage.getEInt(), "typeEndPosition", "-1", 0, 1, TypedASTNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(visitableEClass, Visitable.class, "Visitable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = addEOperation(visitableEClass, theEcorePackage.getEJavaObject(), "accept", 0, 1); //$NON-NLS-1$
		addEParameter(op, theExpressionsPackage.getVisitor(), "v", 0, 1); //$NON-NLS-1$

		// Initialize data types
		initEDataType(semanticExceptionEDataType, SemanticException.class, "SemanticException", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //UtilitiesPackageImpl
