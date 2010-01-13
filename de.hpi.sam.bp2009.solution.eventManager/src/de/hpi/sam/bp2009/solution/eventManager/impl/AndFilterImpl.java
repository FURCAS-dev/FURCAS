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
import de.hpi.sam.bp2009.solution.eventManager.FilterMatcher;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected AndFilterImpl() {
		super();
		this.setFilterMatcher(new FilterMatcher() {
			@Override
			public boolean matchesForFilterType(ModelChangeEvent event,
					EventFilter filter) {
				if(!(filter instanceof AndFilter)){
					return false;
				}
				Object crit = filter.getFilterCriterion();
				if (!(crit instanceof Collection)){
					return false;
				}
				for(Object operator:(Collection)crit){
					if(!(operator instanceof EventFilter))
						return false;
					FilterMatcher otherFilter = ((EventFilter)operator).getFilterMatcher();
					if(!(otherFilter!=null && otherFilter.matchesForFilterType(event, (EventFilter)operator)))
						return false;
				}
				return true;
			}

			@Override
			public TreeIterator<EObject> eAllContents() {
				return null;
			}

			@Override
			public EClass eClass() {
				return null;
			}

			@Override
			public EObject eContainer() {
				return null;
			}

			@Override
			public EStructuralFeature eContainingFeature() {
				return null;
			}

			@Override
			public EReference eContainmentFeature() {
				return null;
			}

			@Override
			public EList<EObject> eContents() {
				return null;
			}

			@Override
			public EList<EObject> eCrossReferences() {
				return null;
			}

			@Override
			public Object eGet(EStructuralFeature feature) {
				return null;
			}

			@Override
			public Object eGet(EStructuralFeature feature, boolean resolve) {
				return null;
			}

			@Override
			public boolean eIsProxy() {
				return false;
			}

			@Override
			public boolean eIsSet(EStructuralFeature feature) {
				return false;
			}

			@Override
			public Resource eResource() {
				return null;
			}

			@Override
			public void eSet(EStructuralFeature feature, Object newValue) {
				
			}

			@Override
			public void eUnset(EStructuralFeature feature) {
				
			}

			@Override
			public EList<Adapter> eAdapters() {
				return null;
			}

			@Override
			public boolean eDeliver() {
				return false;
			}

			@Override
			public void eNotify(Notification notification) {
				
			}

			@Override
			public void eSetDeliver(boolean deliver) {
				
			}
		});
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

} //AndFilterImpl
