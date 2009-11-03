package com.sap.tc.moin.repository.test.performance;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.junit.Test;

import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

public class TestModelElementCreation extends CoreMoinTest {

    @Test
    public void testCreateMofClassInstances10( ) {

        createMofClassInstances( 10 );
    }

    @Test
    public void testCreateMofClassInstances100( ) {

        createMofClassInstances( 100 );
    }

    @Test
    public void testCreateMofClassInstances1000( ) {

        createMofClassInstances( 1000 );
    }

    @Test
    public void testCreateMofClassInstances10000( ) {

        createMofClassInstances( 10000 );
    }

    @Test
    public void testCreateMofClassInstances100000( ) {

        createMofClassInstances( 100000 );
    }

    @Test
    public void testCreateMofClassInstances1000000( ) {

        createMofClassInstances( 1000000 );
    }

    // --------

    @Test
    public void testAddMofClassesAsContents10( ) {

        addMofClassesAsContents( 10 );
    }

    @Test
    public void testAddMofClassesAsContents100( ) {

        addMofClassesAsContents( 100 );
    }

    @Test
    public void testAddMofClassesAsContents1000( ) {

        addMofClassesAsContents( 1000 );
    }

    @Test
    public void testAddMofClassesAsContents10000( ) {

        addMofClassesAsContents( 10000 );
    }

    @Test
    public void testAddMofClassesAsContents100000( ) {

        addMofClassesAsContents( 100000 );
    }

    private void createMofClassInstances( int count ) {

        ModelPackage modelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        Collection<OperationStatistics> statistics = new ArrayList<OperationStatistics>( );
        JmiHandler.getInstance( ).createMultipleMofClasses( count, modelPackage, statistics );
        OperationStatistics.print( statistics, System.out );
    }

    private void addMofClassesAsContents( int count ) {

        ModelPackage modelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        Collection<OperationStatistics> statistics = new ArrayList<OperationStatistics>( );
        MofPackage mofPackage = JmiHandler.getInstance( ).createMofPackage( "Anonymous MofPackage", modelPackage );
        Collection<MofClass> mofClasses = JmiHandler.getInstance( ).createMultipleMofClasses( count, modelPackage, null );
        addMofClassesAsContents( mofPackage, mofClasses, statistics );
        OperationStatistics.print( statistics, System.out );
    }

    private void addMofClassesAsContents( MofPackage container, Collection<MofClass> containees, Collection<OperationStatistics> statistics ) {

        long time = System.currentTimeMillis( );
        long memory = Runtime.getRuntime( ).freeMemory( );
        container.getContents( ).addAll( containees );
        time = System.currentTimeMillis( ) - time;
        memory -= Runtime.getRuntime( ).freeMemory( );
        if ( statistics != null ) {
            statistics.add( new OperationStatistics( "add MofClass as content", containees.size( ), time, memory ) );
        }
    }

}
