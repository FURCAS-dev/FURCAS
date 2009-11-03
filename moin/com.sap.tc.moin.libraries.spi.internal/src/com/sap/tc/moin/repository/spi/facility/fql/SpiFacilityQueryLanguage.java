package com.sap.tc.moin.repository.spi.facility.fql;

import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryClientScope;
import com.sap.tc.moin.repository.spi.facility.SpiMQLQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryServiceException;

/**
 * The facility query language embodies the query algebra which a facility can
 * implement in order to support MQL queries
 * 
 * @author D045917
 */
public interface SpiFacilityQueryLanguage extends SpiMQLQueryService {

    /**
     * Executes the provided FQL query for the given query client scope and
     * returns a result set whose size is no larger than maxResultSetSize.
     * Otherwise, a runtime exception is thrown. The actual partitionScope is
     * specified as part of the queryClientScope.
     * 
     * @param queryClientScope identifies the relevant {@link SpiClientSpec}s
     * and partition scope
     * @param iqlQuery the actual query, which will be executed
     * @param maxResultSetSize limits the maximum number of result set rows to
     * avoid out-of-memory exceptions. If the result is larger, an
     * {@link SpiFacilityQueryServiceException} is thrown
     * @param numberOfRequestedRows the max number of requested rows may be
     * delimited
     * @return the result set after executing the query
     */
    public SpiFqlQueryResultSet execute( SpiFacilityQueryClientScope queryClientScope, SpiFqlQuery iqlQuery, int maxResultSetSize, int numberOfRequestedRows );

}
