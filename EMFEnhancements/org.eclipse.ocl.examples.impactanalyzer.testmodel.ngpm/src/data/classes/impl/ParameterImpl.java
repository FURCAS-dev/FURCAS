/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.Signature;

import dataaccess.expressions.Expression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.ParameterImpl#getOwnerSignature <em>Owner Signature</em>}</li>
 *   <li>{@link data.classes.impl.ParameterImpl#getParameterOfClass <em>Parameter Of Class</em>}</li>
 *   <li>{@link data.classes.impl.ParameterImpl#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterImpl extends NamedValueImpl implements Parameter {
	/**
     * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDefaultValue()
     * @generated
     * @ordered
     */
	protected Expression defaultValue;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Signature getOwnerSignature() {
        if (eContainerFeatureID() != ClassesPackage.PARAMETER__OWNER_SIGNATURE) return null;
        return (Signature)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Signature basicGetOwnerSignature() {
        if (eContainerFeatureID() != ClassesPackage.PARAMETER__OWNER_SIGNATURE) return null;
        return (Signature)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOwnerSignature(Signature newOwnerSignature, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOwnerSignature, ClassesPackage.PARAMETER__OWNER_SIGNATURE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwnerSignature(Signature newOwnerSignature) {
        if (newOwnerSignature != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.PARAMETER__OWNER_SIGNATURE && newOwnerSignature != null)) {
            if (EcoreUtil.isAncestor(this, newOwnerSignature))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwnerSignature != null)
                msgs = ((InternalEObject)newOwnerSignature).eInverseAdd(this, ClassesPackage.SIGNATURE__INPUT, Signature.class, msgs);
            msgs = basicSetOwnerSignature(newOwnerSignature, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.PARAMETER__OWNER_SIGNATURE, newOwnerSignature, newOwnerSignature));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getParameterOfClass() {
        if (eContainerFeatureID() != ClassesPackage.PARAMETER__PARAMETER_OF_CLASS) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetParameterOfClass() {
        if (eContainerFeatureID() != ClassesPackage.PARAMETER__PARAMETER_OF_CLASS) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetParameterOfClass(SapClass newParameterOfClass, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameterOfClass, ClassesPackage.PARAMETER__PARAMETER_OF_CLASS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParameterOfClass(SapClass newParameterOfClass) {
        if (newParameterOfClass != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.PARAMETER__PARAMETER_OF_CLASS && newParameterOfClass != null)) {
            if (EcoreUtil.isAncestor(this, newParameterOfClass))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameterOfClass != null)
                msgs = ((InternalEObject)newParameterOfClass).eInverseAdd(this, ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS, SapClass.class, msgs);
            msgs = basicSetParameterOfClass(newParameterOfClass, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.PARAMETER__PARAMETER_OF_CLASS, newParameterOfClass, newParameterOfClass));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getDefaultValue() {
        if (defaultValue != null && defaultValue.eIsProxy()) {
            InternalEObject oldDefaultValue = (InternalEObject)defaultValue;
            defaultValue = (Expression)eResolveProxy(oldDefaultValue);
            if (defaultValue != oldDefaultValue) {
                InternalEObject newDefaultValue = (InternalEObject)defaultValue;
                NotificationChain msgs = oldDefaultValue.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.PARAMETER__DEFAULT_VALUE, null, null);
                if (newDefaultValue.eInternalContainer() == null) {
                    msgs = newDefaultValue.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.PARAMETER__DEFAULT_VALUE, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.PARAMETER__DEFAULT_VALUE, oldDefaultValue, defaultValue));
            }
        }
        return defaultValue;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetDefaultValue() {
        return defaultValue;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetDefaultValue(Expression newDefaultValue, NotificationChain msgs) {
        Expression oldDefaultValue = defaultValue;
        defaultValue = newDefaultValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.PARAMETER__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDefaultValue(Expression newDefaultValue) {
        if (newDefaultValue != defaultValue) {
            NotificationChain msgs = null;
            if (defaultValue != null)
                msgs = ((InternalEObject)defaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.PARAMETER__DEFAULT_VALUE, null, msgs);
            if (newDefaultValue != null)
                msgs = ((InternalEObject)newDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.PARAMETER__DEFAULT_VALUE, null, msgs);
            msgs = basicSetDefaultValue(newDefaultValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.PARAMETER__DEFAULT_VALUE, newDefaultValue, newDefaultValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ClassesPackage.PARAMETER__OWNER_SIGNATURE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOwnerSignature((Signature)otherEnd, msgs);
            case ClassesPackage.PARAMETER__PARAMETER_OF_CLASS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameterOfClass((SapClass)otherEnd, msgs);
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
            case ClassesPackage.PARAMETER__OWNER_SIGNATURE:
                return basicSetOwnerSignature(null, msgs);
            case ClassesPackage.PARAMETER__PARAMETER_OF_CLASS:
                return basicSetParameterOfClass(null, msgs);
            case ClassesPackage.PARAMETER__DEFAULT_VALUE:
                return basicSetDefaultValue(null, msgs);
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
            case ClassesPackage.PARAMETER__OWNER_SIGNATURE:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SIGNATURE__INPUT, Signature.class, msgs);
            case ClassesPackage.PARAMETER__PARAMETER_OF_CLASS:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS, SapClass.class, msgs);
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
            case ClassesPackage.PARAMETER__OWNER_SIGNATURE:
                if (resolve) return getOwnerSignature();
                return basicGetOwnerSignature();
            case ClassesPackage.PARAMETER__PARAMETER_OF_CLASS:
                if (resolve) return getParameterOfClass();
                return basicGetParameterOfClass();
            case ClassesPackage.PARAMETER__DEFAULT_VALUE:
                if (resolve) return getDefaultValue();
                return basicGetDefaultValue();
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
            case ClassesPackage.PARAMETER__OWNER_SIGNATURE:
                setOwnerSignature((Signature)newValue);
                return;
            case ClassesPackage.PARAMETER__PARAMETER_OF_CLASS:
                setParameterOfClass((SapClass)newValue);
                return;
            case ClassesPackage.PARAMETER__DEFAULT_VALUE:
                setDefaultValue((Expression)newValue);
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
            case ClassesPackage.PARAMETER__OWNER_SIGNATURE:
                setOwnerSignature((Signature)null);
                return;
            case ClassesPackage.PARAMETER__PARAMETER_OF_CLASS:
                setParameterOfClass((SapClass)null);
                return;
            case ClassesPackage.PARAMETER__DEFAULT_VALUE:
                setDefaultValue((Expression)null);
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
            case ClassesPackage.PARAMETER__OWNER_SIGNATURE:
                return basicGetOwnerSignature() != null;
            case ClassesPackage.PARAMETER__PARAMETER_OF_CLASS:
                return basicGetParameterOfClass() != null;
            case ClassesPackage.PARAMETER__DEFAULT_VALUE:
                return defaultValue != null;
        }
        return super.eIsSet(featureID);
    }

} //ParameterImpl
