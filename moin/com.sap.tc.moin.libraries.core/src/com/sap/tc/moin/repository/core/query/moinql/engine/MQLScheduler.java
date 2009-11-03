/*
 * Created on 02.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.engine;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.query.moinql.internal.InternalQuery;
import com.sap.tc.moin.repository.mql.MQLExecutionException;

/**
 * The scheduler transforms an internal query based on the current state of the
 * connection. It may have to split the internal query to distribute
 * calculations both on the memory and the non-memory FQL processors. Results of
 * those part calculations have to be combined in memory by the interpreter.
 */
public interface MQLScheduler {

    /**
     * Schedules an internal query.
     */
    InternalQuery schedule( InternalQuery internalQuery, boolean schedulingWanted, boolean globalScopeIncluded, PRI[] globalPartitionScope, CRI[] globalContainerScope, int thresholdForNumberOfRelevantPartitionsForOptimization, int thresholdForNumberOfElementsInPartitionForOptimization )
        throws MQLExecutionException;
}
