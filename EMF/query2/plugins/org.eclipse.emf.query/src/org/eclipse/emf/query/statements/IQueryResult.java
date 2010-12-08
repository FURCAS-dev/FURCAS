/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.IEObjectSource;


/**
 * <p>
 * A result created by executing or resuming a query statement. This result
 *  is essentially a collection with the capability of retrieving an exception
 *  if it occurred during the execution of the query statement 
 *  {@link org.eclipse.emf.query.internal.statements.QueryStatement}. Also,
 *  to support queries within queries, query results are also EObject sources
 *  {@link org.eclipse.emf.query.conditions.eobjects.IEObjectSource}.
 * </p>
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * 
 * @author Chris McGee (cmcgee)
 */
public interface IQueryResult
	extends Collection<EObject>, IEObjectSource {

	/**
	 * Retrieve the exception (if any) that occurred during the execute
	 *  or resume of the query statement.
	 * 
	 * @return The exception that was thrown or <i>null</i> if the query
	 *  statement executed normally.
	 */
	public Exception getException();
}
