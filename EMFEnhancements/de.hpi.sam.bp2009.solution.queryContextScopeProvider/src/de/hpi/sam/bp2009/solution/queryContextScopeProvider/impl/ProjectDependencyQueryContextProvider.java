package de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.query2.QueryContext;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextScopeProvider;

public class ProjectDependencyQueryContextProvider implements QueryContextProvider {
    @Override
    public QueryContext getForwardScopeQueryContext(Notifier context) {
        QueryContextScopeProvider sp = new ProjectBasedQueryContextScopeProviderImpl(context);
        QueryContext queryContext = sp.getForwardScopeAsQueryContext();
        return queryContext;
    }

    @Override
    public QueryContext getBackwardScopeQueryContext(Notifier context) {
        QueryContextScopeProvider sp = new ProjectBasedQueryContextScopeProviderImpl(context);
        QueryContext queryContext = sp.getBackwardScopeAsQueryContext();
        return queryContext;
    }

}
