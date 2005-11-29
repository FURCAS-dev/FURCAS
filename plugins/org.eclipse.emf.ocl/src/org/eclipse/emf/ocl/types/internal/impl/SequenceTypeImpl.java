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
 * $Id$
 */

package org.eclipse.emf.ocl.types.internal.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SequenceTypeImpl
	extends CollectionTypeImpl
	implements SequenceType {

	private static EList operations = new BasicEList();

	protected SequenceTypeImpl() {
		super();
		setInstanceClass(List.class);
		this.setClassifierID(TypesPackage.SEQUENCE_TYPE);
	}

	protected SequenceTypeImpl(EClassifier elementType) {
		super();
		this.elementType = elementType;
		setInstanceClass(List.class);
		this.setClassifierID(TypesPackage.SEQUENCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getSequenceType();
	}

	/**
	 * Return result type of  operation based on the sourceType and args.
	 * Conformance rules are applied.  It is assumed that operation signature
	 * is already checked by the time this method is called.
	 * @param opcode
	 * @param args
	 * @return the result type
	 * @throws antlr.SemanticException
	 */
	public EClassifier getResultType(int opcode, EList args)
		throws antlr.SemanticException {

		EClassifier elemType = getElementType();

		switch (opcode) {

			case CollectionTypeImpl.COUNT:
			case CollectionTypeImpl.INDEX_OF:
				return PrimitiveTypeImpl.OCL_INTEGER;
			case CollectionTypeImpl.EQUALS:
			case CollectionTypeImpl.NOT_EQUAL:
				return PrimitiveTypeImpl.OCL_BOOLEAN;
			case CollectionTypeImpl.UNION:
				OclExpression arg = (OclExpression) args.get(0);
				CollectionType argType = (CollectionType) arg.getType();
				EClassifier argElementType = argType.getElementType();
				CollectionType resultType = TypesFactory.eINSTANCE
					.createSequenceType();
				resultType.setElementType(AnyTypeImpl.commonSuperType(
					elemType, argElementType));
				return resultType;
			case CollectionTypeImpl.INCLUDING:
			case CollectionTypeImpl.APPEND:
			case CollectionTypeImpl.PREPEND:
			case CollectionTypeImpl.INSERT_AT:
				arg = (OclExpression) args.get(0);
				EClassifier eArgType = arg.getType();
				resultType = TypesFactory.eINSTANCE.createSequenceType();
				resultType.setElementType(AnyTypeImpl.commonSuperType(
					elemType, eArgType));
				return resultType;
			case CollectionTypeImpl.EXCLUDING:
				return this;
			case CollectionTypeImpl.FLATTEN:
				if (!(elemType instanceof CollectionType))
					return this;
				resultType = TypesFactory.eINSTANCE.createSequenceType();
				resultType.setElementType(((CollectionType) elemType)
					.getElementType());
				return resultType;
			case CollectionTypeImpl.AT:
			case CollectionTypeImpl.FIRST:
			case CollectionTypeImpl.LAST:
				return elemType;
			case CollectionTypeImpl.AS_BAG:
				return TypesFactory.eINSTANCE.createBagType(elemType);
			case CollectionTypeImpl.AS_SEQUENCE:
			case CollectionTypeImpl.SUB_SEQUENCE:
				return this;
			case CollectionTypeImpl.AS_SET:
				return TypesFactory.eINSTANCE.createSetType(elemType);
			case CollectionTypeImpl.AS_ORDERED_SET:
				return TypesFactory.eINSTANCE.createOrderedSetType(elemType);
		}

		return (super.getResultType(opcode, args));
	}

	/**
	 * Initialiaze Operations defined on AnyType
	 */
	protected EList initOperations() {

		EList parentOperations = super.initOperations();
		for (int i = 0; i < parentOperations.size(); i++) {
			operations.add(parentOperations.get(i));
		}
		operations.add(AnyTypeImpl.createBinaryOperation(
			PrimitiveTypeImpl.OCL_BOOLEAN, "oclEquals", OCL_SEQUENCE));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(
			PrimitiveTypeImpl.OCL_BOOLEAN, "oclNotEquals", OCL_SEQUENCE)); //$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"union", OCL_SEQUENCE)); //$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"append", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"prepend", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"insertAt", PrimitiveTypeImpl.OCL_INTEGER));//$NON-NLS-1$
		operations
			.add(AnyTypeImpl
				.createTernaryOperation(
					OCL_SEQUENCE,
					"subSequence", PrimitiveTypeImpl.OCL_INTEGER, PrimitiveTypeImpl.OCL_INTEGER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(
			AnyTypeImpl.OCL_ECLASSIFIER, "at", PrimitiveTypeImpl.OCL_INTEGER)); //$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(
			PrimitiveTypeImpl.OCL_INTEGER,
			"indexOf", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"including", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"excluding", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(
			AnyTypeImpl.OCL_ECLASSIFIER, "first"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(
			AnyTypeImpl.OCL_ECLASSIFIER, "last"));//$NON-NLS-1$
		operations.add(AnyTypeImpl
			.createUnaryOperation(OCL_SEQUENCE, "flatten"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_BAG, "asBag"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_SET, "asSet"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_SEQUENCE,
			"asSequence"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_ORDERED_SET,
			"asOrderedSet"));//$NON-NLS-1$
		return operations;
	}

	public EList getOperations() {
		if (operations == null || operations.size() == 0)
			return initOperations();
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.SEQUENCE_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case TypesPackage.SEQUENCE_TYPE__EPACKAGE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, TypesPackage.SEQUENCE_TYPE__EPACKAGE, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.SEQUENCE_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case TypesPackage.SEQUENCE_TYPE__EPACKAGE:
					return eBasicSetContainer(null, TypesPackage.SEQUENCE_TYPE__EPACKAGE, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case TypesPackage.SEQUENCE_TYPE__EPACKAGE:
					return eContainer.eInverseRemove(this, EcorePackage.EPACKAGE__ECLASSIFIERS, EPackage.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.SEQUENCE_TYPE__EANNOTATIONS:
				return getEAnnotations();
			case TypesPackage.SEQUENCE_TYPE__NAME:
				return getName();
			case TypesPackage.SEQUENCE_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case TypesPackage.SEQUENCE_TYPE__INSTANCE_CLASS:
				return getInstanceClass();
			case TypesPackage.SEQUENCE_TYPE__DEFAULT_VALUE:
				return getDefaultValue();
			case TypesPackage.SEQUENCE_TYPE__EPACKAGE:
				return getEPackage();
			case TypesPackage.SEQUENCE_TYPE__SERIALIZABLE:
				return isSerializable() ? Boolean.TRUE : Boolean.FALSE;
			case TypesPackage.SEQUENCE_TYPE__START_POSITION:
				return new Integer(getStartPosition());
			case TypesPackage.SEQUENCE_TYPE__END_POSITION:
				return new Integer(getEndPosition());
			case TypesPackage.SEQUENCE_TYPE__TYPE_START_POSITION:
				return new Integer(getTypeStartPosition());
			case TypesPackage.SEQUENCE_TYPE__TYPE_END_POSITION:
				return new Integer(getTypeEndPosition());
			case TypesPackage.SEQUENCE_TYPE__ELEMENT_TYPE:
				if (resolve) return getElementType();
				return basicGetElementType();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.SEQUENCE_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case TypesPackage.SEQUENCE_TYPE__NAME:
				setName((String)newValue);
				return;
			case TypesPackage.SEQUENCE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case TypesPackage.SEQUENCE_TYPE__SERIALIZABLE:
				setSerializable(((Boolean)newValue).booleanValue());
				return;
			case TypesPackage.SEQUENCE_TYPE__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.SEQUENCE_TYPE__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.SEQUENCE_TYPE__TYPE_START_POSITION:
				setTypeStartPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.SEQUENCE_TYPE__TYPE_END_POSITION:
				setTypeEndPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.SEQUENCE_TYPE__ELEMENT_TYPE:
				setElementType((EClassifier)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.SEQUENCE_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case TypesPackage.SEQUENCE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesPackage.SEQUENCE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case TypesPackage.SEQUENCE_TYPE__SERIALIZABLE:
				setSerializable(SERIALIZABLE_EDEFAULT);
				return;
			case TypesPackage.SEQUENCE_TYPE__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case TypesPackage.SEQUENCE_TYPE__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case TypesPackage.SEQUENCE_TYPE__TYPE_START_POSITION:
				setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
				return;
			case TypesPackage.SEQUENCE_TYPE__TYPE_END_POSITION:
				setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
				return;
			case TypesPackage.SEQUENCE_TYPE__ELEMENT_TYPE:
				setElementType((EClassifier)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.SEQUENCE_TYPE__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case TypesPackage.SEQUENCE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypesPackage.SEQUENCE_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case TypesPackage.SEQUENCE_TYPE__INSTANCE_CLASS:
				return INSTANCE_CLASS_EDEFAULT == null ? getInstanceClass() != null : !INSTANCE_CLASS_EDEFAULT.equals(getInstanceClass());
			case TypesPackage.SEQUENCE_TYPE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case TypesPackage.SEQUENCE_TYPE__EPACKAGE:
				return getEPackage() != null;
			case TypesPackage.SEQUENCE_TYPE__SERIALIZABLE:
				return ((eFlags & SERIALIZABLE_EFLAG) != 0) != SERIALIZABLE_EDEFAULT;
			case TypesPackage.SEQUENCE_TYPE__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case TypesPackage.SEQUENCE_TYPE__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case TypesPackage.SEQUENCE_TYPE__TYPE_START_POSITION:
				return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
			case TypesPackage.SEQUENCE_TYPE__TYPE_END_POSITION:
				return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
			case TypesPackage.SEQUENCE_TYPE__ELEMENT_TYPE:
				return elementType != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //SequenceTypeImpl
