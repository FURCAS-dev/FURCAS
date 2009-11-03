package com.sap.tc.moin.xm.generation.core.code.serializer.template;


/**
 * Represents a child XML element of an XML element with complex types. See
 * extending interfaces.
 */
public interface ChildElement {

    /**
     * Returns <code>true</code> if the element is of simple type, otherwise
     * <code>false</code>.
     * 
     * @return <code>true</code> if the element is of simple type, otherwise
     * <code>false</code>.
     */
    boolean isSimpleElement( );

}
