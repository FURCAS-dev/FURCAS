package com.sap.tc.moin.repository.test.ocl.integration;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.Test;
import org.omg.ocl.expressions.OclExpression;

import com.sap.serviceinteractions.Message;
import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.EvaluatorException;
import com.sap.tc.moin.ocl.evaluator.ExpressionUndefinedException;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Test OCL registration
 * 
 * @author d022737
 */
public class OclConstraintParsingTest extends BaseOclTest {

    /**
     * @throws Exception
     */
    @Test
    public void testServiceInteractionConstraintsParse( ) throws Exception {

        this.testServiceInteractionConstraintsInternal( false );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testServiceInteractionConstraintsParseAndEvaluate( ) throws Exception {

        this.testServiceInteractionConstraintsInternal( true );
    }

    /**
     * Just see if the constraints are there
     * 
     * @throws Exception
     */
    private void testServiceInteractionConstraintsInternal( boolean withEvaluation ) throws Exception {

        Connection conn = this.createConnection( );

        Set<Constraint> constraints = this.getUnparsedConstraints( conn );
        if ( constraints.size( ) == 0 ) {
            errorAndStop( "No unparsed constraints found, you may need to run the import without parsing" );
        }

        // the context is always the message in the serviceInteractions metamodel

        RefPackage[] pkgs = new RefPackage[] { conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE ) };

        RefObject parserContext = pkgs[0].refClass( "Message" ).refMetaObject( );

        Message message1 = (Message) pkgs[0].refClass( "Message" ).refCreateInstance( Collections.EMPTY_LIST );
        Message message2 = (Message) pkgs[0].refClass( "Message" ).refCreateInstance( Collections.EMPTY_LIST );
        Message message3 = (Message) pkgs[0].refClass( "Message" ).refCreateInstance( Collections.EMPTY_LIST );
        Message message4 = (Message) pkgs[0].refClass( "Message" ).refCreateInstance( Collections.EMPTY_LIST );
        Message message5 = (Message) pkgs[0].refClass( "Message" ).refCreateInstance( Collections.EMPTY_LIST );
        // messages 1 and 2 form a circle (not ok)
        message1.setReplyTo( message2 );
        message2.setReplyTo( message1 );
        // message 3 replies to itself (not ok)
        message3.setReplyTo( message3 );
        message4.setReplyTo( message5 );

        try {

            for ( Iterator<Constraint> it = constraints.iterator( ); it.hasNext( ); ) {
                Constraint constraint = it.next( );
                String rootPackage = (String) constraint.getQualifiedName( ).get( 0 );
                if ( !rootPackage.equals( "ServiceInteractions" ) ) {
                    continue;
                }
                System.out.println( "Constraint: " + constraint.getQualifiedName( ) );
                String expression = constraint.getExpression( );
                System.out.println( "Expression: " + expression );

                Collection<OclStatement> statements = this.parse( expression, parserContext, pkgs );
                System.out.println( "Parsing was successful" );
                if ( withEvaluation ) {
                    for ( OclStatement stmt : statements ) {
                        System.out.println( "Evaluation result for message1: " + this.evaluateInvariant( stmt.getExpression( ), message1 ) );
                        System.out.println( "Evaluation result for message2: " + this.evaluateInvariant( stmt.getExpression( ), message2 ) );
                        System.out.println( "Evaluation result for message3: " + this.evaluateInvariant( stmt.getExpression( ), message3 ) );
                        System.out.println( "Evaluation result for message4: " + this.evaluateInvariant( stmt.getExpression( ), message4 ) );
                    }
                }

            }
        } finally {
            // cleanup
            Collection<Partitionable> elements = ( (CoreConnection) conn ).getNullPartition( ).getElements( );
            for ( Partitionable element : elements ) {
                if ( element instanceof ModelElement ) {
                    try {
                        ( (ModelElement) element ).refDelete( );
                    } catch ( RuntimeException e ) {
                        // duh
                    }
                }
            }
            conn.close( );
        }
    }

    @SuppressWarnings( "unchecked" )
    private Set<Constraint> getUnparsedConstraints( Connection connection ) throws Exception {

        Collection<Constraint> result = (Collection) connection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL ).refClass( "Constraint" ).refAllOfClass( );
        Set<Constraint> resultset = new HashSet<Constraint>( );
        resultset.addAll( result );
        if ( resultset.isEmpty( ) ) {
            throw new IllegalStateException( "No unparsed constraints found, please import the ServiceInteractions metamodel without the constraints" );
        }
        return resultset;
    }

    private boolean evaluateInvariant( OclExpression expr, RefObject context ) throws ExpressionUndefinedException {

        OclAny self = OclFactory.instance( ).create( context );
        EvaluationContext evalCtx = new EvaluationContextImpl( self );
        try {
            ExpressionEvaluator exprEvaluator = ExpressionEvaluator.instance( );
            OclAny value = exprEvaluator.evaluate( coreConnection, expr, evalCtx );
            if ( OclVoidImpl.OCL_UNDEFINED.equals( value ) ) {
                throw new ExpressionUndefinedException( OclServiceExceptions.EXPEVALUATESTOUNDEFINED );
            }
            if ( !( value instanceof OclBoolean ) ) {
                throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_001, value.toString( ) );
            }
            return ( (OclBoolean) value ).getWrappedBoolean( ).booleanValue( );
        } finally {
            // Reset the current context so that the current thread can create
            // a new one later if required.
            EvaluationContext.CurrentContext.reset( );
        }
    }
}
