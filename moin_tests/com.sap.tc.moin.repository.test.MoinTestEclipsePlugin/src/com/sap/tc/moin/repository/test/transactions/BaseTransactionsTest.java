package com.sap.tc.moin.repository.test.transactions;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.transactions.TransactionManagerImpl;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.MoinTestHelper;

/**
 * Basis Test class for Transactions tests, that uses a Mock Connection & a Mock
 * Session to test the internal tx fmwk logic, without repository modifications.
 * 
 * @author d045996
 */
public class BaseTransactionsTest extends CoreMoinTest {

    TransactionManagerImpl txManager;

    SynchronizationManager syncMan;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        Connection connection = getMOINConnection( );
        MoinTestHelper moinHelper = getTestHelper( );
        CoreConnection coreConnection = moinHelper.getCoreConnection( connection );
        CoreSession session = coreConnection.getSession( );
        txManager = (TransactionManagerImpl) session.getTransactionManager( );
        syncMan = getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ).getWorkspaceSet( ).getSynchronizationManager( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        txManager = null;
        syncMan = null;
        super.afterTestMethod( );

    }


}
