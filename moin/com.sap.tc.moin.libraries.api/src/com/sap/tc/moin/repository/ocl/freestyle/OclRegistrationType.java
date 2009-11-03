package com.sap.tc.moin.repository.ocl.freestyle;


/**
 * Registration types.
 * <p>
 * The {@link OclFreestyleRegistry} allows creation of different types of
 * {@link OclRegistration}s. This enumerates the supported types.
 */
public enum OclRegistrationType {
    /**
     * Registrations of type {@link OclInvariantRegistration}.
     * <p>
     * Invariants are OCL expressions which are evaluated in the context of a
     * class and evaluate to a <code>boolean</code> value. If the expression
     * evaluates to false, this is considered a constraint violation.
     */
    Invariant,
    /**
     * Registrations of type {@link OclExpressionRegistration}.
     * <p>
     * Arbitrary OCL expressions are evaluated in an arbitrary context (and
     * perhaps even without a context) and evaluate to arbitrary values. The
     * returned value is either an instance of a <code>ModelElement</code>,
     * an instance of one of the Primitive Types defined in MOF or a (possibly
     * empty) <code>Collection</code> of such instances (if the return value
     * is not of multiplicity 1).
     */
    Expression,
    /**
     * Registration of type {@link JavaCodedConstraintRegistration}.
     * <p>
     * Some constraints are not modeled as "OCL" constraints, but instead
     * checked using Java coding.
     */
    JavaConstraint
}
