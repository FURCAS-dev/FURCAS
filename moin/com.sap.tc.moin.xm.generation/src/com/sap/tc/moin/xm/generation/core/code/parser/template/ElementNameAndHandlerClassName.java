package com.sap.tc.moin.xm.generation.core.code.parser.template;

/**
 * Wrapper for the local element name and the class name of the corresponding
 * handler.
 */
public interface ElementNameAndHandlerClassName {

    /**
     * @return local name of a root XML element, cannot be <code>null</code>
     */
    public String getElementLocalName( );

    /**
     * @return class name of a inner handler class, for example "Ts$EStructure$,
     * cannot be <code>null</code>
     */
    public String getHandlerClassName( );
}
