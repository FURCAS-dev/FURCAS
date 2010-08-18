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
import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilterIncludingSubclasses;
import de.hpi.sam.bp2009.solution.eventManager.filters.ContainmentFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilterIncludingSubclasses;
import de.hpi.sam.bp2009.solution.eventManager.filters.NotFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OldValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OldValueClassFilterIncludingSubclasses;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;

/**
 * Used to obtain an {@link EventManager} instance that listens to change {@link Notification}s occurring on a {@link ResourceSet}
 * . Additionally, an event manager factory offers factory methods
 * 
 * @author Philipp Berger, Axel Uhl
 */
public interface EventManagerFactory {
    /**
     * The default instance implementing this interface
     */
    EventManagerFactory eINSTANCE = de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerFactoryImpl.init();

    /**
     * Creates an {@link EventManager} that receives all change notifications from all notifiers contained directly or indirectly
     * by <code>set</code>. Those events matching the filters provided by listeners in their call to
     * {@link EventManager#subscribe(EventFilter, org.eclipse.emf.common.notify.Adapter)} will be passed on to those listener
     * {@link Adapter}s.
     */
    EventManager getEventManagerFor(ResourceSet set);

    /**
     * {@see EventTypeFilter#EventTypeFilter()}
     */
    EventTypeFilter createEventTypeFilter();

    /**
     * {@see OrFilter#OrFilter()}
     */
    OrFilter createOrFilter();

    /**
     * {@see NotFilter#NotFilter()}
     */
    NotFilter createNotFilter();

    /**
     * {@see AttributeFilter#AttributeFilter()}
     */
    AttributeFilter createAttributeFilter();

    /**
     * {@see AssociationFilter#AssociationFilter()}
     */
    AssociationFilter createAssociationFilter();

    /**
     * {@see ContainmentFilter#INSTANCE}
     */
    ContainmentFilter createContainmentFilter();

    /**
     * Creates an not negated {@link ClassFilter} {@see ClassFilter#ClassFilter(EClass, boolean))}
     */
    ClassFilter createClassFilter(EClass clazz);

    /**
     * Creates an not negated {@link ClassFilterIncludingSubclasses} {@see
     * ClassFilterIncludingSubclasses#ClassFilterIncludingSubclasses(EClass, boolean))}
     */
    ClassFilterIncludingSubclasses createClassFilterIncludingSubclasses(EClass clazz);

    /**
     * Creates an not negated {@link OldValueClassFilter} {@see OldValueClassFilter#OldValueClassFilter(EClass, boolean))}
     */
    OldValueClassFilter createOldValueClassFilter(EClass clazz);

    /**
     * Creates an not negated {@link OldValueClassFilterIncludingSubclasses} {@see
     * OldValueClassFilterIncludingSubclasses#OldValueClassFilterIncludingSubclasses(EClass, boolean))}
     */
    OldValueClassFilterIncludingSubclasses createOldValueClassFilterIncludingSubclasses(EClass clazz);

    /**
     * Creates an not negated {@link NewValueClassFilter} {@see NewValueClassFilter#NewValueClassFilter(EClass, boolean))}
     */
    NewValueClassFilter createNewValueClassFilter(EClass clazz);

    /**
     * Creates an not negated {@link NewValueClassFilterIncludingSubclasses} {@see
     * NewValueClassFilterIncludingSubclasses#NewValueClassFilterIncludingSubclasses(EClass, boolean))}
     */
    NewValueClassFilterIncludingSubclasses createNewValueClassFilterIncludingSubclasses(EClass clazz);

    /**
     * Constructs an {@link AndFilter} combining a {@link ClassFilter} for <code>eClass</code> and an {@link AttributeFilter} for
     * <code>referredProperty</code>.
     */
    EventFilter createFilterForEReference(EClass eClass, EStructuralFeature referredProperty);

    /**
     * Constructs an {@link AndFilter} combining a {@link ClassFilter} for <code>eClass</code> and an {@link AttributeFilter} for
     * <code>referredProperty</code>.
     */
    EventFilter createFilterForEAttribute(EClass eClass, EStructuralFeature referredProperty);

    /**
     * Creates an event filter that listens for events which indicate that an element of type <code>cls</code> has been added to
     * the event manager's {@link ResourceSet}, either by directly assigning it to the immediate {@link Resource#getContents()
     * contents} of a resource owned by the {@link ResourceSet}, or by assigning it to the containment reference of an element
     * that is already part of the {@link ResourceSet}, or by adding a parent in the containment hierarchy to the
     * {@link ResourceSet}.
     */
    EventFilter createFilterForElementInsertion(EClass cls);

    /**
     * Creates a filter tree, which will match if the given class get inserted or deleted by an event
     * 
     * @param cls
     *            class to listen for
     * @return the new filter tree
     */
    EventFilter createFilterForElementInsertionOrDeletion(EClass cls);

    /**
     * Shortcut, to create an {@link OrFilter} for incoming {@link EventFilter}s
     * 
     * @param eventFilters
     *            filter to combine with an OR
     * @return the created {@link OrFilter}
     */
    OrFilter createOrFilterFor(EventFilter... eventFilters);

    /**
     * Shortcut, to create an {@link AndFilter} for incoming {@link EventFilter}s
     * 
     * @param eventFilters
     *            filter to combine with an And
     * @return the created {@link AndFilter}
     */
    AndFilter createAndFilterFor(EventFilter... eventFilters);

    /**
     * If <code>event</code> indicates the setting/adding/removal of/to/from a containment reference, then it is expanded into a
     * collection of event notifications that document the creation or, respectively, dismantling of the entire containment
     * hierarchy.
     * <p>
     * 
     * In any case, <code>event</code> is part of the collection returned.
     */
    Collection<Notification> createNotificationForComposites(Notification event);

} // EventManagerFactory