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
 * $Id: CSTNodeImpl.java,v 1.1 2007/10/11 23:05:01 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.CSTNodeImpl#getStartOffset <em>Start Offset</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.CSTNodeImpl#getEndOffset <em>End Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CSTNodeImpl extends EObjectImpl implements CSTNode {
	/**
     * The default value of the '{@link #getStartOffset() <em>Start Offset</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartOffset()
     * @generated
     * @ordered
     */
	protected static final int START_OFFSET_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getStartOffset() <em>Start Offset</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartOffset()
     * @generated
     * @ordered
     */
	protected int startOffset = START_OFFSET_EDEFAULT;

	/**
     * The default value of the '{@link #getEndOffset() <em>End Offset</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEndOffset()
     * @generated
     * @ordered
     */
	protected static final int END_OFFSET_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getEndOffset() <em>End Offset</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEndOffset()
     * @generated
     * @ordered
     */
	protected int endOffset = END_OFFSET_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CSTNodeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.CST_NODE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getStartOffset() {
        return startOffset;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setStartOffset(int newStartOffset) {
        int oldStartOffset = startOffset;
        startOffset = newStartOffset;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CST_NODE__START_OFFSET, oldStartOffset, startOffset));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getEndOffset() {
        return endOffset;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEndOffset(int newEndOffset) {
        int oldEndOffset = endOffset;
        endOffset = newEndOffset;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CST_NODE__END_OFFSET, oldEndOffset, endOffset));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.CST_NODE__START_OFFSET:
                return new Integer(getStartOffset());
            case CSTPackage.CST_NODE__END_OFFSET:
                return new Integer(getEndOffset());
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
            case CSTPackage.CST_NODE__START_OFFSET:
                setStartOffset(((Integer)newValue).intValue());
                return;
            case CSTPackage.CST_NODE__END_OFFSET:
                setEndOffset(((Integer)newValue).intValue());
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
            case CSTPackage.CST_NODE__START_OFFSET:
                setStartOffset(START_OFFSET_EDEFAULT);
                return;
            case CSTPackage.CST_NODE__END_OFFSET:
                setEndOffset(END_OFFSET_EDEFAULT);
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
            case CSTPackage.CST_NODE__START_OFFSET:
                return startOffset != START_OFFSET_EDEFAULT;
            case CSTPackage.CST_NODE__END_OFFSET:
                return endOffset != END_OFFSET_EDEFAULT;
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
        result.append(" (startOffset: "); //$NON-NLS-1$
        result.append(startOffset);
        result.append(", endOffset: "); //$NON-NLS-1$
        result.append(endOffset);
        result.append(')');
        return result.toString();
    }

} //CSTNodeImpl
