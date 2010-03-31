/**
 * 
 */
package com.sap.tc.moin.repository.test.commands;


import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;


/**
 * An adapter implementation of BaseMoinCommand to be used as anonymous class
 * 
 * @author d045996
 *
 */
public abstract class AnonymousCommand extends Command {

    public AnonymousCommand( Connection connection, String description ) {

        super( connection, description );
    }

    public boolean canExecute( ) {

        return true;
    }

    public Collection<PartitionOperation> getAffectedPartitions( ) {

        return null;
    }

    //private static final com.sap.tc.logging.Location log = com.sap.tc.logging.Location.getLocation(Command.class);
}
