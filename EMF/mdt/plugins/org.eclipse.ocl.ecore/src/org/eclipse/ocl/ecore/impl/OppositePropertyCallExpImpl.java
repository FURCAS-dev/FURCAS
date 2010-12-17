/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 SAP AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Axel Uhl - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OppositePropertyCallExpImpl.java,v 1.1 2010/12/15 17:32:43 ewillink Exp $
 */
package org.eclipse.ocl.ecore.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.util.EcoreValidator;
import org.eclipse.ocl.ecore.utilities.VisitorExtension;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opposite Property Call Exp</b></em>'.
 * @since 3.1
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.impl.OppositePropertyCallExpImpl#getReferredOppositeProperty <em>Referred Opposite Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OppositePropertyCallExpImpl
		extends NavigationCallExpImpl
		implements OppositePropertyCallExp {

	private static final int OPPOSITE_PROPERTY_CALL_EXP__OPPOSITE_PROPERTY_TYPE = 1;

	/**
	 * The cached value of the '{@link #getReferredOppositeProperty() <em>Referred Opposite Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOppositeProperty()
	 * @generated
	 * @ordered
	 */
	protected EReference referredOppositeProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OppositePropertyCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorePackage.Literals.OPPOSITE_PROPERTY_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferredOppositeProperty() {
		if (referredOppositeProperty != null
			&& referredOppositeProperty.eIsProxy()) {
			InternalEObject oldReferredOppositeProperty = (InternalEObject) referredOppositeProperty;
			referredOppositeProperty = (EReference) eResolveProxy(oldReferredOppositeProperty);
			if (referredOppositeProperty != oldReferredOppositeProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
						this,
						Notification.RESOLVE,
						EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY,
						oldReferredOppositeProperty, referredOppositeProperty));
			}
		}
		return referredOppositeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReferredOppositeProperty() {
		return referredOppositeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredOppositeProperty(
			EReference newReferredOppositeProperty) {
		EReference oldReferredOppositeProperty = referredOppositeProperty;
		referredOppositeProperty = newReferredOppositeProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
				this,
				Notification.SET,
				EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY,
				oldReferredOppositeProperty, referredOppositeProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				if (resolve)
					return getReferredOppositeProperty();
				return basicGetReferredOppositeProperty();
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
			case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				setReferredOppositeProperty((EReference) newValue);
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
			case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				setReferredOppositeProperty((EReference) null);
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
			case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				return referredOppositeProperty != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean checkOppositePropertyType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		boolean result = true;
		Environment<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
			.getValidationEnvironment(this, context);

		if (env != null) {
			EReference property = getReferredOppositeProperty();
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> source = getSource();
			EClassifier type = getType();

			if ((property != null) && (source != null)) {
				UMLReflection<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, ?> uml = env
					.getUMLReflection();
				EClassifier refType = uml.getOwningClassifier(property);

				if (!TypeUtil.exactTypeMatch(env, refType, type)) {
					result = false;
				}
			}
		}

		if (!result) {
			if (diagnostics != null) {
				// TODO: Specific message
				diagnostics
					.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						EcoreValidator.DIAGNOSTIC_SOURCE,
						OPPOSITE_PROPERTY_CALL_EXP__OPPOSITE_PROPERTY_TYPE,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"checkOppositePropertyType", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(this, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{this}));
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		if (v instanceof VisitorExtension<?>) {
			return ((VisitorExtension<T>) v).visitOppositePropertyCallExp(this);
		} else {
			return null;
		}
	}
} //OppositePropertyCallExpImpl
