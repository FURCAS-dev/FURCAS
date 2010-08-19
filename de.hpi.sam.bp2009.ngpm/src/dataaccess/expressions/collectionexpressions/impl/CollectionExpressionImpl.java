/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.collectionexpressions.impl;

import dataaccess.expressions.Expression;

import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.collectionexpressions.CollectionExpression;
import dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage;

import dataaccess.expressions.impl.ExpressionImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.collectionexpressions.impl.CollectionExpressionImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CollectionExpressionImpl extends ExpressionImpl implements CollectionExpression {
	/**
     * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
	protected Expression source;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CollectionExpressionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CollectionexpressionsPackage.Literals.COLLECTION_EXPRESSION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getSource() {
        if (source != null && source.eIsProxy()) {
            InternalEObject oldSource = (InternalEObject)source;
            source = (Expression)eResolveProxy(oldSource);
            if (source != oldSource) {
                InternalEObject newSource = (InternalEObject)source;
                NotificationChain msgs =  oldSource.eInverseRemove(this, ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION, Expression.class, null);
                if (newSource.eInternalContainer() == null) {
                    msgs =  newSource.eInverseAdd(this, ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE, oldSource, source));
            }
        }
        return source;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetSource() {
        return source;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSource(Expression newSource, NotificationChain msgs) {
        Expression oldSource = source;
        source = newSource;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE, oldSource, newSource);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSource(Expression newSource) {
        if (newSource != source) {
            NotificationChain msgs = null;
            if (source != null)
                msgs = ((InternalEObject)source).eInverseRemove(this, ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION, Expression.class, msgs);
            if (newSource != null)
                msgs = ((InternalEObject)newSource).eInverseAdd(this, ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION, Expression.class, msgs);
            msgs = basicSetSource(newSource, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE, newSource, newSource));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE:
                if (source != null)
                    msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE, null, msgs);
                return basicSetSource((Expression)otherEnd, msgs);
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
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE:
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
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE:
                if (resolve) return getSource();
                return basicGetSource();
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
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE:
                setSource((Expression)newValue);
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
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE:
                setSource((Expression)null);
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
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION__SOURCE:
                return source != null;
        }
        return super.eIsSet(featureID);
    }

} //CollectionExpressionImpl
