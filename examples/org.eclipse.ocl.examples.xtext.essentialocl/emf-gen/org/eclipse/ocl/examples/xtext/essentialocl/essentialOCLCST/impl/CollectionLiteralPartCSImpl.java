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
 * $Id: CollectionLiteralPartCSImpl.java,v 1.1 2010/04/13 06:32:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralPartCSImpl#getExpressionCS <em>Expression CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralPartCSImpl#getLastExpressionCS <em>Last Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralPartCSImpl extends EObjectImpl implements CollectionLiteralPartCS {
	/**
	 * The cached value of the '{@link #getExpressionCS() <em>Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionCS expressionCS;

	/**
	 * The cached value of the '{@link #getLastExpressionCS() <em>Last Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionCS lastExpressionCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionLiteralPartCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSTPackage.Literals.COLLECTION_LITERAL_PART_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionCS getExpressionCS() {
		return expressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpressionCS(OclExpressionCS newExpressionCS, NotificationChain msgs) {
		OclExpressionCS oldExpressionCS = expressionCS;
		expressionCS = newExpressionCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS, oldExpressionCS, newExpressionCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionCS(OclExpressionCS newExpressionCS) {
		if (newExpressionCS != expressionCS) {
			NotificationChain msgs = null;
			if (expressionCS != null)
				msgs = ((InternalEObject)expressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS, null, msgs);
			if (newExpressionCS != null)
				msgs = ((InternalEObject)newExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS, null, msgs);
			msgs = basicSetExpressionCS(newExpressionCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS, newExpressionCS, newExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionCS getLastExpressionCS() {
		return lastExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLastExpressionCS(OclExpressionCS newLastExpressionCS, NotificationChain msgs) {
		OclExpressionCS oldLastExpressionCS = lastExpressionCS;
		lastExpressionCS = newLastExpressionCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS, oldLastExpressionCS, newLastExpressionCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastExpressionCS(OclExpressionCS newLastExpressionCS) {
		if (newLastExpressionCS != lastExpressionCS) {
			NotificationChain msgs = null;
			if (lastExpressionCS != null)
				msgs = ((InternalEObject)lastExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS, null, msgs);
			if (newLastExpressionCS != null)
				msgs = ((InternalEObject)newLastExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS, null, msgs);
			msgs = basicSetLastExpressionCS(newLastExpressionCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS, newLastExpressionCS, newLastExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS:
				return basicSetExpressionCS(null, msgs);
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
				return basicSetLastExpressionCS(null, msgs);
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
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS:
				return getExpressionCS();
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
				return getLastExpressionCS();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS:
				setExpressionCS((OclExpressionCS)newValue);
				return;
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
				setLastExpressionCS((OclExpressionCS)newValue);
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
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS:
				setExpressionCS((OclExpressionCS)null);
				return;
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
				setLastExpressionCS((OclExpressionCS)null);
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
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS:
				return expressionCS != null;
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
				return lastExpressionCS != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionLiteralPartCSImpl
