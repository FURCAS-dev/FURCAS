package com.sap.tc.moin.repository.spi.facility;

import java.util.Set;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.PRI;

/**
 * Defines the query client scope, which is generally an array of ClientSpecs
 * 
 * @author D045917
 */
public interface SpiFacilityQueryClientScope {

    /**
     * The Query client scope is determined by an array of client specs
     * @return An array of {@link ClientSpec ClientSpecs} defining the scope for the query
     */
    ClientSpec[] getQueryClientScope( );

    /**
     * Defines, if the partitions in {@link #getPartitionsScope()} describe the
     * inclusive or exclusive query scope.
     * 
     * @return <code>false</code> if the set returned by
     * {@link #getPartitionsScope()} is to be negotiated as scope,
     * <code>true</code> otherwise.
     */
    public boolean isPartitionScopeInclusive( );

    /**
     * Returns the set of PRIs describing the inclusive or exclusive scope for a
     * query. Pay attention to the value of {@link #isPartitionScopeInclusive()}!
     * 
     * @return A set of unique {@link PRI}s
     */
    public Set<PRI> getPartitionsScope( );

}
