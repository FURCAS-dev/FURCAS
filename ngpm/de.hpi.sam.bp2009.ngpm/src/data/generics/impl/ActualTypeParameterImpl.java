/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.generics.impl;

import data.classes.SapClass;

import data.generics.ActualTypeParameter;
import data.generics.FormalTypeParameter;
import data.generics.GenericsPackage;
import data.generics.ParameterizedClassInstantiation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actual Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.generics.impl.ActualTypeParameterImpl#getParameterizedClassInstantiation <em>Parameterized Class Instantiation</em>}</li>
 *   <li>{@link data.generics.impl.ActualTypeParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link data.generics.impl.ActualTypeParameterImpl#getFormalTypeParameter <em>Formal Type Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActualTypeParameterImpl extends EObjectImpl implements ActualTypeParameter {
	/**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected SapClass type;

	/**
     * The cached value of the '{@link #getFormalTypeParameter() <em>Formal Type Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFormalTypeParameter()
     * @generated
     * @ordered
     */
	protected FormalTypeParameter formalTypeParameter;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ActualTypeParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GenericsPackage.Literals.ACTUAL_TYPE_PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ParameterizedClassInstantiation getParameterizedClassInstantiation() {
        if (eContainerFeatureID() != GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION) return null;
        return (ParameterizedClassInstantiation)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ParameterizedClassInstantiation basicGetParameterizedClassInstantiation() {
        if (eContainerFeatureID() != GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION) return null;
        return (ParameterizedClassInstantiation)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetParameterizedClassInstantiation(ParameterizedClassInstantiation newParameterizedClassInstantiation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameterizedClassInstantiation, GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParameterizedClassInstantiation(ParameterizedClassInstantiation newParameterizedClassInstantiation) {
        if (newParameterizedClassInstantiation != eInternalContainer() || (eContainerFeatureID() != GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION && newParameterizedClassInstantiation != null)) {
            if (EcoreUtil.isAncestor(this, newParameterizedClassInstantiation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameterizedClassInstantiation != null)
                msgs = ((InternalEObject)newParameterizedClassInstantiation).eInverseAdd(this, GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION, ParameterizedClassInstantiation.class, msgs);
            msgs = basicSetParameterizedClassInstantiation(newParameterizedClassInstantiation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION, newParameterizedClassInstantiation, newParameterizedClassInstantiation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (SapClass)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericsPackage.ACTUAL_TYPE_PARAMETER__TYPE, oldType, type));
            }
        }
        return type;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetType() {
        return type;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setType(SapClass newType) {
        SapClass oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.ACTUAL_TYPE_PARAMETER__TYPE, oldType, type));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FormalTypeParameter getFormalTypeParameter() {
        if (formalTypeParameter != null && formalTypeParameter.eIsProxy()) {
            InternalEObject oldFormalTypeParameter = (InternalEObject)formalTypeParameter;
            formalTypeParameter = (FormalTypeParameter)eResolveProxy(oldFormalTypeParameter);
            if (formalTypeParameter != oldFormalTypeParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericsPackage.ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER, oldFormalTypeParameter, formalTypeParameter));
            }
        }
        return formalTypeParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FormalTypeParameter basicGetFormalTypeParameter() {
        return formalTypeParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetFormalTypeParameter(FormalTypeParameter newFormalTypeParameter, NotificationChain msgs) {
        FormalTypeParameter oldFormalTypeParameter = formalTypeParameter;
        formalTypeParameter = newFormalTypeParameter;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenericsPackage.ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER, oldFormalTypeParameter, newFormalTypeParameter);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFormalTypeParameter(FormalTypeParameter newFormalTypeParameter) {
        if (newFormalTypeParameter != formalTypeParameter) {
            NotificationChain msgs = null;
            if (formalTypeParameter != null)
                msgs = ((InternalEObject)formalTypeParameter).eInverseRemove(this, GenericsPackage.FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS, FormalTypeParameter.class, msgs);
            if (newFormalTypeParameter != null)
                msgs = ((InternalEObject)newFormalTypeParameter).eInverseAdd(this, GenericsPackage.FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS, FormalTypeParameter.class, msgs);
            msgs = basicSetFormalTypeParameter(newFormalTypeParameter, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER, newFormalTypeParameter, newFormalTypeParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameterizedClassInstantiation((ParameterizedClassInstantiation)otherEnd, msgs);
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER:
                if (formalTypeParameter != null)
                    msgs = ((InternalEObject)formalTypeParameter).eInverseRemove(this, GenericsPackage.FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS, FormalTypeParameter.class, msgs);
                return basicSetFormalTypeParameter((FormalTypeParameter)otherEnd, msgs);
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
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION:
                return basicSetParameterizedClassInstantiation(null, msgs);
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER:
                return basicSetFormalTypeParameter(null, msgs);
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
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION:
                return eInternalContainer().eInverseRemove(this, GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION, ParameterizedClassInstantiation.class, msgs);
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
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION:
                if (resolve) return getParameterizedClassInstantiation();
                return basicGetParameterizedClassInstantiation();
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER:
                if (resolve) return getFormalTypeParameter();
                return basicGetFormalTypeParameter();
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
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION:
                setParameterizedClassInstantiation((ParameterizedClassInstantiation)newValue);
                return;
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__TYPE:
                setType((SapClass)newValue);
                return;
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER:
                setFormalTypeParameter((FormalTypeParameter)newValue);
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
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION:
                setParameterizedClassInstantiation((ParameterizedClassInstantiation)null);
                return;
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__TYPE:
                setType((SapClass)null);
                return;
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER:
                setFormalTypeParameter((FormalTypeParameter)null);
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
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION:
                return basicGetParameterizedClassInstantiation() != null;
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__TYPE:
                return type != null;
            case GenericsPackage.ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER:
                return formalTypeParameter != null;
        }
        return super.eIsSet(featureID);
    }

} //ActualTypeParameterImpl
