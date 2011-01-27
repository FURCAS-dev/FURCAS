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
 * $Id: CollectionTypeImpl.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionTypeImpl#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionTypeImpl
		extends DataTypeImpl
		implements CollectionType {

	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected Type elementType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COLLECTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getElementType() {
		if (elementType != null && ((EObject)elementType).eIsProxy())
		{
			InternalEObject oldElementType = (InternalEObject)elementType;
			elementType = (Type)eResolveProxy(oldElementType);
			if (elementType != oldElementType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE, oldElementType, elementType));
			}
		}
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetElementType() {
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementType(Type newElementType) {
		Type oldElementType = elementType;
		elementType = newElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE, oldElementType, elementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_TYPE__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.COLLECTION_TYPE__MONIKER:
				return getMoniker();
			case PivotPackage.COLLECTION_TYPE__NAME:
				return getName();
			case PivotPackage.COLLECTION_TYPE__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.COLLECTION_TYPE__IS_STATIC:
				return isStatic();
			case PivotPackage.COLLECTION_TYPE__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER:
				if (resolve) return getOwningTemplateParameter();
				return basicGetOwningTemplateParameter();
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_PARAMETER:
				if (resolve) return getTemplateParameter();
				return basicGetTemplateParameter();
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_BINDING:
				return getTemplateBindings();
			case PivotPackage.COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE:
				if (resolve) return getOwnedTemplateSignature();
				return basicGetOwnedTemplateSignature();
			case PivotPackage.COLLECTION_TYPE__PACKAGE:
				if (resolve) return getPackage();
				return basicGetPackage();
			case PivotPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case PivotPackage.COLLECTION_TYPE__IS_ABSTRACT:
				return isAbstract();
			case PivotPackage.COLLECTION_TYPE__OWNED_ATTRIBUTE:
				return getOwnedAttributes();
			case PivotPackage.COLLECTION_TYPE__OWNED_OPERATION:
				return getOwnedOperations();
			case PivotPackage.COLLECTION_TYPE__SUPER_CLASS:
				return getSuperClasses();
			case PivotPackage.COLLECTION_TYPE__IS_INTERFACE:
				return isInterface();
			case PivotPackage.COLLECTION_TYPE__SUB_CLASS:
				return getSubClasses();
			case PivotPackage.COLLECTION_TYPE__IS_SERIALIZABLE:
				return isSerializable();
			case PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				if (resolve) return getElementType();
				return basicGetElementType();
		}
		return eDynamicGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_TYPE__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				getTemplateBindings().addAll((Collection<? extends TemplateBinding>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttributes().clear();
				getOwnedAttributes().addAll((Collection<? extends Property>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_OPERATION:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__SUPER_CLASS:
				getSuperClasses().clear();
				getSuperClasses().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_INTERFACE:
				setIsInterface((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__SUB_CLASS:
				getSubClasses().clear();
				getSubClasses().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Class>)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_SERIALIZABLE:
				setIsSerializable((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				setElementType((Type)newValue);
				return;
		}
		eDynamicSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_TYPE__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER:
				setOwningTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_PARAMETER:
				setTemplateParameter((TemplateParameter)null);
				return;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_BINDING:
				getTemplateBindings().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignature)null);
				return;
			case PivotPackage.COLLECTION_TYPE__PACKAGE:
				setPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case PivotPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_ATTRIBUTE:
				getOwnedAttributes().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__OWNED_OPERATION:
				getOwnedOperations().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__SUPER_CLASS:
				getSuperClasses().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__IS_INTERFACE:
				setIsInterface(IS_INTERFACE_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__SUB_CLASS:
				getSubClasses().clear();
				return;
			case PivotPackage.COLLECTION_TYPE__IS_SERIALIZABLE:
				setIsSerializable(IS_SERIALIZABLE_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				setElementType((Type)null);
				return;
		}
		eDynamicUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_TYPE__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.COLLECTION_TYPE__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.COLLECTION_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COLLECTION_TYPE__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.COLLECTION_TYPE__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.COLLECTION_TYPE__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER:
				return basicGetOwningTemplateParameter() != null;
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_PARAMETER:
				return isSetTemplateParameter();
			case PivotPackage.COLLECTION_TYPE__TEMPLATE_BINDING:
				return templateBindings != null && !templateBindings.isEmpty();
			case PivotPackage.COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case PivotPackage.COLLECTION_TYPE__PACKAGE:
				return basicGetPackage() != null;
			case PivotPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME:
				return isSetInstanceClassName();
			case PivotPackage.COLLECTION_TYPE__IS_ABSTRACT:
				return ((eFlags & IS_ABSTRACT_EFLAG) != 0) != IS_ABSTRACT_EDEFAULT;
			case PivotPackage.COLLECTION_TYPE__OWNED_ATTRIBUTE:
				return ownedAttributes != null && !ownedAttributes.isEmpty();
			case PivotPackage.COLLECTION_TYPE__OWNED_OPERATION:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case PivotPackage.COLLECTION_TYPE__SUPER_CLASS:
				return superClasses != null && !superClasses.isEmpty();
			case PivotPackage.COLLECTION_TYPE__IS_INTERFACE:
				return ((eFlags & IS_INTERFACE_EFLAG) != 0) != IS_INTERFACE_EDEFAULT;
			case PivotPackage.COLLECTION_TYPE__SUB_CLASS:
				return subClasses != null && !subClasses.isEmpty();
			case PivotPackage.COLLECTION_TYPE__IS_SERIALIZABLE:
				return ((eFlags & IS_SERIALIZABLE_EFLAG) != 0) != IS_SERIALIZABLE_EDEFAULT;
			case PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE:
				return elementType != null;
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitCollectionType(this);
	}
} //CollectionTypeImpl
