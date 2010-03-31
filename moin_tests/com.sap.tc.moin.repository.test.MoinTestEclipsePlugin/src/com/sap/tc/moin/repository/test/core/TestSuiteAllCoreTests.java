/*
 * Created on 07.03.2006
 */
package com.sap.tc.moin.repository.test.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.test.TestModelDataInstantiator;
import com.sap.tc.moin.repository.test.inconsistency.TestSuiteAllInconsistencyTests;
import com.sap.tc.moin.repository.test.persistence.TestModelPersistence;

/**
 * @author d044711
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestSuiteCoreSmokeTests.class,
// add all non core smoke tests
    TestFacilityLocking.class,
    TestLinkStorageDetection.class,
    TestNotifyingWeakHashMap.class,
    // Commented out since static object valued attributes are not support
    // TODO clean up test case required
    // TestStaticObjectValuedAttribute.class,
    TestWrappers.class,
    TestModelPersistence.class,
    TestModelDataInstantiator.class,
    TestTransientDataArea.class,
    TestSuiteAllInconsistencyTests.class,
    TestRefBaseObjectDummy.class,
    TestSegmentedMofId.class,
    TestUtilMetamodel.class } )
public class TestSuiteAllCoreTests {

}