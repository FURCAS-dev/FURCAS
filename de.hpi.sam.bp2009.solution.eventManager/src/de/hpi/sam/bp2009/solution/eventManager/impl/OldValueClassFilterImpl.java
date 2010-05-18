/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.OldValueClassFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Old Value Class Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.OldValueClassFilterImpl#getAffectedClass <em>Affected Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OldValueClassFilterImpl extends EventFilterImpl implements OldValueClassFilter {
	/**
	 * The cached value of the '{@link #getAffectedClass() <em>Affected Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedClass()
	 * @generated
	 * @ordered
	 */
	protected EClass affectedClass;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OldValueClassFilterImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetAffectedClass() {
		return affectedClass;
	}

	@Override
	public EList<NotificationIdentifier> buildNotificationIdentifiers(
			NotificationIdentifier identifier) {
		identifier.getOldValueClassURIs().add(EcoreUtil.getURI(getAffectedClass()));
		return getEListForNotificationIdentifier(identifier);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.OLD_VALUE_CLASS_FILTER__AFFECTED_CLASS:
				if (resolve) return getAffectedClass();
				return basicGetAffectedClass();
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
			case EventManagerPackage.OLD_VALUE_CLASS_FILTER__AFFECTED_CLASS:
				return affectedClass != null;
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
        OldValueClassFilterImpl other = (OldValueClassFilterImpl) obj;
        if (affectedClass == null) {
            if (other.affectedClass != null)
                return false;
        } else if (!affectedClass.equals(other.affectedClass))
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
			case EventManagerPackage.OLD_VALUE_CLASS_FILTER__AFFECTED_CLASS:
				setAffectedClass((EClass)newValue);
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
			case EventManagerPackage.OLD_VALUE_CLASS_FILTER__AFFECTED_CLASS:
				setAffectedClass((EClass)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAffectedClass() {
		if (affectedClass != null && affectedClass.eIsProxy()) {
			InternalEObject oldAffectedClass = (InternalEObject)affectedClass;
			affectedClass = (EClass)eResolveProxy(oldAffectedClass);
			if (affectedClass != oldAffectedClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.OLD_VALUE_CLASS_FILTER__AFFECTED_CLASS, oldAffectedClass, affectedClass));
			}
		}
		return affectedClass;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((affectedClass == null) ? 0 : affectedClass.hashCode());
        return result;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean matchesFor(Notification event) {
		if(event.getOldValue()==null){
			return false;
		}
		if(event.getOldValue() instanceof EObject){
			return((EObject)event.getOldValue()).eClass().equals(getAffectedClass());
		}
		if(event.getOldValue() instanceof EList<?>){
			for(Object o: (EList<?>)event.getOldValue()){
				if(o instanceof EObject && ((EObject)o).eClass().equals(getAffectedClass())){
					return true;
				}
			}
			return false;
		}

		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffectedClass(EClass newAffectedClass) {
		EClass oldAffectedClass = affectedClass;
		affectedClass = newAffectedClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.OLD_VALUE_CLASS_FILTER__AFFECTED_CLASS, oldAffectedClass, affectedClass));
	}
	@Override
	public String toString() {
	    if(getAffectedClass()!=null)
	        return "filter for old "+getAffectedClass().toString();
	    return "filter for undefined old";
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.OLD_VALUE_CLASS_FILTER;
	}

} //OldValueClassFilterImpl
