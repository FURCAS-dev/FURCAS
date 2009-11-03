package com.sap.tc.moin.repository.spi.facility.fql;


/**
 * An FqlConstraint is a local constraint over the query entry. It has several
 * forms as indicated by the subtypes of this interface.
 * 
 * @author D045917
 */
public interface SpiFqlLocalConstraint {

    /**
     * The owning query entry of this condition.
     */
    SpiFqlQueryEntry getFqlQueryEntry( );
}
