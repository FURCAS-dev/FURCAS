package com.sap.tc.moin.repository.spi.facility.fql;

import java.util.Set;

import com.sap.tc.moin.repository.PRI;

/**
 * An FqlEntryType embodies a query entry which denotes the entire set of
 * instances of the provided types. It permits explicit scoping, which can be
 * inclusive or exclusive. Moreover, the types may either refer to Classes Or
 * StructureTypes
 * 
 * @author D045917
 */
public interface SpiFqlEntryType extends SpiFqlQueryEntry {

    /**
     * The scope of a type is given by a set of PRIs which can be empty, but not
     * null.
     */
    Set<PRI> getScope( );

    /**
     * If true, the scope is inclusive, so all instances have to be taken from
     * within the provided scope. Otherwise, all instances are taken outside the
     * provided scope (within the client scope as indicated by the connection at
     * execution time)
     */
    boolean isScopeInclusive( );

    /**
     * There are two possible type categories: CLASS and STRUCTURETYPE
     */
    SpiFqlFromTypeCategory getTypeCategory( );

}
