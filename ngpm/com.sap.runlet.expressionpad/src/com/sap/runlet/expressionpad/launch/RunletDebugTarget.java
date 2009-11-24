package com.sap.runlet.expressionpad.launch;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;

import com.sap.runlet.abstractinterpreter.AbstractObjectFormatter;
import com.sap.runlet.abstractinterpreter.AbstractRunletInterpreter;
import com.sap.runlet.abstractinterpreter.DebugListener;
import com.sap.runlet.abstractinterpreter.DebugSession;
import com.sap.runlet.expressionpad.Activator;
import com.sap.runlet.expressionpad.RunletEvaluator;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class RunletDebugTarget
extends DebugElement implements IDebugTarget, DebugListener {
    private RunletEvaluator main;
    private AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> topLevelInterpreter;
    private AbstractObjectFormatter<?, ?, ?, ?> formatter;
    private ILaunch launch;
    private Date launchedAt;
    private String name;
    private IProcess process;
    
    /**
     * The connection to the interpreter
     */
    private DebugSession debugSession;
    
    public RunletDebugTarget(RunletEvaluator main, ILaunch launch, String name, AbstractObjectFormatter<?, ?, ?, ?> formatter) {
	super(/*nested debug target*/ null);
	this.main = main;
	this.topLevelInterpreter = main.getInterpreter();
	this.launch = launch;
	this.formatter = formatter;
	launchedAt = new Date();
	this.name = name;
	this.process = new RunletProcess(this);
	this.debugSession = new DebugSession(this);
	this.topLevelInterpreter.setDebugSession(getDebugSession());
	fireCreationEvent();
    }
    
    public int hashCode() {
	return getDebugSession().hashCode();
    }
    
    public boolean equals(Object o) {
	boolean result = false;
	if (o instanceof RunletDebugTarget) {
	    result = getDebugSession().equals(((RunletDebugTarget) o).getDebugSession());
	}
	return result;
    }

    @Override
    public String getName() {
	return Messages.RunletDebugTarget_0+name+Messages.RunletDebugTarget_1+launchedAt;
    }

    @Override
    public IProcess getProcess() {
	return process;
    }

    @Override
    public RunletThread[] getThreads() {
	List<IThread> result = new LinkedList<IThread>();
	if (!isDisconnected()) {
	    result.addAll(getThreadsForInterpreter(getInterpreter()));
	}
	return result.toArray(new RunletThread[result.size()]);
    }

    private Collection<RunletThread> getThreadsForInterpreter(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter) {
	Collection<RunletThread> threads = new LinkedList<RunletThread>();
	threads.add(new RunletThread(interpreter, getLaunch(), this, formatter));
	for (AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> child : interpreter.getRunningChildren()) {
	    threads.addAll(getThreadsForInterpreter(child));
	}
	return threads;
    }

    @Override
    public boolean hasThreads() {
	return true;
    }

    @Override
    public boolean supportsBreakpoint(IBreakpoint breakpoint) {
	return true;
    }

    @Override
    public ILaunch getLaunch() {
	return launch;
    }

    @Override
    public String getModelIdentifier() {
	return Activator.PLUGIN_ID;
    }

    @Override
    public boolean canTerminate() {
	return !isDisconnected() && !isTerminated();
    }

    @Override
    public boolean isTerminated() {
	return getInterpreter() == null || getInterpreter().isTerminated();
    }

    @Override
    public void terminate() throws DebugException {
	for (IThread thread:getThreads()) {
	    thread.terminate();
	}
    }

    @Override
    public boolean canResume() {
	return !isDisconnected() && isSuspended();
    }

    @Override
    public boolean canSuspend() {
	if (isTerminated() || isSuspended()) {
	    return false;
	}
	for (IThread thread : getThreads()) {
	    if (!thread.canSuspend()) {
		return false;
	    }
	}
	return true;
    }

    @Override
    public boolean isSuspended() {
	for (IThread thread : getThreads()) {
	    if (!thread.isSuspended()) {
		return false;
	    }
	}
	return true;
    }

    @Override
    public void resume() throws DebugException {
	for (IThread thread : getThreads()) {
	    thread.resume();
	}
    }

    @Override
    public void suspend() throws DebugException {
	for (IThread thread:getThreads()) {
	    thread.suspend();
	}
    }

    @Override
    public void breakpointAdded(IBreakpoint breakpoint) {
	// TODO Auto-generated method stub

    }

    @Override
    public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
	// TODO Auto-generated method stub

    }

    @Override
    public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
	// TODO Auto-generated method stub

    }

    @Override
    public boolean canDisconnect() {
	return !isDisconnected();
    }

    @Override
    public void disconnect() {
    	topLevelInterpreter = null;
    }

    @Override
    public boolean isDisconnected() {
	return topLevelInterpreter == null;
    }

    @Override
    public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
	throw new DebugException(new Status(Status.ERROR, Activator.PLUGIN_ID, Messages.RunletDebugTarget_3));
    }

    @Override
    public boolean supportsStorageRetrieval() {
	return false;
    }

    public AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> getInterpreter() {
        return topLevelInterpreter;
    }

    public RunletEvaluator getMain() {
        return main;
    }

    protected DebugSession getDebugSession() {
        return debugSession;
    }
    
    @Override
    public void started(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter) {
	for (RunletThread thread : getThreadsForInterpreter(interpreter)) {
	    thread.fireCreationEvent();
	}
    }

    @Override
    public void hitBreakpoint(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter, RefObject element) {
	for (RunletThread thread : getThreadsForInterpreter(interpreter)) {
	    thread.fireSuspendEvent(DebugEvent.BREAKPOINT);
	}
    }

    @Override
    public void resumed(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter, ResumeReason reason) {
	for (RunletThread thread : getThreadsForInterpreter(interpreter)) {
	    int detail;
	    switch (reason) {
	    case STEP_INTO:
	    	    detail = DebugEvent.STEP_INTO; break;
	    case STEP_OVER:
	    	    detail = DebugEvent.STEP_OVER; break;
	    case STEP_RETURN:
	    	    detail = DebugEvent.STEP_RETURN; break;
	    case CLIENT_REQUEST:
	    	    detail = DebugEvent.CLIENT_REQUEST; break;
	    default:
	    	    detail = DebugEvent.UNSPECIFIED; break;
	    }
	    thread.fireResumeEvent(detail);
	}
    }

    @Override
    public void suspended(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter, SuspendReason reason) {
	for (RunletThread thread : getThreadsForInterpreter(interpreter)) {
	    int detail;
	    switch (reason) {
	    case BREAKPOINT:
	    	    detail = DebugEvent.BREAKPOINT; break;
	    case CLIENT_REQUEST:
	    	    detail = DebugEvent.CLIENT_REQUEST; break;
	    case STEP_END:
	    	    detail = DebugEvent.STEP_END; break;
	    default:
	    	    detail = DebugEvent.UNSPECIFIED; break;
	    }
	    thread.fireSuspendEvent(detail);
	}
    }

    @Override
    public void terminated(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter) {
	for (RunletThread thread : getThreadsForInterpreter(interpreter)) {
	    thread.fireTerminateEvent();
	}
	if (interpreter == getInterpreter()) { // the root died
	    fireTerminateEvent();
	}
    }

    @Override
    public IDebugTarget getDebugTarget() {
	return this;
    }
}
