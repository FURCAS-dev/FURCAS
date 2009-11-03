/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.oslo.ocl20.semantics.model.expressions.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ExpressionsFactoryImpl extends EFactoryImpl implements ExpressionsFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ExpressionsFactory init() {
		try {
			ExpressionsFactory theExpressionsFactory = (ExpressionsFactory) EPackage.Registry.INSTANCE
			        .getEFactory("urn:semantics.model.expressions.ecore");
			if (theExpressionsFactory != null) {
				return theExpressionsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpressionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExpressionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExpressionsPackage.BOOLEAN_LITERAL_EXP:
				return createBooleanLiteralExp();
			case ExpressionsPackage.CALL_EXP:
				return createCallExp();
			case ExpressionsPackage.COLLECTION_ITEM:
				return createCollectionItem();
			case ExpressionsPackage.COLLECTION_LITERAL_EXP:
				return createCollectionLiteralExp();
			case ExpressionsPackage.COLLECTION_LITERAL_PART:
				return createCollectionLiteralPart();
			case ExpressionsPackage.COLLECTION_RANGE:
				return createCollectionRange();
			case ExpressionsPackage.ENUM_LITERAL_EXP:
				return createEnumLiteralExp();
			case ExpressionsPackage.IF_EXP:
				return createIfExp();
			case ExpressionsPackage.INTEGER_LITERAL_EXP:
				return createIntegerLiteralExp();
			case ExpressionsPackage.ITERATE_EXP:
				return createIterateExp();
			case ExpressionsPackage.ITERATOR_EXP:
				return createIteratorExp();
			case ExpressionsPackage.LET_EXP:
				return createLetExp();
			case ExpressionsPackage.LITERAL_EXP:
				return createLiteralExp();
			case ExpressionsPackage.LOOP_EXP:
				return createLoopExp();
			case ExpressionsPackage.MODEL_PROPERTY_CALL_EXP:
				return createModelPropertyCallExp();
			case ExpressionsPackage.NUMERICAL_LITERAL_EXP:
				return createNumericalLiteralExp();
			case ExpressionsPackage.OCL_EXPRESSION:
				return createOclExpression();
			case ExpressionsPackage.OCL_MESSAGE_ARG:
				return createOclMessageArg();
			case ExpressionsPackage.OCL_MESSAGE_EXP:
				return createOclMessageExp();
			case ExpressionsPackage.OPERATION_CALL_EXP:
				return createOperationCallExp();
			case ExpressionsPackage.PROPERTY_CALL_EXP:
				return createPropertyCallExp();
			case ExpressionsPackage.REAL_LITERAL_EXP:
				return createRealLiteralExp();
			case ExpressionsPackage.STRING_LITERAL_EXP:
				return createStringLiteralExp();
			case ExpressionsPackage.TUPLE_LITERAL_EXP:
				return createTupleLiteralExp();
			case ExpressionsPackage.TYPE_LITERAL_EXP:
				return createTypeLiteralExp();
			case ExpressionsPackage.UNDEFINED_LITERAL_EXP:
				return createUndefinedLiteralExp();
			case ExpressionsPackage.UNSPECIFIED_VALUE_EXP:
				return createUnspecifiedValueExp();
			case ExpressionsPackage.VARIABLE_DECLARATION:
				return createVariableDeclaration();
			case ExpressionsPackage.VARIABLE_EXP:
				return createVariableExp();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionsPackage.COLLECTION_KIND:
				return createCollectionKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName()
				        + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionsPackage.COLLECTION_KIND:
				return convertCollectionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName()
				        + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BooleanLiteralExp createBooleanLiteralExp() {
		BooleanLiteralExpImpl booleanLiteralExp = new BooleanLiteralExpImpl();
		return booleanLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CallExp createCallExp() {
		CallExpImpl callExp = new CallExpImpl();
		return callExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionItem createCollectionItem() {
		CollectionItemImpl collectionItem = new CollectionItemImpl();
		return collectionItem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionLiteralExp createCollectionLiteralExp() {
		CollectionLiteralExpImpl collectionLiteralExp = new CollectionLiteralExpImpl();
		return collectionLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionLiteralPart createCollectionLiteralPart() {
		CollectionLiteralPartImpl collectionLiteralPart = new CollectionLiteralPartImpl();
		return collectionLiteralPart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionRange createCollectionRange() {
		CollectionRangeImpl collectionRange = new CollectionRangeImpl();
		return collectionRange;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EnumLiteralExp createEnumLiteralExp() {
		EnumLiteralExpImpl enumLiteralExp = new EnumLiteralExpImpl();
		return enumLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IfExp createIfExp() {
		IfExpImpl ifExp = new IfExpImpl();
		return ifExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IntegerLiteralExp createIntegerLiteralExp() {
		IntegerLiteralExpImpl integerLiteralExp = new IntegerLiteralExpImpl();
		return integerLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IterateExp createIterateExp() {
		IterateExpImpl iterateExp = new IterateExpImpl();
		return iterateExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IteratorExp createIteratorExp() {
		IteratorExpImpl iteratorExp = new IteratorExpImpl();
		return iteratorExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LetExp createLetExp() {
		LetExpImpl letExp = new LetExpImpl();
		return letExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LiteralExp createLiteralExp() {
		LiteralExpImpl literalExp = new LiteralExpImpl();
		return literalExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LoopExp createLoopExp() {
		LoopExpImpl loopExp = new LoopExpImpl();
		return loopExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelPropertyCallExp createModelPropertyCallExp() {
		ModelPropertyCallExpImpl modelPropertyCallExp = new ModelPropertyCallExpImpl();
		return modelPropertyCallExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NumericalLiteralExp createNumericalLiteralExp() {
		NumericalLiteralExpImpl numericalLiteralExp = new NumericalLiteralExpImpl();
		return numericalLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OclExpression createOclExpression() {
		OclExpressionImpl oclExpression = new OclExpressionImpl();
		return oclExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OclMessageArg createOclMessageArg() {
		OclMessageArgImpl oclMessageArg = new OclMessageArgImpl();
		return oclMessageArg;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OclMessageExp createOclMessageExp() {
		OclMessageExpImpl oclMessageExp = new OclMessageExpImpl();
		return oclMessageExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationCallExp createOperationCallExp() {
		OperationCallExpImpl operationCallExp = new OperationCallExpImpl();
		return operationCallExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PropertyCallExp createPropertyCallExp() {
		PropertyCallExpImpl propertyCallExp = new PropertyCallExpImpl();
		return propertyCallExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RealLiteralExp createRealLiteralExp() {
		RealLiteralExpImpl realLiteralExp = new RealLiteralExpImpl();
		return realLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StringLiteralExp createStringLiteralExp() {
		StringLiteralExpImpl stringLiteralExp = new StringLiteralExpImpl();
		return stringLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TupleLiteralExp createTupleLiteralExp() {
		TupleLiteralExpImpl tupleLiteralExp = new TupleLiteralExpImpl();
		return tupleLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypeLiteralExp createTypeLiteralExp() {
		TypeLiteralExpImpl typeLiteralExp = new TypeLiteralExpImpl();
		return typeLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UndefinedLiteralExp createUndefinedLiteralExp() {
		UndefinedLiteralExpImpl undefinedLiteralExp = new UndefinedLiteralExpImpl();
		return undefinedLiteralExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UnspecifiedValueExp createUnspecifiedValueExp() {
		UnspecifiedValueExpImpl unspecifiedValueExp = new UnspecifiedValueExpImpl();
		return unspecifiedValueExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariableExp createVariableExp() {
		VariableExpImpl variableExp = new VariableExpImpl();
		return variableExp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollectionKind createCollectionKindFromString(EDataType eDataType, String initialValue) {
		CollectionKind result = CollectionKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
			        + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertCollectionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExpressionsPackage getExpressionsPackage() {
		return (ExpressionsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	public static ExpressionsPackage getPackage() {
		return ExpressionsPackage.eINSTANCE;
	}

} // ExpressionsFactoryImpl
