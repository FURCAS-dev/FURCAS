package com.sap.tc.moin.repository.test.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class UnexecutableCommand extends Command {

    public int nOExecutions = 0;

    public UnexecutableCommand( Connection connection ) {

        super( connection, "Unexecutable" );
    }

    public UnexecutableCommand( Connection connection, String description ) {

        super( connection, description );
    }

    @Override
    public boolean canExecute( ) {

        return false;
    }

    @Override
    public void doExecute( ) {

        nOExecutions++;
        // As this command can never execute, throw an exception
        throw new RuntimeException( "Command cannot be executed" );

    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions( ) {

        return null;
    }


}
