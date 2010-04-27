package de.hpi.sam.bp2009.solution.scopeProvider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.QueryContextProvider;

import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

public class ProjectDependencyQueryContextProvider implements QueryContextProvider {
	/**
	 * Applies this query context / scope provider to the OCL environment <tt>ocl</tt>.
	 * As a result, whenever queries need to be performed during the evaluation or
	 * parsing of OCL expressions, this object will be used to provide the query scope.
	 */
	public void apply(OCL ocl) {
		((EcoreEvaluationEnvironment) ocl.getEvaluationEnvironment()).setQueryContextProvider(this);
	}
	
	@Override
	public QueryContext getQueryContext(EObject eObject) {
		ScopeProvider sp = new ProjectBasedScopeProviderImpl(eObject);
		QueryContext queryContext = sp.getForwardScopeAsQueryContext();
		return queryContext;
	}

}
