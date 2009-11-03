package com.sap.tc.moin.repository.core.query.moinql.engine;

import com.sap.tc.moin.repository.core.query.moinql.internal.InternalQuery;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLResultSet;

/**
 * This service interpretes the
 * {@link com.sap.tc.moin.repository.core.query.moinql.internal.InternalQuery}
 * structure. It uses the FQL services, including the memory FQL to calculate
 * parts of the query. Its query part results are further combined in-memory
 * according to the operations defined in the Internal Query.
 */
public interface MQLInterpreter {

    /**
     * The MQL execution interpreter. It assumes that the interal query has an
     * executable structure. It returns a MQL result set. The number of
     * requested rows limits the possible number of requested rows. The
     * maxResultSetSize defines when the execution aborts with an
     * MQLExecutionException.
     */
    MQLResultSet execute( InternalQuery internalQuery, int maxResultSetSize, int numberOfRequestedRows ) throws MQLExecutionException;

}
