package com.sap.tc.moin.repository.shared.logger;

/**
 * The interface TraceContext defines the trace context.
 * <p>
 * The context object provides some context relevant information, for example
 * MRI of the model element, etc. To provide this information, the context
 * object must implement the TraceContext interface
 * (com.sap.tc.moin.repository.shared.logger.TraceContext) - implement the
 * getMessage() method. The MOIN Logger calls this method automatically if the
 * message is printed to the log and / or trace file.
 * 
 * @author d029324
 */
public interface TraceContext {

    /**
     * The getMessage() method returns the context relevant information (text)
     * which should enlarge the understanding of the particular message and is
     * reported in the MOIN-specific log and or trace file.
     * 
     * @return the context-related object message
     */
    public String getMessage( );
}
