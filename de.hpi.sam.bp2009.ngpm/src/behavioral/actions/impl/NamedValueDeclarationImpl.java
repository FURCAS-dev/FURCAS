/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions.impl;

import behavioral.actions.ActionsPackage;
import behavioral.actions.NamedValueDeclaration;
import behavioral.actions.NamedValueWithOptionalInitExpression;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Value Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.actions.impl.NamedValueDeclarationImpl#getNamedValue <em>Named Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedValueDeclarationImpl extends StatementImpl implements NamedValueDeclaration {
	/**
     * The cached value of the '{@link #getNamedValue() <em>Named Value</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNamedValue()
     * @generated
     * @ordered
     */
	protected NamedValueWithOptionalInitExpression namedValue;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NamedValueDeclarationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ActionsPackage.Literals.NAMED_VALUE_DECLARATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NamedValueWithOptionalInitExpression getNamedValue() {
        if (namedValue != null && namedValue.eIsProxy()) {
            InternalEObject oldNamedValue = (InternalEObject)namedValue;
            namedValue = (NamedValueWithOptionalInitExpression)eResolveProxy(oldNamedValue);
            if (namedValue != oldNamedValue) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE, oldNamedValue, namedValue));
            }
        }
        return namedValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NamedValueWithOptionalInitExpression basicGetNamedValue() {
        return namedValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetNamedValue(NamedValueWithOptionalInitExpression newNamedValue, NotificationChain msgs) {
        NamedValueWithOptionalInitExpression oldNamedValue = namedValue;
        namedValue = newNamedValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE, oldNamedValue, newNamedValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNamedValue(NamedValueWithOptionalInitExpression newNamedValue) {
        if (newNamedValue != namedValue) {
            NotificationChain msgs = null;
            if (namedValue != null)
                msgs = ((InternalEObject)namedValue).eInverseRemove(this, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION, NamedValueWithOptionalInitExpression.class, msgs);
            if (newNamedValue != null)
                msgs = ((InternalEObject)newNamedValue).eInverseAdd(this, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION, NamedValueWithOptionalInitExpression.class, msgs);
            msgs = basicSetNamedValue(newNamedValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE, newNamedValue, newNamedValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE:
                if (namedValue != null)
                    msgs = ((InternalEObject)namedValue).eInverseRemove(this, ActionsPackage.NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION, NamedValueWithOptionalInitExpression.class, msgs);
                return basicSetNamedValue((NamedValueWithOptionalInitExpression)otherEnd, msgs);
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
            case ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE:
                return basicSetNamedValue(null, msgs);
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
            case ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE:
                if (resolve) return getNamedValue();
                return basicGetNamedValue();
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
            case ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE:
                setNamedValue((NamedValueWithOptionalInitExpression)newValue);
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
            case ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE:
                setNamedValue((NamedValueWithOptionalInitExpression)null);
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
            case ActionsPackage.NAMED_VALUE_DECLARATION__NAMED_VALUE:
                return namedValue != null;
        }
        return super.eIsSet(featureID);
    }

} //NamedValueDeclarationImpl
