package com.sap.tc.moin.friends.merge;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;


/**
 * The {@link OperationParameters} for a {@link LinkOperation}
 */
public interface LinkOperationParameters extends OperationParameters {

    /**
     * @return the association end involved
     */
    public AssociationEnd getLinkOwner( );

    /**
     * @return the MOF ID of the exposed element
     */
    public String getExposedElementId( );

}
