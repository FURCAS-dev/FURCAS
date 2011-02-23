/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionSignatureImplementationImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.FunctionSignature;
import data.classes.FunctionSignatureImplementation;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Signature Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.FunctionSignatureImplementationImpl#getFunctionSignature <em>Function Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionSignatureImplementationImpl extends SignatureImplementationImpl implements FunctionSignatureImplementation {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FunctionSignatureImplementationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.FUNCTION_SIGNATURE_IMPLEMENTATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FunctionSignature getFunctionSignature() {
        if (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE) return null;
        return (FunctionSignature)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FunctionSignature basicGetFunctionSignature() {
        if (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE) return null;
        return (FunctionSignature)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetFunctionSignature(FunctionSignature newFunctionSignature, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newFunctionSignature, ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFunctionSignature(FunctionSignature newFunctionSignature) {
        if (newFunctionSignature != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE && newFunctionSignature != null)) {
            if (EcoreUtil.isAncestor(this, newFunctionSignature))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newFunctionSignature != null)
                msgs = ((InternalEObject)newFunctionSignature).eInverseAdd(this, ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION, FunctionSignature.class, msgs);
            msgs = basicSetFunctionSignature(newFunctionSignature, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE, newFunctionSignature, newFunctionSignature));
    }

	/**
     * The cached invocation delegate for the '{@link #isSideEffectFree() <em>Is Side Effect Free</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isSideEffectFree()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.FUNCTION_SIGNATURE_IMPLEMENTATION.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSideEffectFree() {
        try {
            return (Boolean)IS_SIDE_EFFECT_FREE__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
            case ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetFunctionSignature((FunctionSignature)otherEnd, msgs);
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
            case ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE:
                return basicSetFunctionSignature(null, msgs);
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
            case ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.FUNCTION_SIGNATURE__IMPLEMENTATION, FunctionSignature.class, msgs);
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
            case ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE:
                if (resolve) return getFunctionSignature();
                return basicGetFunctionSignature();
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
            case ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE:
                setFunctionSignature((FunctionSignature)newValue);
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
            case ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE:
                setFunctionSignature((FunctionSignature)null);
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
            case ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE:
                return basicGetFunctionSignature() != null;
        }
        return super.eIsSet(featureID);
    }

} //FunctionSignatureImplementationImpl
