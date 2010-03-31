package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on OclInteger operations.
 */
@SuppressWarnings( "nls" )
public class TestLongEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testLongEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (5).oclAsType(Long) = 5" );
        verify( evaluate( this.message, stmts ), "Positive Longs equal should be valid" );

        stmts = parse( "context Message inv: (0).oclAsType(Long) = 0" );
        verify( evaluate( this.message, stmts ), "Zero equal should be valid" );

        stmts = parse( "context Message inv: (-5).oclAsType(Long) = -5" );
        verify( evaluate( this.message, stmts ), "Negative Longs equal should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongNotEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (5).oclAsType(Long) <> (4).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs not equal should be valid" );

        stmts = parse( "context Message inv: (5).oclAsType(Long) <> (-5).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs not equal should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongPlus( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (3).oclAsType(Long) + (2).oclAsType(Long) = (5).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs plus should be valid" );

        stmts = parse( "context Message inv: -(3).oclAsType(Long) + (2).oclAsType(Long) = (-1).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs plus should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongMinus( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (5).oclAsType(Long) - (3).oclAsType(Long) = (2).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs minus should be valid" );

        stmts = parse( "context Message inv: (-5).oclAsType(Long) - (3).oclAsType(Long) = (-8).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs minus should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongMultiply( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (2).oclAsType(Long) * (3).oclAsType(Long) = (6).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs multiply should be valid" );

        stmts = parse( "context Message inv: (2).oclAsType(Long) * (-3).oclAsType(Long) = (-6).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs multiply should be valid" );

        stmts = parse( "context Message inv: (-2).oclAsType(Long) * (-3).oclAsType(Long) = (6).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs multiply should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongDivide( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (6).oclAsType(Long) / (4).oclAsType(Long) = 1.5" );
        verify( evaluate( this.message, stmts ), "Longs divide should be valid" );

        stmts = parse( "context Message inv: (6).oclAsType(Long) / (-4).oclAsType(Long) = -1.5" );
        verify( evaluate( this.message, stmts ), "Longs divide should be valid" );

        stmts = parse( "context Message inv: (-6).oclAsType(Long) / (4).oclAsType(Long) = -1.5" );
        verify( evaluate( this.message, stmts ), "Longs divide should be valid" );

        stmts = parse( "context Message inv: (-6).oclAsType(Long) / (-4).oclAsType(Long) = 1.5" );
        verify( evaluate( this.message, stmts ), "Longs divide should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongLessThan( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (3).oclAsType(Long) < (5).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs less than should be valid" );

        stmts = parse( "context Message inv: (-5).oclAsType(Long).ltStdLib((3).oclAsType(Long))" );
        verify( evaluate( this.message, stmts ), "Longs less than should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongGreaterThan( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (5).oclAsType(Long) > (3).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs greater than should be valid" );

        stmts = parse( "context Message inv: (3).oclAsType(Long) > (-5).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs greater than should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongLessThanOrEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (3).oclAsType(Long) <= (5).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs less than or equal should be valid" );

        stmts = parse( "context Message inv: (5).oclAsType(Long) <= (5).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs less than or equal should be valid" );

        stmts = parse( "context Message inv: (-5).oclAsType(Long) <= (3).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs less than or equal should be valid" );

        stmts = parse( "context Message inv: (-5).oclAsType(Long).lteqStdLib((-5).oclAsType(Long))" );
        verify( evaluate( this.message, stmts ), "Longs less than or equal should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongGreaterThanOrEqual( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (5).oclAsType(Long) >= (3).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs greater than or equal should be valid" );

        stmts = parse( "context Message inv: (5).oclAsType(Long) >= (5).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs greater than or equal should be valid" );

        stmts = parse( "context Message inv: (3).oclAsType(Long) >= (-5).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs greater than or equal should be valid" );

        stmts = parse( "context Message inv: (-5).oclAsType(Long) >= (-5).oclAsType(Long)" );
        verify( evaluate( this.message, stmts ), "Longs greater than or equal should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongAbs( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let i:Long = (5).oclAsType(Long) in i.abs() = 5" );
        verify( evaluate( this.message, stmts ), "Positive Long abs() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-5).oclAsType(Long) in i.abs() = 5" );
        verify( evaluate( this.message, stmts ), "Negative Long abs() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (0).oclAsType(Long) in i.abs() = 0" );
        verify( evaluate( this.message, stmts ), "Zero abs() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongMax( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let i:Long = (5).oclAsType(Long) in i.max(3) = 5" );
        verify( evaluate( this.message, stmts ), "Positive Long max() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-5).oclAsType(Long) in i.max(-3) = -3" );
        verify( evaluate( this.message, stmts ), "Negative Long max() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-5).oclAsType(Long) in i.max(3) = 3" );
        verify( evaluate( this.message, stmts ), "Mixed Long max() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongMin( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let i:Long = (5).oclAsType(Long) in i.min(3) = 3" );
        verify( evaluate( this.message, stmts ), "Positive Long min() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-5).oclAsType(Long) in i.min(-3) = -5" );
        verify( evaluate( this.message, stmts ), "Negative Long min() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-5).oclAsType(Long) in i.min(3) = -5" );
        verify( evaluate( this.message, stmts ), "Mixed Long min() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testLongDiv( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let i:Long = (7).oclAsType(Long) in (i.longDivStdLib((2).oclAsType(Long))) = 3" );
        verify( evaluate( this.message, stmts ), "Positive Long div() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-8).oclAsType(Long) in (i.longDivStdLib((2).oclAsType(Long))) = -4" );
        verify( evaluate( this.message, stmts ), "Mixed Long div() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (10).oclAsType(Long) in (i.longDivStdLib((-3).oclAsType(Long))) = -3" );
        verify( evaluate( this.message, stmts ), "Mixed Long div() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-11).oclAsType(Long) in (i.longDivStdLib((-3).oclAsType(Long))) = 3" );
        verify( evaluate( this.message, stmts ), "Negative Long div() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-11).oclAsType(Long) in (i.longDivStdLib((0).oclAsType(Long))).oclIsInvalid()" );
        verify( evaluate( this.message, stmts ), "Zero Long div() should be undefined" );
    }

    /**
     *
     */
    @Test
    public void testLongMod( ) {

        Collection<OclStatement> stmts = parse( "context Message " + "inv: let i:Long = (7).oclAsType(Long) in i.mod(2) = 1" );
        verify( evaluate( this.message, stmts ), "Positive Long mod() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (9).oclAsType(Long) in i.mod(3) = 0" );
        verify( evaluate( this.message, stmts ), "Positive Long mod() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (10).oclAsType(Long) in i.mod(-3) = 1" );
        verify( evaluate( this.message, stmts ), "Positive/negative mod() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-7).oclAsType(Long) in i.mod(2) = -1" );
        verify( evaluate( this.message, stmts ), "Negative/positive should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-11).oclAsType(Long) in i.mod(-3) = -2" );
        verify( evaluate( this.message, stmts ), "Negative Long mod() should be valid" );

        stmts = parse( "context Message " + "inv: let i:Long = (-11).oclAsType(Long) in i.mod(0).oclIsInvalid()" );
        verify( evaluate( this.message, stmts ), "Zero Long mod() should be undefined" );
    }
}
