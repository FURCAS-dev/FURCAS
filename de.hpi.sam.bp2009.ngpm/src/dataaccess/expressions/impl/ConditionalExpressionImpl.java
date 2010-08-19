/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.impl;

import dataaccess.expressions.Conditional;
import dataaccess.expressions.ConditionalExpression;
import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.ConditionalExpressionImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConditionalExpressionImpl extends ExpressionImpl implements ConditionalExpression {
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
	protected ConditionalExpressionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.CONDITIONAL_EXPRESSION;
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
                NotificationChain msgs =  oldCondition.eInverseRemove(this, ExpressionsPackage.EXPRESSION__CONDITIONAL, Expression.class, null);
                if (newCondition.eInternalContainer() == null) {
                    msgs =  newCondition.eInverseAdd(this, ExpressionsPackage.EXPRESSION__CONDITIONAL, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION, oldCondition, condition));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION, oldCondition, newCondition);
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
                msgs = ((InternalEObject)condition).eInverseRemove(this, ExpressionsPackage.EXPRESSION__CONDITIONAL, Expression.class, msgs);
            if (newCondition != null)
                msgs = ((InternalEObject)newCondition).eInverseAdd(this, ExpressionsPackage.EXPRESSION__CONDITIONAL, Expression.class, msgs);
            msgs = basicSetCondition(newCondition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION, newCondition, newCondition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
                if (condition != null)
                    msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION, null, msgs);
                return basicSetCondition((Expression)otherEnd, msgs);
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
            case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
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
            case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
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
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
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
            case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
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
            case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
                return condition != null;
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
        if (baseClass == Conditional.class) {
            switch (derivedFeatureID) {
                case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION: return ExpressionsPackage.CONDITIONAL__CONDITION;
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
        if (baseClass == Conditional.class) {
            switch (baseFeatureID) {
                case ExpressionsPackage.CONDITIONAL__CONDITION: return ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //ConditionalExpressionImpl
