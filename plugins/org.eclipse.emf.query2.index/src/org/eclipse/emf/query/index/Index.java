/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index;

import org.eclipse.emf.query.index.event.IndexChangeListenerRegistry;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.update.UpdateCommand;

/**
 * Index is built to support the Query by providing information for narrowing
 * the scope of resources that have to be loaded during execution. Therefore it
 * contains data about resources, EObjects and references between them.
 * Attributes are not part of the information.
 * 
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public interface Index {

	IndexChangeListenerRegistry getEventListenerRegistry();

	/**
	 * For execution of multiple queries with guaranteed isolation. Holds the
	 * read lock during the execution of the runnable.
	 * 
	 * <p>
	 * Queries can only be executed in scope of a QueryCommand which guarantees
	 * consistent query results. Inside the command, a QueryExecutor is
	 * available that takes all kinds of query types for execution and returns a
	 * QueryResult, which is basically an iterator. At the time you retrieve the
	 * iterator from the executor the execution has not been started and only
	 * starts by iterating over the QueryResult. This lazy querying element by
	 * element allows performant exists-any checks or first-X queries. Since
	 * there is no ordering the query does not support range queries.
	 * </p>
	 * 
	 * @param readRunnable
	 */
	void executeQueryCommand(QueryCommand command);

	/**
	 * For Updating the existing indices.
	 * 
	 * @param command
	 */
	void executeUpdateCommand(UpdateCommand command);

	/**
	 * Saves the Indices into the defined location.
	 */
	void save();

	/**
	 * Loads the Indices from a defined location into memory.
	 */
	void load();

	/**
	 * @return status whether the dump for Index exists already
	 */
	boolean isDumpExists();

}
