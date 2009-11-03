package com.sap.tc.moin.xm.generation.core.code.parser.template;


/** Maps the local name and prefix of a child XML element to an association. */
public interface ChildAssociation {

    /**
     * Returns the local name of the child.
     * 
     * @return local name, cannot be <code>null</code>
     */
    String getLocalName( );

    /**
     * Returns the dot separated qualified java class name of the association.
     * 
     * @return qualified name, cannot be <code>null</code>
     */
    String getQualifiedJavaClassName( );

    /**
     * Returns the end name of the child end of the association.
     * 
     * @return end name, cannot be <code>null</code>
     */
    String getReferencedEndName( );

    /**
     * Indicator whether this instance is used for the generation of the method
     * "rootElementClosed" or "childClosed".
     */
    boolean isForRootElementClosed( );

}
