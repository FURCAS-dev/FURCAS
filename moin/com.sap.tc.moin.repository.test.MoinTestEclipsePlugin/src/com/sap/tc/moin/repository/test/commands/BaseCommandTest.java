package com.sap.tc.moin.repository.test.commands;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.commands.CommandStackImpl;
import com.sap.tc.moin.repository.core.transactions.TransactionManagerImpl;
import com.sap.tc.moin.repository.spi.core.SpiEventManager;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;


/**
 * Basis Test class for Commands tests, that uses a Mock Connection & a Mock
 * Session to test the internal cmd fmwk logic, without repository
 * modifications.
 * 
 * @author d045996
 */
public class BaseCommandTest extends CoreMoinTest {

    protected CommandStack stack;

    protected CommandStackImpl stackImpl;

    protected TransactionManagerImpl txManager;

    protected SpiEventManager evManager;

    protected SpiEventManager mem;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        stack = getMOINConnection( ).getCommandStack( );

        // Activate Mock Transactions to test Command Stack
        CoreConnection connection = getTestHelper( ).getCoreConnection( this.getMOINConnection( ) );
        CoreSession session = (CoreSession) connection.getSession( );
        txManager = (TransactionManagerImpl) session.getTransactionManager( );
        stackImpl = (CommandStackImpl) connection.getCommandStack( );
        evManager = session.getEventManager( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        stack = null;
        stackImpl = null;
        txManager = null;
        evManager = null;
        mem = null;
        super.afterTestMethod( );
    }

}
