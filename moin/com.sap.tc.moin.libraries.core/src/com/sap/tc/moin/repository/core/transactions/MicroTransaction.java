package com.sap.tc.moin.repository.core.transactions;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.framework.simple.SessionEventManagerSimple;
import com.sap.tc.moin.repository.core.transactions.actions.ActionExecutor;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.actions.Action;

/**
 * Responsible for the execution, revert, undo and redo of a
 * {@link MicroTransactionable}.
 */
public class MicroTransaction extends AbstractTransaction {

    MicroTransactionable microTransactionable;

    public MicroTransaction( TransactionManagerImpl aTransactionManager, MicroTransactionable aMicroTransactionable ) {

        super( aTransactionManager );
        microTransactionable = aMicroTransactionable;
    }

    @Override
    protected void doExecute( ) throws UnrecoverableExecutionException, RecoverableExecutionException, JmiException, NullPointerException {

        try {
            // check pre constraints
            microTransactionable.assertDoPreConstraints( );
            // preparation
            microTransactionable.computeDoActionsAndDoEvents( );
            // fire pre events
            List<ChangeEvent> doEvents = microTransactionable.getDoEvents( );
            if ( doEvents != null ) {
//                long time = System.currentTimeMillis();
                for ( int i = 0; i < doEvents.size( ); i++ ) {
                    ChangeEvent event = doEvents.get( i );
                    txManager.getEventManager( ).firePreChangeEvent( event );
                }
//                System.err.println("Time doing pre change events:" + (System.currentTimeMillis() - time));
            }
            // acquire micro write lock after firing pre events but before
            // executing the actions
            List<Action> doActions = microTransactionable.getDoActions( );
            if ( doActions != null ) {
                executedActions = new ArrayList<Action>( doActions.size( ) );
                // acquire micro write lock
                acquireMicroWriteLock( );
                try {
                    // do actions
                    for ( int i = 0; i < doActions.size( ); i++ ) {
                        Action action = doActions.get( i );
                        ActionExecutor.executeAction( action );
                        executedActions.add( action );
                    }
                    // check post constraints
                    microTransactionable.assertDoPostConstraints( );
                    // check immediate constraints
                    // OclServiceImpl.getInstance().checkImmediateConstraints();
                } finally {
                    // release the write lock for synchronization before firing
                    // the
                    // post events
                    releaseMicroWriteLock( );
                }
            }
            // fire post events
            if ( doEvents != null ) {
                ((SessionEventManagerSimple)txManager.getEventManager( )).filtered = 0;
//                long time = System.currentTimeMillis();
                for ( int i = 0; i < doEvents.size( ); i++ ) {
                    ChangeEvent event = doEvents.get( i );
                    txManager.getEventManager( ).fireChangeEvent( event );
                }
//                System.err.println("Time doing post change for " +  doEvents.size( ) + " events:" + (System.currentTimeMillis() - time) + ". Afer filtering: " + ((SessionEventManagerSimple)txManager.getEventManager( )).filtered );
            }
            // Only add this MicroTx to the record when successfully executed!
            txManager.getRecord( ).addMicroTx( this );
        } catch ( JmiException jmiEx ) {
            throw jmiEx;
        } catch ( NullPointerException nullPointerEx ) {
            throw nullPointerEx;
        } catch ( RecoverableExecutionException recoverableExecutionEx ) {
            throw recoverableExecutionEx;
        } catch ( UnrecoverableExecutionException unrecoverableExecutionEx ) {
            throw unrecoverableExecutionEx;
        }
//        catch ( VetoException vetoEx ) {
//            throw new RecoverableExecutionException( vetoEx );
//        }
        // VetoException handling generalized for all MoinBaseRuntimeExceptions (MM)
        catch ( MoinBaseRuntimeException moinBaseRuntimeEx ) {
            throw new RecoverableExecutionException( moinBaseRuntimeEx );
        } catch ( RuntimeException runtimeEx ) {
            throw new UnrecoverableExecutionException( runtimeEx );
        } finally {
            microTransactionable.doFinished( );
        }
    }

    @Override
    protected void rollbackExecute( ) {

        if ( executedActions == null ) {
            return;
        }
        acquireMicroWriteLock( );
        try {
            // TODO Make sure that this call ignores inconsistencies
            List<Action> actionsToRevert = ActionExecutor.reverseActionList( executedActions );
            for ( int i = 0; i < actionsToRevert.size( ); i++ ) {
                Action action = actionsToRevert.get( i );
                ActionExecutor.revertAction( action );
            }
        } finally {
            releaseMicroWriteLock( );
        }
    }

    // Undo including rollback in case of failure (if possible)
    public void undo( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, JmiException, NullPointerException {

        try {
            doUndo( );
        } catch ( UnrecoverableExecutionException unrecoverableTransactionEx ) {
            throw unrecoverableTransactionEx;
        } catch ( RuntimeException runtimeEx ) {
            try {
                rollbackUndo( );
            } catch ( RuntimeException runtimeEx2 ) {
                throw new ExecutionRollbackFailedException( runtimeEx, runtimeEx2 );
            }
            if ( runtimeEx instanceof RecoverableExecutionException ) {
                throw (RuntimeException) runtimeEx.getCause( );
            }
            throw runtimeEx;
        }
    }

    void doUndo( ) throws UnrecoverableExecutionException, RecoverableExecutionException, JmiException, NullPointerException {

        try {
            // check pre constraints
            microTransactionable.assertUndoPreConstraints( );
            // preparation
            microTransactionable.computeUndoActionsAndUndoEvents( );
            // fire pre events
            List<ChangeEvent> undoEvents = microTransactionable.getUndoEvents( );
            if ( undoEvents != null ) {
                for ( int i = 0; i < undoEvents.size( ); i++ ) {
                    txManager.getEventManager( ).firePreChangeEvent( undoEvents.get( i ) );
                }
            }
            // acquire micro write lock after firing pre events but before
            // executing the actions
            List<Action> undoActions = microTransactionable.getUndoActions( );
            if ( undoActions != null ) {
                executedActions = new ArrayList<Action>( undoActions.size( ) );
                // acquire micro write lock
                acquireMicroWriteLock( );
                try {
                    // undo actions
                    for ( int i = 0; i < undoActions.size( ); i++ ) {
                        Action undoAction = undoActions.get( i );
                        ActionExecutor.executeAction( undoAction );
                        executedActions.add( undoAction );
                    }
                    // check post constraints
                    microTransactionable.assertUndoPostConstraints( );
                    // check immediate constraints
                    // OclServiceImpl.getInstance().checkImmediateConstraints();
                } finally {
                    // release the write lock for synchronization before firing
                    // the
                    // post events
                    releaseMicroWriteLock( );
                }
            }
            // fire post events
            if ( undoEvents != null ) {
                for ( int i = 0; i < undoEvents.size( ); i++ ) {
                    txManager.getEventManager( ).fireChangeEvent( undoEvents.get( i ) );
                }
            }
        } catch ( JmiException jmiEx ) {
            throw jmiEx;
        } catch ( NullPointerException nullPointerEx ) {
            throw nullPointerEx;
        } catch ( RecoverableExecutionException recoverableExecutionEx ) {
            throw recoverableExecutionEx;
        } catch ( UnrecoverableExecutionException unrecoverableExecutionEx ) {
            throw unrecoverableExecutionEx;
        } catch ( RuntimeException runtimeEx ) {
            throw new UnrecoverableExecutionException( runtimeEx );
        } finally {
            microTransactionable.undoFinished( );
        }
    }

    void rollbackUndo( ) {

        if ( executedActions == null ) {
            return;
        }
        // TODO: Make sure that this call ignores inconsistencies
        acquireMicroWriteLock( );
        try {
            List<Action> undoActionsToRevert = ActionExecutor.reverseActionList( executedActions );
            for ( int i = 0; i < undoActionsToRevert.size( ); i++ ) {
                Action action = undoActionsToRevert.get( i );
                ActionExecutor.revertAction( action );
            }
        } finally {
            releaseMicroWriteLock( );
        }
    }

    // Redo including rollback in case of failure (if possible)
    public void redo( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, JmiException, NullPointerException {

        try {
            doRedo( );
            return;
        } catch ( UnrecoverableExecutionException unrecoverableTransactionEx ) {
            throw unrecoverableTransactionEx;
        } catch ( RuntimeException runtimeEx ) {
            try {
                rollbackRedo( );
            } catch ( RuntimeException runtimeEx2 ) {
                throw new ExecutionRollbackFailedException( runtimeEx, runtimeEx2 );
            }
            if ( runtimeEx instanceof RecoverableExecutionException ) {
                Throwable cause = runtimeEx.getCause( );
                if ( cause != null ) {
                    throw (RuntimeException) cause;
                }
            }
            throw runtimeEx;
        }
    }

    void doRedo( ) throws UnrecoverableExecutionException, RecoverableExecutionException, JmiException, NullPointerException {

        try {
            // preparation
            microTransactionable.computeRedoActionsAndRedoEvents( );
            // fire pre events
            List<ChangeEvent> redoEvents = microTransactionable.getRedoEvents( );
            if ( redoEvents != null ) {
                for ( int i = 0; i < redoEvents.size( ); i++ ) {
                    txManager.getEventManager( ).firePreChangeEvent( redoEvents.get( i ) );
                }
            }
            // acquire micro write lock after firing pre events but before
            // executing the actions
            List<Action> redoActions = microTransactionable.getRedoActions( );
            if ( redoActions != null ) {
                executedActions = new ArrayList<Action>( redoActions.size( ) );
                // acquire micro write lock
                acquireMicroWriteLock( );
                try {
                    // redo actions
                    for ( int i = 0; i < redoActions.size( ); i++ ) {
                        Action action = redoActions.get( i );
                        ActionExecutor.executeAction( action );
                        executedActions.add( action );
                    }
                    // check immediate constraints
                    // OclServiceImpl.getInstance().checkImmediateConstraints();
                } finally {
                    // release the write lock for synchronization before firing
                    // the
                    // post events
                    releaseMicroWriteLock( );
                }
            }
            // fire post events
            if ( redoEvents != null ) {
                for ( int i = 0; i < redoEvents.size( ); i++ ) {
                    txManager.getEventManager( ).fireChangeEvent( redoEvents.get( i ) );
                }
            }
        } catch ( JmiException jmiEx ) {
            throw jmiEx;
        } catch ( NullPointerException nullPointerEx ) {
            throw nullPointerEx;
        } catch ( RecoverableExecutionException recoverableExecutionEx ) {
            throw recoverableExecutionEx;
        } catch ( UnrecoverableExecutionException unrecoverableExecutionEx ) {
            throw unrecoverableExecutionEx;
        } catch ( RuntimeException runtimeEx ) {
            throw new UnrecoverableExecutionException( runtimeEx );
        } finally {
            microTransactionable.redoFinished( );
        }
    }

    void rollbackRedo( ) {

        if ( executedActions == null ) {
            return;
        }
        // TODO: Make sure that this call ignores inconsistencies
        acquireMicroWriteLock( );
        try {
            List<Action> actionsToRedo = ActionExecutor.reverseActionList( executedActions );
            for ( int i = 0; i < actionsToRedo.size( ); i++ ) {
                ActionExecutor.revertAction( actionsToRedo.get( i ) );
            }
        } finally {
            releaseMicroWriteLock( );
        }
    }

    private void releaseMicroWriteLock( ) {

        this.txManager.getWorkspaceSet( ).getSynchronizationManager( ).releaseMicroWriteLock( );
    }

    private void acquireMicroWriteLock( ) {

        this.txManager.getWorkspaceSet( ).getSynchronizationManager( ).acquireMicroWriteLock( );
    }

    @Override
    public CoreConnection getConnection( ) {

        return microTransactionable.getConnection( );
    }

}
