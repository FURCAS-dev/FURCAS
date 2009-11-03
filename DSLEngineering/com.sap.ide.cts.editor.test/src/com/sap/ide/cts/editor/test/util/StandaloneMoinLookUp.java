/**
 * 
 */
package com.sap.ide.cts.editor.test.util;

import java.util.Collection;

import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.mi.textual.moinlookup.MoinMetaLookup;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;

/**
 *
 */
public class StandaloneMoinLookUp extends MoinMetaLookup {

    /**
     * @param connection
     * @param priList
     */
    public StandaloneMoinLookUp(Connection connection, Collection<PRI> priList) {
        super(connection, priList);
    }
    
    /**
     * @return
     */
    protected Moin getMoin() {
        Moin moin = MOINTCSMetaConnectionProvider.getBuildMoin();
        return moin;
    }

}
