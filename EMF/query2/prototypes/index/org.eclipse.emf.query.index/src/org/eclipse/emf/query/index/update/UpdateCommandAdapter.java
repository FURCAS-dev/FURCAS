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
 * 
 * @author Martin Strenge, SAP AG
 * 
 */
public abstract class UpdateCommandAdapter implements UpdateCommand {

	@Override
	public void postCommitAction() {
	}

	@Override
	public void preCommitAction(IndexUpdater updater) {
	}

}
