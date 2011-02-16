/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotValidator.java,v 1.5 2011/02/15 10:38:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CallOperationAction;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.CompleteEnvironment;
import org.eclipse.ocl.examples.pivot.CompleteIteration;
import org.eclipse.ocl.examples.pivot.CompleteOperation;
import org.eclipse.ocl.examples.pivot.CompletePackage;
import org.eclipse.ocl.examples.pivot.CompleteProperty;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.FeatureCallExp;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.LiteralExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.MessageType;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.MultiplicityElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.NavigationCallExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.NumericLiteralExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OperationTemplateParameter;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.PackageableElement;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.SendSignalAction;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.Signal;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateParameterType;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.pivot.PivotPackage
 * @generated
 */
public class PivotValidator
		extends EObjectValidator {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final PivotValidator INSTANCE = new PivotValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.ocl.examples.pivot"; //$NON-NLS-1$

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Not Apply To Self' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__NOT_APPLY_TO_SELF = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Value Specification Boolean' of 'Constraint'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONSTRAINT__VALUE_SPECIFICATION_BOOLEAN = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Binding To Attribute' of 'Property'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROPERTY__BINDING_TO_ATTRIBUTE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Lower Ge0' of 'Multiplicity Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MULTIPLICITY_ELEMENT__LOWER_GE0 = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Upper Ge Lower' of 'Multiplicity Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MULTIPLICITY_ELEMENT__UPPER_GE_LOWER = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Language Body Size' of 'Opaque Expression'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPAQUE_EXPRESSION__LANGUAGE_BODY_SIZE = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Must Be Compatible' of 'Template Parameter'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_PARAMETER__MUST_BE_COMPATIBLE = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Own Elements' of 'Template Signature'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_SIGNATURE__OWN_ELEMENTS = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Parameter Substitution Formal' of 'Template Binding'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_BINDING__PARAMETER_SUBSTITUTION_FORMAL = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate One Parameter Substitution' of 'Template Binding'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_BINDING__ONE_PARAMETER_SUBSTITUTION = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Must Be Compatible' of 'Template Parameter Substitution'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TEMPLATE_PARAMETER_SUBSTITUTION__MUST_BE_COMPATIBLE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Test Constraint' of 'Operation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int OPERATION__TEST_CONSTRAINT = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Has Constraining Type' of 'Type Template Parameter'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int TYPE_TEMPLATE_PARAMETER__HAS_CONSTRAINING_TYPE = 13;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 13;

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
	public PivotValidator() {
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
	  return PivotPackage.eINSTANCE;
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
		switch (classifierID)
		{
			case PivotPackage.ANNOTATION:
				return validateAnnotation((Annotation)value, diagnostics, context);
			case PivotPackage.ANY_TYPE:
				return validateAnyType((AnyType)value, diagnostics, context);
			case PivotPackage.ASSOCIATION_CLASS:
				return validateAssociationClass((AssociationClass)value, diagnostics, context);
			case PivotPackage.ASSOCIATION_CLASS_CALL_EXP:
				return validateAssociationClassCallExp((AssociationClassCallExp)value, diagnostics, context);
			case PivotPackage.BAG_TYPE:
				return validateBagType((BagType)value, diagnostics, context);
			case PivotPackage.BOOLEAN_LITERAL_EXP:
				return validateBooleanLiteralExp((BooleanLiteralExp)value, diagnostics, context);
			case PivotPackage.CALL_EXP:
				return validateCallExp((CallExp)value, diagnostics, context);
			case PivotPackage.CALL_OPERATION_ACTION:
				return validateCallOperationAction((CallOperationAction)value, diagnostics, context);
			case PivotPackage.CLASS:
				return validateClass((org.eclipse.ocl.examples.pivot.Class)value, diagnostics, context);
			case PivotPackage.COLLECTION_ITEM:
				return validateCollectionItem((CollectionItem)value, diagnostics, context);
			case PivotPackage.COLLECTION_LITERAL_EXP:
				return validateCollectionLiteralExp((CollectionLiteralExp)value, diagnostics, context);
			case PivotPackage.COLLECTION_LITERAL_PART:
				return validateCollectionLiteralPart((CollectionLiteralPart)value, diagnostics, context);
			case PivotPackage.COLLECTION_RANGE:
				return validateCollectionRange((CollectionRange)value, diagnostics, context);
			case PivotPackage.COLLECTION_TYPE:
				return validateCollectionType((CollectionType)value, diagnostics, context);
			case PivotPackage.COMMENT:
				return validateComment((Comment)value, diagnostics, context);
			case PivotPackage.COMPLETE_ENVIRONMENT:
				return validateCompleteEnvironment((CompleteEnvironment)value, diagnostics, context);
			case PivotPackage.COMPLETE_ITERATION:
				return validateCompleteIteration((CompleteIteration)value, diagnostics, context);
			case PivotPackage.COMPLETE_OPERATION:
				return validateCompleteOperation((CompleteOperation)value, diagnostics, context);
			case PivotPackage.COMPLETE_PACKAGE:
				return validateCompletePackage((CompletePackage)value, diagnostics, context);
			case PivotPackage.COMPLETE_PROPERTY:
				return validateCompleteProperty((CompleteProperty)value, diagnostics, context);
			case PivotPackage.COMPLETE_TYPE:
				return validateCompleteType((CompleteType)value, diagnostics, context);
			case PivotPackage.CONSTRAINT:
				return validateConstraint((Constraint)value, diagnostics, context);
			case PivotPackage.DATA_TYPE:
				return validateDataType((DataType)value, diagnostics, context);
			case PivotPackage.DETAIL:
				return validateDetail((Detail)value, diagnostics, context);
			case PivotPackage.ELEMENT:
				return validateElement((Element)value, diagnostics, context);
			case PivotPackage.ENUM_LITERAL_EXP:
				return validateEnumLiteralExp((EnumLiteralExp)value, diagnostics, context);
			case PivotPackage.ENUMERATION:
				return validateEnumeration((Enumeration)value, diagnostics, context);
			case PivotPackage.ENUMERATION_LITERAL:
				return validateEnumerationLiteral((EnumerationLiteral)value, diagnostics, context);
			case PivotPackage.EXPRESSION_IN_OCL:
				return validateExpressionInOcl((ExpressionInOcl)value, diagnostics, context);
			case PivotPackage.FEATURE:
				return validateFeature((Feature)value, diagnostics, context);
			case PivotPackage.FEATURE_CALL_EXP:
				return validateFeatureCallExp((FeatureCallExp)value, diagnostics, context);
			case PivotPackage.IF_EXP:
				return validateIfExp((IfExp)value, diagnostics, context);
			case PivotPackage.INTEGER_LITERAL_EXP:
				return validateIntegerLiteralExp((IntegerLiteralExp)value, diagnostics, context);
			case PivotPackage.INVALID_LITERAL_EXP:
				return validateInvalidLiteralExp((InvalidLiteralExp)value, diagnostics, context);
			case PivotPackage.INVALID_TYPE:
				return validateInvalidType((InvalidType)value, diagnostics, context);
			case PivotPackage.ITERATE_EXP:
				return validateIterateExp((IterateExp)value, diagnostics, context);
			case PivotPackage.ITERATION:
				return validateIteration((Iteration)value, diagnostics, context);
			case PivotPackage.ITERATOR_EXP:
				return validateIteratorExp((IteratorExp)value, diagnostics, context);
			case PivotPackage.LAMBDA_TYPE:
				return validateLambdaType((LambdaType)value, diagnostics, context);
			case PivotPackage.LET_EXP:
				return validateLetExp((LetExp)value, diagnostics, context);
			case PivotPackage.LIBRARY:
				return validateLibrary((Library)value, diagnostics, context);
			case PivotPackage.LITERAL_EXP:
				return validateLiteralExp((LiteralExp)value, diagnostics, context);
			case PivotPackage.LOOP_EXP:
				return validateLoopExp((LoopExp)value, diagnostics, context);
			case PivotPackage.MESSAGE_EXP:
				return validateMessageExp((MessageExp)value, diagnostics, context);
			case PivotPackage.MESSAGE_TYPE:
				return validateMessageType((MessageType)value, diagnostics, context);
			case PivotPackage.MONIKERED_ELEMENT:
				return validateMonikeredElement((MonikeredElement)value, diagnostics, context);
			case PivotPackage.MULTIPLICITY_ELEMENT:
				return validateMultiplicityElement((MultiplicityElement)value, diagnostics, context);
			case PivotPackage.NAMEABLE:
				return validateNameable((Nameable)value, diagnostics, context);
			case PivotPackage.NAMED_ELEMENT:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case PivotPackage.NAMESPACE:
				return validateNamespace((Namespace)value, diagnostics, context);
			case PivotPackage.NAVIGATION_CALL_EXP:
				return validateNavigationCallExp((NavigationCallExp)value, diagnostics, context);
			case PivotPackage.NULL_LITERAL_EXP:
				return validateNullLiteralExp((NullLiteralExp)value, diagnostics, context);
			case PivotPackage.NUMERIC_LITERAL_EXP:
				return validateNumericLiteralExp((NumericLiteralExp)value, diagnostics, context);
			case PivotPackage.OCL_EXPRESSION:
				return validateOclExpression((OclExpression)value, diagnostics, context);
			case PivotPackage.OPAQUE_EXPRESSION:
				return validateOpaqueExpression((OpaqueExpression)value, diagnostics, context);
			case PivotPackage.OPERATION:
				return validateOperation((Operation)value, diagnostics, context);
			case PivotPackage.OPERATION_CALL_EXP:
				return validateOperationCallExp((OperationCallExp)value, diagnostics, context);
			case PivotPackage.OPERATION_TEMPLATE_PARAMETER:
				return validateOperationTemplateParameter((OperationTemplateParameter)value, diagnostics, context);
			case PivotPackage.ORDERED_SET_TYPE:
				return validateOrderedSetType((OrderedSetType)value, diagnostics, context);
			case PivotPackage.PACKAGE:
				return validatePackage((org.eclipse.ocl.examples.pivot.Package)value, diagnostics, context);
			case PivotPackage.PACKAGEABLE_ELEMENT:
				return validatePackageableElement((PackageableElement)value, diagnostics, context);
			case PivotPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case PivotPackage.PARAMETERABLE_ELEMENT:
				return validateParameterableElement((ParameterableElement)value, diagnostics, context);
			case PivotPackage.PIVOTABLE:
				return validatePivotable((Pivotable)value, diagnostics, context);
			case PivotPackage.PRECEDENCE:
				return validatePrecedence((Precedence)value, diagnostics, context);
			case PivotPackage.PRIMITIVE_LITERAL_EXP:
				return validatePrimitiveLiteralExp((PrimitiveLiteralExp)value, diagnostics, context);
			case PivotPackage.PRIMITIVE_TYPE:
				return validatePrimitiveType((PrimitiveType)value, diagnostics, context);
			case PivotPackage.PROPERTY:
				return validateProperty((Property)value, diagnostics, context);
			case PivotPackage.PROPERTY_CALL_EXP:
				return validatePropertyCallExp((PropertyCallExp)value, diagnostics, context);
			case PivotPackage.REAL_LITERAL_EXP:
				return validateRealLiteralExp((RealLiteralExp)value, diagnostics, context);
			case PivotPackage.SEND_SIGNAL_ACTION:
				return validateSendSignalAction((SendSignalAction)value, diagnostics, context);
			case PivotPackage.SEQUENCE_TYPE:
				return validateSequenceType((SequenceType)value, diagnostics, context);
			case PivotPackage.SET_TYPE:
				return validateSetType((SetType)value, diagnostics, context);
			case PivotPackage.SIGNAL:
				return validateSignal((Signal)value, diagnostics, context);
			case PivotPackage.STATE:
				return validateState((State)value, diagnostics, context);
			case PivotPackage.STATE_EXP:
				return validateStateExp((StateExp)value, diagnostics, context);
			case PivotPackage.STRING_LITERAL_EXP:
				return validateStringLiteralExp((StringLiteralExp)value, diagnostics, context);
			case PivotPackage.TEMPLATE_BINDING:
				return validateTemplateBinding((TemplateBinding)value, diagnostics, context);
			case PivotPackage.TEMPLATE_PARAMETER:
				return validateTemplateParameter((TemplateParameter)value, diagnostics, context);
			case PivotPackage.TEMPLATE_PARAMETER_SUBSTITUTION:
				return validateTemplateParameterSubstitution((TemplateParameterSubstitution)value, diagnostics, context);
			case PivotPackage.TEMPLATE_PARAMETER_TYPE:
				return validateTemplateParameterType((TemplateParameterType)value, diagnostics, context);
			case PivotPackage.TEMPLATE_SIGNATURE:
				return validateTemplateSignature((TemplateSignature)value, diagnostics, context);
			case PivotPackage.TEMPLATEABLE_ELEMENT:
				return validateTemplateableElement((TemplateableElement)value, diagnostics, context);
			case PivotPackage.TUPLE_LITERAL_EXP:
				return validateTupleLiteralExp((TupleLiteralExp)value, diagnostics, context);
			case PivotPackage.TUPLE_LITERAL_PART:
				return validateTupleLiteralPart((TupleLiteralPart)value, diagnostics, context);
			case PivotPackage.TUPLE_TYPE:
				return validateTupleType((TupleType)value, diagnostics, context);
			case PivotPackage.TYPE:
				return validateType((Type)value, diagnostics, context);
			case PivotPackage.TYPE_EXP:
				return validateTypeExp((TypeExp)value, diagnostics, context);
			case PivotPackage.TYPE_TEMPLATE_PARAMETER:
				return validateTypeTemplateParameter((TypeTemplateParameter)value, diagnostics, context);
			case PivotPackage.TYPED_ELEMENT:
				return validateTypedElement((TypedElement)value, diagnostics, context);
			case PivotPackage.TYPED_MULTIPLICITY_ELEMENT:
				return validateTypedMultiplicityElement((TypedMultiplicityElement)value, diagnostics, context);
			case PivotPackage.UNLIMITED_NATURAL_LITERAL_EXP:
				return validateUnlimitedNaturalLiteralExp((UnlimitedNaturalLiteralExp)value, diagnostics, context);
			case PivotPackage.UNSPECIFIED_TYPE:
				return validateUnspecifiedType((UnspecifiedType)value, diagnostics, context);
			case PivotPackage.UNSPECIFIED_VALUE_EXP:
				return validateUnspecifiedValueExp((UnspecifiedValueExp)value, diagnostics, context);
			case PivotPackage.VALUE_SPECIFICATION:
				return validateValueSpecification((ValueSpecification)value, diagnostics, context);
			case PivotPackage.VARIABLE:
				return validateVariable((Variable)value, diagnostics, context);
			case PivotPackage.VARIABLE_DECLARATION:
				return validateVariableDeclaration((VariableDeclaration)value, diagnostics, context);
			case PivotPackage.VARIABLE_EXP:
				return validateVariableExp((VariableExp)value, diagnostics, context);
			case PivotPackage.VISITABLE:
				return validateVisitable((Visitable)value, diagnostics, context);
			case PivotPackage.VISITOR:
				return validateVisitor((Visitor<?, ?>)value, diagnostics, context);
			case PivotPackage.VOID_TYPE:
				return validateVoidType((VoidType)value, diagnostics, context);
			case PivotPackage.ASSOCIATIVITY_KIND:
				return validateAssociativityKind((AssociativityKind)value, diagnostics, context);
			case PivotPackage.COLLECTION_KIND:
				return validateCollectionKind((CollectionKind)value, diagnostics, context);
			case PivotPackage.BOOLEAN:
				return validateBoolean((Boolean)value, diagnostics, context);
			case PivotPackage.CALLABLE_IMPLEMENTATION:
				return validateCallableImplementation((CallableImplementation)value, diagnostics, context);
			case PivotPackage.INT:
				return validateInt((Integer)value, diagnostics, context);
			case PivotPackage.INTEGER:
				return validateInteger((BigInteger)value, diagnostics, context);
			case PivotPackage.OBJECT:
				return validateObject(value, diagnostics, context);
			case PivotPackage.REAL:
				return validateReal((BigDecimal)value, diagnostics, context);
			case PivotPackage.STRING:
				return validateString((String)value, diagnostics, context);
			case PivotPackage.THROWABLE:
				return validateThrowable((Throwable)value, diagnostics, context);
			case PivotPackage.UNLIMITED_NATURAL:
				return validateUnlimitedNatural((BigInteger)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnnotation(Annotation annotation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)annotation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyType(AnyType anyType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)anyType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateType(Type type, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)type, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)namedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamespace(Namespace namespace,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)namespace, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateElement(Element element,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)element, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClass(org.eclipse.ocl.examples.pivot.Class class_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)class_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)property, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)property, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateLowerGe0(property, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateUpperGeLower(property, diagnostics, context);
		if (result || diagnostics != null) result &= validateProperty_validateBindingToAttribute(property, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateBindingToAttribute constraint of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty_validateBindingToAttribute(
			Property property, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return property.validateBindingToAttribute(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedElement(TypedElement typedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)typedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedMultiplicityElement(
			TypedMultiplicityElement typedMultiplicityElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)typedMultiplicityElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)typedMultiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)typedMultiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)typedMultiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)typedMultiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)typedMultiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)typedMultiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)typedMultiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)typedMultiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateLowerGe0(typedMultiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateUpperGeLower(typedMultiplicityElement, diagnostics, context);
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
		return validate_EveryDefaultConstraint((EObject)unlimitedNaturalLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnspecifiedType(UnspecifiedType unspecifiedType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)unspecifiedType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityElement(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)multiplicityElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)multiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)multiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)multiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)multiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)multiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)multiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)multiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)multiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateLowerGe0(multiplicityElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateUpperGeLower(multiplicityElement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateLowerGe0 constraint of '<em>Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityElement_validateLowerGe0(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return multiplicityElement.validateLowerGe0(diagnostics, context);
	}

	/**
	 * Validates the validateUpperGeLower constraint of '<em>Multiplicity Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiplicityElement_validateUpperGeLower(
			MultiplicityElement multiplicityElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return multiplicityElement.validateUpperGeLower(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNameable(Nameable nameable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)nameable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterableElement(
			ParameterableElement parameterableElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)parameterableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePivotable(Pivotable pivotable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)pivotable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrecedence(Precedence precedence,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)precedence, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameter(
			TemplateParameter templateParameter, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)templateParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)templateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)templateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)templateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)templateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)templateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)templateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)templateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)templateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateParameter_validateMustBeCompatible(templateParameter, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMustBeCompatible constraint of '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameter_validateMustBeCompatible(
			TemplateParameter templateParameter, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return templateParameter.validateMustBeCompatible(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateSignature(
			TemplateSignature templateSignature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)templateSignature, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)templateSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)templateSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)templateSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)templateSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)templateSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)templateSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)templateSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)templateSignature, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateSignature_validateOwnElements(templateSignature, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateOwnElements constraint of '<em>Template Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateSignature_validateOwnElements(
			TemplateSignature templateSignature, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return templateSignature.validateOwnElements(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateableElement(
			TemplateableElement templateableElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)templateableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBinding(TemplateBinding templateBinding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)templateBinding, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)templateBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)templateBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)templateBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)templateBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)templateBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)templateBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)templateBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)templateBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateBinding_validateParameterSubstitutionFormal(templateBinding, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateBinding_validateOneParameterSubstitution(templateBinding, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateParameterSubstitutionFormal constraint of '<em>Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBinding_validateParameterSubstitutionFormal(
			TemplateBinding templateBinding, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return templateBinding.validateParameterSubstitutionFormal(diagnostics, context);
	}

	/**
	 * Validates the validateOneParameterSubstitution constraint of '<em>Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateBinding_validateOneParameterSubstitution(
			TemplateBinding templateBinding, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return templateBinding.validateOneParameterSubstitution(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterSubstitution(
			TemplateParameterSubstitution templateParameterSubstitution,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)templateParameterSubstitution, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)templateParameterSubstitution, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateParameterSubstitution_validateMustBeCompatible(templateParameterSubstitution, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateMustBeCompatible constraint of '<em>Template Parameter Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterSubstitution_validateMustBeCompatible(
			TemplateParameterSubstitution templateParameterSubstitution,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return templateParameterSubstitution.validateMustBeCompatible(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationClass(AssociationClass associationClass,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)associationClass, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation(Operation operation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)operation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateLowerGe0(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateUpperGeLower(operation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateTestConstraint(operation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateTestConstraint constraint of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperation_validateTestConstraint(
			Operation operation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return operation.validateTestConstraint(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)parameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateLowerGe0(parameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateUpperGeLower(parameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationTemplateParameter(
			OperationTemplateParameter operationTemplateParameter,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)operationTemplateParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)operationTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateParameter_validateMustBeCompatible(operationTemplateParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComment(Comment comment,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)comment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteEnvironment(
			CompleteEnvironment completeEnvironment,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)completeEnvironment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteIteration(CompleteIteration completeIteration, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)completeIteration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)completeIteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)completeIteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)completeIteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)completeIteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)completeIteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)completeIteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)completeIteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)completeIteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateLowerGe0(completeIteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateUpperGeLower(completeIteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateTestConstraint(completeIteration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteOperation(
			CompleteOperation completeOperation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)completeOperation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)completeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)completeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)completeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)completeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)completeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)completeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)completeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)completeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateLowerGe0(completeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateUpperGeLower(completeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateTestConstraint(completeOperation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompletePackage(CompletePackage completePackage,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)completePackage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteProperty(CompleteProperty completeProperty,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)completeProperty, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)completeProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)completeProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)completeProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)completeProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)completeProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)completeProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)completeProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)completeProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateLowerGe0(completeProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateUpperGeLower(completeProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validateProperty_validateBindingToAttribute(completeProperty, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompleteType(CompleteType completeType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)completeType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)constraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_validateNotApplyToSelf(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validateConstraint_validateValueSpecificationBoolean(constraint, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateNotApplyToSelf constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateNotApplyToSelf(
			Constraint constraint, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return constraint.validateNotApplyToSelf(diagnostics, context);
	}

	/**
	 * Validates the validateValueSpecificationBoolean constraint of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint_validateValueSpecificationBoolean(
			Constraint constraint, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return constraint.validateValueSpecificationBoolean(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackage(
			org.eclipse.ocl.examples.pivot.Package package_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)package_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeTemplateParameter(
			TypeTemplateParameter typeTemplateParameter,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)typeTemplateParameter, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)typeTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)typeTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)typeTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)typeTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)typeTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)typeTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)typeTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)typeTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateTemplateParameter_validateMustBeCompatible(typeTemplateParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validateTypeTemplateParameter_validateHasConstrainingType(typeTemplateParameter, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateHasConstrainingType constraint of '<em>Type Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeTemplateParameter_validateHasConstrainingType(
			TypeTemplateParameter typeTemplateParameter,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return typeTemplateParameter.validateHasConstrainingType(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociationClassCallExp(
			AssociationClassCallExp associationClassCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)associationClassCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNavigationCallExp(
			NavigationCallExp navigationCallExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)navigationCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeatureCallExp(FeatureCallExp featureCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)featureCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallExp(CallExp callExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)callExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallOperationAction(
			CallOperationAction callOperationAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)callOperationAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCallableImplementation(
			CallableImplementation callableImplementation,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOclExpression(OclExpression oclExpression,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)oclExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBagType(BagType bagType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)bagType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionType(CollectionType collectionType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)collectionType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataType(DataType dataType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)dataType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDetail(Detail detail, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)detail, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanLiteralExp(
			BooleanLiteralExp booleanLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)booleanLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveLiteralExp(
			PrimitiveLiteralExp primitiveLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)primitiveLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteralExp(LiteralExp literalExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)literalExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionItem(CollectionItem collectionItem,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)collectionItem, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralPart(
			CollectionLiteralPart collectionLiteralPart,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)collectionLiteralPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionLiteralExp(
			CollectionLiteralExp collectionLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)collectionLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionRange(CollectionRange collectionRange,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)collectionRange, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumLiteralExp(EnumLiteralExp enumLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)enumLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationLiteral(
			EnumerationLiteral enumerationLiteral, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)enumerationLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumeration(Enumeration enumeration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)enumeration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionInOcl(ExpressionInOcl expressionInOcl,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)expressionInOcl, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)expressionInOcl, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)expressionInOcl, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)expressionInOcl, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)expressionInOcl, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)expressionInOcl, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)expressionInOcl, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)expressionInOcl, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)expressionInOcl, diagnostics, context);
		if (result || diagnostics != null) result &= validateOpaqueExpression_validateLanguageBodySize(expressionInOcl, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFeature(Feature feature,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)feature, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)feature, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)feature, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateLowerGe0(feature, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateUpperGeLower(feature, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueExpression(OpaqueExpression opaqueExpression,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)opaqueExpression, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)opaqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)opaqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)opaqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)opaqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)opaqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)opaqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)opaqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)opaqueExpression, diagnostics, context);
		if (result || diagnostics != null) result &= validateOpaqueExpression_validateLanguageBodySize(opaqueExpression, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateLanguageBodySize constraint of '<em>Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueExpression_validateLanguageBodySize(
			OpaqueExpression opaqueExpression, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return opaqueExpression.validateLanguageBodySize(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable(Variable variable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)variable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableDeclaration(
			VariableDeclaration variableDeclaration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)variableDeclaration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIfExp(IfExp ifExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)ifExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIntegerLiteralExp(
			IntegerLiteralExp integerLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)integerLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNumericLiteralExp(
			NumericLiteralExp numericLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)numericLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvalidLiteralExp(
			InvalidLiteralExp invalidLiteralExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)invalidLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInvalidType(InvalidType invalidType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)invalidType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIterateExp(IterateExp iterateExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)iterateExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteration(Iteration iteration, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment((EObject)iteration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateLowerGe0(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateMultiplicityElement_validateUpperGeLower(iteration, diagnostics, context);
		if (result || diagnostics != null) result &= validateOperation_validateTestConstraint(iteration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIteratorExp(IteratorExp iteratorExp, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)iteratorExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLambdaType(LambdaType lambdaType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)lambdaType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoopExp(LoopExp loopExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)loopExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLetExp(LetExp letExp, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)letExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibrary(Library library, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)library, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageExp(MessageExp messageExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)messageExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageType(MessageType messageType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)messageType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMonikeredElement(MonikeredElement monikeredElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)monikeredElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignal(Signal signal, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)signal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNullLiteralExp(NullLiteralExp nullLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)nullLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationCallExp(OperationCallExp operationCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)operationCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderedSetType(OrderedSetType orderedSetType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)orderedSetType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePackageableElement(
			PackageableElement packageableElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)packageableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveType(PrimitiveType primitiveType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)primitiveType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertyCallExp(PropertyCallExp propertyCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)propertyCallExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRealLiteralExp(RealLiteralExp realLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)realLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSendSignalAction(SendSignalAction sendSignalAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)sendSignalAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceType(SequenceType sequenceType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)sequenceType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSetType(SetType setType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)setType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState(State state, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)state, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateExp(StateExp stateExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)stateExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringLiteralExp(StringLiteralExp stringLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)stringLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTemplateParameterType(
			TemplateParameterType templateParameterType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)templateParameterType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleLiteralExp(TupleLiteralExp tupleLiteralExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)tupleLiteralExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleLiteralPart(TupleLiteralPart tupleLiteralPart,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)tupleLiteralPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTupleType(TupleType tupleType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)tupleType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypeExp(TypeExp typeExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)typeExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnspecifiedValueExp(
			UnspecifiedValueExp unspecifiedValueExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)unspecifiedValueExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueSpecification(
			ValueSpecification valueSpecification, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)valueSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableExp(VariableExp variableExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)variableExp, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVisitable(Visitable visitable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)visitable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVisitor(Visitor<?, ?> visitor,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)visitor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVoidType(VoidType voidType,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)voidType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssociativityKind(
			AssociativityKind associativityKind, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollectionKind(CollectionKind collectionKind,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBoolean(boolean boolean_,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInt(int int_, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteger(BigInteger integer,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObject(Object object, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReal(BigDecimal real, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateString(String string, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateThrowable(Throwable throwable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnlimitedNatural(BigInteger unlimitedNatural,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
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
		return PivotPlugin.INSTANCE;
	}

} //PivotValidator
