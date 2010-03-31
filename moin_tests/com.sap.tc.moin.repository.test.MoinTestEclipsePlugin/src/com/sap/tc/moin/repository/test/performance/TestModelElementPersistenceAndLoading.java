package com.sap.tc.moin.repository.test.performance;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

public class TestModelElementPersistenceAndLoading extends CoreMoinTest {

    private static final int SAVE_COUNT = 3;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        _testClient1 = getTestHelper( ).getDefaultTestClient( true );
        _testClient1.setAsCurrentClient( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Test
    public void testPartitionLoadAndSave00_1( ) throws Exception {

        final long count = 100;
        partitionLoadAndSave( count, count / 10 );
    }

    @Test
    public void testPartitionLoadAndSave00_2( ) throws Exception {

        final long count = 100;
        partitionLoadAndSave( count, count / 10 );
    }

    @Test
    public void testPartitionLoadAndSave00( ) throws Exception {

        final long count = 100;
        partitionLoadAndSave( count, count / 10 );
    }

    @Test
    public void testPartitionLoadAndSave01( ) throws Exception {

        final long count = 200;
        partitionLoadAndSave( count, count / 10 );
    }

    @Test
    public void testPartitionLoadAndSave02( ) throws Exception {

        final long count = 300;
        partitionLoadAndSave( count, count / 10 );
    }

    @Test
    public void testPartitionLoadAndSave05( ) throws Exception {

        final long count = 400;
        partitionLoadAndSave( count, count / 10 );
    }

    @Test
    public void testPartitionLoadAndSave06( ) throws Exception {

        final long count = 500;
        partitionLoadAndSave( count, count / 10 );
    }

    @Test
    public void testPartitionLoadAndSave07( ) throws Exception {

        final long count = 600;
        partitionLoadAndSave( count, count / 10 );
    }

    @Test
    public void testPartitionLoadAndSave08( ) throws Exception {

        final long count = 700;
        partitionLoadAndSave( count, count / 10 );
    }

    @Test
    public void testPartitionLoadAndSave09( ) throws Exception {

        final long count = 800;
        partitionLoadAndSave( count, count / 10 );
    }

    @Test
    public void testPartitionLoadAndSave10( ) throws Exception {

        final long count = 900;
        partitionLoadAndSave( count, count / 10 );
    }

    private void partitionLoadAndSave( long count, long childrenPerNode ) throws Exception {

        long time;
        JmiHandler jmiHandler = JmiHandler.getInstance( );
        Connection connection = getMOINConnection( );
        ModelPackage modelPackage = (ModelPackage) connection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        time = System.currentTimeMillis( );

        ModelPartition mp = (ModelPartition) _testClient1.getOrCreatePartition( "partition_1" );
        time = System.currentTimeMillis( ) - time;
        System.out.println( "Load: #" + mp.getElements( ).size( ) + " " + time + " ms" );

        time = System.currentTimeMillis( );
        for ( Partitionable partitionable : mp.getElements( ) ) {
            partitionable.is___Alive( );
        }
        time = System.currentTimeMillis( ) - time;
        System.out.println( "Check the elements: #" + mp.getElements( ).size( ) + " " + time + " ms" );

        mp.deleteElements( );

        time = System.currentTimeMillis( );
        connection.save( );
        time = System.currentTimeMillis( ) - time;
        System.out.println( "Save: #" + mp.getElements( ).size( ) + " " + time + " ms" );

        AtomicLong countDown = new AtomicLong( count );
        List<MofClass> currentLevel = null;
        List<MofClass> nextLevel = new ArrayList<MofClass>( );
        MofClass mofClass = createMofClass( "MofClass_" + countDown, modelPackage, countDown, jmiHandler );
        if ( mofClass != null ) {
            nextLevel.add( mofClass );
            ( (Partitionable) mofClass ).assign___Partition( mp );
        }
        while ( countDown.get( ) > 0 ) {
            currentLevel = nextLevel;
            nextLevel = new ArrayList<MofClass>( );
            for ( MofClass classCurrentLevel : currentLevel ) {
                for ( long i = 0; i < childrenPerNode && countDown.get( ) > 0; i++ ) {
                    MofClass mofClassChild = createMofClass( "MofClass_" + countDown, modelPackage, countDown, jmiHandler );
                    if ( mofClassChild != null ) {
                        classCurrentLevel.getContents( ).add( mofClassChild );
                        nextLevel.add( mofClassChild );
                        ( (Partitionable) mofClassChild ).assign___Partition( mp );
                    }
                }
            }
        }
        time = System.currentTimeMillis( );
        connection.save( );
        time = System.currentTimeMillis( ) - time;
        System.out.println( "Save1: #" + mp.getElements( ).size( ) + " " + time + " ms" );

        for ( int i = 2; i <= SAVE_COUNT; i++ ) {
            String iAsString = new DecimalFormat( "000" ).format( i );
            mofClass.setAnnotation( "Annotation changed: #" + i );
            time = System.currentTimeMillis( );
            connection.save( );
            time = System.currentTimeMillis( ) - time;
            System.out.println( "Save" + iAsString + ": #" + mp.getElements( ).size( ) + " " + time + " ms" );
        }
        mofClass.setAnnotation( "Annotation changed" );
        PRI pri = mp.getPri( );
        connection.revert( );
        time = System.currentTimeMillis( );

        mp = connection.getPartition( pri );
        time = System.currentTimeMillis( ) - time;
        System.out.println( "Load: #" + mp.getElements( ).size( ) + " " + time + " ms" );

    }

    private MofClass createMofClass( String name, ModelPackage modelPackage, AtomicLong countDown, JmiHandler jmiHandler ) {

        MofClass mofClass = null;
        if ( countDown.getAndDecrement( ) > 0 ) {
            mofClass = jmiHandler.createMofClass( name, modelPackage );
            mofClass.getQualifiedName( );
        }
        return mofClass;
    }

}