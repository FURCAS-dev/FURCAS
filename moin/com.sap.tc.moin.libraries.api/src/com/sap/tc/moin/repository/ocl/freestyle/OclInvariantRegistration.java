package com.sap.tc.moin.repository.ocl.freestyle;

/**
 * This is the registration for OCL expressions of type "class invariant".
 * <p>
 * At Runtime, this represents an OCL expression that evaluates to a boolean
 * value. If the expression evaluates to false, this is considered a constraint
 * violation. This interface is empty, as the listener registration is done
 * through {@link OclFreestyleRegistry}.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OclInvariantRegistration extends OclRegistration {
    // empty indeed
}
