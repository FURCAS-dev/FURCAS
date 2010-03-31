package com.sap.tc.moin.repository.test.query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;


public class TestSuiteNegativeQueryTests extends MoinTestCase {

    // trace setup
    protected static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, TestSuiteNegativeQueryTests.class );

    private static final String COMPANY_MM_CONTAINER_NAME = "sap.com/tc/moin/test/company";

    private static final String GENERATED_MM_CONTAINER_NAME = "sap.com/tc/moin/metamodel/generatedmetamodel";

    private static final String MOF_CONTAINER_NAME = MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME;

    private Connection conn;

    private TestClient testClient1;

    private PRI[] globalPartitionScope;

    private CRI[] containerScope;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        // Call setup of parent test case
        super.beforeTestMethod( );

        this.testClient1 = getTestHelper( ).getDefaultTestClient( true );
        this.testClient1.setAsCurrentClient( );
        this.conn = this.testClient1.getConnection( );

        try {
            ModelPartition p1 = this.testClient1.getOrCreatePartitionStable( "negative_query_partition1" );
            ModelPartition p2 = this.testClient1.getOrCreatePartitionStable( "negative_query_partition2" );
            ModelPartition p3 = this.testClient1.getOrCreatePartitionStable( "negative_query_partition3" );
            this.globalPartitionScope = new PRI[] { p1.getPri( ), p2.getPri( ), p3.getPri( ) };
            this.containerScope = new CRI[] { p1.getPri( ).getCri( ) };

        } catch ( Exception e1 ) {
            e1.printStackTrace( );
        }


    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( this.testClient1 != null ) {
            this.testClient1.clear( );
            this.testClient1 = null;
        }
        this.conn = null;
        super.afterTestMethod( );
    }

    private boolean verifyNegativeTest( String query ) {

        MQLProcessor mql = this.conn.getMQLProcessor( );
        try {
            mql.prepare( query );
        } catch ( MQLFormatException e ) {
            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, "Query: \n" + query );
                logger.trace( MoinSeverity.INFO, "did not preprocess with message: " + e.getLocalizedMessage( ) );
            }
            return true;
        }

        assertTrue( "Query >> " + query + " << did not produce an MQL FormatException!", false );
        return false;
    }

    /*
     * Actual TESTs
     */

    @Test
    public void structureTypesAsNestedQuery( ) throws Exception {

        String query = "select cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 where cl1.name ='TestClass1Inst0' where cl1.attrStruct in (select strTp from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::StructTp as strTp)";

        this.verifyNegativeTest( query );
    }

    @Test
    public void structureTypesInNullComparison( ) throws Exception {

        String query = "select cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 where cl1.name ='TestClass1Inst0' where cl1.attrStruct <> null";

        this.verifyNegativeTest( query );
    }

    @Test
    public void unqualifiedAssocEndInComparisonWithNull( ) throws Exception {

        String query = "select cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 where cl1.assoc1x2EndB <> null";

        this.verifyNegativeTest( query );
    }

    @Test
    public void derivedAttributesAreNotSupported( ) throws Exception {

        String query = "select modelClass.qualifiedName from \"" + MOF_CONTAINER_NAME + "\"#Model::Class as modelClass";

        this.verifyNegativeTest( query );
    }

    @Test
    public void unMatchingAliasesInSelect( ) throws Exception {

        String query = "select alias1 from \"" + MOF_CONTAINER_NAME + "\"#Model::Class as alias2";

        this.verifyNegativeTest( query );
    }

    @Test
    public void fromTypeDoesNotExist( ) throws Exception {

        String query = "select nec from \"" + MOF_CONTAINER_NAME + "\"#Model::NonExistingClass as nec";

        this.verifyNegativeTest( query );
    }

    @Test
    public void whereClauseWithOr( ) throws Exception {

        String query = "select cl from \"" + MOF_CONTAINER_NAME + "\"#Model::Class as cl where cl.name = 'a' or c.name = 'b'";

        this.verifyNegativeTest( query );
    }


    @Test
    public void nullComparisonOnPrimitiveTypeInWhereClause( ) throws Exception {

        String query = "select dep from \"" + COMPANY_MM_CONTAINER_NAME + "\"#Company::Department as dep where dep.budget = null";

        this.verifyNegativeTest( query );
    }

    @Test
    public void comparisonTooLong( ) throws Exception {

        String query = "select mm from generatedmetamodel::TestClass1 as mm where name = 'Thisisalongstringwhichismorethan200characters :                                                                                                                                                                       n'";

        this.verifyNegativeTest( query );
    }

    @Test
    public void nestedQueryWithMoreThanOneSelect( ) throws Exception {

        String query = "select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0 where cl0.assoc0x1EndB in (select cl1, cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1 "
                       + " where for cl1(name ='TestClass1Inst0'))";

        this.verifyNegativeTest( query );
    }

    @Test
    public void nestedQueryWithOneAttributeSelect( ) throws Exception {

        String query = "select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0 where cl0.assoc0x1EndB in (select cl1.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass1 as cl1)";

        this.verifyNegativeTest( query );
    }

    @Test
    public void fromTypeWithNotInElements( ) throws Exception {

        String query = "select cl0.name from \"" + GENERATED_MM_CONTAINER_NAME + "\"#generatedmetamodel::TestClass0 as cl0 not in elements{}";

        this.verifyNegativeTest( query );
    }

    @Test
    public void fromTypeWithSameAlias( ) throws Exception {

        String query = "select mm from \"" + GENERATED_MM_CONTAINER_NAME + "\"#Model::Class as mm, \"" + GENERATED_MM_CONTAINER_NAME + "\"#Model::Class as mm";

        this.verifyNegativeTest( query );
    }

    @Test
    public void invalidEscapeInLikePattern( ) throws Exception {

        String query = "select mm from \"" + GENERATED_MM_CONTAINER_NAME + "\"#Model::Class as mm where mm.name like 'this pattern is \\invalid'";

        this.verifyNegativeTest( query );
    }

    @Test
    public void executionOverLoad( ) throws Exception {

        String query = "select m from \"" + MOF_CONTAINER_NAME + "\"#Model::Class as m, \"" + MOF_CONTAINER_NAME + "\"#Model::Class as m2, Model::Class as m3";

        MQLProcessor mql = this.conn.getMQLProcessor( );
        boolean executionFailed = false;
        try {
            mql.execute( query );
        } catch ( MQLExecutionException e ) {
            executionFailed = true;
        }

        assertTrue( "Query >> " + query + " << did not produce an MQL ExecutionException!", executionFailed );
    }

    @Test
    public void invalidSubTypeExclusion( ) throws Exception {

        String query = "select clf from Model::Classifier withoutsubtypes {} as clf";
        this.verifyNegativeTest( query );

        String query2 = "select clf from Model::Classifier withoutsubtypes {Model::Classifier} as clf";
        this.verifyNegativeTest( query2 );

        String query3 = "select clf from Model::Classifier withoutsubtypes {Model::Associations} as clf";
        this.verifyNegativeTest( query3 );
    }
}
