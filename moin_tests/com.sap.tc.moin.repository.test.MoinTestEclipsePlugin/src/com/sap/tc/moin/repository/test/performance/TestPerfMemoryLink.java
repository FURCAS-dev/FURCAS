package com.sap.tc.moin.repository.test.performance;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case003.A3;
import com.sap.tc.moin.testcases.case003.B3;
import com.sap.tc.moin.testcases.case003.C3;
import com.sap.tc.moin.testcases.case003.Case003Package;
import com.sap.tc.moin.testcases.case003.OrderedReferences;
import com.sap.tc.moin.testcases.case016.A16;
import com.sap.tc.moin.testcases.case016.B16;
import com.sap.tc.moin.testcases.case016.Case016Package;
import com.sap.tc.moin.testcases.case016.HasB;

/**
 * Performance test to measure the creation and deletion of links and the
 * navigation via associations.
 * <p>
 * The metamodel "testcases" with its packages "case003" and "case016" is used.
 */
public class TestPerfMemoryLink extends TestPerfBase {

    /*
     * Number of class instances for the tests test1xNLink and testNxMLink.
     * Influences the duration of the test.
     */
    private final int NumberOfElement = 20000;

    /*
     * Number of class instances for the tests test1xNLinkRemove. Influences the
     * duration of the test. This number is significantly smaller then in the
     * other test cases because the removing takes long.
     */
    private final int NumberOfElementForRemove = 5000;

    /*
     * Number of class instances for the tests testNxMLinkCreateAndNavigate.
     */
    private final int NumberOfElementForNxMLinkCreate = 20000;

    public TestPerfMemoryLink( ) {

        super( );
    }

    /**
     * Measures the creation and the navigation of a 1xN link.
     * 
     * @throws Exception
     */
    @Test
    public void test1xNLink( ) throws Exception {

        PerformanceMeter linkCreationMeterToN = createPerformanceMeter( "1xN link creation", false, "The test adds " + NumberOfElement + " elements to a 0..n reference " );
        PerformanceMeter navigateWithStorageToN = createPerformanceMeter( "Get 1xNassocEndN w storage", false, "Navigatates to an association end of type collection containing " + NumberOfElement + " elements via the reference method(with storage) " + NumberOfElement + " times." );
        PerformanceMeter navigateWOStorageToN = createPerformanceMeter( "Get 1xNassocEnd1 no storage", false, "Navigatates  to an association end with multiplicity 0..1 (without storage)" + NumberOfElement + " times." );

        TestClient testClient = getTestHelper( ).getDefaultTestClient( true );

        Connection conn = testClient.getConnection( );
        RefPackage refPackage = conn.getPackage( TestcasesPackage.PACKAGE_DESCRIPTOR );
        if ( refPackage == null ) {
            throw new RuntimeException( "Testcases metamodel not found!" );
        }

        TestcasesPackage testcasesPackage = (TestcasesPackage) refPackage;
        Case003Package case003Package = testcasesPackage.getCase003( );

        // Partitions per class
        ModelPartition partitionC3 = testClient.getOrCreatePartition( "PartitionClassC3" );
        ModelPartition partitionB3 = testClient.getOrCreatePartition( "PartitionClassB3" );

        // create class instances and assign them to the partition
        C3 c3 = conn.createElementInPartition( C3.class, partitionC3 );
        //partitionC3.assignElement( c3 );
        List<B3> listOfB3 = this.createListOfB3( case003Package, partitionB3, this.NumberOfElement, conn );

        // save class instances
        conn.save( );

        try {
            // average over 10 runs
            // first run is dry run
            for ( int i = 0; i < 11; i++ ) {

                try {
                    this.measureLinkCreation( i, c3, listOfB3, case003Package, partitionB3, linkCreationMeterToN );

                    this.measureNavigation( i, case003Package, listOfB3, c3, navigateWithStorageToN, navigateWOStorageToN );
                } finally {
                    // revert created or removed links
                    conn.revert( );
                }
            }
            endPerformanceMeasurement( linkCreationMeterToN, true );
            endPerformanceMeasurement( navigateWithStorageToN, true );
            endPerformanceMeasurement( navigateWOStorageToN, true );
        } finally {
            linkCreationMeterToN.dispose( );
            navigateWithStorageToN.dispose( );
            navigateWOStorageToN.dispose( );
            // revert all changes
            conn.revert( );
            // delete the partitions
            partitionC3.delete( );
            partitionB3.delete( );
            conn.save( );
        }

    }

    /**
     * Measures the removing of 1xN links.
     * 
     * @throws Exception
     */

    @Test
    public void test1xNLinkRemove( ) throws Exception {

        PerformanceMeter linkRemoveMeterToN = createPerformanceMeter( "1xN link remove", false, "The test removes " + NumberOfElementForRemove + " elements from a 0..n reference." );

        TestClient testClient = getTestHelper( ).getDefaultTestClient( true );

        Connection conn = testClient.getConnection( );
        RefPackage refPackage = conn.getPackage( TestcasesPackage.PACKAGE_DESCRIPTOR );
        if ( refPackage == null ) {
            throw new RuntimeException( "Testcases metamodel not found!" );
        }

        TestcasesPackage testcasesPackage = (TestcasesPackage) refPackage;
        Case003Package case003Package = testcasesPackage.getCase003( );

        // Partitions per class
        ModelPartition partitionC3 = testClient.getOrCreatePartition( "PartitionClassC3" );
        ModelPartition partitionB3 = testClient.getOrCreatePartition( "PartitionClassB3" );

        // create class instances and assign them to the partition
        C3 c3 = conn.createElementInPartition( C3.class, partitionC3 );
        //partitionC3.assignElement( c3 );
        List<B3> listOfB3 = this.createListOfB3( case003Package, partitionB3, this.NumberOfElementForRemove, conn );

        // save class instances
        conn.save( );

        try {
            // average over 10 runs
            // first run is dry run
            for ( int i = 0; i < 11; i++ ) {

                try {
                    // create links
                    c3.getY( ).addAll( listOfB3 );
                    // measure
                    this.measureLinkRemove( i, c3, linkRemoveMeterToN );
                } finally {
                    // revert created or removed links
                    conn.revert( );
                }
            }
            endPerformanceMeasurement( linkRemoveMeterToN, true );
        } finally {
            linkRemoveMeterToN.dispose( );
            // revert all changes
            conn.revert( );
            // delete the partitions
            partitionC3.delete( );
            partitionB3.delete( );
            conn.save( );
        }

    }

    @Test
    public void testNxMLinkCreationAndNavigate( ) throws Exception {

        this.executeScenaroForNxMLink( Scenarios.CREATE_AND_NAVIGATE );
    }

    @Test
    public void testNxMLinkNavigateToCachedLinkWithoutStorage( ) throws Exception {

        this.executeScenaroForNxMLink( Scenarios.NAVIGATE_WITHOUT_STORAGE_CACHED );
    }

    @Test
    public void testNxMLinkNavigatetoCachedLinkWithStorage( ) throws Exception {

        this.executeScenaroForNxMLink( Scenarios.NAVIGATE_WITH_STORAGE_CACHED );
    }

    /**
     * Measures the creation and navigation of a NxM link.
     * 
     * @param scenario
     * @throws Exception
     */
    private void executeScenaroForNxMLink( Scenarios scenario ) throws Exception {

        PerformanceMeter meter = this.getMeter( scenario );
        PerformanceMeter meterNavigateWithStorage = null;
        PerformanceMeter meterNavigateWithoutStorage = null;
        if ( Scenarios.CREATE_AND_NAVIGATE.equals( scenario ) ) {
            meterNavigateWithStorage = createPerformanceMeter( "Get NxMassocEnd w storage", false, "Navigatates to an association end with multiplicity 0..n  (with storage) " + 2 * NumberOfElement + " times." );

            meterNavigateWithoutStorage = createPerformanceMeter( "Get NxMassocEnd no storage", false, "Navigatates to an association end with multiplicity 0..n via the reference method (without storage) " + NumberOfElement + " times." );
        }

        TestClient testClient = getTestHelper( ).getDefaultTestClient( true );

        Connection conn = testClient.getConnection( );
        RefPackage refPackage = conn.getPackage( TestcasesPackage.PACKAGE_DESCRIPTOR );
        if ( refPackage == null ) {
            throw new RuntimeException( "GeneratedMetamodel not found!" );
        }

        TestcasesPackage testcasesPackage = (TestcasesPackage) refPackage;
        Case016Package case016Package = testcasesPackage.getCase016( );

        // Partitions per class and scenario

        ModelPartition partitionA16 = testClient.getOrCreatePartition( "PartitionClassA16" + scenario.ordinal( ) );
        ModelPartition partitionB16 = testClient.getOrCreatePartition( "PartitionClassB16" + scenario.ordinal( ) );

        // create class instances and assign them to the partition
        List<A16> listOfA16 = this.createListOfA16( case016Package, partitionA16, scenario, conn );
        List<B16> listOfB16 = this.createListOfB16( case016Package, partitionB16, scenario, conn );

        if ( Scenarios.CREATE_AND_NAVIGATE.equals( scenario ) ) {
            // save class instances for link creation scenario
            conn.save( );
        } else {
            // create links for the other cases
            this.createNtoMLinks( 0, listOfA16, listOfB16, null );
        }
        try {
            // average over 10 runs
            // first run is dry run
            for ( int i = 0; i < 11; i++ ) {

                try {
                    this.measureNtoMLink( i, listOfA16, listOfB16, case016Package, meter, meterNavigateWithoutStorage, meterNavigateWithStorage, scenario );
                } finally {
                    if ( Scenarios.CREATE_AND_NAVIGATE.equals( scenario ) ) {
                        // revert created links
                        conn.revert( );
                    }
                }
            }
            endPerformanceMeasurement( meter, true );
            if ( meterNavigateWithStorage != null ) {
                endPerformanceMeasurement( meterNavigateWithStorage, true );
            }
            if ( meterNavigateWithoutStorage != null ) {
                endPerformanceMeasurement( meterNavigateWithoutStorage, true );
            }
        } finally {
            meter.dispose( );
            // revert all changes
            conn.revert( );
            // delete the partitions, only relevant for create scenario
            // because only then the partition was saved
            if ( Scenarios.CREATE_AND_NAVIGATE.equals( scenario ) ) {
                partitionB16.delete( );
                partitionA16.delete( );
                conn.save( );
            }
        }

    }

    private PerformanceMeter getMeter( Scenarios scenario ) {

        PerformanceMeter meter;
        switch ( scenario ) {
            case CREATE_AND_NAVIGATE:
                meter = createPerformanceMeter( "NxM link creation", false, "The test adds  2 elements to a nToM link  via a reference method " + NumberOfElementForNxMLinkCreate + " times." );
                break;
            case NAVIGATE_WITH_STORAGE_CACHED:
                meter = createPerformanceMeter( "Get NxMcachedEnd w storage", false, "Navigatates to an association end with multiplicity 0..n  (with storage) " + 20 * 2 * NumberOfElement + " times. The links are cached!" );
                break;
            case NAVIGATE_WITHOUT_STORAGE_CACHED:
                meter = createPerformanceMeter( "Get NxMcachedEnd no storage", false, "Navigatates to an association end with multiplicity 0..n via the reference method (without storage) " + 40 * NumberOfElement + " times. The links are cached!" );
                break;
            default:
                throw new IllegalArgumentException( "scenario " + scenario + " is not valid" );
        }
        return meter;
    }

    private void measureLinkCreation( int i, C3 c3, List<B3> listOfB3, Case003Package case003Package, ModelPartition partitionB3, PerformanceMeter linkCreationMeterToN ) {

        // link creation
        if ( i > 0 ) {
            linkCreationMeterToN.start( );
        }
        c3.getY( ).addAll( listOfB3 );
        if ( i > 0 ) {
            linkCreationMeterToN.stop( );
        }
    }

    private void measureNavigation( int i, Case003Package case003Package, List<B3> listOfB3, C3 c3, PerformanceMeter navigateWithStorageToN, PerformanceMeter navigateWOStorageToN ) {

        OrderedReferences association = case003Package.getOrderedReferences( );
        // navigation with storage
        if ( i > 0 ) {
            navigateWithStorageToN.start( );
        }
        for ( int ii = 0; ii < listOfB3.size( ); ii++ ) {
            Collection<B3> collection = association.getY( c3 );
            collection.size( );
        }
        if ( i > 0 ) {
            navigateWithStorageToN.stop( );
        }

        // navigation without storage
        if ( i > 0 ) {
            navigateWOStorageToN.start( );
        }
        for ( B3 tClass : listOfB3 ) {
            A3 navigatedA3 = association.getA3( tClass );
        }
        if ( i > 0 ) {
            navigateWOStorageToN.stop( );
        }

    }

    private void measureLinkRemove( int i, C3 c3, PerformanceMeter linkRemoveMeterToN ) {

        // link remove
        if ( i > 0 ) {
            linkRemoveMeterToN.start( );
        }
        c3.getY( ).clear( );
        if ( i > 0 ) {
            linkRemoveMeterToN.stop( );
        }
    }

    private void measureNtoMLink( int i, final List<A16> listOfA16, final List<B16> listOfB16, final Case016Package case016Package, final PerformanceMeter meter, PerformanceMeter meterNavigateWithoutStorage, PerformanceMeter meterNavigateWithStorage, final Scenarios scenario )
        throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        switch ( scenario ) {
            case CREATE_AND_NAVIGATE:
                this.createNtoMLinks( i, listOfA16, listOfB16, meter );
                // navigation link is not cached, because they are newly created
                this.navigateToNxMLinkWithoutStorage( i, listOfA16, meterNavigateWithoutStorage, 1 );
                this.navigateToNxMLinkWithStorage( i, listOfA16, listOfB16, case016Package, meterNavigateWithStorage, 1 );
                break;
            case NAVIGATE_WITHOUT_STORAGE_CACHED:
                // navigation to end 0..n without storage, the link is cached
                this.navigateToNxMLinkWithoutStorage( i, listOfA16, meter, 40 );
                break;
            case NAVIGATE_WITH_STORAGE_CACHED:
                // reverse: navigation to end 0..n with storage, the link is cached
                this.navigateToNxMLinkWithStorage( i, listOfA16, listOfB16, case016Package, meter, 20 );
                break;
            default:
                throw new IllegalArgumentException( "invalid scenario " + scenario );
        }

    }

    private void navigateToNxMLinkWithoutStorage( int i, final List<A16> listOfA16, PerformanceMeter meter, int numberOfTimes ) {

        if ( i > 0 ) {
            meter.start( );
        }
        for ( int j = 0; j < numberOfTimes; j++ ) {
            for ( A16 a16 : listOfA16 ) {
                Collection<B16> b16 = a16.getB( );
                b16.size( );
            }
        }
        if ( i > 0 ) {
            meter.stop( );
        }
    }

    private void navigateToNxMLinkWithStorage( int i, final List<A16> listOfA16, final List<B16> listOfB16, final Case016Package case016Package, final PerformanceMeter meter, int numberOfTimes ) {

        // reverse:
        HasB hasB = case016Package.getHasB( );
        // navigation to end 0..n with storage, the link is cached
        if ( i > 0 ) {
            meter.start( );
        }

        for ( int j = 0; j < numberOfTimes; j++ ) {
            for ( B16 b16 : listOfB16 ) {
                Collection<A16> a16List = hasB.getA( b16 );
                a16List.size( );
            }
        }
        if ( i > 0 ) {
            meter.stop( );
        }
    }

    /**
     * Creates NtoMLinks.
     * 
     * @param i
     * @param listOfA16
     * @param listOfB16
     * @param meter can be null, then no measurement is done.
     */
    private void createNtoMLinks( int i, final List<A16> listOfA16, final List<B16> listOfB16, PerformanceMeter meter ) {

        int counter = -1;
        B16[] arrayB16 = listOfB16.toArray( new B16[listOfB16.size( )] );
        if ( i > 0 && meter != null ) {
            meter.start( );
        }

        for ( A16 a16 : listOfA16 ) {
            counter++;
            // add always to 16
            a16.getB( ).add( arrayB16[counter] );
            counter++;
            a16.getB( ).add( arrayB16[counter] );
        }
        if ( i > 0 && meter != null ) {
            meter.stop( );
        }

    }

    /*
     * Creates a list containing NumberOfElement instances of B3 and assigns the
     * instances to the given partition.
     */
    private final List<B3> createListOfB3( Case003Package testcasesPackage, ModelPartition p1, int size, Connection conn ) {

        if ( testcasesPackage == null ) {
            throw new NullPointerException( "\"testcasesPackage\" is null" );
        }
        List<B3> result = new LinkedList<B3>( );
        for ( int i = 0; i < size; i++ ) {
            B3 b3 = conn.createElementInPartition( B3.class, p1 );
            result.add( b3 );
            //p1.assignElement( b3 );
        }
        return result;
    }

    /*
     * Creates a list containing NumberOfElement instances of B16 and assigns
     * the instances to the given partition.
     */
    private final List<B16> createListOfB16( Case016Package case016Package, ModelPartition p1, Scenarios scenario, Connection conn ) {

        if ( case016Package == null ) {
            throw new NullPointerException( "\"case016Package\" is null" );
        }
        List<B16> result = new LinkedList<B16>( );
        int size = NumberOfElement;
        if ( Scenarios.CREATE_AND_NAVIGATE.equals( scenario ) ) {
            size = this.NumberOfElementForNxMLinkCreate;
        }
        size = 2 * size;
        for ( int i = 0; i < size; i++ ) {
            B16 b16 = conn.createElementInPartition( B16.class, p1 );
            result.add( b16 );
        }
        return result;
    }

    /*
     * Creates a list containing NumberOfElement instances of A16 and assigns
     * the instances to the given partition.
     */
    private final List<A16> createListOfA16( Case016Package case016Package, ModelPartition p1, Scenarios scenario, Connection conn ) {

        if ( case016Package == null ) {
            throw new NullPointerException( "\"case016Package\" is null" );
        }
        List<A16> result = new LinkedList<A16>( );
        int size = NumberOfElement;
        if ( Scenarios.CREATE_AND_NAVIGATE.equals( scenario ) ) {
            size = this.NumberOfElementForNxMLinkCreate;
        }
        for ( int i = 0; i < size; i++ ) {
            A16 a16 = conn.createElementInPartition( A16.class, p1 );
            result.add( a16 );
        }
        return result;
    }

    private static enum Scenarios {
        CREATE_AND_NAVIGATE, NAVIGATE_WITH_STORAGE_CACHED, NAVIGATE_WITHOUT_STORAGE_CACHED
    }

}
