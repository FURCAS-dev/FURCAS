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
	 * @param readRunnable
	 */
	void executeQueryCommand(QueryCommand command);

	void executeUpdateCommand(UpdateCommand command);

	void save();

	/**
	 * @return Path of master dump file
	 */ 
	void load();
	
	/**
	 * @return status whether the dump for Index exists already
	 */
	boolean isDumpExists();
	
}
