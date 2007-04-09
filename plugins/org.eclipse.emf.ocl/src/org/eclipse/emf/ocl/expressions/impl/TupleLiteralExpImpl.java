/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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
 * $Id: TupleLiteralExpImpl.java,v 1.3 2007/04/09 17:35:25 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralPart;
import org.eclipse.emf.ocl.expressions.Visitor;
/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.TupleLiteralExpImpl#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TupleLiteralExpImpl extends LiteralExpImpl implements TupleLiteralExp {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
     * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPart()
     * @generated
     * @ordered
     */
	protected EList part;

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
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.TUPLE_LITERAL_EXP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getPart() {
        if (part == null) {
            part = new EObjectContainmentEList(TupleLiteralPart.class, this, ExpressionsPackage.TUPLE_LITERAL_EXP__PART);
        }
        return part;
    }

			public Object accept(Visitor v) {
		return v.visitTupleLiteralExp(this);
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.TUPLE_LITERAL_EXP__PART:
                return ((InternalEList)getPart()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExpressionsPackage.TUPLE_LITERAL_EXP__PART:
                return getPart();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExpressionsPackage.TUPLE_LITERAL_EXP__PART:
                getPart().clear();
                getPart().addAll((Collection)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eUnset(int featureID) {
        switch (featureID) {
            case ExpressionsPackage.TUPLE_LITERAL_EXP__PART:
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
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ExpressionsPackage.TUPLE_LITERAL_EXP__PART:
                return part != null && !part.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //TupleLiteralExpImpl
