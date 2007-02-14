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
 * $Id: EcorePackageImpl.java,v 1.2 2007/02/14 13:42:02 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.ecore.AnyType;
import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.ElementType;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.InvalidType;
import org.eclipse.ocl.ecore.MessageType;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.ecore.VoidType;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcorePackageImpl extends EPackageImpl implements EcorePackage {
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass callOperationActionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass constraintEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass sendSignalActionEClass = null;

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
     * @see org.eclipse.ocl.ecore.EcorePackage#eNS_URI
     * @see #init()
     * @generated NOT
     */
    private EcorePackageImpl() {
        super(eNS_URI, EcoreFactory.eINSTANCE);
        
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
    public static EcorePackage init() {
        if (isInited) return (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Obtain or create and register package
        EcorePackageImpl theEcorePackage = (EcorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EcorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EcorePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        org.eclipse.emf.ecore.EcorePackage.eINSTANCE.eClass();
        TypesPackage.eINSTANCE.eClass();
        ExpressionsPackage.eINSTANCE.eClass();
        UtilitiesPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theEcorePackage.createPackageContents();

        // Initialize created meta-data
        theEcorePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theEcorePackage.freeze();

        return theEcorePackage;
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
    public EClass getVoidType() {
        return voidTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCallOperationAction() {
        return callOperationActionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCallOperationAction_Operation() {
        return (EReference)callOperationActionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConstraint() {
        return constraintEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConstraint_Specification() {
        return (EReference)constraintEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConstraint_ConstrainedElements() {
        return (EReference)constraintEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConstraint_Stereotype() {
        return (EAttribute)constraintEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSendSignalAction() {
        return sendSignalActionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSendSignalAction_Signal() {
        return (EReference)sendSignalActionEClass.getEStructuralFeatures().get(0);
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
    public EcoreFactory getEcoreFactory() {
        return (EcoreFactory)getEFactoryInstance();
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

        elementTypeEClass = createEClass(ELEMENT_TYPE);

        invalidTypeEClass = createEClass(INVALID_TYPE);

        messageTypeEClass = createEClass(MESSAGE_TYPE);

        orderedSetTypeEClass = createEClass(ORDERED_SET_TYPE);

        primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

        sequenceTypeEClass = createEClass(SEQUENCE_TYPE);

        setTypeEClass = createEClass(SET_TYPE);

        tupleTypeEClass = createEClass(TUPLE_TYPE);

        typeTypeEClass = createEClass(TYPE_TYPE);

        voidTypeEClass = createEClass(VOID_TYPE);

        callOperationActionEClass = createEClass(CALL_OPERATION_ACTION);
        createEReference(callOperationActionEClass, CALL_OPERATION_ACTION__OPERATION);

        constraintEClass = createEClass(CONSTRAINT);
        createEReference(constraintEClass, CONSTRAINT__SPECIFICATION);
        createEReference(constraintEClass, CONSTRAINT__CONSTRAINED_ELEMENTS);
        createEAttribute(constraintEClass, CONSTRAINT__STEREOTYPE);

        sendSignalActionEClass = createEClass(SEND_SIGNAL_ACTION);
        createEReference(sendSignalActionEClass, SEND_SIGNAL_ACTION__SIGNAL);

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
        org.eclipse.emf.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.emf.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.ecore.EcorePackage.eNS_URI);
        TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
        UtilitiesPackage theUtilitiesPackage = (UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        EGenericType g1 = createEGenericType(theEcorePackage_1.getEClassifier());
        anyTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getAnyType());
        EGenericType g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        anyTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        bagTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getBagType());
        g2 = createEGenericType(theEcorePackage_1.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        bagTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theEcorePackage_1.getEDataType());
        collectionTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getCollectionType());
        g2 = createEGenericType(theEcorePackage_1.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        collectionTypeEClass.getEGenericSuperTypes().add(g1);
        elementTypeEClass.getESuperTypes().add(theEcorePackage_1.getEClass());
        elementTypeEClass.getESuperTypes().add(theTypesPackage.getElementType());
        g1 = createEGenericType(theEcorePackage_1.getEClassifier());
        invalidTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getInvalidType());
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        invalidTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theEcorePackage_1.getEClass());
        messageTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getMessageType());
        g2 = createEGenericType(theEcorePackage_1.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEStructuralFeature());
        g1.getETypeArguments().add(g2);
        messageTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        orderedSetTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getOrderedSetType());
        g2 = createEGenericType(theEcorePackage_1.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        orderedSetTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theEcorePackage_1.getEDataType());
        primitiveTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getPrimitiveType());
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        primitiveTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        sequenceTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getSequenceType());
        g2 = createEGenericType(theEcorePackage_1.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        sequenceTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionType());
        setTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getSetType());
        g2 = createEGenericType(theEcorePackage_1.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        setTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theEcorePackage_1.getEClass());
        tupleTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getTupleType());
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEStructuralFeature());
        g1.getETypeArguments().add(g2);
        tupleTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theEcorePackage_1.getEClassifier());
        typeTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getTypeType());
        g2 = createEGenericType(theEcorePackage_1.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        typeTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theEcorePackage_1.getEClassifier());
        voidTypeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theTypesPackage.getVoidType());
        g2 = createEGenericType(theEcorePackage_1.getEOperation());
        g1.getETypeArguments().add(g2);
        voidTypeEClass.getEGenericSuperTypes().add(g1);
        constraintEClass.getESuperTypes().add(theEcorePackage_1.getENamedElement());
        g1 = createEGenericType(theUtilitiesPackage.getExpressionInOCL());
        g2 = createEGenericType(theEcorePackage_1.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEParameter());
        g1.getETypeArguments().add(g2);
        expressionInOCLEClass.getEGenericSuperTypes().add(g1);

        // Initialize classes and features; add operations and parameters
        initEClass(anyTypeEClass, AnyType.class, "AnyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(bagTypeEClass, BagType.class, "BagType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(collectionTypeEClass, CollectionType.class, "CollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(elementTypeEClass, ElementType.class, "ElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(invalidTypeEClass, InvalidType.class, "InvalidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(messageTypeEClass, MessageType.class, "MessageType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(orderedSetTypeEClass, OrderedSetType.class, "OrderedSetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(sequenceTypeEClass, SequenceType.class, "SequenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(setTypeEClass, SetType.class, "SetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(tupleTypeEClass, TupleType.class, "TupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(typeTypeEClass, TypeType.class, "TypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(voidTypeEClass, VoidType.class, "VoidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(callOperationActionEClass, CallOperationAction.class, "CallOperationAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getCallOperationAction_Operation(), theEcorePackage_1.getEOperation(), null, "operation", null, 1, 1, CallOperationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(theUtilitiesPackage.getExpressionInOCL());
        g2 = createEGenericType(theEcorePackage_1.getEClassifier());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theEcorePackage_1.getEParameter());
        g1.getETypeArguments().add(g2);
        initEReference(getConstraint_Specification(), g1, null, "specification", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEReference(getConstraint_ConstrainedElements(), theEcorePackage_1.getENamedElement(), null, "constrainedElements", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getConstraint_Stereotype(), ecorePackage.getEString(), "stereotype", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(sendSignalActionEClass, SendSignalAction.class, "SendSignalAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEReference(getSendSignalAction_Signal(), theEcorePackage_1.getEClass(), null, "signal", null, 1, 1, SendSignalAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(expressionInOCLEClass, ExpressionInOCL.class, "ExpressionInOCL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

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

} //EcorePackageImpl
