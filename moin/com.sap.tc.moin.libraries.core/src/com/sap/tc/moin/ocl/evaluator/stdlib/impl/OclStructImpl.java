package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.ocl.evaluator.EvaluatorException;
import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclStruct;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * {@link OclStruct} implementation.
 */
public class OclStructImpl extends BaseOclAny implements OclStruct {

    private final RefStruct underlyingRefStruct;

    /**
     * Create a new OclEnum that wraps the supplied
     * <code>underlyingRefEnum</code>.
     * 
     * @param theStruct the RefStruct to wrap
     */
    public OclStructImpl( RefStruct theStruct ) {

        this.underlyingRefStruct = theStruct;
    }

    /* Specified by interface */
    public Object getWrappedObject( ) {

        return getWrappedRefStruct( );
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

    public RefStruct getWrappedRefStruct( ) {

        return this.underlyingRefStruct;
    }

    public OclAny getValue( String name ) {

        Object value = this.underlyingRefStruct.refGetValue( name );
        if ( value == null ) {
            throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_013, name );
        }
        return OclFactory.instance( ).create( value );
    }

    @Override
    protected OclAny evaluateAsToString( CoreConnection connection ) {

        return new OclStringImpl( this.underlyingRefStruct.toString( ) );
    }
}
