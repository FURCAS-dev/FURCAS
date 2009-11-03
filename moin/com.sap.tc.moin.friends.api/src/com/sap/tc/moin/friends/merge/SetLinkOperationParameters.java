package com.sap.tc.moin.friends.merge;



/**
 * The {@link OperationParameters} for a {@link LinkOperation}
 */
public interface SetLinkOperationParameters extends LinkOperationParameters {

    /**
     * @return the MOF ID of the referenced element
     */
    public String getReferencedElementId( );

}
