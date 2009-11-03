package com.sap.tc.moin.repository.ocl.registry;

import com.sap.tc.moin.repository.ocl.metamodel.OclMetamodelConstraintRegistry;

/**
 * This represents the "built-in" constraint categories provided by MOIN.
 * <p>
 * In general, the idea behind the categories is to make constraint checking
 * more flexible. The constraint checking API allows the application to trigger
 * constraint evaluation for all constraints assigned to a certain category.
 * Thus categories could be considered as "constraint checking synchronization
 * points". As categories can be defined freely, the meta modeler can design
 * such synchronization points in a very flexible way and even in a
 * domain-specific fashion.
 * <p>
 * The "evaluation policies" as defined by the MOF standard are handled as
 * "pseudo-categories" which are orthogonal to the domain-specific ones (each
 * constraint is attached to either the "immediate" or the "deferred" evaluation
 * policy and may be attached to any number (perhaps none) of domain-specific
 * categories).
 */
public enum OclRegistrationCategory {
    /**
     * The "deferred" category.
     * <p>
     * This is a pseudo-category mapping to the standard "deferred" evaluation
     * policy.
     */
    deferred,
    /**
     * The "immediate" category.
     * <p>
     * This is a pseudo-category mapping to the standard "immediate" evaluation
     * policy.
     */
    immediate,
    /**
     * the "virtual" category.
     * <p>
     * This is a pseudo-category used to identify hard-coded constraint checks,
     * most notably the "underflow" and "overflow" warnings and the name checks.
     * <p>
     * This can be used in the check API
     * {@link OclMetamodelConstraintRegistry#verifyConstraints(java.util.Set, java.util.Set)}
     * that use category filtering in order to include these checks.
     */
    virtual
}
