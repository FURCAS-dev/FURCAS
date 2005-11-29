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
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;


/**
 * @generated
 */
public class BagTypeImpl extends CollectionTypeImpl implements BagType {
	
	private static EList operations = new BasicEList();
	
	protected BagTypeImpl() {
		super();
		setInstanceClass(Collection.class);
		this.setClassifierID(TypesPackage.BAG_TYPE);
	}
	
	/**
	 * Create a BagTypeImpl with the specified element type.
	 * @param elementType
	 */
	protected BagTypeImpl(EClassifier elementType) {
		super(elementType);
		setInstanceClass(Collection.class);				
		this.setClassifierID(TypesPackage.BAG_TYPE);
	}
	
	/**
	 * Return result type of Bag operation based on the sourceType and args.
	 * Conformance rules are applied.  It is assumed that operation signature
	 * is already checked by the time this method is called.
	 * @param opcode
	 * @param args
	 * @return the result type
	 */
	public EClassifier getResultType(int opcode, EList args)
					throws antlr.SemanticException {
		
									
		EClassifier elemType = getElementType();
		
		switch (opcode) {
			
		case CollectionTypeImpl.EQUALS:
		case CollectionTypeImpl.NOT_EQUAL:
			return PrimitiveTypeImpl.OCL_BOOLEAN;
		case CollectionTypeImpl.UNION:
			OclExpression arg = (OclExpression) args.get(0); 
			CollectionType argType = (CollectionType) arg.getType();
			EClassifier argElementType = argType.getElementType();
			return TypesFactory.eINSTANCE.createBagType(AnyTypeImpl.commonSuperType(elemType, argElementType));	
		case CollectionTypeImpl.INCLUDING:
			arg = (OclExpression) args.get(0);
			EClassifier eArgType = arg.getType();			 
			return TypesFactory.eINSTANCE.createBagType(AnyTypeImpl.commonSuperType(elemType, eArgType));
		case CollectionTypeImpl.INTERSECTION:

			arg = (OclExpression) args.get(0);  
			argType = (CollectionType) arg.getType();
			argElementType = argType.getElementType();
			if (argType instanceof SetType) {
				return TypesFactory.eINSTANCE.createSetType(AnyTypeImpl.commonSuperType(elemType, argElementType));				
			} else {
				return TypesFactory.eINSTANCE.createBagType(AnyTypeImpl.commonSuperType(elemType, argElementType));
			}
		case  CollectionTypeImpl.EXCLUDING:
			return this;
		case CollectionTypeImpl.COUNT:
			return PrimitiveTypeImpl.OCL_INTEGER;
		case  CollectionTypeImpl.FLATTEN:
			if (!(elemType instanceof CollectionType)) return this;
				return TypesFactory.eINSTANCE.createBagType(((CollectionType) elemType).getElementType());
		case CollectionTypeImpl.AS_BAG:
			return this;
		case CollectionTypeImpl.AS_SEQUENCE:
			return TypesFactory.eINSTANCE.createSequenceType(elemType);
		case CollectionTypeImpl.AS_SET:
			return  TypesFactory.eINSTANCE.createSetType(elemType);
		case CollectionTypeImpl.AS_ORDERED_SET:
			return TypesFactory.eINSTANCE.createOrderedSetType(elemType);
		}
		return super.getResultType(opcode, args);	
	}
	
	
	/**
	 * Initialiaze Operations defined on BagType
	 */
	protected EList initOperations() {
		
		EList parentOperations = super.initOperations();
		for (int i=0; i < parentOperations.size(); i++) {
			operations.add(parentOperations.get(i));
		}	
		operations.add(AnyTypeImpl.createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN, "oclEquals", OCL_BAG));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN, "oclNotEquals", OCL_BAG)); //$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "union", OCL_BAG)); //$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "union", OCL_SET));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "intersection", OCL_BAG));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SET, "intersection", OCL_SET));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "including", AnyTypeImpl.OCL_ECLASSIFIER));	//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "excluding", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_BAG, "flatten"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_BAG, "asBag"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_SET, "asSet"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_SEQUENCE, "asSequence"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_ORDERED_SET, "asOrderedSet"));//$NON-NLS-1$
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
				case TypesPackage.BAG_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case TypesPackage.BAG_TYPE__EPACKAGE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, TypesPackage.BAG_TYPE__EPACKAGE, msgs);
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
				case TypesPackage.BAG_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case TypesPackage.BAG_TYPE__EPACKAGE:
					return eBasicSetContainer(null, TypesPackage.BAG_TYPE__EPACKAGE, msgs);
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
				case TypesPackage.BAG_TYPE__EPACKAGE:
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
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getBagType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.BAG_TYPE__EANNOTATIONS:
				return getEAnnotations();
			case TypesPackage.BAG_TYPE__NAME:
				return getName();
			case TypesPackage.BAG_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case TypesPackage.BAG_TYPE__INSTANCE_CLASS:
				return getInstanceClass();
			case TypesPackage.BAG_TYPE__DEFAULT_VALUE:
				return getDefaultValue();
			case TypesPackage.BAG_TYPE__EPACKAGE:
				return getEPackage();
			case TypesPackage.BAG_TYPE__SERIALIZABLE:
				return isSerializable() ? Boolean.TRUE : Boolean.FALSE;
			case TypesPackage.BAG_TYPE__START_POSITION:
				return new Integer(getStartPosition());
			case TypesPackage.BAG_TYPE__END_POSITION:
				return new Integer(getEndPosition());
			case TypesPackage.BAG_TYPE__TYPE_START_POSITION:
				return new Integer(getTypeStartPosition());
			case TypesPackage.BAG_TYPE__TYPE_END_POSITION:
				return new Integer(getTypeEndPosition());
			case TypesPackage.BAG_TYPE__ELEMENT_TYPE:
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
			case TypesPackage.BAG_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case TypesPackage.BAG_TYPE__NAME:
				setName((String)newValue);
				return;
			case TypesPackage.BAG_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case TypesPackage.BAG_TYPE__SERIALIZABLE:
				setSerializable(((Boolean)newValue).booleanValue());
				return;
			case TypesPackage.BAG_TYPE__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.BAG_TYPE__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.BAG_TYPE__TYPE_START_POSITION:
				setTypeStartPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.BAG_TYPE__TYPE_END_POSITION:
				setTypeEndPosition(((Integer)newValue).intValue());
				return;
			case TypesPackage.BAG_TYPE__ELEMENT_TYPE:
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
			case TypesPackage.BAG_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case TypesPackage.BAG_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesPackage.BAG_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case TypesPackage.BAG_TYPE__SERIALIZABLE:
				setSerializable(SERIALIZABLE_EDEFAULT);
				return;
			case TypesPackage.BAG_TYPE__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case TypesPackage.BAG_TYPE__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case TypesPackage.BAG_TYPE__TYPE_START_POSITION:
				setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
				return;
			case TypesPackage.BAG_TYPE__TYPE_END_POSITION:
				setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
				return;
			case TypesPackage.BAG_TYPE__ELEMENT_TYPE:
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
			case TypesPackage.BAG_TYPE__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case TypesPackage.BAG_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypesPackage.BAG_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case TypesPackage.BAG_TYPE__INSTANCE_CLASS:
				return INSTANCE_CLASS_EDEFAULT == null ? getInstanceClass() != null : !INSTANCE_CLASS_EDEFAULT.equals(getInstanceClass());
			case TypesPackage.BAG_TYPE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case TypesPackage.BAG_TYPE__EPACKAGE:
				return getEPackage() != null;
			case TypesPackage.BAG_TYPE__SERIALIZABLE:
				return ((eFlags & SERIALIZABLE_EFLAG) != 0) != SERIALIZABLE_EDEFAULT;
			case TypesPackage.BAG_TYPE__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case TypesPackage.BAG_TYPE__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case TypesPackage.BAG_TYPE__TYPE_START_POSITION:
				return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
			case TypesPackage.BAG_TYPE__TYPE_END_POSITION:
				return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
			case TypesPackage.BAG_TYPE__ELEMENT_TYPE:
				return elementType != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //BagTypeImpl
