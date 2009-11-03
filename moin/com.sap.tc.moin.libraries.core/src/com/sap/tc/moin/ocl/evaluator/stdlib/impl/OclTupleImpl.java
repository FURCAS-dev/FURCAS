package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Classifier;

import com.sap.tc.moin.ocl.evaluator.EvaluatorException;
import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclTuple;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * {@link OclTuple} implementation.
 */
public class OclTupleImpl extends BaseOclAny implements OclTuple {

    // Maps the String tuple part name to its OclAny value
    private final Map<String, OclAny> nameValuePairs;

    /**
     * Create a new OclTuple that wraps the supplied <code>nameValuePairs</code>
     * .
     * 
     * @param theNameValuePairs the tuples to wrap
     */
    public OclTupleImpl( Map<String, OclAny> theNameValuePairs ) {

        if ( theNameValuePairs == null ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.UNDERLYINGVALUENOTNULL );
        }
        if ( theNameValuePairs.isEmpty( ) ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.CANNOTCREATEEMPTYTUPLE );
        }
        this.nameValuePairs = theNameValuePairs;
    }

    /* Specified by interface */
    public Object getWrappedObject( ) {

        return this.nameValuePairs;
    }

    /* Specified by interface */
    public OclAny getValue( String name ) throws EvaluatorException {

        OclAny value = this.nameValuePairs.get( name );
        if ( value == null ) {
            throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_013, name );
        }
        return value;
    }

    // TODO: Remove this once this class doesn't implement OclAny
    /* Specified by interface */
    @Override
    boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier ) {

        throw new MoinUnsupportedOperationException( "isUnderlyingValueKindOf" ); //$NON-NLS-1$
    }

    // TODO: Remove this once this class doesn't implement OclAny
    /* Specified by interface */
    @Override
    boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier ) {

        throw new MoinUnsupportedOperationException( "isUnderlyingValueTypeOf" ); //$NON-NLS-1$
    }

    @Override
    protected OclAny evaluateAsToString( CoreConnection connection ) {

        StringBuilder stringValue = new StringBuilder( );
        stringValue.append( "Tuple{" ); //$NON-NLS-1$
        for ( Map.Entry<String, OclAny> pair : this.nameValuePairs.entrySet( ) ) {
            stringValue.append( pair.getKey( ) );
            stringValue.append( " = " ); //$NON-NLS-1$
            BaseOclAny value = (BaseOclAny) pair.getValue( );
            stringValue.append( value.toBaseString( ) );
            stringValue.append( ", " ); //$NON-NLS-1$
        }
        if ( this.nameValuePairs.size( ) > 0 ) {
            stringValue.setCharAt( stringValue.length( ) - 2, '}' );
            stringValue.deleteCharAt( stringValue.length( ) - 1 );

        } else {
            stringValue.append( "}" ); //$NON-NLS-1$
        }
        return new OclStringImpl( stringValue.toString( ) );
    }
}
