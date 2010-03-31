/*
 * Created on 27.07.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import org.junit.Test;

import com.sap.tc.moin.testcases.case014.A14;

/**
 * @author D044784
 */
public class TestRefInvokeOperation extends CoreMoinTest {

    @Test
    public void testRefInvokeOperationCorrectArguments( ) throws RefException {

        A14 element = getMOINConnection( ).createElementInPartition( A14.class, null );
        Object result = element.refInvokeOperation( "operationJavaReturnInt", Collections.emptyList( ) );
        assertTrue( "Expected result to be 42", result.equals( 42 ) );
    }

    @Test
    public void testRefInvokeOperationWrongArgumentsSize( ) throws RefException {

        try {
            A14 element = getMOINConnection( ).createElementInPartition( A14.class, null );
            element.refInvokeOperation( "operationJavaReturnInt", Collections.singletonList( "Test" ) );
            flop( "Arguments have wrong size, WrongSizeException should have been thrown" );
        } catch ( WrongSizeException ex ) {
            // as expected
        }
    }

    @Test
    public void testRefInvokeOperationWrongArgumentType( ) throws RefException {

        try {
            MofClass cls = getMOINConnection( ).createElementInPartition( MofClass.class, null );
            cls.refInvokeOperation( "lookupElement", Collections.singletonList( true ) );
            fail( "Argument has wrong type, TypeMismatchException should have been thrown" );
        } catch ( TypeMismatchException ex ) {
            // as expected
        }
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testRefInvokeOperationWithArrayType( ) throws RefException {

        MofClass cls = getMOINConnection( ).createElementInPartition( MofClass.class, null );
        List args = new ArrayList( 2 );
        args.add( cls );
        args.add( new String[] { "some", "string", "array" } );
        cls.refInvokeOperation( "isRequiredBecause", args );
    }

    @Test
    public void testRefInvokeOperationWithNullArg( ) throws Exception {

        MofClass mofClass = getMOINConnection( ).createElementInPartition( MofClass.class, null );
        List<Object> args = new ArrayList<Object>( 1 );
        args.add( null );
        mofClass.refInvokeOperation( "isVisible", args );
    }

    @Test( expected = com.sap.tc.moin.repository.mmi.reflect.WrongSizeException.class )
    public void testRefInvokeOperationWithWrongArgCount( ) throws Exception {

        MofClass mofClass = getMOINConnection( ).createElementInPartition( MofClass.class, null );
        List<Object> args = new ArrayList<Object>( 3 );
        args.add( null );
        args.add( null );
        args.add( null );
        mofClass.refInvokeOperation( "findRequiredElements", args );
    }

    @Test( expected = com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException.class )
    public void testRefInvokeOperationWithWrongArgType( ) throws Exception {

        MofClass mofClass = getMOINConnection( ).createElementInPartition( MofClass.class, null );
        List<Object> args = new ArrayList<Object>( 2 );
        args.add( new Object( ) );
        args.add( new Object( ) );
        mofClass.refInvokeOperation( "findRequiredElements", args );
    }
}