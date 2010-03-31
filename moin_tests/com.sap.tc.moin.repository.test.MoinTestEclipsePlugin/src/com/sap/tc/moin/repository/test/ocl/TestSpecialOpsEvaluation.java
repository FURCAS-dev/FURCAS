package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.serviceinteractions.Message;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.serviceinteractions.TwoWayInteraction;
import com.sap.serviceinteractions.__impl.MessageImpl;
import com.sap.serviceinteractions.__impl.TwoWayInteractionImpl;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests for the various special operations.
 */
public class TestSpecialOpsEvaluation extends BaseOclEvaluationTest {

    private RefClassImpl interactionClass;

    private TwoWayInteractionImpl interaction;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        this.interactionClass = (RefClassImpl) this.svcIntPkg.getTwoWayInteraction( this.coreConnection );
        synchronized ( this.syncObjectForWrite ) {
            TwoWayInteraction wrappedElement = this.coreConnection.getWrapper( ).createElementInPartition( TwoWayInteraction.class, null );
            this.interaction = (TwoWayInteractionImpl) getTestHelper( ).getCorePartitionable( wrappedElement );
        }
    }

    /**
     *
     */
    @Test
    public void testAllInstances( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let msgs:Sequence(Message) = " + "Message.allInstances()->asSequence() in\n" + "msgs->size() = 2 and\n" + "((msgs->at(1).isFault and not msgs->at(2).isFault) or\n" + " (not msgs->at(1).isFault and msgs->at(2).isFault))" );

        synchronized ( this.syncObjectForWrite ) {
            // TODO: The previous test which leaves rest rubbish should clean up its test objects !!!
            // All tests should always perform precondition checks and clean up their test objects!!!
            assertEquals( "Precondition test failed: Expected other number of text messages.", 1, this.connection.getPackage( ServiceInteractionsPackage.PACKAGE_DESCRIPTOR ).getMessage( ).refAllOfClass( ).size( ) );

            this.message.setFault( this.coreConnection, true );
            Message wrappedElement = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            MessageImpl otherMessage = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedElement );
            otherMessage.setFault( this.coreConnection, false );

            Collection<RefObject> instances = this.connection.getPackage( ServiceInteractionsPackage.PACKAGE_DESCRIPTOR ).getMessage( ).refAllOfClass( );
            verify( instances.size( ) == 2, "Expected two message instances, but found " + instances.size( ) );

            verify( evaluate( this.message, stmts ), "Expr with allInstances() should be valid" );
        }
    }

    /**
     *
     */
    @Test
    public void testOclAsTypeDownCast( ) {

        Collection<OclStatement> stmts = parse( "context Interactions inv:\n" + "let twoWayInteraction:TwoWayInteraction = " + "self.oclAsType(TwoWayInteraction) in\n" + "self = twoWayInteraction", this.svcIntPkg.getInteractions( this.coreConnection ).refMetaObject( ), this.types );

        verify( evaluate( this.interaction, stmts ), "Expr with oclAsType() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testOclAsTypeUpCast( ) {

        Collection<OclStatement> stmts = parse( "context TwoWayInteraction inv:\n" + "let interaction:Interactions = " + "self.oclAsType(Interactions) in\n" + "self = interaction", this.interactionClass.refMetaObject( ), this.types );

        verify( evaluate( this.interaction, stmts ), "Expr with oclAsType() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testOclAsTypeUndefinedCast( ) {

        String ocl = "context TwoWayInteraction inv:\n" + "let anyM:OclAny = self in " + "let message:Message = anyM.oclAsType(Message) in\n" + "message.oclIsUndefined()";
        Collection<OclStatement> stmts = parse( ocl, this.interactionClass.refMetaObject( ), this.types );
        verify( evaluate( this.interaction, stmts ), "Expr with oclAsType() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testModelEltOclIsKindOf( ) {

        Collection<OclStatement> stmts = parse( "context TwoWayInteraction inv:\n" + "let interaction:Interactions = self in\n" + "interaction.oclIsKindOf(TwoWayInteraction) and\n" + "interaction.oclIsKindOf(Interactions) and\n" + "not interaction.oclIsKindOf(OneWayInteractions)",
                                                this.interactionClass.refMetaObject( ), this.types );

        verify( evaluate( this.interaction, stmts ), "Expr with oclIsKindOf() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testBooleanOclIsKindOf( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let bool:OclAny = false in\n" + "bool.oclIsKindOf(Boolean) and\n" + "bool.oclIsKindOf(OclAny) and\n" + "not bool.oclIsKindOf(Integer)" );

        verify( evaluate( this.message, stmts ), "Expr with oclIsKindOf() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIntegerOclIsKindOf( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let int:OclAny = 4 in\n" + "int.oclIsKindOf(Integer) and\n" + "int.oclIsKindOf(Float) and\n" + "int.oclIsKindOf(OclAny) and\n" + "not int.oclIsKindOf(String)" );

        verify( evaluate( this.message, stmts ), "Expr with oclIsKindOf() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testRealOclIsKindOf( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let real:OclAny = 4.3 in\n" + "real.oclIsKindOf(Float) and\n" + "real.oclIsKindOf(OclAny) and\n" + "not real.oclIsKindOf(Integer)" );

        verify( evaluate( this.message, stmts ), "Expr with oclIsKindOf() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testStringOclIsKindOf( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let str:OclAny = 'myString' in\n" + "str.oclIsKindOf(String) and\n" + "str.oclIsKindOf(OclAny) and\n" + "not str.oclIsKindOf(Boolean)" );

        verify( evaluate( this.message, stmts ), "Expr with oclIsKindOf() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testStringNotOclIsKindOf( ) {

        parseFail( "context Message inv:\n" + "let str:OclAny = 'myString' in\n" + "str.oclIsKindOf(self)" );
    }

    /**
     *
     */
    @Test
    public void testSetEqualsNotPossible( ) {

        parseFail( "context Message inv: self = Set{}" );
    }

    /**
     *
     */
    @Test
    public void testModelEltOclIsTypeOf( ) {

        Collection<OclStatement> stmts = parse( "context TwoWayInteraction inv:\n" + "let interaction:Interactions = self in\n" + "interaction.oclIsTypeOf(TwoWayInteraction) and\n" + "not interaction.oclIsTypeOf(Interactions)", this.interactionClass.refMetaObject( ), this.types );

        verify( evaluate( this.interaction, stmts ), "Expr with oclIsTypeOf() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testBooleanOclIsTypeOf( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let bool:OclAny = false in\n" + "bool.oclIsTypeOf(Boolean) and\n" + "not bool.oclIsTypeOf(OclAny)" );

        verify( evaluate( this.message, stmts ), "Expr with oclIsTypeOf() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testIntegerOclIsTypeOf( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let int:OclAny = 4 in\n" + "int.oclIsTypeOf(Integer) and\n" + "not int.oclIsTypeOf(Float)" );

        verify( evaluate( this.message, stmts ), "Expr with oclIsTypeOf() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testRealOclIsTypeOf( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let real:OclAny = 4.3 in\n" + "real.oclIsTypeOf(Float) and\n" + "not real.oclIsTypeOf(OclAny)" );

        verify( evaluate( this.message, stmts ), "Expr with oclIsTypeOf() should be valid" );
    }

    /**
     *
     */
    @Test
    public void testStringOclIsTypeOf( ) {

        Collection<OclStatement> stmts = parse( "context Message inv:\n" + "let str:OclAny = 'myString' in\n" + "str.oclIsTypeOf(String) and\n" + "not str.oclIsTypeOf(OclAny)" );

        verify( evaluate( this.message, stmts ), "Expr with oclIsTypeOf() should be valid" );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.interaction = null;
        this.interactionClass = null;
        super.afterTestMethod( );
    }

}
