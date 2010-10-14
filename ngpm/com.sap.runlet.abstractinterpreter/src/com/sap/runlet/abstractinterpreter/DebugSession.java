package com.sap.runlet.abstractinterpreter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;


/**
 * If a {@link DebugSession} is attached to a {@link AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType>}, the interpreter will
 * check for various sorts of breakpoints. The breakpoints are managed by an instance of this
 * class.<p>
 * 
 * Furthermore, an debug session offers the interfaces to suspend, resume and terminate
 * a running session. It also manages the stepping behavior of an interpreter in the sense
 * that it will negotiate with the interpreter when to suspend execution next, based on
 * the command given to the debug session, such as "step into" or "step over."<p>
 * 
 * The debug session is also the interface for remote-controlling the execution of an interpreter
 * in debug mode.
 * 
 * @author Axel Uhl (D043530)
 */
public class DebugSession {
    /**
     * The listener will be notified about suspend/resume/terminate/etc. events. May be <tt>null</tt>
     * which means that no events will be communicated by this session.
     */
    private DebugListener listener;
    
    /**
     * These are the elements at whose evaluation the interpreter to which this object is attached
     * is supposed to stop.
     */
    private Set<EObject> elementBreakpoints;
    
    /**
     * Step-into breakpoints, managed per {@link AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType> interpreter}. No need to remember
     * the stack level where this was requested because the interpreter will stop at the next
     * opportunity in any case, regardless the value because this is what "step into" is actually
     * asking for. Think about stepping into while at the end of a method...
     */
    private Set<AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>> stepIntoBreakpoints;
    
    /**
     * Step-over breakpoints, managed per {@link AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType> interpreter}. The value represents
     * the index of the stack frame <tt>s</tt> in {@link AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType>#getCallstack} such that when
     * <tt>t</tt> was the current stack frame when the "step over"
     * was issued, <tt>s</tt> is <tt>t</tt>'s outermost {@link StackFrame#getScopeParent() scope parent}
     * if <tt>t</tt> has a non-<tt>null</tt> scope parent, or <tt>t</tt> if <tt>t</tt> has no
     * scope parent.
     */
    private Map<AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>, Integer> stepOverBreakpoints;
    
    /**
     * Step-return breakpoints, managed per {@link AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType> interpreter}. The value represents
     * the index of the stack frame in {@link AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType>#getCallstack} where the "step return"
     * was issued.
     */
    private Map<AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>, Integer> stepReturnBreakpoints;
    
    /**
     * Contains those interpreters that shall be suspended. When one of those interpreters calls
     * to announce an evaluation, this will suspend that interpreter.
     */
    private Set<AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>> interpretersToSuspend;
    
    /**
     * For each interpreter can maintain the reason why the interpreter resumes
     */
    private Map<AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>, DebugListener.ResumeReason> resumeReasons;

    public DebugSession(DebugListener listener) {
	this.listener = listener;
	elementBreakpoints = new HashSet<EObject>();
	interpretersToSuspend = new HashSet<AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>();
	stepIntoBreakpoints = new HashSet<AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>>();
	stepOverBreakpoints = new HashMap<AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>, Integer>();
	stepReturnBreakpoints = new HashMap<AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>, Integer>();
	resumeReasons = new HashMap<AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>, DebugListener.ResumeReason>();
    }
    
    public void addBreakpoint(EObject elementToStopAt) {
	elementBreakpoints.add(elementToStopAt);
    }
    
    public void removeBreakpoint(EObject elementToNoLongerStopAt) {
	elementBreakpoints.remove(elementToNoLongerStopAt);
    }
    
    /**
     * Requests that the <tt>interpreter</tt> be suspended at the next possible point
     */
    public synchronized void suspend(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter) {
	interpretersToSuspend.add(interpreter);
    }
    
    /**
     * Resumes the interpreter if it is currently suspended or removes the request to
     * suspend it.
     * @param reason TODO
     */
    public synchronized void resume(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter, DebugListener.ResumeReason reason) {
	interpretersToSuspend.remove(interpreter);
	resumeReasons.put(interpreter, reason);
	notifyAll();
    }
    
    /**
     * An interpreter connected to this debug session calls this operation before each evaluation of
     * a model element and before it is set to {@link AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType>#isRunning()} for the first
     * evaluation. In case a breakpoint is set for the element or the interpreter is supposed to get
     * suspended, this method will block. If it was a breakpoint, the interpreter is entered into
     * those to be suspended. Only once the interpreter is resumed will the calling thread get
     * unblocked.
     */
    public void aboutToEvaluate(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter, EObject element) {
	if (!interpreter.isRunning()) {
	    if (listener != null) {
		listener.started(interpreter);
	    }
	}
	if (!interpreter.getCallstack().isEmpty()) {
	    interpreter.getCallstack().peek().setCurrentlyEvaluating(element);
	}
	boolean suspended = false;
	DebugListener.SuspendReason suspendReason = null;
	if (interpretersToSuspend.contains(interpreter)) {
	    suspendReason = DebugListener.SuspendReason.CLIENT_REQUEST;
	}
	if (elementBreakpoints.contains(element)) {
	    interpretersToSuspend.add(interpreter);
	    suspendReason = DebugListener.SuspendReason.BREAKPOINT;
	}
	suspendReason = setSuspendForInterpreterBasedOnSteppingRequests(interpreter, suspendReason);
	if (interpretersToSuspend.contains(interpreter) && listener != null) {
	    suspended = true;
	    listener.suspended(interpreter, suspendReason);
	}
	while (interpretersToSuspend.contains(interpreter)) {
	    synchronized(this) {
		try {
		    wait();
		} catch (InterruptedException e) {
		    // no problem; just try again
		}
	    }
	}
	if (suspended) {
	    if (listener != null) {
		listener.resumed(interpreter, resumeReasons.get(interpreter));
	    }
	}
    }

    private DebugListener.SuspendReason setSuspendForInterpreterBasedOnSteppingRequests(
	    AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter, DebugListener.SuspendReason suspendReason) {
	if (stepIntoBreakpoints.contains(interpreter)) {
	    interpretersToSuspend.add(interpreter); // step into means stop at the next opportunity
	    stepIntoBreakpoints.remove(interpreter);
	    suspendReason = DebugListener.SuspendReason.STEP_END;
	} else {
	    if (stepOverBreakpoints.containsKey(interpreter)) {
		int requestLevel = stepOverBreakpoints.get(interpreter);
		StackFrame<?, ?, ?, ?> currentFrame = null;
		int currentLevel = 0;
		if (interpreter.getCallstack().size() > 0) {
		    currentFrame = interpreter.getCallstack().peek();
		    while (currentFrame.getScopeParent() != null) {
			currentFrame = currentFrame.getScopeParent();
		    }
		    currentLevel = interpreter.getCallstack().indexOf(currentFrame);
		}
		if (currentLevel <= requestLevel) {
		    interpretersToSuspend.add(interpreter);
		    stepOverBreakpoints.remove(interpreter);
		    suspendReason = DebugListener.SuspendReason.STEP_END;
		}
	    }
	    if (stepReturnBreakpoints.containsKey(interpreter)) {
		int requestLevel = stepReturnBreakpoints.get(interpreter);
		StackFrame<?, ?, ?, ?> currentFrame = null;
		int currentLevel = 0;
		if (interpreter.getCallstack().size() > 0) {
		    currentFrame = interpreter.getCallstack().peek();
		    while (currentFrame.getScopeParent() != null) {
			currentFrame = currentFrame.getScopeParent();
		    }
		    currentLevel = interpreter.getCallstack().indexOf(currentFrame);
		}
		if (currentLevel < requestLevel) {
		    interpretersToSuspend.add(interpreter);
		    stepReturnBreakpoints.remove(interpreter);
		    suspendReason = DebugListener.SuspendReason.STEP_END;
		}
	    }
	}
	return suspendReason;
    }
    
    protected void terminated(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter) {
	if (listener != null) {
	    listener.terminated(interpreter);
	}
    }

    public boolean isSuspended(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter) {
	return interpretersToSuspend.contains(interpreter);
    }

    public void stepInto(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter) {
	stepIntoBreakpoints.add(interpreter);
	resume(interpreter, DebugListener.ResumeReason.STEP_INTO);
    }

    public void stepOver(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter) {
	stepOverBreakpoints.put(interpreter, interpreter.getCallstack().size()-1);
	resume(interpreter, DebugListener.ResumeReason.STEP_OVER);
    }

    public void stepReturn(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter) {
	stepReturnBreakpoints.put(interpreter, interpreter.getCallstack().size()-1);
	resume(interpreter, DebugListener.ResumeReason.STEP_RETURN);
    }
}
