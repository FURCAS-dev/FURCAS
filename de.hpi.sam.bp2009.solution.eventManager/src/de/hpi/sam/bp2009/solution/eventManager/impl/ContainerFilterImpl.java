/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventManager.ContainerFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.FilterMatcher;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.ContainerFilterImpl#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainerFilterImpl extends EObjectImpl implements ContainerFilter {
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
	protected ContainerFilterImpl() {
		super();
		this.setFilterMatcher(new FilterMatcher() {
			
			@Override
			public void eSetDeliver(boolean deliver) {
				
			}
			
			@Override
			public void eNotify(Notification notification) {
				
			}
			
			@Override
			public boolean eDeliver() {
				return false;
			}
			
			@Override
			public EList<Adapter> eAdapters() {
				return null;
			}
			
			@Override
			public void eUnset(EStructuralFeature feature) {
			
				
			}
			
			@Override
			public void eSet(EStructuralFeature feature, Object newValue) {
			
				
			}
			
			@Override
			public Resource eResource() {
			
				return null;
			}
			
			@Override
			public boolean eIsSet(EStructuralFeature feature) {
		
				return false;
			}
			
			@Override
			public boolean eIsProxy() {
		
				return false;
			}
			
			@Override
			public Object eGet(EStructuralFeature feature, boolean resolve) {
		
				return null;
			}
			
			@Override
			public Object eGet(EStructuralFeature feature) {
			
				return null;
			}
			
			@Override
			public EList<EObject> eCrossReferences() {
			
				return null;
			}
			
			@Override
			public EList<EObject> eContents() {
			
				return null;
			}
			
			@Override
			public EReference eContainmentFeature() {
			
				return null;
			}
			
			@Override
			public EStructuralFeature eContainingFeature() {
			
				return null;
			}
			
			@Override
			public EObject eContainer() {
			
				return null;
			}
			
			@Override
			public EClass eClass() {
				
				return null;
			}
			
			@Override
			public TreeIterator<EObject> eAllContents() {
			
				return null;
			}
			
			@Override
			public boolean matchesForFilterType(ModelChangeEvent event,
					EventFilter filter) {
				if(!(filter instanceof ContainerFilter)){
					return false;
				}
				Object crit = filter.getFilterCriterion();
				if((crit instanceof EObject) && (event.getSourceObject().eContainer().equals((EObject)crit))){
					return true;
				}
				return false;
			}
		});
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.CONTAINER_FILTER;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.CONTAINER_FILTER__FILTERS, oldFilters, filters));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.CONTAINER_FILTER__FILTERS, oldFilters, filters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean matchesFor(ModelChangeEvent event) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.CONTAINER_FILTER__FILTERS:
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
			case EventManagerPackage.CONTAINER_FILTER__FILTERS:
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
			case EventManagerPackage.CONTAINER_FILTER__FILTERS:
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
			case EventManagerPackage.CONTAINER_FILTER__FILTERS:
				return filters != null;
		}
		return super.eIsSet(featureID);
	}

} //ContainerFilterImpl
