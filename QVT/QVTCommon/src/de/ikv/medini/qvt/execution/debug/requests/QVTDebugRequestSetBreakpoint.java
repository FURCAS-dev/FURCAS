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
import de.ikv.medini.qvt.execution.debug.QVTSourcePosition;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyOK;

/**
 * Request class to set a breakpoint at a given line. Replies always with "ok".
 * 
 * @author kiegeland
 * 
 */

public class QVTDebugRequestSetBreakpoint extends QVTDebugRequest {

	private QVTSourcePosition sourcePosition;

	public QVTDebugRequestSetBreakpoint(QVTSourcePosition sourcePosition) {
		this.sourcePosition = sourcePosition;
	}

	public String toString() {
		return "set " + this.sourcePosition.getLine();
	}

	public void handleRequest(IDebugAdapter debugAdapter) {
		debugAdapter.getBreakpoints().add(this.sourcePosition);
		this.setReply(new QVTDebugReplyOK());
	}

}
