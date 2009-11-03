package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on Let expressions.
 */
public class TestLetEvaluation extends BaseOclEvaluationTest {

    public TestLetEvaluation( ) {
    }

    /**
     *
     */
    @Test
    public void testLetFaultFalse( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let fault : Boolean = self.isFault in " + "fault" );

        synchronized ( this.syncObjectForWrite ) {
            this.message.setFault( coreConnection, false );
        }
        verify( !evaluate( this.message, stmts ), "Invariant should be false when fault is false" );
    }

    /**
     *
     */
    @Test
    public void testLetFaultTrue( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let fault : Boolean = self.isFault in " + "fault" );

        synchronized ( this.syncObjectForWrite ) {
            this.message.setFault( coreConnection, true );
        }

        verify( evaluate( this.message, stmts ), "Invariant should be true when fault is true" );
    }

    /**
     *
     */
    @Test
    public void testLetTwoVariables( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: " + "let fault : Boolean = self.isFault, notfault : Boolean = not self.isFault in " + "fault" );

        synchronized ( this.syncObjectForWrite ) {
            this.message.setFault( coreConnection, true );
        }

        verify( evaluate( this.message, stmts ), "Invariant should be true when fault is true" );
    }

}
