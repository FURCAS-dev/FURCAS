package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.serviceinteractions.Message;
import com.sap.serviceinteractions.__impl.MessageImpl;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on AttributeCall expressions.
 */
public class TestAttributeCallEvaluation extends BaseOclEvaluationTest {

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.original = null;
        this.reply = null;
        super.afterTestMethod( );
    }

    private MessageImpl original;

    private MessageImpl reply;

    /* Specified by interface */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        synchronized ( this.syncObjectForWrite ) {
            Message wrappedMessage = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            this.original = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedMessage );
            Message wrappedReply = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            this.reply = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedReply );
        }

    }

    /**
     * self.istFault
     */
    @Test
    public void testVariableDotAttr( ) {

        synchronized ( this.syncObjectForWrite ) {
            Collection<OclStatement> stmts = parse( "context Message " + "inv: self.isFault" );
            Message wrappedElement = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            MessageImpl actMessage = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedElement );
            actMessage.setFault( coreConnection, false );
            verify( !evaluate( actMessage, stmts ), "false attribute should be evaluated to false" );
            actMessage.setFault( coreConnection, true );
            verify( evaluate( actMessage, stmts ), "true attribute should be evaluated to true" );
        }
    }

    /**
     * self.reply_to.istFault
     */
    @Test
    public void testVariableDotAssociationDotAttribute( ) {

        synchronized ( this.syncObjectForWrite ) {
            Collection<OclStatement> stmts = parse( "context Message " + "inv: not self.reply_to.isFault" );
            this.reply.setReplyTo( coreConnection, this.original );
            this.original.setFault( coreConnection, true );
            verify( !evaluate( this.reply, stmts ), "Invalid model should evaluate to false" );
            this.original.setFault( coreConnection, false );
            verify( evaluate( this.reply, stmts ), "Valid model should evaluate to true" );
        }
    }
}