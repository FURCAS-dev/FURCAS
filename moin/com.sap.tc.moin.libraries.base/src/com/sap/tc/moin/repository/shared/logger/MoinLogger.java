package com.sap.tc.moin.repository.shared.logger;

import java.text.MessageFormat;

import com.sap.tc.moin.repository.exception.MoinExternalizedString;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * The MOIN Logging and Tracing API
 * <p>
 * Wraps the SAP Logging and Tracing API and provides one homogeneous interface
 * which covers the Category and Location functionality and automatically
 * redirect the messages to the associated log and/or trace files (Category
 * and/or Location).
 * <p>
 * To obtain a new MOIN Logger, application code should use the the getLogger()
 * factory method of the {@link MoinLoggerFactory} class.
 * <p>
 * The MOIN Logger expects a Category that is predefined in the MoinCategoryEnum
 * class and is a sub-Category of the <tt>/Applications/Moin</tt> parent
 * Category.
 * <p>
 * The used Location name must be a logical-defined Location name that is
 * predefined in the MoinLocationEnum class and is a sub-Location of the
 * <tt>com.sap.moin</tt> parent Location.
 * <p>
 * The MOIN severities (see {@link MoinSeverity}) are mapped to SAP Logging and
 * Tracing severities. Message parameter replacement is done using
 * {@link MessageFormat}
 * 
 * @author d029324
 */

public interface MoinLogger {

    /**
     * Prints the message to the log and trace files
     * <p>
     * 
     * @param severity MOIN severity
     * @param message the message pattern or constant
     * @param args message parameters used for parameter replacement
     */
    public void logAndTrace( MoinSeverity severity, MoinLocalizedString message, Object... args );

    /**
     * Prints the message and the exception to the log and trace files
     * <p>
     * 
     * @param throwable the exception
     * @param severity MOIN severity
     * @param message message defined as message constant, created with the S2X
     * editor
     * @param args message parameters
     */
    public void logAndTrace( Throwable throwable, MoinSeverity severity, MoinLocalizedString message, Object... args );


    /**
     * Prints the message and the exception to the log and trace files
     * <p>
     * Allows reporting of the message context.
     * <p>
     * The context object may provide context relevant information, for example
     * MRI of the model element, etc. To provide this information, the context
     * object must implement the {@link TraceContext} interface.
     * 
     * @param throwable the exception
     * @param context context object which implements the TraceContext interface
     * @param severity MOIN severity
     * @param message message defined as message constant, created with the S2X
     * editor
     * @param args message parameters
     */
    public void logAndTrace( Throwable throwable, TraceContext context, MoinSeverity severity, MoinLocalizedString message, Object... args );

    /**
     * Prints the message and the exception to the log and trace files
     * <p>
     * This logAndTrace() method allows an automatically reporting of the
     * message context.
     * <p>
     * This logAndTrace() method uses the Java reflection functionality to
     * determine the context (all {@link String} member variables of the context
     * object) and prints it as additional information to the log and trace
     * file.
     * 
     * @param throwable the exception
     * @param context context object
     * @param severity MOIN severity
     * @param message message defined as message constant, created with the S2X
     * editor
     * @param args message parameters
     */
    public void logAndTrace( Throwable throwable, Object context, MoinSeverity severity, MoinLocalizedString message, Object... args );

    /**
     * Prints the message and a stack trace to the trace file
     * <p>
     * 
     * @param severity MOIN severity
     * @param message message
     * @param args message parameters
     */
    public void traceWithStack( MoinSeverity severity, String message, Object... args );

    /**
     * Prints the message and a stack trace to the trace file
     * <p>
     * 
     * @param severity MOIN severity
     * @param message message
     * @param args message parameters
     */
    public void traceWithStack( MoinSeverity severity, MoinExternalizedString message, Object... args );

    /**
     * Prints the message and the Exception to the trace file
     * <p>
     * 
     * @param throwable
     * @param severity MOIN severity
     * @param message message
     * @param args message parameters
     */
    public void trace( Throwable throwable, MoinSeverity severity, String message, Object... args );

    /**
     * @param sev
     * @param message
     * @param e
     * @deprecated can lead to ambiguous parameter assignments due to vargs; use
     * {@link #trace(Throwable throwable, MoinSeverity severity, String message, Object... args )}
     * instead
     */
    @Deprecated
    public void trace( MoinSeverity sev, String message, Throwable e );

    /**
     * Prints the message and the Exception to the trace file
     * <p>
     * Allows reporting of the message context, see
     * {@link #logAndTrace(Throwable, TraceContext, MoinSeverity, MoinLocalizedString, Object...)}
     * 
     * @param throwable
     * @param context
     * @param severity MOIN severity
     * @param message message
     * @param args message parameters
     */
    public void trace( Throwable throwable, TraceContext context, MoinSeverity severity, MoinExternalizedString message, Object... args );

    /**
     * Prints the message and the Exception to the trace file
     * <p>
     * Allows reporting of the message context, see
     * {@link #logAndTrace(Throwable, Object, MoinSeverity, MoinLocalizedString, Object...)}
     * 
     * @param throwable
     * @param context
     * @param severity MOIN severity
     * @param message message
     * @param args message parameters
     */
    public void trace( Throwable throwable, Object context, MoinSeverity severity, MoinExternalizedString message, Object... args );

    /**
     * Prints the message and the Exception to the trace file
     * 
     * @param severity MOIN severity
     * @param message message
     * @param args message parameters
     */
    public void trace( MoinSeverity severity, String message, Object... args );

    /**
     * Prints the message and the Exception to the trace file
     * <p>
     * 
     * @param exception
     * @param severity MOIN severity
     * @param message message
     * @param args message parameters
     */
    public void trace( Throwable exception, MoinSeverity severity, MoinExternalizedString message, Object... args );

    /**
     * Prints the message and the Exception to the trace file
     * <p>
     * 
     * @param exception the localized MOIN Exception
     * @param severity MOIN severity
     */
    public void trace( MoinLocalizedBaseException exception, MoinSeverity severity );

    /**
     * Prints the message and the Exception to the trace file
     * <p>
     * 
     * @param exception the localized MOIN Exception
     * @param severity MOIN severity
     */
    public void trace( MoinLocalizedBaseRuntimeException exception, MoinSeverity severity );

    /**
     * Prints the message to the trace file
     * <p>
     * 
     * @param message the localized MOIN Exception
     * @param severity MOIN severity
     * @param args message parameters
     */
    public void trace( MoinSeverity severity, MoinExternalizedString message, Object... args );


    /**
     * The isLoggedOrTraced() method checks the current effective severity level
     * of the particular Log Controller
     * <p>
     * The isLoggedOrTraced() method returns true if the message with this
     * particular severity (see MoinSeverity severity parameter) is logged or
     * traced; this means printed to the log or trace file. Otherwise the
     * isLoggedOrTraced() method returns false.
     * <p>
     * This method checks the severity of Category and Location and therefore
     * should be used together with the logAndTrace() methods.
     * 
     * @param severity MOIN severity
     * @return true if the used / checked severity allows the printing to the
     * log or trace file
     */
    public boolean isLoggedOrTraced( MoinSeverity severity );

    /**
     * The isTraced() method checks the current effective severity level of the
     * particular Log Controller.
     * <p>
     * The isTraced() method returns true if the message with this particular
     * severity (see MoinSeverity severity parameter) is traced; this means
     * printed to the trace file. Otherwise the isTraced() method returns false.
     * <p>
     * This mehtod checks the Location severity and therefore should be used
     * together with the trace(), entering() and exiting() methods.
     * 
     * @param severity MOIN severity
     * @return true if the used / checked severity allows the printing to the
     * trace file
     */
    public boolean isTraced( MoinSeverity severity );

}
