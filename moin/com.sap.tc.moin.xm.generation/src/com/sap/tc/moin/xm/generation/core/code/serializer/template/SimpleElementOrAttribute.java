package com.sap.tc.moin.xm.generation.core.code.serializer.template;


/**
 * Represents an XML element with a simple type or an XML attribute. From this
 * information the "addElement" or "addAttribute" method is generated.
 */
public interface SimpleElementOrAttribute extends ChildElement {

    /**
     * Returns the qualified XML element/attribute name.
     * 
     * @return qualified XML element/attribute name
     */
    QualifiedName getQName( );

    /**
     * Returns the dot separated qualified class name of the MOIN model element
     * from which the attribute value is read.
     * 
     * @return qualified class name
     */
    String getQualifiedModelElementClassName( );

    /**
     * Returns the attribute name in upper case of the MOIN model element, from
     * which the attribute value is read.
     * <p>
     * If the attribute name is camalized, then the separator charactere '_' is
     * introduced between the lower and upper character.
     * 
     * @return attribute name in upper case
     */
    String getUpperCaseAttributeName( );


}
