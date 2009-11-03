/**
 * The MOIN EventFilters represent a language to express the subset of events
 * that a listener wants to receive. They consist of "atomic" filter types and
 * the <code>LogicOperationFilters</code> which provide the possibility to
 * combine the atomic filters.<br>
 * <br>
 * <b> Getting Started Using MoinEventFilters:</b><br>
 * All filters can directly be instantiated using Java's <code>new</code>
 * operator. <br>
 * <H2>Example</H2><br>
 * <code>
 * // Create a filter for an event when a given model element is deleted<br>
 * MoinEventFilter myInstanceFilter = new InstanceFilter(elementMRI);<br>
 * MoinEventFilter myDeleteFilter = new EventTypeFilter(ElementDeleteEvent.class);<br>
 * AndFilter myAndFilter = new AndFilter(myInstanceFilter, myDeleteFilter);<br>
 * </code><br>
 * <br>
 * Most of the filters require some parameters when instantiating them. See
 * their JavaDocs for details. Combinig multiple filters can be done either at
 * creation time of the <code>LogicalOperationFilter</code> or later:<br>
 * <br>
 * <code>
 * LogicalOperationFilter anotherFilterTree = new ANDFilter(myEventTypeFilter,myFilterTree);<br>
 * myFilterTree.getOperands().add(myInstanceFilter);</code><br>
 * <br>
 * Be careful to never use a filter tree twice when registering a listener. The
 * tree is transformed while registration and the original reference to the root
 * of the tree might have become invalid. Use a deep clone of the tree if you
 * plan to reuse it:<br>
 * <br>
 * <code>MoinEventFilter deepClone = anotherFilterTree.cloneFilterTree();</code><br>
 * <br>
 * Note, that each filter can be negated either at creation time or later using
 * the <code>negate()</code> method. A negated filter or subtree will result in
 * the notification of all events except those the filter(tree) normally
 * expresses. But be careful, <b>a big number of negated registrations
 * dramatically affects the performance of the EventFramework, so only use this
 * option where really needed! </b> <br>
 * <br>
 * This API is for SAP-internal use only and subject to change
 */
package com.sap.tc.moin.repository.events.filter;