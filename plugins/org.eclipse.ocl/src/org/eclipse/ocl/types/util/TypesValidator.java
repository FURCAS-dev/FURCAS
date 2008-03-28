/**
 * <copyright>
 * 
 * Copyright (c) 2008 IBM Corporation and others.
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
 * $Id: TypesValidator.java,v 1.1 2008/03/28 20:33:33 cdamus Exp $
 */
package org.eclipse.ocl.types.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.types.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.types.TypesPackage
 * @generated
 * @since 1.2
 */
public class TypesValidator extends EObjectValidator {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final TypesValidator INSTANCE = new TypesValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.types"; //$NON-NLS-1$

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Collection Type Name' of 'Bag Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int BAG_TYPE__COLLECTION_TYPE_NAME = 1;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Collection Type Name' of 'Collection Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int COLLECTION_TYPE__COLLECTION_TYPE_NAME = 2;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check No Invalid Values' of 'Collection Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int COLLECTION_TYPE__NO_INVALID_VALUES = 3;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Exclusive Signature' of 'Message Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int MESSAGE_TYPE__EXCLUSIVE_SIGNATURE = 4;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Operation Parameters' of 'Message Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int MESSAGE_TYPE__OPERATION_PARAMETERS = 5;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Signal Attributes' of 'Message Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int MESSAGE_TYPE__SIGNAL_ATTRIBUTES = 6;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Collection Type Name' of 'Ordered Set Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int ORDERED_SET_TYPE__COLLECTION_TYPE_NAME = 7;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Collection Type Name' of 'Sequence Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int SEQUENCE_TYPE__COLLECTION_TYPE_NAME = 8;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Collection Type Name' of 'Set Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int SET_TYPE__COLLECTION_TYPE_NAME = 9;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Tuple Type Name' of 'Tuple Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int TUPLE_TYPE__TUPLE_TYPE_NAME = 10;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Part Names Unique' of 'Tuple Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int TUPLE_TYPE__PART_NAMES_UNIQUE = 11;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Features Only Properties' of 'Tuple Type'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int TUPLE_TYPE__FEATURES_ONLY_PROPERTIES = 12;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 12;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypesValidator() {
        super();
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
      return TypesPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
            case TypesPackage.ANY_TYPE:
                return validateAnyType((AnyType<?>)value, diagnostics, context);
            case TypesPackage.BAG_TYPE:
                return validateBagType((BagType<?, ?>)value, diagnostics, context);
            case TypesPackage.COLLECTION_TYPE:
                return validateCollectionType((CollectionType<?, ?>)value, diagnostics, context);
            case TypesPackage.ELEMENT_TYPE:
                return validateElementType((ElementType)value, diagnostics, context);
            case TypesPackage.INVALID_TYPE:
                return validateInvalidType((InvalidType<?>)value, diagnostics, context);
            case TypesPackage.MESSAGE_TYPE:
                return validateMessageType((MessageType<?, ?, ?>)value, diagnostics, context);
            case TypesPackage.ORDERED_SET_TYPE:
                return validateOrderedSetType((OrderedSetType<?, ?>)value, diagnostics, context);
            case TypesPackage.PRIMITIVE_TYPE:
                return validatePrimitiveType((PrimitiveType<?>)value, diagnostics, context);
            case TypesPackage.SEQUENCE_TYPE:
                return validateSequenceType((SequenceType<?, ?>)value, diagnostics, context);
            case TypesPackage.SET_TYPE:
                return validateSetType((SetType<?, ?>)value, diagnostics, context);
            case TypesPackage.TUPLE_TYPE:
                return validateTupleType((TupleType<?, ?>)value, diagnostics, context);
            case TypesPackage.TYPE_TYPE:
                return validateTypeType((TypeType<?, ?>)value, diagnostics, context);
            case TypesPackage.VOID_TYPE:
                return validateVoidType((VoidType<?>)value, diagnostics, context);
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAnyType(AnyType<?> anyType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(anyType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateBagType(BagType<?, ?> bagType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(bagType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(bagType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(bagType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(bagType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(bagType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(bagType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(bagType, diagnostics, context);
        if (result || diagnostics != null) result &= validateBagType_checkCollectionTypeName(bagType, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionType_checkNoInvalidValues(bagType, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkCollectionTypeName constraint of '<em>Bag Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean validateBagType_checkCollectionTypeName(BagType<?, ?> bagType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // Bags are not named Collection(...)
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionType(CollectionType<?, ?> collectionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(collectionType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(collectionType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionType, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionType_checkCollectionTypeName(collectionType, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionType_checkNoInvalidValues(collectionType, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkCollectionTypeName constraint of '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionType_checkCollectionTypeName(CollectionType<?, ?> collectionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return collectionType.checkCollectionTypeName(diagnostics, context);
    }

    /**
     * Validates the checkNoInvalidValues constraint of '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionType_checkNoInvalidValues(CollectionType<?, ?> collectionType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return collectionType.checkNoInvalidValues(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateElementType(ElementType elementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(elementType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateInvalidType(InvalidType<?> invalidType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(invalidType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMessageType(MessageType<?, ?, ?> messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(messageType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(messageType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(messageType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(messageType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(messageType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(messageType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(messageType, diagnostics, context);
        if (result || diagnostics != null) result &= validateMessageType_checkExclusiveSignature(messageType, diagnostics, context);
        if (result || diagnostics != null) result &= validateMessageType_checkOperationParameters(messageType, diagnostics, context);
        if (result || diagnostics != null) result &= validateMessageType_checkSignalAttributes(messageType, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkExclusiveSignature constraint of '<em>Message Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMessageType_checkExclusiveSignature(MessageType<?, ?, ?> messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return messageType.checkExclusiveSignature(diagnostics, context);
    }

    /**
     * Validates the checkOperationParameters constraint of '<em>Message Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMessageType_checkOperationParameters(MessageType<?, ?, ?> messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return messageType.checkOperationParameters(diagnostics, context);
    }

    /**
     * Validates the checkSignalAttributes constraint of '<em>Message Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMessageType_checkSignalAttributes(MessageType<?, ?, ?> messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return messageType.checkSignalAttributes(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOrderedSetType(OrderedSetType<?, ?> orderedSetType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(orderedSetType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(orderedSetType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(orderedSetType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(orderedSetType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(orderedSetType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(orderedSetType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(orderedSetType, diagnostics, context);
        if (result || diagnostics != null) result &= validateOrderedSetType_checkCollectionTypeName(orderedSetType, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionType_checkNoInvalidValues(orderedSetType, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkCollectionTypeName constraint of '<em>Ordered Set Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean validateOrderedSetType_checkCollectionTypeName(OrderedSetType<?, ?> orderedSetType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // OrderedSets are not named Collection(...)
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePrimitiveType(PrimitiveType<?> primitiveType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(primitiveType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSequenceType(SequenceType<?, ?> sequenceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(sequenceType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(sequenceType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(sequenceType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(sequenceType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(sequenceType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(sequenceType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(sequenceType, diagnostics, context);
        if (result || diagnostics != null) result &= validateSequenceType_checkCollectionTypeName(sequenceType, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionType_checkNoInvalidValues(sequenceType, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkCollectionTypeName constraint of '<em>Sequence Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean validateSequenceType_checkCollectionTypeName(SequenceType<?, ?> sequenceType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // Sequences are not named Collection(...)
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSetType(SetType<?, ?> setType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(setType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(setType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(setType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(setType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(setType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(setType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(setType, diagnostics, context);
        if (result || diagnostics != null) result &= validateSetType_checkCollectionTypeName(setType, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionType_checkNoInvalidValues(setType, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkCollectionTypeName constraint of '<em>Set Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean validateSetType_checkCollectionTypeName(SetType<?, ?> setType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // Sets are not named Collection(...)
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTupleType(TupleType<?, ?> tupleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(tupleType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tupleType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tupleType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(tupleType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(tupleType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(tupleType, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tupleType, diagnostics, context);
        if (result || diagnostics != null) result &= validateTupleType_checkTupleTypeName(tupleType, diagnostics, context);
        if (result || diagnostics != null) result &= validateTupleType_checkPartNamesUnique(tupleType, diagnostics, context);
        if (result || diagnostics != null) result &= validateTupleType_checkFeaturesOnlyProperties(tupleType, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkTupleTypeName constraint of '<em>Tuple Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTupleType_checkTupleTypeName(TupleType<?, ?> tupleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return tupleType.checkTupleTypeName(diagnostics, context);
    }

    /**
     * Validates the checkPartNamesUnique constraint of '<em>Tuple Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTupleType_checkPartNamesUnique(TupleType<?, ?> tupleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return tupleType.checkPartNamesUnique(diagnostics, context);
    }

    /**
     * Validates the checkFeaturesOnlyProperties constraint of '<em>Tuple Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTupleType_checkFeaturesOnlyProperties(TupleType<?, ?> tupleType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return tupleType.checkFeaturesOnlyProperties(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTypeType(TypeType<?, ?> typeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(typeType, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVoidType(VoidType<?> voidType, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(voidType, diagnostics, context);
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return OCLPlugin.INSTANCE;
    }

} //TypesValidator
