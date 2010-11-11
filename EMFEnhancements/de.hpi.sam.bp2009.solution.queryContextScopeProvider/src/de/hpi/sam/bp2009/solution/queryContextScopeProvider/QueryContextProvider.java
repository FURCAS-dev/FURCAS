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
package de.hpi.sam.bp2009.solution.queryContextScopeProvider;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.query2.QueryContext;

/**
 * Can provide an EMF query2 context that describes what's visible for a query,
 * starting at a given element. The provider implementation may use the element
 * to determine, based on visibility and modularization rules, what can be seen
 * by the query. The provider can be asked to look in one of two directions: "forward"
 * means that a scope will be determined containing everything that can be "seen"
 * from the object's location. In other words, this is the scope to which the object
 * would be allowed to create references. "Backward" means that a scope will be
 * determined containing everything that can see the object. This scope contains the
 * model elements which would be allowed to create references to the object.
 * 
 * @author Axel Uhl
 *
 */
public interface QueryContextProvider {
    QueryContext getForwardScopeQueryContext(Notifier context);
    QueryContext getBackwardScopeQueryContext(Notifier context);
}
