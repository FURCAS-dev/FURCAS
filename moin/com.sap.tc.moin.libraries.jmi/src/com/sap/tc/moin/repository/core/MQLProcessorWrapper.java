package com.sap.tc.moin.repository.core;

import java.util.Set;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLPreprocessorException;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;

public class MQLProcessorWrapper extends AbstractConnectionAwareWrapper<MQLProcessor> implements MQLProcessor {

    private final MQLProcessor mqlProcessor;

    public MQLProcessorWrapper( CoreConnection connection ) {

        super( connection, connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.mqlProcessor = connection.getMQLProcessor( );
    }

    public MQLProcessor unwrap( ) {

        return this.mqlProcessor;
    }

    public int getMaxResultSetSize( ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getMaxResultSetSize( );
    }

    public void setMaxResultSetSize( int maxResultSetSize ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        this.mqlProcessor.setMaxResultSetSize( maxResultSetSize );
    }

    public MQLPreparedQuery prepare( MQLQuery query ) throws MQLPreprocessorException, MQLFormatException {


        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.mqlProcessor.prepare( query );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public MQLPreparedQuery prepare( String query ) throws MQLPreprocessorException, MQLFormatException {


        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.mqlProcessor.prepare( query );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public MQLResultSet execute( MQLQuery query ) throws MQLExecutionException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query );
    }

    public MQLResultSet execute( MQLPreparedQuery query ) throws MQLExecutionException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query );
    }

    public MQLResultSet execute( String query ) throws MQLExecutionException, MQLFormatException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query );
    }

    public MQLResultSet execute( MQLPreparedQuery query, QueryScopeProvider scopeProvider ) throws MQLExecutionException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query, scopeProvider );
    }

    public MQLResultSet execute( MQLQuery query, QueryScopeProvider scopeProvider ) throws MQLExecutionException, MQLFormatException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query, scopeProvider );
    }

    public MQLResultSet execute( String query, QueryScopeProvider scopeProvider ) throws MQLExecutionException, MQLFormatException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query, scopeProvider );
    }

    public MQLResultSet execute( MQLPreparedQuery query, int numberOfResults ) throws MQLExecutionException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query, numberOfResults );
    }

    public MQLResultSet execute( MQLQuery query, int numberOfResults ) throws MQLExecutionException, MQLFormatException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query, numberOfResults );
    }

    public MQLResultSet execute( String query, int numberOfResults ) throws MQLExecutionException, MQLFormatException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query, numberOfResults );
    }

    public MQLResultSet execute( MQLPreparedQuery query, QueryScopeProvider scopeProvider, int numberOfResults ) throws MQLExecutionException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query, scopeProvider, numberOfResults );
    }

    public MQLResultSet execute( MQLQuery query, QueryScopeProvider scopeProvider, int numberOfResults ) throws MQLExecutionException, MQLFormatException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query, scopeProvider, numberOfResults );
    }

    public MQLResultSet execute( String query, QueryScopeProvider scopeProvider, int numberOfResults ) throws MQLExecutionException, MQLFormatException {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.execute( query, scopeProvider, numberOfResults );
    }

    public QueryScopeProvider getGlobalQueryScopeProvider( ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getGlobalQueryScopeProvider( );
    }


    public QueryScopeProvider getQueryScopeProvider( boolean scopeInclusive, PRI[] partitionScope, CRI[] containerScope ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getQueryScopeProvider( scopeInclusive, partitionScope, containerScope );
    }

    public QueryScopeProvider getQueryScopeProvider( boolean scopeInclusive, PRI[] partitionScope, String[] containerScope ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getQueryScopeProvider( scopeInclusive, partitionScope, containerScope );
    }

    public QueryScopeProvider getQueryScopeProvider( boolean scopeInclusive, Set<PRI> partitionScope, Set<CRI> containerScope ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getQueryScopeProvider( scopeInclusive, partitionScope, containerScope );
    }

    public QueryScopeProvider getInclusiveCriScopeProvider( CRI... containerScope ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getInclusiveCriScopeProvider( containerScope );
    }

    public QueryScopeProvider getInclusiveQueryScopeProvider( PRI[] partitionScope, CRI[] containerScope ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getInclusiveQueryScopeProvider( partitionScope, containerScope );
    }

    public QueryScopeProvider getInclusivePartitionScopeProvider( PRI... partitionScope ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getInclusivePartitionScopeProvider( partitionScope );
    }

    public QueryScopeProvider getInclusiveQueryScopeProvider( Set<PRI> partitionScope, Set<CRI> containerScope ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getInclusiveQueryScopeProvider( partitionScope, containerScope );
    }

    public QueryScopeProvider getInclusiveContainerScopeProvider( String... containerScope ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getInclusiveContainerScopeProvider( containerScope );
    }

    public CRI[] getCrisForContainerNames( String... containerNames ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getCrisForContainerNames( containerNames );
    }

    public QueryScopeProvider getInclusiveVisibleCriScopeProvider( CRI cri ) {

        assertConnectionAlive( );
        attachConnectionIfRequired( );
        return this.mqlProcessor.getInclusiveVisibleCriScopeProvider( cri );
    }

}