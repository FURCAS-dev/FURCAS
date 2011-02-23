/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConverterBetweenParametrizationsImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.ConverterBetweenParametrizations;
import data.classes.MethodSignature;
import data.classes.SapClass;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Converter Between Parametrizations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.ConverterBetweenParametrizationsImpl#getClazz <em>Clazz</em>}</li>
 *   <li>{@link data.classes.impl.ConverterBetweenParametrizationsImpl#getConversionMethod <em>Conversion Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConverterBetweenParametrizationsImpl extends EObjectImpl implements ConverterBetweenParametrizations {
	/**
     * The cached value of the '{@link #getConversionMethod() <em>Conversion Method</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConversionMethod()
     * @generated
     * @ordered
     */
	protected MethodSignature conversionMethod;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ConverterBetweenParametrizationsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.CONVERTER_BETWEEN_PARAMETRIZATIONS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getClazz() {
        if (eContainerFeatureID() != ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetClazz() {
        if (eContainerFeatureID() != ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetClazz(SapClass newClazz, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newClazz, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setClazz(SapClass newClazz) {
        if (newClazz != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ && newClazz != null)) {
            if (EcoreUtil.isAncestor(this, newClazz))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newClazz != null)
                msgs = ((InternalEObject)newClazz).eInverseAdd(this, ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS, SapClass.class, msgs);
            msgs = basicSetClazz(newClazz, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ, newClazz, newClazz));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MethodSignature getConversionMethod() {
        if (conversionMethod != null && conversionMethod.eIsProxy()) {
            InternalEObject oldConversionMethod = (InternalEObject)conversionMethod;
            conversionMethod = (MethodSignature)eResolveProxy(oldConversionMethod);
            if (conversionMethod != oldConversionMethod) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD, oldConversionMethod, conversionMethod));
            }
        }
        return conversionMethod;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MethodSignature basicGetConversionMethod() {
        return conversionMethod;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetConversionMethod(MethodSignature newConversionMethod, NotificationChain msgs) {
        MethodSignature oldConversionMethod = conversionMethod;
        conversionMethod = newConversionMethod;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD, oldConversionMethod, newConversionMethod);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setConversionMethod(MethodSignature newConversionMethod) {
        if (newConversionMethod != conversionMethod) {
            NotificationChain msgs = null;
            if (conversionMethod != null)
                msgs = ((InternalEObject)conversionMethod).eInverseRemove(this, ClassesPackage.METHOD_SIGNATURE__CONVERTER, MethodSignature.class, msgs);
            if (newConversionMethod != null)
                msgs = ((InternalEObject)newConversionMethod).eInverseAdd(this, ClassesPackage.METHOD_SIGNATURE__CONVERTER, MethodSignature.class, msgs);
            msgs = basicSetConversionMethod(newConversionMethod, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD, newConversionMethod, newConversionMethod));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetClazz((SapClass)otherEnd, msgs);
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD:
                if (conversionMethod != null)
                    msgs = ((InternalEObject)conversionMethod).eInverseRemove(this, ClassesPackage.METHOD_SIGNATURE__CONVERTER, MethodSignature.class, msgs);
                return basicSetConversionMethod((MethodSignature)otherEnd, msgs);
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
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ:
                return basicSetClazz(null, msgs);
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD:
                return basicSetConversionMethod(null, msgs);
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
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS, SapClass.class, msgs);
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
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ:
                if (resolve) return getClazz();
                return basicGetClazz();
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD:
                if (resolve) return getConversionMethod();
                return basicGetConversionMethod();
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
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ:
                setClazz((SapClass)newValue);
                return;
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD:
                setConversionMethod((MethodSignature)newValue);
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
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ:
                setClazz((SapClass)null);
                return;
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD:
                setConversionMethod((MethodSignature)null);
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
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ:
                return basicGetClazz() != null;
            case ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD:
                return conversionMethod != null;
        }
        return super.eIsSet(featureID);
    }

} //ConverterBetweenParametrizationsImpl
