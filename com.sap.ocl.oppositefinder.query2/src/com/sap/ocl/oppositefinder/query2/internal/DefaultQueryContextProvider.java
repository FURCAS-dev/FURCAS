package com.sap.ocl.oppositefinder.query2.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryContext;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;

public class DefaultQueryContextProvider implements QueryContextProvider {
    @Override
    public QueryContext getQueryContext(EObject etarget) {
        ResourceSet rs = null;
        if (etarget.eResource() != null) {
                rs = etarget.eResource().getResourceSet();
        }
        if (rs == null) {
                rs = new ResourceSetImpl();
        }
        return getWorkspaceQueryContext(rs);
    }

    /**
     * Provides a query context that contains all resources known to the current query2 index
     */
    private static QueryContext getWorkspaceQueryContext(final ResourceSet rs) {
        return new QueryContext() {
            public URI[] getResourceScope() {
                final List<URI> result = new ArrayList<URI>();
                IndexFactory.getInstance().executeQueryCommand(new QueryCommand() {
                    public void execute(QueryExecutor queryExecutor) {
                        ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
                        for (ResourceDescriptor desc : queryExecutor.execute(resourceQuery)) {
                            result.add(desc.getURI());
                        }
                        for (Resource r : rs.getResources()) {
                            result.add(r.getURI());
                        }
                    }
                });
                return result.toArray(new URI[0]);
            }

            public ResourceSet getResourceSet() {
                return rs;
            }
        };
    }
}
