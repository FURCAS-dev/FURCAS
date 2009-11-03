package com.sap.tc.moin.xm.generation.core.code.serializer.template;

/**
 * Represents an association.
 */
public interface Association extends ChildElement {


    /**
     * Returns the qualified name of the java class which represents the MOIN
     * association.
     * 
     * @return qualified class name (separator is dot)
     */
    String getQualifiedAssociationClassName( );

    /**
     * Returns the name of the association end which belongs to the linked model
     * element.
     * 
     * @return association end name
     */
    String getEndName( );

    /**
     * Returns the name of the method which should be called when a linked model
     * element has been determined via the association.
     * 
     * @return method name.
     */
    String getMethodName( );

    /**
     * Returns the qualified name of the element to which the association
     * correspond or <code>null</code> if the association is an association for
     * a substitution group
     * 
     * @return QName or <code>null</code>
     */
    QualifiedName getElementQName( );

}
