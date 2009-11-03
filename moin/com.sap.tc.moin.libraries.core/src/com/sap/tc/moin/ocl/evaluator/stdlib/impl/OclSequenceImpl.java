package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclSequence;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * Implementation of OclSequence. These sequences have 1-based indexes.
 */
public class OclSequenceImpl extends OclCollectionImpl implements OclSequence {

    /**
     * Create a new OclSet that wraps the supplied <code>underlyingValue</code>.
     * The contents of the set must be of type {@link OclAny}.
     */
    OclSequenceImpl( List<OclAny> underlyingValue ) {

        super( underlyingValue );
    }

    /* Specified by interface */
    public List<OclAny> getWrappedSequence( ) {

        return (List<OclAny>) getWrappedCollection( );
    }

    /* List factory. Provides a central point for setting the list type. */
    static Collection<OclAny> newCollection( Collection<OclAny> collection ) {

        return new ArrayList<OclAny>( collection );
    }

    /* List factory. Provides a central point for setting the list type. */
    static Collection<OclAny> newCollection( ) {

        return new ArrayList<OclAny>( );
    }

    /* Specified by interface */
    public Collection<OclAny> newUnderlyingCollection( ) {

        return OclSequenceImpl.newCollection( );
    }

    /* Specified by interface */
    public OclCollection newOclCollection( Collection<OclAny> collection ) {

        return new OclSequenceImpl( (List<OclAny>) collection );
    }

    /* Specified by interface */
    public OclCollection newCollectOclCollection( List<OclAny> values ) {

        return new OclSequenceImpl( values );
    }

    /* Specified by interface */
    public OclCollection newSortedByOclCollection( List<OclAny> values ) {

        return new OclSequenceImpl( values );
    }

    /* Specified by interface */
    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException {

        try {
            if ( OclConstants.OP_FIRST.equals( opName ) ) {
                return evaluateFirst( );
            }
            if ( OclConstants.OP_LAST.equals( opName ) ) {
                return evaluateLast( );
            }
            if ( OclConstants.OP_COUNT.equals( opName ) ) {
                return callOneArg( opName, args );
            }
            if ( OclConstants.OP_UNION.equals( opName ) ) {
                return callOneArg( opName, args );
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
            if ( OclConstants.OP_SUBSEQUENCE.equals( opName ) ) {
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
            return args[0];
        }
        OclAny arg = args[0];

        // evaluate the 1 argument functions
        if ( OclConstants.OP_COUNT.equals( opName ) ) {
            return evaluateCount( arg );
        }
        if ( OclConstants.OP_UNION.equals( opName ) ) {
            return evaluateUnion( (OclSequence) arg );
        }
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
        if ( OclConstants.OP_SUBSEQUENCE.equals( opName ) ) {
            return evaluateSubSequence( first, second );
        }
        throw new OperationNotFoundException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_016, new String[] { opName, "2", getClass( ).getName( ) } ); //$NON-NLS-1$
    }

    /**
     * Implementation of "count" method evaluation. Count occurs in linear time.
     */
    private OclAny evaluateCount( OclAny arg ) {

        int count = 0;
        for ( Iterator<OclAny> it = getWrappedCollection( ).iterator( ); it.hasNext( ); ) {
            if ( arg.equals( it.next( ) ) ) {
                count++;
            }
        }
        return new OclIntegerImpl( Integer.valueOf( count ) );
    }

    /**
     * Implementation of "union" method evaluation.
     */
    private OclAny evaluateUnion( OclSequence arg ) {

        List<OclAny> result = (List<OclAny>) newCollection( getWrappedSequence( ) );
        result.addAll( arg.getWrappedSequence( ) );
        return new OclSequenceImpl( result );
    }

    /**
     * Implementation of "append" method evaluation.
     */
    private OclAny evaluateAppend( OclAny arg ) {

        List<OclAny> newList = (List<OclAny>) newCollection( getWrappedSequence( ) );
        newList.add( arg );
        return new OclSequenceImpl( newList );
    }

    /**
     * Implementation of "prepend" method evaluation.
     */
    private OclAny evaluatePrepend( OclAny arg ) {

        List<OclAny> newList = (List<OclAny>) newCollection( getWrappedSequence( ) );
        newList.add( 0, arg );
        return new OclSequenceImpl( newList );
    }

    /**
     * Implementation of "at" method evaluation.
     */
    private OclAny evaluateAt( OclAny indexAny ) {

        int index = ( (Integer) indexAny.getWrappedObject( ) ).intValue( );
        // check preconditions
        if ( index < 1 || index > getWrappedSequence( ).size( ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        return getWrappedSequence( ).get( index - 1 );
    }

    /**
     * Implementation of "indexOf" method evaluation.
     */
    private OclAny evaluateIndexOf( OclAny object ) {

        int result = getWrappedSequence( ).indexOf( object );
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
        if ( index < 1 || index > getWrappedSequence( ).size( ) + 1 ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        List<OclAny> newList = (List<OclAny>) newCollection( getWrappedSequence( ) );
        newList.add( index - 1, object );
        return new OclSequenceImpl( newList );
    }

    /**
     * Implementation of "subSequence" method evaluation.
     */
    private OclAny evaluateSubSequence( OclAny lowAny, OclAny highAny ) {

        int low = ( (Integer) lowAny.getWrappedObject( ) ).intValue( );
        int high = ( (Integer) highAny.getWrappedObject( ) ).intValue( );
        // check preconditions
        List<OclAny> underlyingList = getWrappedSequence( );
        if ( low < 1 || high > underlyingList.size( ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        List<OclAny> newList = underlyingList.subList( low - 1, high );
        return new OclSequenceImpl( newList );
    }

    /**
     * Implementation of "first" method evaluation.
     */
    private OclAny evaluateFirst( ) {

        // check preconditions
        if ( getWrappedSequence( ).isEmpty( ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        return getWrappedSequence( ).get( 0 );
    }

    /**
     * Implementation of "last" method evaluation.
     */
    private OclAny evaluateLast( ) {

        // check preconditions
        if ( getWrappedSequence( ).isEmpty( ) ) {
            return OclInvalidImpl.OCL_INVALID;
        }
        List<OclAny> list = getWrappedSequence( );
        return list.get( list.size( ) - 1 );
    }

    /**
     * Implementation of "asSequence" method evaluation.
     */
    @Override
    protected OclAny evaluateAsSequence( ) {

        return this;
    }

}
