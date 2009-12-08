/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import de.ikv.medini.qvt.QVTProcessorConsts;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.execution.debug.QVTSourcePosition;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEvent;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventResumed;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventStarted;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventSuspended;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventSuspendedBreakpointCause;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventSuspendedStepCause;
import de.ikv.medini.qvt.execution.debug.events.QVTDebugEventTerminated;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReply;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyGetValue;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyOK;
import de.ikv.medini.qvt.execution.debug.replies.QVTDebugReplyStack;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequest;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestClearBreakpoint;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestGetValue;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestResume;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestSetBreakpoint;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestSetValue;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestStack;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestStepOver;
import de.ikv.medini.qvt.execution.debug.requests.QVTDebugRequestStepReturn;
import de.ikv.medini.qvt.execution.debug.stackframe.QVTDebugStackFrame;
import de.ikv.medini.qvt.execution.debug.stackframe.QVTStackFrameAssignable;
import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Test the QVT debugging API
 * 
 * @author kiegeland
 * 
 */
public class DebugTestCase extends QVTTestCase {

	private Object topPackage;

	private Object useCase1;

	private Object useCase2;

	private Object useCase3;

	private QvtProcessorImpl processor;

	protected ArrayList recordedEvents;

	/**
	 * Tests different debugging requests/replys/events
	 * 
	 * @throws FileNotFoundException
	 */
	public void testTraces5() throws FileNotFoundException {
		try {

			final String qvtFile = this.fullPath("usecase2activity.qvt");
			this.recordedEvents = new ArrayList();
			this.processor = (QvtProcessorImpl) this.adapter.getQvtProcessor();
			this.processor.setProperty(QVTProcessorConsts.PROP_ECLIPSE_DEBUG, "true");
			this.processor.setProperty(QVTProcessorConsts.PROP_TRANSFORMATION_PATH, qvtFile);

			Thread engineThread = new Thread(new Runnable() {
				public void run() {
					DebugTestCase.this.adapter.evaluateQVT(qvtFile, "usecase2activity", true, "forward");
				}
			});
			try {
				Thread eventThread = new Thread(new Runnable() {
					public void run() {
						try {
							QVTDebugEvent event;
							do {
								event = DebugTestCase.this.processor.getDebugAdapter().dequeueEvent();
								synchronized (DebugTestCase.this.recordedEvents) {
									DebugTestCase.this.recordedEvents.add(event);
									DebugTestCase.this.recordedEvents.notifyAll();
								}
								System.out.print("event(" + event + ")");
							} while (event != null);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
				engineThread.start();
				eventThread.start();
				QVTSourcePosition sourcePosition = new QVTSourcePosition(qvtFile, 41);

				Assert.assertTrue(this.getEvent() instanceof QVTDebugEventStarted);

				Assert.assertTrue(this.sendRequest(new QVTDebugRequestSetBreakpoint(sourcePosition)) instanceof QVTDebugReplyOK);

				Assert.assertTrue(this.sendRequest(new QVTDebugRequestResume()) instanceof QVTDebugReplyOK);
				Assert.assertEquals(new QVTDebugEventResumed(true), this.getEvent());
				Assert.assertEquals(new QVTDebugEventSuspended(new QVTDebugEventSuspendedBreakpointCause(sourcePosition)), this.getEvent());

				Assert.assertTrue(this.sendRequest(new QVTDebugRequestStepOver()) instanceof QVTDebugReplyOK);
				Assert.assertEquals(new QVTDebugEventResumed(false), this.getEvent());
				Assert.assertEquals(new QVTDebugEventSuspended(new QVTDebugEventSuspendedStepCause()), this.getEvent());

				QVTDebugReplyStack stack = (QVTDebugReplyStack) this.sendRequest(new QVTDebugRequestStack());
				Assert.assertEquals(2, stack.getFrames().size());

				Assert.assertTrue(this.sendRequest(new QVTDebugRequestStepReturn()) instanceof QVTDebugReplyOK);
				Assert.assertEquals(new QVTDebugEventResumed(false), this.getEvent());
				Assert.assertEquals(new QVTDebugEventSuspended(new QVTDebugEventSuspendedBreakpointCause(sourcePosition)), this.getEvent());

				Assert.assertTrue(this.sendRequest(new QVTDebugRequestClearBreakpoint(sourcePosition)) instanceof QVTDebugReplyOK);

				Assert.assertTrue(this.sendRequest(new QVTDebugRequestStepReturn()) instanceof QVTDebugReplyOK);
				Assert.assertEquals(new QVTDebugEventResumed(false), this.getEvent());
				Assert.assertEquals(new QVTDebugEventSuspended(new QVTDebugEventSuspendedStepCause()), this.getEvent());

				stack = (QVTDebugReplyStack) this.sendRequest(new QVTDebugRequestStack());
				Assert.assertEquals(1, stack.getFrames().size());
				QVTDebugStackFrame frame = (QVTDebugStackFrame) stack.getFrames().get(0);
				Assert.assertEquals(4, frame.getVariables().size());
				boolean brooksWasHere = false;
				for (QVTStackFrameAssignable var : (List<QVTStackFrameAssignable>) frame.getVariables()) {
					if (var.getName().equals("varName")) {
						QVTDebugReplyGetValue val1 = (QVTDebugReplyGetValue) this.sendRequest(new QVTDebugRequestGetValue(var));
						Assert.assertEquals("'Col1'", val1.toString());
						Assert.assertTrue(this.sendRequest(new QVTDebugRequestSetValue(var, "'Col2'")) instanceof QVTDebugReplyOK);
						QVTDebugReplyGetValue val2 = (QVTDebugReplyGetValue) this.sendRequest(new QVTDebugRequestGetValue(var));
						Assert.assertEquals("'Col2'", val2.toString());
						brooksWasHere = true;
					}
				}
				Assert.assertTrue("Variable 'varName' was not found in the stack frame!", brooksWasHere);

				Assert.assertTrue(this.sendRequest(new QVTDebugRequestResume()) instanceof QVTDebugReplyOK);
				Assert.assertEquals(new QVTDebugEventResumed(true), this.getEvent());
				Assert.assertTrue(this.getEvent() instanceof QVTDebugEventTerminated);
				Assert.assertTrue(this.getEvent() == null);

			} finally {
				engineThread.interrupt();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private QVTDebugEvent getEvent() throws InterruptedException {
		synchronized (this.recordedEvents) {
			while (this.recordedEvents.isEmpty()) {
				this.recordedEvents.wait();
			}
			return (QVTDebugEvent) this.recordedEvents.remove(0);
		}
	}

	private QVTDebugReply sendRequest(QVTDebugRequest request) throws InterruptedException {
		System.out.print("request(" + request + ")");
		QVTDebugReply result = this.processor.getDebugAdapter().sendRequest(request);
		System.out.print("reply(" + result + ")");
		return result;

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.topPackage = this.createModelElement(this.META_UMLPackage);
		this.adapter.setValueForFeature(this.topPackage, this.META_UMLNamedElement_name, "topLevelPackage1");

		this.useCase1 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(this.useCase1, this.META_UMLNamedElement_name, "useCase1");
		this.adapter.setValueForFeature(this.useCase1, this.META_UMLElement_the_owner, this.topPackage);

		this.useCase2 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(this.useCase2, this.META_UMLNamedElement_name, "useCase2");
		this.adapter.setValueForFeature(this.useCase2, this.META_UMLElement_the_owner, this.topPackage);

		this.useCase3 = this.createModelElement(this.META_UMLUseCase);
		this.adapter.setValueForFeature(this.useCase3, this.META_UMLNamedElement_name, "useCase3");
		this.adapter.setValueForFeature(this.useCase3, this.META_UMLElement_the_owner, this.topPackage);
	}

}
