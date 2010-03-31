package com.sap.tc.moin.repository.test.ocl.ia.performance;

import java.util.Set;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps.ClassScopeApplication;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps.InstanceScopeApplication;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps.NaiveApplication;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps.PartitionFilteredApplication;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps.UnfilteredApplication;
import com.sap.tc.moin.repository.test.ocl.ia.helper.PerformanceBaseTest;

/**
 * @author d022737
 */
public class IAPerformanceGetInstances extends PerformanceBaseTest {

    /**
     * 
     */
    public IAPerformanceGetInstances( ) {

        this.minIt = 10;
        this.maxIt = 10;
    }

    /**
     * The performance test logger
     */
    public final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, IAPerformanceGetInstances.class );

    /**
     * @throws Exception
     */
    @Test
    public void testUnfilteredApplication( ) throws Exception {

        Set<OclStatement> statements = this.classStatements;
        UnfilteredApplication app = new UnfilteredApplication( getTestHelper( ).getCoreConnection( getMOINConnection( ) ), statements, false );
        app.initialize( );
        this.performanceTest( app );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testPartitionFilteredApplication( ) throws Exception {

        Set<OclStatement> statements = this.classStatements;
        PartitionFilteredApplication app = new PartitionFilteredApplication( getTestHelper( ).getCoreConnection( getMOINConnection( ) ), statements, false );
        app.initialize( );
        this.performanceTest( app );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testNaiveApplication( ) throws Exception {

        Set<OclStatement> statements = this.classStatements;
        NaiveApplication app = new NaiveApplication( getTestHelper( ).getCoreConnection( getMOINConnection( ) ), statements, false );
        app.initialize( );
        this.performanceTest( app );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testInstanceScopeApplication( ) throws Exception {

        Set<OclStatement> statements = this.classStatements;
        InstanceScopeApplication app = new InstanceScopeApplication( getTestHelper( ).getCoreConnection( getMOINConnection( ) ), statements, false );
        app.initialize( );
        this.performanceTest( app );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testClassScopeApplication( ) throws Exception {

        Set<OclStatement> statements = this.classStatements;
        ClassScopeApplication app = new ClassScopeApplication( getTestHelper( ).getCoreConnection( getMOINConnection( ) ), statements, false );
        app.initialize( );
        this.performanceTest( app );
    }

}
