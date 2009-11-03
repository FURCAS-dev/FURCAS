package com.sap.tc.moin.repository.admin;

import com.sap.tc.moin.repository.Moin;

/**
 * Implements the MOIN lifecycle - start of MOIN.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d029324
 */

public interface RuntimeHost {

    /**
     * Returns the valid MOIN instance. If the MOIN is not running, the Runtime
     * Host starts the MOIN.
     * 
     * @return running MOIN instance.
     */
    public Moin getMoinInstance( );

}
