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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestStack;
import de.ikv.medini.qvt.execution.debug.stackframe.QVTDebugStackFrame;

/**
 * Reply class for {@link QVTDebugRequestStack}
 * 
 * @author kiegeland
 * 
 */
public class QVTDebugReplyStack extends QVTDebugReply {

	/**
	 * A list of {@link QVTDebugStackFrame} instances
	 */
	private List frames = new ArrayList();

	public void addCallerFrame(QVTDebugStackFrame frame) {
		this.frames.add(0, frame);
	}

	public List getFrames() {
		return this.frames;
	}

	public String toString() {
		String result = "";
		for (Iterator iter = this.frames.iterator(); iter.hasNext();) {
			QVTDebugStackFrame frame = (QVTDebugStackFrame) iter.next();
			result += frame.toString() + "#";
		}
		return result;
	}

}
