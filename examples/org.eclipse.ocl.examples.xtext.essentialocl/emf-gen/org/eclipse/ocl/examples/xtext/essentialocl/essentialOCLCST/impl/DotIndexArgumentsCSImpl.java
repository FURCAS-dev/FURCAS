/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: DotIndexArgumentsCSImpl.java,v 1.1 2010/04/13 06:32:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotIndexArgumentsCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dot Index Arguments CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DotIndexArgumentsCSImpl#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DotIndexArgumentsCSImpl#isIsPre <em>Is Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DotIndexArgumentsCSImpl extends CallArgumentsCSImpl implements DotIndexArgumentsCS {
	/**
	 * The cached value of the '{@link #getIndexes() <em>Indexes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexes()
	 * @generated
	 * @ordered
	 */
	protected EList<OclExpressionCS> indexes;

	/**
	 * The default value of the '{@link #isIsPre() <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPre()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PRE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPre() <em>Is Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPre()
	 * @generated
	 * @ordered
	 */
	protected boolean isPre = IS_PRE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DotIndexArgumentsCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSTPackage.Literals.DOT_INDEX_ARGUMENTS_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclExpressionCS> getIndexes() {
		if (indexes == null) {
			indexes = new EObjectContainmentEList<OclExpressionCS>(OclExpressionCS.class, this, EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__INDEXES);
		}
		return indexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPre() {
		return isPre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPre(boolean newIsPre) {
		boolean oldIsPre = isPre;
		isPre = newIsPre;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__IS_PRE, oldIsPre, isPre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__INDEXES:
				return ((InternalEList<?>)getIndexes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__INDEXES:
				return getIndexes();
			case EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__IS_PRE:
				return isIsPre();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__INDEXES:
				getIndexes().clear();
				getIndexes().addAll((Collection<? extends OclExpressionCS>)newValue);
				return;
			case EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__IS_PRE:
				setIsPre((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__INDEXES:
				getIndexes().clear();
				return;
			case EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__IS_PRE:
				setIsPre(IS_PRE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__INDEXES:
				return indexes != null && !indexes.isEmpty();
			case EssentialOCLCSTPackage.DOT_INDEX_ARGUMENTS_CS__IS_PRE:
				return isPre != IS_PRE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isPre: ");
		result.append(isPre);
		result.append(')');
		return result.toString();
	}

} //DotIndexArgumentsCSImpl
