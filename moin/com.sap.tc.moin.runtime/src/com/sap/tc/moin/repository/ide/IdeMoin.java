/**
 * 
 */
package com.sap.tc.moin.repository.ide;

import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;


/**
 * Moin instance for the eclipse runtime scenario.
 * <p>
 * In addition to the runtime-independent base interface {@link Moin}, this
 * interface exposes the scenario-specific sub-interface of the
 * {@link CompoundDataAreaManager}, so that the MOIN access is straightforward.
 * <p>
 * This interface is <b>not</b> intended to be implemented by clients.
 * 
 * @see MoinFactory
 * @author d032434
 */
public interface IdeMoin extends Moin {

    /**
     * Returns the {@link IdeCompoundDataAreaManager} for the eclipse runtime
     * scenario.
     * 
     * @return the {@link IdeCompoundDataAreaManager}
     */
    public IdeCompoundDataAreaManager getCompoundDataAreaManager( );
}
