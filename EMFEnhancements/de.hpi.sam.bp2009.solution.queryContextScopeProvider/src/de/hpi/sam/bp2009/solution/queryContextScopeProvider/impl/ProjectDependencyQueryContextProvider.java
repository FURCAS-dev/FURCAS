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

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.query2.QueryContext;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextScopeProvider;

public class ProjectDependencyQueryContextProvider implements QueryContextProvider {
    private final Notifier[] additionalScopeSeeds;
    
    /**
     * Using this constructor, only the immediate project context determined from the <code>context</code> parameters of
     * {@link #getForwardScopeQueryContext(Notifier)} and {@link #getBackwardScopeQueryContext(Notifier)} will be used
     * for scope detection.
     */
    public ProjectDependencyQueryContextProvider() {
        additionalScopeSeeds = null;
    }

    /**
     * The <code>notifiers</code> will be used as additional scope seed in
     * {@link #getForwardScopeQueryContext(Notifier)} and {@link #getBackwardScopeQueryContext(Notifier)}.
     */
    public ProjectDependencyQueryContextProvider(Notifier... additionalScopeSeeds) {
        this.additionalScopeSeeds = additionalScopeSeeds;
    }
    
    @Override
    public QueryContext getForwardScopeQueryContext(Notifier context) {
        QueryContextScopeProvider sp = new ProjectBasedQueryContextScopeProviderImpl(getExtendedContext(context));
        QueryContext queryContext = sp.getForwardScopeAsQueryContext();
        return queryContext;
    }

    private Notifier[] getExtendedContext(Notifier context) {
        if (additionalScopeSeeds == null || additionalScopeSeeds.length == 0) {
            return new Notifier[] { context };
        } else {
            Notifier[] result = new Notifier[additionalScopeSeeds.length+1];
            System.arraycopy(additionalScopeSeeds, 0, result, 0, additionalScopeSeeds.length);
            result[result.length-1] = context;
            return result;
        }
    }

    @Override
    public QueryContext getBackwardScopeQueryContext(Notifier context) {
        QueryContextScopeProvider sp = new ProjectBasedQueryContextScopeProviderImpl(getExtendedContext(context));
        QueryContext queryContext = sp.getBackwardScopeAsQueryContext();
        return queryContext;
    }
    
}
