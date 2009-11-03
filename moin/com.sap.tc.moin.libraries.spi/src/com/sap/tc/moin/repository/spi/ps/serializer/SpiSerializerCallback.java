package com.sap.tc.moin.repository.spi.ps.serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;

/**
 * An instance of {@link SpiSerializerCallback} is passed to the
 * {@link SpiCustomSerializer#serialize(java.io.OutputStream, SpiSerializerCallback)}
 * method of a custom serializer, and is used by the serializer to retrieve
 * information about {@link SpiElement model elements} and {@link SpiLink links}
 * of the partition.
 */
public interface SpiSerializerCallback {

    /**
     * Returns the {@link PRI} of the currently serialized partition.
     * 
     * @return the {@link PRI} of the currently serialized partition
     */
    public PRI getPri( );

    /**
     * Returns all {@link SpiClass classes} used in the model partition. A class
     * is contained in the resulting collection if and only if at least one
     * instance of it exists in the partition.
     * 
     * @return all classes used in the model partition
     */
    public Collection<SpiClass> getUsedClasses( );

    /**
     * Returns all {@link SpiAssociation associations} used in the model
     * partition. An association is contained in the resulting collection if and
     * only if at least one link of it exists in the partition.
     * 
     * @return all associations used in the model partition
     */
    public Collection<SpiAssociation> getUsedAssociations( );

    /**
     * Returns all {@link SpiStructureType StructureTypes} used in the model
     * partition. A StructureType is contained in the resulting collection if
     * and only if at least one instance of it exists as the attribute value of
     * some element in the partition.
     * 
     * @return all StructureTypes used in the model partition
     */
    public Collection<SpiStructureType> getUsedStructureTypes( );

    /**
     * Returns all {@link SpiElement model elements} stored in the model
     * partition.
     * 
     * @return all model elements stored in the model partition
     */
    public Collection<SpiElement> getElements( );

    /**
     * Returns all {@link SpiElement model elements} stored in the model
     * partition, grouped by their {@link SpiClass class}.
     * 
     * @return all model elements stored in the model partition, grouped by
     * their class
     */
    public Map<SpiClass, Collection<SpiElement>> getElementsByClass( );

    /**
     * Returns all links stored in the model partition.
     * 
     * @return all links stored in the model partition
     */
    public List<SpiLink> getLinks( );

    /**
     * Returns all links stored in the model partition, grouped by their
     * {@link SpiAssociation associations}.
     * 
     * @return all links stored in the model partition, grouped by their
     * associations
     */
    public Map<SpiAssociation, List<SpiLink>> getLinksByAssociation( );

    /**
     * Returns the element at the link end with the specified number. The result
     * is either an instance of {@link SpiElement}, if the element is stored in
     * the current partition, or an instance of {@link LRI} , if the element is
     * stored in a different partition. In the latter case, if the
     * {@link SpiElement} instance is needed, use
     * {@link SpiSerializerCallback#getElement(LRI)}, passing the result of this
     * method as input parameter.
     * 
     * @throws IllegalArgumentException, if the specified end number is neither
     * 0 nor 1
     * @param endNumber either 0 or 1
     * @return the model element at the first end of the link
     */
    public Object getElementAtLinkEnd( SpiLink link, int endNumber );

    /**
     * Returns the {@link SpiElement element} with the specified {@link LRI}, or
     * <code>null</code> if the LRI cannot be resolved.
     * 
     * @param lriOfElement the {@link LRI} of the requested element
     * @return the element with the specified LRI, or <code>null</code> if the
     * LRI cannot be resolved
     */
    public SpiElement getElement( LRI lriOfElement );

    /**
     * Returns the {@link SpiElement element} with the specified {@link MRI}, or
     * <code>null</code> if the MRI cannot be resolved.
     * 
     * @param mriOfElement the {@link MRI} of the requested element
     * @return the element with the specified MRI, or <code>null</code> if the
     * MRI cannot be resolved
     */
    public SpiElement getElement( MRI mriOfElement );

    /**
     * Delegates serialization to other serializer identified by the
     * serialization id. <br>
     * The serialization id is provided in the registration file for a custom
     * parser/serializer.<br>
     * The serialization id for the MOIN build-in is
     * {@link SpiCustomParserSerializerFactory#DEFAULT_SERIALIZATION}.
     * 
     * @param serializationId
     * @param output
     * @param callback
     * @throws IOException
     */
    public void callOtherSerializer( String serializationId, OutputStream output, SpiSerializerCallback callback ) throws IOException;
}