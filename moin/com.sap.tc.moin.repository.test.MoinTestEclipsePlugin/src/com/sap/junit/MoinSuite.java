package com.sap.junit;

import org.junit.internal.runners.InitializationError;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Suite;

import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.MoinTestHelperSelector;


public class MoinSuite extends Suite implements RunnerProxy {

    public MoinSuite( Class<?> klass ) throws InitializationError {

        super( klass );
        TestHelper testHelper = klass.getAnnotation( TestHelper.class );
        if ( testHelper != null ) {
            System.setProperty( MoinTestHelper.TEST_SCENARIO_KEY, testHelper.value( ) );
        }
    }

    @Override
    public void run( RunNotifier notifier ) {

        MoinTestHelperSelector.getScenarioSpecificTestHelper( ).setTestExecutionEnvironment( this, notifier );
    }

    public void realRun( RunNotifier notifier ) {

        super.run( notifier );
    }
}
