package com.sap.tc.moin.repository.test.transactions;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;
import com.sap.tc.moin.repository.transactions.actions.Action;

/**
 * A micro txble that only records when and how often each method is called.
 * 
 * @author d045996
 */
public class MockMicroTransactionable implements MicroTransactionable {

    public MockAction doAction1 = new MockAction( "doAction1" );

    public MockAction doAction2 = new MockAction( "doAction2" );

    public MockAction doAction3 = new MockAction( "doAction3" );

    public MockAction undoAction1 = new MockAction( "undoAction1" );

    public MockAction undoAction2 = new MockAction( "undoAction2" );

    public MockAction undoAction3 = new MockAction( "undoAction3" );

    ArrayList<Action> doActions;

    ArrayList<Action> undoActions;

    public int prepareDoCalls = 0;

    public int prepareUndoCalls = 0;

    public int getDoActionsCalls = 0;

    public int getUndoActionsCalls = 0;

    public long execTime = 0;

    public long undoTime = 0;

    public int getEventsCalls = 0;

    public boolean vetoDo = false;

    public boolean vetoUndo = false;

    private static long sequence = 0;

    public void assertDoPostConstraints( ) {

        if ( vetoDo ) {
            throw new VetoException( "vetoed Action do" );
        }
    }

    public void assertDoPreConstraints( ) {

        if ( vetoDo ) {
            throw new VetoException( "vetoed Action do" );
        }
    }

    public void assertUndoPostConstraints( ) {

        if ( vetoUndo ) {
            throw new VetoException( "vetoed Action undo" );
        }
    }

    public void assertUndoPreConstraints( ) {

        if ( vetoUndo ) {
            throw new VetoException( "vetoed Action undo" );
        }
    }

    public void computeDoActionsAndDoEvents( ) {

        prepareDoCalls++;
        doActions = new ArrayList<Action>( 3 );
        doActions.add( doAction1 );
        doActions.add( doAction2 );
        doActions.add( doAction3 );
    }

    public void computeUndoActionsAndUndoEvents( ) {

        prepareUndoCalls++;
        undoActions = new ArrayList<Action>( 3 );
        undoActions.add( undoAction1 );
        undoActions.add( undoAction2 );
        undoActions.add( undoAction3 );
    }

    public void computeRedoActionsAndRedoEvents( ) {

    }

    public List<Action> getDoActions( ) {

        getDoActionsCalls++;
        execTime = sequence++;
        return doActions;
    }

    public List<Action> getUndoActions( ) {

        getUndoActionsCalls++;
        undoTime = sequence++;
        return undoActions;
    }

    public List<Action> getRedoActions( ) {

        return getDoActions( );
    }

    public List<ChangeEvent> getDoEvents( ) {

        getEventsCalls++;
        return new ArrayList<ChangeEvent>( );
    }

    public List<ChangeEvent> getUndoEvents( ) {

        return new ArrayList<ChangeEvent>( );
    }

    public List<ChangeEvent> getRedoEvents( ) {

        return getDoEvents( );
    }

    public class MockAction implements Action {

        public int executeCalls = 0;

        public int revertCalls = 0;

        public long execTime = 0;

        public long revertTime = 0;

        public boolean doFailExecute = false;

        public boolean doFailRevert = false;

        public String name;

        public MockAction( String name ) {

            this.name = name;
        }

        public void execute( ) throws UnrecoverableExecutionException {

            executeCalls++;
            execTime = sequence++;
            if ( doFailExecute ) {
                throw new UnrecoverableExecutionException( new RuntimeException( ) );
            }
        }

        public void revert( ) throws UnrecoverableExecutionException {

            revertCalls++;
            revertTime = sequence++;
            if ( doFailRevert ) {
                throw new UnrecoverableExecutionException( new RuntimeException( ) );
            }

        }

    }

    public void doFinished( ) {

    }

    public void undoFinished( ) {

    }

    public void redoFinished( ) {

    }

    public void compact( ) {

    }

    public CoreConnection getConnection( ) {

        // TODO Auto-generated method stub
        return null;
    }
}
