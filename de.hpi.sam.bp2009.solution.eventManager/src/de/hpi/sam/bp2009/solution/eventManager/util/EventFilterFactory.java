/**
 * 
 */
package de.hpi.sam.bp2009.solution.eventManager.util;

import java.util.Arrays;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.OldValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.StructuralFeatureFilter;

/**
 * @author Philipp Berger
 *
 */
public class EventFilterFactory {
	
	static EventFilterFactory instance = new EventFilterFactory();
	
	/**
	 * @return the singelton instance of the factory
	 */
	public static EventFilterFactory getInstance() {
		return instance;
	}
	/**
	 * private constructor for singelton
	 */
	private EventFilterFactory() {
	}
	/**
	 * Handle creation of an And-filter for multiple given filters
	 * @param eventFilters
	 * @return
	 */
	public EventFilter getAndFilterFor(EventFilter...eventFilters){
		AndFilter and = EventManagerFactory.eINSTANCE.createAndFilter();
		and.getFilters().addAll(Arrays.asList(eventFilters));
		return and;
	}
	/**
	 * Creates an And-Filter for all given filters
	 * @param eventFilters
	 * @return
	 */
	public EventFilter getOrFilterFor(EventFilter... eventFilters){
		OrFilter or = EventManagerFactory.eINSTANCE.createOrFilter();
		or.getFilters().addAll(Arrays.asList(eventFilters));
		return or;
	}
	
	public EventFilter createFilterForElementInsertionOrDeletion(EClass cls){
		EventManagerFactory i = EventManagerFactory.eINSTANCE;
		
		NewValueClassFilter nv = i.createNewValueClassFilter();
		nv.setAffectedClass(cls);
		
		OldValueClassFilter ov = i.createOldValueClassFilter();
		ov.setAffectedClass(cls);

		return getAndFilterFor(getOrFilterFor(nv,ov),
				i.createContainmentFilter() );
	}
	public EventFilter createFilterForElementInsertion(EClass cls){
		EventManagerFactory i = EventManagerFactory.eINSTANCE;
			
		NewValueClassFilter nv = i.createNewValueClassFilter();
		nv.setAffectedClass(cls);
		/*
		 * Figure out what the containing Reference is
		 */
		return getAndFilterFor(createOrFilterForEventTypes(Notification.ADD, Notification.SET, Notification.ADD_MANY),
				nv,
				i.createContainmentFilter());

	}
	public OrFilter createOrFilterForEventTypes(int... types){
		OrFilter or = EventManagerFactory.eINSTANCE.createOrFilter();
		for(int t:types){
			EventTypeFilter e1 = EventManagerFactory.eINSTANCE.createEventTypeFilter();
			e1.setEventType(t);
			or.getFilters().add(e1);
		}
		return or;

	}
	public EventFilter createFilterForStructuralFeature(EClass eClass,
			EStructuralFeature referredProperty) {
		EventManagerFactory i = EventManagerFactory.eINSTANCE;

		StructuralFeatureFilter sf = i.createStructuralFeatureFilter();
		sf.setFeature(referredProperty);
		
		ClassFilter cf = i.createClassFilter();
		cf.setWantedClass(eClass);
		
		return getAndFilterFor(sf,cf);

		
	}
}
