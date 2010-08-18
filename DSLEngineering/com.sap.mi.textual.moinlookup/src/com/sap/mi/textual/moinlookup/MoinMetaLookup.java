package com.sap.mi.textual.moinlookup;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;




/**
 * looks up metamodel information using a set of PRIs
 * 
 * @author C5107456
 */
public class MoinMetaLookup extends AbstractQueryBasedMoinMetaLookUp {
    
    private HashSet<URI> newPRIs;

    /**
     * test workaround constructor to specify own PRIs for the standalone case, where no MetaModelManager is available.
     * @param connection
     * @param containerName
     * @param priList 
     * @throws IOException 
     */
    public MoinMetaLookup(ResourceSet connection, Collection<URI> priList) {
        super(connection);
        if (priList != null) {
            newPRIs = new HashSet<URI>(priList);
        } else {
            newPRIs = new HashSet<URI>();
        }
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.moinlookup.AbstractQueryBasedMoinMetaLookUp#initQueryPRIs()
     */
    @Override
    protected Set<URI> initQueryPRIs() {
        return newPRIs;
    }


}
