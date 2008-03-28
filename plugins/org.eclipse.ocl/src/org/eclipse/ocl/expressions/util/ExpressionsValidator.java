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
 * $Id: ExpressionsValidator.java,v 1.1 2008/03/28 20:33:35 cdamus Exp $
 */
package org.eclipse.ocl.expressions.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.expressions.*;
import org.eclipse.ocl.internal.OCLPlugin;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.expressions.ExpressionsPackage
 * @generated
 * @since 1.2
 */
public class ExpressionsValidator extends EObjectValidator {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final ExpressionsValidator INSTANCE = new ExpressionsValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.expressions"; //$NON-NLS-1$

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Boolean Type' of 'Boolean Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int BOOLEAN_LITERAL_EXP__BOOLEAN_TYPE = 1;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Item Type' of 'Collection Item'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int COLLECTION_ITEM__ITEM_TYPE = 2;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check No Collection Instances' of 'Collection Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int COLLECTION_LITERAL_EXP__NO_COLLECTION_INSTANCES = 3;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Set Kind' of 'Collection Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int COLLECTION_LITERAL_EXP__SET_KIND = 4;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Sequence Kind' of 'Collection Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int COLLECTION_LITERAL_EXP__SEQUENCE_KIND = 5;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Bag Kind' of 'Collection Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int COLLECTION_LITERAL_EXP__BAG_KIND = 6;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Element Type' of 'Collection Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int COLLECTION_LITERAL_EXP__ELEMENT_TYPE = 7;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Range Type' of 'Collection Range'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int COLLECTION_RANGE__RANGE_TYPE = 8;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Enum Type' of 'Enum Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int ENUM_LITERAL_EXP__ENUM_TYPE = 9;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Boolean Condition' of 'If Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int IF_EXP__BOOLEAN_CONDITION = 10;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check If Type' of 'If Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int IF_EXP__IF_TYPE = 11;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Integer Type' of 'Integer Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int INTEGER_LITERAL_EXP__INTEGER_TYPE = 12;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Natural Type' of 'Unlimited Natural Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int UNLIMITED_NATURAL_LITERAL_EXP__NATURAL_TYPE = 13;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Iterate Type' of 'Iterate Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int ITERATE_EXP__ITERATE_TYPE = 14;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Body Type' of 'Iterate Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int ITERATE_EXP__BODY_TYPE = 15;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Result Init' of 'Iterate Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int ITERATE_EXP__RESULT_INIT = 16;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Source Collection' of 'Loop Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int LOOP_EXP__SOURCE_COLLECTION = 17;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Loop Variable Init' of 'Loop Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int LOOP_EXP__LOOP_VARIABLE_INIT = 18;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Loop Variable Type' of 'Loop Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int LOOP_EXP__LOOP_VARIABLE_TYPE = 19;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Init Type' of 'Variable'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int VARIABLE__INIT_TYPE = 20;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Boolean Type' of 'Iterator Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int ITERATOR_EXP__BOOLEAN_TYPE = 21;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Collect Type' of 'Iterator Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int ITERATOR_EXP__COLLECT_TYPE = 22;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Select Reject Type' of 'Iterator Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int ITERATOR_EXP__SELECT_REJECT_TYPE = 23;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Boolean Body Type' of 'Iterator Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int ITERATOR_EXP__BOOLEAN_BODY_TYPE = 24;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Let Type' of 'Let Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int LET_EXP__LET_TYPE = 25;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Operation Arguments' of 'Message Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int MESSAGE_EXP__OPERATION_ARGUMENTS = 26;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Signal Arguments' of 'Message Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int MESSAGE_EXP__SIGNAL_ARGUMENTS = 27;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Target Defines Operation' of 'Message Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int MESSAGE_EXP__TARGET_DEFINES_OPERATION = 28;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Has Operation Or Signal' of 'Message Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int MESSAGE_EXP__HAS_OPERATION_OR_SIGNAL = 29;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Target Not Collection' of 'Message Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int MESSAGE_EXP__TARGET_NOT_COLLECTION = 30;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Arguments Conform' of 'Operation Call Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int OPERATION_CALL_EXP__ARGUMENTS_CONFORM = 31;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Argument Count' of 'Operation Call Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int OPERATION_CALL_EXP__ARGUMENT_COUNT = 32;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Property Type' of 'Property Call Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int PROPERTY_CALL_EXP__PROPERTY_TYPE = 33;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Real Type' of 'Real Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int REAL_LITERAL_EXP__REAL_TYPE = 34;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check String Type' of 'String Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int STRING_LITERAL_EXP__STRING_TYPE = 35;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Tuple Type' of 'Tuple Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int TUPLE_LITERAL_EXP__TUPLE_TYPE = 36;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Parts Unique' of 'Tuple Literal Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int TUPLE_LITERAL_EXP__PARTS_UNIQUE = 37;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Value Type' of 'Tuple Literal Part'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int TUPLE_LITERAL_PART__VALUE_TYPE = 38;

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check Var Type' of 'Variable Exp'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int VARIABLE_EXP__VAR_TYPE = 39;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 39;

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
    public ExpressionsValidator() {
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
      return ExpressionsPackage.eINSTANCE;
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
            case ExpressionsPackage.ASSOCIATION_CLASS_CALL_EXP:
                return validateAssociationClassCallExp((AssociationClassCallExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.NAVIGATION_CALL_EXP:
                return validateNavigationCallExp((NavigationCallExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.FEATURE_CALL_EXP:
                return validateFeatureCallExp((FeatureCallExp<?>)value, diagnostics, context);
            case ExpressionsPackage.CALL_EXP:
                return validateCallExp((CallExp<?>)value, diagnostics, context);
            case ExpressionsPackage.OCL_EXPRESSION:
                return validateOCLExpression((OCLExpression<?>)value, diagnostics, context);
            case ExpressionsPackage.BOOLEAN_LITERAL_EXP:
                return validateBooleanLiteralExp((BooleanLiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.PRIMITIVE_LITERAL_EXP:
                return validatePrimitiveLiteralExp((PrimitiveLiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.LITERAL_EXP:
                return validateLiteralExp((LiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.COLLECTION_ITEM:
                return validateCollectionItem((CollectionItem<?>)value, diagnostics, context);
            case ExpressionsPackage.COLLECTION_LITERAL_PART:
                return validateCollectionLiteralPart((CollectionLiteralPart<?>)value, diagnostics, context);
            case ExpressionsPackage.COLLECTION_LITERAL_EXP:
                return validateCollectionLiteralExp((CollectionLiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.COLLECTION_RANGE:
                return validateCollectionRange((CollectionRange<?>)value, diagnostics, context);
            case ExpressionsPackage.ENUM_LITERAL_EXP:
                return validateEnumLiteralExp((EnumLiteralExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.IF_EXP:
                return validateIfExp((IfExp<?>)value, diagnostics, context);
            case ExpressionsPackage.INTEGER_LITERAL_EXP:
                return validateIntegerLiteralExp((IntegerLiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.NUMERIC_LITERAL_EXP:
                return validateNumericLiteralExp((NumericLiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.UNLIMITED_NATURAL_LITERAL_EXP:
                return validateUnlimitedNaturalLiteralExp((UnlimitedNaturalLiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.INVALID_LITERAL_EXP:
                return validateInvalidLiteralExp((InvalidLiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.ITERATE_EXP:
                return validateIterateExp((IterateExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.LOOP_EXP:
                return validateLoopExp((LoopExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.VARIABLE:
                return validateVariable((Variable<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.ITERATOR_EXP:
                return validateIteratorExp((IteratorExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.LET_EXP:
                return validateLetExp((LetExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.MESSAGE_EXP:
                return validateMessageExp((MessageExp<?, ?, ?>)value, diagnostics, context);
            case ExpressionsPackage.NULL_LITERAL_EXP:
                return validateNullLiteralExp((NullLiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.OPERATION_CALL_EXP:
                return validateOperationCallExp((OperationCallExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.PROPERTY_CALL_EXP:
                return validatePropertyCallExp((PropertyCallExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.REAL_LITERAL_EXP:
                return validateRealLiteralExp((RealLiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.STATE_EXP:
                return validateStateExp((StateExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.STRING_LITERAL_EXP:
                return validateStringLiteralExp((StringLiteralExp<?>)value, diagnostics, context);
            case ExpressionsPackage.TUPLE_LITERAL_EXP:
                return validateTupleLiteralExp((TupleLiteralExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.TUPLE_LITERAL_PART:
                return validateTupleLiteralPart((TupleLiteralPart<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.TYPE_EXP:
                return validateTypeExp((TypeExp<?>)value, diagnostics, context);
            case ExpressionsPackage.UNSPECIFIED_VALUE_EXP:
                return validateUnspecifiedValueExp((UnspecifiedValueExp<?>)value, diagnostics, context);
            case ExpressionsPackage.VARIABLE_EXP:
                return validateVariableExp((VariableExp<?, ?>)value, diagnostics, context);
            case ExpressionsPackage.COLLECTION_KIND:
                return validateCollectionKind((CollectionKind)value, diagnostics, context);
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAssociationClassCallExp(AssociationClassCallExp<?, ?> associationClassCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(associationClassCallExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNavigationCallExp(NavigationCallExp<?, ?> navigationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(navigationCallExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFeatureCallExp(FeatureCallExp<?> featureCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(featureCallExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCallExp(CallExp<?> callExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(callExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOCLExpression(OCLExpression<?> oclExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(oclExpression, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateBooleanLiteralExp(BooleanLiteralExp<?> booleanLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(booleanLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(booleanLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(booleanLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(booleanLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(booleanLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(booleanLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(booleanLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateBooleanLiteralExp_checkBooleanType(booleanLiteralExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkBooleanType constraint of '<em>Boolean Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateBooleanLiteralExp_checkBooleanType(BooleanLiteralExp<?> booleanLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return booleanLiteralExp.checkBooleanType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePrimitiveLiteralExp(PrimitiveLiteralExp<?> primitiveLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(primitiveLiteralExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLiteralExp(LiteralExp<?> literalExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(literalExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionItem(CollectionItem<?> collectionItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(collectionItem, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionItem, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionItem, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionItem, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(collectionItem, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionItem, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionItem, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionItem_checkItemType(collectionItem, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkItemType constraint of '<em>Collection Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionItem_checkItemType(CollectionItem<?> collectionItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return collectionItem.checkItemType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionLiteralPart(CollectionLiteralPart<?> collectionLiteralPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(collectionLiteralPart, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionLiteralExp(CollectionLiteralExp<?> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionLiteralExp_checkNoCollectionInstances(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionLiteralExp_checkSetKind(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionLiteralExp_checkSequenceKind(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionLiteralExp_checkBagKind(collectionLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionLiteralExp_checkElementType(collectionLiteralExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkNoCollectionInstances constraint of '<em>Collection Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionLiteralExp_checkNoCollectionInstances(CollectionLiteralExp<?> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return collectionLiteralExp.checkNoCollectionInstances(diagnostics, context);
    }

    /**
     * Validates the checkSetKind constraint of '<em>Collection Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionLiteralExp_checkSetKind(CollectionLiteralExp<?> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return collectionLiteralExp.checkSetKind(diagnostics, context);
    }

    /**
     * Validates the checkSequenceKind constraint of '<em>Collection Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionLiteralExp_checkSequenceKind(CollectionLiteralExp<?> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return collectionLiteralExp.checkSequenceKind(diagnostics, context);
    }

    /**
     * Validates the checkBagKind constraint of '<em>Collection Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionLiteralExp_checkBagKind(CollectionLiteralExp<?> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return collectionLiteralExp.checkBagKind(diagnostics, context);
    }

    /**
     * Validates the checkElementType constraint of '<em>Collection Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionLiteralExp_checkElementType(CollectionLiteralExp<?> collectionLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return collectionLiteralExp.checkElementType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionRange(CollectionRange<?> collectionRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(collectionRange, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collectionRange, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collectionRange, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(collectionRange, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(collectionRange, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(collectionRange, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collectionRange, diagnostics, context);
        if (result || diagnostics != null) result &= validateCollectionRange_checkRangeType(collectionRange, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkRangeType constraint of '<em>Collection Range</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionRange_checkRangeType(CollectionRange<?> collectionRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return collectionRange.checkRangeType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEnumLiteralExp(EnumLiteralExp<?, ?> enumLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(enumLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(enumLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateEnumLiteralExp_checkEnumType(enumLiteralExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkEnumType constraint of '<em>Enum Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEnumLiteralExp_checkEnumType(EnumLiteralExp<?, ?> enumLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return enumLiteralExp.checkEnumType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIfExp(IfExp<?> ifExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(ifExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(ifExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(ifExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(ifExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(ifExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(ifExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(ifExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateIfExp_checkBooleanCondition(ifExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateIfExp_checkIfType(ifExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkBooleanCondition constraint of '<em>If Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIfExp_checkBooleanCondition(IfExp<?> ifExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return ifExp.checkBooleanCondition(diagnostics, context);
    }

    /**
     * Validates the checkIfType constraint of '<em>If Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIfExp_checkIfType(IfExp<?> ifExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return ifExp.checkIfType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIntegerLiteralExp(IntegerLiteralExp<?> integerLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(integerLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(integerLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(integerLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(integerLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(integerLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(integerLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(integerLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateIntegerLiteralExp_checkIntegerType(integerLiteralExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkIntegerType constraint of '<em>Integer Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIntegerLiteralExp_checkIntegerType(IntegerLiteralExp<?> integerLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return integerLiteralExp.checkIntegerType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNumericLiteralExp(NumericLiteralExp<?> numericLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(numericLiteralExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<?> unlimitedNaturalLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(unlimitedNaturalLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unlimitedNaturalLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unlimitedNaturalLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(unlimitedNaturalLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(unlimitedNaturalLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(unlimitedNaturalLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unlimitedNaturalLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateUnlimitedNaturalLiteralExp_checkNaturalType(unlimitedNaturalLiteralExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkNaturalType constraint of '<em>Unlimited Natural Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUnlimitedNaturalLiteralExp_checkNaturalType(UnlimitedNaturalLiteralExp<?> unlimitedNaturalLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return unlimitedNaturalLiteralExp.checkNaturalType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateInvalidLiteralExp(InvalidLiteralExp<?> invalidLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(invalidLiteralExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIterateExp(IterateExp<?, ?> iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateLoopExp_checkSourceCollection(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateLoopExp_checkLoopVariableInit(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateLoopExp_checkLoopVariableType(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateIterateExp_checkIterateType(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateIterateExp_checkBodyType(iterateExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateIterateExp_checkResultInit(iterateExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkIterateType constraint of '<em>Iterate Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIterateExp_checkIterateType(IterateExp<?, ?> iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return iterateExp.checkIterateType(diagnostics, context);
    }

    /**
     * Validates the checkBodyType constraint of '<em>Iterate Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIterateExp_checkBodyType(IterateExp<?, ?> iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return iterateExp.checkBodyType(diagnostics, context);
    }

    /**
     * Validates the checkResultInit constraint of '<em>Iterate Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIterateExp_checkResultInit(IterateExp<?, ?> iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return iterateExp.checkResultInit(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLoopExp(LoopExp<?, ?> loopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(loopExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(loopExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(loopExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(loopExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(loopExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(loopExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(loopExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateLoopExp_checkSourceCollection(loopExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateLoopExp_checkLoopVariableInit(loopExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateLoopExp_checkLoopVariableType(loopExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkSourceCollection constraint of '<em>Loop Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLoopExp_checkSourceCollection(LoopExp<?, ?> loopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return loopExp.checkSourceCollection(diagnostics, context);
    }

    /**
     * Validates the checkLoopVariableInit constraint of '<em>Loop Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLoopExp_checkLoopVariableInit(LoopExp<?, ?> loopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return loopExp.checkLoopVariableInit(diagnostics, context);
    }

    /**
     * Validates the checkLoopVariableType constraint of '<em>Loop Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLoopExp_checkLoopVariableType(LoopExp<?, ?> loopExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return loopExp.checkLoopVariableType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariable(Variable<?, ?> variable, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variable, diagnostics, context);
        if (result || diagnostics != null) result &= validateVariable_checkInitType(variable, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkInitType constraint of '<em>Variable</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariable_checkInitType(Variable<?, ?> variable, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return variable.checkInitType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIteratorExp(IteratorExp<?, ?> iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateLoopExp_checkSourceCollection(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateLoopExp_checkLoopVariableInit(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateLoopExp_checkLoopVariableType(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateIteratorExp_checkBooleanType(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateIteratorExp_checkCollectType(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateIteratorExp_checkSelectRejectType(iteratorExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateIteratorExp_checkBooleanBodyType(iteratorExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkBooleanType constraint of '<em>Iterator Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIteratorExp_checkBooleanType(IteratorExp<?, ?> iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return iteratorExp.checkBooleanType(diagnostics, context);
    }

    /**
     * Validates the checkCollectType constraint of '<em>Iterator Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIteratorExp_checkCollectType(IteratorExp<?, ?> iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return iteratorExp.checkCollectType(diagnostics, context);
    }

    /**
     * Validates the checkSelectRejectType constraint of '<em>Iterator Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIteratorExp_checkSelectRejectType(IteratorExp<?, ?> iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return iteratorExp.checkSelectRejectType(diagnostics, context);
    }

    /**
     * Validates the checkBooleanBodyType constraint of '<em>Iterator Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIteratorExp_checkBooleanBodyType(IteratorExp<?, ?> iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return iteratorExp.checkBooleanBodyType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLetExp(LetExp<?, ?> letExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(letExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(letExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(letExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(letExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(letExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(letExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(letExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateLetExp_checkLetType(letExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkLetType constraint of '<em>Let Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLetExp_checkLetType(LetExp<?, ?> letExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return letExp.checkLetType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMessageExp(MessageExp<?, ?, ?> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateMessageExp_checkOperationArguments(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateMessageExp_checkSignalArguments(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateMessageExp_checkTargetDefinesOperation(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateMessageExp_checkHasOperationOrSignal(messageExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateMessageExp_checkTargetNotCollection(messageExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkOperationArguments constraint of '<em>Message Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMessageExp_checkOperationArguments(MessageExp<?, ?, ?> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return messageExp.checkOperationArguments(diagnostics, context);
    }

    /**
     * Validates the checkSignalArguments constraint of '<em>Message Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMessageExp_checkSignalArguments(MessageExp<?, ?, ?> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return messageExp.checkSignalArguments(diagnostics, context);
    }

    /**
     * Validates the checkTargetDefinesOperation constraint of '<em>Message Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMessageExp_checkTargetDefinesOperation(MessageExp<?, ?, ?> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return messageExp.checkTargetDefinesOperation(diagnostics, context);
    }

    /**
     * Validates the checkHasOperationOrSignal constraint of '<em>Message Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMessageExp_checkHasOperationOrSignal(MessageExp<?, ?, ?> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return messageExp.checkHasOperationOrSignal(diagnostics, context);
    }

    /**
     * Validates the checkTargetNotCollection constraint of '<em>Message Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMessageExp_checkTargetNotCollection(MessageExp<?, ?, ?> messageExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return messageExp.checkTargetNotCollection(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNullLiteralExp(NullLiteralExp<?> nullLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(nullLiteralExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOperationCallExp(OperationCallExp<?, ?> operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(operationCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operationCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operationCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(operationCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(operationCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(operationCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operationCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateOperationCallExp_checkArgumentsConform(operationCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateOperationCallExp_checkArgumentCount(operationCallExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkArgumentsConform constraint of '<em>Operation Call Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOperationCallExp_checkArgumentsConform(OperationCallExp<?, ?> operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return operationCallExp.checkArgumentsConform(diagnostics, context);
    }

    /**
     * Validates the checkArgumentCount constraint of '<em>Operation Call Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOperationCallExp_checkArgumentCount(OperationCallExp<?, ?> operationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return operationCallExp.checkArgumentCount(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePropertyCallExp(PropertyCallExp<?, ?> propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(propertyCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(propertyCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(propertyCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(propertyCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(propertyCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(propertyCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(propertyCallExp, diagnostics, context);
        if (result || diagnostics != null) result &= validatePropertyCallExp_checkPropertyType(propertyCallExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkPropertyType constraint of '<em>Property Call Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePropertyCallExp_checkPropertyType(PropertyCallExp<?, ?> propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return propertyCallExp.checkPropertyType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateRealLiteralExp(RealLiteralExp<?> realLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(realLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(realLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(realLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(realLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(realLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(realLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(realLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateRealLiteralExp_checkRealType(realLiteralExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkRealType constraint of '<em>Real Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateRealLiteralExp_checkRealType(RealLiteralExp<?> realLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return realLiteralExp.checkRealType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStateExp(StateExp<?, ?> stateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(stateExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStringLiteralExp(StringLiteralExp<?> stringLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(stringLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(stringLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(stringLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(stringLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(stringLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(stringLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(stringLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateStringLiteralExp_checkStringType(stringLiteralExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkStringType constraint of '<em>String Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStringLiteralExp_checkStringType(StringLiteralExp<?> stringLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return stringLiteralExp.checkStringType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTupleLiteralExp(TupleLiteralExp<?, ?> tupleLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(tupleLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tupleLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tupleLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(tupleLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(tupleLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(tupleLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tupleLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateTupleLiteralExp_checkTupleType(tupleLiteralExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateTupleLiteralExp_checkPartsUnique(tupleLiteralExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkTupleType constraint of '<em>Tuple Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTupleLiteralExp_checkTupleType(TupleLiteralExp<?, ?> tupleLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return tupleLiteralExp.checkTupleType(diagnostics, context);
    }

    /**
     * Validates the checkPartsUnique constraint of '<em>Tuple Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTupleLiteralExp_checkPartsUnique(TupleLiteralExp<?, ?> tupleLiteralExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return tupleLiteralExp.checkPartsUnique(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTupleLiteralPart(TupleLiteralPart<?, ?> tupleLiteralPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(tupleLiteralPart, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(tupleLiteralPart, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(tupleLiteralPart, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(tupleLiteralPart, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(tupleLiteralPart, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(tupleLiteralPart, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(tupleLiteralPart, diagnostics, context);
        if (result || diagnostics != null) result &= validateTupleLiteralPart_checkValueType(tupleLiteralPart, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkValueType constraint of '<em>Tuple Literal Part</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTupleLiteralPart_checkValueType(TupleLiteralPart<?, ?> tupleLiteralPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return tupleLiteralPart.checkValueType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTypeExp(TypeExp<?> typeExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(typeExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUnspecifiedValueExp(UnspecifiedValueExp<?> unspecifiedValueExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(unspecifiedValueExp, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariableExp(VariableExp<?, ?> variableExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(variableExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(variableExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(variableExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(variableExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(variableExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(variableExp, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(variableExp, diagnostics, context);
        if (result || diagnostics != null) result &= validateVariableExp_checkVarType(variableExp, diagnostics, context);
        return result;
    }

    /**
     * Validates the checkVarType constraint of '<em>Variable Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariableExp_checkVarType(VariableExp<?, ?> variableExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return variableExp.checkVarType(diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCollectionKind(CollectionKind collectionKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
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

} //ExpressionsValidator
