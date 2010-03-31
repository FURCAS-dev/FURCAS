package com.sap.tc.moin.xm.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestMc.class, XmCpsTestSuite.class } )
public class XmTestSuite {

//    @BeforeClass
//    static public void beforeClass( ) {
//
//        MoinLoggerFactory.setAllLocationsToDebug( );
//
//    }

}
