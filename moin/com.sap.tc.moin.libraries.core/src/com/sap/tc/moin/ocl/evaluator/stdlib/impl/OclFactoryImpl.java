package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBag;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclOrderedSet;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclSequence;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclSet;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclTuple;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclType;
import com.sap.tc.moin.ocl.evaluator.util.Bag;
import com.sap.tc.moin.ocl.evaluator.util.HashBag;
import com.sap.tc.moin.ocl.evaluator.util.ListOrderedSet;
import com.sap.tc.moin.ocl.evaluator.util.OrderedSet;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * Default OclFactory implementation.
 */
public class OclFactoryImpl extends OclFactory {

    /*
     * If it is deemed necessary for performance reasons, this class can be
     * modified to cache the instances that it creates, returning objects from
     * the cache if possible. This should at least work for the primitive types
     * and Enumerations, as the OclAny subclasses for those types are immutable.
     * Further care would have to be taken for Collections and ModelElements.
     */

    @Override
    public OclAny create( Object underlyingObject ) {

        if ( underlyingObject == null ) {
            //throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.UNDERLYINGVALUENOTNULL );
            return OclVoidImpl.OCL_UNDEFINED;
        }

        /*
         * This code could be refactored to use a look-up table & switch
         * statement if it is necessary for performance reasons.
         */
        if ( underlyingObject instanceof Boolean ) {
            return ( (Boolean) underlyingObject ).booleanValue( ) ? OclBooleanImpl.TRUE_IMPL : OclBooleanImpl.FALSE_IMPL;
        }
        if ( underlyingObject instanceof Integer ) {
            return new OclIntegerImpl( (Integer) underlyingObject );
        }
        if ( underlyingObject instanceof Float ) {
            return new OclFloatImpl( (Float) underlyingObject );
        }
        if ( underlyingObject instanceof Long ) {
            return new OclLongImpl( (Long) underlyingObject );
        }
        if ( underlyingObject instanceof Double ) {
            return new OclDoubleImpl( (Double) underlyingObject );
        }
        if ( underlyingObject instanceof String ) {
            return new OclStringImpl( (String) underlyingObject );
        }
        if ( underlyingObject instanceof RefObject ) {
            return createModelObject( (RefObject) underlyingObject );
        }
        if ( underlyingObject instanceof RefEnum ) {
            return new OclEnumImpl( (RefEnum) underlyingObject );
        }
        if ( underlyingObject instanceof RefStruct ) {
            return new OclStructImpl( (RefStruct) underlyingObject );
        }
        throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.OCLANYCREATENOTSUPPORTED, underlyingObject.getClass( ).getName( ) );
    }

    @Override
    public OclTuple createTuple( Map<String, OclAny> nameValuePairs ) {

        return new OclTupleImpl( nameValuePairs );
    }

    @Override
    public OclType createType( Classifier referredType ) {

        return new OclTypeImpl( referredType );
    }

    @Override
    public OclSet createSetFromOclAnyObjects( Set<OclAny> oclAnyObjects ) {

        return new OclSetImpl( oclAnyObjects );
    }

    @Override
    public OclOrderedSet createOrderedSetFromOclAnyObjects( OrderedSet oclAnyObjects ) {

        return new OclOrderedSetImpl( oclAnyObjects );
    }

    @Override
    public OclSequence createSequenceFromOclAnyObjects( List<OclAny> oclAnyObjects ) {

        return new OclSequenceImpl( oclAnyObjects );
    }

    @Override
    public OclBag createBagFromOclAnyObjects( Bag oclAnyObjects ) {

        return new OclBagImpl( oclAnyObjects );
    }

    @Override
    public OclSet createSetFromRefObjects( Collection<? extends RefObject> refObjects ) {

        Set<OclAny> underlyingSet = (Set<OclAny>) OclSetImpl.newCollection( );
        populateOclAnySetFromRefObjects( refObjects, underlyingSet );
        return createSetFromOclAnyObjects( underlyingSet );
    }

    @Override
    public OclOrderedSet createOrderedSetFromRefObjects( Collection<RefObject> refObjects ) {

        OrderedSet underlyingSet = (OrderedSet) OclOrderedSetImpl.newCollection( );
        populateOclAnySetFromRefObjects( refObjects, underlyingSet );
        return createOrderedSetFromOclAnyObjects( underlyingSet );
    }

    @Override
    public OclBag createBagFromRefObjects( Collection<RefObject> refObjects ) {

        Collection<OclAny> oclAnyObjects = OclBagImpl.newCollection( );
        for ( RefObject obj : refObjects ) {
            oclAnyObjects.add( create( obj ) );
        }
        return new OclBagImpl( new HashBag( oclAnyObjects ) );
    }

    @Override
    public OclSequence createSequenceFromRefObjects( Collection<RefObject> refObjects ) {

        List<OclAny> oclAnyObjects = (List<OclAny>) OclSequenceImpl.newCollection( );
        for ( RefObject obj : refObjects ) {
            oclAnyObjects.add( create( obj ) );
        }
        return new OclSequenceImpl( oclAnyObjects );
    }

    @Override
    public OclCollection createCollectionFromRawValues( Collection<Object> objects, boolean ordered, boolean unique ) {

        List<OclAny> oclAnyObjects = new ArrayList<OclAny>( );
        for ( Iterator<Object> it = objects.iterator( ); it.hasNext( ); ) {
            oclAnyObjects.add( create( it.next( ) ) );
        }

        if ( ordered && unique ) {
            return new OclOrderedSetImpl( new ListOrderedSet( oclAnyObjects ) );
        } else if ( ordered && !unique ) {
            return new OclSequenceImpl( oclAnyObjects );
        } else if ( !ordered && unique ) {
            return new OclSetImpl( new HashSet<OclAny>( oclAnyObjects ) );
        } else { // !ordered && !unique
            return new OclBagImpl( new HashBag( oclAnyObjects ) );
        }
    }

    /**
     * Creates a new OclModelObject to the supplied <code>set</code> for each
     * RefObject in the supplied <code>refObjects</code> collection.
     */
    private void populateOclAnySetFromRefObjects( Collection<? extends RefObject> refObjects, Set<OclAny> set ) {

        for ( Iterator<? extends RefObject> it = refObjects.iterator( ); it.hasNext( ); ) {
            RefObject refObject = it.next( );
            if(refObject != null) {
                set.add( createModelObject( refObject ) );
            }
        }
    }

    private OclAny createModelObject( RefObject underlyingObject ) {

        if ( underlyingObject instanceof Wrapper<?> ) {
            return new OclModelElementImpl( (RefObject) ( (Wrapper<?>) underlyingObject ).unwrap( ) );
        }
        return new OclModelElementImpl( underlyingObject );
    }

}
