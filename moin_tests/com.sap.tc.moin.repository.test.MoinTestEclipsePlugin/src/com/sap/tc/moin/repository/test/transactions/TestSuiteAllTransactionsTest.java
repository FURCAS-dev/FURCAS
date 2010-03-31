package com.sap.tc.moin.repository.test.transactions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.test.transactions.microtransactionables.TestSuiteAllMicroTransactionablesTests;

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( { TestMicroTransactions.class, TestRecordCombination.class, TestTransactionComposition.class, TestSuiteAllMicroTransactionablesTests.class } )
public class TestSuiteAllTransactionsTest {
}
