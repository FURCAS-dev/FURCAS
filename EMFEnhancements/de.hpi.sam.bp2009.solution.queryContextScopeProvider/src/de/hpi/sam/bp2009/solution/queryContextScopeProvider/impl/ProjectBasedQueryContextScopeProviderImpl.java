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
package de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
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
    
    public ProjectBasedQueryContextScopeProviderImpl(Notifier... notifier) {
        super(notifier);
    }
    
    @Override
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
                return list.toArray(new URI[list.size()]);

            }
        };
    }

    @Override
    public QueryContext getBackwardScopeAsQueryContext() {
        return new QueryContext() {

            @Override
            public ResourceSet getResourceSet() {
                return rs;
            }

            @Override
            public URI[] getResourceScope() {
                Collection<URI> list = getBackwardScopeAsURIs();
                return list.toArray(new URI[list.size()]);
            }
        };
    }

} // ProjectBasedScopeProviderImpl
