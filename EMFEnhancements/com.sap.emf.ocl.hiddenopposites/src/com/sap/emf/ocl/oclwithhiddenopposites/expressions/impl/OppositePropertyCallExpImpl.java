/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl;

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
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.impl.NavigationCallExpImpl;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.ToStringVisitor;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.Visitor;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsPackage;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.util.ExpressionsValidator;
import com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opposite Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl.OppositePropertyCallExpImpl#getReferredOppositeProperty <em>Referred Opposite Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OppositePropertyCallExpImpl extends NavigationCallExpImpl implements OppositePropertyCallExp {
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
                return ExpressionsPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EReference getReferredOppositeProperty() {
                if (referredOppositeProperty != null && referredOppositeProperty.eIsProxy()) {
                        InternalEObject oldReferredOppositeProperty = (InternalEObject)referredOppositeProperty;
                        referredOppositeProperty = (EReference)eResolveProxy(oldReferredOppositeProperty);
                        if (referredOppositeProperty != oldReferredOppositeProperty) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY, oldReferredOppositeProperty, referredOppositeProperty));
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
	public void setReferredOppositeProperty(EReference newReferredOppositeProperty) {
                EReference oldReferredOppositeProperty = referredOppositeProperty;
                referredOppositeProperty = newReferredOppositeProperty;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY, oldReferredOppositeProperty, referredOppositeProperty));
        }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean property_type(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean good = false;
		EClass eClass = (EClass) getReferredOppositeProperty().eContainer();
		EClassifier type = getType();
		if (type instanceof CollectionType) {
			CollectionType collectionType = (CollectionType) type;
			EClassifier elementType = collectionType.getElementType();
			good = TypeUtil.exactTypeMatch(OCLUtil.getValidationEnvironment(this, context), elementType, eClass);
		}
		if (!good) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ExpressionsValidator.DIAGNOSTIC_SOURCE,
						 ExpressionsValidator.OPPOSITE_PROPERTY_CALL_EXP__PROPERTY_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "property_type", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
		}
		return good;
	}

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY:
                                if (resolve) return getReferredOppositeProperty();
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
                        case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY:
                                setReferredOppositeProperty((EReference)newValue);
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
                        case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY:
                                setReferredOppositeProperty((EReference)null);
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
                        case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY:
                                return referredOppositeProperty != null;
                }
                return super.eIsSet(featureID);
        }

    /**
     * @generated NOT
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
	if (v instanceof ToStringVisitor<?, ?, ?, ?, ?, ?, ?, ?, ?>) {
	    EReference property = getReferredOppositeProperty();

	    T sourceResult = getSource() == null ? null : getSource().accept(v);
	    if (sourceResult == null) {
		// if we are the qualifier of an association class call, then
		// we just return our name, because our source is null (implied)
		return (T) ("oppositeOf(" + property.getName() + ")"); //$NON-NLS-1$//$NON-NLS-2$
	    }
	    String base = sourceResult + ".oppositeOf(" + property.getName() + ")";//$NON-NLS-1$ //$NON-NLS-2$
	    StringBuffer result = new StringBuffer(isMarkedPre() ? base + "@pre" : base);
	    // in this case T must have been String because ToStringVisitor has T==String
	    return (T) result.toString();
	}
	if (v instanceof VisitorWithHiddenOpposite<?>) {
	    return ((VisitorWithHiddenOpposite<T>) v).visitOppositePropertyCallExp(this);
	} else {
	    return null;
	}
    }
} //OppositePropertyCallExpImpl
