package com.sap.tc.moin.xm.generation.core.code.parser.template;

import java.util.List;


/** Wrapper for a prefix and its root elements. */
public interface PrefixToElementHandlers {


    /**
     * Returns a prefix for which root elements with an handler exist.
     * 
     * @return prefix, cannot be <code>null</code>
     */
    public String getPrefix( );

    /**
     * Returns the local names of the XML elements and their handler classes.
     * 
     * @return list, cannot be <code>null</code>
     */
    public List<ElementNameAndHandlerClassName> getElements( );

}
