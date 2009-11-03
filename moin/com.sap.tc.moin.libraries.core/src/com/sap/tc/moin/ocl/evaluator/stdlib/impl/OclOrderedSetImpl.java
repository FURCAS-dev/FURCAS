package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.Collection;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclOrderedSet;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.evaluator.util.ListOrderedSet;
import com.sap.tc.moin.ocl.evaluator.util.OrderedSet;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * {@link OclOrderedSet} implementation.
 */
public class OclOrderedSetImpl extends OclSetImpl implements OclOrderedSet {

    private final OrderedSet orderedSet;

    /**
     * Create a new OclOrderedSet that wraps the supplied
     * <code>underlyingValue</code>. The contents of the sorted set must be of
     * type {@link OclAny}.
     */
    OclOrderedSetImpl( OrderedSet underlyingValue ) {

        super( underlyingValue );
        this.orderedSet = underlyingValue;
    }

    /* Specified by interface */
    public OrderedSet getWrappedOrderedSet( ) {

        return this.orderedSet;
    }

    /* OrderedSet factory. Provides a central point for setting the type. */
    static Collection<OclAny> newCollection( Collection<OclAny> collection ) {

        return new ListOrderedSet( collection );
    }

    /* OrderedSet factory. Provides a central point for setting the type. */
    static Collection<OclAny> newCollection( ) {

        return new ListOrderedSet( );
    }

    /* Specified by interface */
    @Override
    public Collection<OclAny> newUnderlyingCollection( ) {

        return OclOrderedSetImpl.newCollection( );
    }

    /* Specified by interface */
    @Override
    public OclCollection newOclCollection( Collection<OclAny> collection ) {

        return new OclOrderedSetImpl( (OrderedSet) collection );
    }

    /* Specified by interface */
    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException {

        try {
            // get the zero argument functions
            if ( OclConstants.OP_FIRST.equals( opName ) ) {
                return evaluateFirst( );
            }
            if ( OclConstants.OP_LAST.equals( opName ) ) {
                return evaluateLast( );
            }
            if ( OclConstants.OP_APPEND.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_PREPEND.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_AT.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_INDEXOF.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_INSERTAT.equals( opName ) ) {
                return callTwoArgs( opName, args );
            }
            if ( OclConstants.OP_SUBORDEREDSET.equals( opName ) ) {
                return callTwoArgs( opName, args );
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
        if ( OclConstants.OP_APPEND.equals( opName ) ) {
            return evaluateAppend( arg );
        }
        if ( OclConstants.OP_PREPEND.equals( opName ) ) {
            return evaluatePrepend( arg );
        }
        if ( OclConstants.OP_AT.equals( opName ) ) {
            return evaluateAt( arg );
        }
        if ( OclConstants.OP_INDEXOF.equals( opName ) ) {
            return evaluateIndexOf( arg );
        }
        throw new OperationNotFoundException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_016, new String[] { opName, "1", getClass( ).getName( ) } ); //$NON-NLS-1$
    }

    /**
     * Convenience method to call functions of 2 arguments
     */
    private OclAny callTwoArgs( String opName, OclAny[] args ) {

        // get the first argument
        if ( args[0].equals( OclInvalidImpl.OCL_INVALID ) || args[0].equals( OclVoidImpl.OCL_UNDEFINED ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        OclAny first = args[0];

        // get the second argument
        if ( args[1].equals( OclInvalidImpl.OCL_INVALID ) || args[1].equals( OclVoidImpl.OCL_UNDEFINED ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        OclAny second = args[1];

        // evaluate the two argument operations
        if ( OclConstants.OP_INSERTAT.equals( opName ) ) {
            return evaluateInsertAt( first, second );
        }
        if ( OclConstants.OP_SUBORDEREDSET.equals( opName ) ) {
            return evaluateSubOrderedSet( first, second );
        }
        throw new OperationNotFoundException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_016, new String[] { opName, "2", getClass( ).getName( ) } ); //$NON-NLS-1$
    }

    /**
     * Implementation of "first" method evaluation.
     */
    private OclAny evaluateFirst( ) {

        // check preconditions
        if ( getWrappedOrderedSet( ).isEmpty( ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        return getWrappedOrderedSet( ).get( 0 );
    }

    /**
     * Implementation of "last" method evaluation.
     */
    private OclAny evaluateLast( ) {

        // check preconditions
        if ( getWrappedOrderedSet( ).isEmpty( ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        OrderedSet OrderedSet = getWrappedOrderedSet( );
        return OrderedSet.get( OrderedSet.size( ) - 1 );
    }

    /**
     * Implementation of "append" method evaluation.
     */
    private OclAny evaluateAppend( OclAny arg ) {

        // check if this object is already included
        if ( getWrappedSet( ).contains( arg ) ) {
            return this;
        }
        OrderedSet newOrderedSet = (OrderedSet) newCollection( getWrappedOrderedSet( ) );
        newOrderedSet.add( arg );
        return new OclOrderedSetImpl( newOrderedSet );
    }

    /**
     * Implementation of "prepend" method evaluation.
     */
    private OclAny evaluatePrepend( OclAny arg ) {

        // check if this object is already included
        if ( getWrappedSet( ).contains( arg ) ) {
            return this;
        }
        OrderedSet newOrderedSet = (OrderedSet) newCollection( getWrappedOrderedSet( ) );
        newOrderedSet.add( 0, arg );
        return new OclOrderedSetImpl( newOrderedSet );
    }

    /**
     * Implementation of "at" method evaluation.
     */
    private OclAny evaluateAt( OclAny indexAny ) {

        int index = ( (Integer) indexAny.getWrappedObject( ) ).intValue( );
        // check preconditions
        if ( index < 1 || index > getWrappedOrderedSet( ).size( ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        return getWrappedOrderedSet( ).get( index - 1 );
    }

    /**
     * Implementation of "indexOf" method evaluation.
     */
    private OclAny evaluateIndexOf( OclAny object ) {

        int result = getWrappedOrderedSet( ).indexOf( object );
        // check the "contains" precondition
        if ( result == -1 ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        return new OclIntegerImpl( Integer.valueOf( result + 1 ) );
    }

    /**
     * Implementation of "insertAt" method evaluation.
     */
    private OclAny evaluateInsertAt( OclAny indexAny, OclAny object ) {

        int index = ( (Integer) indexAny.getWrappedObject( ) ).intValue( );
        // check preconditions
        if ( index < 1 || index > getWrappedOrderedSet( ).size( ) + 1 ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        // check if this object is already included
        if ( getWrappedSet( ).contains( object ) ) {
            return this;
        }
        OrderedSet newOrderedSet = (OrderedSet) newCollection( getWrappedOrderedSet( ) );
        newOrderedSet.add( index - 1, object );
        return new OclOrderedSetImpl( newOrderedSet );
    }

    /**
     * Implementation of "subSequence" method evaluation.
     */
    private OclAny evaluateSubOrderedSet( OclAny lowAny, OclAny highAny ) {

        int low = ( (Integer) lowAny.getWrappedObject( ) ).intValue( );
        int high = ( (Integer) highAny.getWrappedObject( ) ).intValue( );
        // check preconditions
        if ( low < 1 || high > getWrappedOrderedSet( ).size( ) || low > high ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        OrderedSet newOrderedSet = getWrappedOrderedSet( ).subOrderedSet( low - 1, high );
        return new OclOrderedSetImpl( newOrderedSet );
    }

    /**
     * Implementation of "asOrderedSet" method evaluation.
     */
    @Override
    protected OclAny evaluateAsOrderedSet( ) {

        return this;
    }
}
