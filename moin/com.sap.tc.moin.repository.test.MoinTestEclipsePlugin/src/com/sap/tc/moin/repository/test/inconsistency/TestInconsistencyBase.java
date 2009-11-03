package com.sap.tc.moin.repository.test.inconsistency;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.consistency.ConsistencyViolationListenerRegistry;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.ConsistencyViolationRegistryWrapperImpl;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.PartitionChangeRecorder;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.core.consistency.impl.ConsistencyViolationRegistryImpl;
import com.sap.tc.moin.repository.core.serialization.PartitionReaderImpl;
import com.sap.tc.moin.repository.core.serialization.PartitionWriterImpl;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;
import com.sap.tc.moin.testcases.case002.Case002Package;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.Case004Package;
import com.sap.tc.moin.testcases.case005.Case005Package;
import com.sap.tc.moin.testcases.case005.p1.A5;
import com.sap.tc.moin.testcases.case005.p1.p2.B5;
import com.sap.tc.moin.testcases.case006.B6;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.D6;
import com.sap.tc.moin.testcases.case008.Case008Package;
import com.sap.tc.moin.testcases.case017.A17;
import com.sap.tc.moin.testcases.case017.Case017Package;

public abstract class TestInconsistencyBase extends CoreMoinTest {

    protected MoinPackage moinPackage = null;

    protected TestcasesPackage testcasesPackage = null;

    protected Case002Package case002Package = null;

    protected Case004Package case004Package = null;

    protected Case008Package case008Package = null;

    protected RefClass a4Class = null;

    protected RefClass a8Class = null;

    protected RefClass b4Class = null;

    public TestInconsistencyBase( ) {

        super( );
    }

    protected C2 createC2( ) {

        return getMOINConnection( ).createElementInPartition( C2.class, null );
    }

    protected B2 createB2( ) {

        return getMOINConnection( ).createElementInPartition( B2.class, null );
    }

    protected B4 createB4( String value ) {

        B4 b4 = getMOINConnection( ).createElementInPartition( B4.class, null );
        b4.setOnePrimitive( value );
        return b4;
    }

    protected A17 createA17( ) {

        Case017Package case017Package = testcasesPackage.getCase017( );

        A17 a17 = getMOINConnection( ).createElementInPartition( A17.class, null );
        A17 a17_2 = getMOINConnection( ).createElementInPartition( A17.class, null );
        a17.getToEnd( ).add( a17_2 );

        a17_2.setFromEnd( a17 );

        return a17;
    }

    protected A17 createSingleA17( ) {

        A17 a17 = getMOINConnection( ).createElementInPartition( A17.class, null );

        return a17;
    }

    protected A5 createA5( ) {

        Case005Package case005Package = testcasesPackage.getCase005( );
        B5 child = getMOINConnection( ).createElementInPartition( B5.class, null );
        A5 parent = getMOINConnection( ).createElementInPartition( A5.class, null );
        parent.setX( child );
        return parent;
    }

    protected A4 createA4( ) {

        A4 a4 = getMOINConnection( ).createElementInPartition( A4.class, null );
        a4.setOnePrimitive( "initial" ); // onePrimitive
        a4.setOnePrimitiveOptional( "Primitive" ); // onePrimitiveOptional
        a4.setOnePrimitiveNotChangeable( "initial" ); // onePrimitiveNotChangeable
        a4.getManyPrimitive( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitive
        a4.getManyPrimitiveUnique( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveUnique
        a4.getManyPrimitiveOrderedNotChangeable( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveNotChangeable
        a4.getManyPrimitiveOrdered( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveOrdered
        a4.getManyPrimitiveOrderedUnique( ).addAll( Arrays.asList( new String[] { "initial0", "initial1", "initial2", "initial3", "initial4" } ) ); // manyPrimitiveOrderedUnique
        a4.setOneBchangeable( createB4( "B4-Initial" ) ); // oneBChangeable
        a4.getManyBs( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBs
        a4.getManyBsUnique( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBsUnique
        a4.getManyBsOrdered( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBsOrdered
        a4.getManyBsOrderedUnique( ).addAll( Arrays.asList( createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ), createB4( "B4-Initial" ) ) ); // manyBsOrderedUnique
        return a4;
    }

    protected B6 createB6( ) {

        return getMOINConnection( ).createElementInPartition( B6.class, null );

    }

    protected C6 createC6( ) {

        return getMOINConnection( ).createElementInPartition( C6.class, null );
    }

    protected D6 createD6( ) {

        return getMOINConnection( ).createElementInPartition( D6.class, null );
    }

    protected void checkCorrectionWithSecondConnection( MyConsistencyListener secondListener, ModelPartition... mp ) {

        for ( ModelPartition modelPartition : mp ) {
            this.getSecondMOINConnection( ).getConsistencyViolationListenerRegistry( ).performConsistencyCheck( modelPartition.getPri( ) );

            this.verify( secondListener.getViolations( ).isEmpty( ), "Inconsistencies left." );
        }
    }

    protected MyConsistencyListener createInconsistencyListener( Connection connection ) {

        ConsistencyViolationListenerRegistry consistencyViolationRegistry = connection.getConsistencyViolationListenerRegistry( );

        MyConsistencyListener listener = new MyConsistencyListener( getTestHelper( ).getCoreConnection( connection ).getConsistencyViolationRegistry( ) );
        consistencyViolationRegistry.addListener( listener );
        return listener;
    }

    /**
     * @param mp
     * @param partitionName
     * @param byteArray
     * @return
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    protected ModelPartition createDuplicatePartition( String partitionName, byte[] byteArray, TestClient client ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        return createNewPartitionFromByteArray( partitionName, byteArray, client );

    }

    /**
     * @param partitionName
     * @param byteArray
     * @return
     * @throws PartitionsNotSavedException
     * @throws ReferencedTransientElementsException
     * @throws NullPartitionNotEmptyException
     */
    protected ModelPartition createNewPartitionFromByteArray( String partitionName, byte[] byteArray, TestClient client ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        // create second partition
        ModelPartition mpCopy = client.getOrCreatePartitionStable( partitionName );
        mpCopy.delete( );
        client.getConnection( ).save( );

        mpCopy = client.getOrCreatePartitionStable( partitionName );

        fillPartitionFromByteArray( mpCopy, byteArray, client );
        processNotificationQueue( );
        ensurePartitionLoadedInCCSW( mpCopy ); // COW ensure that the partition is loaded in the CCSW

        return mpCopy;
    }

    protected final void ensurePartitionLoadedInCCSW( ModelPartition partition ) {

        CoreModelPartition coreModelPartition = getTestHelper( ).getCoreModelPartition( partition );
        assertTrue( coreModelPartition.getWorkspace( ) instanceof CompoundClientSpecWorkspace );
    }

    @SuppressWarnings( "unchecked" )
    private void fillPartitionFromByteArray( ModelPartition partition, byte[] byteArray, TestClient client ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        CoreModelPartition cmpCopy = ( (Wrapper<CoreModelPartition>) partition ).unwrap( );

        PartitionReaderImpl reader = new PartitionReaderImpl( );

        try {
            reader.read( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), new ByteArrayInputStream( byteArray ), cmpCopy );
        } catch ( Exception e ) {
            errorAndStop( "Partition could not be restored from xmi.", e );
        }

        // TODO update partition change recorder
        CoreConnection coreConnection = this.getTestHelper( ).getCoreConnection( client.getConnection( ) );
        PartitionChangeRecorder changeRecorder = coreConnection.getPartitionChangeRecorder( );
        for ( Partitionable element : cmpCopy.getElements( ) ) {
            changeRecorder.elementCreated( (CorePartitionable) element );
        }

        for ( SpiLink link : cmpCopy.getLinks( ) ) {
            changeRecorder.linkAdded( (EndStorageLink) link );
        }

        client.getConnection( ).save( );
    }

    /**
     * @param mp
     * @return
     */
    protected byte[] getPartitionByteArray( ModelPartition mp ) {

        CoreModelPartition cmp = ( (Wrapper<CoreModelPartition>) mp ).unwrap( );
        PartitionWriterImpl writer = new PartitionWriterImpl( );
        ByteArrayOutputStream os = new ByteArrayOutputStream( );
        try {
            writer.write( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), os, cmp );
        } catch ( IOException e ) {
            errorAndStop( "Partition could not written to xmi.", e );
        }

        byte[] byteArray = os.toByteArray( );
        return byteArray;
    }

    protected ModelPartition recreatePartition( String name ) {

        ModelPartition mp = this._testClient1.getOrCreatePartitionStable( name );
        mp.delete( );
        saveConnectionOne( );
        mp = this._testClient1.getOrCreatePartitionStable( name );
        saveConnectionOne( );
        return mp;
    }

    /**
     * 
     */
    protected void saveConnectionOne( ) {

        try {
            this.getMOINConnection( ).save( );
        } catch ( Exception e ) {
            errorAndStop( "Partition could not be saved.", e );
        }
    }

    protected void verifyNoConsistencyViolations( MyConsistencyListener listener ) {

        this.verify( listener.getViolations( ).isEmpty( ), "Inconsistencies left." );
    }

    protected boolean checkPartitionViolationCounter( Connection connection, PRI pri ) {

        CoreConnection coreConnection = MoinTestCase.getTestHelper( ).getCoreConnection( connection );
        ConsistencyViolationRegistry registry = coreConnection.getConsistencyViolationRegistry( );
        return registry.isPartitionInconsistent( pri );
    }

    protected void processNotificationQueue( ) {

        ConsistencyViolationRegistryImpl registry = (ConsistencyViolationRegistryImpl) ( (ConsistencyViolationRegistryWrapperImpl) this.getMOINConnection( ).getConsistencyViolationListenerRegistry( ) ).unwrap( );
        registry.processNotificationQueue( );
    }

    protected void processSecondNotificationQueue( ) {

        ConsistencyViolationRegistryImpl registry = (ConsistencyViolationRegistryImpl) ( (ConsistencyViolationRegistryWrapperImpl) this.getSecondMOINConnection( ).getConsistencyViolationListenerRegistry( ) ).unwrap( );
        registry.processNotificationQueue( );
    }

    class MyConsistencyListener implements ConsistencyListener {

        private final List<ConsistencyViolation> events = new ArrayList<ConsistencyViolation>( );

        private int numberOfNotifications = 0;

        private ConsistencyViolationRegistry registry;

        public MyConsistencyListener( ConsistencyViolationRegistry registry ) {

            this.registry = registry;
        }

        public ConsistencyViolationRegistry getRegistry( ) {

            return registry;
        }

        public void onConsistencyViolation( ConsistencyViolation[] consistencyEvents, Connection connection ) {

            for ( ConsistencyViolation event : consistencyEvents ) {
                // check if event already exists since it is not guaranteed that a notification occurs only once
                if ( !this.events.contains( event ) ) {
                    this.events.add( event );
                }
            }
            this.numberOfNotifications++;
        }

        public void onConsistencyResolution( ConsistencyViolation[] consistencyEvents, Connection connection ) {

            for ( ConsistencyViolation event : consistencyEvents ) {
                while ( this.events.remove( event ) ) {
                }
            }
            this.numberOfNotifications++;
        }

        public List<ConsistencyViolation> getViolations( ) {

            return new ArrayList<ConsistencyViolation>( this.events );
        }

        public void reset( ) {

            this.events.clear( );
            this.numberOfNotifications = 0;
        }

        public List<ConsistencyViolation> getEvents( ) {

            return this.events;
        }

        public int getNumberOfNotifications( ) {

            return this.numberOfNotifications;
        }

        @Override
        public String toString( ) {

            StringBuilder entries = new StringBuilder( );
            for ( ConsistencyViolation violation : this.events ) {
                entries.append( violation.toString( ) );
                entries.append( "\n" );
            }
            return "Entries: " + entries;
        }

    }
}
