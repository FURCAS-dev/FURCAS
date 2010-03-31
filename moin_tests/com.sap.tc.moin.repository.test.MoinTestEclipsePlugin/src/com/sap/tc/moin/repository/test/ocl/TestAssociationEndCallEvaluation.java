package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;
import java.util.Collections;

import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.serviceinteractions.Message;
import com.sap.serviceinteractions.__impl.MessageImpl;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on AssociationEndCall expressions.
 */
public class TestAssociationEndCallEvaluation extends BaseOclEvaluationTest {

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

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        original = null;
        reply = null;
    }

    /**
     * self.reply_to
     */
    @Test
    public void testVariableDotAssociation( ) {

        Collection<OclStatement> stmts = parse( "inv: self.reply_to->excludes(self)" );

        synchronized ( this.syncObjectForWrite ) {
            this.reply.setReplyTo( coreConnection, this.reply );
            verify( !evaluate( this.reply, stmts ), "Invalid model should evaluate to false" );
            this.reply.setReplyTo( coreConnection, this.original );
            verify( evaluate( this.reply, stmts ), "Valid model should evaluate to true" );
        }
    }

    /**
     * self.reply_to.reply_to
     */
    @Test
    public void testVariableDotAssociationDotAssociation( ) {

        Collection<OclStatement> stmts = parse( "inv: self.reply_to.reply_to->excludes(self)" );

        synchronized ( this.syncObjectForWrite ) {
            this.reply.setReplyTo( coreConnection, this.original );
            this.original.setReplyTo( coreConnection, this.reply );
            verify( !evaluate( this.reply, stmts ), "Invalid model should evaluate to false" );
            this.reply.setReplyTo( coreConnection, this.original );
            this.original.setReplyTo( coreConnection, coreConnection.createElementInPartition( Message.class, null ) );
        }
        System.out.println( );
        verify( evaluate( this.reply, stmts ), "Valid model should evaluate to true" );
    }

    /**
     * self.reply_to.reply_to->notEmpty()
     */
    @Test
    public void testVariableDotSingleAssociationDotCollectionOperation( ) {

        synchronized ( this.syncObjectForWrite ) {
            Collection<OclStatement> stmts = parse( "inv: self.reply_to->notEmpty()" );

            verify( !evaluate( this.reply, stmts ), "Invalid model should evaluate to false" );

            this.reply.setReplyTo( coreConnection, this.original );

            verify( evaluate( this.reply, stmts ), "Valid model should evaluate to true" );
        }
    }

    /**
     * self.triggers->notEmpty()
     */
    @Test
    public void testVariableDotMultiAssociationDotCollectionOperation( ) {

        synchronized ( this.syncObjectForWrite ) {
            Collection<OclStatement> stmts = parse( "inv: self.triggers->notEmpty()" );
            verify( !evaluate( this.reply, stmts ), "Invalid model should evaluate to false" );
            this.original.setReplyTo( coreConnection, this.reply );
            verify( evaluate( this.reply, stmts ), "Valid model should evaluate to true" );
        }
    }

    /**
     * Test to ensure that an association is not wrapped as a set when it is not
     * the source of a set operation
     */
    @Test
    public void testAssociationAsType( ) {

        synchronized ( this.syncObjectForWrite ) {
            Collection<OclStatement> stmts = parse( "inv: self.reply_to.oclAsType(Message).isFault" );
            this.original.setReplyTo( coreConnection, this.reply );
            verify( !evaluate( this.original, stmts ), "Invalid model should evaluate to false" );
            this.reply.setFault( coreConnection, true );
            verify( evaluate( this.original, stmts ), "Valid model should evaluate to true" );
        }

    }

    /**
     * Test to ensure that an association is not wrapped as a set when it is not
     * the source of a set operation
     */
    @Test
    public void testAssociationCallInCollectionIsFlattened( ) {

        synchronized ( this.syncObjectForWrite ) {
            RefClassImpl mofPackageClass = (RefClassImpl) this.modelPackage.getMofPackage( coreConnection );
            MofPackageImpl top = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            MofPackageImpl child1 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            MofPackageImpl child11 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            child11.setContainer( coreConnection, child1 );
            MofPackageImpl child12 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            child12.setContainer( coreConnection, child1 );

            MofPackageImpl child2 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            MofPackageImpl child21 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            child21.setContainer( coreConnection, child2 );
            MofPackageImpl child22 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            child22.setContainer( coreConnection, child2 );
            MofPackageImpl child23 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            child23.setContainer( coreConnection, child2 );

            MofPackageImpl child3 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            MofPackageImpl child31 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            child31.setContainer( coreConnection, child3 );
            MofPackageImpl child32 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            child32.setContainer( coreConnection, child3 );
            MofPackageImpl child33 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            child33.setContainer( coreConnection, child3 );
            MofPackageImpl child34 = (MofPackageImpl) mofPackageClass.refCreateInstance( coreConnection, Collections.emptyList( ) );
            child34.setContainer( coreConnection, child3 );

            Collection<OclStatement> stmts = this.parse( "inv: self.contents->collect(a|a.oclAsType(Namespace).contents)->size()=2", this.modelPackage.getNamespace( coreConnection ).refMetaObject( ), new RefPackage[] { this.modelPackage } );

            child1.setContainer( coreConnection, top );
            verify( evaluate( top, stmts ), "Flatten operation should result in 2 values" );

            stmts = this.parse( "inv: self.contents->collect(a|a.oclAsType(Namespace).contents)->size()=5", this.modelPackage.getNamespace( coreConnection ).refMetaObject( ), new RefPackage[] { this.modelPackage } );

            child2.setContainer( coreConnection, top );
            verify( evaluate( top, stmts ), "Flatten operation should result in 5 values" );

            stmts = this.parse( "inv: self.contents->collect(a|a.oclAsType(Namespace).contents)->size()=9", this.modelPackage.getNamespace( coreConnection ).refMetaObject( ), new RefPackage[] { this.modelPackage } );

            child3.setContainer( coreConnection, top );
            verify( evaluate( top, stmts ), "Flatten operation should result in 9 values" );
        }

    }
}