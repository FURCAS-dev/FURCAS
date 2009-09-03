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
package org.eclipse.emf.query.index.api;

import org.eclipse.emf.query.index.api.event.IndexChangeListenerRegistry;
import org.eclipse.emf.query.index.api.query.QueryCommand;
import org.eclipse.emf.query.index.api.update.UpdateCommand;

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
	
	void load();
}
