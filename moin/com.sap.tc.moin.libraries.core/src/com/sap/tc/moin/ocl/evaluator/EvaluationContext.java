package com.sap.tc.moin.ocl.evaluator;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;


/**
 * Context to keep track of variables during expression evaluation.
 * <p />
 * By default, there are two variables that always exist in the context. These
 * names of these variables are "<code>self</code>" and "
 * <code>OclUndefined</code>".
 * <p />
 * Contexts can be stacked for the purpose of scoping. When a context is pushed
 * on to the stack, it becomes the context for the current thread. When that
 * context is popped, the previous context is restored as the context for the
 * current thread. See the {@link #push} and {@link #pop} methods for details.
 * <p />
 * <b>Note:</b> The name of this type should not be confused with the term
 * "context", used to describe the "self" variable.
 */
public interface EvaluationContext {


    /**
     * Get a variable by its name
     * 
     * @param name the variable's name
     * @return The variable with the supplied name.
     */
    public OclAny getVariable( String name );


    /**
     * Assign the supplied variable <code>value</code> to the variable
     * <code>name</code> in this context.
     * <p />
     * <b>Note:</b> If a variable has already been set under the given
     * <code>name</code>, the previous value is overwriten. This behaviour is
     * required during iteration, where a different value is set for the
     * iterator variable name at each step of the iteration.
     * 
     * @param name the variable name
     * @param value the variable value
     */
    public void setVariable( String name, OclAny value );

    /**
     * Create a new EvaluationContext which is stacked on top of this context,
     * and set the new context as the {@link CurrentContext} for the thread.
     * <p * />
     * <b>Important:</b> If this method is called, a corresponding call to
     * {@link #pop} must be made on the new context when it is finished with.
     * This should be done in a <code>finally</code> block to ensure that it
     * occurs.
     * 
     * @param self The value of the "self" variable for the new context
     * @return The newly created context
     */
    public EvaluationContext push( OclAny self );

    /**
     * Remove this context from the top of the stack, replacing the
     * {@link CurrentContext} with the context that this was pushed on to.
     * 
     * @throws IllegalStateException Thrown if this context was not created
     * using the {@link #push} method.
     */
    public void pop( );

    /**
     * Holds a reference to the context for the current thread.
     */
    public static class CurrentContext {

        private static ThreadLocal<EvaluationContext> currentContext = new ThreadLocal<EvaluationContext>( );

        /**
         * Return the context for the current thread.
         * 
         * @return the current evaluation context
         * @throws IllegalStateException Thrown if no context has been set for
         * the current thread.
         */
        public static EvaluationContext get( ) {

            EvaluationContext ctx = currentContext.get( );
            if ( ctx == null ) {
                throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.EVALCONTEXTNOTSET );
            }
            return ctx;
        }

        /**
         * Set the context for the current thread.
         */
        static void set( EvaluationContext ctx ) {

            currentContext.set( ctx );
        }

        /**
         * @return <code>true</code> if a context exists for the current thread.
         */
        static boolean isSet( ) {

            return ( currentContext.get( ) != null );
        }

        /**
         * Clears the context for the current thread.
         */
        public static void reset( ) {

            currentContext.set( null );
        }
    }
}
