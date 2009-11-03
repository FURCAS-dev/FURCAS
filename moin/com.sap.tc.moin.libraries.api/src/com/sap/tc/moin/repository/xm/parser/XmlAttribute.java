package com.sap.tc.moin.repository.xm.parser;

/**
 * Represents an XML attribute which has been parsed by the SAX parser.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface XmlAttribute {



    /**
     * Returns the local name of the attribute.
     * 
     * @return local name, cannot be <code>null</code>
     */
    String getLocalName( );

    /**
     * Returns the namespace of the attribute.
     * 
     * @return namespace, cannot be <code>null</code>, the no-namespace is
     * represented by an empty string
     */
    String getNamespace( );

    /**
     * Returns the attribute value.
     * <p>
     * If the attribute value is a list of tokens (IDREFS, ENTITIES, or
     * NMTOKENS), the tokens will be concatenated into a single string with each
     * token separated by a single space.
     * </p>
     * 
     * @return value, cannot be <code>null</code>
     */
    String getValue( );

}
