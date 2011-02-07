/**
 * <copyright>
 * </copyright>
 *
 * $Id: PackageOwnerImpl.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package modelmanagement.impl;

import java.util.Collection;
import modelmanagement.ModelmanagementPackage;
import modelmanagement.PackageOwner;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelmanagement.impl.PackageOwnerImpl#getOwnedPackages <em>Owned Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageOwnerImpl extends NamedElementImpl implements PackageOwner {
	/**
     * The cached value of the '{@link #getOwnedPackages() <em>Owned Packages</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOwnedPackages()
     * @generated
     * @ordered
     */
	protected EList<modelmanagement.Package> ownedPackages;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PackageOwnerImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ModelmanagementPackage.Literals.PACKAGE_OWNER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<modelmanagement.Package> getOwnedPackages() {
        if (ownedPackages == null) {
            ownedPackages = new EObjectContainmentWithInverseEList.Resolving<modelmanagement.Package>(modelmanagement.Package.class, this, ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES, ModelmanagementPackage.PACKAGE__OWNER);
        }
        return ownedPackages;
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
            case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPackages()).basicAdd(otherEnd, msgs);
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
            case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
                return ((InternalEList<?>)getOwnedPackages()).basicRemove(otherEnd, msgs);
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
            case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
                return getOwnedPackages();
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
            case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
                getOwnedPackages().clear();
                getOwnedPackages().addAll((Collection<? extends modelmanagement.Package>)newValue);
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
            case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
                getOwnedPackages().clear();
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
            case ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES:
                return ownedPackages != null && !ownedPackages.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //PackageOwnerImpl
