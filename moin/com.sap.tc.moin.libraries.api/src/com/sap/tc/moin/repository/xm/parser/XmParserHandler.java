package com.sap.tc.moin.repository.xm.parser;

import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.xm.XmException;



/**
 * Handler for the XM Parser. The methods of this class are called during
 * parsing an XML document which is mapped to a MOIN model. You can use
 * instances implementing this interface in {@link XmParserConfiguration}.
 * <p>
 * The events this handler handles are similar to SAX events.
 * <p>
 * The abstract class{@link XmParserHandlerAbstract} implements the methods of
 * this interface.
 * <p>
 * An instance implementing this handler interface can hold state during the
 * parsing of a single XML document. <strong>However, when the parsing of the
 * single XML document is finished, then the instance should have the same state
 * as at the beginning of the parsing.</strong> All caches accumulated during
 * the parsing can be cleared in the method {@link #endDocument()}.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface XmParserHandler {

    /**
     * This method is called before a XML document is parsed.
     * 
     * @param helper parser helper instance
     * @throws XmException for error handling
     * @see #endDocument()
     */
    void startDocument( ParserHelper helper ) throws XmException;

    /**
     * Method is called if the parser reaches the start tag of an XML element.
     * 
     * @param localName local name of the XML element
     * @param namespace namespace of the XML element or the empty string if the
     * element has no namespace URI
     * @param value value of the XML element, if the XML element has child XML
     * elements, then this value is the empty string (mixed content is not
     * supported); cannot be <code>null</code>
     * @param attributes XML attributes of the XML element, if the XML element
     * does not contain attributes then an empty list is passed; attention: the
     * list will be reused for the next call, therefore you must not hold a
     * reference to the list
     * @throws XmException if an error occurs; if you throw such an exception
     * all MOIN model changes done by the XM Parser are reverted
     */
    void elementStarted( String localName, String namespace, String value, List<XmlAttribute> attributes ) throws XmException;


    /**
     * Method is called, if the parser reaches the end tag of an element.
     * 
     * @throws XmException if an error occurs; if you throw such an exception
     * all MOIN model changes done by the XM Parser are reverted
     */
    void elementClosed( ) throws XmException;

    /**
     * This method is called after an XML document has been parsed. It can be
     * used for resetting the state, so that the handler can be reused for the
     * next XML document.
     * <p>
     * The method is called in a finally block, so that it is executed even if a
     * exception is thrown during the parsing.
     * 
     * @throws XmException if an error occurs; if you throw such an exception
     * all MOIN model changes done by the XM Parser are reverted
     * @see #startDocument(ParserHelper)
     */
    void endDocument( ) throws XmException;


    /**
     * Returns an unmodifiable map which maps all the namespaces which occur in
     * the XML documents to unique prefixes.
     * 
     * @return namespace prefix map, contains as keys namespaces and as values
     * the prefixes, cannot be <code>null</code>
     */
    public Map<String, String> getNamespaceToPrefix( );


}
