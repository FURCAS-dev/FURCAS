/*
 * Created on 07.03.2006
 */
package com.sap.tc.moin.repository.test.performance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.test.core.TestMofRom;

/**
 * @author d044711
 * @author D036732
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestPerfMofStandard.class, TestPerfMoinExtensions.class, TestPerfMassContent.class, TestPerfQuery.class, TestMofRom.class } )
public class TestSuiteAllPerformanceTests {

}