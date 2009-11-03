package com.sap.tc.moin.repository.spi.facility.basicquery;

import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryClientScope;
import com.sap.tc.moin.repository.spi.facility.SpiMQLQueryService;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFacilityQueryLanguage;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlQueryResultSet;

/**
 * @author D045917
 * @deprecated please implement {@link SpiMQLQueryService} instead
 */
@Deprecated
public interface SpiBasicQueryProcessor extends SpiFacilityQueryLanguage {

    /**
     * Selects objects with primitive attributes from a select expression.
     * 
     * @param clientScope
     * @param selectExpression
     * @param partitions partition scope
     * @param maxResultSetSize
     * @return objects
     */
    public SpiFqlQueryResultSet execute( SpiFacilityQueryClientScope queryClientScope, SpiSelectExpression selectExpression, int maxResultSetSize, int numberOfRequestedRows );

}