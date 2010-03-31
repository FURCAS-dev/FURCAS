package com.sap.tc.moin.repository.test.transactions;

import org.junit.Test;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.transactions.RecordOfMicroTx;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.transactions.Transactionable;

/**
 * Test composing transactions with rollbacks & retries. Checks that the Txs are
 * executed and undone in the right sequence.
 * 
 * @author d045996
 */
public class TestTransactionComposition extends BaseTransactionsTest {

    @Test
    public void testCompositionLifecycle( ) {

        final MockMicroTransactionable mt1 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt2 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt3 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt4 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt5 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt6 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt7 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt8 = new MockMicroTransactionable( );

        // Create composite Txs
        Transactionable txble = new Transactionable( ) {

            public void runInTransaction( ) {

                txManager.runInMicroTransaction( mt1 );
                txManager.runInMicroTransaction( mt2 );

                txManager.runInTransaction( new Transactionable( ) {

                    public void runInTransaction( ) {

                        txManager.runInMicroTransaction( mt3 );

                        txManager.runInTransaction( new Transactionable( ) {

                            public void runInTransaction( ) {

                                txManager.runInMicroTransaction( mt4 );
                                txManager.runInMicroTransaction( mt5 );
                            }

                            public CoreConnection getConnection( ) {

                                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
                            }
                        } );

                        txManager.runInMicroTransaction( mt6 );
                    }

                    public CoreConnection getConnection( ) {

                        return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
                    }
                } );

                txManager.runInMicroTransaction( mt7 );
                txManager.runInMicroTransaction( mt8 );
            }

            public CoreConnection getConnection( ) {

                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            }
        };

        synchronized ( syncMan.getProhibitWriteSyncObject( ) ) {
            // Run Txble code
            RecordOfMicroTx rec = (RecordOfMicroTx) txManager.runInTransaction( txble );

            // Check MicroTx execution
            assertEquals( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEquals( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEquals( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEquals( "mTx4 executed", 1, mt4.prepareDoCalls );
            assertEquals( "mTx5 executed", 1, mt5.prepareDoCalls );
            assertEquals( "mTx6 executed", 1, mt6.prepareDoCalls );
            assertEquals( "mTx7 executed", 1, mt7.prepareDoCalls );
            assertEquals( "mTx8 executed", 1, mt8.prepareDoCalls );
            // Check sequence
            assertTrue( "mTx2 executed after mTx1", mt2.execTime > mt1.execTime );
            assertTrue( "mTx3 executed after mTx2", mt3.execTime > mt2.execTime );
            assertTrue( "mTx4 executed after mTx3", mt4.execTime > mt3.execTime );
            assertTrue( "mTx5 executed after mTx4", mt5.execTime > mt4.execTime );
            assertTrue( "mTx6 executed after mTx5", mt6.execTime > mt5.execTime );
            assertTrue( "mTx7 executed after mTx6", mt7.execTime > mt6.execTime );
            assertTrue( "mTx8 executed after mTx7", mt8.execTime > mt7.execTime );

            // Undo
            txManager.getEventManager( ).beginCommand( getMOINConnection( ) );
            rec.undo( );
            txManager.getEventManager( ).postCommitCommand( getMOINConnection( ) );

            // Check MicroTx execution
            assertEquals( "mTx1 undone", 1, mt1.prepareUndoCalls );
            assertEquals( "mTx2 undone", 1, mt2.prepareUndoCalls );
            assertEquals( "mTx3 undone", 1, mt3.prepareUndoCalls );
            assertEquals( "mTx4 undone", 1, mt4.prepareUndoCalls );
            assertEquals( "mTx5 undone", 1, mt5.prepareUndoCalls );
            assertEquals( "mTx6 undone", 1, mt6.prepareUndoCalls );
            assertEquals( "mTx7 undone", 1, mt7.prepareUndoCalls );
            assertEquals( "mTx8 undone", 1, mt8.prepareUndoCalls );

            // Check sequence
            assertTrue( "mTx7 undone after mTx8", mt7.undoAction2.execTime > mt8.undoAction2.execTime );
            assertTrue( "mTx6 undone after mTx7", mt6.undoAction2.execTime > mt7.undoAction2.execTime );
            assertTrue( "mTx5 undone after mTx6", mt5.undoAction2.execTime > mt6.undoAction2.execTime );
            assertTrue( "mTx4 undone after mTx5", mt4.undoAction2.execTime > mt5.undoAction2.execTime );
            assertTrue( "mTx3 undone after mTx4", mt3.undoAction2.execTime > mt4.undoAction2.execTime );
            assertTrue( "mTx2 undone after mTx3", mt2.undoAction2.execTime > mt3.undoAction2.execTime );
            assertTrue( "mTx1 undone after mTx2", mt1.undoAction2.execTime > mt2.undoAction2.execTime );

            // Redo
            txManager.getEventManager( ).beginCommand( getMOINConnection( ) );
            rec.redo( );
            txManager.getEventManager( ).postCommitCommand( getMOINConnection( ) );

            // Check MicroTx execution
            assertEquals( "mTx1 redone", 2, mt1.getDoActionsCalls );
            assertEquals( "mTx2 redone", 2, mt2.getDoActionsCalls );
            assertEquals( "mTx3 redone", 2, mt3.getDoActionsCalls );
            assertEquals( "mTx4 redone", 2, mt4.getDoActionsCalls );
            assertEquals( "mTx5 redone", 2, mt5.getDoActionsCalls );
            assertEquals( "mTx6 redone", 2, mt6.getDoActionsCalls );
            assertEquals( "mTx7 redone", 2, mt7.getDoActionsCalls );
            assertEquals( "mTx8 redone", 2, mt8.getDoActionsCalls );
        }
    }

    @Test
    public void testCompositionRollbackAtEnd( ) {

        final MockMicroTransactionable mt1 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt2 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt3 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt4 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt5 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt6 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt7 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt8 = new MockMicroTransactionable( );

        // Create composite Txs
        Transactionable txble = new Transactionable( ) {

            public void runInTransaction( ) {

                txManager.runInMicroTransaction( mt1 );
                txManager.runInMicroTransaction( mt2 );

                txManager.runInTransaction( new Transactionable( ) {

                    public void runInTransaction( ) {

                        txManager.runInMicroTransaction( mt3 );

                        txManager.runInTransaction( new Transactionable( ) {

                            public void runInTransaction( ) {

                                txManager.runInMicroTransaction( mt4 );
                                txManager.runInMicroTransaction( mt5 );
                            }

                            public CoreConnection getConnection( ) {

                                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
                            }
                        } );

                        txManager.runInMicroTransaction( mt6 );
                    }

                    public CoreConnection getConnection( ) {

                        return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
                    }
                } );

                txManager.runInMicroTransaction( mt7 );
                // ABORT TX
                abort( );
                txManager.runInMicroTransaction( mt8 );
            }

            public CoreConnection getConnection( ) {

                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            }
        };

        synchronized ( syncMan.getProhibitWriteSyncObject( ) ) {
            // Run Txble code
            try {
                RecordOfMicroTx rec = (RecordOfMicroTx) txManager.runInTransaction( txble );
                fail( "TransactionCancelledException thrown executing Tx w/abortion." );
            } catch ( ExecutionCancelledException ex ) {
                // ok
            }

            // Check MicroTx execution
            assertEquals( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEquals( "mTx1 reverted", 1, mt1.doAction2.revertCalls );
            assertEquals( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEquals( "mTx2 reverted", 1, mt2.doAction2.revertCalls );
            assertEquals( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEquals( "mTx3 reverted", 1, mt3.doAction2.revertCalls );
            assertEquals( "mTx4 executed", 1, mt4.prepareDoCalls );
            assertEquals( "mTx4 reverted", 1, mt4.doAction2.revertCalls );
            assertEquals( "mTx5 executed", 1, mt5.prepareDoCalls );
            assertEquals( "mTx5 reverted", 1, mt5.doAction2.revertCalls );
            assertEquals( "mTx6 executed", 1, mt6.prepareDoCalls );
            assertEquals( "mTx6 reverted", 1, mt6.doAction2.revertCalls );
            assertEquals( "mTx7 executed", 1, mt7.prepareDoCalls );
            assertEquals( "mTx7 reverted", 1, mt7.doAction2.revertCalls );
            assertEquals( "mTx8 executed", 0, mt8.prepareDoCalls );
            assertEquals( "mTx8 reverted", 0, mt8.doAction2.revertCalls );
            // Check sequence
            assertTrue( "mTx2 executed after mTx1", mt2.execTime > mt1.execTime );
            assertTrue( "mTx3 executed after mTx2", mt3.execTime > mt2.execTime );
            assertTrue( "mTx4 executed after mTx3", mt4.execTime > mt3.execTime );
            assertTrue( "mTx5 executed after mTx4", mt5.execTime > mt4.execTime );
            assertTrue( "mTx6 executed after mTx5", mt6.execTime > mt5.execTime );
            assertTrue( "mTx7 executed after mTx6", mt7.execTime > mt6.execTime );

            assertTrue( "mTx6 reverted after mTx7", mt6.doAction2.revertTime > mt7.doAction2.revertTime );
            assertTrue( "mTx5 reverted after mTx6", mt5.doAction2.revertTime > mt6.doAction2.revertTime );
            assertTrue( "mTx4 reverted after mTx5", mt4.doAction2.revertTime > mt5.doAction2.revertTime );
            assertTrue( "mTx3 reverted after mTx4", mt3.doAction2.revertTime > mt4.doAction2.revertTime );
            assertTrue( "mTx2 reverted after mTx3", mt2.doAction2.revertTime > mt3.doAction2.revertTime );
            assertTrue( "mTx1 reverted after mTx2", mt1.doAction2.revertTime > mt2.doAction2.revertTime );
        }
    }

    @Test
    public void testCompositionDeepRollback( ) {

        final MockMicroTransactionable mt1 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt2 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt3 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt4 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt5 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt6 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt7 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt8 = new MockMicroTransactionable( );

        // Create composite Txs
        Transactionable txble = new Transactionable( ) {

            public void runInTransaction( ) {

                txManager.runInMicroTransaction( mt1 );
                txManager.runInMicroTransaction( mt2 );

                txManager.runInTransaction( new Transactionable( ) {

                    public void runInTransaction( ) {

                        txManager.runInMicroTransaction( mt3 );

                        txManager.runInTransaction( new Transactionable( ) {

                            public void runInTransaction( ) {

                                txManager.runInMicroTransaction( mt4 );
                                // ABORT TX
                                abort( );
                                txManager.runInMicroTransaction( mt5 );
                            }

                            public CoreConnection getConnection( ) {

                                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
                            }
                        } );

                        txManager.runInMicroTransaction( mt6 );
                    }

                    public CoreConnection getConnection( ) {

                        return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
                    }
                } );

                txManager.runInMicroTransaction( mt7 );
                txManager.runInMicroTransaction( mt8 );
            }

            public CoreConnection getConnection( ) {

                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            }
        };

        synchronized ( syncMan.getProhibitWriteSyncObject( ) ) {
            // Run Txble code
            try {
                RecordOfMicroTx rec = (RecordOfMicroTx) txManager.runInTransaction( txble );
                fail( "TransactionCancelledException thrown executing Tx w/abortion." );
            } catch ( ExecutionCancelledException ex ) {
                // ok
            }

            // Check MicroTx execution
            assertEquals( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEquals( "mTx1 reverted", 1, mt1.doAction2.revertCalls );
            assertEquals( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEquals( "mTx2 reverted", 1, mt2.doAction2.revertCalls );
            assertEquals( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEquals( "mTx3 reverted", 1, mt3.doAction2.revertCalls );
            assertEquals( "mTx4 executed", 1, mt4.prepareDoCalls );
            assertEquals( "mTx4 reverted", 1, mt4.doAction2.revertCalls );
            assertEquals( "mTx5 executed", 0, mt5.prepareDoCalls );
            assertEquals( "mTx5 reverted", 0, mt5.doAction2.revertCalls );
            assertEquals( "mTx6 executed", 0, mt6.prepareDoCalls );
            assertEquals( "mTx6 reverted", 0, mt6.doAction2.revertCalls );
            assertEquals( "mTx7 executed", 0, mt7.prepareDoCalls );
            assertEquals( "mTx7 reverted", 0, mt7.doAction2.revertCalls );
            assertEquals( "mTx8 executed", 0, mt8.prepareDoCalls );
            assertEquals( "mTx8 reverted", 0, mt8.doAction2.revertCalls );
            // Check sequence
            assertTrue( "mTx2 executed after mTx1", mt2.execTime > mt1.execTime );
            assertTrue( "mTx3 executed after mTx2", mt3.execTime > mt2.execTime );
            assertTrue( "mTx4 executed after mTx3", mt4.execTime > mt3.execTime );

            assertTrue( "mTx3 reverted after mTx4", mt3.doAction2.revertTime > mt4.doAction2.revertTime );
            assertTrue( "mTx2 reverted after mTx3", mt2.doAction2.revertTime > mt3.doAction2.revertTime );
            assertTrue( "mTx1 reverted after mTx2", mt1.doAction2.revertTime > mt2.doAction2.revertTime );
        }
    }

    @Test
    public void testCompositionRollbackStopContinue( ) {

        final MockMicroTransactionable mt1 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt2 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt3 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt4 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt5 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt6 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt7 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt8 = new MockMicroTransactionable( );

        // Create composite Txs
        Transactionable txble = new Transactionable( ) {

            public void runInTransaction( ) {

                txManager.runInMicroTransaction( mt1 );
                txManager.runInMicroTransaction( mt2 );

                try {
                    txManager.runInTransaction( new Transactionable( ) {

                        public void runInTransaction( ) {

                            txManager.runInMicroTransaction( mt3 );

                            txManager.runInTransaction( new Transactionable( ) {

                                public void runInTransaction( ) {

                                    txManager.runInMicroTransaction( mt4 );
                                    // ABORT TX
                                    abort( );
                                    txManager.runInMicroTransaction( mt5 );
                                }

                                public CoreConnection getConnection( ) {

                                    return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
                                }
                            } );

                            txManager.runInMicroTransaction( mt6 );
                        }

                        public CoreConnection getConnection( ) {

                            return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
                        }
                    } );
                } catch ( RuntimeException ex ) {
                    // Stop Rollback and continue
                }

                txManager.runInMicroTransaction( mt7 );
                txManager.runInMicroTransaction( mt8 );
            }

            public CoreConnection getConnection( ) {

                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            }
        };

        synchronized ( syncMan.getProhibitWriteSyncObject( ) ) {

            // Run Txble code
            RecordOfMicroTx rec = (RecordOfMicroTx) txManager.runInTransaction( txble );

            // Check MicroTx execution
            // executed - no reverted
            assertEquals( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEquals( "mTx1 reverted", 0, mt1.doAction2.revertCalls );
            assertEquals( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEquals( "mTx2 reverted", 0, mt2.doAction2.revertCalls );

            // executed + reverted
            assertEquals( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEquals( "mTx3 reverted", 1, mt3.doAction2.revertCalls );
            assertEquals( "mTx4 executed", 1, mt4.prepareDoCalls );
            assertEquals( "mTx4 reverted", 1, mt4.doAction2.revertCalls );

            // not executed - not reverted
            assertEquals( "mTx5 executed", 0, mt5.prepareDoCalls );
            assertEquals( "mTx5 reverted", 0, mt5.doAction2.revertCalls );
            assertEquals( "mTx6 executed", 0, mt6.prepareDoCalls );
            assertEquals( "mTx6 reverted", 0, mt6.doAction2.revertCalls );

            // executed - no reverted
            assertEquals( "mTx7 executed", 1, mt7.prepareDoCalls );
            assertEquals( "mTx7 reverted", 0, mt7.doAction2.revertCalls );
            assertEquals( "mTx8 executed", 1, mt8.prepareDoCalls );
            assertEquals( "mTx8 reverted", 0, mt8.doAction2.revertCalls );

            // Check sequence
            assertTrue( "mTx2 executed after mTx1", mt2.execTime > mt1.execTime );
            assertTrue( "mTx3 executed after mTx2", mt3.execTime > mt2.execTime );
            assertTrue( "mTx4 executed after mTx3", mt4.execTime > mt3.execTime );

            assertTrue( "mTx4 reverted after mTx4 executed", mt4.doAction2.revertTime > mt4.execTime );
            assertTrue( "mTx3 reverted after mTx4", mt3.doAction2.revertTime > mt4.doAction2.revertTime );

            // Undo
            txManager.getEventManager( ).beginCommand( getMOINConnection( ) );
            rec.undo( );
            txManager.getEventManager( ).postCommitCommand( getMOINConnection( ) );

            // Check MicroTx Undo
            // executed - no reverted + undone
            assertEquals( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEquals( "mTx1 reverted", 0, mt1.doAction2.revertCalls );
            assertEquals( "mTx1 undone", 1, mt1.prepareUndoCalls );
            assertEquals( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEquals( "mTx2 undone", 0, mt2.doAction2.revertCalls );
            assertEquals( "mTx2 reverted", 1, mt1.prepareUndoCalls );

            // executed + reverted - no undone
            assertEquals( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEquals( "mTx3 reverted", 1, mt3.doAction2.revertCalls );
            assertEquals( "mTx3 undone", 0, mt3.prepareUndoCalls );
            assertEquals( "mTx4 executed", 1, mt4.prepareDoCalls );
            assertEquals( "mTx4 undone", 1, mt4.doAction2.revertCalls );
            assertEquals( "mTx4 reverted", 0, mt4.prepareUndoCalls );

            // not executed - not reverted - no undone
            assertEquals( "mTx5 executed", 0, mt5.prepareDoCalls );
            assertEquals( "mTx5 reverted", 0, mt5.doAction2.revertCalls );
            assertEquals( "mTx5 undone", 0, mt5.prepareUndoCalls );
            assertEquals( "mTx6 executed", 0, mt6.prepareDoCalls );
            assertEquals( "mTx6 undone", 0, mt6.doAction2.revertCalls );
            assertEquals( "mTx6 reverted", 0, mt6.prepareUndoCalls );

            // executed - no reverted + undone
            assertEquals( "mTx7 executed", 1, mt7.prepareDoCalls );
            assertEquals( "mTx7 reverted", 0, mt7.doAction2.revertCalls );
            assertEquals( "mTx7 undone", 1, mt7.prepareUndoCalls );
            assertEquals( "mTx8 executed", 1, mt8.prepareDoCalls );
            assertEquals( "mTx8 undone", 0, mt8.doAction2.revertCalls );
            assertEquals( "mTx8 reverted", 1, mt8.prepareUndoCalls );
        }
    }

    void abort( ) {

        throw new ExecutionCancelledException( );
    }

    void error( ) {

        throw new NullPointerException( );
    }

}
