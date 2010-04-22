/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.query2.QueryContext;

public interface ScopeProvider {
	Collection<Resource> getInMemoryResources();
	QueryContext getForwardScopeAsQueryContext();
	QueryContext getBackwardScopeAsQueryContext();
	Collection<EObject> getForwardScopeAsEObjects();
	Collection<URI> getForwardScopeAsURIs();
	Collection<EObject> getBackwardScopeAsEObjects();
	Collection<URI> getBackwardScopeAsURIs();


} // ScopeProvider
