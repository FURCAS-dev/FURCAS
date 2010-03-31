package com.sap.tc.moin.repository.test.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.sap.junit.MoinParameterizedRunner;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.MQLProcessorWrapper;
import com.sap.tc.moin.repository.core.query.moinql.controller.MQLProcessorImpl;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromFixedSet;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.JoinWhereEntry;
import com.sap.tc.moin.repository.mql.LocalWhereEntry;
import com.sap.tc.moin.repository.mql.MQLColumnType;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.Operation;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectAttrs;
import com.sap.tc.moin.repository.mql.SelectEntry;
import com.sap.tc.moin.repository.mql.WhereAnd;
import com.sap.tc.moin.repository.mql.WhereClause;
import com.sap.tc.moin.repository.mql.WhereComparisonAliases;
import com.sap.tc.moin.repository.mql.WhereComparisonAttrs;
import com.sap.tc.moin.repository.mql.WhereEntry;
import com.sap.tc.moin.repository.mql.WhereInt;
import com.sap.tc.moin.repository.mql.WhereNestedFeature;
import com.sap.tc.moin.repository.mql.WhereNot;
import com.sap.tc.moin.repository.mql.WhereOr;
import com.sap.tc.moin.repository.mql.WhereRelationAssoc;
import com.sap.tc.moin.repository.mql.WhereRelationFeature;
import com.sap.tc.moin.repository.mql.WhereString;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.fw.ModelDataInstantiator;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * @author D045917
 * @author D046918
 * @version Apr 13, 2006
 */
@RunWith( MoinParameterizedRunner.class )
abstract public class BaseSyntheticQueryTests extends MoinTestCase {

    // trace setup
    protected static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, BaseSyntheticQueryTests.class );

    private static final String GENERATED_MM_CONTAINER_NAME = "sap.com/tc/moin/metamodel/generatedmetamodel";

    static protected Connection myConn;

    static protected TestClient myTestClient;

    static protected ModelDataInstantiator mdi;

    static public String partitionNameAppendix = "";

    // the following are test suite parameters with some defaults

    static protected int mmSize = 10;

    static protected int attrSize = 10;

    static protected int instSize = 10;

    static protected int partSize = 10;

    static protected PRI[] partitionScope = null;

    static protected boolean partitionScopeInclusive = true;

    static protected boolean createDirtyData = true;

    static protected boolean createObjValAttrs = true;

    // we need this as state for the actual tests
    protected int dirtyPartitionsRatio;

    // default is true
    protected boolean withOptimization = true;

    static public void beforeQueryTests( boolean withSave ) throws Exception {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Query Test INITIALIZATION START" );
        }

        init( );

        mdi = new ModelDataInstantiator( myTestClient, withSave, mmSize, attrSize, instSize, partSize, createObjValAttrs );
        mdi.createData( );

        // should happen after instantiate and save
        if ( partitionScope == null && partitionScopeInclusive ) {
            partitionScope = mdi.getAllPartitions( myConn ).toArray( new PRI[] {} );
        }

        // trigger MOIN reset
        resetTestEnvironment( );
        getTestHelper( ).reset( );

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Query Test INITIALIZATION END" );
        }
    }

    private static void init( ) {

        myTestClient = MoinTestCase.getTestHelper( ).getDefaultTestClient( true );
        myTestClient.setAsCurrentClient( );

        myConn = myTestClient.getConnection( );
    }

    static public void afterQueryTests( boolean deletePartitions ) throws Exception {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Query Test CLEANUP START" );
        }

        // if we have to delete the partitions
        if ( mdi != null && deletePartitions ) {
            mdi.removeData( );
        }

        clear( );

        if ( mdi != null ) {
            mdi.shutdown( );
            mdi = null;
        }

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Query Test CLEANUP END" );
        }
    }

    static protected void clear( ) {

        if ( myConn != null && myConn.isAlive( ) ) {
            myConn.close( );
        }
        if ( myTestClient != null ) {
            myTestClient.clear( );
        }
        myTestClient = null;
        myConn = null;
    }

    static protected void resetTestEnvironment( ) {

        clear( );
        init( );
    }

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            int ratio = ( this.dirtyPartitionsRatio == 0 ) ? 0 : ( 100 / this.dirtyPartitionsRatio );
            logger.trace( MoinSeverity.INFO, "Executing test: " + this.getName( ) + " with dirty partitions ratio on " + ratio + "%" );
        }

        init( );

        for ( int i = 0; i < partitionScope.length; i++ ) {
            partitionScope[i] = myConn.getSession( ).getMoin( ).createPri( partitionScope[i].toString( ) );
        }

        super.beforeTestMethod( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        clear( );
    }

    /*
     * ================= Test Cases ===============
     */

    /*-
     * (select mm.name(STRING), mm.attrInt1(INTEGER) 
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm) as result
     */
    protected boolean basic_get_attributes_ast( ) throws Exception {

        int testClassNr = 1;
        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass" + testClassNr }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name", "attrInt" + testClassNr } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries );
        MQLResultSet resultSet = this.executeQuery( query );

        return this.basic_get_attributes_check( resultSet );
    }

    protected boolean basic_get_attributes( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1" + " as mm";
        MQLResultSet resultSet = this.executeQuery( query );

        return this.basic_get_attributes_check( resultSet );
    }

    protected boolean basic_get_attributes_with_removal( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1" + " as mm";
        MQLResultSet resultSet = this.executeQuery( query );

        boolean successful = this.basic_get_attributes_check( resultSet );

        // remove element
        if ( successful ) {
            int origSize = resultSet.getSize( );
            int newSize = resultSet.removeRow( origSize - 1 );
            successful = ( newSize == resultSet.getSize( ) ) && ( newSize == origSize - 1 );
        }

        return successful;
    }

    protected boolean basic_get_attributes_with_comparison( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm2 where mm = mm2";
        MQLResultSet resultSet = this.executeQuery( query );

        return this.basic_get_attributes_check( resultSet );
    }

    protected boolean basic_get_attributes_with_reflect_element( ) throws Exception {

        String partitions = "";
        if ( partitionScope != null && partitionScope.length > 0 ) {
            partitions = "\"" + partitionScope[0] + "\"";
            for ( int i = 1; i < partitionScope.length; i++ ) {
                partitions += ", \"" + partitionScope[i] + "\"";
            }
        }

        String query = "select mm.name, mm.attrInt1 from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm, Reflect::Element as refEl in partitions{" + partitions + "} where mm = refEl";
        MQLResultSet resultSet = this.executeQuery( query );

        return this.basic_get_attributes_check( resultSet );
    }

    private boolean basic_get_attributes_check( MQLResultSet resultSet ) throws Exception {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 0; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, false ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, true ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
        }

        if ( resultSet.isEmpty( ) ) {
            return false;
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    protected boolean basic_get_attributes_limited( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1" + " as mm";
        MQLResultSet resultSet = this.executeQuery( query, 1 );

        return this.basic_get_attributes_limited_check( resultSet );
    }

    private boolean basic_get_attributes_limited_check( MQLResultSet resultSet ) throws Exception {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( 1 );
        for ( int i = 0; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, false ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, true ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
        }

        if ( resultSet.getSize( ) != 1 ) {
            return false;
        }

        return this.verifyResultSetLimited( resultSet, intendedResultSet );
    }


    /*-
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm) as result
     */
    protected boolean basic_get_mris_ast( ) throws Exception {

        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

        SelectAlias selectMe = new SelectAlias( "mm" );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMe };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.basic_get_mris_check( resultSet );
    }

    protected boolean basic_get_mris( ) throws Exception {

        String query = "select mm from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1" + " as mm";
        MQLResultSet resultSet = this.executeQuery( query );
        return this.basic_get_mris_check( resultSet );
    }

    private boolean basic_get_mris_check( MQLResultSet resultSet ) {

        int intendedSize = instSize * 2;

        // we can only verify that the size of the result is correct (since MRIs
        // permanently change)
        return resultSet.getSize( ) == intendedSize;
    }

    /*-
     * (select mm.name(STRING), mm.attrInt1(INTEGER)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm
     *  where for mm((not(name like 'TestClass*Obj*')) and
     *               (name like 'TestS?b*'))) as result
     */
    protected boolean like_and_not_like_ast( ) throws Exception {

        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name", "attrInt1" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

        WhereString whereName = new WhereString( "name", Operation.LIKE, "Test\\Class*Obj*\\" );
        WhereNot whereNot = new WhereNot( whereName );
        WhereString whereName2 = new WhereString( "name", Operation.LIKE, "TestS?b*" );
        WhereClause[] whereClauses = { whereNot, whereName2 };
        WhereAnd whereAnd = new WhereAnd( whereClauses );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "mm", whereAnd );
        WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.like_and_not_like_check( resultSet );
    }

    protected boolean like_and_not_like( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm " + "where for mm((name not like 'TestClass*Obj*') and (name like 'TestS?b*'))";
        MQLResultSet resultSet = this.executeQuery( query );

        return this.like_and_not_like_check( resultSet );
    }

    protected boolean like_and_not_like_2( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm " + "where mm.name not like 'TestClass*Obj*'  where mm.name like 'TestS?b*'";
        MQLResultSet resultSet = this.executeQuery( query );

        return this.like_and_not_like_check( resultSet );
    }

    private boolean like_and_not_like_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 0; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, true ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    protected boolean where_not_like( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm " + "where for mm(not(name like 'TestClass*Obj*'))";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.where_not_check( resultSet );
    }

    protected boolean where_not_like_2( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm " + "where mm.name not like 'TestClass*Obj*'";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.where_not_check( resultSet );
    }

    protected boolean where_not_like_and_not_null_check( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm " + " where mm.assoc0x1EndA[generatedmetamodel::Assoc0x1] <> null " + "where mm.name not like 'TestClass*Obj*'";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.where_not_check( resultSet );
    }

    private boolean where_not_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 0; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, false ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, true ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl0.name(STRING), cl1.name(STRING), cl2.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0} as cl0,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as cl1,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass2} as cl2
     *  where cl0.assoc0x1EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
     *  where cl1.assoc1x2EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] = cl2
     *  where for cl2(name(STRING) ='TestClass2Inst0')) as result
     */
    protected boolean double_assoc_ast( ) throws Exception {

        FromType fromRelationShip1 = new FromType( "cl0", new String[] { "generatedmetamodel", "TestClass0" }, null, true );
        FromType fromRelationShip2 = new FromType( "cl1", new String[] { "generatedmetamodel", "TestClass1" }, null, true );
        FromType fromRelationShip3 = new FromType( "cl2", new String[] { "generatedmetamodel", "TestClass2" }, null, true );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1, fromRelationShip2, fromRelationShip3 };

        SelectAttrs selectName1 = new SelectAttrs( "cl0", new String[] { "name" } );
        SelectAttrs selectName2 = new SelectAttrs( "cl1", new String[] { "name" } );
        SelectAttrs selectName3 = new SelectAttrs( "cl2", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectName1, selectName2, selectName3 };

        WhereString whereName = new WhereString( "name", Operation.EQUAL, "TestClass2Inst0" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl2", whereName );

        WhereRelationAssoc whereAssoc1 = new WhereRelationAssoc( "cl0", "assoc0x1EndB", null, new String[] { "generatedmetamodel", "Assoc0x1" }, "cl1" );
        WhereRelationAssoc whereAssoc2 = new WhereRelationAssoc( "cl1", "assoc1x2EndB", null, new String[] { "generatedmetamodel", "Assoc1x2" }, "cl2" );
        WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry, whereAssoc1, whereAssoc2 };

        MQLQuery query2a = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query2a );

        return this.double_assoc_check( resultSet );
    }

    protected boolean double_assoc( ) throws Exception {

        String query = "select cl0.name, cl1.name, cl2.name " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2 " + "where cl0.assoc0x1EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + "where cl1.assoc1x2EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2 ] = cl2 "
                       + "where for cl2(name = 'TestClass2Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.double_assoc_check( resultSet );
    }

    protected boolean double_assoc_variant( ) throws Exception {

        String query = "select cl0.name, cl1.name, cl2.name " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 as cl2_2 " + "where cl0.assoc0x1EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + "where cl1.assoc1x2EndB[\""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2 ] = cl2 " + "where cl2 = cl2_2 " + "where for cl2_2(name = 'TestClass2Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.double_assoc_check( resultSet );
    }

    protected boolean double_assoc_2( ) throws Exception {

        String query = "select cl0.name, cl1.name, cl2.name " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2 " + "where cl0.assoc0x1EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + "where cl1.assoc1x2EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2 ] = cl2 "
                       + "where cl2.name = 'TestClass2Inst0'";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.double_assoc_check( resultSet );
    }

    protected boolean double_assoc_3( ) throws Exception {

        String query = "select cl0.name, cl1.name, cl2.name " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2 " + "where cl0.assoc0x1EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + "where cl2.assoc1x2EndA[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2 ] = cl1 "
                       + "where cl2.name = 'TestClass2Inst0'";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.double_assoc_check( resultSet );
    }

    protected boolean double_assoc_with_comparison( ) throws Exception {

        String query = "select cl0.name, cl1.name, cl2.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass1 as cl1extra, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 as cl2 " + "where cl0.assoc0x1EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + "where cl1.assoc1x2EndB[\""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2 ] = cl2 " + "where cl1 = cl1extra " + "where cl1extra.assoc0x1EndA = cl0 " + "where cl1extra.assoc1x2EndB = cl2 " + "where for cl2(name = 'TestClass2Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.double_assoc_check( resultSet );
    }

    protected boolean double_paired_assocs( ) throws Exception {

        String query = "select cl0.name, cl1.name, cl2.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + "\"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2 " + "where cl0.assoc0x1EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + "where cl1.assoc1x2EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2 ] = cl2 "
                       + "where cl1.assoc0x1EndA[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl0 " + "where cl1.assoc1x2EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2 ] = cl2 " + "where for cl2(name = 'TestClass2Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.double_assoc_check( resultSet );
    }

    private boolean double_assoc_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, 0, false ), ModelDataInstantiator.calculateClassName( 1, 0, false ), ModelDataInstantiator.calculateClassName( 2, 0, false ) } );

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl0.attrString9(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0} as cl0
     *  where for cl0(attrString9(STRING) = null)) as result
     */
    protected boolean string_null_comparison_ast( ) throws Exception {

        FromType fromRelationShip1 = new FromType( "cl0", new String[] { "generatedmetamodel", "TestClass0" }, null, true );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1 };

        SelectAttrs selectName1 = new SelectAttrs( "cl0", new String[] { "attrString9" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

        WhereString whereName = new WhereString( "attrString9", Operation.EQUAL, null );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl0", whereName );
        WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

        MQLQuery query2a = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query2a );

        return this.string_null_comparison_check( resultSet );
    }

    protected boolean string_null_comparison( ) throws Exception {

        String query = "select cl0.attrString9 " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0 " + "where for cl0(attrString9 = null)";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.string_null_comparison_check( resultSet );
    }

    protected boolean string_null_comparison_2( ) throws Exception {

        String query = "select cl0.attrString9 " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0 " + "where cl0.attrString9 = null";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.string_null_comparison_check( resultSet );
    }

    private boolean string_null_comparison_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        if ( attrSize < 10 ) {
            for ( int i = 0; i < instSize; i++ ) {
                intendedResultSet.add( new Object[] { null } );

                if ( createObjValAttrs ) {
                    for ( int j = 0; j < mmSize; j++ ) {
                        intendedResultSet.add( new Object[] { null } );
                    }
                }
            }
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl0.attrString9(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0} as cl0
     *  where for cl0(attrString9(STRING) = null)) as result
     */
    protected boolean string_not_null_comparison_ast( ) throws Exception {

        FromType fromRelationShip1 = new FromType( "cl0", new String[] { "generatedmetamodel", "TestClass0" }, null, true );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1 };

        SelectAttrs selectName1 = new SelectAttrs( "cl0", new String[] { "attrString9" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

        WhereString whereName = new WhereString( "attrString9", Operation.NOTEQUAL, null );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl0", whereName );
        WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

        MQLQuery query2a = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query2a );

        return this.string_not_null_comparison_check( resultSet );
    }

    protected boolean string_not_null_comparison( ) throws Exception {

        String query = "select cl0.attrString9 " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0 " + "where for cl0(attrString9 <> null)";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.string_not_null_comparison_check( resultSet );
    }

    protected boolean string_not_null_comparison_2( ) throws Exception {

        String query = "select cl0.attrString9 " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0 " + "where cl0.attrString9 <> null";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.string_not_null_comparison_check( resultSet );
    }

    private boolean string_not_null_comparison_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select[PF] cl0.attrString5(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0,
              sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass0} as cl0
        where for cl0(attrString5(STRING) ='')) as result
     */
    protected boolean empty_string_comparison_ast( ) throws Exception {

        FromType fromRelationShip1 = new FromType( "cl0", new String[] { "generatedmetamodel", "TestClass0" }, null, true );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1 };

        SelectAttrs selectName1 = new SelectAttrs( "cl0", new String[] { "attrString5" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

        WhereString whereName = new WhereString( "attrString5", Operation.EQUAL, "" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl0", whereName );
        WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

        MQLQuery query2a = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query2a );

        return this.empty_string_comparison_check( resultSet );
    }

    protected boolean empty_string_comparison( ) throws Exception {

        String query = "select cl0.attrString5 " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0 " + "where for cl0(attrString5 = '')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.empty_string_comparison_check( resultSet );
    }

    protected boolean empty_string_comparison_2( ) throws Exception {

        String query = "select cl0.attrString5 " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0 " + "where cl0.attrString5 = ''";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.empty_string_comparison_check( resultSet );
    }

    private boolean empty_string_comparison_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        if ( attrSize > 4 && !( createDirtyData && ( myTestClient.getOrCreatePartitionStable( ModelDataInstantiator.getInstPartName( 0 ) ).isDirty( ) ) ) ) {
            for ( int i = 0; i < instSize; i++ ) {
                intendedResultSet.add( new Object[] { "" } );
            }
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl1.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as cl1
     *  where cl1.assoc1x2EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] in 
     *    (select cl2
     *     from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass2} as cl2
     *     where for cl2(name(STRING) ='TestClass2Inst0')) as nested) as result
     */
    protected boolean nested_query_with_reference_ast( ) throws Exception {

        FromType fromRelationShip1 = new FromType( "cl1", new String[] { "generatedmetamodel", "TestClass1" }, null, true );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1 };

        SelectAttrs selectName1 = new SelectAttrs( "cl1", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

        SelectAlias selectCl2 = new SelectAlias( "cl2" );
        SelectEntry[] nestedSelect = new SelectEntry[] { selectCl2 };

        FromType fromRelationShip2 = new FromType( "cl2", new String[] { "generatedmetamodel", "TestClass2" }, null, true );
        FromEntry[] nestedFromEntries = new FromEntry[] { fromRelationShip2 };

        WhereString whereName = new WhereString( "name", Operation.EQUAL, "TestClass2Inst0" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl2", whereName );
        WhereEntry[] whereEntries1 = new WhereEntry[] { localWhereEntry };

        MQLQuery nestedQuery = new MQLQuery( nestedSelect, nestedFromEntries, whereEntries1 );

        WhereNestedFeature whereReference = new WhereNestedFeature( "cl1", "reference1x2", nestedQuery );
        WhereEntry[] whereEntries2 = new WhereEntry[] { whereReference };

        MQLQuery query2 = new MQLQuery( selectEntries, fromEntries, whereEntries2 );

        MQLResultSet resultSet = this.executeQuery( query2 );

        return this.nested_query_with_reference_check( resultSet );
    }

    protected boolean nested_query_with_reference( ) throws Exception {

        String query = "select cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1 " + "where cl1.assoc1x2EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2] in " + "(select cl2 from \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 withoutsubtypes as cl2 " + " where for cl2(name = 'TestClass2Inst0'))";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.nested_query_with_reference_check( resultSet );
    }

    protected boolean nested_query_with_reference_variant( ) throws Exception {

        String query = "select cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1, " + "\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1_1 " + "where cl1 = cl1_1 " + "where cl1.assoc1x2EndB[\""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2] in " + "(select cl2 from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 withoutsubtypes as cl2 " + " where for cl2(name = 'TestClass2Inst0'))";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.nested_query_with_reference_check( resultSet );
    }

    protected boolean nested_query_with_reference_2( ) throws Exception {

        String query = "select cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1 " + "where cl1.assoc1x2EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2] in " + "(select cl2 from \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 withoutsubtypes as cl2 " + " where cl2.name = 'TestClass2Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.nested_query_with_reference_check( resultSet );
    }

    private boolean nested_query_with_reference_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, 0, false ) } );

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    protected boolean nested_query_with_reference_in_other_direction( ) throws Exception {

        String query = "select cl2.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 withoutsubtypes as cl2 " + "where cl2.assoc1x2EndA[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2] in " + "(select cl1 from \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1 where cl1.name = 'TestClass1Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.nested_query_with_reference_in_other_direction_check( resultSet );
    }

    private boolean nested_query_with_reference_in_other_direction_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 2, 0, false ) } );

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    protected boolean nested_query_with_reference_and_not( ) throws Exception {

        String query = "select cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 " + "where cl1.name not like 'TestClass*Obj*'  where cl1.name like 'TestS?b*' where cl1.assoc1x2EndB not in " + "(select cl2 from \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2)";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.nested_query_with_reference_and_not_check( resultSet );
    }

    protected boolean nested_query_with_reference_and_not_2( ) throws Exception {

        String query = "select cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 " + "where cl1.name not like 'TestClass*Obj*' where cl1.name like 'TestS?b*' where cl1.assoc1x2EndB[\"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::Assoc1x2] = null";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.nested_query_with_reference_and_not_check( resultSet );
    }

    private boolean nested_query_with_reference_and_not_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );

        for ( int i = 0; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, true ) } );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl0.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass0} as cl0
     *  where cl0.assoc0x1EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] in 
     *     (select cl1
     *      from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as cl1
     *      where for cl1(name(STRING) ='TestClass1Inst0')) as nested) as result
     */
    protected boolean nested_query_with_assoc_end_ast( ) throws Exception {

        FromType fromRelationShip1 = new FromType( "cl0", new String[] { "generatedmetamodel", "TestClass0" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1 };

        SelectAttrs selectName1 = new SelectAttrs( "cl0", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

        SelectAlias selectCl2 = new SelectAlias( "cl1" );
        SelectEntry[] nestedSelect = new SelectEntry[] { selectCl2 };

        FromType fromRelationShip2 = new FromType( "cl1", new String[] { "generatedmetamodel", "TestClass1" }, null, true );
        FromEntry[] nestedFromEntries = new FromEntry[] { fromRelationShip2 };

        WhereString whereName = new WhereString( "name", Operation.EQUAL, "TestClass1Inst0" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl1", whereName );
        WhereEntry[] whereEntries1 = new WhereEntry[] { localWhereEntry };

        MQLQuery nestedQuery = new MQLQuery( nestedSelect, nestedFromEntries, whereEntries1 );
        WhereNestedFeature whereAssoc = new WhereNestedFeature( "cl0", "assoc0x1EndB", nestedQuery );
        WhereEntry[] whereEntries2 = new WhereEntry[] { whereAssoc };

        MQLQuery query2 = new MQLQuery( selectEntries, fromEntries, whereEntries2 );

        MQLResultSet resultSet = this.executeQuery( query2 );

        return this.nested_query_with_assoc_end_check( resultSet );
    }

    protected boolean nested_query_with_assoc_end( ) throws Exception {

        String query = "select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0 " + "where cl0.assoc0x1EndB in " + "(select cl1 from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 "
                       + " where for cl1(name ='TestClass1Inst0'))";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.nested_query_with_assoc_end_check( resultSet );
    }

    protected boolean nested_query_with_assoc_end_2( ) throws Exception {

        String query = "select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0 " + "where cl0.assoc0x1EndB in " + "(select cl1 from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 " + " where cl1.name = 'TestClass1Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.nested_query_with_assoc_end_check( resultSet );
    }

    private boolean nested_query_with_assoc_end_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, 0, false ) } );

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl0.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0} as cl0,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as cl1,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass2} as cl2,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass3} as cl3,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass4} as cl4,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass5} as cl5,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass6} as cl6,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass7} as cl7,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass8} as cl8,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass9} as cl9
     *  where cl0.assoc0x1EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
     *  where cl1.assoc1x2EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] = cl2
     *  where cl2.assoc2x3EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x3 ] = cl3
     *  where cl3.assoc3x4EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x4 ] = cl4
     *  where cl4.assoc4x5EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc4x5 ] = cl5
     *  where cl5.assoc5x6EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc5x6 ] = cl6
     *  where cl6.assoc6x7EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc6x7 ] = cl7
     *  where cl7.assoc7x8EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc7x8 ] = cl8
     *  where cl8.assoc8x9EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc8x9 ] = cl9
     *  where for cl9(name(STRING) ='TestClass9Inst1')) as result
     */
    protected boolean complex_assoc_linear_ast( ) throws Exception {

        FromEntry[] fromEntries = new FromEntry[mmSize];

        for ( int i = 0; i < mmSize; i++ ) {
            fromEntries[i] = new FromType( "cl" + i, new String[] { "generatedmetamodel", "TestClass" + i }, null, true );
        }

        SelectAttrs selectName1 = new SelectAttrs( "cl0", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

        WhereString whereName = new WhereString( "name", Operation.EQUAL, "TestClass" + ( mmSize - 1 ) + "Inst1" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl" + ( mmSize - 1 ), whereName );

        WhereEntry[] whereEntries = new WhereEntry[mmSize];

        for ( int i = 0; i < ( mmSize - 1 ); i++ ) {
            whereEntries[i] = new WhereRelationFeature( "cl" + i, "reference" + i + "x" + ( i + 1 ), "cl" + ( i + 1 ) );
        }

        whereEntries[mmSize - 1] = localWhereEntry;

        MQLQuery query5 = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query5 );

        return this.complex_assoc_linear_check( resultSet );
    }

    protected boolean complex_assoc_linear( ) throws Exception {

        String query = "select cl0.name " + "from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + "     \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + "     \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2, " + "     \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 as cl3, " + "     \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass4 as cl4, " + "     \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass5 as cl5, " + "     \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass6 as cl6, " + "     \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass7 as cl7, " + "     \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass8 as cl8, " + "     \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass9 as cl9 " + "where cl0.assoc0x1EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + "where cl1.assoc1x2EndB = cl2 "
                       + "where cl2.assoc2x3EndB = cl3 " + "where cl3.assoc3x4EndB = cl4 " + "where cl4.assoc4x5EndB = cl5 " + "where cl5.assoc5x6EndB = cl6 " + "where cl6.assoc6x7EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc6x7 ] = cl7 " + "where cl7.assoc7x8EndB = cl8 "
                       + "where cl8.assoc8x9EndB = cl9 " + "where for cl9(name ='TestClass9Inst1')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.complex_assoc_linear_check( resultSet );
    }

    private boolean complex_assoc_linear_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, 1, false ) } );
        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl0.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0} as cl0,
     {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as cl1,
     {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass2} as cl2,
     {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass3} as cl3,
     {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass4} as cl4,
     {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass5} as cl5,
     {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass6} as cl6,
     {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass7} as cl7,
     {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass8} as cl8,
     {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass9} as cl9
     where cl0.assoc0x1EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
     where cl1.assoc1x2EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] = cl2
     where cl2.assoc2x3EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x3 ] = cl3
     where cl3.assoc3x4EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x4 ] = cl4
     where cl5.assoc5x6EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc5x6 ] = cl6
     where cl6.assoc6x7EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc6x7 ] = cl7
     where cl7.assoc7x8EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc7x8 ] = cl8
     where cl8.assoc8x9EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc8x9 ] = cl9
     where cl0.assoc0x5EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x5 ] = cl5
     where cl1.assoc1x6EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x6 ] = cl6
     where cl2.assoc2x7EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x7 ] = cl7
     where cl3.assoc3x8EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x8 ] = cl8
     where cl4.assoc4x9EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc4x9 ] = cl9
     where for cl9(name like 'TestClass9Inst2*')) as result
     */
    protected boolean complex_assoc_grid_ast( ) throws Exception {

        FromEntry[] fromEntries = new FromEntry[mmSize];

        for ( int i = 0; i < mmSize; i++ ) {
            fromEntries[i] = new FromType( "cl" + i, new String[] { "generatedmetamodel", "TestClass" + i }, null, true );
        }

        SelectAttrs selectName1 = new SelectAttrs( "cl0", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

        WhereString whereName = new WhereString( "name", Operation.LIKE, "TestClass" + ( mmSize - 1 ) + "Inst2*" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl" + ( mmSize - 1 ), whereName );

        WhereEntry[] whereEntries = new WhereEntry[( mmSize / 2 - 1 ) + mmSize];

        for ( int i = 0; i < ( mmSize / 2 - 1 ); i++ ) {
            whereEntries[i] = new WhereRelationFeature( "cl" + i, "reference" + i + "x" + ( i + 1 ), "cl" + ( i + 1 ) );
        }

        for ( int i = mmSize / 2; i < ( mmSize - 1 ); i++ ) {
            whereEntries[i - 1] = new WhereRelationFeature( "cl" + i, "reference" + i + "x" + ( i + 1 ), "cl" + ( i + 1 ) );
        }

        for ( int i = 0; i < ( mmSize / 2 ); i++ ) {
            whereEntries[i + ( mmSize - 1 ) - 1] = new WhereRelationFeature( "cl" + i, "reference" + i + "x" + ( i + ( mmSize / 2 ) ), "cl" + ( i + ( mmSize / 2 ) ) );
        }

        whereEntries[( mmSize / 2 - 1 ) + ( mmSize - 1 )] = localWhereEntry;

        MQLQuery query6 = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query6 );

        return this.complex_grid_assoc_check( resultSet );
    }

    protected boolean complex_assoc_grid( ) throws Exception {

        String query = "select cl0.name " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + "  \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 as cl3, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass4 as cl4, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass5 as cl5, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass6 as cl6, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass7 as cl7, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass8 as cl8, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass9 as cl9 " + " where cl0.assoc0x1EndB[ \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + " where cl1.assoc1x2EndB = cl2 "
                       + " where cl2.assoc2x3EndB = cl3 " + " where cl3.assoc3x4EndB = cl4 " + " where cl5.assoc5x6EndB = cl6 " + " where cl6.assoc6x7EndB = cl7 " + " where cl7.assoc7x8EndB = cl8 " + " where cl8.assoc8x9EndB = cl9 " + " where cl0.assoc0x5EndB = cl5 "
                       + " where cl1.assoc1x6EndB = cl6 " + " where cl2.assoc2x7EndB = cl7 " + " where cl3.assoc3x8EndB = cl8 " + " where cl4.assoc4x9EndB = cl9 " + " where for cl9(name like 'TestClass9Inst2*')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.complex_grid_assoc_check( resultSet );
    }

    protected boolean complex_assoc_grid_with_attr_comparisons( ) throws Exception {

        String query = "select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0,  \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 as cl2, " + " \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 as cl3, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass4 as cl4, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass5 as cl5, " + " \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass6 as cl6, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass7 as cl7, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass8 as cl8, " + " \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass9 as cl9 " + " where cl0.assoc0x1EndB[ \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 where cl0.attrInt0 < cl1.attrInt0 "
                       + " where cl1.assoc1x2EndB = cl2 where cl1.attrDouble0 < cl2.attrDouble0 " + " where cl2.assoc2x3EndB = cl3 where cl2.attrInt0 < cl3.attrInt0 " + " where cl3.assoc3x4EndB = cl4 where cl3.attrDouble0 <= cl4.attrDouble0 "
                       + " where cl5.assoc5x6EndB = cl6 where cl5.attrInt0 <= cl6.attrInt0 " + " where cl6.assoc6x7EndB = cl7 where cl7.attrDouble0 > cl6.attrDouble0 " + " where cl7.assoc7x8EndB = cl8 where cl8.attrInt0 > cl7.attrInt0 "
                       + " where cl8.assoc8x9EndB = cl9 where cl9.attrDouble0 >= cl8.attrDouble0 " + " where cl0.assoc0x5EndB = cl5 where cl5.attrInt0 >= cl0.attrInt0 " + " where cl1.assoc1x6EndB = cl6 where cl1.attrDouble0 <> cl6.attrDouble0 "
                       + " where cl2.assoc2x7EndB = cl7 where cl2.attrInt0 <> cl7.attrInt0 " + " where cl3.assoc3x8EndB = cl8 where cl3.attrDouble0 < cl8.attrDouble0 " + " where cl4.assoc4x9EndB = cl9 where cl4.attrInt0 < cl9.attrInt0 " + " where for cl9(name like 'TestClass9Inst2*')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.complex_grid_assoc_check( resultSet );
    }

    protected boolean complex_assoc_grid_with_structureTypes( ) throws Exception {

        String query = "select cl0.name " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + "  \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, generatedmetamodel::StructTp as st1, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2, generatedmetamodel::StructTp as st2, generatedmetamodel::StructInStructTp as st22, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 as cl3, generatedmetamodel::StructTp as st3, " + " \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass4 as cl4, generatedmetamodel::StructTp as st4, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass5 as cl5, generatedmetamodel::StructTp as st5, generatedmetamodel::StructInStructTp as st52, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass6 as cl6, generatedmetamodel::StructTp as st6, " + " \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass7 as cl7, generatedmetamodel::StructTp as st7, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass8 as cl8, generatedmetamodel::StructTp as st8, generatedmetamodel::StructInStructTp as st82, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass9 as cl9, generatedmetamodel::StructTp as st9 "
                       + " where cl0.assoc0x1EndB[ \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + " where cl1.assoc1x2EndB = cl2 " + " where cl2.assoc2x3EndB = cl3 " + " where cl3.assoc3x4EndB = cl4 " + " where cl5.assoc5x6EndB = cl6 "
                       + " where cl6.assoc6x7EndB = cl7 " + " where cl7.assoc7x8EndB = cl8 " + " where cl8.assoc8x9EndB = cl9 " + " where cl0.assoc0x5EndB = cl5 " + " where cl1.assoc1x6EndB = cl6 " + " where cl2.assoc2x7EndB = cl7 " + " where cl3.assoc3x8EndB = cl8 "
                       + " where cl4.assoc4x9EndB = cl9 " + " where cl9.name like 'TestClass9Inst2*'"
                       + " where cl1.attrStruct = st1 where cl2.attrStruct = st2 where cl3.attrStruct = st3 where cl4.attrStruct = st4 where cl5.attrStruct = st5 where cl6.attrStruct = st6 where cl7.attrStruct = st7 where cl8.attrStruct = st8 where cl9.attrStruct = st9"
                       + " where for st1(Field2 like 'TestClass1Inst?structValue' or Field2 like 'TestSubClass1Inst?structValue') " + " where for st2(Field2 like 'TestClass2Inst?structValue' or Field2 like 'TestSubClass2Inst?structValue') "
                       + " where for st3(Field2 like 'TestClass3Inst?structValue' or Field2 like 'TestSubClass3Inst?structValue') " + " where for st4(Field2 like 'TestClass4Inst?structValue' or Field2 like 'TestSubClass4Inst?structValue') "
                       + " where for st5(Field2 like 'TestClass5Inst?structValue' or Field2 like 'TestSubClass5Inst?structValue') " + " where for st6(Field2 like 'TestClass6Inst?structValue' or Field2 like 'TestSubClass6Inst?structValue') "
                       + " where for st7(Field2 like 'TestClass7Inst?structValue' or Field2 like 'TestSubClass7Inst?structValue') " + " where for st8(Field2 like 'TestClass8Inst?structValue' or Field2 like 'TestSubClass8Inst?structValue') "
                       + " where for st9(Field2 like 'TestClass9Inst?structValue' or Field2 like 'TestSubClass9Inst?structValue') " + " where st2.Field3 = st22 where st5.Field3 = st52 where st8.Field3 = st82";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.complex_grid_assoc_check( resultSet );
    }

    private boolean complex_grid_assoc_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, 2, false ) } );
        if ( instSize > 20 ) {
            for ( int i = 20; i < Math.min( instSize, 30 ); i++ ) {
                intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, i, false ) } );
            }
            if ( instSize > 200 ) {
                for ( int j = 200; j < Math.min( instSize, 300 ); j++ ) {
                    intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, j, false ) + j } );
                }
            }
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    protected boolean complex_grid_assoc_with_string_comparisons( ) throws Exception {

        String query = "select cl0.name " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + "  \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 as cl3, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass4 as cl4, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass5 as cl5, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass6 as cl6, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass7 as cl7, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass8 as cl8, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass9 as cl9 " + " where cl0.assoc0x1EndB[ \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + " where cl1.assoc1x2EndB = cl2 "
                       + " where cl2.assoc2x3EndB = cl3 " + " where cl3.assoc3x4EndB = cl4 " + " where cl5.assoc5x6EndB = cl6 " + " where cl6.assoc6x7EndB = cl7 " + " where cl7.assoc7x8EndB = cl8 " + " where cl8.assoc8x9EndB = cl9 " + " where cl0.assoc0x5EndB = cl5 "
                       + " where cl1.assoc1x6EndB = cl6 " + " where cl2.assoc2x7EndB = cl7 " + " where cl3.assoc3x8EndB = cl8 " + " where cl4.assoc4x9EndB = cl9 " + " where for cl9(name like 'TestClass9Inst2*') "
                       + " where cl8.name like 'TestClass8Inst2*' where cl7.name like 'TestClass7Inst2*' where cl6.name like 'TestClass6Inst2*' where cl5.name like 'TestClass5Inst2*' where cl4.name like 'TestClass4Inst2*' "
                       + " where cl3.name like 'TestClass3Inst2*' where cl2.name like 'TestClass2Inst2*' where cl1.name like 'TestClass1Inst2*'";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.complex_grid_assoc_check( resultSet );
    }

    /*-
     * (select cl0.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0} as cl0,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as cl1,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass2,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass2} as cl2
     *        in E{PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFEAEC2A82CFC9E42A61455809B3F7DFF69,
     *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFE651E90B462404D180F87CACB737499B8,
     *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFEA3115CEAD9794BD70FF3D4DC0A43C632,
     *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFF57F135EF447F413C274EC29C31525E1F,
     *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFE6C31DC76157040B70FA89D899733A881,
     *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFE9D663D97E5844E3225B793D39046DD39,
     *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFFD7DABB0124ED4E6F14CBE21344F86227,
     *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFF54EFA3ADD44B46493941C397670828FD,
     *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFE1526C92E5B314BF7039E9BAE6B33627D,
     *             PF.DefaultDataArea:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/generatedMM_instances2#45F91CFF302632358AA049C134F5BD274CD575CA},
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass3} as cl3,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass4} as cl4,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass5} as cl5,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass6} as cl6,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass7} as cl7,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass8} as cl8,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass9} as cl9
     *  where cl0.assoc0x1EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
     *  where cl1.assoc1x2EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] = cl2
     *  where cl2.assoc2x3EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x3 ] = cl3
     *  where cl3.assoc3x4EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x4 ] = cl4
     *  where cl5.assoc5x6EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc5x6 ] = cl6
     *  where cl6.assoc6x7EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc6x7 ] = cl7
     *  where cl7.assoc7x8EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc7x8 ] = cl8
     *  where cl8.assoc8x9EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc8x9 ] = cl9
     *  where cl0.assoc0x5EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x5 ] = cl5
     *  where cl1.assoc1x6EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x6 ] = cl6
     *  where cl2.assoc2x7EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x7 ] = cl7
     *  where cl3.assoc3x8EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x8 ] = cl8
     *  where cl4.assoc4x9EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc4x9 ] = cl9
     *  where for cl9(name like 'TestClass9Inst2*')) as result
     */
    protected boolean complex_grid_assoc_with_fixed_set_ast( ) throws Exception {

        // we first calculate a pre-query to obtain all MRIs of type TestClass2
        int fixedIndex = 2;
        FromEntry intermediateFromEntry = new FromType( "intermediateAlias", new String[] { "generatedmetamodel", "TestClass" + fixedIndex }, null, true );
        SelectAlias intermediateSelectEntry = new SelectAlias( "intermediateAlias" );

        WhereString whereObjectValued = new WhereString( "name", Operation.LIKE, "TestClass*Obj*" );
        WhereNot whereNotObjectValued = new WhereNot( whereObjectValued );
        LocalWhereEntry whereNotObjectValuedEntry = new LocalWhereEntry( "intermediateAlias", whereNotObjectValued );

        MQLQuery intermediateQuery = new MQLQuery( new SelectEntry[] { intermediateSelectEntry }, new FromEntry[] { intermediateFromEntry }, new WhereEntry[] { whereNotObjectValuedEntry } );
        this.makeDirty( );
        QueryScopeProvider queryScopeProvider = myConn.getMQLProcessor( ).getQueryScopeProvider( partitionScopeInclusive, partitionScope, new CRI[0] );
        MQLResultSet intermediateResultSet = myConn.getMQLProcessor( ).execute( intermediateQuery, queryScopeProvider );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "-----> Intermediate Result Set for fixed set test case: " );
            String intermediateResultStr = intermediateResultSet.toString( );
            logger.trace( MoinSeverity.DEBUG, intermediateResultStr );
        }

        resetTestEnvironment( );

        MRI[] intermediateElements = new MRI[intermediateResultSet.getSize( )];
        for ( int i = 0; i < intermediateElements.length; i++ ) {
            intermediateElements[i] = intermediateResultSet.getMri( i, "intermediateAlias" );
        }

        FromEntry[] fromEntries = new FromEntry[mmSize];

        for ( int i = 0; i < mmSize; i++ ) {
            if ( i != fixedIndex ) {
                fromEntries[i] = new FromType( "cl" + i, new String[] { "generatedmetamodel", "TestClass" + i }, null, true );
            } else {
                fromEntries[i] = new FromFixedSet( "cl" + i, new String[] { "generatedmetamodel", "TestClass" + i }, null, intermediateElements );
            }
        }

        SelectAttrs selectName1 = new SelectAttrs( "cl0", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

        WhereString whereName = new WhereString( "name", Operation.LIKE, "TestClass" + ( mmSize - 1 ) + "Inst2*" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl" + ( mmSize - 1 ), whereName );

        WhereEntry[] whereEntries = new WhereEntry[( mmSize / 2 - 1 ) + mmSize];

        for ( int i = 0; i < ( mmSize / 2 - 1 ); i++ ) {
            whereEntries[i] = new WhereRelationFeature( "cl" + i, "reference" + i + "x" + ( i + 1 ), "cl" + ( i + 1 ) );
        }

        for ( int i = mmSize / 2; i < ( mmSize - 1 ); i++ ) {
            whereEntries[i - 1] = new WhereRelationFeature( "cl" + i, "reference" + i + "x" + ( i + 1 ), "cl" + ( i + 1 ) );
        }

        for ( int i = 0; i < ( mmSize / 2 ); i++ ) {
            whereEntries[i + ( mmSize - 1 ) - 1] = new WhereRelationFeature( "cl" + i, "reference" + i + "x" + ( i + ( mmSize / 2 ) ), "cl" + ( i + ( mmSize / 2 ) ) );
        }

        whereEntries[( mmSize / 2 - 1 ) + ( mmSize - 1 )] = localWhereEntry;

        MQLQuery query7 = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query7 );

        return this.complex_grid_assoc_with_fixed_set_check( resultSet );
    }

    protected boolean complex_grid_assoc_with_fixed_set( ) throws Exception {

        // we first calculate a pre-query to obtain all MRIs of type TestClass2
        int fixedIndex = 2;
        FromEntry intermediateFromEntry = new FromType( "intermediateAlias", new String[] { "generatedmetamodel", "TestClass" + fixedIndex }, null, true );
        SelectAlias intermediateSelectEntry = new SelectAlias( "intermediateAlias" );

        WhereString whereObjectValued = new WhereString( "name", Operation.LIKE, "TestClass*Obj*" );
        WhereNot whereNotObjectValued = new WhereNot( whereObjectValued );
        LocalWhereEntry whereNotObjectValuedEntry = new LocalWhereEntry( "intermediateAlias", whereNotObjectValued );

        MQLQuery intermediateQuery = new MQLQuery( new SelectEntry[] { intermediateSelectEntry }, new FromEntry[] { intermediateFromEntry }, new WhereEntry[] { whereNotObjectValuedEntry } );
        this.makeDirty( );

        QueryScopeProvider queryScopeProvider = myConn.getMQLProcessor( ).getQueryScopeProvider( partitionScopeInclusive, partitionScope, new CRI[0] );
        MQLResultSet intermediateResultSet = myConn.getMQLProcessor( ).execute( intermediateQuery, queryScopeProvider );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "-----> Intermediate Result Set for fixed set test case: " );
            String intermediateResultStr = intermediateResultSet.toString( );
            logger.trace( MoinSeverity.DEBUG, intermediateResultStr );
        }

        resetTestEnvironment( );

        String elements = "";
        for ( int i = 0; i < intermediateResultSet.getSize( ); i++ ) {
            elements = elements + "\"" + intermediateResultSet.getMri( i, "intermediateAlias" ) + "\" ,";
        }
        // remove last comma
        elements = elements.substring( 0, elements.length( ) - 2 );

        String query = "select cl0.name " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + "  \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2 in elements { " + elements + " }, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 as cl3, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass4 as cl4, " + " \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass5 as cl5, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass6 as cl6, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass7 as cl7, " + " \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass8 as cl8, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass9 as cl9 " + " where cl0.assoc0x1EndB[ \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 "
                       + " where cl1.assoc1x2EndB = cl2 " + " where cl2.assoc2x3EndB = cl3 " + " where cl3.assoc3x4EndB = cl4 " + " where cl5.assoc5x6EndB = cl6 " + " where cl6.assoc6x7EndB = cl7 " + " where cl7.assoc7x8EndB = cl8 " + " where cl8.assoc8x9EndB = cl9 "
                       + " where cl0.assoc0x5EndB = cl5 " + " where cl1.assoc1x6EndB = cl6 " + " where cl2.assoc2x7EndB = cl7 " + " where cl3.assoc3x8EndB = cl8 " + " where cl4.assoc4x9EndB = cl9 " + " where for cl9(name like 'TestClass9Inst2*')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.complex_grid_assoc_with_fixed_set_check( resultSet );
    }

    private boolean complex_grid_assoc_with_fixed_set_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, 2, false ) } );
        if ( instSize > 20 ) {
            for ( int i = 20; i < Math.min( instSize, 30 ); i++ ) {
                intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, i, false ) } );
            }
            if ( instSize > 200 ) {
                for ( int j = 200; j < Math.min( instSize, 300 ); j++ ) {
                    intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, j, false ) + j } );
                }
            }
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select mm.name(STRING), mm.attrStringMultiValued2(STRING)(multi)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm
     *  where for mm(name(STRING) ='TestClass1Inst0')) as result
     */
    protected boolean select_multivalued_attributes_ast( ) throws Exception {

        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name", "attrStringMultiValued2" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

        WhereString whereName = new WhereString( "name", Operation.EQUAL, "TestClass1Inst0" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "mm", whereName );
        WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.select_multivalued_attributes_check( resultSet );
    }

    protected boolean select_multivalued_attributes( ) throws Exception {

        String query = "select mm.name, mm.attrStringMultiValued2 " + " from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm " + " where for mm(name ='TestClass1Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.select_multivalued_attributes_check( resultSet );
    }

    private boolean select_multivalued_attributes_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        Object[] multivalues = new Object[10];
        for ( int i = 0; i < 10; i++ ) {
            multivalues[i] = ModelDataInstantiator.calculateMultiValuedStringAttr( 1, 0, 2, i, false );
        }

        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, 0, false ), multivalues } );

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select mm.name(STRING), mm.attrEnum(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm
     *  where for mm(name(STRING) ='TestClass1Inst0')) as result
     */
    protected boolean select_enum_attribute_ast( ) throws Exception {

        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name", "attrEnum" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

        WhereString whereName = new WhereString( "name", Operation.EQUAL, "TestClass1Inst0" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "mm", whereName );
        WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.select_enum_attribute_check( resultSet );
    }

    protected boolean select_enum_attribute( ) throws Exception {

        String query = "select mm.name, mm.attrEnum " + " from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm " + " where for mm(name ='TestClass1Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.select_enum_attribute_check( resultSet );
    }

    private boolean select_enum_attribute_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, 0, false ), "Label1" } );

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select mm.name(STRING), strTp.Field2(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::StructTp} as strTp
     *  where mm.StructTp[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1::attrStruct ] = strTp
     *  where for mm(name(STRING) ='TestClass1Inst0')) as result
     */
    protected boolean assoc_with_struct_ast( ) throws Exception {

        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromType fromStruct = new FromType( "strTp", new String[] { "generatedmetamodel", "StructTp" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip, fromStruct };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name" } );
        SelectAttrs selectField = new SelectAttrs( "strTp", new String[] { "Field2" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName, selectField };

        WhereString whereName = new WhereString( "name", Operation.EQUAL, "TestClass1Inst0" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "mm", whereName );

        WhereRelationFeature whereAssoc = new WhereRelationFeature( "mm", "attrStruct", "strTp" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereAssoc, localWhereEntry };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_struct_check( resultSet );
    }

    protected boolean assoc_with_struct( ) throws Exception {

        String query = "select mm.name, strTp.Field2 " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm, " + "       \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::StructTp as strTp " + "  where mm.attrStruct = strTp "
                       + "  where for mm(name ='TestClass1Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_struct_check( resultSet );
    }

    private boolean assoc_with_struct_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, 0, false ), ModelDataInstantiator.calculateClassName( 1, 0, false ) + "structValue" } );

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select mm.name(STRING), strTp.Field2(STRING), strInStrTp.Field2(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::StructTp} as strTp,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::StructInStructTp} as strInStrTp
     *  where mm.StructTp[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1::attrStruct ] = strTp
     *  where strTp.StructInStructTp[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::StructTp::Field3 ] = strInStrTp
     *  where for mm(name(STRING) ='TestClass1Inst0')) as result
     */
    protected boolean assoc_with_nested_struct_ast( ) throws Exception {

        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromType fromStruct = new FromType( "strTp", new String[] { "generatedmetamodel", "StructTp" }, null, false );
        FromType fromStructInStruct = new FromType( "strInStrTp", new String[] { "generatedmetamodel", "StructInStructTp" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip, fromStruct, fromStructInStruct };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name" } );
        SelectAttrs selectField = new SelectAttrs( "strTp", new String[] { "Field2" } );
        SelectAttrs selectInField = new SelectAttrs( "strInStrTp", new String[] { "Field2" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName, selectField, selectInField };

        WhereString whereName = new WhereString( "name", Operation.EQUAL, "TestClass1Inst0" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "mm", whereName );

        WhereRelationFeature whereAssoc = new WhereRelationFeature( "mm", "attrStruct", "strTp" );
        WhereRelationFeature whereAssoc2 = new WhereRelationFeature( "strTp", "Field3", "strInStrTp" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereAssoc, whereAssoc2, localWhereEntry };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_nested_struct_check( resultSet );
    }

    protected boolean assoc_with_nested_struct( ) throws Exception {

        String query = "select mm.name, strTp.Field2, strInStrTp.Field2 " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm, " + "       \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::StructTp as strTp, " + "       \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::StructInStructTp as strInStrTp " + "  where mm.attrStruct = strTp " + "  where strTp.Field3 = strInStrTp " + "  where for mm(name ='TestClass1Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_nested_struct_check( resultSet );
    }

    private boolean assoc_with_nested_struct_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, 0, false ), ModelDataInstantiator.calculateClassName( 1, 0, false ) + "structValue", ModelDataInstantiator.calculateClassName( 1, 0, false ) + "structValueField3structValue" } );

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select mm.name(STRING), obj.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass2,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass2} as obj
     *  where mm.TestClass2[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1::attrObjectValued2 ] = obj
     *  where for mm(name like 'TestClass1Inst0*')) as result
     */
    protected boolean assoc_with_class_typed_ast( ) throws Exception {

        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromType fromObjType = new FromType( "obj", new String[] { "generatedmetamodel", "TestClass0" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip, fromObjType };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name" } );
        SelectAttrs selectObjName = new SelectAttrs( "obj", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName, selectObjName };

        WhereString whereName = new WhereString( "name", Operation.LIKE, "TestClass1Inst0*" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "mm", whereName );

        WhereRelationFeature whereAssoc = new WhereRelationFeature( "mm", "attrObjectValued0", "obj" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereAssoc, localWhereEntry };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_class_typed_check( resultSet );
    }

    protected boolean assoc_with_class_typed( ) throws Exception {

        String query = "select mm.name, obj.name " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as mm, " + "       \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as obj " + "  where mm.attrObjectValued0 = obj "
                       + "  where for mm(name like 'TestClass1Inst0*')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_class_typed_check( resultSet );
    }

    private boolean assoc_with_class_typed_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        if ( createObjValAttrs ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, 0, false ), ModelDataInstantiator.calculateObjectValuedAttrName( 1, 0, 0, false ) } );
        }
        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl1.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0} as cl0,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as cl1
     *  where cl0.assoc0x1EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
     *  where for cl0(attrString0(STRING) ='TestClass0Inst1strValue0_DIRTY')) as result
     */
    protected boolean assoc_with_dirty_partition_ast( ) throws Exception {

        FromType fromRelationShip1 = new FromType( "cl0", new String[] { "generatedmetamodel", "TestClass0" }, null, true );
        FromType fromRelationShip2 = new FromType( "cl1", new String[] { "generatedmetamodel", "TestClass1" }, null, true );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1, fromRelationShip2 };

        SelectAttrs selectName1 = new SelectAttrs( "cl1", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectName1 };

        WhereString whereName = new WhereString( "attrString0", Operation.EQUAL, "TestClass0Inst1strValue0_DIRTY" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl0", whereName );

        WhereRelationAssoc whereAssoc = new WhereRelationAssoc( "cl0", "assoc0x1EndB", null, new String[] { "generatedmetamodel", "Assoc0x1" }, "cl1" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereAssoc, localWhereEntry };

        MQLQuery query11 = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query11 );

        return this.assoc_with_dirty_partition_check( resultSet );
    }

    protected boolean assoc_with_dirty_partition( ) throws Exception {

        String query = "select cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0,   \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1 " + "  where cl0.assoc0x1EndB = cl1 "
                       + "  where for cl0(attrString0 = 'TestClass0Inst1strValue0_DIRTY')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_dirty_partition_check( resultSet );
    }

    private boolean assoc_with_dirty_partition_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        if ( partSize > 1 && createDirtyData && ( myTestClient.getOrCreatePartitionStable( ModelDataInstantiator.getInstPartName( 0 ) ).isDirty( ) ) ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, 1, false ) } );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    protected boolean assoc_with_dirty_partition_in_other_direction( ) throws Exception {

        String query = "select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0,   \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1 " + "  where cl0.assoc0x1EndB = cl1 "
                       + "  where for cl1(attrString1 = 'TestClass1Inst0strValue1_DIRTY')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_dirty_partition_in_other_direction_check( resultSet );
    }

    private boolean assoc_with_dirty_partition_in_other_direction_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        if ( partSize > 1 && createDirtyData && ( myTestClient.getOrCreatePartitionStable( ModelDataInstantiator.getInstPartName( 1 ) ).isDirty( ) ) ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, 0, false ) } );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl0.name(STRING), cl1.name(STRING), cl2.name(STRING), cl3.name(STRING), cl4.name(STRING), cl5.name(STRING), cl6.name(STRING), cl7.name(STRING), cl8.name(STRING), cl9.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0} as cl0,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as cl1,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass2} as cl2,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass3} as cl3,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass4} as cl4,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass5} as cl5,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass6} as cl6,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass7} as cl7,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass8} as cl8,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass9} as cl9
     *  where cl0.assoc0x1EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
     *  where cl1.assoc1x2EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1x2 ] = cl2
     *  where cl2.assoc2x3EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc2x3 ] = cl3
     *  where cl3.assoc3x4EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc3x4 ] = cl4
     *  where cl4.assoc4x5EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc4x5 ] = cl5
     *  where cl5.assoc5x6EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc5x6 ] = cl6
     *  where cl6.assoc6x7EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc6x7 ] = cl7
     *  where cl7.assoc7x8EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc7x8 ] = cl8
     *  where cl8.assoc8x9EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc8x9 ] = cl9
     *  where for cl9(name like 'TestClass9Inst2*')) as result
     */
    protected boolean complex_assoc_linear_with_many_selections_ast( ) throws Exception {

        FromEntry[] fromEntries = new FromEntry[mmSize];
        SelectEntry[] selectEntries = new SelectEntry[mmSize];

        for ( int i = 0; i < mmSize; i++ ) {
            fromEntries[i] = new FromType( "cl" + i, new String[] { "generatedmetamodel", "TestClass" + i }, null, true );
            selectEntries[i] = new SelectAttrs( "cl" + i, new String[] { "name" } );
        }

        WhereString whereName = new WhereString( "name", Operation.LIKE, "TestClass" + ( mmSize - 1 ) + "Inst2*" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl" + ( mmSize - 1 ), whereName );

        WhereEntry[] whereEntries = new WhereEntry[mmSize];

        for ( int i = 0; i < ( mmSize - 1 ); i++ ) {
            whereEntries[i] = new WhereRelationFeature( "cl" + i, "reference" + i + "x" + ( i + 1 ), "cl" + ( i + 1 ) );
        }
        whereEntries[mmSize - 1] = localWhereEntry;

        MQLQuery query12 = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query12 );

        return this.complex_assoc_linear_with_many_selections_check( resultSet );
    }

    protected boolean complex_assoc_linear_with_many_selections( ) throws Exception {

        String query = "select cl0.name, cl1.name, cl2.name, cl3.name, cl4.name, cl5.name, cl6.name, cl7.name, cl8.name, cl9.name " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + "  \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass1 as cl1, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 as cl2, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 as cl3, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass4 as cl4, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass5 as cl5, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass6 as cl6, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass7 as cl7, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass8 as cl8, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass9 as cl9 " + " where cl0.assoc0x1EndB[ \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + " where cl1.assoc1x2EndB = cl2 " + " where cl2.assoc2x3EndB = cl3 " + " where cl3.assoc3x4EndB = cl4 " + " where cl4.assoc4x5EndB = cl5 " + " where cl5.assoc5x6EndB = cl6 "
                       + " where cl6.assoc6x7EndB = cl7 " + " where cl7.assoc7x8EndB = cl8 " + " where cl8.assoc8x9EndB = cl9 " + " where for cl9(name like 'TestClass9Inst2*')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.complex_assoc_linear_with_many_selections_check( resultSet );
    }

    protected boolean complex_assoc_linear_with_many_selections_limited( ) throws Exception {

        String query = "select cl0.name, cl1.name, cl2.name, cl3.name, cl4.name, cl5.name, cl6.name, cl7.name, cl8.name, cl9.name " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + "  \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass1 as cl1, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 as cl2, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 as cl3, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass4 as cl4, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass5 as cl5, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass6 as cl6, " + " \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass7 as cl7, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass8 as cl8, " + " \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass9 as cl9 " + " where cl0.assoc0x1EndB[ \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc0x1 ] = cl1 " + " where cl1.assoc1x2EndB = cl2 " + " where cl2.assoc2x3EndB = cl3 " + " where cl3.assoc3x4EndB = cl4 " + " where cl4.assoc4x5EndB = cl5 " + " where cl5.assoc5x6EndB = cl6 "
                       + " where cl6.assoc6x7EndB = cl7 " + " where cl7.assoc7x8EndB = cl8 " + " where cl8.assoc8x9EndB = cl9 " + " where for cl9(name like 'TestClass9Inst2*')";

        MQLResultSet resultSet = this.executeQuery( query, 3 );

        return this.complex_assoc_linear_with_many_selections_check_limited( resultSet );
    }

    private boolean complex_assoc_linear_with_many_selections_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        Object[] intendedResultString = new Object[mmSize];
        for ( int i = 0; i < mmSize; i++ ) {
            intendedResultString[i] = ModelDataInstantiator.calculateClassName( i, 2, false );
        }
        intendedResultSet.add( intendedResultString );

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    private boolean complex_assoc_linear_with_many_selections_check_limited( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        Object[] intendedResultString = new Object[mmSize];
        for ( int i = 0; i < mmSize; i++ ) {
            intendedResultString[i] = ModelDataInstantiator.calculateClassName( i, 2, false );
        }
        intendedResultSet.add( intendedResultString );

        if ( resultSet.getSize( ) > 3 ) {
            return false;
        }

        return this.verifyResultSetLimited( resultSet, intendedResultSet );
    }

    /*-
     * Query dependent on dirty state...
     */
    protected boolean partition_scope_in_query_ast( ) throws Exception {

        this.makeDirty( );

        List<PRI> partitionScopeList = new ArrayList<PRI>( );

        for ( int i = 0; i < partSize; i++ ) {
            if ( myTestClient.getOrCreatePartitionStable( ModelDataInstantiator.getInstPartName( i ) ).isDirty( ) ) {
                partitionScopeList.add( myTestClient.getOrCreatePartitionStable( ModelDataInstantiator.getInstPartName( i ) ).getPri( ) );
            }
        }

        PRI[] myPartitionScope = partitionScopeList.toArray( new PRI[partitionScopeList.size( )] );

        // numbers of those TestClasses that are in a dirty partition
        List<Integer> dirtyClassesList = new ArrayList<Integer>( );

        if ( this.dirtyPartitionsRatio > 0 ) {
            for ( int classNr = 0; classNr < mmSize; classNr++ ) {
                if ( this.calculatePartitionDirtyFlag( ModelDataInstantiator.calculatePartitionForClassNr( classNr, partSize ) ) ) {
                    dirtyClassesList.add( classNr );
                }
            }
        } else {
            for ( int classNr = 0; classNr < mmSize; classNr++ ) {
                dirtyClassesList.add( classNr );
            }
        }

        List<FromEntry> fromEntriesList = new ArrayList<FromEntry>( );
        List<SelectEntry> selectEntriesList = new ArrayList<SelectEntry>( );

        for ( Iterator<Integer> dirtyIterator = dirtyClassesList.iterator( ); dirtyIterator.hasNext( ); ) {
            int i = dirtyIterator.next( );
            QueryScopeProvider queryScopeProvider = myConn.getMQLProcessor( ).getInclusivePartitionScopeProvider( myPartitionScope );
            fromEntriesList.add( new FromType( "cl" + i, new String[] { "generatedmetamodel", "TestClass" + i }, true, queryScopeProvider ) );
            selectEntriesList.add( new SelectAttrs( "cl" + i, new String[] { "name" } ) );
        }

        FromEntry[] fromEntries = fromEntriesList.toArray( new FromEntry[fromEntriesList.size( )] );
        SelectEntry[] selectEntries = selectEntriesList.toArray( new SelectEntry[selectEntriesList.size( )] );

        WhereString whereName = new WhereString( "name", Operation.EQUAL, "TestClass" + dirtyClassesList.get( 0 ).toString( ) + "Inst0" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl" + dirtyClassesList.get( 0 ).toString( ), whereName );

        WhereEntry[] whereEntries = new WhereEntry[dirtyClassesList.size( )];

        for ( int i = 0; i < dirtyClassesList.size( ) - 1; i++ ) {
            whereEntries[i] = new WhereRelationFeature( "cl" + dirtyClassesList.get( i ).toString( ), "reference" + dirtyClassesList.get( i ).toString( ) + "x" + dirtyClassesList.get( i + 1 ).toString( ), "cl" + dirtyClassesList.get( i + 1 ).toString( ) );
        }

        whereEntries[dirtyClassesList.size( ) - 1] = localWhereEntry;

        MQLQuery query13 = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query13 );

        return this.partition_scope_in_query_check( resultSet, dirtyClassesList );
    }

    private boolean partition_scope_in_query_check( MQLResultSet resultSet, List<Integer> dirtyClassesList ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        List<Object> intendedResultString = new ArrayList<Object>( );

        if ( this.dirtyPartitionsRatio > 0 ) {
            for ( Iterator<Integer> dirtyIterator = dirtyClassesList.iterator( ); dirtyIterator.hasNext( ); ) {
                intendedResultString.add( ModelDataInstantiator.calculateClassName( dirtyIterator.next( ), 0, false ) );
            }
            intendedResultSet.add( intendedResultString.toArray( ) );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl0.name(STRING), cl0.attrInt2(INTEGER)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass0} as cl0,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as cl1
     *  where cl0.assoc0x1EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
     *  where cl1.attrInt2(INTEGER) > cl0.attrInt2(INTEGER)
     *  where for cl1(name(STRING) ='TestClass1Inst1')) as result
     */
    protected boolean assoc_with_two_comparisons_ast( ) throws Exception {

        FromType fromRelationShip1 = new FromType( "cl0", new String[] { "generatedmetamodel", "TestClass0" }, null, false );
        FromType fromRelationShip2 = new FromType( "cl1", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1, fromRelationShip2 };

        SelectAttrs select1 = new SelectAttrs( "cl0", new String[] { "name", "attrInt2" } );
        SelectEntry[] selectEntries = new SelectEntry[] { select1 };

        WhereString whereName0 = new WhereString( "name", Operation.EQUAL, "TestClass1Inst1" );
        LocalWhereEntry whereEntry0 = new LocalWhereEntry( "cl1", whereName0 );

        WhereEntry[] whereEntries = new WhereEntry[3];
        whereEntries[0] = new WhereRelationFeature( "cl0", "reference0x1", "cl1" );
        whereEntries[1] = new WhereComparisonAttrs( "cl1", "attrInt2", Operation.GREATER, "cl0", "attrInt2" );
        whereEntries[2] = whereEntry0;

        MQLQuery query14 = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query14 );

        return this.assoc_with_two_comparisons_check( resultSet );
    }

    protected boolean assoc_with_two_comparisons( ) throws Exception {

        String query = "select cl0.name, cl0.attrInt2 " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + "       \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 " + "  where cl0.assoc0x1EndB = cl1 "
                       + "  where cl1.attrInt2 > cl0.attrInt2 " + "  where for cl1(name ='TestClass1Inst1')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_two_comparisons_check( resultSet );
    }

    protected boolean assoc_with_two_comparisons_variant( ) throws Exception {

        String query = "select cl0.name, cl0.attrInt2 " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + "       \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1, " + "       \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass1 as cl1_1 " + "  where cl0.assoc0x1EndB = cl1 " + "  where cl1 = cl1_1 " + "  where cl1.attrInt2 > cl0.attrInt2 " + "  where cl1_1.name ='TestClass1Inst1'";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_two_comparisons_check( resultSet );
    }

    private boolean assoc_with_two_comparisons_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 1; i < 2; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, i, false ), new Integer( ModelDataInstantiator.calculateIntAttr( 0, i, 2 ) ) } );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select mm.name(STRING), mm.attrInt1(INTEGER)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as mm
     *  where for mm((attrInt1(INTEGER) >= 1001002) and
     *               (attrInt1(INTEGER) < 1001010) and
     *               (not(name like 'TestClass*Obj*')))) as result
     */
    protected boolean where_with_three_comparisons_ast( ) throws Exception {

        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, true );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name", "attrInt1" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

        WhereString whereName = new WhereString( "name", Operation.LIKE, "TestClass*Obj*" );
        WhereNot whereNot = new WhereNot( whereName );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "mm", whereNot );

        WhereInt whereInt1 = new WhereInt( "attrInt1", Operation.GREATEREQUAL, ModelDataInstantiator.calculateIntAttr( 1, 2, 1 ) );
        WhereInt whereInt2 = new WhereInt( "attrInt1", Operation.SMALLER, ModelDataInstantiator.calculateIntAttr( 1, instSize, 1 ) );
        WhereClause[] whereInts = new WhereClause[] { whereInt1, whereInt2 };
        WhereAnd whereAnd = new WhereAnd( whereInts );
        LocalWhereEntry andComparison = new LocalWhereEntry( "mm", whereAnd );

        WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry, andComparison };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.where_with_three_comparisons_check( resultSet );
    }

    protected boolean where_with_three_comparisons( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as mm " + "  where for mm((attrInt1 >= 1001002) and " + "              (attrInt1 < 1001010) and "
                       + "               (not(name like 'TestClass*Obj*')))";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.where_with_three_comparisons_check( resultSet );
    }

    protected boolean where_with_three_comparisons_limited( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as mm " + "  where for mm((attrInt1 >= 1001002) and " + "              (attrInt1 < 1001010) and "
                       + "               (not(name like 'TestClass*Obj*')))";

        MQLResultSet resultSet = this.executeQuery( query, 3 );

        return this.where_with_three_comparisons_check_limited( resultSet );
    }

    protected boolean where_with_three_comparisons_2( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as mm where mm.attrInt1 >= 1001002 where mm.attrInt1 < 1001010 where " + " mm.name not like 'TestClass*Obj*'";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.where_with_three_comparisons_check( resultSet );
    }

    private boolean where_with_three_comparisons_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 2; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, false ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    private boolean where_with_three_comparisons_check_limited( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 2; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, false ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
        }

        if ( resultSet.getSize( ) != 3 ) {
            return false;
        }

        return this.verifyResultSetLimited( resultSet, intendedResultSet );
    }

    /*-
     * (select mm.name(STRING), mm.attrInt1(INTEGER)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as mm
     *  where for mm((not(name like 'TestClass*Obj*')) and
     *               ((attrInt1(INTEGER) < 1001002) or
     *               (attrInt1(INTEGER) > 1001002)))) as result
     */
    protected boolean where_with_three_comparisons_and_or_ast( ) throws Exception {

        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, true );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name", "attrInt1" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

        WhereString whereName = new WhereString( "name", Operation.LIKE, "TestClass*Obj*" );
        WhereNot whereNot = new WhereNot( whereName );

        WhereInt whereInt1 = new WhereInt( "attrInt1", Operation.SMALLER, ModelDataInstantiator.calculateIntAttr( 1, 2, 1 ) );
        WhereInt whereInt2 = new WhereInt( "attrInt1", Operation.GREATER, ModelDataInstantiator.calculateIntAttr( 1, 2, 1 ) );
        WhereClause[] whereInts = new WhereClause[] { whereInt1, whereInt2 };
        WhereOr whereOr = new WhereOr( whereInts );

        WhereClause[] finalAnd = new WhereClause[] { whereNot, whereOr };

        WhereAnd whereAnd = new WhereAnd( finalAnd );

        LocalWhereEntry andComparison = new LocalWhereEntry( "mm", whereAnd );

        WhereEntry[] whereEntries = new WhereEntry[] { andComparison };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.where_with_three_comparisons_and_or_check( resultSet );
    }

    protected boolean where_with_three_comparisons_and_or( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as mm " + "  where for mm((not(name like 'TestClass*Obj*')) and " + "               ((attrInt1 < 1001002) or "
                       + "               (attrInt1 > 1001002)))";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.where_with_three_comparisons_and_or_check( resultSet );
    }

    private boolean where_with_three_comparisons_and_or_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 0; i < instSize; i++ ) {
            if ( i != 2 ) {
                intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, false ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
            }
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select mm.name(STRING), mm.attrInt1(INTEGER)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as mm) as result
     */
    protected boolean execute_with_exclusive_scope_ast( ) throws Exception {

        FromType fromRelationShip = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name", "attrInt1" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries );

        PRI[] oldPartitionScope = partitionScope;
        boolean oldPartitionScopeInclusive = partitionScopeInclusive;
        partitionScope = null;
        partitionScopeInclusive = false;
        MQLResultSet resultSet = this.executeQuery( query );
        partitionScope = oldPartitionScope;
        partitionScopeInclusive = oldPartitionScopeInclusive;

        return this.execute_with_exclusive_scope_check( resultSet );
    }

    private boolean execute_with_exclusive_scope_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 0; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, false ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, true ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    protected boolean reflect_element( ) throws Exception {

        String partitions = "";
        if ( partitionScope != null && partitionScope.length > 0 ) {
            partitions = "\"" + partitionScope[0] + "\"";
            for ( int i = 1; i < partitionScope.length; i++ ) {
                partitions += ", \"" + partitionScope[i] + "\"";
            }
        }

        String query = "select el from Reflect::Element as el in partitions{" + partitions + "}";
        MQLResultSet resultSet = this.executeQuery( query );
        return this.reflect_element_check( resultSet );
    }

    private boolean reflect_element_check( MQLResultSet resultSet ) {

        // collect all partitions in the result set and verify
        Set<PRI> partitionsInResultSet = new HashSet<PRI>( );
        for ( int i = 0; i < resultSet.getSize( ); i++ ) {
            partitionsInResultSet.add( resultSet.getMri( i, "el" ).getPri( ) );
        }

        // check against the initial available 
        for ( int i = 0; i < partitionScope.length; i++ ) {
            if ( !partitionsInResultSet.contains( partitionScope[i] ) ) {
                return false;
            }
        }

        return partitionsInResultSet.size( ) == partitionScope.length;
    }


    /*-
     * (select t1.name(STRING), t2.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as t1,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as t2
     *  where t1.assoc1xRefElementEndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc1xRefElement ] = t2) as result
     */
    protected boolean assoc_to_subclass_of_reflect_element_ast( ) throws Exception {

        FromType fromRelationShip1 = new FromType( "t1", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromType fromRelationShip2 = new FromType( "t2", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1, fromRelationShip2 };

        SelectAttrs selectMe1Name = new SelectAttrs( "t1", new String[] { "name" } );
        SelectAttrs selectMe2Name = new SelectAttrs( "t2", new String[] { "name" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMe1Name, selectMe2Name };

        WhereRelationAssoc whereAssoc1 = new WhereRelationAssoc( "t1", "assoc1xRefElementEndB", null, new String[] { "generatedmetamodel", "Assoc1xRefElement" }, "t2" );
        WhereEntry[] whereEntries = new WhereEntry[] { whereAssoc1 };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_to_subclass_of_reflect_element_check( resultSet );
    }

    protected boolean assoc_to_subclass_of_reflect_element( ) throws Exception {

        String query = "select t1.name, t2.name " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as t1, " + "       \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as t2 " + "  where t1.assoc1xRefElementEndB[ \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::Assoc1xRefElement] = t2";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_to_subclass_of_reflect_element_check( resultSet );
    }

    private boolean assoc_to_subclass_of_reflect_element_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 0; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, 0, false ), ModelDataInstantiator.calculateClassName( 1, i, false ) } );
        }
        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    protected boolean reflect_element_with_fixed_set( ) throws Exception {

        String preQuery = "select el from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as el where el.name = 'TestClass1Inst0'";
        MQLResultSet preResultSet = this.executeQuery( preQuery );

        String query = "select el from Reflect::Element as el in elements {\"" + preResultSet.getMri( 0, "el" ) + "\"}";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.reflect_element_with_fixed_set_check( resultSet, preResultSet.getMri( 0, "el" ) );
    }

    protected boolean reflect_element_compared_with_fixed_set( ) throws Exception {

        String preQuery = "select el from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as el where el.name = 'TestClass1Inst0'";
        MQLResultSet preResultSet = this.executeQuery( preQuery );

        String query = "select el from Reflect::Element as el, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 in elements {\"" + preResultSet.getMri( 0, "el" ) + "\"}, \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass2 as cl2 where cl1.assoc1x2EndB[\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1x2 ] = cl2 where el = cl1 ";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.reflect_element_with_fixed_set_check( resultSet, preResultSet.getMri( 0, "el" ) );
    }

    protected boolean reflect_element_compared_with_fixed_set_2( ) throws Exception {

        String preQuery = "select el from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as el where el.name = 'TestClass1Inst0'";
        MQLResultSet preResultSet = this.executeQuery( preQuery );

        String query = "select el, cl1 from Reflect::Element as el, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 in elements {\"" + preResultSet.getMri( 0, "el" ) + "\"} where el = cl1 ";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.reflect_element_with_fixed_set_check( resultSet, preResultSet.getMri( 0, "el" ) ) && this.reflect_element_with_fixed_set_check_2( resultSet, preResultSet.getMri( 0, "el" ) );

    }

    private boolean reflect_element_with_fixed_set_check( MQLResultSet resultSet, MRI element ) {

        return element.equals( resultSet.getMri( 0, "el" ) );
    }

    private boolean reflect_element_with_fixed_set_check_2( MQLResultSet resultSet, MRI element ) {

        return element.equals( resultSet.getMri( 0, "cl1" ) );
    }

    protected boolean incompatible_types_return_empty_result( ) throws Exception {

        String query = "select el from Reflect::Element as el, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1," + "\"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 as cl2 where el = cl1 where el = cl2 where cl2 = cl2";

        MQLResultSet resultSet = this.executeQuery( query );

        return resultSet.isEmpty( );
    }

    protected boolean assoc_to_reflect_element( ) throws Exception {

        String query = "select t1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as t1, Reflect::Element as t2 where t1.assoc1xRefElementEndB[ \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::Assoc1xRefElement] = t2";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_to_reflect_element_check( resultSet );
    }

    private boolean assoc_to_reflect_element_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 0; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, 0, false ) } );
        }
        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select cl0.name(STRING), cl1.name(STRING)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass0,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass0} as cl0,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1,
     *        sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestSubClass1} as cl1
     *  where cl0.assoc0x1EndB[@ sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::Assoc0x1 ] = cl1
     *  where for cl0(name(STRING) ='TestClass0Inst0')) as result
     */
    protected boolean assoc_with_multiple_selection_ast( ) throws Exception {

        FromType fromRelationShip1 = new FromType( "cl0", new String[] { "generatedmetamodel", "TestClass0" }, null, false );
        FromType fromRelationShip2 = new FromType( "cl1", new String[] { "generatedmetamodel", "TestClass1" }, null, false );
        FromEntry[] fromEntries = new FromEntry[] { fromRelationShip1, fromRelationShip2 };

        SelectAttrs selectName1 = new SelectAttrs( "cl0", new String[] { "name" } );
        SelectAttrs selectName2 = new SelectAttrs( "cl1", new String[] { "name" } );

        SelectEntry[] selectEntries = new SelectEntry[] { selectName1, selectName2 };

        WhereString whereName = new WhereString( "name", Operation.EQUAL, "TestClass0Inst0" );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "cl0", whereName );

        WhereRelationAssoc whereAssoc1 = new WhereRelationAssoc( "cl0", "assoc0x1EndB", null, new String[] { "generatedmetamodel", "Assoc0x1" }, "cl1" );
        WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry, whereAssoc1 };

        MQLQuery query2a = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query2a );

        return this.assoc_with_multipled_selection_check( resultSet );
    }

    protected boolean assoc_with_multiple_selection( ) throws Exception {

        String query = "select cl0.name, cl1.name " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0, " + "       \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 " + "  where cl0.assoc0x1EndB = cl1 "
                       + "  where for cl0(name ='TestClass0Inst0')";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.assoc_with_multipled_selection_check( resultSet );
    }

    private boolean assoc_with_multipled_selection_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, 0, false ), ModelDataInstantiator.calculateClassName( 1, 0, false ) } );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, 0, false ), ModelDataInstantiator.calculateClassName( 1, 0, true ) } );
        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /*-
     * (select mm.name(STRING), mm.attrInt1(INTEGER)
     *  from {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as mm,
     *       {sap.com/tc/moin/metamodel/generatedmetamodel#generatedmetamodel::TestClass1} as mm2
     *  where mm.attrEnum(STRING) = mm2.attrEnum(STRING)
     *  where mm = mm2
     *  where for mm((not(name like 'TestClass*Obj*')) and
     *               (attrEnum(STRING) ='Label1'))) as result
     */
    protected boolean enum_comparisons_ast( ) throws Exception {

        FromType fromT1 = new FromType( "mm", new String[] { "generatedmetamodel", "TestClass1" }, null, true );
        FromType fromT2 = new FromType( "mm2", new String[] { "generatedmetamodel", "TestClass1" }, null, true );
        FromEntry[] fromEntries = new FromEntry[] { fromT1, fromT2 };

        SelectAttrs selectMeName = new SelectAttrs( "mm", new String[] { "name", "attrInt1" } );
        SelectEntry[] selectEntries = new SelectEntry[] { selectMeName };

        WhereString whereName = new WhereString( "name", Operation.LIKE, "TestClass*Obj*" );
        WhereNot whereNot = new WhereNot( whereName );
        WhereString whereEnum = new WhereString( "attrEnum", Operation.EQUAL, "Label1" );

        WhereClause[] whereClauses = { whereNot, whereEnum };
        WhereAnd whereAnd = new WhereAnd( whereClauses );
        LocalWhereEntry localWhereEntry = new LocalWhereEntry( "mm", whereAnd );

        JoinWhereEntry joinWhereEntry1 = new WhereComparisonAttrs( "mm", "attrEnum", Operation.EQUAL, "mm2", "attrEnum" );
        JoinWhereEntry joinWhereEntry2 = new WhereComparisonAliases( "mm", "mm2" );

        WhereEntry[] whereEntries = new WhereEntry[] { localWhereEntry, joinWhereEntry1, joinWhereEntry2 };

        MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.enum_comparisons_check( resultSet );
    }

    protected boolean enum_comparisons( ) throws Exception {

        String query = "select mm.name, mm.attrInt1 " + "  from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as mm, " + "       \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as mm2 "
                       + "  where mm.attrEnum = mm2.attrEnum " + "  where mm = mm2 " + "  where for mm((not(name like 'TestClass*Obj*')) and " + "               (attrEnum ='Label1'))";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.enum_comparisons_check( resultSet );
    }

    private boolean enum_comparisons_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 0; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 1, i, false ), new Integer( ModelDataInstantiator.calculateIntAttr( 1, i, 1 ) ) } );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    protected boolean enforced_simple_scheduling( ) throws Exception {

        String query = " select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 withoutsubtypes as cl2 in partitions{\"" + this.partitionScope[2] + "\"}, \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 withoutsubtypes as cl3 /* in partitions{\"" + this.partitionScope[3]
                       + "\"} */ where cl0.assoc0x1EndB = cl1 where cl1.assoc1x2EndB = cl2 where cl2.assoc2x3EndB = cl3 ";

        this.makePartitionDirty( this.loadPartition( 3 ) );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.enforced_simple_scheduling_check( resultSet );
    }

    protected boolean enforced_simple_scheduling_2( ) throws Exception {

        String query = " select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0 in partitions{\"" + this.partitionScope[0] + "\"}, \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1 in partitions{\"" + this.partitionScope[1] + "\"} , \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 withoutsubtypes as cl2 in partitions{\"" + this.partitionScope[2]
                       + "\"} where cl0.assoc0x1EndB = cl1 where cl1.assoc1x2EndB = cl2";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.enforced_simple_scheduling_check( resultSet );
    }

    protected boolean enforced_simple_scheduling_3( ) throws Exception {

        String query = " select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1 in partitions{\"" + this.partitionScope[1] + "\"}, \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 withoutsubtypes as cl2, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 withoutsubtypes as cl3 /* in partitions{\"" + this.partitionScope[3]
                       + "\"} */ where cl0.assoc0x1EndB = cl1 where cl1.assoc1x2EndB = cl2 where cl2.assoc2x3EndB = cl3 ";

        this.makePartitionDirty( this.loadPartition( 1 ) );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.enforced_simple_scheduling_check( resultSet );
    }

    private boolean enforced_simple_scheduling_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        for ( int i = 0; i < instSize; i++ ) {
            intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, i, false ) } );
        }

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    protected boolean enforced_scheduling( ) throws Exception {

        String query = " select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 withoutsubtypes as cl2 in partitions{\"" + this.partitionScope[2] + "\"}, \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 withoutsubtypes as cl3 /* in partitions{\"" + this.partitionScope[3]
                       + "\"} */ where cl0.assoc0x1EndB = cl1 where cl1.assoc1x2EndB = cl2 where cl2.name ='TestClass2Inst0' where cl1.name = 'TestClass1Inst0' where cl2.assoc2x3EndB = cl3";

        this.makePartitionDirty( this.loadPartition( 3 ) );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.enforced_scheduling_check( resultSet );
    }

    protected boolean enforced_scheduling_2( ) throws Exception {

        String query = " select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0 in partitions{\"" + this.partitionScope[0] + "\"}, \"" + GENERATED_MM_CONTAINER_NAME
                       + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1 in partitions{\"" + this.partitionScope[1] + "\"} , \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 withoutsubtypes as cl2 in partitions{\"" + this.partitionScope[2]
                       + "\"} where cl0.assoc0x1EndB = cl1 where cl1.assoc1x2EndB = cl2 where cl2.name ='TestClass2Inst0' where cl1.name = 'TestClass1Inst0'";

        MQLResultSet resultSet = this.executeQuery( query );

        return this.enforced_scheduling_check( resultSet );
    }

    protected boolean enforced_scheduling_3( ) throws Exception {

        String query = " select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 withoutsubtypes as cl0, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 withoutsubtypes as cl1 in partitions{\"" + this.partitionScope[1] + "\"}, \""
                       + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass2 withoutsubtypes as cl2, \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass3 withoutsubtypes as cl3 /* in partitions{\"" + this.partitionScope[3]
                       + "\"} */ where cl0.assoc0x1EndB = cl1 where cl1.assoc1x2EndB = cl2 where cl2.assoc2x3EndB = cl3 where cl2.name ='TestClass2Inst0' where cl1.name = 'TestClass1Inst0'";

        this.makePartitionDirty( this.loadPartition( 1 ) );

        MQLResultSet resultSet = this.executeQuery( query );

        return this.enforced_scheduling_check( resultSet );
    }

    private boolean enforced_scheduling_check( MQLResultSet resultSet ) {

        List<Object[]> intendedResultSet = new ArrayList<Object[]>( );
        intendedResultSet.add( new Object[] { ModelDataInstantiator.calculateClassName( 0, 0, false ) } );

        return this.verifyResultSet( resultSet, intendedResultSet );
    }

    /* Auxiliary methods */

    private MQLResultSet executeQuery( MQLQuery mqlQuery ) throws Exception {

        this.makeDirty( );

        MQLResultSet resultSet = null;

        MQLProcessor mql = myConn.getMQLProcessor( );

        if ( this.withOptimization ) {
            ( (MQLProcessorImpl) ( ( (MQLProcessorWrapper) mql ).unwrap( ) ) ).turnOnOptimizationDuringScheduling( );
        } else {
            ( (MQLProcessorImpl) ( ( (MQLProcessorWrapper) mql ).unwrap( ) ) ).turnOffOptimizationForElementsDuringScheduling( );
        }

        long timeStamp = System.currentTimeMillis( );
        MQLPreparedQuery preparedQuery = mql.prepare( mqlQuery );
        String preparedQueryString = preparedQuery.toString( );
        QueryScopeProvider queryScopeProvider = mql.getQueryScopeProvider( partitionScopeInclusive, partitionScope, new CRI[0] );
        resultSet = mql.execute( preparedQuery, queryScopeProvider );

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Query \n" + preparedQueryString + "\nexecuted in " + String.valueOf( System.currentTimeMillis( ) - timeStamp ) + " ms" );
        }

        return resultSet;
    }

    private MQLResultSet executeQuery( String mqlQuery, int threshold ) throws Exception {

        this.makeDirty( );

        MQLResultSet resultSet = null;

        MQLProcessor mql = myConn.getMQLProcessor( );

        if ( this.withOptimization ) {
            ( (MQLProcessorImpl) ( ( (MQLProcessorWrapper) mql ).unwrap( ) ) ).turnOnOptimizationDuringScheduling( );
        } else {
            ( (MQLProcessorImpl) ( ( (MQLProcessorWrapper) mql ).unwrap( ) ) ).turnOffOptimizationForElementsDuringScheduling( );
        }

        long timeStamp = System.currentTimeMillis( );
        MQLPreparedQuery preparedQuery = mql.prepare( mqlQuery );
        String preparedQueryString = preparedQuery.toString( );
        QueryScopeProvider queryScopeProvider = mql.getQueryScopeProvider( partitionScopeInclusive, partitionScope, new CRI[0] );
        resultSet = mql.execute( preparedQuery, queryScopeProvider, threshold );

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Query \n" + preparedQueryString + "\nexecuted in " + String.valueOf( System.currentTimeMillis( ) - timeStamp ) + " ms" );
        }

        return resultSet;
    }

    private MQLResultSet executeQuery( String mqlQuery ) throws Exception {

        return this.executeQuery( mqlQuery, -1 );
    }


    private boolean calculatePartitionDirtyFlag( int partNr ) {

        return ( partNr % this.dirtyPartitionsRatio == 0 );
    }

    private void makeDirty( ) throws Exception {

        if ( this.dirtyPartitionsRatio > 0 ) {
            for ( int j = 0; j < partSize; j++ ) {
                if ( this.calculatePartitionDirtyFlag( j ) ) {
                    ModelPartition mp = this.loadPartition( j );
                    this.makePartitionDirty( mp );

                    if ( createDirtyData ) {
                        Collection<Partitionable> elements = mp.getElements( );
                        for ( Iterator<Partitionable> el_iter = elements.iterator( ); el_iter.hasNext( ); ) {
                            Object tmpObject = el_iter.next( );

                            for ( int k = 0; k < attrSize; k++ ) {
                                String tmpStr = (String) tmpObject.getClass( ).getMethod( "getAttrString" + k, (Class[]) null ).invoke( tmpObject, (Object[]) null );
                                tmpObject.getClass( ).getMethod( "setAttrString" + k, new Class[] { String.class } ).invoke( tmpObject, (Object[]) ( new String[] { tmpStr + "_DIRTY" } ) );
                            }
                        }
                    }
                }
            }
        }

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Applied dirty data settings." );
        }

    }

    private void makePartitionDirty( ModelPartition mp ) {

        assert mp instanceof Wrapper : "Partition must be a wrapped partition";
        Partitionable element = mp.getElements( ).iterator( ).next( );
        element.get___Connection( ).getNullPartition( ).assignElement( element );
        mp.assignElement( element );
    }

    private ModelPartition loadPartition( int j ) {

        ModelPartition mp = myTestClient.getOrCreatePartitionStable( ModelDataInstantiator.getInstPartName( j ) );
        logger.trace( MoinSeverity.INFO, "Loading partition: " + mp.getPri( ).getPartitionName( ) );

        return mp;
    }

    protected ModelPartition[] loadPartitions( ) {

        ModelPartition[] partitions = new ModelPartition[partSize];
        for ( int j = 0; j < partSize; j++ ) {
            partitions[j] = this.loadPartition( j );
        }
        return partitions;
    }

    /**
     * Verfies the result set based on the String entries. The intended result
     * set has to be a list of arrays, which represent the lines of the result
     * set.
     * 
     * @param resultSet
     * @param intendedResult
     */
    private boolean verifyResultSet( MQLResultSet resultSet, List<Object[]> intendedResult ) {

        boolean correctResultSet = true;
        int numberOfRows = resultSet.getSize( );

        // construct the produced result set as basis for comparing
        List<Object[]> producedResultSet = new ArrayList<Object[]>( numberOfRows );

        // get reflective information
        MQLColumnType[] columnTypes = resultSet.getQueryColumnTypes( );

        for ( int rowIndex = 0; rowIndex < numberOfRows; rowIndex++ ) {
            // add a line in the produced result set
            Object[] row = new Object[columnTypes.length];

            // iterate over the aliases
            for ( int k = 0; k < columnTypes.length; k++ ) {
                if ( columnTypes[k].attribute == null ) {
                    row[k] = resultSet.getMri( rowIndex, columnTypes[k].alias );
                } else {
                    row[k] = resultSet.getAttribute( rowIndex, columnTypes[k].alias, columnTypes[k].attribute );
                }
            }
            producedResultSet.add( rowIndex, row );
        }

        // do the actual comparison
        int rsRow = 0;
        if ( intendedResult.size( ) == producedResultSet.size( ) ) {

            while ( correctResultSet && rsRow < numberOfRows ) {
                int psRow = 0;
                boolean correctResultSubSet = false;
                Object[] intendedRow = intendedResult.get( rsRow );
                while ( !correctResultSubSet && psRow < numberOfRows ) {
                    correctResultSubSet = this.equalsArray( producedResultSet.get( psRow ), intendedRow );
                    psRow++;
                }
                correctResultSet = correctResultSubSet;
                rsRow++;
            }
        } else {
            correctResultSet = false;
        }

        if ( !correctResultSet ) {
            // header
            String header = "\n| ";
            for ( int i = 0; i < columnTypes.length; i++ ) {
                header = header + columnTypes[i].alias;
                if ( columnTypes[i].attribute != null ) {
                    header = header + "." + columnTypes[i].attribute;
                }
                header = header + " : " + columnTypes[i].typeName + " | ";
            }

            // convert the 2D arrays to a legible format
            String producedResultSetString = header + "\n";
            String intendedResultSetString = header + "\n";
            for ( Object[] producedResultSetRow : producedResultSet ) {
                producedResultSetString = producedResultSetString + this.nestedArrayToString( producedResultSetRow, " | " ) + "\n";
            }
            for ( Object[] intendedResultSetRow : intendedResult ) {
                intendedResultSetString = intendedResultSetString + this.nestedArrayToString( intendedResultSetRow, " | " ) + "\n";
            }

            StringBuilder sb = new StringBuilder( );
            sb.append( "Test FAILED\n" );
            sb.append( "-----> Result Sets \n" );
            sb.append( "Produced Result Set:" + producedResultSetString + "\n" );
            sb.append( "Intended Result Set:" + intendedResultSetString + "\n" );
            sb.append( "Result Sets <-----" );
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( MoinSeverity.ERROR, sb.toString( ) );
            }
            System.err.println( sb.toString( ) );
        }

        return correctResultSet;
    }

    /**
     * Verfies the result set based on the String entries. The intended result
     * set has to be a list of arrays, which represent the lines of the result
     * set.
     * 
     * @param resultSet
     * @param intendedResult
     */
    private boolean verifyResultSetLimited( MQLResultSet resultSet, List<Object[]> intendedResult ) {

        boolean correctResultSet = true;
        int numberOfRows = resultSet.getSize( );

        // construct the produced result set as basis for comparing
        List<Object[]> producedResultSet = new ArrayList<Object[]>( numberOfRows );

        // get reflective information
        MQLColumnType[] columnTypes = resultSet.getQueryColumnTypes( );

        for ( int rowIndex = 0; rowIndex < numberOfRows; rowIndex++ ) {
            // add a line in the produced result set
            Object[] row = new Object[columnTypes.length];

            // iterate over the aliases
            for ( int k = 0; k < columnTypes.length; k++ ) {
                if ( columnTypes[k].attribute == null ) {
                    row[k] = resultSet.getMri( rowIndex, columnTypes[k].alias );
                } else {
                    row[k] = resultSet.getAttribute( rowIndex, columnTypes[k].alias, columnTypes[k].attribute );
                }
            }
            producedResultSet.add( rowIndex, row );
        }

        // do the actual comparison
        int rsRow = 0;
        if ( intendedResult.size( ) >= producedResultSet.size( ) ) {

            while ( correctResultSet && rsRow < numberOfRows ) {
                int psRow = 0;
                boolean correctResultSubSet = false;
                Object[] intendedRow = intendedResult.get( rsRow );
                while ( !correctResultSubSet && psRow < numberOfRows ) {
                    correctResultSubSet = this.equalsArray( producedResultSet.get( psRow ), intendedRow );
                    psRow++;
                }
                correctResultSet = correctResultSubSet;
                rsRow++;
            }
        } else {
            correctResultSet = false;
        }

        if ( !correctResultSet ) {
            // header
            String header = "\n| ";
            for ( int i = 0; i < columnTypes.length; i++ ) {
                header = header + columnTypes[i].alias;
                if ( columnTypes[i].attribute != null ) {
                    header = header + "." + columnTypes[i].attribute;
                }
                header = header + " : " + columnTypes[i].typeName + " | ";
            }

            // convert the 2D arrays to a legible format
            String producedResultSetString = header + "\n";
            String intendedResultSetString = header + "\n";
            for ( Object[] producedResultSetRow : producedResultSet ) {
                producedResultSetString = producedResultSetString + this.nestedArrayToString( producedResultSetRow, " | " ) + "\n";
            }
            for ( Object[] intendedResultSetRow : intendedResult ) {
                intendedResultSetString = intendedResultSetString + this.nestedArrayToString( intendedResultSetRow, " | " ) + "\n";
            }

            StringBuilder sb = new StringBuilder( );
            sb.append( "Test FAILED\n" );
            sb.append( "-----> Result Sets \n" );
            sb.append( "Produced Result Set:" + producedResultSetString + "\n" );
            sb.append( "Intended Result Set:" + intendedResultSetString + "\n" );
            sb.append( "Result Sets <-----" );
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( MoinSeverity.ERROR, sb.toString( ) );
            }
            System.err.println( sb.toString( ) );
        }

        return correctResultSet;
    }


    private String nestedArrayToString( Object[] resultSetArray, String separator ) {

        String res = separator;
        for ( Object resSetEntry : resultSetArray ) {
            if ( resSetEntry == null ) {
                res = res + " null" + separator;
            } else if ( resSetEntry instanceof Object[] ) {
                res = res + "[" + this.nestedArrayToString( (Object[]) resSetEntry, " ; " ) + "]";
            } else {
                res = res + resSetEntry.toString( ) + separator;
            }
        }
        return res;
    }

    private boolean equalsArray( Object[] array1, Object[] array2 ) {

        if ( array1.length == array2.length ) {
            boolean res = true;
            int i = 0;
            while ( res && i < array1.length ) {
                if ( ( array1[i] == null && array2[i] != null ) || ( array2[i] == null && array1[i] != null ) ) {
                    res = false;
                } else if ( array1[i] instanceof Object[] && array2[i] instanceof Object[] ) {
                    res = this.equalsArray( ( (Object[]) array1[i] ), ( (Object[]) array2[i] ) );
                } else {
                    res = ( array1[i] == null && array2[i] == null ) || array1[i].equals( array2[i] );
                }
                i++;
            }
            return res;
        }
        return false;

    }

}
