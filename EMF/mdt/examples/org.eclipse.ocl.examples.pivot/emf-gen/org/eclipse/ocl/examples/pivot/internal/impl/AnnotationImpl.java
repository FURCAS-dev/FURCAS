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
 * $Id: AnnotationImpl.java,v 1.2 2011/01/24 20:42:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl#getOwnedContents <em>Owned Content</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl#getOwnedDetails <em>Owned Detail</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.internal.impl.AnnotationImpl#getReferences <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationImpl
		extends NamedElementImpl
		implements Annotation {

	/**
	 * The cached value of the '{@link #getOwnedContents() <em>Owned Content</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedContents()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> ownedContents;

	/**
	 * The cached value of the '{@link #getOwnedDetails() <em>Owned Detail</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDetails()
	 * @generated
	 * @ordered
	 */
	protected EList<Detail> ownedDetails;

	/**
	 * The cached value of the '{@link #getReferences() <em>Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> references;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PivotPackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getOwnedContents() {
		if (ownedContents == null)
		{
			ownedContents = new EObjectContainmentEList.Resolving<Element>(Element.class, this, PivotPackage.ANNOTATION__OWNED_CONTENT);
		}
		return ownedContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element createOwnedContent(EClass eClass) {
		Element newOwnedContent = (Element) create(eClass);
		getOwnedContents().add(newOwnedContent);
		return newOwnedContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getReferences() {
		if (references == null)
		{
			references = new EObjectResolvingEList<Element>(Element.class, this, PivotPackage.ANNOTATION__REFERENCE);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Detail> getOwnedDetails() {
		if (ownedDetails == null)
		{
			ownedDetails = new EObjectContainmentEList.Resolving<Detail>(Detail.class, this, PivotPackage.ANNOTATION__OWNED_DETAIL);
		}
		return ownedDetails;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Detail createOwnedDetail() {
		Detail newOwnedDetail = (Detail) create(PivotPackage.Literals.DETAIL);
		getOwnedDetails().add(newOwnedDetail);
		return newOwnedDetail;
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
			case PivotPackage.ANNOTATION__OWNED_COMMENT:
				return ((InternalEList<?>)getOwnedComments()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_RULE:
				return ((InternalEList<?>)getOwnedRules()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_ANNOTATION:
				return ((InternalEList<?>)getOwnedAnnotations()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_CONTENT:
				return ((InternalEList<?>)getOwnedContents()).basicRemove(otherEnd, msgs);
			case PivotPackage.ANNOTATION__OWNED_DETAIL:
				return ((InternalEList<?>)getOwnedDetails()).basicRemove(otherEnd, msgs);
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
			case PivotPackage.ANNOTATION__OWNED_COMMENT:
				return getOwnedComments();
			case PivotPackage.ANNOTATION__MONIKER:
				return getMoniker();
			case PivotPackage.ANNOTATION__NAME:
				return getName();
			case PivotPackage.ANNOTATION__OWNED_RULE:
				return getOwnedRules();
			case PivotPackage.ANNOTATION__IS_STATIC:
				return isStatic();
			case PivotPackage.ANNOTATION__OWNED_ANNOTATION:
				return getOwnedAnnotations();
			case PivotPackage.ANNOTATION__OWNED_CONTENT:
				return getOwnedContents();
			case PivotPackage.ANNOTATION__OWNED_DETAIL:
				return getOwnedDetails();
			case PivotPackage.ANNOTATION__REFERENCE:
				return getReferences();
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
			case PivotPackage.ANNOTATION__OWNED_COMMENT:
				getOwnedComments().clear();
				getOwnedComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case PivotPackage.ANNOTATION__MONIKER:
				setMoniker((String)newValue);
				return;
			case PivotPackage.ANNOTATION__NAME:
				setName((String)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_RULE:
				getOwnedRules().clear();
				getOwnedRules().addAll((Collection<? extends Constraint>)newValue);
				return;
			case PivotPackage.ANNOTATION__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				getOwnedAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_CONTENT:
				getOwnedContents().clear();
				getOwnedContents().addAll((Collection<? extends Element>)newValue);
				return;
			case PivotPackage.ANNOTATION__OWNED_DETAIL:
				getOwnedDetails().clear();
				getOwnedDetails().addAll((Collection<? extends Detail>)newValue);
				return;
			case PivotPackage.ANNOTATION__REFERENCE:
				getReferences().clear();
				getReferences().addAll((Collection<? extends Element>)newValue);
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
			case PivotPackage.ANNOTATION__OWNED_COMMENT:
				getOwnedComments().clear();
				return;
			case PivotPackage.ANNOTATION__MONIKER:
				setMoniker(MONIKER_EDEFAULT);
				return;
			case PivotPackage.ANNOTATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PivotPackage.ANNOTATION__OWNED_RULE:
				getOwnedRules().clear();
				return;
			case PivotPackage.ANNOTATION__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case PivotPackage.ANNOTATION__OWNED_ANNOTATION:
				getOwnedAnnotations().clear();
				return;
			case PivotPackage.ANNOTATION__OWNED_CONTENT:
				getOwnedContents().clear();
				return;
			case PivotPackage.ANNOTATION__OWNED_DETAIL:
				getOwnedDetails().clear();
				return;
			case PivotPackage.ANNOTATION__REFERENCE:
				getReferences().clear();
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
			case PivotPackage.ANNOTATION__OWNED_COMMENT:
				return ownedComments != null && !ownedComments.isEmpty();
			case PivotPackage.ANNOTATION__MONIKER:
				return MONIKER_EDEFAULT == null ? getMoniker() != null : !MONIKER_EDEFAULT.equals(getMoniker());
			case PivotPackage.ANNOTATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PivotPackage.ANNOTATION__OWNED_RULE:
				return ownedRules != null && !ownedRules.isEmpty();
			case PivotPackage.ANNOTATION__IS_STATIC:
				return ((eFlags & IS_STATIC_EFLAG) != 0) != IS_STATIC_EDEFAULT;
			case PivotPackage.ANNOTATION__OWNED_ANNOTATION:
				return ownedAnnotations != null && !ownedAnnotations.isEmpty();
			case PivotPackage.ANNOTATION__OWNED_CONTENT:
				return ownedContents != null && !ownedContents.isEmpty();
			case PivotPackage.ANNOTATION__OWNED_DETAIL:
				return ownedDetails != null && !ownedDetails.isEmpty();
			case PivotPackage.ANNOTATION__REFERENCE:
				return references != null && !references.isEmpty();
		}
		return eDynamicIsSet(featureID);
	}

	@Override
	public <R, C> R accept(Visitor<R, C> visitor) {
		return visitor.visitAnnotation(this);
	}
} //AnnotationImpl
