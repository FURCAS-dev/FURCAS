/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.query.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;

import dataaccess.query.FromClause;
import dataaccess.query.OqlQuery;
import dataaccess.query.QueryPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>From Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.query.impl.FromClauseImpl#getFromClauseOfOqlQuery <em>From Clause Of Oql Query</em>}</li>
 *   <li>{@link dataaccess.query.impl.FromClauseImpl#getFromExpression <em>From Expression</em>}</li>
 *   <li>{@link dataaccess.query.impl.FromClauseImpl#getAlias <em>Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FromClauseImpl extends EObjectImpl implements FromClause {
	/**
     * The cached value of the '{@link #getFromExpression() <em>From Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFromExpression()
     * @generated
     * @ordered
     */
	protected Expression fromExpression;

	/**
     * The cached value of the '{@link #getAlias() <em>Alias</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAlias()
     * @generated
     * @ordered
     */
	protected Iterator alias;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FromClauseImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return QueryPackage.Literals.FROM_CLAUSE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OqlQuery getFromClauseOfOqlQuery() {
        if (eContainerFeatureID() != QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY) return null;
        return (OqlQuery)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OqlQuery basicGetFromClauseOfOqlQuery() {
        if (eContainerFeatureID() != QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY) return null;
        return (OqlQuery)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetFromClauseOfOqlQuery(OqlQuery newFromClauseOfOqlQuery, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newFromClauseOfOqlQuery, QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFromClauseOfOqlQuery(OqlQuery newFromClauseOfOqlQuery) {
        if (newFromClauseOfOqlQuery != eInternalContainer() || (eContainerFeatureID() != QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY && newFromClauseOfOqlQuery != null)) {
            if (EcoreUtil.isAncestor(this, newFromClauseOfOqlQuery))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newFromClauseOfOqlQuery != null)
                msgs = ((InternalEObject)newFromClauseOfOqlQuery).eInverseAdd(this, QueryPackage.OQL_QUERY__FROM_CLAUSES, OqlQuery.class, msgs);
            msgs = basicSetFromClauseOfOqlQuery(newFromClauseOfOqlQuery, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY, newFromClauseOfOqlQuery, newFromClauseOfOqlQuery));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getFromExpression() {
        if (fromExpression != null && fromExpression.eIsProxy()) {
            InternalEObject oldFromExpression = (InternalEObject)fromExpression;
            fromExpression = (Expression)eResolveProxy(oldFromExpression);
            if (fromExpression != oldFromExpression) {
                InternalEObject newFromExpression = (InternalEObject)fromExpression;
                NotificationChain msgs =  oldFromExpression.eInverseRemove(this, ExpressionsPackage.EXPRESSION__FROM_CLAUSE, Expression.class, null);
                if (newFromExpression.eInternalContainer() == null) {
                    msgs =  newFromExpression.eInverseAdd(this, ExpressionsPackage.EXPRESSION__FROM_CLAUSE, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.FROM_CLAUSE__FROM_EXPRESSION, oldFromExpression, fromExpression));
            }
        }
        return fromExpression;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetFromExpression() {
        return fromExpression;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetFromExpression(Expression newFromExpression, NotificationChain msgs) {
        Expression oldFromExpression = fromExpression;
        fromExpression = newFromExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryPackage.FROM_CLAUSE__FROM_EXPRESSION, oldFromExpression, newFromExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFromExpression(Expression newFromExpression) {
        if (newFromExpression != fromExpression) {
            NotificationChain msgs = null;
            if (fromExpression != null)
                msgs = ((InternalEObject)fromExpression).eInverseRemove(this, ExpressionsPackage.EXPRESSION__FROM_CLAUSE, Expression.class, msgs);
            if (newFromExpression != null)
                msgs = ((InternalEObject)newFromExpression).eInverseAdd(this, ExpressionsPackage.EXPRESSION__FROM_CLAUSE, Expression.class, msgs);
            msgs = basicSetFromExpression(newFromExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.FROM_CLAUSE__FROM_EXPRESSION, newFromExpression, newFromExpression));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Iterator getAlias() {
        if (alias != null && alias.eIsProxy()) {
            InternalEObject oldAlias = (InternalEObject)alias;
            alias = (Iterator)eResolveProxy(oldAlias);
            if (alias != oldAlias) {
                InternalEObject newAlias = (InternalEObject)alias;
                NotificationChain msgs =  oldAlias.eInverseRemove(this, ActionsPackage.ITERATOR__FROM_CLAUSE, Iterator.class, null);
                if (newAlias.eInternalContainer() == null) {
                    msgs =  newAlias.eInverseAdd(this, ActionsPackage.ITERATOR__FROM_CLAUSE, Iterator.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.FROM_CLAUSE__ALIAS, oldAlias, alias));
            }
        }
        return alias;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Iterator basicGetAlias() {
        return alias;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetAlias(Iterator newAlias, NotificationChain msgs) {
        Iterator oldAlias = alias;
        alias = newAlias;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryPackage.FROM_CLAUSE__ALIAS, oldAlias, newAlias);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAlias(Iterator newAlias) {
        if (newAlias != alias) {
            NotificationChain msgs = null;
            if (alias != null)
                msgs = ((InternalEObject)alias).eInverseRemove(this, ActionsPackage.ITERATOR__FROM_CLAUSE, Iterator.class, msgs);
            if (newAlias != null)
                msgs = ((InternalEObject)newAlias).eInverseAdd(this, ActionsPackage.ITERATOR__FROM_CLAUSE, Iterator.class, msgs);
            msgs = basicSetAlias(newAlias, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.FROM_CLAUSE__ALIAS, newAlias, newAlias));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetFromClauseOfOqlQuery((OqlQuery)otherEnd, msgs);
            case QueryPackage.FROM_CLAUSE__FROM_EXPRESSION:
                if (fromExpression != null)
                    msgs = ((InternalEObject)fromExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.FROM_CLAUSE__FROM_EXPRESSION, null, msgs);
                return basicSetFromExpression((Expression)otherEnd, msgs);
            case QueryPackage.FROM_CLAUSE__ALIAS:
                if (alias != null)
                    msgs = ((InternalEObject)alias).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.FROM_CLAUSE__ALIAS, null, msgs);
                return basicSetAlias((Iterator)otherEnd, msgs);
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
            case QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY:
                return basicSetFromClauseOfOqlQuery(null, msgs);
            case QueryPackage.FROM_CLAUSE__FROM_EXPRESSION:
                return basicSetFromExpression(null, msgs);
            case QueryPackage.FROM_CLAUSE__ALIAS:
                return basicSetAlias(null, msgs);
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
            case QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY:
                return eInternalContainer().eInverseRemove(this, QueryPackage.OQL_QUERY__FROM_CLAUSES, OqlQuery.class, msgs);
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
            case QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY:
                if (resolve) return getFromClauseOfOqlQuery();
                return basicGetFromClauseOfOqlQuery();
            case QueryPackage.FROM_CLAUSE__FROM_EXPRESSION:
                if (resolve) return getFromExpression();
                return basicGetFromExpression();
            case QueryPackage.FROM_CLAUSE__ALIAS:
                if (resolve) return getAlias();
                return basicGetAlias();
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
            case QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY:
                setFromClauseOfOqlQuery((OqlQuery)newValue);
                return;
            case QueryPackage.FROM_CLAUSE__FROM_EXPRESSION:
                setFromExpression((Expression)newValue);
                return;
            case QueryPackage.FROM_CLAUSE__ALIAS:
                setAlias((Iterator)newValue);
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
            case QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY:
                setFromClauseOfOqlQuery((OqlQuery)null);
                return;
            case QueryPackage.FROM_CLAUSE__FROM_EXPRESSION:
                setFromExpression((Expression)null);
                return;
            case QueryPackage.FROM_CLAUSE__ALIAS:
                setAlias((Iterator)null);
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
            case QueryPackage.FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY:
                return basicGetFromClauseOfOqlQuery() != null;
            case QueryPackage.FROM_CLAUSE__FROM_EXPRESSION:
                return fromExpression != null;
            case QueryPackage.FROM_CLAUSE__ALIAS:
                return alias != null;
        }
        return super.eIsSet(featureID);
    }

} //FromClauseImpl
