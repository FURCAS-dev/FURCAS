/**
 * <copyright>
 * </copyright>
 *
 * $Id: SignatureOwnerImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.MethodSignature;
import data.classes.SignatureOwner;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signature Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.SignatureOwnerImpl#getOwnedSignatures <em>Owned Signatures</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignatureOwnerImpl extends NamedElementImpl implements SignatureOwner {
	/**
     * The cached value of the '{@link #getOwnedSignatures() <em>Owned Signatures</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOwnedSignatures()
     * @generated
     * @ordered
     */
	protected EList<MethodSignature> ownedSignatures;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SignatureOwnerImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.SIGNATURE_OWNER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> getOwnedSignatures() {
        if (ownedSignatures == null) {
            ownedSignatures = new EObjectContainmentWithInverseEList.Resolving<MethodSignature>(MethodSignature.class, this, ClassesPackage.SIGNATURE_OWNER__OWNED_SIGNATURES, ClassesPackage.METHOD_SIGNATURE__OWNER);
        }
        return ownedSignatures;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ClassesPackage.SIGNATURE_OWNER__OWNED_SIGNATURES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedSignatures()).basicAdd(otherEnd, msgs);
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
            case ClassesPackage.SIGNATURE_OWNER__OWNED_SIGNATURES:
                return ((InternalEList<?>)getOwnedSignatures()).basicRemove(otherEnd, msgs);
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
            case ClassesPackage.SIGNATURE_OWNER__OWNED_SIGNATURES:
                return getOwnedSignatures();
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
            case ClassesPackage.SIGNATURE_OWNER__OWNED_SIGNATURES:
                getOwnedSignatures().clear();
                getOwnedSignatures().addAll((Collection<? extends MethodSignature>)newValue);
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
            case ClassesPackage.SIGNATURE_OWNER__OWNED_SIGNATURES:
                getOwnedSignatures().clear();
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
            case ClassesPackage.SIGNATURE_OWNER__OWNED_SIGNATURES:
                return ownedSignatures != null && !ownedSignatures.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //SignatureOwnerImpl
