package com.sap.tc.moin.friends;


/**
 * A <code>ProgressMonitor</code> is a communication object between a long
 * running Command and the UI. For the moment, this abstract class is intended
 * to be sub-classed only by MI, to adapt the Eclipse implementation of
 * IProgressMonitor.
 * <p>
 * All activity is broken down into a linear sequence of tasks against which
 * progress is reported. When a task begins, a <code>beginTask(String, int)
 * </code> notification is reported,
 * followed by any number and mixture of progress reports (<code>worked()</code>
 * ). When the task is eventually completed, a <code>done()</code> notification
 * is reported. After the <code>done()</code> notification, the progress monitor
 * cannot be reused; i.e., <code>
 * beginTask(String, int)</code> cannot be called again
 * after the call to <code>done()</code>. This methods are triggered by the
 * CommandStack on Commands execution.
 * </p>
 * <p>
 * A ProgressMonitor object also tracks any request to cancel from the UI.
 * Commands are expected to poll the monitor (using then CommandStack)
 * periodically and abort at their earliest convenience. Commands can however
 * choose to ignore cancelation requests.
 * </p>
 */
public abstract class ProgressMonitor {

    /**
     * Constant indicating an unknown amount of work.
     */
    public final static int UNKNOWN = -1;

    /**
     * Notifies that the main task is beginning. This must only be called once
     * on a given progress monitor instance.
     * 
     * @param name the name (or description) of the main task
     * @param totalWork the total number of work units into which the main task
     * is been subdivided. If the value is <code>UNKNOWN</code> the
     * implementation is free to indicate progress in a way which doesn't
     * require the total number of work units in advance.
     */
    public abstract void beginTask( String name, int totalWork );

    /**
     * Notifies that the work is done; that is, either the main task is
     * completed or the user canceled it. This method may be called more than
     * once (implementations should be prepared to handle this case).
     */
    public abstract void done( );

    /**
     * Returns whether cancelation of current operation has been requested.
     * Long-running operations should poll to see if cancelation has been
     * requested.
     * 
     * @return <code>true</code> if cancellation has been requested, and
     * <code>false</code> otherwise
     * @see #setCanceled(boolean)
     */
    public abstract boolean isCanceled( );


    /**
     * Notifies that a given number of work unit of the main task has been
     * completed. Note that this amount represents an installment, as opposed to
     * a cumulative amount of work done to date.
     * 
     * @param work a non-negative number of work units just completed
     */
    public abstract void worked( int work );
}
