package com.sap.tc.moin.repository.xm.serializer;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.xm.ModelElementHandle;

/**
 * Represents a handle to a model element which is used in
 * {@link SerializerHelper}.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * Only MOIN is allowed to implement this interface.
 */
public interface SModelElementHandle extends ModelElementHandle {



    /**
     * Returns the attribute value of primitive type of the model element. The
     * <code>attributeDescriptor</code> can denote a single- or multi-valued
     * attribute. The return value can be one of the following:
     * <ul>
     * <li>{@link String}, for single-valued attributes</li>
     * <li>a {@link Collection} of strings, if the attribute is multi-valued</li>
     * </ul>
     * 
     * @param attributeDescriptor attribute descriptor
     * @return value of the attribute of type string for single-valued
     * attributes or a collection of strings
     * (java.util.Collection&lt;String&gt;) in the case of a multi-valued
     * attribute
     * @throws NullPointerException if the parameter is <code>null</code>
     * @throws IllegalArgumentException if <tt>modelElement</tt> has not been
     * retrieved by the methods
     * {@link SerializerHelper#getModelElement(ClassDescriptor, String[])},
     * {@link SerializerHelper#getModelElements(ClassDescriptor)}, or
     * {@link SerializerHelper#getLinks(SModelElementHandle, AssociationDescriptor, String)}
     * @throws IllegalArgumentException if the attribute descriptor denotes an
     * attribute which is not defined in the type of the model element
     */
    Object getAttribute( AttributeDescriptor<? extends Attribute, ? extends RefObject, ? extends Object> attributeDescriptor );

    /**
     * Returns the MRI of the model element.
     * 
     * @return MRI, cannot be <code>null</code>
     */
    MRI getMri( );

}
