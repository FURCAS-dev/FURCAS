/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionExpressionWithArgumentImpl.java,v 1.1 2011/02/07 16:43:33 auhl Exp $
 */
package dataaccess.expressions.collectionexpressions.impl;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionWithArgument;
import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.WithArgument;

import dataaccess.expressions.collectionexpressions.CollectionExpressionWithArgument;
import dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Expression With Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.collectionexpressions.impl.CollectionExpressionWithArgumentImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CollectionExpressionWithArgumentImpl extends CollectionExpressionImpl implements CollectionExpressionWithArgument {
	/**
     * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getArgument()
     * @generated
     * @ordered
     */
	protected Expression argument;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CollectionExpressionWithArgumentImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CollectionexpressionsPackage.Literals.COLLECTION_EXPRESSION_WITH_ARGUMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getArgument() {
        if (argument != null && argument.eIsProxy()) {
            InternalEObject oldArgument = (InternalEObject)argument;
            argument = (Expression)eResolveProxy(oldArgument);
            if (argument != oldArgument) {
                InternalEObject newArgument = (InternalEObject)argument;
                NotificationChain msgs =  oldArgument.eInverseRemove(this, ExpressionsPackage.EXPRESSION__ARGUMENT_OF, Expression.class, null);
                if (newArgument.eInternalContainer() == null) {
                    msgs =  newArgument.eInverseAdd(this, ExpressionsPackage.EXPRESSION__ARGUMENT_OF, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT, oldArgument, argument));
            }
        }
        return argument;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetArgument() {
        return argument;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetArgument(Expression newArgument, NotificationChain msgs) {
        Expression oldArgument = argument;
        argument = newArgument;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT, oldArgument, newArgument);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setArgument(Expression newArgument) {
        if (newArgument != argument) {
            NotificationChain msgs = null;
            if (argument != null)
                msgs = ((InternalEObject)argument).eInverseRemove(this, ExpressionsPackage.EXPRESSION__ARGUMENT_OF, Expression.class, msgs);
            if (newArgument != null)
                msgs = ((InternalEObject)newArgument).eInverseAdd(this, ExpressionsPackage.EXPRESSION__ARGUMENT_OF, Expression.class, msgs);
            msgs = basicSetArgument(newArgument, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT, newArgument, newArgument));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT:
                if (argument != null)
                    msgs = ((InternalEObject)argument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT, null, msgs);
                return basicSetArgument((Expression)otherEnd, msgs);
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
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT:
                return basicSetArgument(null, msgs);
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
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT:
                if (resolve) return getArgument();
                return basicGetArgument();
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
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT:
                setArgument((Expression)newValue);
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
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT:
                setArgument((Expression)null);
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
            case CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT:
                return argument != null;
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
        if (baseClass == WithArgument.class) {
            switch (derivedFeatureID) {
                case CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT: return ExpressionsPackage.WITH_ARGUMENT__ARGUMENT;
                default: return -1;
            }
        }
        if (baseClass == ExpressionWithArgument.class) {
            switch (derivedFeatureID) {
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
        if (baseClass == WithArgument.class) {
            switch (baseFeatureID) {
                case ExpressionsPackage.WITH_ARGUMENT__ARGUMENT: return CollectionexpressionsPackage.COLLECTION_EXPRESSION_WITH_ARGUMENT__ARGUMENT;
                default: return -1;
            }
        }
        if (baseClass == ExpressionWithArgument.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //CollectionExpressionWithArgumentImpl
