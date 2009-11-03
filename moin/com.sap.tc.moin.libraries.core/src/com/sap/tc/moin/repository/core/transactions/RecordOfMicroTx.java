package com.sap.tc.moin.repository.core.transactions;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.FastStack;
import com.sap.tc.moin.repository.transactions.TransactionRecord;

/**
 * Records all micro transactions executed during a transaction (==Command). The
 * recording does not depend on events, but it is managed by the
 * {@link TransactionManagerImpl}. During the execution phase, marks are used by
 * {@link CompositeTransaction} to rollback only the micro Tx corresponding to
 * this Transaction. After execution, the recorded micro transactions can be
 * atomically undone and redone.
 * 
 * @author d045996
 */
public class RecordOfMicroTx implements TransactionRecord {

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_MICROTRANSACTIONS, RecordOfMicroTx.class );

    TransactionManagerImpl txManager;

    // TODO: Maybe a linked list could be better, as the size of the record can
    // vary from
    // 3 (direct JMI call) to a very big number
    FastStack<MicroTransaction> undo = new FastStack<MicroTransaction>( );

    FastStack<MicroTransaction> redo = null;

    private final CoreConnection connection;

    public RecordOfMicroTx( TransactionManagerImpl txManager, CoreConnection connection ) {

        this.txManager = txManager;
        this.connection = connection;
        // TODO: not clear if there can be a non-undoable RecordOfMicroTx
        isUndoable = true;
    }

    private boolean isUndoable = false;

    private boolean isRedoable = false;

    public boolean canUndo( ) {

        return isUndoable;
    }

    public boolean canRedo( ) {

        return isRedoable;
    }

    /**
     * Add a successfully executed micro transactionable to the record.
     * 
     * @param mTx {@link MicroTransaction} to be added
     */
    public void addMicroTx( MicroTransaction mTx ) {

        isUndoable = true;
        undo.add( mTx );
    }

    /**
     * Add the {@link MicroTransaction}s in the given {@link TransactionRecrod}
     * to the record.
     * 
     * @param record
     */
    public void addRecord( TransactionRecord record ) {

        undo.addAll( ( (RecordOfMicroTx) record ).undo );
        isUndoable = true;
    }

    /**
     * @return a mark representing the actual state of the record
     */
    public int getActualMark( ) {

        return undo.size( );
    }

    /**
     * Rollbacks all the {@link MicroTransaction}s added after the given mark
     * 
     * @param mark obtained with {@link getActualMark()}
     */
    public void rollbackToMark( int mark ) {

        MicroTransaction tx;
        while ( undo.size( ) > mark ) {
            tx = undo.pop( );
            tx.rollbackExecute( );
        }
    }

    // On Tx commited, clean-up all MicroTransactions
    protected void txCommited( ) {

        if ( undo != null ) {
            for ( int i = 0, n = undo.size( ); i < n; i++ ) {
                undo.get( i ).cleanUpOnCommit( );
            }
        }
        if ( redo != null ) {
            for ( int i = 0, n = redo.size( ); i < n; i++ ) {
                redo.get( i ).cleanUpOnCommit( );
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.transactions.TransactionRecord#undo()
     */
    public void undo( ) {

        this.txManager.undo( this );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.transactions.TransactionRecord#redo()
     */
    public void redo( ) {

        this.txManager.redo( this );
    }

    /**
     * Undo all micro transactions atomically. If there is any problem, then try
     * to rollback the undone txs, leaving the repository in the same state as
     * before the call. This is an internal method to be used by the
     * {@link TransactionManagerImpl}
     */
    public void _undo( ) /* TODO: throws */{

        try {
            simpleUndo( false );
            txManager.firePreCommitEvents( connection );
            txCommited( );
        } catch ( UnrecoverableExecutionException rbe ) {
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( rbe, MoinSeverity.ERROR, "Exception on undo.", null ); //$NON-NLS-1$
            }
            throw rbe;
        } catch ( RuntimeException ex ) {
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( ex, MoinSeverity.ERROR, "Exception on undo.", null ); //$NON-NLS-1$
            }
            // Try to rollback undone Txs
            try {
                simpleRedo( true );
            } catch ( ExecutionRollbackFailedException rbe ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( rbe, MoinSeverity.ERROR, "Exception on trying to rollback undo.", null ); //$NON-NLS-1$
                }
                throw rbe;
            } catch ( RuntimeException ex2 ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( ex2, MoinSeverity.ERROR, "Exception on trying to rollback undo.", null ); //$NON-NLS-1$
                }
                throw new ExecutionRollbackFailedException( ex, ex2 );
            }
            throw ex;
        }
        isUndoable = false;
        isRedoable = true;
    }

    /**
     * Redo all micro transactions atomically. If there is any problem, then try
     * to rollback the redone txs, leaving the repository in the same state as
     * before the call This is an internal method to be used by the
     * {@link TransactionManagerImpl}
     */
    public void _redo( ) /* TODO: throws */{

        try {
            simpleRedo( false );
            txManager.firePreCommitEvents( connection );
            txCommited( );
        } catch ( UnrecoverableExecutionException rbe ) {
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( rbe, MoinSeverity.ERROR, "Exception on redo.", null ); //$NON-NLS-1$
            }
            throw rbe;
        } catch ( RuntimeException ex ) {
            // Try to rollback redone mTxs
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( ex, MoinSeverity.ERROR, "Exception on redo.", null );//$NON-NLS-1$
            }
            try {
                simpleUndo( true );
            } catch ( ExecutionRollbackFailedException rbe ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( rbe, MoinSeverity.ERROR, "Exception on trying to rollback redo.", null );//$NON-NLS-1$
                }
                throw rbe;
            } catch ( RuntimeException ex2 ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( ex2, MoinSeverity.ERROR, "Exception on trying to rollback redo.", null );//$NON-NLS-1$
                }
                throw new ExecutionRollbackFailedException( ex, ex2 );
            }
            throw ex;
        }
        isUndoable = true;
        isRedoable = false;
    }

    // Undo the txs in the undo stack one after the other and put them in the
    // redo stack.
    // If the process is interrupted due to an exception, the tx beign processed
    // is put
    // back in the undo stack. (Hoping that it could be rolled back)
    // The parameter isRollback is used to control events and constraint checks
    private void simpleUndo( boolean isRollback ) {

        MicroTransaction tx = null;
        if ( redo == null ) {
            redo = new FastStack<MicroTransaction>( undo.size( ) );
        }
        while ( !undo.isEmpty( ) ) {
            tx = undo.pop( );
            try {
                if ( !isRollback ) {
                    tx.undo( );
                } else {
                    tx.rollbackRedo( );
                }
                redo.push( tx );
            } catch ( RuntimeException re ) {
                undo.push( tx );
                throw re;
            }
        }
    }

    // Redo the txs in the redo stack one after the other and put them in the
    // undo stack.
    // If the process is interrupted due to an exception, the tx beign processed
    // is put
    // back in the redo stack. (Hopping that it could be rolled back)
    // The parameter isRollback is used to control events and constraint checks
    private void simpleRedo( boolean isRollback ) {

        MicroTransaction tx = null;
        if ( redo == null ) {
            redo = new FastStack<MicroTransaction>( undo.size( ) );
        }
        while ( !redo.isEmpty( ) ) {
            tx = redo.pop( );
            try {
                if ( !isRollback ) {
                    tx.redo( );
                } else {
                    tx.rollbackUndo( );
                }
                undo.push( tx );
            } catch ( RuntimeException re ) {
                redo.push( tx );
                throw re;
            }
        }
    }

    public CoreConnection getConnection( ) {

        return connection;
    }
}
