package de.hpi.sam.bp2009.solution.eventManager;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

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

public class EventManagerFactoryImpl implements EventManagerFactory {
    WeakHashMap<ResourceSet,WeakReference<EventManager>> setToManager= new WeakHashMap<ResourceSet, WeakReference<EventManager>>();

    public static EventManagerFactory init() {
        return new EventManagerFactoryImpl();
    }

    public EventManagerFactoryImpl() {
        super();
    }
    public EventManager getEventManagerFor(ResourceSet set) {
        EventManager cached = setToManager.get(set)==null?null:setToManager.get(set).get();
        if(cached!=null){
            return cached;
        }
        EventManager eventManager = new de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased(set);
        setToManager.put(set, new WeakReference<EventManager>(eventManager));
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

    public ContainmentFilter createContainmentFilter() {
        ContainmentFilter containmentFilter = ContainmentFilter.INSTANCE;
        return containmentFilter;
    }
   
} // EventManagerFactoryImpl