package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on OclInteger operations.
 */
public class TestIntegerEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testIntegersEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 5 = 5" );
        verify( evaluate( this.message, stmts ), "Positive Integers equal should be valid" );

        stmts = parse( "context Message inv: 0 = 0" );
        verify( evaluate( this.message, stmts ), "Zero equal should be valid" );

        stmts = parse( "context Message inv: -5 = -5" );
        verify( evaluate( this.message, stmts ), "Negative Integers equal should be valid" );

        // infix

        stmts = parse( "context Message inv: (10).=(-5, -5)" );
        verify( evaluate( this.message, stmts ), "Negative Integers equal should be valid" );

    }

    /**
     *
     */
    @Test
    public void testIntegersNotEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 5 <> 4" );
        verify( evaluate( this.message, stmts ), "Integers not equal should be valid" );

        stmts = parse( "context Message inv: 5 <> -5" );
        verify( evaluate( this.message, stmts ), "Integers not equal should be valid" );

        // infix

        stmts = parse( "context Message inv: (10).<>(5, -5)" );
        verify( evaluate( this.message, stmts ), "Integers not equal should be valid" );

    }

    /**
     *
     */
    @Test
    public void testIntegersPlus( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 3 + 2 = 5" );
        verify( evaluate( this.message, stmts ), "Integers plus should be valid" );

        stmts = parse( "context Message inv: -3 + 2 = -1" );
        verify( evaluate( this.message, stmts ), "Integers plus should be valid" );

        // infix

        stmts = parse( "context Message inv: (10).+(-3, 2) = -1" );
        verify( evaluate( this.message, stmts ), "Integers plus should be valid" );

    }

    /**
     *
     */
    @Test
    public void testIntegersMinus( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 5 - 3 = 2" );
        verify( evaluate( this.message, stmts ), "Integers minus should be valid" );

        stmts = parse( "context Message inv: -5 - 3 = -8" );
        verify( evaluate( this.message, stmts ), "Integers minus should be valid" );

    }

    /**
     *
     */
    @Test
    public void testIntegersMultiply( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 2 * 3 = 6" );
        verify( evaluate( this.message, stmts ), "Integers multiply should be valid" );

        stmts = parse( "context Message inv: 2 * -3 = -6" );
        verify( evaluate( this.message, stmts ), "Integers multiply should be valid" );

        stmts = parse( "context Message inv: -2 * -3 = 6" );
        verify( evaluate( this.message, stmts ), "Integers multiply should be valid" );

        // infix

        stmts = parse( "context Message inv: (5).*(-2, -3) = 6" );
        verify( evaluate( this.message, stmts ), "Integers multiply should be valid" );

    }

    /**
     *
     */
    @Test
    public void testIntegersDivide( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 6 / 4 = 1.5" );
        verify( evaluate( this.message, stmts ), "Integers divide should be valid" );

        stmts = parse( "context Message inv: 6 / -4 = -1.5" );
        verify( evaluate( this.message, stmts ), "Integers divide should be valid" );

        stmts = parse( "context Message inv: -6 / 4 = -1.5" );
        verify( evaluate( this.message, stmts ), "Integers divide should be valid" );

        stmts = parse( "context Message inv: -6 / -4 = 1.5" );
        verify( evaluate( this.message, stmts ), "Integers divide should be valid" );

        // infix

        stmts = parse( "context Message inv: (5)./(-6, -4) = 1.5" );
        verify( evaluate( this.message, stmts ), "Integers divide should be valid" );

    }

    /**
     *
     */
    @Test
    public void testIntegersLessThan( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 3 < 5" );
        verify( evaluate( this.message, stmts ), "Integers less than should be valid" );

        stmts = parse( "context Message inv: -5 < 3" );
        verify( evaluate( this.message, stmts ), "Integers less than should be valid" );

        // infix

        stmts = parse( "context Message inv: (10).<(-5, 3)" );
        verify( evaluate( this.message, stmts ), "Integers less than should be valid" );

    }

    /**
     *
     */
    @Test
    public void testIntegersGreaterThan( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 5 > 3" );
        verify( evaluate( this.message, stmts ), "Integers greater than should be valid" );

        stmts = parse( "context Message inv: 3 > -5" );
        verify( evaluate( this.message, stmts ), "Integers greater than should be valid" );

        // infix

        stmts = parse( "context Message inv: (10).>(3, -5)" );
        verify( evaluate( this.message, stmts ), "Integers greater than should be valid" );

    }

    /**
     *
     */
    @Test
    public void testIntegersLessThanOrEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 3 <= 5" );
        verify( evaluate( this.message, stmts ), "Integers less than or equal should be valid" );

        stmts = parse( "context Message inv: 5 <= 5" );
        verify( evaluate( this.message, stmts ), "Integers less than or equal should be valid" );

        stmts = parse( "context Message inv: -5 <= 3" );
        verify( evaluate( this.message, stmts ), "Integers less than or equal should be valid" );

        stmts = parse( "context Message inv: -5 <= -5" );
        verify( evaluate( this.message, stmts ), "Integers less than or equal should be valid" );

        // infix

        stmts = parse( "context Message inv: (10).<=(-5, -5)" );
        verify( evaluate( this.message, stmts ), "Integers less than or equal should be valid" );

    }

    /**
     *
     */
    @Test
    public void testIntegersGreaterThanOrEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 5 >= 3" );
        verify( evaluate( this.message, stmts ), "Integers greater than or equal should be valid" );

        stmts = parse( "context Message inv: 5 >= 5" );
        verify( evaluate( this.message, stmts ), "Integers greater than or equal should be valid" );

        stmts = parse( "context Message inv: 3 >= -5" );
        verify( evaluate( this.message, stmts ), "Integers greater than or equal should be valid" );

        stmts = parse( "context Message inv: -5 >= -5" );
        verify( evaluate( this.message, stmts ), "Integers greater than or equal should be valid" );

        // infix

        stmts = parse( "context Message inv: (10).>=(-5, -5)" );
        verify( evaluate( this.message, stmts ), "Integers greater than or equal should be valid" );

    }

    /**
     *
     */
    @Test
    public void testIntegerAbs( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let i:Integer = 5 in i.abs() = 5" );
        verify( evaluate( this.message, stmts ), "Positive Integer abs() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -5 in i.abs() = 5" );
        verify( evaluate( this.message, stmts ), "Negative Integer abs() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = 0 in i.abs() = 0" );
        verify( evaluate( this.message, stmts ), "Zero abs() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIntegerMax( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let i:Integer = 5 in i.max(3) = 5" );
        verify( evaluate( this.message, stmts ), "Positive Integer max() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -5 in i.max(-3) = -3" );
        verify( evaluate( this.message, stmts ), "Negative Integer max() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -5 in i.max(3) = 3" );
        verify( evaluate( this.message, stmts ), "Mixed Integer max() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIntegerMin( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let i:Integer = 5 in i.min(3) = 3" );
        verify( evaluate( this.message, stmts ), "Positive Integer min() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -5 in i.min(-3) = -5" );
        verify( evaluate( this.message, stmts ), "Negative Integer min() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -5 in i.min(3) = -5" );
        verify( evaluate( this.message, stmts ), "Mixed Integer min() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIntegerDiv( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let i:Integer = 7 in (i.intDivStdLib(2)) = 3" );
        verify( evaluate( this.message, stmts ), "Positive Integer div() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -8 in (i.intDivStdLib(2)) = -4" );
        verify( evaluate( this.message, stmts ), "Mixed Integer div() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = 10 in (i.intDivStdLib(-3)) = -3" );
        verify( evaluate( this.message, stmts ), "Mixed Integer div() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -11 in (i.intDivStdLib(-3)) = 3" );
        verify( evaluate( this.message, stmts ), "Negative Integer div() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -11 in (i.intDivStdLib(0)).oclIsInvalid()" );
        verify( evaluate( this.message, stmts ), "Zero Integer div() should be undefined" );
    }

    /**
     *
     */
    @Test
    public void testIntegerMod( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let i:Integer = 7 in i.mod(2) = 1" );
        verify( evaluate( this.message, stmts ), "Positive Integer mod() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = 9 in i.mod(3) = 0" );
        verify( evaluate( this.message, stmts ), "Positive Integer mod() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = 10 in i.mod(-3) = 1" );
        verify( evaluate( this.message, stmts ), "Positive/negative mod() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -7 in i.mod(2) = -1" );
        verify( evaluate( this.message, stmts ), "Negative/positive should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -11 in i.mod(-3) = -2" );
        verify( evaluate( this.message, stmts ), "Negative Integer mod() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Integer = -11 in i.mod(0).oclIsInvalid()" );
        verify( evaluate( this.message, stmts ), "Zero Integer mod() should be undefined" );
    }
}
