package com.sap.tc.moin.xm.kernel;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;

/**
 * Call-back used by the XM Serializer for accessing MOIN model elements.
 * <p>
 * Different object types for the MOIN model elements are used depending on the
 * integration strategy.
 * 
 * @param <TElement> either a RefObject representing a MOF class instance in the
 * case of Export or a SpiElement in the case of CPS
 * @param <TMofClass> either RefClass in the case of Export or SpiClass in the
 * case of CPS
 * @param <TMofAssociation> either a RefAssociation in the case of Import or a
 * SpiAssociation in the case of CPS
 */
public interface XmSerializerCallback<TElement, TMofClass, TMofAssociation> extends XmCallback<TElement, TMofClass, TMofAssociation> {


    /**
     * Returns all instances of a certain class contained in the model partition
     * to be serialized. Instances which have as type a sub-class of the
     * specified class are not taken-into account.
     * 
     * @param mofClass MOF class
     * @return Collection of instances, <code>null</code> in the CP/S case if
     * there are not any instances of the given class
     * @throws NullPointerException if <tt>mofClass</tt> is <tt>null</tt>
     */
    Collection<TElement> getInstances( TMofClass mofClass );

    /**
     * Returns an instance of a MOF class with a certain logical key contained
     * in the model partition to be serialized.
     * 
     * @param mofClass the MOF class of the model element to create
     * @param logicalKey logical key
     * @return instance, <code>null</code> if an instance for the logical key
     * was not found or the found instance is not contained in the model
     * partition
     */
    TElement getClassInstance( TMofClass mofClass, String... logicalKey );



    /**
     * Returns the type of a model element in form of a class descriptor.
     * 
     * @param modelElement model element
     * @return class descriptor, cannot be <code>null</code>
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    ClassDescriptor<? extends RefClass, ? extends RefObject> getType( TElement modelElement );

    /**
     * Retrieves a class instance via its MRI.
     * 
     * @param mri the MRI for the class instance to be retrieved
     * @return the instance requested or <code>null</code> if it doesn't exist.
     * @throws NullPointerException if the MRI argument is <code>null</code> .
     */
    TElement getClassInstance( MRI mri );

    /**
     * Retrieves a class instance via its LRI.
     * 
     * @param lri the LRI for the class instance to be retrieved
     * @return the instance requested or <code>null</code> if it doesn't exist.
     * @throws NullPointerException if the LRI argument is <code>null</code> .
     */
    TElement getClassInstance( LRI lri );


//    /**
//     * Returns the qualified name of a type of an instance.
//     * 
//     * @param instance instance
//     * @return the qualified name, separator is dot
//     */
//    String getQualifiedName( TElement instance );

//    /**
//     * Returns the metamodel container name of a type of an instance.
//     * 
//     * @param instance instance
//     * @return the container name
//     */
//    String getMetamodelContainer( TElement instance );

    /**
     * Returns the MRI of an class instance.
     * 
     * @param instance class instance
     * @return MRI cannot be <code>null</code>
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    MRI getMri( TElement instance );

    /**
     * Returns the current value of a primitive or enumeration type attribute
     * with the specified name. The return value can be one of the following:
     * <ul>
     * <li>{@link String}, for single-valued attributes</li>
     * <li>a {@link Collection} of strings, if the attribute is multi-valued</li>
     * </ul>
     * <p>
     * Note that this method cannot be used for references.
     * 
     * @param instance instance
     * @param attributeName the name of the requested attribute
     * @return the current value of the element's attribute with the specified
     * name
     * @throws IllegalArgumentException if the <tt>attributeName</tt> is not a
     * valid attribute name of the instance
     */
    Object getAttributeValue( TElement instance, String attributeName );

    /**
     * Determines the instances which are linked to a given instance. Not only
     * those instances are returned which are in the partition which is
     * currently serialized (inner-partition links) but also those instances
     * which are in other partitions (inter-partition links).
     * 
     * @param endAinstance instance of end A, this instance must be stored in
     * the current serialized partition
     * @param association association with end A and end B
     * @param endBName name of end B
     * @return list of the end B instances linked to <tt>endAinstance</tt>
     * @throws NullPointerException if a parameter is <tt>null</tt>
     * @throws IllegalArgumentException if the association does not have an end
     * name <tt>endBName<tt> or the type of the end A instance does
     * not fit to the end A of the association
     */
    Collection<TElement> getLinkedInstances( TElement endAinstance, TMofAssociation association, String endBName );


    /**
     * Returns the model elements stored in the partition which is serialized.
     * 
     * @return collection of model elements stored in the partition, or an empty
     * collection
     */
    Collection<TElement> getStoredElements( );



}
