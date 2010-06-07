package com.sap.tc.moin.ocl.evaluator;

import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclInvalidImpl;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * Default {@link EvaluationContext} implementation.
 * <p />
 * Note that only one context can be created per thread via the exposed
 * constructor. All others in the same thread must be created using the
 * {@link #push} method unless an explicit call to
 * {@link EvaluationContext.CurrentContext#reset} has been made.
 */
public class EvaluationContextImpl implements EvaluationContext {

    /** The internal map of String variable names to OclAny variable values. */
    private final Map<String, OclAny> variables = new HashMap<String, OclAny>( );

    /** The outer context if this context pushed on to the stack */
    private final EvaluationContext parentCtx;

    /**
     * Creates a new EvaluationContext and sets it as the CurrentContext for the
     * thread.
     * 
     * @param self The value of the "self" variable
     * @throws IllegalStateException Thrown if an EvaluationContext has already
     * been created in the current thread with this constructor, and not cleared
     * using the {@link EvaluationContext.CurrentContext#reset} method.
     */
    public EvaluationContextImpl( OclAny self ) {

        this( self, null );
        if ( EvaluationContext.CurrentContext.isSet( ) ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.EVALCONTEXTALREADYSET );
        }
        EvaluationContext.CurrentContext.set( this );
    }

    /**
     * Creates a new EvaluationContext from the supplied parameters.
     * 
     * @param thePkgFinder
     * @param parentContext The context that this context is being pushed on to
     * @see #EvaluationContextImpl(OclAny)
     */
    private EvaluationContextImpl( OclAny self, EvaluationContext parentContext ) {

        if ( self == null ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.SELFMUSTNOTBENULL );
        }
        this.parentCtx = parentContext;
        setVariable( OclConstants.VAR_SELF, self );
        setVariable( OclConstants.VAR_NULL, OclVoidImpl.OCL_UNDEFINED );
        setVariable( OclConstants.VAR_INVALID, OclInvalidImpl.OCL_INVALID );

    }

    /* Specified by interface */
    public EvaluationContext push( OclAny newSelf ) {

        EvaluationContextImpl newCtx = new EvaluationContextImpl( newSelf, this );
        // Set the current context for the thread to the pushed context
        EvaluationContext.CurrentContext.set( newCtx );
        return newCtx;
    }

    /* Specified by interface */
    public void pop( ) {

        if ( this.parentCtx == null ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.CANNOTPOP );
        }
        // Set the current context for the thread back to the parent context
        EvaluationContext.CurrentContext.set( this.parentCtx );
    }

    /* Specified by interface */
    public OclAny getVariable( String name ) {

        return this.variables.get( name );
    }

    /* Specified by interface */
    public void setVariable( String name, OclAny value ) {

        if ( name == null ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.VARNAMEMUSTNOTBENULL );
        }
        if ( value == null ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.VARVALUEMUSTNOTBENULL );
        }
        this.variables.put( name, value );
    }
    
    public void unsetVariable(String name) {
	this.variables.remove(name);
    }
}
