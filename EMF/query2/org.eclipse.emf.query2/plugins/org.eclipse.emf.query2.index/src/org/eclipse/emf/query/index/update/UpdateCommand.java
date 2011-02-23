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
package org.eclipse.emf.query.index.update;

/**
 * Commands to update the indices, save the updation done or revert the changes done.
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public interface UpdateCommand {

	/**
	 * Executes the index updation process.
	 * @param updater instance of the {@link IndexUpdater}
	 */
	void execute(IndexUpdater updater);

	/**
	 * Actions taken before commiting the index update.
	 * @param updater instance of the {@link IndexUpdater}
	 */
	void preCommitAction(IndexUpdater updater);

	/**
	 * Actions taken after commiting index update, generally cleanup tasks.
	 */
	void postCommitAction();

}
