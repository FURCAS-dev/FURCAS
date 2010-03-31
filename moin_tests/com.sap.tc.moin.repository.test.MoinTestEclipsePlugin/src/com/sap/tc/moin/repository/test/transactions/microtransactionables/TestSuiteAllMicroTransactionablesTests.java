package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( {
//
    TestMicroTransactionablesDataTypeAttributes.class,
    TestMicroTransactionablesObjectAttributes.class,
    TestMicroTransactionablesReferences.class,
    TestMicroTransactionablesElementAssignToPartition.class,
    TestMicroTransactionablesAssociations.class,
    TestMicroTransactionablesPartitionables.class,
    TestMicroTransactionablesPartition.class,
    TestMicroTransactionablesModeledOperations.class,
    TestMicroTransactionablesDeleteElementIsolated.class,
    TestMicroTransactionablesComposedTransactions.class } )
public class TestSuiteAllMicroTransactionablesTests {
}
