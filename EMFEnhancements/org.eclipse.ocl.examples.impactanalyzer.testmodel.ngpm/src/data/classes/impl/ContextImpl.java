/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.Context;
import data.classes.SapClass;

import data.constraints.Constraint;
import data.constraints.ConstraintsPackage;

import dataaccess.expressions.Expression;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

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
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.ContextImpl#getFor_ <em>For </em>}</li>
 *   <li>{@link data.classes.impl.ContextImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link data.classes.impl.ContextImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextImpl extends NamedElementImpl implements Context {
	/**
     * The cached value of the '{@link #getFor_() <em>For </em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFor_()
     * @generated
     * @ordered
     */
	protected SapClass for_;

	/**
     * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConstraints()
     * @generated
     * @ordered
     */
	protected EList<Constraint> constraints;

	/**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
	protected Expression condition;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ContextImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.CONTEXT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getFor_() {
        if (for_ != null && for_.eIsProxy()) {
            InternalEObject oldFor_ = (InternalEObject)for_;
            for_ = (SapClass)eResolveProxy(oldFor_);
            if (for_ != oldFor_) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.CONTEXT__FOR_, oldFor_, for_));
            }
        }
        return for_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetFor_() {
        return for_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFor_(SapClass newFor_) {
        SapClass oldFor_ = for_;
        for_ = newFor_;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.CONTEXT__FOR_, oldFor_, for_));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Constraint> getConstraints() {
        if (constraints == null) {
            constraints = new EObjectContainmentWithInverseEList.Resolving<Constraint>(Constraint.class, this, ClassesPackage.CONTEXT__CONSTRAINTS, ConstraintsPackage.CONSTRAINT__THE_CONTEXT);
        }
        return constraints;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getCondition() {
        if (condition != null && condition.eIsProxy()) {
            InternalEObject oldCondition = (InternalEObject)condition;
            condition = (Expression)eResolveProxy(oldCondition);
            if (condition != oldCondition) {
                InternalEObject newCondition = (InternalEObject)condition;
                NotificationChain msgs = oldCondition.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.CONTEXT__CONDITION, null, null);
                if (newCondition.eInternalContainer() == null) {
                    msgs = newCondition.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.CONTEXT__CONDITION, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.CONTEXT__CONDITION, oldCondition, condition));
            }
        }
        return condition;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetCondition() {
        return condition;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
        Expression oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.CONTEXT__CONDITION, oldCondition, newCondition);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCondition(Expression newCondition) {
        if (newCondition != condition) {
            NotificationChain msgs = null;
            if (condition != null)
                msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.CONTEXT__CONDITION, null, msgs);
            if (newCondition != null)
                msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.CONTEXT__CONDITION, null, msgs);
            msgs = basicSetCondition(newCondition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.CONTEXT__CONDITION, newCondition, newCondition));
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
            case ClassesPackage.CONTEXT__CONSTRAINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
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
            case ClassesPackage.CONTEXT__CONSTRAINTS:
                return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
            case ClassesPackage.CONTEXT__CONDITION:
                return basicSetCondition(null, msgs);
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
            case ClassesPackage.CONTEXT__FOR_:
                if (resolve) return getFor_();
                return basicGetFor_();
            case ClassesPackage.CONTEXT__CONSTRAINTS:
                return getConstraints();
            case ClassesPackage.CONTEXT__CONDITION:
                if (resolve) return getCondition();
                return basicGetCondition();
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
            case ClassesPackage.CONTEXT__FOR_:
                setFor_((SapClass)newValue);
                return;
            case ClassesPackage.CONTEXT__CONSTRAINTS:
                getConstraints().clear();
                getConstraints().addAll((Collection<? extends Constraint>)newValue);
                return;
            case ClassesPackage.CONTEXT__CONDITION:
                setCondition((Expression)newValue);
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
            case ClassesPackage.CONTEXT__FOR_:
                setFor_((SapClass)null);
                return;
            case ClassesPackage.CONTEXT__CONSTRAINTS:
                getConstraints().clear();
                return;
            case ClassesPackage.CONTEXT__CONDITION:
                setCondition((Expression)null);
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
            case ClassesPackage.CONTEXT__FOR_:
                return for_ != null;
            case ClassesPackage.CONTEXT__CONSTRAINTS:
                return constraints != null && !constraints.isEmpty();
            case ClassesPackage.CONTEXT__CONDITION:
                return condition != null;
        }
        return super.eIsSet(featureID);
    }

} //ContextImpl
