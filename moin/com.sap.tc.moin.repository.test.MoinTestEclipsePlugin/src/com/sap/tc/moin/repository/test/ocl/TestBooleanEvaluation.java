package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on OclBoolean operations.
 */
public class TestBooleanEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testBooleansEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: true = true" );
        verify( evaluate( this.message, stmts ), "Booleans equal should be valid" );

        stmts = parse( "context Message inv: false = false" );
        verify( evaluate( this.message, stmts ), "Booleans equal should be valid" );

    }

    /**
     *
     */

    @Test
    public void testBooleansNotEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: true <> false" );
        verify( evaluate( this.message, stmts ), "Booleans not equal should be valid" );

        stmts = parse( "context Message inv: false <> true" );
        verify( evaluate( this.message, stmts ), "Booleans not equal should be valid" );

    }

    /**
     *
     */

    @Test
    public void testBooleansOr( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (false or false) = false" );
        verify( evaluate( this.message, stmts ), "Booleans OR should be valid" );

        stmts = parse( "context Message inv: false or true" );
        verify( evaluate( this.message, stmts ), "Booleans OR should be valid" );

        stmts = parse( "context Message inv: true or false" );
        verify( evaluate( this.message, stmts ), "Booleans OR should be valid" );

        stmts = parse( "context Message inv: true or true" );
        verify( evaluate( this.message, stmts ), "Booleans OR should be valid" );

        stmts = parse( "context Message " + "inv: true or self.reply_to.isFault" );
        verify( evaluate( this.message, stmts ), "true OR undefined should be true" );

        // the "infix" variety

        stmts = parse( "context Message inv: (true.or(false, false)) = false" );
        verify( evaluate( this.message, stmts ), "Booleans OR should be valid" );

        stmts = parse( "context Message inv: false.or(false, true)" );
        verify( evaluate( this.message, stmts ), "Booleans OR should be valid" );

        stmts = parse( "context Message inv: false.or(true, false)" );
        verify( evaluate( this.message, stmts ), "Booleans OR should be valid" );

        stmts = parse( "context Message inv: false.or(true, true)" );
        verify( evaluate( this.message, stmts ), "Booleans OR should be valid" );

        stmts = parse( "context Message " + "inv: false.or(true, self.reply_to.isFault)" );
        verify( evaluate( this.message, stmts ), "true OR undefined should be true" );
    }

    /**
     *
     */

    @Test
    public void testBooleansAnd( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (false and false) = false" );
        verify( evaluate( this.message, stmts ), "Booleans AND should be valid" );

        stmts = parse( "context Message inv: (false and true) = false" );
        verify( evaluate( this.message, stmts ), "Booleans AND should be valid" );

        stmts = parse( "context Message inv: (true and false) = false" );
        verify( evaluate( this.message, stmts ), "Booleans AND should be valid" );

        stmts = parse( "context Message inv: true and true" );
        verify( evaluate( this.message, stmts ), "Booleans AND should be valid" );

        stmts = parse( "context Message " + "inv: (false and self.reply_to.isFault) = false" );
        verify( evaluate( this.message, stmts ), "false AND undefined should be true" );

        // the "infix" variety 

        stmts = parse( "context Message inv: (true.and(false, false)) = false" );
        verify( evaluate( this.message, stmts ), "Booleans AND should be valid" );

        stmts = parse( "context Message inv: (true.and(false, true)) = false" );
        verify( evaluate( this.message, stmts ), "Booleans AND should be valid" );

        stmts = parse( "context Message inv: (true.and(true, false)) = false" );
        verify( evaluate( this.message, stmts ), "Booleans AND should be valid" );

        stmts = parse( "context Message inv: false.and(true, true)" );
        verify( evaluate( this.message, stmts ), "Booleans AND should be valid" );

        stmts = parse( "context Message " + "inv: (true.and(false, self.reply_to.isFault)) = false" );
        verify( evaluate( this.message, stmts ), "false AND undefined should be true" );
    }

    /**
     *
     */

    @Test
    public void testBooleansXor( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (false xor false) = false" );
        verify( evaluate( this.message, stmts ), "Booleans XOR should be valid" );

        stmts = parse( "context Message inv: false xor true" );
        verify( evaluate( this.message, stmts ), "Booleans XOR should be valid" );

        stmts = parse( "context Message inv: true xor false" );
        verify( evaluate( this.message, stmts ), "Booleans XOR should be valid" );

        stmts = parse( "context Message inv: (true xor true) = false" );
        verify( evaluate( this.message, stmts ), "Booleans XOR should be valid" );

        // the "infix" variety

        stmts = parse( "context Message inv: true.xor(false, false) = false" );
        verify( evaluate( this.message, stmts ), "Booleans XOR should be valid" );

        stmts = parse( "context Message inv: false.xor(false, true)" );
        verify( evaluate( this.message, stmts ), "Booleans XOR should be valid" );

        stmts = parse( "context Message inv: false.xor(true, false)" );
        verify( evaluate( this.message, stmts ), "Booleans XOR should be valid" );

        stmts = parse( "context Message inv: true.xor(true, true) = false" );
        verify( evaluate( this.message, stmts ), "Booleans XOR should be valid" );
    }

    /**
     *
     */

    @Test
    public void testBooleansNot( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: not false" );
        verify( evaluate( this.message, stmts ), "Booleans NOT should be valid" );

        stmts = parse( "context Message inv: not true = false" );
        verify( evaluate( this.message, stmts ), "Booleans NOT should be valid" );

        stmts = parse( "context Message inv: not false = true" );
        verify( evaluate( this.message, stmts ), "Booleans NOT should be valid" );

        stmts = parse( "context Message inv: not not true = true" );
        verify( evaluate( this.message, stmts ), "Booleans NOT should be valid" );

        stmts = parse( "context Message inv: not not false = false" );
        verify( evaluate( this.message, stmts ), "Booleans NOT should be valid" );

        stmts = parse( "context Message inv: not not true" );
        verify( evaluate( this.message, stmts ), "Booleans NOT should be valid" );
    }

    /**
     *
     */

    @Test
    public void testBooleansImplies( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: false implies false" );
        verify( evaluate( this.message, stmts ), "Booleans IMPLIES should be valid" );

        stmts = parse( "context Message inv: false implies true" );
        verify( evaluate( this.message, stmts ), "Booleans IMPLIES should be valid" );

        stmts = parse( "context Message inv: (true implies false) = false" );
        verify( evaluate( this.message, stmts ), "Booleans IMPLIES should be valid" );

        stmts = parse( "context Message inv: true implies true" );
        verify( evaluate( this.message, stmts ), "Booleans IMPLIES should be valid" );

        stmts = parse( "context Message " + "inv: false implies self.reply_to.isFault" );
        verify( evaluate( this.message, stmts ), "false IMPLIES undefined should be true" );
    }

}
