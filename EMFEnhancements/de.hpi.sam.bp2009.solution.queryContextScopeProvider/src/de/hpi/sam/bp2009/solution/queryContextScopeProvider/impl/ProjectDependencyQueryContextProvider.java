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
    @Override
    public QueryContext getForwardScopeQueryContext(Notifier context) {
        QueryContextScopeProvider sp = new ProjectBasedQueryContextScopeProviderImpl(context);
        QueryContext queryContext = sp.getForwardScopeAsQueryContext();
        return queryContext;
    }

    @Override
    public QueryContext getBackwardScopeQueryContext(Notifier context) {
        QueryContextScopeProvider sp = new ProjectBasedQueryContextScopeProviderImpl(context);
        QueryContext queryContext = sp.getBackwardScopeAsQueryContext();
        return queryContext;
    }

}
