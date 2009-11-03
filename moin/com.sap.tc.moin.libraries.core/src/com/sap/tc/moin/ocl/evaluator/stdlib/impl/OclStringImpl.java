package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclString;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * {@link OclString} implementation.
 */
public class OclStringImpl extends BaseOclAny implements OclString {

    private final String underlyingValue;

    /**
     * Create a new OclString that wraps the supplied
     * <code>underlyingValue</code>.
     * 
     * @param theString the String to wrap
     */
    public OclStringImpl( String theString ) {

        this.underlyingValue = theString;
    }

    /* Specified by interface */
    public Object getWrappedObject( ) {

        return getWrappedString( );
    }

    /* Specified by interface */
    public String getWrappedString( ) {

        return this.underlyingValue;
    }

    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException {

        /*
         * If this causes a performance problem, it would be possible to change
         * this into a switch statement instead by mapping the operation names
         * to an integer key.
         */
        if ( OclConstants.OP_SIZE.equals( opName ) ) {
            return evaluateSize( );
        }
        if ( OclConstants.OP_CONCAT.equals( opName ) ) {
            return evaluateConcat( args );
        }
        if ( OclConstants.OP_SUBSTRING.equals( opName ) ) {
            return evaluateSubstring( args );
        }
        if ( OclConstants.OP_TOINTEGER.equals( opName ) ) {
            return evaluateToInteger( );
        }
        if ( OclConstants.OP_TOFLOAT.equals( opName ) ) {
            return evaluateToFloat( );
        }
        if ( OclConstants.OP_TODOUBLE.equals( opName ) ) {
            return evaluateToDouble( );
        }
        if ( OclConstants.OP_TOLONG.equals( opName ) ) {
            return evaluateToLong( );
        }
        if ( OclConstants.OP_MATCHES.equals( opName ) ) {
            return evaluateMatches( args );
        }
        if ( OclConstants.OP_TOUPPER.equals( opName ) ) {
            return evaluateToUpperCase( );
        }
        if ( OclConstants.OP_TOLOWER.equals( opName ) ) {
            return evaluateToLowerCase( );
        }
        return super.callOperation( connection, opName, args );

    }

    private OclAny evaluateToLowerCase( ) {

        return new OclStringImpl( this.underlyingValue.toLowerCase( Locale.ENGLISH ) );
    }

    private OclAny evaluateToUpperCase( ) {

        return new OclStringImpl( this.underlyingValue.toUpperCase( Locale.ENGLISH ) );
    }

    private OclAny evaluateMatches( OclAny[] args ) {

        if ( args[0].equals( OclInvalidImpl.OCL_INVALID ) || args[0].equals( OclVoidImpl.OCL_UNDEFINED ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        String matchPattern = (String) args[0].getWrappedObject( );
        if ( this.underlyingValue.matches( matchPattern ) ) {
            return OclBoolean.TRUE;
        }
        return OclBoolean.FALSE;
    }

    private OclAny evaluateToLong( ) {

        try {
            long result = Long.parseLong( this.underlyingValue );
            return new OclLongImpl( Long.valueOf( result ) );
        } catch ( NumberFormatException nfe ) {
            return OclInvalidImpl.OCL_INVALID;
        }
    }

    private OclAny evaluateToDouble( ) {

        try {
            double result = Double.parseDouble( this.underlyingValue );
            return new OclDoubleImpl( new Double( result ) );
        } catch ( NumberFormatException nfe ) {
            return OclInvalidImpl.OCL_INVALID;
        }
    }

    private OclAny evaluateSize( ) {

        int result = this.underlyingValue.length( );
        return new OclIntegerImpl( Integer.valueOf( result ) );
    }

    private OclAny evaluateToInteger( ) {

        try {
            int result = Integer.parseInt( this.underlyingValue );
            return new OclIntegerImpl( Integer.valueOf( result ) );
        } catch ( NumberFormatException nfe ) {
            return OclInvalidImpl.OCL_INVALID;
        }
    }

    private OclAny evaluateToFloat( ) {

        try {
            float result = Float.parseFloat( this.underlyingValue );
            return new OclFloatImpl( new Float( result ) );
        } catch ( NumberFormatException nfe ) {
            return OclInvalidImpl.OCL_INVALID;
        }
    }

    private OclAny evaluateConcat( OclAny[] args ) {

        if ( args[0].equals( OclInvalidImpl.OCL_INVALID ) ) {
            return args[0];
        }
        if ( args[0].equals( OclVoidImpl.OCL_UNDEFINED ) ) {
            return new OclStringImpl( this.underlyingValue + OclVoidImpl.OCL_UNDEFINED.toString( ) );
        }
        OclStringImpl arg = (OclStringImpl) args[0];
        return new OclStringImpl( this.underlyingValue + arg.underlyingValue );
    }

    private OclAny evaluateSubstring( OclAny[] args ) {

        if ( args[0].equals( OclInvalidImpl.OCL_INVALID ) ) {
            return args[0];
        }
        if ( args[1].equals( OclInvalidImpl.OCL_INVALID ) ) {
            return args[1];
        }
        OclIntegerImpl lowerArg = (OclIntegerImpl) args[0];
        OclIntegerImpl upperArg = (OclIntegerImpl) args[1];
        int lower = ( (Integer) lowerArg.getWrappedObject( ) ).intValue( );
        int upper = ( (Integer) upperArg.getWrappedObject( ) ).intValue( );
        if ( lower < 1 || upper > this.underlyingValue.length( ) || lower > upper ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        String result = this.underlyingValue.substring( lower - 1, upper );
        return new OclStringImpl( result );
    }

    /**
     * Implementation of "oclIsKindOf" method. Returns true if the argument
     * represents the String or OclAny type, false otherwise.
     */
    @Override
    boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier ) {

        return isUnderlyingValueTypeOf( connection, classifier ) || super.isOclAnyType( connection, classifier );
    }

    /**
     * Implementation of "oclIsTypeOf" method. Returns true if the argument
     * represents the String type, false otherwise.
     */
    @Override
    boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier ) {

        return classifier instanceof PrimitiveType && OclConstants.T_STRING.equals( classifier.getName( ) );
    }

    @Override
    protected OclAny evaluateAsToString( CoreConnection connection ) {

        return new OclStringImpl( this.underlyingValue );
    }
}
