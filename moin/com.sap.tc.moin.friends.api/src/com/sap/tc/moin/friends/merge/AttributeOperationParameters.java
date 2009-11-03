package com.sap.tc.moin.friends.merge;

/**
 * Parameters for Attribute operations
 */
public interface AttributeOperationParameters extends OperationParameters {

    /**
     * @return the MOF ID of the owner of the attribute
     */
    public String getOwnerId( );

}
