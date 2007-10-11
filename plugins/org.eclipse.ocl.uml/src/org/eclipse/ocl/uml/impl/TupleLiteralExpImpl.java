/**
 * <copyright>
 * 
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TupleLiteralExpImpl.java,v 1.2 2007/10/11 23:05:21 cdamus Exp $
 */
package org.eclipse.ocl.uml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.TupleLiteralPart;

import org.eclipse.ocl.uml.TupleLiteralExp;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.impl.TupleLiteralExpImpl#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class TupleLiteralExpImpl extends LiteralExpImpl implements TupleLiteralExp {
	/**
     * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPart()
     * @generated
     * @ordered
     */
	protected EList<TupleLiteralPart<Classifier, Property>> part;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TupleLiteralExpImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return UMLPackage.Literals.TUPLE_LITERAL_EXP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<TupleLiteralPart<Classifier, Property>> getPart() {
        if (part == null) {
            part = new EObjectContainmentEList<TupleLiteralPart<Classifier, Property>>(TupleLiteralPart.class, this, UMLPackage.TUPLE_LITERAL_EXP__PART);
        }
        return part;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UMLPackage.TUPLE_LITERAL_EXP__PART:
                return ((InternalEList<?>)getPart()).basicRemove(otherEnd, msgs);
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
            case UMLPackage.TUPLE_LITERAL_EXP__PART:
                return getPart();
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
            case UMLPackage.TUPLE_LITERAL_EXP__PART:
                getPart().clear();
                getPart().addAll((Collection<? extends TupleLiteralPart<Classifier, Property>>)newValue);
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
            case UMLPackage.TUPLE_LITERAL_EXP__PART:
                getPart().clear();
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
            case UMLPackage.TUPLE_LITERAL_EXP__PART:
                return part != null && !part.isEmpty();
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
        if (baseClass == org.eclipse.ocl.expressions.TupleLiteralExp.class) {
            switch (derivedFeatureID) {
                case UMLPackage.TUPLE_LITERAL_EXP__PART: return ExpressionsPackage.TUPLE_LITERAL_EXP__PART;
                default: return -1;
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
        if (baseClass == org.eclipse.ocl.expressions.TupleLiteralExp.class) {
            switch (baseFeatureID) {
                case ExpressionsPackage.TUPLE_LITERAL_EXP__PART: return UMLPackage.TUPLE_LITERAL_EXP__PART;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
    public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		return v.visitTupleLiteralExp(this);
	}

} //TupleLiteralExpImpl
