package com.sap.runlet.abstractinterpreter;

import org.eclipse.emf.ecore.EObject;


/**
 * To be implemented by those who register for events from a {@link DebugSession}
 * 
 * @author Axel Uhl (D043530)
 */
public interface DebugListener {
    public static enum ResumeReason {
	/**
	 * Step start detail. Indicates a thread was resumed by a step into action.
	 */
	STEP_INTO,

	/**
	 * Step start detail. Indicates a thread was resumed by a step over action.
	 */
	STEP_OVER,

	/**
	 * Step start detail. Indicates a thread was resumed by a step return action.
	 */
	STEP_RETURN,

	/**
	 * Client request detail. Indicates a thread was suspended due to a client request.
	 */
	CLIENT_REQUEST
    }

    public static enum SuspendReason {
	/**
	 * Step end detail. Indicates a thread was suspended due to the completion of a step action.
	 */
	STEP_END,

	/**
	 * Breakpoint detail. Indicates a thread was suspended by a breakpoint.
	 */
	BREAKPOINT,
	/**
	 * Client request detail. Indicates a thread was suspended due to a client request.
	 */
	CLIENT_REQUEST
    }

    void started(
	    AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter);

    void resumed(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter, ResumeReason reason);

    void suspended(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter, SuspendReason reason);

    void terminated(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter);

    void hitBreakpoint(AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> interpreter, EObject element);
}
