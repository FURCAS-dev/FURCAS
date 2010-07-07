/**
 * 
 */
package de.hpi.sam.bp2009.benchframework.modifiedScopeProvider.impl;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.query2.QueryContext;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectBasedQueryContextScopeProviderImpl;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

/**
 * 
 * @author Tobias Hoppe
 *
 */
public class ModifiedProjectBasedScopeProviderImpl extends ProjectBasedQueryContextScopeProviderImpl {

    /**
     * Modified version of the {@link ProjectBasedScopeProviderImpl} to benchmark time consumption
     * 
     */
    public ModifiedProjectBasedScopeProviderImpl(){
        super();
    }
    
    @Override
    public Collection<IProject> getForwardScopeAsProjects() {
        long before = System.nanoTime();
        Collection<IProject> result = super.getForwardScopeAsProjects();
        long after = System.nanoTime();
        System.out.println("Time for getting Forward Scope as Projects: " + (after - before) + "ns");
        return result;
    }

    @Override
    public Collection<Resource> getForwardScopeAsResources() {
        long before = System.nanoTime();
        Collection<Resource> result = super.getForwardScopeAsResources();
        long after = System.nanoTime();
        System.out.println("Time for getting Forward Scope as Resources: " + (after - before) + "ns");
        return result;
    }

    @Override
    public QueryContext getForwardScopeAsQueryContext() {
        long before = System.nanoTime();
        QueryContext result = super.getForwardScopeAsQueryContext();
        long after = System.nanoTime();
        System.out.println("Time for getting Forward Scope as QueryContext: " + (after - before) + "ns");
        return result;
    }

    @Override
    public Collection<URI> getForwardScopeAsURIs() {
        long before = System.nanoTime();
        Collection<URI> result = super.getForwardScopeAsURIs();
        long after = System.nanoTime();
        System.out.println("Time for getting Forward Scope as URIs: " + (after - before) + "ns");
        return result;
    }

    @Override
    public Collection<EObject> getForwardScopeAsEObjects() {
        long before = System.nanoTime();
        Collection<EObject> result = super.getForwardScopeAsEObjects();
        long after = System.nanoTime();
        System.out.println("Time for getting Forward Scope as EObjects: " + (after - before) + "ns");
        return result;
    }

    @Override
    public Collection<IProject> getBackwardScopeAsProjects() {
        long before = System.nanoTime();
        Collection<IProject> result = super.getBackwardScopeAsProjects();
        long after = System.nanoTime();
        System.out.println("Time for getting Backward Scope as Projects: " + (after - before) + "ns");
        return result;
    }

    @Override
    public Collection<Resource> getBackwardScopeAsResources() {
        long before = System.nanoTime();
        Collection<Resource> result = super.getBackwardScopeAsResources();
        long after = System.nanoTime();
        System.out.println("Time for getting Backward Scope as Resources: " + (after - before) + "ns");
        return result;
    }

    @Override
    public QueryContext getBackwardScopeAsQueryContext() {
        long before = System.nanoTime();
        QueryContext result = super.getBackwardScopeAsQueryContext();
        long after = System.nanoTime();
        System.out.println("Time for getting Backward Scope as QueryContext: " + (after - before) + "ns");
        return result;
    }

    @Override
    public Collection<URI> getBackwardScopeAsURIs() {
        long before = System.nanoTime();
        Collection<URI> result = super.getBackwardScopeAsURIs();
        long after = System.nanoTime();
        System.out.println("Time for getting Backward Scope as URIs: " + (after - before) + "ns");
        return result;
    }

    @Override
    public Collection<EObject> getBackwardScopeAsEObjects() {
        long before = System.nanoTime();
        Collection<EObject> result = super.getBackwardScopeAsEObjects();
        long after = System.nanoTime();
        System.out.println("Time for getting Backward Scope as EObjects: " + (after - before) + "ns");
        return result;
    }

}
