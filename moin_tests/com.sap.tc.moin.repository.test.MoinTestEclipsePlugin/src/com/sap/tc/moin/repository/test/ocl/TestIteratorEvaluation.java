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
 * Test Iterator Evaluation
 */
public class TestIteratorEvaluation extends BaseOclEvaluationTest {

    private MessageImpl original;

    private MessageImpl reply;

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
     *
     */
    @Test
    public void testImplicitCollectOperation( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: self.triggers.isNotFault()->size() >= 0" );

        this.verify( this.evaluate( this.original, stmts ), "Valid model should evaluate to true" );
    }

    /**
     *
     */
    @Test
    public void testImplicitCollectAttributes( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: self.triggers.isFault->size() = 2" );

        this.verify( !this.evaluate( this.original, stmts ), "Invalid model should evaluate to false" );

        synchronized ( this.syncObjectForWrite ) {
            this.reply.setReplyTo( coreConnection, this.original );
            this.reply.setFault( coreConnection, true );
            Message wrappedMessage = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            MessageImpl another = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedMessage );
            another.setReplyTo( coreConnection, this.original );
            this.reply.setFault( coreConnection, false );
        }
        this.verify( this.evaluate( this.original, stmts ), "Valid model should evaluate to true" );
    }

    /**
     *
     */
    @Test
    public void testCollectAttributesImplicitIterator( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "self.triggers->collect(isFault)->size() = 2" );

        this.verify( !this.evaluate( this.original, stmts ), "Invalid model should evaluate to false" );

        synchronized ( this.syncObjectForWrite ) {
            this.reply.setReplyTo( coreConnection, this.original );
            this.reply.setFault( coreConnection, true );
            Message wrappedMessage = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            MessageImpl another = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedMessage );
            another.setReplyTo( coreConnection, this.original );
            this.reply.setFault( coreConnection, false );
        }
        this.verify( this.evaluate( this.original, stmts ), "Valid model should evaluate to true" );
    }

    // self.restrictions->select(oclIsKindOf(DerivedXsdTypeRestriction))

    /**
     *
     */
    @Test
    public void testSelectAttributesImplicitIterator( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "self.triggers->select(oclIsKindOf(Message))->isEmpty()" );

        this.verify( this.evaluate( this.original, stmts ), "Valid model should evaluate to true" );
    }

    /**
     *
     */
    @Test
    public void testCollectAttributesExplicitIterator( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "self.triggers->collect(m | m.isFault)->size() = 2" );

        this.verify( !this.evaluate( this.original, stmts ), "Invalid model should evaluate to false" );

        synchronized ( this.syncObjectForWrite ) {
            this.reply.setReplyTo( coreConnection, this.original );
            this.reply.setFault( coreConnection, true );
            Message wrappedMessage = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            MessageImpl another = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedMessage );
            another.setReplyTo( coreConnection, this.original );
            this.reply.setFault( coreConnection, false );
        }
        this.verify( this.evaluate( this.original, stmts ), "Valid model should evaluate to true" );
    }

    /**
     *
     */
    @Test
    public void testImplicitCollectAssociations( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: self.triggers.reply_to->includes(self)" );

        this.verify( !this.evaluate( this.original, stmts ), "Invalid model should evaluate to false" );

        synchronized ( this.syncObjectForWrite ) {
            this.reply.setReplyTo( coreConnection, this.original );
            Message wrappedMessage = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            MessageImpl another = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedMessage );
            another.setReplyTo( coreConnection, this.original );
        }
        this.verify( this.evaluate( this.original, stmts ), "Valid model should evaluate to true" );
    }

    /**
     *
     */
    @Test
    public void testCollectAssociationsImplicitIterator( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "self.triggers->collect(reply_to)->includes(self)" );

        this.verify( !this.evaluate( this.original, stmts ), "Invalid model should evaluate to false" );

        synchronized ( this.syncObjectForWrite ) {
            this.reply.setReplyTo( coreConnection, this.original );
            Message wrappedMessage = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            MessageImpl another = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedMessage );
            another.setReplyTo( coreConnection, this.original );
        }
        this.verify( this.evaluate( this.original, stmts ), "Valid model should evaluate to true" );
    }

    /**
     *
     */
    @Test
    public void testCollectAssociationsExplicitIterator( ) {

        Collection<OclStatement> stmts = this.parse( "context Message inv: " + "self.triggers->collect(m | m.reply_to)->includes(self)" );

        this.verify( !this.evaluate( this.original, stmts ), "Invalid model should evaluate to false" );

        synchronized ( this.syncObjectForWrite ) {
            this.reply.setReplyTo( coreConnection, this.original );
            Message wrappedMessage = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            MessageImpl another = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedMessage );
            another.setReplyTo( coreConnection, this.original );
        }
        this.verify( this.evaluate( this.original, stmts ), "Valid model should evaluate to true" );
    }

    /**
     *
     */
    @Test
    public void testMultipleIterators( ) {

        Collection<OclStatement> stmts = this.parse( "context ServiceInteractions::Message inv: " + "self.triggers->forAll(m1, m2 | " + "m1 <> m2 implies m1.isFault <> m2.isFault)" );

        synchronized ( this.syncObjectForWrite ) {
            this.reply.setReplyTo( coreConnection, this.original );
            this.reply.setFault( coreConnection, true );
            Message wrappedMessage = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            MessageImpl another = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedMessage );
            another.setReplyTo( coreConnection, this.original );
            another.setFault( coreConnection, false );
        }
        this.verify( this.evaluate( this.original, stmts ), "Valid model should evaluate to true" );
    }

    /**
     *
     */
    @Test
    public void testMultipleOneVariableIterators( ) {

        Collection<OclStatement> stmts = this.parse( "context ServiceInteractions::Message inv: " + "let b : Boolean = self.triggers->exists(m : Message | m.type = 'test') in " + "let a : Boolean = self.triggers->forAll(m : Message | m.isFault) in " + "a or b" );

        synchronized ( this.syncObjectForWrite ) {
            this.reply.setReplyTo( coreConnection, this.original );
            this.reply.setFault( coreConnection, true );
            Message wrappedMessage = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            MessageImpl another = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedMessage );
            another.setReplyTo( coreConnection, this.original );
            another.setFault( coreConnection, false );
        }
        this.verify( !this.evaluate( this.original, stmts ), "Valid model should evaluate to false" );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.original = null;
        this.reply = null;
        super.afterTestMethod( );
    }

}