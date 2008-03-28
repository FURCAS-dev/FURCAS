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
 * $Id: LoopExpImpl.java,v 1.7 2008/03/28 20:33:33 cdamus Exp $
 */
package org.eclipse.ocl.expressions.impl;

import java.util.Collection;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.operations.LoopExpOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.impl.LoopExpImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.impl.LoopExpImpl#getIterator <em>Iterator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LoopExpImpl<C, PM> extends CallExpImpl<C> implements LoopExp<C, PM> {
	/**
     * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBody()
     * @generated
     * @ordered
     */
	protected OCLExpression<C> body;

	/**
     * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIterator()
     * @generated
     * @ordered
     */
	protected EList<Variable<C, PM>> iterator;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected LoopExpImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.LOOP_EXP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpression<C> getBody() {
        return body;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetBody(OCLExpression<C> newBody, NotificationChain msgs) {
        OCLExpression<C> oldBody = body;
        body = newBody;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.LOOP_EXP__BODY, oldBody, newBody);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBody(OCLExpression<C> newBody) {
        if (newBody != body) {
            NotificationChain msgs = null;
            if (body != null)
                msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.LOOP_EXP__BODY, null, msgs);
            if (newBody != null)
                msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.LOOP_EXP__BODY, null, msgs);
            msgs = basicSetBody(newBody, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.LOOP_EXP__BODY, newBody, newBody));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Variable<C, PM>> getIterator() {
        if (iterator == null) {
            iterator = new EObjectContainmentEList<Variable<C, PM>>(Variable.class, this, ExpressionsPackage.LOOP_EXP__ITERATOR);
        }
        return iterator;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkSourceCollection(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return LoopExpOperations.checkSourceCollection(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkLoopVariableInit(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return LoopExpOperations.checkLoopVariableInit(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkLoopVariableType(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return LoopExpOperations.checkLoopVariableType(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.LOOP_EXP__BODY:
                return basicSetBody(null, msgs);
            case ExpressionsPackage.LOOP_EXP__ITERATOR:
                return ((InternalEList<?>)getIterator()).basicRemove(otherEnd, msgs);
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
            case ExpressionsPackage.LOOP_EXP__BODY:
                return getBody();
            case ExpressionsPackage.LOOP_EXP__ITERATOR:
                return getIterator();
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
            case ExpressionsPackage.LOOP_EXP__BODY:
                setBody((OCLExpression<C>)newValue);
                return;
            case ExpressionsPackage.LOOP_EXP__ITERATOR:
                getIterator().clear();
                getIterator().addAll((Collection<? extends Variable<C, PM>>)newValue);
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
            case ExpressionsPackage.LOOP_EXP__BODY:
                setBody((OCLExpression<C>)null);
                return;
            case ExpressionsPackage.LOOP_EXP__ITERATOR:
                getIterator().clear();
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
            case ExpressionsPackage.LOOP_EXP__BODY:
                return body != null;
            case ExpressionsPackage.LOOP_EXP__ITERATOR:
                return iterator != null && !iterator.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //LoopExpImpl
