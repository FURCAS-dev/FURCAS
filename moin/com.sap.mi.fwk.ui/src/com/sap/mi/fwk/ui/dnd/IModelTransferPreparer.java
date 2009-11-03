package com.sap.mi.fwk.ui.dnd;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Protocol to notify that a deep copy operations will take place / has just
 * taken place.
 * 
 * E.g. Can be used to disable and re-enable certain environment specific event
 * listeners which might invalidate the copy due to link creations during the
 * copy
 * 
 * @author D049157
 * 
 */
public interface IModelTransferPreparer {

    /**
     * Announce that the given srcObjects will be copyied via a deepCopy on the
     * targetConnection.
     * 
     * @param targetConnection
     * @param srcObjects
     */
    public void handlePreCopy(Connection targetConnection, RefObject[] srcObjects);

    /**
     * Announce that the srcObjects have just been copied by a deepCopy on the
     * given targetConnection. The result given copyResult set must not be modified
     * in terms of repartitioning of elements (MRI must stay valid). 
     * 
     * @param targetConnection
     * @param srcObjects
     * @param copyResult
     */
    public void handlePostCopy(Connection targetConnection, RefObject[] srcObjects, DeepCopyResultSet copyResult);
}
