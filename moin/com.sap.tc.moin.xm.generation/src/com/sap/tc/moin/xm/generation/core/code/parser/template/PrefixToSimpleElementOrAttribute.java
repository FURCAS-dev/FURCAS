package com.sap.tc.moin.xm.generation.core.code.parser.template;

import java.util.List;

/**
 * Maps the prefix to the the simple elements or attributes and their
 * corresponding MOIN attribute names.
 */
public interface PrefixToSimpleElementOrAttribute {


    /**
     * Returns a prefix for which root elements with an handler exist.
     * 
     * @return prefix, cannot be <code>null</code>
     */
    String getPrefix( );

    /**
     * Returns the root element local names and handler class list of this
     * prefix.
     * 
     * @return list, cannot be <code>null</code>
     */
    List<XmlElementOrAttributeNameToMoinAttributeName> getMoinAttributes( );

}
