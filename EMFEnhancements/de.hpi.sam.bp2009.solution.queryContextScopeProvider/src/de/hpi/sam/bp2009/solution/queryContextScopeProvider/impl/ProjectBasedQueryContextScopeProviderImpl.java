/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.query2.QueryContext;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.ProjectBasedQueryContextScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

/**
 * <!-- begin-user-doc --> An implementation of the '<em><b>Project Based Query Context Scope Provider</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * 
 * <li>{@link ProjectBasedScopeProvider#getForwardScopeAsQueryContext() <em>Forward Scope as Query Context</em>}</li>
 * 
 * <li>{@link ProjectBasedScopeProvider#getBackwardScopeAsQueryContext() <em>Backward Scope as Query Context</em>}</li>
 * 
 * </ul>
 * </p>
 */
public class ProjectBasedQueryContextScopeProviderImpl extends ProjectBasedScopeProviderImpl
implements ProjectBasedQueryContextScopeProvider {
 
    protected ProjectBasedQueryContextScopeProviderImpl() {
        super();
    }

    public ProjectBasedQueryContextScopeProviderImpl(EObject... eObjects) {
        super(eObjects);
    }

    public ProjectBasedQueryContextScopeProviderImpl(Resource... resources) {
        super(resources);      
    }

    public ProjectBasedQueryContextScopeProviderImpl(ResourceSet... resourceSets) {
        super(resourceSets);
    }
    
    public ProjectBasedQueryContextScopeProviderImpl(Notifier notifier) {
        super(notifier);
    }
    
    public QueryContext getForwardScopeAsQueryContext() {
        if (rs == null) {
            throw new IllegalStateException("No ResourceSet defined!");
        }
        return new QueryContext() {

            @Override
            public ResourceSet getResourceSet() {
                return rs;
            }

            @Override
            public URI[] getResourceScope() {
                Collection<URI> list = getForwardScopeAsURIs();
                return (URI[]) list.toArray(new URI[list.size()]);

            }
        };
    }

    public QueryContext getBackwardScopeAsQueryContext() {
        return new QueryContext() {

            @Override
            public ResourceSet getResourceSet() {
                return rs;
            }

            @Override
            public URI[] getResourceScope() {
                Collection<URI> list = getBackwardScopeAsURIs();
                return (URI[]) list.toArray(new URI[list.size()]);
            }
        };
    }

} // ProjectBasedScopeProviderImpl
