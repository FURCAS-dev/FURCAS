/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import java.util.Collection;

import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 */
public class AndFilterImpl extends EventFilterImpl implements AndFilter {
	/**
	 * The cached value of the '{@link #getFilters() <em>Filters</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilters()
	 * @generated
	 * @ordered
	 */
	protected EventFilter filters;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected AndFilterImpl() {
		super();
	}

	void setOperators(EventFilter... operators){
		this.setFilterCriterion(operators);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.AND_FILTER;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventFilter getFilters() {
		if (filters != null && filters.eIsProxy()) {
			InternalEObject oldFilters = (InternalEObject)filters;
			filters = (EventFilter)eResolveProxy(oldFilters);
			if (filters != oldFilters) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.AND_FILTER__FILTERS, oldFilters, filters));
			}
		}
		return filters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventFilter basicGetFilters() {
		return filters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilters(EventFilter newFilters) {
		EventFilter oldFilters = filters;
		filters = newFilters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.AND_FILTER__FILTERS, oldFilters, filters));
	}

	@Override
	public boolean matchesFor(ModelChangeEvent event) {

		for(Object operator:(Collection)this.getFilterCriterion()){
			if(!(operator instanceof EventFilter))
				return false;
			if(!((EventFilter) operator).matchesFor(event))
				return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.AND_FILTER__FILTERS:
				if (resolve) return getFilters();
				return basicGetFilters();
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
			case EventManagerPackage.AND_FILTER__FILTERS:
				setFilters((EventFilter)newValue);
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
			case EventManagerPackage.AND_FILTER__FILTERS:
				setFilters((EventFilter)null);
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
			case EventManagerPackage.AND_FILTER__FILTERS:
				return filters != null;
		}
		return super.eIsSet(featureID);
	}

} //AndFilterImpl
