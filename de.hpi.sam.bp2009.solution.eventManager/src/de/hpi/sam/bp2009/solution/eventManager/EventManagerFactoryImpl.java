package de.hpi.sam.bp2009.solution.eventManager;

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

public class EventManagerFactoryImpl implements EventManagerFactory {
    public static EventManagerFactory init() {
        return new EventManagerFactoryImpl();
    }

    public EventManagerFactoryImpl() {
        super();
    }

    public EventManager createEventManager() {
        EventManager eventManager = new EventManagerImpl();
        return eventManager;
    }
    public EventManager createEventManagerTableBased() {
        EventManager eventManager = new de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased();
        return eventManager;
    }
    public EventTypeFilter createEventTypeFilter() {
        EventTypeFilter eventTypeFilter = new EventTypeFilter();
        return eventTypeFilter;
    }

    public AndFilter createAndFilter() {
        AndFilter andFilter = new AndFilter();
        return andFilter;
    }

    public OrFilter createOrFilter() {
        OrFilter orFilter = new OrFilter();
        return orFilter;
    }
    public NotFilter createNotFilter() {
        NotFilter notFilter = new NotFilter();
        return notFilter;
    }
    public ClassFilter createClassFilter() {
        ClassFilter classFilter = new ClassFilter();
        return classFilter;
    }

    public AttributeFilter createAttributeFilter() {
        AttributeFilter attributeFilter = new AttributeFilter();
        return attributeFilter;
    }

    public AssociationFilter createAssociationFilter() {
        AssociationFilter associationFilter = new AssociationFilter();
        return associationFilter;
    }

    public OldValueClassFilter createOldValueClassFilter() {
        OldValueClassFilter oldValueClassFilter = new OldValueClassFilter();
        return oldValueClassFilter;
    }

    public NewValueClassFilter createNewValueClassFilter() {
        NewValueClassFilter newValueClassFilter = new NewValueClassFilter();
        return newValueClassFilter;
    }

    public NotificationIdentifier createNotificationIdentifier() {
        NotificationIdentifier notificationIdentifier = new NotificationIdentifier();
        return notificationIdentifier;
    }

    public NotificationIdentifierBuilder createNotificationIdentifierBuilder() {
        NotificationIdentifierBuilder notificationIdentifierBuilder = new NotificationIdentifierBuilder();
        return notificationIdentifierBuilder;
    }

    public ContainmentFilter createContainmentFilter() {
        ContainmentFilter containmentFilter = ContainmentFilter.INSTANCE;
        return containmentFilter;
    }
   
} // EventManagerFactoryImpl