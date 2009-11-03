package com.sap.tc.moin.repository.jmigenerator.template;

/**
 * Reference abstraction
 */
public interface JmiGeneratorReference {

    /**
     * @return <code>true</code> if the reference exposes a derived
     * association
     */
    public Boolean isAssociationDerived( );

    /**
     * @return <code>true</code> if both ends of the association are
     * changeable
     */
    public Boolean bothEndsChangeable( );

    /**
     * @return <code>true</code> if the exposed end of the association is the
     * "0" end
     */
    public Boolean exposedAssocEndIsEnd0( );
}
