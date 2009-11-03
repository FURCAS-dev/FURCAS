package com.sap.tc.moin.repository.test.transactions;

import org.junit.After;
import org.junit.Test;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.transactions.RecordOfMicroTx;
import com.sap.tc.moin.repository.transactions.Transactionable;

public class TestMicroTransactions extends BaseTransactionsTest {

    MockMicroTransactionable mt1;

    MockMicroTransactionable mt2;

    MockMicroTransactionable mt3;

    public Transactionable getNewTxble( ) {

        mt1 = new MockMicroTransactionable( );
        mt2 = new MockMicroTransactionable( );
        mt3 = new MockMicroTransactionable( );
        return new Transactionable( ) {

            public void runInTransaction( ) {

                txManager.runInMicroTransaction( mt1 );
                txManager.runInMicroTransaction( mt2 );
                txManager.runInMicroTransaction( mt3 );
            }

            public CoreConnection getConnection( ) {

                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            }
        };

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        mt1 = null;
        mt2 = null;
        mt3 = null;
    }

    @Test
    public void testMTxRunUndoRedo( ) {

        Transactionable txble = getNewTxble( );

        //*******************************************************************************//
        //*                                    Run                                      *//
        synchronized ( syncMan.getProhibitWriteSyncObject( ) ) {

            RecordOfMicroTx rec = (RecordOfMicroTx) txManager.runInTransaction( txble );

            // Check MicroTx execution
            assertEqualsAndContinue( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEqualsAndContinue( "mTx1 undone", 0, mt1.prepareUndoCalls );
            assertEqualsAndContinue( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEqualsAndContinue( "mTx2 undone", 0, mt2.prepareUndoCalls );
            assertEqualsAndContinue( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEqualsAndContinue( "mTx3 undone", 0, mt3.prepareUndoCalls );
            // Check MicroTx sequence
            assertTrueAndContinue( "mTx2 executed after mTx1", mt2.execTime >= mt1.execTime );
            assertTrueAndContinue( "mTx3 executed after mTx2", mt3.execTime >= mt2.execTime );

            // Check Actions execution
            assertEqualsAndContinue( "mTx1.action1 executed", 1, mt1.doAction1.executeCalls );
            assertEqualsAndContinue( "mTx1.action2 executed", 1, mt1.doAction2.executeCalls );
            assertEqualsAndContinue( "mTx1.action3 executed", 1, mt1.doAction3.executeCalls );
            assertEqualsAndContinue( "mTx2.action1 executed", 1, mt2.doAction1.executeCalls );
            assertEqualsAndContinue( "mTx2.action2 executed", 1, mt2.doAction2.executeCalls );
            assertEqualsAndContinue( "mTx2.action3 executed", 1, mt2.doAction3.executeCalls );
            assertEqualsAndContinue( "mTx3.action1 executed", 1, mt3.doAction1.executeCalls );
            assertEqualsAndContinue( "mTx3.action2 executed", 1, mt3.doAction2.executeCalls );
            assertEqualsAndContinue( "mTx3.action3 executed", 1, mt3.doAction3.executeCalls );

            // Check MicroTx.Actions sequence
            assertTrueAndContinue( "mTx1.action2 executed after mTx1.action1", mt1.doAction2.execTime > mt1.doAction1.execTime );
            assertTrueAndContinue( "mTx1.action3 executed after mTx1.action2", mt1.doAction3.execTime > mt1.doAction2.execTime );

            //*******************************************************************************//
            //*                                    Undo                                     *//
            txManager.getEventManager( ).beginCommand( getMOINConnection( ) );
            rec.undo( );
            txManager.getEventManager( ).postCommitCommand( getMOINConnection( ) );

            // Check MicroTx execution
            assertEqualsAndContinue( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEqualsAndContinue( "mTx1 undone", 1, mt1.prepareUndoCalls );
            assertEqualsAndContinue( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEqualsAndContinue( "mTx2 undone", 1, mt2.prepareUndoCalls );
            assertEqualsAndContinue( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEqualsAndContinue( "mTx3 undone", 1, mt3.prepareUndoCalls );
            // Check MicroTx sequence
            assertTrueAndContinue( "mTx2 undone after mTx3", mt2.undoTime > mt3.undoTime );
            assertTrueAndContinue( "mTx1 undone after mTx2", mt1.undoTime > mt2.undoTime );

            // Actions executed once
            assertEqualsAndContinue( "mTx1.action1 executed", 1, mt1.doAction1.executeCalls );
            assertEqualsAndContinue( "mTx1.action2 executed", 1, mt1.doAction2.executeCalls );
            assertEqualsAndContinue( "mTx1.action3 executed", 1, mt1.doAction3.executeCalls );
            assertEqualsAndContinue( "mTx2.action1 executed", 1, mt2.doAction1.executeCalls );
            assertEqualsAndContinue( "mTx2.action2 executed", 1, mt2.doAction2.executeCalls );
            assertEqualsAndContinue( "mTx2.action3 executed", 1, mt2.doAction3.executeCalls );
            assertEqualsAndContinue( "mTx3.action1 executed", 1, mt3.doAction1.executeCalls );
            assertEqualsAndContinue( "mTx3.action2 executed", 1, mt3.doAction2.executeCalls );
            assertEqualsAndContinue( "mTx3.action3 executed", 1, mt3.doAction3.executeCalls );

            // No action reverted!
            assertEqualsAndContinue( "mTx1.action1 reverted", 0, mt1.doAction1.revertCalls );
            assertEqualsAndContinue( "mTx1.action2 reverted", 0, mt1.doAction2.revertCalls );
            assertEqualsAndContinue( "mTx1.action3 reverted", 0, mt1.doAction3.revertCalls );
            assertEqualsAndContinue( "mTx2.action1 reverted", 0, mt2.doAction1.revertCalls );
            assertEqualsAndContinue( "mTx2.action2 reverted", 0, mt2.doAction2.revertCalls );
            assertEqualsAndContinue( "mTx2.action3 reverted", 0, mt2.doAction3.revertCalls );
            assertEqualsAndContinue( "mTx3.action1 reverted", 0, mt3.doAction1.revertCalls );
            assertEqualsAndContinue( "mTx3.action2 reverted", 0, mt3.doAction2.revertCalls );
            assertEqualsAndContinue( "mTx3.action3 reverted", 0, mt3.doAction3.revertCalls );

            // Undo actions executed once!
            assertEqualsAndContinue( "mTx1.uAction1 executed", 1, mt1.undoAction1.executeCalls );
            assertEqualsAndContinue( "mTx1.uAction2 executed", 1, mt1.undoAction2.executeCalls );
            assertEqualsAndContinue( "mTx1.uAction3 executed", 1, mt1.undoAction3.executeCalls );
            assertEqualsAndContinue( "mTx2.uAction1 executed", 1, mt2.undoAction1.executeCalls );
            assertEqualsAndContinue( "mTx2.uAction2 executed", 1, mt2.undoAction2.executeCalls );
            assertEqualsAndContinue( "mTx2.uAction3 executed", 1, mt2.undoAction3.executeCalls );
            assertEqualsAndContinue( "mTx3.uAction1 executed", 1, mt3.undoAction1.executeCalls );
            assertEqualsAndContinue( "mTx3.uAction2 executed", 1, mt3.undoAction2.executeCalls );
            assertEqualsAndContinue( "mTx3.uAction3 executed", 1, mt3.undoAction3.executeCalls );

            // Check MicroTx.undoActions sequence
            assertTrueAndContinue( "mTx1.undoAction2 executed after mTx1.undoAction1", mt1.undoAction2.execTime > mt1.undoAction1.execTime );
            assertTrueAndContinue( "mTx1.undoAction3 executed after mTx1.undoAction2", mt1.undoAction3.execTime > mt1.undoAction2.execTime );

            //*******************************************************************************//
            //*                                    Redo                                     *//
            txManager.getEventManager( ).beginCommand( getMOINConnection( ) );
            rec.redo( );
            txManager.getEventManager( ).postCommitCommand( getMOINConnection( ) );

            // Check MicroTx execution
            // TODO: check if ok: redo does not calls computeDoActions....
            assertEqualsAndContinue( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEqualsAndContinue( "mTx1 undone", 1, mt1.prepareUndoCalls );
            assertEqualsAndContinue( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEqualsAndContinue( "mTx2 undone", 1, mt2.prepareUndoCalls );
            assertEqualsAndContinue( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEqualsAndContinue( "mTx3 undone", 1, mt3.prepareUndoCalls );
            // Check MicroTx sequence
            assertTrueAndContinue( "mTx2 redone after mTx1", mt2.execTime > mt1.execTime );
            assertTrueAndContinue( "mTx3 redone after mTx2", mt3.execTime > mt2.execTime );

            // Actions executed twice 
            assertEqualsAndContinue( "mTx1.action1 re-executed", 2, mt1.doAction1.executeCalls );
            assertEqualsAndContinue( "mTx1.action2 re-executed", 2, mt1.doAction2.executeCalls );
            assertEqualsAndContinue( "mTx1.action3 re-executed", 2, mt1.doAction3.executeCalls );
            assertEqualsAndContinue( "mTx2.action1 re-executed", 2, mt2.doAction1.executeCalls );
            assertEqualsAndContinue( "mTx2.action2 re-executed", 2, mt2.doAction2.executeCalls );
            assertEqualsAndContinue( "mTx2.action3 re-executed", 2, mt2.doAction3.executeCalls );
            assertEqualsAndContinue( "mTx3.action1 re-executed", 2, mt3.doAction1.executeCalls );
            assertEqualsAndContinue( "mTx3.action2 re-executed", 2, mt3.doAction2.executeCalls );
            assertEqualsAndContinue( "mTx3.action3 re-executed", 2, mt3.doAction3.executeCalls );

            // No action reverted!
            assertEqualsAndContinue( "mTx1.action1 reverted", 0, mt1.doAction1.revertCalls );
            assertEqualsAndContinue( "mTx1.action2 reverted", 0, mt1.doAction2.revertCalls );
            assertEqualsAndContinue( "mTx1.action3 reverted", 0, mt1.doAction3.revertCalls );
            assertEqualsAndContinue( "mTx2.action1 reverted", 0, mt2.doAction1.revertCalls );
            assertEqualsAndContinue( "mTx2.action2 reverted", 0, mt2.doAction2.revertCalls );
            assertEqualsAndContinue( "mTx2.action3 reverted", 0, mt2.doAction3.revertCalls );
            assertEqualsAndContinue( "mTx3.action1 reverted", 0, mt3.doAction1.revertCalls );
            assertEqualsAndContinue( "mTx3.action2 reverted", 0, mt3.doAction2.revertCalls );
            assertEqualsAndContinue( "mTx3.action3 reverted", 0, mt3.doAction3.revertCalls );

            // Undo actions executed once!
            assertEqualsAndContinue( "mTx1.uAction1 executed", 1, mt1.undoAction1.executeCalls );
            assertEqualsAndContinue( "mTx1.uAction2 executed", 1, mt1.undoAction2.executeCalls );
            assertEqualsAndContinue( "mTx1.uAction3 executed", 1, mt1.undoAction3.executeCalls );
            assertEqualsAndContinue( "mTx2.uAction1 executed", 1, mt2.undoAction1.executeCalls );
            assertEqualsAndContinue( "mTx2.uAction2 executed", 1, mt2.undoAction2.executeCalls );
            assertEqualsAndContinue( "mTx2.uAction3 executed", 1, mt2.undoAction3.executeCalls );
            assertEqualsAndContinue( "mTx3.uAction1 executed", 1, mt3.undoAction1.executeCalls );
            assertEqualsAndContinue( "mTx3.uAction2 executed", 1, mt3.undoAction2.executeCalls );
            assertEqualsAndContinue( "mTx3.uAction3 executed", 1, mt3.undoAction3.executeCalls );

            // Check MicroTx.doActions sequence
            assertTrueAndContinue( "mTx1.action2 executed after mTx1.action1", mt1.doAction2.execTime > mt1.doAction1.execTime );
            assertTrueAndContinue( "mTx1.action3 executed after mTx1.action2", mt1.doAction3.execTime > mt1.doAction2.execTime );

        }
    }

    @Test
    public void testMTxExecExceptions( ) {

        // TODO: Test exceptions/vetos when running
    }

    @Test
    public void testMTxExecRollbackExceptions( ) {

        // TODO: Test exceptions/vetos when rolling back
    }

    @Test
    public void testMTxUndoExceptions( ) {

        // TODO: Test exceptions/vetos when undoing
    }

    @Test
    public void testMTxUndoRollbackExceptions( ) {

        // TODO: Test exceptions/vetos when rolling back undo
    }

    @Test
    public void testMTxRedoExceptions( ) {

        // TODO: Test exceptions/vetos when redoing
    }

    @Test
    public void testMTxRedoRollbackExceptions( ) {

        // TODO: Test exceptions/vetos when rolling back redo
    }

}
