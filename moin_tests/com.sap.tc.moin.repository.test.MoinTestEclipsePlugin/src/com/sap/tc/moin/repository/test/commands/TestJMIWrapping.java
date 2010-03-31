/**
 * 
 */
package com.sap.tc.moin.repository.test.commands;

import org.junit.Test;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.commands.CommandStackImpl.AutoCommandMode;
import com.sap.tc.moin.repository.core.transactions.RecordOfMicroTx;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.test.transactions.MockMicroTransactionable;
import com.sap.tc.moin.repository.transactions.Transactionable;

/**
 * @author d045996
 */
public class TestJMIWrapping extends BaseCommandTest {

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

        stack.clear( );

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

        // Run Txble code
        synchronized ( txManager.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            RecordOfMicroTx rec = (RecordOfMicroTx) txManager.runInTransaction( txble );

            assertTrueAndContinue( "canUndo() after executing tx", stack.canUndo( ) );
            assertFalseAndContinue( "canRedo() after executing tx", stack.canRedo( ) );

            // Undo
            stack.undo( );

            assertFalseAndContinue( "canUndo() after undoing wrapped tx", stack.canUndo( ) );
            assertTrueAndContinue( "canRedo() after undoing wrapped tx", stack.canRedo( ) );

            // Check MicroTx execution
            assertEqualsAndContinue( "mTx1 undone", 1, mt1.prepareUndoCalls );
            assertEqualsAndContinue( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEqualsAndContinue( "mTx2 undone", 1, mt2.prepareUndoCalls );
            assertEqualsAndContinue( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEqualsAndContinue( "mTx3 undone", 1, mt3.prepareUndoCalls );
            assertEqualsAndContinue( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEqualsAndContinue( "mTx4 undone", 1, mt4.prepareUndoCalls );
            assertEqualsAndContinue( "mTx4 executed", 1, mt4.prepareDoCalls );
            assertEqualsAndContinue( "mTx5 undone", 1, mt5.prepareUndoCalls );
            assertEqualsAndContinue( "mTx5 executed", 1, mt5.prepareDoCalls );
            assertEqualsAndContinue( "mTx6 undone", 1, mt6.prepareUndoCalls );
            assertEqualsAndContinue( "mTx6 executed", 1, mt6.prepareDoCalls );
            assertEqualsAndContinue( "mTx7 undone", 1, mt7.prepareUndoCalls );
            assertEqualsAndContinue( "mTx7 executed", 1, mt7.prepareDoCalls );
            assertEqualsAndContinue( "mTx8 undone", 1, mt8.prepareUndoCalls );
            assertEqualsAndContinue( "mTx8 executed", 1, mt8.prepareDoCalls );

            // Check sequence
            assertTrueAndContinue( "mTx7 executed after mTx8", mt7.undoTime >= mt8.undoTime );
            assertTrueAndContinue( "mTx6 executed after mTx7", mt6.undoTime >= mt7.undoTime );
            assertTrueAndContinue( "mTx5 executed after mTx6", mt5.undoTime >= mt6.undoTime );
            assertTrueAndContinue( "mTx4 executed after mTx5", mt4.undoTime >= mt5.undoTime );
            assertTrueAndContinue( "mTx3 executed after mTx4", mt3.undoTime >= mt4.undoTime );
            assertTrueAndContinue( "mTx2 executed after mTx3", mt2.undoTime >= mt3.undoTime );
            assertTrueAndContinue( "mTx1 executed after mTx2", mt1.undoTime >= mt2.undoTime );

            // Redo
            stack.redo( );

            assertTrueAndContinue( "canUndo() after redoing wrapped tx", stack.canUndo( ) );
            assertFalseAndContinue( "canRedo() after redoing wrapped tx", stack.canRedo( ) );

            // Check MicroTx execution
            assertEqualsAndContinue( "mTx1 undone", 1, mt1.prepareUndoCalls );
            assertEqualsAndContinue( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEqualsAndContinue( "mTx2 undone", 1, mt2.prepareUndoCalls );
            assertEqualsAndContinue( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEqualsAndContinue( "mTx3 undone", 1, mt3.prepareUndoCalls );
            assertEqualsAndContinue( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEqualsAndContinue( "mTx4 undone", 1, mt4.prepareUndoCalls );
            assertEqualsAndContinue( "mTx4 executed", 1, mt4.prepareDoCalls );
            assertEqualsAndContinue( "mTx5 undone", 1, mt5.prepareUndoCalls );
            assertEqualsAndContinue( "mTx5 executed", 1, mt5.prepareDoCalls );
            assertEqualsAndContinue( "mTx6 undone", 1, mt6.prepareUndoCalls );
            assertEqualsAndContinue( "mTx6 executed", 1, mt6.prepareDoCalls );
            assertEqualsAndContinue( "mTx7 undone", 1, mt7.prepareUndoCalls );
            assertEqualsAndContinue( "mTx7 executed", 1, mt7.prepareDoCalls );
            assertEqualsAndContinue( "mTx8 undone", 1, mt8.prepareUndoCalls );
            assertEqualsAndContinue( "mTx8 executed", 1, mt8.prepareDoCalls );
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

        stack.clear( );

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

        // Run Txble code
        try {
            synchronized ( txManager.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
                RecordOfMicroTx rec = (RecordOfMicroTx) txManager.runInTransaction( txble );
            }
            assertTrueAndContinue( "TransactionCancelledException thrown executing Tx w/abortion.", false );
        } catch ( ExecutionCancelledException ex ) {
            // ok
        } catch ( RuntimeException ex ) {
            assertEqualsAndContinue( "TransactionCancelledException thrown executing Tx w/abortion.", ex, null );
        }

        assertFalseAndContinue( "canUndo() after executing tx with error", stack.canUndo( ) );
        assertFalseAndContinue( "canRedo() after executing tx with error", stack.canRedo( ) );

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

        stack.clear( );

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

        // Run Txble code
        try {
            synchronized ( txManager.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
                RecordOfMicroTx rec = (RecordOfMicroTx) txManager.runInTransaction( txble );
            }
            assertTrueAndContinue( "TransactionCancelledException thrown executing Tx w/abortion.", false );
        } catch ( ExecutionCancelledException ex ) {
            // ok
        } catch ( RuntimeException ex ) {
            assertEqualsAndContinue( "TransactionCancelledException thrown executing Tx w/abortion.", ex, null );
        }

        assertFalseAndContinue( "canUndo() after executing tx with error", stack.canUndo( ) );
        assertFalseAndContinue( "canRedo() after executing tx with error", stack.canRedo( ) );
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

        stack.clear( );

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

        synchronized ( txManager.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {
            // Run Txble code
            RecordOfMicroTx rec = (RecordOfMicroTx) txManager.runInTransaction( txble );

            assertTrueAndContinue( "canUndo() after executing tx", stack.canUndo( ) );
            assertFalseAndContinue( "canRedo() after executing tx", stack.canRedo( ) );

            // Undo
            stack.undo( );

            assertFalseAndContinue( "canUndo() after undoing wrapped tx", stack.canUndo( ) );
            assertTrueAndContinue( "canRedo() after undoing wrapped tx", stack.canRedo( ) );

            // done and undone
            assertEqualsAndContinue( "mTx1 executed", 1, mt1.prepareDoCalls );
            assertEqualsAndContinue( "mTx1 undone", 1, mt1.prepareUndoCalls );
            assertEqualsAndContinue( "mTx2 executed", 1, mt2.prepareDoCalls );
            assertEqualsAndContinue( "mTx2 undone", 1, mt2.prepareUndoCalls );

            // done and reverted
            assertEqualsAndContinue( "mTx3 executed", 1, mt3.prepareDoCalls );
            assertEqualsAndContinue( "mTx3 reverted", 1, mt3.doAction2.revertCalls );
            assertEqualsAndContinue( "mTx4 executed", 1, mt4.prepareDoCalls );
            assertEqualsAndContinue( "mTx4 reverted", 1, mt4.doAction2.revertCalls );

            // nothing
            assertEqualsAndContinue( "mTx5 executed", 0, mt5.prepareDoCalls );
            assertEqualsAndContinue( "mTx5 undone", 0, mt5.prepareUndoCalls );
            assertEqualsAndContinue( "mTx6 executed", 0, mt6.prepareDoCalls );
            assertEqualsAndContinue( "mTx6 undone", 0, mt6.prepareUndoCalls );

            // done and undone
            assertEqualsAndContinue( "mTx7 executed", 1, mt7.prepareDoCalls );
            assertEqualsAndContinue( "mTx7 undone", 1, mt7.prepareUndoCalls );
            assertEqualsAndContinue( "mTx8 executed", 1, mt8.prepareDoCalls );
            assertEqualsAndContinue( "mTx8 undone", 1, mt8.prepareUndoCalls );
        }
    }

    @Test
    public void testAutoCommandModeException( ) {

        final MockMicroTransactionable mt1 = new MockMicroTransactionable( );

        stack.clear( );

        // Create Txs
        Transactionable txble = new Transactionable( ) {

            public void runInTransaction( ) {

                txManager.runInMicroTransaction( mt1 );
            }

            public CoreConnection getConnection( ) {

                return getTestHelper( ).getCoreConnection( getMOINConnection( ) );
            }
        };

        stackImpl.setAutoCommandMode( AutoCommandMode.EXCEPTION );

        // Run Txble code
        try {
            RecordOfMicroTx rec = (RecordOfMicroTx) txManager.runInTransaction( txble );
            assertTrueAndContinue( "TransactionCancelledException thrown executing Tx w/AutoCommandMode.EXCEPTION", false );
        } catch ( ExecutionCancelledException ex ) {
        }

        assertFalseAndContinue( "canUndo() after direct executing tx w/AutoCommandMode.EXCEPTION", stack.canUndo( ) );
        assertFalseAndContinue( "canRedo() after direct executing tx w/AutoCommandMode.EXCEPTION", stack.canRedo( ) );

        // Check MicroTx execution
        assertEqualsAndContinue( "mTx1 executed", 0, mt1.prepareDoCalls );
        assertEqualsAndContinue( "mTx1 undone", 0, mt1.prepareUndoCalls );
    }

    void abort( ) {

        throw new ExecutionCancelledException( );
    }

    void error( ) {

        throw new NullPointerException( );
    }

}
