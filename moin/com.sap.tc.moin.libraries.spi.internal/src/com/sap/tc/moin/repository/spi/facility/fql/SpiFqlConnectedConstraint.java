package com.sap.tc.moin.repository.spi.facility.fql;

/**
 * An FqlConnectedCondition stands for a logical AND or OR connection of several
 * nested conditions (all on the same where entry)
 * 
 * @author D045917
 */
public interface SpiFqlConnectedConstraint extends SpiFqlLocalConstraint {

    /**
     * Returns at least 2 or more nested conditions which are logically
     * connected.
     */
    SpiFqlLocalConstraint[] getNestedConstraint( );

    /**
     * If true, the logical connection is OR, otherwise it is AND
     */
    boolean isOrConnected( );
}
