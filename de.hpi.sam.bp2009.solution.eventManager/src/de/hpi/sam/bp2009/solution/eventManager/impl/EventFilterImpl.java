/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.FilterMatcher;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventFilterImpl#getFilterMatcher <em>Filter Matcher</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventFilterImpl#getFilterCriterion <em>Filter Criterion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EventFilterImpl extends EObjectImpl implements EventFilter {
	/**
	 * The cached value of the '{@link #getFilterMatcher() <em>Filter Matcher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterMatcher()
	 * @generated
	 * @ordered
	 */
	protected FilterMatcher filterMatcher;

	/**
	 * The default value of the '{@link #getFilterCriterion() <em>Filter Criterion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterCriterion()
	 * @generated
	 * @ordered
	 */
	protected static final Object FILTER_CRITERION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilterCriterion() <em>Filter Criterion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterCriterion()
	 * @generated
	 * @ordered
	 */
	protected Object filterCriterion = FILTER_CRITERION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.EVENT_FILTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMatcher getFilterMatcher() {
		if (filterMatcher != null && filterMatcher.eIsProxy()) {
			InternalEObject oldFilterMatcher = (InternalEObject)filterMatcher;
			filterMatcher = (FilterMatcher)eResolveProxy(oldFilterMatcher);
			if (filterMatcher != oldFilterMatcher) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.EVENT_FILTER__FILTER_MATCHER, oldFilterMatcher, filterMatcher));
			}
		}
		return filterMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMatcher basicGetFilterMatcher() {
		return filterMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterMatcher(FilterMatcher newFilterMatcher) {
		FilterMatcher oldFilterMatcher = filterMatcher;
		filterMatcher = newFilterMatcher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.EVENT_FILTER__FILTER_MATCHER, oldFilterMatcher, filterMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFilterCriterion() {
		return filterCriterion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterCriterion(Object newFilterCriterion) {
		Object oldFilterCriterion = filterCriterion;
		filterCriterion = newFilterCriterion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.EVENT_FILTER__FILTER_CRITERION, oldFilterCriterion, filterCriterion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.EVENT_FILTER__FILTER_MATCHER:
				if (resolve) return getFilterMatcher();
				return basicGetFilterMatcher();
			case EventManagerPackage.EVENT_FILTER__FILTER_CRITERION:
				return getFilterCriterion();
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
			case EventManagerPackage.EVENT_FILTER__FILTER_MATCHER:
				setFilterMatcher((FilterMatcher)newValue);
				return;
			case EventManagerPackage.EVENT_FILTER__FILTER_CRITERION:
				setFilterCriterion(newValue);
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
			case EventManagerPackage.EVENT_FILTER__FILTER_MATCHER:
				setFilterMatcher((FilterMatcher)null);
				return;
			case EventManagerPackage.EVENT_FILTER__FILTER_CRITERION:
				setFilterCriterion(FILTER_CRITERION_EDEFAULT);
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
			case EventManagerPackage.EVENT_FILTER__FILTER_MATCHER:
				return filterMatcher != null;
			case EventManagerPackage.EVENT_FILTER__FILTER_CRITERION:
				return FILTER_CRITERION_EDEFAULT == null ? filterCriterion != null : !FILTER_CRITERION_EDEFAULT.equals(filterCriterion);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (filterCriterion: ");
		result.append(filterCriterion);
		result.append(')');
		return result.toString();
	}

} //EventFilterImpl
