/**
 * 
 */
package com.sap.tc.moin.repository.test.commands;

import org.junit.Test;

import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * @author d045996
 */
public class TestCommandIllegalOperations extends BaseCommandTest {

    @Test( expected = IllegalStateException.class )
    public void testSaveDuringCommand( ) {

        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                try {
                    getConnection( ).save( );
                } catch ( NullPartitionNotEmptyException e ) {
                    throw e;
                } catch ( ReferencedTransientElementsException e ) {
                    throw e;
                } catch ( PartitionsNotSavedException e ) {
                    throw new RuntimeException( e );
                }
            }
        };

        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    @Test( expected = IllegalStateException.class )
    public void testRevertDuringCommand( ) {

        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                this.getConnection( ).revert( );
            }
        };

        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    @Test( expected = IllegalStateException.class )
    public void testCloseDuringCommand( ) {

        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                this.getConnection( ).close( );
            }
        };

        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    @Test( expected = IllegalStateException.class )
    public void testUndoDuringCommand( ) {

        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                this.getConnection( ).getCommandStack( ).undo( );
            }
        };

        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    @Test( expected = IllegalStateException.class )
    public void testRedoDuringCommand( ) {

        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                this.getConnection( ).getCommandStack( ).redo( );
            }
        };

        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    @Test( expected = IllegalStateException.class )
    public void testClearDuringCommand( ) {

        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                this.getConnection( ).getCommandStack( ).clear( );
            }
        };

        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    @Test( expected = IllegalStateException.class )
    public void testUndoStackSizeDuringCommand( ) {

        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                this.getConnection( ).getCommandStack( ).setMaxUndoStackSize( 42 );
            }
        };

        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    @Test( expected = IllegalStateException.class )
    public void testOpenGroupDuringCommand( ) {

        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                this.getConnection( ).getCommandStack( ).openGroup( "GroupDescription" );
            }
        };

        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    @Test( expected = IllegalStateException.class )
    public void testCloseGroupDuringCommand( ) {

        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                this.getConnection( ).getCommandStack( ).closeGroup( );
            }
        };

        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    @Test( expected = IllegalStateException.class )
    public void testObtainApplicationLockDuringCommand( ) {

        final PRI pri = this.getPartitionOne( ).getPri( );
        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                this.getConnection( ).getSession( ).getLockManager( ).obtainApplicationLock( pri, getConnection( ) );
            }
        };

        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    @Test( expected = IllegalStateException.class )
    public void testReleaseApplicationLockDuringCommand( ) {

        final PRI pri = this.getPartitionOne( ).getPri( );
        Command cmd = new EmptyCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                this.getConnection( ).getSession( ).getLockManager( ).releaseApplicationLock( pri, getConnection( ) );
            }
        };

        getMOINConnection( ).getSession( ).getLockManager( ).obtainApplicationLock( pri, getMOINConnection( ) );
        getMOINConnection( ).getCommandStack( ).execute( cmd );
    }

    // //////////////////////////////////////////
    // Internal classes
    // //////////////////////////////////////////
    private static class TestListener implements PreChangeListener, ChangeListener, PreCommitListener, CommitListener, UpdateListener {

        public void prepare( ChangeEvent event ) {

        }

        public void notify( ChangeEvent event ) {

        }

        public void prepareCommit( EventChain events ) {

        }

        public void notifyCommit( EventChain events ) {

        }

        public void notifyUpdate( EventChain events ) {

        }

    }
}
