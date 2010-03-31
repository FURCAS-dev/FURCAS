package com.sap.tc.moin.repository.test.ocl.integration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Operation;

import org.junit.Test;
import org.omg.ocl.OclPackage;
import org.omg.ocl.expressions.OclExpression;

import com.sap.serviceinteractions.Message;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclServiceImpl;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * Integration tests focusing on the evaluation of user-defined operations.
 */
public class TestOperationCallEvaluation extends BaseOclEvaluationTest {

    /**
     *
     */
    @Test
    public void testOperationNoArgsJava( ) throws Exception {

        // expression: "context Message::isNotFault():Boolean body: not self.isFault",


        this.message.setFault( true );
        Boolean result = (Boolean) OclServiceImpl.getInstance( ).evaluateOclBodyExpression( coreConnection, "isNotFault", this.message, null );
        verify( !result.booleanValue( ), "isNotFault should return false" );

        this.message.setFault( false );
        result = (Boolean) OclServiceImpl.getInstance( ).evaluateOclBodyExpression( coreConnection, "isNotFault", this.message, null );
        verify( result.booleanValue( ), "isNotFault should return true" );

    }

    /**
     *
     */
    @Test
    public void testOperationNoArgsJmi( ) {

        // expression: "context Message::isNotFault():Boolean body: not self.isFault",

        Message wrappedMessage = (Message) coreConnection.getWrapper( ).getElement( this.message.get___Mri( ) );
        wrappedMessage.setFault( true );
        boolean result = wrappedMessage.isNotFault( );
        verify( !result, "isNotFault should return false" );

        wrappedMessage.setFault( false );
        result = wrappedMessage.isNotFault( );
        verify( result, "isNotFault should return true" );
    }

    /**
     *
     */
    @Test
    public void testOperationOneArgJava( ) throws Exception {

        // expression: "context Message::getMessagesTriggeredByType(type:String):Bag(Message) " +
        // "body: let emptyBag:Bag(Message) = Bag{} in " + "if type = 'request' then Bag{self} else emptyBag endif",


        Map<String, Object> parameterMap = new HashMap<String, Object>( );
        parameterMap.put( "type", "response" );

        Collection result = (Collection) OclServiceImpl.getInstance( ).evaluateOclBodyExpression( coreConnection, "getMessagesTriggeredByType", this.message, parameterMap );

        verify( !result.contains( this.message ), "result should not contain the message" );

        parameterMap.put( "type", "request" );

        result = (Collection) OclServiceImpl.getInstance( ).evaluateOclBodyExpression( coreConnection, "getMessagesTriggeredByType", this.message, parameterMap );
        verify( result.contains( this.message ), "result should contain the message" );

    }

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
            Operation op = (Operation) s.getContext( );
            if ( !op.isQuery( ) ) {
                op.setQuery( true );
            }
            // let's check if the body was attached before
            OclExpression result = ( (OclPackage) s.getExpression( ).refImmediatePackage( ).refImmediatePackage( ) ).getAttaching( ).getOperationBodyDefinition( ).getBody( (Operation) s.getContext( ) );
            if ( result == null ) {
                // TODO: Is it possible to get the exceptions from MOF?
                // op.getExceptions().add(???);
                ( (OclPackage) s.getExpression( ).refImmediatePackage( ).refImmediatePackage( ) ).getAttaching( ).getOperationBodyDefinition( ).getDefines( s.getExpression( ) ).add( (Operation) s.getContext( ) );
            }

            OclExpression exp = s.getExpression( );
            if ( exp.getName( ) == null ) {
                exp.setName( op.getName( ) + "_OclGenerated" );
            }

        }

        Collection<OclStatement> stmts = parse( "context Message inv: self.isNotFault()", null, this.types );

        this.message.setFault( false );

        verify( evaluate( this.message, stmts ), "User-defined no-arg op should be valid" );

        this.message.setFault( true );
        verify( !evaluate( this.message, stmts ), "User-defined no-arg op should be valid" );

    }

    /**
     *
     */
    @Test
    public void testOperationOneArgOcl( ) {

        Collection<OclStatement> stmts = parse( "context Message::getMessagesTriggeredByType(type:String):Bag(Message) " + "body: let emptyBag:Bag(Message) = Bag{} in " + "if self.type = 'request' then Bag{self} else emptyBag endif", null, this.types );

        for ( OclStatement s : stmts ) {
            Operation op = (Operation) s.getContext( );
            if ( !op.isQuery( ) ) {
                op.setQuery( true );
            }

            // let's check if the body was attached before
            OclExpression result = ( (OclPackage) s.getExpression( ).refImmediatePackage( ).refImmediatePackage( ) ).getAttaching( ).getOperationBodyDefinition( ).getBody( (Operation) s.getContext( ) );
            if ( result == null ) {
                // TODO: Is it possible to get the exceptions from MOF?
                // op.getExceptions().add(???);
                ( (OclPackage) s.getExpression( ).refImmediatePackage( ).refImmediatePackage( ) ).getAttaching( ).getOperationBodyDefinition( ).getDefines( s.getExpression( ) ).add( (Operation) s.getContext( ) );
            }
            OclExpression exp = s.getExpression( );
            if ( exp.getName( ) == null ) {
                exp.setName( op.getName( ) + "_OclGenerated" );
            }
        }

        stmts = parse( "context Message inv: " + "self.getMessagesTriggeredByType(self.type)->includes(self)", null, this.types );

        this.message.setType( "request" );
        verify( evaluate( this.message, stmts ), "User-defined op with arg should be valid" );

        this.message.setType( "response" );
        verify( !evaluate( this.message, stmts ), "User-defined op with arg should be valid" );

    }

    /**
     * 
     */
    @Test
    public void testOperationOneArgJmi( ) {

        // Expression: "context Message::getMessagesTriggeredByType(type:String):Bag(Message) +
        // body: let emptyBag:Bag(Message) = Bag{} in " + "if type = 'request' then Bag{self} else emptyBag endif"
        Message wrappedMessage = (Message) coreConnection.getWrapper( ).getElement( this.message.get___Mri( ) );
        Collection<Message> result = wrappedMessage.getMessagesTriggeredByType( "request" );
        verify( result.contains( wrappedMessage ), "Result should contain the message" );

        result = wrappedMessage.getMessagesTriggeredByType( "response" );
        verify( !result.contains( wrappedMessage ), "Result should not contain the message" );

    }
    // TODO: Tests for multiple arguments, exceptions, and possibly OUT args.

}
