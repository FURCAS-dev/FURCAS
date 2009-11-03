package com.sap.tc.moin.xm.generation.core.code.serializer.template;

/**
 * Represents a qualified name of an XML element or attribute. It consits of the
 * prefix and the local name. For example: "ns1:customer".
 */
public interface QualifiedName {

    /**
     * Returns the local name.
     * 
     * @return local name, for example "customer", cannot be <code>null</code>
     */
    String getLocalPart( );

    /**
     * Returns the local name whose non-java identifier character are replaced
     * '_'.
     * 
     * @return local name, for example "customer", cannot be <code>null</code>
     */
    String getJavaLocalPart( );


    /**
     * Returns the namespace.
     * 
     * @return namespace, cannot be <code>null</code>
     */
    String getNamespace( );

    /**
     * Returns the prefix.
     * 
     * @return prefix, cannot be <code>null</code>
     */
    String getPrefix( );

    /**
     * Returns the qualified name which is a concatenation of the prefix, ':'
     * and the local name. If the prefix is empty then ':' is not present.
     * 
     * @return qualified name, for example: "ns1:customer", cannot be
     * <code>null</code>
     */
    String getQName( );

}
