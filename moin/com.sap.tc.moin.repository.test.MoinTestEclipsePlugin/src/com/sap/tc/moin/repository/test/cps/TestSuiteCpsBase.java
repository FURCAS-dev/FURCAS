/*
 * Created on 07.03.2006
 */
package com.sap.tc.moin.repository.test.cps;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

/**
 * @author d026715
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestErrorHandlerRegistry.class, TestRegistrationParsers.class, TestPriPatternRegistry.class, TestErrorHandlerArchiveRegistration.class, TestCustomParserArchiveRegistration.class, TestCustomParserSerializerSpi.class }

)
public class TestSuiteCpsBase {

}
