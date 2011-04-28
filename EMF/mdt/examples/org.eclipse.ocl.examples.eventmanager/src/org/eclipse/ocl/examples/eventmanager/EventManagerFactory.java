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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.eventmanager.filters.AndFilter;
import org.eclipse.ocl.examples.eventmanager.filters.NewValueClassFilter;
import org.eclipse.ocl.examples.eventmanager.filters.NewValueClassFilterIncludingSubclasses;
import org.eclipse.ocl.examples.eventmanager.filters.OldValueClassFilter;
import org.eclipse.ocl.examples.eventmanager.filters.OldValueClassFilterIncludingSubclasses;
import org.eclipse.ocl.examples.eventmanager.filters.OrFilter;

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
    EventFilter createEventTypeFilter(int eventType);

    /**
     * Creates a filter that matches if and only if <code>filter</code> does not match.
     */
    EventFilter createNotFilter(EventFilter filter);

    /**
     * Creates a filter that matches a notification if its {@link Notification#getFeature() feature}
     * equals <code>feature</code>.
     */
    EventFilter createStructuralFeatureFilter(EStructuralFeature feature);

	/**
	 * Creates a filter that matches a notification that indicates a change in
	 * containment. This may be an {@link EReference} with its
	 * {@link EReference#isContainer()} or {@link EReference#isContainment()}
	 * set to <code>true</code>, or it may be a change in the containment of a
	 * {@link Resource} in a {@link ResourceSet} or of an {@link EObject} in a
	 * {@link Resource}.
	 */
    EventFilter createContainmentFilter();

	/**
	 * Creates a filter that matches a {@link Notification} if the
	 * {@link Notification#getNotifier() object that changed}
	 * {@link EObject#eClass() has <code>clazz</code> as its class}.
	 */
    EventFilter createClassFilter(EClass clazz);

	/**
	 * Creates a filter that matches a
	 * notification if its {@link Notification#getNotifier() notifier}'s
	 * {@link EObject#eClass() class} equals the class passed to this filter's
	 * constructor or any subclasses thereof.
	 */
    EventFilter createClassFilterIncludingSubclasses(EClass clazz);

	/**
	 * Creates a filter that matches an event's
	 * {@link Notification#getOldValue()} {@link EObject#eClass() class} against
	 * <code>clazz</code>. An exact match, not considering any inheritance
	 * relations, is required. If the {@link Notification#getOldValue() new
	 * value} is a collection, e.g., because several elements were removed from
	 * a many-feature at once, this filter matches if at least one of the
	 * elements' class is matched.
	 * <p>
	 * 
	 * When several such filters are combined in an {@link AndFilter}, the
	 * {@link AndFilter} matches if all of its operand filters match. This does
	 * not require the individual {@link OldValueClassFilter}s to match based on
	 * the same element in case the old value happens to be a collection. For
	 * example, assume there are two classes <code>X</code> and <code>Y</code>.
	 * Assume there is an {@link AndFiter} with two {@link OldValueClassFilter}s
	 * inside, one matching <code>X</code>, the other matching <code>Y</code>.
	 * If there are two elements in the old value collection of the
	 * {@link Notification}, one of type <code>X</code> and the other of type
	 * <code>Y</code>, the first {@link OldValueClassFilter} matches because of
	 * the <code>X</code> element, and the second {@link OldValueClassFilter}
	 * matches because of the <code>Y</code> element and hence the
	 * {@link AndFilter} matches. However, no single element in the old value
	 * collection fulfills both criteria.
	 */
    EventFilter createOldValueClassFilter(EClass clazz);

	/**
	 * Creates an filter that matches an event's
	 * {@link Notification#getOldValue()} {@link EObject#eClass() class} against
	 * <code>clazz</code> and all subclasses thereof. If the new value is a
	 * collection then this filter matches if at least one of the collection's
	 * elements is matched.
	 * <p>
	 * 
	 * When several such filters are combined in an {@link AndFilter}, the
	 * {@link AndFilter} matches if all of its operand filters match. This does
	 * not require the individual {@link OldValueClassFilterIncludingSubclasses}
	 * s to match based on the same element in case the old value happens to be
	 * a collection. For example, assume there are two classes <code>X</code>
	 * and <code>Y</code> with a class <code>Z</code> that has both,
	 * <code>X</code> and <code>Y</code> as its superclasses (multiple
	 * inheritance). Assume there is an {@link AndFiter} with two
	 * {@link OldValueClassFilterIncludingSubclasses}s inside, one matching
	 * <code>X</code>, the other matching <code>Y</code>. If only a single
	 * element is the old value of a {@link Notification}, the {@link AndFilter}
	 * matches the notification if and only if the old value conforms to both,
	 * <code>X</code> and <code>Y</code>, for example if its type is
	 * <code>Z</code>. However, if there are two elements in the old value
	 * collection of the {@link Notification}, one of type <code>X</code> and
	 * the other of type <code>Y</code>, the first
	 * {@link OldValueClassFilterIncludingSubclasses} matches because of the
	 * <code>X</code> element, and the second
	 * {@link OldValueClassFilterIncludingSubclasses} matches because of the
	 * <code>Y</code> element and hence the {@link AndFilter} matches. However,
	 * no single element in the old value collection fulfills both criteria.
	 */
    EventFilter createOldValueClassFilterIncludingSubclasses(EClass clazz);

	/**
	 * Creates a filter that matches an event's
	 * {@link Notification#getNewValue()} {@link EObject#eClass() class}. An
	 * exact match, not considering any inheritance relations, is required. If
	 * the {@link Notification#getNewValue() new value} is a collection, e.g.,
	 * because several elements were assigned to a many-feature at once, this
	 * filter matches if at least one of the elements' class is matched.
	 * <p>
	 * 
	 * When several such filters are combined in an {@link AndFilter}, the
	 * {@link AndFilter} matches if all of its operand filters match. This does
	 * not require the individual {@link NewValueClassFilter}s to match based on
	 * the same element in case the new value happens to be a collection. For
	 * example, assume there are two classes <code>X</code> and <code>Y</code>.
	 * Assume there is an {@link AndFiter} with two {@link NewValueClassFilter}s
	 * inside, one matching <code>X</code>, the other matching <code>Y</code>.
	 * If there are two elements in the new value collection of the
	 * {@link Notification}, one of type <code>X</code> and the other of type
	 * <code>Y</code>, the first {@link NewValueClassFilter} matches because of
	 * the <code>X</code> element, and the second {@link NewValueClassFilter}
	 * matches because of the <code>Y</code> element and hence the
	 * {@link AndFilter} matches. However, no single element in the new value
	 * collection fulfills both criteria.
	 */
    EventFilter createNewValueClassFilter(EClass clazz);

	/**
	 * Creates a filter that matches an event's
	 * {@link Notification#getNewValue()} {@link EObject#eClass() class} to
	 * <code>clazz</code> and all subclasses thereof. If the new value is a
	 * collection then this filter matches if at least one of the collection's
	 * elements is matched.
	 * <p>
	 * 
	 * When several such filters are combined in an {@link AndFilter}, the
	 * {@link AndFilter} matches if all of its operand filters match. This does
	 * not require the individual {@link NewValueClassFilterIncludingSubclasses}
	 * s to match based on the same element in case the new value happens to be
	 * a collection. For example, assume there are two classes <code>X</code>
	 * and <code>Y</code> with a class <code>Z</code> that has both,
	 * <code>X</code> and <code>Y</code> as its superclasses (multiple
	 * inheritance). Assume there is an {@link AndFiter} with two
	 * {@link NewValueClassFilterIncludingSubclasses}s inside, one matching
	 * <code>X</code>, the other matching <code>Y</code>. If only a single
	 * element is the new value of a {@link Notification}, the {@link AndFilter}
	 * matches the notification if and only if the new value conforms to both,
	 * <code>X</code> and <code>Y</code>, for example if its type is
	 * <code>Z</code>. However, if there are two elements in the new value
	 * collection of the {@link Notification}, one of type <code>X</code> and
	 * the other of type <code>Y</code>, the first
	 * {@link NewValueClassFilterIncludingSubclasses} matches because of the
	 * <code>X</code> element, and the second
	 * {@link NewValueClassFilterIncludingSubclasses} matches because of the
	 * <code>Y</code> element and hence the {@link AndFilter} matches. However,
	 * no single element in the new value collection fulfills both criteria.
	 */
    EventFilter createNewValueClassFilterIncludingSubclasses(EClass clazz);

	/**
	 * Constructs an {@link #createAndFilterFor(EventFilter...) AndFilter}
	 * combining a {@link #createClassFilter(EClass) ClassFilter} for
	 * <code>eClass</code> and a
	 * {@link #createStructuralFeatureFilter(EStructuralFeature) PropertyFilter}
	 * for <code>referredProperty</code>.
	 */
    EventFilter createFilterForEReference(EClass eClass, EReference referredProperty);

	/**
	 * Constructs an {@link #createAndFilterFor(EventFilter...) AndFilter}
	 * combining a {@link #createClassFilter(EClass) ClassFilter} for
	 * <code>eClass</code> and an
	 * {@link #createStructuralFeatureFilter(EStructuralFeature) PropertyFilter}
	 * for <code>referredProperty</code>.
	 */
    EventFilter createFilterForEAttribute(EClass eClass, EAttribute referredProperty);

	/**
	 * Creates an event filter that listens for events which indicate that an
	 * element of type <code>cls</code> has been added to the event manager's
	 * {@link ResourceSet}, either by directly assigning it to the immediate
	 * {@link Resource#getContents() contents} of a resource owned by the
	 * {@link ResourceSet}, or by assigning it to the containment reference of
	 * an element that is already part of the {@link ResourceSet}, or by adding
	 * a parent in the containment hierarchy to the {@link ResourceSet}.
	 */
    EventFilter createFilterForElementInsertion(EClass cls);

	/**
	 * Creates a filter tree, which will match if the given class get inserted
	 * or deleted by an event
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
    EventFilter createOrFilterFor(EventFilter... eventFilters);

	/**
	 * Creates an {@link AndFilter} for incoming {@link EventFilter}s. The
	 * resulting filter matches a {@link Notification} if and only if the
	 * {@link Notification} is matched by all <code>eventFilters</code>.
	 * 
	 * @param eventFilters
	 *            filter to combine with an <code>and</code>
	 * @return the created {@link AndFilter}
	 */
    EventFilter createAndFilterFor(EventFilter... eventFilters);

	/**
	 * If <code>event</code> indicates the setting/adding/removal of/to/from a
	 * containment reference, then it is expanded into a collection of event
	 * notifications that document the creation or, respectively, dismantling of
	 * the entire containment hierarchy.
	 * <p>
	 * 
	 * In any case, <code>event</code> is part of the collection returned.
	 */
    Collection<Notification> createNotificationForComposites(Notification event);

} // EventManagerFactory
