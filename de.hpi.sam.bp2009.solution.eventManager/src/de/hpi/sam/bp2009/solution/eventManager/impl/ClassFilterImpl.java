/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.ClassFilterImpl#getWantedClass <em>Wanted Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassFilterImpl extends EventFilterImpl implements ClassFilter {

	/**
	 * The cached value of the '{@link #getWantedClass() <em>Wanted Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWantedClass()
	 * @generated
	 * @ordered
	 */
	protected EClass wantedClass;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassFilterImpl() {
		super();
	}
    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetWantedClass() {
		return wantedClass;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
		EList<NotificationIdentifier> result = new BasicEList<NotificationIdentifier>();
		result.add(identifier);
		
		identifier.setNotifierClassURI(EcoreUtil.getURI(getWantedClass()));
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.CLASS_FILTER__WANTED_CLASS:
				if (resolve) return getWantedClass();
				return basicGetWantedClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventManagerPackage.CLASS_FILTER__WANTED_CLASS:
				return wantedClass != null;
		}
		return super.eIsSet(featureID);
	}

	/* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClassFilterImpl other = (ClassFilterImpl) obj;
        if (wantedClass == null) {
            if (other.wantedClass != null)
                return false;
        } else if (!wantedClass.equals(other.wantedClass))
            return false;
        return true;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventManagerPackage.CLASS_FILTER__WANTED_CLASS:
				setWantedClass((EClass)newValue);
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
			case EventManagerPackage.CLASS_FILTER__WANTED_CLASS:
				setWantedClass((EClass)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWantedClass() {
		if (wantedClass != null && wantedClass.eIsProxy()) {
			InternalEObject oldWantedClass = (InternalEObject)wantedClass;
			wantedClass = (EClass)eResolveProxy(oldWantedClass);
			if (wantedClass != oldWantedClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.CLASS_FILTER__WANTED_CLASS, oldWantedClass, wantedClass));
			}
		}
		return wantedClass;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((wantedClass == null) ? 0 : wantedClass.hashCode());
        return result;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean matchesFor(Notification event) {
		// TODO check if an URI based comparison is more adequate
		Object notifier = event.getNotifier();
		if(notifier==null || !(notifier instanceof EObject))
			return false;
		if(((EObject)notifier).eClass().equals(getWantedClass()))
			return true;
		if (((EObject)notifier).eClass().equals(getWantedClass())){
		    return true;
		}
		return ((EObject)notifier).eClass().getEAllSuperTypes().contains(getWantedClass());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWantedClass(EClass newWantedClass) {
		EClass oldWantedClass = wantedClass;
		wantedClass = newWantedClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.CLASS_FILTER__WANTED_CLASS, oldWantedClass, wantedClass));
	}

	@Override
	public String toString() {
	if(getWantedClass()!=null)
	    return "wantedClass :" +getWantedClass().toString();
	return "empty ClassFilter";
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.CLASS_FILTER;
	}
} //ClassFilterImpl
