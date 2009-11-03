package com.sap.tc.moin.repository.test.ocl.base;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.omg.ocl.expressions.OclExpression;

import com.sap.serviceinteractions.Message;
import com.sap.serviceinteractions.ServiceInteractionsPackage;
import com.sap.serviceinteractions.__impl.MessageImpl;
import com.sap.serviceinteractions.__impl.ServiceInteractionsPackageImpl;
import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.EvaluatorException;
import com.sap.tc.moin.ocl.evaluator.ExpressionUndefinedException;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclInvalidImpl;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;

/**
 * Provides basic operations for integration test classes.
 */
public abstract class BaseOclEvaluationTest extends BaseOclTest {

    protected ServiceInteractionsPackageImpl svcIntPkg;

    protected RefPackage[] types;

    protected MessageImpl message;

    protected ExpressionEvaluator evaluator = ExpressionEvaluator.instance( );

    private RefClass class1;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        ServiceInteractionsPackage wrappedPackage = this.getMOINConnection( ).getPackage( ServiceInteractionsPackage.PACKAGE_DESCRIPTOR );
        this.svcIntPkg = (ServiceInteractionsPackageImpl) getTestHelper( ).getCorePartitionable( wrappedPackage );
        this.types = new RefPackage[] { this.svcIntPkg };
        synchronized ( this.syncObjectForWrite ) {
            Message wrappedMessage = coreConnection.getWrapper( ).createElementInPartition( Message.class, null );
            this.message = (MessageImpl) getTestHelper( ).getCorePartitionable( wrappedMessage );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        svcIntPkg = null;
        types = null;
        message = null;
        evaluator = null;
    }

    /**
     * Evaluates all OCL constraints on the supplied <code>refObject</code>.
     * 
     * @param refObj An instance to evaluate
     * @param statements the constraints
     * @return <code>true</code> if the <code>refObj</code> is valid according
     * its constraints, <code>false</code> otherwise.
     */
    public boolean evaluate( RefObject refObj, Collection<OclStatement> statements ) {

        if ( statements == null ) {
            return false;
        }
        for ( Iterator<OclStatement> it = statements.iterator( ); it.hasNext( ); ) {
            OclStatement stmt = it.next( );
            if ( stmt.getKind( ) != OclStatement.INVARIANT ) {
                continue;
            }
            try {
                if ( !evaluateInvariant( stmt.getExpression( ), refObj ) ) {
                    return false;
                }
            } catch ( ExpressionUndefinedException e ) {
                flop( "The expression evaluated to OclUndefined" );
            }
        }

        return true;
    }

    protected Collection<OclStatement> parse( String string ) {

        RefClass msgProxy = this.coreConnection.getClass( Message.CLASS_DESCRIPTOR );
        return this.parse( string, msgProxy.refMetaObject( ), new RefPackage[] { this.svcIntPkg } );
    }

    protected OclExpression parseExp( String string ) {

        RefClass msgProxy = this.coreConnection.getClass( Message.CLASS_DESCRIPTOR );
        Collection<OclStatement> statements = this.parse( string, msgProxy.refMetaObject( ), new RefPackage[] { this.svcIntPkg } );

        if ( statements.size( ) == 1 ) {
            OclStatement statement = statements.iterator( ).next( );
            if ( statement.getKind( ) == OclStatement.EXPRESSION ) {
                return statement.getExpression( );
            }
        }

        // no expression
        throw new RuntimeException( "Provided string is not an OCL expression!" );
    }

    protected void parseFail( String ocl ) {

        RefClass msgProxy = this.coreConnection.getClass( Message.CLASS_DESCRIPTOR );
        parseFail( ocl, msgProxy.refMetaObject( ), new RefPackage[] { this.svcIntPkg } );

    }

    protected boolean evaluateInvariant( OclExpression expr, RefObject context ) throws ExpressionUndefinedException {

        OclAny self = OclFactory.instance( ).create( context );
        EvaluationContext evalCtx = new EvaluationContextImpl( self );
        try {
            ExpressionEvaluator exprEvaluator = ExpressionEvaluator.instance( );
            OclAny value = exprEvaluator.evaluate( coreConnection, expr, evalCtx );
            if ( OclVoidImpl.OCL_UNDEFINED.equals( value ) || OclInvalidImpl.OCL_INVALID.equals( value ) ) {
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

    protected OclAny evaluateExpression( OclExpression expr, RefObject context ) {

        OclAny self = OclFactory.instance( ).create( context );
        EvaluationContext evalCtx = new EvaluationContextImpl( self );
        try {
            ExpressionEvaluator exprEvaluator = ExpressionEvaluator.instance( );
            OclAny value = exprEvaluator.evaluate( coreConnection, expr, evalCtx );
            // if (OclVoid.OCL_UNDEFINED.equals(value)) {
            // throw new ExpressionUndefinedException();
            // }
            // if (!(value instanceof OclBoolean)) {
            // throw new EvaluatorException(MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_001, value.toString());
            // }
            return value;
        } finally {
            // Reset the current context so that the current thread can create
            // a new one later if required.
            EvaluationContext.CurrentContext.reset( );
        }
    }

}