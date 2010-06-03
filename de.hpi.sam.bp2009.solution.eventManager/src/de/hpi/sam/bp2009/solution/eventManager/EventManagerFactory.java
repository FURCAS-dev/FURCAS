package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.solution.eventManager.filters.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ContainmentFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NotFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OldValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;

public interface EventManagerFactory {

    EventManagerFactory eINSTANCE = de.hpi.sam.bp2009.solution.eventManager.EventManagerFactoryImpl.init();

    EventManager getEventManagerFor(ResourceSet set);

    EventTypeFilter createEventTypeFilter();

    AndFilter createAndFilter();

    OrFilter createOrFilter();
    
    NotFilter createNotFilter();

    ClassFilter createClassFilter();

    AttributeFilter createAttributeFilter();

    AssociationFilter createAssociationFilter();

    OldValueClassFilter createOldValueClassFilter();

    NewValueClassFilter createNewValueClassFilter();

    NotificationIdentifier createNotificationIdentifier();

    NotificationIdentifierBuilder createNotificationIdentifierBuilder();

    ContainmentFilter createContainmentFilter();

} // EventManagerFactory