package com.sap.tc.moin.test.fw;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

@SuppressWarnings( { "unchecked", "nls" } )
public class MoinTestHelperSelector {

    /**
     * 
     */
    private static final String DEFAULT_TEST_HELPER_CLASSNAME = "com.sap.tc.moin.test.fw.ide.IdeProductiveTestHelperImpl";

    private static MoinTestHelper _instance;

    private static MoinLogger testLogger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, MoinTestHelperSelector.class );

    public static synchronized MoinTestHelper getScenarioSpecificTestHelper( ) {

        if ( _instance == null ) {
            /*
             * THE RIGHT TEST HELPER MIGHT BE DETERMINED BY A SYSTEM PARAMETER
             */
            String scenario = System.getProperty( MoinTestHelper.TEST_SCENARIO_KEY );
            String testHelperClassName = null;
            Class helper = null;

            if ( scenario == null ) {
                //Only needed for compatibility, as the parameter is not yet published
                testLogger.trace( MoinSeverity.INFO, "No test helper/scenario set - using default: " + DEFAULT_TEST_HELPER_CLASSNAME );
                testHelperClassName = DEFAULT_TEST_HELPER_CLASSNAME;
            } else if ( scenario.equals( "IdeProductive" ) ) {
                testHelperClassName = DEFAULT_TEST_HELPER_CLASSNAME;
            } else {
                // general case: fully qualified name of test helper is set as scenario parameter
                testHelperClassName = scenario;
            }

            // try to load the test helper class
            try {
                helper = Class.forName( testHelperClassName );
            } catch ( Exception e ) {
                testLogger.trace( MoinSeverity.ERROR, e.getMessage( ) );
                throw new RuntimeException( "Failed to load class for test helper. Scenario: " + scenario + ", classname: " + testHelperClassName, e );
            }

            // try to instantiate the test helper
            try {
                _instance = (MoinTestHelper) helper.newInstance( );
                //                return (MoinTestHelper) helper.getMethod( "getInstance", new Class[0] ).invoke( helper, new Object[0] );
            } catch ( IllegalAccessException e ) {
                testLogger.trace( MoinSeverity.ERROR, e.getMessage( ) );
                throw new RuntimeException( e );
            } catch ( IllegalArgumentException e ) {
                testLogger.trace( MoinSeverity.ERROR, e.getMessage( ) );
                throw new RuntimeException( e );
            } catch ( SecurityException e ) {
                testLogger.trace( MoinSeverity.ERROR, e.getMessage( ) );
                throw new RuntimeException( e );
            } catch ( InstantiationException e ) {
                testLogger.trace( MoinSeverity.ERROR, e.getMessage( ) );
                throw new RuntimeException( e );
            }
        }
        return _instance;
    }
}
