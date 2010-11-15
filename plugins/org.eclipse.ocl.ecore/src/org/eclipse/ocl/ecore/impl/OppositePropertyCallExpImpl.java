/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.ecore.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.ocl.utilities.VisitorWithHiddenOpposite;

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

	/**
	 * The cached value of the '{@link #getReferredOppositeProperty() <em>Referred Opposite Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOppositeProperty()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature referredOppositeProperty;

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
	public EStructuralFeature getReferredOppositeProperty() {
		if (referredOppositeProperty != null
			&& ((EObject) referredOppositeProperty).eIsProxy()) {
			InternalEObject oldReferredOppositeProperty = (InternalEObject) referredOppositeProperty;
			referredOppositeProperty = (EStructuralFeature) eResolveProxy(oldReferredOppositeProperty);
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
	public EStructuralFeature basicGetReferredOppositeProperty() {
		return referredOppositeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredOppositeProperty(
			EStructuralFeature newReferredOppositeProperty) {
		EStructuralFeature oldReferredOppositeProperty = referredOppositeProperty;
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
	public boolean checkPropertyType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		boolean result = true;
		Environment<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object> env = OCLUtil
			.getValidationEnvironment(this, context);

		if (env != null) {
			EStructuralFeature property = this.getReferredOppositeProperty();
			OCLExpression<EClassifier> source = this.getSource();
			EClassifier type = this.getType();

			if ((property != null) && (source != null)) {
				EClass refType = (EClass) property.eContainer();

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
						ExpressionsValidator.DIAGNOSTIC_SOURCE,
						ExpressionsValidator.PROPERTY_CALL_EXP__PROPERTY_TYPE,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
							.getString(
								"_UI_GenericInvariant_diagnostic", new Object[]{"checkPropertyType", org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(this, context)}), //$NON-NLS-1$ //$NON-NLS-2$
						new Object[]{this}));
			}
		}
		return result;
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
				setReferredOppositeProperty((EStructuralFeature) newValue);
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
				setReferredOppositeProperty((EStructuralFeature) null);
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
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == org.eclipse.ocl.expressions.OppositePropertyCallExp.class) {
			switch (derivedFeatureID) {
				case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
					return ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY;
				default :
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == org.eclipse.ocl.expressions.OppositePropertyCallExp.class) {
			switch (baseFeatureID) {
				case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
					return EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		if (v instanceof VisitorWithHiddenOpposite<?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) {
			return ((VisitorWithHiddenOpposite<T, EClassifier, ?, EStructuralFeature, ?, ?, ?, ?, ?, ?>) v)
				.visitOppositePropertyCallExp(this);
		} else {
			return null;
		}
	}
} //OppositePropertyCallExpImpl
