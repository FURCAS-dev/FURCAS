/*
 * Created on 07.03.2006
 */
package com.sap.tc.moin.repository.test.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

/**
 * @author d044711
 */
@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestPartitionAssignment.class, TestPartitionDeleting.class, TestDuplicatePartitionCreation.class }

)
public class TestSuitePartitions {

}