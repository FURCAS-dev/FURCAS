package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.ocl.evaluator.EvaluatorException;
import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.evaluator.util.Bag;
import com.sap.tc.moin.ocl.evaluator.util.OrderedSet;
import com.sap.tc.moin.ocl.evaluator.util.UnWrappingHashBag;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;

/**
 * {@link OclCollection} base implementation.
 */
public abstract class OclCollectionImpl extends BaseOclAny implements OclCollection {

    private final Collection<OclAny> underlyingValue;

    /**
     * Create a new OclCollection that wraps the supplied
     * <code>underlyingValue</code>. The contents of the set must be of type
     * {@link OclAny}.
     */
    OclCollectionImpl( Collection<OclAny> theUnderlyingValue ) {

        if ( theUnderlyingValue == null ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.UNDERLYINGVALUENOTNULL );
        }
        this.underlyingValue = theUnderlyingValue;
    }

    /* Specified by interface */
    public final Object getWrappedObject( ) {

        return getWrappedCollection( );
    }

    /* Specified by interface */
    public final Collection<OclAny> getWrappedCollection( ) {

        return this.underlyingValue;
    }

    public Collection<Object> getUnwrappingCollection( boolean wrapModelElementsInMri ) {

        if ( this.underlyingValue instanceof Bag ) {
            Bag bag = (Bag) this.underlyingValue;
            UnWrappingHashBag result = new UnWrappingHashBag( );
            for ( Iterator<OclAny> bagElements = bag.iterator( ); bagElements.hasNext( ); ) {
                OclAny element = bagElements.next( );
                Object unwrappedElement = element.getWrappedObject( );
                if ( unwrappedElement instanceof InvalidValueException ) {
                    throw (InvalidValueException) unwrappedElement;
                }
                if ( wrapModelElementsInMri && unwrappedElement instanceof Partitionable ) {
                    result.add( ( (Partitionable) unwrappedElement ).get___Mri( ) );
                } else {
                    result.add( unwrappedElement );
                }
            }
            return result;
        } else if ( this.underlyingValue instanceof OrderedSet ) {
            Set<Object> result = new LinkedHashSet<Object>( );
            OrderedSet resultset = (OrderedSet) this.underlyingValue;
            for ( OclAny any : resultset ) {
                Object unwrappedElement = any.getWrappedObject( );
                if ( wrapModelElementsInMri && unwrappedElement instanceof Partitionable ) {
                    result.add( ( (Partitionable) unwrappedElement ).get___Mri( ) );
                } else {
                    result.add( unwrappedElement );
                }
            }
            return result;
        } else if ( this.underlyingValue instanceof Set ) {
            Set<Object> result = new HashSet<Object>( );
            Set<OclAny> resultset = (Set<OclAny>) this.underlyingValue;
            for ( OclAny any : resultset ) {
                Object unwrappedElement = any.getWrappedObject( );
                if ( wrapModelElementsInMri && unwrappedElement instanceof Partitionable ) {
                    result.add( ( (Partitionable) unwrappedElement ).get___Mri( ) );
                } else {
                    result.add( unwrappedElement );
                }
            }
            return result;
        } else if ( this.underlyingValue instanceof List ) {
            List<Object> result = new ArrayList<Object>( );
            List<OclAny> resultset = (List<OclAny>) this.underlyingValue;
            for ( OclAny any : resultset ) {
                Object unwrappedElement = any.getWrappedObject( );
                if ( wrapModelElementsInMri && unwrappedElement instanceof Partitionable ) {
                    result.add( ( (Partitionable) unwrappedElement ).get___Mri( ) );
                } else {
                    result.add( unwrappedElement );
                }
            }
            return result;
        }
        return null;
    }

    /* Specified by interface */
    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException {

        // If any arguments are OclUndefined, the result is OclUndefined
        for ( int i = 0; i < args.length; i++ ) {
            if ( OclInvalidImpl.OCL_INVALID.equals( args[i] ) || args[i].equals( OclVoidImpl.OCL_UNDEFINED ) ) {
                return OclInvalidImpl.OCL_INVALID;
            }
        }

        /*
         * This code could be refactored to use a look-up table & switch
         * statement if it is necessary for performance reasons.
         */
        if ( OclConstants.OP_SIZE.equals( opName ) ) {
            return evaluateSize( );
        }
        if ( OclConstants.OP_INCLUDING.equals( opName ) ) {
            return evaluateIncluding( args[0] );
        }
        if ( OclConstants.OP_EXCLUDING.equals( opName ) ) {
            return evaluateExcluding( args[0] );
        }
        if ( OclConstants.OP_INCLUDES.equals( opName ) ) {
            return evaluateIncludes( args );
        }
        if ( OclConstants.OP_EXCLUDES.equals( opName ) ) {
            return evaluateExcludes( args );
        }
        if ( OclConstants.OP_INCLUDESALL.equals( opName ) ) {
            return evaluateIncludesAll( args );
        }
        if ( OclConstants.OP_EXCLUDESALL.equals( opName ) ) {
            return evaluateExcludesAll( args );
        }
        if ( OclConstants.OP_ISEMPTY.equals( opName ) ) {
            return evaluateIsEmpty( );
        }
        if ( OclConstants.OP_NOTEMPTY.equals( opName ) ) {
            return evaluateNotEmpty( );
        }
        if ( OclConstants.OP_SUM.equals( opName ) ) {
            return evaluateSum( connection );
        }
        if ( OclConstants.OP_PRODUCT.equals( opName ) ) {
            return evaluateProduct( args );
        }
        if ( OclConstants.OP_FLATTEN.equals( opName ) ) {
            return evaluateFlatten( );
        }
        if ( OclConstants.OP_ASBAG.equals( opName ) ) {
            return evaluateAsBag( );
        }
        if ( OclConstants.OP_ASSEQUENCE.equals( opName ) ) {
            return evaluateAsSequence( );
        }
        if ( OclConstants.OP_ASSET.equals( opName ) ) {
            return evaluateAsSet( );
        }
        if ( OclConstants.OP_ASORDEREDSET.equals( opName ) ) {
            return evaluateAsOrderedSet( );
        }

        // should not pass on to BaseOclAny because collections do not extend
        // OclAny in the OCL spec
        // But = and <> are correctly implemented in OclAnyBase
        return super.callOperation( connection, opName, args );
    }

    /**
     * Convenience method for iterator operations that can only take one
     * iterator name. This method checks the length of the supplied array and
     * throws a SemanticErrorException if it is greater than one.
     */
    private void checkSingleIteratorName( String[] iteratorNames ) {

        if ( iteratorNames.length > 1 ) {
            throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_011 );
        }
    }

    /**
     * Implementation of "size" operation evaluation.
     */
    private OclAny evaluateSize( ) {

        int result = this.underlyingValue.size( );
        return new OclIntegerImpl( Integer.valueOf( result ) );
    }

    /**
     * Implementation of "including" method evaluation.
     */
    private OclAny evaluateIncluding( OclAny arg ) {

        Collection<OclAny> newCollection = newUnderlyingCollection( );
        newCollection.addAll( getWrappedCollection( ) );
        newCollection.add( arg );
        return newOclCollection( newCollection );
    }

    /**
     * Implementation of "excluding" method evaluation.
     */
    private OclAny evaluateExcluding( OclAny arg ) {

        Collection<OclAny> newCollection = newUnderlyingCollection( );
        for ( Iterator<? extends OclAny> it = getWrappedCollection( ).iterator( ); it.hasNext( ); ) {
            OclAny element = it.next( );
            if ( !element.equals( arg ) ) {
                newCollection.add( element );
            }
        }
        return newOclCollection( newCollection );
    }

    /**
     * Implementation of "includes" operation evaluation.
     */
    private OclAny evaluateIncludes( OclAny[] args ) {

        boolean result = this.underlyingValue.contains( args[0] );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "excludes" operation evaluation.
     */
    private OclAny evaluateExcludes( OclAny[] args ) {

        boolean result = !this.underlyingValue.contains( args[0] );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "includesAll" operation evaluation.
     */
    private OclAny evaluateIncludesAll( OclAny[] args ) {

        OclCollectionImpl arg = (OclCollectionImpl) args[0];
        boolean result = this.underlyingValue.containsAll( arg.underlyingValue );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "excludesAll" operation evaluation.
     */
    private OclAny evaluateExcludesAll( OclAny[] args ) {

        OclCollectionImpl arg = (OclCollectionImpl) args[0];
        Set<OclAny> values = new HashSet<OclAny>( this.underlyingValue );
        boolean result = !values.removeAll( arg.underlyingValue );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "isEmpty" operation evaluation.
     */
    private OclAny evaluateIsEmpty( ) {

        boolean result = this.underlyingValue.isEmpty( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "isEmpty" operation evaluation.
     */
    private OclAny evaluateNotEmpty( ) {

        boolean result = !this.underlyingValue.isEmpty( );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "sum" operation evaluation.
     */
    private OclAny evaluateSum( CoreConnection connection ) {

        /*
         * For evaluateSum we assume that we are summing either and Integer or
         * Real or some subtype thereof. The Semantic analysis in the parser
         * should enforce this. It is not clear if we would ever have to support
         * summing a user-defined type that does not inherit from Integer or
         * Real. If this were the case then this method would have to be
         * re-implemented.
         */

        OclAny result = new OclIntegerImpl( Integer.valueOf( 0 ) );

        for ( Iterator<? extends OclAny> it = this.underlyingValue.iterator( ); it.hasNext( ); ) {
            OclAny element = it.next( );

            try {
                result = element.callOperation( connection, OclConstants.OP_PLUSSTDLIB, new OclAny[] { result } );
            } catch ( OperationNotFoundException e ) {

                throw new EvaluatorException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_014 );
            }
        }
        return result;
    }

    /**
     * Implementation of "product" operation evaluation.
     */
    private OclAny evaluateProduct( OclAny[] args ) {

        OclCollection arg = (OclCollection) args[0];
        Collection<OclAny> otherCollection = arg.getWrappedCollection( );

        OclFactory oclFactory = OclFactory.instance( );
        Set<OclAny> results = new HashSet<OclAny>( );
        for ( Iterator<OclAny> it1 = this.underlyingValue.iterator( ); it1.hasNext( ); ) {
            OclAny first = it1.next( );
            for ( Iterator<OclAny> it2 = otherCollection.iterator( ); it2.hasNext( ); ) {
                OclAny second = it2.next( );
                Map<String, OclAny> values = new HashMap<String, OclAny>( );
                values.put( "first", first ); //$NON-NLS-1$
                values.put( "second", second ); //$NON-NLS-1$
                results.add( oclFactory.createTuple( values ) );
            }
        }
        return oclFactory.createSetFromOclAnyObjects( results );
    }

    /**
     * Implementation of "flatten" method evaluation. This does not recursively
     * flatten.
     */
    private OclAny evaluateFlatten( ) {

        Collection<OclAny> result = newUnderlyingCollection( );
        for ( Iterator<OclAny> it = getWrappedCollection( ).iterator( ); it.hasNext( ); ) {
            OclAny item = it.next( );
            if ( item instanceof OclCollection ) {
                result.addAll( ( (OclCollection) item ).getWrappedCollection( ) );
            } else {
                result.add( item );
            }
        }
        return newOclCollection( result );
    }

    /**
     * Implementation of "asSet" operation evaluation.
     */
    protected OclAny evaluateAsSet( ) {

        Set<OclAny> set = (Set<OclAny>) OclSetImpl.newCollection( this.underlyingValue );
        return new OclSetImpl( set );
    }

    /**
     * Implementation of "asOrderedSet" operation evaluation.
     */
    protected OclAny evaluateAsOrderedSet( ) {

        OrderedSet orderedSet = (OrderedSet) OclOrderedSetImpl.newCollection( this.underlyingValue );
        return new OclOrderedSetImpl( orderedSet );
    }

    /**
     * Implementation of "asSequence" operation evaluation.
     */
    protected OclAny evaluateAsSequence( ) {

        List<OclAny> list = (List<OclAny>) OclSequenceImpl.newCollection( this.underlyingValue );
        return new OclSequenceImpl( list );
    }

    /**
     * Implementation of "asBag" operation evaluation.
     */
    protected OclAny evaluateAsBag( ) {

        Bag bag = (Bag) OclBagImpl.newCollection( this.underlyingValue );
        return new OclBagImpl( bag );
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
}
