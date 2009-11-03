/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt.execution.debug.replies;

/**
 * Debugging reply signaling that a request was not succussful processed
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugReplyFailure extends QVTDebugReply {

	private String message;

	public QVTDebugReplyFailure(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
