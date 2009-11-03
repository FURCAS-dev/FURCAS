package com.sap.tc.moin.repository.core.transactions;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.FastStack;
import com.sap.tc.moin.repository.spi.core.SpiEventManager;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;
import com.sap.tc.moin.repository.transactions.TransactionManager;
import com.sap.tc.moin.repository.transactions.TransactionRecord;
import com.sap.tc.moin.repository.transactions.Transactionable;

/**
 * Responsible for the execution of {@link Transactionable} and
 * {@link MicroTransactionable} code. Uses a new {@link RecordOfMicroTx} for
 * each new root Transaction to track all executed {@link MicroTransaction}s.
 * Notifies the {@link SpiEventManager} when a new root Transaction is created
 * or closed.
 * 
 * @author D045996
 */
public class TransactionManagerImpl implements TransactionManager {

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_MICROTRANSACTIONS, TransactionManagerImpl.class );

    public enum TransactionState {
        WAITING, RUNNING, UNDOING, REDOING, ERROR
    };

    protected TransactionState state = TransactionState.WAITING;

    private RecordOfMicroTx record = null;

    private FastStack<AbstractTransaction> activeTxs = new FastStack<AbstractTransaction>( );

    private AbstractTransaction rootTx = null;

    private SpiEventManager eventManager;

    private WorkspaceSet workspaceSet;

    public TransactionManagerImpl( CoreSession session ) {

        this.eventManager = session.getEventManager( );
        this.workspaceSet = session.getWorkspaceSet( );
    }

    public SpiEventManager getEventManager( ) {

        return eventManager;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.transactions.TransactionManager#runInTransaction(com.
     * sap.tc.moin.transactions.Transactionable)
     */
    public TransactionRecord runInTransaction( Transactionable code ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException {

        if ( activeTxs.size( ) > 0 && ( activeTxs.peek( ) instanceof MicroTransaction ) ) {
            throw new MoinIllegalStateException( TransactionManagerMessages.TXINSIDEMICROTX );
        }
        if ( state != TransactionState.WAITING && state != TransactionState.RUNNING ) {
            throw new MoinIllegalStateException( TransactionManagerMessages.TXWRONGSTATE, state.name( ) );
        }

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            String cTxName = code.getClass( ).toString( );
            logger.trace( MoinSeverity.INFO, "CompositeTx " + cTxName + " started. Connection is [" + code.getConnection( ) + "]" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
        }

        CompositeTransaction tx = new CompositeTransaction( this, code );
        TransactionRecord result = runTransaction( tx );

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            String cTxName = code.getClass( ).toString( );
            logger.trace( MoinSeverity.INFO, "CompositeTx " + cTxName + " finished. Connection is [" + code.getConnection( ) + "]" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.transactions.TransactionManager#runInTransaction(com.
     * sap.tc.moin.transactions.Transactionable)
     */
    public TransactionRecord runInMicroTransaction( MicroTransactionable code ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, JmiException
    /* TODO: Other JMI Exceptions */{

        if ( activeTxs.size( ) > 0 && ( activeTxs.peek( ) instanceof MicroTransaction ) ) {
            throw new MoinIllegalStateException( TransactionManagerMessages.TXINSIDEMICROTX );
        }
        if ( state != TransactionState.WAITING && state != TransactionState.RUNNING ) {
            throw new MoinIllegalStateException( TransactionManagerMessages.TXWRONGSTATE, state.name( ) );
        }

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            String mTxName = code.getClass( ).toString( );
            logger.trace( MoinSeverity.INFO, "MicroTx " + mTxName + " started. Connection is [" + code.getConnection( ) + "]" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
        }

        MicroTransaction mTx = new MicroTransaction( this, code );
        TransactionRecord result = runTransaction( mTx );

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            String mTxName = code.getClass( ).toString( );
            logger.trace( MoinSeverity.INFO, "MicroTx " + mTxName + " finished. Connection is [" + code.getConnection( ) + "]" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
        }

        return result;
    }

    /**
     * @return the record when running a root tx, otherwise null
     */
    private TransactionRecord runTransaction( AbstractTransaction tx ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, JmiException {

        // TODO: parameter check!
        TransactionRecord ret = null;

        // Check New Root Tx
        if ( rootTx == null ) {
            // If (CommandStack.AutoCommandMode == EXCEPTION)
            // and it is a direct JMI call, this call
            // will throw an exception, aborting the TX execution!
            notifyRootTxStarted( tx );
            setRootTx( tx );
            ret = record;
        }

        activeTxs.push( tx );
        try {
            // Note that exception wrapping is performed by CompositeTransation
            // and MicroTransaction, so that, this is not necessary here!
            tx.execute( );
        } catch ( ExecutionCancelledException e ) {
            //this exception is part of the contract, therefore don't trace it as error
            handleExecutionExceptionAndRethrow( tx, e );
        } catch ( RuntimeException ex ) {
            //unexpected exception occurred, therefore trace it as error
            traceThrowable( MoinSeverity.ERROR, ex, tx.getConnection( ) );
            handleExecutionExceptionAndRethrow( tx, ex );
        } catch ( AssertionError error ) {// $JL-EXC$
            // Can occur if some MOIN Core internal assertions failed.
            // Example: SynchronizationManager.acquireMicroWriteLock() was
            // called without holding the big write lock.
            traceThrowable( MoinSeverity.ERROR, error, tx.getConnection( ) );
            handleExecutionExceptionAndRethrow( tx, new RuntimeException( error ) );
        } finally {
            activeTxs.pop( );
        }
        // Check Close Root Tx
        if ( rootTx == tx ) {
            // Notify record, to forward clean-up
            getRecord( ).txCommited( );
            closeRootTx( tx );
            notifyRootTxEnded( ret );
        }

        return ret;
    }

    private void handleExecutionExceptionAndRethrow( AbstractTransaction tx, RuntimeException exceptionToBeThrown ) {

        if ( rootTx == tx ) {
            closeRootTx( tx );
            notifyRootTxCancelled( tx );
        }
        throw exceptionToBeThrown;
    }

    public boolean isRootTx( AbstractTransaction tx ) {

        return ( rootTx != null && rootTx.equals( tx ) );
    }

    private void setRootTx( AbstractTransaction tx ) {

        state = TransactionState.RUNNING;
        rootTx = tx;
        record = new RecordOfMicroTx( this, tx.getConnection( ) );
    }

    private void closeRootTx( AbstractTransaction tx ) {

        rootTx = null;
        record = null;
        state = TransactionState.WAITING;
        // TODO: At least here should locks be freed!
        // To avoid deadlocks due to committed event listeners trying to
        // modify the repository
    }

    public RecordOfMicroTx getRecord( ) {

        return record;
    }

    public void undo( TransactionRecord tx ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException {

        // Note that eventManager.begin/end is not necessary because this is
        // done
        // in the CommandStackImpl
        if ( state != TransactionState.WAITING ) {
            throw new MoinIllegalStateException( TransactionManagerMessages.TXUNDOWRONGSTATE, state.name( ) );
        }
        state = TransactionState.UNDOING;
        try {
            ( (RecordOfMicroTx) tx )._undo( );
        } finally {
            state = TransactionState.WAITING;
        }
    }

    public void redo( TransactionRecord tx ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException {

        // Note that eventManager.begin/end is not necessary because this is
        // done
        // in the CommandStackImpl
        if ( state != TransactionState.WAITING ) {
            throw new MoinIllegalStateException( TransactionManagerMessages.TXREDOWRONGSTATE, state.name( ) );
        }
        state = TransactionState.REDOING;
        try {
            ( (RecordOfMicroTx) tx )._redo( );
        } finally {
            state = TransactionState.WAITING;
        }
    }

    public WorkspaceSet getWorkspaceSet( ) {

        return this.workspaceSet;
    }

    // This method is called by a root AbstractTransaction before it commits
    public void firePreCommitEvents( CoreConnection connection ) {

        getEventManager( ).preCommitCommand( connection );
    }

    private void notifyRootTxStarted( AbstractTransaction tx ) {

        getRootTransactionListener( tx.getConnection( ) ).rootTransactionStarted( tx );
    }

    private void notifyRootTxCancelled( AbstractTransaction tx ) {

        getRootTransactionListener( tx.getConnection( ) ).rootTransactionCancelled( tx );
    }

    private void notifyRootTxEnded( TransactionRecord rec ) {

        getRootTransactionListener( rec.getConnection( ) ).rootTransactionEnded( rec );
    }

    private RootTransactionListener getRootTransactionListener( CoreConnection connection ) {

        return (RootTransactionListener) connection.getCommandStack( );
    }

    private void traceThrowable( MoinSeverity severity, Throwable throwable, CoreConnection connection ) {

        if ( logger.isTraced( severity ) ) {
            logger.trace( throwable, severity, "Exception or Error occured! Connection is [{0}].", new Object[] { connection } ); //$NON-NLS-1$
        }
    }
}
