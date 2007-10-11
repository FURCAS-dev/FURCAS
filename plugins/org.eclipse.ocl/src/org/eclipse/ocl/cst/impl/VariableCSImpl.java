/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: VariableCSImpl.java,v 1.1 2007/10/11 23:05:02 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.VariableCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.VariableCSImpl#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.VariableCSImpl#getInitExpression <em>Init Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableCSImpl extends CSTNodeImpl implements VariableCS {
	/**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected static final String NAME_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected String name = NAME_EDEFAULT;

	/**
     * The cached value of the '{@link #getTypeCS() <em>Type CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeCS()
     * @generated
     * @ordered
     */
	protected TypeCS typeCS;

	/**
     * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInitExpression()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS initExpression;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected VariableCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.VARIABLE_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.VARIABLE_CS__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeCS getTypeCS() {
        return typeCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTypeCS(TypeCS newTypeCS, NotificationChain msgs) {
        TypeCS oldTypeCS = typeCS;
        typeCS = newTypeCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.VARIABLE_CS__TYPE_CS, oldTypeCS, newTypeCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeCS(TypeCS newTypeCS) {
        if (newTypeCS != typeCS) {
            NotificationChain msgs = null;
            if (typeCS != null)
                msgs = ((InternalEObject)typeCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.VARIABLE_CS__TYPE_CS, null, msgs);
            if (newTypeCS != null)
                msgs = ((InternalEObject)newTypeCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.VARIABLE_CS__TYPE_CS, null, msgs);
            msgs = basicSetTypeCS(newTypeCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.VARIABLE_CS__TYPE_CS, newTypeCS, newTypeCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getInitExpression() {
        return initExpression;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInitExpression(OCLExpressionCS newInitExpression, NotificationChain msgs) {
        OCLExpressionCS oldInitExpression = initExpression;
        initExpression = newInitExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.VARIABLE_CS__INIT_EXPRESSION, oldInitExpression, newInitExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInitExpression(OCLExpressionCS newInitExpression) {
        if (newInitExpression != initExpression) {
            NotificationChain msgs = null;
            if (initExpression != null)
                msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.VARIABLE_CS__INIT_EXPRESSION, null, msgs);
            if (newInitExpression != null)
                msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.VARIABLE_CS__INIT_EXPRESSION, null, msgs);
            msgs = basicSetInitExpression(newInitExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.VARIABLE_CS__INIT_EXPRESSION, newInitExpression, newInitExpression));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.VARIABLE_CS__TYPE_CS:
                return basicSetTypeCS(null, msgs);
            case CSTPackage.VARIABLE_CS__INIT_EXPRESSION:
                return basicSetInitExpression(null, msgs);
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
            case CSTPackage.VARIABLE_CS__NAME:
                return getName();
            case CSTPackage.VARIABLE_CS__TYPE_CS:
                return getTypeCS();
            case CSTPackage.VARIABLE_CS__INIT_EXPRESSION:
                return getInitExpression();
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
            case CSTPackage.VARIABLE_CS__NAME:
                setName((String)newValue);
                return;
            case CSTPackage.VARIABLE_CS__TYPE_CS:
                setTypeCS((TypeCS)newValue);
                return;
            case CSTPackage.VARIABLE_CS__INIT_EXPRESSION:
                setInitExpression((OCLExpressionCS)newValue);
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
            case CSTPackage.VARIABLE_CS__NAME:
                setName(NAME_EDEFAULT);
                return;
            case CSTPackage.VARIABLE_CS__TYPE_CS:
                setTypeCS((TypeCS)null);
                return;
            case CSTPackage.VARIABLE_CS__INIT_EXPRESSION:
                setInitExpression((OCLExpressionCS)null);
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
            case CSTPackage.VARIABLE_CS__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case CSTPackage.VARIABLE_CS__TYPE_CS:
                return typeCS != null;
            case CSTPackage.VARIABLE_CS__INIT_EXPRESSION:
                return initExpression != null;
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
        result.append(" (name: "); //$NON-NLS-1$
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //VariableDeclarationCSImpl
