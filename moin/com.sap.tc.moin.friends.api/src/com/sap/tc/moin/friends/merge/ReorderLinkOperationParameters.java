package com.sap.tc.moin.friends.merge;

import java.util.List;

/**
 * The {@link OperationParameters} for a {@link LinkOperation}
 */
public interface ReorderLinkOperationParameters extends LinkOperationParameters {

    /**
     * @return the MOF IDs in old order
     */
    public List<String> getOldMofIds( );


    /**
     * @return the MOF IDs in old order
     */
    public List<String> getNewMofIds( );


}
