package com.sap.tc.moin.ocl.evaluator.expr;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.StackedEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * Evaluates an expression and returns the result of that expression.
 * <p>
 * This ExpressionEvaluator abstract class provides a default concrete
 * implementation. At runtime, the first call to {@link #instance()} will
 * initialize the instance using the default implementation. Unless you wish to
 * provide another implementation, eg, for testing, there is no need for
 * additional sub-classes.
 */
public abstract class ExpressionEvaluator {

    // //////////////////
    // Main interface //
    // //////////////////

    /**
     * Evaluate the supplied <code>expression</code> using the supplied
     * <code>ctx</code>, and return the result.
     * 
     * @param connection the core connection
     * @param expression The expression to evaluate
     * @param ctx The context that the expression is to be evaluated in
     * @return The result of the expression
     */
    public abstract OclAny evaluate( CoreConnection connection, OclExpression expression, EvaluationContext ctx );

    // ///////////////////////////////////////////////////////////////
    // Registry pattern to lookup the ExpressionEvaluator instance //
    // ///////////////////////////////////////////////////////////////

    private static ExpressionEvaluator instance;

    /**
     * Initialise the ExpressionEvaluator instance. Subsequent calls to
     * {@link #instance()} will return the supplied
     * <code>expressionEvaluator</code>.
     * <p>
     * <b>NOTE:</b> This method has been provided to assist with testing when
     * you wish to stub out the ExpressionEvaluator instance. The default
     * implementation should be used in other cases.
     * 
     * @param expressionEvaluator the evaluator to use
     */
    public static void init( ExpressionEvaluator expressionEvaluator ) {

        ExpressionEvaluator.instance = expressionEvaluator;
    }

    /**
     * Initialize the ExpressionEvaluator instance with the default
     * implementation.
     */
    public static void defaultInit( ) {

        init( new StackedEvaluator( ) );
    }

    /**
     * Return the ExpressionEvaluator instance, initializing it to the default
     * implementation if it isn't already initialized.
     * 
     * @return the instance
     */
    public static ExpressionEvaluator instance( ) {

        if ( instance == null ) {
            defaultInit( );
        }
        return instance;
    }
}