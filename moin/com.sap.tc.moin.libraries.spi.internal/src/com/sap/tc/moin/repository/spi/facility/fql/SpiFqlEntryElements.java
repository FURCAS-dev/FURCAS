package com.sap.tc.moin.repository.spi.facility.fql;

import com.sap.tc.moin.repository.MRI;

/**
 * An FqlEntryElements embodies a query entry which denotes a fixed set of
 * elements. All these elements are instances of the given query entry types.
 * Also note that the scope of this query entry is implicit defined by the
 * partitions of the provided MRIs
 * 
 * @author D045917
 */
public interface SpiFqlEntryElements extends SpiFqlQueryEntry {

    /**
     * The fixed elements of this query entry. This method does not return null.
     */
    MRI[] getFixedElements( );

}
