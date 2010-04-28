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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

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
public class ClassFilterImpl extends EObjectImpl implements ClassFilter {

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
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.CLASS_FILTER;
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
	 * @generated
	 */
	public void setWantedClass(EClass newWantedClass) {
		EClass oldWantedClass = wantedClass;
		wantedClass = newWantedClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.CLASS_FILTER__WANTED_CLASS, oldWantedClass, wantedClass));
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
		return ((EObject)notifier).eClass().getEAllSuperTypes().contains(getWantedClass());
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventManagerPackage.CLASS_FILTER__WANTED_CLASS:
				return wantedClass != null;
		}
		return super.eIsSet(featureID);
	}
} //ClassFilterImpl
