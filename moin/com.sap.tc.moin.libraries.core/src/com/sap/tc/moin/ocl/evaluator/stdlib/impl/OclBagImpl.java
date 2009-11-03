package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBag;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.evaluator.util.Bag;
import com.sap.tc.moin.ocl.evaluator.util.HashBag;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * {@link OclBag} implementation.
 */
public class OclBagImpl extends OclCollectionImpl implements OclBag {

    /**
     * Create a new OclBag that wraps the supplied <code>underlyingValue</code>.
     * The contents of the collection must be of type {@link OclAny}.
     */
    OclBagImpl( Bag underlyingValue ) {

        super( underlyingValue );
    }

    /* Specified by interface */
    public Bag getWrappedBag( ) {

        return (Bag) getWrappedObject( );
    }

    /* Bag factory. Provides a central point for setting the Bag type. */
    static Collection<OclAny> newCollection( Collection<OclAny> collection ) {

        return new HashBag( collection );
    }

    /* Bag factory. Provides a central point for setting the Bag type. */
    static Collection<OclAny> newCollection( ) {

        return new HashBag( );
    }

    /* Specified by interface */
    public Collection<OclAny> newUnderlyingCollection( ) {

        return OclBagImpl.newCollection( );
    }

    /* Specified by interface */
    public OclCollection newOclCollection( Collection<OclAny> collection ) {

        return new OclBagImpl( (Bag) collection );
    }

    /* Specified by interface */
    public OclCollection newCollectOclCollection( List<OclAny> values ) {

        return new OclBagImpl( new HashBag( values ) );
    }

    /* Specified by interface */
    public OclCollection newSortedByOclCollection( List<OclAny> values ) {

        return new OclSequenceImpl( values );
    }

    /* Specified by interface */
    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException {

        try {
            // get the zero argument functions first
            if ( OclConstants.OP_UNION.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_INTERSECTION.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_COUNT.equals( opName ) ) {
                return callOneArg( opName, args );
            }
        } catch ( IndexOutOfBoundsException ioob ) {
            throw new OperationNotFoundException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_016, new String[] { opName, OclConstants.EMPTY + args.length, getClass( ).getName( ) } );
        }
        return super.callOperation( connection, opName, args );
    }

    /**
     * Convenience method to call functions of 1 argument
     */
    private OclAny callOneArg( String opName, OclAny[] args ) {

        // get the first argument
        if ( args[0].equals( OclInvalidImpl.OCL_INVALID ) || args[0].equals( OclVoidImpl.OCL_UNDEFINED ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        OclAny arg = args[0];

        // evaluate the 1 argument functions
        if ( OclConstants.OP_UNION.equals( opName ) ) {
            return evaluateUnion( (OclCollection) arg );
        }
        if ( OclConstants.OP_INTERSECTION.equals( opName ) ) {
            return evaluateIntersection( (OclCollection) arg );
        }
        if ( OclConstants.OP_COUNT.equals( opName ) ) {
            return evaluateCount( arg );
        }
        throw new OperationNotFoundException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_016, new String[] { opName, "1", getClass( ).getName( ) } ); //$NON-NLS-1$
    }

    /**
     * Implementation of "union" method evaluation.
     */
    private OclAny evaluateUnion( OclCollection arg ) {

        Bag newData = (Bag) newCollection( getWrappedBag( ) );
        newData.addAll( arg.getWrappedCollection( ) );
        return new OclBagImpl( newData );
    }

    /**
     * Implementation of "intersection" method evaluation. Returns an OclSet if
     * the input argument is an OclSet.
     */
    private OclAny evaluateIntersection( OclCollection arg ) {

        Collection<OclAny> newData;
        OclCollection result;
        if ( arg instanceof OclBag ) {
            newData = newCollection( getWrappedBag( ) );
            result = new OclBagImpl( (Bag) newData );
        } else {
            newData = OclSetImpl.newCollection( getWrappedBag( ) );
            result = new OclSetImpl( (Set<OclAny>) newData );
        }
        newData.retainAll( (Collection) arg.getWrappedObject( ) );
        return result;
    }

    /**
     * Implementation of "count" method evaluation.
     */
    private OclAny evaluateCount( OclAny arg ) {

        int count = getWrappedBag( ).count( arg );
        return new OclIntegerImpl( Integer.valueOf( count ) );
    }

    /**
     * Implementation of "asBag" method evaluation.
     */
    @Override
    protected OclAny evaluateAsBag( ) {

        return this;
    }

}
