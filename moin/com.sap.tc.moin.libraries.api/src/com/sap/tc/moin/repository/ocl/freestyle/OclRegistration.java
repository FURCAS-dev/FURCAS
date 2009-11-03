package com.sap.tc.moin.repository.ocl.freestyle;

import java.util.Set;

import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

/**
 * This is the base interface for objects in the {@link OclFreestyleRegistry}.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OclRegistration {

    /**
     * The registration name.
     * <p>
     * For MOF and metamodel constraints, this is a <code>String</code>
     * representation of the qualified name of the constraint within the meta
     * model, for other {@link OclRegistration} objects, this name is provided
     * by the registering application.
     * 
     * @return the name
     */
    public String getName( );

    /**
     * The OCL expression underlying this {@link OclRegistration}.
     * 
     * @return the OCL Expression as String
     */
    public String getOclExpression( );

    /**
     * The registration type.
     * 
     * @return the type
     */
    public OclRegistrationType getType( );

    /**
     * @return the severity
     */
    public OclRegistrationSeverity getSeverity( );

    /**
     * The categories Contains at least one of the pseudo-categories
     * {@link OclRegistrationCategory#immediate} or
     * {@link OclRegistrationCategory#deferred} and any number of additional
     * categories. Note that MOF Constraints do not support additional
     * categories.
     * 
     * @return the categories
     */
    public Set<String> getCategories( );

    /**
     * TODO we need to have something like a (language dependent?) long text and
     * error text
     */

}
