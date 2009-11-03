package com.sap.tc.moin.repository.mql;

import java.util.Set;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;

/**
 * The MQLProcessor is the basis for specifying and executing MQL queries. An
 * instance of an MQLProcessor is provided via a MOIN connection.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MQLProcessor {

    /**
     * The preparation of an {@link MQLQuery} means that the query is
     * pre-processed with regard to meta-model and type information. It only has
     * to happen once for each query as long as the query is not being used
     * against a different meta-model (e.g. with similar structure). If a type
     * or format error occur, this method will throw a
     * {@link MQLFormatException} with a list of errors and warnings. Other
     * errors result in a {@link MQLPreprocessorException}.
     * 
     * @param query the to-be-prepared query in AST
     * @return the MQL prepared query
     * @throws MQLPreprocessorException the MQL preprocessor exception
     * @throws MQLFormatException the MQL format exception
     */
    MQLPreparedQuery prepare( MQLQuery query ) throws MQLPreprocessorException, MQLFormatException;

    /**
     * Identical to {@link #prepare(MQLQuery)}, but this method allows the query
     * in concrete syntax format.
     * 
     * @param query the to-be-prepared query in CST
     * @return the MQL prepared query
     * @throws MQLPreprocessorException the MQL preprocessor exception
     * @throws MQLFormatException the MQL format exception
     */
    MQLPreparedQuery prepare( String query ) throws MQLPreprocessorException, MQLFormatException;

    /**
     * This operation executes the {@link MQLQuery}. It always first prepares
     * the query by means of {@link #prepare(MQLQuery)} and returns an
     * {@link MQLResultSet}. To avoid repeated preparation, use
     * {@link #prepare(MQLQuery)} first and then
     * {@link #execute(MQLPreparedQuery)}. Execution errors are throw as an
     * {@link MQLExecutionException} and should not occur during normal
     * operation.
     * 
     * @param query the to-be-executed query in AST
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     * @throws MQLFormatException the MQL format exception
     */
    MQLResultSet execute( MQLQuery query ) throws MQLExecutionException, MQLFormatException;

    /**
     * Identical to {@link #execute(MQLQuery)}, but this method allows the query
     * in concrete syntax format.
     * 
     * @param query the to-be-executed query in CST
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     * @throws MQLFormatException the MQL format exception
     */
    MQLResultSet execute( String query ) throws MQLExecutionException, MQLFormatException;

    /**
     * This operation executes the {@link MQLPreparedQuery} and returns a
     * {@link MQLResultSet}. Execution errors are throw as an
     * {@link MQLExecutionException} and should not occur during normal
     * operation.
     * 
     * @param query the prepared query, which is to-be-executed
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     */
    MQLResultSet execute( MQLPreparedQuery query ) throws MQLExecutionException;

    /**
     * This operation executes the {@link MQLPreparedQuery} and returns a
     * {@link MQLResultSet}. Execution errors are throw as an
     * {@link MQLExecutionException} and should not occur during normal
     * operation. The {@link QueryScopeProvider} makes it possible to delimit
     * the scope in which the query is executed. Tool builder can implement
     * their own {@link QueryScopeProvider}.
     * 
     * @param query the prepared query, which is to-be-executed
     * @param scopeProvider the scope provider to reduce the global scope in
     * which the query is to be executed
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     */
    MQLResultSet execute( MQLPreparedQuery query, QueryScopeProvider scopeProvider ) throws MQLExecutionException;

    /**
     * This operation executes the {@link MQLQuery}. It always first prepares
     * the query by means of {@link #prepare(MQLQuery)} and returns an
     * {@link MQLResultSet}. To avoid repeated preparation, use
     * {@link #prepare(MQLQuery)} first and then
     * {@link #execute(MQLPreparedQuery)}. Execution errors are throw as an
     * {@link MQLExecutionException} and should not occur during normal
     * operation. The {@link QueryScopeProvider} makes it possible to delimit
     * the scope in which the query is executed. Tool builder can implement
     * their own {@link QueryScopeProvider}.
     * 
     * @param query the to-be-executed query in AST
     * @param scopeProvider the scope provider to reduce the global scope in
     * which the query is to be executed
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     * @throws MQLFormatException the MQL format exception
     */
    MQLResultSet execute( MQLQuery query, QueryScopeProvider scopeProvider ) throws MQLExecutionException, MQLFormatException;

    /**
     * Identical to {@link #execute(MQLQuery)}, but this method allows the query
     * in concrete syntax format. The {@link QueryScopeProvider} makes it
     * possible to delimit the scope in which the query is executed. Tool
     * builder can implement their own {@link QueryScopeProvider}.
     * 
     * @param query the to-be-executed query in CST
     * @param scopeProvider the scope provider to reduce the global scope in
     * which the query is to be executed
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     * @throws MQLFormatException the MQL format exception
     */
    MQLResultSet execute( String query, QueryScopeProvider scopeProvider ) throws MQLExecutionException, MQLFormatException;

    /**
     * This operation executes the {@link MQLPreparedQuery} and returns a
     * {@link MQLResultSet}. Execution errors are throw as an
     * {@link MQLExecutionException} and should not occur during normal
     * operation. The number of result rows can be constrained by a positive
     * integer. A negative integer implies that no upper boundary is provided
     * (note that an {@link MQLExecutionException} will be thrown if the number
     * of results exceeds the maximum result set size as provided by
     * {@link #setMaxResultSetSize(int)}.
     * 
     * @param query the prepared query, which is to-be-executed
     * @param numberOfResults limits the number of result rows. A negative
     * number means no limitation.
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     */
    MQLResultSet execute( MQLPreparedQuery query, int numberOfResults ) throws MQLExecutionException;

    /**
     * This operation executes the {@link MQLQuery}. It always first prepares
     * the query by means of {@link #prepare(MQLQuery)} and returns an
     * {@link MQLResultSet}. To avoid repeated preparation, use
     * {@link #prepare(MQLQuery)} first and then
     * {@link #execute(MQLPreparedQuery)}. Execution errors are throw as an
     * {@link MQLExecutionException} and should not occur during normal
     * operation. Finally, the number of result rows can be constrained by a
     * positive integer. A negative integer implies that no upper boundary is
     * provided (note that an {@link MQLExecutionException} will be thrown if
     * the number of results exceeds the maximum result set size as provided by
     * {@link #setMaxResultSetSize(int)}.
     * 
     * @param query the to-be-executed query in AST
     * @param numberOfResults limits the number of result rows. A negative
     * number means no limitation.
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     * @throws MQLFormatException the MQL format exception
     */
    MQLResultSet execute( MQLQuery query, int numberOfResults ) throws MQLExecutionException, MQLFormatException;

    /**
     * Identical to {@link #execute(MQLQuery)}, but this method allows the query
     * in concrete syntax format. The number of result rows can be constrained
     * by a positive integer. A negative integer implies that no upper boundary
     * is provided (note that an {@link MQLExecutionException} will be thrown if
     * the number of results exceeds the maximum result set size as provided by
     * {@link #setMaxResultSetSize(int)}.
     * 
     * @param query the to-be-executed query in CST
     * @param numberOfResults limits the number of result rows. A negative
     * number means no limitation.
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     * @throws MQLFormatException the MQL format exception
     */
    MQLResultSet execute( String query, int numberOfResults ) throws MQLExecutionException, MQLFormatException;

    /**
     * This operation executes the {@link MQLPreparedQuery} and returns a
     * {@link MQLResultSet}. Execution errors are throw as an
     * {@link MQLExecutionException} and should not occur during normal
     * operation. The {@link QueryScopeProvider} makes it possible to delimit
     * the scope in which the query is executed. Tool builder can implement
     * their own {@link QueryScopeProvider}. Finally, the number of result rows
     * can be constrained by a positive integer. A negative integer implies that
     * no upper boundary is provided (note that an {@link MQLExecutionException}
     * will be thrown if the number of results exceeds the maximum result set
     * size as provided by {@link #setMaxResultSetSize(int)}.
     * 
     * @param query the prepared query, which is to-be-executed
     * @param scopeProvider the scope provider to reduce the global scope in
     * which the query is to be executed
     * @param numberOfResults limits the number of result rows. A negative
     * number means no limitation.
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     */
    MQLResultSet execute( MQLPreparedQuery query, QueryScopeProvider scopeProvider, int numberOfResults ) throws MQLExecutionException;

    /**
     * This operation executes the {@link MQLQuery}. It always first prepares
     * the query by means of {@link #prepare(MQLQuery)} and returns an
     * {@link MQLResultSet}. To avoid repeated preparation, use
     * {@link #prepare(MQLQuery)} first and then
     * {@link #execute(MQLPreparedQuery)}. Execution errors are throw as an
     * {@link MQLExecutionException} and should not occur during normal
     * operation. The {@link QueryScopeProvider} makes it possible to delimit
     * the scope in which the query is executed. Tool builder can implement
     * their own {@link QueryScopeProvider}. Finally, the number of result rows
     * can be constrained by a positive integer. A negative integer implies that
     * no upper boundary is provided (note that an {@link MQLExecutionException}
     * will be thrown if the number of results exceeds the maximum result set
     * size as provided by {@link #setMaxResultSetSize(int)}.
     * 
     * @param query the to-be-executed query in AST
     * @param scopeProvider the scope provider to reduce the global scope in
     * which the query is to be executed
     * @param numberOfResults limits the number of result rows. A negative
     * number means no limitation.
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     * @throws MQLFormatException the MQL format exception
     */
    MQLResultSet execute( MQLQuery query, QueryScopeProvider scopeProvider, int numberOfResults ) throws MQLExecutionException, MQLFormatException;

    /**
     * Identical to {@link #execute(MQLQuery)}, but this method allows the query
     * in concrete syntax format. The {@link QueryScopeProvider} makes it
     * possible to delimit the scope in which the query is executed. Tool
     * builder can implement their own {@link QueryScopeProvider}. Finally, the
     * number of result rows can be constrained by a positive integer. A
     * negative integer implies that no upper boundary is provided (note that an
     * {@link MQLExecutionException} will be thrown if the number of results
     * exceeds the maximum result set size as provided by
     * {@link #setMaxResultSetSize(int)}.
     * 
     * @param query the to-be-executed query in CST
     * @param scopeProvider the scope provider to reduce the global scope in
     * which the query is to be executed
     * @param numberOfResults limits the number of result rows. A negative
     * number means no limitation.
     * @return the MQL result set
     * @throws MQLExecutionException the MQL execution exception
     * @throws MQLFormatException the MQL format exception
     */
    MQLResultSet execute( String query, QueryScopeProvider scopeProvider, int numberOfResults ) throws MQLExecutionException, MQLFormatException;


    /**
     * This returns a scope provider, which does not restrain the scope at all.
     * 
     * @return a scope provider, which does not restrain the scope at all.
     */
    QueryScopeProvider getGlobalQueryScopeProvider( );

    /**
     * This provides a standard scope provider where the scope is defined by
     * union of the provided partitions and cris and the inclusion flag
     * indicates whether the query should be calculated inside the provided
     * scope or outside the provided scope.
     * 
     * @param scopeInclusive indicates whether the scope should include the
     * provided partitions and containers
     * @param partitionScope the partitions to be considered in the scope (may
     * be null)
     * @param containerScope the containers to be considered in the scope (may
     * be null)
     * @return the query scope provider
     */
    QueryScopeProvider getQueryScopeProvider( boolean scopeInclusive, PRI[] partitionScope, CRI[] containerScope );

    /**
     * This provides a standard scope provider where the scope is defined by
     * union of the provided partitions and cris and the inclusion flag
     * indicates whether the query should be calculated inside the provided
     * scope or outside the provided scope.
     * 
     * @param scopeInclusive indicates whether the scope should include the
     * provided partitions and containers
     * @param partitionScope the partitions to be considered in the scope (may
     * be null)
     * @param containerScope the containers to be considered in the scope (may
     * be null)
     * @return the query scope provider
     */
    QueryScopeProvider getQueryScopeProvider( boolean scopeInclusive, Set<PRI> partitionScope, Set<CRI> containerScope );

    /**
     * This provides a standard scope provider where the scope is defined by
     * union of the provided partitions and container names and the inclusion
     * flag indicates whether the query should be calculated inside the provided
     * scope or outside the provided scope. Note that the container names are
     * expanded over all facilities and data areas
     * 
     * @param scopeInclusive indicates whether the scope should include the
     * provided partitions and containers
     * @param partitionScope the partitions to be considered in the scope (may
     * be null)
     * @param containerScope the containers to be considered in the scope (may
     * be null), encoded as strings, so they are expanded over all facilities
     * and data areas
     * @return the query scope provider
     */
    QueryScopeProvider getQueryScopeProvider( boolean scopeInclusive, PRI[] partitionScope, String[] containerScope );

    /**
     * This provides a standard scope provider where the scope is defined by
     * union of the provided partitions and cris and the query will be executed
     * inside the provided scope.
     * 
     * @param partitionScope the partitions to be considered in the scope (may
     * be null)
     * @param containerScope the containers to be considered in the scope (may
     * be null)
     * @return the inclusive query scope provider
     */
    QueryScopeProvider getInclusiveQueryScopeProvider( PRI[] partitionScope, CRI[] containerScope );

    /**
     * This provides a standard scope provider where the scope is defined by
     * union of the provided partitions and cris and the query will be executed
     * inside the provided scope.
     * 
     * @param partitionScope the partitions to be considered in the scope (may
     * be null)
     * @param containerScope the containers to be considered in the scope (may
     * be null)
     * @return the inclusive query scope provider
     */
    QueryScopeProvider getInclusiveQueryScopeProvider( Set<PRI> partitionScope, Set<CRI> containerScope );

    /**
     * This provides a standard scope provider where the scope is defined by the
     * provided partitions and the query will be executed inside the provided
     * scope.
     * 
     * @param partitionScope the partitions to be considered in the scope (may
     * be null)
     * @return the inclusive partition scope provider
     */
    QueryScopeProvider getInclusivePartitionScopeProvider( PRI... partitionScope );

    /**
     * This provides a standard scope provider where the scope is defined by the
     * provided cris and the query will be executed inside the provided scope.
     * 
     * @param containerScope the containers to be considered in the scope (may
     * be null)
     * @return the inclusive container scope provider
     */
    QueryScopeProvider getInclusiveCriScopeProvider( CRI... containerScope );

    /**
     * This provides a standard scope provider where the scope is defined by the
     * provided container names and the query will be executed inside the
     * provided scope.
     * 
     * @param containerScope the containers to be considered in the scope (may
     * be null), encoded as strings, so they are expanded over all facilities
     * and data areas
     * @return the inclusive container scope provider
     */
    QueryScopeProvider getInclusiveContainerScopeProvider( String... containerScope );

    /**
     * This provides a standard scope provider where the scope is defined by the
     * provided CRI plus all the partitions which are visible for the provided
     * container. Additionally, the scope includes the null-partition of the
     * connection on which the MQL processor is registered. The query will be
     * executed inside the provided scope.
     * 
     * @param cri the container, which is the seed of the scope, i.e. the query
     * will be executed within this container and all visible containers
     * @return the inclusive visible container scope provider
     */
    QueryScopeProvider getInclusiveVisibleCriScopeProvider( CRI cri );

    /**
     * Returns the currently set maximum result set size after which the query
     * engine will give up with an exception. Note that this threshold is also
     * obeyed when constructing intermediate result sets (caused by mixing
     * transient and persistent results). By default, the threshold is set to
     * 10.000 rows.
     * 
     * @return the max result set size before a query execution will abort
     */
    int getMaxResultSetSize( );

    /**
     * Allows to change the maximum result set size after which the query engine
     * will give up with an exception. Note that this threshold is also obeyed
     * when constructing intermediate result sets (caused by mixing transient
     * and persistent results). By default, the threshold is set to 10.000 rows.
     * 
     * @param maxResultSetSize the max result set size before which a query
     * execution will abort
     */
    void setMaxResultSetSize( int maxResultSetSize );

    /**
     * This method calculates all possibly CRIs for a given set of container
     * names. It does this by combining all given container names with all data
     * areas in all facilities.
     * 
     * @param containerNames a bunch of container names encoded as strings,
     * which are expanded over all facilities and data areas
     * @return the cris for all containers after expanding over all facilities
     * and data areas
     */
    public CRI[] getCrisForContainerNames( String... containerNames );

}
