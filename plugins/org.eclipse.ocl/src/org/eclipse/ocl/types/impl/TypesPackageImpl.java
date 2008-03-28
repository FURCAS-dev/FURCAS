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
 * $Id: TypesPackageImpl.java,v 1.8 2008/03/28 20:33:33 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.ElementType;
import org.eclipse.ocl.types.InvalidType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.types.TypesFactory;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.types.util.TypesValidator;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.impl.UtilitiesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass anyTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass bagTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass collectionTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass elementTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass invalidTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass messageTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass orderedSetTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass primitiveTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass sequenceTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass setTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass tupleTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typeTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass voidTypeEClass = null;

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
     * @see org.eclipse.ocl.types.TypesPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private TypesPackageImpl() {
        super(eNS_URI, TypesFactory.eINSTANCE);
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
	public static TypesPackage init() {
        if (isInited) return (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

        // Obtain or create and register package
        TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new TypesPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        UtilitiesPackageImpl theUtilitiesPackage = (UtilitiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI) instanceof UtilitiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI) : UtilitiesPackage.eINSTANCE);
        ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);

        // Create package meta-data objects
        theTypesPackage.createPackageContents();
        theUtilitiesPackage.createPackageContents();
        theExpressionsPackage.createPackageContents();

        // Initialize created meta-data
        theTypesPackage.initializePackageContents();
        theUtilitiesPackage.initializePackageContents();
        theExpressionsPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put
            (theTypesPackage, 
             new EValidator.Descriptor() {
                 public EValidator getEValidator() {
                     return TypesValidator.INSTANCE;
                 }
             });

        // Mark meta-data to indicate it can't be changed
        theTypesPackage.freeze();

        return theTypesPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAnyType() {
        return anyTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getBagType() {
        return bagTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCollectionType() {
        return collectionTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCollectionType_ElementType() {
        return (EReference)collectionTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCollectionType_Kind() {
        return (EAttribute)collectionTypeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getElementType() {
        return elementTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getInvalidType() {
        return invalidTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMessageType() {
        return messageTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMessageType_ReferredOperation() {
        return (EReference)messageTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMessageType_ReferredSignal() {
        return (EReference)messageTypeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOrderedSetType() {
        return orderedSetTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPrimitiveType() {
        return primitiveTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSequenceType() {
        return sequenceTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSetType() {
        return setTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTupleType() {
        return tupleTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTypeType() {
        return typeTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTypeType_ReferredType() {
        return (EReference)typeTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getVoidType() {
        return voidTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypesFactory getTypesFactory() {
        return (TypesFactory)getEFactoryInstance();
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
        anyTypeEClass = createEClass(ANY_TYPE);

        bagTypeEClass = createEClass(BAG_TYPE);

        collectionTypeEClass = createEClass(COLLECTION_TYPE);
        createEReference(collectionTypeEClass, COLLECTION_TYPE__ELEMENT_TYPE);
        createEAttribute(collectionTypeEClass, COLLECTION_TYPE__KIND);

        elementTypeEClass = createEClass(ELEMENT_TYPE);

        invalidTypeEClass = createEClass(INVALID_TYPE);

        messageTypeEClass = createEClass(MESSAGE_TYPE);
        createEReference(messageTypeEClass, MESSAGE_TYPE__REFERRED_OPERATION);
        createEReference(messageTypeEClass, MESSAGE_TYPE__REFERRED_SIGNAL);

        orderedSetTypeEClass = createEClass(ORDERED_SET_TYPE);

        primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

        sequenceTypeEClass = createEClass(SEQUENCE_TYPE);

        setTypeEClass = createEClass(SET_TYPE);

        tupleTypeEClass = createEClass(TUPLE_TYPE);

        typeTypeEClass = createEClass(TYPE_TYPE);
        createEReference(typeTypeEClass, TYPE_TYPE__REFERRED_TYPE);

        voidTypeEClass = createEClass(VOID_TYPE);
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
        UtilitiesPackage theUtilitiesPackage = (UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);
        ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

        // Create type parameters
        ETypeParameter anyTypeEClass_O = addETypeParameter(anyTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter bagTypeEClass_C = addETypeParameter(bagTypeEClass, "C"); //$NON-NLS-1$
        ETypeParameter bagTypeEClass_O = addETypeParameter(bagTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter collectionTypeEClass_C = addETypeParameter(collectionTypeEClass, "C"); //$NON-NLS-1$
        ETypeParameter collectionTypeEClass_O = addETypeParameter(collectionTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter invalidTypeEClass_O = addETypeParameter(invalidTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter messageTypeEClass_C = addETypeParameter(messageTypeEClass, "C"); //$NON-NLS-1$
        ETypeParameter messageTypeEClass_O = addETypeParameter(messageTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter messageTypeEClass_P = addETypeParameter(messageTypeEClass, "P"); //$NON-NLS-1$
        ETypeParameter orderedSetTypeEClass_C = addETypeParameter(orderedSetTypeEClass, "C"); //$NON-NLS-1$
        ETypeParameter orderedSetTypeEClass_O = addETypeParameter(orderedSetTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter primitiveTypeEClass_O = addETypeParameter(primitiveTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter sequenceTypeEClass_C = addETypeParameter(sequenceTypeEClass, "C"); //$NON-NLS-1$
        ETypeParameter sequenceTypeEClass_O = addETypeParameter(sequenceTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter setTypeEClass_C = addETypeParameter(setTypeEClass, "C"); //$NON-NLS-1$
        ETypeParameter setTypeEClass_O = addETypeParameter(setTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter tupleTypeEClass_O = addETypeParameter(tupleTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter tupleTypeEClass_P = addETypeParameter(tupleTypeEClass, "P"); //$NON-NLS-1$
        ETypeParameter typeTypeEClass_C = addETypeParameter(typeTypeEClass, "C"); //$NON-NLS-1$
        ETypeParameter typeTypeEClass_O = addETypeParameter(typeTypeEClass, "O"); //$NON-NLS-1$
        ETypeParameter voidTypeEClass_O = addETypeParameter(voidTypeEClass, "O"); //$NON-NLS-1$

        // Set bounds for type parameters

        // Add supertypes to classes
        EGenericType g1 = createEGenericType(theUtilitiesPackage.getPredefinedType());
        EGenericType g2 = createEGenericType(anyTypeEClass_O);
        g1.getETypeArguments().add(g2);
        anyTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        g2 = createEGenericType(bagTypeEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(bagTypeEClass_O);
        g1.getETypeArguments().add(g2);
        bagTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getPredefinedType());
        g2 = createEGenericType(collectionTypeEClass_O);
        g1.getETypeArguments().add(g2);
        collectionTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getTypedASTNode());
        collectionTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getPredefinedType());
        g2 = createEGenericType(invalidTypeEClass_O);
        g1.getETypeArguments().add(g2);
        invalidTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getPredefinedType());
        g2 = createEGenericType(messageTypeEClass_O);
        g1.getETypeArguments().add(g2);
        messageTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        g2 = createEGenericType(orderedSetTypeEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(orderedSetTypeEClass_O);
        g1.getETypeArguments().add(g2);
        orderedSetTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getPredefinedType());
        g2 = createEGenericType(primitiveTypeEClass_O);
        g1.getETypeArguments().add(g2);
        primitiveTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        g2 = createEGenericType(sequenceTypeEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(sequenceTypeEClass_O);
        g1.getETypeArguments().add(g2);
        sequenceTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        g2 = createEGenericType(setTypeEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(setTypeEClass_O);
        g1.getETypeArguments().add(g2);
        setTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getPredefinedType());
        g2 = createEGenericType(tupleTypeEClass_O);
        g1.getETypeArguments().add(g2);
        tupleTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getPredefinedType());
        g2 = createEGenericType(typeTypeEClass_O);
        g1.getETypeArguments().add(g2);
        typeTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getPredefinedType());
        g2 = createEGenericType(voidTypeEClass_O);
        g1.getETypeArguments().add(g2);
        voidTypeEClass.getEGenericSuperTypes().add(g1);

        // Initialize classes and features; add operations and parameters
        initEClass(anyTypeEClass, AnyType.class, "AnyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(bagTypeEClass, BagType.class, "BagType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(collectionTypeEClass, CollectionType.class, "CollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(collectionTypeEClass_C);
        initEReference(getCollectionType_ElementType(), g1, null, "elementType", null, 0, 1, CollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getCollectionType_Kind(), theExpressionsPackage.getCollectionKind(), "kind", null, 1, 1, CollectionType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        EOperation op = addEOperation(collectionTypeEClass, ecorePackage.getEBoolean(), "checkCollectionTypeName", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(collectionTypeEClass, ecorePackage.getEBoolean(), "checkNoInvalidValues", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(collectionTypeEClass, null, "oclIterators", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(collectionTypeEClass_O);
        initEOperation(op, g1);

        initEClass(elementTypeEClass, ElementType.class, "ElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(invalidTypeEClass, InvalidType.class, "InvalidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(messageTypeEClass, MessageType.class, "MessageType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(messageTypeEClass_O);
        initEReference(getMessageType_ReferredOperation(), g1, null, "referredOperation", null, 0, 1, MessageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(messageTypeEClass_C);
        initEReference(getMessageType_ReferredSignal(), g1, null, "referredSignal", null, 0, 1, MessageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(messageTypeEClass, ecorePackage.getEBoolean(), "checkExclusiveSignature", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(messageTypeEClass, ecorePackage.getEBoolean(), "checkOperationParameters", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(messageTypeEClass, ecorePackage.getEBoolean(), "checkSignalAttributes", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(messageTypeEClass, null, "oclProperties", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(messageTypeEClass_P);
        initEOperation(op, g1);

        initEClass(orderedSetTypeEClass, OrderedSetType.class, "OrderedSetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(sequenceTypeEClass, SequenceType.class, "SequenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(setTypeEClass, SetType.class, "SetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(tupleTypeEClass, TupleType.class, "TupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(tupleTypeEClass, ecorePackage.getEBoolean(), "checkTupleTypeName", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(tupleTypeEClass, ecorePackage.getEBoolean(), "checkPartNamesUnique", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(tupleTypeEClass, ecorePackage.getEBoolean(), "checkFeaturesOnlyProperties", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(tupleTypeEClass, null, "oclProperties", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(tupleTypeEClass_P);
        initEOperation(op, g1);

        initEClass(typeTypeEClass, TypeType.class, "TypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(typeTypeEClass_C);
        initEReference(getTypeType_ReferredType(), g1, null, "referredType", null, 1, 1, TypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(voidTypeEClass, VoidType.class, "VoidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // duplicates
        createDuplicatesAnnotations();
    }

    /**
     * Initializes the annotations for <b>duplicates</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createDuplicatesAnnotations() {
        String source = "duplicates"; //$NON-NLS-1$		
        addAnnotation
          (bagTypeEClass, 
           source, 
           new String[] {
           });																	
        addAnnotation
          (orderedSetTypeEClass, 
           source, 
           new String[] {
           });		
        addAnnotation
          (sequenceTypeEClass, 
           source, 
           new String[] {
           });		
        addAnnotation
          (setTypeEClass, 
           source, 
           new String[] {
           });										
    }

} //TypesPackageImpl
