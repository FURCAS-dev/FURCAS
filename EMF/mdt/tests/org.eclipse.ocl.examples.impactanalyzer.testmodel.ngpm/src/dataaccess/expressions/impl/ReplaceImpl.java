/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReplaceImpl.java,v 1.1 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.expressions.impl;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.NavigationStep;
import dataaccess.expressions.Replace;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.ReplaceImpl#getSteps <em>Steps</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.ReplaceImpl#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReplaceImpl extends ObjectBasedExpressionImpl implements Replace {
	/**
     * The cached value of the '{@link #getSteps() <em>Steps</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSteps()
     * @generated
     * @ordered
     */
	protected EList<NavigationStep> steps;

	/**
     * The cached value of the '{@link #getWith() <em>With</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getWith()
     * @generated
     * @ordered
     */
	protected Expression with;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ReplaceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.REPLACE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<NavigationStep> getSteps() {
        if (steps == null) {
            steps = new EObjectContainmentWithInverseEList.Resolving<NavigationStep>(NavigationStep.class, this, ExpressionsPackage.REPLACE__STEPS, ExpressionsPackage.NAVIGATION_STEP__REPLACE);
        }
        return steps;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getWith() {
        if (with != null && with.eIsProxy()) {
            InternalEObject oldWith = (InternalEObject)with;
            with = (Expression)eResolveProxy(oldWith);
            if (with != oldWith) {
                InternalEObject newWith = (InternalEObject)with;
                NotificationChain msgs = oldWith.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.REPLACE__WITH, null, null);
                if (newWith.eInternalContainer() == null) {
                    msgs = newWith.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.REPLACE__WITH, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.REPLACE__WITH, oldWith, with));
            }
        }
        return with;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetWith() {
        return with;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetWith(Expression newWith, NotificationChain msgs) {
        Expression oldWith = with;
        with = newWith;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.REPLACE__WITH, oldWith, newWith);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setWith(Expression newWith) {
        if (newWith != with) {
            NotificationChain msgs = null;
            if (with != null)
                msgs = ((InternalEObject)with).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.REPLACE__WITH, null, msgs);
            if (newWith != null)
                msgs = ((InternalEObject)newWith).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.REPLACE__WITH, null, msgs);
            msgs = basicSetWith(newWith, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.REPLACE__WITH, newWith, newWith));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.REPLACE__STEPS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSteps()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.REPLACE__STEPS:
                return ((InternalEList<?>)getSteps()).basicRemove(otherEnd, msgs);
            case ExpressionsPackage.REPLACE__WITH:
                return basicSetWith(null, msgs);
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
            case ExpressionsPackage.REPLACE__STEPS:
                return getSteps();
            case ExpressionsPackage.REPLACE__WITH:
                if (resolve) return getWith();
                return basicGetWith();
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
            case ExpressionsPackage.REPLACE__STEPS:
                getSteps().clear();
                getSteps().addAll((Collection<? extends NavigationStep>)newValue);
                return;
            case ExpressionsPackage.REPLACE__WITH:
                setWith((Expression)newValue);
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
            case ExpressionsPackage.REPLACE__STEPS:
                getSteps().clear();
                return;
            case ExpressionsPackage.REPLACE__WITH:
                setWith((Expression)null);
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
            case ExpressionsPackage.REPLACE__STEPS:
                return steps != null && !steps.isEmpty();
            case ExpressionsPackage.REPLACE__WITH:
                return with != null;
        }
        return super.eIsSet(featureID);
    }

} //ReplaceImpl
