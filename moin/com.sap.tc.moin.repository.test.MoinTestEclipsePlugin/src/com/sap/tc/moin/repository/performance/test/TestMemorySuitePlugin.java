package com.sap.tc.moin.repository.performance.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.test.performance.TestPerfMemoryLink;
import com.sap.tc.moin.repository.test.performance.TestPerfMoinScenario;


@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestPerfMoinScenario.class, TestPerfMemoryLink.class } )
public class TestMemorySuitePlugin {



}
