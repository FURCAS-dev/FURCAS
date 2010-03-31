package com.sap.tc.moin.primary.facility.test.ide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.jobs.Job;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsFacilityForTest;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.friends.CommandStackObserver;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.core.CommandStackWrapper;
import com.sap.tc.moin.repository.core.CoreCommandStack;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.spi.util.SpiDelegator;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Tests for known deadlock situations during facility locking.
 * <p>
 * Known cases are:
 * <ul>
 * <li>Some thread in Eclipse locks resources, then executes save, while other
 * thread executes save, without acquiring resource locks. System is then
 * deadlocked on MOIN's big write lock.</li>
 * <li>A command is being executed. Before the root command starts, the stack
 * listeners are notified about the pending command. The listeners still have
 * the possibility to execute Connection.save(). The system is deadlocked on
 * MOIN's big write lock.</li>
 * </ul>
 * </p>
 * 
 * @author D046220
 */
public class TestCoreFacilityLocks extends MoinTestCase {


    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Test( timeout = 30000 )
    public void testDiiDeadlock( ) {

        Thread testThread = new Thread( new Runnable( ) {

            public void run( ) {

                Job.getJobManager( ).beginRule( ResourcesPlugin.getWorkspace( ).getRoot( ), null );


                Job.getJobManager( ).endRule( ResourcesPlugin.getWorkspace( ).getRoot( ) );
            }

        } );

        testThread.start( );
        try {
            testThread.join( );
        } catch ( InterruptedException e ) {
            throw new RuntimeException( e );
        }
    }

    @Test
    public void testDeadLockAvoidanceOnSave( ) {

        TestClient client1 = getTestHelper( ).getDefaultTestClient( true );
        client1.setAsCurrentClient( );
        Connection conn = client1.getConnection( );

        final ModelPartition p1 = client1.getOrCreatePartition( "test/my.xmi" );

        TestClient client2 = getTestHelper( ).getDefaultTestClient( true );
        client2.setAsCurrentClient( );

        final Connection conn2 = client2.getConnection( );


        final ModelPartition p2 = client2.getOrCreatePartition( "test/my2.xmi" );

        final CountDownLatch latch = new CountDownLatch( 1 );


        Thread testThread = ( new Thread( ) {

            @Override
            public void run( ) {

                Job.getJobManager( ).beginRule( ResourcesPlugin.getWorkspace( ).getRoot( ), null );

                latch.countDown( );

                try {
                    Thread.sleep( 1000 );
                } catch ( InterruptedException e1 ) {
                    throw new RuntimeException( e1 );
                }

                try {
                    conn2.save( );
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                } finally {
                    Job.getJobManager( ).endRule( ResourcesPlugin.getWorkspace( ).getRoot( ) );
                }

            }

        } );
        testThread.setName( "Deadlock test thread" );
        testThread.start( );

        try {
            latch.await( );
        } catch ( InterruptedException e1 ) {
            throw new RuntimeException( e1 );
        }

        try {
            conn2.save( );
        } catch ( Exception e ) {
            fail( e.getMessage( ) );
        }

        try {
            testThread.join( );
        } catch ( InterruptedException e ) {
            throw new RuntimeException( e );
        }

        conn.close( );
        conn2.close( );
    }

    /**
     * This test makes sure that no deadlocks occur on eclipse refresh
     * operations triggered on partition load.
     */
    @Test( timeout = 60000 )
    public void testDeadLockAvoidanceOnLoad( ) throws Exception {

        TestClient client1 = getTestHelper( ).getDefaultTestClient( true );
        client1.setAsCurrentClient( );
        Connection conn = client1.getConnection( );

        // create and save partition in first connection 
        final ModelPartition p1 = client1.getOrCreatePartitionStable( "test/myDeadlockOnLoadTest1" ); //$NON-NLS-1$
        conn.save( );

        // get resource for partition
        IpiFsResourceManagement resourceManagement = ( (IpiFsFacilityForTest) SpiDelegator.dismantle( getFacility( ) ) ).getResourceManagement( );
        IpiStorage storage = resourceManagement.getStorageResponsibleForPRI( p1.getPri( ) );
        File p1File = storage.getPartitionResourceHandle( p1.getPri( ) ).getUnderlyingResource( IFile.class ).getLocation( ).toFile( );

        // now we make a change on java.io.File level (resource is out of sync)
        OutputStream os = null;
        try {
            os = new FileOutputStream( p1File, true );
            os.write( "<!-- appended content -->".getBytes( ) ); //$NON-NLS-1$
            os.flush( );
        } finally {
            if ( os != null ) {
                os.close( );
            }
        }

        // prepare second connection
        final TestClient client2 = getTestHelper( ).getDefaultTestClient( true );
        client2.setAsCurrentClient( );
        final Connection conn2 = client2.getConnection( );
        final CountDownLatch latch = new CountDownLatch( 1 );

        Thread testThread = ( new Thread( ) {

            @Override
            public void run( ) {

                // get an eclipse workspace lock first
                Job.getJobManager( ).beginRule( ResourcesPlugin.getWorkspace( ).getRoot( ), null );

                // start other thread
                latch.countDown( );

                try {
                    // wait until other thread acquired MOIN locks
                    Thread.sleep( 2000 );
                } catch ( InterruptedException e1 ) {
                    throw new RuntimeException( e1 );
                }

                try {
                    // execute MOIN operation in second connection
                    client2.getOrCreatePartitionStable( "test/myDeadlockOnLoadTest2" ); //$NON-NLS-1$
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                } finally {
                    Job.getJobManager( ).endRule( ResourcesPlugin.getWorkspace( ).getRoot( ) );
                }

            }

        } );
        testThread.setName( "Deadlock test thread" ); //$NON-NLS-1$
        testThread.start( );

        try {
            latch.await( );
        } catch ( InterruptedException e1 ) {
            throw new RuntimeException( e1 );
        }

        try {
            // trigger load on out-of-sync resource
            client1.getOrCreatePartitionStable( "test/myDeadlockOnLoadTest1" ); //$NON-NLS-1$
        } catch ( Exception e ) {
            e.printStackTrace( );
            fail( e.getMessage( ) );
        }

        try {
            testThread.join( );
        } catch ( InterruptedException e ) {
            throw new RuntimeException( e );
        }

        conn.close( );
        conn2.close( );
    }

    @Test( timeout = 30000 )
    public void testDeadLockAvoidanceOnCommandStack( ) {

        TestClient client1 = getTestHelper( ).getDefaultTestClient( true );
        client1.setAsCurrentClient( );
        final Connection conn = client1.getConnection( );

        CommandStack stack = conn.getCommandStack( );

        final ModelPartition p1 = client1.getOrCreatePartition( "test/my" + System.currentTimeMillis( ) + ".xmi" );

        TestClient client2 = getTestHelper( ).getDefaultTestClient( true );
        client2.setAsCurrentClient( );

        final Connection conn2 = client2.getConnection( );


        final ModelPartition p2 = client2.getOrCreatePartition( "test/my2" + System.currentTimeMillis( ) + ".xmi" );

        Thread testThread = ( new Thread( ) {

            @Override
            public void run( ) {

                Job.getJobManager( ).beginRule( ResourcesPlugin.getWorkspace( ).getRoot( ), null );

                try {
                    Thread.sleep( 1000 );
                } catch ( InterruptedException e1 ) {
                    throw new RuntimeException( e1 );
                }

                try {
                    conn2.save( );
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }

                Job.getJobManager( ).endRule( ResourcesPlugin.getWorkspace( ).getRoot( ) );
            }

        } );
        testThread.start( );

        try {
            // wait until the other thread has the workspace lock.
            Thread.sleep( 200 );
        } catch ( InterruptedException e1 ) {
            throw new RuntimeException( e1 );
        }

        ( (CommandStackWrapper) stack ).unwrap( ).setCommandStackObserver( new CommandStackObserver( ) {


            private void save( ) {

                try {
                    conn2.save( );
                } catch ( Exception e ) {
                    fail( e.getMessage( ) );
                }
            }

            public void notifyBeforeRootCommandExecution( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

                save( );
            }

            public void notifyTopLevelCommandExecuted( CommandHandle cmdHnd, Connection con ) {


            }

            public void notifyTopLevelCommandRedone( CommandHandle cmdHnd, Connection con ) {

            }

            public void notifyTopLevelCommandUndone( CommandHandle cmdHnd, Connection con ) {

            }

            public void notifyTopLevelStacksCleared( Connection con ) {

            }

            public Collection<Connection> getConnectionsToBeSaved( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

                return Collections.singleton( conn );
            }

        } );

        stack.execute( new Command( conn ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return Collections.singletonList( new PartitionOperation( Operation.CREATE, p1.getPri( ) ) );
            }

        } );

    }

    @Test( timeout = 30000 )
    public void testDeadLockAvoidanceOnCommandStackWithOneCreatedPartitionToBeSaved( ) {

        TestClient client1 = getTestHelper( ).getDefaultTestClient( true );
        client1.setAsCurrentClient( );
        Connection conn = client1.getConnection( );

        CommandStack stack = conn.getCommandStack( );
        CoreCommandStack coreStack = (CoreCommandStack) ( (Wrapper) stack ).unwrap( );

        final ModelPartition p1 = client1.getOrCreatePartition( "test/my" + System.currentTimeMillis( ) + ".xmi" );

        TestClient client2 = getTestHelper( ).getDefaultTestClient( true );
        client2.setAsCurrentClient( );

        final Connection conn2 = client2.getConnection( );


        final ModelPartition p2 = client2.getOrCreatePartition( "test/my2" + System.currentTimeMillis( ) + ".xmi" );

        Thread testThread = ( new Thread( ) {

            @Override
            public void run( ) {

                Job.getJobManager( ).beginRule( ResourcesPlugin.getWorkspace( ).getRoot( ), null );

                try {
                    Thread.sleep( 1000 );
                } catch ( InterruptedException e1 ) {
                    throw new RuntimeException( e1 );
                }

                try {
                    conn2.save( );
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }

                Job.getJobManager( ).endRule( ResourcesPlugin.getWorkspace( ).getRoot( ) );
            }

        } );
        testThread.start( );

        try {
            // wait until the other thread has the workspace lock.
            Thread.sleep( 200 );
        } catch ( InterruptedException e1 ) {
            throw new RuntimeException( e1 );
        }

        coreStack.setCommandStackObserver( new CommandStackObserver( ) {


            private void save( ) {

                try {
                    conn2.save( );
                } catch ( Exception e ) {
                    fail( e.getMessage( ) );
                }
            }

            public void notifyBeforeRootCommandExecution( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

                save( );
            }

            public void notifyTopLevelCommandExecuted( CommandHandle cmdHnd, Connection con ) {


            }

            public void notifyTopLevelCommandRedone( CommandHandle cmdHnd, Connection con ) {

            }

            public void notifyTopLevelCommandUndone( CommandHandle cmdHnd, Connection con ) {

            }

            public void notifyTopLevelStacksCleared( Connection con ) {

            }

            public Collection<Connection> getConnectionsToBeSaved( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

                return Collections.singleton( conn2 );
            }

        } );

        stack.execute( new Command( conn ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return Collections.singletonList( new PartitionOperation( Operation.CREATE, p1.getPri( ) ) );
            }

        } );
    }

    @Test( timeout = 30000 )
    public void testDeadLockAvoidanceOnCommandStackWithAllDirtyPartitions( ) {

        TestClient client1 = getTestHelper( ).getDefaultTestClient( true );
        client1.setAsCurrentClient( );
        Connection conn = client1.getConnection( );

        CommandStack stack = conn.getCommandStack( );
        CoreCommandStack coreStack = (CoreCommandStack) ( (Wrapper) stack ).unwrap( );

        final ModelPartition p1 = client1.getOrCreatePartition( "test/my" + System.currentTimeMillis( ) + ".xmi" );

        TestClient client2 = getTestHelper( ).getDefaultTestClient( true );
        client2.setAsCurrentClient( );

        final Connection conn2 = client2.getConnection( );


        final ModelPartition p2 = client2.getOrCreatePartition( "test/my2" + System.currentTimeMillis( ) + ".xmi" );

        Thread testThread = ( new Thread( ) {

            @Override
            public void run( ) {

                Job.getJobManager( ).beginRule( ResourcesPlugin.getWorkspace( ).getRoot( ), null );

                try {
                    Thread.sleep( 1000 );
                } catch ( InterruptedException e1 ) {
                    throw new RuntimeException( e1 );
                }

                try {
                    conn2.save( );
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }

                Job.getJobManager( ).endRule( ResourcesPlugin.getWorkspace( ).getRoot( ) );
            }

        } );
        testThread.start( );

        try {
            // wait until the other thread has the workspace lock.
            Thread.sleep( 200 );
        } catch ( InterruptedException e1 ) {
            throw new RuntimeException( e1 );
        }

        coreStack.setCommandStackObserver( new CommandStackObserver( ) {


            private void save( ) {

                try {
                    conn2.save( );
                } catch ( Exception e ) {
                    fail( e.getMessage( ) );
                }
            }

            public void notifyBeforeRootCommandExecution( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

                save( );
            }

            public void notifyTopLevelCommandExecuted( CommandHandle cmdHnd, Connection con ) {


            }

            public void notifyTopLevelCommandRedone( CommandHandle cmdHnd, Connection con ) {

            }

            public void notifyTopLevelCommandUndone( CommandHandle cmdHnd, Connection con ) {

            }

            public void notifyTopLevelStacksCleared( Connection con ) {

            }

            public Collection<Connection> getConnectionsToBeSaved( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

                return Collections.singleton( conn2 );
            }

        } );

        stack.execute( new Command( conn ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        } );
    }

}
