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
 * $Id: CollectionLiteralPartCSImpl.java,v 1.4 2010/05/24 08:55:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.Signature;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

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
public class CollectionLiteralPartCSImpl extends ElementCSImpl implements CollectionLiteralPartCS {
	/**
	 * The cached value of the '{@link #getExpressionCS() <em>Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected ExpCS expressionCS;

	/**
	 * The cached value of the '{@link #getLastExpressionCS() <em>Last Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected ExpCS lastExpressionCS;

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
	public ExpCS getExpressionCS() {
		return expressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpressionCS(ExpCS newExpressionCS, NotificationChain msgs) {
		ExpCS oldExpressionCS = expressionCS;
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
	public void setExpressionCS(ExpCS newExpressionCS) {
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
	public ExpCS getLastExpressionCS() {
		return lastExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLastExpressionCS(ExpCS newLastExpressionCS, NotificationChain msgs) {
		ExpCS oldLastExpressionCS = lastExpressionCS;
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
	public void setLastExpressionCS(ExpCS newLastExpressionCS) {
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
				setExpressionCS((ExpCS)newValue);
				return;
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
				setLastExpressionCS((ExpCS)newValue);
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
				setExpressionCS((ExpCS)null);
				return;
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
				setLastExpressionCS((ExpCS)null);
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

	@Override
	public void getSignature(Signature signature, TypeBindingsCS typeBindings) {
		signature.appendParent(this, "@", typeBindings);
		signature.appendIndex(this);
	}
} //CollectionLiteralPartCSImpl
