/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.query.statements;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.internal.statements.QueryClause;


/**
 * The where clause specifies the condition that all result EObjects of the
 *  query must satisfy.
 * 
 * @author Yasser Lulu 
 */
public class WHERE extends QueryClause {
	
	// IMPORTANT: never cache results to guarantee correctness of results when 
	// re-executing the query, since eObject could change some of their 
	// attribs, refs, values...etc. between re-executions and thus new results 
	// should be obtained afresh to ensure correctness. 
	 
    private EObjectCondition condition;

    public WHERE(EObjectCondition condition) {
        this.condition = condition;
    }

    public boolean matches(EObject eObject) {
        return condition.isSatisfied(eObject);
    }

    public boolean shouldPrune(EObject eObject) {
        return condition.shouldPrune(eObject);
    }
}
