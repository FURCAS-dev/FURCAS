package com.sap.tc.moin.friends.merge;


/**
 * Parameters for Attribute setting
 */
public interface SetAttributeValueOperationParameters extends AttributeOperationParameters {

    /**
     * @return the old attribute value (null if the attribute is to be created)
     */
    public Object getOldAttributeValue( );

    /**
     * @return the new attribute value
     */
    public Object getNewAttributeValue( );


}
