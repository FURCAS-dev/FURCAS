/*
 * Created on 07.03.2006
 */
package com.sap.tc.moin.repository.test.inconsistency;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

/**
 * @author d044711
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestInconsistencyBasicStuff.class, //
    TestInconsistencyFixing.class,
    TestInconsistencyCorrectionHandles.class,
    TestInconsistencySynchronization.class,
    TestInconsistencyCorrectionWithUndo.class,
    TestInconsistencyListeners.class,
    TestInconsistencyBehavior.class } )
public class TestSuiteAllInconsistencyTests {

}