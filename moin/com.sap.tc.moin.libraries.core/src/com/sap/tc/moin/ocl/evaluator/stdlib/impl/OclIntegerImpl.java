package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclInteger;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclType;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * {@link OclInteger} implementation.
 */

/* OclIntegerImpl does not extend OclRealImpl due to concerns about precision */
public class OclIntegerImpl extends OclFloatImpl implements OclInteger {

    private final Integer underlyingValue;

    /**
     * Create a new OclString that wraps the supplied
     * <code>underlyingValue</code>.
     */
    OclIntegerImpl( Integer theInteger ) {

        super( new Float( theInteger.floatValue( ) ) );
        this.underlyingValue = theInteger;
    }

    /* Specified by interface */
    @Override
    public Object getWrappedObject( ) {

        return getWrappedInteger( );
    }

    /* Specified by interface */
    public Integer getWrappedInteger( ) {

        return this.underlyingValue;
    }

    /* Specified by interface */
    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException {

        // If any arguments are OclUndefined, the result is OclUndefined
        for ( int i = 0; i < args.length; i++ ) {
            if ( OclInvalidImpl.OCL_INVALID.equals( args[i] ) || args[i].equals( OclVoidImpl.OCL_UNDEFINED ) ) {
                return OclInvalidImpl.OCL_INVALID;
            }
        }

        /*
         * If this causes a performance problem, it would be possible to change
         * this into a switch statement instead by mapping the operation names
         * to an integer key.
         */
        if ( OclConstants.OP_PLUSSTDLIB.equals( opName ) ) {
            return evaluatePlus( args );
        }
        if ( OclConstants.OP_MINUSSTDLIB.equals( opName ) ) {
            return evaluateMinus( args );
        }
        if ( OclConstants.OP_MULTSTDLIB.equals( opName ) ) {
            return evaluateMultiply( args );
        }
        if ( OclConstants.OP_DIVSTDLIB.equals( opName ) ) {
            return evaluateDivide( args );
        }
        if ( OclConstants.OP_LTSTDLIB.equals( opName ) ) {
            return evaluateLessThan( args );
        }
        if ( OclConstants.OP_GTSTDLIB.equals( opName ) ) {
            return evaluateGreaterThan( args );
        }
        if ( OclConstants.OP_LTEQSTDLIB.equals( opName ) ) {
            return evaluateLessThanOrEqual( args );
        }
        if ( OclConstants.OP_GTEQSTDLIB.equals( opName ) ) {
            return evaluateGreaterThanOrEqual( args );
        }
        if ( OclConstants.OP_ABS.equals( opName ) ) {
            return evaluateAbsolute( );
        }
        if ( OclConstants.OP_MAX.equals( opName ) ) {
            return evaluateMax( args );
        }
        if ( OclConstants.OP_MIN.equals( opName ) ) {
            return evaluateMin( args );
        }
        if ( OclConstants.OP_INTDIVSTDLIB.equals( opName ) ) {
            return evaluateDiv( args );
        }
        if ( OclConstants.OP_MOD.equals( opName ) ) {
            return evaluateMod( args );
        }
        if ( OclConstants.OP_NEGSTDLIB.equals( opName ) ) {
            return evaluateMinus( args );
        }
        return super.callOperation( connection, opName, args );
    }

    @Override
    protected OclAny evaluateAsType( CoreConnection connection, OclAny[] args ) {

        OclType type = (OclType) args[0];
        Classifier classifier = type.getWrappedClassifier( );
        if ( classifier instanceof PrimitiveType && OclConstants.T_LONG.equals( classifier.getName( ) ) ) {
            OclLongImpl longValue = new OclLongImpl( Long.valueOf( this.getWrappedInteger( ).longValue( ) ) );
            return longValue;
        }

        return super.evaluateAsType( connection, args );
    }

    /**
     * Implementation of "+" method evaluation.
     */
    private OclAny evaluatePlus( OclAny[] args ) {

        OclIntegerImpl arg = (OclIntegerImpl) args[0];
        int result = this.underlyingValue.intValue( ) + arg.underlyingValue.intValue( );
        return new OclIntegerImpl( Integer.valueOf( result ) );
    }

    /**
     * Implementation of "-" method evaluation, both unary and binary.
     */
    private OclAny evaluateMinus( OclAny[] args ) {

        int result;
        if ( args.length == 0 ) {
            // Unary "-"
            result = -( this.underlyingValue.intValue( ) );
        } else {
            // Binary "-"
            OclIntegerImpl arg = (OclIntegerImpl) args[0];
            result = this.underlyingValue.intValue( ) - arg.underlyingValue.intValue( );
        }
        return new OclIntegerImpl( Integer.valueOf( result ) );
    }

    /**
     * Implementation of "*" method evaluation.
     */
    private OclAny evaluateMultiply( OclAny[] args ) {

        OclIntegerImpl arg = (OclIntegerImpl) args[0];
        int result = this.underlyingValue.intValue( ) * arg.underlyingValue.intValue( );
        return new OclIntegerImpl( Integer.valueOf( result ) );
    }

    /**
     * Implementation of "/" method evaluation.
     */
    private OclAny evaluateDivide( OclAny[] args ) {

        OclIntegerImpl arg = (OclIntegerImpl) args[0];
        // check for divide by zero
        int argIntValue = arg.underlyingValue.intValue( );
        if ( argIntValue == 0 ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        float result = (float) this.underlyingValue.intValue( ) / (float) argIntValue;
        return new OclFloatImpl( new Float( result ) );
    }

/**
     * Implementation of "<" method evaluation.
     */
    private OclAny evaluateLessThan( OclAny[] args ) {

        OclIntegerImpl arg = (OclIntegerImpl) args[0];
        boolean result = this.underlyingValue.intValue( ) < arg.underlyingValue.intValue( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of ">" method evaluation.
     */
    private OclAny evaluateGreaterThan( OclAny[] args ) {

        OclIntegerImpl arg = (OclIntegerImpl) args[0];
        boolean result = this.underlyingValue.intValue( ) > arg.underlyingValue.intValue( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "<=" method evaluation.
     */
    private OclAny evaluateLessThanOrEqual( OclAny[] args ) {

        OclIntegerImpl arg = (OclIntegerImpl) args[0];
        boolean result = this.underlyingValue.intValue( ) <= arg.underlyingValue.intValue( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of ">=" method evaluation.
     */
    private OclAny evaluateGreaterThanOrEqual( OclAny[] args ) {

        OclIntegerImpl arg = (OclIntegerImpl) args[0];
        boolean result = this.underlyingValue.intValue( ) >= arg.underlyingValue.intValue( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "abs" method evaluation
     */
    private OclAny evaluateAbsolute( ) {

        if ( this.underlyingValue.intValue( ) >= 0 ) {
            return this;
        }
        int result = -( this.underlyingValue.intValue( ) );
        return new OclIntegerImpl( Integer.valueOf( result ) );
    }

    /**
     * Implementation of "max" method evaluation
     */
    private OclAny evaluateMax( OclAny[] args ) {

        OclIntegerImpl arg = ( (OclIntegerImpl) args[0] );
        int underlyingIntValue = this.underlyingValue.intValue( );
        int max = Math.max( underlyingIntValue, arg.underlyingValue.intValue( ) );
        return ( max == underlyingIntValue ? this : arg );
    }

    /**
     * Implementation of "min" method evaluation
     */
    private OclAny evaluateMin( OclAny[] args ) {

        OclIntegerImpl arg = ( (OclIntegerImpl) args[0] );
        int underlyingIntValue = this.underlyingValue.intValue( );
        int min = Math.min( underlyingIntValue, arg.underlyingValue.intValue( ) );
        return ( min == underlyingIntValue ? this : arg );
    }

    /**
     * Implementation of "div" method evaluation
     */
    private OclAny evaluateDiv( OclAny[] args ) {

        OclIntegerImpl arg = (OclIntegerImpl) args[0];
        int argIntValue = arg.underlyingValue.intValue( );
        if ( argIntValue == 0 ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        int result = this.underlyingValue.intValue( ) / argIntValue;
        return new OclIntegerImpl( Integer.valueOf( result ) );
    }

    /**
     * Implementation of "mod" method evaluation
     */
    private OclAny evaluateMod( OclAny[] args ) {

        OclIntegerImpl arg = (OclIntegerImpl) args[0];
        int argIntValue = arg.underlyingValue.intValue( );
        if ( argIntValue == 0 ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        int result = this.underlyingValue.intValue( ) % argIntValue;
        return new OclIntegerImpl( Integer.valueOf( result ) );
    }

    /**
     * Implementation of "oclIsKindOf" method. Returns true if the argument
     * represents the Integer, Real or OclAny type, false otherwise.
     */
    @Override
    boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier ) {

        return isUnderlyingValueTypeOf( connection, classifier ) || super.isUnderlyingValueTypeOf( connection, classifier ) || super.isOclAnyType( connection, classifier );
    }

    /**
     * Implementation of "oclIsTypeOf" method. Returns true if the argument
     * represents the Integer type, false otherwise.
     */
    @Override
    boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier ) {

        return classifier instanceof PrimitiveType && OclConstants.T_INTEGER.equals( classifier.getName( ) );
    }

    @Override
    protected OclAny evaluateAsToString( CoreConnection connection ) {

        return new OclStringImpl( Integer.toString( this.underlyingValue.intValue( ) ) );
    }
}
