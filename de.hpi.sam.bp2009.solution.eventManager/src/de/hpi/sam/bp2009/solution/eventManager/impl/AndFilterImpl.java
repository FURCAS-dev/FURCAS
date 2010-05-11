/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.AndFilterImpl#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AndFilterImpl extends EventFilterImpl implements AndFilter {

	/**
	 * The cached value of the '{@link #getFilters() <em>Filters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilters()
	 * @generated
	 * @ordered
	 */
	protected EList<EventFilter> filters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AndFilterImpl() {
		super();
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
	public EList<EventFilter> getFilters() {
		if (filters == null) {
			filters = new EObjectResolvingEList<EventFilter>(EventFilter.class, this, EventManagerPackage.AND_FILTER__FILTERS);
		}
		return filters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean matchesFor(Notification event) {
		for(EventFilter operator:this.getFilters()){
			if(!(operator.matchesFor(event)))
				return false;
		}
		return true;
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<NotificationIdentifier> buildNotificationIdentifiers(NotificationIdentifier identifier) {
		Set<NotificationIdentifier> result = new HashSet<NotificationIdentifier>();
		for(EventFilter f: getFilters()){
			result.addAll(f.buildNotificationIdentifiers(identifier));
		}
		EList<NotificationIdentifier> notiResult = new BasicEList<NotificationIdentifier>();
		for(NotificationIdentifier i:result){
			notiResult.add(i);
		}
		return notiResult;
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
				return getFilters();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventManagerPackage.AND_FILTER__FILTERS:
				getFilters().clear();
				getFilters().addAll((Collection<? extends EventFilter>)newValue);
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
				getFilters().clear();
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
				return filters != null && !filters.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	@Override
	public String toString() {
	    StringBuilder bld = new StringBuilder();
	    boolean first = true;
	    
	    for(EventFilter f: getFilters()){
	        
	        if(!first){
	            bld.append("\n AND ");
	        }else{
	            first=false;
	        }
	        bld.append("(");
	        bld.append(f.toString());
	        bld.append(")");    
	    }
	       
	    return bld.toString();
	}


} //AndFilterImpl
