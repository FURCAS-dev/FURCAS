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
 * $Id: SquareBracketExpCSImpl.java,v 1.2 2010/05/21 20:12:10 ewillink Exp $
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
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SquareBracketExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SquareBracketExpCSImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SquareBracketExpCSImpl#isPre <em>Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SquareBracketExpCSImpl extends NamedExpCSImpl implements SquareBracketExpCS {
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
	protected SquareBracketExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSTPackage.Literals.SQUARE_BRACKET_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__ARGUMENTS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__PRE, oldPre, pre));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__ARGUMENTS:
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
			case EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__ARGUMENTS:
				return getArguments();
			case EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__PRE:
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
			case EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends ExpCS>)newValue);
				return;
			case EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__PRE:
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
			case EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__ARGUMENTS:
				getArguments().clear();
				return;
			case EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__PRE:
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
			case EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case EssentialOCLCSTPackage.SQUARE_BRACKET_EXP_CS__PRE:
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

} //IndexExpCSImpl
