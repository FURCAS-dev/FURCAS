package com.sap.tc.moin.ocl.evaluator.stdlib;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclFactoryImpl;
import com.sap.tc.moin.ocl.evaluator.util.Bag;
import com.sap.tc.moin.ocl.evaluator.util.OrderedSet;

/**
 * Factory for creating new {@link OclAny} subclass instances.
 */
public abstract class OclFactory {

    // //////////////////
    // Main interface //
    // //////////////////

    /**
     * Create an appropriate <code>OclAny</code> that wraps the supplied
     * <code>underlyingObject</code>.
     * 
     * @param underlyingObject the object to wrap
     * @return the wrapping instance
     * @throws IllegalArgumentException Thrown if the
     * <code>underlyingObject</code> is <code>null</code>, or if is not of a
     * known type (the latter is a sanity check only, as it should not be
     * possible unless there is a problem with the parser/evaluator).
     */
    public abstract OclAny create( Object underlyingObject );

    /**
     * Create an <code>OclTuple</code> from the supplied values.
     * 
     * @param nameValuePairs The map of {@link OclAny} values keyed by the
     * (String) tuple part name.
     * @return the tuple
     * @throws IllegalArgumentException Thrown if <code>nameValuePairs</code> is
     * <code>null</code> or if it is empty. This is a sanity check, as it should
     * not be possible unless there is a problem with the parser/evaluator.
     */
    public abstract OclTuple createTuple( Map<String, OclAny> nameValuePairs );

    /**
     * Create an <code>OclType</code> from the supplied value.
     * 
     * @param referredType the type's classifier
     * @return the corresponding type
     * @throws IllegalArgumentException Thrown if <code>referredType</code> is
     * <code>null</code>.
     */
    public abstract OclType createType( Classifier referredType );

    /**
     * Create an <code>OclSet</code> that wraps the supplied set of
     * {@link OclAny} objects.
     * 
     * @param oclAnyObjects the set of OCL objects
     * @return the wrapping OclSet TODO we can't make this Set<OclAny>, as
     * tuples are provided as parameters TODO perhaps another method? This is
     * for all of these methods, actually
     * @throws IllegalArgumentException Thrown if the supplied set is
     * <code>null</code>.
     */
    public abstract OclSet createSetFromOclAnyObjects( Set<OclAny> oclAnyObjects );

    /**
     * Create an <code>OclOrderedSet</code> that wraps the supplied set of
     * {@link OclAny} objects.
     * 
     * @param oclAnyObjects the set of input objects
     * @return the wrapping OclOrderedSet
     * @throws IllegalArgumentException Thrown if the supplied set is
     * <code>null</code>.
     */
    public abstract OclOrderedSet createOrderedSetFromOclAnyObjects( OrderedSet oclAnyObjects );

    /**
     * Create an <code>OclSequence</code> that wraps the supplied list of
     * {@link OclAny} objects.
     * 
     * @param oclAnyObjects the objects to wrap
     * @return the wrapping OclSequence
     * @throws IllegalArgumentException Thrown if the supplied list is
     * <code>null</code>.
     */
    public abstract OclSequence createSequenceFromOclAnyObjects( List<OclAny> oclAnyObjects );

    /**
     * Create an <code>OclBag</code> that wraps the supplied bag of
     * {@link OclAny} objects.
     * 
     * @param oclAnyObjects the input
     * @return the wrapping OclBag
     * @throws IllegalArgumentException Thrown if the supplied bag is
     * <code>null</code>.
     */
    public abstract OclBag createBagFromOclAnyObjects( Bag oclAnyObjects );

    /**
     * Create a <code>OclBag</code> from RefObjects
     * 
     * @param refObjects the objects to wrap
     * @return the wrapping OclBag
     */
    public abstract OclBag createBagFromRefObjects( Collection<RefObject> refObjects );

    /**
     * Create a <code>OclSequence</code> from RefObjects
     * 
     * @param refObjects the object to wrap
     * @return the wrapping OclSequence
     */
    public abstract OclSequence createSequenceFromRefObjects( Collection<RefObject> refObjects );

    /**
     * Create an <code>OclSet</code> of {@link OclModelElement}s from the
     * collection.
     * 
     * @param refObjects A collection of {@link com.sap.tc.moin.repository.mmi.reflect.RefObject}s to
     * create the <code>OclModelElement</code>s from.
     * @return the wrapping OclSet
     * @throws IllegalArgumentException Thrown if the supplied collection is
     * <code>null</code>.
     * @throws ClassCastException Thrown if the supplied collection does not
     * contain all objects of type {@link com.sap.tc.moin.repository.mmi.reflect.RefObject}.
     */
    public abstract OclSet createSetFromRefObjects( Collection<? extends RefObject> refObjects );

    /**
     * Create an <code>OclOrderedSet</code> of {@link OclModelElement}s from the
     * collection with the elements in the same order as returned by the
     * supplied collection's iterator.
     * 
     * @param refObjects A collection of {@link com.sap.tc.moin.repository.mmi.reflect.RefObject}s to
     * create the <code>OclModelElement</code>s from.
     * @return the wrapping OclOrderedSet
     * @throws IllegalArgumentException Thrown if the supplied collection is
     * <code>null</code>.
     * @throws ClassCastException Thrown if the supplied collection does not
     * contain all objects of type {@link com.sap.tc.moin.repository.mmi.reflect.RefObject}.
     */
    public abstract OclOrderedSet createOrderedSetFromRefObjects( Collection<RefObject> refObjects );

    /**
     * Create an appropriate <code>OclCollection</code> from the supplied
     * collection of unwrapped objects. The type of collection returned is based
     * on the ordered/unique pair, according to the following table:
     * <p>
     * <table border = "1">
     * <tr>
     * <th>ordered</th>
     * <th>unique</th>
     * <th>Type</th>
     * </tr>
     * <tr>
     * <td>true</td>
     * <td>true</td>
     * <td>{@link OclOrderedSet}</td>
     * </tr>
     * <tr>
     * <td>true</td>
     * <td>false</td>
     * <td>{@link OclSequence}</td>
     * </tr>
     * <tr>
     * <td>false</td>
     * <td>true</td>
     * <td>{@link OclSet}</td>
     * </tr>
     * <tr>
     * <td>false</td>
     * <td>false</td>
     * <td>{@link OclBag}</td>
     * </tr>
     * </table>
     * <p>
     * For ordered collections, the ordering is based on the iterator returned
     * from the supplied collection.
     * 
     * @param objects the objects to wrap
     * @param ordered true if the collection is ot be ordered
     * @param unique true if the collection is to enure uniqueness
     * @return the wrapping OclCollection
     */
    public abstract OclCollection createCollectionFromRawValues( Collection<Object> objects, boolean ordered, boolean unique );

    // ///////////////////////////////////
    // Registry pattern implementation //
    // ///////////////////////////////////

    private static OclFactory instance;

    /**
     * Initialise the factory implementation (useful for testing)
     * 
     * @param factory the factory
     */
    public static void init( OclFactory factory ) {

        instance = factory;
    }

    /**
     * Retrieve the factory implementation.
     * 
     * @return the factory
     */
    public static OclFactory instance( ) {

        if ( instance == null ) {
            defaultInit( );
        }
        return instance;
    }

    /**
     * Initialise the registry with the default implementation.
     */
    public static void defaultInit( ) {

        instance = new OclFactoryImpl( );
    }
}
