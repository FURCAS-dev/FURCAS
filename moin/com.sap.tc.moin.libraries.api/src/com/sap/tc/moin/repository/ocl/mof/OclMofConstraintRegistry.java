package com.sap.tc.moin.repository.ocl.mof;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;

/**
 * This exposes the OCL MOIN and MOF constraints to interested clients.
 * <p>
 * MOIN and MOF constraints are part of the MOF meta model and consist of an OCL
 * expression that must evaluate to a boolean value and an evaluation policy
 * ("immediate" or "deferred").
 * <p>
 * This interface allows the application to get notified about violations of
 * these constraints. The following usage patterns for constraint checks are
 * supported:
 * <ul>
 * <li>Deferred, event-based (model change events are collected and checks are
 * performed on request)</li>
 * <li>Partition based (checks are performed for complete meta model partitions
 * on request)</li>
 * </ul>
 * For the event-based scenario, the application must implement a listener that
 * is notified once a constraint violation is detected (see
 * {@link #registerDeferredConstraintViolationListenerForEvents(DeferredConstraintViolationListener, OclRegistrationCategory...)}
 * ). An internal object is used to collect the model change events that are
 * triggered while the meta model is edited. Eventually, the application calls
 * the {@link #analyzeCollectedEvents(OclRegistrationCategory...)} method which
 * provides the violation status.
 * <p>
 * Note that the so-called immediate constraints are not checked by the MOIN
 * infrastructure, so it is up to the application to register a listener for the
 * immediate category and do the checks at suitable points in time.
 * <p>
 * It is important to notice that the events that have been collected are kept
 * in memory until the application calls
 * {@link #resetEvents(OclRegistrationCategory...)}.
 * <p>
 * The partition based usage pattern (
 * {@link #analyzeMetamodelPartitions(Set, OclRegistrationCategory...)}) is to
 * be used to check consistency of complete meta model partitions against the
 * MOF constraints (immediate and deferred). Obviously, the number for checks
 * that have to be performed in this scenario can become quite large, and use of
 * this pattern must be limited to well-defined status transitions in the
 * partition life cycle.
 * <p>
 * In a proper implementation, consistency checks will have to be done both on
 * partition and on event level. For example, a partition may well be
 * inconsistent before editing, and these inconsistencies will not necessarily
 * be detected during the event based checks. On the other hand, even though the
 * partition might have been consistent before editing and all constraints were
 * checked during editing (ensuring "local" consistency), partition based checks
 * might reveal new inconsistencies once this partition is activated.
 * <p>
 * All scenarios above use the so-called Impact Analysis to optimize the number
 * for instances for evaluation. In the partition-based scenario, however, no
 * instance scope analysis can be performed (since no model change events are
 * available from which information about the changed model instances could be
 * obtained), so all instances for all affected classes must be evaluated.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OclMofConstraintRegistry {

    /**
     * @return The available MOIN and MOF constraints
     * @throws OclConstraintManagerException indicates an internal problem
     */
    public Set<OclMetaModelConstraintRegistration> getAvailableMofConstraints( ) throws OclConstraintManagerException;

    /**
     * Triggers MOF constraint checks for a set of meta model partitions
     * 
     * @param partitionPris the meta model partition PRIs to check
     * @param category the categories to check (maps to Evaluation policy)
     * @return the violation status (may be empty)
     * @throws OclManagerException indicates an internal problem
     */
    public DeferredConstraintViolationStatus analyzeMetamodelPartitions( Set<PRI> partitionPris, OclRegistrationCategory... category ) throws OclManagerException;

    /**
     * Listener registration.
     * <p>
     * Note that event collection will only start after this registration.
     * 
     * @param category the categories, which map to the evaluation policy, one
     * of {@link OclRegistrationCategory#immediate} or
     * {@link OclRegistrationCategory#deferred}.
     * <p>
     * Note that you can register the same listener for both immediate and
     * deferred constraints by calling this method twice with the same listener
     * instance.
     * @param listener the listener to be notified
     * @return see {@link Set#add(Object)}
     */
    public boolean registerDeferredConstraintViolationListenerForEvents( DeferredConstraintViolationListener listener, OclRegistrationCategory... category );

    /**
     * Unregisters a listener.
     * <p>
     * If the listener was registered on both immediate and deferred categories,
     * it will be removed from both.
     * 
     * @param listener the listener
     * @return see {@link Set#remove(Object)}
     */
    public boolean unregisterDeferredConstraintViolationListener( DeferredConstraintViolationListener listener );

    /**
     * Registers an immediate listener for immediate constraints.
     * <p>
     * As opposed to the deferred listeners which are notified upon
     * {@link #analyzeCollectedEvents(OclRegistrationCategory...)}, a listener
     * registered here will be notified whenever a relevant event for an
     * immediate constraint was emitted
     * 
     * @param listener the listener to be notified
     * @return see {@link Set#add(Object)}
     */
    public boolean registerImmediateConstraintViolationListener( ImmediateConstraintViolationListener listener );

    /**
     * Unregisters a listener.
     * 
     * @param listener the listener
     * @return see {@link Set#remove(Object)}
     */
    public boolean unregisterImmediateConstraintViolationListener( ImmediateConstraintViolationListener listener );

    /**
     * Trigger deferred constraint checks on the collected events.
     * 
     * @param category the categories (map to Evaluation Policy)
     * @throws OclManagerException indicates an internal problem
     */
    public void analyzeCollectedEvents( OclRegistrationCategory... category ) throws OclManagerException;

    /**
     * For the event-based checks, events are accumulated in a buffer and
     * subsequent evaluations will take all these events into account until the
     * event cache is cleared with this method.
     * <p>
     * Does nothing if no listeners have been registered
     * 
     * @param category the categories (evaluation policy)
     * @throws OclManagerException indicates an internal problem
     */
    public void resetEvents( OclRegistrationCategory... category ) throws OclManagerException;

    /**
     * Checks a set of (Metamodel-){@link ModelPartition}s against a set of
     * {@link OclRegistrationCategory}s.
     * <p>
     * Internally, this will execute
     * {@link RefBaseObject#refVerifyConstraints(boolean)} for all objects in
     * the set of partitions, but only for the constraints that belong to at
     * least one of the categories provided.
     * <p>
     * The set or {@link PRI} should contain metamodel partition PRIs.
     * <p>
     * For each partition, the constraints belonging to any of the categories
     * are checked.
     * <p>
     * <em>
     * Note that if the set of categories is empty, all constraints will be
     * checked.
     * </em>
     * 
     * @param pris the partitions to check
     * @param categories the categories to check; if empty, all categories are
     * checked; may contain the pseudo-categories
     * {@link OclRegistrationCategory#deferred} and
     * {@link OclRegistrationCategory#immediate}
     * @return the status, may be empty
     * @throws OclManagerException indicates internal problems
     */
    public DeferredConstraintViolationStatus verifyConstraints( Set<PRI> pris, Set<OclRegistrationCategory> categories ) throws OclManagerException;

}
