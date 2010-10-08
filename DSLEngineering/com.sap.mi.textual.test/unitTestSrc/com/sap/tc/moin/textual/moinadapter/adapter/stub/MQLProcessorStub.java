/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import static org.junit.Assert.fail;

import java.util.Set;

/**
 *
 */
public class MQLProcessorStub implements MQLProcessor {

    public MQLResultSet resultSet;
    public MQLQuery query;

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#execute(com.sap.tc.moin.repository.mql.MQLQuery)
     */
    public MQLResultSet execute(MQLQuery query) throws MQLExecutionException,
            MQLFormatException {
        this.query = query;
        return resultSet;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#execute(java.lang.String)
     */
    public MQLResultSet execute(String query) throws MQLExecutionException,
            MQLFormatException {
        return resultSet;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#execute(com.sap.tc.moin.repository.mql.MQLPreparedQuery)
     */
    public MQLResultSet execute(MQLPreparedQuery query)
            throws MQLExecutionException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#execute(com.sap.tc.moin.repository.mql.MQLPreparedQuery, com.sap.tc.moin.repository.mql.QueryScopeProvider)
     */
    public MQLResultSet execute(MQLPreparedQuery query,
            QueryScopeProvider scopeProvider) throws MQLExecutionException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#execute(com.sap.tc.moin.repository.mql.MQLQuery, com.sap.tc.moin.repository.mql.QueryScopeProvider)
     */
    public MQLResultSet execute(MQLQuery query, QueryScopeProvider scopeProvider)
            throws MQLExecutionException, MQLFormatException {
        this.query = query;
        return resultSet;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#execute(java.lang.String, com.sap.tc.moin.repository.mql.QueryScopeProvider)
     */
    public MQLResultSet execute(String query, QueryScopeProvider scopeProvider)
            throws MQLExecutionException, MQLFormatException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getCrisForContainerNames(java.lang.String[])
     */
    public CRI[] getCrisForContainerNames(String... containerNames) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getInclusiveContainerScopeProvider(java.lang.String[])
     */
    public QueryScopeProvider getInclusiveContainerScopeProvider(
            String... containerScope) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getInclusiveCriScopeProvider(com.sap.tc.moin.repository.CRI[])
     */
    public QueryScopeProvider getInclusiveCriScopeProvider(
            CRI... containerScope) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getInclusivePartitionScopeProvider(com.sap.tc.moin.repository.PRI[])
     */
    public QueryScopeProvider getInclusivePartitionScopeProvider(
            PRI... partitionScope) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getInclusiveQueryScopeProvider(com.sap.tc.moin.repository.PRI[], com.sap.tc.moin.repository.CRI[])
     */
    public QueryScopeProvider getInclusiveQueryScopeProvider(
            PRI[] partitionScope, CRI[] containerScope) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getInclusiveQueryScopeProvider(java.util.Set, java.util.Set)
     */
    public QueryScopeProvider getInclusiveQueryScopeProvider(
            Set<PRI> partitionScope, Set<CRI> containerScope) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getInclusiveVisibleCriScopeProvider(com.sap.tc.moin.repository.CRI)
     */
    public QueryScopeProvider getInclusiveVisibleCriScopeProvider(CRI cri) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getMaxResultSetSize()
     */
    public int getMaxResultSetSize() {
        fail("not implemented yet");
        return 0;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getQueryScopeProvider(boolean, com.sap.tc.moin.repository.PRI[], com.sap.tc.moin.repository.CRI[])
     */
    public QueryScopeProvider getQueryScopeProvider(boolean scopeInclusive,
            PRI[] partitionScope, CRI[] containerScope) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getQueryScopeProvider(boolean, java.util.Set, java.util.Set)
     */
    public QueryScopeProvider getQueryScopeProvider(boolean scopeInclusive,
            Set<PRI> partitionScope, Set<CRI> containerScope) {
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#getQueryScopeProvider(boolean, com.sap.tc.moin.repository.PRI[], java.lang.String[])
     */
    public QueryScopeProvider getQueryScopeProvider(boolean scopeInclusive,
            PRI[] partitionScope, String[] containerScope) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#prepare(com.sap.tc.moin.repository.mql.MQLQuery)
     */
    public MQLPreparedQuery prepare(MQLQuery query)
            throws MQLPreprocessorException, MQLFormatException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#prepare(java.lang.String)
     */
    public MQLPreparedQuery prepare(String query)
            throws MQLPreprocessorException, MQLFormatException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLProcessor#setMaxResultSetSize(int)
     */
    public void setMaxResultSetSize(int maxResultSetSize) {
        fail("not implemented yet");

    }

	@Override
	public MQLResultSet execute(MQLPreparedQuery query, int numberOfResults)
			throws MQLExecutionException {
        fail("not implemented yet");
		return null;
	}

	@Override
	public MQLResultSet execute(MQLQuery query, int numberOfResults)
			throws MQLExecutionException, MQLFormatException {
        fail("not implemented yet");
		return null;
	}

	@Override
	public MQLResultSet execute(String query, int numberOfResults)
			throws MQLExecutionException, MQLFormatException {
        fail("not implemented yet");
		return null;
	}

	@Override
	public MQLResultSet execute(MQLPreparedQuery query,
			QueryScopeProvider scopeProvider, int numberOfResults)
			throws MQLExecutionException {
        fail("not implemented yet");
		return null;
	}

	@Override
	public MQLResultSet execute(MQLQuery query,
			QueryScopeProvider scopeProvider, int numberOfResults)
			throws MQLExecutionException, MQLFormatException {
        fail("not implemented yet");
		return null;
	}

	@Override
	public MQLResultSet execute(String query, QueryScopeProvider scopeProvider,
			int numberOfResults) throws MQLExecutionException,
			MQLFormatException {
        fail("not implemented yet");
		return null;
	}

	@Override
	public QueryScopeProvider getGlobalQueryScopeProvider() {
        fail("not implemented yet");
		return null;
	}

}
