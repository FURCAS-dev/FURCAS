/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventManager.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.FilterMatcher;
import de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent;
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
 * An implementation of the model object '<em><b>Association Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AssociationFilterImpl extends EventFilterImpl implements AssociationFilter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected AssociationFilterImpl() {
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
				//TODO Handle specific assoziations
				if(event instanceof LinkLifeCycleEvent){
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
		return EventManagerPackage.Literals.ASSOCIATION_FILTER;
	}

} //AssociationFilterImpl
