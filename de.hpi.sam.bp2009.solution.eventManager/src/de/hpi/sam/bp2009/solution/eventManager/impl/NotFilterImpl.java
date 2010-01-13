/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.FilterMatcher;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.NotFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class NotFilterImpl extends EventFilterImpl implements NotFilter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected NotFilterImpl() {
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
				if(!(filter instanceof NotFilter)){
					return false;
				}
				Object crit = filter.getFilterCriterion();
				if(!(crit instanceof EventFilter))
					return false;
				
				FilterMatcher otherFilter = ((EventFilter)crit).getFilterMatcher();
				if(otherFilter!=null && otherFilter.matchesForFilterType(event, (EventFilter)crit))
					return false;
				
				return true;
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
		return EventManagerPackage.Literals.NOT_FILTER;
	}

} //NotFilterImpl
