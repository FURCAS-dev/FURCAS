/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.impl;

import data.classes.AssociationEnd;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.NavigationStep;
import dataaccess.expressions.Replace;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.NavigationStepImpl#getReplace <em>Replace</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.NavigationStepImpl#getTo <em>To</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.NavigationStepImpl#getFilterFunction <em>Filter Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NavigationStepImpl extends EObjectImpl implements NavigationStep {
	/**
     * The cached value of the '{@link #getTo() <em>To</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTo()
     * @generated
     * @ordered
     */
	protected AssociationEnd to;

	/**
     * The cached value of the '{@link #getFilterFunction() <em>Filter Function</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFilterFunction()
     * @generated
     * @ordered
     */
	protected Expression filterFunction;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NavigationStepImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.NAVIGATION_STEP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Replace getReplace() {
        if (eContainerFeatureID() != ExpressionsPackage.NAVIGATION_STEP__REPLACE) return null;
        return (Replace)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Replace basicGetReplace() {
        if (eContainerFeatureID() != ExpressionsPackage.NAVIGATION_STEP__REPLACE) return null;
        return (Replace)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetReplace(Replace newReplace, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newReplace, ExpressionsPackage.NAVIGATION_STEP__REPLACE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setReplace(Replace newReplace) {
        if (newReplace != eInternalContainer() || (eContainerFeatureID() != ExpressionsPackage.NAVIGATION_STEP__REPLACE && newReplace != null)) {
            if (EcoreUtil.isAncestor(this, newReplace))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newReplace != null)
                msgs = ((InternalEObject)newReplace).eInverseAdd(this, ExpressionsPackage.REPLACE__STEPS, Replace.class, msgs);
            msgs = basicSetReplace(newReplace, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.NAVIGATION_STEP__REPLACE, newReplace, newReplace));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd getTo() {
        if (to != null && to.eIsProxy()) {
            InternalEObject oldTo = (InternalEObject)to;
            to = (AssociationEnd)eResolveProxy(oldTo);
            if (to != oldTo) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.NAVIGATION_STEP__TO, oldTo, to));
            }
        }
        return to;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd basicGetTo() {
        return to;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTo(AssociationEnd newTo) {
        AssociationEnd oldTo = to;
        to = newTo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.NAVIGATION_STEP__TO, oldTo, to));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getFilterFunction() {
        if (filterFunction != null && filterFunction.eIsProxy()) {
            InternalEObject oldFilterFunction = (InternalEObject)filterFunction;
            filterFunction = (Expression)eResolveProxy(oldFilterFunction);
            if (filterFunction != oldFilterFunction) {
                InternalEObject newFilterFunction = (InternalEObject)filterFunction;
                NotificationChain msgs = oldFilterFunction.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION, null, null);
                if (newFilterFunction.eInternalContainer() == null) {
                    msgs = newFilterFunction.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION, oldFilterFunction, filterFunction));
            }
        }
        return filterFunction;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetFilterFunction() {
        return filterFunction;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetFilterFunction(Expression newFilterFunction, NotificationChain msgs) {
        Expression oldFilterFunction = filterFunction;
        filterFunction = newFilterFunction;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION, oldFilterFunction, newFilterFunction);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFilterFunction(Expression newFilterFunction) {
        if (newFilterFunction != filterFunction) {
            NotificationChain msgs = null;
            if (filterFunction != null)
                msgs = ((InternalEObject)filterFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION, null, msgs);
            if (newFilterFunction != null)
                msgs = ((InternalEObject)newFilterFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION, null, msgs);
            msgs = basicSetFilterFunction(newFilterFunction, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION, newFilterFunction, newFilterFunction));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.NAVIGATION_STEP__REPLACE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetReplace((Replace)otherEnd, msgs);
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
            case ExpressionsPackage.NAVIGATION_STEP__REPLACE:
                return basicSetReplace(null, msgs);
            case ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION:
                return basicSetFilterFunction(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case ExpressionsPackage.NAVIGATION_STEP__REPLACE:
                return eInternalContainer().eInverseRemove(this, ExpressionsPackage.REPLACE__STEPS, Replace.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExpressionsPackage.NAVIGATION_STEP__REPLACE:
                if (resolve) return getReplace();
                return basicGetReplace();
            case ExpressionsPackage.NAVIGATION_STEP__TO:
                if (resolve) return getTo();
                return basicGetTo();
            case ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION:
                if (resolve) return getFilterFunction();
                return basicGetFilterFunction();
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
            case ExpressionsPackage.NAVIGATION_STEP__REPLACE:
                setReplace((Replace)newValue);
                return;
            case ExpressionsPackage.NAVIGATION_STEP__TO:
                setTo((AssociationEnd)newValue);
                return;
            case ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION:
                setFilterFunction((Expression)newValue);
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
            case ExpressionsPackage.NAVIGATION_STEP__REPLACE:
                setReplace((Replace)null);
                return;
            case ExpressionsPackage.NAVIGATION_STEP__TO:
                setTo((AssociationEnd)null);
                return;
            case ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION:
                setFilterFunction((Expression)null);
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
            case ExpressionsPackage.NAVIGATION_STEP__REPLACE:
                return basicGetReplace() != null;
            case ExpressionsPackage.NAVIGATION_STEP__TO:
                return to != null;
            case ExpressionsPackage.NAVIGATION_STEP__FILTER_FUNCTION:
                return filterFunction != null;
        }
        return super.eIsSet(featureID);
    }

} //NavigationStepImpl
