/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Life Cycle Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.LinkLifeCycleEventImpl#getChangedReference <em>Changed Reference</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.LinkLifeCycleEventImpl#getCorrespondingObject <em>Corresponding Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LinkLifeCycleEventImpl extends ElementChangeEventImpl implements LinkLifeCycleEvent {
	/**
	 * The cached value of the '{@link #getChangedReference() <em>Changed Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangedReference()
	 * @generated
	 * @ordered
	 */
	protected EReference changedReference;

	/**
	 * The cached value of the '{@link #getCorrespondingObject() <em>Corresponding Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrespondingObject()
	 * @generated
	 * @ordered
	 */
	protected EObject correspondingObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkLifeCycleEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.LINK_LIFE_CYCLE_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangedReference() {
		if (changedReference != null && changedReference.eIsProxy()) {
			InternalEObject oldChangedReference = (InternalEObject)changedReference;
			changedReference = (EReference)eResolveProxy(oldChangedReference);
			if (changedReference != oldChangedReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CHANGED_REFERENCE, oldChangedReference, changedReference));
			}
		}
		return changedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetChangedReference() {
		return changedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangedReference(EReference newChangedReference) {
		EReference oldChangedReference = changedReference;
		changedReference = newChangedReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CHANGED_REFERENCE, oldChangedReference, changedReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getCorrespondingObject() {
		if (correspondingObject != null && correspondingObject.eIsProxy()) {
			InternalEObject oldCorrespondingObject = (InternalEObject)correspondingObject;
			correspondingObject = eResolveProxy(oldCorrespondingObject);
			if (correspondingObject != oldCorrespondingObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CORRESPONDING_OBJECT, oldCorrespondingObject, correspondingObject));
			}
		}
		return correspondingObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetCorrespondingObject() {
		return correspondingObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrespondingObject(EObject newCorrespondingObject) {
		EObject oldCorrespondingObject = correspondingObject;
		correspondingObject = newCorrespondingObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CORRESPONDING_OBJECT, oldCorrespondingObject, correspondingObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CHANGED_REFERENCE:
				if (resolve) return getChangedReference();
				return basicGetChangedReference();
			case EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CORRESPONDING_OBJECT:
				if (resolve) return getCorrespondingObject();
				return basicGetCorrespondingObject();
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
			case EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CHANGED_REFERENCE:
				setChangedReference((EReference)newValue);
				return;
			case EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CORRESPONDING_OBJECT:
				setCorrespondingObject((EObject)newValue);
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
			case EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CHANGED_REFERENCE:
				setChangedReference((EReference)null);
				return;
			case EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CORRESPONDING_OBJECT:
				setCorrespondingObject((EObject)null);
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
			case EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CHANGED_REFERENCE:
				return changedReference != null;
			case EventManagerPackage.LINK_LIFE_CYCLE_EVENT__CORRESPONDING_OBJECT:
				return correspondingObject != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public EventFilter getFilter() {
		EventManagerFactory f= EventManagerFactory.eINSTANCE;
		ClassFilter cls= null;
		if(getChangedClass()!=null){
			cls=f.createClassFilter();
			cls.setWantedClass(getChangedClass());
		}
		AssociationFilter ass = f.createAssociationFilter();
		ass.setReference(getChangedReference());
		EventTypeFilter type= f.createEventTypeFilter();
		type.setEventEClass(eClass());
		AndFilter and= f.createAndFilter();
		if(cls!=null)
			and.getFilters().add(cls);
		and.getFilters().add(ass);
		and.getFilters().add(type);
		return and;
	}

} //LinkLifeCycleEventImpl
