package com.sap.tc.moin.facility.primary.test.index;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.ipi.IpiIndexManagement.IndexingAction;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexLinkRecord;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.jmx.IndexMBean;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionStreamProvider;
import com.sap.tc.moin.test.fw.JmxRemoteConnection;
import com.sap.tc.moin.testcases.case002.B2;
import com.sap.tc.moin.testcases.case002.C2;


public class TestIndexJmxAdapter extends IndexTestCase {

    private JmxRemoteConnection jmx = null;

    private static final long maxMillis = 2000L;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        if ( this.jmx == null ) {
            this.jmx = getTestHelper( ).createJmxRemoteConnection( this.index.getObjectName( ) );
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
    public void testJmxAttribute_NumberOfIndexedModelElements( ) throws Exception {

        Integer elemNo = (Integer) jmx.getAttribute( "NumberOfIndexedModelElements" );
        int indexElemNo = this.index.getPriToElements( ).totalSize( );
        assertTrue( elemNo.intValue( ) == indexElemNo );
    }

    @Test
    public void testJmxAttribute_NumberOfIndexedLinkRecords( ) throws Exception {

        Integer lnkNo = (Integer) jmx.getAttribute( "NumberOfIndexedLinkRecords" );
        int indexLnkNo = this.index.getPriToLinkRecords( ).totalSize( );
        assertTrue( lnkNo.intValue( ) == indexLnkNo );
    }

    @Test
    public void testJmxAttribute_IndexedPartitions( ) throws Exception {

        String[] partitions = (String[]) jmx.getAttribute( "IndexedPartitions" );
        Object[] keys = this.index.getPriToIndexPri( ).keys( );
        String[] indexPartitions = new String[keys.length];
        System.arraycopy( keys, 0, indexPartitions, 0, keys.length );
        Arrays.sort( indexPartitions );
        assertTrue( "Number of partitions not equal: jmx=" + partitions.length + ", index=" + indexPartitions.length, partitions.length == indexPartitions.length );
        for ( int i = 0; i < partitions.length; i++ ) {
            assertTrue( "Partition names not equal", indexPartitions[i].equals( partitions[i] ) );
        }
    }

    @Test
    public void testJmxOperation_getIndexedPartitionDetails( ) throws Exception {

        String methodName = "getIndexedPartitionDetails";
        String[] signature = new String[] { String.class.getName( ) };
        String key1 = "1: Indexed Elements";
        String key2 = "2: Indexed Links";

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "jmx_partitiondetails1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "jmx_partitiondetails2" );
        mp1.deleteElements( );
        mp2.deleteElements( );
        B2 b2 = this.createB2( );
        C2 c2 = this.createC2( );
        mp1.assignElement( b2 );
        mp2.assignElement( c2 );
        c2.setB( b2 );
        saveConnectionOne( );

        CompositeData result = (CompositeData) jmx.invoke( methodName, new String[] { mp2.getPri( ).toString( ) }, signature );
        Integer numElems = (Integer) result.get( key1 );
        Integer numLinks = (Integer) result.get( key2 );

        assertTrue( "Number of elements is not correct: jmx=" + numElems + ", exp=1", numElems == 1 );
        assertTrue( "Number of links is not correct: jmx=" + numLinks + ", exp=1", numLinks == 1 );

        mp1.delete( );
        mp2.delete( );
        saveConnectionOne( );
    }

    @Test
    public void testJmxOperation_getIndexedModelElements( ) throws Exception {

        String methodName = "getIndexedModelElements";
        String[] signature = new String[] { String.class.getName( ) };

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "jmx_getIndexedModelElements" );
        mp1.deleteElements( );
        B2 b2 = this.createB2( );
        C2 c2 = this.createC2( );
        mp1.assignElement( b2 );
        mp1.assignElement( c2 );
        saveConnectionOne( );
        String mriC2 = ( (Partitionable) c2 ).get___Mri( ).toString( );
        String mriB2 = ( (Partitionable) b2 ).get___Mri( ).toString( );

        String[] result = (String[]) jmx.invoke( methodName, new String[] { mp1.getPri( ).toString( ) }, signature );

        assertTrue( "Number of elements in partition " + mp1.getPri( ) + " not correct: jmx=" + result.length + ", exp=2", result.length == 2 );
        assertTrue( "C2 element not in result set", result[0].equals( mriC2 ) || result[1].equals( mriC2 ) );
        assertTrue( "B2 element not in result set", result[0].equals( mriB2 ) || result[1].equals( mriB2 ) );

        mp1.delete( );
        saveConnectionOne( );
    }

    @Test
    public void testJmxOperation_getIndexedLinks( ) throws Exception {

        String methodName = "getIndexedLinks";
        String[] signature = new String[] { String.class.getName( ) };

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "jmx_getIndexedLinks1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "jmx_getIndexedLinks2" );
        mp1.deleteElements( );
        mp2.deleteElements( );
        B2 b2_1 = this.createB2( );
        B2 b2_2 = this.createB2( );
        C2 c2_1 = this.createC2( );
        C2 c2_2 = this.createC2( );
        mp1.assignElement( b2_1 );
        mp1.assignElement( b2_2 );
        mp2.assignElement( c2_1 );
        mp2.assignElement( c2_2 );
        c2_1.setB( b2_1 );
        c2_2.setB( b2_2 );
        saveConnectionOne( );

        String[] result = (String[]) jmx.invoke( methodName, new String[] { mp2.getPri( ).toString( ) }, signature );
        Object[] lrs = this.index.getPriToLinkRecords( ).getUnderlyingForRead( this.index.getPriToIndexPri( ).get( mp2.getPri( ).toString( ) ) );
        assertTrue( lrs.length == 2 );
        String[] lrStrings = new String[2];
        lrStrings[0] = ( (IndexLinkRecord) lrs[0] ).toString( );
        lrStrings[1] = ( (IndexLinkRecord) lrs[1] ).toString( );

        assertTrue( "Number of links in partition " + mp2.getPri( ) + " not correct: jmx=" + result.length + ", exp=2", result.length == 2 );
        assertTrue( "Link not in result set: " + lrStrings[0], result[0].equals( lrStrings[0] ) || result[1].equals( lrStrings[0] ) );
        assertTrue( "Link not in result set: " + lrStrings[1], result[0].equals( lrStrings[1] ) || result[1].equals( lrStrings[1] ) );

        mp1.delete( );
        mp2.delete( );
        saveConnectionOne( );
    }

    @Test
    public void testJmxOperation_doSanityCheck( ) throws Exception {

        IndexMBean index = this.jmx.newProxy( IndexMBean.class );
        assertTrue( index.doSanityCheck( ) );
    }

    @Test
    public void testJmxNotification_indexAdd( ) throws Exception {

        String partitionName = "jmx_indexAdd";

        // be sure, the partition does not already exist
        ModelPartition mp = this._testClient1.getOrCreatePartition( partitionName );
        mp.delete( );
        this.saveConnectionOne( );

        // define string to compare in notification handler
        mp = this._testClient1.getOrCreatePartition( partitionName );
        mp.assignElement( this.createB2( ) );
        final String priString = mp.getPri( ).toString( );

        // define the notification listener
        NotificationListener listener = new NotificationListener( ) {

            public void handleNotification( Notification notification, Object handback ) {

                assertTrue( notification.getMessage( ).equals( priString ) );
            }
        };

        jmx.addNotificationListener( listener, IndexMBean.INDEX_ADD, null );
        this.jmx.enableNotifications( );

        // trigger the action that sends the notification
        try {
            this.saveConnectionOne( ); // indexes the partition in save
            // ensure notification was triggered
            int count = jmx.waitForCorrectNotifications( listener, 1, maxMillis );
            assertTrue( "Listener not called within " + maxMillis + "ms! Was " + count, count == 1 );
        } finally {
            this.jmx.disableNotifications( );
            jmx.removeNotificationListener( listener );
        }

        // cleanup
        mp.delete( );
        this.saveConnectionOne( );
    }

    @Test
    public void testJmxNotification_indexDelete( ) throws Exception {

        String partitionName = "jmx_indexDelete";

        // define string to compare in notification handler
        ModelPartition mp = this._testClient1.getOrCreatePartition( partitionName );
        mp.assignElement( this.createB2( ) );
        saveConnectionOne( );
        mp.delete( );
        final String priString = mp.getPri( ).toString( );

        // define the notification listener
        NotificationListener listener = new NotificationListener( ) {

            public void handleNotification( Notification notification, Object handback ) {

                assertTrue( notification.getMessage( ).equals( priString ) );
            }
        };

        jmx.addNotificationListener( listener, IndexMBean.INDEX_DELETE, null );
        this.jmx.enableNotifications( );

        // trigger the action that sends the notification
        try {
            this.saveConnectionOne( ); // deletes the partition in save
            // ensure notification was triggered
            int count = jmx.waitForCorrectNotifications( listener, 1, maxMillis );
            assertTrue( "Listener not called within " + maxMillis + "ms! Was " + count, count == 1 );
        } finally {
            this.jmx.disableNotifications( );
            jmx.removeNotificationListener( listener );
        }
    }

    @Test
    public void testJmxNotification_indexUpdate( ) throws Exception {

        String partitionName = "jmx_indexDelete";

        // define string to compare in notification handler
        ModelPartition mp = this._testClient1.getOrCreatePartition( partitionName );
        mp.assignElement( this.createB2( ) );

        final PRI pri = mp.getPri( );
        final String priString = pri.toString( );
        final byte[] copy = this.getPartitionByteArray( mp );

        mp.delete( );
        saveConnectionOne( );

        SpiPartitionStreamProvider provider = new SpiPartitionStreamProvider( ) {

            public InputStream getPartitionStream( PRI pri ) {

                return new ByteArrayInputStream( copy );
            }
        };

        // define the notification listener
        NotificationListener listener = new NotificationListener( ) {

            public void handleNotification( Notification notification, Object handback ) {

                assertTrue( notification.getMessage( ).equals( priString ) );
            }
        };

        jmx.addNotificationListener( listener, IndexMBean.INDEX_UPDATE, null );
        this.jmx.enableNotifications( );

        // trigger the action that sends the notification
        try {
            IndexingAction result1 = this.index.indexPartition( pri, provider, -2, true );
            assertTrue( "First indexing was not an add action!", result1 == IndexingAction.ADDED );

            IndexingAction result2 = this.index.indexPartition( pri, provider, -3, true );
            assertTrue( "Second indexing was not an update action!", result2 == IndexingAction.UPDATED );
            // ensure notification was triggered
            int count = jmx.waitForCorrectNotifications( listener, 1, maxMillis );
            assertTrue( "Listener not called within " + maxMillis + "ms! Was " + count, count == 1 );
        } finally {
            this.index.removePartition( pri );
            this.jmx.disableNotifications( );
            jmx.removeNotificationListener( listener );
        }
    }

    @Test
    public void testJmxNotification_indexError( ) throws Exception {

        String partitionName = "jmx_indexError";

        // define string to compare in notification handler
        ModelPartition mp = this._testClient1.getOrCreatePartition( partitionName );
        mp.assignElement( this.createB2( ) );

        final PRI pri = mp.getPri( );
        final String priString = pri.toString( );
        final byte[] copy = this.getPartitionByteArray( mp );
        copy[0] = -1; // force error in read

        mp.delete( );
        saveConnectionOne( );

        SpiPartitionStreamProvider provider = new SpiPartitionStreamProvider( ) {

            public InputStream getPartitionStream( PRI pri ) {

                return new ByteArrayInputStream( copy );
            }
        };

        // define the notification listener
        NotificationListener listener = new NotificationListener( ) {

            public void handleNotification( Notification notification, Object handback ) {

                assertTrue( notification.getMessage( ).equals( priString ) );
            }
        };

        jmx.addNotificationListener( listener, IndexMBean.INDEX_ERROR, null );
        this.jmx.enableNotifications( );

        // trigger the action that sends the notification
        try {
            IndexingAction result1 = this.index.indexPartition( pri, provider, -2, true );
            assertTrue( "Indexing was not an exception action!", result1 == IndexingAction.EXCEPTION );

            // ensure notification was triggered
            int count = jmx.waitForCorrectNotifications( listener, 1, maxMillis );
            assertTrue( "Listener not called within " + maxMillis + "ms! Was " + count, count == 1 );
        } finally {
            this.index.removePartition( pri );
            this.jmx.disableNotifications( );
            jmx.removeNotificationListener( listener );
        }
    }
}
