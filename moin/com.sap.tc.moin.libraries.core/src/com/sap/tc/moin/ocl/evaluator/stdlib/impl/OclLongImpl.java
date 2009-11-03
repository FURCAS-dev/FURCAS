package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclInteger;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclLong;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;

/**
 * The Long implementation
 */
public class OclLongImpl extends OclDoubleImpl implements OclLong {

    private final Long underlyingValue;

    /**
     * Create a new OclString that wraps the supplied
     * <code>underlyingValue</code>.
     */
    OclLongImpl( Long theLong ) {

        super( new Double( theLong.floatValue( ) ) );
        this.underlyingValue = theLong;
    }

    @Override
    public Object getWrappedObject( ) {

        return getWrappedLong( );
    }

    /* Specified by interface */
    public Long getWrappedLong( ) {

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
         * to an Long key.
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
        if ( OclConstants.OP_LONGDIVSTDLIB.equals( opName ) ) {
            return evaluateDiv( args );
        }
        if ( OclConstants.OP_LONGDIVSTDLIB.equals( opName ) ) {
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

    /**
     * Implementation of "+" method evaluation.
     */
    private OclAny evaluatePlus( OclAny[] args ) {

        long argValue = convertFirstArgToLong( args );
        long result = this.underlyingValue.longValue( ) + argValue;
        return new OclLongImpl( Long.valueOf( result ) );
    }

    /**
     * Implementation of "-" method evaluation, both unary and binary.
     */
    private OclAny evaluateMinus( OclAny[] args ) {

        long result;
        if ( args.length == 0 ) {
            // Unary "-"
            result = -( this.underlyingValue.longValue( ) );
        } else {
            // Binary "-"
            long argValue = convertFirstArgToLong( args );
            result = this.underlyingValue.longValue( ) - argValue;
        }
        return new OclLongImpl( Long.valueOf( result ) );
    }

    /**
     * Implementation of "*" method evaluation.
     */
    private OclAny evaluateMultiply( OclAny[] args ) {

        long argValue = convertFirstArgToLong( args );
        long result = this.underlyingValue.longValue( ) * argValue;
        return new OclLongImpl( Long.valueOf( result ) );
    }

    /**
     * Implementation of "/" method evaluation.
     */
    private OclAny evaluateDivide( OclAny[] args ) {

        // check for divide by zero
        long argIntValue = convertFirstArgToLong( args );
        if ( argIntValue == 0 ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        double result = (double) this.underlyingValue.longValue( ) / (double) argIntValue;
        return new OclDoubleImpl( new Double( result ) );
    }

/**
     * Implementation of "<" method evaluation.
     */
    private OclAny evaluateLessThan( OclAny[] args ) {

        long argValue = convertFirstArgToLong( args );
        boolean result = this.underlyingValue.longValue( ) < argValue;
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of ">" method evaluation.
     */
    private OclAny evaluateGreaterThan( OclAny[] args ) {

        long argValue = convertFirstArgToLong( args );
        boolean result = this.underlyingValue.longValue( ) > argValue;
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "<=" method evaluation.
     */
    private OclAny evaluateLessThanOrEqual( OclAny[] args ) {

        long argValue = convertFirstArgToLong( args );
        boolean result = this.underlyingValue.longValue( ) <= argValue;
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of ">=" method evaluation.
     */
    private OclAny evaluateGreaterThanOrEqual( OclAny[] args ) {

        long argValue = convertFirstArgToLong( args );
        boolean result = this.underlyingValue.longValue( ) >= argValue;
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "abs" method evaluation
     */
    private OclAny evaluateAbsolute( ) {

        if ( this.underlyingValue.longValue( ) >= 0 ) {
            return this;
        }
        long result = -( this.underlyingValue.longValue( ) );
        return new OclLongImpl( Long.valueOf( result ) );
    }

    /**
     * Implementation of "max" method evaluation
     */
    private OclAny evaluateMax( OclAny[] args ) {

        long argValue = convertFirstArgToLong( args );
        long underlyingIntValue = this.underlyingValue.longValue( );
        long max = Math.max( underlyingIntValue, argValue );

        return ( max == underlyingIntValue ? this : new OclLongImpl( Long.valueOf( max ) ) );
    }

    /**
     * Implementation of "min" method evaluation
     */
    private OclAny evaluateMin( OclAny[] args ) {

        long argValue = convertFirstArgToLong( args );
        long underlyingIntValue = this.underlyingValue.longValue( );
        long min = Math.min( underlyingIntValue, argValue );
        return ( min == underlyingIntValue ? this : new OclLongImpl( Long.valueOf( min ) ) );
    }

    /**
     * Implementation of "div" method evaluation
     */
    private OclAny evaluateDiv( OclAny[] args ) {

        long argIntValue = convertFirstArgToLong( args );
        if ( argIntValue == 0 ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        long result = this.underlyingValue.longValue( ) / argIntValue;
        return new OclLongImpl( Long.valueOf( result ) );
    }

    /**
     * Implementation of "mod" method evaluation
     */
    private OclAny evaluateMod( OclAny[] args ) {


        long argIntValue = convertFirstArgToLong( args );
        if ( argIntValue == 0 ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        long result = this.underlyingValue.longValue( ) % argIntValue;
        return new OclLongImpl( Long.valueOf( result ) );
    }

    private long convertFirstArgToLong( OclAny[] args ) {

        OclAny firstArg = args[0];
        if ( firstArg instanceof OclLong ) {
            OclLongImpl arg = (OclLongImpl) args[0];
            return arg.underlyingValue.longValue( );
        }
        if ( firstArg instanceof OclInteger ) {
            OclIntegerImpl arg = (OclIntegerImpl) args[0];
            return arg.getWrappedInteger( ).longValue( );
        }
        throw new MoinIllegalArgumentException( "firstArgument" ); //$NON-NLS-1$
    }

    /**
     * Implementation of "oclIsKindOf" method. Returns true if the argument
     * represents the Long, Real or OclAny type, false otherwise.
     */
    @Override
    boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier ) {

        return isUnderlyingValueTypeOf( connection, classifier ) || super.isUnderlyingValueTypeOf( connection, classifier ) || super.isOclAnyType( connection, classifier );
    }

    /**
     * Implementation of "oclIsTypeOf" method. Returns true if the argument
     * represents the Long type, false otherwise.
     */
    @Override
    boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier ) {

        return classifier instanceof PrimitiveType && OclConstants.T_LONG.equals( classifier.getName( ) );
    }

    @Override
    protected OclAny evaluateAsToString( CoreConnection connection ) {

        return new OclStringImpl( Long.toString( this.underlyingValue.longValue( ) ) );
    }
}
