/**
 * 
 */
package com.sap.ide.cts.editor.test.util;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.parsergenerator.emf.EcoreMetaLookup;



/**
 *
 */
public class StandaloneMoinLookUp extends EcoreMetaLookup {

    /**
     * @param connection
     * @param priList
     */
    public StandaloneMoinLookUp(ResourceSet connection, Collection<URI> priList) {
        super(connection, priList);
    }
    

}
