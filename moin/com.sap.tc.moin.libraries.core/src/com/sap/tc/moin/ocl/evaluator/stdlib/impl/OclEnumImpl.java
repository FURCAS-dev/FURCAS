package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclEnum;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * {@link OclEnum} implementation.
 */
public class OclEnumImpl extends BaseOclAny implements OclEnum {

    private final RefEnum underlyingRefEnum;

    /**
     * Create a new OclEnum that wraps the supplied
     * <code>underlyingRefEnum</code>.
     */
    OclEnumImpl( RefEnum theEnum ) {

        this.underlyingRefEnum = theEnum;
    }

    /* Specified by interface */
    public Object getWrappedObject( ) {

        return getWrappedRefEnum( );
    }

    /* Specified by interface */
    public RefEnum getWrappedRefEnum( ) {

        return this.underlyingRefEnum;
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

        return new OclStringImpl( this.underlyingRefEnum.toString( ) );
    }
}
