package com.sap.tc.moin.friends.merge;

import com.sap.tc.moin.repository.mmi.model.Attribute;


/**
 * Attribute Operation
 */
public interface AttributeOperation extends Operation {

    /**
     * @return the attribute
     */
    public Attribute getAttribute( );

}
