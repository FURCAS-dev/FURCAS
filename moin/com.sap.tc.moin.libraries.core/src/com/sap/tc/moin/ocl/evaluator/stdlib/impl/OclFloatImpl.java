package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFloat;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * {@link OclFloat} implementation.
 */
public class OclFloatImpl extends BaseOclAny implements OclFloat {

    private static final Float ZERO = new Float( 0.0 );

    private static final Float NEGATIVE_ZERO = new Float( -0.0 );

    private final Float underlyingValue;

    /**
     * Create a new OclString that wraps the supplied
     * <code>underlyingValue</code>.
     */
    OclFloatImpl( Float theFloat ) {

        if ( NEGATIVE_ZERO.equals( theFloat ) ) {
            // As per OclReal interface, -0.0 is treated as 0.0
            this.underlyingValue = ZERO;
        } else {
            this.underlyingValue = theFloat;
        }
    }

    /* Specified by interface */
    public Object getWrappedObject( ) {

        return getWrappedFloat( );
    }

    /* Specified by interface */
    public Float getWrappedFloat( ) {

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
        if ( OclConstants.OP_MINUSSTDLIB.equals( opName ) || OclConstants.OP_NEGSTDLIB.equals( opName ) ) {
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
        if ( OclConstants.OP_FLOOR.equals( opName ) ) {
            return evaluateFloor( );
        }
        if ( OclConstants.OP_ROUND.equals( opName ) ) {
            return evaluateRound( );
        }
        if ( OclConstants.OP_MAX.equals( opName ) ) {
            return evaluateMax( args );
        }
        if ( OclConstants.OP_MIN.equals( opName ) ) {
            return evaluateMin( args );
        }
        return super.callOperation( connection, opName, args );

    }

    /**
     * Implementation of "+" method evaluation.
     */
    private OclAny evaluatePlus( OclAny[] args ) {

        OclFloat arg = (OclFloat) args[0];
        float result = this.underlyingValue.floatValue( ) + arg.getWrappedFloat( ).floatValue( );
        return new OclFloatImpl( new Float( result ) );
    }

    /**
     * Implementation of "-" method evaluation, both unary and binary.
     */
    private OclAny evaluateMinus( OclAny[] args ) {

        float result;
        if ( args.length == 0 ) {
            // Unary "-"
            result = -( this.underlyingValue.floatValue( ) );
        } else {
            // Binary "-"
            OclFloatImpl arg = (OclFloatImpl) args[0];
            result = this.underlyingValue.floatValue( ) - arg.underlyingValue.floatValue( );
        }
        return new OclFloatImpl( new Float( result ) );
    }

    /**
     * Implementation of "*" method evaluation.
     */
    private OclAny evaluateMultiply( OclAny[] args ) {

        OclFloatImpl arg = (OclFloatImpl) args[0];
        float result = this.underlyingValue.floatValue( ) * arg.underlyingValue.floatValue( );
        return new OclFloatImpl( new Float( result ) );
    }

    /**
     * Implementation of "/" method evaluation.
     */
    private OclAny evaluateDivide( OclAny[] args ) {

        OclFloatImpl arg = (OclFloatImpl) args[0];
        // check for divide by zero
        if ( arg.underlyingValue.floatValue( ) == 0.0 ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        float result = this.underlyingValue.floatValue( ) / arg.underlyingValue.floatValue( );
        return new OclFloatImpl( new Float( result ) );
    }

/**
     * Implementation of "<" method evaluation.
     */
    private OclAny evaluateLessThan( OclAny[] args ) {

        OclFloatImpl arg = (OclFloatImpl) args[0];
        boolean result = this.underlyingValue.floatValue( ) < arg.underlyingValue.floatValue( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of ">" method evaluation.
     */
    private OclAny evaluateGreaterThan( OclAny[] args ) {

        OclFloatImpl arg = (OclFloatImpl) args[0];
        boolean result = this.underlyingValue.floatValue( ) > arg.underlyingValue.floatValue( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "<=" method evaluation.
     */
    private OclAny evaluateLessThanOrEqual( OclAny[] args ) {

        OclFloatImpl arg = (OclFloatImpl) args[0];
        boolean result = this.underlyingValue.floatValue( ) <= arg.underlyingValue.floatValue( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of ">=" method evaluation.
     */
    private OclAny evaluateGreaterThanOrEqual( OclAny[] args ) {

        OclFloatImpl arg = (OclFloatImpl) args[0];
        boolean result = this.underlyingValue.floatValue( ) >= arg.underlyingValue.floatValue( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of the "abs" method evaluation
     */
    private OclAny evaluateAbsolute( ) {

        if ( this.underlyingValue.floatValue( ) >= 0 ) {
            return this;
        }
        float result = -( this.underlyingValue.floatValue( ) );
        return new OclFloatImpl( new Float( result ) );
    }

    /**
     * Implementation of the "floor" method evaluation
     */
    private OclAny evaluateFloor( ) {

        int result = (int) Math.floor( this.underlyingValue.floatValue( ) );
        return new OclIntegerImpl( Integer.valueOf( result ) );
    }

    /**
     * Implementation of the "round" method evaluation
     */
    private OclAny evaluateRound( ) {

        int result = Math.round( this.underlyingValue.floatValue( ) );
        return new OclIntegerImpl( Integer.valueOf( result ) );
    }

    /**
     * Implementation of "max" method evaluation
     */
    private OclAny evaluateMax( OclAny[] args ) {

        OclFloatImpl arg = ( (OclFloatImpl) args[0] );
        float underlyingfloatValue = this.underlyingValue.floatValue( );
        float max = Math.max( underlyingfloatValue, arg.underlyingValue.floatValue( ) );
        return ( max == underlyingfloatValue ? this : arg );
    }

    /**
     * Implementation of "min" method evaluation
     */
    private OclAny evaluateMin( OclAny[] args ) {

        OclFloatImpl arg = ( (OclFloatImpl) args[0] );
        float underlyingfloatValue = this.underlyingValue.floatValue( );
        float min = Math.min( underlyingfloatValue, arg.underlyingValue.floatValue( ) );
        return ( min == underlyingfloatValue ? this : arg );
    }

    /**
     * Implementation of "oclIsKindOf" method. Returns true if the argument
     * represents the Real or OclAny type, false otherwise.
     */
    @Override
    boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier ) {

        return isUnderlyingValueTypeOf( connection, classifier ) || super.isOclAnyType( connection, classifier );
    }

    /**
     * Implementation of "oclIsTypeOf" method. Returns true if the argument
     * represents the Real type, false otherwise.
     */
    @Override
    boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier ) {

        return classifier instanceof PrimitiveType && OclConstants.T_FLOAT.equals( classifier.getName( ) );
    }

    /**
     * Implementation of "=" operation evaluation.
     */
    @Override
    protected OclAny evaluateEquals( OclAny[] args ) {

        OclAny arg = args[0];
        if ( arg.equals( OclInvalidImpl.OCL_INVALID ) ) {
            return arg;
        }
        boolean result = false;
        if ( arg.getWrappedObject( ) instanceof Number ) {
            Double d1 = new Double( this.getWrappedFloat( ).doubleValue( ) );
            Double d2 = new Double( ( (Number) arg.getWrappedObject( ) ).doubleValue( ) );
            result = d1.equals( d2 );
        }
        return OclBooleanImpl.fromValue( result );

    }

    /**
     * Implementation of "<>" operation evaluation.
     */
    @Override
    protected OclAny evaluateNotEquals( OclAny[] args ) {

        OclAny arg = args[0];
        if ( arg.equals( OclInvalidImpl.OCL_INVALID ) ) {
            return arg;
        }
        boolean result = true;
        if ( arg.getWrappedObject( ) instanceof Number ) {
            Double d1 = new Double( this.getWrappedFloat( ).doubleValue( ) );
            Double d2 = new Double( ( (Number) arg.getWrappedObject( ) ).doubleValue( ) );
            result = !d1.equals( d2 );
        }
        return OclBooleanImpl.fromValue( result );
    }

    @Override
    protected OclAny evaluateAsToString( CoreConnection connection ) {

        return new OclStringImpl( Float.toString( this.underlyingValue.floatValue( ) ) );
    }
}
