/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectLiteralImpl.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions.literals.impl;

import data.classes.SapClass;

import dataaccess.expressions.impl.ExpressionImpl;

import dataaccess.expressions.literals.LiteralsPackage;
import dataaccess.expressions.literals.ObjectLiteral;
import dataaccess.expressions.literals.ValueInit;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.literals.impl.ObjectLiteralImpl#getValueClass <em>Value Class</em>}</li>
 *   <li>{@link dataaccess.expressions.literals.impl.ObjectLiteralImpl#getPropertyValues <em>Property Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectLiteralImpl extends ExpressionImpl implements ObjectLiteral {
	/**
     * The cached value of the '{@link #getValueClass() <em>Value Class</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValueClass()
     * @generated
     * @ordered
     */
	protected SapClass valueClass;

	/**
     * The cached value of the '{@link #getPropertyValues() <em>Property Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPropertyValues()
     * @generated
     * @ordered
     */
	protected EList<ValueInit> propertyValues;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ObjectLiteralImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return LiteralsPackage.Literals.OBJECT_LITERAL;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getValueClass() {
        if (valueClass != null && valueClass.eIsProxy()) {
            InternalEObject oldValueClass = (InternalEObject)valueClass;
            valueClass = (SapClass)eResolveProxy(oldValueClass);
            if (valueClass != oldValueClass) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, LiteralsPackage.OBJECT_LITERAL__VALUE_CLASS, oldValueClass, valueClass));
            }
        }
        return valueClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetValueClass() {
        return valueClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValueClass(SapClass newValueClass) {
        SapClass oldValueClass = valueClass;
        valueClass = newValueClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, LiteralsPackage.OBJECT_LITERAL__VALUE_CLASS, oldValueClass, valueClass));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ValueInit> getPropertyValues() {
        if (propertyValues == null) {
            propertyValues = new EObjectContainmentEList.Resolving<ValueInit>(ValueInit.class, this, LiteralsPackage.OBJECT_LITERAL__PROPERTY_VALUES);
        }
        return propertyValues;
    }

	/**
     * The cached invocation delegate for the '{@link #isEqualTo(dataaccess.expressions.literals.ObjectLiteral) <em>Is Equal To</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isEqualTo(dataaccess.expressions.literals.ObjectLiteral)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate IS_EQUAL_TO_OBJECT_LITERAL__EINVOCATION_DELEGATE = ((EOperation.Internal)LiteralsPackage.Literals.OBJECT_LITERAL.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isEqualTo(ObjectLiteral o) {
        try {
            return (Boolean)IS_EQUAL_TO_OBJECT_LITERAL__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{o}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case LiteralsPackage.OBJECT_LITERAL__PROPERTY_VALUES:
                return ((InternalEList<?>)getPropertyValues()).basicRemove(otherEnd, msgs);
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
            case LiteralsPackage.OBJECT_LITERAL__VALUE_CLASS:
                if (resolve) return getValueClass();
                return basicGetValueClass();
            case LiteralsPackage.OBJECT_LITERAL__PROPERTY_VALUES:
                return getPropertyValues();
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
            case LiteralsPackage.OBJECT_LITERAL__VALUE_CLASS:
                setValueClass((SapClass)newValue);
                return;
            case LiteralsPackage.OBJECT_LITERAL__PROPERTY_VALUES:
                getPropertyValues().clear();
                getPropertyValues().addAll((Collection<? extends ValueInit>)newValue);
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
            case LiteralsPackage.OBJECT_LITERAL__VALUE_CLASS:
                setValueClass((SapClass)null);
                return;
            case LiteralsPackage.OBJECT_LITERAL__PROPERTY_VALUES:
                getPropertyValues().clear();
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
            case LiteralsPackage.OBJECT_LITERAL__VALUE_CLASS:
                return valueClass != null;
            case LiteralsPackage.OBJECT_LITERAL__PROPERTY_VALUES:
                return propertyValues != null && !propertyValues.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ObjectLiteralImpl
