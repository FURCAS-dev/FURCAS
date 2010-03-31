package com.sap.tc.moin.repository.test.query;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.friends.RefObjectUtil;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;
import com.sap.tc.moin.testcases.case001.A1;
import com.sap.tc.moin.testcases.case001.B1;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.D4;
import com.sap.tc.moin.testcases.case023.A23;
import com.sap.tc.moin.testcases.case023.Ab;
import com.sap.tc.moin.testcases.case023.B23;
import com.sap.tc.moin.testcases.case023.Bc;
import com.sap.tc.moin.testcases.case023.C23;
import com.sap.tc.moin.testcases.case023.Case023Package;


public class TestQueryRegression extends MoinTestCase {

    TestClient _testClient1;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        this._testClient1 = getTestHelper( ).getDefaultTestClient( 3, 4, true );
        this._testClient1.setAsCurrentClient( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( this._testClient1 != null ) {
            this._testClient1.delete( );
            this._testClient1 = null;
        }
        super.afterTestMethod( );
    }

    @Test
    public void testMixedDominantDirtySubdominant( ) throws Exception {

        ModelPartition mp1 = this._testClient1.getOrCreatePartition( "non_dirty" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartition( "dirty" );

        mp1.deleteElements( );
        mp2.deleteElements( );

        A1 a1 = mp1.createElement( A1.class );
        B1 b = mp2.createElement( B1.class );

        a1.getBs( ).add( b );

        this._testClient1.getConnection( ).save( );

        A1 a2 = mp2.createElement( A1.class );

        getTestHelper( ).getCoreConnection( this._testClient1.getConnection( ) ).getSession( ).getWorkspace( ).getPartitionManager( ).evictPartition( mp2.getPri( ) );

        String query = String.format( "select a, b from testcases::case001::A1 as a, testcases::case001::B1 as b in partitions{\"%s\"} where a.bs = b", mp2.getPri( ).toString( ) );

        MQLResultSet rs = this._testClient1.getConnection( ).getMQLProcessor( ).execute( query );

        assertEquals( 1, rs.getSize( ) );

        mp1.delete( );
        mp2.delete( );

        this._testClient1.getConnection( ).save( );
    }

    @Test
    public void testQueryWithInconsistency( ) throws Exception {

        ModelPartition mp1 = this._testClient1.getOrCreatePartitionStable( "juergen1" );
        ModelPartition mp2 = this._testClient1.getOrCreatePartitionStable( "juergen2" );

        mp1.deleteElements( );
        mp2.deleteElements( );

        Case023Package pkg = this._testClient1.getConnection( ).getPackage( Case023Package.PACKAGE_DESCRIPTOR );
        // first chain        
        C23 c23 = mp1.createElement( C23.class );
        B23 b23 = mp1.createElement( B23.class );
        LRI b23Lri = ( (Partitionable) b23 ).get___Mri( ).getLri( );
        b23.refDelete( );
        A23 a23 = mp1.createElement( A23.class );

        RefObjectUtil util = UtilitiesFactory.getRefObjectUtil( );
        Association association = this._testClient1.getConnection( ).getAssociation( Bc.ASSOCIATION_DESCRIPTOR ).refMetaObject( );
        AssociationEnd assocEnd = this._testClient1.getConnection( ).getJmiHelper( ).getAssociationEnds( association ).get( 1 );
        util.addLinkTarget( c23, assocEnd, b23Lri );

        // second chain        
        c23 = mp1.createElement( C23.class );
        b23 = mp2.createElement( B23.class );
        a23 = mp1.createElement( A23.class );

        pkg.getAb( ).add( b23, a23 );
        pkg.getBc( ).add( c23, b23 );

        this._testClient1.getConnection( ).save( );

        MQLProcessor mql = this._testClient1.getConnection( ).getMQLProcessor( );

        MQLResultSet rs = mql.execute( "select c, b, a " //
                                       + "from testcases::case023::C23 as c, " //
                                       + "testcases::case023::A23 as a, " // 
                                       + "testcases::case023::B23 as b " // 
                                       + "where c.cToB[testcases::case023::bc] = b " //
                                       + "where b.bToA[testcases::case023::ab] = a " ); //

        System.out.println( rs.toString( ) );

        assertTrue( rs.getSize( ) == 1 );

        mp1.delete( );
        mp2.delete( );

        this._testClient1.getConnection( ).save( );
    }

    @Test
    public void testNullReference( ) throws Exception {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "jojoWhassaaap" );
        B23 b23 = mp.createElement( B23.class );
        this._testClient1.getConnection( ).getAssociation( Ab.ASSOCIATION_DESCRIPTOR ).add( b23, mp.createElement( A23.class ) );
        this._testClient1.getConnection( ).save( );
        getTestHelper( ).getCoreConnection( this._testClient1.getConnection( ) ).getSession( ).getWorkspace( ).getPartitionManager( ).evictPartitionForced( getTestHelper( ).getCoreModelPartition( mp ) );

        ModelPartition mp1 = this._testClient1.getOrCreatePartitionStable( "beforejuergen1" );

        mp1.deleteElements( );

        B23 b23_2 = mp1.createElement( B23.class );

        MQLProcessor mql = this._testClient1.getConnection( ).getMQLProcessor( );

        MQLResultSet rs = mql.execute( "select b " //
                                       + "from testcases::case023::B23 as b " //
                                       + "where b.bToA[testcases::case023::ab] = null" ); // 

        System.out.println( rs.toString( ) );

        assertTrue( "unexpected size: " + rs.getSize( ), rs.getSize( ) > 0 );
        assertTrue( "unexpected list: " + b23_2.get___Mri( ) + " --- " + Arrays.asList( rs.getMris( "b" ) ), Arrays.asList( rs.getMris( "b" ) ).contains( b23_2.get___Mri( ) ) );
        assertFalse( "unexpected list: " + b23.get___Mri( ) + " --- " + Arrays.asList( rs.getMris( "b" ) ), Arrays.asList( rs.getMris( "b" ) ).contains( b23.get___Mri( ) ) );

        mp1.delete( );
        mp.delete( );

        this._testClient1.getConnection( ).save( );
    }

    @Test
    public void testNullReferenceWithoutInstancesOfNullReferencedType( ) throws Exception {

        ModelPartition mp1 = this._testClient1.getOrCreatePartitionStable( "beforejuergen1" );

        mp1.deleteElements( );

        B23 b23_2 = mp1.createElement( B23.class );

        MQLProcessor mql = this._testClient1.getConnection( ).getMQLProcessor( );

        // just verify execution without errors:
        MQLResultSet rs = mql.execute( "select b " //
                                       + "from testcases::case023::B23 as b " //
                                       + "where b.bToA[testcases::case023::ab] in (select a from testcases::case023::A23 as a)" ); // 

        rs = mql.execute( "select b " //
                          + "from testcases::case023::B23 as b " //
                          + "where b.bToA[testcases::case023::ab] = null" ); // 

        System.out.println( rs.toString( ) );

        assertTrue( "unexpected size: " + rs.getSize( ), rs.getSize( ) > 0 );
        assertTrue( "unexpected list: " + b23_2.get___Mri( ) + " --- " + Arrays.asList( rs.getMris( "b" ) ), Arrays.asList( rs.getMris( "b" ) ).contains( b23_2.get___Mri( ) ) );

        mp1.delete( );

        this._testClient1.getConnection( ).save( );
    }

    @Test
    public void reducedSubtypeQuery( ) {

        QueryScopeProvider qsp = this._testClient1.getConnection( ).getMQLProcessor( ).getInclusiveContainerScopeProvider( MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME );

        String query1 = "select clf from Model::Classifier as clf";
        MQLResultSet resultSet1 = this._testClient1.getConnection( ).getMQLProcessor( ).execute( query1, qsp );
        int sizeOfAllClassifiers = resultSet1.getSize( );

        String query2 = "select ass from Model::Association as ass";
        MQLResultSet resultSet2 = this._testClient1.getConnection( ).getMQLProcessor( ).execute( query2, qsp );
        int sizeOfAllAssociations = resultSet2.getSize( );

        String query3 = "select dt from Model::DataType as dt";
        MQLResultSet resultSet3 = this._testClient1.getConnection( ).getMQLProcessor( ).execute( query3, qsp );
        int sizeOfAllDatatypes = resultSet3.getSize( );

        String query7 = "select cl from Model::Class as cl";
        MQLResultSet resultSet7 = this._testClient1.getConnection( ).getMQLProcessor( ).execute( query7, qsp );
        int sizeOfAllClasses = resultSet7.getSize( );

        String query4 = "select clf from Model::Classifier withoutsubtypes {Model::Association} as clf";
        MQLResultSet resultSet4 = this._testClient1.getConnection( ).getMQLProcessor( ).execute( query4, qsp );
        int sizeOfAllClassifiersMinusAssociations = resultSet4.getSize( );

        String query5 = "select clf from Model::Classifier withoutsubtypes {Model::Class, Model::Association} as clf";
        MQLResultSet resultSet5 = this._testClient1.getConnection( ).getMQLProcessor( ).execute( query5, qsp );
        int sizeOfAllClassifiersMinusAssociationsAndClasses = resultSet5.getSize( );

        String query6 = "select clf from Model::Classifier withoutsubtypes {Model::Association, \"" + MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME + "\"#Model::PrimitiveType, Model::StructureType, Model::EnumerationType, Model::Class} as clf";
        MQLResultSet resultSet6 = this._testClient1.getConnection( ).getMQLProcessor( ).execute( query6, qsp );
        int sizeOfAllClassifiersMinusAssociationsAndDataTypesAndClasses = resultSet6.getSize( );

        String query8 = "select clf from Model::Classifier withoutsubtypes {Model::Class, Model::DataType, Model::Association} as clf";
        MQLResultSet resultSet8 = this._testClient1.getConnection( ).getMQLProcessor( ).execute( query8, qsp );
        int sizeOfAllClassifiersMinusAssociationsAndClasses2 = resultSet8.getSize( );

        assertEquals( sizeOfAllClassifiersMinusAssociations, sizeOfAllClassifiers - sizeOfAllAssociations );
        assertEquals( sizeOfAllClassifiersMinusAssociationsAndClasses, sizeOfAllClassifiers - ( sizeOfAllAssociations + sizeOfAllClasses ) );
        assertEquals( sizeOfAllClassifiersMinusAssociationsAndDataTypesAndClasses, sizeOfAllClassifiers - ( sizeOfAllAssociations + sizeOfAllDatatypes + sizeOfAllClasses ) );
        assertEquals( sizeOfAllClassifiersMinusAssociationsAndClasses, sizeOfAllClassifiersMinusAssociationsAndClasses2 );
    }

    //FIXME the MQL compression algorithm probably invalidates that this is a MOFROM injection tester
    @Test
    public void mofRomIndexInjection( ) throws Exception {

        String query = "select mofClass1 " + "from Model::Class as mofClass1, " + " Model::Class as mofClass2 in containers{\"" + MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME + "\"}" + " where mofClass1 = mofClass2 " + " where for mofClass1(name = 'Class')"
                       + " where for mofClass2(name = 'Class')";

        MQLProcessor mql = this._testClient1.getConnection( ).getMQLProcessor( );

        long timeStamp = System.currentTimeMillis( );
        MQLPreparedQuery preparedQuery = mql.prepare( query );
        MQLResultSet resultSet = mql.execute( preparedQuery );

        assertTrue( "MOFROM appears not properly injected into the facility", resultSet.getSize( ) == 1 );
    }

    @Test
    public void testGetMofRomTopLevelPackages( ) throws Exception {

        String query1 = "select pkg from Model::Package as pkg in containers {\"sap.com/tc/moin/mof_1.4\"} where pkg.container = null";
        String query2 = "select pkg from Model::Namespace as pkg in containers {\"sap.com/tc/moin/mof_1.4\"} where pkg.container = null";
        String query3 = "select pkg from Model::Namespace withoutsubtypes as pkg in containers {\"sap.com/tc/moin/mof_1.4\"} where pkg.container = null";

        MQLProcessor mql = this._testClient1.getConnection( ).getMQLProcessor( );
        MQLResultSet resultSet1 = mql.execute( query1 );
        MQLResultSet resultSet2 = mql.execute( query2 );
        MQLResultSet resultSet3 = mql.execute( query3 );

        assertFalse( "Result set is empty (" + query1 + ")", resultSet1.isEmpty( ) );
        assertEquals( "Unexpected result set size (" + query1 + "): " + resultSet1.toString( ), resultSet1.getSize( ), 6 );
        assertFalse( "Result set is empty (" + query2 + ")", resultSet2.isEmpty( ) );
        assertEquals( "Unexpected result set size (" + query2 + "): " + resultSet2.toString( ), resultSet2.getSize( ), 6 );
        assertTrue( resultSet3.isEmpty( ) );
    }

    @Test
    public void testConstantComparisonWithAllNumberTypes( ) throws Exception {

        ModelPartition mp = this._testClient1.createPartition( "mql_constants_test" );
        D4 d4 = mp.createElement( D4.class );

        d4.setAttributeDouble( 0.0 );
        d4.setAttributeFloat( 0.0f );
        d4.setAttributeInteger( 0 );
        d4.setAttributeLong( 0L );

        this._testClient1.getConnection( ).save( );

        String queryDouble = "select d4 from testcases::case004::D4 as d4 where d4.attributeDouble = 0.0";
        String queryDouble2 = "select d4 from testcases::case004::D4 as d4 where d4.attributeDouble < " + ( ( (Number) Float.MAX_VALUE ).doubleValue( ) * 2.0d );
        String queryDouble3 = "select d4 from testcases::case004::D4 as d4 where d4.attributeDouble < " + Double.POSITIVE_INFINITY;
        String queryDouble4 = "select d4 from testcases::case004::D4 as d4 where d4.attributeDouble > " + Double.NEGATIVE_INFINITY;
        String queryFloat = "select d4 from testcases::case004::D4 as d4 where d4.attributeFloat = 0.0";
        String queryFloat2 = "select d4 from testcases::case004::D4 as d4 where d4.attributeFloat = " + ( ( (Number) Float.MAX_VALUE ).doubleValue( ) * 2.0d );
        String queryFloat3 = "select d4 from testcases::case004::D4 as d4 where d4.attributeFloat < " + Float.POSITIVE_INFINITY;
        String queryFloat4 = "select d4 from testcases::case004::D4 as d4 where d4.attributeFloat > " + Float.NEGATIVE_INFINITY;
        String queryFloat5 = "select d4 from testcases::case004::D4 as d4 where d4.attributeFloat = " + -( ( (Number) Float.MAX_VALUE ).doubleValue( ) * 2.0d );
        String queryLong = "select d4 from testcases::case004::D4 as d4 where d4.attributeLong = 0";
        String queryLong2 = "select d4 from testcases::case004::D4 as d4 where d4.attributeLong < " + ( Long.MAX_VALUE );
        String queryInt = "select d4 from testcases::case004::D4 as d4 where d4.attributeInteger = 0";
        String queryInt2 = "select d4 from testcases::case004::D4 as d4 where d4.attributeInteger = " + Long.MAX_VALUE;

        MQLProcessor mql = this._testClient1.getConnection( ).getMQLProcessor( );

        // expected exceptions
        try {
            mql.execute( queryFloat2 );
            fail( "Did expect exception" );
        } catch ( MQLFormatException e ) {
            // expected
        }

        try {
            mql.execute( queryFloat3 );
            fail( "Did expect exception" );
        } catch ( MQLFormatException e ) {
            // expected
        }

        try {
            mql.execute( queryFloat4 );
            fail( "Did expect exception" );
        } catch ( MQLFormatException e ) {
            // expected
        }

        try {
            mql.execute( queryFloat5 );
            fail( "Did expect exception" );
        } catch ( MQLFormatException e ) {
            // expected
        }

        try {
            mql.execute( queryDouble3 );
            fail( "Did expect exception" );
        } catch ( MQLFormatException e ) {
            // expected
        }

        try {
            mql.execute( queryDouble4 );
            fail( "Did expect exception" );
        } catch ( MQLFormatException e ) {
            // expected
        }

        try {
            mql.execute( queryInt2 );
            fail( "Did expect exception" );
        } catch ( MQLFormatException e ) {
            // expected
        }

        // queries expected to be correct
        try {
            MQLResultSet rsDouble2 = mql.execute( queryDouble2 );
            MQLResultSet rsDouble = mql.execute( queryDouble );
            MQLResultSet rsFloat = mql.execute( queryFloat );
            MQLResultSet rsLong = mql.execute( queryLong );
            MQLResultSet rsLong2 = mql.execute( queryLong2 );
            MQLResultSet rsInt = mql.execute( queryInt );

            assertFalse( rsDouble.isEmpty( ) );
            assertFalse( rsDouble.isEmpty( ) );
            assertFalse( rsFloat.isEmpty( ) );
            assertFalse( rsLong.isEmpty( ) );
            assertFalse( rsLong2.isEmpty( ) );
            assertFalse( rsInt.isEmpty( ) );

            assertTrue( Arrays.asList( rsDouble.getMris( "d4" ) ).contains( d4.get___Mri( ) ) );
            assertTrue( Arrays.asList( rsDouble2.getMris( "d4" ) ).contains( d4.get___Mri( ) ) );
            assertTrue( Arrays.asList( rsFloat.getMris( "d4" ) ).contains( d4.get___Mri( ) ) );
            assertTrue( Arrays.asList( rsLong.getMris( "d4" ) ).contains( d4.get___Mri( ) ) );
            assertTrue( Arrays.asList( rsLong2.getMris( "d4" ) ).contains( d4.get___Mri( ) ) );
            assertTrue( Arrays.asList( rsInt.getMris( "d4" ) ).contains( d4.get___Mri( ) ) );

        } catch ( MQLFormatException e ) {
            e.printStackTrace( );
            fail( e.getMessage( ) );
        }

        mp.delete( );
        this._testClient1.getConnection( ).save( );
    }

    @Test
    public void testObjectValueComparison( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        ModelPartition mp = this._testClient1.getOrCreatePartitionStable( "ovcTestPartition" ); //$NON-NLS-1$

        mp.deleteElements( );

        String query = "select a, b " // //$NON-NLS-1$
                       + "from testcases::case001::A1 as a, testcases::case001::B1 as b " // //$NON-NLS-1$
                       + "where a.bs = b"; //  //$NON-NLS-1$

        MQLProcessor mql = this._testClient1.getConnection( ).getMQLProcessor( );
        MQLResultSet rsBefore = mql.execute( query );
        int sizeBeforeTest = rsBefore.getSize( );
        rsBefore = null;

        A1 a1_1 = mp.createElement( A1.class );

        B1 b1_1 = mp.createElement( B1.class );
        B1 b1_2 = mp.createElement( B1.class );
        B1 b1_3 = mp.createElement( B1.class );
        B1 b1_4 = mp.createElement( B1.class );

        a1_1.getBs( ).add( b1_1 );
        a1_1.getBs( ).add( b1_2 );
        a1_1.getBs( ).add( b1_3 );
        a1_1.getBs( ).add( b1_4 );

        this._testClient1.getConnection( ).save( );

        MQLResultSet rs = mql.execute( query );

        assertEquals( "Unexpected rs size", a1_1.getBs( ).size( ) + sizeBeforeTest, rs.getSize( ) ); //$NON-NLS-1$
        assertTrue( Arrays.asList( rs.getMris( "a" ) ).contains( a1_1.get___Mri( ) ) ); //$NON-NLS-1$
        assertTrue( Arrays.asList( rs.getMris( "b" ) ).contains( b1_1.get___Mri( ) ) ); //$NON-NLS-1$
        assertTrue( Arrays.asList( rs.getMris( "b" ) ).contains( b1_2.get___Mri( ) ) ); //$NON-NLS-1$
        assertTrue( Arrays.asList( rs.getMris( "b" ) ).contains( b1_3.get___Mri( ) ) ); //$NON-NLS-1$
        assertTrue( Arrays.asList( rs.getMris( "b" ) ).contains( b1_4.get___Mri( ) ) ); //$NON-NLS-1$

        mp.delete( );
        this._testClient1.getConnection( ).save( );
    }

    @Test
    public void testObjectValueComparisonAndAttrComparison( ) throws NullPartitionNotEmptyException, ReferencedTransientElementsException, PartitionsNotSavedException {

        ModelPartition mp = this._testClient1.getOrCreatePartitionStable( "ovcTestPartition2" ); //$NON-NLS-1$

        mp.deleteElements( );

        String query = "select a " // //$NON-NLS-1$
                       + "from testcases::case004::A4 as a, testcases::case004::B4 as b " // //$NON-NLS-1$
                       + "where a.manyBs = b " // //$NON-NLS-1$
                       + "where for b(onePrimitive like '*_*')"; //  //$NON-NLS-1$

        MQLProcessor mql = this._testClient1.getConnection( ).getMQLProcessor( );
        MQLResultSet rsBefore = mql.execute( query );
        int sizeBeforeTest = rsBefore.getSize( );
        rsBefore = null;

        A4 a_1 = mp.createElement( A4.class );

        B4 b_1 = mp.createElement( B4.class );
        B4 b_2 = mp.createElement( B4.class );
        B4 b_3 = mp.createElement( B4.class );
        B4 b_4 = mp.createElement( B4.class );

        b_1.setOnePrimitive( "b_1" ); //$NON-NLS-1$
        b_2.setOnePrimitive( "b_2" ); //$NON-NLS-1$
        b_3.setOnePrimitive( "b_3" ); //$NON-NLS-1$
        b_4.setOnePrimitive( "b_4" ); //$NON-NLS-1$

        a_1.getManyBs( ).add( b_1 );
        a_1.getManyBs( ).add( b_2 );
        a_1.getManyBs( ).add( b_3 );
        a_1.getManyBs( ).add( b_4 );

        this._testClient1.getConnection( ).save( );

        MQLResultSet rs = mql.execute( query );

        assertEquals( "Unexpected rs size", a_1.getManyBs( ).size( ) + sizeBeforeTest, rs.getSize( ) ); //$NON-NLS-1$
        assertTrue( Arrays.asList( rs.getMris( "a" ) ).contains( a_1.get___Mri( ) ) ); //$NON-NLS-1$

        mp.delete( );
        this._testClient1.getConnection( ).save( );
    }
}
