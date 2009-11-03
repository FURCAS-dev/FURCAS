package com.sap.tc.moin.repository.spi.facility.fql;

/**
 * An FqlNotConstraint simply negates the nested constraint
 * 
 * @author D045917
 */
public interface SpiFqlNotConstraint extends SpiFqlLocalConstraint {

    /**
     * Returns the nested constraint, which is negated by this constraint
     */
    SpiFqlLocalConstraint getNestedConstraint( );
}
