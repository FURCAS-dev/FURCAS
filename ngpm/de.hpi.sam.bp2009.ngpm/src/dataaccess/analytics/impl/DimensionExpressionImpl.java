/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.analytics.impl;

import data.classes.Parameter;

import dataaccess.analytics.AnalyticsPackage;
import dataaccess.analytics.DimensionExpression;

import dataaccess.expressions.Expression;

import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.impl.ExpressionImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dimension Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.analytics.impl.DimensionExpressionImpl#getCellSet <em>Cell Set</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.DimensionExpressionImpl#getDimensionParameter <em>Dimension Parameter</em>}</li>
 *   <li>{@link dataaccess.analytics.impl.DimensionExpressionImpl#getFacts <em>Facts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DimensionExpressionImpl extends ExpressionImpl implements DimensionExpression {
	/**
     * The cached value of the '{@link #getCellSet() <em>Cell Set</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCellSet()
     * @generated
     * @ordered
     */
	protected Expression cellSet;

	/**
     * The cached value of the '{@link #getDimensionParameter() <em>Dimension Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDimensionParameter()
     * @generated
     * @ordered
     */
	protected Parameter dimensionParameter;

	/**
     * The cached value of the '{@link #getFacts() <em>Facts</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFacts()
     * @generated
     * @ordered
     */
	protected Expression facts;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DimensionExpressionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AnalyticsPackage.Literals.DIMENSION_EXPRESSION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getCellSet() {
        if (cellSet != null && cellSet.eIsProxy()) {
            InternalEObject oldCellSet = (InternalEObject)cellSet;
            cellSet = (Expression)eResolveProxy(oldCellSet);
            if (cellSet != oldCellSet) {
                InternalEObject newCellSet = (InternalEObject)cellSet;
                NotificationChain msgs =  oldCellSet.eInverseRemove(this, ExpressionsPackage.EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION, Expression.class, null);
                if (newCellSet.eInternalContainer() == null) {
                    msgs =  newCellSet.eInverseAdd(this, ExpressionsPackage.EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnalyticsPackage.DIMENSION_EXPRESSION__CELL_SET, oldCellSet, cellSet));
            }
        }
        return cellSet;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetCellSet() {
        return cellSet;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCellSet(Expression newCellSet, NotificationChain msgs) {
        Expression oldCellSet = cellSet;
        cellSet = newCellSet;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_EXPRESSION__CELL_SET, oldCellSet, newCellSet);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCellSet(Expression newCellSet) {
        if (newCellSet != cellSet) {
            NotificationChain msgs = null;
            if (cellSet != null)
                msgs = ((InternalEObject)cellSet).eInverseRemove(this, ExpressionsPackage.EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION, Expression.class, msgs);
            if (newCellSet != null)
                msgs = ((InternalEObject)newCellSet).eInverseAdd(this, ExpressionsPackage.EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION, Expression.class, msgs);
            msgs = basicSetCellSet(newCellSet, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_EXPRESSION__CELL_SET, newCellSet, newCellSet));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Parameter getDimensionParameter() {
        if (dimensionParameter != null && dimensionParameter.eIsProxy()) {
            InternalEObject oldDimensionParameter = (InternalEObject)dimensionParameter;
            dimensionParameter = (Parameter)eResolveProxy(oldDimensionParameter);
            if (dimensionParameter != oldDimensionParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnalyticsPackage.DIMENSION_EXPRESSION__DIMENSION_PARAMETER, oldDimensionParameter, dimensionParameter));
            }
        }
        return dimensionParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Parameter basicGetDimensionParameter() {
        return dimensionParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDimensionParameter(Parameter newDimensionParameter) {
        Parameter oldDimensionParameter = dimensionParameter;
        dimensionParameter = newDimensionParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_EXPRESSION__DIMENSION_PARAMETER, oldDimensionParameter, dimensionParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getFacts() {
        if (facts != null && facts.eIsProxy()) {
            InternalEObject oldFacts = (InternalEObject)facts;
            facts = (Expression)eResolveProxy(oldFacts);
            if (facts != oldFacts) {
                InternalEObject newFacts = (InternalEObject)facts;
                NotificationChain msgs =  oldFacts.eInverseRemove(this, ExpressionsPackage.EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION, Expression.class, null);
                if (newFacts.eInternalContainer() == null) {
                    msgs =  newFacts.eInverseAdd(this, ExpressionsPackage.EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnalyticsPackage.DIMENSION_EXPRESSION__FACTS, oldFacts, facts));
            }
        }
        return facts;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetFacts() {
        return facts;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetFacts(Expression newFacts, NotificationChain msgs) {
        Expression oldFacts = facts;
        facts = newFacts;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_EXPRESSION__FACTS, oldFacts, newFacts);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFacts(Expression newFacts) {
        if (newFacts != facts) {
            NotificationChain msgs = null;
            if (facts != null)
                msgs = ((InternalEObject)facts).eInverseRemove(this, ExpressionsPackage.EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION, Expression.class, msgs);
            if (newFacts != null)
                msgs = ((InternalEObject)newFacts).eInverseAdd(this, ExpressionsPackage.EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION, Expression.class, msgs);
            msgs = basicSetFacts(newFacts, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AnalyticsPackage.DIMENSION_EXPRESSION__FACTS, newFacts, newFacts));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case AnalyticsPackage.DIMENSION_EXPRESSION__CELL_SET:
                if (cellSet != null)
                    msgs = ((InternalEObject)cellSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.DIMENSION_EXPRESSION__CELL_SET, null, msgs);
                return basicSetCellSet((Expression)otherEnd, msgs);
            case AnalyticsPackage.DIMENSION_EXPRESSION__FACTS:
                if (facts != null)
                    msgs = ((InternalEObject)facts).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyticsPackage.DIMENSION_EXPRESSION__FACTS, null, msgs);
                return basicSetFacts((Expression)otherEnd, msgs);
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
            case AnalyticsPackage.DIMENSION_EXPRESSION__CELL_SET:
                return basicSetCellSet(null, msgs);
            case AnalyticsPackage.DIMENSION_EXPRESSION__FACTS:
                return basicSetFacts(null, msgs);
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
            case AnalyticsPackage.DIMENSION_EXPRESSION__CELL_SET:
                if (resolve) return getCellSet();
                return basicGetCellSet();
            case AnalyticsPackage.DIMENSION_EXPRESSION__DIMENSION_PARAMETER:
                if (resolve) return getDimensionParameter();
                return basicGetDimensionParameter();
            case AnalyticsPackage.DIMENSION_EXPRESSION__FACTS:
                if (resolve) return getFacts();
                return basicGetFacts();
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
            case AnalyticsPackage.DIMENSION_EXPRESSION__CELL_SET:
                setCellSet((Expression)newValue);
                return;
            case AnalyticsPackage.DIMENSION_EXPRESSION__DIMENSION_PARAMETER:
                setDimensionParameter((Parameter)newValue);
                return;
            case AnalyticsPackage.DIMENSION_EXPRESSION__FACTS:
                setFacts((Expression)newValue);
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
            case AnalyticsPackage.DIMENSION_EXPRESSION__CELL_SET:
                setCellSet((Expression)null);
                return;
            case AnalyticsPackage.DIMENSION_EXPRESSION__DIMENSION_PARAMETER:
                setDimensionParameter((Parameter)null);
                return;
            case AnalyticsPackage.DIMENSION_EXPRESSION__FACTS:
                setFacts((Expression)null);
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
            case AnalyticsPackage.DIMENSION_EXPRESSION__CELL_SET:
                return cellSet != null;
            case AnalyticsPackage.DIMENSION_EXPRESSION__DIMENSION_PARAMETER:
                return dimensionParameter != null;
            case AnalyticsPackage.DIMENSION_EXPRESSION__FACTS:
                return facts != null;
        }
        return super.eIsSet(featureID);
    }

} //DimensionExpressionImpl
