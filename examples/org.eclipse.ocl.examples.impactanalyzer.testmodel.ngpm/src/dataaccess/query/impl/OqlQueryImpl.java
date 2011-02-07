/**
 * <copyright>
 * </copyright>
 *
 * $Id: OqlQueryImpl.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.query.impl;

import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;

import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.impl.ExpressionImpl;

import dataaccess.query.FromClause;
import dataaccess.query.OqlQuery;
import dataaccess.query.QueryPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Oql Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.query.impl.OqlQueryImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link dataaccess.query.impl.OqlQueryImpl#getFromClauses <em>From Clauses</em>}</li>
 *   <li>{@link dataaccess.query.impl.OqlQueryImpl#getSelected <em>Selected</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OqlQueryImpl extends ExpressionImpl implements OqlQuery {
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
     * The cached value of the '{@link #getFromClauses() <em>From Clauses</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFromClauses()
     * @generated
     * @ordered
     */
	protected EList<FromClause> fromClauses;

	/**
     * The cached value of the '{@link #getSelected() <em>Selected</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSelected()
     * @generated
     * @ordered
     */
	protected EList<Iterator> selected;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OqlQueryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return QueryPackage.Literals.OQL_QUERY;
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
                NotificationChain msgs =  oldCondition.eInverseRemove(this, ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY, Expression.class, null);
                if (newCondition.eInternalContainer() == null) {
                    msgs =  newCondition.eInverseAdd(this, ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.OQL_QUERY__CONDITION, oldCondition, condition));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryPackage.OQL_QUERY__CONDITION, oldCondition, newCondition);
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
                msgs = ((InternalEObject)condition).eInverseRemove(this, ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY, Expression.class, msgs);
            if (newCondition != null)
                msgs = ((InternalEObject)newCondition).eInverseAdd(this, ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY, Expression.class, msgs);
            msgs = basicSetCondition(newCondition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.OQL_QUERY__CONDITION, newCondition, newCondition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<FromClause> getFromClauses() {
        if (fromClauses == null) {
            fromClauses = new EObjectContainmentWithInverseEList.Resolving<FromClause>(FromClause.class, this, QueryPackage.OQL_QUERY__FROM_CLAUSES, QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY);
        }
        return fromClauses;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Iterator> getSelected() {
        if (selected == null) {
            selected = new EObjectResolvingEList<Iterator>(Iterator.class, this, QueryPackage.OQL_QUERY__SELECTED);
        }
        return selected;
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
            case QueryPackage.OQL_QUERY__CONDITION:
                if (condition != null)
                    msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.OQL_QUERY__CONDITION, null, msgs);
                return basicSetCondition((Expression)otherEnd, msgs);
            case QueryPackage.OQL_QUERY__FROM_CLAUSES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getFromClauses()).basicAdd(otherEnd, msgs);
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
            case QueryPackage.OQL_QUERY__CONDITION:
                return basicSetCondition(null, msgs);
            case QueryPackage.OQL_QUERY__FROM_CLAUSES:
                return ((InternalEList<?>)getFromClauses()).basicRemove(otherEnd, msgs);
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
            case QueryPackage.OQL_QUERY__CONDITION:
                if (resolve) return getCondition();
                return basicGetCondition();
            case QueryPackage.OQL_QUERY__FROM_CLAUSES:
                return getFromClauses();
            case QueryPackage.OQL_QUERY__SELECTED:
                return getSelected();
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
            case QueryPackage.OQL_QUERY__CONDITION:
                setCondition((Expression)newValue);
                return;
            case QueryPackage.OQL_QUERY__FROM_CLAUSES:
                getFromClauses().clear();
                getFromClauses().addAll((Collection<? extends FromClause>)newValue);
                return;
            case QueryPackage.OQL_QUERY__SELECTED:
                getSelected().clear();
                getSelected().addAll((Collection<? extends Iterator>)newValue);
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
            case QueryPackage.OQL_QUERY__CONDITION:
                setCondition((Expression)null);
                return;
            case QueryPackage.OQL_QUERY__FROM_CLAUSES:
                getFromClauses().clear();
                return;
            case QueryPackage.OQL_QUERY__SELECTED:
                getSelected().clear();
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
            case QueryPackage.OQL_QUERY__CONDITION:
                return condition != null;
            case QueryPackage.OQL_QUERY__FROM_CLAUSES:
                return fromClauses != null && !fromClauses.isEmpty();
            case QueryPackage.OQL_QUERY__SELECTED:
                return selected != null && !selected.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //OqlQueryImpl
