package com.sap.tc.moin.repository.xmi;

import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * Instances of this interface represent elements found in an XMI document.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface XmiElement {

    /**
     * Returns the value of the element's <code>xmi.id</code> attribute (or, in
     * XMI 2.0 and above, <code>xmi:id</code>).
     * 
     * @return the element's XMI id
     */
    public String getXmiId( );

    /**
     * Returns the URI of the XMI document containing the XmiElement.
     * 
     * @return the URI of the XMI document containing the XmiElement
     */
    public String getUri( );

    /**
     * Returns the enclosing {@link XmiElement}, or <code>null</code> if no such
     * element exists.
     * 
     * @return the enclosing XmiElement, or <code>null</code>
     */
    public XmiElement getParentElement( );

    /**
     * Returns the map of all attribute values, keyed by the attribute names.
     * 
     * @return the map of all attribute values, keyed by the attribute names
     */
    public Map<String /* attributeName */, Object /* attributeValue */> getAttributeValuesByName( );

    /**
     * Returns the type of the model element represented by this
     * {@link XmiElement}.
     * 
     * @return the type of the model element represented by this XmiElement
     */
    public MofClass getType( );
}