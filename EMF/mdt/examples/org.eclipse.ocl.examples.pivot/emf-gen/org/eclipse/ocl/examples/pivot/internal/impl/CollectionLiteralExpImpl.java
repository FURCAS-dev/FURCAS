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
 * $Id: CollectionLiteralExpImpl.java,v 1.2 2011/01/24 20:42:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.CollectionLiteralExpImpl#getParts <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralExpImpl
		extends LiteralExpImpl
		implements CollectionLiteralExp {

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final CollectionKind KIND_EDEFAULT = CollectionKind.COLLECTION;

	/**
	 * The offset of the flags representing the value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG_OFFSET = 9;

	/**
	 * The flags representing the default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG_DEFAULT = KIND_EDEFAULT.ordinal() << KIND_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link CollectionKind Collection Kind}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final CollectionKind[] KIND_EFLAG_VALUES = CollectionKind.values();

	/**
	 * The flags representing the value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EFLAG = 0x7 << KIND_EFLAG_OFFSET;

	/**
	 * The cached value of the '{@link #getParts() <em>Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectionLiteralPart> parts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.COLLECTION_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionKind getKind() {
		return KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(CollectionKind newKind) {
		CollectionKind oldKind = KIND_EFLAG_VALUES[(eFlags & KIND_EFLAG) >>> KIND_EFLAG_OFFSET];
		if (newKind == null) newKind = KIND_EDEFAULT;
		eFlags = eFlags & ~KIND_EFLAG | newKind.ordinal() << KIND_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PivotPackage.COLLECTION_LITERAL_EXP__KIND, oldKind, newKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectionLiteralPart> getParts() {
		if (parts == null)
		{
			parts = new EObjectContainmentEList.Resolving<CollectionLiteralPart>(CollectionLiteralPart.class, this, PivotPackage.COLLECTION_LITERAL_EXP__PART);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralPart createPart(EClass eClass) {
		CollectionLiteralPart newPart = (CollectionLiteralPart) create(eClass);
		getParts().add(newPart);
		return newPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRules()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
		}
		return eDynamicInverseRemove(otherEnd, featureID, msgs);
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
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.COLLECTION_LITERAL_EXP__MONIKER:
				return getMoniker();
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				return getName();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				return isStatic();
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				return getKind();
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				return getParts();
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
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				setType((Type)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				setKind((CollectionKind)newValue);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				getParts().clear();
				getParts().addAll((Collection<? extends CollectionLiteralPart>)newValue);
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
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				setType((Type)null);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				getParts().clear();
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
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.COLLECTION_LITERAL_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.COLLECTION_LITERAL_EXP__TYPE:
				return type != null;
			case PivotPackage.COLLECTION_LITERAL_EXP__KIND:
				return (eFlags & KIND_EFLAG) != KIND_EFLAG_DEFAULT;
			case PivotPackage.COLLECTION_LITERAL_EXP__PART:
				return parts != null && !parts.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitCollectionLiteralExp(this);
	}
} //CollectionLiteralExpImpl
