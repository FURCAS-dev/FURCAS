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
import de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Value Class Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.NewValueClassFilterImpl#getAffectedClass <em>Affected Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewValueClassFilterImpl extends EventFilterImpl implements NewValueClassFilter {
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
	protected NewValueClassFilterImpl() {
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
		identifier.getNewValueClassURIs().add(EcoreUtil.getURI(getAffectedClass()));
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
			case EventManagerPackage.NEW_VALUE_CLASS_FILTER__AFFECTED_CLASS:
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
			case EventManagerPackage.NEW_VALUE_CLASS_FILTER__AFFECTED_CLASS:
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
        NewValueClassFilterImpl other = (NewValueClassFilterImpl) obj;
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
			case EventManagerPackage.NEW_VALUE_CLASS_FILTER__AFFECTED_CLASS:
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
			case EventManagerPackage.NEW_VALUE_CLASS_FILTER__AFFECTED_CLASS:
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.NEW_VALUE_CLASS_FILTER__AFFECTED_CLASS, oldAffectedClass, affectedClass));
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
		if(event.getNewValue() instanceof EObject){
			return((EObject)event.getNewValue()).eClass().equals(getAffectedClass());
		}
		if(event.getNewValue() instanceof EList<?>){
			for(Object o: (EList<?>)event.getNewValue()){
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.NEW_VALUE_CLASS_FILTER__AFFECTED_CLASS, oldAffectedClass, affectedClass));
	}
	@Override
	public String toString() {
	    if(getAffectedClass()!=null)
	        return "filter for new "+getAffectedClass().toString();
	    return "filter for undefined new";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.NEW_VALUE_CLASS_FILTER;
	}

} //NewValueClassFilterImpl
