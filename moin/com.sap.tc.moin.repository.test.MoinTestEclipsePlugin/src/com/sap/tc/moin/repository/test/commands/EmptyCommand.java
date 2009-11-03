package com.sap.tc.moin.repository.test.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * Mock Command that does nothing.
 * @author d045996
 *
 */
public class EmptyCommand extends Command {

    public int nOExecutions = 0;

    public EmptyCommand( Connection connection ) {

        super( connection, "DoNothing" );
    }

    public EmptyCommand( Connection connection, String description ) {

        super( connection, description );
    }

    @Override
    public boolean canExecute( ) {

        return true;
    }

    @Override
    public void doExecute( ) {

        // Do what is suppossed to do:
        // NOTHING!
        nOExecutions++;
    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions( ) {

        return null;
    }

    //    public InternalExecutableCommand getInternalCommand() {
    //        return (InternalExecutableCommand)this.handle;
    //    }

}
