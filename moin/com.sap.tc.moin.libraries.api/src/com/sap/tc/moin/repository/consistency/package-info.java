/**
 * Interfaces for handling inconsistencies. The central entry point for the
 * inconsistency handling is {@link ConsistencyViolationListenerRegistry}.
 * <p>
 * The registry allows to register listeners for consistency violations. In
 * addition, it provides an explicit consistency check for partitions and an API
 * for applying corrections.<br>
 * The registry is attached to the session. It can be obtained by calling
 * {@link Connection#getConsistencyViolationListenerRegistry()}.
 * </p>
 * <h2>Types of inconsistencies</h2>
 * <p>
 * There are different types of inconsistencies that can occur. MOIN can
 * currently handle the two most common types only.
 * </p>
 * <h3>Duplicate elements</h3>
 * <p>
 * Normally, the mof ids of model elements are unique. This means that an
 * element with the same mof id can only occur once. Using the MOIN API, it is
 * not possible to create two elements with the same mof id.<br>
 * Nevertheless, it is possible to create an element twice by manipulating the
 * model data somewhere else, for example by copying files in the file system
 * persistence.
 * </p>
 * <h3>Dangling associations/links</h3>
 * <p>
 * Using the API, it is not possible to create associations of which only one
 * end exists. When an element is deleted, all associations are removed as well.
 * <br>
 * Anyhow, in the same way as for duplicate elements, it can happen that
 * association ends are missing due to non-API-manipulations of the model data.
 * </p>
 * <h3>Duplicate composite parents</h3>
 * <p>
 * According to the MOF constraints, an element can only have one composite
 * parent. In certain scenarios, it can happen that two composite parents point
 * to the same component.
 * </p>
 * <h3>Association permission problems</h3>
 * <p>
 * An instance of an association can refer to elements in another partition
 * (cross partition link). If this partition is located in another container, it
 * can happen that references to this container are no longer allowed, for
 * example because the dependency declaration has been changed after the
 * association instance was created.
 * </p>
 * <h2>Handling of inconsistencies</h2>
 * <p>
 * The MOIN core behaves robust against inconsistencies. Standard operations as
 * deleting and adding elements continue working with inconsistent content.
 * </p>
 * <p>
 * Depending on the nature of the inconsistencies, the data that is returned by
 * MOIN can be unexpected.
 * </p>
 * <h3>Duplicate elements</h3>
 * <p>
 * If an element with the same mof id occurs twice, meaning in two different
 * partitions, MOIN returns one of them (randomly). MOIN <a
 * href="#eventing">records</a> a consistency violation for each dupliate and
 * throws as many <a href="#eventing">events</a>, for example if an element
 * occurs three times, MOIN records three consistency violations.<br>
 * The element MOIN has chosen to return, is <b>always</b> returned, for all
 * operations.<br>
 * The only exception is the deletion of composites. If there are components in
 * the same partition as the composite to be deleted, these components are
 * deleted, even if these were not the ones returned when getting the components
 * from the parent.<br>
 * </p>
 * <p>
 * <b>Example 1:</b><br>
 * An element A is to be deleted. The element has one component B that occurs
 * twice (B1 and B2). When A is deleted, all components are also deleted. If
 * MOIN has chosen B2 to work with, only B2 will be deleted. B1 will not be
 * deleted and remains as orphan.<br>
 * <img src="doc-files/DoubleStorageOneDuplicateDeletion.gif"/><br>
 * <b>Example 2</b><br>
 * An element A with components in the same partition is to be deleted. The
 * element is a duplicate itself. Its components are also duplicated. If element
 * A is explicitely deleted from the copied partition, the component will also
 * be deleted from this partition. <br>
 * <img src="doc-files/DoubleStorageTwoDuplicatesDeletion.gif"/><br>
 * </p>
 * <h3>Dangling associations</h3>
 * <p>
 * If an end of an association that does not exist is to be resolved, MOIN
 * returns <code>null</code>. MOIN <a href="#eventing">records</a> one
 * consistency violation.
 * </p>
 * <h3>Duplicate parents</h3>
 * <p>
 * In case there are two composite parents existing for an element, MOIN chooses
 * one of the parents to be used so that the model can be loaded. MOIN <a
 * href="#eventing">records</a> two consistency violations, one for each of the
 * duplicate parents.
 * </p>
 * <h3>Association permission problems</h3>
 * <p>
 * If a dependency from one container to the other has been removed and an
 * association instance violates the new dependency restrictions, MOIN ignores
 * the restrictions but <a href="#eventing">records</a> a consistency violation.
 * </p>
 * <h2><a name="eventing">Recording of inconsistencies and consistency violation
 * eventing</a></h2>
 * <p>
 * Unless triggered, MOIN does not do an explicit consistency check. The
 * inconsistencies that occur while navigating through a model are recorded in
 * the consistency violation registry. If a listener has registered itself at
 * the consistency violation registry, its listener methods are called when an
 * inconsistency occurs or is resolved. The consistency violation is passed as
 * {@link ConsistencyViolation}. Since the consistency violation registry is
 * bound to the session, the consistency violation will not necessarily be
 * visible in other connections until someone does the same navigation steps
 * there as well.
 * </p>
 * <h2>Consistency correction</h2>
 * <p>
 * In general, it is recommended to correct inconsistencies in the same was as
 * they were created, for example by updating faulty files with the correct
 * (consistent) version in the persistence.<br>
 * As additional way to resolve inconsistencies, MOIN provides correction
 * handles to fix the inconsistencies.
 * </p>
 * <h3>Consistency correction handles</h3>
 * <p>
 * By calling {@link ConsistencyViolation#getCorrectionHandles()}, it is
 * possible to get a set of correction handles, containing a description and a
 * correction id ({@link ConsistencyCorrectionHandle#getId()}). The correction
 * can be applied by calling {@link #applyCorrection(String)} with the
 * correction id.<br>
 * The correction can be made using any connection. All other connections will
 * be updated by cross session events. As long as another connection locks the
 * affected partition, there will be a conflict, of course.
 * </p>
 * <h2>Impact on the JMI API</h2>
 * <p>
 * Even if the model data is inconsistent, it is intended that the API behaves
 * as normal as possible.
 * </p>
 * <h3>Duplicate elements</h3>
 * <p>
 * In case of duplicate elements, MOIN returns one of the duplicates, chosen by
 * random.
 * </p>
 * <h3>Dangling associations</h3>
 * <p>
 * In case of dangling associations, MOIN returns <code>null</code> when
 * resolving the missing end. This means that a getter method might return
 * <code>null</code> although the result should be non-null according to the
 * metamodel. The same applies to returned lists. Although a call of
 * {@link Iterator#next()} should not return <code>null</code>, this is very
 * well possible in case of missing association ends.
 * </p>
 * <h3>Duplicate composite parents</h3>
 * <p>
 * In case of duplicate composite parents, MOIN chooses one of the parents to
 * load the model.
 * </p>
 * <h3>Association permission problems</h3>
 * <p>
 * MOIN ignores dependency restrictions between different containers but shows a
 * problem message.
 * </p>
 * <h2>Performance impact</h2>
 * <p>
 * As long as there are no consistency violations, there is no impact on the
 * performance. If there are inconsistencies, the performance slightly decreases
 * since it is more complicated to resolve the right elements then.
 * </p>
 * <h1>JMX</h1>
 * <p>
 * The state of the consistency violation registry can be checked using the JMX
 * MBean of the session. It is also possible to trace if a new consistency
 * violation occured or if a consistency violation was fixed.
 * </p>
 * <br>
 * <br>
 * This API is for SAP-internal use only and subject to change
 */
package com.sap.tc.moin.repository.consistency;