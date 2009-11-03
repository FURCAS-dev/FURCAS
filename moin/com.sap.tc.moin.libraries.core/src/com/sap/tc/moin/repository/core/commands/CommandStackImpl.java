/**
 * 
 */
package com.sap.tc.moin.repository.core.commands;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.management.MBeanNotificationInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;

import com.sap.tc.moin.friends.CommandStackObserver;
import com.sap.tc.moin.friends.ProgressMonitor;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.core.CoreCommandStack;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.transactions.AbstractTransaction;
import com.sap.tc.moin.repository.core.transactions.RootTransactionListener;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.jmx.CommandStackMBean;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.FastStack;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.core.SpiEventManager;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.transactions.TransactionRecord;

/**
 * @author D045996
 */
@SuppressWarnings( "nls" )
public class CommandStackImpl implements CoreCommandStack, RootTransactionListener {

    /**
     * Modes for direct JMI calls: WRAP_IN_COMMAND wrap direct JMI calls in a
     * Command. EXCEPTION for debugging purposes, throw an exception.
     */
    public enum AutoCommandMode {
        /**
         * wrap in command
         */
        WRAP_IN_COMMAND,
        /**
         * exception
         */
        EXCEPTION
    }

    private boolean EXCEPTION_ON_DIRECT_JMI_CALL = Boolean.getBoolean( "com.sap.tc.moin.ExceptionOnDirectJMICall" ); //$NON-NLS-1$

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_COMMANDS, CommandStackImpl.class );

    private int MaxUndoStackSize = 30;

    // Do not access the variable directly! use getUndoStack() instead
    private FastStack<InternalCommand> _undoStack = new FastStack<InternalCommand>( this.MaxUndoStackSize );

    private FastStack<InternalCommand> redoStack = new FastStack<InternalCommand>( this.MaxUndoStackSize );

    private FastStack<InternalCommandGroup> openGroupStack = new FastStack<InternalCommandGroup>( 4 );

    private StackState state = StackState.WAITING;

    private CoreConnection connection;

    // Exception that causes the stack to go into ERROR state.
    private Throwable errorException;

    /**
     * The name identifying this command stack in JMX.
     */
    private ObjectName objectName;

    /**
     * The MBean instance that gets registered in the MBeanServer. We need it
     * for the emission of JMX notifications.
     */
    private JmxAdapter jmxAdapter;

    /**
     * Whether the emission of JMX notifications is currently enabled.
     */
    public volatile boolean jmxNotificationsEnabled;

    /**
     * Thread local for "attachCommandStack" and "detachCommandStack"
     */
    private static ThreadLocal<CommandStack> currentCommandStack = new ThreadLocal<CommandStack>( );

    /**
     * @param connection
     */
    public CommandStackImpl( CoreConnection connection ) {

        this.connection = connection;
        if ( JMX_ENABLED ) {
            try {
                String sessionId = connection.getId( );
                if ( sessionId != null ) {
                    int pos = sessionId.indexOf( '-' );
                    if ( pos != -1 ) {
                        String connId = sessionId.substring( pos + 1 );
                        sessionId = sessionId.substring( 0, pos );
                        this.objectName = new ObjectName( MOIN_DOMAIN + "type=CommandStack,moin=" + connection.getSession( ).getMoin( ).getId( ) + ",session=" + sessionId + ",connection=" + connId ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        this.jmxAdapter = new JmxAdapter( this, this.objectName, connection.getSession( ).getMoin( ).getReferenceQueue( ) );
                    }
                }
            } catch ( MalformedObjectNameException e ) {
                throw new RuntimeException( e );
            } catch ( NullPointerException e ) {
                throw new RuntimeException( e );
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.commands.CommandStack#getUndoStack()
     */
    public List<CommandHandle> getUndoStack( ) {

        List<? extends CommandHandle> list = getInternalUndoStack( );
        return Collections.unmodifiableList( list );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.commands.CommandStack#getRedoStack()
     */
    public List<CommandHandle> getRedoStack( ) {

        List<? extends CommandHandle> list = this.redoStack;
        return Collections.unmodifiableList( list );
    }

    private SpiEventManager getEventManager( ) {

        return ( this.connection.getSession( ) ).getEventManager( );
    }

    /***************************************************************************
     * * Execute Methods *
     **************************************************************************/

    public CommandHandle execute( Command command ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        throw new UnsupportedOperationException( );
    }

    // Used to follow the Command->subCommand deep 
    int _commandLevel = 0;

    public CommandHandle executeInternal( Command command ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        checkError( );
        Connection cmdConnection = command.getConnection( );
        if ( cmdConnection instanceof Wrapper ) {
            cmdConnection = ( (Wrapper<CoreConnection>) cmdConnection ).unwrap( );
        }
        if ( cmdConnection != this.connection ) {
            throw new CommandBugException( CommandsExceptionMessages.FOREIGNCONNECTION, "execute()" ); //$NON-NLS-1$
        }
        InternalExecutableCommand iCmd = new InternalExecutableCommand( command );
        if ( this.state == StackState.WAITING ) {
            // It is a Root Command
            attachCommandStack( );
            this._commandLevel = 1;
            if ( this._progressMonitor != null ) {
                this._progressMonitor.beginTask( command.getDescription( ), command.getTotalWork( ) );
            }

            if ( !isGroupOpen( ) ) {
                getEventManager( ).beginUpdate( this.connection );
            }
            this.state = StackState.EXECUTING;
            try {
                getEventManager( ).beginCommand( this.connection ); // command

                if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                    long duration = System.nanoTime( );
                    this.jmxAdapter.commandExecuteStart( iCmd.getDescription( ), Thread.currentThread( ).getStackTrace( ) );
                    iCmd._execute( );
                    duration = ( System.nanoTime( ) - duration ) / 1000000;
                    this.jmxAdapter.commandExecuteEnd( iCmd.getDescription( ), duration );
                } else {
                    iCmd._execute( );
                }

                this.redoStack.clear( );
                if ( iCmd.canUndo( ) ) {
                    getInternalUndoStack( ).push( iCmd );
                    enforceMaxUndoStackSize( );
                } else {
                    getInternalUndoStack( ).clear( );
                }
                this.state = StackState.WAITING;
                detachCommandStack( );
                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( MoinSeverity.INFO, "Root Command '" + command.getDescription( ) + "' ended. (Connection: " + this.connection.getId( ) + ")" );
                }
                // Note that after commit event should be fired after stack
                // state is
                // set to WAITING!
                getEventManager( ).postCommitCommand( this.connection ); // command
                if ( !isGroupOpen( ) ) {
                    getEventManager( ).deliverUpdate( this.connection );
                    notifyTopLevelCommandExecution( iCmd, this.connection );
                }

            } catch ( UnrecoverableExecutionException rtex ) {
                this.state = StackState.ERROR;
                detachCommandStack( );
                this.errorException = rtex;
                getEventManager( ).cancelCommand( this.connection ); // command
                if ( !isGroupOpen( ) ) {
                    getEventManager( ).cancelUpdate( this.connection );
                }
                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( rtex, MoinSeverity.INFO, "UnrecoverableExecutionException while executing root Command " + command.getDescription( ) + ". (Connection: " + this.connection.getId( ) + ")", null );
                }
                throw rtex;
            } catch ( RuntimeException ex ) {
                this.state = StackState.WAITING;
                detachCommandStack( );
                getEventManager( ).cancelCommand( this.connection ); // command
                if ( !isGroupOpen( ) ) {
                    getEventManager( ).cancelUpdate( this.connection );
                }
                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( ex, MoinSeverity.INFO, "Root Command '" + command.getDescription( ) + "' rolled-back.", null );
                }

                throw ex;
            } catch ( Error rterr ) {
                // Any other ERROR should set the state to ERROR!
                this.state = StackState.ERROR;
                detachCommandStack( );
                this.errorException = rterr;
                getEventManager( ).cancelCommand( this.connection ); // command
                if ( !isGroupOpen( ) ) {
                    getEventManager( ).cancelUpdate( this.connection );
                }
                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( rterr, MoinSeverity.INFO, "Error while executing root Command '" + command.getDescription( ) + "'.", null );
                }
                throw rterr;
            } finally {
                if ( this._progressMonitor != null ) {
                    this._progressMonitor.done( );
                }
                this._progressMonitor = null;
                this._commandLevel = 0;
            }
        } else if ( this.state == StackState.EXECUTING ) {
            // It is a sub command
            try {
                this._commandLevel++;
                if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                    long duration = System.nanoTime( );
                    this.jmxAdapter.commandExecuteStart( iCmd.getDescription( ), Thread.currentThread( ).getStackTrace( ) );
                    iCmd._execute( );
                    duration = ( System.nanoTime( ) - duration ) / 1000000;
                    this.jmxAdapter.commandExecuteEnd( iCmd.getDescription( ), duration );
                } else {
                    iCmd._execute( );
                }
                // notifyCommandExecuted(iCmd, false);
                return null;
            } catch ( RuntimeException re ) {
                // notifyCommandCancelled(iCmd, false);
                throw re;
            } finally {
                this._commandLevel--;
            }
        } else {
            throw new CommandBugException( CommandsExceptionMessages.ILLEGALCALLWITHSTATE, "execute()", this.state ); //$NON-NLS-1$
        }
        return iCmd;
    }

    /***************************************************************************
     * * Undo Methods *
     **************************************************************************/

    public boolean canUndo( ) {

        return ( !getInternalUndoStack( ).isEmpty( ) );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.commands.CommandStack#undo()
     */
    public void undo( ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        checkError( );

        if ( this.state != StackState.WAITING ) {
            throw new MoinIllegalStateException( CommandsExceptionMessages.ILLEGALCALLWITHSTATE, "undo()", this.state );
        }
        if ( !canUndo( ) ) {
            throw new CommandBugException( CommandsExceptionMessages.EMPTYUNDOSTACK, "undo()" ); //$NON-NLS-1$
        }
        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Undo Command '" + getInternalUndoStack( ).peek( ).getDescription( ) + "'. (Connection: " + this.connection.getId( ) + ")" );
        }
        undoTop( );

    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.commands.CommandStack#canUndo(com.sap.tc.moin
     * .repository.commands.CommandHandle)
     */
    public boolean canUndo( CommandHandle cmd ) {

        return ( canUndo( ) && getInternalUndoStack( ).peek( ).equals( cmd ) );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.commands.CommandStack#undo(com.sap.tc.moin
     * .repository.commands.CommandHandle)
     */
    public void undo( CommandHandle cmd ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        if ( this.state != StackState.WAITING ) {
            throw new CommandBugException( CommandsExceptionMessages.ILLEGALCALLWITHSTATE, "undo()", this.state ); //$NON-NLS-1$
        }
        if ( !canUndo( cmd ) ) {
            throw new CommandBugException( CommandsExceptionMessages.NOTONTOP, "undo()" ); //$NON-NLS-1$
        }

        undoTop( );
    }

    private InternalCommand undoTop( ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        InternalCommand iCmd = getInternalUndoStack( ).pop( );
        try {
            if ( !isGroupOpen( ) ) {
                getEventManager( ).beginUpdate( this.connection );
            }
            this.state = StackState.UNDOING;
            getEventManager( ).beginCommand( this.connection ); // iCmd.getUndoableCommand()
            if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                long duration = System.nanoTime( );
                this.jmxAdapter.commandUndoStart( iCmd.getDescription( ), Thread.currentThread( ).getStackTrace( ) );
                iCmd._undo( );
                duration = ( System.nanoTime( ) - duration ) / 1000000;
                this.jmxAdapter.commandUndoEnd( iCmd.getDescription( ), duration );
            } else {
                iCmd._undo( );
            }
            // notifyCommandUndone(iCmd, true);
            if ( iCmd.canRedo( ) ) {
                this.redoStack.push( iCmd );
            } else {
                this.redoStack.clear( );
            }
            this.state = StackState.WAITING;
        } catch ( UnrecoverableExecutionException rbEx ) {
            this.state = StackState.ERROR;
            this.errorException = rbEx;
            getEventManager( ).cancelCommand( this.connection ); // iCmd.getUndoableCommand()
            if ( !isGroupOpen( ) ) {
                getEventManager( ).cancelUpdate( this.connection );
            }
            throw rbEx;
        } catch ( RuntimeException ex ) {
            getInternalUndoStack( ).push( iCmd );
            this.state = StackState.WAITING;
            getEventManager( ).cancelCommand( this.connection ); // iCmd.getUndoableCommand()
            if ( !isGroupOpen( ) ) {
                getEventManager( ).cancelUpdate( this.connection );
            }
            throw ex;
        }
        getEventManager( ).postCommitCommand( this.connection ); // iCmd.getUndoableCommand()
        if ( !isGroupOpen( ) ) {
            getEventManager( ).deliverUpdate( this.connection );
            notifyTopLevelCommandUndone( iCmd, this.connection );
        }
        return iCmd;
    }

    /***************************************************************************
     * * Redo Methods *
     **************************************************************************/

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.commands.CommandStack#canRedo()
     */
    public boolean canRedo( ) {

        return ( !this.redoStack.isEmpty( ) );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.commands.CommandStack#redo()
     */
    public void redo( ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        checkError( );

        if ( this.state != StackState.WAITING ) {
            throw new MoinIllegalStateException( CommandsExceptionMessages.ILLEGALCALLWITHSTATE, "redo()", this.state ); //$NON-NLS-1$
        }
        if ( !canRedo( ) ) {
            throw new CommandBugException( CommandsExceptionMessages.EMPTYREDOSTACK, "redo()" ); //$NON-NLS-1$
        }
        redoTop( );

    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.commands.CommandStack#canRedo(com.sap.tc.moin
     * .repository.commands.CommandHandle)
     */
    public boolean canRedo( CommandHandle cmd ) {

        return ( canRedo( ) && this.redoStack.peek( ).equals( cmd ) );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.commands.CommandStack#redo(com.sap.tc.moin
     * .repository.commands.CommandHandle)
     */
    public void redo( CommandHandle cmd ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        checkError( );

        if ( this.state != StackState.WAITING ) {
            throw new CommandBugException( CommandsExceptionMessages.ILLEGALCALLWITHSTATE, "redo()", this.state ); //$NON-NLS-1$
        }
        if ( !canRedo( cmd ) ) {
            throw new CommandBugException( CommandsExceptionMessages.NOTONTOP, "redo()" ); //$NON-NLS-1$
        }
        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Redo Command '" + this.redoStack.peek( ).getDescription( ) + "'. (Connection: " + this.connection.getId( ) + ")" );
        }
        redoTop( );
    }

    private InternalCommand redoTop( ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        InternalCommand iCmd = this.redoStack.pop( );
        try {
            this.state = StackState.REDOING;
            if ( !isGroupOpen( ) ) {
                getEventManager( ).beginUpdate( this.connection );
            }
            getEventManager( ).beginCommand( this.connection ); // iCmd.getUndoableCommand()
            if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                long duration = System.nanoTime( );
                this.jmxAdapter.commandRedoStart( iCmd.getDescription( ), Thread.currentThread( ).getStackTrace( ) );
                iCmd._redo( );
                duration = ( System.nanoTime( ) - duration ) / 1000000;
                this.jmxAdapter.commandRedoEnd( iCmd.getDescription( ), duration );
            } else {
                iCmd._redo( );
            }
            // notifyCommandRedone(iCmd, true);
            if ( iCmd.canUndo( ) ) {
                getInternalUndoStack( ).push( iCmd );
            } else {
                getInternalUndoStack( ).clear( );
            }
            this.state = StackState.WAITING;
        } catch ( ExecutionRollbackFailedException ex ) {
            this.state = StackState.ERROR;
            this.errorException = ex;
            getEventManager( ).cancelCommand( this.connection ); // iCmd.getUndoableCommand()
            if ( !isGroupOpen( ) ) {
                getEventManager( ).cancelUpdate( this.connection );
            }
            throw ex;
        } catch ( RuntimeException rex ) {
            cleanupAfterExceptionOnRedo( iCmd );
            throw rex;
        } catch ( AssertionError ae ) {
            cleanupAfterExceptionOnRedo( iCmd );
            throw ae;
        }
        getEventManager( ).postCommitCommand( this.connection ); // iCmd.getUndoableCommand()
        if ( !isGroupOpen( ) ) {
            getEventManager( ).deliverUpdate( this.connection );
            notifyTopLevelCommandRedone( iCmd, this.connection );
        }
        return iCmd;
    }

    private void cleanupAfterExceptionOnRedo( InternalCommand iCmd ) {

        this.state = StackState.WAITING;
        this.redoStack.push( iCmd );
        getEventManager( ).cancelCommand( this.connection ); // iCmd.getUndoableCommand()
        if ( !isGroupOpen( ) ) {
            getEventManager( ).cancelUpdate( this.connection );
        }
        // notifyCommandRedoCancelled(iCmd, true);
    }

    /***************************************************************************
     * * Command Group Methods *
     **************************************************************************/

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.commands.CommandStack#openGroup(java.lang.
     * String)
     */
    public void openGroup( String groupDescription ) {

        checkError( );

        // pre: (state == WAITING)
        if ( this.state != StackState.WAITING ) {
            throw new IllegalStateException( "Illegal openGroup() call: state is: " + this.state ); //$NON-NLS-1$
        }
        if ( !isGroupOpen( ) ) {
            getEventManager( ).beginUpdate( this.connection );
        }
        InternalCommandGroup group = new InternalCommandGroup( this.connection, groupDescription );
        this.openGroupStack.push( group );
        this.redoStack.clear( );
        if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
            this.jmxAdapter.commandGroupOpen( groupDescription, Thread.currentThread( ).getStackTrace( ) );
        }
        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Command Group '" + groupDescription + "' opened. (Connection: " + this.connection.getId( ) + ")" );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.commands.CommandStack#setGroupDescription(
     * java.lang.String)
     */
    public void setGroupDescription( String groupDescription ) {

        if ( !isGroupOpen( ) ) {
            throw new CommandBugException( CommandsExceptionMessages.ILLEGALSETGROUPDESC, "setGroupDescription()" ); //$NON-NLS-1$
        }
        InternalCommandGroup icg = this.openGroupStack.peek( );
        icg.setDescription( groupDescription );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.commands.CommandStack#closeGroup()
     */
    public CommandHandle closeGroup( ) {

        checkError( );

        // pre: (isGroupOpen()) && (state == WAITING)
        if ( !isGroupOpen( ) ) {
            throw new IllegalStateException( "Illegal closeGroup() call: no open group" ); //$NON-NLS-1$
        }
        if ( this.state != StackState.WAITING ) {
            throw new CommandBugException( CommandsExceptionMessages.ILLEGALCALLWITHSTATE, "closeGroup()", this.state ); //$NON-NLS-1$
        }
        InternalCommandGroup icg = this.openGroupStack.pop( );
        // CommandGroup newGroup = new CommandGroup(connection,
        // icg.getDescription());
        // only if the group contains at least one command
        CommandHandle result = null;
        if ( icg.closeGroup( ) ) {
            getInternalUndoStack( ).push( icg );
            enforceMaxUndoStackSize( );
            this.redoStack.clear( );
            result = icg;
        }
        if ( !isGroupOpen( ) ) {
            getEventManager( ).deliverUpdate( this.connection );
            notifyTopLevelCommandExecution( result, this.connection );
        }

        if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
            this.jmxAdapter.commandGroupClose( icg.getDescription( ), Thread.currentThread( ).getStackTrace( ) );
        }
        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Command Group '" + icg.getDescription( ) + "' closed. (Connection: " + this.connection.getId( ) + ")" );
        }
        return result;

    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.commands.CommandStack#cancelGroup()
     */
    public synchronized void cancelGroup( ) {

        try {
            closeGroup( );
            undo( );
        } catch ( Exception e ) {
            throw new UnrecoverableExecutionException( e, CommandsExceptionMessages.CANCELGROUPFAILED );
        }
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.commands.CommandStack#isGroupOpen()
     */
    public boolean isGroupOpen( ) {

        return !this.openGroupStack.isEmpty( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.commands.CommandStack#isCommandRunning()
     */
    public boolean isCommandRunning( ) {

        return getState( ).isRunning( );
    }

    /**
     * Called for diagnostic purposes from within
     * ConnectionImpl.JmxAdapter.getCommandGroupStack().
     */
    public Collection<InternalCommandGroup> getCommandGroupStack( ) {

        return Collections.unmodifiableCollection( this.openGroupStack );
    }

    private FastStack<InternalCommand> getInternalUndoStack( ) {

        if ( isGroupOpen( ) ) {
            return this.openGroupStack.peek( ).getUndoStack( );
        } else {
            return this._undoStack;
        }
    }

    /***************************************************************************
     * * Other Methods *
     **************************************************************************/

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.commands.CommandStack#clear()
     */
    public void clear( ) {

        if ( this.state != StackState.WAITING && this.state != StackState.ERROR ) {
            throw new MoinIllegalStateException( CommandsExceptionMessages.ILLEGALCLEARCALLSTATE, this.state );
        }
        getInternalUndoStack( ).clear( );
        this.redoStack.clear( );
        if ( !isGroupOpen( ) ) {
            notifyCommandStackCleaned( this.connection );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.commands.CommandStack#getMaxUndoStackSize()
     */
    public int getMaxUndoStackSize( ) {

        return this.MaxUndoStackSize;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.commands.CommandStack#setMaxUndoStackSize(int)
     */
    public void setMaxUndoStackSize( int maxSize ) {

        if ( this.state != StackState.WAITING ) {
            throw new MoinIllegalStateException( CommandsExceptionMessages.ILLEGALSETMAXUNDOSTACKSIZECALLSTATE, this.state );
        }
        this.MaxUndoStackSize = maxSize;
    }

    // Internal Methods

    public StackState getState( ) {

        return this.state;
    }

    public Collection getUndoStackContent( ) {

        return (Collection) getInternalUndoStack( ).clone( );
    }

    public Collection getRedoStackContent( ) {

        return (Collection) this.redoStack.clone( );
    }

    private void enforceMaxUndoStackSize( ) {

        if ( getInternalUndoStack( ).size( ) > this.MaxUndoStackSize && ( !isGroupOpen( ) ) ) {
            getInternalUndoStack( ).remove( 0 );
        }
    }

    private void checkError( ) {

        if ( this.state == StackState.ERROR ) {
            throw new MoinIllegalStateException( CommandsExceptionMessages.COMMANDSTACKINERRORSTATE, this.errorException );
        }
    }

    /**
     * Logging location for this class
     */
    // private static final com.sap.tc.logging.Location log =
    // com.sap.tc.logging.Location.getLocation(CommandStackImpl.class);
    /***************************************************************************
     * * JMI Wrapping (callback) Methods *
     **************************************************************************/

    private AutoCommandMode autoCommandMode = AutoCommandMode.WRAP_IN_COMMAND;

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.commands.CommandStack#getAutoCommandMode()
     */
    public AutoCommandMode getAutoCommandMode( ) {

        return this.autoCommandMode;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.commands.CommandStack#setAutoCommandMode(com
     * .sap.tc.moin.repository.commands.CommandStack.AutoCommandMode)
     */
    public void setAutoCommandMode( AutoCommandMode mode ) {

        this.autoCommandMode = mode;
    }

    String wrappingCommandDesc;

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.core.transactions.RootTransactionListener#
     * rootTransactionStarted
     * (com.sap.tc.moin.repository.core.transactions.AbstractTransaction)
     */
    public void rootTransactionStarted( AbstractTransaction tx ) {

        // This method is called by the TransactionManager, each time a new
        // RootTx is started.
        // This root Tx can be either a microTx, in the case of a simple
        // JMI-call, or a
        // Tx, for the case of derived attributes/associations and meta
        // operations.
        checkError( );

        if ( this.state == StackState.EXECUTING ) {
            // This case means that we are already in a command.
            return;
        } else if ( this.state == StackState.WAITING ) {
            // This means, no command has been started -> Direct JMI call
            if ( this.autoCommandMode == AutoCommandMode.EXCEPTION ) {
                throw new ExecutionCancelledException( );
            }
            if ( this.EXCEPTION_ON_DIRECT_JMI_CALL && !isGroupOpen( ) ) {
//                throw new ExecutionCancelledException( "Direct JMI outside Command Group!!!", null );
                //System.err.println("Direct JMI call outside Command Group.");
                if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                    logger.trace( new Exception( ), MoinSeverity.WARNING, "Direct JMI call outside Command Group. (Connection: " + this.connection.getId( ) + ")", null );
                }
            }
            /*
             * When a foreign JMI wrapper is used in a command, it will be
             * interpreted as a direct JMI in the foreign CommandStack. We use
             * this to detect such illegal calls
             */
            attachCommandStack( );
            if ( !isGroupOpen( ) ) {
                getEventManager( ).beginUpdate( this.connection );
            }
            this.wrappingCommandDesc = "Direct JMI Call"; //$NON-NLS-1$
            getEventManager( ).beginCommand( this.connection );
            this.state = StackState.WRAPPING;
        } else {
            throw new CommandBugException( CommandsExceptionMessages.OPERATIONWRONGSTATE, "rootTransactionStarted()", this.state ); //$NON-NLS-1$
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.core.transactions.RootTransactionListener#
     * rootTransactionCancelled
     * (com.sap.tc.moin.repository.core.transactions.AbstractTransaction)
     */
    public void rootTransactionCancelled( AbstractTransaction tx ) {

        if ( this.state == StackState.EXECUTING ) {
            // No wrapping (already in a command) -> ignore
            return;
        } else if ( this.state == StackState.WRAPPING ) {
            // Note: It is not necessary to check autoCommandMode, because the
            // EXCEPTION case should
            // be handled in the rootTransactionStarted
            getEventManager( ).cancelCommand( this.connection );
            this.wrappingCommandDesc = null;
            this.state = StackState.WAITING;
            detachCommandStack( );
            if ( !isGroupOpen( ) ) {
                getEventManager( ).cancelUpdate( this.connection );
            }
        } else {
            throw new CommandBugException( CommandsExceptionMessages.OPERATIONWRONGSTATE, "rootTransactionCancelled()", this.state ); //$NON-NLS-1$
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.core.transactions.RootTransactionListener#
     * rootTransactionEnded
     * (com.sap.tc.moin.repository.transactions.TransactionRecord)
     */
    public void rootTransactionEnded( TransactionRecord record ) {

        checkError( );
        if ( this.state == StackState.EXECUTING ) {
            // No wrapping (already in a command) -> ignore
            return;
        } else if ( this.state == StackState.WRAPPING ) {
            // Note: It is not necessary to check autoCommandMode, because the
            // EXCEPTION case should
            // be handled in the rootTransactionStarted
            InternalCommand ic = new InternalWrappingCommand( this.connection, this.wrappingCommandDesc, record );
            ic.txRecord = record;

            this.redoStack.clear( );
            if ( ic.canUndo( ) ) {
                getInternalUndoStack( ).push( ic );
                enforceMaxUndoStackSize( );
            } else {
                getInternalUndoStack( ).clear( );
            }
            // notifyCommandExecuted(ic, true);
            this.wrappingCommandDesc = null;
            this.state = StackState.WAITING;
            detachCommandStack( );
            // Note that after commit event should be fired after stack state is
            // set to WAITING!
            getEventManager( ).postCommitCommand( this.connection );
            if ( !isGroupOpen( ) ) {
                getEventManager( ).deliverUpdate( this.connection );
                notifyTopLevelCommandExecution( ic, this.connection );
            }
        } else {
            throw new CommandBugException( CommandsExceptionMessages.OPERATIONWRONGSTATE, "rootTransactionEnded()", this.state ); //$NON-NLS-1$
        }
    }

    /**
     * This method is called each time a new root command is executed, including
     * JMI auto wrapping. We attach the CommandStack to the thread in order to
     * be able to detect usage of JMI wrappers coming from a foreign connection
     * and direct execution of a foreign sub-command. throw
     * IllegalStateException if any CommandStack already attached to the local
     * thread
     */
    public void attachCommandStack( ) {

        if ( currentCommandStack.get( ) != null ) {
            throw new MoinIllegalStateException( CommandsExceptionMessages.JMIOBJECTFROMDIFFERENTCONNECTIONACCESSED );
        }
        currentCommandStack.set( this );
    }

    public void detachCommandStack( ) {

        currentCommandStack.remove( );
    }


    private ProgressMonitor _progressMonitor;

    public void setProgressMonitor( ProgressMonitor progressMonitor ) {

        this._progressMonitor = progressMonitor;
    }

    public void reportProgress( int worked ) {

        if ( this._progressMonitor != null ) {
            // Check cancellation
            if ( this._progressMonitor.isCanceled( ) ) {
                throw new ExecutionCancelledException( );
            }
            if ( this._commandLevel == 1 ) {
                // Only report progress for Root commands!
                this._progressMonitor.worked( worked );
            }
        }

    }


    // ----------------------------------------------------------------------
    /***************************************************************************
     * * CommandStackObserver-related Methods *
     **************************************************************************/
    private CommandStackObserver _observer;

    public void setCommandStackObserver( CommandStackObserver observer ) {

        this._observer = observer;
    }

    public void notifyBeforeRootCommandExecution( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

        if ( this._observer != null ) {
//            CoreConnection previousConnection = ConnectionImpl.getCurrentConnection( );
//            try {
            this._observer.notifyBeforeRootCommandExecution( cmd, affectedPartitions );
//            } finally {
//                if ( previousConnection != null && previousConnection != ConnectionImpl.getCurrentConnection( ) ) {
//                    previousConnection.attachToThread( );
//                }
//            }
        }
    }

    private void notifyTopLevelCommandExecution( CommandHandle cmdHnd, CoreConnection con ) {

        if ( this._observer != null ) {
//            CoreConnection previousConnection = ConnectionImpl.getCurrentConnection( );
//            try {
            this._observer.notifyTopLevelCommandExecuted( cmdHnd, con.getWrapper( ) );
//            } finally {
//                if ( previousConnection != null && previousConnection != ConnectionImpl.getCurrentConnection( ) ) {
//                    previousConnection.attachToThread( );
//                }
//            }
        }
    }

    private void notifyTopLevelCommandUndone( CommandHandle cmdHnd, CoreConnection con ) {

        if ( this._observer != null ) {
//            CoreConnection previousConnection = ConnectionImpl.getCurrentConnection( );
//            try {
            this._observer.notifyTopLevelCommandUndone( cmdHnd, con.getWrapper( ) );
//            } finally {
//                if ( previousConnection != null && previousConnection != ConnectionImpl.getCurrentConnection( ) ) {
//                    previousConnection.attachToThread( );
//                }
//            }
        }
    }

    private void notifyTopLevelCommandRedone( CommandHandle cmdHnd, CoreConnection con ) {

        if ( this._observer != null ) {
//            CoreConnection previousConnection = ConnectionImpl.getCurrentConnection( );
//            try {
            this._observer.notifyTopLevelCommandRedone( cmdHnd, con.getWrapper( ) );
//            } finally {
//                if ( previousConnection != null && previousConnection != ConnectionImpl.getCurrentConnection( ) ) {
//                    previousConnection.attachToThread( );
//                }
//            }
        }
    }

    private void notifyCommandStackCleaned( CoreConnection con ) {

        if ( this._observer != null ) {
//            CoreConnection previousConnection = ConnectionImpl.getCurrentConnection( );
//            try {
            this._observer.notifyTopLevelStacksCleared( con.getWrapper( ) );
//            } finally {
//                if ( previousConnection != null && previousConnection != ConnectionImpl.getCurrentConnection( ) ) {
//                    previousConnection.attachToThread( );
//                }
//            }
        }
    }

    public static boolean isCommandRunningInCurrentThread( ) {

        return currentCommandStack.get( ) != null;
    }

    public CommandStackObserver getCommandStackObserver( ) {

        return this._observer;
    }


    // ----------------------------------------------------------------------

    public ObjectName getObjectName( ) {

        return this.objectName;
    }

    private static final class JmxAdapter extends NotificationBroadcasterSupport implements CommandStackMBean {

        /**
         * Sequence number if JMX notifications need to be emitted.
         */
        private AtomicLong seqNo = new AtomicLong( 0 );

        private final WeakReferenceWithObjectName<CommandStackImpl> commandStackRef;

        private final ObjectName objectName;

        private final String commandStackId;

        JmxAdapter( CommandStackImpl commandStack, ObjectName objectName, ReferenceQueue refQueue ) {

            this.objectName = objectName;
            this.commandStackRef = new WeakReferenceWithObjectName<CommandStackImpl>( commandStack, objectName, refQueue );
            registerBroadcastingMBean( this, CommandStackMBean.class, objectName );
            this.commandStackId = "Session=" + objectName.getKeyProperty( "session" ) + ",Connection=" + objectName.getKeyProperty( "connection" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        }

        @Override
        public MBeanNotificationInfo[] getNotificationInfo( ) {

            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( CommandStackMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by a CommandStack MBean" ) }; //$NON-NLS-1$
            return notifsInfo;
        }

        public void startNotifications( ) throws IOException {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                commandStack.jmxNotificationsEnabled = true;
            }
        }

        public boolean notificationsStarted( ) throws IOException {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                return commandStack.jmxNotificationsEnabled;
            }
            return false;
        }

        public void stopNotifications( ) throws IOException {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                commandStack.jmxNotificationsEnabled = false;
            }
        }

        public void commandGroupOpen( String groupDescription, StackTraceElement[] stackTrace ) {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                String message = this.commandStackId + ",Desc=" + groupDescription; //$NON-NLS-1$
                Notification notification = new Notification( CommandStackMBean.COMMAND_GROUP_OPEN, this.objectName, this.seqNo.incrementAndGet( ), message );
                notification.setUserData( stackTrace );
                sendNotification( notification );
            }
        }

        public void commandGroupClose( String groupDescription, StackTraceElement[] stackTrace ) {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                String message = this.commandStackId + ",Desc=" + groupDescription; //$NON-NLS-1$
                Notification notification = new Notification( CommandStackMBean.COMMAND_GROUP_CLOSE, this.objectName, this.seqNo.incrementAndGet( ), message );
                notification.setUserData( stackTrace );
                sendNotification( notification );
            }
        }

        public void commandExecuteStart( String commandDescription, StackTraceElement[] stackTrace ) {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                String message = this.commandStackId + ",Desc=" + commandDescription; //$NON-NLS-1$
                Notification notification = new Notification( CommandStackMBean.COMMAND_EXECUTE_START, this.objectName, this.seqNo.incrementAndGet( ), message );
                notification.setUserData( stackTrace );
                sendNotification( notification );
            }
        }

        public void commandExecuteEnd( String commandDescription, long duration ) {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                String message = this.commandStackId + ",Desc=" + commandDescription; //$NON-NLS-1$
                Notification notification = new Notification( CommandStackMBean.COMMAND_EXECUTE_END, this.objectName, this.seqNo.incrementAndGet( ), message );
                if ( duration > 0 ) {
                    notification.setUserData( "Time=" + duration + "ms" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                sendNotification( notification );
            }
        }

        public void commandUndoStart( String commandDescription, StackTraceElement[] stackTrace ) {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                String message = this.commandStackId + ",Desc=" + commandDescription; //$NON-NLS-1$
                Notification notification = new Notification( CommandStackMBean.COMMAND_UNDO_START, this.objectName, this.seqNo.incrementAndGet( ), message );
                notification.setUserData( stackTrace );
                sendNotification( notification );
            }
        }

        public void commandUndoEnd( String commandDescription, long duration ) {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                String message = this.commandStackId + ",Desc=" + commandDescription; //$NON-NLS-1$
                Notification notification = new Notification( CommandStackMBean.COMMAND_UNDO_END, this.objectName, this.seqNo.incrementAndGet( ), message );
                if ( duration > 0 ) {
                    notification.setUserData( "Time=" + duration + "ms" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                sendNotification( notification );
            }
        }

        public void commandRedoStart( String commandDescription, StackTraceElement[] stackTrace ) {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                String message = this.commandStackId + ",Desc=" + commandDescription; //$NON-NLS-1$
                Notification notification = new Notification( CommandStackMBean.COMMAND_REDO_START, this.objectName, this.seqNo.incrementAndGet( ), message );
                notification.setUserData( stackTrace );
                sendNotification( notification );
            }
        }

        public void commandRedoEnd( String commandDescription, long duration ) {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                String message = this.commandStackId + ",Desc=" + commandDescription; //$NON-NLS-1$
                Notification notification = new Notification( CommandStackMBean.COMMAND_REDO_END, this.objectName, this.seqNo.incrementAndGet( ), message );
                if ( duration > 0 ) {
                    notification.setUserData( "Time=" + duration + "ms" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                sendNotification( notification );
            }
        }

        public String[] getCommandGroupStack( ) throws IOException {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                Collection<InternalCommandGroup> commandGroupStack = commandStack.getCommandGroupStack( );
                List<String> result = new ArrayList<String>( commandGroupStack.size( ) );
                for ( InternalCommandGroup group : commandGroupStack ) {
                    result.add( 0, group.getDescription( ) );
                }
                return result.toArray( new String[result.size( )] );
            }
            return null;
        }

        public String[] getCommandsOnUndoStack( ) {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                Collection commands = commandStack.getUndoStackContent( );
                List<String> result = new ArrayList<String>( commands.size( ) );
                for ( Iterator it = commands.iterator( ); it.hasNext( ); ) {
                    InternalCommand command = (InternalCommand) it.next( );
                    result.add( 0, command.getDescription( ) );
                }
                return result.toArray( new String[result.size( )] );
            }
            return null;
        }

        public String[] getCommandsOnRedoStack( ) {

            CommandStackImpl commandStack = this.commandStackRef.get( );
            if ( commandStack != null ) {
                Collection commands = commandStack.getRedoStackContent( );
                List<String> result = new ArrayList<String>( commands.size( ) );
                for ( Iterator it = commands.iterator( ); it.hasNext( ); ) {
                    InternalCommand command = (InternalCommand) it.next( );
                    result.add( 0, command.getDescription( ) );
                }
                return result.toArray( new String[result.size( )] );
            }
            return null;
        }
    }

    public void destroy( ) {

        this._undoStack = null;
        this.redoStack = null;
        this.openGroupStack = null;
        this.connection = null;
        this.errorException = null;
        this.objectName = null;
        this.jmxAdapter = null;
    }
}
