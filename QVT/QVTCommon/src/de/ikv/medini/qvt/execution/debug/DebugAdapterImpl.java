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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import de.ikv.medini.qvt.QVTProcessorConsts;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.execution.QvtSemanticTask;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEvent;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventStarted;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventSuspended;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventSuspendedBreakpointCause;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventSuspendedEventCause;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventSuspendedStepCause;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventTerminated;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReply;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequest;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestExit;
import de.ikv.medini.qvt.execution.debug.stackframe.QVTDebugStackFrame;

/**
 * Implementation of the {@link IDebugAdapter} interface, using thread synchronization as communication means
 * 
 * @author kiegeland
 * 
 */
public class DebugAdapterImpl implements IDebugAdapter {

	/**
	 * Associated processor
	 */
	private QvtProcessorImpl processor;

	/**
	 * List of installed breakpoints, as a list of {@link QVTSourcePosition} instances
	 */
	private Set breakpoints = new HashSet();

	/**
	 * Requests sent by the QVT debugger to the QVT engine
	 */
	private LinkedList requestQueue = new LinkedList();

	/**
	 * Events sent by the QVT engine to the QVT debugger
	 */
	private LinkedList eventQueue = new LinkedList();

	/**
	 * Flag indicating whether the QVT engine is suspended (task-evaluation is suspended).
	 */
	private boolean suspended;

	private boolean terminated = false;

	/**
	 * The task of a "step over" debugging request
	 */
	private QvtSemanticTask taskToStepOver;

	/**
	 * The task of a "step into" debugging request
	 */
	private QvtSemanticTask taskToStepIntoFrom;

	/**
	 * Indicates the last position where the QVT engine was suspended.
	 */
	private QVTDebugPosition lastDebugPosition;

	public DebugAdapterImpl() {

	}

	public void triggerEvent(QVTDebugEvent event) {
		synchronized (this.eventQueue) {
			this.eventQueue.add(event);
			this.eventQueue.notifyAll();
		}
	}

	public QVTDebugEvent dequeueEvent() throws InterruptedException {
		synchronized (this.eventQueue) {
			while (this.eventQueue.isEmpty() && !this.terminated) {
				this.eventQueue.wait();
			}
			if (!this.eventQueue.isEmpty()) {
				QVTDebugEvent result = (QVTDebugEvent) this.eventQueue.remove(0);
				this.eventQueue.notifyAll();
				return result;
			} else {
				return null;
			}

		}
	}

	public Set getBreakpoints() {
		return this.breakpoints;
	}

	public void doDebugWork() {
		QvtSemanticTask task = this.getSuspendedTask();
		if (task != null) {
			if (!this.suspended && this.taskToStepIntoFrom != null && /* taskToStepIntoFrom == task.getCallerTask() */task.getWaitingTasks().contains(this.taskToStepIntoFrom)) {
				this.suspended = true;
				this.triggerEvent(new QVTDebugEventSuspended(new QVTDebugEventSuspendedStepCause()));
			} else if (!this.suspended && this.taskToStepOver != null && (this.taskToStepOver == task || !this.taskToStepOver.isComputing())) {
				if (!task.currentDebugPosition().equals(this.lastDebugPosition)) {
					this.suspended = true;
					this.triggerEvent(new QVTDebugEventSuspended(new QVTDebugEventSuspendedStepCause()));
				}
			} else if (!this.suspended && this.breakpoints.contains(task.currentSourcePosition()) && !task.currentDebugPosition().equals(this.lastDebugPosition)) {
				this.suspended = true;
				this.triggerEvent(new QVTDebugEventSuspended(new QVTDebugEventSuspendedBreakpointCause(new QVTDebugStackFrame(task))));
			}
		}
		this.readNextRequest();
	}

	/**
	 * Reads and processes requests from the QVT debugger. Only if the QVT engine is resumed (or the debug session is terminated), this method returns to proceed computing tasks.
	 * 
	 * Note that even if we are not in debug mode, we want to be able to process {@link QVTDebugRequestExit} requests
	 * 
	 */
	public void readNextRequest() {
		boolean processedRequest = false;
		do {
			processedRequest = false;
			// waitForNoEvents();
			QVTDebugRequest request = null;
			synchronized (this.requestQueue) {
				if (this.suspended) {
					while (this.requestQueue.isEmpty()) {
						try {
							this.requestQueue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				if (!this.requestQueue.isEmpty()) {
					request = (QVTDebugRequest) this.requestQueue.get(0);
					// System.out.print("received(" + request + ")");
					if (this.requestQueue.size() >= 2) {
						System.out.print("[" + this.requestQueue.size() + " pending requests!]");
					}
					try {
						request.handleRequest(this);
					} finally {
						this.requestQueue.remove(0);
						this.requestQueue.notifyAll(); // the reply can be read now from the other side..
					}
					processedRequest = true;
					// System.out.print("sendreply(" + request + ")");
				}
			}
			if (processedRequest) {
				// waitForProcessedRequest(request);
				if (request.getEvent() != null) {
					this.triggerEvent(request.getEvent());
				}
			}
		} while (processedRequest);
	}

	/**
	 * Waits until all events are fetched by the QVT debugger
	 * 
	 */
	private void waitForNoEvents() {
		synchronized (this.eventQueue) {
			try {
				while (!this.eventQueue.isEmpty()) {
					this.eventQueue.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Waits until the client fetched the reply of the request
	 * 
	 */
	private void waitForProcessedRequest(QVTDebugRequest request) {
		synchronized (this.requestQueue) {
			try {
				while (request.getReply() != null) {
					this.requestQueue.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public QVTDebugReply sendRequest(QVTDebugRequest request) throws InterruptedException {
		synchronized (this.requestQueue) {
			this.requestQueue.add(0, request);
			this.requestQueue.notifyAll();
			while (request.getReply() == null) {
				this.requestQueue.wait();
			}
			QVTDebugReply result = request.getReply();
			request.setReply(null);
			this.requestQueue.notifyAll();
			return result;
		}
	}

	public void resume(boolean resumeStepOver, boolean resumeStepReturn, boolean resumeStepInto, boolean resumeSilent) {
		this.suspended = false;
		if (!resumeSilent) {
			this.taskToStepOver = null;
			this.taskToStepIntoFrom = null;
			if (resumeStepOver) {
				this.taskToStepOver = this.getSuspendedTask();
			}
			if (resumeStepReturn) {
				this.taskToStepOver = this.getSuspendedTask().getCallerTask();
			}
			if (resumeStepInto) {
				this.taskToStepIntoFrom = this.getSuspendedTask();
				/*
				 * If we cannot step into, step over instead
				 */
				this.taskToStepOver = this.getSuspendedTask();
			}
			if (this.getSuspendedTask() != null) {
				this.lastDebugPosition = this.getSuspendedTask().currentDebugPosition();
			}
		}
	}

	public void suspend() {
		this.suspended = true;
	}

	public QvtSemanticTask getSuspendedTask() {
		return this.processor.getQvtEvaluator().getThreadPool().getCurrentComputedTask();
	}

	public void beforeComputingNextTask() {
		if (this.taskToStepOver != null) {
			this.taskToStepOver.bringToFront();
		}
	}

	public QvtProcessorImpl getQvtProcessor() {
		return this.processor;
	}

	public void setQvtProcessor(QvtProcessorImpl processor) {
		this.processor = processor;
	}

	public void startTransformation() {
		this.suspended = !this.getQvtProcessor().isPropertySet(QVTProcessorConsts.PROP_INITIALLY_RESUME_WHEN_DEBUGGING);
		this.terminated = false;
		this.triggerEvent(new QVTDebugEventStarted());
	}

	public void stopTransformation() {
		this.triggerEvent(new QVTDebugEventTerminated());
		synchronized (this.eventQueue) {
			this.terminated = true;
			/*
			 * notify about change in "terminated" state queried in dequeueEvent()
			 */
			this.eventQueue.notifyAll();
		}
	}

	public void suspendByException(Throwable e) {
		if (!this.getQvtProcessor().isPropertySet(QVTProcessorConsts.PROP_INITIALLY_RESUME_WHEN_DEBUGGING)) {
			this.suspended = true;
		}
		this.triggerEvent(new QVTDebugEventSuspended(new QVTDebugEventSuspendedEventCause(e)));
	}

}
