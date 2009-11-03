package com.sap.tc.moin.ocl.evaluator.stdlib;

import java.util.Collection;
import java.util.List;

/**
 * Super-class for all collection wrappers. The underlying collection contains
 * objects of type {@link OclAny}.
 */
public interface OclCollection extends OclAny {

    /**
     * Convenience method to return the underlying object as a Collection
     * without having to cast it.
     * 
     * @return the wrapped collection
     */
    public Collection<OclAny> getWrappedCollection( );

    /**
     * Convenience method to return the underlying Collection which unwraps the
     * contained objects
     * 
     * @param wrapParitionablesInMri if <code>true</code>, Partitinables are
     * replaced with their MRIs
     * @return the unwrapping collection
     */
    @SuppressWarnings( "unchecked" )
    public Collection getUnwrappingCollection( boolean wrapParitionablesInMri );

    /**
     * Return a new Collection that can be wrapped by the runtime type of this
     * collection.
     * 
     * @return the new collection
     */
    public Collection<OclAny> newUnderlyingCollection( );

    /**
     * Return a new OclCollection of the same runtime type of this
     * OclCollection, which wraps the supplied <code>collection</code>.
     * 
     * @param collection the new collection
     * @return the wrapping OCL collection
     * @throws ClassCastException Thrown if the supplied <code>collection</code>
     * is not compatible with the runtime type of this OclCollection.
     */
    public OclCollection newOclCollection( Collection<OclAny> collection );

    /**
     * Return a new OclCollection of the type that should be returned when the
     * "collect" iterator operation is called, which contains the supplied
     * values. For OclSet and OclOrderedSet, and OclBag this will be an OclBag.
     * For OclSequence, this will be an OclSequence.
     * 
     * @param values the values to be wrapped
     * @return the wrapping OCL collection
     */
    public OclCollection newCollectOclCollection( List<OclAny> values );

    /**
     * Return a new OclCollection of the type that should be returned when the
     * "sortedBy" iterator operation is called, which contains the supplied
     * values, in order. For OclSet and OclOrderedSet, this will be an
     * OclOrderedSet. For OclBag and OclSequence, this will be an OclSequence.
     * The element type of the new collection is the same as the element type
     * for this collection.
     * 
     * @param values the values to be wrapped
     * @return the wrapping OCL collection
     */
    public OclCollection newSortedByOclCollection( List<OclAny> values );

}
