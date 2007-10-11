/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: StateExpCSImpl.java,v 1.1 2007/10/11 23:05:01 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.StateExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.StateExpCSImpl#getSequenceOfNames <em>Sequence Of Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateExpCSImpl extends TypeCSImpl implements StateExpCS {
	/**
     * The cached value of the '{@link #getSequenceOfNames() <em>Sequence Of Names</em>}' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSequenceOfNames()
     * @generated
     * @ordered
     */
	protected EList<String> sequenceOfNames;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected StateExpCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.STATE_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<String> getSequenceOfNames() {
        if (sequenceOfNames == null) {
            sequenceOfNames = new EDataTypeUniqueEList<String>(String.class, this, CSTPackage.STATE_EXP_CS__SEQUENCE_OF_NAMES);
        }
        return sequenceOfNames;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.STATE_EXP_CS__SEQUENCE_OF_NAMES:
                return getSequenceOfNames();
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
            case CSTPackage.STATE_EXP_CS__SEQUENCE_OF_NAMES:
                getSequenceOfNames().clear();
                getSequenceOfNames().addAll((Collection<? extends String>)newValue);
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
            case CSTPackage.STATE_EXP_CS__SEQUENCE_OF_NAMES:
                getSequenceOfNames().clear();
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
            case CSTPackage.STATE_EXP_CS__SEQUENCE_OF_NAMES:
                return sequenceOfNames != null && !sequenceOfNames.isEmpty();
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
        result.append(" (sequenceOfNames: "); //$NON-NLS-1$
        result.append(sequenceOfNames);
        result.append(')');
        return result.toString();
    }

} //StateExpCSImpl
