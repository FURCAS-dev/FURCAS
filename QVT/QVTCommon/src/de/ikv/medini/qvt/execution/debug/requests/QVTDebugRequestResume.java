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
 * Debugging request class to resume execution
 * 
 * Always replies with {@link QVTDebugReplyOK}
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugRequestResume extends QVTDebugRequest {

	private boolean resumeSilent;

	public QVTDebugRequestResume(boolean resumeSilent) {
		this.resumeSilent = resumeSilent;
	}

	public QVTDebugRequestResume() {
		this.resumeSilent = false;
	}

	public String toString() {
		return "resume";
	}

	public void handleRequest(IDebugAdapter debugAdapter) {
		debugAdapter.resume(false, false, false, this.resumeSilent);
		if (!this.resumeSilent) {
			this.setEvent(new QVTDebugEventResumed(true));
		}
		this.setReply(new QVTDebugReplyOK());
	}

}
