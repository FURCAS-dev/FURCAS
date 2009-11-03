package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclSet;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.evaluator.util.Bag;
import com.sap.tc.moin.ocl.evaluator.util.HashBag;
import com.sap.tc.moin.ocl.evaluator.util.ListOrderedSet;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * {@link OclSet} implementation.
 */
public class OclSetImpl extends OclCollectionImpl implements OclSet {

    /**
     * Create a new OclSet that wraps the supplied <code>underlyingValue</code>.
     * The contents of the set must be of type {@link OclAny}.
     */
    OclSetImpl( Set<OclAny> underlyingValue ) {

        super( underlyingValue );
    }

    /* Specified by interface */
    public Set<OclAny> getWrappedSet( ) {

        return (Set<OclAny>) getWrappedCollection( );
    }

    /* Set factory. Provides a central point for setting the Set type. */
    static Collection<OclAny> newCollection( Collection<OclAny> collection ) {

        return new LinkedHashSet<OclAny>( collection );
    }

    /* Set factory. Provides a central point for setting the Set type. */
    static Collection<OclAny> newCollection( ) {

        return new HashSet<OclAny>( );
    }

    /* Specified by interface */
    public Collection<OclAny> newUnderlyingCollection( ) {

        return OclSetImpl.newCollection( );
    }

    /* Specified by interface */
    public OclCollection newOclCollection( Collection<OclAny> collection ) {

        return new OclSetImpl( (Set<OclAny>) collection );
    }

    /* Specified by interface */
    public OclCollection newCollectOclCollection( List<OclAny> values ) {

        return new OclBagImpl( new HashBag( values ) );
    }

    /* Specified by interface */
    public OclCollection newSortedByOclCollection( List<OclAny> values ) {

        return new OclOrderedSetImpl( new ListOrderedSet( values ) );
    }

    /* Specified by interface */
    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException {

        try {
            // get the zero argument functions
            if ( OclConstants.OP_COUNT.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_UNION.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_INTERSECTION.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_MINUSSTDLIB.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_SYMMDIF.equals( opName ) ) {
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
        OclAny arg = args[0];
        if ( arg.equals( OclInvalidImpl.OCL_INVALID ) || args[0].equals( OclVoidImpl.OCL_UNDEFINED ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }

        // evaluate the 1 argument functions
        if ( OclConstants.OP_COUNT.equals( opName ) ) {
            return evaluateCount( arg );
        }
        if ( OclConstants.OP_UNION.equals( opName ) ) {
            return evaluateUnion( (OclCollection) arg );
        }
        if ( OclConstants.OP_INTERSECTION.equals( opName ) ) {
            return evaluateIntersection( (OclCollection) arg );
        }
        if ( OclConstants.OP_MINUSSTDLIB.equals( opName ) ) {
            return evaluateMinus( (OclSet) arg );
        }
        if ( OclConstants.OP_SYMMDIF.equals( opName ) ) {
            return evaluateSymmetricDifference( (OclSet) arg );
        }
        throw new OperationNotFoundException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_016, new String[] { opName, "2", getClass( ).getName( ) } ); //$NON-NLS-1$
    }

    /**
     * @return the count
     */
    private OclAny evaluateCount( OclAny arg ) {

        int count = getWrappedSet( ).contains( arg ) ? 1 : 0;
        return new OclIntegerImpl( Integer.valueOf( count ) );
    }

    /**
     * Implementation of "union" method evaluation.
     */
    private OclAny evaluateUnion( OclCollection arg ) {

        Collection<OclAny> newData;
        OclCollection result;
        if ( arg instanceof OclSet ) {
            newData = newCollection( getWrappedSet( ) );
            result = new OclSetImpl( (Set<OclAny>) newData );
        } else {
            newData = OclBagImpl.newCollection( getWrappedSet( ) );
            result = new OclBagImpl( (Bag) newData );
        }
        newData.addAll( arg.getWrappedCollection( ) );
        return result;
    }

    /**
     * Implementation of "intersection" method evaluation.
     */
    private OclAny evaluateIntersection( OclCollection arg ) {

        Collection<OclAny> newData = newCollection( getWrappedSet( ) );
        newData.retainAll( (Collection<?>) arg.getWrappedObject( ) );
        return new OclSetImpl( (Set<OclAny>) newData );
    }

    /**
     * Implementation of "-" method evaluation.
     */
    private OclAny evaluateMinus( OclSet arg ) {

        Set<OclAny> newSet = (Set<OclAny>) newCollection( getWrappedSet( ) );
        newSet.removeAll( arg.getWrappedSet( ) );
        return new OclSetImpl( newSet );
    }

    /**
     * Implementation of "symmetricDifference" method evaluation.
     */
    private OclAny evaluateSymmetricDifference( OclSet arg ) {

        // get the intersection
        Set<OclAny> intersectionSet = (Set<OclAny>) newCollection( getWrappedSet( ) );
        intersectionSet.retainAll( arg.getWrappedSet( ) );
        // get the union
        Set<OclAny> newSet = (Set<OclAny>) newCollection( getWrappedSet( ) );
        newSet.addAll( arg.getWrappedSet( ) );
        // take the intersection away from the union
        newSet.removeAll( intersectionSet );
        return new OclSetImpl( newSet );
    }

    /**
     * Implementation of "asSet" method evaluation.
     */
    @Override
    protected OclAny evaluateAsSet( ) {

        return this;
    }

}
