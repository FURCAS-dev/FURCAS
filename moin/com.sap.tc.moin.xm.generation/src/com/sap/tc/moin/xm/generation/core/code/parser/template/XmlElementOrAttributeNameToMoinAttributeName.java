package com.sap.tc.moin.xm.generation.core.code.parser.template;

/** Maps the XML element/attribute local name to a MOIN attribute name. */
public interface XmlElementOrAttributeNameToMoinAttributeName {

    /**
     * Returns the local XML element/attribute name.
     * 
     * @return local name, cannot be <code>null</code>
     */
    String getLocalXmlElementOrAttributeName( );

    /**
     * Returns the MOIN attribute name in upper case.
     * <p>
     * If the attribute name is camalized, then the separator charactere '_' is
     * introduced between the lower and upper character.
     * 
     * @return attribute name in upper case, cannot be <code>null</code>
     */
    String getUpperCaseMoinAttributeName( );


    /**
     * Returns the dot separated qualified java class name to which the
     * attribute belongs.
     * 
     * @return qualified name, cannot be <code>null</code>
     */
    String getQualifiedJavaClassName( );

    /**
     * Indicator whether the object is used for the generation of
     * "addSimpleRootElement" or "addSimpleElementOrAttribute".
     */
    boolean isForRootElement( );
}
