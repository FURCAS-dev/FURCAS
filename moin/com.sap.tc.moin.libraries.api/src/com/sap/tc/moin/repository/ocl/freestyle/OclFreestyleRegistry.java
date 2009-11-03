package com.sap.tc.moin.repository.ocl.freestyle;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

/**
 * The registry that allows an application to register its own OCL expressions
 * and to access the metamodel constraint registry.
 * <p>
 * The registry is linked to a MOIN Session; once the MOIN session is destroyed,
 * the registry will no longer be available.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OclFreestyleRegistry {

    /**
     * The registration names.
     * <p>
     * Can be used to retrieve the registrations
     * {@link #getRegistration(String)}).
     * 
     * @return the available registration names or an empty Set
     */
    public Set<String> getRegistrationNames( );

    /**
     * Creates an OclInvariantRegistration.
     * 
     * @param name the application defined name, must be unique within the
     * session
     * @param oclExpression the OCL expression as String, must be parsable to an
     * invariant
     * @param severity will be reported to the listeners
     * @param categories the categories for this registration, must not be empty
     * @param parsingContext the context used to parse the OCL expression
     * @param typesPackages the {@link RefPackage}s in which the parser can
     * lookup types
     * @return the registration
     * @throws OclManagerException if the expression can not be parsed or if a
     * registration with this name already exists of if no categories are
     * provided
     */
    public OclInvariantRegistration createInvariantRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefClass parsingContext, RefPackage[] typesPackages ) throws OclManagerException;

    /**
     * Creates an OclExpressionRegistration.
     * 
     * @param name the application defined name, must be unique within the
     * session
     * @param oclExpression the OCL expression as String
     * @param severity will be reported to the listeners
     * @param categories the categories for this registration, must not be empty
     * @param parsingContextMetaClass the context used to parse the OCL expression
     * @param typesPackages the {@link RefPackage}s in which the parser can
     * lookup types
     * @return the registration
     * @throws OclManagerException if the expression can not be parsed or if a
     * registration with this name already exists of if no categories are
     * provided
     */
    public OclExpressionRegistration createExpressionRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefObject parsingContextMetaClass, RefPackage[] typesPackages ) throws OclManagerException;
    
    /**
     * Creates an OclExpressionRegistration.
     * 
     * @param name the application defined name, must be unique within the
     * session
     * @param oclExpression the OCL expression as String
     * @param severity will be reported to the listeners
     * @param categories the categories for this registration, must not be empty
     * @param parsingContext the context used to parse the OCL expression
     * @param typesPackages the {@link RefPackage}s in which the parser can
     * lookup types
     * @return the registration
     * @throws OclManagerException if the expression can not be parsed or if a
     * registration with this name already exists of if no categories are
     * provided
     */
    public OclExpressionRegistration createExpressionRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefClass parsingContext, RefPackage[] typesPackages ) throws OclManagerException;

    /**
     * Gets an existing registration by its name.
     * 
     * @param name the name of the registration
     * @return the registration, or null
     */
    public OclRegistration getRegistration( String name );

    /**
     * Close and remove an existing registration.
     * <p>
     * Does nothing if the registration does not exist.
     * 
     * @param name the name of the registration
     * @return true if a registration was deleted
     * @throws OclManagerException upon internal problems
     */
    public boolean deleteRegistration( String name ) throws OclManagerException;

    /**
     * Registers an event-based, immediate constraint violation listener for a
     * category.
     * <p>
     * Note that this listener will only be notified about constraint
     * violations, even if {@link OclExpressionRegistration}s may be registered
     * for the given category.
     * <p>
     * Violations will be reported after each model change event. This should be
     * used with care to avoid performance issues.
     * <p>
     * Note that this will throw an Exception when trying to register for
     * category "immediate" as such a registration makes no sense (this category
     * is already checked immediately by the MOIN Core and corresponding model
     * change events will be vetoed).
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
     * Registers a partition-based constraint violation listener for a category.
     * <p>
     * Note that this listener will only be notified about constraint
     * violations, even if {@link OclExpressionRegistration}s may be registered
     * for the given category.
     * <p>
     * Violations will be reported after calling
     * {@link OclRegistryService#analyzeModelPartitions(String, Set)}.
     * 
     * @param category any category
     * @param listener the listener
     * @return see {@link Set#add(Object)}
     */
    public boolean registerDeferredConstraintViolationListenerForPartitions( String category, DeferredConstraintViolationListener listener );

    /**
     * Registers an event-based, deferred cosntraint violation listener for a
     * category.
     * <p>
     * Note that this listener will only be notified about constraint
     * violations, even if {@link OclExpressionRegistration}s may be registered
     * for the given category.
     * <p>
     * Model change events from the event framework will be collected and
     * violations will be reported after calling
     * {@link OclRegistryService#analyzeCollectedEvents(String)}.
     * <p>
     * Note that this will throw an Exception when trying to register for
     * category "immediate" as such a registration makes no sense (this category
     * is already checked immediately by the MOIN Core and corresponding model
     * change events will be vetoed).
     * 
     * @param category any existing category except
     * {@link OclRegistrationCategory#immediate}
     * @param listener the listener
     * @throws IllegalArgumentException when trying to register for the
     * {@link OclRegistrationCategory#immediate} category
     * @return see {@link Set#add(Object)}
     */
    public boolean registerDeferredConstraintViolationListenerForEvents( String category, DeferredConstraintViolationListener listener ) throws IllegalArgumentException;

    /**
     * Unregisters the listener
     * 
     * @param listener the listener to unregister
     * @return see {@link Set#remove(Object)}
     */
    public boolean unregisterDeferredConstraintViolationListener( DeferredConstraintViolationListener listener );

    /**
     * Unregister the listener
     * 
     * @param listener the listener to unregister
     * @return see {@link Set#add(Object)}
     */
    public boolean unregisterImmediateConstraintViolationListener( ImmediateConstraintViolationListener listener );

}
