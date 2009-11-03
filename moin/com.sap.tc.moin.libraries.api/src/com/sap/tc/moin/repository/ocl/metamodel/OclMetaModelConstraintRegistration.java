package com.sap.tc.moin.repository.ocl.metamodel;

import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;

/**
 * Metamodel Constraint specific information
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OclMetaModelConstraintRegistration extends OclRegistration {

    /**
     * @return the qualified name
     */
    public List<String> getQualifiedName( );

    /**
     * @return the names of the constrained elements
     */
    public Set<String> getConstrainedElements( );

}
