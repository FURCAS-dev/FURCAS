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

package de.ikv.medini.qvt.execution.debug.requests;

import de.ikv.medini.qvt.execution.debug.IDebugAdapter;
import de.ikv.medini.qvt.execution.debug.QVTExitDebugSessionException;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyOK;

/**
 * Debugging request class to cancel engine execution
 * 
 * Always replies with {@link QVTDebugReplyOK}
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugRequestExit extends QVTDebugRequest {

	public String toString() {
		return "exit";
	}

	public void handleRequest(IDebugAdapter debugAdapter) {
		this.setReply(new QVTDebugReplyOK());
		throw new QVTExitDebugSessionException();
	}

}
