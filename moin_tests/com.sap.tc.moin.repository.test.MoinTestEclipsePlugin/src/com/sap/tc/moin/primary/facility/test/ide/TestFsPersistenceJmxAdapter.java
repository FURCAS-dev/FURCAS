package com.sap.tc.moin.primary.facility.test.ide;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.TabularData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.persistence.fs.FsPersistenceImpl;
import com.sap.tc.moin.facility.primary.persistence.fs.ResourceManagementImpl;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.jmx.FsPersistenceMBean;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.test.fw.JmxRemoteConnection;
import com.sap.tc.moin.testcases.TestcasesPackage;


public class TestFsPersistenceJmxAdapter extends FacilityIdeMoinTest {

    private FsPersistenceImpl persistence = null;

    private JmxRemoteConnection jmx = null;

    private static final long maxMillis = 2000L;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.getPartitionOne( ).delete( );
        this.getPartitionTwo( ).delete( );
        this.getPartitionThree( ).delete( );
        this.saveConnectionOne( );

        this.persistence = (FsPersistenceImpl) ( (SpiFacility) getFacility( ) ).getModelPersistence( );

        if ( this.jmx == null ) {
            this.jmx = getTestHelper( ).createJmxRemoteConnection( this.persistence.getObjectName( ) );
        } else {
            this.jmx.reset( );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( jmx != null ) {
            this.jmx.shutdown( );
        }

        super.afterTestMethod( );
    }

    @Test
    public void testJmxNotification_loadPartitionStart( ) throws Exception {

        String partitionName = "jmx_loadPartitionStart";

        // create partition to load
        ModelPartition mp = this._testClient1.getOrCreatePartitionStable( partitionName );
        this.saveConnectionOne( );
        this.evictPartition( mp );

        final String priString = mp.getPri( ).toString( );

        // define the notification listener
        NotificationListener listener = new NotificationListener( ) {

            public void handleNotification( Notification notification, Object handback ) {

                assertTrue( "PRI does not match: expected=" + priString + ", was=" + notification.getMessage( ), notification.getMessage( ).contains( priString ) );
            }
        };

        this.jmx.addNotificationListener( listener, FsPersistenceMBean.LOAD_PARTITION_START, null );
        this.jmx.enableNotifications( );

        try {
            mp = this._testClient1.getOrCreatePartitionStable( partitionName );
            assertNotNull( mp );

            int count = jmx.waitForCorrectNotifications( listener, 1, maxMillis );
            assertTrue( "Not enough correct notifications within " + maxMillis + "ms! count=" + count, count >= 1 );
        } finally {
            this.jmx.disableNotifications( );
            this.jmx.removeNotificationListener( listener );
        }

        // cleanup
        mp.delete( );
        this.saveConnectionOne( );
    }

    @Test
    public void testJmxNotification_loadPartitionEnd( ) throws Exception {

        String partitionName = "jmx_loadPartitionEnd";

        // create partition to load
        ModelPartition mp = this._testClient1.getOrCreatePartitionStable( partitionName );
        this.saveConnectionOne( );
        this.evictPartition( mp );

        final String priString = mp.getPri( ).toString( );

        // define the notification listener
        NotificationListener listener = new NotificationListener( ) {

            public void handleNotification( Notification notification, Object handback ) {

                assertTrue( "PRI does not match: expected=" + priString + ", was=" + notification.getMessage( ), notification.getMessage( ).contains( priString ) );
            }
        };

        this.jmx.addNotificationListener( listener, FsPersistenceMBean.LOAD_PARTITION_END, null );
        this.jmx.enableNotifications( );

        try {
            mp = this._testClient1.getOrCreatePartitionStable( partitionName );
            assertNotNull( mp );

            int count = jmx.waitForCorrectNotifications( listener, 1, maxMillis );
            assertTrue( "Not enough correct notifications within " + maxMillis + "ms! count=" + count, count >= 1 );
        } finally {
            this.jmx.disableNotifications( );
            this.jmx.removeNotificationListener( listener );
        }

        // cleanup
        mp.delete( );
        this.saveConnectionOne( );
    }

    @Test
    public void testJmxNotification_storePartitionStart( ) throws Exception {

        String partitionName = "jmx_storePartitionStart";

        // create partition to load
        ModelPartition mp = this._testClient1.getOrCreatePartitionStable( partitionName );

        final String priString = mp.getPri( ).toString( );

        // define the notification listener
        NotificationListener listener = new NotificationListener( ) {

            public void handleNotification( Notification notification, Object handback ) {

                assertTrue( "PRI does not match: expected=" + priString + ", was=" + notification.getMessage( ), notification.getMessage( ).equals( priString ) );
            }
        };

        this.jmx.addNotificationListener( listener, FsPersistenceMBean.STORE_PARTITION_START, null );
        this.jmx.enableNotifications( );

        try {
            this.saveConnectionOne( );

            int count = jmx.waitForCorrectNotifications( listener, 1, maxMillis );
            assertTrue( "Not enough correct notifications within " + maxMillis + "ms! count=" + count, count >= 1 );
        } finally {
            this.jmx.disableNotifications( );
            this.jmx.removeNotificationListener( listener );
        }

        // cleanup
        mp.delete( );
        this.saveConnectionOne( );
    }

    @Test
    public void testJmxNotification_storePartitionEnd( ) throws Exception {

        String partitionName = "jmx_storePartitionEnd";

        // create partition to load
        ModelPartition mp = this._testClient1.getOrCreatePartitionStable( partitionName );

        final String priString = mp.getPri( ).toString( );

        // define the notification listener
        NotificationListener listener = new NotificationListener( ) {

            public void handleNotification( Notification notification, Object handback ) {

                assertTrue( "PRI does not match: expected=" + priString + ", was=" + notification.getMessage( ), notification.getMessage( ).equals( priString ) );
            }
        };

        this.jmx.addNotificationListener( listener, FsPersistenceMBean.STORE_PARTITION_END, null );
        this.jmx.enableNotifications( );

        try {
            this.saveConnectionOne( );

            int count = jmx.waitForCorrectNotifications( listener, 1, maxMillis );
            assertTrue( "Not enough correct notifications within " + maxMillis + "ms! count=" + count, count >= 1 );
        } finally {
            this.jmx.disableNotifications( );
            this.jmx.removeNotificationListener( listener );
        }

        // cleanup
        mp.delete( );
        this.saveConnectionOne( );
    }

    @Test
    public void testJmxAtribute_Storages( ) throws Exception {

        ResourceManagementImpl rm = (ResourceManagementImpl) getResourceManagement( );

        Field storageLockField = ResourceManagementImpl.class.getDeclaredField( "registryLock" );
        storageLockField.setAccessible( true );
        ReentrantReadWriteLock storageLock = (ReentrantReadWriteLock) storageLockField.get( rm );
        storageLock.readLock( ).lock( );

        try {
            TabularData result = (TabularData) this.jmx.getAttribute( "Storages" );
            ResourceIdentifierFactory riFactory = getFacility( ).getRIFactory( );

            Collection<CompositeData> values = (Collection<CompositeData>) result.values( );
            for ( CompositeData value : values ) {
                CRI cri = riFactory.createCri( (String) value.get( "1: Data Area" ), (String) value.get( "2: Container" ) );
                Set<String> registeredResourceFoldersForContainer = rm.getRegisteredResourceFoldersForContainer( cri );
                Set<String> registeredRootPathsForContainer = rm.getRegisteredRootPathsForContainer( cri );

                assertTrue( registeredResourceFoldersForContainer.toString( ) + " does not contain " + (String) value.get( "4: Resource Folder" ), registeredResourceFoldersForContainer.contains( (String) value.get( "4: Resource Folder" ) ) );

                assertFalse( ( (String) value.get( "5: Storage Type" ) ).equals( "unknown" ) );
                if ( ( (String) value.get( "5: Storage Type" ) ).equals( "Directory" ) ) {
                    assertTrue( registeredRootPathsForContainer.toString( ) + " does not contain " + (String) value.get( "3: Source Path" ), registeredRootPathsForContainer.contains( (String) value.get( "3: Source Path" ) ) );
                }
            }

            Field declaredField = ResourceManagementImpl.class.getDeclaredField( "storageRegistry" );
            declaredField.setAccessible( true );
            List<IpiStorage> allStorages = new ArrayList<IpiStorage>( );
            Map<DataAreaDescriptor, Map<String, List<IpiStorage>>> storageRegistry = (Map<DataAreaDescriptor, Map<String, List<IpiStorage>>>) declaredField.get( rm );
            for ( Map<String, List<IpiStorage>> entry1 : storageRegistry.values( ) ) {
                for ( List<IpiStorage> entry2 : entry1.values( ) ) {
                    allStorages.addAll( entry2 );
                }
            }
            assertTrue( "Number of Storages unequal: expected=" + allStorages.size( ) + ", was=" + values.size( ), allStorages.size( ) == values.size( ) );

            declaredField.setAccessible( false );
        } finally {
            storageLock.readLock( ).unlock( );
            storageLockField.setAccessible( false );
        }
    }

    @Test
    public void testJmxOperation_getPartitionContent( ) throws Exception {

        FsPersistenceMBean mbean = jmx.newProxy( FsPersistenceMBean.class );

        String priString = getMoinConnection( ).getPackage( TestcasesPackage.PACKAGE_DESCRIPTOR ).refMetaObject( ).get___Partition( ).getPri( ).toString( );
        String partitionContent = mbean.getPartitionContent( priString );
        assertNotNull( partitionContent );
        assertFalse( partitionContent.isEmpty( ) );

        priString = getMoinConnection( ).getPackage( ModelPackage.PACKAGE_DESCRIPTOR ).refMetaObject( ).get___Partition( ).getPri( ).toString( );
        try {
            partitionContent = mbean.getPartitionContent( priString );
            fail( "Expected RuntimeException to be thrown, since MOFROM partitions are not supported." );
        } catch ( RuntimeException ex ) {
            // expected
        }
    }
}