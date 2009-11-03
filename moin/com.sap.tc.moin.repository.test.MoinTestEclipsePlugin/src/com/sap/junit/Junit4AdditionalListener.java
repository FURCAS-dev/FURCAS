package com.sap.junit;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

@SuppressWarnings( "nls" )
public class Junit4AdditionalListener extends RunListener {

    public static String testName = "";

    public static Failure testFailures = null;

    @Override
    public void testStarted( Description description ) throws Exception {

        testName = description.getDisplayName( );
        super.testStarted( description );
    }

    @Override
    public void testFailure( Failure failure ) throws Exception {

        testFailures = failure;
        super.testFailure( failure );
    }

    @Override
    public void testFinished( Description description ) throws Exception {

        testName = description.getDisplayName( );
        super.testFinished( description );
    }

    public String getName( ) {

        return testName;
    }

    public Failure getFailures( ) {

        return testFailures;
    }

}
