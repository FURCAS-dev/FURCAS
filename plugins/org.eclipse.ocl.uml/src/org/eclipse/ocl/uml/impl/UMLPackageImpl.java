/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: UMLPackageImpl.java,v 1.2 2007/02/14 13:42:07 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.uml.AnyType;
import org.eclipse.ocl.uml.BagType;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.uml.ElementType;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.InvalidType;
import org.eclipse.ocl.uml.MessageType;
import org.eclipse.ocl.uml.OrderedSetType;
import org.eclipse.ocl.uml.PrimitiveType;
import org.eclipse.ocl.uml.SequenceType;
import org.eclipse.ocl.uml.SetType;
import org.eclipse.ocl.uml.TupleType;
import org.eclipse.ocl.uml.TypeType;
import org.eclipse.ocl.uml.UMLFactory;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.uml.VoidType;
import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLPackageImpl extends EPackageImpl implements UMLPackage {
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
    private EClass voidTypeEClass = null;

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
    private EClass elementTypeEClass = null;

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
    private EClass messageTypeEClass = null;

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
    private EClass collectionTypeEClass = null;

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
    private EClass bagTypeEClass = null;

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
    private EClass orderedSetTypeEClass = null;

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
     * @see org.eclipse.ocl.uml.UMLPackage#eNS_URI
     * @see #init()
     * @generated NOT
     */
    private UMLPackageImpl() {
        super(eNS_URI, UMLFactory.eINSTANCE);
        
        ExpressionsPackageImpl.OCL_ROOT_PACKAGE.getESubpackages().add(this);
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
    public static UMLPackage init() {
        if (isInited) return (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

        // Obtain or create and register package
        UMLPackageImpl theUMLPackage = (UMLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof UMLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new UMLPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();
        TypesPackage.eINSTANCE.eClass();
        ExpressionsPackage.eINSTANCE.eClass();
        UtilitiesPackage.eINSTANCE.eClass();
        org.eclipse.uml2.uml.UMLPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theUMLPackage.createPackageContents();

        // Initialize created meta-data
        theUMLPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theUMLPackage.freeze();

        return theUMLPackage;
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
    public EReference getAnyType_OwnedOperations() {
        return (EReference)anyTypeEClass.getEStructuralFeatures().get(0);
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
    public EReference getVoidType_OwnedOperations() {
        return (EReference)voidTypeEClass.getEStructuralFeatures().get(0);
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
    public EReference getInvalidType_OwnedOperations() {
        return (EReference)invalidTypeEClass.getEStructuralFeatures().get(0);
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
    public EClass getTypeType() {
        return typeTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTypeType_OwnedOperations() {
        return (EReference)typeTypeEClass.getEStructuralFeatures().get(0);
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
    public EReference getMessageType_OwnedOperations() {
        return (EReference)messageTypeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMessageType_OwnedAttributes() {
        return (EReference)messageTypeEClass.getEStructuralFeatures().get(1);
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
    public EClass getCollectionType() {
        return collectionTypeEClass;
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
    public EClass getBagType() {
        return bagTypeEClass;
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
    public EClass getOrderedSetType() {
        return orderedSetTypeEClass;
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
    public EClass getExpressionInOCL() {
        return expressionInOCLEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLFactory getUMLFactory() {
        return (UMLFactory)getEFactoryInstance();
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
        createEReference(anyTypeEClass, ANY_TYPE__OWNED_OPERATIONS);

        voidTypeEClass = createEClass(VOID_TYPE);
        createEReference(voidTypeEClass, VOID_TYPE__OWNED_OPERATIONS);

        invalidTypeEClass = createEClass(INVALID_TYPE);
        createEReference(invalidTypeEClass, INVALID_TYPE__OWNED_OPERATIONS);

        elementTypeEClass = createEClass(ELEMENT_TYPE);

        typeTypeEClass = createEClass(TYPE_TYPE);
        createEReference(typeTypeEClass, TYPE_TYPE__OWNED_OPERATIONS);

        messageTypeEClass = createEClass(MESSAGE_TYPE);
        createEReference(messageTypeEClass, MESSAGE_TYPE__OWNED_OPERATIONS);
        createEReference(messageTypeEClass, MESSAGE_TYPE__OWNED_ATTRIBUTES);

        primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

        collectionTypeEClass = createEClass(COLLECTION_TYPE);

        tupleTypeEClass = createEClass(TUPLE_TYPE);

        bagTypeEClass = createEClass(BAG_TYPE);

        setTypeEClass = createEClass(SET_TYPE);

        orderedSetTypeEClass = createEClass(ORDERED_SET_TYPE);

        sequenceTypeEClass = createEClass(SEQUENCE_TYPE);

        expressionInOCLEClass = createEClass(EXPRESSION_IN_OCL);
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

        // Obtain other dependent packages
        org.eclipse.uml2.uml.UMLPackage theUMLPackage_1 = (org.eclipse.uml2.uml.UMLPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.uml2.uml.UMLPackage.eNS_URI);
        TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
        UtilitiesPackage theUtilitiesPackage = (UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        EGenericType g1 = createEGenericType(theUMLPackage_1.getClassifier());
        anyTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getAnyType());
        EGenericType g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        anyTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUMLPackage_1.getClassifier());
        voidTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getVoidType());
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        voidTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUMLPackage_1.getClassifier());
        invalidTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getInvalidType());
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        invalidTypeEClass.getEGenericSuperTypes().add(g1);
        elementTypeEClass.getESuperTypes().add(theUMLPackage_1.getClassifier());
        elementTypeEClass.getESuperTypes().add(theTypesPackage.getElementType());
        g1 = createEGenericType(theUMLPackage_1.getClassifier());
        typeTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getTypeType());
        g2 = createEGenericType(theUMLPackage_1.getClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        typeTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUMLPackage_1.getClassifier());
        messageTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getMessageType());
        g2 = createEGenericType(theUMLPackage_1.getClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theUMLPackage_1.getProperty());
        g1.getETypeArguments().add(g2);
        messageTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUMLPackage_1.getPrimitiveType());
        primitiveTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getPrimitiveType());
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        primitiveTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUMLPackage_1.getDataType());
        collectionTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getCollectionType());
        g2 = createEGenericType(theUMLPackage_1.getClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        collectionTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUMLPackage_1.getDataType());
        tupleTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getTupleType());
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theUMLPackage_1.getProperty());
        g1.getETypeArguments().add(g2);
        tupleTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        bagTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getBagType());
        g2 = createEGenericType(theUMLPackage_1.getClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        bagTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        setTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getSetType());
        g2 = createEGenericType(theUMLPackage_1.getClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        setTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        orderedSetTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getOrderedSetType());
        g2 = createEGenericType(theUMLPackage_1.getClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        orderedSetTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        sequenceTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getSequenceType());
        g2 = createEGenericType(theUMLPackage_1.getClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theUMLPackage_1.getOperation());
        g1.getETypeArguments().add(g2);
        sequenceTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUMLPackage_1.getOpaqueExpression());
        expressionInOCLEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getExpressionInOCL());
        g2 = createEGenericType(theUMLPackage_1.getClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theUMLPackage_1.getParameter());
        g1.getETypeArguments().add(g2);
        expressionInOCLEClass.getEGenericSuperTypes().add(g1);

        // Initialize classes and features; add operations and parameters
        initEClass(anyTypeEClass, AnyType.class, "AnyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getAnyType_OwnedOperations(), theUMLPackage_1.getOperation(), null, "ownedOperations", null, 0, -1, AnyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(voidTypeEClass, VoidType.class, "VoidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getVoidType_OwnedOperations(), theUMLPackage_1.getOperation(), null, "ownedOperations", null, 0, -1, VoidType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(invalidTypeEClass, InvalidType.class, "InvalidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getInvalidType_OwnedOperations(), theUMLPackage_1.getOperation(), null, "ownedOperations", null, 0, -1, InvalidType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(elementTypeEClass, ElementType.class, "ElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(typeTypeEClass, TypeType.class, "TypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getTypeType_OwnedOperations(), theUMLPackage_1.getOperation(), null, "ownedOperations", null, 0, -1, TypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(messageTypeEClass, MessageType.class, "MessageType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getMessageType_OwnedOperations(), theUMLPackage_1.getOperation(), null, "ownedOperations", null, 0, -1, MessageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getMessageType_OwnedAttributes(), theUMLPackage_1.getProperty(), null, "ownedAttributes", null, 0, -1, MessageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(collectionTypeEClass, CollectionType.class, "CollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(tupleTypeEClass, TupleType.class, "TupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(bagTypeEClass, BagType.class, "BagType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(setTypeEClass, SetType.class, "SetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(orderedSetTypeEClass, OrderedSetType.class, "OrderedSetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(sequenceTypeEClass, SequenceType.class, "SequenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(expressionInOCLEClass, ExpressionInOCL.class, "ExpressionInOCL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        // Create resource
        createResource(eNS_URI);
    }

} //UMLPackageImpl
