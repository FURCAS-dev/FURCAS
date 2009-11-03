package com.sap.tc.moin.repository.core.commands;

import java.util.Iterator;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.transactions.RecordOfMicroTx;
import com.sap.tc.moin.repository.shared.util.FastStack;

/**
 * An Internal Command that groups a set of Internal Commands. During the time a
 * command group is open, new executed commands are put in the undo stack of the
 * group. When the group is closed, the transaction record of the commands in
 * the undo stack are consolidated in the transaction record of the group.
 * 
 * @author d045996
 */
public class InternalCommandGroup extends InternalCommand {

    FastStack<InternalCommand> undoStack = new FastStack<InternalCommand>( 30 );

    /**
     * @param actConn
     * @param descr
     */
    public InternalCommandGroup( Connection actConn, String descr ) {

        super( actConn, descr );
    }

    /**
     * @return The undo stack of the group, used by the {@link CommandStackImpl}
     * while the group is open.
     */
    public FastStack<InternalCommand> getUndoStack( ) {

        if ( this.state != InternalCommand.CommandState.INITIALIZED ) {
            throw new CommandBugException( CommandsExceptionMessages.COMMANDGROUPCLOSED );
        }
        return this.undoStack;
    }

    /**
     * Closes the group, and returns true only when the group contains at least
     * one command.
     * 
     * @return success flag
     */
    public boolean closeGroup( ) {

        this.state = InternalCommand.CommandState.DONE;

        if ( !this.undoStack.isEmpty( ) ) {
            // Consolidate Records of commands in the Record of the group.
            Iterator<InternalCommand> it = this.undoStack.iterator( );
            // Reuse the record of the first Internal Command
            this.txRecord = it.next( ).txRecord;
            RecordOfMicroTx tr = (RecordOfMicroTx) this.txRecord;
            while ( it.hasNext( ) ) {
                tr.addRecord( it.next( ).txRecord );
            }
        }
        this.undoStack = null;
        return ( this.txRecord != null && ( (RecordOfMicroTx) this.txRecord ).canUndo( ) );
    }

}
