/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.MethodSignature;
import data.classes.Signature;
import data.classes.SignatureImplementation;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signature Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.SignatureImplementationImpl#getImplements_ <em>Implements </em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SignatureImplementationImpl extends EObjectImpl implements SignatureImplementation {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SignatureImplementationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.SIGNATURE_IMPLEMENTATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MethodSignature getImplements_() {
        if (eContainerFeatureID() != ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_) return null;
        return (MethodSignature)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MethodSignature basicGetImplements_() {
        if (eContainerFeatureID() != ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_) return null;
        return (MethodSignature)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetImplements_(MethodSignature newImplements_, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newImplements_, ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setImplements_(MethodSignature newImplements_) {
        if (newImplements_ != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_ && newImplements_ != null)) {
            if (EcoreUtil.isAncestor(this, newImplements_))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newImplements_ != null)
                msgs = ((InternalEObject)newImplements_).eInverseAdd(this, ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION, MethodSignature.class, msgs);
            msgs = basicSetImplements_(newImplements_, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_, newImplements_, newImplements_));
    }

	/**
     * The cached invocation delegate for the '{@link #getImplementedSignature() <em>Get Implemented Signature</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImplementedSignature()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_IMPLEMENTED_SIGNATURE__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SIGNATURE_IMPLEMENTATION.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Signature getImplementedSignature() {
        try {
            return (Signature)GET_IMPLEMENTED_SIGNATURE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetImplements_((MethodSignature)otherEnd, msgs);
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
            case ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_:
                return basicSetImplements_(null, msgs);
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
            case ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.METHOD_SIGNATURE__IMPLEMENTATION, MethodSignature.class, msgs);
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
            case ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_:
                if (resolve) return getImplements_();
                return basicGetImplements_();
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
            case ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_:
                setImplements_((MethodSignature)newValue);
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
            case ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_:
                setImplements_((MethodSignature)null);
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
            case ClassesPackage.SIGNATURE_IMPLEMENTATION__IMPLEMENTS_:
                return basicGetImplements_() != null;
        }
        return super.eIsSet(featureID);
    }

} //SignatureImplementationImpl
