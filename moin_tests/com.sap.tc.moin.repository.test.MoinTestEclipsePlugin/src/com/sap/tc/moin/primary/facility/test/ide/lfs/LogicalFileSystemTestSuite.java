package com.sap.tc.moin.primary.facility.test.ide.lfs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { // comment for smarter formatting 
TestEclLogicalFsFactory.class, // comment for smarter formatting
    TestEclLogicalFile.class,
    TestEclLogicalFolder.class,
    TestJavaioLogicalFsFactory.class,
    TestJavaioLogicalFile.class,
    TestJavaioLogicalFolder.class } )
public class LogicalFileSystemTestSuite {

}
