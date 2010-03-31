package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on If expressions.
 */
public class TestIfThenElseEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testIfThenElseConditionTrue( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "if true then " + "true " + "else " + "false " + "endif" );

        verify( evaluate( this.message, stmts ), "true in if-then-else should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIfThenElseConditionFalse( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "if false then " + "true " + "else " + "false " + "endif" );

        verify( !evaluate( this.message, stmts ), "false in if-then-else should be invalid" );
    }

    /**
     *
     */
    @Test
    public void testIfThenElseConditionUndefined( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "(if 5/0 = 5 then true else false endif).oclIsInvalid()" );

        verify( evaluate( this.message, stmts ), "undefined condition in if-then-else should be undefined" );
    }

}
