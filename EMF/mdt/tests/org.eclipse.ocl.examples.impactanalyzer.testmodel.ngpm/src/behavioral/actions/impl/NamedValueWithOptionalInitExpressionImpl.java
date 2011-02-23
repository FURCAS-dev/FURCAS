/**
 * <copyright>
 * </copyright>
 *
 * $Id: NamedValueWithOptionalInitExpressionImpl.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.NamedValueDeclaration;
import behavioral.actions.NamedValueWithOptionalInitExpression;

import data.classes.impl.NamedValueImpl;

import dataaccess.expressions.Expression;

import dataaccess.expressions.ExpressionsPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Value With Optional Init Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.NamedValueWithOptionalInitExpressionImpl#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link behavioral.actions.impl.NamedValueWithOptionalInitExpressionImpl#getNamedValueDeclaration <em>Named Value Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NamedValueWithOptionalInitExpressionImpl extends NamedValueImpl implements NamedValueWithOptionalInitExpression {
	/**
     * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInitExpression()
     * @generated
     * @ordered
     */
	protected Expression initExpression;

	/**
     * The cached value of the '{@link #getNamedValueDeclaration() <em>Named Value Declaration</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNamedValueDeclaration()
     * @generated
     * @ordered
     */
	protected NamedValueDeclaration namedValueDeclaration;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NamedValueWithOptionalInitExpressionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getInitExpression() {
        if (initExpression != null && initExpression.eIsProxy()) {
            InternalEObject oldInitExpression = (InternalEObject)initExpression;
            initExpression = (Expression)eResolveProxy(oldInitExpression);
            if (initExpression != oldInitExpression) {
                InternalEObject newInitExpression = (InternalEObject)initExpression;
                NotificationChain msgs =  oldInitExpression.eInverseRemove(this, ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR, Expression.class, null);
                if (newInitExpression.eInternalContainer() == null) {
                    msgs =  newInitExpression.eInverseAdd(this, ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION, oldInitExpression, initExpression));
            }
        }
        return initExpression;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetInitExpression() {
        return initExpression;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetInitExpression(Expression newInitExpression, NotificationChain msgs) {
        Expression oldInitExpression = initExpression;
        initExpression = newInitExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION, oldInitExpression, newInitExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInitExpression(Expression newInitExpression) {
        if (newInitExpression != initExpression) {
            NotificationChain msgs = null;
            if (initExpression != null)
                msgs = ((InternalEObject)initExpression).eInverseRemove(this, ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR, Expression.class, msgs);
            if (newInitExpression != null)
                msgs = ((InternalEObject)newInitExpression).eInverseAdd(this, ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR, Expression.class, msgs);
            msgs = basicSetInitExpression(newInitExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION, newInitExpression, newInitExpression));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NamedValueDeclaration getNamedValueDeclaration() {
        if (namedValueDeclaration != null && namedValueDeclaration.eIsProxy()) {
            InternalEObject oldNamedValueDeclaration = (InternalEObject)namedValueDeclaration;
            namedValueDeclaration = (NamedValueDeclaration)eResolveProxy(oldNamedValueDeclaration);
            if (namedValueDeclaration != oldNamedValueDeclaration) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION, oldNamedValueDeclaration, namedValueDeclaration));
            }
        }
        return namedValueDeclaration;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NamedValueDeclaration basicGetNamedValueDeclaration() {
        return namedValueDeclaration;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetNamedValueDeclaration(NamedValueDeclaration newNamedValueDeclaration, NotificationChain msgs) {
        NamedValueDeclaration oldNamedValueDeclaration = namedValueDeclaration;
        namedValueDeclaration = newNamedValueDeclaration;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION, oldNamedValueDeclaration, newNamedValueDeclaration);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNamedValueDeclaration(NamedValueDeclaration newNamedValueDeclaration) {
        if (newNamedValueDeclaration != namedValueDeclaration) {
            NotificationChain msgs = null;
            if (namedValueDeclaration != null)
                msgs = ((InternalEObject)namedValueDeclaration).eInverseRemove(this, ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE, NamedValueDeclaration.class, msgs);
            if (newNamedValueDeclaration != null)
                msgs = ((InternalEObject)newNamedValueDeclaration).eInverseAdd(this, ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE, NamedValueDeclaration.class, msgs);
            msgs = basicSetNamedValueDeclaration(newNamedValueDeclaration, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION, newNamedValueDeclaration, newNamedValueDeclaration));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION:
                if (initExpression != null)
                    msgs = ((InternalEObject)initExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION, null, msgs);
                return basicSetInitExpression((Expression)otherEnd, msgs);
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION:
                if (namedValueDeclaration != null)
                    msgs = ((InternalEObject)namedValueDeclaration).eInverseRemove(this, ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE, NamedValueDeclaration.class, msgs);
                return basicSetNamedValueDeclaration((NamedValueDeclaration)otherEnd, msgs);
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
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION:
                return basicSetInitExpression(null, msgs);
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION:
                return basicSetNamedValueDeclaration(null, msgs);
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
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION:
                if (resolve) return getInitExpression();
                return basicGetInitExpression();
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION:
                if (resolve) return getNamedValueDeclaration();
                return basicGetNamedValueDeclaration();
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
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION:
                setInitExpression((Expression)newValue);
                return;
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION:
                setNamedValueDeclaration((NamedValueDeclaration)newValue);
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
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION:
                setInitExpression((Expression)null);
                return;
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION:
                setNamedValueDeclaration((NamedValueDeclaration)null);
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
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION:
                return initExpression != null;
            case ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION:
                return namedValueDeclaration != null;
        }
        return super.eIsSet(featureID);
    }

} //NamedValueWithOptionalInitExpressionImpl
