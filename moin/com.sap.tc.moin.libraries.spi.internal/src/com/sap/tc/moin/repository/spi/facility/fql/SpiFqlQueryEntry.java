package com.sap.tc.moin.repository.spi.facility.fql;

import com.sap.tc.moin.repository.MRI;

/**
 * An Fql Query Entry embodies one type or set of elements in the query. Each of
 * these contributes instances to the cartesian product. Each individual Query
 * Entry may be additionally constrained by a local FqlCondition.
 * 
 * @author D045917
 */
public interface SpiFqlQueryEntry {

    /**
     * Indicates the types of interest. If more than one type is provided, then
     * all types are subtypes from the first type (directly or indirectly). If
     * no types are returned, the query type entry indicates that all instance
     * should be contributed the the query. This essentially encodes
     * Reflect::Element. This method does not return null.
     */
    MRI[] getTypes( );

    /**
     * Each FqlQueryEntry has optionally a local condition. If no condition
     * exists, null is returned.
     */
    SpiFqlLocalConstraint getCondition( );

    /*
     * For Debugging purposes
     */

    /**
     * The qualified names of all types in the same order as {@link #getTypes()}.
     * This method does not return null.
     */
    String[] getTypeNames( );

}
