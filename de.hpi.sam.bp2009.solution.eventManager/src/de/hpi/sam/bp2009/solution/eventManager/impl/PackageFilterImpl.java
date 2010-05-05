/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.PackageFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.PackageFilterImpl#getWantedPackage <em>Wanted Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageFilterImpl extends EObjectImpl implements PackageFilter {
	/**
     * The cached value of the '{@link #getWantedPackage() <em>Wanted Package</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getWantedPackage()
     * @generated
     * @ordered
     */
	protected EPackage wantedPackage;
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PackageFilterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return EventManagerPackage.Literals.PACKAGE_FILTER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EPackage getWantedPackage() {
        if (wantedPackage != null && wantedPackage.eIsProxy()) {
            InternalEObject oldWantedPackage = (InternalEObject)wantedPackage;
            wantedPackage = (EPackage)eResolveProxy(oldWantedPackage);
            if (wantedPackage != oldWantedPackage) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.PACKAGE_FILTER__WANTED_PACKAGE, oldWantedPackage, wantedPackage));
            }
        }
        return wantedPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EPackage basicGetWantedPackage() {
        return wantedPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setWantedPackage(EPackage newWantedPackage) {
        EPackage oldWantedPackage = wantedPackage;
        wantedPackage = newWantedPackage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.PACKAGE_FILTER__WANTED_PACKAGE, oldWantedPackage, wantedPackage));
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean matchesFor(Notification event) {
		// TODO check if an URI based comparison is more adequate
		Object notifier = event.getNotifier();
		if(notifier==null)
			return false;
		if(!(notifier instanceof EObject))
			return false;
		return ((EObject)notifier).eClass().getEPackage().equals((getWantedPackage()));
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EventManagerPackage.PACKAGE_FILTER__WANTED_PACKAGE:
                if (resolve) return getWantedPackage();
                return basicGetWantedPackage();
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
            case EventManagerPackage.PACKAGE_FILTER__WANTED_PACKAGE:
                setWantedPackage((EPackage)newValue);
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
            case EventManagerPackage.PACKAGE_FILTER__WANTED_PACKAGE:
                setWantedPackage((EPackage)null);
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
            case EventManagerPackage.PACKAGE_FILTER__WANTED_PACKAGE:
                return wantedPackage != null;
        }
        return super.eIsSet(featureID);
    }
	@Override
	public String toString() {
	    if(getWantedPackage()!=null)
	        return "filter package "+getWantedPackage().toString();
	    return "filter undefined package";
	}

} //PackageFilterImpl
