package com.sap.tc.moin.repository.xm.serializer;

import java.util.Collection;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;

/**
 * The serializer helper provides access to MOIN model elements and links, and
 * does contain methods for creating XML documents.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface SerializerHelper {

    /**
     * Returns the output handler.
     * 
     * @return output handler
     */
    XmlOutputHandler getOutputHandler( );

    /**
     * Returns the PRI of the model partition which is serialized.
     * 
     * @return PRI
     */
    PRI getPri( );


    /**
     * Returns handles for all model elements of a MOF class contained in the
     * model partition which is serialized.
     * 
     * @param classDescriptor MOF class descriptor
     * @return handles of all model elements of the specified MOF class, or an
     * empty collection if there is not any model element of the specified MOF
     * class
     * @throws NullPointerException if the parameter is <tt>null</tt>
     */
    Collection<SModelElementHandle> getModelElements( ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor );


    /**
     * Returns a handle for a model element of a certain type and with a certain
     * logical key which is contained in the model partition which is
     * serialized.
     * 
     * @param classDescriptor MOF class descriptor
     * @param logicalKey logical key specifying the model element
     * @return handle for the specified model element, or <code>null</code> if a
     * model element for the specified logical key does not exist in the model
     * partition
     * @throws NullPointerException if a parameter is <tt>null</tt>
     * @throws IllegalStateException if the array <tt>logicalKey</tt> is empty
     */
    SModelElementHandle getModelElement( ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, String... logicalKey );


    /**
     * Returns a handle for a model element with a certain MRI.
     * <p>
     * You can retrieve a MRI for a model element contained in the partition to
     * be serialized via the method sequence {@link #getPri()} and
     * {@link PRI#createMri(String)}.
     * 
     * @param MRI mri of the model element,
     * @return the model element handle which corresponds to the model element
     * with the specified MRI, or <code>null</code> if the MRI cannot be
     * resolved
     * @throws NullPointerException if the parameter is <tt>null</tt>
     */
    SModelElementHandle getModelElement( MRI mri );

    /**
     * Returns a handle for a model element with a certain LRI.
     * <p>
     * You can retrieve a LRI for a model element via the method sequence
     * {@link #getPri()}, {@link PRI#createMri(String)}, and
     * {@link MRI#getLri()}.
     * <p>
     * With this method you can retrieve handles for model elements which are
     * stored in other model partition than the model partition to be
     * serialized. If you want to retrieve handles for model elements which are
     * stored in the partition to be serialized then you should use the method
     * {@link #getModelElement(MRI)}.
     * 
     * @param LRI LRI of the model element,
     * @return the model element handle which corresponds to the model element
     * with the specified LRI, or <code>null</code> if the LRI cannot be
     * resolved
     * @throws NullPointerException if the parameter is <tt>null</tt>
     */
    SModelElementHandle getModelElement( LRI lri );

    /**
     * Calculates a LRI from a class descriptor and a logical key.
     * 
     * @param classDescriptor class descriptor
     * @param logicalKey logical key
     * @return LRI
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalStateException if the array <tt>logicalKey</tt> is empty
     */
    LRI calculateLri( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String... logicalKey );


    /**
     * Returns the model elements which are linked to a specified model element
     * via a certain association. Not only those instances are returned which
     * are in the partition which is currently serialized (inner-partition
     * links) but also those instances which are in other partitions
     * (inter-partition links).
     * 
     * @param endInputModelElement handle for the specified model element, the
     * corresponding model element must be located in the model partition which
     * is serialized
     * @param associationDescriptor association descriptor
     * @param endOutputName name of the association end which contains the
     * returned model elements
     * @return collection of all the links, or an empty collection if there are
     * not any links for the specified model element and the specified
     * association
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalArgumentException if the end output name is not correct or
     * if the type of the input model element does not fit to the input end of
     * the association
     */
    Collection<SModelElementHandle> getLinks( SModelElementHandle endInputModelElement, AssociationDescriptor<? extends RefAssociation> associationDescriptor, String endOutputName );


    /**
     * Adds the namespace prefix declarations to the output stream. Must be
     * called only once on the root XML element.
     * 
     * @param prefix2Ns prefix to namespace map
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    void addNamespacePrefixDeclarations( Map<String, String> prefix2Ns );
}
