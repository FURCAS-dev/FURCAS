/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.ocl.oppositefinder.query2;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.IndexFactory;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query2.QueryContext;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;

public class DefaultQueryContextProvider implements QueryContextProvider {
    @Override
    public QueryContext getForwardScopeQueryContext(Notifier context) {
        return getWorkspaceQueryContext(context);
    }

    private QueryContext getWorkspaceQueryContext(Notifier context) {
        ResourceSet rs = null;
        Resource singleResource = null;
        if (context instanceof EObject) {
            singleResource = ((EObject) context).eResource();
            if (singleResource != null) {
                rs = singleResource.getResourceSet();
            }
        } else if (context instanceof Resource) {
            singleResource = (Resource) context;
            rs = singleResource.getResourceSet();
        } else if (context instanceof ResourceSet) {
            rs = (ResourceSet) context;
        }
        if (rs == null) {
            rs = new ResourceSetImpl();
        }
        return getWorkspaceQueryContext(rs, singleResource);
    }
    
    @Override
    public QueryContext getBackwardScopeQueryContext(Notifier context) {
        return getWorkspaceQueryContext(context);
    }

    /**
     * Provides a query context that contains all resources known to the current query2 index plus all resources
     * contained in the <code>rs</code> resource set
     */
    private static QueryContext getWorkspaceQueryContext(final ResourceSet rs, final Resource singleResource) {
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
                        if (singleResource != null) {
                            result.add(singleResource.getURI());
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
