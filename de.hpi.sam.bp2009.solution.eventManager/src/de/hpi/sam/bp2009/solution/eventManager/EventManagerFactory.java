package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.solution.eventManager.filters.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ContainmentFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.LogicalOperationFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NotFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OldValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;

/**
 * Used to obtain an {@link EventManager} instance that listens to change {@link Notification}s occurring
 * on a {@link ResourceSet}. Additionally, an event manager factory offers factory methods 
 *  
 * @author Philipp Berger, Axel Uhl
 */
public interface EventManagerFactory {
    /**
     * The default instance implementing this interface
     */
    EventManagerFactory eINSTANCE = de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerFactoryImpl.init();

    /**
     * Creates an {@link EventManager} that receives all change notifications from all notifiers contained
     * directly or indirectly by <code>set</code>. Those events matching the filters provided by
     * listeners in their call to {@link EventManager#subscribe(EventFilter, org.eclipse.emf.common.notify.Adapter)}
     * will be passed on to those listener {@link Adapter}s.
     */
    EventManager getEventManagerFor(ResourceSet set);

    EventTypeFilter createEventTypeFilter();
    LogicalOperationFilter createAndFilter();
    OrFilter createOrFilter();
    NotFilter createNotFilter();
    ClassFilter createClassFilter();
    AttributeFilter createAttributeFilter();
    AssociationFilter createAssociationFilter();
    OldValueClassFilter createOldValueClassFilter();
    NewValueClassFilter createNewValueClassFilter();
    ContainmentFilter createContainmentFilter();

    /**
     * Constructs an {@link AndFilter} combining a {@link ClassFilter} for <code>eClass</code>
     * and an {@link AttributeFilter} for <code>referredProperty</code>.
     */
    EventFilter createFilterForEReference(EClass eClass, EStructuralFeature referredProperty);

    /**
     * Constructs an {@link AndFilter} combining a {@link ClassFilter} for <code>eClass</code>
     * and an {@link AttributeFilter} for <code>referredProperty</code>.
     */
    EventFilter createFilterForEAttribute(EClass eClass, EStructuralFeature referredProperty);

    /**
     * Creates an event filter that listens for events which indicate that an element of type <code>cls</code>
     * has been added to the event manager's {@link ResourceSet}, either by directly assigning it to the
     * immediate {@link Resource#getContents() contents} of a resource owned by the {@link ResourceSet},
     * or by assigning it to the containment reference of an element that is already part of the
     * {@link ResourceSet}, or by adding a parent in the containment hierarchy to the {@link ResourceSet}.
     */
    EventFilter createFilterForElementInsertion(EClass cls);

    EventFilter createFilterForElementInsertionOrDeletion(EClass cls);

    EventFilter getOrFilterFor(EventFilter... eventFilters);

    EventFilter getAndFilterFor(EventFilter... eventFilters);

    /**
     * If <code>event</code> indicates the setting/adding/removal of/to/from a containment
     * reference, then it is expanded into a collection of event notifications that document
     * the creation or, respectively, dismantling of the entire containment hierarchy.<p>
     * 
     * In any case, <code>event</code> is part of the collection returned.
     */
    Collection<Notification> createNotificationForComposites(Notification event);

} // EventManagerFactory