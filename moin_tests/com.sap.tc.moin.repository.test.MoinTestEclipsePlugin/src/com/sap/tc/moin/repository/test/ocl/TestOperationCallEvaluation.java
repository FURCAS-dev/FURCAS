package com.sap.tc.moin.repository.test.ocl;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.Test;
import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on the evaluation of user-defined operations.
 * User-defined operations are not yet supported FIXME enable tests once
 */
public class TestOperationCallEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testOperationNoArgsOcl( ) {

        Collection<OclStatement> bodyStmts = parse( "context Message::isNotFault():Boolean body: not self.isFault", null, this.types );

        /*
         * -- We need to explicitly attach that body so that the evaluator can
         * find it afterwards
         */
        for ( OclStatement s : bodyStmts ) {
            OperationImpl op = (OperationImpl) s.getContext( );
            if ( !op.isQuery( ) ) {
                op.setQuery( coreConnection, true );
            }
            // let's check if the body was attached before
            OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) coreConnection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR );
            OclExpression result = assoc.getBody( coreConnection, (Operation) s.getContext( ) );
            if ( result == null ) {
                // TODO: Is it possible to get the exceptions from MOF?
                // op.getExceptions().add(???);
                ( (JmiList) assoc.getDefines( coreConnection, s.getExpression( ) ) ).add( coreConnection, s.getContext( ) );
            }
            OclExpression exp = s.getExpression( );
            if ( exp.getName( ) == null ) {
                ( (OclExpressionInternal) exp ).setName( coreConnection, op.getName( ) + "_OclGenerated" );
            }
        }

        Collection<OclStatement> stmts = parse( "context Message inv: self.isNotFault()", null, this.types );

        synchronized ( this.syncObjectForWrite ) {
            this.message.setFault( coreConnection, false );
            verify( evaluate( this.message, stmts ), "User-defined no-arg op should be valid" );
            this.message.setFault( coreConnection, true );
            verify( !evaluate( this.message, stmts ), "User-defined no-arg op should be valid" );
        }

    }

    @Test
    public void testFreeStandingOperation( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: isNotFault()", null, this.types );

        synchronized ( this.syncObjectForWrite ) {
            this.message.setFault( coreConnection, false );
            verify( evaluate( this.message, stmts ), "User-defined no-arg op should be valid" );
            this.message.setFault( coreConnection, true );
            verify( !evaluate( this.message, stmts ), "User-defined no-arg op should be valid" );
        }
    }

    @Test
    public void testOperationAsSetConversion( ) {

        Collection<OclStatement> stmts = parse( "context Message inv: self->notEmpty()", null, this.types );

        synchronized ( this.syncObjectForWrite ) {
            this.message.setFault( coreConnection, false );
            verify( evaluate( this.message, stmts ), "User-defined no-arg op should be valid" );
            this.message.setFault( coreConnection, true );
            verify( evaluate( this.message, stmts ), "User-defined no-arg op should be valid" );
        }
    }

    /**
     *
     */
    @Test
    public void testParseOperationContextWithBag( ) {

        Collection<OclStatement> stmts = parse( "context Message::getMessagesTriggeredByType(type:String):Bag(Message)" + "body: let emptyBag:Bag(Message) = Bag{} in " + "if type = 'request' then Bag{self} else emptyBag endif", null, new RefPackage[] { this.svcIntPkg } );

        synchronized ( this.syncObjectForWrite ) {
            this.message.setFault( coreConnection, false );
            verify( evaluate( this.message, stmts ), "User-defined no-arg op should be valid" );
            this.message.setFault( coreConnection, true );
            verify( evaluate( this.message, stmts ), "User-defined no-arg op should be valid" );
        }
    }

    /**
     *
     */
    @Test
    public void testOperationOneArgOcl( ) {

        Collection<OclStatement> stmts = null;

        stmts = parse( "context Message::getMessagesTriggeredByType(type:String):Bag(Message) " + "body: let emptyBag:Bag(Message) = Bag{} in " + "if self.type = 'request' then Bag{self} else emptyBag endif", null, this.types );

        synchronized ( this.syncObjectForWrite ) {
            for ( OclStatement s : stmts ) {
                OperationImpl op = (OperationImpl) s.getContext( );
                if ( !op.isQuery( ) ) {
                    op.setQuery( coreConnection, true );
                }

                // let's check if the body was attached before
                OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) coreConnection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR );
                OclExpression result = assoc.getBody( coreConnection, (Operation) s.getContext( ) );
                if ( result == null ) {
                    // TODO: Is it possible to get the exceptions from MOF?
                    // op.getExceptions().add(???);
                    ( (JmiList) assoc.getDefines( coreConnection, s.getExpression( ) ) ).add( coreConnection, s.getContext( ) );
                }
                OclExpression exp = s.getExpression( );
                if ( exp.getName( ) == null ) {
                    ( (OclExpressionInternal) exp ).setName( coreConnection, op.getName( ) + "_OclGenerated" );
                }
            }

            stmts = parse( "context Message inv: " + "self.getMessagesTriggeredByType(self.type)->includes(self)", null, this.types );

            this.message.setType( coreConnection, "request" );
            verify( evaluate( this.message, stmts ), "User-defined op with arg should be valid" );

            stmts = parse( "context Message inv: " + "self.getMessagesTriggeredByType(self.type) = null", null, this.types );

            this.message.setType( coreConnection, "response" );
            verify( evaluate( this.message, stmts ), "User-defined op with arg should be valid" );
        }
    }

}
