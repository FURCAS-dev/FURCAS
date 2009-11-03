/*
 * Created on 02.02.2006
 */
package com.sap.tc.moin.repository.mql;

import com.sap.tc.moin.repository.ProcessReport;

/**
 * An MQLPreparedQuery stands for a pre-processed
 * {@link com.sap.tc.moin.repository.mql.MQLQuery}. It has elaborated all static
 * query information such as type-relevant operations. This is particularly
 * useful if a query has to be executed multiple times.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MQLPreparedQuery {

    /**
     * Produces a pretty-printed string of the prepared query.
     * 
     * @return a pretty-printed string of the prepared query.
     */
    String toString( );

    /**
     * Provides the report made during the preparation phase of the query. Note
     * that if there were errors, an {@link MQLFormatException} has been thrown,
     * which also provides a means to obtain a {@link ProcessReport}.
     * 
     * @return the preparation report
     */
    ProcessReport getPreparationReport( );

    /**
     * Some syntactic and type-correct queries may have statically determinable
     * empty solution sets. This predicate allows the client to verify this
     * before actually executing the query.
     * 
     * @return true, if the query is the empty query
     */
    boolean isEmpty( );
}
