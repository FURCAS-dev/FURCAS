package com.sap.tc.moin.repository.test.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class DeepCompositeCommand extends Command {

    public int nOExecutions = 0;

    public int sub1NOExecutions = 0;

    public int sub2ANOExecutions = 0;

    public int sub2BNOExecutions = 0;

    public int sub3NOExecutions = 0;

    public DeepCompositeCommand( Connection connection ) {

        this( connection, "DeepCompositeCommand" );
    }

    public DeepCompositeCommand( Connection connection, String description ) {

        super( connection, description );
    }

    @Override
    public boolean canExecute( ) {

        return true;
    }

    @Override
    public void doExecute( ) {

        nOExecutions++;
        // Do what is suppossed to do:
        // Execute SubCommands
        executeSubCommand( new AnonymousCommand( this.getConnection( ), "SubCmd1" ) {

            public void doExecute( ) {

                sub1NOExecutions++;
                executeSubCommand( new AnonymousCommand( this.getConnection( ), "SubCmd2A" ) {

                    public void doExecute( ) {

                        sub2ANOExecutions++;
                        executeSubCommand( new AnonymousCommand( this.getConnection( ), "SubCmd3" ) {

                            public void doExecute( ) {

                                sub3NOExecutions++;
                            }
                        } );

                    }
                } );
                executeSubCommand( new AnonymousCommand( getConnection( ), "SubCmd2B" ) {

                    public void doExecute( ) {

                        sub2BNOExecutions++;
                    }
                } );
            }
        } );
    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions( ) {

        return null;
    }
    //        public InternalExecutableCommand getInternalCommand() {
    //            return (InternalExecutableCommand)this.handle;
    //        }


}
