package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;

import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclType;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclVoid;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * {@link OclVoid} implementation.
 */
public class OclVoidImpl extends BaseOclAny implements OclVoid {

    /** The single OclVoid instance, i.e., OclUndefined. */
    public static final OclVoidImpl OCL_UNDEFINED = new OclVoidImpl( );

    /**
     * Only one instance of OclVoid exists, which is {@link #OCL_UNDEFINED
     * OclUndefined}. Constructor is private to prevent additional instances
     * being created.
     */
    private OclVoidImpl( ) {

        // No initialisation required
    }

    public Object getWrappedObject( ) {

        /*
         * Question: Should this return null or throw a RuntimeException? In
         * theory, this method shouldn't be called - all client code should
         * check for the special OclUndefined instance and deal with it
         * appropriately. For now, throw an exception, as it will generally
         * indicate a programming error in the framework. IMPORTANT: If this
         * changes, make sure the relevant JavaDoc is updated for the
         * OclAny#getWrappedObject() and OclVoid#getWrappedObject() methods.
         */
        return null;
        // throw new InvalidValueException();
    }

    /**
     * All OclVoid objects are instances of the singleton OCL_UNDEFINED.
     */
    @Override
    public boolean equals( Object o ) {

        return o == OCL_UNDEFINED;
    }

    /**
     * Override the OclAny implementation of hashCode.
     */
    @Override
    public int hashCode( ) {

        return System.identityHashCode( this );
    }

    @Override
    protected OclAny evaluateOclIsUndefined( OclAny[] args ) {

        return OclBoolean.TRUE;
    }

    @Override
    protected OclAny evaluateOclIsInvalid( OclAny[] args ) {

        return OclBoolean.FALSE;
    }

    @Override
    protected OclAny evaluateOclIsKindOf( CoreConnection connection, OclAny[] args ) {

        if ( args[0] instanceof OclType ) {
            try {
                if ( ( (com.sap.tc.moin.repository.mmi.model.MofClass) args[0].getWrappedObject( ) ).getName( ).equals( OclConstants.T_OCLVOIDSTDLIB ) ) {
                    return OclBoolean.TRUE;
                }
            } catch ( RuntimeException re ) {
                return OclBoolean.FALSE;
            }

        }
        return OclBoolean.FALSE;
    }

    @Override
    protected OclAny evaluateOclIsTypeOf( CoreConnection connection, OclAny[] args ) {

        return this.evaluateOclIsKindOf( connection, args );
    }

    @Override
    public String toString( ) {

        return "null"; //$NON-NLS-1$
    }

    /* Specified by interface */
    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) {

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
        if ( OclConstants.OP_ASSET.equals( opName ) ) {
            return evaluateAsSet( args );
        }
        if ( OclConstants.OP_TOSTRING.equals( opName ) ) {
            return evaluateAsToString( connection );
        }
        if ( OclConstants.OP_ASTYPE.equals( opName ) ) {
            return evaluateAsType( connection, args );
        }
        if ( OclConstants.OP_EQSTDLIB.equals( opName ) ) {
            return evaluateEquals( args );
        }
        if ( OclConstants.OP_NOTEQSTDLIB.equals( opName ) ) {
            return evaluateNotEquals( args );
        }
        if ( OclConstants.OP_OCLISINVALID.equals( opName ) ) {
            return evaluateOclIsInvalid( args );
        }
        if ( OclConstants.OP_OCLISKINDOF.equals( opName ) ) {
            return evaluateOclIsKindOf( connection, args );
        }
        if ( OclConstants.OP_OCLISTYPEOF.equals( opName ) ) {
            return evaluateOclIsTypeOf( connection, args );
        }
        if ( OclConstants.OP_OCLASTYPE.equals( opName ) ) {
            return evaluateAsType( connection, args );
        }

        // Specified by "Undefined Values" (page 15) and section A.2.2 (page
        // A-12) in the UML 2.0 OCL spec - The new spec uses OclInvalid for
        // exceptional situations
        return OclInvalidImpl.OCL_INVALID;
    }

    private OclAny evaluateOr( OclAny[] args ) {

        if ( OclBoolean.TRUE.equals( args[0] ) ) {
            return OclBoolean.TRUE;
        }
        return OCL_UNDEFINED;
    }

    private OclAny evaluateAnd( OclAny[] args ) {

        // Specified by "Undefined Values" (page 15) in the UML 2.0 OCL spec
        if ( OclBoolean.FALSE.equals( args[0] ) ) {
            return OclBoolean.FALSE;
        }
        return OCL_UNDEFINED;
    }

    private OclAny evaluateImplies( OclAny[] args ) {

        // Specified by "Undefined Values" (page 15) in the UML 2.0 OCL spec
        if ( OclBoolean.TRUE.equals( args[0] ) ) {
            return OclBoolean.TRUE;
        }
        return OCL_UNDEFINED;
    }

    @Override
    boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier ) {

        return false;
    }

    @Override
    boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier ) {

        return false;
    }

    @Override
    protected OclAny evaluateAsToString( CoreConnection connection ) {

        return new OclStringImpl( "null" ); //$NON-NLS-1$
    }

    @Override
    protected OclAny evaluateNotEquals( OclAny[] args ) {

        return OclBooleanImpl.fromValue( !( args[0] instanceof OclVoid ) );
    }

    @Override
    protected OclAny evaluateAsType( CoreConnection connection, OclAny[] args ) {

        return OCL_UNDEFINED;
    }

    @Override
    protected OclAny evaluateAsSet( OclAny[] args ) {

        Set<OclAny> set = (Set<OclAny>) OclSetImpl.newCollection( );
        return new OclSetImpl( set );
    }

    @Override
    protected OclAny evaluateEquals( OclAny[] args ) {

        if ( args[0] instanceof OclVoid ) {
            return OclBoolean.TRUE;
        }
        return OclBoolean.FALSE;
    }
}
