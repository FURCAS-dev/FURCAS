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
 * $Id: RoundBracketExpCSImpl.java,v 1.2 2010/05/21 20:12:10 ewillink Exp $
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
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RoundBracketExpCSImpl#getVariable1 <em>Variable1</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RoundBracketExpCSImpl#getVariable2 <em>Variable2</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RoundBracketExpCSImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RoundBracketExpCSImpl#isPre <em>Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoundBracketExpCSImpl extends NamedExpCSImpl implements RoundBracketExpCS {
	/**
	 * The cached value of the '{@link #getVariable1() <em>Variable1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable1()
	 * @generated
	 * @ordered
	 */
	protected VariableCS variable1;

	/**
	 * The cached value of the '{@link #getVariable2() <em>Variable2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable2()
	 * @generated
	 * @ordered
	 */
	protected VariableCS variable2;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> arguments;

	/**
	 * The default value of the '{@link #isPre() <em>Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPre()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPre() <em>Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPre()
	 * @generated
	 * @ordered
	 */
	protected boolean pre = PRE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoundBracketExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSTPackage.Literals.ROUND_BRACKET_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCS getVariable1() {
		return variable1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariable1(VariableCS newVariable1, NotificationChain msgs) {
		VariableCS oldVariable1 = variable1;
		variable1 = newVariable1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE1, oldVariable1, newVariable1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable1(VariableCS newVariable1) {
		if (newVariable1 != variable1) {
			NotificationChain msgs = null;
			if (variable1 != null)
				msgs = ((InternalEObject)variable1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE1, null, msgs);
			if (newVariable1 != null)
				msgs = ((InternalEObject)newVariable1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE1, null, msgs);
			msgs = basicSetVariable1(newVariable1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE1, newVariable1, newVariable1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCS getVariable2() {
		return variable2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariable2(VariableCS newVariable2, NotificationChain msgs) {
		VariableCS oldVariable2 = variable2;
		variable2 = newVariable2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE2, oldVariable2, newVariable2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable2(VariableCS newVariable2) {
		if (newVariable2 != variable2) {
			NotificationChain msgs = null;
			if (variable2 != null)
				msgs = ((InternalEObject)variable2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE2, null, msgs);
			if (newVariable2 != null)
				msgs = ((InternalEObject)newVariable2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE2, null, msgs);
			msgs = basicSetVariable2(newVariable2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE2, newVariable2, newVariable2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPre() {
		return pre;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPre(boolean newPre) {
		boolean oldPre = pre;
		pre = newPre;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__PRE, oldPre, pre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE1:
				return basicSetVariable1(null, msgs);
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE2:
				return basicSetVariable2(null, msgs);
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__ARGUMENTS:
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
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE1:
				return getVariable1();
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE2:
				return getVariable2();
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__ARGUMENTS:
				return getArguments();
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__PRE:
				return isPre();
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
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE1:
				setVariable1((VariableCS)newValue);
				return;
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE2:
				setVariable2((VariableCS)newValue);
				return;
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends ExpCS>)newValue);
				return;
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__PRE:
				setPre((Boolean)newValue);
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
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE1:
				setVariable1((VariableCS)null);
				return;
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE2:
				setVariable2((VariableCS)null);
				return;
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__ARGUMENTS:
				getArguments().clear();
				return;
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__PRE:
				setPre(PRE_EDEFAULT);
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
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE1:
				return variable1 != null;
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__VARIABLE2:
				return variable2 != null;
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case EssentialOCLCSTPackage.ROUND_BRACKET_EXP_CS__PRE:
				return pre != PRE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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

} //CallExpCSImpl
