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
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventResumed;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyOK;

/**
 * Debugging request class to step over.
 * 
 * Always replies with {@link QVTDebugReplyOK}.
 * 
 * Throws event {@link QVTDebugEventResumed}.
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugRequestStepOver extends QVTDebugRequest {

	public String toString() {
		return "stepover";
	}

	public void handleRequest(IDebugAdapter debugAdapter) {
		debugAdapter.resume(true, false, false, false);
		this.setEvent(new QVTDebugEventResumed(false));
		this.setReply(new QVTDebugReplyOK());
	}

}
