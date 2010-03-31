package com.sap.tc.moin.repository.test.ocl;

import org.junit.Test;
import java.util.Collection;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on OclDouble operations.
 */
public class TestDoubleEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testDoublesEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 5.2 = 5.2" );
        verify( evaluate( this.message, stmts ), "Doubles equal should be valid" );

        stmts = parse( "context Message inv: 0.0 = 0.0" );
        verify( evaluate( this.message, stmts ), "Doubles equal should be valid" );

        stmts = parse( "context Message inv: -5.2 = -5.2" );
        verify( evaluate( this.message, stmts ), "Doubles equal should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoublesNotEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 5.1 <> 5.2" );
        verify( evaluate( this.message, stmts ), "Doubles not equal should be valid" );

        stmts = parse( "context Message inv: 5.2 <> -5.2" );
        verify( evaluate( this.message, stmts ), "Doubles not equal should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoublesPlus( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 3.3 + 2.1 = 5.4" );
        verify( evaluate( this.message, stmts ), "Doubles plus should be valid" );

        stmts = parse( "context Message inv: -3.2 + 2.1 = -1.1" );
        verify( evaluate( this.message, stmts ), "Doubles plus should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoublesMinus( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 5.5 - 1.5 = 4.0" );
        verify( evaluate( this.message, stmts ), "Doubles minus should be valid" );

        stmts = parse( "context Message inv: -5.5 - 1.5 = -7.0" );
        verify( evaluate( this.message, stmts ), "Doubles minus should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoublesMultiply( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 2.0 * 3.3 = 6.6" );
        verify( evaluate( this.message, stmts ), "Doubles multiply should be valid" );

        stmts = parse( "context Message inv: -2.0 * 3.3 = -6.6" );
        verify( evaluate( this.message, stmts ), "Doubles multiply should be valid" );

        stmts = parse( "context Message inv: -2.0 * -3.3 = 6.6" );
        verify( evaluate( this.message, stmts ), "Doubles multiply should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoublesDivide( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 6.6 / 2.0 = 3.3" );
        verify( evaluate( this.message, stmts ), "Doubles divide should be valid" );

        stmts = parse( "context Message inv: -6.6 / 2.0 = -3.3" );
        verify( evaluate( this.message, stmts ), "Doubles divide should be valid" );

        stmts = parse( "context Message inv: -6.6 / -2.0 = 3.3" );
        verify( evaluate( this.message, stmts ), "Doubles divide should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoublesLessThan( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 3.6 < 5.5" );
        verify( evaluate( this.message, stmts ), "Doubles less than should be valid" );

        stmts = parse( "context Message inv: -5.5 < 3.6" );
        verify( evaluate( this.message, stmts ), "Doubles less than should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoublesGreaterThan( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 5.5 > 3.6" );
        verify( evaluate( this.message, stmts ), "Doubles greater than should be valid" );

        stmts = parse( "context Message inv: 3.6 > -5.5" );
        verify( evaluate( this.message, stmts ), "Doubles greater than should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoublesLessThanOrEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 3.6 <= 5.5" );
        verify( evaluate( this.message, stmts ), "Doubles less than or equal should be valid" );

        stmts = parse( "context Message inv: 5.5 <= 5.5" );
        verify( evaluate( this.message, stmts ), "Doubles less than or equal should be valid" );

        stmts = parse( "context Message inv: -5.5 <= 3.6" );
        verify( evaluate( this.message, stmts ), "Doubles less than or equal should be valid" );

        stmts = parse( "context Message inv: -5.5 <= -5.5" );
        verify( evaluate( this.message, stmts ), "Doubles less than or equal should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoublesGreaterThanOrEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: 5.5 >= 3.6" );
        verify( evaluate( this.message, stmts ), "Doubles greater than or equal should be valid" );

        stmts = parse( "context Message inv: 5.5 >= 5.5" );
        verify( evaluate( this.message, stmts ), "Doubles greater than or equal should be valid" );

        stmts = parse( "context Message inv: 3.6 >= -5.5" );
        verify( evaluate( this.message, stmts ), "Doubles greater than or equal should be valid" );

        stmts = parse( "context Message inv: -5.5 >= -5.5" );
        verify( evaluate( this.message, stmts ), "Doubles greater than or equal should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoubleAbs( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let r:Double = 5.5 in r.abs() = 5.5" );
        verify( evaluate( this.message, stmts ), "Positive Double abs() should be valid" );

        stmts = parse( "context Message " + "inv: let r:Double = -5.5 in r.abs() = 5.5" );
        verify( evaluate( this.message, stmts ), "Negative Double abs() should be valid" );

        stmts = parse( "context Message " + "inv: let r:Double = 0.0 in r.abs() = 0.0" );
        verify( evaluate( this.message, stmts ), "Zero abs() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoubleFloor( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let r:Double = 5.2 in r.floor() = 5" );
        verify( evaluate( this.message, stmts ), "Low Positive Double floor() should be valid" );

        stmts = parse( "context Message inv: let r:Double = 5.8 in r.floor() = 5" );
        verify( evaluate( this.message, stmts ), "High Positive Double floor() should be valid" );

        stmts = parse( "context Message inv: let r:Double = 5.0 in r.floor() = 5" );
        verify( evaluate( this.message, stmts ), "Even Positive Double floor() should be valid" );

        stmts = parse( "context Message inv: let r:Double = -5.2 in r.floor() = -6" );
        verify( evaluate( this.message, stmts ), "High Negative Double floor() should be valid" );

        stmts = parse( "context Message inv: let r:Double = -5.8 in r.floor() = -6" );
        verify( evaluate( this.message, stmts ), "Low Negative Double floor() should be valid" );

        stmts = parse( "context Message inv: let r:Double = -5.0 in r.floor() = -5" );
        verify( evaluate( this.message, stmts ), "Even Negative Double floor() should be valid" );

        stmts = parse( "context Message inv: let r:Double = 0.0 in r.floor() = 0" );
        verify( evaluate( this.message, stmts ), "Zero floor() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoubleRound( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let r:Double = 5.4 in r.round() = 5" );
        verify( evaluate( this.message, stmts ), "Low Positive Double round() should be valid" );

        stmts = parse( "context Message inv: let r:Double = 5.5 in r.round() = 6" );
        verify( evaluate( this.message, stmts ), "High Positive Double round() should be valid" );

        stmts = parse( "context Message inv: let r:Double = 5.0 in r.round() = 5" );
        verify( evaluate( this.message, stmts ), "Even Positive Double round() should be valid" );

        stmts = parse( "context Message inv: let r:Double = -5.5 in r.round() = -5" );
        verify( evaluate( this.message, stmts ), "High Negative Double round() should be valid" );

        stmts = parse( "context Message inv: let r:Double = -5.6 in r.round() = -6" );
        verify( evaluate( this.message, stmts ), "Low Negative Double round() should be valid" );

        stmts = parse( "context Message inv: let r:Double = -5.0 in r.round() = -5" );
        verify( evaluate( this.message, stmts ), "Even Negative Double round() should be valid" );

        stmts = parse( "context Message inv: let r:Double = 0.0 in r.round() = 0" );
        verify( evaluate( this.message, stmts ), "Zero round() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoubleMax( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let r:Double = 5.4 in r.max(3.2) = 5.4" );
        verify( evaluate( this.message, stmts ), "Positive Double max() should be valid" );

        stmts = parse( "context Message inv: let r:Double = -5.4 in r.max(-3.2) = -3.2" );
        verify( evaluate( this.message, stmts ), "Negative Double max() should be valid" );

        stmts = parse( "context Message inv: let r:Double = -5.4 in r.max(3.2) = 3.2" );
        verify( evaluate( this.message, stmts ), "Mixed Double max() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testDoubleMin( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: let r:Double = 5.4 in r.min(3.2) = 3.2" );
        verify( evaluate( this.message, stmts ), "Positive Double min() should be valid" );

        stmts = parse( "context Message inv: let r:Double = -5.4 in r.min(-3.2) = -5.4" );
        verify( evaluate( this.message, stmts ), "Negative Double min() should be valid" );

        stmts = parse( "context Message inv: let r:Double = -5.4 in r.min(3.2) = -5.4" );
        verify( evaluate( this.message, stmts ), "Mixed Double min() should be valid" );
    }
}
