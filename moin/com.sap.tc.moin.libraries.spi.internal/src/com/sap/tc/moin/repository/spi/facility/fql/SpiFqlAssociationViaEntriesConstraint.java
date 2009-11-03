package com.sap.tc.moin.repository.spi.facility.fql;


/**
 * This association-based join constraint is set up between two query entries.
 * 
 * @author D045917
 */
public interface SpiFqlAssociationViaEntriesConstraint extends SpiFqlAssociationConstraint {

    /**
     * Returns the query entry for the to-side
     */
    SpiFqlQueryEntry getToEndEntry( );

}
