package com.sap.tc.moin.repository.ocl.metamodel;

import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.notification.ConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;

/**
 * This exposes the OCL metamodel constraints to interested clients.
 * <p>
 * Metamodel constraints are part of a metamodel and consist of an OCL
 * expression that must evaluate to a boolean value, an evaluation policy
 * ("immediate" or "deferred") and (specifically in MOIN) a Set of
 * <code>String</code>s called "categories" (see {@link OclRegistrationCategory}
 * ). Furthermore (also specifically in MOIN) it is possible to assign a
 * "severity" to each constraint (Error or Warning).
 * <p>
 * This registry is mainly intended to allow the application to get notified
 * about metamodel constraint violations. The following usage patterns for
 * constraint checks are supported:
 * <ul>
 * <li>Immediate, event-based (checks are executed for each model change event)</li>
 * <li>Deferred, event-based (model change events are collected and checks are
 * performed on request)</li>
 * <li>Partition based (checks are performed for complete partitions on request)
 * </li>
 * </ul>
 * The application must implement a listener that is notified once a constraint
 * violation is detected or it gets access to an object that can be used to
 * trigger the checks.
 * <p>
 * Registration is always for <em>all</em> constraints of the given category,
 * i.e. it is not possible to register for individual constraints. The detected
 * violation or violations are reported as {@link ConstraintViolationStatus}
 * that allows to access the errors and warnings with some detailed information.
 * <p>
 * The event-based usage patterns can be used by tools to check their models
 * while they are edited.
 * <p>
 * Note that the immediate event-based usage pattern (
 * {@link #registerImmediateConstraintViolationListener(String, ImmediateConstraintViolationListener)}
 * may easily run into performance issues as the number of model change events
 * and model elements that have to be evaluated can become quite large during
 * complex model manipulation operations and the checks are performed for each
 * event. Hence this usage pattern should be used with care.
 * <p>
 * Note that "immediate" constraints are not checked by the MOIN infrastructure.
 * However, the immediate event-based scenario allows to get an immediate
 * notification for constraint violations, and the application has to take
 * proper action upon violation of immediate constraints.
 * <p>
 * The deferred event-based pattern (
 * {@link #registerDeferredConstraintViolationListenerForEvents(String, DeferredConstraintViolationListener)}
 * ) uses a checker object to collect the model change events that are triggered
 * while the model is edited. Eventually, the application calls the
 * {@link OclRegistryService#analyzeCollectedEvents(String)} method which
 * provides the violation status.
 * <p>
 * The partition based usage pattern (
 * {@link #registerPartitionBasedConstraintViolationListener(String, DeferredConstraintViolationListener)}
 * ) is to be used to check consistency of complete model partitions against the
 * metamodel constraints. Obviously, the number for checks that have to be
 * performed in this scenario can become quite large, and use of this pattern
 * must be limited to well-defined status transitions in the partition life
 * cycle.
 * <p>
 * In a proper implementation, consistency checks will have to be done both on
 * partition and on event level. For example, a partition may well be
 * inconsistent before editing, and these inconsistencies will not necessarily
 * detected during the event based checks. On the other hand, even though the
 * partition might have been consistent before editing and all constraints were
 * checked during editing (ensuring "local" consistency), partition based checks
 * might reveal new inconsistencies once this partition is activated.
 * <p>
 * All scenarios above use the so-called Impact Analysis to optimize the number
 * for instances for evaluation. In the partition-based scenario, however, no
 * instance scope analysis can be performed (since no model change events are
 * available on which information about the changed model instances is
 * available), so all instances for all affected classes must be evaluated.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OclMetamodelConstraintRegistry {

    /**
     * Register an event-based, immediate listener.
     * <p>
     * Violations will be reported after each model change event. Note that this
     * will throw an Exception when trying to register for category "immediate"
     * as such a registration makes no sense (this category is already checked
     * immediately by the MOIN Core and corresponding events will be vetoed).
     * 
     * @param category any existing category except
     * {@link OclRegistrationCategory#immediate}
     * @param listener the listener
     * @return see {@link Set#add(Object)}
     * @throws IllegalArgumentException when trying to register for the
     * {@link OclRegistrationCategory#immediate} category
     */
    public boolean registerImmediateConstraintViolationListener( String category, ImmediateConstraintViolationListener listener ) throws IllegalArgumentException;

    /**
     * Register a partition based listener.
     * <p>
     * Violations will be reported after a call to
     * {@link OclRegistryService#analyzeModelPartitions(String, Set)}.
     * 
     * @param category any existing category, including the ones defined in
     * {@link OclRegistrationCategory}
     * @param listener the listener
     * @return see {@link Set#add(Object)}
     */
    public boolean registerPartitionBasedConstraintViolationListener( String category, DeferredConstraintViolationListener listener );

    /**
     * Unregister the listener.
     * 
     * @param listener the listener
     * @return see {@link Set#remove(Object)}
     */
    public boolean unregisterDeferredListener( DeferredConstraintViolationListener listener );

    /**
     * Unregister the listener.
     * 
     * @param listener the listener
     * @return see {@link Set#remove(Object)}
     */
    public boolean unregisterImmediateListener( ImmediateConstraintViolationListener listener );

    /**
     * @return The available metamodel constraints
     * @throws OclConstraintManagerException indicates an internal problem
     */
    public Set<OclMetaModelConstraintRegistration> getAvailableMetamodelConstraints( ) throws OclConstraintManagerException;

    /**
     * @param category category
     * @param listener listener
     * @return see {@link Set#add(Object)}
     */
    public boolean registerDeferredConstraintViolationListenerForEvents( String category, DeferredConstraintViolationListener listener );

    /**
     * @return the registry (the mapping between categories and constraint
     * registrations
     * @throws OclManagerException indicates an internal problem
     */
    public Map<String, Set<OclMetaModelConstraintRegistration>> getRegistry( ) throws OclManagerException;

    /**
     * Checks a set of {@link ModelPartition}s against a set of categories.
     * <p>
     * Note that the {@link OclRegistrationCategory#virtual} category must be
     * specified explicitly in order to include the hard-coded constraints (most
     * notably, these are the "underflow", "overflow", and name checks) unless
     * the set of categories already contains the
     * {@link OclRegistrationCategory#deferred} entry, otherwise the hard-coded
     * checks will not be performed.
     * <p>
     * Internally, this will execute
     * {@link RefBaseObject#refVerifyConstraints(boolean)} for all objects in
     * the set of partitions, but only for the constraints that belong to at
     * least one of the categories provided.
     * <p>
     * <em>
     * If the set of categories is empty contains <b>only</b> the
     * {@link OclRegistrationCategory#virtual} category, all constraints will be
     * checked. </em>
     * 
     * @param pris the partitions to check
     * @param categories the categories to check; if empty, all categories are
     * checked; may contain the pseudo-categories
     * {@link OclRegistrationCategory#immediate},
     * {@link OclRegistrationCategory#deferred}, and
     * {@link OclRegistrationCategory#virtual} (use the <code>name()</code>
     * method to convert these into the corresponding <code>String</code>s).
     * @return the status, may be empty
     * @throws OclManagerException indicates internal problems
     */
    public DeferredConstraintViolationStatus verifyConstraints( Set<PRI> pris, Set<String> categories ) throws OclManagerException;
}
