package com.sap.tc.moin.repository.transactions;

import java.util.List;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.transactions.actions.Action;

/**
 * The sequence on <b>executing</b> is the following:<br>
 * <ul>
 * <li>{@link #assertDoPreConstraints()}</li>
 * <li>{@link #computeDoActionsAndDoEvents()}</li>
 * <li>{@link #getDoEvents()}</li>
 * <li>{@link #getDoActions()}</li>
 * <li>{@link #assertDoPostConstraints()}</li>
 * <li>{@link #doFinished()}</li>
 * </ul>
 * <br>
 * The sequence on <b>undoing</b> is the following:<br>
 * <ul>
 * <li>{@link #assertUndoPreConstraints()}</li>
 * <li>{@link #computeUndoActionsAndUndoEvents()}</li>
 * <li>{@link #getUndoEvents()}</li>
 * <li>{@link #getUndoActions()}</li>
 * <li>{@link #assertUndoPostConstraints()}</li>
 * <li>{@link #undoFinished()}</li>
 * </ul>
 * <br>
 * The sequence on <b>redoing</b> is the following:<br>
 * <ul>
 * <li>{@link #computeRedoActionsAndRedoEvents()}</li>
 * <li>{@link #getRedoEvents()}</li>
 * <li>{@link #getRedoActions()}</li>
 * <li>{@link #redoFinished()}</li>
 * </ul>
 * <br>
 */
public interface MicroTransactionable {

    public void assertDoPostConstraints( ) throws JmiException, NullPointerException, RecoverableExecutionException;

    public void assertDoPreConstraints( ) throws JmiException, NullPointerException, RecoverableExecutionException;

    public void assertUndoPostConstraints( ) throws JmiException, NullPointerException, RecoverableExecutionException;

    public void assertUndoPreConstraints( ) throws JmiException, NullPointerException, RecoverableExecutionException;

    public void computeDoActionsAndDoEvents( ) throws JmiException, NullPointerException, RecoverableExecutionException;

    public void computeUndoActionsAndUndoEvents( ) throws JmiException, NullPointerException, RecoverableExecutionException;

    public void computeRedoActionsAndRedoEvents( ) throws JmiException, NullPointerException, RecoverableExecutionException;

    public List<Action> getDoActions( );

    public List<Action> getUndoActions( );

    public List<Action> getRedoActions( );

    public List<ChangeEvent> getDoEvents( );

    public List<ChangeEvent> getUndoEvents( );

    public List<ChangeEvent> getRedoEvents( );

    /**
     * Are invoked when the do, undo and redo phases were finished successfuly.
     * This provides the opportunity to clean up internal structures, e.g. lists
     * of actions and events or other internal objects.
     */
    public void doFinished( );

    public void undoFinished( );

    public void redoFinished( );

    public CoreConnection getConnection( );
}
