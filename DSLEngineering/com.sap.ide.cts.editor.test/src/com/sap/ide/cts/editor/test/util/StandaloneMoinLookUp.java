/**
 * 
 */
package com.sap.ide.cts.editor.test.util;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;


/**
 *
 */
public class StandaloneMoinLookUp extends MoinMetaLookup {

    /**
     * @param connection
     * @param priList
     */
    public StandaloneMoinLookUp(ResourceSet connection, Collection<URI> priList) {
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
