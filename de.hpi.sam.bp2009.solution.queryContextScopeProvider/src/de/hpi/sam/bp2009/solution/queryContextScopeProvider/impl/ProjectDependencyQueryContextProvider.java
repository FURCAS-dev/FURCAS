package de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query2.QueryContext;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.ProjectBasedQueryContextScopeProvider;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;

public class ProjectDependencyQueryContextProvider implements QueryContextProvider {
	@Override
	public QueryContext getQueryContext(EObject eObject) {
		ProjectBasedQueryContextScopeProvider sp = new ProjectBasedQueryContextScopeProviderImpl(eObject);
		QueryContext queryContext = sp.getForwardScopeAsQueryContext();
		return queryContext;
	}

}
