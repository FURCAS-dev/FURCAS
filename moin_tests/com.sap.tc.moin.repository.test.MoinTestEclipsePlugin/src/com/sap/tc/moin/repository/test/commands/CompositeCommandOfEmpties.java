package com.sap.tc.moin.repository.test.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CompositeCommandOfEmpties extends Command {

    public int nOExecutions = 0;

    public EmptyCommand ec1, ec2, ec3;

    public CompositeCommandOfEmpties( Connection connection ) {

        this( connection, "CompositeCommandOfEmpties" );
    }

    public CompositeCommandOfEmpties( Connection connection, String description ) {

        super( connection, description );
        ec1 = new EmptyCommand( connection, "EmptySubCommand1" );
        ec2 = new EmptyCommand( connection, "EmptySubCommand2" );
        ec3 = new EmptyCommand( connection, "EmptySubCommand3" );
    }

    @Override
    public boolean canExecute( ) {

        return true;
    }

    @Override
    public void doExecute( ) {

        nOExecutions++;
        // Do what is suppossed to do:
        // Execute Empty Commands
        getConnection( ).getCommandStack( ).execute( ec1 );
        getConnection( ).getCommandStack( ).execute( ec2 );
        getConnection( ).getCommandStack( ).execute( ec3 );
    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions( ) {

        return null;
    }

    //        public InternalExecutableCommand getInternalCommand() {
    //            return (InternalExecutableCommand)this.handle;
    //        }

}
