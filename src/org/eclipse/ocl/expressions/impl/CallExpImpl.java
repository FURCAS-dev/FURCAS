/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CallExpImpl.java,v 1.4 2007/10/11 23:04:56 cdamus Exp $
 */
package org.eclipse.ocl.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.impl.CallExpImpl#getPropertyStartPosition <em>Property Start Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.impl.CallExpImpl#getPropertyEndPosition <em>Property End Position</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.impl.CallExpImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CallExpImpl<C> extends OCLExpressionImpl<C> implements CallExp<C> {
	/**
     * The default value of the '{@link #getPropertyStartPosition() <em>Property Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPropertyStartPosition()
     * @generated
     * @ordered
     */
	protected static final int PROPERTY_START_POSITION_EDEFAULT = -1;

	/**
     * The cached value of the '{@link #getPropertyStartPosition() <em>Property Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPropertyStartPosition()
     * @generated
     * @ordered
     */
	protected int propertyStartPosition = PROPERTY_START_POSITION_EDEFAULT;

	/**
     * The default value of the '{@link #getPropertyEndPosition() <em>Property End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPropertyEndPosition()
     * @generated
     * @ordered
     */
	protected static final int PROPERTY_END_POSITION_EDEFAULT = -1;

	/**
     * The cached value of the '{@link #getPropertyEndPosition() <em>Property End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPropertyEndPosition()
     * @generated
     * @ordered
     */
	protected int propertyEndPosition = PROPERTY_END_POSITION_EDEFAULT;

	/**
     * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
	protected OCLExpression<C> source;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CallExpImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.CALL_EXP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getPropertyStartPosition() {
        return propertyStartPosition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPropertyStartPosition(int newPropertyStartPosition) {
        int oldPropertyStartPosition = propertyStartPosition;
        propertyStartPosition = newPropertyStartPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CALL_EXP__PROPERTY_START_POSITION, oldPropertyStartPosition, propertyStartPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getPropertyEndPosition() {
        return propertyEndPosition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPropertyEndPosition(int newPropertyEndPosition) {
        int oldPropertyEndPosition = propertyEndPosition;
        propertyEndPosition = newPropertyEndPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CALL_EXP__PROPERTY_END_POSITION, oldPropertyEndPosition, propertyEndPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpression<C> getSource() {
        return source;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSource(OCLExpression<C> newSource, NotificationChain msgs) {
        OCLExpression<C> oldSource = source;
        source = newSource;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CALL_EXP__SOURCE, oldSource, newSource);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSource(OCLExpression<C> newSource) {
        if (newSource != source) {
            NotificationChain msgs = null;
            if (source != null)
                msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CALL_EXP__SOURCE, null, msgs);
            if (newSource != null)
                msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CALL_EXP__SOURCE, null, msgs);
            msgs = basicSetSource(newSource, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CALL_EXP__SOURCE, newSource, newSource));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.CALL_EXP__SOURCE:
                return basicSetSource(null, msgs);
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
            case ExpressionsPackage.CALL_EXP__PROPERTY_START_POSITION:
                return new Integer(getPropertyStartPosition());
            case ExpressionsPackage.CALL_EXP__PROPERTY_END_POSITION:
                return new Integer(getPropertyEndPosition());
            case ExpressionsPackage.CALL_EXP__SOURCE:
                return getSource();
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
            case ExpressionsPackage.CALL_EXP__PROPERTY_START_POSITION:
                setPropertyStartPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.CALL_EXP__PROPERTY_END_POSITION:
                setPropertyEndPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.CALL_EXP__SOURCE:
                setSource((OCLExpression<C>)newValue);
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
            case ExpressionsPackage.CALL_EXP__PROPERTY_START_POSITION:
                setPropertyStartPosition(PROPERTY_START_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.CALL_EXP__PROPERTY_END_POSITION:
                setPropertyEndPosition(PROPERTY_END_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.CALL_EXP__SOURCE:
                setSource((OCLExpression<C>)null);
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
            case ExpressionsPackage.CALL_EXP__PROPERTY_START_POSITION:
                return propertyStartPosition != PROPERTY_START_POSITION_EDEFAULT;
            case ExpressionsPackage.CALL_EXP__PROPERTY_END_POSITION:
                return propertyEndPosition != PROPERTY_END_POSITION_EDEFAULT;
            case ExpressionsPackage.CALL_EXP__SOURCE:
                return source != null;
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
        if (baseClass == CallingASTNode.class) {
            switch (derivedFeatureID) {
                case ExpressionsPackage.CALL_EXP__PROPERTY_START_POSITION: return UtilitiesPackage.CALLING_AST_NODE__PROPERTY_START_POSITION;
                case ExpressionsPackage.CALL_EXP__PROPERTY_END_POSITION: return UtilitiesPackage.CALLING_AST_NODE__PROPERTY_END_POSITION;
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
        if (baseClass == CallingASTNode.class) {
            switch (baseFeatureID) {
                case UtilitiesPackage.CALLING_AST_NODE__PROPERTY_START_POSITION: return ExpressionsPackage.CALL_EXP__PROPERTY_START_POSITION;
                case UtilitiesPackage.CALLING_AST_NODE__PROPERTY_END_POSITION: return ExpressionsPackage.CALL_EXP__PROPERTY_END_POSITION;
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
	public String toString() {
		return super.toString();
	}

} //CallExpImpl
