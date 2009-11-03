package com.sap.tc.moin.repository.spi.facility.fql;


/**
 * A selection indicates whether a query entry from an FQL entry is part of the
 * result set.
 * 
 * @author D045917
 */
public interface SpiFqlSelection {

    /**
     * Each FqlSelection is owned by a QueryEntry. At least the MRIs for the
     * entry will be part of the facility result set.
     */
    SpiFqlQueryEntry getOwningQueryEntry( );

    /**
     * Returns 0 or more attribute selections. These will be part of the result
     * set on top of the actual returning element.
     */
    SpiFqlAttributeSelection[] getAttributeSelections( );
}
