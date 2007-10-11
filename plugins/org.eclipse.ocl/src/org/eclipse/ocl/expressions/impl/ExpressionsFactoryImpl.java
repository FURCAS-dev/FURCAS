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
 * $Id: ExpressionsFactoryImpl.java,v 1.6 2007/10/11 23:04:56 cdamus Exp $
 */
package org.eclipse.ocl.expressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

//import org.eclipse.ocl.expressions.*;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsFactoryImpl extends EFactoryImpl implements ExpressionsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ExpressionsFactory init() {
        try {
            ExpressionsFactory theExpressionsFactory = (ExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/1.1.0/OCL/Expressions"); //$NON-NLS-1$ 
            if (theExpressionsFactory != null) {
                return theExpressionsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ExpressionsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExpressionsFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ExpressionsPackage.ASSOCIATION_CLASS_CALL_EXP: return createAssociationClassCallExp();
            case ExpressionsPackage.BOOLEAN_LITERAL_EXP: return createBooleanLiteralExp();
            case ExpressionsPackage.COLLECTION_ITEM: return createCollectionItem();
            case ExpressionsPackage.COLLECTION_LITERAL_EXP: return createCollectionLiteralExp();
            case ExpressionsPackage.COLLECTION_RANGE: return createCollectionRange();
            case ExpressionsPackage.ENUM_LITERAL_EXP: return createEnumLiteralExp();
            case ExpressionsPackage.IF_EXP: return createIfExp();
            case ExpressionsPackage.INTEGER_LITERAL_EXP: return createIntegerLiteralExp();
            case ExpressionsPackage.UNLIMITED_NATURAL_LITERAL_EXP: return createUnlimitedNaturalLiteralExp();
            case ExpressionsPackage.INVALID_LITERAL_EXP: return createInvalidLiteralExp();
            case ExpressionsPackage.ITERATE_EXP: return createIterateExp();
            case ExpressionsPackage.VARIABLE: return createVariable();
            case ExpressionsPackage.ITERATOR_EXP: return createIteratorExp();
            case ExpressionsPackage.LET_EXP: return createLetExp();
            case ExpressionsPackage.MESSAGE_EXP: return createMessageExp();
            case ExpressionsPackage.NULL_LITERAL_EXP: return createNullLiteralExp();
            case ExpressionsPackage.OPERATION_CALL_EXP: return createOperationCallExp();
            case ExpressionsPackage.PROPERTY_CALL_EXP: return createPropertyCallExp();
            case ExpressionsPackage.REAL_LITERAL_EXP: return createRealLiteralExp();
            case ExpressionsPackage.STATE_EXP: return createStateExp();
            case ExpressionsPackage.STRING_LITERAL_EXP: return createStringLiteralExp();
            case ExpressionsPackage.TUPLE_LITERAL_EXP: return createTupleLiteralExp();
            case ExpressionsPackage.TUPLE_LITERAL_PART: return createTupleLiteralPart();
            case ExpressionsPackage.TYPE_EXP: return createTypeExp();
            case ExpressionsPackage.UNSPECIFIED_VALUE_EXP: return createUnspecifiedValueExp();
            case ExpressionsPackage.VARIABLE_EXP: return createVariableExp();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case ExpressionsPackage.COLLECTION_KIND:
                return createCollectionKindFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case ExpressionsPackage.COLLECTION_KIND:
                return convertCollectionKindToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, P> AssociationClassCallExp<C, P> createAssociationClassCallExp() {
        AssociationClassCallExpImpl<C, P> associationClassCallExp = new AssociationClassCallExpImpl<C, P>();
        return associationClassCallExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> BooleanLiteralExp<C> createBooleanLiteralExp() {
        BooleanLiteralExpImpl<C> booleanLiteralExp = new BooleanLiteralExpImpl<C>();
        return booleanLiteralExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> CollectionItem<C> createCollectionItem() {
        CollectionItemImpl<C> collectionItem = new CollectionItemImpl<C>();
        return collectionItem;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> CollectionLiteralExp<C> createCollectionLiteralExp() {
        CollectionLiteralExpImpl<C> collectionLiteralExp = new CollectionLiteralExpImpl<C>();
        return collectionLiteralExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> CollectionRange<C> createCollectionRange() {
        CollectionRangeImpl<C> collectionRange = new CollectionRangeImpl<C>();
        return collectionRange;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, EL> EnumLiteralExp<C, EL> createEnumLiteralExp() {
        EnumLiteralExpImpl<C, EL> enumLiteralExp = new EnumLiteralExpImpl<C, EL>();
        return enumLiteralExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> IfExp<C> createIfExp() {
        IfExpImpl<C> ifExp = new IfExpImpl<C>();
        return ifExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> IntegerLiteralExp<C> createIntegerLiteralExp() {
        IntegerLiteralExpImpl<C> integerLiteralExp = new IntegerLiteralExpImpl<C>();
        return integerLiteralExp;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public <C> UnlimitedNaturalLiteralExp<C> createUnlimitedNaturalLiteralExp() {
        UnlimitedNaturalLiteralExpImpl<C> unlimitedNaturalLiteralExp = new UnlimitedNaturalLiteralExpImpl<C>();
        return unlimitedNaturalLiteralExp;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> InvalidLiteralExp<C> createInvalidLiteralExp() {
        InvalidLiteralExpImpl<C> invalidLiteralExp = new InvalidLiteralExpImpl<C>();
        return invalidLiteralExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, PM> IterateExp<C, PM> createIterateExp() {
        IterateExpImpl<C, PM> iterateExp = new IterateExpImpl<C, PM>();
        return iterateExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, PM> IteratorExp<C, PM> createIteratorExp() {
        IteratorExpImpl<C, PM> iteratorExp = new IteratorExpImpl<C, PM>();
        return iteratorExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, PM> LetExp<C, PM> createLetExp() {
        LetExpImpl<C, PM> letExp = new LetExpImpl<C, PM>();
        return letExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, COA, SSA> MessageExp<C, COA, SSA> createMessageExp() {
        MessageExpImpl<C, COA, SSA> messageExp = new MessageExpImpl<C, COA, SSA>();
        return messageExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> NullLiteralExp<C> createNullLiteralExp() {
        NullLiteralExpImpl<C> nullLiteralExp = new NullLiteralExpImpl<C>();
        return nullLiteralExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, O> OperationCallExp<C, O> createOperationCallExp() {
        OperationCallExpImpl<C, O> operationCallExp = new OperationCallExpImpl<C, O>();
        return operationCallExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, P> PropertyCallExp<C, P> createPropertyCallExp() {
        PropertyCallExpImpl<C, P> propertyCallExp = new PropertyCallExpImpl<C, P>();
        return propertyCallExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> RealLiteralExp<C> createRealLiteralExp() {
        RealLiteralExpImpl<C> realLiteralExp = new RealLiteralExpImpl<C>();
        return realLiteralExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, S> StateExp<C, S> createStateExp() {
        StateExpImpl<C, S> stateExp = new StateExpImpl<C, S>();
        return stateExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> StringLiteralExp<C> createStringLiteralExp() {
        StringLiteralExpImpl<C> stringLiteralExp = new StringLiteralExpImpl<C>();
        return stringLiteralExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, P> TupleLiteralExp<C, P> createTupleLiteralExp() {
        TupleLiteralExpImpl<C, P> tupleLiteralExp = new TupleLiteralExpImpl<C, P>();
        return tupleLiteralExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, P> TupleLiteralPart<C, P> createTupleLiteralPart() {
        TupleLiteralPartImpl<C, P> tupleLiteralPart = new TupleLiteralPartImpl<C, P>();
        return tupleLiteralPart;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> TypeExp<C> createTypeExp() {
        TypeExpImpl<C> typeExp = new TypeExpImpl<C>();
        return typeExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C> UnspecifiedValueExp<C> createUnspecifiedValueExp() {
        UnspecifiedValueExpImpl<C> unspecifiedValueExp = new UnspecifiedValueExpImpl<C>();
        return unspecifiedValueExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, PM> Variable<C, PM> createVariable() {
        VariableImpl<C, PM> variable = new VariableImpl<C, PM>();
        return variable;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, PM> VariableExp<C, PM> createVariableExp() {
        VariableExpImpl<C, PM> variableExp = new VariableExpImpl<C, PM>();
        return variableExp;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CollectionKind createCollectionKindFromString(EDataType eDataType, String initialValue) {
        CollectionKind result = CollectionKind.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertCollectionKindToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExpressionsPackage getExpressionsPackage() {
        return (ExpressionsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static ExpressionsPackage getPackage() {
        return ExpressionsPackage.eINSTANCE;
    }

} //ExpressionsFactoryImpl
