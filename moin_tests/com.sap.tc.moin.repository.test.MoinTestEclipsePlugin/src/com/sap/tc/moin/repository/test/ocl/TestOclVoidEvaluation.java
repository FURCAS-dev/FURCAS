package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on OclVoid operations.
 */
public class TestOclVoidEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    // @Test public void testOclUndefinedLiteral() {
    // Collection<OclStatement> stmts = parse("context Message "
    // + "inv: OclUndefined.oclIsUndefined()");
    // verify(evaluate(this.message, stmts), "OclUndefined literal should be undefined");
    // }
    /**
     *
     */
    @Test
    public void testNotOclUndefinedValue( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: not self.oclIsUndefined()" );
        verify( evaluate( this.message, stmts ), "Defined value shuold not be undefined" );
    }

    /**
     *
     */
    @Test
    public void testOclUndefinedValue( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: self.reply_to.isFault.oclIsUndefined()" );
        verify( evaluate( this.message, stmts ), "Undefined value shuold be undefined" );
    }

    /**
     *
     */
    @Test
    public void testOclUndefinedOrTrue( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: self.reply_to.isFault or true" );
        verify( evaluate( this.message, stmts ), "invalid OR true should be true" );
    }

    /**
     *
     */
    @Test
    public void testOclUndefinedOrTrueInverted( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: true or self.reply_to.isFault" );
        verify( evaluate( this.message, stmts ), "true OR invalid should be true" );
    }

    /**
     *
     */
    @Test
    public void testOclUndefinedAndFalse( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: (self.reply_to.isFault and false) = false" );
        verify( evaluate( this.message, stmts ), "OclUndefined AND false should be false" );
    }

    /**
     *
     */
    @Test
    public void testOclUndefinedImpliesTrue( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: self.reply_to.isFault implies true" );
        verify( evaluate( this.message, stmts ), "OclUndefined IMPLIES true should be true" );
    }

    // /**
    // * This test ensures that semantics remain consistent with section A.2.2 in the UML 2.0 OCL spec (page A-12) The
    // * above has been overruled by the new spec, so we rewrote the test!
    // */
    // @Test
    // public void testOclUndefinedEquals() {
    // Collection<OclStatement> stmts = null;
    //
    // stmts = parse("context Message inv: " + "(self.reply_to.isFault).oclIsUndefined()");
    // verify(evaluate(this.message, stmts), "invalid should be invalid");
    //
    // stmts = parse("context Message inv: "
    // + "not ((self.reply_to.isFault = self.reply_to.isFault).oclIsUndefined())");
    // verify(evaluate(this.message, stmts), "invalid = invalid should be invalid");
    // }
}
