package com.sap.tc.moin.friends.merge;

import java.util.List;

/**
 * Parameters for Attribute reordering
 */
public interface ReorderAttributeValueOperationParameters extends AttributeOperationParameters {

    /**
     * @return the values in old order; if the attribute is object-typed, then
     * this contains MofIDs
     */
    public List<Object> getOldValues( );

    /**
     * @return the values in new order; if the attribute is object-typed, then
     * this contains MofIDs
     */
    public List<Object> getNewValues( );

}
