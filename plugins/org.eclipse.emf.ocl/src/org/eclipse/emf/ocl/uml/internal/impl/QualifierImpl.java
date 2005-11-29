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

package org.eclipse.emf.ocl.uml.internal.impl;

import org.eclipse.emf.ocl.uml.AssociationEnd;
import org.eclipse.emf.ocl.uml.Qualifier;
import org.eclipse.emf.ocl.uml.UmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.uml.internal.impl.QualifierImpl#getAssociationEnd <em>Association End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifierImpl extends ETypedElementImpl implements Qualifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmlPackage.eINSTANCE.getQualifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd getAssociationEnd() {
		if (eContainerFeatureID != UmlPackage.QUALIFIER__ASSOCIATION_END) return null;
		return (AssociationEnd)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationEnd(AssociationEnd newAssociationEnd) {
		if (newAssociationEnd != eContainer || (eContainerFeatureID != UmlPackage.QUALIFIER__ASSOCIATION_END && newAssociationEnd != null)) {
			if (EcoreUtil.isAncestor(this, newAssociationEnd))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAssociationEnd != null)
				msgs = ((InternalEObject)newAssociationEnd).eInverseAdd(this, UmlPackage.ASSOCIATION_END__QUALIFIERS, AssociationEnd.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newAssociationEnd, UmlPackage.QUALIFIER__ASSOCIATION_END, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPackage.QUALIFIER__ASSOCIATION_END, newAssociationEnd, newAssociationEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UmlPackage.QUALIFIER__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case UmlPackage.QUALIFIER__ASSOCIATION_END:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, UmlPackage.QUALIFIER__ASSOCIATION_END, msgs);
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
				case UmlPackage.QUALIFIER__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case UmlPackage.QUALIFIER__ASSOCIATION_END:
					return eBasicSetContainer(null, UmlPackage.QUALIFIER__ASSOCIATION_END, msgs);
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
				case UmlPackage.QUALIFIER__ASSOCIATION_END:
					return eContainer.eInverseRemove(this, UmlPackage.ASSOCIATION_END__QUALIFIERS, AssociationEnd.class, msgs);
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
			case UmlPackage.QUALIFIER__EANNOTATIONS:
				return getEAnnotations();
			case UmlPackage.QUALIFIER__NAME:
				return getName();
			case UmlPackage.QUALIFIER__ORDERED:
				return isOrdered() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.QUALIFIER__UNIQUE:
				return isUnique() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.QUALIFIER__LOWER_BOUND:
				return new Integer(getLowerBound());
			case UmlPackage.QUALIFIER__UPPER_BOUND:
				return new Integer(getUpperBound());
			case UmlPackage.QUALIFIER__MANY:
				return isMany() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.QUALIFIER__REQUIRED:
				return isRequired() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.QUALIFIER__ETYPE:
				if (resolve) return getEType();
				return basicGetEType();
			case UmlPackage.QUALIFIER__ASSOCIATION_END:
				return getAssociationEnd();
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
			case UmlPackage.QUALIFIER__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UmlPackage.QUALIFIER__NAME:
				setName((String)newValue);
				return;
			case UmlPackage.QUALIFIER__ORDERED:
				setOrdered(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.QUALIFIER__UNIQUE:
				setUnique(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.QUALIFIER__LOWER_BOUND:
				setLowerBound(((Integer)newValue).intValue());
				return;
			case UmlPackage.QUALIFIER__UPPER_BOUND:
				setUpperBound(((Integer)newValue).intValue());
				return;
			case UmlPackage.QUALIFIER__ETYPE:
				setEType((EClassifier)newValue);
				return;
			case UmlPackage.QUALIFIER__ASSOCIATION_END:
				setAssociationEnd((AssociationEnd)newValue);
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
			case UmlPackage.QUALIFIER__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UmlPackage.QUALIFIER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmlPackage.QUALIFIER__ORDERED:
				setOrdered(ORDERED_EDEFAULT);
				return;
			case UmlPackage.QUALIFIER__UNIQUE:
				setUnique(UNIQUE_EDEFAULT);
				return;
			case UmlPackage.QUALIFIER__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case UmlPackage.QUALIFIER__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
				return;
			case UmlPackage.QUALIFIER__ETYPE:
				setEType((EClassifier)null);
				return;
			case UmlPackage.QUALIFIER__ASSOCIATION_END:
				setAssociationEnd((AssociationEnd)null);
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
			case UmlPackage.QUALIFIER__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UmlPackage.QUALIFIER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmlPackage.QUALIFIER__ORDERED:
				return ((eFlags & ORDERED_EFLAG) != 0) != ORDERED_EDEFAULT;
			case UmlPackage.QUALIFIER__UNIQUE:
				return ((eFlags & UNIQUE_EFLAG) != 0) != UNIQUE_EDEFAULT;
			case UmlPackage.QUALIFIER__LOWER_BOUND:
				return lowerBound != LOWER_BOUND_EDEFAULT;
			case UmlPackage.QUALIFIER__UPPER_BOUND:
				return upperBound != UPPER_BOUND_EDEFAULT;
			case UmlPackage.QUALIFIER__MANY:
				return isMany() != MANY_EDEFAULT;
			case UmlPackage.QUALIFIER__REQUIRED:
				return isRequired() != REQUIRED_EDEFAULT;
			case UmlPackage.QUALIFIER__ETYPE:
				return eType != null;
			case UmlPackage.QUALIFIER__ASSOCIATION_END:
				return getAssociationEnd() != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //QualifierImpl
