package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * {@link OclBoolean} implementation.
 */
public class OclBooleanImpl extends BaseOclAny implements OclBoolean {

    static final OclBoolean TRUE_IMPL = new OclBooleanImpl( Boolean.TRUE );

    static final OclBoolean FALSE_IMPL = new OclBooleanImpl( Boolean.FALSE );

    private final Boolean underlyingValue;

    /**
     * Convenience method that returns either {@link #TRUE_IMPL} or
     * {@link #FALSE_IMPL} based on the supplied value.
     */
    static OclBoolean fromValue( boolean value ) {

        return ( value ? TRUE_IMPL : FALSE_IMPL );
    }

    /**
     * Create a new OclBoolean that wraps the supplied
     * <code>underlyingValue</code>.
     */
    private OclBooleanImpl( Boolean value ) {

        this.underlyingValue = value;
    }

    /* Specified by interface */
    public Object getWrappedObject( ) {

        return getWrappedBoolean( );
    }

    /* Specified by interface */
    public Boolean getWrappedBoolean( ) {

        return this.underlyingValue;
    }

    /* Specified by interface */
    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException {

        /*
         * If this causes a performance problem, it would be possible to change
         * this into a switch statement instead by mapping the operation names
         * to an integer key.
         */
        if ( OclConstants.OP_OR.equals( opName ) ) {
            return evaluateOr( args );
        }
        if ( OclConstants.OP_AND.equals( opName ) ) {
            return evaluateAnd( args );
        }
        if ( OclConstants.OP_XOR.equals( opName ) ) {
            return evaluateXor( args );
        }
        if ( OclConstants.OP_NOT.equals( opName ) ) {
            return evaluateNot( );
        }
        if ( OclConstants.OP_IMPLIES.equals( opName ) ) {
            return evaluateImplies( args );
        }
        return super.callOperation( connection, opName, args );

    }

    /**
     * Implementation of "or" method evaluation.
     */
    private OclAny evaluateOr( OclAny[] args ) {

        // use OclAny to avoid casting an OclVoid
        OclAny result = this;
        if ( !this.underlyingValue.booleanValue( ) ) {
            result = args[0];
        }
        return result;
    }

    /**
     * Implementation of "and" method evaluation.
     */
    private OclAny evaluateAnd( OclAny[] args ) {

        // use OclAny to avoid casting an OclVoid
        OclAny result = this;
        if ( this.underlyingValue.booleanValue( ) ) {
            result = args[0];
        }
        return result;
    }

    /**
     * Implementation of "xor" method evaluation.
     */
    private OclAny evaluateXor( OclAny[] args ) {

        if ( args[0].equals( OclInvalidImpl.OCL_INVALID ) || args[0].equals( OclVoidImpl.OCL_UNDEFINED ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        OclBooleanImpl arg = (OclBooleanImpl) args[0];
        boolean result = this.underlyingValue.booleanValue( ) ^ arg.underlyingValue.booleanValue( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "not" method evaluation.
     * 
     * @param args not used
     */
    private OclAny evaluateNot( ) {

        boolean result = !this.underlyingValue.booleanValue( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "implies" method evaluation.
     */
    private OclAny evaluateImplies( OclAny[] args ) {

        // use OclAny to avoid casting an OclVoid
        OclAny result;
        if ( !this.underlyingValue.booleanValue( ) ) {
            result = OclBooleanImpl.TRUE_IMPL;
        } else {
            result = args[0];
        }
        return result;
    }

    /**
     * Implementation of "oclIsKindOf" method. Returns true if the argument
     * represents the Boolean or OclAny type, false otherwise.
     */
    @Override
    boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier ) {

        return isUnderlyingValueTypeOf( connection, classifier ) || super.isOclAnyType( connection, classifier );
    }

    /**
     * Implementation of "oclIsTypeOf" method. Returns true if the argument
     * represents the Boolean type, false otherwise.
     */
    @Override
    boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier ) {

        return classifier instanceof PrimitiveType && OclConstants.T_BOOLEAN.equals( classifier.getName( ) );
    }

    @Override
    protected OclAny evaluateAsToString( CoreConnection connection ) {

        return new OclStringImpl( this.underlyingValue.toString( ) );
    }
}
