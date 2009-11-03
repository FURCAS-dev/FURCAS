package com.sap.tc.moin.repository.test.transactions;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.core.commands.CommandStackImpl;
import com.sap.tc.moin.repository.test.commands.AnonymousCommand;


/**
 * Test the combination of multiple Transaction Records, which is used to
 * implement Command Groups, when they are closed.
 * 
 * @author d045996
 */
public class TestRecordCombination extends BaseTransactionsTest {


    @Test
    public void testRecordCombinationOnCommandGroup( ) {

        final MockMicroTransactionable mt1 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt2 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt3 = new MockMicroTransactionable( );
        final MockMicroTransactionable mt4 = new MockMicroTransactionable( );


        Connection con = getMOINConnection( );
        CommandStack stack = con.getCommandStack( );
        stack.clear( );


        stack.openGroup( "Group1" );
        stack.execute( new AnonymousCommand( con, "Cmd1.1" ) {

            @Override
            public void doExecute( ) {

                txManager.runInMicroTransaction( mt1 );
            }
        } );
        stack.execute( new AnonymousCommand( con, "Cmd1.2" ) {

            @Override
            public void doExecute( ) {

                txManager.runInMicroTransaction( mt2 );
            }
        } );

        stack.openGroup( "SubGroupA" );
        stack.execute( new AnonymousCommand( con, "Cmd1.A.1" ) {

            @Override
            public void doExecute( ) {

                txManager.runInMicroTransaction( mt3 );
                txManager.runInMicroTransaction( mt4 );
            }
        } );
        stack.closeGroup( );

        CommandHandle group = stack.closeGroup( );

        CommandStackImpl commandStackImpl = (CommandStackImpl) getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getCommandStack( );
        Collection undoStack = commandStackImpl.getUndoStackContent( );
        assertEquals( "Undo stack size", undoStack.size( ), 1 );

        // Check through undo of micro txs
        stack.undo( );

        assertEqualsAndContinue( "mTx1 executed", mt1.prepareDoCalls, 1 );
        assertEqualsAndContinue( "mTx1 undone", mt1.prepareUndoCalls, 1 );
        assertEqualsAndContinue( "mTx2 executed", mt2.prepareDoCalls, 1 );
        assertEqualsAndContinue( "mTx2 undone", mt2.prepareUndoCalls, 1 );
        assertEqualsAndContinue( "mTx3 executed", mt3.prepareDoCalls, 1 );
        assertEqualsAndContinue( "mTx3 undone", mt3.prepareUndoCalls, 1 );
        assertEqualsAndContinue( "mTx4 executed", mt4.prepareDoCalls, 1 );
        assertEqualsAndContinue( "mTx4 undone", mt4.prepareUndoCalls, 1 );

        assertTrueAndContinue( "mTx2 executed after mTx1", mt2.execTime > mt1.execTime );
        assertTrueAndContinue( "mTx3 executed after mTx2", mt3.execTime > mt2.execTime );
        assertTrueAndContinue( "mTx4 executed after mTx3", mt4.execTime > mt3.execTime );

        assertTrueAndContinue( "mTx3 undone after mTx4", mt3.undoTime > mt4.undoTime );
        assertTrueAndContinue( "mTx2 undone after mTx3", mt2.undoTime > mt3.undoTime );
        assertTrueAndContinue( "mTx1 undone after mTx2", mt1.undoTime > mt2.undoTime );
    }

}
