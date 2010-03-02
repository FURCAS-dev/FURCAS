package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import com.sap.tc.moin.repository.mmi.model.Classifier;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclInvalid;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;

/**
 * {@link OclInvalid} implementation
 */
public class OclInvalidImpl extends BaseOclAny implements OclInvalid {

    /**
     * The singleton instance
     */
    public static final OclInvalidImpl OCL_INVALID = new OclInvalidImpl( );

    private OclInvalidImpl( ) {

        // singleton
    }

    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException {

        if ( opName.equals( OclConstants.OP_OCLISINVALID ) ) {
            return evaluateOclIsInvalid( args );
        }
        if ( OclConstants.OP_OR.equals( opName ) ) {
            return evaluateOr( args );
        }
        if ( OclConstants.OP_AND.equals( opName ) ) {
            return evaluateAnd( args );
        }
        if ( OclConstants.OP_IMPLIES.equals( opName ) ) {
            return evaluateImplies( args );
        }
        if ( OclConstants.OP_OCLISUNDEFINED.equals( opName ) ) {
            return evaluateOclIsUndefined( args );
        }

        return this;
    }

    private OclAny evaluateOr( OclAny[] args ) {

        if ( OclBoolean.TRUE.equals( args[0] ) ) {
            return OclBoolean.TRUE;
        }
        return OclInvalidImpl.OCL_INVALID;
    }

    private OclAny evaluateAnd( OclAny[] args ) {

        // Specified by "Undefined Values" (page 15) in the UML 2.0 OCL spec
        if ( OclBoolean.FALSE.equals( args[0] ) ) {
            return OclBoolean.FALSE;
        }
        return OclInvalidImpl.OCL_INVALID;
    }

    private OclAny evaluateImplies( OclAny[] args ) {

        // Specified by "Undefined Values" (page 15) in the UML 2.0 OCL spec
        if ( OclBoolean.TRUE.equals( args[0] ) ) {
            return OclBoolean.TRUE;
        }
        return OclInvalidImpl.OCL_INVALID;
    }

    @Override
    protected OclAny evaluateOclIsUndefined( OclAny[] args ) {

        return this;
    }

    @Override
    protected OclAny evaluateOclIsInvalid( OclAny[] args ) {

        return OclBoolean.TRUE;
    }

    public Object getWrappedObject( ) {

        throw new InvalidValueException( OclServiceExceptions.INVALIDVALUEEXCEPTION );
    }

    @Override
    boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier ) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier ) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean equals( Object o ) {

        return o == this;
    }

    @Override
    public int hashCode( ) {

        return "invalid".hashCode( ); //$NON-NLS-1$
    }

    @Override
    public String toString( ) {
        return "(" + getClass( ).getName( ) + ") " + "invalid"; //$NON-NLS-1$//$NON-NLS-2$
    }
}
