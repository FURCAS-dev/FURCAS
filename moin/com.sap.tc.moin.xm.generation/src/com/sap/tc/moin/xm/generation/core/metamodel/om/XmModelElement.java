package com.sap.tc.moin.xm.generation.core.metamodel.om;

import com.sap.tc.moin.repository.mmi.model.ModelElement;


public interface XmModelElement {

    /**
     * Returns the XSD name.
     * 
     * @return XSD name, is <code>null</code> for MOIN associations.
     */
    String getXSDName( );

    void setMofName( String mofName );

    String getMofName( );

    /** Create a meta-model element. */
    ModelElement createModelElement( );

    /**
     * Returns the kind of the XSD component. For example simple type, complex
     * type, element, attribute, ...
     */
    XmXsdComponentKind getXsdComponentKind( );

}
