/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager;

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.eventmanager.filters.AndFilter;
import org.eclipse.ocl.examples.eventmanager.filters.ClassFilter;
import org.eclipse.ocl.examples.eventmanager.filters.ClassFilterIncludingSubclasses;
import org.eclipse.ocl.examples.eventmanager.filters.ContainmentFilter;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.EventTypeFilter;
import org.eclipse.ocl.examples.eventmanager.filters.NewValueClassFilter;
import org.eclipse.ocl.examples.eventmanager.filters.NewValueClassFilterIncludingSubclasses;
import org.eclipse.ocl.examples.eventmanager.filters.NotFilter;
import org.eclipse.ocl.examples.eventmanager.filters.OldValueClassFilter;
import org.eclipse.ocl.examples.eventmanager.filters.OldValueClassFilterIncludingSubclasses;
import org.eclipse.ocl.examples.eventmanager.filters.OrFilter;
import org.eclipse.ocl.examples.eventmanager.filters.StructuralFeatureFilter;

/**
 * Used to obtain an {@link EventManager} instance that listens to change
 * {@link Notification}s occurring on zero or more {@link ResourceSet}s.
 * Additionally, an event manager factory offers factory methods for event
 * filters.
 * 
 * @author Philipp Berger, Axel Uhl
 */
public interface EventManagerFactory {
    /**
     * The default instance implementing this interface
     */
    EventManagerFactory eINSTANCE = org.eclipse.ocl.examples.eventmanager.framework.EventManagerFactoryImpl.init();

	/**
	 * Creates a new or re-uses an existing {@link EventManager} that was
	 * previously created by calling this operation (and not by
	 * {@link #createEventManagerFor(ResourceSet)}). The event manager receives
	 * all change notifications from all notifiers contained directly or
	 * indirectly by <code>set</code>. Those events matching the filters
	 * provided by listeners in their call to
	 * {@link EventManager#subscribe(EventFilter, org.eclipse.emf.common.notify.Adapter)}
	 * will be passed on to those listener {@link Adapter}s.
	 * 
	 * @param set
	 *            if <code>null</code>, a <code>null</code> result will be
	 *            returned
	 * @return a valid, non-<code>null</code> {@link EventManager} if and only
	 *         if <code>set!=null</code>
	 */
    EventManager getEventManagerFor(ResourceSet set);
    
    /**
     * Creates a new {@link EventManager} that initially does not receive change notifications from any resource set.
     * This is useful if you want to be able to already register adapters with the event manager without knowing the
     * resource sets from which those adapters later shall receive their notifications. Well-suited for creating
     * long-lived event managers.
     */
    EventManager createEventManager();

    /**
     * Creates a new {@link EventManager} that receives all change notifications from all notifiers contained directly or
     * indirectly by <code>set</code>. Those events matching the filters provided by listeners in their call to
     * {@link EventManager#subscribe(EventFilter, org.eclipse.emf.common.notify.Adapter)} will be passed on to those listener
     * {@link Adapter}s. The event manager returned will never be returned by {@link #getEventManagerFor(ResourceSet)}.
     * This is useful if you need to control which adapters subscribe to the event manager returned.
     */
    EventManager createEventManagerFor(ResourceSet set);

    /**
     * Filters for a {@link Notification}'s {@link Notification#getEventType() event type}, such as
     * {@link Notification#ADD} or {@link Notification#REMOVE}.
     * 
     * {@see EventTypeFilter#EventTypeFilter()}
     */
    EventTypeFilter createEventTypeFilter(int eventType);

    /**
     * {@see NotFilter#NotFilter()}
     */
    NotFilter createNotFilter(EventFilter filter);

    /**
     * {@see AttributeFilter#AttributeFilter()}
     */
    StructuralFeatureFilter createStructuralFeatureFilter(EStructuralFeature attribute);

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
     * Constructs an {@link AndFilter} combining a {@link ClassFilter} for <code>eClass</code> and an {@link PropertyFilter} for
     * <code>referredProperty</code>.
     */
    EventFilter createFilterForEReference(EClass eClass, EReference referredProperty);

    /**
     * Constructs an {@link AndFilter} combining a {@link ClassFilter} for <code>eClass</code> and an {@link PropertyFilter} for
     * <code>referredProperty</code>.
     */
    EventFilter createFilterForEAttribute(EClass eClass, EAttribute referredProperty);

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
