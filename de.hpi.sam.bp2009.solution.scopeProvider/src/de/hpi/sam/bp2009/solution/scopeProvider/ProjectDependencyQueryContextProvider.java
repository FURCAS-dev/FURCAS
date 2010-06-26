package de.hpi.sam.bp2009.solution.scopeProvider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query2.QueryContext;

import com.sap.ocl.oppositefinder.query2.QueryContextProvider;

import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

public class ProjectDependencyQueryContextProvider implements QueryContextProvider {
	@Override
	public QueryContext getQueryContext(EObject eObject) {
		ScopeProvider sp = new ProjectBasedScopeProviderImpl(eObject);
		QueryContext queryContext = sp.getForwardScopeAsQueryContext();
		return queryContext;
	}

}
