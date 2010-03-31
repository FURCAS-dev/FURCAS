package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on the evaluation of TupleLiteral expressions
 */
public class TestTupleLiteralEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testTupleWithLiterals( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let myTuple: Tuple(i:Integer, s:String, j: Integer) = " + "Tuple {i = 5, s = 'myString', j = 8} in " + "myTuple.i = 5 and " + "myTuple.s = 'myString' and " + "myTuple.j = 8" );

        verify( evaluate( this.message, stmts ), "Tuple with literals should be valid" );
    }

    /**
     *
     */

    @Test
    public void testTupleDifferentOrder( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let myTuple: Tuple(i:Integer, s:String, j: Integer) = " + "Tuple {s = 'myString', j = 8, i = 5} in " + "myTuple.i = 5 and " + "myTuple.s = 'myString' and " + "myTuple.j = 8" );

        verify( evaluate( this.message, stmts ), "Tuple with literals should be valid" );
    }

    /**
     *
     */

    @Test
    public void testTupleWithExpressions( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let myString: String = 'myString' in " + "let myTuple: Tuple(i:Integer, s:String, j:Integer) = " + "Tuple {i = (3 + 2), s = myString, j = myString.size()} in " + "myTuple.i = 5 and " + "myTuple.s = 'myString' and "
                                                + "myTuple.j = 8" );

        verify( evaluate( this.message, stmts ), "Tuple with expressions should be valid" );
    }

    /**
     *
     */

    @Test
    public void testTupleUndefined( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: Tuple {i = 5/0}.oclIsInvalid()" );
        verify( evaluate( this.message, stmts ), "Tuple with undefined part should be invalid" );
    }
}
