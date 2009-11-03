package com.sap.tc.moin.repository.xm.serializer;

/**
 * Handler for creating an XML document. The handler directly writes the entered
 * content to an output stream. You can add XML attributes and XML elements
 * (tags) at the current position of the stream. An escaping is executed for the
 * XML characters '&amp;', '&quot;', '&lt;', '&gt;', and '''. And non XML
 * characters are replaced by '#' (see <a
 * href="http://www.w3.org/TR/REC-xml#charsets">Escaping</a>).
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */

public interface XmlOutputHandler {


    /**
     * Adds an attribute.
     * 
     * @param name qualified name of the attribute, for example "ns1:customer";
     * "ns1" is the namespace prefix, this prefix must be registered via the
     * method
     * {@link XmCustomSerializerAbstract#registerPrefixForNamespace(String, String)}
     * .
     * @param value value of the attribute, the toString method is called on the
     * value and and an escaping is executed (see interface description)
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    void addAttribute( String name, Object value );

    /**
     * Adds an element and its value. The start tag, the value, and the end tag
     * are written. For example &lt;ns1:customer&gt;value&lt;/ns1:customer&gt;
     * 
     * @param tagName qualified name of an element, for example "ns1:customer",
     * "ns1" is the namespace prefix; this prefix must be registered via the
     * method
     * {@link XmCustomSerializerAbstract#registerPrefixForNamespace(String, String)}
     * .
     * @param value value of the element; the toString method is called on the
     * value and and an escaping is executed (see interface description)
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    void addElement( String tagName, Object value );


    /**
     * Closes the last open tag. For example if the tag "&lt;ns1:customer&gt;"
     * was written by the method {@link #startTag(String)} and not yet closed,
     * this method will add "&lt;/ns1:customer&gt;".
     * 
     * @throws IllegalStateException if there is not any open tag
     */
    void closeTag( );


    /**
     * Returns the path to the current XML element/attribute. For example:
     * "/customers/customer[3]".
     * 
     * @return path
     */
    String getCurPath( );

    /**
     * Returns the qualified name ("&lt;prefix&gt;:&lt;local name&gt;") of the
     * current open tag, for example "ns1:Customer".
     * 
     * @return qualified name
     * @throws IllegalStateException if there is no open tag
     */
    String getCurTag( );


    /**
     * Returns the index of the current open element.
     * 
     * @return index, starts from 0
     */
    int getLastIndex( );


    /**
     * Adds an element value to the current open element. If the element does
     * already have a value, the new value is concatenated to the old one. The
     * toString method is called on the value and an escaping is executed (see
     * description of this interface).
     * 
     * @param value element value
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    void putValue( Object value );


    /**
     * Adds a starting tag to the output stream.
     * 
     * @param tagName qualified name of an element, for example "ns1:customer",
     * "ns1" is the namespace prefix; this prefix must be registered via the
     * method
     * {@link XmCustomSerializerAbstract#registerPrefixForNamespace(String, String)}
     * .
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    void startTag( String tagName );


}
