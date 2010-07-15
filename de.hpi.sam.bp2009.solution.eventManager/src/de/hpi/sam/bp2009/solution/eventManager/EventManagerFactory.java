package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;

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

public interface EventManagerFactory {

    EventManagerFactory eINSTANCE = de.hpi.sam.bp2009.solution.eventManager.EventManagerFactoryImpl.init();

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

    EventFilter createFilterForEReference(EClass eClass, EStructuralFeature referredProperty);

    EventFilter createFilterForEAttribute(EClass eClass, EStructuralFeature referredProperty);

    EventFilter createFilterForElementInsertion(EClass cls);

    EventFilter createFilterForElementInsertionOrDeletion(EClass cls);

    EventFilter getOrFilterFor(EventFilter... eventFilters);

    EventFilter getAndFilterFor(EventFilter... eventFilters);

    Collection<Notification> createNotificationForComposites(Notification event);

} // EventManagerFactory