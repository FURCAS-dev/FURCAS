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

package de.ikv.medini.qvt.execution.debug;

import java.util.Set;

import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.execution.QvtSemanticTask;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEvent;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReply;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequest;

/**
 * The debug adapter interface, representing the debugging API. The only two methods which are allowed to be called by the client are {@link #sendRequest(QVTDebugRequest)} and
 * {@link #dequeueEvent()}.
 * 
 * @author kiegeland
 * 
 */
public interface IDebugAdapter {

	/**
	 * Called before the next task is computed
	 * 
	 */
	void beforeComputingNextTask();

	/**
	 * Throws events (e.g. when a breakpoint is hit) and checks for new client requests.
	 * 
	 */
	void doDebugWork();

	/**
	 * Gets installed breakpoints
	 * 
	 * @return list of {@link QVTSourcePosition} instances
	 */
	Set getBreakpoints();

	/**
	 * Get the task which is currently worked on when a request is handled.
	 * 
	 * @return the task or null
	 */
	QvtSemanticTask getSuspendedTask();

	/**
	 * Resumes the transformation
	 * 
	 * @param resumeStepOver ..
	 *            because of a "step over" request
	 * @param resumeStepReturn ..
	 *            because of a "step return" request
	 * @param resumeStepInto ..
	 *            because of a "step into" request
	 * @param resumeSilent
	 *            resumes the engine silently, as if it was not suspended (so e.g. a "step over" context is not lost)
	 */
	void resume(boolean resumeStepOver, boolean resumeStepReturn, boolean resumeStepInto, boolean resumeSilent);

	/**
	 * Suspends the transformation
	 * 
	 */
	void suspend();

	/**
	 * Supends the transformation because an exception occured
	 */
	void suspendByException(Throwable e);

	/**
	 * Gets the QVT processor prior set by {@link #setQvtProcessor(QvtProcessorImpl)}
	 * 
	 * @return
	 */
	QvtProcessorImpl getQvtProcessor();

	/**
	 * Sets the QVT processor executing the transformation.
	 * 
	 * @param processor
	 */
	void setQvtProcessor(QvtProcessorImpl processor);

	/**
	 * Called from the client to fetch events
	 * 
	 * @return the event or <code>null</code> if there are not more events because the transformation finished
	 * @throws InterruptedException
	 */
	QVTDebugEvent dequeueEvent() throws InterruptedException;

	/**
	 * Called from the client to do a request and to wait for the reply.
	 * 
	 * @param request
	 * @return
	 * @throws InterruptedException
	 * 
	 */
	QVTDebugReply sendRequest(QVTDebugRequest request) throws InterruptedException;

	/**
	 * Called by the engine when the transformation is started
	 * 
	 */
	void startTransformation();

	/**
	 * Called by the engine when the transformation has finished (successfully or not successfully)
	 * 
	 */
	void stopTransformation();

}
