package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on OclDouble operations.
 */
@SuppressWarnings( "nls" )
public class TestFloatEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testFloatEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (5.2).oclAsType(Float) = 5.2" );
        verify( evaluate( this.message, stmts ), "Float equal should be valid" );

    }


    /**
     *
     */
    @Test
    public void testFloatPlus( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (3.3).oclAsType(Float) + (2.1).oclAsType(Float) = (5.4).oclAsType(Float)" );
        verify( evaluate( this.message, stmts ), "Float plus should be valid" );

    }

    /**
     *
     */
    @Test
    public void testFloatMinus( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (5.5).oclAsType(Float) - (1.5).oclAsType(Float) = (4.0).oclAsType(Float)" );
        verify( evaluate( this.message, stmts ), "Float minus should be valid" );

    }

    /**
     *
     */
    @Test
    public void testFloatMultiply( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (2.0).oclAsType(Float) * (3.3).oclAsType(Float) = (6.6).oclAsType(Float)" );
        verify( evaluate( this.message, stmts ), "Float multiply should be valid" );
    }

    /**
     *
     */
    @Test
    public void testFloatDivide( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (6.6).oclAsType(Float) / (2.0).oclAsType(Float) = (3.3).oclAsType(Float)" );
        verify( evaluate( this.message, stmts ), "Float divide should be valid" );
    }

    /**
     *
     */
    @Test
    public void testFloatLessThan( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (3.6).oclAsType(Float) < (5.5).oclAsType(Float)" );
        verify( evaluate( this.message, stmts ), "Float less than should be valid" );

    }

    /**
     *
     */
    @Test
    public void testFloatGreaterThan( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (5.5).oclAsType(Float) > (3.6).oclAsType(Float)" );
        verify( evaluate( this.message, stmts ), "Float greater than should be valid" );

    }

    /**
     *
     */
    @Test
    public void testFloatLessThanOrEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (3.6).oclAsType(Float) <= (5.5).oclAsType(Float)" );
        verify( evaluate( this.message, stmts ), "Float less than or equal should be valid" );

    }

    /**
     *
     */
    @Test
    public void testFloatGreaterThanOrEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (5.5).oclAsType(Float) >= (3.6).oclAsType(Float)" );
        verify( evaluate( this.message, stmts ), "Float greater than or equal should be valid" );

    }

    /**
     *
     */
    @Test
    public void testFloatAbs( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let r:Float = (5.5).oclAsType(Float) in r.abs() = 5.5" );
        verify( evaluate( this.message, stmts ), "Positive Float abs() should be valid" );


    }

    /**
     *
     */
    @Test
    public void testFloatFloor( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let r:Float = (5.2).oclAsType(Float) in r.floor() = 5" );
        verify( evaluate( this.message, stmts ), "Low Positive Float floor() should be valid" );

    }

    /**
     *
     */
    @Test
    public void testFloatRound( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let r:Float = (5.4).oclAsType(Float) in r.round() = 5" );
        verify( evaluate( this.message, stmts ), "Low Positive Float round() should be valid" );

    }

    /**
     *
     */
    @Test
    public void testFloatMax( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let r:Float = (5.4).oclAsType(Float) in r.max((3.2).oclAsType(Float)) = 5.4" );
        verify( evaluate( this.message, stmts ), "Positive Float max() should be valid" );

        stmts = parse( "context Message inv: let r:Float = (-5.4).oclAsType(Float) in r.max((-3.2).oclAsType(Float)) = -3.2" );
        verify( evaluate( this.message, stmts ), "Negative Float max() should be valid" );

    }

    /**
     *
     */
    @Test
    public void testFloatMin( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let r:Float = (5.4).oclAsType(Float) in r.min((3.2).oclAsType(Float)) = 3.2" );
        verify( evaluate( this.message, stmts ), "Positive Float min() should be valid" );

    }
}
