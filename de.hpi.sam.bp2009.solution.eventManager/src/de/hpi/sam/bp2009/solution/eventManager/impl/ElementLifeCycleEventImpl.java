/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Life Cycle Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.ElementLifeCycleEventImpl#getContainingElement <em>Containing Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementLifeCycleEventImpl extends ElementChangeEventImpl implements ElementLifeCycleEvent {
	/**
	 * The cached value of the '{@link #getContainingElement() <em>Containing Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainingElement()
	 * @generated
	 * @ordered
	 */
	protected EObject containingElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementLifeCycleEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.ELEMENT_LIFE_CYCLE_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getContainingElement() {
		if (containingElement != null && containingElement.eIsProxy()) {
			InternalEObject oldContainingElement = (InternalEObject)containingElement;
			containingElement = eResolveProxy(oldContainingElement);
			if (containingElement != oldContainingElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.ELEMENT_LIFE_CYCLE_EVENT__CONTAINING_ELEMENT, oldContainingElement, containingElement));
			}
		}
		return containingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetContainingElement() {
		return containingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingElement(EObject newContainingElement) {
		EObject oldContainingElement = containingElement;
		containingElement = newContainingElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.ELEMENT_LIFE_CYCLE_EVENT__CONTAINING_ELEMENT, oldContainingElement, containingElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.ELEMENT_LIFE_CYCLE_EVENT__CONTAINING_ELEMENT:
				if (resolve) return getContainingElement();
				return basicGetContainingElement();
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
			case EventManagerPackage.ELEMENT_LIFE_CYCLE_EVENT__CONTAINING_ELEMENT:
				setContainingElement((EObject)newValue);
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
			case EventManagerPackage.ELEMENT_LIFE_CYCLE_EVENT__CONTAINING_ELEMENT:
				setContainingElement((EObject)null);
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
			case EventManagerPackage.ELEMENT_LIFE_CYCLE_EVENT__CONTAINING_ELEMENT:
				return containingElement != null;
		}
		return super.eIsSet(featureID);
	}
	@Override
	public EventFilter getFilter() {
		EventManagerFactory f=EventManagerFactory.eINSTANCE;
		ClassFilter cls = f.createClassFilter();
		cls.setWantedClass(getChangedClass());
		
		EventTypeFilter type= f.createEventTypeFilter();
		type.setEventEClass(eClass());
		AndFilter and= f.createAndFilter();
		and.getFilters().add(cls);
		and.getFilters().add(type);
		return and;
	}

} //ElementLifeCycleEventImpl
