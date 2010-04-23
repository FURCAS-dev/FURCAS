/**
 * <copyright>
 * 
 * Copyright (c) 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: UMLValidator.java,v 1.4 2010/04/23 05:52:15 ewillink Exp $
 */
package org.eclipse.ocl.uml.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;

import org.eclipse.ocl.types.util.TypesValidator;

import org.eclipse.ocl.uml.*;

import org.eclipse.ocl.uml.internal.OCLUMLPlugin;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.uml.UMLPackage
 * @generated
 */
public class UMLValidator
		extends EObjectValidator {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final UMLValidator INSTANCE = new UMLValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.uml"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected org.eclipse.uml2.uml.util.UMLValidator umlValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypesValidator typesValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionsValidator expressionsValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLValidator() {
		super();
		umlValidator = org.eclipse.uml2.uml.util.UMLValidator.INSTANCE;
		typesValidator = TypesValidator.INSTANCE;
		expressionsValidator = ExpressionsValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return UMLPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case UMLPackage.ANY_TYPE :
				return validateAnyType((AnyType) value, diagnostics, context);
			case UMLPackage.VOID_TYPE :
				return validateVoidType((VoidType) value, diagnostics, context);
			case UMLPackage.INVALID_TYPE :
				return validateInvalidType((InvalidType) value, diagnostics,
					context);
			case UMLPackage.ELEMENT_TYPE :
				return validateElementType((ElementType) value, diagnostics,
					context);
			case UMLPackage.TYPE_TYPE :
				return validateTypeType((TypeType) value, diagnostics, context);
			case UMLPackage.MESSAGE_TYPE :
				return validateMessageType((MessageType) value, diagnostics,
					context);
			case UMLPackage.PRIMITIVE_TYPE :
				return validatePrimitiveType((PrimitiveType) value,
					diagnostics, context);
			case UMLPackage.COLLECTION_TYPE :
				return validateCollectionType((CollectionType) value,
					diagnostics, context);
			case UMLPackage.TUPLE_TYPE :
				return validateTupleType((TupleType) value, diagnostics,
					context);
			case UMLPackage.BAG_TYPE :
				return validateBagType((BagType) value, diagnostics, context);
			case UMLPackage.SET_TYPE :
				return validateSetType((SetType) value, diagnostics, context);
			case UMLPackage.ORDERED_SET_TYPE :
				return validateOrderedSetType((OrderedSetType) value,
					diagnostics, context);
			case UMLPackage.SEQUENCE_TYPE :
				return validateSequenceType((SequenceType) value, diagnostics,
					context);
			case UMLPackage.EXPRESSION_IN_OCL :
				return validateExpressionInOCL((ExpressionInOCL) value,
					diagnostics, context);
			case UMLPackage.ASSOCIATION_CLASS_CALL_EXP :
				return validateAssociationClassCallExp(
					(AssociationClassCallExp) value, diagnostics, context);
			case UMLPackage.NAVIGATION_CALL_EXP :
				return validateNavigationCallExp((NavigationCallExp) value,
					diagnostics, context);
			case UMLPackage.FEATURE_CALL_EXP :
				return validateFeatureCallExp((FeatureCallExp) value,
					diagnostics, context);
			case UMLPackage.CALL_EXP :
				return validateCallExp((CallExp) value, diagnostics, context);
			case UMLPackage.OCL_EXPRESSION :
				return validateOCLExpression((OCLExpression) value,
					diagnostics, context);
			case UMLPackage.BOOLEAN_LITERAL_EXP :
				return validateBooleanLiteralExp((BooleanLiteralExp) value,
					diagnostics, context);
			case UMLPackage.PRIMITIVE_LITERAL_EXP :
				return validatePrimitiveLiteralExp((PrimitiveLiteralExp) value,
					diagnostics, context);
			case UMLPackage.LITERAL_EXP :
				return validateLiteralExp((LiteralExp) value, diagnostics,
					context);
			case UMLPackage.COLLECTION_ITEM :
				return validateCollectionItem((CollectionItem) value,
					diagnostics, context);
			case UMLPackage.COLLECTION_LITERAL_PART :
				return validateCollectionLiteralPart(
					(CollectionLiteralPart) value, diagnostics, context);
			case UMLPackage.COLLECTION_LITERAL_EXP :
				return validateCollectionLiteralExp(
					(CollectionLiteralExp) value, diagnostics, context);
			case UMLPackage.COLLECTION_RANGE :
				return validateCollectionRange((CollectionRange) value,
					diagnostics, context);
			case UMLPackage.ENUM_LITERAL_EXP :
				return validateEnumLiteralExp((EnumLiteralExp) value,
					diagnostics, context);
			case UMLPackage.IF_EXP :
				return validateIfExp((IfExp) value, diagnostics, context);
			case UMLPackage.INTEGER_LITERAL_EXP :
				return validateIntegerLiteralExp((IntegerLiteralExp) value,
					diagnostics, context);
			case UMLPackage.NUMERIC_LITERAL_EXP :
				return validateNumericLiteralExp((NumericLiteralExp) value,
					diagnostics, context);
			case UMLPackage.UNLIMITED_NATURAL_LITERAL_EXP :
				return validateUnlimitedNaturalLiteralExp(
					(UnlimitedNaturalLiteralExp) value, diagnostics, context);
			case UMLPackage.INVALID_LITERAL_EXP :
				return validateInvalidLiteralExp((InvalidLiteralExp) value,
					diagnostics, context);
			case UMLPackage.ITERATE_EXP :
				return validateIterateExp((IterateExp) value, diagnostics,
					context);
			case UMLPackage.LOOP_EXP :
				return validateLoopExp((LoopExp) value, diagnostics, context);
			case UMLPackage.ITERATOR_EXP :
				return validateIteratorExp((IteratorExp) value, diagnostics,
					context);
			case UMLPackage.LET_EXP :
				return validateLetExp((LetExp) value, diagnostics, context);
			case UMLPackage.MESSAGE_EXP :
				return validateMessageExp((MessageExp) value, diagnostics,
					context);
			case UMLPackage.NULL_LITERAL_EXP :
				return validateNullLiteralExp((NullLiteralExp) value,
					diagnostics, context);
			case UMLPackage.OPERATION_CALL_EXP :
				return validateOperationCallExp((OperationCallExp) value,
					diagnostics, context);
			case UMLPackage.PROPERTY_CALL_EXP :
				return validatePropertyCallExp((PropertyCallExp) value,
					diagnostics, context);
			case UMLPackage.REAL_LITERAL_EXP :
				return validateRealLiteralExp((RealLiteralExp) value,
					diagnostics, context);
			case UMLPackage.STATE_EXP :
				return validateStateExp((StateExp) value, diagnostics, context);
			case UMLPackage.STRING_LITERAL_EXP :
				return validateStringLiteralExp((StringLiteralExp) value,
					diagnostics, context);
			case UMLPackage.TUPLE_LITERAL_EXP :
				return validateTupleLiteralExp((TupleLiteralExp) value,
					diagnostics, context);
			case UMLPackage.TUPLE_LITERAL_PART :
				return validateTupleLiteralPart((TupleLiteralPart) value,
					diagnostics, context);
			case UMLPackage.TYPE_EXP :
				return validateTypeExp((TypeExp) value, diagnostics, context);
			case UMLPackage.UNSPECIFIED_VALUE_EXP :
				return validateUnspecifiedValueExp((UnspecifiedValueExp) value,
					diagnostics, context);
			case UMLPackage.VARIABLE :
				return validateVariable((Variable) value, diagnostics, context);
			case UMLPackage.VARIABLE_EXP :
				return validateVariableExp((VariableExp) value, diagnostics,
					context);
			case UMLPackage.TEMPLATE_PARAMETER_TYPE :
				return validateTemplateParameterType(
					(TemplateParameterType) value, diagnostics, context);
			default :
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyType(AnyType anyType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(anyType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(anyType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(anyType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(anyType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(anyType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(anyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(anyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(anyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(anyType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(anyType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(anyType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(anyType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(anyType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(anyType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(anyType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					anyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					anyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(anyType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(anyType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				anyType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(anyType,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVoidType(VoidType voidType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(voidType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(voidType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(voidType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(voidType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(voidType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(voidType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(voidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(voidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(voidType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(voidType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(voidType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(voidType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(voidType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					voidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(voidType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					voidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					voidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(voidType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(voidType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				voidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(voidType,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvalidType(InvalidType invalidType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(invalidType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(invalidType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(invalidType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(invalidType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(invalidType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(invalidType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(invalidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(invalidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(invalidType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				invalidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				invalidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(invalidType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(invalidType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					invalidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(invalidType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					invalidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					invalidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(
					invalidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(
					invalidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				invalidType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(
					invalidType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElementType(ElementType elementType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(elementType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(elementType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(elementType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(elementType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(elementType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(elementType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(elementType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(elementType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(elementType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				elementType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				elementType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(elementType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(elementType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					elementType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(elementType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					elementType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					elementType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(
					elementType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(
					elementType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				elementType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(
					elementType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeType(TypeType typeType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(typeType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(typeType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(typeType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(typeType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(typeType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					typeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(typeType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					typeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					typeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(typeType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(typeType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				typeType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(typeType,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageType(MessageType messageType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(messageType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(messageType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(messageType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(messageType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(messageType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(messageType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(messageType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(messageType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(messageType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(messageType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(
					messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(
					messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(
					messageType, diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateMessageType_checkExclusiveSignature(messageType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateMessageType_checkOperationParameters(messageType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator.validateMessageType_checkSignalAttributes(
				messageType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveType(PrimitiveType primitiveType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(primitiveType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(primitiveType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(primitiveType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(primitiveType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(primitiveType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(primitiveType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(primitiveType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(primitiveType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(primitiveType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(
					primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(
					primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(
					primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				primitiveType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(
					primitiveType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionType(CollectionType collectionType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionType, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(collectionType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(collectionType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(collectionType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(collectionType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(collectionType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(collectionType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(collectionType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(
					collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(
					collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(
					collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(
					collectionType, diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateCollectionType_checkCollectionTypeName(collectionType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateCollectionType_checkNoInvalidValues(collectionType,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleType(TupleType tupleType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(tupleType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(tupleType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(tupleType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(tupleType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(tupleType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(tupleType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(tupleType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(tupleType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(tupleType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				tupleType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(tupleType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(tupleType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(tupleType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					tupleType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(tupleType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					tupleType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					tupleType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(tupleType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(
					tupleType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				tupleType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(tupleType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator.validateTupleType_checkTupleTypeName(
				tupleType, diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator.validateTupleType_checkPartNamesUnique(
				tupleType, diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateTupleType_checkFeaturesOnlyProperties(tupleType,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBagType(BagType bagType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(bagType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(bagType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(bagType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(bagType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(bagType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(bagType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(bagType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(bagType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(bagType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(bagType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(bagType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(bagType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(bagType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(bagType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(bagType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					bagType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					bagType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(bagType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(bagType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				bagType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(bagType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateCollectionType_checkCollectionTypeName(bagType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateCollectionType_checkNoInvalidValues(bagType,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetType(SetType setType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(setType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(setType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(setType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(setType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(setType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(setType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(setType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(setType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(setType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(setType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(setType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(setType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(setType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(setType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(setType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					setType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					setType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(setType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(setType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				setType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(setType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateCollectionType_checkCollectionTypeName(setType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateCollectionType_checkNoInvalidValues(setType,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedSetType(OrderedSetType orderedSetType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(orderedSetType, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(orderedSetType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(orderedSetType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(orderedSetType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(orderedSetType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(orderedSetType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(orderedSetType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(orderedSetType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(
					orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(
					orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(
					orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(
					orderedSetType, diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateCollectionType_checkCollectionTypeName(orderedSetType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateCollectionType_checkNoInvalidValues(orderedSetType,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceType(SequenceType sequenceType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(sequenceType, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(sequenceType,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(sequenceType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(sequenceType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(sequenceType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(sequenceType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(sequenceType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(sequenceType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(sequenceType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(sequenceType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(
					sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(
					sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(
					sequenceType, diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateCollectionType_checkCollectionTypeName(sequenceType,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= typesValidator
				.validateCollectionType_checkNoInvalidValues(sequenceType,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionInOCL(ExpressionInOCL expressionInOCL,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(expressionInOCL, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(expressionInOCL,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(expressionInOCL,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(expressionInOCL,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				expressionInOCL, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(expressionInOCL, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(expressionInOCL, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(expressionInOCL, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(expressionInOCL,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				expressionInOCL, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				expressionInOCL, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					expressionInOCL, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(expressionInOCL,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					expressionInOCL, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateOpaqueExpression_validateLanguageBodySize(
					expressionInOCL, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateOpaqueExpression_validateOnlyReturnResultParameters(
					expressionInOCL, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateOpaqueExpression_validateOneReturnResultParameter(
					expressionInOCL, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationClassCallExp(
			AssociationClassCallExp associationClassCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(associationClassCallExp,
			diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
			associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(associationClassCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(associationClassCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(associationClassCallExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(associationClassCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(associationClassCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					associationClassCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(associationClassCallExp,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNavigationCallExp(
			NavigationCallExp navigationCallExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(navigationCallExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(navigationCallExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(navigationCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(navigationCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				navigationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(navigationCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(navigationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(navigationCallExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(navigationCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				navigationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				navigationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					navigationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					navigationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					navigationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(navigationCallExp,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureCallExp(FeatureCallExp featureCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(featureCallExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(featureCallExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(featureCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(featureCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				featureCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(featureCallExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(featureCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(featureCallExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(featureCallExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				featureCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				featureCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					featureCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(featureCallExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					featureCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(featureCallExp,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallExp(CallExp callExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(callExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(callExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(callExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(callExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(callExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(callExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(callExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(callExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(callExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(callExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(callExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(callExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(callExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(callExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(callExp, diagnostics,
				context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOCLExpression(OCLExpression oclExpression,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(oclExpression, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(oclExpression,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(oclExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(oclExpression,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				oclExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(oclExpression, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(oclExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(oclExpression, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(oclExpression, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				oclExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				oclExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(oclExpression,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(oclExpression,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					oclExpression, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(oclExpression,
				diagnostics, context);
		return result;
	}

	/**
	 * Validates the has_type constraint of '<em>OCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateOCLExpression_has_type(OCLExpression oclExpression,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (oclExpression.getType() == null) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR,
					DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
					new Object[]{
						"has_type", getObjectLabel(oclExpression, context)}, //$NON-NLS-1$
					new Object[]{oclExpression}, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteralExp(
			BooleanLiteralExp booleanLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(booleanLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(booleanLiteralExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(booleanLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(booleanLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(booleanLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(booleanLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(booleanLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					booleanLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(booleanLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateBooleanLiteralExp_checkBooleanType(booleanLiteralExp,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveLiteralExp(
			PrimitiveLiteralExp primitiveLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(primitiveLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
			primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(primitiveLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(primitiveLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(primitiveLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(primitiveLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(primitiveLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(primitiveLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					primitiveLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(primitiveLiteralExp,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralExp(LiteralExp literalExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(literalExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(literalExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(literalExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(literalExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(literalExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(literalExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(literalExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(literalExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(literalExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				literalExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(literalExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(literalExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(literalExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					literalExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(literalExp, diagnostics,
				context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionItem(CollectionItem collectionItem,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionItem, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(collectionItem,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(collectionItem,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(collectionItem,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				collectionItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(collectionItem, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(collectionItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(collectionItem, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(collectionItem, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				collectionItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				collectionItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					collectionItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(collectionItem,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					collectionItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateCollectionItem_checkItemType(collectionItem,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralPart(
			CollectionLiteralPart collectionLiteralPart,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionLiteralPart, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
			collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(collectionLiteralPart,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(collectionLiteralPart,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(collectionLiteralPart,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(collectionLiteralPart, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(collectionLiteralPart,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(collectionLiteralPart,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					collectionLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					collectionLiteralPart, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp(
			CollectionLiteralExp collectionLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
			collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(collectionLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(collectionLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(collectionLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(collectionLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(collectionLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(collectionLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(collectionLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateCollectionLiteralExp_checkNoCollectionInstances(
					collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateCollectionLiteralExp_checkSetKind(
					collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateCollectionLiteralExp_checkSequenceKind(
					collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateCollectionLiteralExp_checkBagKind(
					collectionLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateCollectionLiteralExp_checkElementType(
					collectionLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionRange(CollectionRange collectionRange,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collectionRange, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(collectionRange,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(collectionRange,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(collectionRange,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				collectionRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(collectionRange, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(collectionRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(collectionRange, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(collectionRange,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				collectionRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				collectionRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					collectionRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(collectionRange,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					collectionRange, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateCollectionRange_checkRangeType(collectionRange,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumLiteralExp(EnumLiteralExp enumLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(enumLiteralExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(enumLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(enumLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(enumLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(enumLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(enumLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(enumLiteralExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					enumLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(enumLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateEnumLiteralExp_checkEnumType(enumLiteralExp,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfExp(IfExp ifExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(ifExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(ifExp, diagnostics,
			context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(ifExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(ifExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(ifExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(ifExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(ifExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(ifExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(ifExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(ifExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(ifExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(ifExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(ifExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(ifExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(ifExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= expressionsValidator.validateIfExp_checkBooleanCondition(
				ifExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator.validateIfExp_checkIfType(ifExp,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerLiteralExp(
			IntegerLiteralExp integerLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(integerLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(integerLiteralExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(integerLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(integerLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(integerLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(integerLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(integerLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					integerLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(integerLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateIntegerLiteralExp_checkIntegerType(integerLiteralExp,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericLiteralExp(
			NumericLiteralExp numericLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(numericLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(numericLiteralExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(numericLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(numericLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(numericLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(numericLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(numericLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					numericLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(numericLiteralExp,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnlimitedNaturalLiteralExp(
			UnlimitedNaturalLiteralExp unlimitedNaturalLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unlimitedNaturalLiteralExp,
			diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
			unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(
				unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(
				unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(unlimitedNaturalLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(unlimitedNaturalLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(unlimitedNaturalLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(unlimitedNaturalLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(
				unlimitedNaturalLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateUnlimitedNaturalLiteralExp_checkNaturalType(
					unlimitedNaturalLiteralExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvalidLiteralExp(
			InvalidLiteralExp invalidLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(invalidLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(invalidLiteralExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(invalidLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(invalidLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(invalidLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(invalidLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(invalidLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					invalidLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(invalidLiteralExp,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp(IterateExp iterateExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(iterateExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(iterateExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(iterateExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(iterateExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(iterateExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(iterateExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(iterateExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(iterateExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(iterateExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				iterateExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(iterateExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(iterateExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(iterateExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					iterateExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(iterateExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateLoopExp_checkSourceCollection(iterateExp, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateLoopExp_checkLoopVariableInit(iterateExp, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateLoopExp_checkLoopVariableType(iterateExp, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= expressionsValidator.validateIterateExp_checkIterateType(
				iterateExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator.validateIterateExp_checkBodyType(
				iterateExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator.validateIterateExp_checkResultInit(
				iterateExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp(LoopExp loopExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(loopExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(loopExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(loopExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(loopExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(loopExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(loopExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(loopExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(loopExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(loopExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(loopExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(loopExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(loopExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(loopExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(loopExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(loopExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateLoopExp_checkSourceCollection(loopExp, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateLoopExp_checkLoopVariableInit(loopExp, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateLoopExp_checkLoopVariableType(loopExp, diagnostics,
					context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp(IteratorExp iteratorExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(iteratorExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(iteratorExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(iteratorExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(iteratorExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(iteratorExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(iteratorExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(iteratorExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(iteratorExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(iteratorExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				iteratorExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				iteratorExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(iteratorExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(iteratorExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					iteratorExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(iteratorExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateLoopExp_checkSourceCollection(iteratorExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateLoopExp_checkLoopVariableInit(iteratorExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateLoopExp_checkLoopVariableType(iteratorExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateIteratorExp_checkBooleanType(iteratorExp, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateIteratorExp_checkCollectType(iteratorExp, diagnostics,
					context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateIteratorExp_checkSelectRejectType(iteratorExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateIteratorExp_checkBooleanBodyType(iteratorExp,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetExp(LetExp letExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(letExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(letExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(letExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(letExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(letExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(letExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(letExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(letExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(letExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(letExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(letExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(letExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(letExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(letExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(letExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= expressionsValidator.validateLetExp_checkLetType(letExp,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageExp(MessageExp messageExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(messageExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(messageExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(messageExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(messageExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(messageExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(messageExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(messageExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(messageExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(messageExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				messageExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(messageExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(messageExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(messageExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					messageExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(messageExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateMessageExp_checkOperationArguments(messageExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateMessageExp_checkSignalArguments(messageExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateMessageExp_checkTargetDefinesOperation(messageExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateMessageExp_checkHasOperationOrSignal(messageExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateMessageExp_checkTargetNotCollection(messageExp,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNullLiteralExp(NullLiteralExp nullLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(nullLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(nullLiteralExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(nullLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(nullLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(nullLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(nullLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(nullLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(nullLiteralExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					nullLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(nullLiteralExp,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCallExp(OperationCallExp operationCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(operationCallExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(operationCallExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(operationCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(operationCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				operationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(operationCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(operationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(operationCallExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(operationCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				operationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				operationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					operationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					operationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					operationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(operationCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateOperationCallExp_checkArgumentsConform(
					operationCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateOperationCallExp_checkArgumentCount(operationCallExp,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCallExp(PropertyCallExp propertyCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(propertyCallExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(propertyCallExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(propertyCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(propertyCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				propertyCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(propertyCallExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(propertyCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(propertyCallExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(propertyCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				propertyCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				propertyCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					propertyCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(propertyCallExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					propertyCallExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(propertyCallExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validatePropertyCallExp_checkPropertyType(propertyCallExp,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealLiteralExp(RealLiteralExp realLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(realLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(realLiteralExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(realLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(realLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				realLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(realLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(realLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(realLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(realLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				realLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				realLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					realLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(realLiteralExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					realLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(realLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateRealLiteralExp_checkRealType(realLiteralExp,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateExp(StateExp stateExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(stateExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(stateExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(stateExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(stateExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(stateExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(stateExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(stateExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(stateExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(stateExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(stateExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(stateExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(stateExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(stateExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					stateExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(stateExp, diagnostics,
				context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringLiteralExp(StringLiteralExp stringLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(stringLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(stringLiteralExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(stringLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(stringLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(stringLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(stringLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(stringLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					stringLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(stringLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateStringLiteralExp_checkStringType(stringLiteralExp,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleLiteralExp(TupleLiteralExp tupleLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(tupleLiteralExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(tupleLiteralExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(tupleLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(tupleLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(tupleLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(tupleLiteralExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(tupleLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(tupleLiteralExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					tupleLiteralExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(tupleLiteralExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateTupleLiteralExp_checkTupleType(tupleLiteralExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateTupleLiteralExp_checkPartsUnique(tupleLiteralExp,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleLiteralPart(TupleLiteralPart tupleLiteralPart,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(tupleLiteralPart, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(tupleLiteralPart,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(tupleLiteralPart,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(tupleLiteralPart,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(tupleLiteralPart,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(tupleLiteralPart, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(tupleLiteralPart,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					tupleLiteralPart, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator
				.validateTupleLiteralPart_checkValueType(tupleLiteralPart,
					diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeExp(TypeExp typeExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(typeExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(typeExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(typeExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(typeExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(typeExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(typeExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(typeExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(typeExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(typeExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(typeExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(typeExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(typeExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(typeExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(typeExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(typeExp, diagnostics,
				context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnspecifiedValueExp(
			UnspecifiedValueExp unspecifiedValueExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unspecifiedValueExp, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
			unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(unspecifiedValueExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(unspecifiedValueExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(unspecifiedValueExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(unspecifiedValueExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(unspecifiedValueExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(unspecifiedValueExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					unspecifiedValueExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(unspecifiedValueExp,
				diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable(Variable variable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variable, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(variable,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(variable, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(variable, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(variable,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(variable, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(variable, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(variable, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(variable, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(variable,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(variable,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(variable,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(variable,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					variable, diagnostics, context);
		if (result || diagnostics != null)
			result &= expressionsValidator.validateVariable_checkInitType(
				variable, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableExp(VariableExp variableExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(variableExp, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(variableExp,
			diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(variableExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(variableExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(variableExp,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(variableExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(variableExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(variableExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(variableExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				variableExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				variableExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(variableExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(variableExp,
					diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					variableExp, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateOCLExpression_has_type(variableExp, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= expressionsValidator.validateVariableExp_checkVarType(
				variableExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterType(
			TemplateParameterType templateParameterType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(templateParameterType, diagnostics,
			context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(
			templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(templateParameterType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(templateParameterType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(
				templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(templateParameterType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_UniqueID(templateParameterType, diagnostics,
				context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(templateParameterType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(templateParameterType,
				diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateNotOwnSelf(
				templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateElement_validateHasOwner(
				templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasNoQualifiedName(
					templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateHasQualifiedName(
					templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamedElement_validateVisibilityNeedsOwnership(
					templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateNamespace_validateMembersDistinguishable(
					templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionContextValid(
					templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateRedefinableElement_validateRedefinitionConsistent(
					templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateNoCyclesInGeneralization(
					templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateGeneralizationHierarchies(
					templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator.validateClassifier_validateSpecializeType(
				templateParameterType, diagnostics, context);
		if (result || diagnostics != null)
			result &= umlValidator
				.validateClassifier_validateMapsToGeneralizationSet(
					templateParameterType, diagnostics, context);
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return OCLUMLPlugin.INSTANCE;
	}

} //UMLValidator
