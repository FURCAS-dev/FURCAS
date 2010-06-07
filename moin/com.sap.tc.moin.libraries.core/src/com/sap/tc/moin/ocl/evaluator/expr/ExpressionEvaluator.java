package com.sap.tc.moin.ocl.evaluator.expr;

import java.util.Set;

import org.omg.ocl.expressions.ModelPropertyCallExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.PropertyCallExp;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.StackedEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode.NodeRoleTypes;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

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

    /**
     * Evaluate the supplied <code>expression</code> using the supplied
     * <code>ctx</code>, and return the result.
     * 
     * @param connection the core connection
     * @param expression The expression to evaluate
     * @param ctx The context that the expression is to be evaluated in. With the current implementation,
     * the key reason to ask to this in the signature is that it forces the called to create an
     * instances of {@link EvaluationContext} before calling this method which in turn puts the
     * {@link EvaluationContext} object on the {@link EvaluationContext.CurrentContext} for the current
     * thread.
     * @return The result of the expression
     */
    public abstract OclAny evaluate(CoreConnection connection, OclExpression expression, EvaluationContext ctx,
	    Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting);
    
    /**
     * Like {@link #evaluate(CoreConnection, OclExpression, EvaluationContext, Set)}, but pushes
     * <tt>sourceObject</tt> onto the evaluation stack in role {@link NodeRoleTypes#Source} so that
     * the {@link ModelPropertyCallExp} <tt>expression</tt> can use it instead of having to compute it.<p>
     * 
     * If <tt>expression</tt>'s source expression is of collection type (upper multiplicity greater than 1),
     * and <tt>sourceObject</tt> is not an {@link OclCollection}, an {@link OclCollection} will be created
     * on the fly to wrap <tt>sourceObject</tt> appropriately to, e.g., let loop expressions work properly.
     * 
     * @param throwExceptionWhenVisiting an exception will be thrown when the evaluator tries to
     * navigate the {@link Pair#getA()} feature (an {@link Attribute} or {@link AssociationEnd})
     * starting at the {@link Pair#getB()} element. May be <tt>null</tt> which has the same effect
     * as passing an empty map.
     */
    public abstract OclAny evaluate(CoreConnection connection, PropertyCallExp expression, OclAny sourceObject,
	    Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting);

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

    /**
     * Evaluates an OCL iterator expression body with a single iterator variable and sets the iterator variable to the
     * <tt>sourceObject</tt> passed.
     * 
     * @param throwExceptionWhenVisiting
     *            an exception will be thrown when the evaluator tries to navigate the {@link Pair#getA()} feature (an
     *            {@link Attribute} or {@link AssociationEnd}) starting at the {@link Pair#getB()} element. May be
     *            <tt>null</tt> which has the same effect as passing an empty map.
     */
    public abstract OclAny evaluateIteratorBody(CoreConnection connection, OclExpression expression,
	    String iteratorName, OclAny sourceObject,
	    Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting);
}