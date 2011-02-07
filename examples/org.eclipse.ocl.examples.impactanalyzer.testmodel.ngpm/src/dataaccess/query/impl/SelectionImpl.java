/**
 * <copyright>
 * </copyright>
 *
 * $Id: SelectionImpl.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.query.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.Iterator;

import dataaccess.expressions.Expression;

import dataaccess.expressions.impl.ObjectBasedExpressionImpl;

import dataaccess.query.QueryPackage;
import dataaccess.query.Selection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.query.impl.SelectionImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link dataaccess.query.impl.SelectionImpl#getSelectionExpr <em>Selection Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionImpl extends ObjectBasedExpressionImpl implements Selection {
	/**
     * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIterator()
     * @generated
     * @ordered
     */
	protected Iterator iterator;

	/**
     * The cached value of the '{@link #getSelectionExpr() <em>Selection Expr</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSelectionExpr()
     * @generated
     * @ordered
     */
	protected Expression selectionExpr;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SelectionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return QueryPackage.Literals.SELECTION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Iterator getIterator() {
        if (iterator != null && iterator.eIsProxy()) {
            InternalEObject oldIterator = (InternalEObject)iterator;
            iterator = (Iterator)eResolveProxy(oldIterator);
            if (iterator != oldIterator) {
                InternalEObject newIterator = (InternalEObject)iterator;
                NotificationChain msgs =  oldIterator.eInverseRemove(this, ActionsPackage.ITERATOR__SELECTION, Iterator.class, null);
                if (newIterator.eInternalContainer() == null) {
                    msgs =  newIterator.eInverseAdd(this, ActionsPackage.ITERATOR__SELECTION, Iterator.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.SELECTION__ITERATOR, oldIterator, iterator));
            }
        }
        return iterator;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Iterator basicGetIterator() {
        return iterator;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetIterator(Iterator newIterator, NotificationChain msgs) {
        Iterator oldIterator = iterator;
        iterator = newIterator;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryPackage.SELECTION__ITERATOR, oldIterator, newIterator);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIterator(Iterator newIterator) {
        if (newIterator != iterator) {
            NotificationChain msgs = null;
            if (iterator != null)
                msgs = ((InternalEObject)iterator).eInverseRemove(this, ActionsPackage.ITERATOR__SELECTION, Iterator.class, msgs);
            if (newIterator != null)
                msgs = ((InternalEObject)newIterator).eInverseAdd(this, ActionsPackage.ITERATOR__SELECTION, Iterator.class, msgs);
            msgs = basicSetIterator(newIterator, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.SELECTION__ITERATOR, newIterator, newIterator));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getSelectionExpr() {
        if (selectionExpr != null && selectionExpr.eIsProxy()) {
            InternalEObject oldSelectionExpr = (InternalEObject)selectionExpr;
            selectionExpr = (Expression)eResolveProxy(oldSelectionExpr);
            if (selectionExpr != oldSelectionExpr) {
                InternalEObject newSelectionExpr = (InternalEObject)selectionExpr;
                NotificationChain msgs = oldSelectionExpr.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.SELECTION__SELECTION_EXPR, null, null);
                if (newSelectionExpr.eInternalContainer() == null) {
                    msgs = newSelectionExpr.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryPackage.SELECTION__SELECTION_EXPR, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.SELECTION__SELECTION_EXPR, oldSelectionExpr, selectionExpr));
            }
        }
        return selectionExpr;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetSelectionExpr() {
        return selectionExpr;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSelectionExpr(Expression newSelectionExpr, NotificationChain msgs) {
        Expression oldSelectionExpr = selectionExpr;
        selectionExpr = newSelectionExpr;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QueryPackage.SELECTION__SELECTION_EXPR, oldSelectionExpr, newSelectionExpr);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSelectionExpr(Expression newSelectionExpr) {
        if (newSelectionExpr != selectionExpr) {
            NotificationChain msgs = null;
            if (selectionExpr != null)
                msgs = ((InternalEObject)selectionExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.SELECTION__SELECTION_EXPR, null, msgs);
            if (newSelectionExpr != null)
                msgs = ((InternalEObject)newSelectionExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QueryPackage.SELECTION__SELECTION_EXPR, null, msgs);
            msgs = basicSetSelectionExpr(newSelectionExpr, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.SELECTION__SELECTION_EXPR, newSelectionExpr, newSelectionExpr));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case QueryPackage.SELECTION__ITERATOR:
                if (iterator != null)
                    msgs = ((InternalEObject)iterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QueryPackage.SELECTION__ITERATOR, null, msgs);
                return basicSetIterator((Iterator)otherEnd, msgs);
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
            case QueryPackage.SELECTION__ITERATOR:
                return basicSetIterator(null, msgs);
            case QueryPackage.SELECTION__SELECTION_EXPR:
                return basicSetSelectionExpr(null, msgs);
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
            case QueryPackage.SELECTION__ITERATOR:
                if (resolve) return getIterator();
                return basicGetIterator();
            case QueryPackage.SELECTION__SELECTION_EXPR:
                if (resolve) return getSelectionExpr();
                return basicGetSelectionExpr();
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
            case QueryPackage.SELECTION__ITERATOR:
                setIterator((Iterator)newValue);
                return;
            case QueryPackage.SELECTION__SELECTION_EXPR:
                setSelectionExpr((Expression)newValue);
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
            case QueryPackage.SELECTION__ITERATOR:
                setIterator((Iterator)null);
                return;
            case QueryPackage.SELECTION__SELECTION_EXPR:
                setSelectionExpr((Expression)null);
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
            case QueryPackage.SELECTION__ITERATOR:
                return iterator != null;
            case QueryPackage.SELECTION__SELECTION_EXPR:
                return selectionExpr != null;
        }
        return super.eIsSet(featureID);
    }

} //SelectionImpl
