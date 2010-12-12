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
package org.eclipse.ocl.examples.eventmanager.framework;

/**
 * This package contains the core of the EventFramework implementation. It mainly consists of three parts:
 * <ul>
 * <li>The <code>SessionEventManager</code> (which implements both interfaces the EventFramework provides to clients
 * and to the repository core)</li>
 * <li>The <code>RegistrationManager</code> (which manages the <code>Registrations</code> using the
 * <code>EventFilterTables</code>)</li>
 * <li>The <code>EventFilterTables</code> (which store the <code>Registrations</code> and provide all
 * <code>Registrations</code> that might be interested in a notification)</li>
 * </ul>
 * <br>
 * <br>
 * <b>A brief overview of the core mechanisms:</b><br>
 * <br>
 * <b>Registering new Listeners:</b><br>
 * When a new listener is registered using the appropriate method on the <code>EventManager</code> interface, the
 * SessionEventManager assigns the matching <code>Notifier</code> and delegates the registration to its
 * <code>RegistrationManager</code>. The <code>Notifier</code> encapsulates the knowledge how to notify the
 * listeners. <code>CommitListeners</code> for example do not want to get notified directly, but when the command was
 * committed.<br>
 * The <code>RegistrationManager</code> does the main work: First, it transforms the passed tree of
 * <code>EventFilters</code> into the disjunctive normal form. This means, that the resulting tree has a depth of 2
 * and consists of an <code>ORFilter</code> at the root which connects multiple <code>ANDFilters</code> which
 * connect the atomic leaves (the real filters) of the tree. This is needed due to the fact, that the algorithm that
 * computes all affected registrations for an event is only able to implement AND conjunctions, but no logical OR. The
 * logical OR is emulated by a split-up into one <code>Registration</code> per operand of the root filter. Each atomic
 * filter then is registered in its associated <code>EventFitlerTable</code> (there is a 1 to 1 mapping of the filter
 * type to the type of the FilterTable). Afterwards, all <code>Registrations</code> that were created during one
 * registration call are pooled in a <code>RegistrationSet</code> in order to be able to distinguish between a
 * listener that registered once using a logical OR and a listener that registered twice without an OR.<br>
 * The <code>EventFilterTable</code> connects the filter's criterion with the associated <code>Registrations</code>.
 * There are two sets of Registrations associated with the filter criterion: The RegistrationSet (all registrations
 * registered for the criterion) and the NegatedRegistrationSet (all registrations registered for "NOT the filter
 * criterion"). <br>
 * <br>
 * <b>Computing the Set of affected registrations in the context of an event:</b><br>
 * The <code>SessionEventManager</code> delegates the computation to the RegistrationManager. Afterwards it orders the
 * associated <code>Notifier</code> to notify its listener.<br>
 * The RegistrationManager asks all affected <code>EventFilterTables</code> for their contribution. (There is a 1 to n
 * mapping of the event types to the types of the filter tables.) All the mappings of the <code>EventFilterTables</code>
 * are realized in the init() method of a subclass of <code>RegistrationManager</code>, called
 * <code>SessionRegistrationManager</code>. Each <code>EventFilterTable</code> can contibute 2 sets of
 * Registrations for an event: The <code>Registrations</code> for an event and the negated Registrations for an event
 * (these sets do not only consist of RegistrationSet and NegatedRegistrationSet). The <code>RegistrationManager</code>
 * then merges all "<code>Registrations</code> for the event" into one set and deletes all "negated
 * <code>Registrations</code> for the event". Then, all <code>Registrations</code> that are contained in the same
 * <code>RegistrationSet</code> are pooled. As each <code>Registration</code> knows its associated
 * <code>Listener</code>, the <code>RegistrationManager</code> can easily return the set of affected listeners.<br>
 * Each <code>EventFilterTable</code> knows which information to extract from the passed event (this is the
 * information that can be compared with the filter criterion). The "<code>Registrations</code> for an event" consist of
 * the RegistrationSet of the matching filter criterion plus the NegatedRegistrationSets of all other registered criterions.
 * The "negated <code>Registrations</code> for an event" consist of the NegatedRegistrationSet that is associated with the 
 * matching filter criterion plus all RegistrationSets of all other filter criterions. Due to performance reasons, this logic
 * is encapsulated in the <code>RegistrationIterator</code>, so that no sets have to be copied. 
 */

