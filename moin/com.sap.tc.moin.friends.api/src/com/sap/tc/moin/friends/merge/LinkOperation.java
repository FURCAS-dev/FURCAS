package com.sap.tc.moin.friends.merge;

import com.sap.tc.moin.repository.mmi.model.Association;


/**
 * Link Operation
 */
public interface LinkOperation extends Operation {

    /**
     * @return the association
     */
    public Association getAssociation( );
}
