package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import org.junit.Test;

import com.sap.tc.moin.testcases.case009.ClassThrowsException;
import com.sap.tc.moin.testcases.case009.Ex9Exception;
import com.sap.tc.moin.testcases.case009.Fx9Exception;
import com.sap.tc.moin.testcases.case011.A11;
import com.sap.tc.moin.testcases.case012.A12;
import com.sap.tc.moin.testcases.case012.D12;

@SuppressWarnings( "nls" )
public class TestMicroTransactionablesModeledOperations extends BaseMicroTransactionablesTest {

    @Test
    public void testOperationsWithObjectParameters( ) {

        // we test the wrapping and unwrapping of the parameters of modeled operations
        A12 a12 = (A12) a12Class.refCreateInstance( );
        D12 d12 = (D12) d12Class.refCreateInstance( );
        try {
            a12 = a12.operationWithThisAsReturnParameter( );
        } catch ( Exception ex ) {
            errorAndStop( "Error when calling method \"operationWithThisAsReturnParameter\"", ex );
        }
        try {
            d12 = a12.operationWithObjectParameters( d12 );
        } catch ( Exception ex ) {
            errorAndStop( "Error when calling method \"operationWithObjectParameters\"", ex );
        }
        a12.setAttributeD12( d12 );
        try {
            d12 = a12.operationGetAttributeD12( );
        } catch ( Exception ex ) {
            errorAndStop( "Error when calling method \"operationGetAttributeC14\"", ex );
        }
    }

    @Test
    public void testNonChangingOperationWithException( ) {

        // we have an operation that can throw 2 exceptions, let us test both of them
        ClassThrowsException cte = getMOINConnection( ).createElementInPartition( ClassThrowsException.class, null );
        try {
            // throw Ex9
            cte.operationThrowsEx9AndFx9( true, false );
        } catch ( Ex9Exception ex ) {
        } catch ( Exception ex ) {
            errorAndStop( "Error when calling method \"operationThrowsEx9AndFx9\"", ex );
        }
        try {
            // throw Fx9
            cte.operationThrowsEx9AndFx9( false, true );
        } catch ( Fx9Exception ex ) {
        } catch ( Exception ex ) {
            errorAndStop( "Error when calling method \"operationThrowsEx9AndFx9\"", ex );
        }
    }

    @Test
    public void testChangingOperationWithoutException( ) {

        // we change the 2 attributes "attribute1" and "attribute2" via one call of the modeled operation "callMultipleSetter"
        // the call does not throw an exception between the changes of "attribute1" and "attribute2", so that the
        // attributes are both changed afterwards
        A11 a11 = (A11) a11Class.refCreateInstance( );
        a11.setAttribute1( "attribute1Initial" );
        a11.setAttribute2( "attribute2Initial" );
        a11.callMultipleSetter( false, "attribute1Changed", "attribute2Changed" );
        assertFalse( "The attribute \"attribute1\" should have been changed, but it hasn't.", a11.getAttribute1( ).equals( "attribute1Initial" ) );
        assertFalse( "The attribute \"attribute2\" should have been changed, but it hasn't.", a11.getAttribute2( ).equals( "attribute2Initial" ) );
    }

    @Test
    public void testChangingOperationWithException( ) {

        // we have a changing operation that can throw 2 exceptions, let us test both of them
        // note that changing operations go through transactions
        ClassThrowsException cte = getMOINConnection( ).createElementInPartition( ClassThrowsException.class, null );
        try {
            try {
                // throw WrongSizeException, the operation has 2 arguments
                cte.refInvokeOperation( "changingOperationThrowsEx9AndFx9", null );
            } catch ( WrongSizeException ex ) {
            }
            try {
                // throw Ex9
                cte.changingOperationThrowsEx9AndFx9( true, false );
            } catch ( Ex9Exception ex ) {
            }
            try {
                // throw Fx9
                cte.changingOperationThrowsEx9AndFx9( false, true );
            } catch ( Fx9Exception ex ) {
            }
        } catch ( Exception ex ) {
            errorAndStop( "Error when calling method \"changingOperationThrowsEx9AndFx9\"", ex );
        }
    }

    @Test
    public void testChangingOperationWithRollback( ) {

        // we change the 2 attributes "attribute1" and "attribute2" via one call of the modeled operation "callMultipleSetter"
        // the call throws an exception between the changes of "attribute1" and "attribute2", so that
        // "attribute1" is changed and "attribute2" not
        A11 a11 = (A11) a11Class.refCreateInstance( );
        a11.setAttribute1( "attribute1Initial" );
        a11.setAttribute2( "attribute2Initial" );
        try {
            a11.callMultipleSetter( true, "attribute1Changed", "attribute2Changed" );
            errorAndStop( "The call should have thrown a RuntimeException, but hasn't." );
        } catch ( RuntimeException runtimeEx ) {
        }
        assertTrue( "The attribute \"attribute1\" should not have been changed, but it has.", a11.getAttribute1( ).equals( "attribute1Initial" ) );
        assertTrue( "The attribute \"attribute2\" should not have been changed, but it has.", a11.getAttribute2( ).equals( "attribute2Initial" ) );
    }
}
