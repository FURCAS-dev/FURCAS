package com.sap.tc.moin.facility.primary.test.index.fs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.facility.primary.test.index.TestIndexOverwrittenMethodsInIndexImpl;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestIndexDumpFs.class, TestIndexOverwrittenMethodsInIndexImpl.class } )
public class TestIndexFsSuite {

}
