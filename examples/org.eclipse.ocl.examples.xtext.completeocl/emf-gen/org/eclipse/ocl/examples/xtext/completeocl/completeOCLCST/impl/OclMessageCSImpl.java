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
 * $Id: OclMessageCSImpl.java,v 1.1 2010/04/13 06:38:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageCS;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OclExpressionCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Message CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageCSImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageCSImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageCSImpl#getMessageName <em>Message Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.OclMessageCSImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclMessageCSImpl extends OclExpressionCSImpl implements OclMessageCS {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionCS source;

	/**
	 * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected static final String OP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected String op = OP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMessageName() <em>Message Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageName()
	 * @generated
	 * @ordered
	 */
	protected SimpleNameCS messageName;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<OclExpressionCS> arguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclMessageCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSTPackage.Literals.OCL_MESSAGE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionCS getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(OclExpressionCS newSource, NotificationChain msgs) {
		OclExpressionCS oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.OCL_MESSAGE_CS__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(OclExpressionCS newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.OCL_MESSAGE_CS__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.OCL_MESSAGE_CS__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.OCL_MESSAGE_CS__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOp() {
		return op;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOp(String newOp) {
		String oldOp = op;
		op = newOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.OCL_MESSAGE_CS__OP, oldOp, op));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS getMessageName() {
		return messageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMessageName(SimpleNameCS newMessageName, NotificationChain msgs) {
		SimpleNameCS oldMessageName = messageName;
		messageName = newMessageName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.OCL_MESSAGE_CS__MESSAGE_NAME, oldMessageName, newMessageName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageName(SimpleNameCS newMessageName) {
		if (newMessageName != messageName) {
			NotificationChain msgs = null;
			if (messageName != null)
				msgs = ((InternalEObject)messageName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.OCL_MESSAGE_CS__MESSAGE_NAME, null, msgs);
			if (newMessageName != null)
				msgs = ((InternalEObject)newMessageName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.OCL_MESSAGE_CS__MESSAGE_NAME, null, msgs);
			msgs = basicSetMessageName(newMessageName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.OCL_MESSAGE_CS__MESSAGE_NAME, newMessageName, newMessageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclExpressionCS> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<OclExpressionCS>(OclExpressionCS.class, this, CompleteOCLCSTPackage.OCL_MESSAGE_CS__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__SOURCE:
				return basicSetSource(null, msgs);
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__MESSAGE_NAME:
				return basicSetMessageName(null, msgs);
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__SOURCE:
				return getSource();
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__OP:
				return getOp();
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__MESSAGE_NAME:
				return getMessageName();
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__ARGUMENTS:
				return getArguments();
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
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__SOURCE:
				setSource((OclExpressionCS)newValue);
				return;
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__OP:
				setOp((String)newValue);
				return;
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__MESSAGE_NAME:
				setMessageName((SimpleNameCS)newValue);
				return;
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends OclExpressionCS>)newValue);
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
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__SOURCE:
				setSource((OclExpressionCS)null);
				return;
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__OP:
				setOp(OP_EDEFAULT);
				return;
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__MESSAGE_NAME:
				setMessageName((SimpleNameCS)null);
				return;
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__ARGUMENTS:
				getArguments().clear();
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
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__SOURCE:
				return source != null;
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__OP:
				return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__MESSAGE_NAME:
				return messageName != null;
			case CompleteOCLCSTPackage.OCL_MESSAGE_CS__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
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
		result.append(" (op: ");
		result.append(op);
		result.append(')');
		return result.toString();
	}

} //OclMessageCSImpl
