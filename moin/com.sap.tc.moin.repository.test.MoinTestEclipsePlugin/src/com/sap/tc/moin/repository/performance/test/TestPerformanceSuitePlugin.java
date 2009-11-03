package com.sap.tc.moin.repository.performance.test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.performance.test.build.TestPerfBuild;
import com.sap.tc.moin.repository.performance.test.events.TestPerfEvents;
import com.sap.tc.moin.repository.test.performance.TestPerfConnections;
import com.sap.tc.moin.repository.test.performance.TestPerfMemoryLink;
import com.sap.tc.moin.repository.test.performance.TestPerfMofStandard;
import com.sap.tc.moin.repository.test.performance.TestPerfMoinExtensions;
import com.sap.tc.moin.repository.test.performance.TestPerfMoinScenario;
import com.sap.tc.moin.repository.test.performance.TestPerfOCL;
import com.sap.tc.moin.repository.test.performance.TestPerfPartitionHandling;
import com.sap.tc.moin.repository.test.performance.TestPerfQuery;
import com.sap.tc.moin.repository.test.performance.TestPerfSamePartitionLoadedIntoMultipleSessions;
import com.sap.tc.moin.repository.test.performance.TestPerfXm;

/**
 * Test Suite for executing all MOIN performance tests in Eclipse
 * 
 * @author d036732
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestPerfMofStandard.class, TestPerfMoinExtensions.class, TestPerfOCL.class,
//TestPerfMassContent.class, 
    TestPerfQuery.class,
    TestPerfBuild.class,
    TestPerfMoinScenario.class,
    TestPerfMemoryLink.class,
    TestPerfEvents.class,
    TestPerfSamePartitionLoadedIntoMultipleSessions.class,
    TestPerfXm.class,
    TestPerfConnections.class,
    TestPerfPartitionHandling.class } )
public class TestPerformanceSuitePlugin {

    @BeforeClass
    static public void beforeClass( ) {

        //MoinTestHelper.setTestConfigurationFile( "eclipseRuntimeTestConfiguration" );
    }

}
