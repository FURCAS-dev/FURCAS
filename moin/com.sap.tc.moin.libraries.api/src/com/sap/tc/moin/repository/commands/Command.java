/**
 * 
 */
package com.sap.tc.moin.repository.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;

/**
 * Basis class to be used for creating new domain specific undoable commands. To
 * create a new command, a derived class must be created, which implements the
 * abstract methods. Undo and Redo functionality is provided by MOIN. <br>
 * <H1>Code you can('t) use inside doExecute() </H1>
 * <B>Does:</B> Automatic Undo support is provided for following calls:
 * <ul>
 * <li> Any JMI call </li>
 * <ul>
 * <li>Reflective API </li>
 * <li>Generated API </li>
 * <li>Modeled operations (operations included in a Metamodel)</li>
 * </ul>
 * <li> Partition Creation / Deletion</li>
 * <li> Partition Assignment</li>
 * <li> Another MOIN (sub-)Command</li>
 * </ul>
 * <br>
 * <B>Don'ts:</B> In the doExecute() method of a command you should NOT:
 * <ul>
 * <li> Undo / redo subcommands</li>
 * <li> Expect to find an executed sub command in the undo stack</li>
 * <li> Execute a command more than once</li>
 * <li> Undo / Redo an executed command</li>
 * <li> Open / Close command groups</li>
 * <li> Save/Revert a Connection</li>
 * <li> Perform any action that would require manual reversion on rollback or
 * undo</li>
 * </ul>
 * <br>
 * <p>
 * This class <i>is</i> intended to be extended by clients.
 * @see CommandStack
 * @author D045996
 */
public abstract class Command {

    /**
     * Moin Connection used for undoing / redoing the command,
     */
    private final Connection conn;

    private final String description;

    /**
     * Basis constructor for a MoinCommand, to be executed in the given
     * connection.
     * 
     * @param connection to be used to execute the command.
     */
    protected Command( Connection connection ) {

        this( connection, null );
    }

    /**
     * Basis constructor for a MoinCommand, to be executed in the given
     * connection.
     * 
     * @param connection to be used to execute the command.
     */
    protected Command( Connection connection, String description ) {

        this.conn = connection;
        this.description = description;
    }

    /**
     * This method contains the code with the modification logic. It must be
     * implemented by each specific command. <br>
     * <B>Very Important:</B> Never call this method directly!
     * <P>
     * As the implementation of the undo functionality is provided by the MOIN
     * core, only supported repository operations can be included in this
     * method:
     * <UL>
     * <LI>Reflective and generated JMI
     * <LI>Partition creation & deletion
     * <LI>Partition assignment
     * <LI>MoinCommand
     * </UL>
     * Usual exception handling can be used to prevent roll-back of the whole
     * command in case of exceptions when modifying the repository. It must be
     * avoided to make more than one API call in each try block, as it cannot be
     * determined which of the calls produced the exception, and it will not be
     * clear which modifications were rolled/back.
     */
    abstract public void doExecute( );

    /**
     * Tells whether executing the command would fail.
     * <p>
     * Note that even if this method returns true, the command can still fail.
     * As this method is to be used for GUI feedback, it should not take longer
     * than 0.5 secs.
     * 
     * @return false if the command would fail, true otherwise.
     */
    public abstract boolean canExecute( );

    /**
     * Execute the command.
     * 
     * @return The command handle.
     */
    public CommandHandle execute( ) {

        return conn.getCommandStack( ).execute( this );
    }

    /**
     * @return The set of partitions that will be modified when executing the
     * command.
     */
    public abstract Collection<PartitionOperation> getAffectedPartitions( );

    /**
     * @return The connection.
     */
    public Connection getConnection( ) {

        return conn;
    }

    /**
     * @return The description of the command.
     */
    public String getDescription( ) {

        return description;
    }

    /**
     * Executes a sub command.
     */
    protected CommandHandle executeSubCommand( Command command ) {

        return conn.getCommandStack( ).execute( command );
    }

    /**
     * Can be used by Commands to report progress as a given number of work
     * units, that have been completed since the last report. Note that this
     * amount represents an installment, as opposed to a cumulative amount of
     * work done to date. If the Execution has been cancelled by the end user,
     * then an ExecutionCancelledException will be thrown.
     * 
     * @param worked a non-negative number of work units just completed
     * @throws ExecutionCancelledException
     */
    protected void reportProgress( int worked ) throws ExecutionCancelledException {

        conn.getCommandStack( ).reportProgress( worked );

    }

    /**
     * Returns the total work units to be worked-out during the command
     * execution
     * 
     * @return
     */
    public int getTotalWork( ) {

        // This is the default value with the semantic "UNKNOWN"
        return -1;
    }

    /**
     * Logging location for this class
     */
    //private static final com.sap.tc.logging.Location log = com.sap.tc.logging.Location.getLocation(ExecutableCommand.class);
}
